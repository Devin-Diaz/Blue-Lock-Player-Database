import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { useParams } from "react-router-dom";
import api from "../Services/api";
import Header from "./Header";
import DataBox from "./DataBox";
import '../Styles/dataBoxStyle.css';
import teamZ from '../Images/team_z.jpg';
import teamY from '../Images/team_y.webp';
import teamX from '../Images/team_x.webp';
import teamW from '../Images/team_w.webp';
import teamV from '../Images/team_v.webp';
import teamRed from '../Images/team_red.webp';
import teamWhite from '../Images/team_white.webp';
import teamWorldFive from '../Images/team_world_five.webp';
import teamA from '../Images/team_a.webp';
import teamB from '../Images/team_b.avif';
import teamC from '../Images/team_c.jpg';
import blEleven from '../Images/bl_eleven.jpg';
import u20Squad from '../Images/u20_squad.webp';
import bastard from '../Images/bastard.webp';
import pxg from '../Images/pxg.webp';
import barcha from '../Images/barcha.webp';
import manshine from '../Images/manshine.webp';
import ubers from '../Images/ubers.webp';
import '../Styles/titleStyle.css';
import arrow from '../Images/arrow.png';


function TeamList() {
    const [teams, setTeams] = useState([]);
    const [arc, setArc] = useState(null); // State to hold the arc information
    const { arcId } = useParams();

    useEffect(() => {
        const fetchTeamsAndArc = async () => {
            try {
                const teamResponse = await api.get(`teams?arcId=${arcId}`);
                setTeams(teamResponse.data);

                const arcResponse = await api.get(`arcs/${arcId}`);
                setArc(arcResponse.data);
            } catch (error) {
                console.log('error fetching blue lock teams or arc!', error);
            }
        };
        fetchTeamsAndArc();
    }, [arcId]);

    const teamImages = {
        1: teamZ,
        2: teamY,
        3: teamX,
        4: teamW,
        5: teamV,
        6: teamWhite,
        7: teamRed,
        8: teamWorldFive,
        9: teamA,
        10: teamB,
        11: teamC,
        12: blEleven,
        13: u20Squad,
        14: bastard,
        15: barcha,
        16: manshine,
        17: ubers,
        18: pxg
    };

    const navigate = useNavigate();
    function handleClick() {
        navigate('/arcs')
    }

    return (
        <div>
            <Header />
            {arc && (
                <div className="title--container">
                    <img src={arrow} alt="go back to teams" onClick={handleClick}/>
                    <h2 className="title--text">{arc.arcName}</h2>
                </div>
            )}
            <div className="databox--grid--container">
                <div className="databox--grid">
                    {teams.map(team => (
                        <DataBox key={team.teamId} entity={team} imageUrl={teamImages[team.teamId]} />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default TeamList;
