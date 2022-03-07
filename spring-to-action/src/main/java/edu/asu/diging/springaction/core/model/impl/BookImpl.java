package edu.asu.diging.springaction.core.model.impl;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import edu.asu.diging.simpleusers.core.model.IUser;
import edu.asu.diging.simpleusers.core.model.impl.User;
import edu.asu.diging.springaction.core.model.Book;

@Entity
public class BookImpl implements Book{ 

    @Id
    @GeneratedValue
    private Long id;
    
    @ManyToOne(targetEntity = User.class)
    private IUser borrower;
    
    private String title;
    private String author;

    private boolean available;
    
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }
    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }
	public IUser getBorrower() {
		return borrower;
	}
	public void setBorrower(IUser borrower) {
		this.borrower = borrower;
	}
	

     
}