package com.transfer.revolut.exception;

import com.transfer.revolut.response.TransferExceptionResponse;

import javax.ws.rs.NotFoundException;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
/**
 * Jefferson Rodrigues
 */
@Provider
public class NotFoundAccountException implements ExceptionMapper<NotFoundException> {

    @Override
    public Response toResponse(NotFoundException exception) {
        return Response.status(Response.Status.NOT_FOUND).entity(new TransferExceptionResponse(exception.getMessage())).build();
    }
}
