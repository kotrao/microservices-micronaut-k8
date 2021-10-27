This is to demonstrate running Micronaut services in kubernetes and using service discovery features.
skaffold and jib are being using to run these services in minikkube. 

customer-service makes a call to order-service to get the details of customer and returns.

## Running Order service in minikube
- cd order-service
- skaffold dev

## Running Customer service in minikube
- cd order-service
- skaffold dev

## Testing without @ExecuteOn(TaskExecutors.IO) on CustomerController
Use the URL http://localhost:8080/customers/1 for testing

If you try this from chromer browser or postman, it doesn't get any response from second time.
But it has no problem if you try from curl.

## Testing with @ExecuteOn(TaskExecutors.IO) on CustomerController
Use the URL http://localhost:8080/customers/1 for testing

It has no issues. It continues to work after the first request.





