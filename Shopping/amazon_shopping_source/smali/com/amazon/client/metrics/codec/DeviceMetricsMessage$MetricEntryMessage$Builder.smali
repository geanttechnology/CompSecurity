.class public final Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
.super Lcom/google/protobuf/GeneratedMessage$Builder;

# interfaces
.implements Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessageOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "Builder"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/protobuf/GeneratedMessage$Builder",
        "<",
        "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;",
        ">;",
        "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessageOrBuilder;"
    }
.end annotation


# instance fields
.field private bitField0_:I

.field private dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/protobuf/RepeatedFieldBuilder",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;",
            ">;"
        }
    .end annotation
.end field

.field private dataPoint_:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;",
            ">;"
        }
    .end annotation
.end field

.field private program_:Ljava/lang/Object;

.field private source_:Ljava/lang/Object;

.field private timestamp_:J


# direct methods
.method private constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessage$Builder;-><init>()V

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->maybeForceBuilderInitialization()V

    return-void
.end method

.method private constructor <init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)V
    .locals 1

    invoke-direct {p0, p1}, Lcom/google/protobuf/GeneratedMessage$Builder;-><init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)V

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->maybeForceBuilderInitialization()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;-><init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)V

    return-void
.end method

.method static synthetic access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1800()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method private buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->isInitialized()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->newUninitializedMessageException(Lcom/google/protobuf/Message;)Lcom/google/protobuf/UninitializedMessageException;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/UninitializedMessageException;->asInvalidProtocolBufferException()Lcom/google/protobuf/InvalidProtocolBufferException;

    move-result-object v0

    throw v0

    :cond_0
    return-object v0
.end method

