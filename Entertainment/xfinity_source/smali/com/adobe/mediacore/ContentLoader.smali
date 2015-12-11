.class final Lcom/adobe/mediacore/ContentLoader;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/ContentLoader$1;,
        Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;,
        Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;,
        Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;
    }
.end annotation


# static fields
.field public static final FLV:Ljava/lang/String; = "FLV"

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final START_AD_LOADING_ID:I = 0x1


# instance fields
.field private final _contentCache:Lcom/adobe/mediacore/ContentCache;

.field private final _contentLoadCompleteListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;

.field private final _contentLoadFailedListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;

.field private _contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _nextAvailableId:I

.field private final _videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

.field private _videoEngineTimeline:Lcom/adobe/ave/Timeline;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/ContentLoader;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/ContentLoader;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/VideoEngineDispatcher;Lcom/adobe/mediacore/ContentCache;)V
    .locals 3

    const/4 v1, 0x0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/ContentLoader;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;

    const/4 v0, 0x1

    iput v0, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    new-instance v0, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    invoke-direct {v0, p0, v1}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;-><init>(Lcom/adobe/mediacore/ContentLoader;Lcom/adobe/mediacore/ContentLoader$1;)V

    iput-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    iput-object p1, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v0, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;

    invoke-direct {v0, p0, v1}, Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;-><init>(Lcom/adobe/mediacore/ContentLoader;Lcom/adobe/mediacore/ContentLoader$1;)V

    iput-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoadCompleteListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;

    new-instance v0, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;

    invoke-direct {v0, p0, v1}, Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;-><init>(Lcom/adobe/mediacore/ContentLoader;Lcom/adobe/mediacore/ContentLoader$1;)V

    iput-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoadFailedListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoadCompleteListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoadFailedListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->addEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iput-object p2, p0, Lcom/adobe/mediacore/ContentLoader;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    return-void
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    return-object v0
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/ContentCache;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    return-object v0
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/ContentLoader;)Lcom/adobe/mediacore/VideoEngineDispatcher;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    return-object v0
.end method

.method private convertType(Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/ave/ContainerType;
    .locals 2

    sget-object v0, Lcom/adobe/ave/ContainerType;->UNDEFINED:Lcom/adobe/ave/ContainerType;

    sget-object v1, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-virtual {p1, v1}, Lcom/adobe/mediacore/MediaResource$Type;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lcom/adobe/ave/ContainerType;->HLS:Lcom/adobe/ave/ContainerType;

    :cond_0
    return-object v0
.end method

.method private createContentLoaderMonitorForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;I)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;
    .locals 3

    new-instance v1, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    const/4 v0, 0x0

    invoke-direct {v1, p0, v0}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;-><init>(Lcom/adobe/mediacore/ContentLoader;Lcom/adobe/mediacore/ContentLoader$1;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v1, p2, v0}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->addPendingContent(ILcom/adobe/mediacore/timeline/advertising/Ad;)V

    add-int/lit8 p2, p2, 0x1

    goto :goto_0

    :cond_0
    return-object v1
.end method


