.class public final Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
.super Lcom/google/protobuf/GeneratedMessage;

# interfaces
.implements Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessageOrBuilder;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x19
    name = "MetricBatchMessage"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    }
.end annotation


# static fields
.field public static final DEVICESERIALNUMBER_FIELD_NUMBER:I = 0x1

.field public static final DEVICETYPE_FIELD_NUMBER:I = 0x2

.field public static final METADATA_FIELD_NUMBER:I = 0x4

.field public static final METRICENTRY_FIELD_NUMBER:I = 0x5

.field public static final TAG_FIELD_NUMBER:I = 0x3

.field private static final defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

.field private static final serialVersionUID:J


# instance fields
.field private bitField0_:I

.field private deviceSerialNumber_:Ljava/lang/Object;

.field private deviceType_:Ljava/lang/Object;

.field private memoizedIsInitialized:B

.field private memoizedSerializedSize:I

.field private metadata_:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;",
            ">;"
        }
    .end annotation
.end field

.field private metricEntry_:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;",
            ">;"
        }
    .end annotation
.end field

.field private tag_:Ljava/lang/Object;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;-><init>(Z)V

    sput-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    invoke-direct {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->initFields()V

    return-void
.end method

.method private constructor <init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)V
    .locals 1

    const/4 v0, -0x1

    invoke-direct {p0, p1}, Lcom/google/protobuf/GeneratedMessage;-><init>(Lcom/google/protobuf/GeneratedMessage$Builder;)V

    iput-byte v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedIsInitialized:B

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedSerializedSize:I

    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V
    .locals 0

    invoke-direct {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;-><init>(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)V

    return-void
.end method

.method private constructor <init>(Z)V
    .locals 1

    const/4 v0, -0x1

    invoke-direct {p0}, Lcom/google/protobuf/GeneratedMessage;-><init>()V

    iput-byte v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedIsInitialized:B

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedSerializedSize:I

    return-void
.end method

.method static synthetic access$1000(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1002(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;Ljava/util/List;)Ljava/util/List;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1100(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;)Ljava/util/List;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;Ljava/util/List;)Ljava/util/List;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1202(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;I)I
    .locals 0

    iput p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    return p1
.end method

.method static synthetic access$1300()Z
    .locals 1

    sget-boolean v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->alwaysUseFieldBuilders:Z

    return v0
.end method

.method static synthetic access$1400()Z
    .locals 1

    sget-boolean v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->alwaysUseFieldBuilders:Z

    return v0
.end method

.method static synthetic access$500()Z
    .locals 1

    sget-boolean v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->alwaysUseFieldBuilders:Z

    return v0
.end method

.method static synthetic access$702(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceSerialNumber_:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic access$802(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceType_:Ljava/lang/Object;

    return-object p1
.end method

.method static synthetic access$902(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;Ljava/lang/Object;)Ljava/lang/Object;
    .locals 0

    iput-object p1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->tag_:Ljava/lang/Object;

    return-object p1
.end method

.method public static getDefaultInstance()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    return-object v0
.end method

.method public static final getDescriptor()Lcom/google/protobuf/Descriptors$Descriptor;
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricBatchMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$000()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v0

    return-object v0
.end method

.method private getDeviceSerialNumberBytes()Lcom/google/protobuf/ByteString;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceSerialNumber_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/google/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceSerialNumber_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Lcom/google/protobuf/ByteString;

    goto :goto_0
.end method

.method private getDeviceTypeBytes()Lcom/google/protobuf/ByteString;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceType_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/google/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceType_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Lcom/google/protobuf/ByteString;

    goto :goto_0
.end method

.method private getTagBytes()Lcom/google/protobuf/ByteString;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->tag_:Ljava/lang/Object;

    instance-of v1, v0, Ljava/lang/String;

    if-eqz v1, :cond_0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/google/protobuf/ByteString;->copyFromUtf8(Ljava/lang/String;)Lcom/google/protobuf/ByteString;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->tag_:Ljava/lang/Object;

    :goto_0
    return-object v0

    :cond_0
    check-cast v0, Lcom/google/protobuf/ByteString;

    goto :goto_0
.end method

.method private initFields()V
    .locals 1

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceSerialNumber_:Ljava/lang/Object;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceType_:Ljava/lang/Object;

    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->tag_:Ljava/lang/Object;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-static {}, Ljava/util/Collections;->emptyList()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    return-void
.end method

.method public static newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    .locals 1

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->create()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$300()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public static newBuilder(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeDelimitedFrom(Ljava/io/InputStream;)Z

    move-result v1

    if-eqz v1, :cond_0

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static parseDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeDelimitedFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Z

    move-result v1

    if-eqz v1, :cond_0

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom(Lcom/google/protobuf/ByteString;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom(Lcom/google/protobuf/ByteString;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom(Lcom/google/protobuf/CodedInputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom(Ljava/io/InputStream;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom(Ljava/io/InputStream;Lcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom([B)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom([B)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public static parseFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/google/protobuf/InvalidProtocolBufferException;
        }
    .end annotation

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    invoke-virtual {v0, p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->mergeFrom([BLcom/google/protobuf/ExtensionRegistryLite;)Lcom/google/protobuf/AbstractMessage$Builder;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    # invokes: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->buildParsed()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;->access$200(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;
    .locals 1

    sget-object v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->defaultInstance:Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/Message;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic getDefaultInstanceForType()Lcom/google/protobuf/MessageLite;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getDefaultInstanceForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    move-result-object v0

    return-object v0
.end method

.method public getDeviceSerialNumber()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceSerialNumber_:Ljava/lang/Object;

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

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceSerialNumber_:Ljava/lang/Object;

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public getDeviceType()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceType_:Ljava/lang/Object;

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

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->deviceType_:Ljava/lang/Object;

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public getMetadata(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;

    return-object v0
.end method

.method public getMetadataCount()I
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getMetadataList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    return-object v0
.end method

.method public getMetadataOrBuilder(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValueOrBuilder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValueOrBuilder;

    return-object v0
.end method

.method public getMetadataOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<+",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValueOrBuilder;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    return-object v0
.end method

.method public getMetricEntry(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    return-object v0
.end method

.method public getMetricEntryCount()I
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getMetricEntryList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    return-object v0
.end method

.method public getMetricEntryOrBuilder(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessageOrBuilder;
    .locals 1

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessageOrBuilder;

    return-object v0
.end method

.method public getMetricEntryOrBuilderList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<+",
            "Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessageOrBuilder;",
            ">;"
        }
    .end annotation

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    return-object v0
.end method

.method public getSerializedSize()I
    .locals 6

    const/4 v5, 0x4

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v1, 0x0

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedSerializedSize:I

    const/4 v2, -0x1

    if-eq v0, v2, :cond_0

    :goto_0
    return v0

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x1

    if-ne v0, v3, :cond_5

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getDeviceSerialNumberBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v0

    add-int/2addr v0, v1

    :goto_1
    iget v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    and-int/lit8 v2, v2, 0x2

    if-ne v2, v4, :cond_1

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getDeviceTypeBytes()Lcom/google/protobuf/ByteString;

    move-result-object v2

    invoke-static {v4, v2}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v2

    add-int/2addr v0, v2

    :cond_1
    iget v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    and-int/lit8 v2, v2, 0x4

    if-ne v2, v5, :cond_2

    const/4 v2, 0x3

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getTagBytes()Lcom/google/protobuf/ByteString;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/google/protobuf/CodedOutputStream;->computeBytesSize(ILcom/google/protobuf/ByteString;)I

    move-result v2

    add-int/2addr v0, v2

    :cond_2
    move v2, v1

    move v3, v0

    :goto_2
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v2, v0, :cond_3

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/MessageLite;

    invoke-static {v5, v0}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v0

    add-int/2addr v3, v0

    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_2

    :cond_3
    :goto_3
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_4

    const/4 v2, 0x5

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/MessageLite;

    invoke-static {v2, v0}, Lcom/google/protobuf/CodedOutputStream;->computeMessageSize(ILcom/google/protobuf/MessageLite;)I

    move-result v0

    add-int/2addr v3, v0

    add-int/lit8 v1, v1, 0x1

    goto :goto_3

    :cond_4
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/UnknownFieldSet;->getSerializedSize()I

    move-result v0

    add-int/2addr v0, v3

    iput v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedSerializedSize:I

    goto :goto_0

    :cond_5
    move v0, v1

    goto :goto_1
.end method

.method public getTag()Ljava/lang/String;
    .locals 2

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->tag_:Ljava/lang/Object;

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

    iput-object v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->tag_:Ljava/lang/Object;

    :cond_1
    move-object v0, v1

    goto :goto_0
.end method

.method public hasDeviceSerialNumber()Z
    .locals 2

    const/4 v0, 0x1

    iget v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    and-int/lit8 v1, v1, 0x1

    if-ne v1, v0, :cond_0

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public hasDeviceType()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

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

.method public hasTag()Z
    .locals 2

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

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

.method protected internalGetFieldAccessorTable()Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    .locals 1

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricBatchMessage_fieldAccessorTable:Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$100()Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    move-result-object v0

    return-object v0
.end method

.method public final isInitialized()Z
    .locals 4

    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-byte v2, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedIsInitialized:B

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
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->hasDeviceSerialNumber()Z

    move-result v2

    if-nez v2, :cond_2

    iput-byte v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedIsInitialized:B

    goto :goto_1

    :cond_2
    move v2, v1

    :goto_2
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getMetadataCount()I

    move-result v3

    if-ge v2, v3, :cond_4

    invoke-virtual {p0, v2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getMetadata(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;->isInitialized()Z

    move-result v3

    if-nez v3, :cond_3

    iput-byte v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedIsInitialized:B

    goto :goto_1

    :cond_3
    add-int/lit8 v2, v2, 0x1

    goto :goto_2

    :cond_4
    move v2, v1

    :goto_3
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getMetricEntryCount()I

    move-result v3

    if-ge v2, v3, :cond_6

    invoke-virtual {p0, v2}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getMetricEntry(I)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;->isInitialized()Z

    move-result v3

    if-nez v3, :cond_5

    iput-byte v1, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedIsInitialized:B

    goto :goto_1

    :cond_5
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    :cond_6
    iput-byte v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->memoizedIsInitialized:B

    move v1, v0

    goto :goto_1
.end method

.method public newBuilderForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    .locals 1

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected newBuilderForType(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    .locals 2

    new-instance v0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    const/4 v1, 0x0

    invoke-direct {v0, p1, v1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;-><init>(Lcom/google/protobuf/GeneratedMessage$BuilderParent;Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;)V

    return-object v0
.end method

.method public bridge synthetic newBuilderForType()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilderForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method protected bridge synthetic newBuilderForType(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilderForType(Lcom/google/protobuf/GeneratedMessage$BuilderParent;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic newBuilderForType()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilderForType()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public toBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;
    .locals 1

    invoke-static {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->newBuilder(Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;)Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic toBuilder()Lcom/google/protobuf/Message$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->toBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    move-result-object v0

    return-object v0
.end method

.method public bridge synthetic toBuilder()Lcom/google/protobuf/MessageLite$Builder;
    .locals 1

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->toBuilder()Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

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

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getSerializedSize()I

    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x1

    if-ne v0, v1, :cond_0

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getDeviceSerialNumberBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    invoke-virtual {p1, v1, v0}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_0
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x2

    if-ne v0, v3, :cond_1

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getDeviceTypeBytes()Lcom/google/protobuf/ByteString;

    move-result-object v0

    invoke-virtual {p1, v3, v0}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_1
    iget v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->bitField0_:I

    and-int/lit8 v0, v0, 0x4

    if-ne v0, v4, :cond_2

    const/4 v0, 0x3

    invoke-direct {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getTagBytes()Lcom/google/protobuf/ByteString;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Lcom/google/protobuf/CodedOutputStream;->writeBytes(ILcom/google/protobuf/ByteString;)V

    :cond_2
    move v1, v2

    :goto_0
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_3

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metadata_:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/MessageLite;

    invoke-virtual {p1, v4, v0}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    :cond_3
    :goto_1
    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v2, v0, :cond_4

    const/4 v1, 0x5

    iget-object v0, p0, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->metricEntry_:Ljava/util/List;

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/MessageLite;

    invoke-virtual {p1, v1, v0}, Lcom/google/protobuf/CodedOutputStream;->writeMessage(ILcom/google/protobuf/MessageLite;)V

    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    :cond_4
    invoke-virtual {p0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;->getUnknownFields()Lcom/google/protobuf/UnknownFieldSet;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/google/protobuf/UnknownFieldSet;->writeTo(Lcom/google/protobuf/CodedOutputStream;)V

    return-void
.end method
