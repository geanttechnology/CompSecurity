.class final Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$1;
.super Ljava/lang/Object;

# interfaces
.implements Lcom/google/protobuf/Descriptors$FileDescriptor$InternalDescriptorAssigner;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public assignDescriptors(Lcom/google/protobuf/Descriptors$FileDescriptor;)Lcom/google/protobuf/ExtensionRegistry;
    .locals 10

    const/4 v9, 0x4

    const/4 v8, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->descriptor:Lcom/google/protobuf/Descriptors$FileDescriptor;
    invoke-static {p1}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$5002(Lcom/google/protobuf/Descriptors$FileDescriptor;)Lcom/google/protobuf/Descriptors$FileDescriptor;

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->getDescriptor()Lcom/google/protobuf/Descriptors$FileDescriptor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/Descriptors$FileDescriptor;->getMessageTypes()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/Descriptors$Descriptor;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricBatchMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$002(Lcom/google/protobuf/Descriptors$Descriptor;)Lcom/google/protobuf/Descriptors$Descriptor;

    new-instance v0, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricBatchMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$000()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v1

    const/4 v2, 0x5

    new-array v2, v2, [Ljava/lang/String;

    const-string/jumbo v3, "DeviceSerialNumber"

    aput-object v3, v2, v5

    const-string/jumbo v3, "DeviceType"

    aput-object v3, v2, v6

    const-string/jumbo v3, "Tag"

    aput-object v3, v2, v7

    const-string/jumbo v3, "Metadata"

    aput-object v3, v2, v8

    const-string/jumbo v3, "MetricEntry"

    aput-object v3, v2, v9

    const-class v3, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage;

    const-class v4, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricBatchMessage$Builder;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;-><init>(Lcom/google/protobuf/Descriptors$Descriptor;[Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricBatchMessage_fieldAccessorTable:Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$102(Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;)Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->getDescriptor()Lcom/google/protobuf/Descriptors$FileDescriptor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/Descriptors$FileDescriptor;->getMessageTypes()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/Descriptors$Descriptor;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricEntryMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$1502(Lcom/google/protobuf/Descriptors$Descriptor;)Lcom/google/protobuf/Descriptors$Descriptor;

    new-instance v0, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricEntryMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$1500()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v1

    new-array v2, v9, [Ljava/lang/String;

    const-string/jumbo v3, "Timestamp"

    aput-object v3, v2, v5

    const-string/jumbo v3, "Program"

    aput-object v3, v2, v6

    const-string/jumbo v3, "Source"

    aput-object v3, v2, v7

    const-string/jumbo v3, "DataPoint"

    aput-object v3, v2, v8

    const-class v3, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage;

    const-class v4, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$MetricEntryMessage$Builder;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;-><init>(Lcom/google/protobuf/Descriptors$Descriptor;[Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_MetricEntryMessage_fieldAccessorTable:Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$1602(Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;)Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->getDescriptor()Lcom/google/protobuf/Descriptors$FileDescriptor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/Descriptors$FileDescriptor;->getMessageTypes()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/Descriptors$Descriptor;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_DataPointMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$2802(Lcom/google/protobuf/Descriptors$Descriptor;)Lcom/google/protobuf/Descriptors$Descriptor;

    new-instance v0, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_DataPointMessage_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$2800()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v1

    new-array v2, v9, [Ljava/lang/String;

    const-string/jumbo v3, "Name"

    aput-object v3, v2, v5

    const-string/jumbo v3, "Value"

    aput-object v3, v2, v6

    const-string/jumbo v3, "SampleSize"

    aput-object v3, v2, v7

    const-string/jumbo v3, "Type"

    aput-object v3, v2, v8

    const-class v3, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage;

    const-class v4, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$DataPointMessage$Builder;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;-><init>(Lcom/google/protobuf/Descriptors$Descriptor;[Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_DataPointMessage_fieldAccessorTable:Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$2902(Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;)Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->getDescriptor()Lcom/google/protobuf/Descriptors$FileDescriptor;

    move-result-object v0

    invoke-virtual {v0}, Lcom/google/protobuf/Descriptors$FileDescriptor;->getMessageTypes()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v8}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/protobuf/Descriptors$Descriptor;

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_KeyValue_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$4002(Lcom/google/protobuf/Descriptors$Descriptor;)Lcom/google/protobuf/Descriptors$Descriptor;

    new-instance v0, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    # getter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_KeyValue_descriptor:Lcom/google/protobuf/Descriptors$Descriptor;
    invoke-static {}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$4000()Lcom/google/protobuf/Descriptors$Descriptor;

    move-result-object v1

    new-array v2, v7, [Ljava/lang/String;

    const-string/jumbo v3, "Key"

    aput-object v3, v2, v5

    const-string/jumbo v3, "Value"

    aput-object v3, v2, v6

    const-class v3, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue;

    const-class v4, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage$KeyValue$Builder;

    invoke-direct {v0, v1, v2, v3, v4}, Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;-><init>(Lcom/google/protobuf/Descriptors$Descriptor;[Ljava/lang/String;Ljava/lang/Class;Ljava/lang/Class;)V

    # setter for: Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->internal_static_metrics_KeyValue_fieldAccessorTable:Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;
    invoke-static {v0}, Lcom/amazon/client/metrics/codec/DeviceMetricsMessage;->access$4102(Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;)Lcom/google/protobuf/GeneratedMessage$FieldAccessorTable;

    const/4 v0, 0x0

    return-object v0
.end method
