.class public Lcom/amazon/device/analytics/log/Logging;
.super Ljava/lang/Object;
.source "Logging.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/analytics/log/Logging$LogLevel;
    }
.end annotation


# static fields
.field private static defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field private static instance:Lcom/amazon/device/analytics/log/Logging;


# instance fields
.field private appenders:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/amazon/device/analytics/log/appenders/LogAppender;",
            ">;"
        }
    .end annotation
.end field

.field private configLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

.field private configReadLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

.field private configWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

.field private configuration:Lcom/amazon/device/analytics/configuration/Configuration;

.field private final globalLogLevelListener:Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

.field private loggers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Class",
            "<*>;",
            "Lcom/amazon/device/analytics/log/Logger;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/device/analytics/log/Logging;->instance:Lcom/amazon/device/analytics/log/Logging;

    .line 38
    sget-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->OFF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    sput-object v0, Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 62
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->appenders:Ljava/util/Map;

    .line 42
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;

    .line 43
    new-instance v0, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;

    invoke-direct {v0}, Lcom/amazon/device/analytics/configuration/InMemoryConfiguration;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    .line 44
    new-instance v0, Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->configLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    .line 45
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->configLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->readLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->configReadLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    .line 46
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->configLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-virtual {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;->writeLock()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->configWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    .line 48
    new-instance v0, Lcom/amazon/device/analytics/log/Logging$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/log/Logging$1;-><init>(Lcom/amazon/device/analytics/log/Logging;)V

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->globalLogLevelListener:Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    .line 63
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->appenders:Ljava/util/Map;

    const-class v1, Lcom/amazon/device/analytics/log/appenders/LogCatAppender;

    new-instance v2, Lcom/amazon/device/analytics/log/appenders/LogCatAppender;

    invoke-direct {v2}, Lcom/amazon/device/analytics/log/appenders/LogCatAppender;-><init>()V

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 64
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/analytics/log/Logging;)Ljava/util/Map;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/analytics/log/Logging;

    .prologue
    .line 20
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic access$100()Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .locals 1

    .prologue
    .line 20
    sget-object v0, Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    return-object v0
.end method

