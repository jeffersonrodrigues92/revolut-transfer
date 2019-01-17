package com.transfer.revolut.controller;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.transfer.revolut.response.TransactionResponse;
import com.transfer.revolut.entity.Transfer;
import com.transfer.revolut.service.TransferService;

import java.util.List;
import java.util.Objects;

/**
 * Jefferson Rodrigues
 */
@Path("/transfer")
public class TransferController {

	@Inject
	private TransferService transferService;

	 @POST
	 @Produces(MediaType.APPLICATION_JSON)
	 public Response transfer(@Valid Transfer transfer) {
	     String transactionId = transferService.transfer(transfer);
         TransactionResponse response = new TransactionResponse();
         response.setTransactionId(transactionId);
	 	 return Response.status(Response.Status.OK).entity(response).build();
	 }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{transactionId}")
    public Response findByTransactionId(@PathParam("transactionId") String transactionId) {
        Transfer transfer = transferService.findByTransactionId(transactionId);
        if(Objects.isNull(transfer)){
            throw new NotFoundException("TransactionId could not be found: "+ transactionId);
        }
        return Response.status(Response.Status.OK).entity(transfer).build();
    }
}
 