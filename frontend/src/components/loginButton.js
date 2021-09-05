import React from 'react' ;
import { useAuth0 } from '@auth0/auth0-react' ;
import Button from 'react-bootstrap/Button' ;

const Login = () => {
    const {isAuthenticated, loginWithRedirect, logout, isLoading } = useAuth0() ;
    if (isLoading) {
        return (
            <span />
        )
    }
    const loginButton = (
        <Button variant="info"
        className='login-button'
        onClick={loginWithRedirect}
        size="lg" >
            Login
        </Button>
    )
    const logoutButton = (
        <Button variant="danger"
        className='login-button'
        onClick={() =>logout({returnTo : window.location.origin})}
        size="lg" >
            Logout
        </Button>
    )
    return (
        isAuthenticated ? (
            logoutButton
        ) : (
            loginButton
        )
    )
}

export default Login ;