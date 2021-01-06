./gradlew shadowJar
if [ $? -ne 0 ]
then
	echo "build failed"
	exit 1
fi
eval $(minikube -p minikube docker-env)
docker build . -t micronauttest/ordersvc
