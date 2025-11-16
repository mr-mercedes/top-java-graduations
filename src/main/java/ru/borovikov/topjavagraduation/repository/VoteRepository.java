package ru.borovikov.topjavagraduation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import ru.borovikov.topjavagraduation.model.Vote;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional(readOnly = true)
public interface VoteRepository extends JpaRepository<Vote, Long> {

    Optional<Vote> findByUserIdAndVoteDate(Long userId, LocalDate voteDate);

    @Query("select v.restaurant.id, count(v) from Vote v where v.voteDate = :date group by v.restaurant.id")
    List<Object[]> countByRestaurantForVoteDate(@Param("date") LocalDate date);
}
