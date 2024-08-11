import React from "react";
import '../Styles/buttonStyle.css'

function Button(props) {
    return (

        <button className="button" onClick={props.eventListener}>
            {props.buttonName}
        </button>
    );
}

export default Button;