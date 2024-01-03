import './App.css';
import React, { useState, useEffect } from 'react';
import HomeHeader from './Header.js';
import ActionRow from './ActionRow.js';
import DisplaySetList from './SetDisplayList.js';

function App() {
  return (
    <div className="App">
      <HomeHeader />
      <ActionRow />
      <DisplaySetList />
    </div>
  );
}

export default App;