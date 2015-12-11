.class public Lcom/comcast/cim/httpcomponentsandroid/cookie/params/CookieSpecParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "CookieSpecParamBean.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# virtual methods
.method public setDatePatterns(Ljava/util/Collection;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Collection",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 52
    .local p1, "patterns":Ljava/util/Collection;, "Ljava/util/Collection<Ljava/lang/String;>;"
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/cookie/params/CookieSpecParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.cookie-datepatterns"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 53
    return-void
.end method

.method public setSingleHeader(Z)V
    .locals 2
    .param p1, "singleHeader"    # Z

    .prologue
    .line 56
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/cookie/params/CookieSpecParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.protocol.single-cookie-header"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setBooleanParameter(Ljava/lang/String;Z)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 57
    return-void
.end method
