# AsyncSDk


## Configuration

### Switch: Default off
`async.enabled=true`

### Data Source: Druid
- `spring.datasource.driver-class-name=com.mysql.jdbc.Driver`
- `spring.datasource.url=jdbc:mysql://127.0.0.1:3306/fc_async?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&rewriteBatchedStatements=true`
- `spring.datasource.username=user`
- `spring.datasource.password=xxxx`
- `spring.datasource.filters=config`
- `spring.datasource.connectionProperties=config.decrypt=true;config.decrypt.key=yyy`

### Static Addresses
- `spring.resources.add-mappings=true`
- `spring.resources.static-locations=classpath:/static/`

### Defaults
#### Core Thread Count
`async.executor.thread.corePoolSize=10`
#### Maximum Thread Count
`async.executor.thread.maxPoolSize=50`
#### Queue Capacity
`async.executor.thread.queueCapacity=10000`
#### Keep Alive Time
`async.executor.thread.keepAliveSeconds=600`

#### Record Deletion Post-Execution: Default is to delete
`async.exec.deleted=true`

#### Custom Queue Name Prefix: Default is application name
`async.topic=application name`

#### Retry Execution Count: Default 5 times
`async.exec.count=5`

#### Maximum Number of Retry Queries
`async.retry.limit=100`

#### Maximum Number of Compensation Queries
`async.comp.limit=100`

#### Login Switch: Default off
`async.login.enabled=false`

#### Login URL
`async.login.url=http://xxxx.com`
