.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;
.source "StartState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchEpisode(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
        ">;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

.field final synthetic val$merlinId:Lcom/xfinity/playerlib/model/MerlinId;

.field final synthetic val$parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Ljava/lang/Long;Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
    .param p3, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 235
    .local p2, "taskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;->val$merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    iput-object p5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;->val$parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Ljava/lang/Long;)V

    return-void
.end method


# virtual methods
.method protected createWatchable(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 6
    .param p1, "tvSeriesEntity"    # Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    .prologue
    .line 237
    const/4 v2, 0x0

    .line 238
    .local v2, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;->val$merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;->val$parentMerlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/model/MerlinId;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 239
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    .end local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;->val$merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-direct {v2, p1, v3}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 253
    .restart local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_0
    :goto_0
    return-object v2

    .line 243
    :cond_1
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;->getSeasons()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;

    .line 244
    .local v1, "season":Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeason;->getEpisodes()Ljava/util/List;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_3
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_2

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;

    .line 245
    .local v0, "episode":Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getVideos()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-nez v5, :cond_3

    .line 246
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    .end local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalEpisode;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-direct {v2, p1, v3}, Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 247
    .restart local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    goto :goto_0
.end method

.method protected bridge synthetic createWatchable(Ljava/lang/Object;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 1

    .prologue
    .line 235
    check-cast p1, Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;->createWatchable(Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;)Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v0

    return-object v0
.end method
