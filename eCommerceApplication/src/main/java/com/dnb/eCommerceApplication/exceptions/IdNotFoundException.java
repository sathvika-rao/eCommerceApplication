package com.dnb.eCommerceApplication.exceptions;

//creating a custom exception that will be called when a product does not exist in the database with the given id
public class IdNotFoundException extends Exception {

	public IdNotFoundException(String msg) {
		super(msg);
	}
		
		public String toString() {
			return super.toString()+super.getMessage();
		}
		
	
}
