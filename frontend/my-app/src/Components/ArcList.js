import React, { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import api from "../Services/api";
import Header from './Header';
import DataBox from './DataBox';
import firstSelec from '../Images/first_selection_img.webp';
import secondSelec from '../Images/second_selection_img.webp';
import thirdSelec from '../Images/third_selection_img.webp';
import worldFive from '../Images/world_five.jpg';
import u20 from '../Images/u20_match_img.jpg';
import neoEgoist from '../Images/neo_egoist_img.png';
import '../Styles/dataBoxStyle.css';
import arrow from '../Images/arrow.png';

function ArcList() {
    const [arcs, setArcs] = useState([]);

    useEffect(() => {
        const fetchArcs = async () => {
            try {
                const response = await api.get('arcs');
                setArcs(response.data);
            } catch (error) {
                console.log('error fetching blue lock arcs!', error);
            }
        };
        fetchArcs();
    }, []);

    const arcImages = {
        1: firstSelec,
        2: secondSelec,
        3: worldFive,
        4: thirdSelec,
        5: u20,
        6: neoEgoist
    };

    const navigate = useNavigate();
    function handleClick() {
        navigate('/')
    }

    return (
        <div>
            <Header />
            <div className="title--container">
                <img src={arrow} alt="go to welcome page" onClick={handleClick}/>
                <h2 className="title--text">Arcs</h2>
            </div>
            <div className="databox--grid--container">
                <div className="databox--grid">
                    {arcs.map(arc => (
                        <DataBox key={arc.arcId} entity={arc} imageUrl={arcImages[arc.arcId]} />
                    ))}
                </div>
            </div>
        </div>
    );
}

export default ArcList;