.class public Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpEntityEnclosingRequest;
.super Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;
.source "BasicHttpEntityEnclosingRequest.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;


# instance fields
.field private entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V
    .locals 0
    .param p1, "requestline"    # Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    .prologue
    .line 57
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpRequest;-><init>(Lcom/comcast/cim/httpcomponentsandroid/RequestLine;)V

    .line 58
    return-void
.end method


# virtual methods
.method public expectContinue()Z
    .locals 3

    .prologue
    .line 69
    const-string v1, "Expect"

    invoke-virtual {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpEntityEnclosingRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 70
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
    .line 61
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpEntityEnclosingRequest;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    return-object v0
.end method

.method public setEntity(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V
    .locals 0
    .param p1, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .prologue
    .line 65
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/message/BasicHttpEntityEnclosingRequest;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 66
    return-void
.end method
