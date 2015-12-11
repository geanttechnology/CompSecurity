.class public Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "HttpProtocolParamBean.java"


# virtual methods
.method public setContentCharset(Ljava/lang/String;)V
    .locals 1
    .param p1, "contentCharset"    # Ljava/lang/String;

    .prologue
    .line 50
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setContentCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V

    .line 51
    return-void
.end method

.method public setHttpElementCharset(Ljava/lang/String;)V
    .locals 1
    .param p1, "httpElementCharset"    # Ljava/lang/String;

    .prologue
    .line 46
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setHttpElementCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V

    .line 47
    return-void
.end method

.method public setUseExpectContinue(Z)V
    .locals 1
    .param p1, "useExpectContinue"    # Z

    .prologue
    .line 62
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setUseExpectContinue(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Z)V

    .line 63
    return-void
.end method

.method public setUserAgent(Ljava/lang/String;)V
    .locals 1
    .param p1, "userAgent"    # Ljava/lang/String;

    .prologue
    .line 58
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setUserAgent(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V

    .line 59
    return-void
.end method

.method public setVersion(Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;)V
    .locals 1
    .param p1, "version"    # Lcom/comcast/cim/httpcomponentsandroid/HttpVersion;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpProtocolParams;->setVersion(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/ProtocolVersion;)V

    .line 55
    return-void
.end method
