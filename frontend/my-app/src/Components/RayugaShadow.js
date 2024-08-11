import React from "react";
import arrow from '../Images/arrow.png'
import leakDay from '../Images/leak_day.png';
import { useNavigate } from "react-router-dom";

function RayugaShadow() {
    const divStyle = {
        display: 'flex',
        justifyContent: 'center',
        alignItems: 'center',
    }
    const imgStyle = {
        width: '1000px',
        marginTop: '100px'
    }

    const nav = useNavigate();
    function handleClick() {
        nav('/bro-locked-off')
    }
    
    
    return (
        <div>
            <div className="title--container">
                <h2 className="title--text">POV: Rayuga and Shadow On Leak Days</h2>
                <img src={arrow} alt="go back to locked off page" onClick={handleClick}/>
            </div>
            <div style={divStyle}>
                <img style={imgStyle} src={leakDay} alt="twins fr"/>
            </div>           
        </div>
    )
}

export default RayugaShadow;