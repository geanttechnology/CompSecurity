.class public final Lcom/adobe/mediacore/AdPolicyProxy;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/AdPolicyProxy$3;
    }
.end annotation


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private _adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

.field private _cachedSeekPosition:J

.field private _desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

.field private _firstPendingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

.field private _oldAdBreakPlacements:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation
.end field

.field private final _onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

.field private final _onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

.field private _pendingAdBreakPlacements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation
.end field

.field private _seekOrTrickPlay:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

.field private _timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

.field private _toPlaceAdBreakPlacements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation
.end field

.field private _videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

.field private _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private _videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/AdPolicyProxy;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/VideoEngineTimeline;Lcom/adobe/mediacore/TimelineOperationQueue;Lcom/adobe/mediacore/MediaPlayerItem;Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v0, Lcom/adobe/mediacore/AdPolicyProxy$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/AdPolicyProxy$1;-><init>(Lcom/adobe/mediacore/AdPolicyProxy;)V

    iput-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    new-instance v0, Lcom/adobe/mediacore/AdPolicyProxy$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/AdPolicyProxy$2;-><init>(Lcom/adobe/mediacore/AdPolicyProxy;)V

    iput-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    iput-object p1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iput-object p2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iput-object p3, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    iput-object p4, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    iput-object p5, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    iput-object p6, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    return-void
.end method

.method static synthetic access$000()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$100(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/AdPolicyProxy;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/AdPolicyProxy;Ljava/util/List;)Ljava/lang/Boolean;
    .locals 1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/AdPolicyProxy;)J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    return-wide v0
.end method

.method static synthetic access$522(Lcom/adobe/mediacore/AdPolicyProxy;J)J
    .locals 3

    iget-wide v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    sub-long/2addr v0, p1

    iput-wide v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    return-wide v0
.end method

.method static synthetic access$600(Lcom/adobe/mediacore/AdPolicyProxy;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/AdPolicyProxy;->removeAdBreakPlacementListeners()V

    return-void
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/AdPolicyProxy;)Lcom/adobe/mediacore/TimelineOperationQueue;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    return-object v0
.end method

