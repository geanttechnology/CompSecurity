.class final Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/adobe/mediacore/PlacementOpportunityDetector;


# static fields
.field private static final LOG_TAG:Ljava/lang/String;

.field private static final OPPORTUNITY_DURATION_KEY:Ljava/lang/String; = "DURATION"

.field private static final OPPORTUNITY_ELAPSED_TIME_KEY:[Ljava/lang/String;

.field private static final OPPORTUNITY_ID_KEY:Ljava/lang/String; = "ID"

.field private static final OPPORTUNITY_TYPE_KEY:Ljava/lang/String; = "TYPE"

.field private static final OPPORTUNITY_TYPE_VALUE:Ljava/lang/String; = "SpliceOut"


# instance fields
.field private _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    const/4 v0, 0x2

    new-array v0, v0, [Ljava/lang/String;

    const/4 v1, 0x0

    const-string v2, "ELAPSEDTIME"

    aput-object v2, v0, v1

    const/4 v1, 0x1

    const-string v2, "ELAPSED"

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->OPPORTUNITY_ELAPSED_TIME_KEY:[Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/MediaPlayerItem;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    iput-object p1, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    return-void
.end method

.method private createOpportunity(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;
    .locals 12

    const/4 v6, 0x0

    const-wide/16 v0, 0x0

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v2

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v7

    sget-object v5, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->OPPORTUNITY_ELAPSED_TIME_KEY:[Ljava/lang/String;

    array-length v8, v5

    const/4 v4, 0x0

    :goto_0
    if-ge v4, v8, :cond_1

    aget-object v9, v5, v4

    invoke-interface {v7, v9}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v10

    if-eqz v10, :cond_0

    invoke-interface {v7, v9}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    const-wide/16 v10, 0x1

    invoke-static {v9, v10, v11}, Lcom/adobe/mediacore/utils/NumberUtils;->parseNumber(Ljava/lang/String;J)J

    move-result-wide v10

    cmp-long v9, v10, v0

    if-eqz v9, :cond_0

    move-object v0, v6

    :goto_1
    return-object v0

    :cond_0
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    :cond_1
    const-string v4, "DURATION"

    invoke-interface {v7, v4}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    const-string v4, "DURATION"

    invoke-interface {v7, v4}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4, v0, v1}, Lcom/adobe/mediacore/utils/NumberUtils;->parseNumber(Ljava/lang/String;J)J

    move-result-wide v4

    const-wide/16 v8, 0x3e8

    mul-long/2addr v4, v8

    :goto_2
    const-string v8, "ID"

    invoke-interface {v7, v8}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_4

    const-string v8, "ID"

    invoke-interface {v7, v8}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    :goto_3
    if-eqz v7, :cond_2

    cmp-long v0, v4, v0

    if-gtz v0, :cond_3

    :cond_2
    move-object v0, v6

    goto :goto_1

    :cond_3
    new-instance v6, Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    invoke-direct/range {v0 .. v5}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;JJ)V

    invoke-direct {v6, v7, v0, p2}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;-><init>(Ljava/lang/String;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;Lcom/adobe/mediacore/metadata/Metadata;)V

    move-object v0, v6

    goto :goto_1

    :cond_4
    move-object v7, v6

    goto :goto_3

    :cond_5
    move-wide v4, v0

    goto :goto_2
.end method

.method private isCueTagSupported(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/MediaPlayerItem;)Z
    .locals 2

    if-eqz p2, :cond_0

    invoke-interface {p2}, Lcom/adobe/mediacore/MediaPlayerItem;->getAdTags()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-interface {p2}, Lcom/adobe/mediacore/MediaPlayerItem;->getAdTags()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private isOpportunity(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z
    .locals 2

    invoke-virtual {p1}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    if-eqz v0, :cond_0

    const-string v1, "TYPE"

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-string v1, "TYPE"

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "SpliceOut"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public process(Ljava/util/List;Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/metadata/TimedMetadata;",
            ">;",
            "Lcom/adobe/mediacore/metadata/Metadata;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/PlacementOpportunity;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "#process"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Processing ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] timed metadata, in order to provide placement opportunities."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/TimedMetadata;

    iget-object v3, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_mediaPlayerItem:Lcom/adobe/mediacore/MediaPlayerItem;

    invoke-direct {p0, v0, v3}, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->isCueTagSupported(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/MediaPlayerItem;)Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->isOpportunity(Lcom/adobe/mediacore/metadata/TimedMetadata;)Z

    move-result v3

    if-eqz v3, :cond_1

    iget-object v3, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#process"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Processing "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v4, v5}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-direct {p0, v0, p2}, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->createOpportunity(Lcom/adobe/mediacore/metadata/TimedMetadata;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/PlacementOpportunity;

    move-result-object v3

    if-eqz v3, :cond_0

    iget-object v4, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "#process"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Ad placement placementOpportunity created for timed metadata ID ["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getId()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "] .["

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "  placementOpportunity time="

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ", placementOpportunity duration="

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v6

    invoke-virtual {v6}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getDuration()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, "]."

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v4, v5, v0}, Lcom/adobe/mediacore/logging/Logger;->i(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v1, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :cond_0
    iget-object v3, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#process"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Ad placement placementOpportunity creation has failed. Probably has invalid metadata. placementOpportunity time = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", metadata: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "]."

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v4, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_1
    iget-object v3, p0, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/SpliceOutPlacementOpportunityDetector;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "#process"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Ad placement placementOpportunity creation has failed. Probably has invalid metadata. placementOpportunity time = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getTime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ", metadata: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/TimedMetadata;->getMetadata()Lcom/adobe/mediacore/metadata/Metadata;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, "]."

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v4, v0}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_2
    return-object v1
.end method
