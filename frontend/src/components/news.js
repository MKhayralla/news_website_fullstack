import React, { useEffect, useState } from 'react';
import { Card, Col, Row } from 'react-bootstrap';
import { Link } from 'react-router-dom';
const News = () => {
    const [news, updateNews] = useState([]);
    useEffect(() => {
        const url = `${process.env.REACT_APP_API_URL}/api/news`
        fetch(url)
            .then(response => response.json())
            .then(data => updateNews(data))
            .catch(err => console.log(err.toString()))
    }, [])
    return (
        <Row>
            {
                news.map(item => (
                    <Col key={item.id} xs={12} lg={6}>
                        <Card style={{ minHeight: 400 }}>
                            <Card.Img variant="left" src={item.image} style={{ maxHeight: 250 }} />
                            <Card.Title>{item.title}</Card.Title>
                            <Card.Text>{item.description.substring(0, 100)}</Card.Text>
                            <Card.Link as={Link} to={`/news/${item.id}`}>Read More</Card.Link>
                        </Card>
                    </Col>
                ))
            }
        </Row>
    )
}

export default News;