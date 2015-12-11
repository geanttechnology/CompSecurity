.class Lcom/adobe/mediacore/TimelineMonitor;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/TimelineMonitor$3;
    }
.end annotation


# static fields
.field private static final INVALID_TIME:I = -0x1

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private _adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

.field private final _adTimeline:Lcom/adobe/mediacore/AdTimeline;

.field private _contentId:J

.field private _contentStartTime:J

.field private _currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

.field private _deleteOnAdBreakExit:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreak;",
            ">;"
        }
    .end annotation
.end field

.field private _detectedAdBreaks:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreak;",
            ">;"
        }
    .end annotation
.end field

.field private _lastAdInfo:Lcom/adobe/mediacore/AdTimeline$AdInformation;

.field private _lastProcessedTime:J

.field private _lastSkippedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _onContentChangedListener:Lcom/adobe/mediacore/ContentChangedListener;

.field private _onContentMarkerListener:Lcom/adobe/mediacore/ContentMarkerListener;

.field private _setAdBreakForRestore:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreak;",
            ">;"
        }
    .end annotation
.end field

.field private _skipAdBreaks:Z

.field private _skippedDuration:J

.field private _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/TimelineMonitor;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/AdTimeline;)V
    .locals 6

    const/4 v3, 0x0

    const-wide/16 v4, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    iput-wide v4, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentStartTime:J

    iput-wide v4, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentId:J

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastProcessedTime:J

    iput-object v3, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    new-instance v0, Lcom/adobe/mediacore/TimelineMonitor$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/TimelineMonitor$1;-><init>(Lcom/adobe/mediacore/TimelineMonitor;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_onContentChangedListener:Lcom/adobe/mediacore/ContentChangedListener;

    new-instance v0, Lcom/adobe/mediacore/TimelineMonitor$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/TimelineMonitor$2;-><init>(Lcom/adobe/mediacore/TimelineMonitor;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_onContentMarkerListener:Lcom/adobe/mediacore/ContentMarkerListener;

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_onContentChangedListener:Lcom/adobe/mediacore/ContentChangedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_onContentMarkerListener:Lcom/adobe/mediacore/ContentMarkerListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iput-object p2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skipAdBreaks:Z

    iput-object v3, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastSkippedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    iput-wide v4, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skippedDuration:J

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/TimelineMonitor;IJ)V
    .locals 0

    invoke-direct {p0, p1, p2, p3}, Lcom/adobe/mediacore/TimelineMonitor;->contentChanged(IJ)V

    return-void
.end method

.method private contentChanged(IJ)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#contentChanged"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Content changed to ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] at time ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iput-wide p2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentStartTime:J

    int-to-long v0, p1

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentId:J

    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastAdInfo:Lcom/adobe/mediacore/AdTimeline$AdInformation;

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastProcessedTime:J

    int-to-long v0, p1

    invoke-direct {p0, v0, v1, p2, p3}, Lcom/adobe/mediacore/TimelineMonitor;->update(JJ)V

    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method private deleteAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Z)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#deleteAdBreak"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Deleting Ad Break: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-nez p2, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->seekThroughAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_setAdBreakForRestore:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_setAdBreakForRestore:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->removeOldAdBreakPlacementForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v0

    if-eqz v0, :cond_2

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-direct {v1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    if-eqz v1, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->placeTimelineLineOperation(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    :cond_2
    return-void
.end method

.method private isUpdateNeeded(Lcom/adobe/mediacore/AdTimeline$Info;)Z
    .locals 3

    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    if-nez v2, :cond_2

    if-eqz p1, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    move v0, v1

    goto :goto_0

    :cond_2
    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    invoke-virtual {v2, p1}, Lcom/adobe/mediacore/AdTimeline$Info;->equals(Lcom/adobe/mediacore/AdTimeline$Info;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0
.end method

.method private notifyOnSkippedAdBreaks(J)V
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdTimeline;->timelineMarkers()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v4

    cmp-long v3, p1, v4

    if-ltz v3, :cond_0

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v4

    add-long/2addr v2, v4

    cmp-long v2, p1, v2

    if-gtz v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastSkippedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    if-eq v0, v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#update"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Ad break skipped."

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v0}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->createSkippedEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastSkippedAdBreak:Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    iget-wide v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skippedDuration:J

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v4

    add-long/2addr v2, v4

    iput-wide v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skippedDuration:J

    goto :goto_0

    :cond_1
    return-void
.end method

.method private onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onAdBreakComplete"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Ad Break Completed: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_END:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    invoke-virtual {v0, p1, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->setAdBreakAsWatched(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/metadata/AdBreakAsWatched;)V

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/ContentTracker;->onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_deleteOnAdBreakExit:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_setAdBreakForRestore:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    const/4 v1, 0x0

    invoke-virtual {v0, p1, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-direct {v2, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/AdPolicyProxy;->placeTimelineLineOperation(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_setAdBreakForRestore:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->remove(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->restoreAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_deleteOnAdBreakExit:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    const/4 v0, 0x1

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_deleteOnAdBreakExit:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->remove(Ljava/lang/Object;)Z

    invoke-direct {p0, p1, v0}, Lcom/adobe/mediacore/TimelineMonitor;->deleteAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Z)V

    goto :goto_0
.end method

.method private onAdBreakDetected(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->getAdBreakPolicyFor(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_setAdBreakForRestore:Ljava/util/Vector;

    invoke-virtual {v1, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    :cond_0
    if-eqz v0, :cond_1

    sget-object v1, Lcom/adobe/mediacore/TimelineMonitor$3;->$SwitchMap$com$adobe$mediacore$timeline$advertising$AdBreakPolicy:[I

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    :cond_1
    :goto_0
    :pswitch_0
    return-void

    :pswitch_1
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TimelineMonitor;->skipAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    goto :goto_0

    :pswitch_2
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/adobe/mediacore/TimelineMonitor;->deleteAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Z)V

    goto :goto_0

    :pswitch_3
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_deleteOnAdBreakExit:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onAdBreakDetected"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "No ad policy proxy available."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method private onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#onAdBreakStart"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Ad Break started: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_detectedAdBreaks:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->indexOf(Ljava/lang/Object;)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_detectedAdBreaks:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->add(Ljava/lang/Object;)Z

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/TimelineMonitor;->onAdBreakDetected(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_0
    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v0

    invoke-interface {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/ContentTracker;->onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    sget-object v1, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    invoke-virtual {v0, p1, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->setAdBreakAsWatched(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/metadata/AdBreakAsWatched;)V

    return-void
.end method

.method private skipAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->seekThroughAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    return-void
.end method

.method private declared-synchronized update(JJ)V
    .locals 5

    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastProcessedTime:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    cmp-long v0, v0, p3

    if-nez v0, :cond_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iput-wide p3, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastProcessedTime:J

    iget-boolean v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skipAdBreaks:Z

    if-eqz v0, :cond_1

    invoke-direct {p0, p3, p4}, Lcom/adobe/mediacore/TimelineMonitor;->notifyOnSkippedAdBreaks(J)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_1
    :try_start_2
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    iget-wide v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentId:J

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/AdTimeline;->getInfoForContentId(J)Lcom/adobe/mediacore/AdTimeline$Info;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/TimelineMonitor;->isUpdateNeeded(Lcom/adobe/mediacore/AdTimeline$Info;)Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/TimelineMonitor;->updateCurrentAdInfo(Lcom/adobe/mediacore/AdTimeline$Info;)V

    goto :goto_0

    :cond_2
    invoke-direct {p0, v0, p3, p4}, Lcom/adobe/mediacore/TimelineMonitor;->updateAdProgress(Lcom/adobe/mediacore/AdTimeline$Info;J)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method

.method private updateAdProgress(Lcom/adobe/mediacore/AdTimeline$Info;J)V
    .locals 10

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v1

    if-eqz v0, :cond_1

    if-eqz v1, :cond_1

    iget-wide v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentStartTime:J

    sub-long v2, p2, v2

    const-wide/16 v4, 0x64

    mul-long/2addr v4, v2

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v6

    div-long/2addr v4, v6

    long-to-int v4, v4

    new-instance v5, Lcom/adobe/mediacore/AdTimeline$AdInformation;

    invoke-direct {v5, v1, v4}, Lcom/adobe/mediacore/AdTimeline$AdInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/Ad;I)V

    iget-object v4, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#updateAdProgress"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Updating ad progress for contentId ["

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-wide v8, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentId:J

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "] ad duration: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v8

    invoke-virtual {v8}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v8

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", ad start time: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget-wide v8, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentStartTime:J

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", current time: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, ", time difference: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", progress: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getProgress()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "%"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v4, v6, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getProgress()I

    move-result v2

    if-ltz v2, :cond_0

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getProgress()I

    move-result v2

    const/16 v3, 0x64

    if-le v2, v3, :cond_2

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#updateAdProgress"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ad progress value is not valid."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    :goto_0
    return-void

    :cond_2
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastAdInfo:Lcom/adobe/mediacore/AdTimeline$AdInformation;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastAdInfo:Lcom/adobe/mediacore/AdTimeline$AdInformation;

    invoke-virtual {v2}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->equals(Lcom/adobe/mediacore/timeline/advertising/Ad;)Z

    move-result v2

    if-eqz v2, :cond_3

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getProgress()I

    move-result v2

    iget-object v3, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastAdInfo:Lcom/adobe/mediacore/AdTimeline$AdInformation;

    invoke-virtual {v3}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getProgress()I

    move-result v3

    if-gt v2, v3, :cond_3

    monitor-exit p0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_3
    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    iput-object v5, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastAdInfo:Lcom/adobe/mediacore/AdTimeline$AdInformation;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v2

    if-eqz v2, :cond_4

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v1

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getProgress()I

    move-result v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/timeline/advertising/ContentTracker;->onAdProgress(Lcom/adobe/mediacore/timeline/advertising/Ad;I)V

    :cond_4
    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-virtual {v5}, Lcom/adobe/mediacore/AdTimeline$AdInformation;->getProgress()I

    move-result v3

    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/AdPlaybackEvent;->createProgressEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;I)Lcom/adobe/mediacore/AdPlaybackEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method


# virtual methods
.method public adjustSeekPosition(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/adobe/mediacore/AdTimeline;->getAdjustedPosition(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    return-object v0
.end method

.method public clear()V
    .locals 3

    const/4 v2, 0x0

    iput-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentId:J

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentStartTime:J

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastProcessedTime:J

    iput-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_lastAdInfo:Lcom/adobe/mediacore/AdTimeline$AdInformation;

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_CHANGED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_onContentChangedListener:Lcom/adobe/mediacore/ContentChangedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_onContentMarkerListener:Lcom/adobe/mediacore/ContentMarkerListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    return-void
.end method

.method public enableAdBreaks()V
    .locals 2

    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skipAdBreaks:Z

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skippedDuration:J

    return-void
.end method

.method public initialize(Lcom/adobe/mediacore/AdPolicyProxy;)V
    .locals 1

    iput-object p1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adPolicyProxy:Lcom/adobe/mediacore/AdPolicyProxy;

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_detectedAdBreaks:Ljava/util/Vector;

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_deleteOnAdBreakExit:Ljava/util/Vector;

    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_setAdBreakForRestore:Ljava/util/Vector;

    return-void
.end method

.method public isPlayingAdBreak()Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public processAdClick()V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_adTimeline:Lcom/adobe/mediacore/AdTimeline;

    iget-wide v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentId:J

    invoke-virtual {v0, v2, v3}, Lcom/adobe/mediacore/AdTimeline;->getInfoForContentId(J)Lcom/adobe/mediacore/AdTimeline$Info;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getAdClick()Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdClick;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v3

    invoke-interface {v3, v1}, Lcom/adobe/mediacore/timeline/advertising/ContentTracker;->onAdClick(Lcom/adobe/mediacore/timeline/advertising/Ad;)V

    :cond_0
    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-static {v3, v0, v2}, Lcom/adobe/mediacore/AdClickEvent;->createAdClickEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/AdClickEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_1
    return-void
.end method

.method public skipAdBreaks()V
    .locals 2

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skippedDuration:J

    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skipAdBreaks:Z

    return-void
.end method

.method public skippedDuration()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skippedDuration:J

    return-wide v0
.end method

.method public skippingAdBreaks()Z
    .locals 1

    iget-boolean v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_skipAdBreaks:Z

    return v0
.end method

.method public update(J)V
    .locals 3

    iget-wide v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_contentId:J

    invoke-direct {p0, v0, v1, p1, p2}, Lcom/adobe/mediacore/TimelineMonitor;->update(JJ)V

    return-void
.end method

.method public declared-synchronized updateCurrentAdInfo(Lcom/adobe/mediacore/AdTimeline$Info;)V
    .locals 5

    const/4 v0, 0x0

    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#updateCurrentAdInfo"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Updating current ad info."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    if-eqz v1, :cond_6

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->equals(Lcom/adobe/mediacore/timeline/advertising/Ad;)Z

    move-result v2

    if-nez v2, :cond_1

    :cond_0
    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#updateCurrentAdInfo"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Ad complete."

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1, v0}, Lcom/adobe/mediacore/AdPlaybackEvent;->createCompleteEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/adobe/mediacore/AdPlaybackEvent;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v2

    invoke-interface {v2, v0}, Lcom/adobe/mediacore/timeline/advertising/ContentTracker;->onAdComplete(Lcom/adobe/mediacore/timeline/advertising/Ad;)V

    :cond_1
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    :cond_2
    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#updateCurrentAdInfo"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Ad break complete."

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v1}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->createCompleteEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/TimelineMonitor;->onAdBreakComplete(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_3
    :goto_0
    iput-object p1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_currentInfo:Lcom/adobe/mediacore/AdTimeline$Info;

    if-eqz p1, :cond_5

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#updateCurrentAdInfo"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Ad break start."

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-static {v2}, Lcom/adobe/mediacore/AdBreakPlaybackEvent;->createStartEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/AdBreakPlaybackEvent;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/TimelineMonitor;->onAdBreakStart(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V

    :cond_4
    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->equals(Lcom/adobe/mediacore/timeline/advertising/Ad;)Z

    move-result v0

    if-nez v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/TimelineMonitor;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#updateCurrentAdInfo"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ad start."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/TimelineMonitor;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/adobe/mediacore/AdPlaybackEvent;->createStartEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/Ad;)Lcom/adobe/mediacore/AdPlaybackEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v0

    if-eqz v0, :cond_5

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getContentTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdTimeline$Info;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/ContentTracker;->onAdStart(Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_5
    monitor-exit p0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    :cond_6
    move-object v1, v0

    goto/16 :goto_0
.end method
