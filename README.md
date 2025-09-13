# AsyncSDK

This module provides an asynchronous task execution framework based on **Spring Boot**, **kafka**, **xxl-job**, and **MySQL**, with flexible configuration and logging.

<img width="524" height="1036" alt="ChatGPT Image 2025年9月14日 01_51_39" src="https://github.com/user-attachments/assets/2cf07dca-bf2c-49f6-b396-845ee8e98c76" />


## 1. Database Schema

### Table: `async_req`

```sql
CREATE TABLE `async_req` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key ID',
  `application_name` varchar(100) NOT NULL DEFAULT '' COMMENT 'Application name',
  `sign` varchar(50) NOT NULL DEFAULT '' COMMENT 'Method signature',
  `class_name` varchar(200) NOT NULL DEFAULT '' COMMENT 'Fully qualified class name',
  `method_name` varchar(100) NOT NULL DEFAULT '' COMMENT 'Method name',
  `async_type` varchar(50) NOT NULL DEFAULT '' COMMENT 'Asynchronous strategy type',
  `exec_status` tinyint NOT NULL DEFAULT '0' COMMENT 'Execution status: 0 = Initialized, 1 = Execution failed, 2 = Execution succeeded',
  `exec_count` int NOT NULL DEFAULT '0' COMMENT 'Execution count',
  `param_json` longtext COMMENT 'Request parameters (JSON)',
  `remark` varchar(200) NOT NULL DEFAULT '' COMMENT 'Business description',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Update time',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_applocation_name` (`application_name`) USING BTREE,
  KEY `idx_exec_status` (`exec_status`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Asynchronous processing request';
```

### Table: `async_log`

```sql
CREATE TABLE `async_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT 'Primary key ID',
  `async_id` bigint NOT NULL DEFAULT '0' COMMENT 'Asynchronous request ID',
  `error_data` longtext COMMENT 'Execution error information',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT 'Creation time',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_async_id` (`async_id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='Asynchronous processing log';
```

---

## 2. Configuration

Below are the key configuration properties. Default values are provided where applicable.

### Core Switch
| Property | Default | Description |
|----------|---------|-------------|
| `async.enabled` | `false` | Global async switch. Set to `true` to enable. |

### Data Source (Druid)
| Property | Example | Description |
|----------|---------|-------------|
| `async.datasource.driver-class-name` | `com.mysql.jdbc.Driver` | JDBC driver. |
| `async.datasource.url` | `jdbc:mysql://127.0.0.1:3306/fc_async?useUnicode=true&characterEncoding=utf-8&zeroDateTimeBehavior=convertToNull&useSSL=false&allowMultiQueries=true&rewriteBatchedStatements=true` | JDBC URL. |
| `async.datasource.username` | `user` | Database username. |
| `async.datasource.password` | `xxxx` | Database password. |
| `async.datasource.filters` | `config` | Druid filter. |
| `async.datasource.connectionProperties` | `config.decrypt=true;config.decrypt.key=yyy` | Connection properties. |

### Static Resources
| Property | Default |
|----------|---------|
| `spring.resources.add-mappings` | `true` |
| `spring.resources.static-locations` | `classpath:/static/` |

### Thread Pool
| Property | Default | Description |
|----------|---------|-------------|
| `async.executor.thread.corePoolSize` | `10` | Core thread count. |
| `async.executor.thread.maxPoolSize` | `50` | Maximum thread count. |
| `async.executor.thread.queueCapacity` | `10000` | Queue capacity. |
| `async.executor.thread.keepAliveSeconds` | `600` | Keep-alive time (seconds). |

### Execution & Retry
| Property | Default | Description |
|----------|---------|-------------|
| `async.exec.deleted` | `true` | Delete record after successful execution. |
| `async.topic` | *Application name* | Custom queue name prefix. |
| `async.exec.count` | `5` | Maximum retry count. |
| `async.retry.limit` | `100` | Max records fetched per retry. |
| `async.comp.limit` | `100` | Max records fetched per compensation task. |

### Login (Optional)
| Property | Default | Description |
|----------|---------|-------------|
| `async.login.enabled` | `false` | Enable login for manual processing page. |
| `async.login.url` | `http://xxxx.com` | Login URL if enabled. |

---

## 3. Usage

1. **Enable Async**

   ```properties
   async.enabled=true
   ```

2. **Add Annotation**

   Apply the annotation to any method that needs asynchronous execution.  
   > The method must be a **Spring proxied method**.

   ```java
   @AsyncExec(type = AsyncExecEnum.SAVE_ASYNC, remark = "Data Dictionary")
   ```

3. **Manual Processing Page**

   Access the web UI for manual compensation/processing:

   ```
   http://localhost:8004/async/index.html
   ```

---

## 4. Notes

- Ensure the database schema above is created before enabling async tasks.
- Druid configuration supports encrypted credentials (`config.decrypt.key`).

---


