.class public Lcom/amazon/device/analytics/log/Logger;
.super Ljava/lang/Object;
.source "Logger.java"

# interfaces
.implements Lcom/amazon/device/analytics/configuration/ConfigurationChangedListener;


# instance fields
.field private classLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field private cls:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private globalLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

.field private tag:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/amazon/device/analytics/log/LoggerBuilder;)V
    .locals 2
    .param p1, "builder"    # Lcom/amazon/device/analytics/log/LoggerBuilder;

    .prologue
    const/4 v1, 0x0

    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 16
    iput-object v1, p0, Lcom/amazon/device/analytics/log/Logger;->classLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 17
    sget-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->OFF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->globalLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 18
    iput-object v1, p0, Lcom/amazon/device/analytics/log/Logger;->cls:Ljava/lang/Class;

    .line 19
    const-string/jumbo v0, "TailwindAnalyticsSDK"

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->tag:Ljava/lang/String;

    .line 22
    if-eqz p1, :cond_0

    .line 23
    invoke-virtual {p1}, Lcom/amazon/device/analytics/log/LoggerBuilder;->getGlobalLogLevel()Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->globalLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 24
    invoke-virtual {p1}, Lcom/amazon/device/analytics/log/LoggerBuilder;->getLogClass()Ljava/lang/Class;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->cls:Ljava/lang/Class;

    .line 25
    invoke-virtual {p1}, Lcom/amazon/device/analytics/log/LoggerBuilder;->getTag()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->tag:Ljava/lang/String;

    .line 27
    :cond_0
    return-void
.end method

