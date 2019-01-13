package com.github.rcd27.demo.controllers

import com.github.rcd27.demo.repositories.AuthorRepository
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class AuthorController(private val authorRepository: AuthorRepository) {

    @RequestMapping("/authors")
    fun getAuthors(model: Model): String {
        model.addAttribute("authors", authorRepository.findAll())

        return "authors"
    }
}