import { BrowserRouter, Route, Router, Routes } from 'react-router-dom'
import './App.css'
import NavbarLayout from './components/NavbarLayout'
import ConferenceList from './components/ConferenceList'
import KeynotesList from './components/KeynotesList'

function App() {

  return (
      <BrowserRouter>
        <Routes>
          <Route path='/' element={<NavbarLayout/>}>
            <Route path='conferences' element={<ConferenceList/>}/>
            <Route path='keynotes' element={<KeynotesList/>}/>
          </Route>
        </Routes>
      </BrowserRouter>
  )
}

export default App
