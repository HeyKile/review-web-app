import React, { useState, useEffect } from 'react';
import './App.css';

function DisplaySetList () {

    const data = Array(10).fill(null);

    return (
        <div className='App-set-display-list'>
            {data.map((_, index) => (
                <div key={index} className='App-set-rectangle'>
                    Temp Set {index}
                </div>
            ))}
        </div>
    );
}

export default DisplaySetList;