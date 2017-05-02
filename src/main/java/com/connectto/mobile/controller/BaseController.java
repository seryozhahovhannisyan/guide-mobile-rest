package com.connectto.mobile.controller;


import com.connectto.mobile.common.exception.DataNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 *
 */
public abstract class BaseController {
    private static final Logger LOG = LoggerFactory.getLogger(BaseController.class);

    /**
     * Handles the 404 (not found) error occurred in the System.
     *
     * @param ex
     * @return error details as a JSON response.
     */
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    @ResponseBody
    public ErrorInfo composeNotFoundResponse(DataNotFoundException ex) {
        LOG.debug(ex.getMessage(), ex);
        String msg = ex.getMessage() == null ?
                "Entity with specified parameters was not found in the System." :
                ex.getMessage();
        return new ErrorInfo(HttpStatus.NOT_FOUND.value(), msg);
    }

    /**
     * Handles an internal error occurred in the System.
     *
     * @param ex
     * @return error details as a JSON response.
     */
    @ExceptionHandler
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorInfo composeInternalErrorResponse(RuntimeException ex) {
        LOG.debug(ex.getMessage(), ex);
        String msg = ex.getMessage() == null ?
                "An unexpected error occurred in the System." :
                ex.getMessage();
        return new ErrorInfo(HttpStatus.INTERNAL_SERVER_ERROR.value(), msg);
    }

}
