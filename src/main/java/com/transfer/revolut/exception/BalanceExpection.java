package com.transfer.revolut.exception;

import com.transfer.revolut.response.TransferExceptionResponse;

import javax.ws.rs.ForbiddenException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * Jefferson Rodrigues
 */
@Provider
public class BalanceExpection implements ExceptionMapper<ForbiddenException> {
    @Override
    public Response toResponse(ForbiddenException exception) {
        return Response.status(Response.Status.FORBIDDEN).entity(new TransferExceptionResponse(exception.getMessage())).build();
    }
}
