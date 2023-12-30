import React, { useState, useEffect } from 'react';
import './App.css';

function HomeHeader () {
    return (
        <div className="App-header">
            <h1 style={{ marginBottom: '5px' }}>Welcome! Let's get studying!</h1>
            <DateAndTime />
        </div>
    )
}

function DateAndTime () {
    const [date, setDate] = useState(new Date().toLocaleDateString());
    const [time, setTime] = useState(new Date().toLocaleTimeString());

    useEffect(() => {
        const timer = setInterval(() => {
            setDate(new Date().toLocaleDateString());
            setTime(new Date().toLocaleTimeString());
        }, 1000);

        return () => {
            clearInterval(timer);
        }
        
    }, []);

    return (
        <div>
            <p style={{ marginTop: '5px' }}>
                <span style={{ marginRight: '20px' }}>{date}</span>{time}
            </p>
        </div>
    );
}