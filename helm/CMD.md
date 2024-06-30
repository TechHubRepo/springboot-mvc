# Connect with EC2 instance

    $ ssh -i ${AWS_KEY} ubuntu@[IP_ADDRESS]

# Create AppData directory

    $ sudo mkdir /AppData
    $ sudo chmod -R 777 /AppData
    $ sudo mkdir /AppData/mysql
    $ sudo chmod -R 777 /AppData/mysql

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

# HELM
    $ helm install mysql-server helm/mysql-chart --dry-run
    $ helm install mysql-server helm/mysql-chart
    $ helm uninstall mysql-server helm/mysql-chart

    $ helm install app-server helm/app-chart --dry-run
    $ helm install app-server helm/app-chart
    $ helm uninstall app-server helm/app-chart

# Describe the Objects

    $ kubectl describe pod [POD_NAME] -n default

# Connect with MySQL pod

    $ kubectl exec -it [POD_NAME] -- /bin/bash
        # mysql --user='root' --password='root'
                    OR
        # mysql -u root -p
        # Enter Password = root

# Access the Web Application
    $ minikube ip
    http://[MINIKUBE_IP]:30001



