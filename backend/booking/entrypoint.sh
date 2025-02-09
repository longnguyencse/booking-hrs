#!/bin/bash

run_app() {
    java -jar booking.jar
}

# Make it rain
./wait-for-it.sh "${DB_HOST}":"${DB_PORT}" && run_app "$@"
