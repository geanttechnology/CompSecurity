.class public Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;
.super Ljava/lang/Object;
.source "RegisterDeviceClient.java"


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
.field private final deviceDisplayName:Ljava/lang/String;

.field private final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private final registerDeviceService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

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


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V
    .locals 1
    .param p2, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p3, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;",
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
    .line 28
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;, "Lcom/xfinity/playerlib/downloads/RegisterDeviceClient<TT;>;"
    .local p1, "registerDeviceService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p5, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 29
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->registerDeviceService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 30
    invoke-virtual {p2}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getDeviceDisplayName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->deviceDisplayName:Ljava/lang/String;

    .line 31
    iput-object p4, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 32
    iput-object p5, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 33
    iput-object p3, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    .prologue
    .line 15
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method public registerDevice(Lcom/comcast/cim/model/user/XipUser;)Lcom/xfinity/playerlib/downloads/DeviceRegistration;
    .locals 7
    .param p1, "user"    # Lcom/comcast/cim/model/user/XipUser;

    .prologue
    .line 37
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;, "Lcom/xfinity/playerlib/downloads/RegisterDeviceClient<TT;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    const-string v5, "proxy/ams/xip/device/download/register"

    const-string v6, "POST"

    invoke-virtual {v4, v5, v6}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 38
    .local v0, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/XipUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v5

    invoke-virtual {v5}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/XipUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v6

    invoke-virtual {v6}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v1

    .line 39
    .local v1, "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    new-instance v3, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    invoke-direct {v3, v0, v1}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 40
    .local v3, "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    const-string v4, "mso"

    const-string v5, "comcast"

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-string v4, "deviceName"

    iget-object v5, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->deviceDisplayName:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 43
    const-wide/16 v4, 0x3a98

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->setSocketTimeout(J)V

    .line 45
    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;->registerDeviceService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v5, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/downloads/RegisterDeviceClient$1;-><init>(Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;)V

    invoke-interface {v4, v3, v5}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;

    .line 51
    .local v2, "response":Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/downloads/RegisterDeviceResponseHandler;->getDeviceRegistration()Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    move-result-object v4

    return-object v4
.end method
