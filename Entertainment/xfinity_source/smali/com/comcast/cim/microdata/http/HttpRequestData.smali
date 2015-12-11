.class public Lcom/comcast/cim/microdata/http/HttpRequestData;
.super Ljava/lang/Object;
.source "HttpRequestData.java"


# instance fields
.field private acceptContentType:Ljava/lang/String;

.field private body:Ljava/lang/String;

.field private method:Lcom/comcast/cim/microdata/http/HttpMethod;

.field private uri:Ljava/net/URI;


# virtual methods
.method public getAcceptContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->acceptContentType:Ljava/lang/String;

    return-object v0
.end method

.method public getBody()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->body:Ljava/lang/String;

    return-object v0
.end method

.method public getMethod()Lcom/comcast/cim/microdata/http/HttpMethod;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->method:Lcom/comcast/cim/microdata/http/HttpMethod;

    return-object v0
.end method

.method public getUri()Ljava/net/URI;
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->uri:Ljava/net/URI;

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 3

    .prologue
    .line 55
    new-instance v0, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    invoke-direct {v0, p0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;-><init>(Ljava/lang/Object;)V

    .line 56
    .local v0, "builder":Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;
    const-string v1, "uri"

    iget-object v2, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->uri:Ljava/net/URI;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 57
    const-string v1, "method"

    iget-object v2, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->method:Lcom/comcast/cim/microdata/http/HttpMethod;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 58
    const-string v1, "body"

    iget-object v2, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->body:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 59
    const-string v1, "acceptContentType"

    iget-object v2, p0, Lcom/comcast/cim/microdata/http/HttpRequestData;->acceptContentType:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->append(Ljava/lang/String;Ljava/lang/Object;)Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;

    .line 60
    invoke-virtual {v0}, Lcom/comcast/cim/microdata/util/SimpleToStringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method
