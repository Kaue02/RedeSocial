import './App.css'
import {BrowserRouter, Routes, Route} from "react-router-dom"
import { Login } from './pages/Login'
import { SignUn } from './pages/SignIn'
import { Home } from './pages/Home'

function App() {

  return (
    
    <BrowserRouter>
      <Routes>
        <Route path='/' element={< Login/>}></Route>
        <Route path='/SignUp' element={< SignUn/>}></Route>
        <Route path='/Home:email' element={< Home/>}></Route>
      </Routes>
    </BrowserRouter>

  )
}

export default App
