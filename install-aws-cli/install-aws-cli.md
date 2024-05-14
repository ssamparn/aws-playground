# Install AWS CLI:

## Install AWS CLI
- [Reference-1](https://docs.aws.amazon.com/cli/latest/userguide/cli-chap-install.html)
- [Reference-2](https://docs.aws.amazon.com/cli/latest/userguide/install-cliv2.html)

### Install and configure AWS CLI in Mac
> Download and install the binary via command line using below two commands.

#### Download the Binary
```bash
$ curl "https://awscli.amazonaws.com/AWSCLIV2.pkg" -o "AWSCLIV2.pkg"
```
#### Install the binary
```bash
$ sudo installer -pkg ./AWSCLIV2.pkg -target /
```
#### Verify the installation
```bash
$ aws --version
Response: aws-cli/2.15.42 Python/3.11.8 Darwin/23.4.0 exe/x86_64 prompt/off
$ which aws
```

#### Configure AWS CLI
```bash
$ aws configure
```
> Provide the AWS Access Key ID, Secret Access Key and the Region Name.