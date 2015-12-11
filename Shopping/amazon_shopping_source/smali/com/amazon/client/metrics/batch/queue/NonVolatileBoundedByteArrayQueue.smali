.class public Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;
.super Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;
.source "NonVolatileBoundedByteArrayQueue.java"


# static fields
.field private static final METRIC_NAME_ADD_BATCHES_IO_FAILURE:Ljava/lang/String; = "addBatchesIOFailure"

.field private static final METRIC_NAME_REMOVE_BATCHES_IO_FAILURE:Ljava/lang/String; = "removeBatchesIOFailure"

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field private final mDirOfBatchFiles:Ljava/io/File;

.field private final mFileNameQueue:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 40
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:NonVolatileBoundedByteArrayQueue"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;Ljava/io/File;)V
    .locals 6
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
    const-wide/high16 v4, 0x3ff0000000000000L    # 1.0

    .line 66
    invoke-direct {p0, p1, p2}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;-><init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V

    .line 46
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mFileNameQueue:Ljava/util/Queue;

    .line 67
    invoke-interface {p1}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxBatchQueueEntries()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    .line 68
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v0}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    const-string/jumbo v1, "queue.capacityError"

    invoke-interface {v0, v1, v4, v5}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 69
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Capacity of queue must be greater than 0 entry"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 72
    :cond_0
    if-eqz p3, :cond_1

    invoke-virtual {p3}, Ljava/io/File;->isDirectory()Z

    move-result v0

    if-nez v0, :cond_2

    .line 73
    :cond_1
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v0}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v0

    const-string/jumbo v1, "queue.dirError"

    invoke-interface {v0, v1, v4, v5}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 74
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "dirOfBatchFiles must not be null and should be a valid directory."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 78
    :cond_2
    iput-object p3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mDirOfBatchFiles:Ljava/io/File;

    .line 81
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->readPersistedData()V

    .line 86
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->trimQueueToFit()V

    .line 87
    return-void
.end method

.method static synthetic access$000()Lcom/amazon/dp/logger/DPLogger;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    return-object v0
.end method

