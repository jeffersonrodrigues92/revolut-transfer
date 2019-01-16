package com.transfer.revolut.response;

/**
 * Jefferson Rodrigues
 */
public class TransferExceptionResponse {

    private String message;

    public TransferExceptionResponse(String message){
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
