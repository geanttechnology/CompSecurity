.class public abstract Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;
.super Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;
.source "HttpEntityEnclosingRequestBase.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field private entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;-><init>()V

    .line 52
    return-void
.end method


# virtual methods
.method public clone()Ljava/lang/Object;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    .prologue
    .line 69
    invoke-super {p0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpRequestBase;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;

    .line 71
    .local v0, "clone":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    if-eqz v1, :cond_0

    .line 72
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-static {v1}, Lcom/comcast/cim/httpcomponentsandroid/client/utils/CloneUtils;->clone(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    iput-object v1, v0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 74
    :cond_0
    return-object v0
.end method

.method public expectContinue()Z
    .locals 3

    .prologue
    .line 63
    const-string v1, "Expect"

    invoke-virtual {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 64
    .local v0, "expect":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_0

    const-string v1, "100-continue"

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    return-object v0
.end method

.method public setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 0
    .param p1, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpEntityEnclosingRequestBase;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 60
    return-void
.end method
