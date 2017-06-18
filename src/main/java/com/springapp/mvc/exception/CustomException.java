package com.springapp.mvc.exception;

/**
 * Created with IntelliJ IDEA.
 * User: vincent
 * Date: 14-1-26
 * Time: 下午5:17
 * To change this template use File | Settings | File Templates.
 */
public class CustomException extends Exception {

    private static final long serialVersionUID = -1028440176111609780L;

    public CustomException() {
    }
    public CustomException(String message) {
        super(message);
    }
}
