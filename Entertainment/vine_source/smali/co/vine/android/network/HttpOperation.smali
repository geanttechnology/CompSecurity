.class public Lco/vine/android/network/HttpOperation;
.super Ljava/lang/Object;
.source "HttpOperation.java"


# static fields
.field private static final DEFAULT_AUTH_RETRIES:I = 0x1

.field private static final DEFAULT_READER:Lco/vine/android/network/HttpOperationReader;

.field public static final DEFAULT_RETRIES:I = 0x0

.field private static final EMPTY_RESULTS:[Lco/vine/android/network/HttpResult;

.field public static final FORM_URLENCODED_HEADER:Ljava/lang/String; = "application/x-www-form-urlencoded"

.field private static final HEADER_DATE:Ljava/lang/String; = "Date"

.field public static final HIGH_PRIORITY_RETRIES:I = 0x1

.field public static final HTTP_MULTIPLE_REDIRECT:I = 0x12c

.field public static final HTTP_OK:I = 0xc8

.field private static final LOGGABLE:Z

.field public static RATE_LIMIT_BYTES_PER_MS:D = 0.0

.field private static final TAG:Ljava/lang/String; = "HttpOperation"

.field public static final USER_AGENT_STRING:Ljava/lang/String;

.field private static final X_RATELIMIT_LIMIT:Ljava/lang/String; = "X-RateLimit-Limit"

.field private static final X_RATELIMIT_REMAINING:Ljava/lang/String; = "X-RateLimit-Remaining"

.field private static final X_RATELIMIT_RESET:Ljava/lang/String; = "X-RateLimit-Reset"

.field public static final sTimeOffset:Ljava/util/concurrent/atomic/AtomicLong;


# instance fields
.field public exception:Ljava/lang/Exception;

.field private final mHttpClient:Lorg/apache/http/client/HttpClient;

.field private final mHttpRequest:Lorg/apache/http/client/methods/HttpRequestBase;

.field private final mReader:Lco/vine/android/network/HttpOperationReader;

.field private mResults:[Lco/vine/android/network/HttpResult;

.field public statusCode:I

.field public statusPhrase:Ljava/lang/String;

.field public uploadKey:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 61
    const-wide/high16 v2, -0x4010000000000000L    # -1.0

    sput-wide v2, Lco/vine/android/network/HttpOperation;->RATE_LIMIT_BYTES_PER_MS:D

    .line 66
    const-string v0, "http.agent"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lco/vine/android/network/HttpOperation;->USER_AGENT_STRING:Ljava/lang/String;

    .line 71
    invoke-static {}, Lco/vine/android/util/BuildUtil;->isLogsOn()Z

    move-result v0

    if-nez v0, :cond_0

    const-string v0, "HttpOperation"

    const/4 v2, 0x3

    invoke-static {v0, v2}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    sput-boolean v0, Lco/vine/android/network/HttpOperation;->LOGGABLE:Z

    .line 84
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    const-wide/16 v2, 0x0

    invoke-direct {v0, v2, v3}, Ljava/util/concurrent/atomic/AtomicLong;-><init>(J)V

    sput-object v0, Lco/vine/android/network/HttpOperation;->sTimeOffset:Ljava/util/concurrent/atomic/AtomicLong;

    .line 91
    new-array v0, v1, [Lco/vine/android/network/HttpResult;

    sput-object v0, Lco/vine/android/network/HttpOperation;->EMPTY_RESULTS:[Lco/vine/android/network/HttpResult;

    .line 92
    new-instance v0, Lco/vine/android/network/DefaultHttpOperationReader;

    invoke-direct {v0}, Lco/vine/android/network/DefaultHttpOperationReader;-><init>()V

    sput-object v0, Lco/vine/android/network/HttpOperation;->DEFAULT_READER:Lco/vine/android/network/HttpOperationReader;

    return-void

    :cond_1
    move v0, v1

    .line 71
    goto :goto_0
.end method

.method public constructor <init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V
    .locals 2
    .param p1, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p2, "httpReq"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p4, "api"    # Lco/vine/android/client/VineAPI;

    .prologue
    .line 114
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 115
    const-string v0, "Accept-Encoding"

    const-string v1, "gzip"

    invoke-virtual {p2, v0, v1}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 116
    const-string v0, "User-Agent"

    sget-object v1, Lco/vine/android/network/HttpOperation;->USER_AGENT_STRING:Ljava/lang/String;

    invoke-virtual {p2, v0, v1}, Lorg/apache/http/client/methods/HttpRequestBase;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    if-eqz p4, :cond_0

    .line 119
    invoke-virtual {p4, p2}, Lco/vine/android/client/VineAPI;->addClientHeaders(Lorg/apache/http/HttpRequest;)V

    .line 122
    :cond_0
    invoke-virtual {p1}, Lco/vine/android/network/HttpOperationClient;->getHttpClient()Lorg/apache/http/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/network/HttpOperation;->mHttpClient:Lorg/apache/http/client/HttpClient;

    .line 123
    iput-object p2, p0, Lco/vine/android/network/HttpOperation;->mHttpRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    .line 124
    if-nez p3, :cond_1

    .line 125
    sget-object v0, Lco/vine/android/network/HttpOperation;->DEFAULT_READER:Lco/vine/android/network/HttpOperationReader;

    iput-object v0, p0, Lco/vine/android/network/HttpOperation;->mReader:Lco/vine/android/network/HttpOperationReader;

    .line 129
    :goto_0
    return-void

    .line 127
    :cond_1
    iput-object p3, p0, Lco/vine/android/network/HttpOperation;->mReader:Lco/vine/android/network/HttpOperationReader;

    goto :goto_0
.end method

.method public static createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;
    .locals 3
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;

    .prologue
    .line 516
    new-instance v0, Lorg/apache/http/client/methods/HttpDelete;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/lang/String;)V

    .line 517
    .local v0, "delete":Lorg/apache/http/client/methods/HttpDelete;
    new-instance v1, Lco/vine/android/network/HttpOperation;

    invoke-direct {v1, p0, v0, p3, p2}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    .line 518
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p2, v1}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;)V

    .line 519
    return-object v1
.end method

.method public static createBasicAuthDeleteRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;
    .locals 3
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p4, "key"    # Ljava/lang/String;

    .prologue
    .line 525
    new-instance v0, Lorg/apache/http/client/methods/HttpDelete;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lorg/apache/http/client/methods/HttpDelete;-><init>(Ljava/lang/String;)V

    .line 526
    .local v0, "delete":Lorg/apache/http/client/methods/HttpDelete;
    new-instance v1, Lco/vine/android/network/HttpOperation;

    invoke-direct {v1, p0, v0, p3, p2}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    .line 527
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p2, v1, p4}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;Ljava/lang/String;)V

    .line 528
    return-object v1
