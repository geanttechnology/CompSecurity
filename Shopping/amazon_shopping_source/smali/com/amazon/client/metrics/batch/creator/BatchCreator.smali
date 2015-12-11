.class public Lcom/amazon/client/metrics/batch/creator/BatchCreator;
.super Ljava/lang/Object;
.source "BatchCreator.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/batch/creator/BatchCreator$1;,
        Lcom/amazon/client/metrics/batch/creator/BatchCreator$BatchOpenTimeWatcher;
    }
.end annotation


# static fields
.field private static final BATCH_COUNT:Ljava/lang/String; = "BATCH_COUNT"

.field private static final BATCH_ENQUEUED:Ljava/lang/String; = "BATCH_ENQUEUED"

.field private static final BATCH_OPEN_TIME:Ljava/lang/String; = "BATCH_OPEN_TIME"

.field private static final BATCH_SIZE:Ljava/lang/String; = "BATCH_SIZE"

.field private static final THREAD_POOL_TERMINATION_WAIT_MS:I = 0x1388

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mBatchOpenTimeWatcher:Lcom/amazon/client/metrics/batch/creator/BatchCreator$BatchOpenTimeWatcher;

.field private final mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

.field private final mBatchQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

.field private final mDeviceInfoManager:Lcom/amazon/client/metrics/DeviceInfoManager;

.field private final mMetricBatchCodec:Lcom/amazon/client/metrics/codec/MetricBatchCodec;

.field private final mMetricEntryCodec:Lcom/amazon/client/metrics/codec/MetricEntryCodec;

.field private final mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

.field private mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

.field protected final mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

.field private final mTimeSinceLastPublish:Ljava/util/concurrent/atomic/AtomicLong;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 52
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:BatchCreator"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;Lcom/amazon/client/metrics/codec/MetricBatchCodec;Lcom/amazon/client/metrics/codec/MetricEntryCodec;Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Lcom/amazon/client/metrics/DeviceInfoManager;)V
    .locals 3
    .param p1, "batchQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;
    .param p2, "batchCodec"    # Lcom/amazon/client/metrics/codec/MetricBatchCodec;
    .param p3, "entryCodec"    # Lcom/amazon/client/metrics/codec/MetricEntryCodec;
    .param p4, "batchPipelineConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .param p5, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;
    .param p6, "deviceInfoManager"    # Lcom/amazon/client/metrics/DeviceInfoManager;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/dp/framework/CodecException;
        }
    .end annotation

    .prologue
    .line 73
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 60
    new-instance v0, Lcom/amazon/client/metrics/batch/creator/BatchCreator$BatchOpenTimeWatcher;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/client/metrics/batch/creator/BatchCreator$BatchOpenTimeWatcher;-><init>(Lcom/amazon/client/metrics/batch/creator/BatchCreator;Lcom/amazon/client/metrics/batch/creator/BatchCreator$1;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchOpenTimeWatcher:Lcom/amazon/client/metrics/batch/creator/BatchCreator$BatchOpenTimeWatcher;

    .line 67
    new-instance v0, Lcom/amazon/device/utils/BackgroundThreadFactory;

    invoke-direct {v0}, Lcom/amazon/device/utils/BackgroundThreadFactory;-><init>()V

    invoke-static {v0}, Ljava/util/concurrent/Executors;->newSingleThreadScheduledExecutor(Ljava/util/concurrent/ThreadFactory;)Ljava/util/concurrent/ScheduledExecutorService;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    .line 75
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    .line 76
    iput-object p2, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mMetricBatchCodec:Lcom/amazon/client/metrics/codec/MetricBatchCodec;

    .line 77
    iput-object p3, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mMetricEntryCodec:Lcom/amazon/client/metrics/codec/MetricEntryCodec;

    .line 78
    iput-object p4, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    .line 79
    new-instance v0, Ljava/util/concurrent/atomic/AtomicLong;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicLong;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mTimeSinceLastPublish:Ljava/util/concurrent/atomic/AtomicLong;

    .line 80
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mTimeSinceLastPublish:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V

    .line 81
    iput-object p6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mDeviceInfoManager:Lcom/amazon/client/metrics/DeviceInfoManager;

    .line 88
    new-instance v0, Lcom/amazon/client/metrics/MetricBatch;

    invoke-direct {v0}, Lcom/amazon/client/metrics/MetricBatch;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    .line 90
    iput-object p5, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .line 92
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->scheduleBatchOpenTimeWatcher()V

    .line 93
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/client/metrics/batch/creator/BatchCreator;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->checkBatchOpenTimeAndEnqueueIfReady()V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/client/metrics/batch/creator/BatchCreator;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/client/metrics/batch/creator/BatchCreator;

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->scheduleBatchOpenTimeWatcher()V

    return-void
.end method

.method private declared-synchronized checkBatchOpenTimeAndEnqueueIfReady()V
    .locals 1

    .prologue
    .line 257
    monitor-enter p0

    :try_start_0
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->maxBatchOpenTimeReached()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/MetricBatch;->containsUserMetrics()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->enqueueBatchForTransmission()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 260
    :cond_0
    monitor-exit p0

    return-void

    .line 257
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private maxBatchCountReached()Z
    .locals 4

    .prologue
    .line 238
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntryCount()I

    move-result v0

    int-to-long v0, v0

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxNumEntriesPerBatch()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private maxBatchOpenTimeReached()Z
    .locals 6

    .prologue
    .line 246
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    .line 247
    .local v2, "now":J
    iget-object v4, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mTimeSinceLastPublish:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v4}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v4

    sub-long v0, v2, v4

    .line 248
    .local v0, "elapsedTime":J
    iget-object v4, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxBatchOpenTimeMillis()J

    move-result-wide v4

    cmp-long v4, v0, v4

    if-ltz v4, :cond_0

    const/4 v4, 0x1

    :goto_0
    return v4

    :cond_0
    const/4 v4, 0x0

    goto :goto_0
