package org.example.keynoteserivce.repository;

import org.example.keynoteserivce.entity.Keynote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface KeynoteRepository extends JpaRepository<Keynote, String> {
}