.method private getAd(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 1

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private getPendingAdBreakPlacements(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;J)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;",
            "J)",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v6

    add-long/2addr v6, v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v8

    cmp-long v3, v8, p2

    if-lez v3, :cond_1

    cmp-long v3, v4, p2

    if-ltz v3, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    cmp-long v3, v6, v4

    if-gtz v3, :cond_0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v8

    cmp-long v3, v4, v8

    if-ltz v3, :cond_0

    cmp-long v3, v6, p2

    if-gez v3, :cond_0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_2
    invoke-direct {p0, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#AdPolicyProxy::getPendingAdBreakPlacements"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Found "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " skipped over ad breaks"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    :goto_1
    return-object v0

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#AdPolicyProxy::getPendingAdBreakPlacements"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Found 0 skipped over ad breaks"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    goto :goto_1
.end method

.method private getSeekIntoAdBreakPlacement(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    .locals 8

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdBreakPlacements()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v4

    add-long/2addr v4, v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v6

    cmp-long v2, v2, v6

    if-gtz v2, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    cmp-long v2, v4, v2

    if-lez v2, :cond_0

    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isCustomAdMarkerAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/lang/Boolean;
    .locals 1

    if-eqz p1, :cond_0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->getAd(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->isCustomAdMarker()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method private listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;
    .locals 2

    const/4 v1, 0x1

    if-nez p1, :cond_0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    if-eqz p1, :cond_1

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method private modifyAdBreakPlacements(Ljava/util/List;Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Z)J
    .locals 22
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;",
            "Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;",
            "Z)J"
        }
    .end annotation

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    if-eqz v2, :cond_0

    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    :cond_0
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    const-wide/16 v6, 0x0

    invoke-virtual/range {p2 .. p2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v16

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    move-wide/from16 v0, v16

    invoke-virtual {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertToLocalTime(J)J

    move-result-wide v4

    if-eqz p1, :cond_8

    const/4 v2, 0x0

    const/4 v13, 0x0

    invoke-interface/range {p1 .. p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v18

    move-object v3, v2

    :cond_1
    :goto_0
    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_7

    invoke-interface/range {v18 .. v18}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    move-object v12, v2

    check-cast v12, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    move-object/from16 v0, p0

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/AdPolicyProxy;->getAdBreakPolicyFor(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    move-result-object v2

    sget-object v8, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->SKIP:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    if-eq v2, v8, :cond_1

    sget-object v8, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->REMOVE:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    if-ne v2, v8, :cond_2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v9, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "#AdPolicyProxy::modifyAdBreakPlacements"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const-string v9, "Removing the Ad break due to REMOVE policy"

    invoke-interface {v2, v8, v9}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-direct {v2, v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-virtual {v8, v2}, Lcom/adobe/mediacore/TimelineOperationQueue;->addToQueue(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v8

    add-long/2addr v6, v8

    goto :goto_0

    :cond_2
    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v8

    add-long v14, v6, v8

    if-nez v3, :cond_3

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-wide/16 v6, 0x0

    invoke-direct/range {v2 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    move-object v3, v2

    :cond_3
    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->size()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v2, v6, v8

    if-lez v2, :cond_4

    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v6

    invoke-virtual {v6, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setRestoreId(Ljava/lang/String;)V

    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v10

    if-eqz v10, :cond_4

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v6, :cond_4

    new-instance v6, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v10}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v10}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v20

    move-wide/from16 v0, v20

    invoke-virtual {v8, v0, v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertToLocalTime(J)J

    move-result-wide v8

    invoke-virtual {v10}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v10

    invoke-direct/range {v6 .. v11}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    new-instance v8, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v9

    invoke-direct {v8, v9, v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-virtual {v7, v2, v8}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_4
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#AdPolicyProxy::modifyAdBreakPlacements"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const-string v7, "Adding ad break removal operation to queue"

    invoke-interface {v2, v6, v7}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v6, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-direct {v6, v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    if-nez v13, :cond_a

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    :goto_1
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-virtual {v7, v6}, Lcom/adobe/mediacore/TimelineOperationQueue;->addToQueue(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "#AdPolicyProxy::modifyAdBreakPlacements"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const-string v8, "Adding ad break placement operation to queue"

    invoke-interface {v6, v7, v8}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v6, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v12}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v7

    invoke-direct {v6, v7, v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    if-nez v7, :cond_5

    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    iput-object v7, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    :cond_5
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    invoke-interface {v7, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_firstPendingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-nez v7, :cond_6

    move-object/from16 v0, p0

    iput-object v6, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_firstPendingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    :cond_6
    move-object v13, v2

    move-wide v6, v14

    goto/16 :goto_0

    :cond_7
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    move-object/from16 v0, p0

    invoke-direct {v0, v2}, Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-nez v2, :cond_8

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_toPlaceAdBreakPlacements:Ljava/util/List;

    const/4 v4, 0x0

    invoke-interface {v2, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mediacore/timeline/TimelineOperation;

    invoke-virtual {v3, v2}, Lcom/adobe/mediacore/TimelineOperationQueue;->addToQueue(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    :cond_8
    if-nez p3, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    if-eqz v2, :cond_9

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/adobe/mediacore/AdPolicyProxy;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-interface {v2}, Lcom/adobe/mediacore/MediaPlayerItem;->isLive()Z

    move-result v2

    if-nez v2, :cond_9

    sub-long v2, v16, v6

    :goto_2
    return-wide v2

    :cond_9
    move-wide/from16 v2, v16

    goto :goto_2

    :cond_a
    move-object v2, v13

    goto/16 :goto_1
.end method

.method private final removeAdBreakPlacementListeners()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_1
    return-void
.end method

.method private selectAdBreaksToPlayForSeek(Ljava/util/List;JJ)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;JJ)",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    const/4 v3, 0x0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    const/high16 v8, 0x3f800000    # 1.0f

    iget-object v9, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_seekOrTrickPlay:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    move-object v2, p1

    move-wide v4, p2

    move-wide v6, p4

    invoke-direct/range {v1 .. v9}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;-><init>(Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/Ad;JJFLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;->selectAdBreaksToPlay(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Ljava/util/List;

    move-result-object v3

    :cond_0
    return-object v3
.end method

.method private shouldPlayUpcomingAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/lang/Boolean;
    .locals 10

    const/4 v0, 0x0

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacementList(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    if-eqz v1, :cond_2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    if-eqz v1, :cond_2

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v4

    iget-object v6, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v6}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v6

    const/high16 v8, 0x3f800000    # 1.0f

    iget-object v9, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_seekOrTrickPlay:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    invoke-direct/range {v1 .. v9}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;-><init>(Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/Ad;JJFLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V

    iget-object v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    invoke-interface {v2, v1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;->selectPolicyForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    if-eq v1, v2, :cond_0

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;->REMOVE_AFTER_PLAY:Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    if-ne v1, v2, :cond_1

    :cond_0
    const/4 v0, 0x1

    :cond_1
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_2
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    goto :goto_0
.end method

.method private startTimeForSeekIntoAd(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;JLcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J
    .locals 14

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v12

    const-wide/16 v0, 0x0

    move-wide v10, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/adobe/mediacore/timeline/advertising/Ad;

    add-long v0, v12, v10

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v4

    invoke-static {v0, v1, v4, v5}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-virtual/range {p4 .. p4}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    invoke-virtual {v0, v4, v5}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v0

    if-eqz v0, :cond_1

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacementList(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/util/List;

    move-result-object v2

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v6

    const/high16 v8, 0x3f800000    # 1.0f

    iget-object v9, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_seekOrTrickPlay:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    move-wide/from16 v4, p2

    invoke-direct/range {v1 .. v9}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;-><init>(Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/Ad;JJFLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;->selectPolicyForSeekIntoAd(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/timeline/advertising/AdPolicy;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/AdPolicyProxy$3;->$SwitchMap$com$adobe$mediacore$timeline$advertising$AdPolicy:[I

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdPolicy;->ordinal()I

    move-result v0

    aget v0, v1, v0

    packed-switch v0, :pswitch_data_0

    move-wide v0, v12

    :goto_1
    move-wide v12, v0

    :cond_0
    return-wide v12

    :pswitch_0
    invoke-virtual/range {p4 .. p4}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    goto :goto_1

    :pswitch_1
    add-long v0, v12, v10

    goto :goto_1

    :pswitch_2
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v2

    add-long/2addr v0, v2

    goto :goto_1

    :pswitch_3
    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v0

    add-long/2addr v0, v10

    add-long/2addr v0, v12

    goto :goto_1

    :pswitch_4
    move-wide v0, v12

    goto :goto_1

    :cond_1
    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v0

    add-long/2addr v0, v10

    move-wide v10, v0

    goto :goto_0

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method


# virtual methods
.method public createAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    .locals 5

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#AdPolicyProxy::createAdBreakPlacement"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "AdBreak: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_0

    if-eqz p2, :cond_1

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v0, p1, p2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    :cond_0
    :goto_0
    return-object v0

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineTimeline:Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v1, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->getPlacementFor(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    if-eqz v1, :cond_0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v0, p1, v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    goto :goto_0
.end method

.method public createAdBreakPlacementList(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#AdPolicyProxy::createAdBreakPlacementList"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "AdBreakPlacement: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getAdBreakPolicyFor(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;
    .locals 10

    const/4 v3, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#AdPolicyProxy::getgetAdBreakPolicyFor"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Selecting the policy for upcoming Ad Break"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    :goto_0
    if-nez v0, :cond_0

    invoke-virtual {p0, p1, v3}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v0

    :cond_0
    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacementList(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/util/List;

    move-result-object v2

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    if-eqz v1, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#AdPolicyProxy::getgetAdBreakPolicyFor"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v4, "Get AdBreakPolicy."

    invoke-interface {v0, v1, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    const/high16 v8, 0x3f800000    # 1.0f

    sget-object v9, Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    invoke-direct/range {v1 .. v9}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;-><init>(Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/Ad;JJFLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;->selectPolicyForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPolicy;

    move-result-object v3

    :cond_1
    return-object v3

    :cond_2
    move-object v0, v3

    goto :goto_0
.end method

.method public placeTimelineLineOperation(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 1

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-virtual {v0, p1}, Lcom/adobe/mediacore/TimelineOperationQueue;->addToQueue(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    :cond_0
    return-void
.end method

.method public registerSeekOrTrickPlayToTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V
    .locals 10

    iput-object p4, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_seekOrTrickPlay:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    iput-object p1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#AdPolicyProxy::registerSeekOrTrickPlayToTime"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "begin="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " end="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v1, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    cmp-long v1, v4, p2

    if-gez v1, :cond_f

    const/4 v0, 0x1

    move v6, v0

    :goto_0
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/AdPolicyProxy;->getSeekIntoAdBreakPlacement(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-direct {p0, v1, p2, p3}, Lcom/adobe/mediacore/AdPolicyProxy;->getPendingAdBreakPlacements(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;J)Ljava/util/List;

    move-result-object v1

    :try_start_0
    invoke-direct {p0, v0}, Lcom/adobe/mediacore/AdPolicyProxy;->isCustomAdMarkerAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/AdPolicyProxy;->getAd(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v4

    iget-object v5, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v5

    if-eqz v5, :cond_2

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v4

    sget-object v7, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v7}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v4, v7}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    const-string v7, "true"

    invoke-virtual {v4, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    iget v4, v5, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v8

    invoke-static {v4, v8, v9}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    :goto_1
    move-object v7, v0

    :goto_2
    if-eqz v1, :cond_3

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_1
    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->size()J

    move-result-wide v4

    const-wide/16 v8, 0x0

    cmp-long v4, v4, v8

    if-lez v4, :cond_1

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/AdPolicyProxy;->isCustomAdMarkerAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    if-nez v4, :cond_1

    iget-object v4, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    :cond_2
    const/4 v0, 0x0

    goto :goto_1

    :catch_0
    move-exception v4

    move-object v7, v0

    goto :goto_2

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#AdPolicyProxy::registerSeekOrTrickPlayToTime"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Pending ad breaks after cleanup: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v1, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz v7, :cond_6

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#AdPolicyProxy::registerSeekOrTrickPlayToTime"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v4, "Seek into ad break without other ad breaks skipped over"

    invoke-interface {v0, v1, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v7}, Lcom/adobe/mediacore/AdPolicyProxy;->shouldPlayUpcomingAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-direct {p0, v7, p2, p3, v0}, Lcom/adobe/mediacore/AdPolicyProxy;->startTimeForSeekIntoAd(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;JLcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)J

    move-result-wide v0

    :goto_4
    iput-wide v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-wide v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    invoke-static {v2, v3}, Lcom/adobe/mediacore/SeekEvent;->createSeekAdjustCompleted(J)Lcom/adobe/mediacore/SeekEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_4
    :goto_5
    return-void

    :cond_5
    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v0

    add-long/2addr v0, v2

    goto :goto_4

    :cond_6
    if-eqz v7, :cond_e

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_e

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#AdPolicyProxy::registerSeekOrTrickPlayToTime"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v4, "Seek into ad break with other ad breaks skipped over"

    invoke-interface {v0, v1, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v0

    cmp-long v0, v0, p2

    if-lez v0, :cond_c

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-interface {v0, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-wide v0, v2

    :goto_6
    iget-object v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v2

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v4

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v8

    add-long/2addr v4, v8

    invoke-static {v2, v4, v5}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v2

    iput-object v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-wide v8, v0

    :goto_7
    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    move-object v0, p0

    move-wide v2, p2

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/AdPolicyProxy;->selectAdBreaksToPlayForSeek(Ljava/util/List;JJ)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#AdPolicyProxy::registerSeekOrTrickPlayToTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Seek into content currentTime="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2, p3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", desiredPosition"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", selectAdBreaksToPlayForSeek empty: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-direct {p0, v3}, Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/AdPolicyProxy;->listIsEmpty(Ljava/util/List;)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_d

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    :cond_7
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementCompletedListener:Lcom/adobe/mediacore/AdBreakPlacementCompletedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_8
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    if-eqz v0, :cond_9

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_onAdBreakPlacementFailedListener:Lcom/adobe/mediacore/AdBreakPlacementFailedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    :cond_9
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_pendingAdBreakPlacements:Ljava/util/List;

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_desiredSeekPosition:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-direct {p0, v0, v1, v6}, Lcom/adobe/mediacore/AdPolicyProxy;->modifyAdBreakPlacements(Ljava/util/List;Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Z)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    if-eqz v7, :cond_a

    if-eqz v6, :cond_a

    iget-wide v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    const-wide/16 v2, 0x1

    add-long/2addr v0, v2

    iput-wide v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    :cond_a
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    :cond_b
    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-wide v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    invoke-static {v2, v3}, Lcom/adobe/mediacore/SeekEvent;->createSeekAdjustCompleted(J)Lcom/adobe/mediacore/SeekEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_5

    :cond_c
    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v2

    add-long/2addr v0, v2

    goto/16 :goto_6

    :cond_d
    iput-wide v8, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-wide v2, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_cachedSeekPosition:J

    invoke-static {v2, v3}, Lcom/adobe/mediacore/SeekEvent;->createSeekAdjustCompleted(J)Lcom/adobe/mediacore/SeekEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_5

    :cond_e
    move-wide v8, v2

    goto/16 :goto_7

    :cond_f
    move v6, v0

    goto/16 :goto_0
.end method

.method public removeOldAdBreakPlacementForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 2

    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    return-void
.end method

.method public restoreAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "AdPolicyProxy::restoreAdBreakPlacement"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Restore ad break"

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_oldAdBreakPlacements:Ljava/util/HashMap;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setRestoreId(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setIsWatched(Ljava/lang/Boolean;)V

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_timelineOperationQueue:Lcom/adobe/mediacore/TimelineOperationQueue;

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/TimelineOperationQueue;->addToQueue(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    :cond_0
    return-void
.end method

.method public seekThroughAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 4

    :try_start_0
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v2

    add-long/2addr v0, v2

    const/4 v2, -0x1

    invoke-static {v2, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->seek(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/AdPolicyProxy;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#seekThroughAdBreak"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Exception raised while trying to seek through AdBreak "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method public setAdBreakAsWatched(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/metadata/AdBreakAsWatched;)V
    .locals 10

    const/4 v3, 0x0

    sget-object v0, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->AD_BREAK_AS_WATCHED_ON_BEGIN:Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    if-eqz v1, :cond_0

    invoke-virtual {p0, p1, v3}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacement(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/adobe/mediacore/AdPolicyProxy;->createAdBreakPlacementList(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Ljava/util/List;

    move-result-object v2

    iget-object v1, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v1, :cond_0

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getCurrentTime()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    const/high16 v8, 0x3f800000    # 1.0f

    sget-object v9, Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;->PLAY:Lcom/adobe/mediacore/timeline/advertising/AdPolicyMode;

    invoke-direct/range {v1 .. v9}, Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;-><init>(Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/Ad;JJFLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V

    iget-object v0, p0, Lcom/adobe/mediacore/AdPolicyProxy;->_adPolicySelector:Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdPolicySelector;->selectWatchedPolicyForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdPolicyInfo;)Lcom/adobe/mediacore/metadata/AdBreakAsWatched;

    move-result-object v0

    :cond_0
    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p2}, Lcom/adobe/mediacore/metadata/AdBreakAsWatched;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setIsWatched(Ljava/lang/Boolean;)V

    :cond_1
    return-void
.end method
