.class public final Lorg/apache/log4j/spi/NOPLogger;
.super Lorg/apache/log4j/Logger;
.source "NOPLogger.java"


# direct methods
.method public constructor <init>(Lorg/apache/log4j/spi/NOPLoggerRepository;Ljava/lang/String;)V
    .locals 1
    .param p1, "repo"    # Lorg/apache/log4j/spi/NOPLoggerRepository;
    .param p2, "name"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0, p2}, Lorg/apache/log4j/Logger;-><init>(Ljava/lang/String;)V

    .line 40
    iput-object p1, p0, Lorg/apache/log4j/Category;->repository:Lorg/apache/log4j/spi/LoggerRepository;

    .line 41
    sget-object v0, Lorg/apache/log4j/Level;->OFF:Lorg/apache/log4j/Level;

    iput-object v0, p0, Lorg/apache/log4j/Category;->level:Lorg/apache/log4j/Level;

    .line 42
    iput-object p0, p0, Lorg/apache/log4j/Category;->parent:Lorg/apache/log4j/Category;

    .line 43
    return-void
.end method


# virtual methods
.method public addAppender(Lorg/apache/log4j/Appender;)V
    .locals 0
    .param p1, "newAppender"    # Lorg/apache/log4j/Appender;

    .prologue
    .line 47
    return-void
.end method

.method public callAppenders(Lorg/apache/log4j/spi/LoggingEvent;)V
    .locals 0
    .param p1, "event"    # Lorg/apache/log4j/spi/LoggingEvent;

    .prologue
    .line 56
    return-void
.end method

.method closeNestedAppenders()V
    .locals 0

    .prologue
    .line 60
    return-void
.end method

.method public getAllAppenders()Ljava/util/Enumeration;
    .locals 1

    .prologue
    .line 91
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    invoke-virtual {v0}, Ljava/util/Vector;->elements()Ljava/util/Enumeration;

    move-result-object v0

    return-object v0
.end method

.method public getEffectiveLevel()Lorg/apache/log4j/Level;
    .locals 1

    .prologue
    .line 101
    sget-object v0, Lorg/apache/log4j/Level;->OFF:Lorg/apache/log4j/Level;

    return-object v0
.end method

.method public isDebugEnabled()Z
    .locals 1

    .prologue
    .line 130
    const/4 v0, 0x0

    return v0
.end method

.method public isEnabledFor(Lorg/apache/log4j/Priority;)Z
    .locals 1
    .param p1, "level"    # Lorg/apache/log4j/Priority;

    .prologue
    .line 135
    const/4 v0, 0x0

    return v0
.end method

.method public isInfoEnabled()Z
    .locals 1

    .prologue
    .line 140
    const/4 v0, 0x0

    return v0
.end method

.method public isTraceEnabled()Z
    .locals 1

    .prologue
    .line 208
    const/4 v0, 0x0

    return v0
.end method

.method public log(Ljava/lang/String;Lorg/apache/log4j/Priority;Ljava/lang/Object;Ljava/lang/Throwable;)V
    .locals 0
    .param p1, "callerFQCN"    # Ljava/lang/String;
    .param p2, "level"    # Lorg/apache/log4j/Priority;
    .param p3, "message"    # Ljava/lang/Object;
    .param p4, "t"    # Ljava/lang/Throwable;

    .prologue
    .line 162
    return-void
.end method

.method public removeAllAppenders()V
    .locals 0

    .prologue
    .line 166
    return-void
.end method

.method public setLevel(Lorg/apache/log4j/Level;)V
    .locals 0
    .param p1, "level"    # Lorg/apache/log4j/Level;

    .prologue
    .line 179
    return-void
.end method

.method public setResourceBundle(Ljava/util/ResourceBundle;)V
    .locals 0
    .param p1, "bundle"    # Ljava/util/ResourceBundle;

    .prologue
    .line 188
    return-void
.end method
