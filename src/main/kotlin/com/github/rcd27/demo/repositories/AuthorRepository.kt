package com.github.rcd27.demo.repositories

import com.github.rcd27.demo.model.Author
import org.springframework.data.repository.CrudRepository

interface AuthorRepository : CrudRepository<Author, Long>