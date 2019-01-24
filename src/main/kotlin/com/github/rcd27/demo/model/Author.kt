package com.github.rcd27.demo.model

import javax.persistence.*

// FIXME: using data classes can be complicated for Hibernate.
// see: https://stackoverflow.com/questions/35847763/kotlin-data-class-bean-validation-jsr-303
@Entity
data class Author(
        @Id
        @GeneratedValue(strategy = GenerationType.AUTO)
        val id: Long? = null) {

    lateinit var firstName: String
    lateinit var lastName: String

    constructor(firstName: String, lastName: String) : this() {
        this.firstName = firstName
        this.lastName = lastName
    }

    @ManyToMany(mappedBy = "authors")
    val books: MutableSet<Book> = mutableSetOf()
}
