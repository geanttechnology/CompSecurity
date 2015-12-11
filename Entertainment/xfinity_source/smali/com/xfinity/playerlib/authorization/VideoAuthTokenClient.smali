.class public Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;
.super Ljava/lang/Object;
.source "VideoAuthTokenClient.java"


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
.field private final authorizationService:Lcom/comcast/cim/cmasl/http/service/HttpService;
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
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
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
    .line 25
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;, "Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient<TT;>;"
    .local p1, "authorizationService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p2, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->authorizationService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 27
    iput-object p2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 28
    iput-object p3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 29
    return-void
.end method


# virtual methods
.method public authorize(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Ljava/lang/String;)Lcom/xfinity/playerlib/authorization/VideoAuthToken;
    .locals 8
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;
    .param p2, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p3, "channel"    # Ljava/lang/String;
    .param p4, "secureMetadataValue"    # Ljava/lang/String;

    .prologue
    .line 35
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;, "Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient<TT;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    const-string v6, "proxy/tve/token/"

    const-string v7, "POST"

    invoke-virtual {v5, v6, v7}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 36
    .local v0, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v5, v6, v7}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v1

    .line 37
    .local v1, "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    new-instance v3, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    invoke-direct {v3, v0, v1}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 39
    .local v3, "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    const-string v5, "Content-Type"

    const-string v6, "application/x-www-form-urlencoded"

    invoke-virtual {v3, v5, v6}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 41
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->getXedata()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 43
    .local v4, "xedataDecode":Ljava/lang/String;
    const-string v5, "xedata"

    invoke-virtual {v3, v5, v4}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    const-string v5, "channel"

    invoke-virtual {v3, v5, p3}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 45
    const-string v5, "scm"

    invoke-virtual {v3, v5, p4}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 47
    const-wide/16 v6, 0x3a98

    invoke-virtual {v3, v6, v7}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->setSocketTimeout(J)V

    .line 49
    iget-object v5, p0, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;->authorizationService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v6, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient$1;-><init>(Lcom/xfinity/playerlib/authorization/VideoAuthTokenClient;)V

    invoke-interface {v5, v3, v6}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;

    .line 56
    .local v2, "responseHandler":Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/authorization/VideoAuthTokenResponseHandler;->getVideoAuthToken()Lcom/xfinity/playerlib/authorization/VideoAuthToken;

    move-result-object v5

    return-object v5
.end method