.end method

.method public static createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;
    .locals 3
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;

    .prologue
    .line 414
    new-instance v0, Lorg/apache/http/client/methods/HttpGet;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 415
    .local v0, "get":Lorg/apache/http/client/methods/HttpGet;
    new-instance v1, Lco/vine/android/network/HttpOperation;

    invoke-direct {v1, p0, v0, p3, p2}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    .line 416
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p2, v1}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;)V

    .line 417
    return-object v1
.end method

.method public static createBasicAuthGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;Ljava/lang/String;)Lco/vine/android/network/HttpOperation;
    .locals 3
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p4, "key"    # Ljava/lang/String;

    .prologue
    .line 423
    new-instance v0, Lorg/apache/http/client/methods/HttpGet;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 424
    .local v0, "get":Lorg/apache/http/client/methods/HttpGet;
    new-instance v1, Lco/vine/android/network/HttpOperation;

    invoke-direct {v1, p0, v0, p3, p2}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    .line 425
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p2, v1, p4}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;Ljava/lang/String;)V

    .line 426
    return-object v1
.end method

.method public static createBasicAuthJsonPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/HashMap;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;
    .locals 2
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p4, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/network/HttpOperationClient;",
            "Ljava/lang/StringBuilder;",
            "Lco/vine/android/client/VineAPI;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lco/vine/android/network/HttpOperationReader;",
            ")",
            "Lco/vine/android/network/HttpOperation;"
        }
    .end annotation

    .prologue
    .line 498
    .local p3, "body":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    invoke-static {p0, p1, p3, p4, p2}, Lco/vine/android/network/HttpOperation;->createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/CharSequence;Ljava/util/HashMap;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v0

    .line 499
    .local v0, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p2, v0}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;)V

    .line 500
    const-string v1, "application/json"

    invoke-virtual {p2, v0, v1}, Lco/vine/android/client/VineAPI;->addContentTypeHeader(Lco/vine/android/network/HttpOperation;Ljava/lang/String;)V

    .line 501
    return-object v0
.end method

.method public static varargs createBasicAuthPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;[Ljava/lang/String;)Lco/vine/android/network/HttpOperation;
    .locals 5
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p4, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p5, "headers"    # [Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/network/HttpOperationClient;",
            "Ljava/lang/StringBuilder;",
            "Lco/vine/android/client/VineAPI;",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;",
            "Lco/vine/android/network/HttpOperationReader;",
            "[",
            "Ljava/lang/String;",
            ")",
            "Lco/vine/android/network/HttpOperation;"
        }
    .end annotation

    .prologue
    .line 476
    .local p3, "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    invoke-static {p0, p1, p3, p4, p2}, Lco/vine/android/network/HttpOperation;->createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;

    move-result-object v4

    .line 477
    .local v4, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p2, v4}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;)V

    .line 478
    move-object v0, p5

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_0

    aget-object v1, v0, v2

    .line 479
    .local v1, "header":Ljava/lang/String;
    invoke-virtual {p2, v4, v1}, Lco/vine/android/client/VineAPI;->addContentTypeHeader(Lco/vine/android/network/HttpOperation;Ljava/lang/String;)V

    .line 478
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 481
    .end local v1    # "header":Ljava/lang/String;
    :cond_0
    return-object v4
.end method

.method public static createBasicAuthPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;
    .locals 5
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p4, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/network/HttpOperationClient;",
            "Ljava/lang/StringBuilder;",
            "Lco/vine/android/client/VineAPI;",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;",
            "Lco/vine/android/network/HttpOperationReader;",
            ")",
            "Lco/vine/android/network/HttpOperation;"
        }
    .end annotation

    .prologue
    .line 443
    .local p3, "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v3, Lorg/apache/http/client/methods/HttpPut;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lorg/apache/http/client/methods/HttpPut;-><init>(Ljava/lang/String;)V

    .line 446
    .local v3, "put":Lorg/apache/http/client/methods/HttpPut;
    if-eqz p3, :cond_0

    .line 448
    :try_start_0
    new-instance v1, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string v4, "UTF-8"

    invoke-direct {v1, p3, v4}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 449
    .local v1, "entity":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    invoke-virtual {v3, v1}, Lorg/apache/http/client/methods/HttpPut;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 455
    .end local v1    # "entity":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    :cond_0
    :goto_0
    new-instance v2, Lco/vine/android/network/HttpOperation;

    invoke-direct {v2, p0, v3, p4, p2}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    .line 456
    .local v2, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p2, v2}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;)V

    .line 457
    return-object v2

    .line 450
    .end local v2    # "op":Lco/vine/android/network/HttpOperation;
    :catch_0
    move-exception v0

    .line 451
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_0
.end method

