# microservices-micronaut-k8

This repo contains to project to demonstrate service discovery in Micronaut using Kubernetes. Two projects are:

	- customer-service
	- order-service

customer-service project calls the order-service using declarative client. The order-service will be discovered using service discovery.

Both projects are configured to use jib for building container images and skaffold for deployment into kubernetes.


# How to run?

## Running manually

You need minikube and skaffold installed locally.

 - First run scripts/setpermissions.sh to set the appropriate permissions for default service account. 
 - Go to order-service folder and run skaffold dev
 - Go to customer-service folder and run skaffold dev
 - From a third terminal run curl $(minikube ip):30007/customers/1

## Running using code cloud plugin for intellij
Google's <a href="https://cloud.google.com/code/docs/intellij/deploying-a-k8-app">code cloud</a> plugin for intellij makes 
kubernetes development very productive.

 - Install code cloud plugin from https://cloud.google.com/code/docs/intellij/install
 - Open cluster explorer from Tools->Cloud Code->Kubernetes->View Cluster Explorer
 - Run the service in minikube by selecting Run on kubernetes from run drop down. This should allow you to debug.



