package org.zerock.z1.movie.service;

import org.zerock.z1.movie.dto.MovieDTO;
import org.zerock.z1.movie.entity.Movie;

import java.util.List;

public interface MovieService {

    List<MovieDTO> getAllMovies();


    default MovieDTO entityToDTO(Movie movie){  // Entity를 주면 DTO로 바꿔준다.

        return MovieDTO.builder()
                .mno(movie.getMno())
                .title(movie.getTitle())
                .poster(movie.getPoster())
                .bookRate(movie.getBookRate())
                .build();

    }   // entityToDTO() 끝


} // Class 끝
