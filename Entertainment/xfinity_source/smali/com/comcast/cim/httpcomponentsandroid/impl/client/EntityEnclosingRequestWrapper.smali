.class public Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;
.source "EntityEnclosingRequestWrapper.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper$EntityWrapper;
    }
.end annotation


# instance fields
.field private consumed:Z

.field private entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;)V
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/ProtocolException;
        }
    .end annotation

    .prologue
    .line 63
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/RequestWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpRequest;)V

    .line 64
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 65
    return-void
.end method

.method static synthetic access$002(Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;
    .param p1, "x1"    # Z

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->consumed:Z

    return p1
.end method


# virtual methods
.method public expectContinue()Z
    .locals 3

    .prologue
    .line 77
    const-string v1, "Expect"

    invoke-virtual {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 78
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
    .line 68
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    return-object v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->isRepeatable()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->consumed:Z

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 1
    .param p1, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .prologue
    .line 72
    if-eqz p1, :cond_0

    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper$EntityWrapper;

    invoke-direct {v0, p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper$EntityWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    :goto_0
    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 73
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/client/EntityEnclosingRequestWrapper;->consumed:Z

    .line 74
    return-void

    .line 72
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