.method static synthetic access$102(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .prologue
    .line 20
    sput-object p0, Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    return-object p0
.end method

.method private attachAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V
    .locals 2
    .param p1, "appender"    # Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .prologue
    .line 105
    if-nez p1, :cond_1

    .line 112
    :cond_0
    :goto_0
    return-void

    .line 109
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->appenders:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->appenders:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-interface {v0, v1, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static attachLogAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V
    .locals 1
    .param p0, "appender"    # Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .prologue
    .line 184
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->getInstance()Lcom/amazon/device/analytics/log/Logging;

    move-result-object v0

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/log/Logging;->attachAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V

    .line 185
    return-void
.end method

.method private detachAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V
    .locals 2
    .param p1, "appender"    # Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .prologue
    .line 115
    if-nez p1, :cond_1

    .line 122
    :cond_0
    :goto_0
    return-void

    .line 119
    :cond_1
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->appenders:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->appenders:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public static detachLogAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V
    .locals 1
    .param p0, "appender"    # Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .prologue
    .line 192
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->getInstance()Lcom/amazon/device/analytics/log/Logging;

    move-result-object v0

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/log/Logging;->detachAppender(Lcom/amazon/device/analytics/log/appenders/LogAppender;)V

    .line 193
    return-void
.end method

.method private getAppenders()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/device/analytics/log/appenders/LogAppender;",
            ">;"
        }
    .end annotation

    .prologue
    .line 161
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logging;->appenders:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method private getClassLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/device/analytics/log/Logger;"
        }
    .end annotation

    .prologue
    .line 125
    .local p1, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-nez p1, :cond_0

    .line 126
    const-class p1, Lcom/amazon/device/analytics/log/Logging;

    .line 128
    :cond_0
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 129
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;

    invoke-interface {v3, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/device/analytics/log/Logger;

    .line 155
    :goto_0
    return-object v3

    .line 131
    :cond_1
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->configReadLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->lock()V

    .line 133
    :try_start_0
    new-instance v3, Lcom/amazon/device/analytics/log/LoggerBuilder;

    const-string/jumbo v4, "TailwindAnalyticsSDK"

    invoke-direct {v3, v4, p1}, Lcom/amazon/device/analytics/log/LoggerBuilder;-><init>(Ljava/lang/String;Ljava/lang/Class;)V

    sget-object v4, Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/log/LoggerBuilder;->setGlobalLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Lcom/amazon/device/analytics/log/LoggerBuilder;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/device/analytics/log/LoggerBuilder;->build()Lcom/amazon/device/analytics/log/Logger;

    move-result-object v2

    .line 138
    .local v2, "logger":Lcom/amazon/device/analytics/log/Logger;
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v3, :cond_3

    .line 140
    :try_start_1
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-static {p1}, Lcom/amazon/device/analytics/log/Logger;->getLogLevelConfigurationKey(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v4

    const/4 v5, 0x0

    invoke-interface {v3, v4, v5}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 141
    .local v1, "levelName":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 142
    invoke-static {v1}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->valueOf(Ljava/lang/String;)Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v0

    .line 143
    .local v0, "level":Lcom/amazon/device/analytics/log/Logging$LogLevel;
    invoke-virtual {v2, v0}, Lcom/amazon/device/analytics/log/Logger;->setLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 149
    .end local v0    # "level":Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .end local v1    # "levelName":Ljava/lang/String;
    :cond_2
    :goto_1
    :try_start_2
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-virtual {v2}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/device/analytics/log/Logger;->getLogLevelConfigurationKey(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v2}, Lcom/amazon/device/analytics/configuration/Configuration;->registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 152
    :cond_3
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;

    invoke-interface {v3, p1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 155
    iget-object v3, p0, Lcom/amazon/device/analytics/log/Logging;->configReadLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v3}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    move-object v3, v2

    goto :goto_0

    .end local v2    # "logger":Lcom/amazon/device/analytics/log/Logger;
    :catchall_0
    move-exception v3

    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configReadLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;->unlock()V

    throw v3

    .line 145
    .restart local v2    # "logger":Lcom/amazon/device/analytics/log/Logger;
    :catch_0
    move-exception v3

    goto :goto_1
.end method

.method private static declared-synchronized getInstance()Lcom/amazon/device/analytics/log/Logging;
    .locals 2

    .prologue
    .line 165
    const-class v1, Lcom/amazon/device/analytics/log/Logging;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/device/analytics/log/Logging;->instance:Lcom/amazon/device/analytics/log/Logging;

    if-nez v0, :cond_0

    .line 166
    new-instance v0, Lcom/amazon/device/analytics/log/Logging;

    invoke-direct {v0}, Lcom/amazon/device/analytics/log/Logging;-><init>()V

    sput-object v0, Lcom/amazon/device/analytics/log/Logging;->instance:Lcom/amazon/device/analytics/log/Logging;

    .line 168
    :cond_0
    sget-object v0, Lcom/amazon/device/analytics/log/Logging;->instance:Lcom/amazon/device/analytics/log/Logging;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 165
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static getLogAppenders()Ljava/util/Collection;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Collection",
            "<",
            "Lcom/amazon/device/analytics/log/appenders/LogAppender;",
            ">;"
        }
    .end annotation

    .prologue
    .line 200
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->getInstance()Lcom/amazon/device/analytics/log/Logging;

    move-result-object v0

    invoke-direct {v0}, Lcom/amazon/device/analytics/log/Logging;->getAppenders()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method public static getLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Lcom/amazon/device/analytics/log/Logger;"
        }
    .end annotation

    .prologue
    .line 209
    .local p0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->getInstance()Lcom/amazon/device/analytics/log/Logging;

    move-result-object v0

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/log/Logging;->getClassLogger(Ljava/lang/Class;)Lcom/amazon/device/analytics/log/Logger;

    move-result-object v0

    return-object v0
.end method

