import React from 'react' ;
import { Alert } from 'react-bootstrap';

const PermissionDenied = () => {

    return (
        <Alert variant="danger">
            You are not allowed to perform this action, you must be an Admin! 
        </Alert>
    )
}

export default PermissionDenied ;