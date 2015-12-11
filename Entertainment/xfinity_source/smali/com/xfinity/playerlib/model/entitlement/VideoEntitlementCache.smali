.class public Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "VideoEntitlementCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/comcast/cim/model/user/XipUser;",
        "Ljava/lang/Integer;",
        ">;>;"
    }
.end annotation


# instance fields
.field private httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;
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

.field private userManager:Lcom/comcast/cim/model/user/UserManager;
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


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/model/user/UserManager;Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;Lcom/fasterxml/jackson/databind/ObjectMapper;)V
    .locals 0
    .param p6, "objectMapper"    # Lcom/fasterxml/jackson/databind/ObjectMapper;
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
            "Lcom/comcast/cim/model/user/UserManager",
            "<+",
            "Lcom/comcast/cim/model/user/XipUser;",
            "+",
            "Lcom/comcast/cim/model/user/service/UserSettings;",
            ">;",
            "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner",
            "<TT;>;>;",
            "Lcom/fasterxml/jackson/databind/ObjectMapper;",
            ")V"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;, "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache<TT;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;>;"
    .local p2, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/comcast/cim/model/user/XipUser;Ljava/lang/Integer;>;>;"
    .local p3, "userManager":Lcom/comcast/cim/model/user/UserManager;, "Lcom/comcast/cim/model/user/UserManager<+Lcom/comcast/cim/model/user/XipUser;+Lcom/comcast/cim/model/user/service/UserSettings;>;"
    .local p4, "requestProviderFactory":Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;, "Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p5, "requestSignerFactory":Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;, "Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory<Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner<TT;>;>;"
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 36
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 37
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    iput-object p1, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 39
    iput-object p3, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->userManager:Lcom/comcast/cim/model/user/UserManager;

    .line 40
    iput-object p4, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    .line 41
    iput-object p5, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    .line 42
    iput-object p6, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    .line 43
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;)Lcom/fasterxml/jackson/databind/ObjectMapper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->objectMapper:Lcom/fasterxml/jackson/databind/ObjectMapper;

    return-object v0
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 9

    .prologue
    .line 47
    .local p0, "this":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;, "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache<TT;>;"
    iget-object v6, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->userManager:Lcom/comcast/cim/model/user/UserManager;

    invoke-virtual {v6}, Lcom/comcast/cim/model/user/UserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v5

    check-cast v5, Lcom/comcast/cim/model/user/XipUser;

    .line 48
    .local v5, "user":Lcom/comcast/cim/model/user/XipUser;
    invoke-virtual {v5}, Lcom/comcast/cim/model/user/XipUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v0

    .line 49
    .local v0, "authKeys":Lcom/comcast/cim/model/user/AuthKeys;
    invoke-virtual {v5}, Lcom/comcast/cim/model/user/XipUser;->getUserName()Ljava/lang/String;

    move-result-object v2

    .line 51
    .local v2, "cacheKey":Ljava/lang/String;
    iget-object v6, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;

    const-string v7, "proxy/edata/entitlement"

    invoke-virtual {v6, v7}, Lcom/comcast/cim/cmasl/xip/XipRequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v1

    .line 52
    .local v1, "baseRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    new-instance v4, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;

    iget-object v6, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->requestSignerFactory:Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerKey()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0}, Lcom/comcast/cim/model/user/AuthKeys;->getConsumerSecret()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v7, v8}, Lcom/comcast/cim/cmasl/http/request/signing/RequestSignerFactory;->create(Ljava/lang/String;Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;

    move-result-object v6

    invoke-direct {v4, v1, v6}, Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/http/request/signing/RequestSigner;)V

    .line 53
    .local v4, "signedRequest":Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/signing/SignedHTTPRequestProvider<TT;>;"
    new-instance v3, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;

    invoke-direct {v3, v4, v2}, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V

    .line 55
    .local v3, "request":Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;"
    iget-object v6, p0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v7, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;

    invoke-direct {v7, p0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache$1;-><init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;)V

    invoke-interface {v6, v3, v7}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;

    .line 60
    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/entitlement/EntitlementResponseHandler;->getVideoEntitlement()Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v6

    return-object v6
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 23
    .local p0, "this":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;, "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlementCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v0

    return-object v0
.end method
