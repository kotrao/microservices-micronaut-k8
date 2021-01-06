# microservices-micronaut-k8

This repo contains to project to demonstrate service discovery in Micronaut using Kubernetes. Two projects are:

	- customer-service
	- order-service

customer-service project calls the order-service using declarative client. The order-service will be discovered using service discovery.

Both projects are configured to use jib for building container images and skaffold for deployment into kubernetes.


# How to run

You need minikube and skaffold installed locally.

 - First run scripts/setpermissions.sh to set the appropriate permissions for default service account. 
 - Go to order-service folder and run skaffold dev
 - Go to customer-service folder and run skaffold dev
 - From a third terminal run curl $(minikube ip):30007/customers/1

