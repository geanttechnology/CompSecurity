.class public Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;
.super Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.source "EpisodeDetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$EpisodeDetailFragmentSpeechListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private airdate:Landroid/widget/TextView;

.field private availability:Landroid/widget/TextView;

.field private cast:Landroid/widget/TextView;

.field private combinedListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private combinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private descriptionText:Landroid/widget/TextView;

.field private detailArtView:Landroid/widget/ImageView;

.field private infoEpisodeTitle:Landroid/widget/TextView;

.field private infoSeriesTitle:Landroid/widget/TextView;

.field private layoutInflator:Landroid/view/LayoutInflater;

.field private newIndicator:Landroid/widget/ImageView;

.field private seasonEpisode:Landroid/widget/TextView;

.field private seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
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

.field private seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

.field private speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

.field private videoItemContainer:Landroid/view/ViewGroup;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 69
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    .line 45
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;-><init>()V

    .line 46
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 47
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCombinedTaskExecutorFactory()Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    .line 67
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$EpisodeDetailFragmentSpeechListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$EpisodeDetailFragmentSpeechListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    .line 351
    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 45
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->loadImageArtForSeries(Lcom/xfinity/playerlib/model/MerlinId;)V

    return-void
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p2, "x2"    # Ljava/util/Map;
    .param p3, "x3"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p4, "x4"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 45
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->displayDetail(Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    return-void
.end method

.method private buildAirdateString(Ljava/util/Date;)Ljava/lang/String;
    .locals 4
    .param p1, "originalAirdate"    # Ljava/util/Date;

    .prologue
    .line 299
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->month_day_year_format:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v0

    .line 300
    .local v0, "dateFormatter":Lorg/apache/commons/lang3/time/FastDateFormat;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->airdate:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ": "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0, p1}, Lorg/apache/commons/lang3/time/FastDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private buildEpisodeNumberString(Ljava/lang/Integer;)Ljava/lang/String;
    .locals 3
    .param p1, "episodeNumber"    # Ljava/lang/Integer;

    .prologue
    .line 304
    const/4 v0, 0x0

    .line 305
    .local v0, "episodeString":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-eqz v1, :cond_0

    .line 306
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Ep"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 308
    :cond_0
    return-object v0
.end method

.method private buildSeasonNumberString(Ljava/lang/Integer;)Ljava/lang/String;
    .locals 3
    .param p1, "seasonNumber"    # Ljava/lang/Integer;

    .prologue
    .line 313
    const/4 v0, 0x0

    .line 314
    .local v0, "seasonString":Ljava/lang/String;
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    if-eqz v1, :cond_0

    .line 315
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "S"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 317
    :cond_0
    return-object v0
.end method