.method private buildMessage(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 86
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v8

    if-nez v8, :cond_0

    .line 113
    .end local p1    # "msg":Ljava/lang/String;
    :goto_0
    return-object p1

    .line 89
    .restart local p1    # "msg":Ljava/lang/String;
    :cond_0
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Thread;->getStackTrace()[Ljava/lang/StackTraceElement;

    move-result-object v7

    .line 90
    .local v7, "stackTraceElements":[Ljava/lang/StackTraceElement;
    const/4 v6, 0x0

    .line 91
    .local v6, "methodName":Ljava/lang/String;
    const/4 v5, 0x0

    .line 92
    .local v5, "lineNumber":I
    const/4 v2, 0x0

    .line 93
    .local v2, "foundClass":Z
    move-object v0, v7

    .local v0, "arr$":[Ljava/lang/StackTraceElement;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_1
    if-ge v3, v4, :cond_1

    aget-object v1, v0, v3

    .line 94
    .local v1, "element":Ljava/lang/StackTraceElement;
    if-eqz v2, :cond_2

    .line 95
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 96
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v6

    .line 97
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v5

    .line 110
    .end local v1    # "element":Ljava/lang/StackTraceElement;
    :cond_1
    if-eqz v6, :cond_4

    .line 111
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "#"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "("

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, "): "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0

    .line 101
    .restart local v1    # "element":Ljava/lang/StackTraceElement;
    :cond_2
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getClassName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_3

    .line 102
    const/4 v2, 0x1

    .line 103
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getMethodName()Ljava/lang/String;

    move-result-object v6

    .line 104
    invoke-virtual {v1}, Ljava/lang/StackTraceElement;->getLineNumber()I

    move-result v5

    .line 105
    const-string/jumbo v8, "v"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_3

    const-string/jumbo v8, "d"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_3

    const-string/jumbo v8, "i"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_3

    const-string/jumbo v8, "w"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_3

    const-string/jumbo v8, "e"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-nez v8, :cond_3

    const-string/jumbo v8, "wtf"

    invoke-virtual {v6, v8}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 93
    :cond_3
    add-int/lit8 v3, v3, 0x1

    goto/16 :goto_1

    .line 113
    .end local v1    # "element":Ljava/lang/StackTraceElement;
    :cond_4
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, ": "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object p1

    goto/16 :goto_0
.end method

.method static getLogLevelConfigurationKey(Ljava/lang/Class;)Ljava/lang/String;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 255
    .local p0, "cls":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    if-eqz p0, :cond_0

    .line 256
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ".logLevel"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/analytics/util/StringUtil;->ionEscape(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 258
    :goto_0
    return-object v0

    :cond_0
    const-string/jumbo v0, "loglevel"

    goto :goto_0
.end method


# virtual methods
.method public d(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 122
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->DEBUG:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 123
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 124
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 127
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method public d(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 135
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->DEBUG:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 136
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 137
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3, p2}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 140
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method public e(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 234
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->ERROR:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 235
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 236
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    iget-object v2, p0, Lcom/amazon/device/analytics/log/Logger;->tag:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 239
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method public e(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 247
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->ERROR:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 248
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 249
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    iget-object v2, p0, Lcom/amazon/device/analytics/log/Logger;->tag:Ljava/lang/String;

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3, p2}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 252
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method getAppenders()Ljava/util/Collection;
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
    .line 69
    invoke-static {}, Lcom/amazon/device/analytics/log/Logging;->getLogAppenders()Ljava/util/Collection;

    move-result-object v0

    return-object v0
.end method

.method getLogClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 73
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->cls:Ljava/lang/Class;

    return-object v0
.end method

.method declared-synchronized getLogLevel()Lcom/amazon/device/analytics/log/Logging$LogLevel;
    .locals 2

    .prologue
    .line 43
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/amazon/device/analytics/log/Logging$LogLevel;->OFF:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .line 44
    .local v0, "level":Lcom/amazon/device/analytics/log/Logging$LogLevel;
    iget-object v1, p0, Lcom/amazon/device/analytics/log/Logger;->classLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    if-eqz v1, :cond_1

    .line 45
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->classLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 49
    :cond_0
    :goto_0
    monitor-exit p0

    return-object v0

    .line 46
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/amazon/device/analytics/log/Logger;->globalLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    if-eqz v1, :cond_0

    .line 47
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->globalLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 43
    .end local v0    # "level":Lcom/amazon/device/analytics/log/Logging$LogLevel;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method getTag()Ljava/lang/String;
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/device/analytics/log/Logger;->tag:Ljava/lang/String;

    return-object v0
.end method

.method public i(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 172
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->INFO:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 173
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 174
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 177
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method public declared-synchronized isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z
    .locals 2
    .param p1, "requestedLevel"    # Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .prologue
    .line 35
    monitor-enter p0

    const/4 v0, 0x0

    .line 36
    .local v0, "isEnabled":Z
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getLogLevel()Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->compareTo(Ljava/lang/Enum;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v1

    if-ltz v1, :cond_0

    .line 37
    const/4 v0, 0x1

    .line 39
    :cond_0
    monitor-exit p0

    return v0

    .line 35
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method public onPropertyChanged(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "propertyName"    # Ljava/lang/String;
    .param p2, "propertyValue"    # Ljava/lang/Object;

    .prologue
    .line 264
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getLogClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logger;->getLogLevelConfigurationKey(Ljava/lang/Class;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 266
    :try_start_0
    invoke-virtual {p2}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/analytics/log/Logging$LogLevel;->valueOf(Ljava/lang/String;)Lcom/amazon/device/analytics/log/Logging$LogLevel;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/analytics/log/Logger;->setLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 270
    :cond_0
    :goto_0
    return-void

    .line 267
    :catch_0
    move-exception v0

    goto :goto_0
.end method

.method declared-synchronized setGlobalLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)V
    .locals 1
    .param p1, "requestedLevel"    # Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .prologue
    .line 65
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/device/analytics/log/Logger;->globalLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 66
    monitor-exit p0

    return-void

    .line 65
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setLogLevel(Lcom/amazon/device/analytics/log/Logging$LogLevel;)V
    .locals 1
    .param p1, "requestedLevel"    # Lcom/amazon/device/analytics/log/Logging$LogLevel;

    .prologue
    .line 57
    monitor-enter p0

    :try_start_0
    iput-object p1, p0, Lcom/amazon/device/analytics/log/Logger;->classLevel:Lcom/amazon/device/analytics/log/Logging$LogLevel;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 58
    monitor-exit p0

    return-void

    .line 57
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public v(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 147
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->VERBOSE:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 148
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 149
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->v(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 152
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method public w(Ljava/lang/String;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 197
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WARN:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 198
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 199
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 202
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method

.method public w(Ljava/lang/String;Ljava/lang/Throwable;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/String;
    .param p2, "tr"    # Ljava/lang/Throwable;

    .prologue
    .line 222
    sget-object v2, Lcom/amazon/device/analytics/log/Logging$LogLevel;->WARN:Lcom/amazon/device/analytics/log/Logging$LogLevel;

    invoke-virtual {p0, v2}, Lcom/amazon/device/analytics/log/Logger;->isLoggingEnabled(Lcom/amazon/device/analytics/log/Logging$LogLevel;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 223
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getAppenders()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/analytics/log/appenders/LogAppender;

    .line 224
    .local v0, "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    invoke-virtual {p0}, Lcom/amazon/device/analytics/log/Logger;->getTag()Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, p1}, Lcom/amazon/device/analytics/log/Logger;->buildMessage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3, p2}, Lcom/amazon/device/analytics/log/appenders/LogAppender;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 227
    .end local v0    # "appender":Lcom/amazon/device/analytics/log/appenders/LogAppender;
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    return-void
.end method
