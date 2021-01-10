# ProjectDemo


## RabbitMQ
### 安装
1. 使用Docker安装
```
docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3-management
```
2. 创建账号并授权   
``` 
rabbitmqctl add_user username passwd  //添加用户，后面两个参数分别是用户名和密码（默认密码是guest/guest）
rabbitmqctl set_permissions -p / username ".*" ".*" ".*"  //添加权限
rabbitmqctl set_user_tags username administrator  //修改用户角色,将用户设为管理员
```
3. 创建虚拟机  
```rabbitmqctl add_vhost vhost_name```
### RabbitMQ的消息模式
#### 1. Simple (简单队列)
provider -> queues cache -> consumer


