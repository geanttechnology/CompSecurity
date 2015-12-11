.class public Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "ConnManagerParamBean.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation

.annotation runtime Ljava/lang/Deprecated;
.end annotation


# virtual methods
.method public setConnectionsPerRoute(Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRouteBean;)V
    .locals 2
    .param p1, "connPerRoute"    # Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRouteBean;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 63
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.conn-manager.max-per-route"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 64
    return-void
.end method

.method public setMaxTotalConnections(I)V
    .locals 2
    .param p1, "maxConnections"    # I
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 57
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.conn-manager.max-total"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setIntParameter(Ljava/lang/String;I)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 58
    return-void
.end method

.method public setTimeout(J)V
    .locals 3
    .param p1, "timeout"    # J

    .prologue
    .line 51
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnManagerParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.conn-manager.timeout"

    invoke-interface {v0, v1, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setLongParameter(Ljava/lang/String;J)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 52
    return-void
.end method
