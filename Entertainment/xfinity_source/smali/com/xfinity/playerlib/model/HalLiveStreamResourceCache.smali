.class public Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "HalLiveStreamResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
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
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
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

.field private final playerConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

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
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/xfinity/playerlib/config/PlayerConfiguration;)V
    .locals 0
    .param p5, "playerConfiguration"    # Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/TveHypermediaService;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
            "<TT;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ")V"
        }
    .end annotation

    .prologue
    .line 24
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;, "Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache<TT;>;"
    .local p1, "tveHypermediaServicesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/TveHypermediaService;>;"
    .local p2, "entityFactory":Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;, "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory<TT;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    .local p3, "halHttpClient":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p4, "integerRevalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    invoke-direct {p0, p4}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 25
    iput-object p1, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 26
    iput-object p2, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    .line 27
    iput-object p3, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    .line 28
    iput-object p5, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->playerConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 29
    return-void
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    .locals 3

    .prologue
    .line 33
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;, "Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache<TT;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->tveHypermediaServicesCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/TveHypermediaService;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/TveHypermediaService;->getStremsUri()Ljava/net/URI;

    move-result-object v1

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v0

    .line 34
    .local v0, "streamsUrl":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->playerConfiguration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDarkStreamsEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 35
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "?dark=true"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 37
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    invoke-virtual {v1, v0, v2}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    return-object v1
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 12
    .local p0, "this":Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;, "Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/HalLiveStreamResourceCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    move-result-object v0

    return-object v0
.end method
