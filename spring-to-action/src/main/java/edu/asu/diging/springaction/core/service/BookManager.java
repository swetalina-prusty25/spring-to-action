package edu.asu.diging.springaction.core.service;

import java.util.List;
import java.util.stream.Collectors;

import edu.asu.diging.simpleusers.core.model.IUser;
import edu.asu.diging.springaction.core.model.Book;
import edu.asu.diging.springaction.core.model.impl.BookImpl;

public interface BookManager {
	
	public List<Book> all();
	public Book store(String author, String title);
	public Book get(Long id);

    public void borrow(IUser user, Book book);
    public void Return(Book book);
    public List<Book> findByUser(IUser user);

}
