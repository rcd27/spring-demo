package com.github.rcd27.demo.repositories

import com.github.rcd27.demo.model.Book
import org.springframework.data.repository.CrudRepository

interface BookRepository : CrudRepository<Book, Long>