.class public Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;
.super Lcom/disney/datg/videoplatforms/sdk/service/Accessor;
.source "VideoAccessor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/Accessor",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
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
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 20
    .local p2, "requestHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 21
    return-void
.end method


# virtual methods
.method public getServiceAsync()Ljava/util/concurrent/Future;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/Future",
            "<",
            "Lorg/springframework/http/ResponseEntity",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 29
    const/4 v1, 0x0

    .line 32
    .local v1, "futureVideosResponse":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;>;"
    :try_start_0
    new-instance v2, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;

    new-instance v3, Ljava/net/URI;

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getServiceEndpoint()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    sget-object v4, Lorg/springframework/http/HttpMethod;->GET:Lorg/springframework/http/HttpMethod;

    const-class v5, Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;

    invoke-direct {v2, v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;-><init>(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Ljava/lang/Class;)V

    .line 37
    .local v2, "videoRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/service/serialization/VideoApiDeserializer;

    invoke-direct {v3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/VideoApiDeserializer;-><init>()V

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getTimeout()I

    move-result v4

    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;

    invoke-direct {v5, p0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;)V

    invoke-virtual {v3, v2, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/VideoApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 94
    return-object v1

    .line 88
    .end local v2    # "videoRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Videos;>;"
    :catch_0
    move-exception v0

    .line 89
    .local v0, "e":Ljava/net/URISyntaxException;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 90
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/VideoAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4, v0}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 91
    :cond_0
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_INVALID_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v0}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v3
.end method
