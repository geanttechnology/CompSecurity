.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;
.super Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;
.source "ClientParamsStack.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field protected final applicationParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

.field protected final clientParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

.field protected final overrideParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

.field protected final requestParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;)V
    .locals 0
    .param p1, "aparams"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p2, "cparams"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p3, "rparams"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .param p4, "oparams"    # Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .prologue
    .line 98
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/params/AbstractHttpParams;-><init>()V

    .line 99
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->applicationParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 100
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->clientParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 101
    iput-object p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->requestParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 102
    iput-object p4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->overrideParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    .line 103
    return-void
.end method


# virtual methods
.method public final getApplicationParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 150
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->applicationParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public final getClientParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->clientParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public final getOverrideParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 177
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->overrideParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public getParameter(Ljava/lang/String;)Ljava/lang/Object;
    .locals 3
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 191
    if-nez p1, :cond_0

    .line 192
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Parameter name must not be null."

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 196
    :cond_0
    const/4 v0, 0x0

    .line 198
    .local v0, "result":Ljava/lang/Object;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->overrideParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-eqz v1, :cond_1

    .line 199
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->overrideParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 201
    .end local v0    # "result":Ljava/lang/Object;
    :cond_1
    if-nez v0, :cond_2

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->requestParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-eqz v1, :cond_2

    .line 202
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->requestParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 204
    :cond_2
    if-nez v0, :cond_3

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->clientParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-eqz v1, :cond_3

    .line 205
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->clientParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 207
    :cond_3
    if-nez v0, :cond_4

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->applicationParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    if-eqz v1, :cond_4

    .line 208
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->applicationParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;->getParameter(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    .line 210
    :cond_4
    return-object v0
.end method

.method public final getRequestParams()Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 1

    .prologue
    .line 168
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/ClientParamsStack;->requestParams:Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;

    return-object v0
.end method

.method public setParameter(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/params/HttpParams;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/UnsupportedOperationException;
        }
    .end annotation

    .prologue
    .line 229
    new-instance v0, Ljava/lang/UnsupportedOperationException;

    const-string v1, "Setting parameters in a stack is not supported."

    invoke-direct {v0, v1}, Ljava/lang/UnsupportedOperationException;-><init>(Ljava/lang/String;)V

    throw v0
.end method
