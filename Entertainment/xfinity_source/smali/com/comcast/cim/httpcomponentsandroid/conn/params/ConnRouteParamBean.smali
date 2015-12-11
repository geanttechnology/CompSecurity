.class public Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "ConnRouteParamBean.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# virtual methods
.method public setDefaultProxy(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)V
    .locals 2
    .param p1, "defaultProxy"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.route.default-proxy"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 56
    return-void
.end method

.method public setForcedRoute(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V
    .locals 2
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .prologue
    .line 65
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.route.forced-route"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 66
    return-void
.end method

.method public setLocalAddress(Ljava/net/InetAddress;)V
    .locals 2
    .param p1, "address"    # Ljava/net/InetAddress;

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnRouteParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.route.local-address"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 61
    return-void
.end method
