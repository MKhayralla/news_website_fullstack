import { Container } from 'react-bootstrap';
import './App.css';
import React, { useEffect, useState } from "react";
import { useAuth0 } from '@auth0/auth0-react';
import Decode from 'jwt-decode' ;
import News from './components/news';
import NewsItem from './components/newsItem';
import EditItem from './admin/editNews';
import PermissionDenied from './admin/adminPermissionDenied' ;
import LoginButton from './components/loginButton';
import AddItem from './admin/addNews';
import Category from './components/category';
import Nav from './components/navBar';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom';
function App() {
  const [categories, updateCategories] = useState([]);
  const [permissions, updatePermissions] = useState([]);
  const { getAccessTokenSilently } = useAuth0() ;
  useEffect(() => {
    getAccessTokenSilently()
    .then(res => Decode(res))
    .then(data => data.permissions)
    .then(p => updatePermissions(p))
    .catch(err => console.log("Not Logged In" + err.toString()))
  }, [getAccessTokenSilently])
  useEffect(() => {
    const url = `${process.env.REACT_APP_API_URL}/api/categories`;
    fetch(url)
      .then(response => response.json())
      .then(data => updateCategories(data))
      .catch(err => console.log(err.toString()))
  }, []);
  return (
    <div className="App">
      <Router>
        <Nav categories={categories} permissions={permissions} />
        <Container>
          <Switch>
            <Route exact path="/">
              <News />
            </Route>
            <Route path="/add">
              {permissions.includes("create:news")?<AddItem categories={categories} />:<PermissionDenied />}
            </Route>
            <Route path="/categories/:id">
              <Category />
            </Route>
            <Route path="/news/:id">
              <NewsItem permissions={permissions} />
            </Route>
            <Route path="/edit/:id">
            {permissions.includes("update:news")?<EditItem categories={categories} />:<PermissionDenied />}
            </Route>
          </Switch>
          <LoginButton />
        </Container>
      </Router>
    </div>
  );
}

export default App;
