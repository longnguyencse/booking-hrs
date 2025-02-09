FROM amazoncorretto:17.0.2
WORKDIR /home/application/java
ADD entrypoint.sh entrypoint.sh
ADD https://raw.githubusercontent.com/vishnubob/wait-for-it/master/wait-for-it.sh ./wait-for-it.sh
RUN ["chmod", "+x", "./wait-for-it.sh"]

COPY build/libs/booking-0.0.1.jar booking.jar

EXPOSE 8080

CMD [ "entrypoint.sh" ]
ENTRYPOINT ["/bin/sh"]
