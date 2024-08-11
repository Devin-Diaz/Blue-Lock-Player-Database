import React from 'react';
import {BrowserRouter as Router, Route, Routes} from 'react-router-dom';
import './App.css';
import ArcList from './Components/ArcList';
import Welcome from './Components/Welcome';
import LockOffPage from './Components/LockOffPage';
import TeamList from './Components/TeamList';
import PlayerStatsList from './Components/PlayerStatsList';
import RayugaShadow from './Components/RayugaShadow';

function App() {
  return (
    <Router>
      <Routes>
          <Route path="/" element={<Welcome />} />
          <Route path="/bro-locked-off" element={<LockOffPage />} />
          <Route path="/bro-locked-off/rayuga-shadow" element={<RayugaShadow />} />
          <Route path="/arcs" element={<ArcList />} />
          <Route path="/arcs/:arcId" element={<TeamList />} />
          <Route path='/teams/:teamId' element={<PlayerStatsList />} />
      </Routes>
    </Router>
  );
}

export default App;
