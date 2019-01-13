package com.github.rcd27.demo.controllers

import com.github.rcd27.demo.repositories.BookRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class BookController(private val bookRespository: BookRepository) {

    @RequestMapping("/books")
    fun getBooks(model: Model): String {
        model.addAttribute("books", bookRespository.findAll())

        return "books"
    }
}