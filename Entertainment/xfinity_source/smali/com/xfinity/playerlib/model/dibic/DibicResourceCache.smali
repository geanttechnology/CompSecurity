.class public Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "DibicResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final cacheKey:Ljava/lang/String;

.field private final dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

.field private final dibicUriProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Ljava/net/URI;",
            ">;"
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

.field private final programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

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

.field private final tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;"
        }
    .end annotation
.end field

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/http/service/HttpService;Lcom/comcast/cim/cmasl/utils/provider/Provider;Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;Lcom/xfinity/playerlib/model/dibic/DibicParser;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;)V
    .locals 1
    .param p3, "programFactory"    # Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;
    .param p6, "cacheKey"    # Ljava/lang/String;
    .param p8, "dibicParser"    # Lcom/xfinity/playerlib/model/dibic/DibicParser;
    .param p9, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/http/service/HttpService",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Ljava/net/URI;",
            ">;",
            "Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory",
            "<",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/xfinity/playerlib/model/dibic/DibicParser;",
            "Lcom/xfinity/playerlib/model/user/PlayNowUserManager;",
            ")V"
        }
    .end annotation

    .prologue
    .line 40
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache<TT;>;"
    .local p1, "httpService":Lcom/comcast/cim/cmasl/http/service/HttpService;, "Lcom/comcast/cim/cmasl/http/service/HttpService<TT;Lcom/comcast/cim/cmasl/http/request/CacheableRequestProvider<TT;>;>;"
    .local p2, "dibicUriProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Ljava/net/URI;>;"
    .local p4, "tagsRootCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;>;"
    .local p5, "revalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    .local p7, "requestProviderFactory":Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;, "Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory<Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    invoke-direct {p0, p5}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 24
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->LOG:Lorg/slf4j/Logger;

    .line 41
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 42
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 43
    invoke-static {p4}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 44
    iput-object p1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    .line 45
    iput-object p3, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    .line 46
    iput-object p4, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 47
    iput-object p6, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->cacheKey:Ljava/lang/String;

    .line 48
    iput-object p2, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->dibicUriProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    .line 49
    iput-object p7, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    .line 50
    iput-object p8, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

    .line 51
    iput-object p9, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 52
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/xfinity/playerlib/model/dibic/DibicParser;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->dibicParser:Lcom/xfinity/playerlib/model/dibic/DibicParser;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;

    .prologue
    .line 22
    iget-object v0, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 5

    .prologue
    .line 71
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache<TT;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->requestProviderFactory:Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->dibicUriProvider:Lcom/comcast/cim/cmasl/utils/provider/Provider;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/utils/provider/Provider;->get()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/net/URI;

    invoke-virtual {v2}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v3, v2}, Lcom/comcast/cim/cmasl/http/request/RequestProviderFactory;->create(Ljava/lang/String;)Lcom/comcast/cim/cmasl/http/request/RequestProvider;

    move-result-object v0

    .line 72
    .local v0, "baseRequest":Lcom/comcast/cim/cmasl/http/request/RequestProvider;, "Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;"
    new-instance v1, Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->programFactory:Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->cacheKey:Ljava/lang/String;

    invoke-direct {v1, v3, v2, v4, v0}, Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;-><init>(Lcom/xfinity/playerlib/model/etc/DibicProgramFactory;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Ljava/lang/String;Lcom/comcast/cim/cmasl/http/request/RequestProvider;)V

    .line 73
    .local v1, "request":Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider;, "Lcom/xfinity/playerlib/model/dibic/DibicRequestProvider<TT;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->httpService:Lcom/comcast/cim/cmasl/http/service/HttpService;

    new-instance v3, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache$1;-><init>(Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;)V

    invoke-interface {v2, v1, v3}, Lcom/comcast/cim/cmasl/http/service/HttpService;->executeRequest(Lcom/comcast/cim/cmasl/http/request/RequestProvider;Lcom/comcast/cim/cmasl/utils/provider/Provider;)Lcom/comcast/cim/cmasl/http/response/ResponseHandler;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;

    .line 78
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/dibic/DibicResponseHandler;->getDibicResource()Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v2

    return-object v2
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 22
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v0

    return-object v0
.end method

.method public getCachedResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 2

    .prologue
    .line 61
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache<TT;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->tagsRootCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 62
    .local v0, "cachedTagsRoot":Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    if-nez v0, :cond_0

    .line 63
    const/4 v1, 0x0

    .line 66
    :goto_0
    return-object v1

    :cond_0
    invoke-super {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;->getCachedResultIfAvailable()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    goto :goto_0
.end method

.method public bridge synthetic getCachedResultIfAvailable()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 22
    .local p0, "this":Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;, "Lcom/xfinity/playerlib/model/dibic/DibicResourceCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/dibic/DibicResourceCache;->getCachedResultIfAvailable()Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v0

    return-object v0
.end method
