package com.devsuperior.dscommerce_exercise.repositories;

import com.devsuperior.dscommerce_exercise.entities.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