# virtual methods
.method public loadContent(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)V
    .locals 7

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineTimeline:Lcom/adobe/ave/Timeline;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "No timeline was set for loading manifests."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    iget v0, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    invoke-direct {p0, p1, v0}, Lcom/adobe/mediacore/ContentLoader;->createContentLoaderMonitorForAdBreak(Lcom/adobe/mediacore/timeline/advertising/AdBreak;I)Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->adsIterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/Ad;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/MediaResource;->getUrl()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/adobe/mediacore/ContentLoader;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    invoke-interface {v3, v2}, Lcom/adobe/mediacore/ContentCache;->isCached(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/ContentLoader;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#loadContent"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Retrieving from cache content "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget v5, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, " location = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v3, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    iget v2, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->markContentResolved(I)V

    :goto_1
    iget v0, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    goto :goto_0

    :cond_1
    :try_start_0
    iget-object v3, p0, Lcom/adobe/mediacore/ContentLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/ContentLoader;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#loadContent"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Starting the loading of manifest for content = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget v6, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, " location = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v3, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineTimeline:Lcom/adobe/ave/Timeline;

    iget v4, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/Ad;->getPrimaryAsset()Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;->getMediaResource()Lcom/adobe/mediacore/MediaResource;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/MediaResource;->getType()Lcom/adobe/mediacore/MediaResource$Type;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/ContentLoader;->convertType(Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/ave/ContainerType;

    move-result-object v0

    invoke-virtual {v3, v2, v4, v0}, Lcom/adobe/ave/Timeline;->loadManifest(Ljava/lang/String;ILcom/adobe/ave/ContainerType;)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    :catch_0
    move-exception v0

    iget-object v3, p0, Lcom/adobe/mediacore/ContentLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/ContentLoader;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#loadContent"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Received exception { code = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", description = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "} while loading content { id = "

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v5, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ", location = "

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v4, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    iget v2, p0, Lcom/adobe/mediacore/ContentLoader;->_nextAvailableId:I

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->markContentResolved(I)V

    goto/16 :goto_1

    :cond_2
    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoaderMonitor:Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;

    invoke-virtual {v0}, Lcom/adobe/mediacore/ContentLoader$ContentLoaderMonitor;->hasFinishedLoading()Z

    move-result v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    new-instance v1, Lcom/adobe/mediacore/MediaPlayerEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_BREAK_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    invoke-direct {v1, v2}, Lcom/adobe/mediacore/MediaPlayerEvent;-><init>(Lcom/adobe/mediacore/MediaPlayerEvent$Type;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/VideoEngineDispatcher;->dispatch(Lcom/adobe/mediacore/MediaPlayerEvent;)V

    :cond_3
    return-void
.end method

.method public releaseHandles()V
    .locals 8

    invoke-virtual {p0}, Lcom/adobe/mediacore/ContentLoader;->removeListeners()V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineTimeline:Lcom/adobe/ave/Timeline;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    invoke-interface {v0}, Lcom/adobe/mediacore/ContentCache;->getCachedUrls()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iget-object v1, p0, Lcom/adobe/mediacore/ContentLoader;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    invoke-interface {v1, v0}, Lcom/adobe/mediacore/ContentCache;->getHandle(Ljava/lang/String;)Lcom/adobe/mediacore/AdHandle;

    move-result-object v3

    :try_start_0
    iget-object v1, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineTimeline:Lcom/adobe/ave/Timeline;

    invoke-virtual {v3}, Lcom/adobe/mediacore/AdHandle;->getHandle()I

    move-result v4

    invoke-virtual {v1, v4}, Lcom/adobe/ave/Timeline;->releaseManifest(I)V
    :try_end_0
    .catch Lcom/adobe/ave/VideoEngineException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    :catch_0
    move-exception v1

    iget-object v4, p0, Lcom/adobe/mediacore/ContentLoader;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/ContentLoader;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#loadContent"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Received exception { code = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngineException;->getErrorCode()Lcom/adobe/ave/MediaErrorCode;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ", description = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/adobe/ave/VideoEngineException;->getDetailMessage()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v6, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v6, "} while releasing content { handle = "

    invoke-virtual {v1, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v3}, Lcom/adobe/mediacore/AdHandle;->getHandle()I

    move-result v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, ", location = "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v5, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_contentCache:Lcom/adobe/mediacore/ContentCache;

    invoke-interface {v0}, Lcom/adobe/mediacore/ContentCache;->clearCache()V

    :cond_1
    return-void
.end method

.method public removeListeners()V
    .locals 3

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoadCompleteListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadCompleteListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    iget-object v0, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineDispatcher:Lcom/adobe/mediacore/VideoEngineDispatcher;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerEvent$Type;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerEvent$Type;

    iget-object v2, p0, Lcom/adobe/mediacore/ContentLoader;->_contentLoadFailedListener:Lcom/adobe/mediacore/ContentLoader$ContentLoadFailedListener;

    invoke-virtual {v0, v1, v2}, Lcom/adobe/mediacore/VideoEngineDispatcher;->removeEventListener(Lcom/adobe/mediacore/MediaPlayerEvent$Type;Lcom/adobe/mediacore/MediaPlayer$EventListener;)V

    return-void
.end method

.method public setVideoEngineTimeline(Lcom/adobe/ave/Timeline;)V
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/ContentLoader;->_videoEngineTimeline:Lcom/adobe/ave/Timeline;

    return-void
.end method
