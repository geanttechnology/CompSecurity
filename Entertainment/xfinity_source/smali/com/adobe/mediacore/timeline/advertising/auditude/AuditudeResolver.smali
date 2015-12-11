.class public Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;
.super Lcom/adobe/mediacore/timeline/advertising/ContentResolver;

# interfaces
.implements Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;


# static fields
.field private static final AUDITUDE_TIME_SCALE:I = 0x3e8

.field private static final MINIMUM_AD_DURATION:I = 0x5

.field private static final MINIMUM_AD_LOTS:I = 0x1

.field private static final MIN_INIT_REQUEST_INTERVAL:I = 0x4b0

.field private static final POST_ROLL_DEFAULT_TIME:I = 0x989680

.field private static final PRE_ROLL_DEFAULT_TIME:I


# instance fields
.field private final EMPTY_AD_ID:I

.field private final LOG_TAG:Ljava/lang/String;

.field private final REPACKAGING_MIME_TYPE:Ljava/lang/String;

.field private _auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

.field private _auditudeTracker:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

.field private _requestQueue:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;",
            ">;"
        }
    .end annotation
.end field

.field private _resolverContext:Landroid/content/Context;

.field private auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

.field private creativeRepackagingEnabled:Z

.field private handler:Landroid/os/Handler;

.field private lastRequestTime:J

.field private loadingGroupCount:I

.field private final pluginEventListener:Lcom/auditude/ads/event/AuditudePluginEventListener;

