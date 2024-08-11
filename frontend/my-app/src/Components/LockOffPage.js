import React from "react";
import egoPic from '../Images/ego_jumpscare.jpg'
import '../Styles/egoStyle.css'
import Header from '../Components/Header'
import { useNavigate } from "react-router-dom";
import Button from "./Button";

function LockOffPage() {

    const navigate = useNavigate();

    function handleRSClick() {
        navigate('rayuga-shadow')
    }

    function handleWelcomeClick() {
        navigate('/')
    }

    function handleArcsClick() {
        navigate('/arcs')
    }

    return (
        <div>
            <div className="ego--container">
                <Header />
                <h1 className="ego--text">You missed harder then Kaiser, go back and browse some arcs</h1>
                <img className="ego--image" src={egoPic} alt="ego's goofy ahh"/>
            </div>

            <div className="button--container">
                <Button eventListener={handleRSClick} buttonName="Rayuga x Shadow"/>
                <Button eventListener={handleWelcomeClick} buttonName="Welcome Page"/>
                <Button eventListener={handleArcsClick} buttonName="Browse Arcs"/>
            </div>
        </div>

    )
}

export default LockOffPage