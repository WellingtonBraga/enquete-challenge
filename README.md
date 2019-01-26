# Enquete Spring Challenge

This project shows an example of how efficient Spring Boot can be and how much it can contribute to us.

## Getting Started

In order to run the project, follow the steps below

### Installing

#### dependencies
Clone this repository and download its dependencies.

#### database

The application uses MySQL database to persist data. The file [db_enquete.sql](db_enquete.sql) is the backup of the database and must to be
restored.

##### Initialize database

To initialize api, all we need to do is to start the embbedded TomCat.

## Endpoints

Below it is stated each endpoint in this api and its responsability.

Method | Pattern | Purpose | URL Params | Body Params
-------|---------|---------|------------|-------------
GET | /poll/{id} | Return a poll. | id=[int] | -
POST | /poll | Create new poll. | - | {"poll_description": "This is the question","options": ["Second Option","Third Option"]}" 
POST | /poll/{id}/vote | Vote to one option. | - | -
GET | /poll/{id}/stats | Return data about the poll statistics. | - | -


## Built by

* Wellington Braga
