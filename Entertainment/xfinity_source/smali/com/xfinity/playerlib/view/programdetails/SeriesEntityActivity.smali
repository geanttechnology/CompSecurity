.class public Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
.super Lcom/xfinity/playerlib/view/programdetails/DetailActivity;
.source "SeriesEntityActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;
.implements Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;,
        Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;,
        Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private bodyContainer:Landroid/view/View;

.field private final connection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

.field private fm:Landroid/app/FragmentManager;

.field private instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

.field private isDualPanel:Z

.field private loadingIndicator:Landroid/view/View;

.field private loadingInfoText:Landroid/widget/TextView;

.field private loadingProgressBar:Landroid/widget/ProgressBar;

.field private loadingRetryButton:Landroid/widget/Button;

.field private final networkReceiver:Landroid/content/BroadcastReceiver;

.field private final pendingListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private final proxyTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private final proxyTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private receiverRegistered:Z

.field private final seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
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

.field private final seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

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

.field private waitingForInternet:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 48
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 47
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;-><init>()V

    .line 57
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->fm:Landroid/app/FragmentManager;

    .line 60
    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    .line 62
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->connection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 63
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 64
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCombinedTaskExecutorFactory()Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    .line 65
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 66
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 67
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->proxyTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 68
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->proxyTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 71
    iput-boolean v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->receiverRegistered:Z

    .line 72
    iput-boolean v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->waitingForInternet:Z

    .line 74
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->networkReceiver:Landroid/content/BroadcastReceiver;

    .line 383
    invoke-static {}, Lcom/google/common/collect/Sets;->newHashSet()Ljava/util/HashSet;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;

    .line 406
    return-void
.end method

.method static synthetic access$200()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 47
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 47
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->waitingForInternet:Z

    return v0
.end method

