.class Lcom/adobe/mediacore/MediaPlayerClient;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final _adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

.field private _adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

.field private _adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

.field private final _adProviderListener:Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;

.field private final _adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

.field private _adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

.field private _contentResolvers:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/ContentResolver;",
            ">;"
        }
    .end annotation
.end field

.field private final _dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private final _mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

.field private _onAdPlaybackEventListener:Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

.field private _onOpportunityCompletedListener:Lcom/adobe/mediacore/OpportunityHandledListener;

.field private _placementOpportunityDetector:Lcom/adobe/mediacore/PlacementOpportunityDetector;

.field protected _processedTimedMetadatas:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;"
        }
    .end annotation
.end field

.field private _processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

.field private _processingTime:J

.field private final _queuedOpportunities:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/adobe/mediacore/timeline/PlacementOpportunity;",
            ">;"
        }
    .end annotation
.end field

.field private _reservations:I

.field private final _timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

.field private final _videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

.field private final _videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

.field private final _videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/AdClientFactory;Lcom/adobe/mediacore/metadata/AdSignalingMode;)V
    .locals 3

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    const/4 v0, 0x0

    iput v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_reservations:I

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingTime:J

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerClient$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/MediaPlayerClient$1;-><init>(Lcom/adobe/mediacore/MediaPlayerClient;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onOpportunityCompletedListener:Lcom/adobe/mediacore/OpportunityHandledListener;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerClient$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/MediaPlayerClient$2;-><init>(Lcom/adobe/mediacore/MediaPlayerClient;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onAdPlaybackEventListener:Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object p3, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getTimeline()Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0, p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->setMediaPlayerClient(Lcom/adobe/mediacore/MediaPlayerClient;)V

    new-instance v0, Lcom/adobe/mediacore/TimelineOperationQueue;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getTimeline()Lcom/adobe/mediacore/VideoEngineTimeline;

    move-result-object v1

    invoke-direct {v0, v1, p1}, Lcom/adobe/mediacore/TimelineOperationQueue;-><init>(Lcom/adobe/mediacore/VideoEngineTimeline;Lcom/adobe/mediacore/VideoEngineDispatcher;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->createVideoEngineTimelineProxy()Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;-><init>(Lcom/adobe/mediacore/MediaPlayerClient;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adProviderListener:Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;

    iput-object p2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    new-instance v0, Ljava/util/ArrayDeque;

    invoke-direct {v0}, Ljava/util/ArrayDeque;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_queuedOpportunities:Ljava/util/Queue;

    iput-object p4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    iput-object p5, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onOpportunityCompletedListener:Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onOpportunityCompletedListener:Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onAdPlaybackEventListener:Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/TimelineOperationQueue;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineTimelineProxy;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    return-object v0
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/MediaPlayerClient;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->notifyAdResolvingCompletion()V

    return-void
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    return-object v0
.end method

.method static synthetic access$502(Lcom/adobe/mediacore/MediaPlayerClient;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    return-object p1
.end method

.method static synthetic access$600(Lcom/adobe/mediacore/MediaPlayerClient;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->processQueuedOpportunities()V

    return-void
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/MediaPlayerClient;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method private isValid(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z
    .locals 10

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    if-nez v0, :cond_1

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#isOpportunity"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "PlacementOpportunity received is invalid."

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    :goto_0
    return v0

    :cond_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_queuedOpportunities:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v8

    add-long/2addr v8, v6

    cmp-long v5, v6, v2

    if-gtz v5, :cond_2

    cmp-long v5, v2, v8

    if-gez v5, :cond_2

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#isOpportunity"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "PlacementOpportunity is overlapping an existing one ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "] with ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "]"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v1

    goto :goto_0

    :cond_3
    const/4 v0, 0x1

    goto :goto_0
.end method

.method private lookupContentResolver(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;
    .locals 4

    const/4 v1, 0x0

    if-nez p1, :cond_1

    :cond_0
    return-object v1

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;->canResolve(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z

    move-result v3

    if-eqz v3, :cond_2

    :goto_1
    move-object v1, v0

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_1
.end method

.method private notifyAdResolvingCompletion()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    return-void
.end method

.method private processQueuedOpportunities()V
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    if-eqz v0, :cond_1

    :cond_0
    :goto_0
    return-void

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_queuedOpportunities:Ljava/util/Queue;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_queuedOpportunities:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerClient;->lookupContentResolver(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#processQueuedOpportunities"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Processing "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->containsHoldFor(J)Z

    move-result v2

    if-nez v2, :cond_3

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#processQueuedOpportunities"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Trying to place HOLD at "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->getHoldAt(J)Lcom/adobe/mediacore/TimelineHold;

    move-result-object v2

    if-nez v2, :cond_2

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#processQueuedOpportunities"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Unable to place HOLD at "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ". Ignoring timedMetadata"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v0, v1}, Lcom/adobe/mediacore/MediaPlayerClient;->removeTimedMetadata(J)V

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->processQueuedOpportunities()V

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_2
    iget-object v3, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#processQueuedOpportunities"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Adding reference for opportunity for  HOLD at "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v4, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimelineProxy:Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->addHoldReference(Lcom/adobe/mediacore/TimelineHold;)V

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerClient;->lookupContentResolver(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;->resolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V

    goto/16 :goto_0
.end method

.method private removeTimedMetadata(J)V
    .locals 7

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    monitor-enter v1

    :try_start_0
    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v4

    cmp-long v4, v4, p1

    if-nez v4, :cond_0

    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->removeAll(Ljava/util/Collection;)Z

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method

.method private resolveOpportunity(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 2

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "PlacementOpportunity parameter can not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_queuedOpportunities:Ljava/util/Queue;

    monitor-enter v1

    :try_start_0
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/MediaPlayerClient;->isValid(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_queuedOpportunities:Ljava/util/Queue;

    invoke-interface {v0, p1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->processQueuedOpportunities()V

    :cond_1
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public beginResolveAds(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V
    .locals 5

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/MediaPlayerClient;->registerPlacement(I)V

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->notifyAdResolvingCompletion()V

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#beginResolveAds"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ad resolving and placementInformation process is starting."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    const-string v2, ""

    invoke-direct {v1, v2, p1, v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;-><init>(Ljava/lang/String;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Lcom/adobe/mediacore/metadata/Metadata;)V

    :try_start_0
    invoke-direct {p0, v1}, Lcom/adobe/mediacore/MediaPlayerClient;->lookupContentResolver(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;->resolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Ad resolving and placementInformation process cancelled due argument exception ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "]."

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#beginResolveAds"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3, v1}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->PLAYBACK_OPERATION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v2, "Ad resolving and placementInformation process cancelled due argument exception."

    invoke-static {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v3, "DESCRIPTION"

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->notifyAdResolvingCompletion()V

    goto/16 :goto_0

    :cond_2
    :try_start_1
    invoke-virtual {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->unregisterPlacement()V
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public doneInitialResolving()Z
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_reservations:I

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAdPolicyProxy()Lcom/adobe/mediacore/AdPolicyProxy;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    return-object v0
.end method

.method public getAdSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adSignalingMode:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    return-object v0
.end method

.method public initialize(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Lcom/adobe/mediacore/TimelineMonitor;)V
    .locals 7

    iput-object p2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    instance-of v0, v0, Lcom/adobe/mediacore/AdvertisingFactory;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    check-cast v0, Lcom/adobe/mediacore/AdvertisingFactory;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdvertisingFactory;->createAdPolicySelector(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    if-nez v0, :cond_0

    new-instance v0, Lcom/adobe/mediacore/DefaultAdPolicySelector;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-direct {v0, v1}, Lcom/adobe/mediacore/DefaultAdPolicySelector;-><init>(Lcom/adobe/mediacore/MediaPlayerItem;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    check-cast v0, Lcom/adobe/mediacore/AdvertisingFactory;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdvertisingFactory;->createContentResolvers(Lcom/adobe/mediacore/MediaPlayerItem;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    new-instance v0, Lcom/adobe/mediacore/AdPolicyProxy;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v3, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    iget-object v4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    iget-object v5, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    iget-object v6, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/AdPolicyProxy;-><init>(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/VideoEngineTimeline;Lcom/adobe/mediacore/TimelineOperationQueue;Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;)V

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adTimelineMonitor:Lcom/adobe/mediacore/TimelineMonitor;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/TimelineMonitor;->initialize(Lcom/adobe/mediacore/AdPolicyProxy;)V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adClientFactory:Lcom/adobe/mediacore/AdClientFactory;

    iget-object v1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/AdClientFactory;->createOpportunityDetector(Lcom/adobe/mediacore/MediaPlayerItem;)Lcom/adobe/mediacore/PlacementOpportunityDetector;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_placementOpportunityDetector:Lcom/adobe/mediacore/PlacementOpportunityDetector;

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_placementOpportunityDetector:Lcom/adobe/mediacore/PlacementOpportunityDetector;

    if-eqz v0, :cond_2

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingTime:J

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adProviderListener:Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adProviderListener:Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;->registerOnCompleteListener(Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;)V

    goto :goto_0

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->setInitialTimeMapping(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V

    return-void
.end method

.method public registerPlacement(I)V
    .locals 0

    iput p1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_reservations:I

    return-void
.end method

.method public unload()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->dispose()V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-virtual {v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->clear()V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onOpportunityCompletedListener:Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->OPPORTUNITY_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onOpportunityCompletedListener:Lcom/adobe/mediacore/OpportunityHandledListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_dispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_onAdPlaybackEventListener:Lcom/adobe/mediacore/MediaPlayer$AdPlaybackEventListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayer$Event;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_contentResolvers:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_adProviderListener:Lcom/adobe/mediacore/MediaPlayerClient$AdProviderListener;

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;->unregisterOnCompleteListener(Lcom/adobe/mediacore/timeline/advertising/AdProvider$OnCompleteListener;)V

    goto :goto_0

    :cond_0
    return-void
.end method

.method public unregisterPlacement()V
    .locals 1

    iget v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_reservations:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_reservations:I

    return-void
.end method

.method public update(JLcom/adobe/mediacore/utils/TimeRange;)V
    .locals 9

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_placementOpportunityDetector:Lcom/adobe/mediacore/PlacementOpportunityDetector;

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#update"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Update ignored as there is no registered detector to process it"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    iput-wide p1, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingTime:J

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v0}, Lcom/adobe/mediacore/MediaPlayerItem;->getTimedMetadata()Ljava/util/List;

    move-result-object v0

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    monitor-enter v2

    :try_start_0
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_2
    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v4

    invoke-virtual {p3, v4, v5}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v4

    if-nez v4, :cond_3

    iget-object v4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#update"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Removing old timed metadata.[ opportunity: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", playback range: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_3
    :try_start_1
    iget-object v4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v4

    iget-wide v6, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingTime:J

    cmp-long v4, v4, v6

    if-gez v4, :cond_4

    iget-object v4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#update"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Ad placement opportunity skipped since its position is in the past (previous to the play head).[ opportunity: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ", processing time: "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "]."

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v5, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_1

    :cond_4
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processedTimedMetadatas:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingTime:J

    goto/16 :goto_1

    :cond_5
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_placementOpportunityDetector:Lcom/adobe/mediacore/PlacementOpportunityDetector;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerItem;->getResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/PlacementOpportunityDetector;->process(Ljava/util/List;Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_6

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    iget-object v2, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/MediaPlayerClient;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#update"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Resolving opportunity "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", processing time="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {p1, p2}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/MediaPlayerClient;->resolveOpportunity(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V

    goto :goto_2

    :cond_6
    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_processingPlacementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/MediaPlayerClient;->_queuedOpportunities:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->size()I

    move-result v0

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/adobe/mediacore/MediaPlayerClient;->notifyAdResolvingCompletion()V

    goto/16 :goto_0
.end method
