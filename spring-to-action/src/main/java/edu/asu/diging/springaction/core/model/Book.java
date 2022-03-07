package edu.asu.diging.springaction.core.model;

import edu.asu.diging.simpleusers.core.model.IUser;

public interface Book {
	
	   

	public String getTitle();
	
    public void setTitle(String title);

	public String getAuthor();

	public void setAuthor(String author);

	public boolean isAvailable();

	public void setAvailable(boolean available);

	public void setBorrower(IUser user);
	   
	}
