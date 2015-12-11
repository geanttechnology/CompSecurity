.class public Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;
.super Ljava/lang/Object;
.source "VideoAuthorizationClient.java"


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

.field private objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

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
    .line 29
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;, "Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient<TT;>;"
    .local p1, "authorizationService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->authorizationService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 31
    iput-object p3, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 32
    iput-object p4, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 33
    iput-object p2, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method public authorize(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Lcom/xfinity/playerlib/authorization/VideoAuthorization;
    .locals 12
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;
    .param p2, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p3, "secureMetadataValue"    # Ljava/lang/String;
    .param p4, "deviceAuthorizationToken"    # Ljava/lang/String;
    .param p5, "previousSessionId"    # Ljava/lang/String;
    .param p6, "pin"    # Ljava/lang/String;
    .param p7, "isLiveStream"    # Z

    .prologue
    .line 39
    .local p0, "this":Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;, "Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient<TT;>;"
    iget-object v10, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    if-eqz p7, :cond_0

    const-string v9, "proxy/ams/video/xa-linear-access"

    :goto_0
    const-string v11, "POST"

    invoke-virtual {v10, v9, v11}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v2

    .line 40
    .local v2, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v9, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v9, v10, v11}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v3

    .line 41
    .local v3, "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    new-instance v7, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    invoke-direct {v7, v2, v3}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 43
    .local v7, "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    if-eqz p7, :cond_1

    const-string v6, "scm"

    .line 44
    .local v6, "secureMetadataName":Ljava/lang/String;
    :goto_1
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->getXedata()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    .line 47
    .local v8, "xedataDecode":Ljava/lang/String;
    if-eqz p7, :cond_2

    .line 48
    move-object v5, p3

    .line 53
    .local v5, "secureMetaData":Ljava/lang/String;
    :goto_2
    const-string v9, "appName"

    const-string v10, "AndroidPlayNow"

    invoke-virtual {v7, v9, v10}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    const-string v9, "xedata"

    invoke-virtual {v7, v9, v8}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 55
    const-string v9, "pin"

    move-object/from16 v0, p6

    invoke-virtual {v7, v9, v0}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 56
    invoke-virtual {v7, v6, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    const-string v9, "deviceAuthorizationToken"

    move-object/from16 v0, p4

    invoke-virtual {v7, v9, v0}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 58
    const-string v9, "previousSessionId"

    move-object/from16 v0, p5

    invoke-virtual {v7, v9, v0}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 59
    const-string v9, "drmType"

    const-string v10, "AdobeAccess"

    invoke-virtual {v7, v9, v10}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 61
    const-wide/16 v10, 0x3a98

    invoke-virtual {v7, v10, v11}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->setSocketTimeout(J)V

    .line 63
    iget-object v9, p0, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;->authorizationService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v10, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;

    invoke-direct {v10, p0}, Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient$1;-><init>(Lcom/xfinity/playerlib/authorization/VideoAuthorizationClient;)V

    invoke-interface {v9, v7, v10}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;

    .line 70
    .local v4, "responseHandler":Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;->getVideoAuthorization()Lcom/xfinity/playerlib/authorization/VideoAuthorization;

    move-result-object v9

    return-object v9

    .line 39
    .end local v2    # "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    .end local v3    # "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    .end local v4    # "responseHandler":Lcom/xfinity/playerlib/authorization/VideoAuthorizationResponseHandler;
    .end local v5    # "secureMetaData":Ljava/lang/String;
    .end local v6    # "secureMetadataName":Ljava/lang/String;
    .end local v7    # "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    .end local v8    # "xedataDecode":Ljava/lang/String;
    :cond_0
    const-string v9, "proxy/ams/video/access"

    goto :goto_0

    .line 43
    .restart local v2    # "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    .restart local v3    # "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    .restart local v7    # "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    :cond_1
    const-string v6, "svm"

    goto :goto_1

    .line 50
    .restart local v6    # "secureMetadataName":Ljava/lang/String;
    .restart local v8    # "xedataDecode":Ljava/lang/String;
    :cond_2
    invoke-static {p3}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .restart local v5    # "secureMetaData":Ljava/lang/String;
    goto :goto_2
.end method
