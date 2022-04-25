package com.nagarro.advancedjava.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.nagarro.advancedjava.model.BookDetails;

public interface BookDetailsRepo extends JpaRepository<BookDetails, Integer> {

}
