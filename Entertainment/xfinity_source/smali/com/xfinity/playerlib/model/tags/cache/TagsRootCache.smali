.class public Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "TagsRootCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private final cacheKey:Ljava/lang/String;

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

.field private final hypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;"
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

.field private final tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/xfinity/playerlib/model/tags/parser/TagsParser;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;)V
    .locals 0
    .param p4, "cacheKey"    # Ljava/lang/String;
    .param p5, "tagsParser"    # Lcom/xfinity/playerlib/model/tags/parser/TagsParser;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsParser;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;)V"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache<TT;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;>;"
    .local p2, "hypermediaServicesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;>;"
    .local p3, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    .local p6, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0, p3}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->hypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 29
    iput-object p4, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->cacheKey:Ljava/lang/String;

    .line 30
    iput-object p5, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    .line 31
    iput-object p6, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 32
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;)Lcom/xfinity/playerlib/model/tags/parser/TagsParser;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->tagsParser:Lcom/xfinity/playerlib/model/tags/parser/TagsParser;

    return-object v0
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    .locals 5

    .prologue
    .line 36
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache<TT;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->hypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;

    .line 37
    .local v2, "service":Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;->getTagsUri()Ljava/net/URI;

    move-result-object v4

    invoke-virtual {v4}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 38
    .local v0, "baseRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    new-instance v1, Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->cacheKey:Ljava/lang/String;

    invoke-direct {v1, v0, v3}, Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider;-><init>(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Ljava/lang/String;)V

    .line 39
    .local v1, "request":Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider;, "Lcom/xfinity/playerlib/model/tags/http/TagsRequestProvider<TT;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v4, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache$1;-><init>(Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;)V

    invoke-interface {v3, v1, v4}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;

    .line 44
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/tags/http/TagsResponseHandler;->getTagsRoot()Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    move-result-object v3

    return-object v3
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 17
    .local p0, "this":Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;, "Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/tags/cache/TagsRootCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    move-result-object v0

    return-object v0
.end method
