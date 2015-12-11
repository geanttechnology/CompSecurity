.class Lcom/adobe/mediacore/TimelineOperationQueue;
.super Ljava/lang/Object;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private _executor:Ljava/lang/Runnable;

.field private _handler:Landroid/os/Handler;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private final _onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

.field private final _onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

.field private final _onAdBreakRemovalCompletedListener:Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;

.field private final _operationsToBeExecuted:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation
.end field

.field private _pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

.field private final _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private final _videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/TimelineOperationQueue;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineTimeline;Lcom/adobe/mediacore/VideoEngineDispatcher;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/TimelineOperationQueue;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v0, Ljava/util/PriorityQueue;

    invoke-direct {v0}, Ljava/util/PriorityQueue;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_operationsToBeExecuted:Ljava/util/Queue;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

    new-instance v0, Lcom/adobe/mediacore/TimelineOperationQueue$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/TimelineOperationQueue$2;-><init>(Lcom/adobe/mediacore/TimelineOperationQueue;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    new-instance v0, Lcom/adobe/mediacore/TimelineOperationQueue$3;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/TimelineOperationQueue$3;-><init>(Lcom/adobe/mediacore/TimelineOperationQueue;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    new-instance v0, Lcom/adobe/mediacore/TimelineOperationQueue$4;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/TimelineOperationQueue$4;-><init>(Lcom/adobe/mediacore/TimelineOperationQueue;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakRemovalCompletedListener:Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    iput-object p2, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-direct {p0}, Lcom/adobe/mediacore/TimelineOperationQueue;->initialise()V

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/VideoEngineTimeline;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    return-object v0
.end method

.method static synthetic access$100(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/timeline/TimelineOperation;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

    return-object v0
.end method

.method static synthetic access$102(Lcom/adobe/mediacore/TimelineOperationQueue;Lcom/adobe/mediacore/timeline/TimelineOperation;)Lcom/adobe/mediacore/timeline/TimelineOperation;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

    return-object p1
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/TimelineOperationQueue;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/TimelineOperationQueue;->process()V

    return-void
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method static synthetic access$400()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/TimelineOperationQueue;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/TimelineOperationQueue;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method private clearOperation()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

    return-void
.end method

.method private clearOperationsQueue()V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_operationsToBeExecuted:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->clear()V

    return-void
.end method

.method private initialise()V
    .locals 3

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_handler:Landroid/os/Handler;

    new-instance v0, Lcom/adobe/mediacore/TimelineOperationQueue$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/TimelineOperationQueue$1;-><init>(Lcom/adobe/mediacore/TimelineOperationQueue;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_executor:Ljava/lang/Runnable;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakRemovalCompletedListener:Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    return-void
.end method

.method private process()V
    .locals 12

    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    move v0, v3

    move v4, v3

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_operationsToBeExecuted:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/timeline/TimelineOperation;

    if-eqz v1, :cond_5

    instance-of v0, v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_2

    move-object v0, v1

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->willAccept(Lcom/adobe/mediacore/timeline/TimelineOperation;)Z

    move-result v0

    if-nez v0, :cond_7

    move v0, v2

    :goto_1
    move v4, v0

    :cond_2
    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->isValid()Z

    move-result v0

    if-nez v0, :cond_8

    move v5, v2

    :goto_2
    if-nez v4, :cond_3

    if-eqz v5, :cond_4

    :cond_3
    if-eqz v4, :cond_9

    const-string v0, "Proposed ad break is conflicting with previously placed ad breaks."

    :goto_3
    iget-object v6, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/adobe/mediacore/TimelineOperationQueue;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "#process"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v8, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "["

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v1}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "]."

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v7, v8}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v6, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v7, Lcom/adobe/mediacore/OpportunityHandledEvent;

    sget-object v8, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v9

    invoke-virtual {v9}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v10

    invoke-direct {v7, v8, v10, v11}, Lcom/adobe/mediacore/OpportunityHandledEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;J)V

    invoke-virtual {v6, v7}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    sget-object v6, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_RESOLVER_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    invoke-static {v6, v0}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v6

    new-instance v7, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v7}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v8, "AD_BREAK"

    move-object v0, v1

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v7, v8, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v6, v7}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v6}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_4
    move v0, v5

    :cond_5
    if-eqz v1, :cond_6

    if-nez v0, :cond_1

    if-nez v4, :cond_1

    :cond_6
    if-nez v1, :cond_a

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_7
    move v0, v3

    goto/16 :goto_1

    :cond_8
    move v5, v3

    goto/16 :goto_2

    :cond_9
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Proposed ad break is invalid - replace duration ["

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object v0, v1

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getInitialReplaceDuration()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "] is smaller than the actual duration of ad break ["

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    move-object v0, v1

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "]."

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto/16 :goto_3

    :cond_a
    instance-of v0, v1, Lcom/adobe/mediacore/timeline/NopTimelineOperation;

    if-eqz v0, :cond_b

    invoke-direct {p0}, Lcom/adobe/mediacore/TimelineOperationQueue;->process()V

    goto/16 :goto_0

    :cond_b
    iput-object v1, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_executor:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto/16 :goto_0
.end method


# virtual methods
.method public declared-synchronized addAllToQueue(Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;)V"
        }
    .end annotation

    monitor-enter p0

    :try_start_0
    invoke-static {p1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_operationsToBeExecuted:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->addAll(Ljava/util/Collection;)Z

    invoke-direct {p0}, Lcom/adobe/mediacore/TimelineOperationQueue;->process()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized addToQueue(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_operationsToBeExecuted:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    invoke-direct {p0}, Lcom/adobe/mediacore/TimelineOperationQueue;->process()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public clear()V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/TimelineOperationQueue;->clearOperation()V

    invoke-direct {p0}, Lcom/adobe/mediacore/TimelineOperationQueue;->clearOperationsQueue()V

    return-void
.end method

.method public dispose()V
    .locals 3

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_handler:Landroid/os/Handler;

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_executor:Ljava/lang/Runnable;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_onAdBreakRemovalCompletedListener:Lcom/adobe/mediacore/AdBreakRemovalCompletedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    return-void
.end method

.method public isEmpty()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_operationsToBeExecuted:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    if-gtz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineOperationQueue;->_pendingOperation:Lcom/adobe/mediacore/timeline/TimelineOperation;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0
.end method
