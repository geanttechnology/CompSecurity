.class public Lcom/comcast/cim/model/ParentalControlsCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "ParentalControlsCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/comcast/cim/model/user/XipUser;",
        "Ljava/lang/Integer;",
        ">;>;"
    }
.end annotation


# instance fields
.field private final httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
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

.field private final userManager:Lcom/comcast/cim/model/user/UserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/XipUser;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;"
        }
    .end annotation
.end field

.field private final xipServer:Lcom/comcast/cim/cmasl/xip/XipServer;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/xip/XipServer;Lcom/comcast/cim/model/user/UserManager;Lcom/fasterxml/jackson/databind/ObjectMapper;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;)V
    .locals 0
    .param p3, "xipServer"    # Lcom/comcast/cim/cmasl/xip/XipServer;
    .param p5, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/comcast/cim/model/user/XipUser;",
            "Ljava/lang/Integer;",
            ">;>;",
            "Lcom/comcast/cim/cmasl/xip/XipServer;",
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/XipUser;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;",
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
    .line 38
    .local p0, "this":Lcom/comcast/cim/model/ParentalControlsCache;, "Lcom/comcast/cim/model/ParentalControlsCache<TT;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;>;"
    .local p2, "integerRevalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/comcast/cim/model/user/XipUser;Ljava/lang/Integer;>;>;"
    .local p4, "userManager":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<+Lcom/comcast/cim/model/user/XipUser;+Lcom/comcast/cim/model/user/service/UserSettings;>;"
    .local p6, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p7, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 39
    iput-object p4, p0, Lcom/comcast/cim/model/ParentalControlsCache;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 40
    iput-object p1, p0, Lcom/comcast/cim/model/ParentalControlsCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 41
    iput-object p3, p0, Lcom/comcast/cim/model/ParentalControlsCache;->xipServer:Lcom/comcast/cim/cmasl/xip/XipServer;

    .line 42
    iput-object p5, p0, Lcom/comcast/cim/model/ParentalControlsCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 43
    iput-object p6, p0, Lcom/comcast/cim/model/ParentalControlsCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 44
    iput-object p7, p0, Lcom/comcast/cim/model/ParentalControlsCache;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 45
    return-void
.end method

.method static synthetic access$000(Lcom/comcast/cim/model/ParentalControlsCache;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/comcast/cim/model/ParentalControlsCache;

    .prologue
    .line 24
    iget-object v0, p0, Lcom/comcast/cim/model/ParentalControlsCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    .locals 11

    .prologue
    .line 49
    .local p0, "this":Lcom/comcast/cim/model/ParentalControlsCache;, "Lcom/comcast/cim/model/ParentalControlsCache<TT;>;"
    iget-object v8, p0, Lcom/comcast/cim/model/ParentalControlsCache;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v8}, Lcom/comcast/cim/model/user/UserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v7

    check-cast v7, Lcom/comcast/cim/model/user/XipUser;

    .line 50
    .local v7, "user":Lcom/comcast/cim/model/user/XipUser;
    invoke-virtual {v7}, Lcom/comcast/cim/model/user/XipUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v0

    .line 51
    .local v0, "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    invoke-virtual {v7}, Lcom/comcast/cim/model/user/XipUser;->getUserName()Ljava/lang/String;

    move-result-object v1

    .line 52
    .local v1, "cacheKey":Ljava/lang/String;
    iget-object v8, p0, Lcom/comcast/cim/model/ParentalControlsCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v10, p0, Lcom/comcast/cim/model/ParentalControlsCache;->xipServer:Lcom/comcast/cim/cmasl/xip/XipServer;

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v10, "proxy/parentalcontrols/user/summary"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v8, v9}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v4

    .line 53
    .local v4, "requestProvider":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    iget-object v8, p0, Lcom/comcast/cim/model/ParentalControlsCache;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v10

    invoke-interface {v8, v9, v10}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v5

    .line 54
    .local v5, "requestSigner":Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;"
    new-instance v6, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    invoke-direct {v6, v4, v5}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 55
    .local v6, "signedHTTPRequestProvider":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    new-instance v3, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;

    invoke-direct {v3, v6, v1}, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V

    .line 56
    .local v3, "request":Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;"
    iget-object v8, p0, Lcom/comcast/cim/model/ParentalControlsCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v9, Lcom/comcast/cim/model/ParentalControlsCache$1;

    invoke-direct {v9, p0}, Lcom/comcast/cim/model/ParentalControlsCache$1;-><init>(Lcom/comcast/cim/model/ParentalControlsCache;)V

    invoke-interface {v8, v3, v9}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;

    .line 61
    .local v2, "handler":Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;
    invoke-virtual {v2}, Lcom/comcast/cim/http/parentalcontrols/ParentalControlsResponseHandler;->getParentalControlsSettings()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    move-result-object v8

    return-object v8
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 24
    .local p0, "this":Lcom/comcast/cim/model/ParentalControlsCache;, "Lcom/comcast/cim/model/ParentalControlsCache<TT;>;"
    invoke-virtual {p0}, Lcom/comcast/cim/model/ParentalControlsCache;->fetchResourceWithNoCache()Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;

    move-result-object v0

    return-object v0
.end method
