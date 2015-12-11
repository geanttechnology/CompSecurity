.class public Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;
.super Lcom/disney/datg/videoplatforms/sdk/service/Accessor;
.source "ChannelsAccessor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/Accessor",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
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
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p2, "requestHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    invoke-direct {p0, p1, p2}, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 27
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
            "Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    .line 35
    const/4 v2, 0x0

    .line 40
    .local v2, "futureChannelsResponse":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;>;"
    :try_start_0
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;

    new-instance v3, Ljava/net/URI;

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getServiceEndpoint()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    sget-object v4, Lorg/springframework/http/HttpMethod;->GET:Lorg/springframework/http/HttpMethod;

    const-class v5, Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;

    invoke-direct {v0, v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;-><init>(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Ljava/lang/Class;)V

    .line 45
    .local v0, "channelsRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ChannelsApiDeserializer;

    invoke-direct {v3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ChannelsApiDeserializer;-><init>()V

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getTimeout()I

    move-result v4

    new-instance v5, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;

    invoke-direct {v5, p0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;)V

    invoke-virtual {v3, v0, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/ChannelsApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 102
    return-object v2

    .line 96
    .end local v0    # "channelsRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/Channels;>;"
    :catch_0
    move-exception v1

    .line 97
    .local v1, "e":Ljava/net/URISyntaxException;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 98
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/ChannelsAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v3

    const/4 v4, 0x0

    invoke-interface {v3, v4, v1}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 99
    :cond_0
    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v4, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_INVALID_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v1}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v3, v4, v5}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v3
.end method
