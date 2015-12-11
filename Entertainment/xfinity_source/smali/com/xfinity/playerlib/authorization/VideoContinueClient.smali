.class public Lcom/xfinity/playerlib/authorization/VideoContinueClient;
.super Ljava/lang/Object;
.source "VideoContinueClient.java"


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
.field private final httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

.field private final requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
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
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V
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
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
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
    .line 25
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoContinueClient;, "Lcom/xfinity/playerlib/authorization/VideoContinueClient<TT;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 27
    iput-object p2, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 28
    iput-object p3, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 29
    iput-object p4, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 30
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/authorization/VideoContinueClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/authorization/VideoContinueClient;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method public sendHeartbeat(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/authorization/VideoAuthorization;)Lcom/xfinity/playerlib/authorization/VideoSession;
    .locals 7
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;
    .param p2, "authorization"    # Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    .prologue
    .line 33
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoContinueClient;, "Lcom/xfinity/playerlib/authorization/VideoContinueClient<TT;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    const-string v5, "proxy/ams/video/continue"

    const-string v6, "POST"

    invoke-interface {v4, v5, v6}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 34
    .local v0, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v1

    .line 35
    .local v1, "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    new-instance v3, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    invoke-direct {v3, v0, v1}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 37
    .local v3, "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    const-string v4, "appName"

    const-string v5, "AndroidPlayNow"

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 38
    const-string v4, "deviceAuthorizationToken"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getDeviceAuthorizationToken()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 39
    const-string v4, "previousSessionId"

    invoke-virtual {p2}, Lcom/xfinity/playerlib/authorization/VideoAuthorization;->getSessionToken()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    const-wide/16 v4, 0x3a98

    invoke-virtual {v3, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->setSocketTimeout(J)V

    .line 43
    iget-object v4, p0, Lcom/xfinity/playerlib/authorization/VideoContinueClient;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v5, Lcom/xfinity/playerlib/authorization/VideoContinueClient$1;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/authorization/VideoContinueClient$1;-><init>(Lcom/xfinity/playerlib/authorization/VideoContinueClient;)V

    invoke-interface {v4, v3, v5}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;

    .line 50
    .local v2, "responseHandler":Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/authorization/VideoContinueResponseHandler;->getVideoContinue()Lcom/xfinity/playerlib/authorization/VideoSession;

    move-result-object v4

    return-object v4
.end method
