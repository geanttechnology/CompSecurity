.class public Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;
.super Lcom/adobe/mediacore/timeline/advertising/ContentResolver;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final _logger:Lcom/adobe/mediacore/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[DeleteContentResolver]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method private createPlacementInformation(Lcom/adobe/mediacore/utils/TimeRange;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
    .locals 8

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->CUSTOM_TIME_RANGES:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->DELETE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    invoke-virtual {p1}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    invoke-virtual {p1}, Lcom/adobe/mediacore/utils/TimeRange;->getDuration()J

    move-result-wide v6

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    return-object v1
.end method

.method private createTimelineOperations(Ljava/util/List;)Ljava/util/List;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/ReplacementTimeRange;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    move-object v0, v1

    :goto_0
    return-object v0

    :cond_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    new-instance v3, Lcom/adobe/mediacore/timeline/advertising/ContentRemoval;

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->createPlacementInformation(Lcom/adobe/mediacore/utils/TimeRange;)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-direct {v3, v0}, Lcom/adobe/mediacore/timeline/advertising/ContentRemoval;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method private handleInvalidMetadata(Ljava/lang/Exception;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->LOG_TAG:Ljava/lang/String;

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

    const-string v1, "Invalid custom time range metadata."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "DESCRIPTION"

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method private processDeleteRanges(Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;)V
    .locals 1

    :try_start_0
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->extractCustomTimeRangeMetadata()Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->extractCustomTimeRanges(Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->mergeRanges(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->createTimelineOperations(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->notifyResolveComplete(Ljava/util/List;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :goto_0
    return-void

    :catch_0
    move-exception v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->handleInvalidMetadata(Ljava/lang/Exception;)V

    goto :goto_0
.end method


# virtual methods
.method protected doCanResolve(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z
    .locals 2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getMode()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->DELETE:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected doProvideAdTracker()Lcom/adobe/mediacore/timeline/advertising/ContentTracker;
    .locals 1

    const/4 v0, 0x0

    return-object v0
.end method

.method protected doResolveAds(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/PlacementOpportunity;)V
    .locals 1

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;

    invoke-direct {v0, p1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;-><init>(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-direct {p0, p2, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/DeleteContentResolver;->processDeleteRanges(Lcom/adobe/mediacore/timeline/PlacementOpportunity;Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;)V

    return-void
.end method
