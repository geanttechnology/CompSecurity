.class public Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;
.super Ljava/lang/Object;
.source "UnregisterDeviceClient.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# instance fields
.field private final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private final requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final unregisterDeviceService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V
    .locals 0
    .param p2, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/fasterxml/jackson/databind/ObjectMapper;",
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;, "Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient<TT;>;"
    .local p1, "unregisterDeviceService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->unregisterDeviceService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 26
    iput-object p2, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 27
    iput-object p3, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 28
    iput-object p4, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 29
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    .prologue
    .line 13
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method public unregisterDevice(Lcom/comcast/cim/model/user/AuthKeys;Ljava/lang/String;)V
    .locals 5
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;
    .param p2, "deviceId"    # Ljava/lang/String;

    .prologue
    .line 32
    .local p0, "this":Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;, "Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient<TT;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "proxy/ams/xip/device/download/devices/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "DELETE"

    invoke-virtual {v2, v3, v4}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 33
    .local v0, "baseRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 34
    .local v1, "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->unregisterDeviceService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v3, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient$1;-><init>(Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;)V

    invoke-interface {v2, v1, v3}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    .line 40
    return-void
.end method
