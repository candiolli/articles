package com.candiolli.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Component;

import com.candiolli.model.Music;

@Component
public interface MusicRepository extends PagingAndSortingRepository<Music, Long> {

    List<Music> findByAlbumId(@Param("id") Long id);

    @RestResource(path = "titleStartsWith", rel = "titleStartsWith")
    List<Music> findByTitleStartsWith(@Param("title") String title);
	
}
