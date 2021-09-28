package com.springboot.exception;

public class ResourceNotFoundException extends RuntimeException{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
private String resource;
private String fieldName;
private Object fieldValue;
public ResourceNotFoundException(String resource, String fieldName, Object fieldValue) {
	super(String.format("%s is not Found with %s : '%s'",resource, fieldName, fieldValue));
	this.resource = resource;
	this.fieldName = fieldName;
	this.fieldValue = fieldValue;
}
public ResourceNotFoundException()
{
	
}
public String getResource() {
	return resource;
}
public void setResource(String resource) {
	this.resource = resource;
}
public String getFieldName() {
	return fieldName;
}
public void setFieldName(String fieldName) {
	this.fieldName = fieldName;
}
public Object getFieldValue() {
	return fieldValue;
}
public void setFieldValue(Object fieldValue) {
	this.fieldValue = fieldValue;
}

}
