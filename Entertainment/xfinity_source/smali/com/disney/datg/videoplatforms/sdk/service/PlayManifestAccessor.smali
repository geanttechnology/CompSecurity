.class public Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;
.super Lcom/disney/datg/videoplatforms/sdk/service/Accessor;
.source "PlayManifestAccessor.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/disney/datg/videoplatforms/sdk/service/Accessor",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;",
        ">;"
    }
.end annotation


# instance fields
.field private postParams:Lorg/springframework/util/MultiValueMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lorg/springframework/util/MultiValueMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Ljava/lang/String;Lorg/springframework/util/MultiValueMap;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V
    .locals 0
    .param p1, "serviceEndpoint"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/springframework/util/MultiValueMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler",
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 23
    .local p2, "param":Lorg/springframework/util/MultiValueMap;, "Lorg/springframework/util/MultiValueMap<Ljava/lang/String;Ljava/lang/String;>;"
    .local p3, "requestHandler":Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;, "Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    invoke-direct {p0, p1, p3}, Lcom/disney/datg/videoplatforms/sdk/service/Accessor;-><init>(Ljava/lang/String;Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)V

    .line 24
    iput-object p2, p0, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;->postParams:Lorg/springframework/util/MultiValueMap;

    .line 25
    return-void
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
            "<",
            "Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;
        }
    .end annotation

    .prologue
    const/4 v8, 0x0

    .line 34
    const/4 v7, 0x0

    .line 37
    .local v7, "futureEntitlementResponse":Ljava/util/concurrent/Future;, "Ljava/util/concurrent/Future<Lorg/springframework/http/ResponseEntity<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;>;"
    :try_start_0
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;

    new-instance v1, Ljava/net/URI;

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;->getServiceEndpoint()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V

    sget-object v2, Lorg/springframework/http/HttpMethod;->POST:Lorg/springframework/http/HttpMethod;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;->postParams:Lorg/springframework/util/MultiValueMap;

    const-class v5, Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;

    invoke-direct/range {v0 .. v5}, Lcom/disney/datg/videoplatforms/sdk/service/resttemplate/RestTemplateRequest;-><init>(Ljava/net/URI;Lorg/springframework/http/HttpMethod;Lorg/springframework/http/HttpHeaders;Lorg/springframework/util/MultiValueMap;Ljava/lang/Class;)V

    .line 44
    .local v0, "entitlementRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/service/serialization/PlayManifestApiDeserializer;

    invoke-direct {v1}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/PlayManifestApiDeserializer;-><init>()V

    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;->getTimeout()I

    move-result v2

    new-instance v3, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor$1;

    invoke-direct {v3, p0}, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor$1;-><init>(Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;)V

    invoke-virtual {v1, v0, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/service/serialization/PlayManifestApiDeserializer;->executeAsync(Lcom/disney/datg/videoplatforms/sdk/service/Request;ILcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;)Ljava/util/concurrent/Future;
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v7

    .line 103
    return-object v7

    .line 97
    .end local v0    # "entitlementRequest":Lcom/disney/datg/videoplatforms/sdk/service/Request;, "Lcom/disney/datg/videoplatforms/sdk/service/Request<Lcom/disney/datg/videoplatforms/sdk/models/api/PlayManifest;>;"
    :catch_0
    move-exception v6

    .line 98
    .local v6, "e":Ljava/net/URISyntaxException;
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 99
    invoke-virtual {p0}, Lcom/disney/datg/videoplatforms/sdk/service/PlayManifestAccessor;->getRequestHandler()Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;

    move-result-object v1

    invoke-interface {v1, v8, v6}, Lcom/disney/datg/videoplatforms/sdk/service/HttpRequestHandler;->onError(Lcom/disney/datg/videoplatforms/sdk/service/Request;Ljava/lang/Exception;)V

    .line 100
    :cond_0
    new-instance v1, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;->ANDROID_SDK_SERVICE_INVALID_HOST:Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;

    invoke-virtual {v6}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/error/AndroidSDKException;-><init>(Lcom/disney/datg/videoplatforms/sdk/error/ErrorCode;Ljava/lang/String;)V

    throw v1
.end method
