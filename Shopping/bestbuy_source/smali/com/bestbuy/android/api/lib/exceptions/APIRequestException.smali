.class public Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;
.super Ljava/lang/Exception;
.source "SourceFile"


# instance fields
.field private response:Lorg/apache/http/HttpResponse;

.field private responseBody:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lorg/apache/http/HttpResponse;)V
    .locals 0

    .prologue
    .line 13
    invoke-direct {p0}, Ljava/lang/Exception;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->response:Lorg/apache/http/HttpResponse;

    .line 15
    return-void
.end method


# virtual methods
.method public getReasonPhrase()Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->response:Lorg/apache/http/HttpResponse;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getResponse()Lorg/apache/http/HttpResponse;
    .locals 1

    .prologue
    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->response:Lorg/apache/http/HttpResponse;

    return-object v0
.end method

.method public getResponseBody()Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->responseBody:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 19
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->response:Lorg/apache/http/HttpResponse;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/http/util/EntityUtils;->toString(Lorg/apache/http/HttpEntity;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->responseBody:Ljava/lang/String;

    .line 21
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->responseBody:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 24
    :goto_0
    return-object v0

    .line 22
    :catch_0
    move-exception v0

    .line 24
    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getStatusCode()I
    .locals 1

    .prologue
    .line 42
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->response:Lorg/apache/http/HttpResponse;

    invoke-interface {v0}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v0

    invoke-interface {v0}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v0

    return v0
.end method

.method public responseJSON()Lorg/json/JSONObject;
    .locals 2

    .prologue
    .line 29
    iget-object v0, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->responseBody:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 30
    invoke-virtual {p0}, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->getResponseBody()Ljava/lang/String;

    .line 33
    :cond_0
    :try_start_0
    new-instance v0, Lorg/json/JSONObject;

    iget-object v1, p0, Lcom/bestbuy/android/api/lib/exceptions/APIRequestException;->responseBody:Ljava/lang/String;

    invoke-direct {v0, v1}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 36
    :goto_0
    return-object v0

    .line 34
    :catch_0
    move-exception v0

    .line 36
    const/4 v0, 0x0

    goto :goto_0
.end method
