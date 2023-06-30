package com.candiolli.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import com.candiolli.model.Album;

@Component
public interface AlbumRepository extends PagingAndSortingRepository<Album, Long> {
	
}
