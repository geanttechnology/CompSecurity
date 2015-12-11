.class Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "EpisodeDetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->loadScreenInfo()V
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
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public execute()Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;
    .locals 6

    .prologue
    .line 126
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getVideoId()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    .line 127
    .local v0, "downloadFile":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-eqz v0, :cond_0

    .line 128
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getUuid()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getStoredEntity(Ljava/util/UUID;)Lcom/comcast/cim/cmasl/utils/container/Either;

    move-result-object v1

    .line 129
    .local v1, "either":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    if-eqz v1, :cond_0

    .line 130
    iget-object v2, v1, Lcom/comcast/cim/cmasl/utils/container/Either;->e2:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .line 134
    .end local v1    # "either":Lcom/comcast/cim/cmasl/utils/container/Either;, "Lcom/comcast/cim/cmasl/utils/container/Either<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :goto_0
    return-object v2

    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

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
    .line 123
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;->execute()Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    move-result-object v0

    return-object v0
.end method
