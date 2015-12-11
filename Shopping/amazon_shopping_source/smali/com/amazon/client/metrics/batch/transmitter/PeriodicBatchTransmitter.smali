.class public Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;
.super Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;
.source "PeriodicBatchTransmitter.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;
    }
.end annotation


# static fields
.field private static final THREAD_POOL_TERMINATION_WAIT_MS:I = 0x1388

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

.field private mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

.field private mTransmitter:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 41
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "PeriodicBatchTransmitter"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;J)V
    .locals 0
    .param p1, "byteArrayQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .param p2, "metricsTransport"    # Lcom/amazon/client/metrics/transport/MetricsTransport;
    .param p3, "uploadResultBroadcaster"    # Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;
    .param p4, "batchPipelineConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .param p5, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;
    .param p6, "initialTransmissionPeriodMillis"    # J

    .prologue
    .line 53
    invoke-direct {p0, p1, p2, p3, p5}, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;-><init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/transport/MetricsTransport;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V

    .line 54
    iput-object p4, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    .line 55
    invoke-direct {p0, p6, p7}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->createScheduledThreadPoolExecutor(J)V

    .line 56
    return-void
.end method

.method static synthetic access$000()Lcom/amazon/dp/logger/DPLogger;
    .locals 1

    .prologue
    .line 39
    sget-object v0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;)Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mTransmitter:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;)Ljava/util/concurrent/ScheduledThreadPoolExecutor;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;

    .prologue
    .line 39
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    return-object v0
.end method

.method private createScheduledThreadPoolExecutor(J)V
    .locals 4
    .param p1, "initialTransmissionPeriodMillis"    # J

    .prologue
    .line 59
    const/4 v0, 0x1

    .line 60
    .local v0, "coreThreadPoolSize":I
    new-instance v1, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const/4 v2, 0x1

    new-instance v3, Lcom/amazon/device/utils/BackgroundThreadFactory;

    invoke-direct {v3}, Lcom/amazon/device/utils/BackgroundThreadFactory;-><init>()V

    invoke-direct {v1, v2, v3}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;-><init>(ILjava/util/concurrent/ThreadFactory;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    .line 61
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    new-instance v2, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;

    invoke-direct {v2}, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;-><init>()V

    invoke-virtual {v1, v2}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->setRejectedExecutionHandler(Ljava/util/concurrent/RejectedExecutionHandler;)V

    .line 62
    new-instance v1, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;

    invoke-direct {v1, p0}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;-><init>(Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;)V

    iput-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mTransmitter:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;

    .line 63
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mTransmitter:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;

    sget-object v3, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, p1, p2, v3}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->schedule(Ljava/lang/Runnable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 64
    return-void
.end method


# virtual methods
.method public shutdown()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 100
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mTransmitter:Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter$Transmitter;->shutdown()V

    .line 101
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {v1}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->shutdown()V

    .line 103
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 104
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {v1}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 106
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->mScheduledExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 107
    sget-object v1, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool did not terminate."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    .line 115
    :cond_0
    :goto_0
    invoke-super {p0}, Lcom/amazon/client/metrics/batch/transmitter/ThreadPoolBatchTransmitter;->shutdown()V

    .line 116
    return-void

    .line 110
    :catch_0
    move-exception v0

    .line 111
    .local v0, "e":Ljava/lang/InterruptedException;
    sget-object v1, Lcom/amazon/client/metrics/batch/transmitter/PeriodicBatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool interrupted on shutdown."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 112
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V

    goto :goto_0
.end method
