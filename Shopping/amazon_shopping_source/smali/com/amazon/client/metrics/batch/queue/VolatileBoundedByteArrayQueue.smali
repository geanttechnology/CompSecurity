.class public Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;
.super Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;
.source "VolatileBoundedByteArrayQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;
    }
.end annotation


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected final mListeners:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;",
            ">;"
        }
    .end annotation
.end field

.field private mQueue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 34
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:VolatileBoundedByteArrayQueue"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V
    .locals 2
    .param p1, "batchPipelineConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .param p2, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .prologue
    .line 48
    invoke-direct {p0, p1, p2}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;-><init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V

    .line 36
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mQueue:Ljava/util/Queue;

    .line 37
    new-instance v0, Ljava/util/HashSet;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mListeners:Ljava/util/Set;

    .line 49
    return-void
.end method


# virtual methods
.method public declared-synchronized add([BZ)V
    .locals 5
    .param p1, "serializedObject"    # [B
    .param p2, "triggerNotifications"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 64
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->validateInput([B)V

    .line 66
    iget-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mBytesUsed:J

    array-length v3, p1

    int-to-long v3, v3

    add-long/2addr v1, v3

    iput-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mBytesUsed:J

    .line 69
    :cond_0
    iget-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mBytesUsed:J

    iget-object v3, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v3}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxBatchQueueCapacityBytes()J

    move-result-wide v3

    cmp-long v1, v1, v3

    if-lez v1, :cond_1

    .line 70
    sget-object v1, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "add"

    const-string/jumbo v3, "Queue is full. Dropping an item from the queue."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 73
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v1}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v1

    const-string/jumbo v2, "droppedBatches"

    const-wide/high16 v3, 0x3ff0000000000000L    # 1.0

    invoke-interface {v1, v2, v3, v4}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 76
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->remove()[B

    move-result-object v0

    .line 77
    .local v0, "removedSerializedObject":[B
    if-nez v0, :cond_0

    .line 78
    new-instance v1, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v2, "All items removed and the queue is still full"

    invoke-direct {v1, v2}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 64
    .end local v0    # "removedSerializedObject":[B
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1

    .line 83
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mQueue:Ljava/util/Queue;

    new-instance v2, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    invoke-direct {v2, p0, v3, v4, p1}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;-><init>(Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;J[B)V

    invoke-interface {v1, v2}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 84
    iget-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mNumEntries:J

    const-wide/16 v3, 0x1

    add-long/2addr v1, v3

    iput-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mNumEntries:J

    .line 85
    if-eqz p2, :cond_2

    .line 86
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->notifyListeners()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 87
    :cond_2
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized peekVolatileQueueSerializedObject()Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;
    .locals 1

    .prologue
    .line 131
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mQueue:Ljava/util/Queue;

    invoke-interface {v0}, Ljava/util/Queue;->peek()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized purgeExpiredBatches()V
    .locals 11

    .prologue
    .line 113
    monitor-enter p0

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iget-object v6, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v6}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getExpiryTimeMillis()J

    move-result-wide v6

    sub-long v0, v4, v6

    .line 114
    .local v0, "cutoffMillis":J
    iget-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mNumEntries:J

    .line 115
    .local v2, "oldNumEntries":J
    :goto_0
    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mQueue:Ljava/util/Queue;

    invoke-interface {v4}, Ljava/util/Queue;->peek()Ljava/lang/Object;

    move-result-object v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mQueue:Ljava/util/Queue;

    invoke-interface {v4}, Ljava/util/Queue;->peek()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;

    invoke-virtual {v4}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->getTimeStamp()J

    move-result-wide v4

    cmp-long v4, v4, v0

    if-gez v4, :cond_0

    .line 116
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->remove()[B

    .line 117
    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v4}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v4

    const-string/jumbo v5, "expiredBatches"

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    invoke-interface {v4, v5, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 113
    .end local v0    # "cutoffMillis":J
    .end local v2    # "oldNumEntries":J
    :catchall_0
    move-exception v4

    monitor-exit p0

    throw v4

    .line 119
    .restart local v0    # "cutoffMillis":J
    .restart local v2    # "oldNumEntries":J
    :cond_0
    :try_start_1
    sget-object v4, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "purgeExpiredBatches"

    const-string/jumbo v6, "Number of batches purged: "

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    iget-wide v9, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mNumEntries:J

    sub-long v9, v2, v9

    invoke-static {v9, v10}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v9

    aput-object v9, v7, v8

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 120
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized remove()[B
    .locals 5

    .prologue
    .line 97
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->peek()Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_1

    const/4 v0, 0x0

    .line 100
    .local v0, "removedSerializedObject":[B
    :goto_0
    if-eqz v0, :cond_0

    .line 101
    iget-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mBytesUsed:J

    array-length v3, v0

    int-to-long v3, v3

    sub-long/2addr v1, v3

    iput-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mBytesUsed:J

    .line 102
    iget-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mNumEntries:J

    const-wide/16 v3, 0x1

    sub-long/2addr v1, v3

    iput-wide v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mNumEntries:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 104
    :cond_0
    monitor-exit p0

    return-object v0

    .line 97
    .end local v0    # "removedSerializedObject":[B
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->mQueue:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->getSerializedObject()[B
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method
