# Connect with EC2 instance

    $ ssh -i ${AWS_KEY} ubuntu@13.201.132.1
    $ sudo systemctl daemon-reload
    $ sudo systemctl restart kubelet
    $ sudo systemctl status kubelet

# Create AppData directory in node

    $ ssh -i ${AWS_KEY} ubuntu@3.110.156.56
    $ sudo mkdir AppData
    $ sudo chmod -R 777 AppData

# Copy the local files to EC2

    $ scp -i ${AWS_KEY} config.yml ubuntu@13.201.132.1:/home/ubuntu/ws
    $ scp -i ${AWS_KEY} db-deployment.yml ubuntu@13.201.132.1:/home/ubuntu/ws
    $ scp -i ${AWS_KEY} app-deployment.yml ubuntu@13.201.132.1:/home/ubuntu/ws

# Label the nodes

    $ kubectl label nodes workernode1 appName=mvcdemo
    $ kubectl label nodes workernode2 appName=mywebapp

# Create the Configuration

    $ kubectl apply -f ws/config.yml

# Create the Deployments

    $ kubectl apply -f ws/db-deployment.yml
    $ kubectl apply -f ws/app-deployment.yml

# See the Objects

     $ kubectl get pods -n default
     $ kubectl get configmaps -n default
     $ kubectl get secrets -n default
     $ kubectl get persistentvolumes -n default
     $ kubectl get persistentvolumeclaims -n default
     $ kubectl get deployments -n default
     $ kubectl get services -n default

# Describe the Objects

     $ kubectl describe configmap NAME -n default
     $ kubectl describe secret NAME -n default
     $ kubectl describe persistentvolume NAME -n default
     $ kubectl describe persistentvolumeclaim NAME -n default
     $ kubectl describe deployment NAME -n default
     $ kubectl describe service NAME -n default
     $ kubectl describe pod mysql-58b86c5997-qv2z9 -n default


# Delete the Objects

     $ kubectl delete configmaps db-config -n default
     $ kubectl delete secrets db-secrets -n default
     $ kubectl delete persistentvolume mypv -n default
     $ kubectl delete persistentvolumeclaim mysql-pv-claim -n default
     $ kubectl delete deployments mysql -n default
     $ kubectl delete deployments mvcdemo-deployment -n default
     $ kubectl delete services mvcdemo-service -n default
     $ kubectl delete services mysql -n default

