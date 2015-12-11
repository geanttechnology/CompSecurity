.class public Lcom/comcast/cim/microdata/http/HttpResponseData;
.super Ljava/lang/Object;
.source "HttpResponseData.java"


# instance fields
.field private final baseUrl:Ljava/lang/String;

.field private final content:Ljava/lang/String;

.field private final contentType:Ljava/lang/String;

.field private final statusCode:I


# virtual methods
.method public getBaseUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/HttpResponseData;->baseUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getContent()Ljava/lang/String;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/HttpResponseData;->content:Ljava/lang/String;

    return-object v0
.end method

.method public getContentType()Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/comcast/cim/microdata/http/HttpResponseData;->contentType:Ljava/lang/String;

    return-object v0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 35
    iget v0, p0, Lcom/comcast/cim/microdata/http/HttpResponseData;->statusCode:I

    return v0
.end method
