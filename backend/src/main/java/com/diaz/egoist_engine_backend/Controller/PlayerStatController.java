package com.diaz.egoist_engine_backend.Controller;

import com.diaz.egoist_engine_backend.Model.PlayerStat;
import com.diaz.egoist_engine_backend.Model.Team;
import com.diaz.egoist_engine_backend.Service.ArcService;
import com.diaz.egoist_engine_backend.Service.PlayerStatService;

import com.diaz.egoist_engine_backend.Service.TeamService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/playerstats")
public class PlayerStatController {

    private final PlayerStatService playerStatService;
    private final TeamService teamService;
    private final ArcService arcService;

    public PlayerStatController(PlayerStatService playerStatService, TeamService teamService, ArcService arcService) {
        this.playerStatService = playerStatService;
        this.teamService = teamService;
        this.arcService = arcService;
    }

    @GetMapping("/byTeam")
    public ResponseEntity<List<PlayerStat>> getPlayerStatsByTeam(@RequestParam Integer teamId) {
        Optional<Team> teamOptional = teamService.getTeamById(teamId);
        if (teamOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        Team team = teamOptional.get();
        List<PlayerStat> playerStats = playerStatService.getPlayerStatsByTeam(team);
        return ResponseEntity.ok(playerStats);
    }



}
