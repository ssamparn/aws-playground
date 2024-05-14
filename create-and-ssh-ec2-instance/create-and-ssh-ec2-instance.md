## Create & Connect to AWS EC2 Instance

#### Create an EC2 Instance
- Goto **EC2** Dashboard.
- Click on **Instances**
- Click on **Launch Instances**
- Provide name for the EC2 Instance **aws-web-server**. You can choose to provide a tag for the same, which is optional.
- Choose OS as **Amazon Linux** and **AMI** as **Amazon Linux 2023 AMI**.
- Choose architecture as **64-bit (x86)**
- Now go on to create a key-pair. Click on **Create a new key pair**. 
  - Provide name as **ec2-key-pair**.
  - Key pair type: **RSA**
  - Private key file format: **.pem**
- In **Network Settings** along with the default options, enable **Allow HTTP traffic from the internet**.
- Provide **User Data** as below in the advanced details section.

```bash
# ec2 init bootstrap script: ec2-user-data.sh
!/bin/bash
yum update -y
yum install -y httpd
systemctl start httpd
systemctl enable httpd
echo "<h1>Hello World from $(hostname -f)</h1>" > /var/www/html/index.html
```

- Now Click on **Launch Instance**. Wait (30 seconds to 1 minute) for the instance to be launched.

- **Public IPv4 Address**: Public IPv4 Address is used to connect to EC2 Instance from outside.
- **Private IPv4 Address**: Private IPv4 Address is used to connect to EC2 Instance from inside using AWS internal network.

#### Access the website
```bash
$ curl http://<public-ip>
```