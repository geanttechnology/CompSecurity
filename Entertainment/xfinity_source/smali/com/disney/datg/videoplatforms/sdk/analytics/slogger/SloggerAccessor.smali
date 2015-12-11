.class public Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;
.super Lcom/disney/datg/videoplatforms/sdk/service/Accessor;
.source "SloggerAccessor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/Accessor",
        "<[B>;"
    }
.end annotation


# instance fields
.field private headers:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Ljava/util/Map;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V
    .locals 0
    .param p1, "serviceEndpoint"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<[B>;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p2, "headers":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "requestHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<[B>;"
    invoke-direct {p0, p1, p3}, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 37
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->headers:Ljava/util/Map;

    .line 38
    return-void
.end method

.method static synthetic access$000(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$100(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$300(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$500(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$700(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$800(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$900(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;
    .locals 1
    .param p0, "x0"    # Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;

    .prologue
    .line 24
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getServiceAsync()Ljava/util/concurrent/Future;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<[B>;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 43
    const/4 v4, 0x0

    .line 46
    .local v4, "sloggerResponse":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<[B>;>;"
    :try_start_0
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;

    new-instance v5, Ljava/net/URI;

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getServiceEndpoint()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v5, v6}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    sget-object v6, Lorg/springframework/http/HttpMethod;->GET:Lorg/springframework/http/HttpMethod;

    const-class v7, [B

    invoke-direct {v3, v5, v6, v7}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;-><init>(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Ljava/lang/Class;)V

    .line 50
    .local v3, "sloggerRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    new-instance v5, Lorg/springframework/http/HttpHeaders;

    invoke-direct {v5}, Lorg/springframework/http/HttpHeaders;-><init>()V

    invoke-interface {v3, v5}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->setHeaders(Lorg/springframework/http/HttpHeaders;)V

    .line 51
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->headers:Ljava/util/Map;

    if-eqz v5, :cond_2

    .line 52
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->headers:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 53
    .local v2, "key":Ljava/lang/String;
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->headers:Ljava/util/Map;

    invoke-interface {v5, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_0

    .line 54
    iget-object v5, p0, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->headers:Ljava/util/Map;

    invoke-interface {v5, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v3, v2, v5}, Lcom/disney/datg/videoplatforms/sdk/service/Request;->addHeader(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    goto :goto_0

    .line 102
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "key":Ljava/lang/String;
    .end local v3    # "sloggerRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    :catch_0
    move-exception v0

    .line 103
    .local v0, "e":Ljava/net/URISyntaxException;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v5

    if-eqz v5, :cond_1

    .line 104
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v5

    invoke-interface {v5, v8, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 105
    :cond_1
    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v6, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_INVALID_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v0}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v5

    .line 58
    .end local v0    # "e":Ljava/net/URISyntaxException;
    .restart local v3    # "sloggerRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    :cond_2
    :try_start_1
    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerDeserializer;

    new-instance v6, Lorg/springframework/http/converter/ByteArrayHttpMessageConverter;

    invoke-direct {v6}, Lorg/springframework/http/converter/ByteArrayHttpMessageConverter;-><init>()V

    const-class v7, [B

    invoke-direct {v5, v6, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerDeserializer;-><init>(Lorg/springframework/http/converter/HttpMessageConverter;Ljava/lang/Class;)V

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getTimeout()I

    move-result v6

    new-instance v7, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;

    invoke-direct {v7, p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;)V

    invoke-virtual {v5, v3, v6, v7}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerDeserializer;->getForObjectAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1

    move-result-object v4

    .line 111
    return-object v4

    .line 106
    .end local v3    # "sloggerRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<[B>;"
    :catch_1
    move-exception v0

    .line 107
    .local v0, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v5

    if-eqz v5, :cond_3

    .line 108
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/analytics/slogger/SloggerAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v5

    invoke-interface {v5, v8, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 109
    :cond_3
    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v6, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_INVALID_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v6, v7}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v5
.end method
