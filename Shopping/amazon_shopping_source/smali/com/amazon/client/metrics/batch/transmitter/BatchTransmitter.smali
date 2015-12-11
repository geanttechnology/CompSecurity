.class public abstract Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
.super Ljava/lang/Object;
.source "BatchTransmitter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;
    }
.end annotation


# static fields
.field private static final NULL_METRIC_EVENT:Lcom/amazon/client/metrics/MetricEvent;

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected final mByteArrayQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

.field protected final mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

.field final mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

.field protected final mQueuePusher:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 38
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:BatchTransmitter"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    .line 39
    new-instance v0, Lcom/amazon/client/metrics/NullMetricEvent;

    const-string/jumbo v1, "MetricsService"

    const-string/jumbo v2, "BatchTransmitter"

    invoke-direct {v0, v1, v2}, Lcom/amazon/client/metrics/NullMetricEvent;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->NULL_METRIC_EVENT:Lcom/amazon/client/metrics/MetricEvent;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V
    .locals 2
    .param p1, "byteArrayQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .param p2, "metricsTransport"    # Lcom/amazon/client/metrics/transport/MetricsTransport;
    .param p3, "uploadResultBroadcaster"    # Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    .param p4, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mByteArrayQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    .line 59
    iput-object p2, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    .line 60
    new-instance v0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;

    invoke-direct {v0, p0, p3}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;-><init>(Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mQueuePusher:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;

    .line 62
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mByteArrayQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    if-nez v0, :cond_0

    .line 63
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Byte array queue cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 66
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    if-nez v0, :cond_1

    .line 67
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Metrics transport instance cannot be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 69
    :cond_1
    iput-object p4, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .line 70
    return-void
.end method

.method static synthetic access$000()Lcom/amazon/dp/logger/DPLogger;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    return-object v0
.end method

.method static synthetic access$100()Lcom/amazon/client/metrics/MetricEvent;
    .locals 1

    .prologue
    .line 36
    sget-object v0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->NULL_METRIC_EVENT:Lcom/amazon/client/metrics/MetricEvent;

    return-object v0
.end method


# virtual methods
.method public shutdown()V
    .locals 1

    .prologue
    .line 77
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mQueuePusher:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->shutdown()V

    .line 78
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mByteArrayQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    invoke-interface {v0}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;->shutdown()V

    .line 79
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    invoke-interface {v0}, Lcom/amazon/client/metrics/transport/MetricsTransport;->shutdown()V

    .line 80
    return-void
.end method

.method public abstract transmitBatches(Z)V
.end method
