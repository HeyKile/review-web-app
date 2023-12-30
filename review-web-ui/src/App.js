import './App.css';
import React, { useState, useEffect } from 'react';
import HomeHeader from './Header.js';
import ActionRow from './ActionRow.js';
import DisplaySetGrid from './SetDisplayGrid.js';

function App() {
  return (
    <div className="App">
      <HomeHeader />
      <ActionRow />
      <DisplaySetGrid />
    </div>
  );
}

export default App;