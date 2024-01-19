current_dir=/Users/dohagtae/Desktop/best/docker

cd "$current_dir"

cd ../best-prc-config
git add .
git commit -m "common config update"
git push

cd ../configserver
./gradlew clean bootJar

cd ../eurekaserver
./gradlew clean bootJar

cd ../gatewayserver
./gradlew clean bootJar

cd ../notificationserver
./gradlew clean bootJar

cd ../paymentserver
./gradlew clean bootJar

cd ../reservationserver
./gradlew clean bootJar

cd "$current_dir"

docker-compose build
docker-compose up -d
docker ps -a

