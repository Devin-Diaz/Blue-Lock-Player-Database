import React from "react";
import { useNavigate } from "react-router-dom";
import Button from './Button';
import '../Styles/buttonStyle.css';
import '../Styles/welcomeBodyStyle.css';

function WelcomeBody() {
    const navigate = useNavigate();

    function handleBrowseArcsClick() {
        navigate('/arcs');
    }

    function handleLockOffClick() {
        navigate('/bro-locked-off');
    }

    return (
        <main className="welcome--container">
            <div className="left--container">
                <h1 className="welcome--text">Welcome to the Blue Lock Egoist Engine!</h1>
            </div>
            <div className="right--container">
                <h3 className="spoilers--text">
                    <span className="spoiler--span">**Note for Anime-Only Viewers**</span>
                    This database contains spoilers. Manga readers, enjoy exploring!
                    <br /><br />
                    <a href="https://bluelock.fandom.com/wiki/Blue_Lock_Wiki"> 
                        <u>All data is from the Fandom Blue Lock Wiki</u>
                    </a>
                    <br /><br />

                    <a href="https://github.com/Devin-Diaz">
                       <u>My Github</u> 
                    </a>
                </h3>
                <h4 className="description--text">
                    As a passionate fan of Blue Lock, one of the most popular manga and anime series today, 
                    I'm excited to present this mini player database. It showcases all teams and players for 
                    each arc of the manga so far.
                    <br /><br />
                    Creating this was the perfect project for me as a computer science student, blending my love for 
                    Blue Lock with my technical skills. I hope you enjoy it as much as I enjoyed making it!
                </h4>
                <div className="buttons--container">
                    <Button eventListener={handleLockOffClick} buttonName="LOCK OFF" />
                    <Button eventListener={handleBrowseArcsClick} buttonName="Browse Arcs" />
                </div>
            </div>
        </main>
    );
    
    
}

export default WelcomeBody;
