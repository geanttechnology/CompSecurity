.class public Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;
.super Ljava/lang/Object;
.source "SemiVolatileBoundedByteArrayQueue.java"

# interfaces
.implements Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;


# static fields
.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

.field private mQueueName:Ljava/lang/String;

.field mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 38
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:SemiVolatileBoundedByteArrayQueue"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Ljava/io/File;)V
    .locals 1
    .param p1, "batchPipelineConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .param p2, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;
    .param p3, "dirOfBatchFiles"    # Ljava/io/File;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 57
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 58
    new-instance v0, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-direct {v0, p1, p2}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;-><init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    .line 59
    new-instance v0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    invoke-direct {v0, p1, p2, p3}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;-><init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Ljava/io/File;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    .line 60
    return-void
.end method


# virtual methods
.method public declared-synchronized add([BZ)V
    .locals 6
    .param p1, "serializedObject"    # [B
    .param p2, "triggerNotifications"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 80
    monitor-enter p0

    if-eqz p2, :cond_1

    .line 81
    :try_start_0
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    const/4 v3, 0x1

    invoke-virtual {v2, p1, v3}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->add([BZ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 92
    :cond_0
    monitor-exit p0

    return-void

    .line 85
    :cond_1
    :try_start_1
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    const/4 v3, 0x0

    invoke-virtual {v2, p1, v3}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->add([BZ)V

    .line 87
    :goto_0
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->getNumEntriesInQueue()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-lez v2, :cond_0

    .line 88
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->peekVolatileQueueSerializedObject()Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue$TimeStampedSerializedObject;->getTimeStamp()J

    move-result-wide v0

    .line 89
    .local v0, "serializedObjectTimeStamp":J
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    iget-object v3, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v3}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->remove()[B

    move-result-object v3

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4, v0, v1}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->add([BZJ)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 80
    .end local v0    # "serializedObjectTimeStamp":J
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method

.method public declared-synchronized addListener(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;

    .prologue
    .line 122
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->addListener(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 123
    monitor-exit p0

    return-void

    .line 122
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized getNumEntriesInQueue()J
    .locals 4

    .prologue
    .line 155
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->getNumEntriesInQueue()J

    move-result-wide v0

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    invoke-virtual {v2}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->getNumEntriesInQueue()J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v2

    add-long/2addr v0, v2

    monitor-exit p0

    return-wide v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getQueueName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mQueueName:Ljava/lang/String;

    return-object v0
.end method

.method public declared-synchronized remove()[B
    .locals 4
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v2, 0x0

    .line 107
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->getNumEntriesInQueue()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-lez v0, :cond_0

    .line 108
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->remove()[B
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 114
    :goto_0
    monitor-exit p0

    return-object v0

    .line 111
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->getNumEntriesInQueue()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-lez v0, :cond_1

    .line 112
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->remove()[B
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    goto :goto_0

    .line 114
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 107
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized removeListener(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;)V
    .locals 1
    .param p1, "listener"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;

    .prologue
    .line 130
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v0, p1}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->removeListener(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 131
    monitor-exit p0

    return-void

    .line 130
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public setQueueName(Ljava/lang/String;)V
    .locals 0
    .param p1, "QueueName"    # Ljava/lang/String;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mQueueName:Ljava/lang/String;

    .line 142
    return-void
.end method

.method public shutdown()V
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mVolatileQueue:Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/VolatileBoundedByteArrayQueue;->shutdown()V

    .line 136
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/SemiVolatileBoundedByteArrayQueue;->mNonVolatileQueue:Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;

    invoke-virtual {v0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->shutdown()V

    .line 137
    return-void
.end method
