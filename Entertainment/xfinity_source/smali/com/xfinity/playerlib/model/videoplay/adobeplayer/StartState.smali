.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
.super Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;
.source "StartState.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field final cancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field private liveStreamMetaDataResourceTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamMetaDataResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamResourceTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation
.end field

.field private movieEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;>;"
        }
    .end annotation
.end field

.field private movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;>;"
        }
    .end annotation
.end field

.field private seriesEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;>;"
        }
    .end annotation
.end field

.field private seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V
    .locals 1
    .param p1, "stateController"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 58
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    .line 50
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 59
    return-void
.end method

.method static synthetic access$000()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 37
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method private fetchEpisode(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V
    .locals 7
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p3, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 232
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    invoke-interface {v0, p2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v6

    .line 233
    .local v6, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {v0, v1, v6}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 235
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-object v1, p0

    move-object v3, p3

    move-object v4, p1

    move-object v5, p2

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$4;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Ljava/lang/Long;Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 257
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 258
    return-void
.end method

.method private fetchEpisode(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
    .locals 4
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 261
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    .line 262
    .local v1, "seriesId":Lcom/xfinity/playerlib/model/MerlinId;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v2

    invoke-interface {v2, v1}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    .line 263
    .local v0, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 265
    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$5;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    invoke-direct {v2, p0, v3, p1, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$5;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 271
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 272
    return-void
.end method

.method private fetchLiveStreamById(Ljava/lang/String;)V
    .locals 7
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 275
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_launch_fetch_live_stream_details:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 276
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 277
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 278
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v3

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 279
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    move-object v1, p0

    move-object v6, p1

    invoke-direct/range {v0 .. v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 294
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 296
    return-void
.end method

.method private fetchLiveStreamByName(Ljava/lang/String;)V
    .locals 6
    .param p1, "streamName"    # Ljava/lang/String;

    .prologue
    .line 299
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->player_launch_fetch_live_stream_details:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 300
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStreamMetaDataResourceFactory()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamMetaDataResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 302
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$7;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamMetaDataResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 303
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v3

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 304
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$7;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamMetaDataResourceTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 319
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamMetaDataResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamMetaDataResourceTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 320
    return-void
.end method

.method private fetchMovie(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V
    .locals 3
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 206
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v1

    invoke-interface {v1, p1}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    .line 207
    .local v0, "movieCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 208
    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$2;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    invoke-direct {v1, p0, v2, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$2;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Ljava/lang/Long;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 214
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 215
    return-void
.end method

.method private fetchMovie(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
    .locals 4
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 218
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    .line 219
    .local v0, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v2

    invoke-interface {v2, v0}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    .line 220
    .local v1, "movieCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-virtual {v2, v3, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 222
    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    invoke-direct {v2, p0, v3, p1, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$3;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Lcom/xfinity/playerlib/model/consumable/WatchableKey;Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 228
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 229
    return-void
.end method

.method private fetchVideo(Ljava/lang/Long;Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V
    .locals 6
    .param p1, "videoId"    # Ljava/lang/Long;
    .param p2, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p3, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p4, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 126
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->player_launch_fetch_details:I

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 128
    if-nez p1, :cond_0

    .line 129
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v1

    invoke-virtual {v1, p2, p3, p4}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithMerlinData(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    .line 134
    .local v0, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :goto_0
    if-eqz v0, :cond_2

    .line 135
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->isDownloadComplete()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 136
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v1

    sget-object v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->NOT_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-ne v1, v2, :cond_1

    .line 137
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideo()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v2

    invoke-direct {p0, v1, v2, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->setupVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 138
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 149
    :goto_1
    return-void

    .line 131
    .end local v0    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v0

    .restart local v0    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    goto :goto_0

    .line 140
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v4}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->video_startup_error:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_1

    .line 143
    :cond_2
    if-eqz p1, :cond_3

    .line 144
    new-instance v1, Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {p1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-direct {v1, p3, v2, v3}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;-><init>(Lcom/xfinity/playerlib/model/MerlinId;J)V

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchWatchable(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    goto :goto_1

    .line 146
    :cond_3
    invoke-direct {p0, p2, p3, p4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchWatchable(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V

    goto :goto_1
.end method

.method private fetchWatchable(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V
    .locals 2
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "parentMerlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p3, "companyId"    # Ljava/lang/Long;

    .prologue
    .line 198
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 199
    invoke-direct {p0, p1, p3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchMovie(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V

    .line 203
    :goto_0
    return-void

    .line 201
    :cond_0
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchEpisode(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V

    goto :goto_0
.end method

.method private fetchWatchable(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
    .locals 2
    .param p1, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .prologue
    .line 190
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 191
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchMovie(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    .line 195
    :goto_0
    return-void

    .line 193
    :cond_0
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchEpisode(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    goto :goto_0
.end method

.method private onPostVideoSetup(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 7
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 329
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->checkShouldPauseDownloads()V

    .line 331
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getSeriesInfoIfApplicable()Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;

    move-result-object v0

    .line 332
    .local v0, "info":Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;
    if-eqz v0, :cond_0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Integer;->intValue()I

    move-result v2

    const/4 v3, -0x1

    if-le v2, v3, :cond_0

    .line 333
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->video_episode_title:I

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getSeasonNumber()Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x1

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchableInfo;->getEpisodeNumber()Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    const/4 v5, 0x2

    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 337
    .local v1, "title":Ljava/lang/String;
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setVideoTitle(Ljava/lang/String;)V

    .line 338
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setupRatingsBug(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 339
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setInfoTabIcon()V

    .line 340
    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->configurePlaybackControls()V

    .line 341
    return-void

    .line 335
    .end local v1    # "title":Ljava/lang/String;
    :cond_0
    invoke-interface {p2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "title":Ljava/lang/String;
    goto :goto_0
.end method

.method private setupLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 3
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 344
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 345
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->checkShouldPauseDownloads()V

    .line 346
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setVideoTitle(Ljava/lang/String;)V

    .line 347
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setupRatingsBug(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 348
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setInfoTabIcon()V

    .line 349
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getNetworkLogoUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setNetworkInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 350
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->configurePlaybackControls()V

    .line 351
    return-void
.end method

.method private setupVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 1
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "file"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 323
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 324
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setDownloadedFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 325
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->onPostVideoSetup(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 326
    return-void
.end method


# virtual methods
.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 70
    const-string v0, "StartState"

    return-object v0
.end method

.method public onActivityPaused()V
    .locals 3

    .prologue
    .line 153
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 154
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->movieEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 157
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_1

    .line 158
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->seriesEntityTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 161
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_2

    .line 162
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->liveStreamResourceTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 165
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/BackgroundState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 166
    return-void
.end method

.method public onActivityResumed()V
    .locals 0

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->run()V

    .line 76
    return-void
.end method

.method public onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 4
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 181
    if-nez p1, :cond_0

    .line 182
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->error_stream_not_available_text:I

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 187
    :goto_0
    return-void

    .line 184
    :cond_0
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->setupLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 185
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method

.method public onVideoFetchFailed()V
    .locals 5

    .prologue
    .line 170
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$string;->error_video_not_available_text:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-direct {v1, v2, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/ErrorState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 171
    return-void
.end method

.method public onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 3
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 175
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->setupVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 176
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v1, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 177
    return-void
.end method

.method public run()V
    .locals 10

    .prologue
    .line 80
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v7

    sget v8, Lcom/xfinity/playerlib/R$string;->player_launch_starting:I

    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setLaunchScreenMessage(I)V

    .line 81
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v7

    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->showLaunchScreen()V

    .line 82
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v7

    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideMainControls()V

    .line 83
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v7

    invoke-virtual {v7}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideActionBar()V

    .line 85
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v7

    if-eqz v7, :cond_0

    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v7

    if-eqz v7, :cond_0

    .line 87
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getPlayerDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v7

    iget-object v8, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v8

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->findFileWithVideoId(J)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    move-result-object v2

    .line 88
    .local v2, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setDownloadedFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V

    .line 90
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v7

    iget-object v8, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v8

    invoke-direct {p0, v7, v8}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->onPostVideoSetup(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 91
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v8, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    iget-object v9, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v8, v9}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 123
    .end local v2    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :goto_0
    return-void

    .line 95
    :cond_0
    const/4 v6, 0x0

    .line 96
    .local v6, "videoId":Ljava/lang/Long;
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v7

    invoke-virtual {v7}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v7

    invoke-virtual {v7}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 97
    .local v0, "arguments":Landroid/os/Bundle;
    const-string v7, "liveStreamID"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 98
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v7

    if-eqz v7, :cond_1

    .line 99
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v3

    .line 100
    .local v3, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v7

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setVideoTitle(Ljava/lang/String;)V

    .line 101
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v7

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getNetworkLogoUrl()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v7, v8, v9}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->setNetworkInfo(Ljava/lang/String;Ljava/lang/String;)V

    .line 102
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->checkShouldPauseDownloads()V

    .line 103
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    new-instance v8, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    iget-object v9, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-direct {v8, v9}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {v7, v8}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0

    .line 105
    .end local v3    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    :cond_1
    const-string v7, "liveStreamID"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchLiveStreamById(Ljava/lang/String;)V

    goto :goto_0

    .line 107
    :cond_2
    const-string v7, "liveStreamName"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_3

    .line 108
    const-string v7, "liveStreamName"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {p0, v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchLiveStreamByName(Ljava/lang/String;)V

    goto :goto_0

    .line 110
    :cond_3
    const-string v7, "videoId"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_4

    .line 111
    const-string v7, "videoId"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v6

    .line 113
    :cond_4
    const-string v7, "merlinId"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/MerlinId;

    .line 114
    .local v4, "merlinId":Lcom/xfinity/playerlib/model/MerlinId;
    const-string v7, "parentMerlinId"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/MerlinId;

    .line 115
    .local v5, "parentMerlinId":Lcom/xfinity/playerlib/model/MerlinId;
    const/4 v1, 0x0

    .line 116
    .local v1, "companyId":Ljava/lang/Long;
    const-string v7, "companyId"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_5

    .line 117
    const-string v7, "companyId"

    invoke-virtual {v0, v7}, Landroid/os/Bundle;->getLong(Ljava/lang/String;)J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    .line 120
    :cond_5
    invoke-direct {p0, v6, v4, v5, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchVideo(Ljava/lang/Long;Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/Long;)V

    goto/16 :goto_0
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 62
    instance-of v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/SetupMediaPlayerState;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 67
    :goto_0
    return-void

    .line 65
    :cond_0
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/DefaultVideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    goto :goto_0
.end method
