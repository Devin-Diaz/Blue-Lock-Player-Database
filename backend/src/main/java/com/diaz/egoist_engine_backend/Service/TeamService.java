package com.diaz.egoist_engine_backend.Service;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Model.Team;
import com.diaz.egoist_engine_backend.Repository.ArcRepository;
import com.diaz.egoist_engine_backend.Repository.TeamRepository;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    private final TeamRepository teamRepository;
    private final ArcRepository arcRepository;

    public TeamService(TeamRepository teamRepository, ArcRepository arcRepository) {
        this.teamRepository = teamRepository;
        this.arcRepository = arcRepository;
    }

    public Optional<Team> getTeamById(Integer teamId) {
        return teamRepository.findById(teamId);
    }

    public Optional<Arc> getArcById(Integer arcId) {
        return arcRepository.findById(arcId);
    }

    public List<Team> getAllTeamsByArc(Arc arc) {
        return teamRepository.findAllByArc(arc);
    }
}