.method private displayDetail(Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 9
    .param p1, "tvSeriesFacade"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p3, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p4, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ")V"
        }
    .end annotation

    .prologue
    .line 229
    .local p2, "bookmarks":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->detailArtView:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 231
    invoke-virtual {p0, p4, p3}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getSortedVideos(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/Watchable;)Ljava/util/SortedSet;

    move-result-object v4

    .line 232
    .local v4, "sortedVideos":Ljava/util/SortedSet;, "Ljava/util/SortedSet<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->videoItemContainer:Landroid/view/ViewGroup;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->layoutInflator:Landroid/view/LayoutInflater;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v8, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    move-object v0, p0

    move-object v1, p2

    move-object v2, p4

    move-object v3, p3

    invoke-virtual/range {v0 .. v8}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->addVideoItems(Ljava/util/Map;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/Watchable;Ljava/util/SortedSet;Landroid/view/ViewGroup;Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Ljava/lang/Long;)V

    .line 234
    invoke-virtual {p0, p1, p3}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->present(Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 236
    invoke-interface {v4}, Ljava/util/SortedSet;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 237
    invoke-interface {v4}, Ljava/util/SortedSet;->first()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->showDuration(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 240
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->onLoadingFinished()V

    .line 241
    return-void
.end method

.method private loadImageArtForSeries(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 2
    .param p1, "imageSeriesId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 220
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->detailArtView:Landroid/widget/ImageView;

    if-eqz v0, :cond_0

    .line 221
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->detailArtView:Landroid/widget/ImageView;

    invoke-virtual {v0, p1, v1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadDetailProgramArt(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;)V

    .line 223
    :cond_0
    return-void
.end method


# virtual methods
.method public getDetailLayoutId()I
    .locals 1

    .prologue
    .line 330
    sget v0, Lcom/xfinity/playerlib/R$layout;->series_episode_detail:I

    return v0
.end method

.method public getVideoItemViewContainer()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 335
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->videoItemContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method public loadScreenInfo()V
    .locals 4

    .prologue
    .line 122
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->useDownloadAsSource()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 123
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;)V

    .line 141
    .local v1, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :goto_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 142
    .local v0, "activity":Landroid/app/Activity;
    instance-of v2, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    if-eqz v2, :cond_1

    .line 143
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->combinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 148
    :goto_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->combinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;)V

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->combinedListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 217
    return-void

    .line 138
    .end local v1    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    .restart local v1    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    goto :goto_0

    .line 145
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->combinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    goto :goto_1
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 84
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 85
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 86
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onAttach(Landroid/app/Activity;)V

    .line 74
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 90
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 92
    .local v0, "view":Landroid/view/View;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->layoutInflator:Landroid/view/LayoutInflater;

    .line 93
    sget v1, Lcom/xfinity/playerlib/R$id;->video_item_container:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->videoItemContainer:Landroid/view/ViewGroup;

    .line 94
    sget v1, Lcom/xfinity/playerlib/R$id;->detail_image:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->detailArtView:Landroid/widget/ImageView;

    .line 95
    sget v1, Lcom/xfinity/playerlib/R$id;->info_series_title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->infoSeriesTitle:Landroid/widget/TextView;

    .line 96
    sget v1, Lcom/xfinity/playerlib/R$id;->info_episode_title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->infoEpisodeTitle:Landroid/widget/TextView;

    .line 97
    sget v1, Lcom/xfinity/playerlib/R$id;->season_episode:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seasonEpisode:Landroid/widget/TextView;

    .line 98
    sget v1, Lcom/xfinity/playerlib/R$id;->airdate:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->airdate:Landroid/widget/TextView;

    .line 99
    sget v1, Lcom/xfinity/playerlib/R$id;->cast:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->cast:Landroid/widget/TextView;

    .line 100
    sget v1, Lcom/xfinity/playerlib/R$id;->description:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->descriptionText:Landroid/widget/TextView;

    .line 101
    sget v1, Lcom/xfinity/playerlib/R$id;->new_indicator:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->newIndicator:Landroid/widget/ImageView;

    .line 102
    sget v1, Lcom/xfinity/playerlib/R$id;->availability:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->availability:Landroid/widget/TextView;

    .line 103
    sget v1, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->bodyContainer:Landroid/view/View;

    .line 105
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->setupReviews(Landroid/view/View;)V

    .line 107
    return-object v0
.end method

.method public onDetach()V
    .locals 2

    .prologue
    .line 78
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onDetach()V

    .line 79
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 80
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 112
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onStop()V

    .line 114
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->combinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 115
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->combinedTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->combinedListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 117
    :cond_0
    return-void
.end method

.method public present(Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 12
    .param p1, "tvSeriesFacade"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p2, "episodeFacade"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    const/4 v11, -0x1

    const/16 v10, 0x8

    const/4 v9, 0x1

    const/4 v8, 0x0

    .line 245
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-boolean v4, v4, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->shouldHideSeriesTitle:Z

    if-eqz v4, :cond_0

    .line 246
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->infoSeriesTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 251
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->bodyContainer:Landroid/view/View;

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_describe_scrollable_episode_section:I

    new-array v6, v9, [Ljava/lang/Object;

    .line 252
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeriesTitle()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    .line 251
    invoke-virtual {p0, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 254
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->infoEpisodeTitle:Landroid/widget/TextView;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 255
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->infoEpisodeTitle:Landroid/widget/TextView;

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_add_pause:I

    new-array v6, v9, [Ljava/lang/Object;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-virtual {p0, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 257
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->descriptionText:Landroid/widget/TextView;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDescription()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 258
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->descriptionText:Landroid/widget/TextView;

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_description:I

    new-array v6, v9, [Ljava/lang/Object;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDescription()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-virtual {p0, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 260
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 261
    .local v3, "seasonNumber":I
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v0

    .line 263
    .local v0, "episodeNumber":I
    if-le v3, v11, :cond_1

    if-le v0, v11, :cond_1

    .line 264
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seasonEpisode:Landroid/widget/TextView;

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->buildSeasonNumberString(Ljava/lang/Integer;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v6

    invoke-direct {p0, v6}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->buildEpisodeNumberString(Ljava/lang/Integer;)Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v9

    invoke-virtual {p0, v4, v5}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->updateCompoundTextView(Landroid/widget/TextView;[Ljava/lang/Object;)V

    .line 269
    :goto_1
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v4

    if-eqz v4, :cond_2

    .line 270
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->airdate:Landroid/widget/TextView;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getOriginalAirdate()Ljava/util/Date;

    move-result-object v5

    invoke-direct {p0, v5}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->buildAirdateString(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 271
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->airdate:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 276
    :goto_2
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->isNew()Z

    move-result v4

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->setNew(Z)V

    .line 278
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getExpiresDate()Ljava/util/Date;

    move-result-object v4

    if-eqz v4, :cond_3

    .line 279
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getExpiresDate()Ljava/util/Date;

    move-result-object v4

    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->formatAvailability(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    .line 280
    .local v1, "formattedAvailabilityDate":Ljava/lang/String;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->availability:Landroid/widget/TextView;

    invoke-virtual {v4, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 281
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->availability:Landroid/widget/TextView;

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_add_pause:I

    new-array v6, v9, [Ljava/lang/Object;

    aput-object v1, v6, v8

    invoke-virtual {p0, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 286
    .end local v1    # "formattedAvailabilityDate":Ljava/lang/String;
    :goto_3
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getCast()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_4

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getCast()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_4

    .line 287
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->cast:Landroid/widget/TextView;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getCast()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 288
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->cast:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 289
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->cast:Landroid/widget/TextView;

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_cast:I

    new-array v6, v9, [Ljava/lang/Object;

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getCast()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v6, v8

    invoke-virtual {p0, v5, v6}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 294
    :goto_4
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getReviews()Ljava/util/List;

    move-result-object v2

    .line 295
    .local v2, "reviews":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalReview;>;"
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->presentReviews(Ljava/util/List;)V

    .line 296
    return-void

    .line 248
    .end local v0    # "episodeNumber":I
    .end local v2    # "reviews":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalReview;>;"
    .end local v3    # "seasonNumber":I
    :cond_0
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getSeriesTitle()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->infoSeriesTitle:Landroid/widget/TextView;

    invoke-virtual {p0, v4, v5}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V

    goto/16 :goto_0

    .line 266
    .restart local v0    # "episodeNumber":I
    .restart local v3    # "seasonNumber":I
    :cond_1
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->seasonEpisode:Landroid/widget/TextView;

    invoke-virtual {v4, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_1

    .line 273
    :cond_2
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->airdate:Landroid/widget/TextView;

    invoke-virtual {v4, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_2

    .line 283
    :cond_3
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->availability:Landroid/widget/TextView;

    invoke-virtual {v4, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_3

    .line 291
    :cond_4
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->cast:Landroid/widget/TextView;

    invoke-virtual {v4, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4
.end method

.method protected setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V
    .locals 5
    .param p1, "displayTitle"    # Ljava/lang/String;
    .param p2, "inlineDisplayTitle"    # Landroid/widget/TextView;

    .prologue
    .line 347
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V

    .line 348
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_detail_title:I

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string v4, "Episode"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p1, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->setTitle(Ljava/lang/String;)V

    .line 349
    return-void
.end method

.method public setNew(Z)V
    .locals 2
    .param p1, "isNew"    # Z

    .prologue
    .line 321
    if-eqz p1, :cond_0

    .line 322
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->newIndicator:Landroid/widget/ImageView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 326
    :goto_0
    return-void

    .line 324
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->newIndicator:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0
.end method

.method public showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    .prologue
    .line 340
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Failed to get episode detail"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 341
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->descriptionText:Landroid/widget/TextView;

    sget v1, Lcom/xfinity/playerlib/R$string;->error_not_available_text:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 342
    sget v0, Lcom/xfinity/playerlib/R$string;->error_not_available_text:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailFragment;->onLoadingFailed(I)V

    .line 343
    return-void
.end method
