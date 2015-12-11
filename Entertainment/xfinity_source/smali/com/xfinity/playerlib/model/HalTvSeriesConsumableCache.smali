.class public Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;
.source "HalTvSeriesConsumableCache.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
        "Ljava/lang/Integer;",
        ">;"
    }
.end annotation


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
            "<TT;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
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

.field private final hypermediaServiceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;"
        }
    .end annotation
.end field

.field private final merlinId:Lcom/xfinity/playerlib/model/MerlinId;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p5, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p6, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory",
            "<TT;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;",
            "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient",
            "<TT;",
            "Lcom/comcast/cim/cmasl/http/request/RequestProvider",
            "<TT;>;>;",
            "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;",
            ">;",
            "Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            ")V"
        }
    .end annotation

    .prologue
    .line 26
    .local p0, "this":Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;, "Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache<TT;>;"
    .local p1, "entityFactory":Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;, "Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory<TT;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    .local p2, "halHttpClient":Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;, "Lcom/comcast/cim/cmasl/hal/http/HalHttpClient<TT;Lcom/comcast/cim/cmasl/http/request/RequestProvider<TT;>;>;"
    .local p3, "integerRevalidationPolicy":Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;, "Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy<Ljava/lang/Integer;>;"
    .local p4, "hypermediaServiceCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;>;"
    invoke-direct {p0, p3}, Lcom/comcast/cim/cmasl/taskexecutor/task/RevalidatingCachingTask;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/policy/RevalidationPolicy;)V

    .line 27
    iput-object p1, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    .line 28
    iput-object p2, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    .line 29
    iput-object p4, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->hypermediaServiceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 30
    iput-object p5, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 31
    iput-object p6, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 32
    return-void
.end method


# virtual methods
.method protected fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    .locals 7

    .prologue
    .line 36
    .local p0, "this":Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;, "Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache<TT;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->hypermediaServiceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;

    .line 37
    .local v0, "service":Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/MerlinId;->getSimpleId()Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "%d"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 38
    invoke-virtual {v6}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getScreenWidth()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 37
    invoke-virtual {v0, v2, v3}, Lcom/xfinity/playerlib/model/ConsumablesHypermediaService;->getConsumablesUri(Ljava/lang/String;Ljava/lang/String;)Ljava/net/URI;

    move-result-object v1

    .line 40
    .local v1, "uri":Ljava/net/URI;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->entityFactory:Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;

    invoke-virtual {v1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->halHttpClient:Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;

    invoke-virtual {v2, v3, v4}, Lcom/comcast/cim/cmasl/hal/model/HalObjectFactory;->createWithUrl(Ljava/lang/String;Lcom/comcast/cim/cmasl/hal/http/HalHttpClient;)Lcom/comcast/cim/cmasl/hal/model/HalParseable;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    return-object v2
.end method

.method protected bridge synthetic fetchResourceWithNoCache()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 14
    .local p0, "this":Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;, "Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache<TT;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/HalTvSeriesConsumableCache;->fetchResourceWithNoCache()Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    move-result-object v0

    return-object v0
.end method
