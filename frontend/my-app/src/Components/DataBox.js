import React from "react";
import { useNavigate } from "react-router-dom";
import '../Styles/dataBoxStyle.css';

function DataBox({ entity, imageUrl }) {
    const navigate = useNavigate();

    function handleClick() {
        if (entity.arcId) {
            navigate(`/arcs/${entity.arcId}`);
        } else if (entity.teamId) {
            navigate(`/teams/${entity.teamId}`);
        }
    }

    return (
        <div className="databox--card" onClick={handleClick}>
            <img src={imageUrl} alt={`${entity.arcName || entity.teamName}`} className="databox--image" />
            <h3>{entity.arcName || entity.teamName}</h3>
        </div>
    );
}

export default DataBox;
