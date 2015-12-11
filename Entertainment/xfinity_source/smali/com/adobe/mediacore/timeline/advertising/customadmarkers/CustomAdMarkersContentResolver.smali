.class public final Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;
.super Lcom/adobe/mediacore/timeline/advertising/ContentResolver;


# static fields
.field public static final DEFAULT_TIME_PREROLL:I

.field private static final LOG_TAG:Ljava/lang/String;

.field private static _nextAvailableAdId:I


# instance fields
.field private final _logger:Lcom/adobe/mediacore/logging/Logger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[CustomAdMarkers]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->LOG_TAG:Ljava/lang/String;

    const/16 v0, 0x2710

    sput v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->_nextAvailableAdId:I

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/adobe/mediacore/timeline/advertising/ContentResolver;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    return-void
.end method

.method private extractAdBreakPlacements(Ljava/util/List;Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;
    .locals 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/ReplacementTimeRange;",
            ">;",
            "Lcom/adobe/mediacore/metadata/Metadata;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/timeline/TimelineOperation;",
            ">;"
        }
    .end annotation

    new-instance v11, Ljava/util/ArrayList;

    invoke-direct {v11}, Ljava/util/ArrayList;-><init>()V

    invoke-interface/range {p1 .. p1}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_0

    move-object v2, v11

    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mediacore/utils/TimeRange;

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v2, v1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->timeRangeToAd(Lcom/adobe/mediacore/utils/TimeRange;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v3

    invoke-interface {v4, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    const/4 v3, 0x1

    move v9, v3

    move-object v10, v5

    move-object v3, v4

    move-object v4, v2

    :goto_1
    invoke-interface/range {p1 .. p1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v9, v2, :cond_5

    move-object/from16 v0, p1

    invoke-interface {v0, v9}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/adobe/mediacore/utils/TimeRange;

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v6

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v12

    sub-long/2addr v6, v12

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const-wide/16 v12, 0x0

    cmp-long v6, v6, v12

    if-gez v6, :cond_2

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Math;->abs(J)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v6

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v12

    add-long/2addr v6, v12

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v12

    cmp-long v6, v6, v12

    if-ltz v6, :cond_1

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v7, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "#extractAdBreakPlacements"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "Failed to place custome ad-marker for timerange: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v7, ". Prev. time-range: "

    invoke-virtual {v2, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v5, v6, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-object v5, v4

    move-object v4, v10

    :goto_2
    add-int/lit8 v2, v9, 0x1

    move v9, v2

    move-object v10, v4

    move-object v4, v5

    goto/16 :goto_1

    :cond_1
    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v8, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "#extractAdBreakPlacements"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Adjusting timerange: "

    invoke-virtual {v8, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v12, "with offset: "

    invoke-virtual {v8, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v12, ". Prev. time-range: "

    invoke-virtual {v8, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-interface {v6, v7, v8}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v6

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v12

    add-long/2addr v6, v12

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v12

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v14

    sub-long/2addr v12, v14

    invoke-static {v6, v7, v12, v13}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v2

    :cond_2
    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v6

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v12

    sub-long/2addr v6, v12

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const-wide/16 v12, 0x0

    cmp-long v6, v6, v12

    if-lez v6, :cond_3

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    const-string v8, "custom_ad_break"

    invoke-static/range {v3 .. v8}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v3

    new-instance v4, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v12

    move-object/from16 v0, p0

    invoke-direct {v0, v6, v7, v12, v13}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->getPlacementInformation(JJ)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v5

    invoke-direct {v4, v3, v5}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-interface {v11, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v2, v1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->timeRangeToAd(Lcom/adobe/mediacore/utils/TimeRange;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    :goto_3
    move-object v4, v10

    move-object v5, v2

    goto/16 :goto_2

    :cond_3
    invoke-virtual {v5}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    const-wide/16 v12, 0x0

    cmp-long v5, v6, v12

    if-nez v5, :cond_4

    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v2, v1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->timeRangeToAd(Lcom/adobe/mediacore/utils/TimeRange;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_3

    :cond_4
    new-instance v3, Ljava/lang/IllegalStateException;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Time-ranges should not overlap at this point. Current time-range: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, ". Prev. time-range: "

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v3, v2}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v3

    :cond_5
    invoke-interface {v3}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_6

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    const-string v8, "custom_ad_break"

    invoke-static/range {v3 .. v8}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->createAdBreak(Ljava/util/List;JJLjava/lang/String;)Lcom/adobe/mediacore/timeline/advertising/AdBreak;

    move-result-object v2

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-virtual {v2}, Lcom/adobe/mediacore/timeline/advertising/AdBreak;->getDuration()J

    move-result-wide v6

    move-object/from16 v0, p0

    invoke-direct {v0, v4, v5, v6, v7}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->getPlacementInformation(JJ)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v3

    new-instance v4, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;

    invoke-direct {v4, v2, v3}, Lcom/adobe/mediacore/timeline/advertising/AdBreakPlacement;-><init>(Lcom/adobe/mediacore/timeline/advertising/AdBreak;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;)V

    invoke-interface {v11, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    :cond_6
    move-object v2, v11

    goto/16 :goto_0
.end method

.method private extractCustomAdMarkersMetadata(Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/metadata/MetadataNode;
    .locals 2

    const/4 v0, 0x0

    instance-of v1, p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v1, :cond_1

    check-cast p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

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

    if-eqz v0, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    :cond_1
    :goto_0
    return-object v0

    :cond_2
    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    goto :goto_0
.end method

.method private extractTimeRanges(Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;
    .locals 10
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/metadata/Metadata;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/TimeRange;",
            ">;"
        }
    .end annotation

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    const-string v0, "time_range_list"

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v2

    new-instance v0, Ljava/util/TreeSet;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->keySet()Ljava/util/Set;

    move-result-object v3

    invoke-direct {v0, v3}, Ljava/util/TreeSet;-><init>(Ljava/util/Collection;)V

    invoke-interface {v0}, Ljava/util/SortedSet;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    const-string v4, "time_range_begin"

    invoke-virtual {v0, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    const-string v5, "time_range_end"

    invoke-virtual {v0, v5}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    cmp-long v5, v6, v8

    if-ltz v5, :cond_0

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "\'begin\' value must not be greater or equal than the \'end\' value."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_0
    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v6

    invoke-virtual {v0}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    sub-long v4, v8, v4

    invoke-static {v6, v7, v4, v5}, Lcom/adobe/mediacore/utils/TimeRange;->createRange(JJ)Lcom/adobe/mediacore/utils/TimeRange;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    :cond_1
    return-object v1
.end method

.method public static declared-synchronized getNextTimelineId()I
    .locals 3

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;

    monitor-enter v1

    :try_start_0
    sget v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->_nextAvailableAdId:I

    add-int/lit8 v2, v0, 0x1

    sput v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->_nextAvailableAdId:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method private getPlacementInformation(JJ)Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;
    .locals 9

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->MID_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    const-wide/16 v0, 0x0

    cmp-long v0, p1, v0

    if-nez v0, :cond_0

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;->PRE_ROLL:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;

    :cond_0
    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->MARK:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-wide v4, p1

    move-wide v6, p3

    invoke-direct/range {v1 .. v7}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;-><init>(Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Type;Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;JJ)V

    return-object v1
.end method

.method private getPrimaryAdAssetForCustomAdMarker(Lcom/adobe/mediacore/metadata/Metadata;IJ)Lcom/adobe/mediacore/timeline/advertising/AdAsset;
    .locals 7

    new-instance v5, Lcom/adobe/mediacore/timeline/advertising/AdClick;

    const-string v0, ""

    const-string v1, ""

    const-string v2, ""

    invoke-direct {v5, v0, v1, v2}, Lcom/adobe/mediacore/timeline/advertising/AdClick;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v0, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-static {p1, v0}, Lcom/adobe/mediacore/MediaResource;->createFromMetadata(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/MediaResource$Type;)Lcom/adobe/mediacore/MediaResource;

    move-result-object v4

    new-instance v0, Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move v1, p2

    move-wide v2, p3

    move-object v6, p1

    invoke-direct/range {v0 .. v6}, Lcom/adobe/mediacore/timeline/advertising/AdAsset;-><init>(IJLcom/adobe/mediacore/MediaResource;Lcom/adobe/mediacore/timeline/advertising/AdClick;Lcom/adobe/mediacore/metadata/Metadata;)V

    return-object v0
.end method

.method private handleInvalidMetadata(Ljava/lang/Exception;)V
    .locals 4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->LOG_TAG:Ljava/lang/String;

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

    const-string v1, "Invalid JSON metadata."

    invoke-static {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification;->createErrorNotification(Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$Error;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v1}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v2, "DESCRIPTION"

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v3}, Lcom/adobe/mediacore/metadata/Metadata;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/MediaPlayerNotification$Error;->setMetadata(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->notifyResolveError(Lcom/adobe/mediacore/MediaPlayerNotification$Error;)V

    return-void
.end method

.method private processMetadata(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;)V
    .locals 4

    :try_start_0
    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_TYPE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-interface {p1, v0}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {p1, v0}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    sget-object v2, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->MARK_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    :cond_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Metadata type must be: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    :catch_0
    move-exception v0

    invoke-direct {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->handleInvalidMetadata(Ljava/lang/Exception;)V

    :goto_0
    return-void

    :cond_1
    :try_start_1
    invoke-virtual {p2}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->extractCustomTimeRangeMetadata()Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->extractCustomTimeRanges(Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p2, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->mergeRanges(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    invoke-direct {p0, v0, p1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->extractAdBreakPlacements(Ljava/util/List;Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->notifyResolveComplete(Ljava/util/List;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method private timeRangeToAd(Lcom/adobe/mediacore/utils/TimeRange;Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/timeline/advertising/Ad;
    .locals 5

    invoke-static {}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->getNextTimelineId()I

    move-result v0

    invoke-virtual {p1}, Lcom/adobe/mediacore/utils/TimeRange;->getDuration()J

    move-result-wide v2

    sget-object v1, Lcom/adobe/mediacore/MediaResource$Type;->HLS:Lcom/adobe/mediacore/MediaResource$Type;

    invoke-direct {p0, p2, v0, v2, v3}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->getPrimaryAdAssetForCustomAdMarker(Lcom/adobe/mediacore/metadata/Metadata;IJ)Lcom/adobe/mediacore/timeline/advertising/AdAsset;

    move-result-object v4

    invoke-static {v1, v2, v3, v0, v4}, Lcom/adobe/mediacore/timeline/advertising/Ad;->createCustomAdMarker(Lcom/adobe/mediacore/MediaResource$Type;JILcom/adobe/mediacore/timeline/advertising/AdAsset;)Lcom/adobe/mediacore/timeline/advertising/Ad;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method protected doCanResolve(Lcom/adobe/mediacore/timeline/PlacementOpportunity;)Z
    .locals 2

    invoke-virtual {p1}, Lcom/adobe/mediacore/timeline/PlacementOpportunity;->getPlacementInformation()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;

    move-result-object v0

    invoke-virtual {v0}, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation;->getMode()Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

    move-result-object v0

    sget-object v1, Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;->MARK:Lcom/adobe/mediacore/timeline/advertising/PlacementInformation$Mode;

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
    .locals 2

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->extractCustomAdMarkersMetadata(Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v0

    new-instance v1, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;

    invoke-direct {v1, p1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;-><init>(Lcom/adobe/mediacore/metadata/Metadata;)V

    invoke-direct {p0, v0, v1}, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomAdMarkersContentResolver;->processMetadata(Lcom/adobe/mediacore/metadata/Metadata;Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;)V

    return-void
.end method
