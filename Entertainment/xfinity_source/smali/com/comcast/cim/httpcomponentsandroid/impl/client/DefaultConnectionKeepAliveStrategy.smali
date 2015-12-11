.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/DefaultConnectionKeepAliveStrategy;
.super Ljava/lang/Object;
.source "DefaultConnectionKeepAliveStrategy.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionKeepAliveStrategy;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getKeepAliveDuration(Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)J
    .locals 8
    .param p1, "response"    # Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;
    .param p2, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;

    .prologue
    .line 52
    if-nez p1, :cond_0

    .line 53
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "HTTP response may not be null"

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 55
    :cond_0
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;

    const-string v4, "Keep-Alive"

    invoke-interface {p1, v4}, Lcom/comcast/cim/httpcomponentsandroid/HttpResponse;->headerIterator(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;

    move-result-object v4

    invoke-direct {v1, v4}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHeaderElementIterator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HeaderIterator;)V

    .line 57
    .local v1, "it":Lcom/comcast/cim/httpcomponentsandroid/HeaderElementIterator;
    :cond_1
    :goto_0
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElementIterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 58
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElementIterator;->nextElement()Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;

    move-result-object v0

    .line 59
    .local v0, "he":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getName()Ljava/lang/String;

    move-result-object v2

    .line 60
    .local v2, "param":Ljava/lang/String;
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;->getValue()Ljava/lang/String;

    move-result-object v3

    .line 61
    .local v3, "value":Ljava/lang/String;
    if-eqz v3, :cond_1

    const-string v4, "timeout"

    invoke-virtual {v2, v4}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 63
    :try_start_0
    invoke-static {v3}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    mul-long/2addr v4, v6

    .line 68
    .end local v0    # "he":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .end local v2    # "param":Ljava/lang/String;
    .end local v3    # "value":Ljava/lang/String;
    :goto_1
    return-wide v4

    :cond_2
    const-wide/16 v4, -0x1

    goto :goto_1

    .line 64
    .restart local v0    # "he":Lcom/comcast/cim/httpcomponentsandroid/HeaderElement;
    .restart local v2    # "param":Ljava/lang/String;
    .restart local v3    # "value":Ljava/lang/String;
    :catch_0
    move-exception v4

    goto :goto_0
.end method
