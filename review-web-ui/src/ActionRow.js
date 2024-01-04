import React, { useState, useEffect } from 'react';
import './App.css';
import SetCreationMenu from './SetCreator.js';

function ActionRow () {
    const [displayCreationMenu, SetCreationMenu] = useState(false);

    return (
      <div className='App-function-row'>
        <CreateSetButton onClick={() => SetCreationMenu(true)} />
        {displayCreationMenu && <SetCreationMenu onClose={() => displayCreationMenu(false)}/>}
        <SetCreationMenu />
      </div>
    );
  }

function CreateSetButton ({ onClick }) {
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