.method public static createGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;
    .locals 2
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p3, "api"    # Lco/vine/android/client/VineAPI;

    .prologue
    .line 542
    new-instance v0, Lorg/apache/http/client/methods/HttpGet;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 543
    .local v0, "get":Lorg/apache/http/client/methods/HttpGet;
    new-instance v1, Lco/vine/android/network/HttpOperation;

    invoke-direct {v1, p0, v0, p2, p3}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    return-object v1
.end method

.method public static createMediaPutRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/network/HttpOperationReader;Lorg/apache/http/HttpEntity;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;
    .locals 3
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p3, "entity"    # Lorg/apache/http/HttpEntity;
    .param p4, "api"    # Lco/vine/android/client/VineAPI;

    .prologue
    .line 559
    new-instance v1, Lorg/apache/http/client/methods/HttpPut;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Lorg/apache/http/client/methods/HttpPut;-><init>(Ljava/lang/String;)V

    .line 560
    .local v1, "put":Lorg/apache/http/client/methods/HttpPut;
    if-eqz p3, :cond_0

    .line 561
    invoke-virtual {v1, p3}, Lorg/apache/http/client/methods/HttpPut;->setEntity(Lorg/apache/http/HttpEntity;)V

    .line 563
    :cond_0
    new-instance v0, Lco/vine/android/network/HttpOperation;

    invoke-direct {v0, p0, v1, p2, p4}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    .line 564
    .local v0, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p4, v0}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;)V

    .line 565
    return-object v0
.end method

.method private static createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/CharSequence;Ljava/util/HashMap;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;
    .locals 7
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/CharSequence;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p4, "api"    # Lco/vine/android/client/VineAPI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/network/HttpOperationClient;",
            "Ljava/lang/CharSequence;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;",
            "Lco/vine/android/network/HttpOperationReader;",
            "Lco/vine/android/client/VineAPI;",
            ")",
            "Lco/vine/android/network/HttpOperation;"
        }
    .end annotation

    .prologue
    .line 605
    .local p2, "body":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/Object;>;"
    new-instance v4, Lorg/apache/http/client/methods/HttpPost;

    invoke-interface {p1}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 608
    .local v4, "post":Lorg/apache/http/client/methods/HttpPost;
    if-eqz p2, :cond_0

    .line 610
    :try_start_0
    new-instance v3, Lcom/fasterxml/jackson/databind/ObjectMapper;

    invoke-direct {v3}, Lcom/fasterxml/jackson/databind/ObjectMapper;-><init>()V

    .line 611
    .local v3, "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    invoke-virtual {v3, p2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->valueToTree(Ljava/lang/Object;)Lcom/fasterxml/jackson/databind/JsonNode;

    move-result-object v2

    .line 612
    .local v2, "jsonBody":Lcom/fasterxml/jackson/databind/JsonNode;
    new-instance v1, Lorg/apache/http/entity/StringEntity;

    invoke-virtual {v3, v2}, Lcom/fasterxml/jackson/databind/ObjectMapper;->writeValueAsString(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    const-string v6, "UTF-8"

    invoke-direct {v1, v5, v6}, Lorg/apache/http/entity/StringEntity;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 613
    .local v1, "entity":Lorg/apache/http/entity/StringEntity;
    const-string v5, "application/json"

    invoke-virtual {v1, v5}, Lorg/apache/http/entity/StringEntity;->setContentType(Ljava/lang/String;)V

    .line 614
    const-string v5, "UTF-8"

    invoke-virtual {v1, v5}, Lorg/apache/http/entity/StringEntity;->setContentEncoding(Ljava/lang/String;)V

    .line 615
    invoke-virtual {v4, v1}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 621
    .end local v1    # "entity":Lorg/apache/http/entity/StringEntity;
    .end local v2    # "jsonBody":Lcom/fasterxml/jackson/databind/JsonNode;
    .end local v3    # "mapper":Lcom/fasterxml/jackson/databind/ObjectMapper;
    :cond_0
    :goto_0
    new-instance v5, Lco/vine/android/network/HttpOperation;

    invoke-direct {v5, p0, v4, p3, p4}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    return-object v5

    .line 616
    :catch_0
    move-exception v0

    .line 617
    .local v0, "e":Ljava/io/IOException;
    const-string v5, "Failed to create Post Request."

    invoke-static {v5, v0}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public static createPostRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Ljava/util/ArrayList;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)Lco/vine/android/network/HttpOperation;
    .locals 4
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;
    .param p4, "api"    # Lco/vine/android/client/VineAPI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lco/vine/android/network/HttpOperationClient;",
            "Ljava/lang/StringBuilder;",
            "Ljava/util/ArrayList",
            "<",
            "Lorg/apache/http/message/BasicNameValuePair;",
            ">;",
            "Lco/vine/android/network/HttpOperationReader;",
            "Lco/vine/android/client/VineAPI;",
            ")",
            "Lco/vine/android/network/HttpOperation;"
        }
    .end annotation

    .prologue
    .line 579
    .local p2, "params":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lorg/apache/http/message/BasicNameValuePair;>;"
    new-instance v2, Lorg/apache/http/client/methods/HttpPost;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lorg/apache/http/client/methods/HttpPost;-><init>(Ljava/lang/String;)V

    .line 582
    .local v2, "post":Lorg/apache/http/client/methods/HttpPost;
    if-eqz p2, :cond_0

    .line 584
    :try_start_0
    new-instance v1, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string v3, "UTF-8"

    invoke-direct {v1, p2, v3}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 585
    .local v1, "entity":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    invoke-virtual {v2, v1}, Lorg/apache/http/client/methods/HttpPost;->setEntity(Lorg/apache/http/HttpEntity;)V
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    .line 591
    .end local v1    # "entity":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    :cond_0
    :goto_0
    new-instance v3, Lco/vine/android/network/HttpOperation;

    invoke-direct {v3, p0, v2, p3, p4}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    return-object v3

    .line 586
    :catch_0
    move-exception v0

    .line 587
    .local v0, "e":Ljava/io/UnsupportedEncodingException;
    invoke-virtual {v0}, Ljava/io/UnsupportedEncodingException;->printStackTrace()V

    goto :goto_0
