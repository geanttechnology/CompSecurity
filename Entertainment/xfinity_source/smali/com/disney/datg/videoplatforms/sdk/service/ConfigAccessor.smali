.class public Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;
.super Lcom/disney/datg/videoplatforms/sdk/service/Accessor;
.source "ConfigAccessor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/Accessor",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
        ">;"
    }
.end annotation


# direct methods
.method public constructor <init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V
    .locals 0
    .param p1, "serviceEndpoint"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 28
    .local p2, "requestHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 29
    return-void
.end method


# virtual methods
.method public getServiceAsync()Ljava/util/concurrent/Future;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Config;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 37
    const/4 v3, 0x0

    .line 40
    .local v3, "futureConfigResponse":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;>;"
    :try_start_0
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;

    new-instance v4, Ljava/net/URI;

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;->getServiceEndpoint()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, v5}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    sget-object v5, Lorg/springframework/http/HttpMethod;->GET:Lorg/springframework/http/HttpMethod;

    const-class v6, Lcom/disney/datg/videoplatforms/sdk/models/api/Config;

    invoke-direct {v1, v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;-><init>(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Ljava/lang/Class;)V

    .line 45
    .local v1, "configRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;

    invoke-direct {v0}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;-><init>()V

    .line 47
    .local v0, "configApiDeserializer":Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;->getTimeout()I

    move-result v4

    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor$1;

    invoke-direct {v5, p0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;)V

    invoke-virtual {v0, v1, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1

    move-result-object v3

    .line 110
    return-object v3

    .line 99
    .end local v0    # "configApiDeserializer":Lcom/disney/datg/videoplatforms/sdk/service/serialization/ConfigApiDeserializer;
    .end local v1    # "configRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Config;>;"
    :catch_0
    move-exception v2

    .line 100
    .local v2, "e":Ljava/net/URISyntaxException;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v4

    if-eqz v4, :cond_0

    .line 101
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v4

    invoke-interface {v4, v7, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 102
    :cond_0
    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_INVALID_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v2}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v4

    .line 104
    .end local v2    # "e":Ljava/net/URISyntaxException;
    :catch_1
    move-exception v2

    .line 105
    .local v2, "e":Ljava/lang/Exception;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 106
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ConfigAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v4

    invoke-interface {v4, v7, v2}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 107
    :cond_1
    new-instance v4, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v5, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_INVALID_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v2}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v6

    invoke-direct {v4, v5, v6}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v4
.end method
