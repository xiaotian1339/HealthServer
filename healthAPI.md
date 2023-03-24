## 全局公共参数
#### 全局Header参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 全局Query参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 全局Body参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 全局认证方式
```text
noauth
```
#### 全局预执行脚本
```javascript
暂无预执行脚本
```
#### 全局后执行脚本
```javascript
暂无后执行脚本
```
## /api
```text
api目录
```
#### Header参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### Query参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### Body参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /api/拿到用户有数据的日期
```text
暂无描述
```
#### 接口状态
> 已完成

#### 接口URL
> health.tcgg.asia/api/v1/getUserDate

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
userId | 3208_1 | String | 是 | uid
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
[
	{
		"date": "2023-03-21",
		"id": 0
	},
	{
		"date": "2023-03-22",
		"id": 1
	}
]
```
## /api/根据用户id和日期查询数据
```text
日期必须遵守 yyyy-MM-dd格式
分割线为减号即中划线
eg: 2023-03-21
```
#### 接口状态
> 已完成

#### 接口URL
> health.tcgg.asia/api/v1/info/date

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
userId | 3208_1 | String | 是 | -
date | 2023-03-21 | String | 是 | 日期 yyyy-MM-dd
page | 2 | String | 是 | -
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
返回为HTML页面
```
#### 错误响应示例
```javascript
404界面
```
## /api/查询分页数据
```text
通过Post方式拿到健康检测数据，
必需参数：
userId：硬件ID 测试时使用“3208_1”
page: 页码
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/info

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
userId | 3208_1 | String | 是 | 用户id(ClientID)
page | 2 | String | 是 | 页码
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
{
	"total": 7,
	"list": [
		{
			"id": 1,
			"uid": "3208_1",
			"oxygenSaturation": 91.0945264,
			"heartRate": 101,
			"available": true,
			"date": "2023-03-21",
			"time": "11:27:51"
		},
		{
			"id": 2,
			"uid": "3208_1",
			"oxygenSaturation": 97.6924,
			"heartRate": 92,
			"available": true,
			"date": "2023-03-21",
			"time": "11:27:51"
		},
		{
			"id": 3,
			"uid": "3208_1",
			"oxygenSaturation": 92.118,
			"heartRate": 96,
			"available": true,
			"date": "2023-03-21",
			"time": "11:27:52"
		},
		{
			"id": 4,
			"uid": "3208_1",
			"oxygenSaturation": 99.1871248,
			"heartRate": 60,
			"available": true,
			"date": "2023-03-21",
			"time": "11:27:52"
		},
		{
			"id": 5,
			"uid": "3208_1",
			"oxygenSaturation": 94.57,
			"heartRate": 89,
			"available": true,
			"date": "2023-03-21",
			"time": "11:27:53"
		},
		{
			"id": 6,
			"uid": "3208_1",
			"oxygenSaturation": 89.58,
			"heartRate": 61,
			"available": true,
			"date": "2023-03-21",
			"time": "11:27:53"
		},
		{
			"id": 7,
			"uid": "3208_1",
			"oxygenSaturation": 99.686,
			"heartRate": 118,
			"available": true,
			"date": "2023-03-21",
			"time": "11:27:54"
		}
	],
	"pageNum": 1,
	"pageSize": 30,
	"size": 7,
	"startRow": 1,
	"endRow": 7,
	"pages": 1,
	"prePage": 0,
	"nextPage": 0,
	"isFirstPage": true,
	"isLastPage": true,
	"hasPreviousPage": false,
	"hasNextPage": false,
	"navigatePages": 8,
	"navigatepageNums": [
		1
	],
	"navigateFirstPage": 1,
	"navigateLastPage": 1
}
```
参数名 | 示例值 | 参数类型 | 参数描述
--- | --- | --- | ---
total | 7 | Integer | 总数
list | - | Array | 列表
list.id | 1 | Integer | 消息序列id
list.uid | 3208_1 | String | ClientId
list.oxygenSaturation | 91.0945264 | Number | 血氧
list.heartRate | 101 | Integer | 心率
list.available | true | Boolean | 是否可用(is_finger_on)
list.date | 2023-03-21 | String | 测量日期
list.time | 11:27:51 | String | 测量时间
pageNum | 1 | Integer | 页码
pageSize | 30 | Integer | 每页数量
size | 7 | Integer | 当前数量
startRow | 1 | Integer | 起始行
endRow | 7 | Integer | 终止行
pages | 1 | Integer | 总页数
prePage | 0 | Integer | 前一页
nextPage | 0 | Integer | 下一页
isFirstPage | true | Boolean | 是否为第一页
isLastPage | true | Boolean | 是否为末页
hasPreviousPage | false | Boolean | 是否有前一页
hasNextPage | false | Boolean | 是否有下一页
navigatePages | 8 | Integer | 导航页数
navigatepageNums | 1 | Array | 导航页码数组
navigateFirstPage | 1 | Integer | 第一页页码
navigateLastPage | 1 | Integer | 末页页码
## /api/通过Topic发送Mqtt数据
```text
暂无描述
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/sendMqttTopic

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
topic | java-mqtt-test | String | 是 | topic
sendData | {"id":"3208_1","SP02":"@float(88,99,1,9)","Heart_Rate":"@integer(60,120)","Is_finger_ontop":"true"} | String | 是 | JSON数据
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
{
	"code": 200,
	"message": "OK"
}
```
## /api/查看mqtt客户端配置
```text
默认密钥xiaotian5945
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/mqttConfigDetail

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
secret | xiaotian5945 | String | 是 | 密钥
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
{
  "host" : "tcp://49.233.50.22",
  "port" : 1883,
  "username" : "admin",
  "password" : "xiaotian5945",
  "inClientId" : "25f3d564cfd5e7e0aa037c2158817f84",
  "outClientId" : "0168635fadae6b5db4b0c9143e0e80b1",
  "topic" : "java-mqtt-test",
  "timeout" : 30,
  "keepalive" : 60,
  "cleanSession" : "true"
}
```
#### 错误响应示例
```javascript
{
    "code": 500,
    "message": "FAIL"
}
```
## /api/查看客户端topic
```text
暂无描述
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/topics

#### 请求方式
> POST

#### Content-Type
> none

#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
{"0" : "java-mqtt-test" }
```
## /api/发送默认topic信息
```text
暂无描述
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/sendMqtt

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
sendData | 123 | String | 是 | 数据
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
{"code":200,"message":"OK"}
```
## /api/使用topic和Qos发送Mqtt
```text
暂无描述
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/sendWithTopicAndQos

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
sendData | {"a":"d","d":"e"} | String | 是 | 数据
topic | test1 | String | 是 | topic
Qos | 0 | Integer | 是 | Qos等级
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /api/添加一个topic
```text
暂无描述
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/addTopic

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
topic | test1 | String | 是 | topic
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
{"code":200,"message":"OK"}
```
## /api/移除topic
```text
暂无描述
```
#### 接口状态
> 已完成

#### 接口URL
> https://health.tcgg.asia/api/v1/removeTopic

#### 请求方式
> POST

#### Content-Type
> urlencoded

#### 请求Body参数
参数名 | 示例值 | 参数类型 | 是否必填 | 参数描述
--- | --- | --- | --- | ---
topic | test2 | String | 是 | topic
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /简易页面
```text
简易页面，请求使用RESTFul风格
```
#### Header参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### Query参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### Body参数
参数名 | 示例值 | 参数描述
--- | --- | ---
暂无参数
#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
## /简易页面/返回用户数据的HTML页面
```text
health.tcgg.asia/info/{uid}/{pageNum}
uid 用户id
pageNum 页码

