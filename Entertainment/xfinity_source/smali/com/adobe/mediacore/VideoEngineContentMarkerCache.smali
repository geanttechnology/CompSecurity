.class final Lcom/adobe/mediacore/VideoEngineContentMarkerCache;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;
    }
.end annotation


# static fields
.field private static final INVALID_TIME:J = -0x1L

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private _allEventsDispatched:Z

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private final _mainContentId:I

.field private final _markerInfos:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;",
            ">;"
        }
    .end annotation
.end field

.field private final _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineDispatcher;I)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput p2, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_mainContentId:I

    return-void
.end method


# virtual methods
.method public addMarker(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;IJ)V
    .locals 9

    iget-object v6, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    monitor-enter v6

    :try_start_0
    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    const-wide/16 v2, -0x1

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    monitor-exit v6

    :goto_0
    return-void

    :cond_0
    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    move v1, p2

    move-wide v4, p3

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;-><init>(IJJ)V

    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    monitor-exit v6

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public containsMarkerFor(J)Z
    .locals 9

    const/4 v1, 0x0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    monitor-exit v2

    move v0, v1

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v4

    cmp-long v4, p1, v4

    if-ltz v4, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getDuration()J

    move-result-wide v6

    add-long/2addr v4, v6

    cmp-long v0, p1, v4

    if-gez v0, :cond_1

    const/4 v0, 0x1

    monitor-exit v2

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_2
    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move v0, v1

    goto :goto_0
.end method

.method public dispatchEvents(J)V
    .locals 13

    const/4 v2, 0x1

    const/4 v3, 0x0

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    monitor-enter v5

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_allEventsDispatched:Z

    if-eqz v0, :cond_1

    :cond_0
    monitor-exit v5

    :goto_0
    return-void

    :cond_1
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_allEventsDispatched:Z

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v6

    cmp-long v4, p1, v6

    if-ltz v4, :cond_2

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getDuration()J

    move-result-wide v8

    add-long/2addr v6, v8

    cmp-long v0, p1, v6

    if-gez v0, :cond_2

    move v4, v2

    :goto_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_markerInfos:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_3
    :goto_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;

    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_allEventsDispatched:Z

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v8

    cmp-long v1, p1, v8

    if-ltz v1, :cond_4

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v8

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getDuration()J

    move-result-wide v10

    add-long/2addr v8, v10

    cmp-long v1, p1, v8

    if-gez v1, :cond_4

    move v1, v2

    :goto_3
    if-eqz v1, :cond_5

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->isEventDispatched()Z

    move-result v7

    if-nez v7, :cond_5

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#dispatchEvents"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Dispatching event for contentId ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getContentId()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] at time ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v6

    invoke-virtual {v3, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "], when current time is ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->setEventDispatched(Z)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getContentId()I

    move-result v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->getTimestamp()J

    move-result-wide v6

    invoke-static {v2, v6, v7}, Lcom/adobe/mediacore/ContentMarkerEvent;->createContentMarkerEvent(IJ)Lcom/adobe/mediacore/ContentMarkerEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    monitor-exit v5

    goto/16 :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_4
    move v1, v3

    goto :goto_3

    :cond_5
    if-nez v1, :cond_6

    :try_start_1
    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->isEventDispatched()Z

    move-result v1

    if-eqz v1, :cond_6

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache$MarkerInfo;->setEventDispatched(Z)V

    :cond_6
    if-nez v4, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v7, "#dispatchEvents"

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Dispatching event for contentId ["

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    iget v8, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_mainContentId:I

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "] at time ["

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "], when current time is ["

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "]"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v0, v1, v7}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget v1, p0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->_mainContentId:I

    invoke-static {v1, p1, p2}, Lcom/adobe/mediacore/ContentMarkerEvent;->createContentMarkerEvent(IJ)Lcom/adobe/mediacore/ContentMarkerEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_2

    :cond_7
    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    :cond_8
    move v4, v3

    goto/16 :goto_1
.end method
