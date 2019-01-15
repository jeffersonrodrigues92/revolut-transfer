package com.transfer.revolut.controller;

import com.transfer.revolut.dto.TransferDTO;
import com.transfer.revolut.service.TransferService;

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
	 public Response transfer(@Valid TransferDTO transfer) {

	 	 return Response.status(200).build();
	 }


}
 