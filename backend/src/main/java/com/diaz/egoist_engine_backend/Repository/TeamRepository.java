package com.diaz.egoist_engine_backend.Repository;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TeamRepository extends JpaRepository<Team, Integer> {
    List<Team> findAllByArc(Arc arc);
}
