.class public Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;
.super Ljava/lang/Object;


# static fields
.field public static final DELETE_RANGE:Ljava/lang/String; = "delete"

.field private static final LOG_TAG:Ljava/lang/String;

.field public static final MARK_RANGE:Ljava/lang/String; = "mark"

.field public static final REPLACE_RANGE:Ljava/lang/String; = "replace"


# instance fields
.field private _key:Ljava/lang/String;

.field private final _logger:Lcom/adobe/mediacore/logging/Logger;

.field private _metadata:Lcom/adobe/mediacore/metadata/Metadata;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "[PSDK]::[CustomRangeHelper]::"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-class v1, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;

    invoke-virtual {v1}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/metadata/Metadata;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    sget-object v0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-static {v0}, Lcom/adobe/mediacore/logging/Log;->getLogger(Ljava/lang/String;)Lcom/adobe/mediacore/logging/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    iput-object p1, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    return-void
.end method


# virtual methods
.method public extractCustomTimeRangeMetadata()Lcom/adobe/mediacore/metadata/MetadataNode;
    .locals 3

    const/4 v1, 0x0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    instance-of v0, v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    check-cast v0, Lcom/adobe/mediacore/metadata/MetadataNode;

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    :cond_0
    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    if-eqz v1, :cond_1

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    :cond_1
    :goto_0
    return-object v1

    :cond_2
    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsNode(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v1

    goto :goto_0
.end method

.method public extractCustomTimeRanges(Lcom/adobe/mediacore/metadata/Metadata;)Ljava/util/List;
    .locals 14
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/metadata/Metadata;",
            ")",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/ReplacementTimeRange;",
            ">;"
        }
    .end annotation

    const-wide/16 v12, 0x0

    new-instance v6, Ljava/util/ArrayList;

    invoke-direct {v6}, Ljava/util/ArrayList;-><init>()V

    check-cast p1, Lcom/adobe/mediacore/metadata/MetadataNode;

    const-string v0, "time_range_list"

    invoke-virtual {p1, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v7

    new-instance v0, Ljava/util/TreeSet;

    invoke-virtual {v7}, Lcom/adobe/mediacore/metadata/MetadataNode;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/util/TreeSet;-><init>(Ljava/util/Collection;)V

    invoke-interface {v0}, Ljava/util/SortedSet;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v7, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getNode(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/MetadataNode;

    move-result-object v2

    const-string v0, "time_range_begin"

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    const-string v0, "time_range_end"

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    const-string v4, "replacement_duration"

    invoke-virtual {v2, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->containsKey(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_4

    const-string v0, "replacement_duration"

    invoke-virtual {v2, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    move-object v4, v0

    :goto_1
    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v0, v10, v12

    if-gez v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, "#extractCustomTimeRanges"

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Invalid TimeRange ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ", "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "], \'end\' value is less than 0, time range ignored"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v2, v1}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_0
    invoke-virtual {v1}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v0, v10, v12

    if-gez v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v5, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v5, "#extractCustomTimeRanges"

    invoke-virtual {v2, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v9, "Invalid TimeRange ["

    invoke-virtual {v5, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, ", "

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v5, "], modified \'begin\' to 0"

    invoke-virtual {v1, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v2, v1}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    invoke-static {v12, v13}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    move-object v2, v0

    :goto_2
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v0, v0, v10

    if-ltz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "#extractCustomTimeRanges"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Invalid TimeRange ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ", "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "], \'begin\' value must not be greater then or equal to \'end\', time range ignored."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    :cond_1
    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v0

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v2

    sub-long v2, v10, v2

    invoke-virtual {v4}, Ljava/lang/Long;->longValue()J

    move-result-wide v4

    invoke-static/range {v0 .. v5}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->createRange(JJJ)Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    move-result-object v0

    invoke-interface {v6, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto/16 :goto_0

    :cond_2
    invoke-static {v6}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    return-object v6

    :cond_3
    move-object v2, v1

    goto :goto_2

    :cond_4
    move-object v4, v0

    goto/16 :goto_1
.end method

.method public hasRanges()Ljava/lang/String;
    .locals 2

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_key:Ljava/lang/String;

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "delete"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    const-string v0, "delete"

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_key:Ljava/lang/String;

    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_metadata:Lcom/adobe/mediacore/metadata/Metadata;

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "mark"

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_key:Ljava/lang/String;

    :cond_1
    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_key:Ljava/lang/String;

    return-object v0

    :cond_2
    const-string v1, "replace"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    const-string v0, "replace"

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_key:Ljava/lang/String;

    goto :goto_0

    :cond_3
    const-string v1, "mark"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    const-string v0, "mark"

    iput-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_key:Ljava/lang/String;

    goto :goto_0
.end method

.method public mergeRanges(Ljava/util/List;)Ljava/util/List;
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/ReplacementTimeRange;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/ReplacementTimeRange;",
            ">;"
        }
    .end annotation

    new-instance v8, Ljava/util/ArrayList;

    invoke-direct {v8}, Ljava/util/ArrayList;-><init>()V

    const/4 v0, 0x0

    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    const/4 v1, 0x1

    move v6, v1

    move-object v7, v0

    :goto_0
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-ge v6, v0, :cond_5

    invoke-interface {p1, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    move-object v2, v0

    check-cast v2, Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-lez v0, :cond_2

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-lez v0, :cond_0

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object v1, v2

    :goto_1
    add-int/lit8 v0, v6, 0x1

    move v6, v0

    move-object v7, v1

    goto :goto_0

    :cond_0
    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-lez v0, :cond_1

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v0

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v2

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v4

    sub-long/2addr v2, v4

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getReplacementDuration()J

    move-result-wide v4

    invoke-static/range {v0 .. v5}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->createRange(JJJ)Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    move-result-object v2

    invoke-interface {v8, v7}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#mergeRanges"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Adjusting timerange due to overlap between prev and current timerange: New Timerange "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v2

    goto :goto_1

    :cond_1
    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-gez v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#mergeRanges"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "TimeRange "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " was not added because it is a subset "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "of the previous timerange"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v2

    goto/16 :goto_1

    :cond_2
    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-nez v0, :cond_4

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-lez v0, :cond_3

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v0

    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v2

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v4

    sub-long/2addr v2, v4

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getReplacementDuration()J

    move-result-wide v4

    invoke-static/range {v0 .. v5}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->createRange(JJJ)Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    move-result-object v2

    invoke-interface {v8, v7}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    invoke-interface {v8, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#mergeRanges"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Adjusting timerange due to overlap between prev and current timerange: New Timerange "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v2

    goto/16 :goto_1

    :cond_3
    invoke-virtual {v2}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v0

    invoke-virtual {v7}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v4

    cmp-long v0, v0, v4

    if-gez v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->_logger:Lcom/adobe/mediacore/logging/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Lcom/adobe/mediacore/timeline/advertising/customadmarkers/CustomRangeHelper;->LOG_TAG:Ljava/lang/String;

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "#mergeRanges"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "TimeRange "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " was not added because it is a subset "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "of the previous timerange"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v1, v3}, Lcom/adobe/mediacore/logging/Logger;->w(Ljava/lang/String;Ljava/lang/String;)V

    :cond_4
    move-object v1, v2

    goto/16 :goto_1

    :cond_5
    return-object v8
.end method
