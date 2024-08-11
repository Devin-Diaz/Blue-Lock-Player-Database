import React from "react";
import blueLockLogo from "../Images/blue_lock_logo.avif"
import '../Styles/headerStyle.css'

function Header() {
    return (
        <header className="header--container">
            <h1 className="header--title">Egoist</h1>
            <img className="header--logo" src={blueLockLogo} alt="main page logo"/>
            <h1 className="header--title">Engine</h1>
        </header>
    )
}

export default Header;