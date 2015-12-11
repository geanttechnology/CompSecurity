.class public Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
.super Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
.source "SeriesSpeechRecognizer.java"


# instance fields
.field private currentlyPlayingVideoId:Ljava/lang/Long;

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

.field private seriesId:Lcom/xfinity/playerlib/model/MerlinId;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;-><init>()V

    .line 35
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 36
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCombinedTaskExecutorFactory()Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    return-void
.end method

.method static synthetic access$001(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 33
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    return-void
.end method

.method static synthetic access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 33
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V

    return-void
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;Ljava/util/List;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
    .param p1, "x1"    # Ljava/util/List;
    .param p2, "x2"    # [Ljava/lang/String;
    .param p3, "x3"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 33
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->playOrShowIfValidListNumberForSeriesWatchable(Ljava/util/List;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->playOrLoadSeriesWatchable(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$401(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 33
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    return-void
.end method

.method static synthetic access$501(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 33
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V

    return-void
.end method

.method private playOrLoadSeriesWatchable(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 3
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 127
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getVideos()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 129
    .local v0, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v1}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 130
    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->playSeriesWatchable(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 135
    :goto_0
    const/4 v1, 0x1

    .line 137
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :goto_1
    return v1

    .line 132
    .restart local v0    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_0
    invoke-direct {p0, v0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    goto :goto_0

    .line 137
    .end local v0    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private playOrShowIfValidListNumberForSeriesWatchable(Ljava/util/List;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 7
    .param p2, "terms"    # [Ljava/lang/String;
    .param p3, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;",
            ">;[",
            "Ljava/lang/String;",
            "Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;",
            ")Z"
        }
    .end annotation

    .prologue
    .local p1, "results":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 111
    array-length v3, p2

    if-ne v3, v2, :cond_0

    .line 112
    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->alternateInterfaceUtil:Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;

    aget-object v4, p2, v1

    invoke-virtual {v3, v4}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceUtil;->interpretIfNumber(Ljava/lang/String;)I

    move-result v0

    .line 114
    .local v0, "justaNumber":I
    const/4 v3, -0x1

    if-le v0, v3, :cond_0

    .line 115
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    if-gt v0, v3, :cond_1

    .line 116
    add-int/lit8 v1, v0, -0x1

    invoke-interface {p1, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    invoke-direct {p0, v1, p3}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->playOrLoadSeriesWatchable(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    :goto_0
    move v1, v2

    .line 123
    .end local v0    # "justaNumber":I
    :cond_0
    return v1

    .line 118
    .restart local v0    # "justaNumber":I
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->list_number_invalid:I

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v1

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    aput-object v1, v5, v2

    invoke-virtual {p0, v4, v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private playSeriesWatchable(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V
    .locals 2
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 142
    invoke-static {p2, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v0

    .line 143
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 144
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 146
    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechActions;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->closeWithAction(Lcom/comcast/cim/android/accessibility/SpeechActions;)V

    .line 147
    return-void
.end method

.method private showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 10
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 152
    new-instance v2, Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-direct {v2, p2, p1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;-><init>(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 154
    .local v2, "watchableKey":Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v3, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    const/4 v4, 0x0

    .line 155
    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v4

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 156
    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const-wide/16 v8, -0x1

    cmp-long v3, v6, v8

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->currentlyPlayingVideoId:Ljava/lang/Long;

    :goto_0
    invoke-virtual {v4, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 157
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->episodeId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 158
    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 159
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 161
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    new-instance v1, Landroid/content/Intent;

    const-class v3, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    invoke-direct {v1, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 162
    .local v1, "intent":Landroid/content/Intent;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 163
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 165
    sget-object v3, Lcom/comcast/cim/android/accessibility/SpeechActions;->OPEN:Lcom/comcast/cim/android/accessibility/SpeechActions;

    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->closeWithAction(Lcom/comcast/cim/android/accessibility/SpeechActions;)V

    .line 166
    return-void

    .line 156
    .end local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method


# virtual methods
.method public attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 3
    .param p1, "terms"    # [Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 57
    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v1}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 58
    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->access$001(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    .line 106
    :goto_0
    return-void

    .line 64
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    iget-object v2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    .line 65
    .local v0, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 67
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;

    invoke-direct {v2, p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1

    .prologue
    .line 170
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 48
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onCreate(Landroid/os/Bundle;)V

    .line 50
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "INTENT_KEY_SERIES_ID"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/MerlinId;

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    .line 51
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "INTENT_KEY_CURRENTLY_PLAYING_VIDEO_ID"

    const-wide/16 v2, -0x1

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 52
    return-void
.end method
