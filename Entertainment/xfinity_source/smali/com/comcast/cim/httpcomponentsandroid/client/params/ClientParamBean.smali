.class public Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "ClientParamBean.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# virtual methods
.method public setAllowCircularRedirects(Z)V
    .locals 2
    .param p1, "allow"    # Z

    .prologue
    .line 76
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.allow-circular-redirects"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 77
    return-void
.end method

.method public setConnectionManagerFactory(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;)V
    .locals 2
    .param p1, "factory"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManagerFactory;
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 60
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.connection-manager.factory-object"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 61
    return-void
.end method

.method public setConnectionManagerFactoryClassName(Ljava/lang/String;)V
    .locals 2
    .param p1, "factory"    # Ljava/lang/String;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.connection-manager.factory-class-name"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 56
    return-void
.end method

.method public setCookiePolicy(Ljava/lang/String;)V
    .locals 2
    .param p1, "policy"    # Ljava/lang/String;

    .prologue
    .line 84
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.cookie-policy"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 85
    return-void
.end method

.method public setDefaultHeaders(Ljava/util/Collection;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/Header;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 92
    .local p1, "headers":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/comcast/cim/httpcomponentsandroid/Header;>;"
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.default-headers"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 93
    return-void
.end method

.method public setDefaultHost(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)V
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.default-host"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 97
    return-void
.end method

.method public setHandleAuthentication(Z)V
    .locals 2
    .param p1, "handle"    # Z

    .prologue
    .line 80
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.handle-authentication"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 81
    return-void
.end method

.method public setHandleRedirects(Z)V
    .locals 2
    .param p1, "handle"    # Z

    .prologue
    .line 64
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.handle-redirects"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 65
    return-void
.end method

.method public setMaxRedirects(I)V
    .locals 2
    .param p1, "maxRedirects"    # I

    .prologue
    .line 72
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.max-redirects"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setIntParameter(Ljava/lang/String;I)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 73
    return-void
.end method

.method public setRejectRelativeRedirect(Z)V
    .locals 2
    .param p1, "reject"    # Z

    .prologue
    .line 68
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.reject-relative-redirect"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 69
    return-void
.end method

.method public setVirtualHost(Lcom/comcast/cim/httpcomponentsandroid/HttpHost;)V
    .locals 2
    .param p1, "host"    # Lcom/comcast/cim/httpcomponentsandroid/HttpHost;

    .prologue
    .line 88
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/params/ClientParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.virtual-host"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 89
    return-void
.end method
