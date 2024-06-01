# Connect with EC2 instance

    $ ssh -i ${AWS_KEY} ubuntu@[IP_ADDRESS]

# Copy the local files to EC2

    $ scp -i ${AWS_KEY} k8s/mysql-deployment.yml ubuntu@[IP_ADDRESS]:/home/ubuntu/k8s
    $ scp -i ${AWS_KEY} k8s/app-deployment.yml ubuntu@[IP_ADDRESS]:/home/ubuntu/k8s

# Create AppData directory

    $ sudo mkdir /AppData
    $ sudo chmod -R 777 /AppData
    $ sudo mkdir /AppData/mysql

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

# Create the Deployments

    $ kubectl apply -f k8s/mysql-deployment.yml
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

    $ kubectl describe pod mysql-deployment-f654b7995-pctds -n default
    $ kubectl describe pod mvcdemo-deployment-6d748fb56d-s8jc4 -n default

# Delete the Objects
    
    $ kubectl delete persistentvolumeclaim mysql-pv-claim -n default
    $ kubectl delete persistentvolume mysql-pv -n default
    $ kubectl delete configmaps mysql-config -n default
    $ kubectl delete secrets mysql-secret -n default
    $ kubectl delete services mysql-service -n default
    $ kubectl delete services mvcdemo-service -n default

    $ kubectl delete deployments mvcdemo-deployment -n default
    $ kubectl delete deployments mysql-deployment -n default
    
# Connect with MySQL pod

    $ kubectl exec -it mysql-deployment-f654b7995-dzdhv -- /bin/bash
        # mysql --user='root' --password='root'

# Access the Web Application
    $ minikube ip
    http://[MINIKUBE_IP]:30001

# To Scale the Replicaset 

    $ kubectl scale replicaset [RepliSet-name] --replicas=[numbers]
    $ kubectl scale replicaset mysql-deployment-76796c49cb --replicas=3
    $ kubectl scale replicaset mvcdemo-deployment-d5795f6f5 --replicas=3