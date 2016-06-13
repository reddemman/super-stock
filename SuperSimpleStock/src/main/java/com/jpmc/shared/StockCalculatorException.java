package com.jpmc.shared;

public class StockCalculatorException extends Exception {

	    static final long serialVersionUID = 123123123;

	    /**
	     * Default constructor.
	     */
	    public StockCalculatorException() {}

	  	 /**
	  	  * Constructor with error message.
	  	  * @param message the error message
	  	  */
	    public StockCalculatorException(String message) {
	        super(message);
	    }
	    

}
