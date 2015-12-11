.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultHttpRoutePlanner;
.super Ljava/lang/Object;
.source "DefaultHttpRoutePlanner.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoutePlanner;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field protected final schemeRegistry:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)V
    .locals 2
    .param p1, "schreg"    # Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    .prologue
    .line 74
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 75
    if-nez p1, :cond_0

    .line 76
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "SchemeRegistry must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 79
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultHttpRoutePlanner;->schemeRegistry:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    .line 80
    return-void
.end method


# virtual methods
.method public determineRoute(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;)Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .locals 9
    .param p1, "target"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .param p2, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;
    .param p3, "context"    # Lcom/comcast/cim/httpcomponentsandroid/protocol/HttpContext;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/HttpException;
        }
    .end annotation

    .prologue
    .line 87
    if-nez p2, :cond_0

    .line 88
    new-instance v7, Ljava/lang/IllegalStateException;

    const-string v8, "Request must not be null."

    invoke-direct {v7, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 93
    :cond_0
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v7

    invoke-static {v7}, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->getForcedRoute(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v3

    .line 95
    .local v3, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    if-eqz v3, :cond_1

    move-object v4, v3

    .line 126
    .end local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .local v4, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    :goto_0
    return-object v4

    .line 101
    .end local v4    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .restart local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    :cond_1
    if-nez p1, :cond_2

    .line 102
    new-instance v7, Ljava/lang/IllegalStateException;

    const-string v8, "Target host must not be null."

    invoke-direct {v7, v8}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 106
    :cond_2
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v7

    invoke-static {v7}, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->getLocalAddress(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/InetAddress;

    move-result-object v1

    .line 108
    .local v1, "local":Ljava/net/InetAddress;
    invoke-interface {p2}, Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;->getParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v7

    invoke-static {v7}, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->getDefaultProxy(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    move-result-object v2

    .line 113
    .local v2, "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    :try_start_0
    iget-object v7, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultHttpRoutePlanner;->schemeRegistry:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->getSchemeName()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;->getScheme(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 119
    .local v5, "schm":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    invoke-virtual {v5}, Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;->isLayered()Z

    move-result v6

    .line 121
    .local v6, "secure":Z
    if-nez v2, :cond_3

    .line 122
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .end local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-direct {v3, p1, v1, v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/net/InetAddress;Z)V

    .restart local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    :goto_1
    move-object v4, v3

    .line 126
    .end local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .restart local v4    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    goto :goto_0

    .line 114
    .end local v4    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .end local v5    # "schm":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    .end local v6    # "secure":Z
    .restart local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    :catch_0
    move-exception v0

    .line 115
    .local v0, "ex":Ljava/lang/IllegalStateException;
    new-instance v7, Lcom/comcast/cim/httpcomponentsandroid/HttpException;

    invoke-virtual {v0}, Ljava/lang/IllegalStateException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v7, v8}, Lcom/comcast/cim/httpcomponentsandroid/HttpException;-><init>(Ljava/lang/String;)V

    throw v7

    .line 124
    .end local v0    # "ex":Ljava/lang/IllegalStateException;
    .restart local v5    # "schm":Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/Scheme;
    .restart local v6    # "secure":Z
    :cond_3
    new-instance v3, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .end local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    invoke-direct {v3, p1, v1, v2, v6}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Ljava/net/InetAddress;Lcom/comcast/cim/httpcomponentsandroid/HttpHost;Z)V

    .restart local v3    # "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    goto :goto_1
.end method
