.class final Lcom/adobe/mediacore/VideoEngineTimelineProxy;
.super Ljava/lang/Object;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private _currentHoldTime:J

.field private final _timeline:Lcom/adobe/ave/Timeline;

.field private final _timelineHoldMap:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/adobe/mediacore/TimelineHold;",
            ">;"
        }
    .end annotation
.end field

.field private final _videoEngineHoldManager:Lcom/adobe/mediacore/VideoEngineHoldManager;

.field private final _videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/VideoEngineTimelineProxy;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/ave/Timeline;Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/Hashtable;

    invoke-direct {v0}, Ljava/util/Hashtable;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_currentHoldTime:J

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid argument received. Timeline cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez p2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Invalid argument received. VideoEnginePlaybackMetrics cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timeline:Lcom/adobe/ave/Timeline;

    iput-object p2, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineHoldManager;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/VideoEngineHoldManager;-><init>(Lcom/adobe/mediacore/VideoEngineTimelineProxy;)V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEngineHoldManager:Lcom/adobe/mediacore/VideoEngineHoldManager;

    return-void
.end method

.method private isInPlaybackRange(J)Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public addHoldReference(J)V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/TimelineHold;

    invoke-interface {v0, p1, p2}, Lcom/adobe/mediacore/TimelineHold;->addReference(J)V

    :cond_0
    return-void
.end method

.method public addHoldReference(Lcom/adobe/mediacore/TimelineHold;)V
    .locals 4

    invoke-interface {p1}, Lcom/adobe/mediacore/TimelineHold;->getHoldTime()J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3, p1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    invoke-interface {p1, v0, v1}, Lcom/adobe/mediacore/TimelineHold;->addReference(J)V

    return-void
.end method

.method public containsHoldFor(J)Z
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    return v0
.end method

.method public getCurrentHoldTime()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_currentHoldTime:J

    return-wide v0
.end method

.method public getHoldAt(J)Lcom/adobe/mediacore/TimelineHold;
    .locals 7

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->isInPlaybackRange(J)Z

    move-result v1

    if-nez v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getHoldAt"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Cannot retrieve HOLD for this time "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ". Value given is not in playback range"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    invoke-virtual {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->isTimeBeforeReadHead(J)Z

    move-result v1

    if-eqz v1, :cond_2

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getHoldAt"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Cannot retrieve HOLD for this time "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ". Value given is before read head"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_2
    iget-wide v2, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_currentHoldTime:J

    const-wide/16 v4, -0x1

    cmp-long v1, v2, v4

    if-eqz v1, :cond_3

    iget-wide v2, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_currentHoldTime:J

    cmp-long v1, p1, v2

    if-lez v1, :cond_3

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#getHoldAt"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Pending HOLD for time "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEngineHoldManager:Lcom/adobe/mediacore/VideoEngineHoldManager;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineHoldManager;->addHoldPostion(J)V

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimelineHold;

    invoke-direct {v0, p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimelineHold;-><init>(Lcom/adobe/mediacore/VideoEngineTimelineProxy;J)V

    goto :goto_0

    :cond_3
    invoke-virtual {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->setHoldAt(J)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#getHoldAt"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Creating HOLD for time "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timeline:Lcom/adobe/ave/Timeline;

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->printTimeline(Lcom/adobe/ave/Timeline;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->printLivePlaybackWindowState(Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEngineHoldManager:Lcom/adobe/mediacore/VideoEngineHoldManager;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineHoldManager;->addHoldPostion(J)V

    iput-wide p1, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_currentHoldTime:J

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimelineHold;

    invoke-direct {v0, p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimelineHold;-><init>(Lcom/adobe/mediacore/VideoEngineTimelineProxy;J)V

    goto/16 :goto_0
.end method

.method public isTimeBeforeReadHead(J)Z
    .locals 9

    const/4 v1, 0x1

    const/4 v2, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;->getReadHead()J

    move-result-wide v4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->printLivePlaybackWindowState(Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;)V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "#isTimeBeforeReadHead"

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Is time provided ["

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, "] before read head ["

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v7, "] - "

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    cmp-long v0, p1, v4

    if-gtz v0, :cond_1

    move v0, v1

    :goto_0
    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v6, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-wide/16 v6, 0x0

    cmp-long v0, p1, v6

    if-gtz v0, :cond_3

    cmp-long v0, p1, v4

    if-gez v0, :cond_2

    :cond_0
    :goto_1
    return v1

    :cond_1
    move v0, v2

    goto :goto_0

    :cond_2
    move v1, v2

    goto :goto_1

    :cond_3
    cmp-long v0, p1, v4

    if-lez v0, :cond_0

    move v1, v2

    goto :goto_1
.end method

.method public releaseHoldReference(J)V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/TimelineHold;

    invoke-interface {v0, p1, p2}, Lcom/adobe/mediacore/TimelineHold;->releaseReference(J)V

    :cond_0
    return-void
.end method

.method protected removeHoldFor(J)V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timeline:Lcom/adobe/ave/Timeline;

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->printTimeline(Lcom/adobe/ave/Timeline;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEnginePlaybackMetrics:Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->printLivePlaybackWindowState(Lcom/adobe/mediacore/VideoEngineAdapter$VideoEnginePlaybackMetrics;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timelineHoldMap:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_videoEngineHoldManager:Lcom/adobe/mediacore/VideoEngineHoldManager;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineHoldManager;->removeHoldFor(J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_currentHoldTime:J

    :cond_0
    return-void
.end method

.method protected setHoldAt(J)Z
    .locals 5

    :try_start_0
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#setHoldAt"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Setting AVE hold at "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_timeline:Lcom/adobe/ave/Timeline;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/ave/Timeline;->setHoldAt(J)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimelineProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#setHoldAdt"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "VideoEngineException raise while placing HOLD for time "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    const/4 v0, 0x0

    goto :goto_0
.end method
