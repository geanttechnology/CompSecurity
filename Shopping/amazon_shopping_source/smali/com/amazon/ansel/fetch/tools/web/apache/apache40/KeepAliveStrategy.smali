.class public Lcom/amazon/ansel/fetch/tools/web/apache/apache40/KeepAliveStrategy;
.super Lorg/apache/http/impl/client/DefaultConnectionKeepAliveStrategy;
.source "KeepAliveStrategy.java"


# instance fields
.field private final timeout:J


# direct methods
.method public constructor <init>(J)V
    .locals 0
    .param p1, "timeout"    # J

    .prologue
    .line 21
    invoke-direct {p0}, Lorg/apache/http/impl/client/DefaultConnectionKeepAliveStrategy;-><init>()V

    .line 22
    iput-wide p1, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/KeepAliveStrategy;->timeout:J

    .line 23
    return-void
.end method


# virtual methods
.method public getKeepAliveDuration(Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)J
    .locals 6
    .param p1, "response"    # Lorg/apache/http/HttpResponse;
    .param p2, "context"    # Lorg/apache/http/protocol/HttpContext;

    .prologue
    const-wide/16 v4, -0x1

    .line 34
    invoke-super {p0, p1, p2}, Lorg/apache/http/impl/client/DefaultConnectionKeepAliveStrategy;->getKeepAliveDuration(Lorg/apache/http/HttpResponse;Lorg/apache/http/protocol/HttpContext;)J

    move-result-wide v0

    .line 36
    .local v0, "keepAlive":J
    cmp-long v2, v0, v4

    if-nez v2, :cond_1

    .line 37
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/KeepAliveStrategy;->timeout:J

    .line 44
    .end local v0    # "keepAlive":J
    :cond_0
    :goto_0
    return-wide v0

    .line 40
    .restart local v0    # "keepAlive":J
    :cond_1
    iget-wide v2, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/KeepAliveStrategy;->timeout:J

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    .line 44
    iget-wide v2, p0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/KeepAliveStrategy;->timeout:J

    invoke-static {v0, v1, v2, v3}, Ljava/lang/Math;->min(JJ)J

    move-result-wide v0

    goto :goto_0
.end method
