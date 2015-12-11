.class public Lcom/xfinity/playerlib/PlayNowLog4JConfigurator;
.super Ljava/lang/Object;
.source "PlayNowLog4JConfigurator.java"

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
    .locals 6

    .prologue
    .line 17
    new-instance v2, Lde/mindpipe/android/logging/log4j/LogConfigurator;

    invoke-direct {v2}, Lde/mindpipe/android/logging/log4j/LogConfigurator;-><init>()V

    .line 18
    .local v2, "logConfigurator":Lde/mindpipe/android/logging/log4j/LogConfigurator;
    sget-object v4, Lorg/apache/log4j/Level;->DEBUG:Lorg/apache/log4j/Level;

    invoke-virtual {v2, v4}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->setRootLevel(Lorg/apache/log4j/Level;)V

    .line 19
    const/4 v4, 0x0

    invoke-virtual {v2, v4}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->setUseFileAppender(Z)V

    .line 20
    invoke-virtual {v2}, Lde/mindpipe/android/logging/log4j/LogConfigurator;->configure()V

    .line 23
    invoke-static {}, Lorg/apache/log4j/Logger;->getRootLogger()Lorg/apache/log4j/Logger;

    move-result-object v3

    .line 24
    .local v3, "logger":Lorg/apache/log4j/Logger;
    invoke-virtual {v3}, Lorg/apache/log4j/Logger;->getAllAppenders()Ljava/util/Enumeration;

    move-result-object v1

    .line 25
    .local v1, "appenders":Ljava/util/Enumeration;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Enumeration;->hasMoreElements()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 26
    invoke-interface {v1}, Ljava/util/Enumeration;->nextElement()Ljava/lang/Object;

    move-result-object v0

    .line 27
    .local v0, "appender":Ljava/lang/Object;
    instance-of v4, v0, Lde/mindpipe/android/logging/log4j/LogCatAppender;

    if-eqz v4, :cond_0

    .line 28
    check-cast v0, Lde/mindpipe/android/logging/log4j/LogCatAppender;

    .end local v0    # "appender":Ljava/lang/Object;
    new-instance v4, Lorg/apache/log4j/PatternLayout;

    const-string v5, "PNA:%c{1}:%t"

    invoke-direct {v4, v5}, Lorg/apache/log4j/PatternLayout;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, v4}, Lde/mindpipe/android/logging/log4j/LogCatAppender;->setTagLayout(Lorg/apache/log4j/Layout;)V

    goto :goto_0

    .line 31
    :cond_1
    return-void
.end method
