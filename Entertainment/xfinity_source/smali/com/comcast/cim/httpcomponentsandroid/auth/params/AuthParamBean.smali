.class public Lcom/comcast/cim/httpcomponentsandroid/auth/params/AuthParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "AuthParamBean.java"


# virtual methods
.method public setCredentialCharset(Ljava/lang/String;)V
    .locals 1
    .param p1, "charset"    # Ljava/lang/String;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/auth/params/AuthParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-static {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/auth/params/AuthParams;->setCredentialCharset(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Ljava/lang/String;)V

    .line 48
    return-void
.end method
