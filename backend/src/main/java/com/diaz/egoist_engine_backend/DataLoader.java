package com.diaz.egoist_engine_backend;

import com.diaz.egoist_engine_backend.Model.Arc;
import com.diaz.egoist_engine_backend.Model.Player;
import com.diaz.egoist_engine_backend.Model.PlayerStat;
import com.diaz.egoist_engine_backend.Model.Team;
import com.diaz.egoist_engine_backend.Repository.ArcRepository;
import com.diaz.egoist_engine_backend.Repository.PlayerRepository;
import com.diaz.egoist_engine_backend.Repository.PlayerStatRepository;
import com.diaz.egoist_engine_backend.Repository.TeamRepository;
import com.opencsv.CSVReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Component;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class DataLoader {

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private PlayerStatRepository playerStatsRepository;

    @Autowired
    private ArcRepository arcRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Bean
    CommandLineRunner loadData() {
        return args -> {
            loadPlayers();
            loadPlayerStats();
        };
    }

    private void loadPlayers() throws Exception {
        List<Player> players = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("players.csv").getFile()))) {
            String[] line;
            reader.readNext();  // Skip header
            while ((line = reader.readNext()) != null) {
                Player player = new Player();
                player.setPlayerId((int) Long.parseLong(line[0]));
                player.setFullName(line[1]);
                player.setAge(line[2].isEmpty() ? null : Integer.parseInt(line[2]));
                player.setHeight(line[3].isEmpty() ? null : String.valueOf(Integer.parseInt(line[3])));
                player.setNationality(line[4]);
                player.setImage(null);  // Set image to null as it's not used
                players.add(player);
            }
            playerRepository.saveAll(players);
        }
    }

    private void loadPlayerStats() throws Exception {
        List<PlayerStat> playerStatsList = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(new ClassPathResource("player_stats.csv").getFile()))) {
            String[] line;
            reader.readNext();  // Skip header
            while ((line = reader.readNext()) != null) {
                PlayerStat playerStats = new PlayerStat();
                playerStats.setPlayerStatId((int) Long.parseLong(line[0]));

                // Retrieve related entities, handling potential absence with Optional
                Optional<Player> playerOpt = Optional.ofNullable(playerRepository.findByPlayerId(Integer.parseInt(line[1])));
                Optional<Arc> arcOpt = Optional.ofNullable(arcRepository.findByArcId(Integer.parseInt(line[2])));
                Optional<Team> teamOpt = Optional.ofNullable(teamRepository.findByTeamId(Integer.parseInt(line[3])));

                if (playerOpt.isPresent() && arcOpt.isPresent() && teamOpt.isPresent()) {
                    playerStats.setPlayer(playerOpt.get());
                    playerStats.setArc(arcOpt.get());
                    playerStats.setTeam(teamOpt.get());
                } else {
                    System.out.println("Related entity not found, skipping this record.");
                    continue; // Skip this record if any related entity is not found
                }

                playerStats.setJerseyNumber(line[4]);
                playerStats.setWeapon(line[5]);
                playerStats.setPosition(line[6]);
                playerStatsList.add(playerStats);
            }
            playerStatsRepository.saveAll(playerStatsList);
        }
    }
}
