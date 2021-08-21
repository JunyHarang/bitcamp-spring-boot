package org.zerock.z1.review.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.zerock.z1.review.entity.MovieReview;

public interface MovieReviewRepository extends JpaRepository<MovieReview, Long> {
}