.method static synthetic access$302(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 47
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->waitingForInternet:Z

    return p1
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->triggerLoading()V

    return-void
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Ljava/util/Set;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;

    return-object v0
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .prologue
    .line 47
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->showError()V

    return-void
.end method

.method private initDataProvider()V
    .locals 3

    .prologue
    .line 292
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->useDownloadAsSource()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 293
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$3;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$3;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    .line 311
    .local v0, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 312
    return-void

    .line 308
    .end local v0    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    .restart local v0    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    goto :goto_0
.end method

.method private showError()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 370
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->connection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 371
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->loading_exception:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 372
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 373
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingRetryButton:Landroid/widget/Button;

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 374
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 381
    :goto_0
    return-void

    .line 376
    :cond_0
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Connection error, enter waiting state"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;)V

    .line 377
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->waiting_for_internet:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 378
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingInfoText:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 379
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->waitingForInternet:Z

    goto :goto_0
.end method

.method private triggerLoading()V
    .locals 2

    .prologue
    .line 349
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingProgressBar:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 350
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingInfoText:Landroid/widget/TextView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 351
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingRetryButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 352
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->proxyTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 353
    return-void
.end method


# virtual methods
.method protected getEpisodeDetailActivityClass()Ljava/lang/Class;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation

    .prologue
    .line 241
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    return-object v0
.end method

.method protected getInstanceState()Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;
    .locals 1

    .prologue
    .line 263
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    return-object v0
.end method

.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 99
    sget v0, Lcom/xfinity/playerlib/R$layout;->series_entity:I

    return v0
.end method

.method protected getSpeechRecognizerClass()Ljava/lang/Class;
    .locals 1

    .prologue
    .line 435
    const-class v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    return-object v0
.end method

.method getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 340
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    if-eqz v0, :cond_0

    .line 341
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Returning proxy resource provider for dual panel view"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 342
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->proxyTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 344
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    goto :goto_0
.end method

.method public hideLoading()V
    .locals 2

    .prologue
    .line 365
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->bodyContainer:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 366
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingIndicator:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 367
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 12
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v9, 0x0

    const/4 v8, 0x1

    .line 105
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->onCreate(Landroid/os/Bundle;)V

    .line 107
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getIntent()Landroid/content/Intent;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 109
    .local v1, "bundle":Landroid/os/Bundle;
    const-string v7, "KEY_ANNOUNCE_EPISODES"

    invoke-virtual {v1, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 111
    .local v0, "announceListOnLoad":Z
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->fromBundle(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    move-result-object v7

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    .line 113
    sget v7, Lcom/xfinity/playerlib/R$id;->fragment_container_2:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    if-eqz v7, :cond_3

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v7}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v7

    if-nez v7, :cond_3

    move v7, v8

    :goto_0
    iput-boolean v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    .line 115
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->initDataProvider()V

    .line 116
    sget v7, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingIndicator:Landroid/view/View;

    .line 117
    sget v7, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->bodyContainer:Landroid/view/View;

    .line 118
    sget v7, Lcom/xfinity/playerlib/R$id;->loading_info_text:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingInfoText:Landroid/widget/TextView;

    .line 119
    sget v7, Lcom/xfinity/playerlib/R$id;->loading_retry_button:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/Button;

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingRetryButton:Landroid/widget/Button;

    .line 120
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingRetryButton:Landroid/widget/Button;

    if-eqz v7, :cond_0

    .line 121
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingRetryButton:Landroid/widget/Button;

    new-instance v10, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$2;

    invoke-direct {v10, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    invoke-virtual {v7, v10}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    :cond_0
    sget v7, Lcom/xfinity/playerlib/R$id;->loading_progressbar:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/ProgressBar;

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingProgressBar:Landroid/widget/ProgressBar;

    .line 130
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->fm:Landroid/app/FragmentManager;

    invoke-virtual {v7}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v6

    .line 132
    .local v6, "ft":Landroid/app/FragmentTransaction;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->fm:Landroid/app/FragmentManager;

    const-string v10, "episodeList"

    invoke-virtual {v7, v10}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .line 134
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    if-nez v7, :cond_1

    .line 136
    new-instance v10, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    sget-object v11, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-direct {v10, v7, v11}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/view/BaseInstanceState;Lcom/xfinity/playerlib/model/MerlinId$Namespace;)V

    iget-boolean v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    if-nez v7, :cond_4

    move v7, v8

    .line 138
    :goto_1
    invoke-virtual {v10, v7}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showSeriesArt(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v7

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v10, v10, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    .line 139
    invoke-virtual {v7, v10}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v10

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v7, v7, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    if-nez v7, :cond_5

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-boolean v7, v7, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v7, :cond_5

    move v7, v8

    .line 140
    :goto_2
    invoke-virtual {v10, v7}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v7

    .line 141
    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v3

    .line 143
    .local v3, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    new-instance v7, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-direct {v7}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;-><init>()V

    iput-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .line 145
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v7

    const-string v10, "KEY_ANNOUNCE_EPISODES"

    invoke-virtual {v7, v10, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 147
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v4

    .line 148
    .local v4, "fragBundle":Landroid/os/Bundle;
    const-string v7, "KEY_ANNOUNCE_EPISODES"

    invoke-virtual {v4, v7, v0}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 150
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-virtual {v7, v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->setArguments(Landroid/os/Bundle;)V

    .line 153
    sget v7, Lcom/xfinity/playerlib/R$id;->fragment_container_1:I

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    const-string v11, "episodeList"

    invoke-virtual {v6, v7, v10, v11}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 156
    .end local v3    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    .end local v4    # "fragBundle":Landroid/os/Bundle;
    :cond_1
    iget-boolean v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    if-eqz v7, :cond_2

    .line 157
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->fm:Landroid/app/FragmentManager;

    const-string v10, "detail"

    invoke-virtual {v7, v10}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;

    .line 158
    .local v2, "detailFragment":Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    if-nez v2, :cond_2

    .line 159
    new-instance v7, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    sget-object v11, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-direct {v7, v10, v11}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/view/BaseInstanceState;Lcom/xfinity/playerlib/model/MerlinId$Namespace;)V

    .line 160
    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v7

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v10, v10, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    .line 161
    invoke-virtual {v7, v10}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v7

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v10, v10, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    if-nez v10, :cond_6

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-boolean v10, v10, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v10, :cond_6

    .line 162
    :goto_3
    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v7

    .line 163
    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v7

    .line 164
    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getFragment()Landroid/app/Fragment;

    move-result-object v5

    .line 166
    .local v5, "fragment":Landroid/app/Fragment;
    sget v7, Lcom/xfinity/playerlib/R$id;->fragment_container_2:I

    const-string v8, "detail"

    invoke-virtual {v6, v7, v5, v8}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 170
    .end local v2    # "detailFragment":Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    .end local v5    # "fragment":Landroid/app/Fragment;
    :cond_2
    invoke-virtual {v6}, Landroid/app/FragmentTransaction;->commit()I

    .line 172
    return-void

    .end local v6    # "ft":Landroid/app/FragmentTransaction;
    :cond_3
    move v7, v9

    .line 113
    goto/16 :goto_0

    .restart local v6    # "ft":Landroid/app/FragmentTransaction;
    :cond_4
    move v7, v9

    .line 136
    goto/16 :goto_1

    :cond_5
    move v7, v9

    .line 139
    goto :goto_2

    .restart local v2    # "detailFragment":Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
    :cond_6
    move v8, v9

    .line 161
    goto :goto_3
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 6
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 253
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 254
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->speech_playing_x:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getTitle()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 257
    :cond_0
    invoke-static {p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)Landroid/content/Intent;

    move-result-object v0

    .line 258
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v1, 0x4000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 259
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->startActivity(Landroid/content/Intent;)V

    .line 260
    return-void
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 284
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->onResumeInternal()V

    .line 285
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->checkTalkBackModeOnResume()V

    .line 286
    return-void
.end method

.method public onSpeechSwipe()V
    .locals 4

    .prologue
    .line 440
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->stopSpeaking()V

    .line 442
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 443
    .local v0, "bundle":Landroid/os/Bundle;
    const-string v1, "INTENT_KEY_SERIES_ID"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 444
    const-string v1, "INTENT_KEY_CURRENTLY_PLAYING_VIDEO_ID"

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    if-nez v2, :cond_0

    const-wide/16 v2, -0x1

    :goto_0
    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Bundle;->putLong(Ljava/lang/String;J)V

    .line 447
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getSpeechDelegate()Lcom/comcast/cim/android/accessibility/SpeechDelegate;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getSpeechRecognizerClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/comcast/cim/android/accessibility/SpeechDelegate;->getSpeechInput(Ljava/lang/Class;Landroid/os/Bundle;)V

    .line 448
    return-void

    .line 444
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 445
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    goto :goto_0
.end method

.method public onStartInternal()V
    .locals 2

    .prologue
    .line 316
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->onStartInternal()V

    .line 318
    new-instance v0, Landroid/content/IntentFilter;

    invoke-direct {v0}, Landroid/content/IntentFilter;-><init>()V

    .line 319
    .local v0, "filter":Landroid/content/IntentFilter;
    const-string v1, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addAction(Ljava/lang/String;)V

    .line 320
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->networkReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v1, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 321
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->receiverRegistered:Z

    .line 322
    return-void
.end method

.method protected onStop()V
    .locals 2

    .prologue
    .line 326
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailActivity;->onStop()V

    .line 327
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->receiverRegistered:Z

    if-eqz v0, :cond_0

    .line 328
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->networkReceiver:Landroid/content/BroadcastReceiver;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V

    .line 329
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->receiverRegistered:Z

    .line 331
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_1

    .line 332
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->proxyTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 334
    :cond_1
    return-void
.end method

.method public shouldShowSeriesListItemsChecked()Z
    .locals 1

    .prologue
    .line 246
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    return v0
.end method

.method public showLoading()V
    .locals 2

    .prologue
    .line 360
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->bodyContainer:Landroid/view/View;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 361
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->loadingIndicator:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 362
    return-void
.end method

.method public showSeriesDetail()V
    .locals 6

    .prologue
    .line 177
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->useDownloadAsSource()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 178
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-static {v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->createBundle(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)Landroid/os/Bundle;

    move-result-object v0

    .line 183
    .local v0, "bundle":Landroid/os/Bundle;
    :goto_0
    iget-boolean v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    if-eqz v4, :cond_1

    .line 184
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->fm:Landroid/app/FragmentManager;

    invoke-virtual {v4}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 185
    .local v2, "ft":Landroid/app/FragmentTransaction;
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;

    invoke-direct {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;-><init>()V

    .line 186
    .local v1, "fragment":Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;
    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->setArguments(Landroid/os/Bundle;)V

    .line 187
    sget v4, Lcom/xfinity/playerlib/R$id;->fragment_container_2:I

    const-string v5, "detail"

    invoke-virtual {v2, v4, v1, v5}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 188
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commit()I

    .line 190
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->showSeriesAsSelected()V

    .line 196
    .end local v1    # "fragment":Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;
    .end local v2    # "ft":Landroid/app/FragmentTransaction;
    :goto_1
    return-void

    .line 180
    .end local v0    # "bundle":Landroid/os/Bundle;
    :cond_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v4, v4, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-static {v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailFragment;->createBundle(Lcom/xfinity/playerlib/model/MerlinId;)Landroid/os/Bundle;

    move-result-object v0

    .restart local v0    # "bundle":Landroid/os/Bundle;
    goto :goto_0

    .line 192
    :cond_1
    new-instance v3, Landroid/content/Intent;

    const-class v4, Lcom/xfinity/playerlib/view/programdetails/SeriesDetailActivity;

    invoke-direct {v3, p0, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 193
    .local v3, "intent":Landroid/content/Intent;
    invoke-virtual {v3, v0}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 194
    invoke-virtual {p0, v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_1
.end method

.method public showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 7
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 203
    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v5, v5, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v5, :cond_1

    .line 205
    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-direct {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    iget-boolean v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    .line 206
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 207
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    .line 208
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->episodeId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    sget-object v6, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 209
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    .line 210
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    if-nez v6, :cond_0

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-boolean v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v6, :cond_0

    .line 211
    :goto_0
    invoke-virtual {v5, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 212
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 225
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    :goto_1
    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    if-eqz v3, :cond_3

    .line 226
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->fm:Landroid/app/FragmentManager;

    invoke-virtual {v3}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v1

    .line 228
    .local v1, "ft":Landroid/app/FragmentTransaction;
    sget v3, Lcom/xfinity/playerlib/R$id;->fragment_container_2:I

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getFragment()Landroid/app/Fragment;

    move-result-object v4

    const-string v5, "detail"

    invoke-virtual {v1, v3, v4, v5}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    .line 229
    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 231
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->episodeListFragment:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-virtual {v3, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->showEpisodeAsSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 238
    .end local v1    # "ft":Landroid/app/FragmentTransaction;
    :goto_2
    return-void

    .end local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    :cond_0
    move v3, v4

    .line 210
    goto :goto_0

    .line 216
    :cond_1
    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v5, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    .line 217
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    iget-boolean v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->isDualPanel:Z

    .line 218
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    sget-object v6, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 219
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    .line 220
    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->companyId(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v5

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->companyId:Ljava/lang/Long;

    if-nez v6, :cond_2

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;

    iget-boolean v6, v6, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v6, :cond_2

    .line 221
    :goto_3
    invoke-virtual {v5, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->wantsSubscriptionOnly(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 222
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .restart local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    goto :goto_1

    .end local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    :cond_2
    move v3, v4

    .line 220
    goto :goto_3

    .line 234
    .restart local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    :cond_3
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getEpisodeDetailActivityClass()Ljava/lang/Class;

    move-result-object v3

    invoke-direct {v2, p0, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 235
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 236
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->startActivity(Landroid/content/Intent;)V

    goto :goto_2
.end method
