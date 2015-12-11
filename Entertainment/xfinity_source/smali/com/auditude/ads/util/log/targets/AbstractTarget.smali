.class public Lcom/auditude/ads/util/log/targets/AbstractTarget;
.super Ljava/lang/Object;
.source "AbstractTarget.java"

# interfaces
.implements Lcom/auditude/ads/util/event/IEventListener;
.implements Lcom/auditude/ads/util/log/targets/ILoggingTarget;


# instance fields
.field private level:Lcom/auditude/ads/util/log/LogLevel;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    sget-object v0, Lcom/auditude/ads/util/log/LogLevel;->ALL:Lcom/auditude/ads/util/log/LogLevel;

    iput-object v0, p0, Lcom/auditude/ads/util/log/targets/AbstractTarget;->level:Lcom/auditude/ads/util/log/LogLevel;

    .line 13
    return-void
.end method


# virtual methods
.method public addLogger(Lcom/auditude/ads/util/log/ILogger;)Lcom/auditude/ads/util/log/ILogger;
    .locals 1
    .param p1, "logger"    # Lcom/auditude/ads/util/log/ILogger;

    .prologue
    .line 73
    if-eqz p1, :cond_0

    .line 76
    const-string v0, "log"

    invoke-interface {p1, v0, p0}, Lcom/auditude/ads/util/log/ILogger;->addEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 79
    :cond_0
    return-object p1
.end method

.method public getLevel()Lcom/auditude/ads/util/log/LogLevel;
    .locals 1

    .prologue
    .line 52
    iget-object v0, p0, Lcom/auditude/ads/util/log/targets/AbstractTarget;->level:Lcom/auditude/ads/util/log/LogLevel;

    return-object v0
.end method

.method public logEvent(Lcom/auditude/ads/util/log/LogEvent;)V
    .locals 0
    .param p1, "event"    # Lcom/auditude/ads/util/log/LogEvent;

    .prologue
    .line 116
    return-void
.end method

.method public onEvent(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 3
    .param p1, "type"    # Ljava/lang/String;
    .param p2, "event"    # Ljava/lang/Object;

    .prologue
    .line 121
    const-string v1, "log"

    if-ne p1, v1, :cond_0

    instance-of v1, p2, Lcom/auditude/ads/util/log/LogEvent;

    if-eqz v1, :cond_0

    move-object v0, p2

    .line 123
    check-cast v0, Lcom/auditude/ads/util/log/LogEvent;

    .line 125
    .local v0, "logEvent":Lcom/auditude/ads/util/log/LogEvent;
    iget-object v1, v0, Lcom/auditude/ads/util/log/LogEvent;->level:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v1}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v1

    iget-object v2, p0, Lcom/auditude/ads/util/log/targets/AbstractTarget;->level:Lcom/auditude/ads/util/log/LogLevel;

    invoke-virtual {v2}, Lcom/auditude/ads/util/log/LogLevel;->getVerbosity()I

    move-result v2

    if-lt v1, v2, :cond_0

    invoke-virtual {p0, v0}, Lcom/auditude/ads/util/log/targets/AbstractTarget;->logEvent(Lcom/auditude/ads/util/log/LogEvent;)V

    .line 127
    .end local v0    # "logEvent":Lcom/auditude/ads/util/log/LogEvent;
    :cond_0
    return-void
.end method

.method public removeLogger(Lcom/auditude/ads/util/log/ILogger;)V
    .locals 1
    .param p1, "logger"    # Lcom/auditude/ads/util/log/ILogger;

    .prologue
    .line 89
    if-eqz p1, :cond_0

    .line 92
    const-string v0, "log"

    invoke-interface {p1, v0, p0}, Lcom/auditude/ads/util/log/ILogger;->removeEventListener(Ljava/lang/String;Lcom/auditude/ads/util/event/IEventListener;)V

    .line 94
    :cond_0
    return-void
.end method

.method public setLevel(Lcom/auditude/ads/util/log/LogLevel;)V
    .locals 0
    .param p1, "value"    # Lcom/auditude/ads/util/log/LogLevel;

    .prologue
    .line 60
    invoke-static {p0}, Lcom/auditude/ads/util/log/Log;->removeTarget(Lcom/auditude/ads/util/log/targets/ILoggingTarget;)V

    .line 61
    iput-object p1, p0, Lcom/auditude/ads/util/log/targets/AbstractTarget;->level:Lcom/auditude/ads/util/log/LogLevel;

    .line 62
    invoke-static {p0}, Lcom/auditude/ads/util/log/Log;->addTarget(Lcom/auditude/ads/util/log/targets/ILoggingTarget;)V

    .line 63
    return-void
.end method