测试用例
GET：health.tcgg.asia/info/3208_1/2

页面展示3208_1用户的第2页数据
每页30条
```
#### 接口状态
> 开发中

#### 接口URL
> health.tcgg.asia/info/{uid}/{pageNum}

#### 请求方式
> GET

#### Content-Type
> none

#### 认证方式
```text
noauth
```
#### 预执行脚本
```javascript
暂无预执行脚本
```
#### 后执行脚本
```javascript
暂无后执行脚本
```
#### 成功响应示例
```javascript
<!DOCTYPE html>
   <html lang="en">
      <head>
      <meta charset="UTF-8">
      <link href="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.3/css/bootstrap.css" rel="stylesheet">
         <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.6.3/jquery.js"></script><script src="https://cdn.bootcdn.net/ajax/libs/axios/1.2.2/axios.js"></script><script src="https://cdn.bootcdn.net/ajax/libs/twitter-bootstrap/5.2.3/js/bootstrap.js"></script>
         <title>
            数据显示
         </title>
</head>
      <body>
         <table class="table table-striped table-hover">
            <thead>
               <tr>
                  <th>
                     血氧
                  </th>
                  <th>
                     心率
                  </th>
                  <th>
                     数据可用性
                  </th>
                  <th>
                     检测日期
                  </th>
                  <th>
                     检测时间
                  </th>
