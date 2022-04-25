package com.nagarro.advancedjava.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.advancedjava.dao.BookDetailsRepo;
import com.nagarro.advancedjava.model.BookDetails;

@RestController
public class BookDetailsController {
	
	@Autowired
	BookDetailsRepo repo;
	
	@GetMapping("/books")
	public List<BookDetails> getbooks(){
		return repo.findAll();
	}
	
	@PostMapping("/books")
	public void saveBooks(@RequestBody BookDetails books) {
		
		repo.save(books);
	}
	
	//Actions
	
	@PostMapping("/edited")
	public void editBook(@RequestBody BookDetails book) {
		int id=book.getCode();
		Optional<BookDetails> bookDetails=repo.findById(id);
		BookDetails updateBook= bookDetails.get();
		updateBook.setName(book.getName());
		updateBook.setAuthor(book.getAuthor());
		repo.save(updateBook);
	}
	
	
	@PostMapping("/delete")
	public void deleteBook(@RequestBody String id) {
		int book_id = Integer.parseInt(id);
		
		repo.deleteById(book_id);
	}

}