.end method

.method public static createResourceGetRequest(Lco/vine/android/network/HttpOperationClient;Ljava/lang/StringBuilder;Lco/vine/android/client/VineAPI;Lco/vine/android/network/HttpOperationReader;)Lco/vine/android/network/HttpOperation;
    .locals 4
    .param p0, "client"    # Lco/vine/android/network/HttpOperationClient;
    .param p1, "url"    # Ljava/lang/StringBuilder;
    .param p2, "api"    # Lco/vine/android/client/VineAPI;
    .param p3, "reader"    # Lco/vine/android/network/HttpOperationReader;

    .prologue
    .line 548
    new-instance v0, Lorg/apache/http/client/methods/HttpGet;

    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v2}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 549
    .local v0, "get":Lorg/apache/http/client/methods/HttpGet;
    new-instance v1, Lco/vine/android/network/HttpOperation;

    invoke-direct {v1, p0, v0, p3, p2}, Lco/vine/android/network/HttpOperation;-><init>(Lco/vine/android/network/HttpOperationClient;Lorg/apache/http/client/methods/HttpRequestBase;Lco/vine/android/network/HttpOperationReader;Lco/vine/android/client/VineAPI;)V

    .line 550
    .local v1, "op":Lco/vine/android/network/HttpOperation;
    invoke-virtual {p1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "https"

    invoke-virtual {v2, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 551
    invoke-virtual {p2, v1}, Lco/vine/android/client/VineAPI;->addSessionKeyAuthHeader(Lco/vine/android/network/HttpOperation;)V

    .line 553
    :cond_0
    return-object v1
.end method


# virtual methods
.method public cancel()V
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lco/vine/android/network/HttpOperation;->mHttpRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    invoke-virtual {v0}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 137
    return-void
.end method

.method public execute()Lco/vine/android/network/HttpOperation;
    .locals 1

    .prologue
    .line 145
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lco/vine/android/network/HttpOperation;->execute(I)Lco/vine/android/network/HttpOperation;

    move-result-object v0

    return-object v0
.end method

.method public final execute(I)Lco/vine/android/network/HttpOperation;
    .locals 52
    .param p1, "retries"    # I

    .prologue
    .line 159
    const/4 v10, 0x1

    .line 162
    .local v10, "authRetry":I
    const/16 v22, 0x0

    .line 163
    .local v22, "e":Ljava/lang/Exception;
    const/16 v47, 0x0

    .line 169
    .local v47, "uploadKey":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v0, v0, Lco/vine/android/network/HttpOperation;->mHttpRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    move-object/from16 v27, v0

    .line 170
    .local v27, "httpReq":Lorg/apache/http/client/methods/HttpRequestBase;
    new-instance v42, Ljava/util/ArrayList;

    const/4 v3, 0x0

    move/from16 v0, p1

    invoke-static {v0, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    add-int/lit8 v3, v3, 0x1

    move-object/from16 v0, v42

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(I)V

    .line 173
    .local v42, "results":Ljava/util/ArrayList;, "Ljava/util/ArrayList<Lco/vine/android/network/HttpResult;>;"
    const-wide/16 v5, -0x1

    .line 176
    .local v5, "firstByte":J
    :cond_0
    const-wide/16 v37, 0x0

    .line 177
    .local v37, "readTime":J
    const-wide/16 v33, 0x0

    .line 178
    .local v33, "openTime":J
    const-wide/16 v13, 0x0

    .line 179
    .local v13, "closeTime":J
    sget-object v3, Lco/vine/android/network/HttpOperation;->sTimeOffset:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v3}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v18

    .line 182
    .local v18, "currentTimeOffset":J
    move-object/from16 v0, p0

    move-wide/from16 v1, v18

    invoke-virtual {v0, v1, v2}, Lco/vine/android/network/HttpOperation;->prepareRequest(J)V

    .line 184
    sget-boolean v3, Lco/vine/android/network/HttpOperation;->LOGGABLE:Z

    if-eqz v3, :cond_1

    .line 185
    const-string v3, "HttpOperation"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->getMethod()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, " "

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v9

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 189
    :cond_1
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v11

    .line 193
    .local v11, "before":J
    :try_start_0
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/network/HttpOperation;->mHttpClient:Lorg/apache/http/client/HttpClient;

    move-object/from16 v0, v27

    invoke-interface {v3, v0}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v40

    .line 194
    .local v40, "resp":Lorg/apache/http/HttpResponse;
    invoke-interface/range {v40 .. v40}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v44

    .line 195
    .local v44, "statusLine":Lorg/apache/http/StatusLine;
    invoke-interface/range {v44 .. v44}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v43

    .line 197
    .local v43, "statusCode":I
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sub-long v5, v3, v11

    .line 199
    invoke-interface/range {v44 .. v44}, Lorg/apache/http/StatusLine;->getReasonPhrase()Ljava/lang/String;

    move-result-object v39

    .line 201
    .local v39, "reasonPhrase":Ljava/lang/String;
    sget-boolean v3, Lco/vine/android/network/HttpOperation;->LOGGABLE:Z

    if-eqz v3, :cond_2

    .line 202
    const-string v3, "HttpOperation"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    move/from16 v0, v43

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, "/"

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v39

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, " ["

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v9

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, "]"

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 207
    :cond_2
    sparse-switch v43, :sswitch_data_0

    .line 240
    const/16 p1, 0x0

    .line 244
    :cond_3
    :goto_0
    :sswitch_0
    invoke-interface/range {v40 .. v40}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v23

    .line 245
    .local v23, "entity":Lorg/apache/http/HttpEntity;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sub-long v33, v3, v11

    .line 247
    if-eqz v23, :cond_7

    invoke-interface/range {v23 .. v23}, Lorg/apache/http/HttpEntity;->isStreaming()Z

    move-result v3

    if-eqz v3, :cond_7

    .line 249
    invoke-interface/range {v23 .. v23}, Lorg/apache/http/HttpEntity;->getContentEncoding()Lorg/apache/http/Header;

    move-result-object v3

    if-eqz v3, :cond_d

    .line 250
    invoke-interface/range {v23 .. v23}, Lorg/apache/http/HttpEntity;->getContentEncoding()Lorg/apache/http/Header;

    move-result-object v3

    invoke-interface {v3}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v15

    .line 254
    .local v15, "contentEncoding":Ljava/lang/String;
    :goto_1
    invoke-interface/range {v23 .. v23}, Lorg/apache/http/HttpEntity;->getContentType()Lorg/apache/http/Header;

    move-result-object v24

    .line 256
    .local v24, "entityContentType":Lorg/apache/http/Header;
    if-eqz v24, :cond_e

    .line 257
    invoke-interface/range {v24 .. v24}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v17

    .line 261
    .local v17, "contentType":Ljava/lang/String;
    :goto_2
    invoke-interface/range {v23 .. v23}, Lorg/apache/http/HttpEntity;->getContentLength()J

    move-result-wide v3

    long-to-int v0, v3

    move/from16 v16, v0

    .line 262
    .local v16, "contentLength":I
    sget-boolean v3, Lco/vine/android/network/HttpOperation;->LOGGABLE:Z

    if-eqz v3, :cond_4

    .line 263
    const-string v3, "HttpOperation"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "read: Encoding: "

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v15}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, ", type: "

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, ", length: "

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move/from16 v0, v16

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 266
    :cond_4
    const/16 v28, 0x0

    .line 268
    .local v28, "in":Ljava/io/InputStream;
    :try_start_1
    new-instance v30, Lco/vine/android/util/MeasureInputStream;

    invoke-interface/range {v23 .. v23}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v3

    move-object/from16 v0, v30

    invoke-direct {v0, v3}, Lco/vine/android/util/MeasureInputStream;-><init>(Ljava/io/InputStream;)V

    .line 270
    .local v30, "measuredIn":Lco/vine/android/util/MeasureInputStream;
    move-object/from16 v28, v30

    .line 271
    if-nez v17, :cond_f

    .line 298
    :cond_5
    :goto_3
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/network/HttpOperation;->mReader:Lco/vine/android/network/HttpOperationReader;

    move/from16 v0, v43

    move/from16 v1, v16

    move-object/from16 v2, v28

    invoke-interface {v3, v0, v1, v2}, Lco/vine/android/network/HttpOperationReader;->readInput(IILjava/io/InputStream;)V

    .line 299
    invoke-virtual/range {v30 .. v30}, Lco/vine/android/util/MeasureInputStream;->getReadTime()J

    move-result-wide v37

    .line 300
    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v3, :cond_6

    sget-wide v3, Lco/vine/android/network/HttpOperation;->RATE_LIMIT_BYTES_PER_MS:D

    const-wide/high16 v49, -0x4010000000000000L    # -1.0

    cmpl-double v3, v3, v49

    if-eqz v3, :cond_6

    .line 301
    move/from16 v0, v16

    int-to-double v3, v0

    sget-wide v49, Lco/vine/android/network/HttpOperation;->RATE_LIMIT_BYTES_PER_MS:D

    div-double v3, v3, v49

    move-wide/from16 v0, v37

    long-to-double v0, v0

    move-wide/from16 v49, v0

    sub-double v3, v3, v49

    double-to-long v0, v3

    move-wide/from16 v35, v0

    .line 302
    .local v35, "rateLimitLeft":J
    const-wide/16 v3, 0x0

    cmp-long v3, v35, v3

    if-lez v3, :cond_6

    .line 303
    const-string v3, "Rate limiting: {}ms."

    invoke-static/range {v35 .. v36}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 304
    invoke-static/range {v35 .. v36}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 308
    .end local v35    # "rateLimitLeft":J
    :cond_6
    :try_start_2
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v31

    .line 309
    .local v31, "now":J
    invoke-static/range {v28 .. v28}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 310
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    move-result-wide v3

    sub-long v13, v3, v31

    .line 324
    .end local v15    # "contentEncoding":Ljava/lang/String;
    .end local v16    # "contentLength":I
    .end local v17    # "contentType":Ljava/lang/String;
    .end local v24    # "entityContentType":Lorg/apache/http/Header;
    .end local v28    # "in":Ljava/io/InputStream;
    .end local v30    # "measuredIn":Lco/vine/android/util/MeasureInputStream;
    .end local v31    # "now":J
    :cond_7
    add-long v3, v33, v37

    add-long v7, v3, v13

    .line 325
    .local v7, "durationMs":J
    const-wide/16 v3, -0x1

    cmp-long v3, v5, v3

    if-eqz v3, :cond_9

    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-nez v3, :cond_8

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v3

    const-wide v49, 0x3fb999999999999aL    # 0.1

    cmpl-double v3, v3, v49

    if-lez v3, :cond_9

    .line 326
    :cond_8
    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v48

    .line 327
    .local v48, "uri":Ljava/net/URI;
    const-string v3, "{}, {} took {} ms to open and {} total."

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v49

    aput-object v49, v4, v9

    const/4 v9, 0x1

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v49

    aput-object v49, v4, v9

    const/4 v9, 0x2

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v49

    aput-object v49, v4, v9

    const/4 v9, 0x3

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v49

    aput-object v49, v4, v9

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 328
    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v49, "/r/videos/"

    move-object/from16 v0, v49

    invoke-virtual {v9, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    invoke-static/range {v3 .. v9}, Lco/vine/android/util/FlurryUtils;->trackRespondTime(Ljava/lang/String;Ljava/lang/String;JJZ)V

    .line 334
    .end local v48    # "uri":Ljava/net/URI;
    :cond_9
    new-instance v41, Lco/vine/android/network/HttpResult;

    move-object/from16 v0, v41

    move/from16 v1, v43

    move-object/from16 v2, v39

    invoke-direct {v0, v1, v2}, Lco/vine/android/network/HttpResult;-><init>(ILjava/lang/String;)V

    .line 335
    .local v41, "result":Lco/vine/android/network/HttpResult;
    move-object/from16 v0, v22

    move-object/from16 v1, v41

    iput-object v0, v1, Lco/vine/android/network/HttpResult;->exception:Ljava/lang/Exception;

    .line 336
    move-object/from16 v0, v41

    iput-wide v7, v0, Lco/vine/android/network/HttpResult;->durationMs:J

    .line 337
    move-object/from16 v0, v47

    move-object/from16 v1, v41

    iput-object v0, v1, Lco/vine/android/network/HttpResult;->uploadKey:Ljava/lang/String;

    .line 338
    const/16 v3, 0xc8

    move/from16 v0, v43

    if-eq v0, v3, :cond_a

    .line 339
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/network/HttpOperation;->mReader:Lco/vine/android/network/HttpOperationReader;

    move-object/from16 v0, v41

    invoke-interface {v3, v0}, Lco/vine/android/network/HttpOperationReader;->onHandleError(Lco/vine/android/network/HttpResult;)V

    .line 341
    :cond_a
    move-object/from16 v0, v42

    move-object/from16 v1, v41

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 343
    add-int/lit8 p1, p1, -0x1

    .line 344
    if-gez p1, :cond_0

    .line 346
    .end local v23    # "entity":Lorg/apache/http/HttpEntity;
    .end local v40    # "resp":Lorg/apache/http/HttpResponse;
    .end local v41    # "result":Lco/vine/android/network/HttpResult;
    .end local v44    # "statusLine":Lorg/apache/http/StatusLine;
    :cond_b
    :goto_4
    move/from16 v0, v43

    move-object/from16 v1, p0

    iput v0, v1, Lco/vine/android/network/HttpOperation;->statusCode:I

    .line 347
    move-object/from16 v0, v39

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/network/HttpOperation;->statusPhrase:Ljava/lang/String;

    .line 348
    move-object/from16 v0, v22

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/network/HttpOperation;->exception:Ljava/lang/Exception;

    .line 349
    move-object/from16 v0, v47

    move-object/from16 v1, p0

    iput-object v0, v1, Lco/vine/android/network/HttpOperation;->uploadKey:Ljava/lang/String;

    .line 351
    invoke-virtual/range {v42 .. v42}, Ljava/util/ArrayList;->size()I

    move-result v3

    new-array v3, v3, [Lco/vine/android/network/HttpResult;

    move-object/from16 v0, p0

    iput-object v3, v0, Lco/vine/android/network/HttpOperation;->mResults:[Lco/vine/android/network/HttpResult;

    .line 352
    move-object/from16 v0, p0

    iget-object v3, v0, Lco/vine/android/network/HttpOperation;->mResults:[Lco/vine/android/network/HttpResult;

    move-object/from16 v0, v42

    invoke-virtual {v0, v3}, Ljava/util/ArrayList;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    .line 354
    return-object p0

    .line 209
    .end local v7    # "durationMs":J
    .restart local v40    # "resp":Lorg/apache/http/HttpResponse;
    .restart local v44    # "statusLine":Lorg/apache/http/StatusLine;
    :sswitch_1
    :try_start_3
    const-string v3, "X-Upload-Key"

    move-object/from16 v0, v40

    invoke-interface {v0, v3}, Lorg/apache/http/HttpResponse;->getHeaders(Ljava/lang/String;)[Lorg/apache/http/Header;

    move-result-object v26

    .line 210
    .local v26, "headers":[Lorg/apache/http/Header;
    if-eqz v26, :cond_3

    move-object/from16 v0, v26

    array-length v3, v0

    if-lez v3, :cond_3

    .line 211
    const/4 v3, 0x0

    aget-object v3, v26, v3

    invoke-interface {v3}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v47

    goto/16 :goto_0

    .line 216
    .end local v26    # "headers":[Lorg/apache/http/Header;
    :sswitch_2
    const-string v3, "Date"

    move-object/from16 v0, v40

    invoke-interface {v0, v3}, Lorg/apache/http/HttpResponse;->getLastHeader(Ljava/lang/String;)Lorg/apache/http/Header;

    move-result-object v21

    .line 217
    .local v21, "dateHeader":Lorg/apache/http/Header;
    if-eqz v21, :cond_c

    .line 218
    sget-object v3, Lco/vine/android/util/Util;->DATE_TIME_RFC1123:Ljava/text/SimpleDateFormat;

    invoke-interface/range {v21 .. v21}, Lorg/apache/http/Header;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/text/SimpleDateFormat;->parse(Ljava/lang/String;)Ljava/util/Date;

    move-result-object v20

    .line 219
    .local v20, "d":Ljava/util/Date;
    invoke-virtual/range {v20 .. v20}, Ljava/util/Date;->getTime()J

    move-result-wide v45

    .line 220
    .local v45, "ts":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v31

    .line 221
    .restart local v31    # "now":J
    sget-object v3, Lco/vine/android/network/HttpOperation;->sTimeOffset:Ljava/util/concurrent/atomic/AtomicLong;

    sub-long v49, v45, v31

    move-wide/from16 v0, v49

    invoke-virtual {v3, v0, v1}, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 223
    .end local v20    # "d":Ljava/util/Date;
    .end local v31    # "now":J
    .end local v45    # "ts":J
    :cond_c
    if-lez v10, :cond_3

    .line 224
    add-int/lit8 v10, v10, -0x1

    .line 225
    add-int/lit8 p1, p1, 0x1

    goto/16 :goto_0

    .line 252
    .end local v21    # "dateHeader":Lorg/apache/http/Header;
    .restart local v23    # "entity":Lorg/apache/http/HttpEntity;
    :cond_d
    const/4 v15, 0x0

    .restart local v15    # "contentEncoding":Ljava/lang/String;
    goto/16 :goto_1

    .line 259
    .restart local v24    # "entityContentType":Lorg/apache/http/Header;
    :cond_e
    const/16 v17, 0x0

    .restart local v17    # "contentType":Ljava/lang/String;
    goto/16 :goto_2

    .line 274
    .restart local v16    # "contentLength":I
    .restart local v28    # "in":Ljava/io/InputStream;
    .restart local v30    # "measuredIn":Lco/vine/android/util/MeasureInputStream;
    :cond_f
    :try_start_4
    const-string v3, "application/octet-stream"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    const-string v3, "video/avc"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    const-string v3, "video/webm"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    const-string v3, "video/mp4"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    const-string v3, "binary/octet-stream"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 280
    const-string v3, "application/json"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_10

    .line 281
    if-eqz v15, :cond_5

    const-string v3, "gzip"

    invoke-virtual {v15, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 282
    new-instance v29, Ljava/util/zip/GZIPInputStream;

    move-object/from16 v0, v29

    move-object/from16 v1, v28

    invoke-direct {v0, v1}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    .line 283
    .end local v28    # "in":Ljava/io/InputStream;
    .local v29, "in":Ljava/io/InputStream;
    const/16 v16, -0x1

    move-object/from16 v28, v29

    .end local v29    # "in":Ljava/io/InputStream;
    .restart local v28    # "in":Ljava/io/InputStream;
    goto/16 :goto_3

    .line 285
    :cond_10
    const-string v3, "text/html"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_11

    const-string v3, "text/plain"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_11

    const-string v3, "text/xml"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_11

    const-string v3, "application/xml"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_11

    const-string v3, "image/"

    move-object/from16 v0, v17

    invoke-virtual {v0, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_12

    .line 291
    :cond_11
    if-eqz v15, :cond_5

    const-string v3, "gzip"

    invoke-virtual {v15, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    .line 292
    new-instance v29, Ljava/util/zip/GZIPInputStream;

    move-object/from16 v0, v29

    move-object/from16 v1, v28

    invoke-direct {v0, v1}, Ljava/util/zip/GZIPInputStream;-><init>(Ljava/io/InputStream;)V

    .line 293
    .end local v28    # "in":Ljava/io/InputStream;
    .restart local v29    # "in":Ljava/io/InputStream;
    const/16 v16, -0x1

    move-object/from16 v28, v29

    .end local v29    # "in":Ljava/io/InputStream;
    .restart local v28    # "in":Ljava/io/InputStream;
    goto/16 :goto_3

    .line 296
    :cond_12
    new-instance v3, Ljava/io/IOException;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Unsupported content type: "

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    move-object/from16 v0, v17

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 308
    .end local v30    # "measuredIn":Lco/vine/android/util/MeasureInputStream;
    :catchall_0
    move-exception v3

    :try_start_5
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v31

    .line 309
    .restart local v31    # "now":J
    invoke-static/range {v28 .. v28}, Lco/vine/android/util/Util;->closeSilently(Ljava/io/Closeable;)V

    .line 310
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v49

    sub-long v13, v49, v31

    .line 311
    throw v3
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 313
    .end local v15    # "contentEncoding":Ljava/lang/String;
    .end local v16    # "contentLength":I
    .end local v17    # "contentType":Ljava/lang/String;
    .end local v23    # "entity":Lorg/apache/http/HttpEntity;
    .end local v24    # "entityContentType":Lorg/apache/http/Header;
    .end local v28    # "in":Ljava/io/InputStream;
    .end local v31    # "now":J
    .end local v39    # "reasonPhrase":Ljava/lang/String;
    .end local v40    # "resp":Lorg/apache/http/HttpResponse;
    .end local v43    # "statusCode":I
    .end local v44    # "statusLine":Lorg/apache/http/StatusLine;
    :catch_0
    move-exception v25

    .line 314
    .local v25, "ex":Ljava/lang/Exception;
    :try_start_6
    sget-boolean v3, Lco/vine/android/network/HttpOperation;->LOGGABLE:Z

    if-eqz v3, :cond_13

    .line 315
    const-string v3, "HttpOperation"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "["

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v9

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v9, "]"

    invoke-virtual {v4, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    move-object/from16 v0, v25

    invoke-static {v3, v4, v0}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 317
    :cond_13
    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 318
    const/16 v43, 0x0

    .line 319
    .restart local v43    # "statusCode":I
    const/16 v39, 0x0

    .line 320
    .restart local v39    # "reasonPhrase":Ljava/lang/String;
    move-object/from16 v22, v25

    .line 321
    const-wide/16 v5, -0x1

    .line 324
    add-long v3, v33, v37

    add-long v7, v3, v13

    .line 325
    .restart local v7    # "durationMs":J
    const-wide/16 v3, -0x1

    cmp-long v3, v5, v3

    if-eqz v3, :cond_b

    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-nez v3, :cond_14

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v3

    const-wide v49, 0x3fb999999999999aL    # 0.1

    cmpl-double v3, v3, v49

    if-lez v3, :cond_b

    .line 326
    :cond_14
    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v48

    .line 327
    .restart local v48    # "uri":Ljava/net/URI;
    const-string v3, "{}, {} took {} ms to open and {} total."

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v49

    aput-object v49, v4, v9

    const/4 v9, 0x1

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v49

    aput-object v49, v4, v9

    const/4 v9, 0x2

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v49

    aput-object v49, v4, v9

    const/4 v9, 0x3

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v49

    aput-object v49, v4, v9

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 328
    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v49, "/r/videos/"

    move-object/from16 v0, v49

    invoke-virtual {v9, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    invoke-static/range {v3 .. v9}, Lco/vine/android/util/FlurryUtils;->trackRespondTime(Ljava/lang/String;Ljava/lang/String;JJZ)V

    goto/16 :goto_4

    .line 324
    .end local v7    # "durationMs":J
    .end local v25    # "ex":Ljava/lang/Exception;
    .end local v39    # "reasonPhrase":Ljava/lang/String;
    .end local v43    # "statusCode":I
    .end local v48    # "uri":Ljava/net/URI;
    :catchall_1
    move-exception v3

    move-object/from16 v49, v3

    add-long v3, v33, v37

    add-long v7, v3, v13

    .line 325
    .restart local v7    # "durationMs":J
    const-wide/16 v3, -0x1

    cmp-long v3, v5, v3

    if-eqz v3, :cond_16

    sget-boolean v3, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-nez v3, :cond_15

    invoke-static {}, Ljava/lang/Math;->random()D

    move-result-wide v3

    const-wide v50, 0x3fb999999999999aL    # 0.1

    cmpl-double v3, v3, v50

    if-lez v3, :cond_16

    .line 326
    :cond_15
    invoke-virtual/range {v27 .. v27}, Lorg/apache/http/client/methods/HttpRequestBase;->getURI()Ljava/net/URI;

    move-result-object v48

    .line 327
    .restart local v48    # "uri":Ljava/net/URI;
    const-string v3, "{}, {} took {} ms to open and {} total."

    const/4 v4, 0x4

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v50

    aput-object v50, v4, v9

    const/4 v9, 0x1

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v50

    aput-object v50, v4, v9

    const/4 v9, 0x2

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v50

    aput-object v50, v4, v9

    const/4 v9, 0x3

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v50

    aput-object v50, v4, v9

    invoke-static {v3, v4}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 328
    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v3

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->getPath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual/range {v48 .. v48}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v9

    const-string v50, "/r/videos/"

    move-object/from16 v0, v50

    invoke-virtual {v9, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v9

    invoke-static/range {v3 .. v9}, Lco/vine/android/util/FlurryUtils;->trackRespondTime(Ljava/lang/String;Ljava/lang/String;JJZ)V

    .line 329
    .end local v48    # "uri":Ljava/net/URI;
    :cond_16
    throw v49

    .line 207
    nop

    :sswitch_data_0
    .sparse-switch
        0xc8 -> :sswitch_1
        0x191 -> :sswitch_2
        0x1f4 -> :sswitch_0
        0x1f6 -> :sswitch_0
        0x1f7 -> :sswitch_0
    .end sparse-switch
.end method

.method public getHttpRequest()Lorg/apache/http/client/methods/HttpRequestBase;
    .locals 1

    .prologue
    .line 399
    iget-object v0, p0, Lco/vine/android/network/HttpOperation;->mHttpRequest:Lorg/apache/http/client/methods/HttpRequestBase;

    return-object v0
.end method

.method public getReader()Lco/vine/android/network/HttpOperationReader;
    .locals 1

    .prologue
    .line 149
    iget-object v0, p0, Lco/vine/android/network/HttpOperation;->mReader:Lco/vine/android/network/HttpOperationReader;

    return-object v0
.end method

.method public getResults()[Lco/vine/android/network/HttpResult;
    .locals 1

    .prologue
    .line 391
    iget-object v0, p0, Lco/vine/android/network/HttpOperation;->mResults:[Lco/vine/android/network/HttpResult;

    if-nez v0, :cond_0

    .line 392
    sget-object v0, Lco/vine/android/network/HttpOperation;->EMPTY_RESULTS:[Lco/vine/android/network/HttpResult;

    .line 394
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lco/vine/android/network/HttpOperation;->mResults:[Lco/vine/android/network/HttpResult;

    goto :goto_0
.end method

.method public isOK()Z
    .locals 2

    .prologue
    .line 373
    iget v0, p0, Lco/vine/android/network/HttpOperation;->statusCode:I

    const/16 v1, 0xc8

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isSuccessful()Z
    .locals 2

    .prologue
    .line 382
    iget v0, p0, Lco/vine/android/network/HttpOperation;->statusCode:I

    const/16 v1, 0xc8

    if-lt v0, v1, :cond_0

    iget v0, p0, Lco/vine/android/network/HttpOperation;->statusCode:I

    const/16 v1, 0x12c

    if-ge v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected prepareRequest(J)V
    .locals 0
    .param p1, "timeOffset"    # J

    .prologue
    .line 365
    return-void
.end method
