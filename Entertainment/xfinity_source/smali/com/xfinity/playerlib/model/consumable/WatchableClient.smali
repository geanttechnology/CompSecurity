.class public Lcom/xfinity/playerlib/model/consumable/WatchableClient;
.super Ljava/lang/Object;
.source "WatchableClient.java"


# instance fields
.field private final movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private final tvSeriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private final watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;)V
    .locals 0
    .param p3, "watchableCodec"    # Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;",
            "Lcom/xfinity/playerlib/model/consumable/WatchableCodec;",
            ")V"
        }
    .end annotation

    .prologue
    .line 13
    .local p1, "movieCacheMap":Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;"
    .local p2, "tvSeriesCacheMap":Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 14
    iput-object p1, p0, Lcom/xfinity/playerlib/model/consumable/WatchableClient;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 15
    iput-object p2, p0, Lcom/xfinity/playerlib/model/consumable/WatchableClient;->tvSeriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 16
    iput-object p3, p0, Lcom/xfinity/playerlib/model/consumable/WatchableClient;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    .line 17
    return-void
.end method


# virtual methods
.method public fetchWatchable(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 5
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 20
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    .line 22
    .local v1, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->isMovie()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 23
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/WatchableClient;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    invoke-interface {v4, v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .line 24
    .local v2, "movieEntity":Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    invoke-direct {v0, p1, v2}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)V

    .line 29
    .end local v2    # "movieEntity":Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    .local v0, "encodedWatchable":Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/WatchableClient;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    invoke-virtual {v4, v0}, Lcom/xfinity/playerlib/model/consumable/WatchableCodec;->decode(Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v4

    return-object v4

    .line 26
    .end local v0    # "encodedWatchable":Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
    :cond_0
    iget-object v4, p0, Lcom/xfinity/playerlib/model/consumable/WatchableClient;->tvSeriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    invoke-interface {v4, v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 27
    .local v3, "tvSeriesEntity":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    new-instance v0, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;

    invoke-direct {v0, p1, v3}, Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)V

    .restart local v0    # "encodedWatchable":Lcom/xfinity/playerlib/model/consumable/EncodedWatchable;
    goto :goto_0
.end method
