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


function CreateSet ({ onClick }) {
  return (
    <button className='App-button' onClick={onClick}>Create New Set</button>
  );
}

function ShowSetCreationMenu ({ onClose }) {
  return <Modal onClose={onClose} />;
}

function Modal ({ onClose }) {

  const [terms, setTerms] = useState([{term: '', definition: ''}]);

  const addTerm = async (event) => {
    event.preventDefault();
    setTerms([...terms, { term: '', definition: '' }]);

    const formData = {
      setName: document.querySelector('input[placeholder="Set Name"]').value,
      setCategory: document.querySelector('input[placeholder="Set category"]').value,
      terms: terms,
    };

    const response = await fetch('http://localhost:3000/api/endpoint', {
      method: 'POST',
      headers: {
        'Content-Type': 'application/json',
      },
      body: JSON.stringify(formData),
    });

    if (response.ok) {
      setTerms([{ term: '', definition: '' }]);
    } else {
      console.error('Failed to send form data to backend');
    }

  };

  const handleSubmit = async (event) => {
    event.preventDefault();
    await addTerm();
  };

  return (
    <div className='App-modal'>
      <div className='App-subheader'>
        <h1>Set Creator</h1>
        <form onSubmit={handleSubmit}>
          <div>
            <input
              className='App-text-input'
              type='text'
              placeHolder='Set Name'
            />
          </div>
          <div>
            <input
              className='App-text-input'
              type='text'
              placeHolder='Set Category'
            />
          </div>
          <div className='App-term-def-container'>
            {terms.map((term, index) => (
              <div key={index} className='App-term-definition-row'>
                <input
                  className='App-text-input'
                  type='text'
                  placeholder={`Term ${index + 1}`}
                  value={term.term}
                  onChange={(e) => {
                    const newTerms = [...terms];
                    newTerms[index].term = e.target.value;
                    setTerms(newTerms);
                  }}
                  required
                />
                <input
                  className='App-text-input'
                  type='text'
                  placeholder={`Definition ${index + 1}`}
                  value={term.definition}
                  onChange={(e) => {
                    const newTerms = [...terms];
                    newTerms[index].definition = e.target.value;
                    setTerms(newTerms);
                  }}
                  required
                />
              </div>
            ))}
          <button type='button' onClick={addTerm}>Add Term</button>
          </div>
        </form>
      </div>
      <div className='App-button-container'>
        <button className='App-button' onClick={onClose}> Close </button>
        <button className='App-button' form='form-id' type='submit'>Submit</button>
      </div>
    </div>
  );
}

function SearchForSet () {
  return (
    <input type='search' className='App-button' placeholder='Search for set' />
  );
}

function ActionRow () {
  const [showCreationMenu, setShowSetCreationMenu] = useState(false);
  return (
    <div className='App-function-row'>
      <CreateSet onClick={() => setShowSetCreationMenu(true)} />
      {showCreationMenu && <ShowSetCreationMenu onClose={() => setShowSetCreationMenu(false)} />}
      {SearchForSet()}
    </div>
  );
}

function App() {
  return (
    <div className="App">
      <HomeHeader />
      <ActionRow />
    </div>
  );
}

export default App;
