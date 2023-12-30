import React, { useState, useEffect } from 'react';
import './App.css';

function DisplaySetGrid () {

    const data = Array(10).fill(null);

    return (
        <div className='App-set-display-list'>
            {data.map((_, index) => (
                <div key={index} className='App-set-rectangle'>
                    Hello {index}
                </div>
            ))}
        </div>
    );
}

export default DisplaySetGrid;