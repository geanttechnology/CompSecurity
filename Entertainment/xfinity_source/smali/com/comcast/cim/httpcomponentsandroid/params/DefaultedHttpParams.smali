.class public final Lcom/comcast/cim/httpcomponentsandroid/params/DefaultedHttpParams;
.super Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;
.source "DefaultedHttpParams.java"


# instance fields
.field private final defaults:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

.field private final local:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;


# virtual methods
.method public getDefaults()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 102
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/DefaultedHttpParams;->defaults:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 74
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/params/DefaultedHttpParams;->local:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 75
    .local v0, "obj":Ljava/lang/Object;
    if-nez v0, :cond_0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/params/DefaultedHttpParams;->defaults:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-eqz v1, :cond_0

    .line 76
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/params/DefaultedHttpParams;->defaults:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 78
    :cond_0
    return-object v0
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/params/DefaultedHttpParams;->local:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    move-result-object v0

    return-object v0
.end method
