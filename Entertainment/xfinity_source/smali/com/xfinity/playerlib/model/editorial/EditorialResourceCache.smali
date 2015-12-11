.class public Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "EditorialResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        "P::",
        "Lcom/xfinity/playerlib/model/editorial/EditorialParser;",
        "R:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<TR;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private final cacheKey:Ljava/lang/String;

.field private final editorialResourceFactory:Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory",
            "<TP;TR;>;"
        }
    .end annotation
.end field

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

.field private final parser:Lcom/xfinity/playerlib/model/editorial/EditorialParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TP;"
        }
    .end annotation
.end field

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

.field private final url:Ljava/lang/String;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Ljava/lang/String;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/xfinity/playerlib/model/editorial/EditorialParser;Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;)V
    .locals 0
    .param p2, "url"    # Ljava/lang/String;
    .param p4, "cacheKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
            "<TT;>;>;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;TP;",
            "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory",
            "<TP;TR;>;)V"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;, "Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache<TT;TP;TR;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;>;"
    .local p3, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    .local p5, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p6, "parser":Lcom/xfinity/playerlib/model/editorial/EditorialParser;, "TP;"
    .local p7, "editorialResourceFactory":Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;, "Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory<TP;TR;>;"
    invoke-direct {p0, p3}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 26
    iput-object p2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->url:Ljava/lang/String;

    .line 27
    iput-object p4, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->cacheKey:Ljava/lang/String;

    .line 28
    iput-object p5, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 29
    iput-object p6, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->parser:Lcom/xfinity/playerlib/model/editorial/EditorialParser;

    .line 30
    iput-object p7, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->editorialResourceFactory:Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;

    .line 31
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;)Lcom/xfinity/playerlib/model/editorial/EditorialParser;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->parser:Lcom/xfinity/playerlib/model/editorial/EditorialParser;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;)Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;

    .prologue
    .line 12
    iget-object v0, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->editorialResourceFactory:Lcom/xfinity/playerlib/model/editorial/EditorialResourceFactory;

    return-object v0
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    .prologue
    .line 35
    .local p0, "this":Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;, "Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache<TT;TP;TR;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->url:Ljava/lang/String;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 36
    .local v0, "baseRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    new-instance v1, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->cacheKey:Ljava/lang/String;

    invoke-direct {v1, v0, v2}, Lcom/comcast/cim/cmasl/http/request/DefaultCacheableRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V

    .line 37
    .local v1, "request":Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider;, "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v3, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache$1;-><init>(Lcom/xfinity/playerlib/model/editorial/EditorialResourceCache;)V

    invoke-interface {v2, v1, v3}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;

    .line 41
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/editorial/EditorialResponseHandler;->getEditorialResponse()Ljava/lang/Object;

    move-result-object v2

    return-object v2
.end method
