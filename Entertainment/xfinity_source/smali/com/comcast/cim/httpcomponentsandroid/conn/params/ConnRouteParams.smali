.class public Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;
.super Ljava/lang/Object;
.source "ConnRouteParams.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRoutePNames;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/Immutable;
.end annotation


# static fields
.field public static final NO_HOST:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

.field public static final NO_ROUTE:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 51
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    const-string v1, "127.0.0.255"

    const/4 v2, 0x0

    const-string v3, "no-host"

    invoke-direct {v0, v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->NO_HOST:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 58
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->NO_HOST:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    invoke-direct {v0, v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)V

    sput-object v0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->NO_ROUTE:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 61
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 63
    return-void
.end method

.method public static getDefaultProxy(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    .locals 3
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 77
    if-nez p0, :cond_0

    .line 78
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parameters must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 80
    :cond_0
    const-string v1, "http.route.default-proxy"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .line 82
    .local v0, "proxy":Lcom/comcast/cim/httpcomponentsandroid/HttpHost;
    if-eqz v0, :cond_1

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->NO_HOST:Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpHost;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 84
    const/4 v0, 0x0

    .line 86
    :cond_1
    return-object v0
.end method

.method public static getForcedRoute(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .locals 3
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 119
    if-nez p0, :cond_0

    .line 120
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parameters must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 122
    :cond_0
    const-string v1, "http.route.forced-route"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .line 124
    .local v0, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    if-eqz v0, :cond_1

    sget-object v1, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParams;->NO_ROUTE:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    invoke-virtual {v1, v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 126
    const/4 v0, 0x0

    .line 128
    :cond_1
    return-object v0
.end method

.method public static getLocalAddress(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)Ljava/net/InetAddress;
    .locals 3
    .param p0, "params"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 162
    if-nez p0, :cond_0

    .line 163
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parameters must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 165
    :cond_0
    const-string v1, "http.route.local-address"

    invoke-interface {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/net/InetAddress;

    .line 168
    .local v0, "local":Ljava/net/InetAddress;
    return-object v0
.end method
