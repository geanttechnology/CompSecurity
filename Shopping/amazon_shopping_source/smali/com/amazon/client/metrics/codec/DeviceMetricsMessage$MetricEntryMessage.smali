.class public final Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
.super Lcom/google/protobuf/GeneratedMessage;

# interfaces
.implements Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessageOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "MetricEntryMessage"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    }
.end annotation


# static fields
.field public static final DATAPOINT_FIELD_NUMBER:I = 0x4

.field public static final PROGRAM_FIELD_NUMBER:I = 0x2

.field public static final SOURCE_FIELD_NUMBER:I = 0x3

.field public static final TIMESTAMP_FIELD_NUMBER:I = 0x1

.field private static final defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

.field private static final serialVersionUID:J


# instance fields
.field private bitField0_:I

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

.field private memoizedIsInitialized:B

.field private memoizedSerializedSize:I

.field private program_:Ljava/lang/Object;

.field private source_:Ljava/lang/Object;

.field private timestamp_:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;-><init>(Z)V

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    invoke-direct {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->initFields()V

    return-void
.end method

.method private constructor <init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)V
    .locals 1

    const/4 v0, -0x1

    invoke-direct {p0, p1}, Lcom/google/protobuf/GeneratedMessage;-><init>(Lcom/google/protobuf/GeneratedMessage$Builder;)V

    iput-byte v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedSerializedSize:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;-><init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)V

    return-void
.end method

.method private constructor <init>(Z)V
    .locals 1

    const/4 v0, -0x1

    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessage;-><init>()V

    iput-byte v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedSerializedSize:I

    return-void
.end method

.method static synthetic access$2000()Z
    .locals 1

    sget-boolean v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->alwaysUseFieldBuilders:Z

    return v0
.end method

.method static synthetic access$2202(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;J)J
    .locals 0

    iput-wide p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->timestamp_:J

    return-wide p1
.end method

