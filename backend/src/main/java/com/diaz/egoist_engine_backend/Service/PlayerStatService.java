package com.diaz.egoist_engine_backend.Service;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Model.PlayerStat;
import com.diaz.egoist_engine_backend.Model.Team;
import com.diaz.egoist_engine_backend.Repository.PlayerStatRepository;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class PlayerStatService {
    private final PlayerStatRepository playerStatRepository;

    public PlayerStatService(PlayerStatRepository playerStatRepository) {
        this.playerStatRepository = playerStatRepository;
    }

    private final Comparator<PlayerStat> jerseyNumberComparator = (ps1, ps2) -> {
        String jersey1 = ps1.getJerseyNumber();
        String jersey2 = ps2.getJerseyNumber();

        if (isNumeric(jersey1) && isNumeric(jersey2)) {
            return Integer.compare(Integer.parseInt(jersey1), Integer.parseInt(jersey2));
        } else if (isNumeric(jersey1)) {
            return -1;
        } else if (isNumeric(jersey2)) {
            return 1;
        } else {
            return jersey1.compareTo(jersey2);
        }
    };

    private boolean isNumeric(String str) {
        if (str == null) {
            return false;
        }
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public List<PlayerStat> getPlayerStatsByTeam(Team team) {
        return playerStatRepository.findAllByTeam(team)
                .stream()
                .sorted(jerseyNumberComparator)
                .collect(Collectors.toList());
    }

    public List<PlayerStat> getPlayerStatsByArcAndTeam(Arc arc, Team team) {
        return playerStatRepository.findAllByArcAndTeam(arc, team);
    }

    public Map<Team, List<PlayerStat>> getAllPlayerStatsGroupedByTeam() {
        List<PlayerStat> playerStats = playerStatRepository.findAll();
        return playerStats.stream()
                .collect(Collectors.groupingBy(PlayerStat::getTeam));
    }

}