.method private getAbsolutePath(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p1, "filename"    # Ljava/lang/String;

    .prologue
    .line 302
    new-instance v0, Ljava/lang/StringBuilder;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mDirOfBatchFiles:Ljava/io/File;

    invoke-virtual {v2}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mDirOfBatchFiles:Ljava/io/File;

    sget-object v2, Ljava/io/File;->separator:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private readPersistedData()V
    .locals 7

    .prologue
    .line 91
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mDirOfBatchFiles:Ljava/io/File;

    invoke-virtual {v3}, Ljava/io/File;->listFiles()[Ljava/io/File;

    move-result-object v0

    .line 93
    .local v0, "allFiles":[Ljava/io/File;
    new-instance v3, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue$1;

    invoke-direct {v3, p0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue$1;-><init>(Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;)V

    invoke-static {v0, v3}, Ljava/util/Arrays;->sort([Ljava/lang/Object;Ljava/util/Comparator;)V

    .line 119
    array-length v2, v0

    .line 120
    .local v2, "noOfFiles":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-ge v1, v2, :cond_0

    .line 121
    iget-wide v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    aget-object v5, v0, v1

    invoke-virtual {v5}, Ljava/io/File;->length()J

    move-result-wide v5

    add-long/2addr v3, v5

    iput-wide v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    .line 122
    iget-object v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mFileNameQueue:Ljava/util/Queue;

    aget-object v4, v0, v1

    invoke-virtual {v4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 123
    iget-wide v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    const-wide/16 v5, 0x1

    add-long/2addr v3, v5

    iput-wide v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    .line 120
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 125
    :cond_0
    return-void
.end method

.method private trimQueueToFit()V
    .locals 8
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    .line 197
    :goto_0
    iget-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxBatchQueueCapacityBytes()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-gtz v2, :cond_0

    iget-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxBatchQueueEntries()J

    move-result-wide v4

    cmp-long v2, v2, v4

    if-lez v2, :cond_2

    .line 198
    :cond_0
    sget-object v2, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "trimQueueToFit"

    const-string/jumbo v4, "Queue is full. Dropping an element"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 201
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v2}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v2

    const-string/jumbo v3, "droppedBatches"

    invoke-interface {v2, v3, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 204
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mFileNameQueue:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 205
    .local v0, "filename":Ljava/lang/String;
    if-nez v0, :cond_1

    .line 206
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v2}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v2

    const-string/jumbo v3, "queueSizeError"

    invoke-interface {v2, v3, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 208
    new-instance v2, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v3, "All items removed and the queue is still full."

    invoke-direct {v2, v3}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 210
    :cond_1
    new-instance v1, Ljava/io/File;

    invoke-direct {p0, v0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->getAbsolutePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v1, v2}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 211
    .local v1, "removedFile":Ljava/io/File;
    iget-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    invoke-virtual {v1}, Ljava/io/File;->length()J

    move-result-wide v4

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    .line 212
    invoke-virtual {v1}, Ljava/io/File;->delete()Z

    .line 213
    iget-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    const-wide/16 v4, 0x1

    sub-long/2addr v2, v4

    iput-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    goto :goto_0

    .line 215
    .end local v0    # "filename":Ljava/lang/String;
    .end local v1    # "removedFile":Ljava/io/File;
    :cond_2
    return-void
.end method


# virtual methods
.method public declared-synchronized add([BZ)V
    .locals 2
    .param p1, "serializedObject"    # [B
    .param p2, "triggerNotifications"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 146
    monitor-enter p0

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-virtual {p0, p1, p2, v0, v1}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->add([BZJ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 147
    monitor-exit p0

    return-void

    .line 146
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized add([BZJ)V
    .locals 10
    .param p1, "serializedObject"    # [B
    .param p2, "triggerNotifications"    # Z
    .param p3, "seriazliedObjectTimeStamp"    # J
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;,
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const-wide/16 v8, 0x1

    .line 152
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0, p1}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->validateInput([B)V

    .line 154
    iget-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    array-length v6, p1

    int-to-long v6, v6

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    .line 156
    iget-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    add-long/2addr v4, v8

    iput-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    .line 159
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->trimQueueToFit()V

    .line 161
    const-string/jumbo v0, ""
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 162
    .local v0, "filename":Ljava/lang/String;
    const/4 v1, 0x0

    .line 165
    .local v1, "fos":Ljava/io/FileOutputStream;
    :try_start_1
    invoke-static {p3, p4}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v0

    .line 166
    new-instance v2, Ljava/io/FileOutputStream;

    invoke-direct {p0, v0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->getAbsolutePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v4}, Ljava/io/FileOutputStream;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 167
    .end local v1    # "fos":Ljava/io/FileOutputStream;
    .local v2, "fos":Ljava/io/FileOutputStream;
    :try_start_2
    invoke-virtual {v2, p1}, Ljava/io/FileOutputStream;->write([B)V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    .line 180
    if-eqz v2, :cond_0

    .line 181
    :try_start_3
    invoke-virtual {v2}, Ljava/io/FileOutputStream;->close()V

    .line 185
    :cond_0
    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mFileNameQueue:Ljava/util/Queue;

    invoke-interface {v4, v0}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 186
    if-eqz p2, :cond_1

    .line 187
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->notifyListeners()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 188
    :cond_1
    monitor-exit p0

    return-void

    .line 168
    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v1    # "fos":Ljava/io/FileOutputStream;
    :catch_0
    move-exception v3

    .line 170
    .local v3, "ioe":Ljava/io/IOException;
    :goto_0
    :try_start_4
    iget-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    array-length v6, p1

    int-to-long v6, v6

    sub-long/2addr v4, v6

    iput-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    .line 171
    iget-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    sub-long/2addr v4, v8

    iput-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    .line 174
    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v4}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v4

    const-string/jumbo v5, "addBatchesIOFailure"

    const-wide/high16 v6, 0x3ff0000000000000L    # 1.0

    invoke-interface {v4, v5, v6, v7}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 176
    sget-object v4, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v5, "add"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "Unable to persist the serializedObject to internal Storage."

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v3}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    const/4 v7, 0x0

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {v4, v5, v6, v7}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 178
    throw v3
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 180
    .end local v3    # "ioe":Ljava/io/IOException;
    :catchall_0
    move-exception v4

    :goto_1
    if-eqz v1, :cond_2

    .line 181
    :try_start_5
    invoke-virtual {v1}, Ljava/io/FileOutputStream;->close()V

    :cond_2
    throw v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 152
    .end local v0    # "filename":Ljava/lang/String;
    .end local v1    # "fos":Ljava/io/FileOutputStream;
    :catchall_1
    move-exception v4

    monitor-exit p0

    throw v4

    .line 180
    .restart local v0    # "filename":Ljava/lang/String;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    :catchall_2
    move-exception v4

    move-object v1, v2

    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v1    # "fos":Ljava/io/FileOutputStream;
    goto :goto_1

    .line 168
    .end local v1    # "fos":Ljava/io/FileOutputStream;
    .restart local v2    # "fos":Ljava/io/FileOutputStream;
    :catch_1
    move-exception v3

    move-object v1, v2

    .end local v2    # "fos":Ljava/io/FileOutputStream;
    .restart local v1    # "fos":Ljava/io/FileOutputStream;
    goto :goto_0
.end method

.method public declared-synchronized purgeExpiredBatches()V
    .locals 12

    .prologue
    .line 279
    monitor-enter p0

    :try_start_0
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    iget-object v7, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v7}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getExpiryTimeMillis()J

    move-result-wide v7

    sub-long v0, v5, v7

    .line 280
    .local v0, "cutoffMillis":J
    iget-wide v3, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    .line 281
    .local v3, "oldNumEntries":J
    :goto_0
    iget-object v5, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mFileNameQueue:Ljava/util/Queue;

    invoke-interface {v5}, Ljava/util/Queue;->peek()Ljava/lang/Object;

    move-result-object v5

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mFileNameQueue:Ljava/util/Queue;

    invoke-interface {v5}, Ljava/util/Queue;->peek()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-static {v5}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-wide v5

    cmp-long v5, v5, v0

    if-gez v5, :cond_0

    .line 283
    :try_start_1
    invoke-virtual {p0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->remove()[B

    .line 284
    iget-object v5, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v5}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v5

    const-string/jumbo v6, "expiredBatches"

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    invoke-interface {v5, v6, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 285
    :catch_0
    move-exception v2

    .line 286
    .local v2, "ioe":Ljava/io/IOException;
    :try_start_2
    iget-object v5, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v5}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v5

    const-string/jumbo v6, "removeBatchesIOFailure"

    const-wide/high16 v7, 0x3ff0000000000000L    # 1.0

    invoke-interface {v5, v6, v7, v8}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 288
    sget-object v5, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v6, "purgeExpiredBatches"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "Unabled to purge batch."

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v2}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    const/4 v8, 0x0

    new-array v8, v8, [Ljava/lang/Object;

    invoke-virtual {v5, v6, v7, v8}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 279
    .end local v0    # "cutoffMillis":J
    .end local v2    # "ioe":Ljava/io/IOException;
    .end local v3    # "oldNumEntries":J
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 291
    .restart local v0    # "cutoffMillis":J
    .restart local v3    # "oldNumEntries":J
    :cond_0
    :try_start_3
    sget-object v5, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v6, "purgeExpiredBatches"

    const-string/jumbo v7, "Number of batches purged: "

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    iget-wide v10, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    sub-long v10, v3, v10

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-virtual {v5, v6, v7, v8}, Lcom/amazon/dp/logger/DPLogger;->debug(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 292
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized remove()[B
    .locals 14
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 227
    monitor-enter p0

    :try_start_0
    iget-object v8, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mFileNameQueue:Ljava/util/Queue;

    invoke-interface {v8}, Ljava/util/Queue;->poll()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 228
    .local v0, "filename":Ljava/lang/String;
    const/4 v7, 0x0

    .line 233
    .local v7, "removedSerializedObject":[B
    if-eqz v0, :cond_2

    .line 234
    const/4 v1, 0x0

    .line 236
    .local v1, "fis":Ljava/io/FileInputStream;
    :try_start_1
    new-instance v6, Ljava/io/File;

    invoke-direct {p0, v0}, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->getAbsolutePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    invoke-direct {v6, v8}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 237
    .local v6, "removedFile":Ljava/io/File;
    invoke-virtual {v6}, Ljava/io/File;->length()J

    move-result-wide v4

    .line 239
    .local v4, "lengthOfRemovedFile":J
    const-wide/32 v8, 0x7fffffff

    cmp-long v8, v4, v8

    if-lez v8, :cond_1

    .line 240
    sget-object v8, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "remove"

    const-string/jumbo v10, "size of metrics batch file should not be greater than Integer.MAX_VALUE"

    const/4 v11, 0x2

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string/jumbo v13, "file size"

    aput-object v13, v11, v12

    const/4 v12, 0x1

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v13

    aput-object v13, v11, v12

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 244
    iget-object v8, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v8}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v8

    const-string/jumbo v9, "removeBatchMAXLengthError"

    const-wide/high16 v10, 0x3ff0000000000000L    # 1.0

    invoke-interface {v8, v9, v10, v11}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 246
    new-instance v8, Ljava/io/IOException;

    const-string/jumbo v9, "Size of metrics batch file greater than Integer.MAX_VALUE"

    invoke-direct {v8, v9}, Ljava/io/IOException;-><init>(Ljava/lang/String;)V

    throw v8
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 259
    .end local v4    # "lengthOfRemovedFile":J
    .end local v6    # "removedFile":Ljava/io/File;
    :catch_0
    move-exception v3

    .line 262
    .local v3, "ioe":Ljava/io/IOException;
    :goto_0
    :try_start_2
    iget-object v8, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v8}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v8

    const-string/jumbo v9, "removeBatchesIOFailure"

    const-wide/high16 v10, 0x3ff0000000000000L    # 1.0

    invoke-interface {v8, v9, v10, v11}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 264
    sget-object v8, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v9, "remove"

    new-instance v10, Ljava/lang/StringBuilder;

    invoke-direct {v10}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v11, "Unable to delete the file."

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v3}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v10, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v10

    invoke-virtual {v10}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v10

    const/4 v11, 0x0

    new-array v11, v11, [Ljava/lang/Object;

    invoke-virtual {v8, v9, v10, v11}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 265
    throw v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 267
    .end local v3    # "ioe":Ljava/io/IOException;
    :catchall_0
    move-exception v8

    :goto_1
    if-eqz v1, :cond_0

    .line 268
    :try_start_3
    invoke-virtual {v1}, Ljava/io/FileInputStream;->close()V

    :cond_0
    throw v8
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 227
    .end local v0    # "filename":Ljava/lang/String;
    .end local v1    # "fis":Ljava/io/FileInputStream;
    .end local v7    # "removedSerializedObject":[B
    :catchall_1
    move-exception v8

    monitor-exit p0

    throw v8

    .line 251
    .restart local v0    # "filename":Ljava/lang/String;
    .restart local v1    # "fis":Ljava/io/FileInputStream;
    .restart local v4    # "lengthOfRemovedFile":J
    .restart local v6    # "removedFile":Ljava/io/File;
    .restart local v7    # "removedSerializedObject":[B
    :cond_1
    long-to-int v8, v4

    :try_start_4
    new-array v7, v8, [B

    .line 253
    new-instance v2, Ljava/io/FileInputStream;

    invoke-direct {v2, v6}, Ljava/io/FileInputStream;-><init>(Ljava/io/File;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 254
    .end local v1    # "fis":Ljava/io/FileInputStream;
    .local v2, "fis":Ljava/io/FileInputStream;
    :try_start_5
    invoke-virtual {v2, v7}, Ljava/io/FileInputStream;->read([B)I

    .line 256
    iget-wide v8, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    invoke-virtual {v6}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long/2addr v8, v10

    iput-wide v8, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mBytesUsed:J

    .line 257
    invoke-virtual {v6}, Ljava/io/File;->delete()Z

    .line 258
    iget-wide v8, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J

    const-wide/16 v10, 0x1

    sub-long/2addr v8, v10

    iput-wide v8, p0, Lcom/amazon/client/metrics/batch/queue/NonVolatileBoundedByteArrayQueue;->mNumEntries:J
    :try_end_5
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_2

    .line 267
    if-eqz v2, :cond_2

    .line 268
    :try_start_6
    invoke-virtual {v2}, Ljava/io/FileInputStream;->close()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 271
    .end local v2    # "fis":Ljava/io/FileInputStream;
    .end local v4    # "lengthOfRemovedFile":J
    .end local v6    # "removedFile":Ljava/io/File;
    :cond_2
    monitor-exit p0

    return-object v7

    .line 267
    .restart local v2    # "fis":Ljava/io/FileInputStream;
    .restart local v4    # "lengthOfRemovedFile":J
    .restart local v6    # "removedFile":Ljava/io/File;
    :catchall_2
    move-exception v8

    move-object v1, v2

    .end local v2    # "fis":Ljava/io/FileInputStream;
    .restart local v1    # "fis":Ljava/io/FileInputStream;
    goto :goto_1

    .line 259
    .end local v1    # "fis":Ljava/io/FileInputStream;
    .restart local v2    # "fis":Ljava/io/FileInputStream;
    :catch_1
    move-exception v3

    move-object v1, v2

    .end local v2    # "fis":Ljava/io/FileInputStream;
    .restart local v1    # "fis":Ljava/io/FileInputStream;
    goto :goto_0
.end method
