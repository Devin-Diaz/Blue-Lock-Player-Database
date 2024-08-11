package com.diaz.egoist_engine_backend.Repository;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Model.PlayerStat;
import com.diaz.egoist_engine_backend.Model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerStatRepository extends JpaRepository<PlayerStat, Integer> {
    List<PlayerStat> findAllByTeam(Team team);
    List<PlayerStat> findAllByArcAndTeam(Arc arc, Team team);
}
