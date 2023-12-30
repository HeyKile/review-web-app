import React, { useState, useEffect } from 'react';
import './App.css';
import './Header';
import './ActionRow';

function App() {
  return (
    <div className="App">
      <HomeHeader />
      <ActionRow />
      {/* <SetDisplayGrid /> */}
    </div>
  );
}

export default App;
