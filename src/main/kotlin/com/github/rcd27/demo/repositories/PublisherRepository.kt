package com.github.rcd27.demo.repositories

import com.github.rcd27.demo.model.Publisher
import org.springframework.data.repository.CrudRepository

interface PublisherRepository : CrudRepository<Publisher, Long>