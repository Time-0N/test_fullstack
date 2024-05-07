import './App.css'
import {Route, Routes} from "react-router-dom";
import HomePage from "./containers/homepage/HomePage.tsx";
import LoginPage from "./containers/login/LoginPage.tsx";
import RegisterPage from "./containers/register/RegisterPage.tsx";
import UserHome from "./containers/userhome/UserHome.tsx";
import Settings from "./containers/settings/Settings.tsx";
import {ProtectedRoute} from "./components/ProtectedRoute.tsx";
//import BouncingLogo from './components/BouncingLogo.tsx';

function App() {

  return (
    <div className="App">

        <Routes>

            <Route path={"/"} element={<HomePage/>}/>

            <Route path={"/login"} element={<LoginPage/>}/>

            <Route path={"/register"} element={<RegisterPage/>}/>

            <Route path={"/user-home"} element={<ProtectedRoute children={<UserHome/>}/>}/>

            <Route path={"/user-home/settings"} element={<ProtectedRoute children={<Settings/>}/>}/>
        </Routes>
    </div>
  )
}

export default App