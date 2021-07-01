# Twigs Server

This is the backend application that powers the [Android](https://github.com/wbrawner/twigs-android), [iOS](https://github.com/wbrawner/twigs-ios), and [web](https://github.com/wbrawner/twigs-web) applications for Twigs, a personal finance/budgeting app. 

## Prerequisites

- Go 1.16 or newer
- MySQL 5.7 or newer
- (optional) Docker

## Running

Prior to running the app, make sure you have a MySQL server running, with a database and user ready to go. To avoid the hassle of figuring out how to get it installed locally, using Docker is recommended, and a sample `docker-compose.yml` file is included in the root of the repository. If you already have a MySQL server running, you can run the app from the command line with gradle:

    go run twigs.go

By default, twigs will try to connect to the `budget` database on `localhost:3306`, using `budget` as the user and password. To change these values, you can set the following environment variables:

|Variable|Default Value|
|---|---|
|TWIGS_DB_HOST|localhost|
|TWIGS_DB_PORT|3306|
|TWIGS_DB_NAME|budget|
|TWIGS_DB_USER|budget|
|TWIGS_DB_PASS|budget|

## Building

    go build