</tr>
</thead>
            <tbody>
               <tr>
                  <td>
                     91.6527
                  </td>
                  <td>
                     99
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:41
                  </td>
</tr>
               <tr>
                  <td>
                     96.25424
                  </td>
                  <td>
                     104
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:41
                  </td>
</tr>
               <tr>
                  <td>
                     96.96
                  </td>
                  <td>
                     90
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:42
                  </td>
</tr>
               <tr>
                  <td>
                     97.616837798
                  </td>
                  <td>
                     120
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:42
                  </td>
</tr>
               <tr>
                  <td>
                     95.0252289
                  </td>
                  <td>
                     106
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:42
                  </td>
</tr>
               <tr>
                  <td>
                     96.3369
                  </td>
                  <td>
                     79
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:43
                  </td>
</tr>
               <tr>
                  <td>
                     94.66
                  </td>
                  <td>
                     87
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:43
                  </td>
</tr>
               <tr>
                  <td>
                     98.10724753
                  </td>
                  <td>
                     77
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:43
                  </td>
</tr>
               <tr>
                  <td>
                     93.5
                  </td>
                  <td>
                     116
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:43
                  </td>
</tr>
               <tr>
                  <td>
                     95.50568065
                  </td>
                  <td>
                     105
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:47
                  </td>
</tr>
               <tr>
                  <td>
                     93.46
                  </td>
                  <td>
                     68
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:47
                  </td>
</tr>
               <tr>
                  <td>
                     97.19
                  </td>
                  <td>
                     84
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:48
                  </td>
</tr>
               <tr>
                  <td>
                     90.01160754
                  </td>
                  <td>
                     85
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:48
                  </td>
</tr>
               <tr>
                  <td>
                     96.135
                  </td>
                  <td>
                     104
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:48
                  </td>
</tr>
               <tr>
                  <td>
                     90.95421772
                  </td>
                  <td>
                     103
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:48
                  </td>
</tr>
               <tr>
                  <td>
                     95.7343
                  </td>
                  <td>
                     97
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:49
                  </td>
</tr>
               <tr>
                  <td>
                     98.21994175
                  </td>
                  <td>
                     86
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:49
                  </td>
</tr>
               <tr>
                  <td>
                     92.72
                  </td>
                  <td>
                     115
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:49
                  </td>
</tr>
               <tr>
                  <td>
                     90.237374
                  </td>
                  <td>
                     70
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:49
                  </td>
</tr>
               <tr>
                  <td>
                     89.84
                  </td>
                  <td>
                     111
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:50
                  </td>
</tr>
               <tr>
                  <td>
                     92.7765
                  </td>
                  <td>
                     93
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:50
                  </td>
</tr>
               <tr>
                  <td>
                     99.238
                  </td>
                  <td>
                     91
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:50
                  </td>
</tr>
               <tr>
                  <td>
                     93.1201
                  </td>
                  <td>
                     75
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:50
                  </td>
</tr>
               <tr>
                  <td>
                     91.54
                  </td>
                  <td>
                     114
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:51
                  </td>
</tr>
               <tr>
                  <td>
                     97.1
                  </td>
                  <td>
                     118
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:51
                  </td>
</tr>
               <tr>
                  <td>
                     93.18
                  </td>
                  <td>
                     112
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:52
                  </td>
</tr>
               <tr>
                  <td>
                     92.6413628
                  </td>
                  <td>
                     89
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:53
                  </td>
</tr>
               <tr>
                  <td>
                     95.573482
                  </td>
                  <td>
                     67
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:08:53
                  </td>
</tr>
               <tr>
                  <td>
                     93.2386301
                  </td>
                  <td>
                     86
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:28:16
                  </td>
</tr>
               <tr>
                  <td>
                     95.8
                  </td>
                  <td>
                     71
                  </td>
                  <td>
                     true
                  </td>
                  <td>
                     2023-03-22
                  </td>
                  <td>
                     14:28:18
                  </td>
</tr>
</tbody>
</table>
</body>
</html>
```