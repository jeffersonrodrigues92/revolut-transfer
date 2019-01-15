package com.transfer.revolut.controller;


import com.transfer.revolut.dto.AccountDTO;
import com.transfer.revolut.service.AccountService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Objects;

@Path("/account")
public class AccountController {

    @Inject
    private AccountService accountService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{iban}")
    public Response findByIban(@PathParam("iban") String iban) {

        AccountDTO accountDTO = accountService.findByIban(iban);

        if(Objects.isNull(accountDTO)){
            Response.status(404).build();
        }
        return Response.status(200).entity(accountDTO).build();
    }
}
