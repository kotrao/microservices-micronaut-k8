kubectl delete deployment customersvc-deployment
kubectl delete service customersvc
kubectl apply -f k8s/deployment-customer.yaml