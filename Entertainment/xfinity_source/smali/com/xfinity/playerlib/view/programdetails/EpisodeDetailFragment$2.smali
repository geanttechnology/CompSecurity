.class Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
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
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
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
    .line 148
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "e"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 213
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->onLoadingFailed()V

    .line 214
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V
    .locals 14
    .param p1, "resource"    # Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .prologue
    .line 151
    iget-object v2, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 152
    .local v2, "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v5, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .line 153
    .local v5, "tvSeriesFacade":Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    iget-object v1, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 155
    .local v1, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v9

    # invokes: Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->loadImageArtForSeries(Lcom/xfinity/playerlib/model/MerlinId;)V
    invoke-static {v8, v9}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 157
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v8

    invoke-interface {v1, v8}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    .line 161
    .local v0, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    if-eqz v0, :cond_c

    .line 162
    const/4 v7, 0x0

    .line 163
    .local v7, "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->useDownloadAsSource()Z

    move-result v8

    if-eqz v8, :cond_4

    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    if-nez v8, :cond_4

    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->hasValidVideoId()Z

    move-result v8

    if-nez v8, :cond_4

    .line 164
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getVideoId()J

    move-result-wide v8

    invoke-virtual {v5, v8, v9}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->findWatchableByVideoId(J)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    move-result-object v7

    .line 174
    :cond_0
    :goto_0
    if-nez v7, :cond_3

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v8

    if-lez v8, :cond_3

    .line 175
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v4

    .line 176
    .local v4, "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->companyId:Ljava/lang/Long;

    if-nez v8, :cond_1

    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-boolean v8, v8, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v8, :cond_a

    .line 179
    :cond_1
    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_2
    :goto_1
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 180
    .local v3, "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    if-eqz v7, :cond_7

    .line 201
    .end local v3    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .end local v4    # "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_3
    :goto_2
    if-nez v7, :cond_b

    .line 202
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    new-instance v9, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string v11, "No consumables available for "

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v9}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V

    .line 209
    .end local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :goto_3
    return-void

    .line 165
    .restart local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_4
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->useEpisodeId()Z

    move-result v8

    if-eqz v8, :cond_5

    .line 166
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v5, v8}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->findEpisodeById(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    move-result-object v7

    goto :goto_0

    .line 167
    :cond_5
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->hasNonEpisodeID()Z

    move-result v8

    if-eqz v8, :cond_6

    .line 168
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->nonEpisodeVideoId:Ljava/lang/Long;

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-virtual {v5, v8, v9}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->findWatchableByVideoId(J)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    move-result-object v7

    goto/16 :goto_0

    .line 169
    :cond_6
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->hasValidVideoId()Z

    move-result v8

    if-eqz v8, :cond_0

    .line 170
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v8, v8, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->videoId:Ljava/lang/Long;

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-virtual {v5, v8, v9}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->findWatchableByVideoId(J)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    move-result-object v7

    goto/16 :goto_0

    .line 184
    .restart local v3    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .restart local v4    # "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_7
    invoke-interface {v3}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getVideos()Ljava/util/Set;

    move-result-object v9

    invoke-interface {v9}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_8
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v10

    if-eqz v10, :cond_2

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 185
    .local v6, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v10, v10, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v10, v10, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->companyId:Ljava/lang/Long;

    if-eqz v10, :cond_9

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v10

    if-eqz v10, :cond_9

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v10

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v10

    iget-object v12, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v12, v12, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v12, v12, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->companyId:Ljava/lang/Long;

    invoke-virtual {v12}, Ljava/lang/Long;->longValue()J

    move-result-wide v12

    cmp-long v10, v10, v12

    if-nez v10, :cond_9

    .line 186
    move-object v7, v3

    .line 187
    goto/16 :goto_1

    .line 188
    :cond_9
    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v10, v10, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-boolean v10, v10, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v10, :cond_8

    .line 189
    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v2, v10}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_8

    .line 190
    move-object v7, v3

    .line 191
    goto/16 :goto_1

    .line 197
    .end local v3    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .end local v6    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_a
    const/4 v8, 0x0

    invoke-interface {v4, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    .end local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    check-cast v7, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .restart local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    goto/16 :goto_2

    .line 204
    .end local v4    # "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_b
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    iget-object v9, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    iget-object v10, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->bookmarkMap:Ljava/util/Map;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->displayDetail(Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    invoke-static {v8, v9, v10, v7, v2}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    goto/16 :goto_3

    .line 207
    .end local v7    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_c
    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    new-instance v9, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    const-string v10, "Series was not found"

    invoke-direct {v9, v10}, Lcom/comcast/cim/cmasl/utils/exceptions/CimException;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v9}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V

    goto/16 :goto_3
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 148
    check-cast p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;->onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V

    return-void
.end method
