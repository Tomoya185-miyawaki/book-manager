DC := @docker-compose

up:
	$(DC) -f ./docker/docker-compose.yml up -d
sql:
	mysql -h 127.0.0.1 --port 3306 -uroot -pmysql
run:
	./gradlew bootRun
mbgen:
	./gradlew mbGenerator