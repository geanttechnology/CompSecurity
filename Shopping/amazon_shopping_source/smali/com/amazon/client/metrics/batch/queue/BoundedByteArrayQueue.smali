.class public abstract Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;
.super Ljava/lang/Object;
.source "BoundedByteArrayQueue.java"

# interfaces
.implements Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;
    }
.end annotation


# static fields
.field protected static final METRIC_NAME_DROPPED_BATCHES:Ljava/lang/String; = "droppedBatches"

.field protected static final METRIC_NAME_EXPIRED_BATCHES:Ljava/lang/String; = "expiredBatches"

.field private static final THREAD_POOL_TERMINATION_WAIT_MS:I = 0x1388

.field private static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected final mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

.field protected mBytesUsed:J

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

.field protected mNumEntries:J

.field protected final mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

.field private mQueueName:Ljava/lang/String;

.field private final mQueuePurger:Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;

.field private mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 40
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "Metrics:BoundedByteArrayQueue"

    invoke-direct {v0, v1}, Lcom/amazon/dp/logger/DPLogger;-><init>(Ljava/lang/String;)V

    sput-object v0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;Lcom/amazon/client/metrics/PeriodicMetricReporter;)V
    .locals 4
    .param p1, "batchPipelineConfiguration"    # Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;
    .param p2, "periodicMetricReporter"    # Lcom/amazon/client/metrics/PeriodicMetricReporter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    const-wide/16 v2, 0x0

    .line 66
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 47
    new-instance v0, Ljava/util/HashSet;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/HashSet;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mListeners:Ljava/util/Set;

    .line 49
    new-instance v0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;

    invoke-direct {v0, p0}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;-><init>(Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurger:Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;

    .line 51
    iput-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mBytesUsed:J

    .line 53
    iput-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mNumEntries:J

    .line 68
    invoke-interface {p1}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxBatchQueueCapacityBytes()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_0

    .line 69
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Capacity of queue must be greater than 0 bytes."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 72
    :cond_0
    invoke-interface {p1}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getExpiryTimeMillis()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-gez v0, :cond_1

    .line 73
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "ExpiryTimeMillis must not be negative."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 76
    :cond_1
    invoke-interface {p1}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getPurgePeriodMillis()J

    move-result-wide v0

    cmp-long v0, v0, v2

    if-gez v0, :cond_2

    .line 77
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "PurgePeriodMillis must not be negative."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 80
    :cond_2
    if-nez p2, :cond_3

    .line 81
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Periodic metric reporter must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 83
    :cond_3
    iput-object p2, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    .line 84
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    .line 85
    invoke-direct {p0}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->initializeQueuePurger()V

    .line 86
    return-void
.end method

.method static synthetic access$000()Lcom/amazon/dp/logger/DPLogger;
    .locals 1

    .prologue
    .line 38
    sget-object v0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    return-object v0
.end method

.method private initializeQueuePurger()V
    .locals 9

    .prologue
    .line 89
    const/4 v8, 0x1

    .line 90
    .local v8, "corePoolSize":I
    new-instance v7, Lcom/amazon/device/utils/BackgroundThreadFactory;

    invoke-direct {v7}, Lcom/amazon/device/utils/BackgroundThreadFactory;-><init>()V

    .line 91
    .local v7, "backgroundThreadFactory":Ljava/util/concurrent/ThreadFactory;
    new-instance v0, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const/4 v1, 0x1

    invoke-direct {v0, v1, v7}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;-><init>(ILjava/util/concurrent/ThreadFactory;)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    .line 92
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurger:Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getPurgePeriodMillis()J

    move-result-wide v2

    iget-object v4, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v4}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getPurgePeriodMillis()J

    move-result-wide v4

    sget-object v6, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual/range {v0 .. v6}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    .line 93
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    new-instance v1, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;

    invoke-direct {v1}, Ljava/util/concurrent/ThreadPoolExecutor$DiscardPolicy;-><init>()V

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->setRejectedExecutionHandler(Ljava/util/concurrent/RejectedExecutionHandler;)V

    .line 94
    return-void
.end method


# virtual methods
.method public declared-synchronized addListener(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;

    .prologue
    .line 185
    monitor-enter p0

    if-nez p1, :cond_0

    .line 186
    :try_start_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "listener cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 185
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 188
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 189
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized getNumEntriesInQueue()J
    .locals 2

    .prologue
    .line 207
    monitor-enter p0

    :try_start_0
    iget-wide v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mNumEntries:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

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
    .line 219
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueueName:Ljava/lang/String;

    return-object v0
.end method

.method protected declared-synchronized notifyListeners()V
    .locals 6

    .prologue
    .line 154
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mListeners:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;

    .line 155
    .local v1, "listener":Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;
    iget-wide v2, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mNumEntries:J

    iget-wide v4, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mBytesUsed:J

    invoke-interface {v1, v2, v3, v4, v5}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;->onInsert(JJ)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 154
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 157
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    monitor-exit p0

    return-void
.end method

.method protected abstract purgeExpiredBatches()V
.end method

.method public declared-synchronized removeListener(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;)V
    .locals 2
    .param p1, "listener"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueueListener;

    .prologue
    .line 196
    monitor-enter p0

    if-nez p1, :cond_0

    .line 197
    :try_start_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "listener cannot be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 196
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 199
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mListeners:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 200
    monitor-exit p0

    return-void
.end method

.method public setQueueName(Ljava/lang/String;)V
    .locals 0
    .param p1, "QueueName"    # Ljava/lang/String;

    .prologue
    .line 213
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueueName:Ljava/lang/String;

    .line 214
    return-void
.end method

.method public declared-synchronized shutdown()V
    .locals 6

    .prologue
    .line 98
    monitor-enter p0

    :try_start_0
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurger:Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;

    invoke-virtual {v1}, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue$QueuePurger;->shutdown()V

    .line 99
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {v1}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->shutdown()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 101
    :try_start_1
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 102
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {v1}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 104
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const-wide/16 v2, 0x1388

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v1, v2, v3, v4}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->awaitTermination(JLjava/util/concurrent/TimeUnit;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 105
    sget-object v1, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool did not terminate."

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 113
    :cond_0
    :goto_0
    monitor-exit p0

    return-void

    .line 108
    :catch_0
    move-exception v0

    .line 109
    .local v0, "e":Ljava/lang/InterruptedException;
    :try_start_2
    iget-object v1, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mQueuePurgerExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {v1}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 110
    sget-object v1, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v2, "shutdown"

    const-string/jumbo v3, "Thread pool interrupted on shutdown."

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    aput-object v0, v4, v5

    invoke-virtual {v1, v2, v3, v4}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 111
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Thread;->interrupt()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 98
    .end local v0    # "e":Ljava/lang/InterruptedException;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method protected validateInput([B)V
    .locals 4
    .param p1, "serializedObject"    # [B
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 168
    if-eqz p1, :cond_0

    array-length v0, p1

    if-gtz v0, :cond_1

    .line 169
    :cond_0
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Serialized object should not be null or empty."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 174
    :cond_1
    array-length v0, p1

    int-to-long v0, v0

    iget-object v2, p0, Lcom/amazon/client/metrics/batch/queue/BoundedByteArrayQueue;->mBatchPipelineConfiguration:Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;

    invoke-interface {v2}, Lcom/amazon/client/metrics/configuration/BatchPipelineConfiguration;->getMaxBatchQueueCapacityBytes()J

    move-result-wide v2

    cmp-long v0, v0, v2

    if-lez v0, :cond_2

    .line 175
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Serialized object size is larger than the maximum capacity."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 178
    :cond_2
    return-void
.end method
