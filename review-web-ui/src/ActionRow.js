import React, { useState, useEffect } from 'react';
import './App.css';
import './SetCreator.js';

function ActionRow () {
    const [showCreationMenu, setShowSetCreationMenu] = useState(false);
    return (
      <div className='App-function-row'>
        <CreateSet onClick={() => setShowSetCreationMenu(true)} />
        {showCreationMenu && <showCreationMenu onClose={() => setShowSetCreationMenu(false)} />}
        {SearchForSet()}
      </div>
    );
  }

function CreateSet ({ onClick }) {
  return (
    <button className='App-button' onClick={onClick}>Create New Set</button>
  );
}

function SearchForSet () {
  return (
    <input type='search' className='App-button' placeholder='Search for set' />
  );
}

export default ActionRow;