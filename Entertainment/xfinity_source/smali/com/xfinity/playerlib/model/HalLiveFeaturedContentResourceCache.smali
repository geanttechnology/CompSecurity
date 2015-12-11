.class public Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "HalLiveFeaturedContentResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private final entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
            "<TT;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
            ">;"
        }
    .end annotation
.end field

.field private final halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private final tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/TveHypermediaService;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/TveHypermediaService;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
            "<TT;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 21
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;, "Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache<TT;>;"
    .local p1, "tveHypermediaServicesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/TveHypermediaService;>;"
    .local p2, "entityFactory":Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;, "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory<TT;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;>;"
    .local p3, "halHttpClient":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "integerRevalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    invoke-direct {p0, p4}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 22
    iput-object p1, p0, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;->tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 23
    iput-object p2, p0, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    .line 24
    iput-object p3, p0, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    .line 25
    return-void
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;
    .locals 3

    .prologue
    .line 29
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;, "Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache<TT;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    iget-object v0, p0, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;->tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/TveHypermediaService;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/TveHypermediaService;->getPromotedContentUri()Ljava/net/URI;

    move-result-object v0

    invoke-virtual {v0}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    invoke-virtual {v1, v0, v2}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;

    return-object v0
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 13
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;, "Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/HalLiveFeaturedContentResourceCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;

    move-result-object v0

    return-object v0
.end method
