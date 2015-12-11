.class public Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "HttpConnectionParamBean.java"


# virtual methods
.method public setConnectionTimeout(I)V
    .locals 1
    .param p1, "connectionTimeout"    # I

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setConnectionTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 61
    return-void
.end method

.method public setLinger(I)V
    .locals 1
    .param p1, "linger"    # I

    .prologue
    .line 56
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setLinger(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 57
    return-void
.end method

.method public setSoTimeout(I)V
    .locals 1
    .param p1, "soTimeout"    # I

    .prologue
    .line 44
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setSoTimeout(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 45
    return-void
.end method

.method public setSocketBufferSize(I)V
    .locals 1
    .param p1, "socketBufferSize"    # I

    .prologue
    .line 52
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setSocketBufferSize(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;I)V

    .line 53
    return-void
.end method

.method public setStaleCheckingEnabled(Z)V
    .locals 1
    .param p1, "staleCheckingEnabled"    # Z

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setStaleCheckingEnabled(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Z)V

    .line 65
    return-void
.end method

.method public setTcpNoDelay(Z)V
    .locals 1
    .param p1, "tcpNoDelay"    # Z

    .prologue
    .line 48
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpConnectionParams;->setTcpNoDelay(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Z)V

    .line 49
    return-void
.end method
