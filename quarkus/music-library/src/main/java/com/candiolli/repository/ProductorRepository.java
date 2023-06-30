package com.candiolli.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.candiolli.model.Productor;

@RepositoryRestResource(collectionResourceRel = "album-productor", path = "album-productor")
public interface ProductorRepository extends PagingAndSortingRepository<Productor, Long> {
}
