# Connect with EC2 instance

    $ ssh -i ${AWS_KEY} ubuntu@52.66.30.159
    $ sudo systemctl daemon-reload
    $ sudo systemctl restart kubelet
    $ sudo systemctl status kubelet

# Create AppData directory in worker node 1

    $ ssh -i ${AWS_KEY} ubuntu@13.201.56.87
    $ cd ..
    $ cd ..
    $ sudo mkdir AppData
    $ sudo chmod -R 777 AppData

# Copy the local files to EC2

    $ scp -i ${AWS_KEY} k8s/config.yml ubuntu@13.201.56.87:/home/ubuntu/ws
    $ scp -i ${AWS_KEY} k8s/db-deployment.yml ubuntu@13.201.56.87:/home/ubuntu/ws
    $ scp -i ${AWS_KEY} k8s/app-deployment.yml ubuntu@13.201.56.87:/home/ubuntu/ws

# Label the nodes

    $ kubectl label nodes workernode1 appName-
    $ kubectl label nodes workernode2 appName-
    $ kubectl label nodes workernode1 appName=mvcdemoApp
    $ kubectl label nodes workernode2 appName=mvcdemoDB
    $ kubectl get nodes --show-labels

# Create the Configuration

    $ kubectl apply -f ws/config.yml

# Create the Deployments

    $ kubectl apply -f ws/db-deployment.yml
    $ kubectl apply -f ws/app-deployment.yml

# See the Objects

    $ kubectl get pods -n default -o wide
    $ kubectl get configmaps -n default -o wide
    $ kubectl get secrets -n default -o wide
    $ kubectl get persistentvolumes -n default -o wide
    $ kubectl get persistentvolumeclaims -n default -o wide
    $ kubectl get deployments -n default -o wide
    $ kubectl get services -n default -o wide

# Describe the Objects

    $ kubectl describe configmap db-config -n default
    $ kubectl describe secret db-secrets -n default
    $ kubectl describe persistentvolume mypv -n default
    $ kubectl describe persistentvolumeclaim mysql-pv-claim -n default
    $ kubectl describe deployment mysql -n default
    $ kubectl describe deployment mvcdemo-deployment -n default
    $ kubectl describe service mysql -n default
    $ kubectl describe service mvcdemo-service -n default
    $ kubectl describe pod mysql-77fdffb894-lqbbs -n default
    $ kubectl describe pod mvcdemo-deployment-6d748fb56d-8g5b8 -n default
    $ kubectl describe pod mvcdemo-deployment-6d748fb56d-s8jc4 -n default

# Delete the Objects

    $ kubectl delete configmaps db-config -n default
    $ kubectl delete secrets db-secrets -n default
    $ kubectl delete persistentvolume mypv -n default
    $ kubectl delete persistentvolumeclaim mysql-pv-claim -n default
    $ kubectl delete deployments mysql -n default
    $ kubectl delete deployments mvcdemo-deployment -n default
    $ kubectl delete services mvcdemo-service -n default
    $ kubectl delete services mysql -n default