.method private setConfig(Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 7
    .param p1, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 67
    if-eqz p1, :cond_3

    .line 68
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-virtual {p1, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 69
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->lock()V

    .line 71
    :try_start_0
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    if-eqz v4, :cond_0

    .line 72
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    const-string/jumbo v5, "logLevel"

    iget-object v6, p0, Lcom/amazon/device/analytics/log/Logging;->globalLogLevelListener:Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    invoke-interface {v4, v5, v6}, Lcom/amazon/device/analytics/configuration/Configuration;->unregisterChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 73
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .local v2, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/device/analytics/log/Logger;

    .line 74
    .local v3, "logger":Lcom/amazon/device/analytics/log/Logger;
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-virtual {v3}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/device/analytics/log/Logger;->getLogLevelConfigurationKey(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Lcom/amazon/device/analytics/configuration/Configuration;->unregisterChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 98
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "logger":Lcom/amazon/device/analytics/log/Logger;
    :catchall_0
    move-exception v4

    iget-object v5, p0, Lcom/amazon/device/analytics/log/Logging;->configWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v5}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    throw v4

    .line 77
    :cond_0
    :try_start_1
    iput-object p1, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 79
    :try_start_2
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    const-string/jumbo v5, "logLevel"

    sget-object v6, Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v6}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->name()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->valueOf(Ljava/lang/String;)Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v4

    sput-object v4, Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 82
    :goto_1
    :try_start_3
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    const-string/jumbo v5, "logLevel"

    iget-object v6, p0, Lcom/amazon/device/analytics/log/Logging;->globalLogLevelListener:Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;

    invoke-interface {v4, v5, v6}, Lcom/amazon/device/analytics/configuration/Configuration;->registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V

    .line 83
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->loggers:Ljava/util/Map;

    invoke-interface {v4}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .restart local v2    # "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/device/analytics/log/Logger;

    .line 84
    .restart local v3    # "logger":Lcom/amazon/device/analytics/log/Logger;
    sget-object v4, Lcom/amazon/device/analytics/log/Logging;->defaultLogLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {v3, v4}, Lcom/amazon/device/analytics/log/Logger;->setGlobalLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)V

    .line 85
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-virtual {v3}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/device/analytics/log/Logger;->getLogLevelConfigurationKey(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v5

    const/4 v6, 0x0

    invoke-interface {v4, v5, v6}, Lcom/amazon/device/analytics/configuration/Configuration;->optString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v1

    .line 88
    .local v1, "classLevelName":Ljava/lang/String;
    if-eqz v1, :cond_1

    .line 90
    :try_start_4
    invoke-static {v1}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->valueOf(Ljava/lang/String;)Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v0

    .line 91
    .local v0, "classLevel":Lcom/amazon/device/analytics/log/Logging$LogLevel;
    invoke-virtual {v3, v0}, Lcom/amazon/device/analytics/log/Logger;->setLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 95
    .end local v0    # "classLevel":Lcom/amazon/device/analytics/log/Logging$LogLevel;
    :cond_1
    :goto_3
    :try_start_5
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configuration:Lcom/amazon/device/analytics/configuration/Configuration;

    invoke-virtual {v3}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/device/analytics/log/Logger;->getLogLevelConfigurationKey(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5, v3}, Lcom/amazon/device/analytics/configuration/Configuration;->registerChangedListener(Ljava/lang/String;Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 98
    .end local v1    # "classLevelName":Ljava/lang/String;
    .end local v3    # "logger":Lcom/amazon/device/analytics/log/Logger;
    :cond_2
    iget-object v4, p0, Lcom/amazon/device/analytics/log/Logging;->configWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;

    invoke-virtual {v4}, Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;->unlock()V

    .line 102
    .end local v2    # "i$":Ljava/util/Iterator;
    :cond_3
    return-void

    .line 92
    .restart local v1    # "classLevelName":Ljava/lang/String;
    .restart local v2    # "i$":Ljava/util/Iterator;
    .restart local v3    # "logger":Lcom/amazon/device/analytics/log/Logger;
    :catch_0
    move-exception v4

    goto :goto_3

    .line 80
    .end local v1    # "classLevelName":Ljava/lang/String;
    .end local v2    # "i$":Ljava/util/Iterator;
    .end local v3    # "logger":Lcom/amazon/device/analytics/log/Logger;
    :catch_1
    move-exception v4

    goto :goto_1
.end method

.method public static setConfiguration(Lcom/amazon/device/analytics/configuration/Configuration;)V
    .locals 1
    .param p0, "config"    # Lcom/amazon/device/analytics/configuration/Configuration;

    .prologue
    .line 176
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->getInstance()Lcom/amazon/device/analytics/log/Logging;

    move-result-object v0

    invoke-direct {v0, p0}, Lcom/amazon/device/analytics/log/Logging;->setConfig(Lcom/amazon/device/analytics/configuration/Configuration;)V

    .line 177
    return-void
.end method
