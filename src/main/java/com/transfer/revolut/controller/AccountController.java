package com.transfer.revolut.controller;


import java.util.Objects;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import com.transfer.revolut.entity.Account;
import com.transfer.revolut.service.AccountService;
/**
 * Jefferson Rodrigues
 */
@Path("/account")
public class AccountController {

    @Inject
    private AccountService accountService;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{iban}")
    public Response findByIban(@PathParam("iban") String iban) {

        Account account = accountService.findByIban(iban);

        if(Objects.isNull(account)){
            Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.status(Response.Status.OK).entity(account).build();
    }
}