.end method

.method private scheduleBatchOpenTimeWatcher()V
    .locals 6

    .prologue
    .line 267
    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchOpenTimeWatcher:Lcom/amazon/client/metrics/batch/creator/BatchCreator$BatchOpenTimeWatcher;

    iget-object v3, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v3}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getCheckBatchOpenTimeMillis()J

    move-result-wide v3

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4, v5}, Ljava/util/concurrent/ScheduledExecutorService;->schedule(Ljava/util/concurrent/Callable;JLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;
    :try_end_0
    .catch Ljava/util/concurrent/RejectedExecutionException; {:try_start_0 .. :try_end_0} :catch_0

    .line 272
    return-void

    .line 268
    :catch_0
    move-exception v0

    .line 269
    .local v0, "e":Ljava/util/concurrent/RejectedExecutionException;
    sget-object v1, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "scheduleLastPublishTimeWatcher"

    const-string/jumbo v3, "Unexpected rejected execution exception while scheduling LastPublishTimeWatcher"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 270
    throw v0
.end method


# virtual methods
.method public declared-synchronized addMetricEntry(Lcom/amazon/client/metrics/MetricEntry;)V
    .locals 9
    .param p1, "metricEntry"    # Lcom/amazon/client/metrics/MetricEntry;

    .prologue
    .line 101
    monitor-enter p0

    if-nez p1, :cond_0

    .line 102
    :try_start_0
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "Cannot add null metric entry"

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 101
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 107
    :cond_0
    :try_start_1
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mMetricEntryCodec:Lcom/amazon/client/metrics/codec/MetricEntryCodec;

    invoke-interface {v3, p1}, Lcom/amazon/client/metrics/codec/MetricEntryCodec;->encode(Lcom/amazon/client/metrics/MetricEntry;)Lcom/amazon/client/metrics/codec/EncodedMetricEntry;

    move-result-object v2

    .line 108
    .local v2, "encodedMetricEntry":Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    if-eqz v2, :cond_1

    invoke-interface {v2}, Lcom/amazon/client/metrics/codec/EncodedMetricEntry;->getEncodedSize()I

    move-result v3

    if-nez v3, :cond_3

    .line 109
    :cond_1
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v4, "Metric entry serialized to null or nothing."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3
    :try_end_1
    .catch Lcom/dp/framework/CodecException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 125
    .end local v2    # "encodedMetricEntry":Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    :catch_0
    move-exception v0

    .line 126
    .local v0, "ce":Lcom/dp/framework/CodecException;
    :try_start_2
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v3}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v3

    const-string/jumbo v4, "addEntry.CodecException"

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    invoke-interface {v3, v4, v5, v6}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 127
    sget-object v3, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "add"

    const-string/jumbo v5, "Codec Exception while trying to add metric to batch."

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v0, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 132
    .end local v0    # "ce":Lcom/dp/framework/CodecException;
    :cond_2
    :goto_0
    monitor-exit p0

    return-void

    .line 112
    .restart local v2    # "encodedMetricEntry":Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    :cond_3
    :try_start_3
    sget-object v3, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "addMetricEntry"

    const-string/jumbo v5, "Adding metric entry"

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    const-string/jumbo v8, "metricEntry"

    aput-object v8, v6, v7

    const/4 v7, 0x1

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 113
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v3, v2}, Lcom/amazon/client/metrics/MetricBatch;->addEntry(Lcom/amazon/client/metrics/codec/EncodedMetricEntry;)V

    .line 117
    const-string/jumbo v3, "MetricsService"

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getProgram()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    const-string/jumbo v3, "RecordMetric"

    invoke-virtual {p1}, Lcom/amazon/client/metrics/MetricEntry;->getSource()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 118
    :cond_4
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/amazon/client/metrics/MetricBatch;->setContainsUserMetrics(Z)V

    .line 122
    :cond_5
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->maxBatchCountReached()Z

    move-result v3

    if-nez v3, :cond_6

    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->maxBatchSizeReached()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 123
    :cond_6
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->enqueueBatchForTransmission()V
    :try_end_3
    .catch Lcom/dp/framework/CodecException; {:try_start_3 .. :try_end_3} :catch_0
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 128
    .end local v2    # "encodedMetricEntry":Lcom/amazon/client/metrics/codec/EncodedMetricEntry;
    :catch_1
    move-exception v1

    .line 129
    .local v1, "e":Ljava/lang/Exception;
    :try_start_4
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v3}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v3

    const-string/jumbo v4, "addEntry.UnexpectedException"

    const-wide/high16 v5, 0x3ff0000000000000L    # 1.0

    invoke-interface {v3, v4, v5, v6}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 130
    sget-object v3, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v4, "add"

    const-string/jumbo v5, "Unexpected exception while trying to add metric to batch."

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    invoke-virtual {v3, v4, v5, v6}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0
.end method

