.class public Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;
.super Ljava/lang/Object;
.source "HttpRequestAdapter.java"

# interfaces
.implements Loauth/signpost/http/HttpRequest;


# instance fields
.field private entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

.field private request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;)V
    .locals 1
    .param p1, "request"    # Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    iput-object p1, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    .line 21
    instance-of v0, p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    if-eqz v0, :cond_0

    .line 22
    check-cast p1, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;

    .end local p1    # "request":Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntityEnclosingRequest;->getEntity()Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    .line 24
    :cond_0
    return-void
.end method


# virtual methods
.method public getAllHeaders()Ljava/util/Map;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 51
    iget-object v6, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-interface {v6}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getAllHeaders()[Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v5

    .line 52
    .local v5, "origHeaders":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 53
    .local v2, "headers":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    move-object v0, v5

    .local v0, "arr$":[Lcom/comcast/cim/httpcomponentsandroid/Header;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v1, v0, v3

    .line 54
    .local v1, "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v6, v7}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 53
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 56
    .end local v1    # "h":Lcom/comcast/cim/httpcomponentsandroid/Header;
    :cond_0
    return-object v2
.end method

.method public getContentType()Ljava/lang/String;
    .locals 3

    .prologue
    const/4 v1, 0x0

    .line 60
    iget-object v2, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    if-nez v2, :cond_1

    .line 67
    :cond_0
    :goto_0
    return-object v1

    .line 63
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v2}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContentType()Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 64
    .local v0, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-eqz v0, :cond_0

    .line 67
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getHeader(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 39
    iget-object v1, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-interface {v1, p1}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getFirstHeader(Ljava/lang/String;)Lcom/comcast/cim/httpcomponentsandroid/Header;

    move-result-object v0

    .line 40
    .local v0, "header":Lcom/comcast/cim/httpcomponentsandroid/Header;
    if-nez v0, :cond_0

    .line 41
    const/4 v1, 0x0

    .line 43
    :goto_0
    return-object v1

    :cond_0
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/Header;->getValue()Ljava/lang/String;

    move-result-object v1

    goto :goto_0
.end method

.method public getMessagePayload()Ljava/io/InputStream;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 71
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    if-nez v0, :cond_0

    .line 72
    const/4 v0, 0x0

    .line 74
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->entity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v0

    goto :goto_0
.end method

.method public getMethod()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getRequestLine()Lcom/comcast/cim/httpcomponentsandroid/RequestLine;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/RequestLine;->getMethod()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getRequestUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->getURI()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public setHeader(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/comcast/cim/oauth/signpost/commonshttpandroid/HttpRequestAdapter;->request:Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;

    invoke-interface {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;->setHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 48
    return-void
.end method

.method public setRequestUrl(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 35
    new-instance v0, Ljava/lang/RuntimeException;

    new-instance v1, Ljava/lang/UnsupportedOperationException;

    invoke-direct {v1}, Ljava/lang/UnsupportedOperationException;-><init>()V

    invoke-direct {v0, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v0
.end method
