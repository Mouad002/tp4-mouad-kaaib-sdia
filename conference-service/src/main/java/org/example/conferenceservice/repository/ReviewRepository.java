package org.example.conferenceservice.repository;

import org.example.conferenceservice.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface ReviewRepository extends JpaRepository<Review, String> {
}
