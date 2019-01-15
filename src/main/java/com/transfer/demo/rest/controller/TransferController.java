package com.transfer.demo.rest.controller;

import com.transfer.demo.rest.service.TransferService;
import org.h2.value.Transfer;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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

	 	 transferService.transfer(transfer);

	 	 return Response.status(200).build();
	 }


}
 