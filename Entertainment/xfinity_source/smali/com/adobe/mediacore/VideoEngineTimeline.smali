.class final Lcom/adobe/mediacore/VideoEngineTimeline;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;,
        Lcom/adobe/mediacore/VideoEngineTimeline$Period;,
        Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    }
.end annotation


# static fields
.field private static final DELTA:I = 0x5

.field private static final INSERTION_DELTA:I = 0x12c

.field public static final INVALID_CONTENT_ID:I = -0x1

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final READ_HEAD_DELTA:I = 0x2710

.field private static final _logger:Lcom/adobe/mediacore/logging/Logger;


# instance fields
.field private final START_AD_BREAK_ID:I

.field private _acceptedAds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;"
        }
    .end annotation
.end field

.field private _acceptedReplaceDuration:J

.field private final _adBreakPlacements:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation
.end field

.field private final _adBreaksPlacementToRemove:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            "Ljava/lang/Long;",
            ">;"
        }
    .end annotation
.end field

.field private final _contentCache:Lcom/adobe/mediacore/ContentCache;

.field private final _contentLoader:Lcom/adobe/mediacore/ContentLoader;

.field private _contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

.field private _executor:Ljava/lang/Runnable;

.field private _handler:Landroid/os/Handler;

.field private _initialTimeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

.field private _insertedAds:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;",
            ">;"
        }
    .end annotation
.end field

.field private final _mainContentId:I

.field private _mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

.field private final _mediaResource:Lcom/adobe/mediacore/MediaResource;

.field private _nextTimelineId:I

.field private final _onAdBreakCompleteLoadListener:Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;

.field private _processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

.field private final _videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

.field private final _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/VideoEngineTimeline;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/VideoEngineAdapter;Lcom/adobe/mediacore/MediaResource;IZ)V
    .locals 3

    const/16 v1, 0xbb8

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    iput v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->START_AD_BREAK_ID:I

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_initialTimeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iput v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreaksPlacementToRemove:Ljava/util/Map;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$2;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/VideoEngineTimeline$2;-><init>(Lcom/adobe/mediacore/VideoEngineTimeline;)V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_onAdBreakCompleteLoadListener:Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine dispatcher parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    if-nez p2, :cond_1

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Video engine parameter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_1
    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz p5, :cond_2

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Content cache is enabled."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/adobe/mediacore/ContentMapCache;

    invoke-direct {v0}, Lcom/adobe/mediacore/ContentMapCache;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    :goto_0
    new-instance v0, Lcom/adobe/mediacore/ContentLoader;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/ContentLoader;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/ContentCache;)V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentLoader:Lcom/adobe/mediacore/ContentLoader;

    iput-object p2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iput-object p3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    iput p4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mainContentId:I

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->initialise()V

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->clearAdBreakPlacement()V

    return-void

    :cond_2
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Content cache is disabled."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Lcom/adobe/mediacore/ContentNoCache;

    invoke-direct {v0}, Lcom/adobe/mediacore/ContentNoCache;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    goto :goto_0
.end method

