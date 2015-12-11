.class public Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;
.super Ljava/lang/Object;
.source "TitaniumTicketClient.java"


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

.field private final titaniumTicketService:Lcom/comcast/cim/cmasl/http/service/HttpService;
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
    .line 29
    .local p0, "this":Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;, "Lcom/xfinity/playerlib/downloads/TitaniumTicketClient<TT;>;"
    .local p1, "titaniumTicketService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    iput-object p1, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->titaniumTicketService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 31
    iput-object p2, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 32
    iput-object p3, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 33
    iput-object p4, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 34
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    .prologue
    .line 19
    iget-object v0, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method public getTitaniumTicket(Lcom/comcast/cim/model/user/AuthKeys;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .locals 9
    .param p1, "authKeys"    # Lcom/comcast/cim/model/user/AuthKeys;
    .param p2, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p3, "videoProfile"    # Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    .prologue
    .line 37
    .local p0, "this":Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;, "Lcom/xfinity/playerlib/downloads/TitaniumTicketClient<TT;>;"
    iget-object v6, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    const-string v7, "proxy/ams/video/titanium-access"

    const-string v8, "POST"

    invoke-virtual {v6, v7, v8}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 38
    .local v0, "baseRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    new-instance v3, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    iget-object v6, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p1}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v7, v8}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v6

    invoke-direct {v3, v0, v6}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 43
    .local v3, "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    :try_start_0
    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->getXedata()Ljava/lang/String;

    move-result-object v6

    const-string v7, "UTF-8"

    invoke-static {v6, v7}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 44
    .local v5, "xedataDecode":Ljava/lang/String;
    invoke-virtual {p3}, Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;->getSecData()Ljava/lang/String;

    move-result-object v6

    const-string v7, "UTF-8"

    invoke-static {v6, v7}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/io/UnsupportedEncodingException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v4

    .line 49
    .local v4, "svmDecode":Ljava/lang/String;
    const-string v6, "mso"

    const-string v7, "comcast"

    invoke-virtual {v3, v6, v7}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 50
    const-string v6, "svm"

    invoke-virtual {v3, v6, v4}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 51
    const-string v6, "xedata"

    invoke-virtual {v3, v6, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 52
    const-string v6, "drmType"

    const-string v7, "adobeAccess"

    invoke-virtual {v3, v6, v7}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->addHttpEntityParameter(Ljava/lang/String;Ljava/lang/String;)V

    .line 54
    const-wide/16 v6, 0x3a98

    invoke-virtual {v3, v6, v7}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;->setSocketTimeout(J)V

    .line 56
    iget-object v6, p0, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;->titaniumTicketService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v7, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;

    invoke-direct {v7, p0}, Lcom/xfinity/playerlib/downloads/TitaniumTicketClient$1;-><init>(Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;)V

    invoke-interface {v6, v3, v7}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;

    .line 63
    .local v2, "responseHandler":Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;->getTitaniumTicket()Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    move-result-object v6

    return-object v6

    .line 45
    .end local v2    # "responseHandler":Lcom/xfinity/playerlib/downloads/TitaniumTicketResponseHandler;
    .end local v4    # "svmDecode":Ljava/lang/String;
    .end local v5    # "xedataDecode":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 46
    .local v1, "e":Ljava/io/UnsupportedEncodingException;
    new-instance v6, Ljava/lang/RuntimeException;

    invoke-direct {v6, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v6
.end method
