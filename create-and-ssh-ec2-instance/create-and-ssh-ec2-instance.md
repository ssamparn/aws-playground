## Create & Connect to AWS EC2 Instance

#### Create an EC2 Instance
- Goto **EC2** Dashboard.
- Click on **Instances**
- Click on **Launch Instances**
- Provide name for the EC2 Instance **aws-web-server**. You can choose to provide a tag for the same, which is optional.
- Choose OS as **Amazon Linux** and **AMI** as **Amazon Linux 2 AMI**.
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
> Note: If the instance is not reachable and the requests are timed out, then check the inbound security group rules.
> While choosing the AMI, choose **Amazon Linux 2 AMI** instead of **Amazon Linux 2023 AMI**. Since 2023 AMI is not reachable from http.

#### SSH into EC2 Instance
- After launching the EC2 instance, it's time to access it via SSH - Port 22.
- Check the Security Group Inbound Rules if the traffic for Port 22 is allowed in.

```bash
# command templates to ssh into ec2 instance
$ cd create-and-ssh-ec2-instance/
$ chmod 0400 <key-pair-file.pem>
$ ssh -i <key-pair-file.pem> ec2-user@<public-ipv4-of-the-instance>

# actual commands
$ chmod 0400 ec2-key-pair.pem
$ ssh -i ec2-key-pair.pem ec2-user@34.236.154.15
```

- After the successful connection check the connection.

```bash
$ whoami
$ ping google.com
$ exit
```