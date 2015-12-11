.class public Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;
.super Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;
.source "UrgentBatchTransmitter.java"

# interfaces
.implements Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;
.implements Lcom/amazon/client/metrics/transport/TransportStateNotifier$TransportWarmedListener;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:UrgentBatchTransmitter"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;J)V
    .locals 2
    .param p1, "byteArrayQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .param p2, "metricsTransport"    # Lcom/amazon/client/metrics/transport/MetricsTransport;
    .param p3, "uploadResultBroadcaster"    # Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    .param p4, "batchPipelineConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .param p5, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;
    .param p6, "initialTransmissionPeriodMillis"    # J

    .prologue
    .line 39
    invoke-direct/range {p0 .. p7}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;-><init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;J)V

    .line 41
    instance-of v0, p2, Lcom/amazon/client/metrics/transport/TransportStateNotifier;

    if-eqz v0, :cond_0

    .line 42
    check-cast p2, Lcom/amazon/client/metrics/transport/TransportStateNotifier;

    .end local p2    # "metricsTransport":Lcom/amazon/client/metrics/transport/MetricsTransport;
    invoke-interface {p2, p0}, Lcom/amazon/client/metrics/transport/TransportStateNotifier;->listenForTransportWarmed(Lcom/amazon/client/metrics/transport/TransportStateNotifier$TransportWarmedListener;)V

    .line 46
    invoke-interface {p1, p0}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;->addListener(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;)V

    .line 47
    return-void

    .line 44
    .restart local p2    # "metricsTransport":Lcom/amazon/client/metrics/transport/MetricsTransport;
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Unsupported MetricsTransport. TransportStateNotifier expected."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
.end method


# virtual methods
.method public notifyTransportWarmed()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 55
    sget-object v0, Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "notifyTransportWarmed"

    const-string/jumbo v2, "Notified that the transport is warm. Attempting to send batches."

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 56
    invoke-virtual {p0, v4}, Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;->transmitBatches(Z)V

    .line 57
    return-void
.end method

.method public onInsert(JJ)V
    .locals 5
    .param p1, "numQueueElements"    # J
    .param p3, "queueSizeBytes"    # J

    .prologue
    const/4 v4, 0x0

    .line 65
    sget-object v0, Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "onInsert"

    const-string/jumbo v2, "attempting transmission of batches"

    new-array v3, v4, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 66
    invoke-virtual {p0, v4}, Lcom/amazon/client/metrics/batch/transmitter/UrgentBatchTransmitter;->transmitBatches(Z)V

    .line 67
    return-void
.end method