.field private userAgent:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[AuditudeAd]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    iput v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->EMPTY_AD_ID:I

    const-string v0, "application/x-mpegURL"

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->REPACKAGING_MIME_TYPE:Ljava/lang/String;

    iput-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    iput-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    iput-boolean v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->creativeRepackagingEnabled:Z

    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->userAgent:Ljava/lang/String;

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->handler:Landroid/os/Handler;

    iput v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadingGroupCount:I

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;-><init>(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->pluginEventListener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->initializeAdUnit()V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 4

    const/4 v3, 0x0

    const/4 v2, 0x0

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;-><init>()V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[AuditudeAd]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    iput v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->EMPTY_AD_ID:I

    const-string v0, "application/x-mpegURL"

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->REPACKAGING_MIME_TYPE:Ljava/lang/String;

    iput-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    iput-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    iput-boolean v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->creativeRepackagingEnabled:Z

    const-string v0, ""

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->userAgent:Ljava/lang/String;

    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->handler:Landroid/os/Handler;

    iput v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadingGroupCount:I

    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;

    invoke-direct {v0, p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$1;-><init>(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->pluginEventListener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_resolverContext:Landroid/content/Context;

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->initializeAdUnit()V

    return-void
.end method

.method static synthetic access$000(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/auditude/ads/event/AdPluginEvent;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadAdBreaks(Lcom/auditude/ads/event/AdPluginEvent;)V

    return-void
.end method

.method static synthetic access$100(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)V
    .locals 0

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->startConsumer()V

    return-void
.end method

.method static synthetic access$200(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/logging/Logger;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-object v0
.end method

.method static synthetic access$400(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method static synthetic access$500(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Ljava/util/LinkedList;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;

    return-object v0
.end method

.method static synthetic access$600(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    return-object v0
.end method

.method static synthetic access$602(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;)Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;
    .locals 0

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    return-object p1
.end method

.method static synthetic access$700(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;Ljava/util/List;)V
    .locals 0

    invoke-direct {p0, p1, p2, p3, p4}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->issueAdResolvingRequest(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;Ljava/util/List;)V

    return-void
.end method

.method static synthetic access$800(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V
    .locals 0

    invoke-virtual {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method private createAdAsset(Ljava/lang/String;Ljava/lang/String;JLcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    .locals 7

    invoke-static {p1, p5}, Lcom/adobe/mediacore/MediaResource;->createFromUrl(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v4

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    invoke-direct {p0, p2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractId(Ljava/lang/String;)I

    move-result v1

    move-wide v2, p3

    move-object v5, p6

    move-object v6, p5

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;-><init>(IJLcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/timeline/advertising/AdClick;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-object v0
.end method

.method private createPlacementInformation(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
    .locals 8

    const-wide/16 v4, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    :cond_0
    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v2

    cmp-long v0, v2, v4

    if-nez v0, :cond_2

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    :cond_1
    :goto_0
    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v2

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    :goto_1
    return-object v0

    :cond_2
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getTime()J

    move-result-wide v2

    const-wide/32 v6, 0x989680

    cmp-long v0, v2, v6

    if-nez v0, :cond_1

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    goto :goto_0

    :cond_3
    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v2

    iget-object v4, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v4

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v4

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    goto :goto_1
.end method

.method private execResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 4

    iput-object p2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    instance-of v0, p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-nez v0, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "The provided metadata is not valid for Auditude resolver"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    move-object v0, p1

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractAuditudeSettings(Lcom/adobe/mediacore/metadata/MetadataNode;)Lcom/adobe/mediacore/metadata/AuditudeSettings;

    move-result-object v0

    check-cast p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_PARAMETERS:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;

    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    invoke-direct {v3, v0, p2, v1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;-><init>(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {v2, v3}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method private extractAdAsset(Lcom/auditude/ads/model/Asset;Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    .locals 8

    const/4 v1, 0x0

    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getMediaFiles()Ljava/util/ArrayList;

    move-result-object v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#extractAdAsset"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Received invalid response from Auditude. Asset has no media files associated with it"

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/media/MediaFile;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->isMediaFileSupported(Lcom/auditude/ads/model/media/MediaFile;)Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v2, v0, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    iget-object v3, v0, Lcom/auditude/ads/model/media/MediaFile;->id:Ljava/lang/String;

    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getDurationInMillis()I

    move-result v0

    int-to-long v4, v0

    move-object v1, p0

    move-object v6, p2

    move-object v7, p3

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->createAdAsset(Ljava/lang/String;Ljava/lang/String;JLcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    goto :goto_0

    :cond_2
    move-object v0, v1

    goto :goto_0
.end method

.method private extractAdBreakPlacements()Ljava/util/List;
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    invoke-virtual {v0}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->getAdResponse()Lcom/auditude/ads/response/AdResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/response/AdResponse;->getBreaks()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :goto_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Group;

    new-instance v10, Ljava/util/ArrayList;

    invoke-direct {v10}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getRefs()Ljava/util/ArrayList;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v11

    :cond_0
    :goto_1
    invoke-interface {v11}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-interface {v11}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    move-object v4, v1

    check-cast v4, Lcom/auditude/ads/model/smil/Ref;

    if-eqz v4, :cond_0

    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Ref;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v1

    if-eqz v1, :cond_0

    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v1

    if-eqz v1, :cond_0

    new-instance v1, Lcom/adobe/mediacore/metadata/AuditudeSettings;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;-><init>()V

    invoke-virtual {v1, v4}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->setData(Ljava/lang/Object;)V

    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Ref;->getPrimaryAsset()Lcom/auditude/ads/model/Asset;

    move-result-object v2

    invoke-direct {p0, v2, v1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractPrimaryAdAsset(Lcom/auditude/ads/model/Asset;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v5

    if-eqz v5, :cond_1

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    sget-object v1, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-virtual {v2}, Lcom/auditude/ads/model/Asset;->getDurationInMillis()I

    move-result v2

    int-to-long v2, v2

    invoke-virtual {v4}, Lcom/auditude/ads/model/smil/Ref;->getAd()Lcom/auditude/ads/model/Ad;

    move-result-object v4

    invoke-virtual {v4}, Lcom/auditude/ads/model/Ad;->getID()Ljava/lang/String;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractId(Ljava/lang/String;)I

    move-result v4

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->getAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;

    move-result-object v7

    invoke-static/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/Ad;->createAd(Lcom/adobe/mediacore/MediaResource$Type;JILcom/adobe/mediacore/timeline/advertising/AdAsset;Ljava/util/List;Lcom/adobe/mediacore/timeline/advertising/ContentTracker;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v1

    invoke-interface {v10, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_1
    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#extractAdBreaks"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Ad will be skipped. Auditude response contains a primary asset that is not supported"

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    :cond_2
    invoke-interface {v10}, Ljava/util/List;->size()I

    move-result v1

    if-lez v1, :cond_3

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getStartTime()I

    move-result v1

    int-to-long v2, v1

    const-wide/16 v4, 0x0

    invoke-virtual {v0}, Lcom/auditude/ads/model/smil/Group;->getIndex()I

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v6

    move-object v1, v10

    invoke-static/range {v1 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->createPlacementInformation(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    new-instance v2, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v2, v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :cond_3
    new-instance v0, Lcom/adobe/mediacore/timeline/NopTimelineOperation;

    invoke-direct {v0}, Lcom/adobe/mediacore/timeline/NopTimelineOperation;-><init>()V

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :cond_4
    return-object v8
.end method

.method private extractAdClick(Lcom/auditude/ads/model/Asset;)Lcom/adobe/mediacore/timeline/advertising/AdClick;
    .locals 4

    invoke-virtual {p1}, Lcom/auditude/ads/model/Asset;->getClick()Lcom/auditude/ads/model/IClick;

    move-result-object v1

    if-nez v1, :cond_0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdClick;

    const-string v1, ""

    const-string v2, ""

    const-string v3, ""

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/timeline/advertising/AdClick;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdClick;

    invoke-interface {v1}, Lcom/auditude/ads/model/IClick;->getID()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1}, Lcom/auditude/ads/model/IClick;->getTitle()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1}, Lcom/auditude/ads/model/IClick;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v2, v3, v1}, Lcom/adobe/mediacore/timeline/advertising/AdClick;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private extractAuditudeSettings(Lcom/adobe/mediacore/metadata/MetadataNode;)Lcom/adobe/mediacore/metadata/AuditudeSettings;
    .locals 2

    const/4 v0, 0x0

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    :cond_0
    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    :cond_1
    if-eqz v0, :cond_2

    instance-of v1, v0, Lcom/adobe/mediacore/metadata/AuditudeSettings;

    if-nez v1, :cond_3

    :cond_2
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "No AuditudeSettings metdata or compatible metadata have been found."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_3
    check-cast v0, Lcom/adobe/mediacore/metadata/AuditudeSettings;

    return-object v0
.end method

.method private extractId(Ljava/lang/String;)I
    .locals 4

    const/4 v0, 0x0

    if-eqz p1, :cond_0

    :try_start_0
    invoke-static {p1}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v0

    :cond_0
    :goto_0
    return v0

    :catch_0
    move-exception v1

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#extractId"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    const-string v3, "Number format exception when parsing id from auditude. Will use default values"

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private extractPrimaryAdAsset(Lcom/auditude/ads/model/Asset;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    .locals 1

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractAdClick(Lcom/auditude/ads/model/Asset;)Lcom/adobe/mediacore/timeline/advertising/AdClick;

    move-result-object v0

    invoke-direct {p0, p1, p2, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractAdAsset(Lcom/auditude/ads/model/Asset;Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/advertising/AdClick;)Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v0

    return-object v0
.end method

.method private getCustomParams(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Lcom/adobe/mediacore/metadata/Metadata;Ljava/util/List;)Ljava/util/HashMap;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/metadata/AuditudeSettings;",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            "Lcom/adobe/mediacore/metadata/Metadata;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            ">;)",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getTargetingParameters()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v2

    if-eqz v2, :cond_1

    invoke-interface {v2}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v2, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-static {v4}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    invoke-virtual {v1, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    :cond_1
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    const-string v0, "userData"

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    invoke-direct {p0, p4}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->getTimeLineString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    const-string v1, "auditudeTimeline"

    invoke-virtual {v2, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_2
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getCustomParameters()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v3

    if-eqz v3, :cond_4

    invoke-interface {v3}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :cond_3
    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {v3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_3

    if-eqz v5, :cond_3

    invoke-virtual {v1, v0, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    :cond_4
    if-eqz p3, :cond_6

    invoke-interface {p3}, Lcom/adobe/mediacore/metadata/Metadata;->keySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_5
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-interface {p3, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_5

    invoke-static {v4}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_5

    invoke-virtual {v1, v0, v4}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_2

    :cond_6
    const-string v0, "PSDK_AVAIL_DURATION"

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_7

    if-eqz p2, :cond_7

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v4

    const-wide/16 v6, -0x1

    cmp-long v0, v4, v6

    if-eqz v0, :cond_7

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    const-string v0, "PSDK_AVAIL_DURATION"

    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_7
    const-string v0, "auditudePassThroughParams"

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#getCustomParams"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Auditude custom params: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    return-object v2
.end method

.method private getMediaIds(Lcom/adobe/mediacore/metadata/AuditudeSettings;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/metadata/AuditudeSettings;",
            ")",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getMediaId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getDefaultMediaId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#getMediaIds()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Auditude asset ID parameter cannot be null or empty."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Auditude asset ID parameter cannot be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-static {v2}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_1
    return-object v0
.end method

.method private getTimeLineString(Ljava/util/List;)Ljava/lang/String;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    const/4 v1, 0x0

    const/4 v11, 0x1

    const/4 v9, 0x0

    if-eqz p1, :cond_7

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_7

    invoke-interface {p1, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->SERVER_MAP:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-ne v0, v2, :cond_1

    :cond_0
    :goto_0
    return-object v1

    :cond_1
    invoke-interface {p1, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-ne v0, v2, :cond_2

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-ne v0, v11, :cond_2

    invoke-interface {p1, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v2

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-eqz v0, :cond_0

    :cond_2
    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    move v8, v9

    :goto_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v8, v0, :cond_6

    if-lez v8, :cond_3

    const-string v0, "&tl="

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_3
    invoke-interface {p1, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-static {v0, v9}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->serializePlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Z)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-le v0, v11, :cond_4

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    add-int/lit8 v0, v0, -0x1

    if-ge v8, v0, :cond_5

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->INSERT:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    invoke-interface {p1, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v4

    add-int/lit8 v0, v8, 0x1

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v6

    invoke-interface {p1, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v12

    sub-long/2addr v6, v12

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    const-string v0, "&tl="

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {v1, v11}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->serializePlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_4
    :goto_2
    add-int/lit8 v0, v8, 0x1

    move v8, v0

    goto :goto_1

    :cond_5
    invoke-interface {p1, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-eq v0, v1, :cond_4

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->INSERT:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    invoke-interface {p1, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v4

    const-wide/32 v6, 0x989680

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    const-string v0, "&tl="

    invoke-virtual {v10, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {v1, v11}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->serializePlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Z)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_2

    :cond_6
    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_3
    move-object v1, v0

    goto/16 :goto_0

    :cond_7
    move-object v0, v1

    goto :goto_3
.end method

.method private handleInvalidMetadata(Ljava/lang/Exception;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#handleInvalidMetadata"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_METADATA_INVALID:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "Invalid ad metadata."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "DESCRIPTION"

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method private initializeAdUnit()V
    .locals 3

    new-instance v0, Lcom/auditude/ads/AuditudeAdUnitDelegate;

    invoke-direct {v0}, Lcom/auditude/ads/AuditudeAdUnitDelegate;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const-string v1, "repackageCreativeFormat"

    const-string v2, "application/x-mpegURL"

    invoke-virtual {v0, v1, v2}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const-string v1, "applicationContext"

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_resolverContext:Landroid/content/Context;

    invoke-virtual {v0, v1, v2}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->pluginEventListener:Lcom/auditude/ads/event/AuditudePluginEventListener;

    invoke-virtual {v0, v1}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setPluginEventListener(Lcom/auditude/ads/event/AuditudePluginEventListener;)V

    return-void
.end method

.method private isMediaFileSupported(Lcom/auditude/ads/model/media/MediaFile;)Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    if-eqz p1, :cond_0

    iget-object v2, p1, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    if-nez v2, :cond_2

    :cond_0
    move v0, v1

    :cond_1
    :goto_0
    return v0

    :cond_2
    iget-object v2, p1, Lcom/auditude/ads/model/media/MediaFile;->mimeType:Ljava/lang/String;

    sget-object v3, Lcom/adobe/mediacore/MediaResource$MimeType;->HLS_MIME_TYPE:Lcom/adobe/mediacore/MediaResource$MimeType;

    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaResource$MimeType;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    iget-object v2, p1, Lcom/auditude/ads/model/media/MediaFile;->source:Ljava/lang/String;

    invoke-static {v2}, Lcom/adobe/mediacore/utils/StringUtils;->getFileExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_3

    sget-object v3, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-virtual {v3}, Lcom/adobe/mediacore/MediaResource$Type;->getValue()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    :cond_3
    move v0, v1

    goto :goto_0
.end method

.method private issueAdResolvingRequest(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;Ljava/util/List;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/metadata/AuditudeSettings;",
            "Lcom/adobe/mediacore/timeline/PlacementOpportunity;",
            "Lcom/adobe/mediacore/metadata/Metadata;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->getMediaIds(Lcom/adobe/mediacore/metadata/AuditudeSettings;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getDomain()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#initAuditudeAdResolver()"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    const-string v2, "Auditude domain parameter cannot be null or empty."

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->e(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Auditude domain parameter cannot be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    :try_start_0
    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getZoneId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result v3

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->isCreativeRepackagingEnabled()Z

    move-result v0

    iput-boolean v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->creativeRepackagingEnabled:Z

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-direct {p0, p1, v0, p3, p4}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->getCustomParams(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Lcom/adobe/mediacore/metadata/Metadata;Ljava/util/List;)Ljava/util/HashMap;

    move-result-object v4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const-string v5, "repackageCreativeFormat"

    const-string v6, "application/x-mpegURL"

    invoke-virtual {v0, v5, v6}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const-string v5, "repackageCreativeEnabled"

    iget-boolean v6, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->creativeRepackagingEnabled:Z

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    const-string v5, "application/x-mpegURL"

    invoke-virtual {v0, v5}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    iget-object v5, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const-string v6, "validMimeTypes"

    invoke-virtual {v5, v6, v0}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const-string v5, "fallbackOnInvalidCreative"

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->isFallbackOnInvalidCreativeEnabled()Z

    move-result v6

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    invoke-virtual {v0, v5, v6}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/AuditudeSettings;->getUserAgent()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->userAgent:Ljava/lang/String;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->userAgent:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/utils/StringUtils;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const-string v5, "userAgent"

    iget-object v6, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->userAgent:Ljava/lang/String;

    invoke-virtual {v0, v5, v6}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->setProperty(Ljava/lang/String;Ljava/lang/Object;)V

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    const/16 v5, 0xa

    invoke-virtual/range {v0 .. v5}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->init(Ljava/lang/String;Ljava/lang/Object;ILjava/util/HashMap;I)V

    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string v2, "Auditude zoneId parameter must be a valid number."

    invoke-direct {v1, v2, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v1
.end method

.method private loadAdBreaks(Lcom/auditude/ads/event/AdPluginEvent;)V
    .locals 6

    const/4 v5, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    invoke-virtual {v0}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->getAdResponse()Lcom/auditude/ads/response/AdResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/auditude/ads/response/AdResponse;->getBreaks()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v0

    iput v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadingGroupCount:I

    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadingGroupCount:I

    if-lez v0, :cond_1

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v3, "#loadAdBreaks"

    invoke-virtual {v0, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Loading ad breaks. Creative repackaging is: "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-boolean v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->creativeRepackagingEnabled:Z

    if-eqz v0, :cond_0

    const-string v0, "enabled"

    :goto_0
    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "."

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/model/smil/Group;

    iget-boolean v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->creativeRepackagingEnabled:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, p0, v2, v5}, Lcom/auditude/ads/model/smil/Group;->load(Lcom/auditude/ads/model/smil/Group$PrefetchCompleteListener;Ljava/lang/Boolean;Ljava/util/HashMap;)V

    goto :goto_1

    :cond_0
    const-string v0, "disabled"

    goto :goto_0

    :cond_1
    invoke-virtual {p0, v5}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->onPrefetchComplete(Ljava/util/ArrayList;)V

    :cond_2
    return-void
.end method

.method private processReplacementRanges(Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;)V
    .locals 13

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    :try_start_0
    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v3

    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->extractCustomTimeRangeMetadata()Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->extractCustomTimeRanges(Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;

    move-result-object v2

    invoke-virtual {p2, v2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->mergeRanges(Ljava/util/List;)Ljava/util/List;

    move-result-object v11

    move-object v0, v3

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    move-object v2, v0

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractAuditudeSettings(Lcom/adobe/mediacore/metadata/MetadataNode;)Lcom/adobe/mediacore/metadata/AuditudeSettings;

    move-result-object v2

    check-cast v3, Lcom/adobe/mediacore/metadata/MetadataNode;

    sget-object v4, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_PARAMETERS:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v4}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v3

    new-instance v12, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    invoke-direct {v12, v2, p1, v3}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;-><init>(Lcom/adobe/mediacore/metadata/AuditudeSettings;Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/metadata/Metadata;)V

    const/4 v2, 0x0

    invoke-interface {v11, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-eqz v2, :cond_0

    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v5, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->REPLACE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    const-wide/16 v6, 0x0

    const-wide/16 v8, -0x1

    invoke-direct/range {v3 .. v9}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    invoke-virtual {v12, v3}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->addPlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    :cond_0
    const/4 v2, 0x0

    move v10, v2

    :goto_0
    invoke-interface {v11}, Ljava/util/List;->size()I

    move-result v2

    if-ge v10, v2, :cond_3

    invoke-interface {v11, v10}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-nez v3, :cond_1

    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    :goto_1
    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getReplacementDuration()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v3, v6, v8

    if-gez v3, :cond_2

    const-wide/16 v6, -0x1

    :goto_2
    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v8

    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v5, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->REPLACE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v6

    invoke-virtual {v8}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-direct/range {v3 .. v9}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    invoke-virtual {v12, v3}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->addPlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    add-int/lit8 v2, v10, 0x1

    move v10, v2

    goto :goto_0

    :cond_1
    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    goto :goto_1

    :cond_2
    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getReplacementDuration()J

    move-result-wide v6

    goto :goto_2

    :cond_3
    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;

    invoke-virtual {v2, v12}, Ljava/util/LinkedList;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_3
    return-void

    :catch_0
    move-exception v2

    invoke-direct {p0, v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->handleInvalidMetadata(Ljava/lang/Exception;)V

    goto :goto_3
.end method

.method private static serializePlacement(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Z)Ljava/lang/String;
    .locals 12

    const-wide/16 v8, 0x0

    const-wide/16 v2, 0x1

    const-wide/16 v6, -0x1

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v0

    cmp-long v0, v0, v6

    if-eqz v0, :cond_9

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v0

    const-wide/16 v4, 0x3e8

    div-long v4, v0, v4

    const-wide/16 v0, 0x5

    div-long v0, v4, v0

    :goto_0
    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v10

    cmp-long v10, v10, v8

    if-nez v10, :cond_2

    move-wide v2, v8

    :cond_0
    :goto_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    if-eqz p1, :cond_3

    const-string v0, "n"

    :goto_2
    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v8, ","

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    cmp-long v0, v4, v6

    if-nez v0, :cond_4

    const-string v0, "*"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v8, ","

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_3
    cmp-long v0, v4, v6

    if-nez v0, :cond_5

    const-string v0, "*"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :goto_4
    if-nez p1, :cond_1

    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-ne v0, v2, :cond_7

    const-string v0, "p"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_1
    :goto_5
    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0

    :cond_2
    cmp-long v8, v0, v2

    if-ltz v8, :cond_0

    move-wide v2, v0

    goto :goto_1

    :cond_3
    const-string v0, "l"

    goto :goto_2

    :cond_4
    invoke-static {v4, v5}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v8, ","

    invoke-virtual {v0, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_3

    :cond_5
    if-eqz p1, :cond_6

    const-string v0, "0"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4

    :cond_6
    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, ","

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_4

    :cond_7
    invoke-virtual {p0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->POST_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-ne v0, v2, :cond_8

    const-string v0, "t"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_5

    :cond_8
    const-string v0, "m"

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    goto :goto_5

    :cond_9
    move-wide v0, v2

    move-wide v4, v6

    goto/16 :goto_0
.end method

.method private startConsumer()V
    .locals 6

    const-wide/16 v4, 0x4b0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_requestQueue:Ljava/util/LinkedList;

    invoke-virtual {v0}, Ljava/util/LinkedList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    :goto_0
    return-void

    :cond_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->lastRequestTime:J

    sub-long v0, v2, v0

    cmp-long v0, v4, v0

    if-lez v0, :cond_1

    iget-wide v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->lastRequestTime:J

    sub-long v0, v2, v0

    sub-long v0, v4, v0

    :goto_1
    add-long/2addr v2, v0

    iput-wide v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->lastRequestTime:J

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->handler:Landroid/os/Handler;

    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;

    invoke-direct {v3, p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver$2;-><init>(Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;)V

    invoke-virtual {v2, v3, v0, v1}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    :cond_1
    const-wide/16 v0, 0x0

    goto :goto_1
.end method


# virtual methods
.method protected doCanResolve(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z
    .locals 3

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractAuditudeSettings(Lcom/adobe/mediacore/metadata/MetadataNode;)Lcom/adobe/mediacore/metadata/AuditudeSettings;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getMode()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->INSERT:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    if-eq v1, v2, :cond_0

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getMode()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->REPLACE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    if-ne v1, v2, :cond_1

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected doProvideAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;
    .locals 2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeTracker:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;

    if-nez v0, :cond_0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->auditudeAdResolver:Lcom/auditude/ads/AuditudeAdUnitDelegate;

    invoke-virtual {v1}, Lcom/auditude/ads/AuditudeAdUnitDelegate;->getReportingEngine()Lcom/auditude/ads/reporting/ReportingHelper;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;-><init>(Lcom/auditude/ads/reporting/ReportingHelper;)V

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeTracker:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;

    :cond_0
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeTracker:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeTracker;

    return-object v0
.end method

.method protected declared-synchronized doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 2

    monitor-enter p0

    :try_start_0
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;-><init>(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-direct {p0, p2, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->processReplacementRanges(Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;)V

    :goto_0
    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->startConsumer()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    invoke-direct {p0, p1, p2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->execResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onPrefetchComplete(Ljava/util/ArrayList;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/auditude/ads/event/AdPluginEvent;",
            ">;)V"
        }
    .end annotation

    const/4 v6, 0x0

    if-eqz p1, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/auditude/ads/event/AdPluginEvent;

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_RESOLVER_RETURNED_NO_ADS:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v3, "Ad Resolver Returned no ads"

    invoke-static {v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification;->createWarningNotification(Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Warning;

    move-result-object v2

    invoke-virtual {v0}, Lcom/auditude/ads/event/AdPluginEvent;->getData()Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_0

    new-instance v3, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v3}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v4, "AdId"

    const-string v5, "AdId"

    invoke-virtual {v0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v4, "InternalError"

    const-string v5, "InternalErrorId"

    invoke-virtual {v0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v4, "Description"

    const-string v5, "Description"

    invoke-virtual {v0, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v4, v0}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$Warning;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {p0, v2}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->notifyResolveWarning(Lcom/adobe/mediacore/MediaPlayerNotification$Warning;)V

    goto :goto_0

    :cond_1
    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadingGroupCount:I

    add-int/lit8 v0, v0, -0x1

    iput v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadingGroupCount:I

    iget v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->loadingGroupCount:I

    if-gtz v0, :cond_3

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->extractAdBreakPlacements()Ljava/util/List;

    move-result-object v1

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v2

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    if-eqz v2, :cond_2

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_auditudeRequest:Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeRequest;->getPlacementInformations()Ljava/util/List;

    move-result-object v2

    if-eqz v1, :cond_4

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4

    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    instance-of v0, v0, Lcom/adobe/mediacore/timeline/NopTimelineOperation;

    if-eqz v0, :cond_4

    move-object v0, v1

    :cond_2
    :goto_1
    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#createAdBreakFor"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Number of ad breaks returned : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->notifyResolveComplete(Ljava/util/List;)V

    :cond_3
    return-void

    :cond_4
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-eq v0, v3, :cond_5

    invoke-interface {v2, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getType()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    move-result-object v0

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    if-ne v0, v3, :cond_6

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v0

    const/4 v3, 0x1

    if-ne v0, v3, :cond_6

    invoke-interface {v2, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v2

    const-wide/16 v4, -0x1

    cmp-long v0, v2, v4

    if-nez v0, :cond_6

    :cond_5
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "#createAdBreakFor"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Input : "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v4}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v3}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v2, Ljava/util/ArrayList;

    invoke-direct {v2}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_7

    invoke-interface {v1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;->getAdBreak()Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_placementOpportunity:Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    invoke-virtual {v1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->cloneFor(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v0

    iget-object v1, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v4, p0, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "#createAdBreakFor"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Output : "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v3, v4}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/auditude/AuditudeResolver;->createPlacementInformation(Lcom/adobe/mediacore/timeline/advertising/AdBreak;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v1

    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v3, v0, v1}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-interface {v2, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object v0, v2

    goto/16 :goto_1

    :cond_6
    move-object v0, v1

    goto/16 :goto_1

    :cond_7
    move-object v0, v2

    goto/16 :goto_1
.end method
