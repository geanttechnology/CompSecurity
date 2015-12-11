.class public final Lcom/comcast/cim/cmasl/utils/logging/Log4JConfiguratorForTests;
.super Ljava/lang/Object;
.source "Log4JConfiguratorForTests.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/utils/logging/Log4JConfigurator;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public configureLogging()V
    .locals 10

    .prologue
    .line 16
    invoke-static {}, Lorg/apache/log4j/Logger;->getRootLogger()Lorg/apache/log4j/Logger;

    move-result-object v7

    .line 17
    .local v7, "rootLogger":Lorg/apache/log4j/Logger;
    invoke-virtual {v7}, Lorg/apache/log4j/Logger;->getAllAppenders()Ljava/util/Enumeration;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 37
    :goto_0
    return-void

    .line 21
    :cond_0
    new-instance v0, Lorg/apache/log4j/ConsoleAppender;

    new-instance v8, Lorg/apache/log4j/PatternLayout;

    const-string v9, "%d{ABSOLUTE} %5p %c{1}:%L - %m%n"

    invoke-direct {v8, v9}, Lorg/apache/log4j/PatternLayout;-><init>(Ljava/lang/String;)V

    const-string v9, "System.out"

    invoke-direct {v0, v8, v9}, Lorg/apache/log4j/ConsoleAppender;-><init>(Lorg/apache/log4j/Layout;Ljava/lang/String;)V

    .line 23
    .local v0, "console":Lorg/apache/log4j/Appender;
    const-string v8, "console"

    invoke-interface {v0, v8}, Lorg/apache/log4j/Appender;->setName(Ljava/lang/String;)V

    .line 25
    invoke-virtual {v7, v0}, Lorg/apache/log4j/Logger;->addAppender(Lorg/apache/log4j/Appender;)V

    .line 26
    sget-object v8, Lorg/apache/log4j/Level;->INFO:Lorg/apache/log4j/Level;

    invoke-virtual {v7, v8}, Lorg/apache/log4j/Logger;->setLevel(Lorg/apache/log4j/Level;)V

    .line 28
    invoke-virtual {v7}, Lorg/apache/log4j/Logger;->getLoggerRepository()Lorg/apache/log4j/spi/LoggerRepository;

    move-result-object v6

    .line 29
    .local v6, "repository":Lorg/apache/log4j/spi/LoggerRepository;
    const-string v8, "com.comcast"

    const-string v9, "com.xfinity"

    invoke-static {v8, v9}, Lcom/comcast/cim/cmasl/utils/collections/CollectionUtils;->createList(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/List;

    move-result-object v1

    .line 30
    .local v1, "debugLoggerPatterns":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    .line 31
    .local v5, "pattern":Ljava/lang/String;
    invoke-interface {v6, v5}, Lorg/apache/log4j/spi/LoggerRepository;->getLogger(Ljava/lang/String;)Lorg/apache/log4j/Logger;

    move-result-object v4

    .line 32
    .local v4, "logger":Lorg/apache/log4j/Logger;
    sget-object v8, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    invoke-virtual {v4, v8}, Lorg/apache/log4j/Logger;->setLevel(Lorg/apache/log4j/Level;)V

    goto :goto_1

    .line 34
    .end local v4    # "logger":Lorg/apache/log4j/Logger;
    .end local v5    # "pattern":Ljava/lang/String;
    :cond_1
    const-string v8, "com.comcast.cim.httpcomponentsandroid"

    invoke-interface {v6, v8}, Lorg/apache/log4j/spi/LoggerRepository;->getLogger(Ljava/lang/String;)Lorg/apache/log4j/Logger;

    move-result-object v2

    .line 35
    .local v2, "httpLogger":Lorg/apache/log4j/Logger;
    sget-object v8, Lorg/apache/log4j/Level;->INFO:Lorg/apache/log4j/Level;

    invoke-virtual {v2, v8}, Lorg/apache/log4j/Logger;->setLevel(Lorg/apache/log4j/Level;)V

    goto :goto_0
.end method
