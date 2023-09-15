package com.dnb.eCommerceApplication.exceptions;

////creating a custom exception that will be called when a product name is given that already exists in the database as product names should be unique
public class NotUniqueNameException extends Exception{
	public NotUniqueNameException(String msg) {
		super(msg);
	}
		
		public String toString() {
			return super.toString()+super.getMessage();
		}
}
