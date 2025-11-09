package org.example.conferenceservice.feignclient;

import org.example.conferenceservice.entity.Keynote;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "keynote-service")
public interface KeynoteRestClient {
    @GetMapping("/api/keynotes/{keynoteId}")
    Keynote findKeynoteById(@PathVariable String  keynoteId);

    @GetMapping("/api/keynotes")
    PagedModel<Keynote> findAllKeynotes();
}
