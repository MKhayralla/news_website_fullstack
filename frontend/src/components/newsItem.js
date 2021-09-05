import React, { Fragment, useEffect, useState } from "react";
import { Card } from "react-bootstrap";
import { useParams, Link, withRouter } from "react-router-dom";
import Button from 'react-bootstrap/Button';
import { useAuth0 } from "@auth0/auth0-react";
const NewsItem = ({ permissions, history }) => {
    const { id } = useParams();
    const [item, updateItem] = useState(null);
    const { getAccessTokenSilently } = useAuth0();
    useEffect(() => {
        const url = `${process.env.REACT_APP_API_URL}/api/news/${id}`;
        fetch(url)
            .then(res => res.json())
            .then(data => updateItem(data))
            .catch(err => console.log(err.toString()))
    }, [id])
    const handleDelete = () => {
        if (!window.confirm('do you really want to delete this item ?')) {
            return ;
        }
        const url = `${process.env.REACT_APP_API_URL}/api/news/${id}`
        getAccessTokenSilently()
            .then(token => (
                fetch(url, {
                    method: 'DELETE',
                    headers: {
                        'Content-type': 'application/json; charset=UTF-8;',
                        'Authorization': `Bearer ${token}`
                    }
                })
            ))
            .then(res => {
                if (!res.ok) {
                    throw Error(res.statusText)
                }
                alert('Item Deleted Successfully');
                history.push('/');
            })
            .catch(err => console.log(err.toString()))
    }
    return item ? (
        <Card>
            <Card.Img src={item.image} alt={item.title} style={{ maxHeight: 400 }} />
            <Card.Header>
                <Card.Title>{item.title}</Card.Title>
            </Card.Header>
            <Card.Body>
                <Card.Text className="multi-line">
                    {item.description}
                </Card.Text>
                <Card.Link as={Link} to={`/categories/${item.category.id}`}>
                    {item.category.name}
                </Card.Link>
                {
                    permissions.includes('delete:news') && (
                        <Fragment>
                            <Card.Link as={Link} to={`/edit/${item.id}`}> Edit</Card.Link>
                            <Card.Link as={Button}
                            variant="danger"
                            size="sm"
                            onClick={handleDelete}> Delete</Card.Link>
                        </Fragment>

                    )
                }
            </Card.Body>
        </Card>
    ) : (
        <h1>Loading ...</h1>
    )
}

export default withRouter(NewsItem);