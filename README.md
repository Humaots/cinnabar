# Socratic AI Companion

AI 苏格拉底学伴（Socratic AI Companion）是一个基于 **JDK 21 + Spring Boot 4.1 + Spring Cloud Alibaba 2025.1** 的微服务学习沙盒。

这个仓库的目标不是做一个“生产级大而全平台”，而是用尽量清晰的边界，演示 AI 教育系统里最关键的几件事：

- 微服务拆分与演进
- 苏格拉底式追问
- 多智能体协作
- 知识图谱与自适应学习路径
- RAG + 结构化 AI 输出
- Redis 会话态、RabbitMQ 异步任务、Zipkin 链路追踪
- 虚拟线程下的 AI 调用与阻塞式依赖治理

## 设计原则

这套工程采用“**6+ 目标架构，3 服务起步**”的方式：

- 代码边界按完整版设计，不把后续拆分做成推倒重来
- 首版实现先从核心闭环开始，减少学习噪音
- 所有关键服务契约先放进 `socratic-commons`
- 基础设施统一用 `docker-compose.yml` 启动

这样做的目的，是让学习者先理解业务闭环，再逐步理解服务拆分的价值。

## 当前模块

### 业务与基础模块

- `gateway-service`
  - API 网关
  - JWT 鉴权入口
  - 统一流量入口
- `user-service`
  - 用户档案
  - 初始画像
  - 知识图谱状态
- `knowledge-base-service`
  - 文档切片
  - 向量检索
  - 知识点拓扑关系
- `ai-orchestrator-service`
  - 多智能体调度中心
  - 协调追问、规划、激励等 Agent
- `ai-executor-service`
  - 实际大模型调用
  - 结构化输出
  - RAG 检索执行
- `learning-analytics-service`
  - 答题事件分析
  - 掌握度更新
  - 冷启动测评处理
- `socratic-commons`
  - 共享契约
  - DTO / Event / Port 定义
- `discovery-service`
  - Nacos 注册中心占位模块
  - 实际服务由 Docker Compose 中的 Nacos 提供

## 基础设施

`docker-compose.yml` 当前包含：

- Nacos
- MySQL 8.4
- Redis 7.4
- RabbitMQ 3.13
- Zipkin
- Qdrant
- 可选 `pgvector`

## 目录结构

```text
.
├── pom.xml
├── docker-compose.yml
├── README.md
├── socratic-commons/
├── discovery-service/
├── gateway-service/
├── user-service/
├── knowledge-base-service/
├── ai-orchestrator-service/
├── ai-executor-service/
└── learning-analytics-service/
```

## 关键架构决策

### 1. 服务拆分

当前采用“先完整定义边界，再按需逐步落地”的方式。

- 不把 6+ 个职责先揉成 3 个大服务
- 也不强行一开始把所有服务都做满
- 这样后续扩容时更多是“补齐实现”，而不是“重构边界”

### 2. 注册与配置中心

当前选用 Nacos。

- 和 Spring Cloud Alibaba 的集成最直接
- 适合本地 Docker Compose 学习环境
- 后续若迁移 Kubernetes，可再评估原生发现机制

### 3. 向量数据库

当前选用 Qdrant，`pgvector` 作为可选备选。

- Qdrant 更适合独立的向量检索/RAG 场景
- `pgvector` 更适合“少一个基础设施”的极简路线

### 4. 会话状态

- Redis 保存短期会话态
- 关系型数据库保存长期画像与掌握度
- Executor 保持无状态

### 5. 虚拟线程

项目会在 AI Executor 中重点使用虚拟线程执行同步阻塞调用。

- 这样可以保留传统 Spring 生态的开发体验
- 同时降低大规模阻塞调用的线程成本

## 本地启动

### 1. 启动基础设施

```bash
docker compose up -d
```

### 2. 本地开发

建议先从以下模块逐步启动：

1. `gateway-service`
2. `user-service`
3. `ai-orchestrator-service`

后续再补齐：

- `knowledge-base-service`
- `ai-executor-service`
- `learning-analytics-service`

### 3. Maven 构建

```bash
mvn clean package
```

## 配置方式

各服务通过 `bootstrap.yml` 对接 Nacos。

默认环境变量约定：

- `NACOS_SERVER`
- `NACOS_NAMESPACE`

## 代码注释约定

为了让后续维护者更容易理解架构，本项目会优先在这些地方补少量说明性注释：

- 服务入口类
- 核心接口
- 会话、编排、检索等关键契约
- 容易被误解的基础设施配置

原则是：

- 解释“为什么这么设计”
- 不重复代码本身已经写明的内容
- 不加无意义注释

## 后续扩展路线

下一阶段会继续补齐：

- Gateway 路由与 JWT
- Redis 会话态实现
- Qdrant 检索适配
- Spring AI 结构化输出
- RabbitMQ 异步学习分析
- Zipkin TraceId 透传

## 说明

这是一个面向学习和演示的架构沙盒。很多模块现在只保留了骨架和契约，后续会按“先闭环、后扩展”的方式逐步补齐。
