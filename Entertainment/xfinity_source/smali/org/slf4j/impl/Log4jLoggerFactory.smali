.class public Lorg/slf4j/impl/Log4jLoggerFactory;
.super Ljava/lang/Object;
.source "Log4jLoggerFactory.java"

# interfaces
.implements Lorg/slf4j/ILoggerFactory;


# instance fields
.field loggerMap:Ljava/util/Map;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 46
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lorg/slf4j/impl/Log4jLoggerFactory;->loggerMap:Ljava/util/Map;

    .line 47
    return-void
.end method


# virtual methods
.method public getLogger(Ljava/lang/String;)Lorg/slf4j/Logger;
    .locals 5
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 55
    const/4 v2, 0x0

    .line 57
    .local v2, "slf4jLogger":Lorg/slf4j/Logger;
    monitor-enter p0

    .line 58
    :try_start_0
    iget-object v4, p0, Lorg/slf4j/impl/Log4jLoggerFactory;->loggerMap:Ljava/util/Map;

    invoke-interface {v4, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    move-object v0, v4

    check-cast v0, Lorg/slf4j/Logger;

    move-object v2, v0

    .line 59
    if-nez v2, :cond_0

    .line 61
    const-string v4, "ROOT"

    invoke-virtual {p1, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 62
    invoke-static {}, Lorg/apache/log4j/LogManager;->getRootLogger()Lorg/apache/log4j/Logger;

    move-result-object v1

    .line 66
    .local v1, "log4jLogger":Lorg/apache/log4j/Logger;
    :goto_0
    new-instance v3, Lorg/slf4j/impl/Log4jLoggerAdapter;

    invoke-direct {v3, v1}, Lorg/slf4j/impl/Log4jLoggerAdapter;-><init>(Lorg/apache/log4j/Logger;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 67
    .end local v2    # "slf4jLogger":Lorg/slf4j/Logger;
    .local v3, "slf4jLogger":Lorg/slf4j/Logger;
    :try_start_1
    iget-object v4, p0, Lorg/slf4j/impl/Log4jLoggerFactory;->loggerMap:Ljava/util/Map;

    invoke-interface {v4, p1, v3}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    move-object v2, v3

    .line 69
    .end local v1    # "log4jLogger":Lorg/apache/log4j/Logger;
    .end local v3    # "slf4jLogger":Lorg/slf4j/Logger;
    .restart local v2    # "slf4jLogger":Lorg/slf4j/Logger;
    :cond_0
    :try_start_2
    monitor-exit p0

    .line 70
    return-object v2

    .line 64
    :cond_1
    invoke-static {p1}, Lorg/apache/log4j/LogManager;->getLogger(Ljava/lang/String;)Lorg/apache/log4j/Logger;

    move-result-object v1

    .restart local v1    # "log4jLogger":Lorg/apache/log4j/Logger;
    goto :goto_0

    .line 69
    .end local v1    # "log4jLogger":Lorg/apache/log4j/Logger;
    :catchall_0
    move-exception v4

    :goto_1
    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v4

    .end local v2    # "slf4jLogger":Lorg/slf4j/Logger;
    .restart local v1    # "log4jLogger":Lorg/apache/log4j/Logger;
    .restart local v3    # "slf4jLogger":Lorg/slf4j/Logger;
    :catchall_1
    move-exception v4

    move-object v2, v3

    .end local v3    # "slf4jLogger":Lorg/slf4j/Logger;
    .restart local v2    # "slf4jLogger":Lorg/slf4j/Logger;
    goto :goto_1
.end method
