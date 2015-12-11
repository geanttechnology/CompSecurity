.class public Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnConnectionParamBean;
.super Lcom/comcast/cim/httpcomponentsandroid/params/HttpAbstractParamBean;
.source "ConnConnectionParamBean.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# virtual methods
.method public setMaxStatusLineGarbage(I)V
    .locals 2
    .param p1, "maxStatusLineGarbage"    # I

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnConnectionParamBean;->params:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    const-string v1, "http.connection.max-status-line-garbage"

    invoke-interface {v0, v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setIntParameter(Ljava/lang/String;I)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 54
    return-void
.end method
