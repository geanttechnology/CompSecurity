.class public Lcom/adobe/mediacore/utils/TimeRangeCollection;
.super Ljava/lang/Object;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/adobe/mediacore/utils/TimeRangeCollection$1;,
        Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;
    }
.end annotation


# static fields
.field public static final TIME_RANGE_BEGIN:Ljava/lang/String; = "time_range_begin"

.field public static final TIME_RANGE_END:Ljava/lang/String; = "time_range_end"

.field public static final TIME_RANGE_LIST:Ljava/lang/String; = "time_range_list"

.field public static final TIME_RANGE_REPLACEMENT_DURATION:Ljava/lang/String; = "replacement_duration"

.field public static final TIME_RANGE_TYPE:Ljava/lang/String; = "time_range_type"

.field public static final TIME_RANGE_TYPE_DELETE:Ljava/lang/String; = "delete"

.field public static final TIME_RANGE_TYPE_MARK:Ljava/lang/String; = "mark"

.field public static final TIME_RANGE_TYPE_REPLACE:Ljava/lang/String; = "replace"


# instance fields
.field private _timeRanges:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/TimeRange;",
            ">;"
        }
    .end annotation
.end field

.field private final _type:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;


# direct methods
.method public constructor <init>(Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;)V
    .locals 1

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    iput-object p1, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_type:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    return-void
.end method

.method public constructor <init>(Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;Ljava/util/List;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;",
            "Ljava/util/List",
            "<",
            "Lcom/adobe/mediacore/utils/TimeRange;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0, p1}, Lcom/adobe/mediacore/utils/TimeRangeCollection;-><init>(Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;)V

    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0, p2}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    return-void
.end method


# virtual methods
.method public addTimeRange(Lcom/adobe/mediacore/utils/TimeRange;)V
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    return-void
.end method

.method public toMetadata(Lcom/adobe/mediacore/metadata/Metadata;)Lcom/adobe/mediacore/metadata/Metadata;
    .locals 10

    const/4 v0, 0x0

    new-instance v2, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v2}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    new-instance v3, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v3}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    sget-object v1, Lcom/adobe/mediacore/utils/TimeRangeCollection$1;->$SwitchMap$com$adobe$mediacore$utils$TimeRangeCollection$Type:[I

    iget-object v4, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_type:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->ordinal()I

    move-result v4

    aget v1, v1, v4

    packed-switch v1, :pswitch_data_0

    new-instance v0, Ljava/lang/IllegalStateException;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid time-range collection type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_type:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :pswitch_0
    const-string v1, "time_range_type"

    const-string v4, "delete"

    invoke-virtual {v2, v1, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/utils/TimeRange;

    new-instance v4, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v4}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v5, "time_range_begin"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "time_range_end"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ""

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ""

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_0
    const-string v0, "time_range_list"

    invoke-virtual {v2, v0, v3}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    move-object v0, v2

    :goto_1
    return-object v0

    :pswitch_1
    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_TYPE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    sget-object v4, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->MARK_RANGES:Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;

    invoke-virtual {v4}, Lcom/adobe/mediacore/utils/TimeRangeCollection$Type;->getValue()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v1, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    if-eqz p1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/adobe/mediacore/metadata/Metadata;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {p1, v1}, Lcom/adobe/mediacore/metadata/Metadata;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string v4, "true"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    :cond_1
    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    const-string v4, "false"

    invoke-virtual {v2, v1, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    :goto_2
    move v1, v0

    :goto_3
    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/utils/TimeRange;

    new-instance v4, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v4}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v5, "time_range_begin"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getBegin()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "time_range_end"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/TimeRange;->getEnd()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ""

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ""

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_3

    :cond_2
    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v1}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->getValue()Ljava/lang/String;

    move-result-object v1

    const-string v4, "true"

    invoke-virtual {v2, v1, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    :cond_3
    const-string v0, "time_range_list"

    invoke-virtual {v2, v0, v3}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    move-object v0, v2

    goto/16 :goto_1

    :pswitch_2
    const-string v1, "time_range_type"

    const-string v4, "replace"

    invoke-virtual {v2, v1, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    move v1, v0

    :goto_4
    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_4

    iget-object v0, p0, Lcom/adobe/mediacore/utils/TimeRangeCollection;->_timeRanges:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/utils/ReplacementTimeRange;

    new-instance v4, Lcom/adobe/mediacore/metadata/MetadataNode;

    invoke-direct {v4}, Lcom/adobe/mediacore/metadata/MetadataNode;-><init>()V

    const-string v5, "time_range_begin"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getBegin()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "time_range_end"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getEnd()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ""

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    const-string v5, "replacement_duration"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0}, Lcom/adobe/mediacore/utils/ReplacementTimeRange;->getReplacementDuration()J

    move-result-wide v8

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ""

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v4, v5, v0}, Lcom/adobe/mediacore/metadata/MetadataNode;->setValue(Ljava/lang/String;Ljava/lang/String;)V

    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v5, ""

    invoke-virtual {v0, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0, v4}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_4

    :cond_4
    const-string v0, "time_range_list"

    invoke-virtual {v2, v0, v3}, Lcom/adobe/mediacore/metadata/MetadataNode;->setNode(Ljava/lang/String;Lcom/adobe/mediacore/metadata/Metadata;)V

    move-object v0, v2

    goto/16 :goto_1

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
