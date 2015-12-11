.class public Lcom/auditude/ads/util/log/LogLogger;
.super Lcom/auditude/ads/util/event/EventDispatcher;
.source "LogLogger.java"

# interfaces
.implements Lcom/auditude/ads/util/log/ILogger;


# instance fields
.field private category:Ljava/lang/String;


# direct methods
.method public constructor <init>(Ljava/lang/String;)V
    .locals 0
    .param p1, "category"    # Ljava/lang/String;

    .prologue
    .line 10
    invoke-direct {p0}, Lcom/auditude/ads/util/event/EventDispatcher;-><init>()V

    .line 12
    iput-object p1, p0, Lcom/auditude/ads/util/log/LogLogger;->category:Ljava/lang/String;

    .line 13
    return-void
.end method

.method private getLogData(Ljava/lang/Object;)Ljava/lang/String;
    .locals 1
    .param p1, "msg"    # Ljava/lang/Object;

    .prologue
    .line 86
    if-nez p1, :cond_0

    const-string p1, ""

    .line 88
    .end local p1    # "msg":Ljava/lang/Object;
    :goto_0
    return-object p1

    .line 87
    .restart local p1    # "msg":Ljava/lang/Object;
    :cond_0
    instance-of v0, p1, Ljava/lang/String;

    if-eqz v0, :cond_1

    check-cast p1, Ljava/lang/String;

    goto :goto_0

    .line 88
    :cond_1
    invoke-virtual {p1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object p1

    goto :goto_0
.end method


# virtual methods
.method public getCategory()Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Lcom/auditude/ads/util/log/LogLogger;->category:Ljava/lang/String;

    return-object v0
.end method

.method public info(Ljava/lang/Object;)V
    .locals 4
    .param p1, "msg"    # Ljava/lang/Object;

    .prologue
    .line 73
    const-string v0, "log"

    new-instance v1, Lcom/auditude/ads/util/log/LogEvent;

    invoke-direct {p0, p1}, Lcom/auditude/ads/util/log/LogLogger;->getLogData(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/auditude/ads/util/log/LogLevel;->INFO:Lcom/auditude/ads/util/log/LogLevel;

    invoke-direct {v1, p0, v2, v3}, Lcom/auditude/ads/util/log/LogEvent;-><init>(Lcom/auditude/ads/util/event/IEventDispatcher;Ljava/lang/Object;Lcom/auditude/ads/util/log/LogLevel;)V

    invoke-virtual {p0, v0, v1}, Lcom/auditude/ads/util/log/LogLogger;->dispatchEvent(Ljava/lang/String;Ljava/lang/Object;)V

    .line 74
    return-void
.end method