.method public declared-synchronized enqueueBatchForTransmission()V
    .locals 12

    .prologue
    .line 166
    monitor-enter p0

    :try_start_0
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v6}, Lcom/amazon/client/metrics/MetricBatch;->getBatchSizeInBytes()J

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmp-long v6, v6, v8

    if-nez v6, :cond_0

    .line 167
    sget-object v6, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "enqueueBatchForTransmission"

    const-string/jumbo v8, "Metrics Batch is empty. Aborting enqueue operation."

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 224
    :goto_0
    monitor-exit p0

    return-void

    .line 172
    :cond_0
    :try_start_1
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->maxBatchCountReached()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 173
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueueReason.batchCount"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 185
    :goto_1
    :try_start_2
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mDeviceInfoManager:Lcom/amazon/client/metrics/DeviceInfoManager;

    invoke-interface {v6}, Lcom/amazon/client/metrics/DeviceInfoManager;->getDeviceInfo()Lcom/amazon/client/metrics/MetricsDeviceInfo;

    move-result-object v1

    .line 186
    .local v1, "deviceInfo":Lcom/amazon/client/metrics/MetricsDeviceInfo;
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/MetricsDeviceInfo;->getDeviceInfo()Ljava/util/Map;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/amazon/client/metrics/MetricBatch;->putMetricsDeviceInfo(Ljava/util/Map;)V

    .line 189
    sget-object v6, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "enqueueBatchForTransmission"

    const-string/jumbo v8, "Metrics Batch created. Adding to queue"

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 190
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mMetricBatchCodec:Lcom/amazon/client/metrics/codec/MetricBatchCodec;

    iget-object v7, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-interface {v6, v7}, Lcom/amazon/client/metrics/codec/MetricBatchCodec;->encode(Lcom/amazon/client/metrics/MetricBatch;)[B

    move-result-object v5

    .line 191
    .local v5, "serializedBatch":[B
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    const/4 v7, 0x1

    invoke-interface {v6, v5, v7}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;->add([BZ)V

    .line 193
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "BATCH_COUNT"

    iget-object v8, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v8}, Lcom/amazon/client/metrics/MetricBatch;->getMetricEntryCount()I

    move-result v8

    int-to-double v8, v8

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 195
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "BATCH_SIZE"

    iget-object v8, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v8}, Lcom/amazon/client/metrics/MetricBatch;->getBatchSizeInBytes()J

    move-result-wide v8

    long-to-double v8, v8

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 197
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "BATCH_OPEN_TIME"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v8

    iget-object v10, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mTimeSinceLastPublish:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-virtual {v10}, Ljava/util/concurrent/atomic/AtomicLong;->get()J

    move-result-wide v10

    sub-long/2addr v8, v10

    long-to-double v8, v8

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->addTimer(Ljava/lang/String;D)V

    .line 198
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "BATCH_ENQUEUED"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_2
    .catch Lcom/dp/framework/CodecException; {:try_start_2 .. :try_end_2} :catch_0
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_2 .. :try_end_2} :catch_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_3
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 220
    .end local v1    # "deviceInfo":Lcom/amazon/client/metrics/MetricsDeviceInfo;
    .end local v5    # "serializedBatch":[B
    :goto_2
    :try_start_3
    new-instance v6, Lcom/amazon/client/metrics/MetricBatch;

    invoke-direct {v6}, Lcom/amazon/client/metrics/MetricBatch;-><init>()V

    iput-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    .line 223
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mTimeSinceLastPublish:Ljava/util/concurrent/atomic/AtomicLong;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v7

    invoke-virtual {v6, v7, v8}, Ljava/util/concurrent/atomic/AtomicLong;->set(J)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_0

    .line 166
    :catchall_0
    move-exception v6

    monitor-exit p0

    throw v6

    .line 174
    :cond_1
    :try_start_4
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->maxBatchSizeReached()Z

    move-result v6

    if-eqz v6, :cond_2

    .line 175
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueueReason.batchSize"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 176
    :cond_2
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->maxBatchOpenTimeReached()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 177
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueueReason.batchOpenTime"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 179
    :cond_3
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueueReason.forceEnqueue"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 200
    :catch_0
    move-exception v0

    .line 202
    .local v0, "ce":Lcom/dp/framework/CodecException;
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueBatch.CodecException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 203
    sget-object v6, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "enqueueBatchForTransmission"

    const-string/jumbo v8, "Exception trying to serialize metrics batch"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v0, v9, v10

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_2

    .line 204
    .end local v0    # "ce":Lcom/dp/framework/CodecException;
    :catch_1
    move-exception v4

    .line 206
    .local v4, "ioe":Ljava/io/IOException;
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueBatch.IOException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 207
    sget-object v6, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "enqueueBatchForTransmission"

    const-string/jumbo v8, "IOException while trying to add metrics batch to queue."

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v4, v9, v10

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_2

    .line 208
    .end local v4    # "ioe":Ljava/io/IOException;
    :catch_2
    move-exception v3

    .line 210
    .local v3, "iae":Ljava/lang/IllegalArgumentException;
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueBatch.IllegalArgumentException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 211
    sget-object v6, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "enqueueBatchForTransmission"

    const-string/jumbo v8, "IllegalArguementException while trying to add metrics batch to queue"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v3, v9, v10

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto/16 :goto_2

    .line 213
    .end local v3    # "iae":Ljava/lang/IllegalArgumentException;
    :catch_3
    move-exception v2

    .line 214
    .local v2, "e":Ljava/lang/Exception;
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "enqueBatch.UnknownException"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 215
    sget-object v6, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v7, "enqueueBatchForTransmission"

    const-string/jumbo v8, "Unexpected Exception while trying to add metrics batch to queue"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    aput-object v2, v9, v10

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_2
.end method

.method protected maxBatchSizeReached()Z
    .locals 4

    .prologue
    .line 230
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mRunningBatch:Lcom/amazon/client/metrics/MetricBatch;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/MetricBatch;->getBatchSizeInBytes()J

    move-result-wide v0

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxSizePerBatchBytes()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public declared-synchronized shutdown()V
    .locals 6

    .prologue
    .line 138
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v1}, Ljava/util/concurrent/ScheduledExecutorService;->shutdown()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 140
    :try_start_1
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 141
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v1}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 143
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-interface {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledExecutorService;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 144
    sget-object v1, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool did not terminate."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 152
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 147
    :catch_0
    move-exception v0

    .line 148
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_2
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->mThreadPool:Ljava/util/concurrent/ScheduledExecutorService;

    invoke-interface {v1}, Ljava/util/concurrent/ScheduledExecutorService;->shutdownNow()Ljava/util/List;

    .line 149
    sget-object v1, Lcom/amazon/client/metrics/batch/creator/BatchCreator;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool interrupted on shutdown."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 150
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 138
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