.method static synthetic access$2302(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->program_:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic access$2402(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->source_:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic access$2500(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$2502(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;Ljava/util/List;)Ljava/util/List;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$2602(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;I)I
    .locals 0

    iput p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

    return p1
.end method

.method static synthetic access$2700()Z
    .locals 1

    sget-boolean v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->alwaysUseFieldBuilders:Z

    return v0
.end method

.method public static getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    return-object v0
.end method

.method public static final getDescriptor()Lcom/google/protobuf/Descriptors$Descriptor;
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricEntryMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$1500()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v0

    return-object v0
.end method

.method private getProgramBytes()Lcom/google/protobuf/ByteString;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->program_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/google/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->program_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Lcom/google/protobuf/ByteString;

    goto :goto_0
.end method

.method private getSourceBytes()Lcom/google/protobuf/ByteString;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->source_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/google/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->source_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Lcom/google/protobuf/ByteString;

    goto :goto_0
.end method

.method private initFields()V
    .locals 2

    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->timestamp_:J

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->program_:Ljava/lang/Object;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->source_:Ljava/lang/Object;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    return-void
.end method

.method public static newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1800()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public static newBuilder(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeDelimitedFrom(Ljava/io/InputStream;)Z

    move-result v1

    if-eqz v1, :cond_0

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Z

    move-result v1

    if-eqz v1, :cond_0

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Ljava/io/InputStream;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom([B)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom([B)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->mergeFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;->access$1700(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getDataPoint(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    return-object v0
.end method

.method public getDataPointCount()I
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
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

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    return-object v0
.end method

.method public getDataPointOrBuilder(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessageOrBuilder;

    return-object v0
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

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    return-object v0
.end method

.method public getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v0

    return-object v0
.end method

.method public getProgram()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->program_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0}, Lcom/google/protobuf/Internal;->isValidUtf8(Lcom/google/protobuf/ByteString;)Z

    move-result v0

    if-eqz v0, :cond_1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->program_:Ljava/lang/Object;

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public getSerializedSize()I
    .locals 7

    const/4 v6, 0x4

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v1, 0x0

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedSerializedSize:I

    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x1

    if-ne v0, v4, :cond_4

    iget-wide v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->timestamp_:J

    invoke-static {v4, v2, v3}, Lcom/google/protobuf/CodedOutputStream;->computeInt64Size(IJ)I

    move-result v0

    add-int/2addr v0, v1

    :goto_1
    iget v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

    and-int/lit8 v2, v2, 0x2

    if-ne v2, v5, :cond_1

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getProgramBytes()Lcom/google/protobuf/ByteString;

    move-result-object v2

    invoke-static {v5, v2}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v2

    add-int/2addr v0, v2

    :cond_1
    iget v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

    and-int/lit8 v2, v2, 0x4

    if-ne v2, v6, :cond_2

    const/4 v2, 0x3

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getSourceBytes()Lcom/google/protobuf/ByteString;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v2

    add-int/2addr v0, v2

    :cond_2
    move v2, v0

    :goto_2
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/MessageLite;

    invoke-static {v6, v0}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v0

    add-int/2addr v0, v2

    add-int/lit8 v1, v1, 0x1

    move v2, v0

    goto :goto_2

    :cond_3
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/UnknownFieldSet;->getSerializedSize()I

    move-result v0

    add-int/2addr v0, v2

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedSerializedSize:I

    goto :goto_0

    :cond_4
    move v0, v1

    goto :goto_1
.end method

.method public getSource()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->source_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Lcom/google/protobuf/ByteString;

    invoke-virtual {v0}, Lcom/google/protobuf/ByteString;->toStringUtf8()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0}, Lcom/google/protobuf/Internal;->isValidUtf8(Lcom/google/protobuf/ByteString;)Z

    move-result v0

    if-eqz v0, :cond_1

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->source_:Ljava/lang/Object;

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public getTimestamp()J
    .locals 2

    iget-wide v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->timestamp_:J

    return-wide v0
.end method

.method public hasProgram()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

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

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

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

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

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
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-byte v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    const/4 v3, -0x1

    if-eq v2, v3, :cond_1

    if-ne v2, v0, :cond_0

    :goto_0
    move v1, v0

    :goto_1
    return v1

    :cond_0
    move v0, v1

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->hasTimestamp()Z

    move-result v2

    if-nez v2, :cond_2

    iput-byte v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    goto :goto_1

    :cond_2
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->hasProgram()Z

    move-result v2

    if-nez v2, :cond_3

    iput-byte v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    goto :goto_1

    :cond_3
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->hasSource()Z

    move-result v2

    if-nez v2, :cond_4

    iput-byte v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    goto :goto_1

    :cond_4
    move v2, v1

    :goto_2
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDataPointCount()I

    move-result v3

    if-ge v2, v3, :cond_6

    invoke-virtual {p0, v2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getDataPoint(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;->isInitialized()Z

    move-result v3

    if-nez v3, :cond_5

    iput-byte v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    goto :goto_1

    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    :cond_6
    iput-byte v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->memoizedIsInitialized:B

    move v1, v0

    goto :goto_1
.end method

.method public newBuilderForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected newBuilderForType(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 2

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;-><init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V

    return-object v0
.end method

.method public bridge synthetic newBuilderForType()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilderForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic newBuilderForType(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilderForType(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic newBuilderForType()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilderForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public toBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;
    .locals 1

    invoke-static {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->newBuilder(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic toBuilder()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->toBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic toBuilder()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->toBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected writeReplace()Ljava/lang/Object;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/ObjectStreamException;
        }
    .end annotation

    invoke-super {p0}, Lcom/google/protobuf/GeneratedMessage;->writeReplace()Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public writeTo(Lcom/google/protobuf/CodedOutputStream;)V
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    const/4 v4, 0x4

    const/4 v3, 0x2

    const/4 v2, 0x1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getSerializedSize()I

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x1

    if-ne v0, v2, :cond_0

    iget-wide v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->timestamp_:J

    invoke-virtual {p1, v2, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeInt64(IJ)V

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x2

    if-ne v0, v3, :cond_1

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getProgramBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    invoke-virtual {p1, v3, v0}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_1
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x4

    if-ne v0, v4, :cond_2

    const/4 v0, 0x3

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getSourceBytes()Lcom/google/protobuf/ByteString;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_2
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->dataPoint_:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/MessageLite;

    invoke-virtual {p1, v4, v0}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_3
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/protobuf/UnknownFieldSet;->writeTo(Lcom/google/protobuf/CodedOutputStream;)V

    return-void
.end method
