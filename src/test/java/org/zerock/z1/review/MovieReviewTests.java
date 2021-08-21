package org.zerock.z1.review;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.zerock.z1.movie.entity.Movie;
import org.zerock.z1.review.entity.MovieReview;
import org.zerock.z1.review.repository.MovieReviewRepository;

import java.util.stream.IntStream;

@SpringBootTest
@Log4j2
public class MovieReviewTests {

    @Autowired
    private MovieReviewRepository movieReviewRepository;

    @Test
    public void testPaging() {

        Pageable pageable = PageRequest.of(0, 10);

        Page<MovieReview> result = movieReviewRepository.findAll(pageable);

        log.info("--------------------------------");
        log.info(result);

        result.forEach(movieReview -> log.info(movieReview));
    } // testPaging() 끝

    @Test
    public void testInsertDummies() {

        IntStream.rangeClosed(1,500).forEach(i -> {

            Long mno = (long)(Math.random()* 66) + 1;

            Movie movie = Movie.builder().mno(mno).build();

            String reviewer = "reviewer"+(int)(Math.random()*100);

            int score = (int)(Math.random()* 5) + 1;

            String reviewText = score > 3? "재밌어요":"그냥 그래요";

            MovieReview review = MovieReview.builder()
                    .movie(movie)
                    .reviewer(reviewer)
                    .score(score)
                    .title(mno +"영화는요..")
                    .reviewText("제 점수는" +score+" 입니다." +  reviewText)
                    .build();

            movieReviewRepository.save(review);

        });

    }
}