.method private acceptAd(Lcom/adobe/mediacore/AdHandle;Lcom/adobe/mediacore/timeline/advertising/Ad;)V
    .locals 3

    invoke-virtual {p1}, Lcom/adobe/mediacore/AdHandle;->getDuration()J

    move-result-wide v0

    iget v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    invoke-static {p2, v0, v1, v2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->cloneAd(Lcom/adobe/mediacore/timeline/advertising/Ad;JI)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedAds:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    return-object v0
.end method

.method static synthetic access$100(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/ContentLoader;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentLoader:Lcom/adobe/mediacore/ContentLoader;

    return-object v0
.end method

.method static synthetic access$200()Ljava/lang/String;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300()Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/VideoEngineTimeline;)Lcom/adobe/mediacore/ContentCache;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    return-object v0
.end method

.method static synthetic access$600(Lcom/adobe/mediacore/VideoEngineTimeline;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->endAdBreakPlacement()V

    return-void
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/VideoEngineTimeline;Ljava/util/List;Ljava/util/List;)V
    .locals 0

    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline;->placeAdBreak(Ljava/util/List;Ljava/util/List;)V

    return-void
.end method

.method private add(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V
    .locals 2

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private adjusAdBreakPlacementPosition(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/Ad;)Z
    .locals 10
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    const/4 v0, 0x0

    if-eqz p2, :cond_0

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v1

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->getPeriod(I)Lcom/adobe/mediacore/VideoEngineTimeline$Period;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getVirtualTime()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v4

    cmp-long v1, v4, v2

    if-eqz v1, :cond_0

    const/4 v6, 0x1

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#adjusAdBreakPlacementPosition"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Adjusting ad break position from ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v8

    invoke-virtual {v4, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "] to ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v1, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v4

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v1

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v4

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->setPlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    move v0, v6

    :cond_0
    return v0
.end method

.method private calculateAdsDuration(Ljava/util/List;)J
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdHandle;",
            ">;)J"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    move v1, v0

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/AdHandle;

    int-to-long v4, v1

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdHandle;->getDuration()J

    move-result-wide v0

    add-long/2addr v0, v4

    long-to-int v0, v0

    move v1, v0

    goto :goto_0

    :cond_0
    int-to-long v0, v1

    return-wide v0
.end method

.method private calculateFailoverReplaceDuration(JLcom/adobe/mediacore/AdHandle;)J
    .locals 5

    const-wide/16 v0, 0x0

    cmp-long v2, p1, v0

    if-gtz v2, :cond_0

    invoke-virtual {p3}, Lcom/adobe/mediacore/AdHandle;->getDuration()J

    move-result-wide v2

    sub-long v2, p1, v2

    cmp-long v2, v2, v0

    if-lez v2, :cond_1

    :cond_0
    invoke-virtual {p3}, Lcom/adobe/mediacore/AdHandle;->getDuration()J

    move-result-wide v0

    sub-long v0, p1, v0

    :cond_1
    return-wide v0
.end method

.method private clearAdBreakPlacement()V
    .locals 1

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedAds:Ljava/util/List;

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    return-void
.end method

.method private endAdBreakPlacement()V
    .locals 10

    const/4 v0, 0x0

    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v8

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v4

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedAds:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_5

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedAds:Ljava/util/List;

    const/4 v1, 0x0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->isCustomAdMarker()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getVirtualTimeFor(Lcom/adobe/mediacore/timeline/advertising/Ad;)Ljava/lang/Long;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#endAdBreakPlacement"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "PlacementInformation information is "

    invoke-virtual {v6, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v9, " for "

    invoke-virtual {v6, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v5, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v1

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v4

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedAds:Ljava/util/List;

    iget-wide v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedReplaceDuration:J

    invoke-virtual {v8}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTag()Ljava/lang/String;

    move-result-object v6

    invoke-static/range {v1 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-virtual {v8}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setIsWatched(Ljava/lang/Boolean;)V

    :goto_0
    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->clearAdBreakPlacement()V

    if-eqz v1, :cond_4

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v2, v1, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->add(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->update()V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#remove"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Seekable range is  = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#remove"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Playback range is  = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v4}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_1
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v4

    if-nez v4, :cond_2

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#endAdBreakPlacement"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Unable to retrieve valid Ad Break."

    invoke-interface {v0, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_2
    :try_start_1
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v4

    invoke-direct {p0, v0, v4}, Lcom/adobe/mediacore/VideoEngineTimeline;->adjusAdBreakPlacementPosition(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/Ad;)Z
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    :catch_0
    move-exception v0

    :try_start_2
    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#endAdBreakPlacement"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    const-string v6, "A VideoEngineException occured while accessing the timeline"

    invoke-interface {v4, v5, v6, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_1

    :cond_3
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v7, v2}, Lcom/adobe/mediacore/AdBreakPlacementEvent;->createPlacementCompletedEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Lcom/adobe/mediacore/AdBreakPlacementEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMELINE_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :goto_2
    return-void

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v7}, Lcom/adobe/mediacore/AdBreakPlacementEvent;->createPlacementFailedEvent(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Lcom/adobe/mediacore/AdBreakPlacementEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_2

    :cond_5
    move-object v1, v0

    goto/16 :goto_0
.end method

.method private generateInsertedAds()V
    .locals 10

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    const/4 v2, 0x0

    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v9

    const-wide/16 v6, 0x0

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v6

    :cond_1
    :goto_1
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/adobe/mediacore/timeline/advertising/Ad;

    if-eqz v5, :cond_1

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/ContentCache;->getHandle(Ljava/lang/String;)Lcom/adobe/mediacore/AdHandle;

    move-result-object v4

    if-eqz v4, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    if-eqz v0, :cond_1

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdTimeMapping(I)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->isInvalid()Z

    move-result v0

    if-nez v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;

    move-object v1, p0

    invoke-direct/range {v0 .. v7}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;-><init>(Lcom/adobe/mediacore/VideoEngineTimeline;ILcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;Lcom/adobe/mediacore/AdHandle;Lcom/adobe/mediacore/timeline/advertising/Ad;J)V

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    :cond_3
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#generateInsertedAds"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "InsertedAds List size = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private getAdTimeMapping(I)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 6

    const/4 v1, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v3

    if-nez v3, :cond_0

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget v0, v3, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    move v2, v0

    move v0, v1

    :goto_1
    iget v4, v3, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v2, v4, :cond_5

    invoke-virtual {v3, v2}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v4

    if-eqz v4, :cond_3

    iget v5, v4, Lcom/adobe/ave/PeriodInfo;->userData:I

    if-ne v5, p1, :cond_3

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-wide v4, v4, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    invoke-virtual {v1, v4, v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertToLocalTime(J)J

    move-result-wide v4

    if-eqz v0, :cond_1

    invoke-static {v2, v4, v5}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto :goto_0

    :cond_1
    add-int/lit8 v0, v2, -0x1

    if-ltz v0, :cond_2

    add-int/lit8 v0, v2, -0x1

    invoke-static {v0, v4, v5}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto :goto_0

    :cond_2
    invoke-static {v2, v4, v5}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto :goto_0

    :cond_3
    if-eqz v4, :cond_4

    iget v0, v4, Lcom/adobe/ave/PeriodInfo;->userData:I

    iget v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mainContentId:I
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    if-eq v0, v4, :cond_4

    const/4 v0, 0x1

    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_4
    move v0, v1

    goto :goto_2

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getAdTimeMapping"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception raised while getting ad timemapping. {"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto/16 :goto_0

    :cond_5
    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto/16 :goto_0
.end method

.method private getAdjustedPlacementTimeMapping(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 8

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v1

    const/4 v2, -0x1

    if-eq v1, v2, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    iget-wide v4, v0, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    sub-long/2addr v2, v4

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#getAdjustedPlacementTimeMapping"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Diff between proposed position and period local start: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const-wide/16 v4, 0x2

    cmp-long v4, v2, v4

    if-lez v4, :cond_0

    const-wide/16 v4, 0x12c

    cmp-long v2, v2, v4

    if-gtz v2, :cond_0

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#getAdjustedPlacementTimeMapping"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Adjust Insertion position from "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v6

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " to "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v6, v0, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-wide v2, v0, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    invoke-static {v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object p1

    :cond_0
    :goto_0
    return-object p1

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getAdjustedPlacementTimeMapping"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception raised while adjusting placement time mapping. {"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private getAdjustedTimeMapping(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 3

    const-wide/32 v0, 0x7fffffff

    cmp-long v2, p1, v0

    if-lez v2, :cond_0

    move-wide p1, v0

    :cond_0
    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline;->mapLocalTime(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    return-object v0
.end method

.method private getNextTimeMapping(I)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 8

    const/4 v1, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v2

    if-eqz v2, :cond_1

    iget v0, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-ge p1, v0, :cond_0

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    add-int/lit8 v2, p1, 0x1

    const-wide/16 v4, 0x0

    const/4 v3, 0x0

    invoke-direct {v0, v2, v4, v5, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJLcom/adobe/mediacore/VideoEngineTimeline$1;)V

    :goto_0
    return-object v0

    :cond_0
    iget v0, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    invoke-virtual {v2, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v3

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iget v2, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    iget-wide v4, v3, Lcom/adobe/ave/PeriodInfo;->duration:J

    const-wide/16 v6, 0x5

    add-long/2addr v4, v6

    const/4 v3, 0x0

    invoke-direct {v0, v2, v4, v5, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJLcom/adobe/mediacore/VideoEngineTimeline$1;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getNextTimeMapping"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Could not create time mapping for ad insertion."

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method private declared-synchronized getNextTimelineId()I
    .locals 2

    monitor-enter p0

    :try_start_0
    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private getNonSeekableRanges()[Lcom/adobe/mediacore/utils/TimeRange;
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    instance-of v0, v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaResource:Lcom/adobe/mediacore/MediaResource;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v0, :cond_0

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->BLACKOUT_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->BLACKOUT_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/BlackoutMetadata;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/BlackoutMetadata;->getNonSeekableRanges()[Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    move-object v0, v1

    goto :goto_0
.end method

.method private getPeriod(I)Lcom/adobe/mediacore/VideoEngineTimeline$Period;
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/adobe/ave/VideoEngineException;
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    iget v0, v1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_0
    iget v2, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v0, v2, :cond_1

    invoke-virtual {v1, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    iget v3, v2, Lcom/adobe/ave/PeriodInfo;->userData:I

    if-ne v3, p1, :cond_0

    new-instance v1, Lcom/adobe/mediacore/VideoEngineTimeline$Period;

    invoke-direct {v1, p0, v0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;-><init>(Lcom/adobe/mediacore/VideoEngineTimeline;ILcom/adobe/ave/PeriodInfo;)V

    move-object v0, v1

    :goto_1
    return-object v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private getVirtualTimeFor(Lcom/adobe/mediacore/timeline/advertising/Ad;)Ljava/lang/Long;
    .locals 5

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    iget v0, v1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_0
    iget v2, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v0, v2, :cond_1

    invoke-virtual {v1, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v2

    if-eqz v2, :cond_0

    iget v3, v2, Lcom/adobe/ave/PeriodInfo;->userData:I

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v4

    if-ne v3, v4, :cond_0

    iget-wide v0, v2, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_1
    return-object v0

    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#getVirtualTimeFor"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Exception raised while trying to access the timeline "

    invoke-interface {v1, v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    :cond_1
    const/4 v0, 0x0

    goto :goto_1
.end method

.method private initialise()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_onAdBreakCompleteLoadListener:Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_handler:Landroid/os/Handler;

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/VideoEngineTimeline$1;-><init>(Lcom/adobe/mediacore/VideoEngineTimeline;)V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_executor:Ljava/lang/Runnable;

    return-void
.end method

.method private isLive()Z
    .locals 5

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    if-eqz v1, :cond_0

    iget v1, v1, Lcom/adobe/ave/Timeline;->complete:I

    if-nez v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v1

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#isLive"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "Could not obtain timeline from VideoEngine "

    invoke-interface {v2, v3, v4, v1}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_0
.end method

.method private isWithinBounds(JJ)Z
    .locals 9

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    iget v2, v1, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    invoke-virtual {v1, v2}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v2

    iget-wide v2, v2, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    iget v4, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    invoke-virtual {v1, v4}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v4

    iget-wide v4, v4, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    iget v6, v1, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    invoke-virtual {v1, v6}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v1

    iget-wide v6, v1, Lcom/adobe/ave/PeriodInfo;->duration:J
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    add-long/2addr v4, v6

    cmp-long v1, p1, v2

    if-ltz v1, :cond_0

    cmp-long v1, p1, v4

    if-gez v1, :cond_0

    cmp-long v1, p3, v2

    if-lez v1, :cond_0

    cmp-long v1, p3, v4

    if-gtz v1, :cond_0

    const/4 v0, 0x1

    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v1

    goto :goto_0
.end method

.method private loadAds()V
    .locals 6

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#loadAds"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Starting to load ad manifests for adBreak = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentLoader:Lcom/adobe/mediacore/ContentLoader;

    invoke-virtual {v2, v1}, Lcom/adobe/mediacore/ContentLoader;->setVideoEngineTimeline(Lcom/adobe/ave/Timeline;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_handler:Landroid/os/Handler;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_executor:Ljava/lang/Runnable;

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    :goto_1
    return-void

    :cond_0
    :try_start_1
    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#loadAds"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Timeline received on the from the video engine is null"

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#loadAds"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Exception raised while trying to access the video engine timeline { code = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", description = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "}"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_1
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#loadAds"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Timeline retrieve from the VideoEngine is invalid. Ending ad break placement"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->endAdBreakPlacement()V

    goto/16 :goto_1
.end method

.method private mapLocalTime(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 11

    const/4 v10, 0x0

    const/4 v1, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget v0, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    invoke-virtual {v2, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v3

    if-eqz v3, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    iget-wide v4, v3, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    iget-wide v6, v3, Lcom/adobe/ave/PeriodInfo;->duration:J

    add-long/2addr v4, v6

    invoke-virtual {v0, v4, v5}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertToLocalTime(J)J

    move-result-wide v4

    cmp-long v0, p1, v4

    if-ltz v0, :cond_1

    new-instance v0, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    iget v1, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    const/4 v2, 0x0

    invoke-direct {v0, v1, p1, p2, v2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJLcom/adobe/mediacore/VideoEngineTimeline$1;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#mapLocalTime"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception raised while mapping time on timeline. {"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto :goto_0

    :cond_1
    :try_start_1
    iget v0, v2, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    iget v4, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    add-int/lit8 v4, v4, 0x1

    :goto_1
    if-ge v0, v4, :cond_6

    invoke-virtual {v2, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v5

    if-eqz v5, :cond_3

    iget v6, v5, Lcom/adobe/ave/PeriodInfo;->userData:I

    iget v7, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mainContentId:I

    if-ne v6, v7, :cond_3

    iget-wide v6, v5, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    iget-wide v8, v5, Lcom/adobe/ave/PeriodInfo;->duration:J

    add-long/2addr v8, v6

    cmp-long v5, p1, v6

    if-ltz v5, :cond_2

    cmp-long v5, v6, p1

    if-gtz v5, :cond_3

    cmp-long v5, p1, v8

    if-gez v5, :cond_3

    :cond_2
    :goto_2
    if-ne v0, v1, :cond_5

    if-eqz v3, :cond_4

    invoke-static {}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->createInvalid()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    goto/16 :goto_0

    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_4
    iget v0, v2, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0

    :cond_5
    new-instance v1, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-direct {v1, v0, p1, p2, v10}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;-><init>(IJLcom/adobe/mediacore/VideoEngineTimeline$1;)V

    move-object v0, v1

    goto/16 :goto_0

    :cond_6
    move v0, v1

    goto :goto_2
.end method

.method private placeAdBreak(Ljava/util/List;Ljava/util/List;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/AdHandle;",
            ">;)V"
        }
    .end annotation

    const-wide/16 v10, 0x0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#placeAdBreak"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ad break placement process starting."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, p2}, Lcom/adobe/mediacore/VideoEngineTimeline;->calculateAdsDuration(Ljava/util/List;)J

    move-result-wide v0

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v2

    cmp-long v4, v2, v10

    if-eqz v4, :cond_4

    :goto_0
    iput-wide v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedReplaceDuration:J

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v2

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_initialTimeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->isInvalid()Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_initialTimeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    invoke-direct {p0, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdjustedTimeMapping(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v2

    :goto_1
    invoke-virtual {v2}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->isInvalid()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->endAdBreakPlacement()V

    :cond_0
    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdjustedPlacementTimeMapping(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v3

    const/4 v2, 0x0

    move v8, v2

    move-wide v4, v0

    move-object v1, v3

    :goto_2
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v0

    if-ge v8, v0, :cond_3

    invoke-interface {p2, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v6, v0

    check-cast v6, Lcom/adobe/mediacore/AdHandle;

    invoke-interface {p1, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v7, v0

    check-cast v7, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v6}, Lcom/adobe/mediacore/AdHandle;->getHandle()I

    move-result v2

    iget v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/VideoEngineTimeline;->placeContent(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;IIJ)I

    move-result v0

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v9, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v9, "#placeAdBreak"

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Placecontent: time="

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v12, ", adHandle="

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v12, ", replaceDuration="

    invoke-virtual {v9, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v2, v3, v9}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v2, -0x1

    if-eq v0, v2, :cond_2

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#placeAdBreak"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Ad inserted at period "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " with contentId = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " url = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v6, v7}, Lcom/adobe/mediacore/VideoEngineTimeline;->acceptAd(Lcom/adobe/mediacore/AdHandle;Lcom/adobe/mediacore/timeline/advertising/Ad;)V

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getNextTimeMapping(I)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    move-wide v4, v10

    :goto_3
    add-int/lit8 v0, v8, 0x1

    move v8, v0

    goto/16 :goto_2

    :cond_1
    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v2

    invoke-direct {p0, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdjustedTimeMapping(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v2

    goto/16 :goto_1

    :cond_2
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#placeAdBreak"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Ad insertion failed for contentId = "

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget v9, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v9, " url = "

    invoke-virtual {v3, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_nextTimelineId:I

    const/4 v2, 0x1

    invoke-direct {p0, v0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeContent(IZ)Z

    invoke-direct {p0, v4, v5, v6}, Lcom/adobe/mediacore/VideoEngineTimeline;->calculateFailoverReplaceDuration(JLcom/adobe/mediacore/AdHandle;)J

    move-result-wide v4

    iput-wide v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedReplaceDuration:J

    goto :goto_3

    :cond_3
    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->endAdBreakPlacement()V

    return-void

    :cond_4
    move-wide v0, v2

    goto/16 :goto_0
.end method

.method private placeContent(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;IIJ)I
    .locals 10

    const/4 v8, -0x1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    if-eqz v0, :cond_1

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#placeContent"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Placing content at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " for handle "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " contentId = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " replaceDuration = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p4, p5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getPeriod()I

    move-result v1

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v2

    move v4, p2

    move v5, p3

    move-wide v6, p4

    invoke-virtual/range {v0 .. v7}, Lcom/adobe/ave/Timeline;->insertByLocalTime(IJIIJ)Lcom/adobe/ave/InsertionResult;

    move-result-object v0

    if-nez v0, :cond_0

    move v0, v8

    :goto_0
    return v0

    :cond_0
    iget v0, v0, Lcom/adobe/ave/InsertionResult;->periodIndex:I
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#placeContent"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception raised while placing content. {"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    move v0, v8

    goto :goto_0
.end method

.method static printTimeline(Lcom/adobe/ave/Timeline;)V
    .locals 8

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#printTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Showing the AVE timeline:"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    if-nez p0, :cond_1

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#printTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Invalid AVE timeline"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    :try_start_0
    iget v0, p0, Lcom/adobe/ave/Timeline;->firstPeriodIndex:I

    :goto_1
    iget v1, p0, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    if-gt v0, v1, :cond_0

    invoke-virtual {p0, v0}, Lcom/adobe/ave/Timeline;->getPeriodInfo(I)Lcom/adobe/ave/PeriodInfo;

    move-result-object v1

    if-eqz v1, :cond_2

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#printTimeline"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "> "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " vStart: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v6, v1, Lcom/adobe/ave/PeriodInfo;->virtualStartTime:J

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " lStart: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v6, v1, Lcom/adobe/ave/PeriodInfo;->localStartTime:J

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " - duration: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-wide v6, v1, Lcom/adobe/ave/PeriodInfo;->duration:J

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " contentId: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget v1, v1, Lcom/adobe/ave/PeriodInfo;->userData:I

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v2, v3, v1}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#printTimeline"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception raised while accessing the video engine timeline{ code = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", message = "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private processCustomMarkers()Z
    .locals 25

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v10

    const-wide/16 v8, 0x0

    const-wide/16 v12, 0x0

    const/4 v6, 0x0

    move v7, v6

    :cond_0
    :goto_0
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v11

    invoke-virtual {v11}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v11

    invoke-virtual {v11}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v11

    if-nez v11, :cond_4

    invoke-direct/range {p0 .. p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getNextTimelineId()I

    move-result v11

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-object/from16 v16, v0

    invoke-virtual/range {v16 .. v16}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v16

    add-long v16, v16, v8

    move-object/from16 v0, p0

    move-wide/from16 v1, v16

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdjustedTimeMapping(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->isInvalid()Z

    move-result v17

    if-nez v17, :cond_0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    move-object/from16 v17, v0

    invoke-virtual/range {v17 .. v17}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v18

    add-long v20, v18, v14

    move-object/from16 v0, p0

    move-wide/from16 v1, v18

    move-wide/from16 v3, v20

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/adobe/mediacore/VideoEngineTimeline;->isWithinBounds(JJ)Z

    move-result v17

    if-nez v17, :cond_1

    sget-object v17, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v22, Ljava/lang/StringBuilder;

    invoke-direct/range {v22 .. v22}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v23, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    const-string v23, "#processCustomMarkers"

    invoke-virtual/range {v22 .. v23}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v22

    invoke-virtual/range {v22 .. v22}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v22

    new-instance v23, Ljava/lang/StringBuilder;

    invoke-direct/range {v23 .. v23}, Ljava/lang/StringBuilder;-><init>()V

    const-string v24, "Invalid TimeRange ["

    invoke-virtual/range {v23 .. v24}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v23

    move-object/from16 v0, v23

    move-wide/from16 v1, v18

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, ", "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    move-object/from16 v0, v18

    move-wide/from16 v1, v20

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v18

    const-string v19, "], \'begin\' or \'end\' value is out of bounds of stream"

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v18 .. v18}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v17

    move-object/from16 v1, v22

    move-object/from16 v2, v18

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    move-object/from16 v0, p0

    move-object/from16 v1, v16

    invoke-virtual {v0, v1, v11, v14, v15}, Lcom/adobe/mediacore/VideoEngineTimeline;->placeContentMarker(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;IJ)Z

    move-result v17

    if-eqz v17, :cond_4

    const/4 v7, 0x1

    invoke-static {v6, v14, v15, v11}, Lcom/adobe/mediacore/timeline/advertising/Ad;->cloneAd(Lcom/adobe/mediacore/timeline/advertising/Ad;JI)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v6

    sget-object v11, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v17, Ljava/lang/StringBuilder;

    invoke-direct/range {v17 .. v17}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v18, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    const-string v18, "#placeAd"

    invoke-virtual/range {v17 .. v18}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v17

    invoke-virtual/range {v17 .. v17}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v17

    new-instance v18, Ljava/lang/StringBuilder;

    invoke-direct/range {v18 .. v18}, Ljava/lang/StringBuilder;-><init>()V

    const-string v19, "Placing custom ad-marker in "

    invoke-virtual/range {v18 .. v19}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v18

    invoke-virtual/range {v16 .. v16}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->toString()Ljava/lang/String;

    move-result-object v16

    invoke-static/range {v16 .. v16}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v18

    move-object/from16 v1, v16

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v18, " with replacement duration ["

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v0, v12, v13}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v18, "]. "

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/Ad;->toString()Ljava/lang/String;

    move-result-object v18

    move-object/from16 v0, v16

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v17

    move-object/from16 v1, v16

    invoke-interface {v11, v0, v1}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedAds:Ljava/util/List;

    invoke-interface {v11, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    add-long/2addr v8, v14

    move v6, v7

    :goto_1
    move v7, v6

    goto/16 :goto_0

    :cond_2
    if-eqz v7, :cond_3

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v10

    add-long/2addr v8, v10

    move-object/from16 v0, p0

    invoke-direct {v0, v8, v9}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdjustedTimeMapping(J)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    invoke-direct/range {p0 .. p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->endAdBreakPlacement()V

    :cond_3
    return v7

    :cond_4
    move v6, v7

    goto :goto_1
.end method

.method private removeByLocalTime(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 10

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByLocalTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Starting to remove the AdBreak by local time"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, p1

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v3

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    new-instance v5, Ljava/util/ArrayList;

    invoke-direct {v5}, Ljava/util/ArrayList;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "#removeByLocalTime"

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Seekable range is  = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v7}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v1, v6}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "#removeByLocalTime"

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Playback range is  = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v7}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v1, v6}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getReplaceDuration()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v1, v6, v8

    if-eqz v1, :cond_0

    const/4 v1, 0x1

    :goto_1
    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "#removeByLocalTime"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Removing the content with id = "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " and replace content is set to "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v7, v8}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v6

    invoke-direct {p0, v6, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeContent(IZ)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#removeByLocalTime"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Removing the content with id = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " succeded"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v1, v6, v7}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :cond_0
    const/4 v1, 0x0

    goto/16 :goto_1

    :cond_1
    invoke-interface {v5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#removeByLocalTime"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Removing the content with id = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, " failed"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-interface {v1, v6, v7}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->GENERIC_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v6, "Failed to remove content from timeline"

    invoke-static {v1, v6}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v6

    new-instance v7, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v7}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v8, "AD_BREAK"

    move-object v1, p1

    check-cast v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v7, v8, v1}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v1, "AD"

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v7, v1, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v6, v7}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v6}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto/16 :goto_0

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->update()V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByLocalTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Seekable range is  = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByLocalTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Playback range is  = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->printTimeline(Lcom/adobe/ave/Timeline;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_2
    const/4 v1, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_3
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v6

    invoke-virtual {v3, v6}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_5

    :goto_4
    move-object v1, v0

    goto :goto_3

    :catch_0
    move-exception v0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByLocalTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to retrieve thet timeline in order to print the timeline"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :cond_3
    invoke-direct {p0, v5, v4, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->updateAdBreakPlacement(Ljava/util/List;Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Z

    move-result v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMELINE_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    return-void

    :cond_5
    move-object v0, v1

    goto :goto_4
.end method

.method private removeByVirtualTime(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 11

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByVirtualTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Starting to remove the AdBreak by virtual time"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    check-cast p1, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v1

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v3

    const/4 v0, 0x0

    :try_start_0
    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#removeByVirtualTime"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Seekable range is  = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v7}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#removeByVirtualTime"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Playback range is  = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v7}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v7

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v4, v5, v6}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->getPeriod(I)Lcom/adobe/mediacore/VideoEngineTimeline$Period;

    move-result-object v1

    invoke-direct {p0, v3}, Lcom/adobe/mediacore/VideoEngineTimeline;->getPeriod(I)Lcom/adobe/mediacore/VideoEngineTimeline$Period;

    move-result-object v3

    if-eqz v1, :cond_0

    if-eqz v3, :cond_0

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getVirtualTime()J

    move-result-wide v4

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getVirtualTime()J

    move-result-wide v6

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getDuration()J

    move-result-wide v8

    add-long/2addr v6, v8

    invoke-direct {p0, v4, v5, v6, v7}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeContentByVirtualTime(JJ)Z
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :try_start_1
    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#removeByVirtualTime"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Removed Ads content from ["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getVirtualTime()J

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "] to ["

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getVirtualTime()J

    move-result-wide v6

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getDuration()J

    move-result-wide v8

    add-long/2addr v6, v8

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "] from timeline."

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v4, v5, v1}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_3

    :cond_0
    :goto_0
    if-eqz v0, :cond_6

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v3

    const/4 v1, 0x0

    :try_start_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-wide v8

    cmp-long v5, v6, v8

    if-nez v5, :cond_7

    :goto_2
    move-object v1, v0

    goto :goto_1

    :catch_0
    move-exception v1

    move-object v10, v1

    move v1, v0

    move-object v0, v10

    :goto_3
    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#removeByVirtualTime"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Removing AdBreak from timeline failed"

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->printStackTrace()V

    move v0, v1

    goto :goto_0

    :cond_1
    if-eqz v1, :cond_2

    :try_start_3
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "#removeByVirtualTime - updateAdBreakPlacement"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Removing ad break from ad timeline : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v2, v4}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_3

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    if-nez v2, :cond_4

    :cond_3
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "#removeByVirtualTime - updateAdBreakPlacement"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v4, "Unable to retrieve valid Ad Break."

    invoke-interface {v0, v2, v4}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_4

    :catchall_0
    move-exception v0

    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v0

    :cond_4
    :try_start_4
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-direct {p0, v0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->adjusAdBreakPlacementPosition(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/Ad;)Z
    :try_end_4
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_4

    :catch_1
    move-exception v0

    :try_start_5
    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#removeByVirtualTime - updateAdBreakPlacement"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "A VideoEngineException occured while accessing the timeline"

    invoke-interface {v2, v4, v5, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto :goto_4

    :cond_5
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMELINE_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    monitor-exit v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->update()V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByVirtualTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Seekable range is  = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getSeekableRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByVirtualTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Playback range is  = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v3}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->getPlaybackRange()Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/utils/TimeRange;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    :try_start_6
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->printTimeline(Lcom/adobe/ave/Timeline;)V
    :try_end_6
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_6 .. :try_end_6} :catch_2

    :goto_5
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_6
    return-void

    :catch_2
    move-exception v0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeByVirtualTime"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Unable to retrieve thet timeline in order to print the timeline"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_5

    :catch_3
    move-exception v1

    move-object v10, v1

    move v1, v0

    move-object v0, v10

    goto/16 :goto_3

    :cond_7
    move-object v0, v1

    goto/16 :goto_2
.end method

.method private removeContent(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 8

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v2

    add-long/2addr v2, v0

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline;->isWithinBounds(JJ)Z

    move-result v4

    if-nez v4, :cond_0

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#removeContent"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Invalid TimeRange ["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0, v1}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "], \'begin\' or \'end\' value is out of bounds of stream"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v5, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v4

    add-long/2addr v2, v4

    invoke-direct {p0, v0, v1, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeContentByLocalTime(JJ)Z

    move-result v0

    if-nez v0, :cond_1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->GENERIC_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "Failed to remove content from timeline"

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v0}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getPlaybackMetrics()Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/qos/metrics/PlaybackMetrics;->update()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->ADBREAK_REMOVAL_COMPLETED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    goto :goto_0
.end method

.method private removeContent(IZ)Z
    .locals 10

    const/4 v7, 0x0

    :try_start_0
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->getPeriod(I)Lcom/adobe/mediacore/VideoEngineTimeline$Period;

    move-result-object v1

    if-nez v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Unable to remove content with id ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v7

    :goto_0
    return v0

    :cond_0
    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getLocalStartTime()J

    move-result-wide v2

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getLocalEndTime()J

    move-result-wide v4

    cmp-long v0, v2, v4

    if-nez v0, :cond_1

    const-wide/16 v8, 0x1

    add-long/2addr v4, v8

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineTimeline$Period;->getPeriodIndex()I

    move-result v1

    move v6, p2

    invoke-virtual/range {v0 .. v6}, Lcom/adobe/ave/Timeline;->eraseByLocalTime(IJJZ)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeContent"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Removed content ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] from timeline."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    goto :goto_0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#removeContent"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Exception raised while removing content. {"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ","

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "}"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move v0, v7

    goto/16 :goto_0
.end method

.method private removeContentByLocalTime(JJ)Z
    .locals 9

    const/4 v7, 0x0

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    const/4 v6, 0x0

    iget v1, v0, Lcom/adobe/ave/Timeline;->lastPeriodIndex:I

    move-wide v2, p1

    move-wide v4, p3

    invoke-virtual/range {v0 .. v6}, Lcom/adobe/ave/Timeline;->eraseByLocalTime(IJJZ)V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#removeContentByLocalTime"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Removed content ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] from timeline. Period index: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v2, v1}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    move v0, v7

    goto :goto_0
.end method

.method private removeContentByVirtualTime(JJ)Z
    .locals 5

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/adobe/ave/Timeline;->eraseByVirtualTime(JJ)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :catch_0
    move-exception v0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#removeByVirtualTime"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Removing AdBreak from timeline failed"

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->printStackTrace()V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method private removeOldAdBreaks(J)Z
    .locals 11

    const/4 v0, 0x0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreaksPlacementToRemove:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v1

    if-lez v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getBufferControlParameters()Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v1

    if-nez v1, :cond_2

    :cond_0
    move v2, v0

    :cond_1
    return v2

    :cond_2
    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v1}, Lcom/adobe/mediacore/VideoEngineAdapter;->getBufferControlParameters()Lcom/adobe/mediacore/BufferControlParameters;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/BufferControlParameters;->getPlayBufferTime()J

    move-result-wide v4

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreaksPlacementToRemove:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move v2, v0

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Long;

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    sub-long v6, p1, v6

    cmp-long v0, v6, v4

    if-ltz v0, :cond_3

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v8, "#removeOldAdBreaks"

    invoke-virtual {v2, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Removing ad break from ad timeline after ["

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] ms of waiting. ["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v2, v6}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    invoke-interface {v3}, Ljava/util/Iterator;->remove()V

    const/4 v0, 0x1

    :goto_1
    move v2, v0

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_3
    move v0, v2

    goto :goto_1
.end method

.method private retrieveTotalDuration(Ljava/util/List;)J
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;)J"
        }
    .end annotation

    const-wide/16 v0, 0x0

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    move-wide v2, v0

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getDuration()J

    move-result-wide v0

    add-long/2addr v0, v2

    move-wide v2, v0

    goto :goto_0

    :cond_0
    return-wide v2
.end method

.method private seekableTimeEquivalentOfTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 6

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getNonSeekableRanges()[Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v1

    if-eqz v1, :cond_1

    const/4 v0, 0x0

    :goto_0
    array-length v2, v1

    if-ge v0, v2, :cond_1

    aget-object v2, v1, v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->getTime()J

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Lcom/adobe/mediacore/utils/TimeRange;->contains(J)Z

    move-result v3

    if-eqz v3, :cond_2

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#seekableTimeEquivalentOfTime"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "[Warning] >> desired postion "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {p1}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " falls into nonSeekable range ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v4

    invoke-virtual {v3, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]."

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->INVALID_SEEK_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "Attempt to seek into nonSeekableRanges."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    invoke-static {v0}, Lcom/adobe/mediacore/OperationFailedEvent;->createEvent(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)Lcom/adobe/mediacore/OperationFailedEvent;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_0
    const/4 v0, -0x1

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v2

    invoke-static {v0, v2, v3}, Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;->create(IJ)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object p1

    :cond_1
    return-object p1

    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_0
.end method

.method private updateAdBreakPlacement(Ljava/util/List;Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;)Z
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/Ad;",
            ">;",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ")Z"
        }
    .end annotation

    const/4 v0, 0x0

    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    if-nez p3, :cond_1

    :cond_0
    :goto_0
    return v0

    :cond_1
    iget-object v7, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v7

    :try_start_0
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :try_start_1
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v2

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->getPeriod(I)Lcom/adobe/mediacore/VideoEngineTimeline$Period;

    move-result-object v2

    if-nez v2, :cond_2

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#updateAdBreakPlacement"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Readjusting ad break : Ad "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " does not exist on AVE timeline."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#updateAdBreakPlacement"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Readjusting ad break : Ad "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " removed from AdBreakPlacement"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_1

    :catch_0
    move-exception v0

    :try_start_2
    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->printStackTrace()V

    goto/16 :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v7
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    :cond_3
    :try_start_3
    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#updateAdBreakPlacement"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Readjusting ad break : Ad "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, " could not be removed from AdBreakPlacement"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_3
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_1

    :cond_4
    :try_start_4
    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_6

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#updateAdBreakPlacement"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Removing ad break from ad timeline : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->d(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0, p3}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    :goto_2
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_8

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_5

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    if-nez v2, :cond_7

    :cond_5
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#updateAdBreakPlacement"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Unable to retrieve valid Ad Break."

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_3

    :cond_6
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#updateAdBreakPlacement"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Readjusting ad break : "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0, p3}, Ljava/util/List;->indexOf(Ljava/lang/Object;)I

    move-result v8

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getVirtualTimeFor(Lcom/adobe/mediacore/timeline/advertising/Ad;)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->retrieveTotalDuration(Ljava/util/List;)J

    move-result-wide v10

    const-wide/16 v4, 0x0

    invoke-virtual {p3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTag()Ljava/lang/String;

    move-result-object v6

    move-object v1, p1

    invoke-static/range {v1 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v6

    invoke-virtual {p3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->isWatched()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v6, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->setIsWatched(Ljava/lang/Boolean;)V

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {p3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v1

    move-wide v4, v10

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v1, v6, v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0, v8, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_2

    :cond_7
    :try_start_5
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-direct {p0, v0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->adjusAdBreakPlacementPosition(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/Ad;)Z
    :try_end_5
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_3

    :catch_1
    move-exception v0

    :try_start_6
    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#updateAdBreakPlacement"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    const-string v4, "A VideoEngineException occured while accessing the timeline"

    invoke-interface {v2, v3, v4, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Exception;)V

    goto/16 :goto_3

    :cond_8
    monitor-exit v7
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    const/4 v0, 0x1

    goto/16 :goto_0
.end method


# virtual methods
.method public adjustSeekPosition(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;
    .locals 2

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->seekableTimeEquivalentOfTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v1}, Lcom/adobe/mediacore/MediaPlayerClient;->getAdPolicyProxy()Lcom/adobe/mediacore/AdPolicyProxy;

    move-result-object v1

    invoke-virtual {v1, v0, p2, p3, p4}, Lcom/adobe/mediacore/AdPolicyProxy;->registerSeekOrTrickPlayToTime(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;JLcom/adobe/mediacore/timeline/advertising/AdPolicyMode;)V

    return-object v0
.end method

.method public clear()V
    .locals 4

    const/4 v3, 0x0

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentLoader:Lcom/adobe/mediacore/ContentLoader;

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentLoader;->releaseHandles()V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_onAdBreakCompleteLoadListener:Lcom/adobe/mediacore/AdBreakManifestLoadCompleteListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iput-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_handler:Landroid/os/Handler;

    iput-object v3, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_executor:Ljava/lang/Runnable;

    return-void

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0
.end method

.method public containsMarkerForTime(J)Z
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->containsMarkerFor(J)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public convertToLocalTime(J)J
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineAdapter;->convertToLocalTime(J)J

    move-result-wide v0

    return-wide v0
.end method

.method public execute(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 1

    instance-of v0, p1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_1

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->place(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    :cond_0
    :goto_0
    return-void

    :cond_1
    instance-of v0, p1, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    if-eqz v0, :cond_2

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->remove(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    goto :goto_0

    :cond_2
    instance-of v0, p1, Lcom/adobe/mediacore/timeline/advertising/ContentRemoval;

    if-eqz v0, :cond_0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeContent(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    goto :goto_0
.end method

.method public getAdBreakPlacements()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    return-object v0
.end method

.method public getAdSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;
    .locals 2

    sget-object v0, Lcom/adobe/mediacore/metadata/AdSignalingMode;->DEFAULT:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaPlayerClient;->getAdSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v0

    :cond_0
    return-object v0
.end method

.method public getPlacementFor(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
    .locals 4

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    monitor-exit v1

    :goto_0
    return-object v0

    :cond_1
    monitor-exit v1

    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public getRawTimeline()Lcom/adobe/ave/Timeline;
    .locals 3

    :try_start_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineAdapter:Lcom/adobe/mediacore/VideoEngineAdapter;

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineAdapter;->getRawTimeline()Lcom/adobe/ave/Timeline;
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Unable to retrieve timeline."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    goto :goto_0
.end method

.method public place(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "You need to wait for previous place command to finish before issuing a new one. You can use AdBreakPlacementCompletedListener or AdBreakPlacementFailedListener for this."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    instance-of v0, p1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_2

    check-cast p1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_processingAdBreakPlacement:Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_acceptedAds:Ljava/util/List;

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->processCustomMarkers()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->loadAds()V

    :cond_1
    return-void

    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Place operation must receive only AdBreakPlacementOperation as a parameter."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method protected placeContentMarker(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;IJ)Z
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    if-nez v0, :cond_0

    new-instance v0, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    iget-object v1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    iget v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mainContentId:I

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;-><init>(Lcom/adobe/mediacore/VideoEngineDispatcher;I)V

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    invoke-virtual {v0, p1, p2, p3, p4}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->addMarker(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;IJ)V

    const/4 v0, 0x1

    return v0
.end method

.method public remove(Lcom/adobe/mediacore/timeline/TimelineOperation;)V
    .locals 4

    instance-of v0, p1, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "In order to execute remove videoEngineTimeline must receive a  AdBreakRemoval as a TimelineOperation."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    move-object v0, p1

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakRemoval;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getReplaceDuration()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeByLocalTime(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    :goto_0
    return-void

    :cond_1
    invoke-direct {p0, p1}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeByVirtualTime(Lcom/adobe/mediacore/timeline/TimelineOperation;)V

    goto :goto_0
.end method

.method public removeAdsOnSourceTimeline()V
    .locals 14

    const/4 v9, -0x1

    const-wide/16 v4, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->generateInsertedAds()V

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#removeAdsOnSourceTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Remove ads after entering trickplay mode"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    move v1, v0

    move-wide v2, v4

    move-wide v6, v4

    move v8, v9

    :goto_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;

    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getIndex()I

    move-result v10

    if-eq v8, v10, :cond_2

    if-eq v8, v9, :cond_0

    sget-object v8, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v11, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "#removeAdsOnSourceTimeline"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Remove ad: [virtual begin, virtual end] = ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ", "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    add-long v12, v6, v2

    invoke-static {v12, v13}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "]."

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v8, v10, v11}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    add-long v10, v6, v2

    invoke-direct {p0, v6, v7, v10, v11}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeContentByVirtualTime(JJ)Z

    move-result v8

    if-nez v8, :cond_0

    sget-object v8, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v11, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    const-string v11, "#removeAdsOnSourceTimeline"

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Could not remove the content. From="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, " duration="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v8, v10, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getIndex()I

    move-result v8

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/VideoEngineTimeline;->getVirtualTimeFor(Lcom/adobe/mediacore/timeline/advertising/Ad;)Ljava/lang/Long;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getAdHandle()Lcom/adobe/mediacore/AdHandle;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdHandle;->getDuration()J

    move-result-wide v2

    :cond_1
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    :cond_2
    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getAdHandle()Lcom/adobe/mediacore/AdHandle;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/AdHandle;->getDuration()J

    move-result-wide v10

    add-long/2addr v2, v10

    goto :goto_1

    :cond_3
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4

    cmp-long v0, v2, v4

    if-eqz v0, :cond_4

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#removeAdsOnSourceTimeline"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Remove ad: [virtual begin, virtual end] = ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    add-long v8, v6, v2

    invoke-static {v8, v9}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]."

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v0, v1, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    add-long v0, v6, v2

    invoke-direct {p0, v6, v7, v0, v1}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeContentByVirtualTime(JJ)Z

    move-result v0

    if-nez v0, :cond_4

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#removeAdsOnSourceTimeline"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Could not remove the content. From="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v6, v7}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " duration="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2, v3}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    return-void
.end method

.method public restoreAdsOnSourceTimeline()V
    .locals 7

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#restoreAdsOnSourceTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Restore ads after exiting trickplay"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    move v6, v0

    :goto_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v6, v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v1

    if-eqz v1, :cond_0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#restoreAdsOnSourceTimeline"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Attemp to restore ad on the timeline: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/Ad;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getTimeMapping()Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    move-result-object v1

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getAdHandle()Lcom/adobe/mediacore/AdHandle;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/AdHandle;->getHandle()I

    move-result v2

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/VideoEngineTimeline$InsertedAd;->getReplaceDuration()J

    move-result-wide v4

    move-object v0, p0

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/VideoEngineTimeline;->placeContent(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;IIJ)I

    move-result v0

    const/4 v1, -0x1

    if-ne v0, v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#restoreAdsOnSourceTimeline"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Failed to restore ad on the timeline"

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    :cond_0
    add-int/lit8 v0, v6, 0x1

    move v6, v0

    goto/16 :goto_0

    :cond_1
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_insertedAds:Ljava/util/List;

    return-void
.end method

.method public setInitialTimeMapping(Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_initialTimeMapping:Lcom/adobe/mediacore/VideoEngineTimeline$TimeMapping;

    return-void
.end method

.method public setMediaPlayerClient(Lcom/adobe/mediacore/MediaPlayerClient;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_mediaPlayerClient:Lcom/adobe/mediacore/MediaPlayerClient;

    return-void
.end method

.method public shouldTriggerSubscribedTagEvent(J)Z
    .locals 9

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    if-eqz v0, :cond_2

    invoke-direct {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->isLive()Z

    move-result v1

    invoke-virtual {p0}, Lcom/adobe/mediacore/VideoEngineTimeline;->getAdSignalingMode()Lcom/adobe/mediacore/metadata/AdSignalingMode;

    move-result-object v2

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-nez v1, :cond_1

    sget-object v4, Lcom/adobe/mediacore/metadata/AdSignalingMode;->MANIFEST_CUES:Lcom/adobe/mediacore/metadata/AdSignalingMode;

    if-ne v2, v4, :cond_0

    :cond_1
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v4

    cmp-long v4, v4, p1

    if-gtz v4, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getDuration()J

    move-result-wide v6

    add-long/2addr v4, v6

    cmp-long v4, p1, v4

    if-gez v4, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getRestoreId()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_0

    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#shouldTriggerSubscribedTagEvent"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Local time: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1, p2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " ; inside moved ad break: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " with placementinfo: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v1, v2, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    const/4 v0, 0x0

    :goto_0
    return v0

    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public update(J)V
    .locals 9

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#update"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Syncing AdTimeline with AVE timeline."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v2, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    monitor-enter v2

    :try_start_0
    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/VideoEngineTimeline;->removeOldAdBreaks(J)Z

    move-result v1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v4

    if-nez v4, :cond_1

    :cond_0
    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#update"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Unable to retrieve valid Ad Break."

    invoke-interface {v0, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    :try_start_1
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getFirstAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v5

    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getLastAd()Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v5

    if-eqz v4, :cond_2

    if-nez v5, :cond_3

    :cond_2
    sget-object v4, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#update"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Unable to retrieve valid Ad from Ad Break: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v5, v0}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :cond_3
    if-nez v1, :cond_4

    :try_start_2
    invoke-direct {p0, v0, v4}, Lcom/adobe/mediacore/VideoEngineTimeline;->adjusAdBreakPlacementPosition(Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;Lcom/adobe/mediacore/timeline/advertising/Ad;)Z

    move-result v1

    if-eqz v1, :cond_6

    :cond_4
    const/4 v1, 0x1

    :goto_1
    invoke-virtual {v5}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getId()I

    move-result v4

    invoke-direct {p0, v4}, Lcom/adobe/mediacore/VideoEngineTimeline;->getPeriod(I)Lcom/adobe/mediacore/VideoEngineTimeline$Period;

    move-result-object v5

    if-nez v5, :cond_5

    iget-object v5, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreaksPlacementToRemove:Ljava/util/Map;

    invoke-interface {v5, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_5

    sget-object v5, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#update"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Marking ad break for removal, from the ad timeline, after a delay period. Last commercial ID ["

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, "] is no longer found in the AVE timeline. ["

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v7, "]."

    invoke-virtual {v4, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v5, v6, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v4, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreaksPlacementToRemove:Ljava/util/Map;

    invoke-static {p1, p2}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-interface {v4, v0, v5}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_2
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :cond_5
    move v0, v1

    :goto_2
    move v1, v0

    goto/16 :goto_0

    :cond_6
    const/4 v1, 0x0

    goto :goto_1

    :catch_0
    move-exception v0

    move v0, v1

    :try_start_3
    sget-object v1, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#update"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "Unable to retrieve period information from the AVE timeline."

    invoke-interface {v1, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :cond_7
    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    if-eqz v1, :cond_8

    sget-object v0, Lcom/adobe/mediacore/VideoEngineTimeline;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/VideoEngineTimeline;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#update"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Ad timeline has updated."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->TIMELINE_UPDATED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_8
    return-void
.end method

.method public updateTimelineMarkers(J)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    if-nez v0, :cond_0

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_contentMarkerCache:Lcom/adobe/mediacore/VideoEngineContentMarkerCache;

    invoke-virtual {v0, p1, p2}, Lcom/adobe/mediacore/VideoEngineContentMarkerCache;->dispatchEvents(J)V

    goto :goto_0
.end method

.method public willAccept(Lcom/adobe/mediacore/timeline/TimelineOperation;)Z
    .locals 12

    const/4 v2, 0x0

    const/4 v1, 0x1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The timelineOperation parameter passed in must be not null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    instance-of v0, p1, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    if-nez v0, :cond_1

    move v0, v1

    :goto_0
    return v0

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_2

    move v0, v1

    goto :goto_0

    :cond_2
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v4

    iget-object v0, p0, Lcom/adobe/mediacore/VideoEngineTimeline;->_adBreakPlacements:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v8

    invoke-virtual {v8}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getReplaceDuration()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v8, v8, v10

    if-nez v8, :cond_4

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/TimelineOperation;->getPlacement()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getTime()J

    move-result-wide v8

    cmp-long v0, v8, v4

    if-nez v0, :cond_3

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-eq v6, v0, :cond_3

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-eq v6, v0, :cond_3

    move v0, v2

    goto :goto_0

    :cond_4
    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getReplaceDuration()J

    move-result-wide v8

    add-long/2addr v8, v6

    cmp-long v0, v6, v4

    if-gtz v0, :cond_3

    cmp-long v0, v4, v8

    if-gez v0, :cond_3

    move v0, v2

    goto :goto_0

    :cond_5
    move v0, v1

    goto :goto_0
.end method
