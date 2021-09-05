#  Full Stack NEWS API 

The project is an educational project .
it is a demonstration of API development techniques using spring boot framework .


## Getting Started

### Backend


#### Running the server

Assuming you have maven installed in your machine, in the backend folder, execute:

```bash
mvn spring-boot:run
```

This will start the backend server on port `8080` by default


### Frontend

1. **Node** - Follow instructions to install the latest version of node.js for your platform in the [Node.js docs](https://docs.npmjs.com/downloading-and-installing-node-js-and-npm)





2. **NPM Packages** once you installed node and npm install dependencies by naviging to the `/frontend` directory and running:
```bash
npm install
```
This will install all of the required packages .

#### Running the server

in the frontend folder, execute:

```bash
npm start
```
this will start the frontend app on port `3000` by default

## API Reference
### Endpoints

#### GET api/categories
- Request Arguments: None
- Returns: list of category objects 
```bash
curl -X GET http://localhost:8080/api/categories/
```

```json
[
    {
        "id": 1,
        "name": "Politics",
        "image": "https://thumbs.dreamstime.com/b/black-solid-icon-speech-politics-leader-black-solid-icon-speech-politician-logo-politics-leader-146772569.jpg"
    },
    {
        "id": 2,
        "name": "Sport",
        "image": "https://st2.depositphotos.com/4840515/7191/i/950/depositphotos_71918941-stock-photo-silhouettes-figures-of-athletes.jpg"
    },
    {
        "id": 3,
        "name": "Health",
        "image": "https://thumbs.dreamstime.com/b/heart-icon-vector-health-perfect-love-symbol-emblem-isolated-white-background-shadow-flat-style-graphic-web-design-127436803.jpg"
    },
    {
        "id": 4,
        "name": "Entertainment",
        "image": "https://comps.canstockphoto.com/entertainment-icon-set-image_csp52190573.jpg"
    }
]

```


#### GET api/news
- Request Arguments: None
- Returns: list of news objects
 
```bash
curl -X GET http://localhost:8080/api/news
```

```json

[
    {
        "title": "Biden launches federal effort to respond to Texas law as he faces pressure to protect abortion",
        "description": "description\ndescription\ndescription",
        "image": "https://cdn.cnn.com/cnnnext/dam/assets/200304111019-01-abortion-protests-supreme-court-medium-plus-169.jpg",
        "category": 1,
        "id": 5
    },
    {
        "title": "England won 4-0 over host Hungary",
        "description": "description\ndescription\ndescription",
        "image": "https://e0.365dm.com/21/09/512x512/skysports-raheem-sterling-england_5499010.jpg",
        "category": 2,
        "id": 6
    },
    {
        "title": "Coronavirus live news: Bulgaria tightens restrictions ahead of expected surge; further 178 UK deaths reported — as it happened",
        "description": "description\ndescription\ndescription",
        "image": "https://i.guim.co.uk/img/media/d0b6a615cca747e8cbcf9acb7bfcafd9a1143943/0_350_5343_3205/master/5343.jpg?width=620&quality=85&auto=format&fit=max&s=674796953dacebf28c607f5280a7a0a7",
        "category": 3,
        "id": 7
    },
    {
        "title": "Film: More people needed to work with Hollywood stars",
        "description": "description\ndescription\ndescription",
        "image": "https://ichef.bbci.co.uk/news/976/cpsprodpb/A02E/production/_120360014_gavinandstacey.jpg",
        "category": 4,
        "id": 8
    }
]

```

#### GET api/categories/{id}/news
- Request Arguments: None
- Returns: List of news from this category

```bash
curl -X GET http://localhost:8080/api/categories/2/news/
```

```json
[
    {
        "title": "England won 4-0 over host Hungary",
        "description": "description\ndescription\ndescription",
        "image": "https://e0.365dm.com/21/09/512x512/skysports-raheem-sterling-england_5499010.jpg",
        "category": 2,
        "id": 6
    }
]
```

#### POST api/news
- Request Arguments: None
- Posts new news item to the database
- Payload: `title`, `description`, `image`, `category`
- headers: `Content-type`, `Authorization`



#### DELETE api/news/{id}
- Deletes the news item with the given id
- headers: `Content-type`, `Authorization`

#### PUT api/news/{id}
- Edits the news item with the given id
- Payload: `title`, `description`, `image`, `category`
- headers: `Content-type`, `Authorization`

## Future Features
- Paginating returned news for production build with a lot of data
- Allowing no-admin users to comment on news items
- Adding a search feature to search for interesting news


## Authors
- Mahmoud Khayralla (Me)


## Acknowledgements
- I'd like to thank [homains](https://www.homains.com/) for letting me practice through this task

