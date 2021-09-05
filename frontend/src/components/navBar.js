import React from 'react';
import { Image, Nav, Navbar } from 'react-bootstrap';
import { Link } from 'react-router-dom';

const NavBarComp = ({ categories, permissions }) => (
    <Navbar bg="light" expand="lg">
        <Navbar.Brand as={Link} to="/">
            Homain News
        </Navbar.Brand>
        <Navbar.Toggle aria-controls="news-navbar" />
        <Navbar.Collapse id="news-navbar">
            <Nav className="me-auto" >
                {
                    categories.map(category => (
                        <Nav.Link as={Link} to={`/categories/${category.id}`}
                            key={category.id} style={{
                                display: 'flex',
                                justifyContent: 'flex-start',
                            }} >
                            <Image src={category.image} fluid roundedCircle style={{ maxHeight: 50 }} />
                            <span className="nav-span" >{category.name}</ span>
                        </ Nav.Link>
                    ))
                }
            </Nav>
            <Nav className="navbar-right" >
                {
                    permissions.includes('create:news') && (
                        <Nav.Link as={Link} to="/add" className="bordered">Add News Item</Nav.Link>
                    )
                }
            </Nav>
        </Navbar.Collapse>
    </Navbar>
)

export default NavBarComp;