.method private static create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    invoke-direct {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;-><init>()V

    return-object v0
.end method

.method private ensureDataPointIsMutable()V
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, 0x8

    const/16 v1, 0x8

    if-eq v0, v1, :cond_0

    new-instance v0, Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x8

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    :cond_0
    return-void
.end method

.method private getDataPointFieldBuilder()Lcom/google/protobuf/RepeatedFieldBuilder;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/google/protobuf/RepeatedFieldBuilder",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    new-instance v1, Lcom/google/protobuf/RepeatedFieldBuilder;

    iget-object v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, 0x8

    const/16 v3, 0x8

    if-ne v0, v3, :cond_1

    const/4 v0, 0x1

    :goto_0
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getParentForChildren()Lcom/google/protobuf/GeneratedMessage$BuilderParent;

    move-result-object v3

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->isClean()Z

    move-result v4

    invoke-direct {v1, v2, v0, v3, v4}, Lcom/google/protobuf/RepeatedFieldBuilder;-><init>(Ljava/util/List;ZLcom/google/protobuf/GeneratedMessage$BuilderParent;Z)V

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static final getDescriptor()Lcom/google/protobuf/Descriptors$Descriptor;
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricEntryMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$1500()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v0

    return-object v0
.end method

.method private maybeForceBuilderInitialization()V
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->alwaysUseFieldBuilders:Z
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2000()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPointFieldBuilder()Lcom/google/protobuf/RepeatedFieldBuilder;

    :cond_0
    return-void
.end method


# virtual methods
.method public addAllDataPoint(Ljava/lang/Iterable;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Iterable",
            "<+",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;",
            ">;)",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-static {p1, v0}, Lcom/google/protobuf/GeneratedMessage$Builder;->addAll(Ljava/lang/Iterable;Ljava/util/Collection;)V

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0, p1}, Lcom/google/protobuf/RepeatedFieldBuilder;->addAllMessages(Ljava/lang/Iterable;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_0
.end method

.method public addDataPoint(ILcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-virtual {p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/List;->add(ILjava/lang/Object;)V

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->addMessage(ILcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_0
.end method

.method public addDataPoint(ILcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_1

    if-nez p2, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1, p2}, Ljava/util/List;->add(ILjava/lang/Object;)V

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0, p1, p2}, Lcom/google/protobuf/RepeatedFieldBuilder;->addMessage(ILcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_0
.end method

.method public addDataPoint(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->addMessage(Lcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_0
.end method

.method public addDataPoint(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0, p1}, Lcom/google/protobuf/RepeatedFieldBuilder;->addMessage(Lcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_0
.end method

.method public addDataPointBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 2

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPointFieldBuilder()Lcom/google/protobuf/RepeatedFieldBuilder;

    move-result-object v0

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->addBuilder(Lcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/GeneratedMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    return-object v0
.end method

.method public addDataPointBuilder(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 2

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPointFieldBuilder()Lcom/google/protobuf/RepeatedFieldBuilder;

    move-result-object v0

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->addBuilder(ILcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/GeneratedMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    return-object v0
.end method

.method public build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 2

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->isInitialized()Z

    move-result v1

    if-nez v1, :cond_0

    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->newUninitializedMessageException(Lcom/google/protobuf/Message;)Lcom/google/protobuf/UninitializedMessageException;

    move-result-object v0

    throw v0

    :cond_0
    return-object v0
.end method

.method public bridge synthetic build()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic build()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 6

    const/4 v0, 0x1

    new-instance v2, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    const/4 v1, 0x0

    invoke-direct {v2, p0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;-><init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V

    iget v3, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    const/4 v1, 0x0

    and-int/lit8 v4, v3, 0x1

    if-ne v4, v0, :cond_4

    :goto_0
    iget-wide v4, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->timestamp_:J

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->timestamp_:J
    invoke-static {v2, v4, v5}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2202(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;J)J

    and-int/lit8 v1, v3, 0x2

    const/4 v4, 0x2

    if-ne v1, v4, :cond_0

    or-int/lit8 v0, v0, 0x2

    :cond_0
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->program_:Ljava/lang/Object;
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2302(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;Ljava/lang/Object;)Ljava/lang/Object;

    and-int/lit8 v1, v3, 0x4

    const/4 v3, 0x4

    if-ne v1, v3, :cond_1

    or-int/lit8 v0, v0, 0x4

    :cond_1
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->source_:Ljava/lang/Object;
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2402(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v1, :cond_3

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v1, v1, 0x8

    const/16 v3, 0x8

    if-ne v1, v3, :cond_2

    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-static {v1}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v1, v1, -0x9

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    :cond_2
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2502(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;Ljava/util/List;)Ljava/util/List;

    :goto_1
    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I
    invoke-static {v2, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2602(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;I)I

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onBuilt()V

    return-object v2

    :cond_3
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->build()Ljava/util/List;

    move-result-object v1

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {v2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2502(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;Ljava/util/List;)Ljava/util/List;

    goto :goto_1

    :cond_4
    move v0, v1

    goto :goto_0
.end method

.method public bridge synthetic buildPartial()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic buildPartial()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 2

    invoke-super {p0}, Lcom/google/protobuf/GeneratedMessage$Builder;->clear()Lcom/google/protobuf/GeneratedMessage$Builder;

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->timestamp_:J

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    :goto_0
    return-object p0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0}, Lcom/google/protobuf/RepeatedFieldBuilder;->clear()V

    goto :goto_0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/GeneratedMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clear()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clear()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public clearDataPoint()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0}, Lcom/google/protobuf/RepeatedFieldBuilder;->clear()V

    goto :goto_0
.end method

.method public clearProgram()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x3

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getProgram()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public clearSource()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x5

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getSource()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public clearTimestamp()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->timestamp_:J

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-object p0
.end method

.method public clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 2

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/AbstractMessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/GeneratedMessage$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic clone()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/CloneNotSupportedException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->clone()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public getDataPoint(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0, p1}, Lcom/google/protobuf/RepeatedFieldBuilder;->getMessage(I)Lcom/google/protobuf/GeneratedMessage;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    goto :goto_0
.end method

.method public getDataPointBuilder(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;
    .locals 1

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPointFieldBuilder()Lcom/google/protobuf/RepeatedFieldBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/protobuf/RepeatedFieldBuilder;->getBuilder(I)Lcom/google/protobuf/GeneratedMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    return-object v0
.end method

.method public getDataPointBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;",
            ">;"
        }
    .end annotation

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPointFieldBuilder()Lcom/google/protobuf/RepeatedFieldBuilder;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/RepeatedFieldBuilder;->getBuilderList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public getDataPointCount()I
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    :goto_0
    return v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0}, Lcom/google/protobuf/RepeatedFieldBuilder;->getCount()I

    move-result v0

    goto :goto_0
.end method

.method public getDataPointList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0}, Lcom/google/protobuf/RepeatedFieldBuilder;->getMessageList()Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public getDataPointOrBuilder(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0, p1}, Lcom/google/protobuf/RepeatedFieldBuilder;->getMessageOrBuilder(I)Lcom/google/protobuf/MessageOrBuilder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;

    goto :goto_0
.end method

.method public getDataPointOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<+",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0}, Lcom/google/protobuf/RepeatedFieldBuilder;->getMessageOrBuilderList()Ljava/util/List;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-static {v0}, Ljava/util/Collections;->unmodifiableList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    goto :goto_0
.end method

.method public getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public getDescriptorForType()Lcom/google/protobuf/Descriptors$Descriptor;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDescriptor()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v0

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-nez v1, :cond_0

    check-cast v0, Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public getSource()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-nez v1, :cond_0

    check-cast v0, Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Ljava/lang/String;

    goto :goto_0
.end method

.method public getTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->timestamp_:J

    return-wide v0
.end method

.method public hasProgram()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, 0x2

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasSource()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, 0x4

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasTimestamp()Z
    .locals 2

    const/4 v0, 0x1

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v1, v1, 0x1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected internalGetFieldAccessorTable()Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricEntryMessage_fieldAccessorTable:Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$1600()Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    move-result-object v0

    return-object v0
.end method

.method public final isInitialized()Z
    .locals 3

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->hasTimestamp()Z

    move-result v0

    if-nez v0, :cond_1

    :cond_0
    :goto_0
    return v1

    :cond_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->hasProgram()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->hasSource()Z

    move-result v0

    if-eqz v0, :cond_0

    move v0, v1

    :goto_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPointCount()I

    move-result v2

    if-ge v0, v2, :cond_2

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPoint(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->isInitialized()Z

    move-result v2

    if-eqz v2, :cond_0

    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 3

    const/4 v0, 0x0

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v1

    if-ne p1, v1, :cond_0

    :goto_0
    return-object p0

    :cond_0
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->hasTimestamp()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getTimestamp()J

    move-result-wide v1

    invoke-virtual {p0, v1, v2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setTimestamp(J)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    :cond_1
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->hasProgram()Z

    move-result v1

    if-eqz v1, :cond_2

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getProgram()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setProgram(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    :cond_2
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->hasSource()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getSource()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setSource(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    :cond_3
    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v1, :cond_6

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2500(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_5

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2500(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v0, v0, -0x9

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    :goto_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :cond_4
    :goto_2
    invoke-virtual {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeUnknownFields(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/GeneratedMessage$Builder;

    goto :goto_0

    :cond_5
    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2500(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_1

    :cond_6
    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2500(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_8

    iget-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->dispose()V

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2500(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Ljava/util/List;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    and-int/lit8 v1, v1, -0x9

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->alwaysUseFieldBuilders:Z
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2700()Z

    move-result v1

    if-eqz v1, :cond_7

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getDataPointFieldBuilder()Lcom/google/protobuf/RepeatedFieldBuilder;

    move-result-object v0

    :cond_7
    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_2

    :cond_8
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;
    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->access$2500(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->addAllMessages(Ljava/lang/Iterable;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_2
.end method

.method public mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-static {v0}, Lcom/google/protobuf/UnknownFieldSet;->newBuilder(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/UnknownFieldSet$Builder;

    move-result-object v0

    :cond_0
    :goto_0
    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readTag()I

    move-result v1

    sparse-switch v1, :sswitch_data_0

    invoke-virtual {p0, p1, v0, p2, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->parseUnknownField(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/UnknownFieldSet$Builder;Lcom/google/protobuf/ExtensionRegistryLite;I)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {v0}, Lcom/google/protobuf/UnknownFieldSet$Builder;->build()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setUnknownFields(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/GeneratedMessage$Builder;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_1
    return-object p0

    :sswitch_0
    invoke-virtual {v0}, Lcom/google/protobuf/UnknownFieldSet$Builder;->build()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->setUnknownFields(Lcom/google/protobuf/UnknownFieldSet;)Lcom/google/protobuf/GeneratedMessage$Builder;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    goto :goto_1

    :sswitch_1
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v1, v1, 0x1

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readInt64()J

    move-result-wide v1

    iput-wide v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->timestamp_:J

    goto :goto_0

    :sswitch_2
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v1, v1, 0x2

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    goto :goto_0

    :sswitch_3
    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v1, v1, 0x4

    iput v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    invoke-virtual {p1}, Lcom/google/protobuf/CodedInputStream;->readBytes()Lcom/google/protobuf/ByteString;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    goto :goto_0

    :sswitch_4
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    move-result-object v1

    invoke-virtual {p1, v1, p2}, Lcom/google/protobuf/CodedInputStream;->readMessage(Lcom/google/protobuf/MessageLite$Builder;Lcom/google/protobuf/ExtensionRegistryLite;)V

    invoke-virtual {v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->buildPartial()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->addDataPoint(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    goto :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0x8 -> :sswitch_1
        0x12 -> :sswitch_2
        0x1a -> :sswitch_3
        0x22 -> :sswitch_4
    .end sparse-switch
.end method

.method public mergeFrom(Lcom/google/protobuf/Message;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    instance-of v0, p1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    if-eqz v0, :cond_0

    check-cast p1, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object p0

    :goto_0
    return-object p0

    :cond_0
    invoke-super {p0, p1}, Lcom/google/protobuf/GeneratedMessage$Builder;->mergeFrom(Lcom/google/protobuf/Message;)Lcom/google/protobuf/AbstractMessage$Builder;

    goto :goto_0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/Message;)Lcom/google/protobuf/AbstractMessage$Builder;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/Message;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessageLite$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/Message$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/Message;)Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/Message;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/MessageLite$Builder;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-virtual {p0, p1, p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public removeDataPoint(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0, p1}, Lcom/google/protobuf/RepeatedFieldBuilder;->remove(I)V

    goto :goto_0
.end method

.method public setDataPoint(ILcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_0

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-virtual {p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-interface {v0, p1, v1}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {p2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;->build()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/google/protobuf/RepeatedFieldBuilder;->setMessage(ILcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_0
.end method

.method public setDataPoint(ILcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    if-nez v0, :cond_1

    if-nez p2, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->ensureDataPointIsMutable()V

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1, p2}, Ljava/util/List;->set(ILjava/lang/Object;)Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    :goto_0
    return-object p0

    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->dataPointBuilder_:Lcom/google/protobuf/RepeatedFieldBuilder;

    invoke-virtual {v0, p1, p2}, Lcom/google/protobuf/RepeatedFieldBuilder;->setMessage(ILcom/google/protobuf/GeneratedMessage;)Lcom/google/protobuf/RepeatedFieldBuilder;

    goto :goto_0
.end method

.method public setProgram(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-object p0
.end method

.method setProgram(Lcom/google/protobuf/ByteString;)V
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->program_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-void
.end method

.method public setSource(Ljava/lang/String;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    if-nez p1, :cond_0

    new-instance v0, Ljava/lang/NullPointerException;

    invoke-direct {v0}, Ljava/lang/NullPointerException;-><init>()V

    throw v0

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-object p0
.end method

.method setSource(Lcom/google/protobuf/ByteString;)V
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x4

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->source_:Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-void
.end method

.method public setTimestamp(J)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    or-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->bitField0_:I

    iput-wide p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->timestamp_:J

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->onChanged()V

    return-object p0
.end method
