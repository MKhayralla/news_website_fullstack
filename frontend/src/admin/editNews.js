import React, { useEffect, useState } from "react";

import { useAuth0 } from "@auth0/auth0-react";
import Button from "react-bootstrap/Button";
import { Form } from "react-bootstrap";
import { withRouter, useParams } from "react-router-dom";
const EditForm = ({ categories, history }) => {
    const [item, updateForm] = useState(null)
    const { getAccessTokenSilently } = useAuth0()
    const {id} = useParams() ;
    useEffect(() => {
        const url = `${process.env.REACT_APP_API_URL}/api/news/${id}`;
        fetch(url)
        .then(res => res.json())
        .then(data => updateForm({title:data.title,description:data.description,image:data.image,category:data.category.id}))
        .catch(err => console.log(err.toString()))      
    }, [id])
    const handleChange = (e) => {
        e.preventDefault();
        updateForm((last_state) => ({ ...last_state, [e.target.name]: e.target.value }))
    }
    const handleSubmit = () => {
        const url = `${process.env.REACT_APP_API_URL}/api/news/${id}`;
        getAccessTokenSilently()
            .then(token => (
                fetch(url, {
                    method: "PUT",
                    body: JSON.stringify(item),
                    headers: {
                        "Content-type": "application/json; charset=UTF-8",
                        "Authorization": `Bearer ${token}`
                    }
                })
            ))
            .then(res => {
                if (!res.ok) {
                    console.log(res.statusText);
                    switch (res.status) {
                        case 401:
                            alert('not logged in!')
                            break;
                        case 403:
                            alert('you have to be an admin to add news')
                            break;
                        default:
                            alert("Error happened ! Can't perform the task");
                    }
                    throw Error(res.statusText)
                }
                return res.json();
            })
            .then(data => console.log(data))
            .then(() => history.push(`/news/${id}`))
            .catch(err => alert(err.toString()))
    }
    return item && (
        <Form>
            <h2>Edit News Item with id = {id}</h2>
            <Form.Group controlId="newsForm">
                <Form.Label>
                    Title
                </Form.Label>
                <Form.Control as="textarea" name="title" rows={3}
                    value={item.title}
                    onChange={handleChange} />
                <Form.Label>
                    Description
                </Form.Label>
                <Form.Control as="textarea" name="description" rows={20}
                    value={item.description}
                    onChange={handleChange} />
                <Form.Label>
                    Image Link
                </Form.Label>
                <Form.Control type="text" name="image"
                    value={item.image}
                    onChange={handleChange} />
                <Form.Select name="category"
                    value={item.category}
                    onChange={handleChange} >
                    <option>category</option>
                    {
                        categories.map(cat => (
                            <option value={cat.id} key={cat.id} >{cat.name}</option>
                        ))
                    }
                </Form.Select>
            </Form.Group>
            <Button className="form-control"
                onClick={handleSubmit}>Edit news Item data</Button>
        </Form>
    )
}

export default withRouter(EditForm);