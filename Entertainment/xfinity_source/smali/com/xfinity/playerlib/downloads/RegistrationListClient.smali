.class public Lcom/xfinity/playerlib/downloads/RegistrationListClient;
.super Ljava/lang/Object;
.source "RegistrationListClient.java"


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

.field private final registrationListHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
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
    .line 27
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegistrationListClient;, "Lcom/xfinity/playerlib/downloads/RegistrationListClient<TT;>;"
    .local p1, "registrationListHttpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->registrationListHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 29
    iput-object p2, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 30
    iput-object p3, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 31
    iput-object p4, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 32
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/downloads/RegistrationListClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    .prologue
    .line 16
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method public getDeviceRegistrationList(Lcom/comcast/cim/model/user/AuthKeys;)Ljava/util/List;
    .locals 7
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/model/user/AuthKeys;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/xfinity/playerlib/downloads/RegistrationListClient;, "Lcom/xfinity/playerlib/downloads/RegistrationListClient<TT;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    const-string v5, "proxy/ams/xip/device/download/devices"

    const-string v6, "GET"

    invoke-virtual {v4, v5, v6}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 36
    .local v0, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v1

    .line 37
    .local v1, "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    new-instance v3, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    invoke-direct {v3, v0, v1}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 39
    .local v3, "signedHTTPRequestProvider":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    const-wide/16 v4, 0x3a98

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->setSocketTimeout(J)V

    .line 41
    iget-object v4, p0, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->registrationListHttpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v5, Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/downloads/RegistrationListClient$1;-><init>(Lcom/xfinity/playerlib/downloads/RegistrationListClient;)V

    invoke-interface {v4, v3, v5}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;

    .line 47
    .local v2, "responseHandler":Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/downloads/RegistrationListResponseHandler;->getDeviceList()Ljava/util/List;

    move-result-object v4

    return-object v4
.end method
