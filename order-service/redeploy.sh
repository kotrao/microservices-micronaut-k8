kubectl delete deployment ordersvc-deployment
kubectl delete service ordersvc
kubectl apply -f k8s/deployment-ordersvc.yaml