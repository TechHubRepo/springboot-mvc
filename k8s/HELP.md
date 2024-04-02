# Connect with EC2 instance

    $ ssh -i ${AWS_KEY} ubuntu@[IP_ADDRESS]

# Copy the local files to EC2

    $ scp -i ${AWS_KEY} k8s/config.yml ubuntu@[IP_ADDRESS]:/home/ubuntu/k8s
    $ scp -i ${AWS_KEY} k8s/db-deployment.yml ubuntu@[IP_ADDRESS]:/home/ubuntu/k8s
    $ scp -i ${AWS_KEY} k8s/app-deployment.yml ubuntu@[IP_ADDRESS]:/home/ubuntu/k8s

# Create AppData directory

    $ cd ..
    $ cd ..
    $ sudo mkdir AppData
    $ sudo chmod -R 777 AppData

# Uninstall Minikube

    $ minikube stop
    $ minikube delete 
    $ rm -rf /usr/local/bin/minikube
    $ rm -rf ~/.minikube
    $ rm -rf /usr/local/bin/kubectl

# Install Minikube

    $ sudo apt-get update
    $ sudo apt install docker.io -y
    $ sudo usermod -aG docker ${USER}
    $ docker version
    $ curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-linux-amd64
    $ sudo install minikube-linux-amd64 /usr/local/bin/minikube && rm minikube-linux-amd64

# Start/Stop minikube

    $ minikube start
    $ alias kubectl="minikube kubectl --"
    $ minikube stop

# Label the nodes

    $ kubectl label nodes minikube appName-
    $ kubectl label nodes minikube appName=mvcdemoApp
    $ kubectl get nodes --show-labels

# Create the Configuration

    $ kubectl apply -f k8s/config.yml

# Create the Deployments

    $ kubectl apply -f k8s/db-deployment.yml
    $ kubectl apply -f k8s/app-deployment.yml

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
    $ kubectl describe pod mysql-77fdffb894-jffm4 -n default
    $ kubectl describe pod mvcdemo-deployment-6d748fb56d-8g5b8 -n default
    $ kubectl describe pod mvcdemo-deployment-6d748fb56d-s8jc4 -n default

# Delete the Objects

    $ kubectl delete deployments mysql -n default
    $ kubectl delete persistentvolumeclaim mysql-pv-claim -n default
    $ kubectl delete persistentvolume mypv -n default
    $ kubectl delete deployments mvcdemo-deployment -n default
    $ kubectl delete configmaps db-config -n default
    $ kubectl delete secrets db-secrets -n default
    $ kubectl delete services mysql -n default
    $ kubectl delete services mvcdemo-service -n default
    

