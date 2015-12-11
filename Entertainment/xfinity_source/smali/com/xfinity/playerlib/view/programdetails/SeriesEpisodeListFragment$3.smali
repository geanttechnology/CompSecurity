.class Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "SeriesEpisodeListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadScreenInfo()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 272
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    .locals 6

    .prologue
    .line 275
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v3

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getVideoId()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    .line 276
    .local v0, "downloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-eqz v0, :cond_0

    .line 277
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v2

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getUuid()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getStoredEntity(Ljava/util/UUID;)Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v1

    .line 278
    .local v1, "either":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    if-eqz v1, :cond_0

    .line 279
    iget-object v2, v1, Lcom/comcast/cim/cmasl/utils/container/Either;->e2:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 283
    .end local v1    # "either":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :goto_0
    return-object v2

    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v3

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-interface {v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    goto :goto_0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 272
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;->execute()Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    move-result-object v0

    return-object v0
.end method
