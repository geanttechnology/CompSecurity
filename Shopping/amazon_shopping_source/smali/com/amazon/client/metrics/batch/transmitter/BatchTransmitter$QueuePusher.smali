.class public Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;
.super Ljava/lang/Object;
.source "BatchTransmitter.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "QueuePusher"
.end annotation


# instance fields
.field private mBroadcastResultForCurrentRun:Z

.field private final mEnableBroadcastResultForNextRun:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mUploadResultBroadcaster:Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;

.field final synthetic this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;


# direct methods
.method public constructor <init>(Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;)V
    .locals 2
    .param p2, "uploadResultBroadcaster"    # Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;

    .prologue
    .line 106
    iput-object p1, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 107
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 108
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mEnableBroadcastResultForNextRun:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 109
    iput-object p2, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mUploadResultBroadcaster:Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;

    .line 110
    return-void
.end method

.method private sendBatches(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;)Z
    .locals 14
    .param p1, "byteArrayQueue"    # Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 152
    invoke-interface {p1}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;->getQueueName()Ljava/lang/String;

    move-result-object v3

    .line 155
    .local v3, "queueName":Ljava/lang/String;
    const/4 v0, 0x0

    .line 158
    .local v0, "batchesSent":I
    :goto_0
    :try_start_0
    invoke-interface {p1}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;->remove()[B

    move-result-object v1

    .local v1, "currentBatch":[B
    if-eqz v1, :cond_2

    .line 161
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->NULL_METRIC_EVENT:Lcom/amazon/client/metrics/MetricEvent;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$100()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v8

    invoke-interface {v7, v1, v8}, Lcom/amazon/client/metrics/transport/MetricsTransport;->transmit([BLcom/amazon/client/metrics/MetricEvent;)I

    move-result v4

    .line 162
    .local v4, "transmitResult":I
    packed-switch v4, :pswitch_data_0

    .line 241
    :goto_1
    packed-switch v4, :pswitch_data_1

    :pswitch_0
    goto :goto_0

    .line 249
    :pswitch_1
    const/4 v6, 0x0

    invoke-interface {p1, v1, v6}, Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;->add([BZ)V

    .line 250
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v6

    const-string/jumbo v7, "QueuePusher.sendBatches"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Partial number of  "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " queue  batches sent"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 251
    iget-boolean v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mBroadcastResultForCurrentRun:Z

    if-eqz v6, :cond_0

    .line 252
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mUploadResultBroadcaster:Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;

    invoke-virtual {v6, v4, v0, v3}, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;->broadcastResult(IILjava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 275
    :cond_0
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v6, v6, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    invoke-interface {v6}, Lcom/amazon/client/metrics/transport/MetricsTransport;->close()V

    .end local v1    # "currentBatch":[B
    .end local v4    # "transmitResult":I
    :goto_2
    return v5

    .line 166
    .restart local v1    # "currentBatch":[B
    .restart local v4    # "transmitResult":I
    :pswitch_2
    :try_start_1
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on empty data error, discarded."

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 167
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.EMPTY_DATA_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 265
    .end local v1    # "currentBatch":[B
    .end local v4    # "transmitResult":I
    :catch_0
    move-exception v2

    .line 267
    .local v2, "ioe":Ljava/io/IOException;
    :try_start_2
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v6

    const-string/jumbo v7, "QueuePusher.sendBatches"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "Unable to send  "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string/jumbo v9, " queue batches"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    new-array v9, v9, [Ljava/lang/Object;

    invoke-virtual {v6, v7, v8, v9}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 268
    iget-boolean v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mBroadcastResultForCurrentRun:Z

    if-eqz v6, :cond_1

    .line 270
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mUploadResultBroadcaster:Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;

    const/4 v7, -0x1

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v8, v3}, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;->broadcastResult(IILjava/lang/String;)V

    .line 272
    :cond_1
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v6, v6, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v6}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v6

    const-string/jumbo v7, "QueuePusher.BATCH_FAILURE"

    const-wide/high16 v8, 0x3ff0000000000000L    # 1.0

    invoke-interface {v6, v7, v8, v9}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 275
    iget-object v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v6, v6, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    invoke-interface {v6}, Lcom/amazon/client/metrics/transport/MetricsTransport;->close()V

    goto :goto_2

    .line 172
    .end local v2    # "ioe":Ljava/io/IOException;
    .restart local v1    # "currentBatch":[B
    .restart local v4    # "transmitResult":I
    :pswitch_3
    :try_start_3
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed due to no usable connection, re-enqueuing batch"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 173
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.NO_USABLE_CONNECTION"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V
    :try_end_3
    .catch Ljava/io/IOException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_1

    .line 275
    .end local v1    # "currentBatch":[B
    .end local v4    # "transmitResult":I
    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v6, v6, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    invoke-interface {v6}, Lcom/amazon/client/metrics/transport/MetricsTransport;->close()V

    throw v5

    .line 179
    .restart local v1    # "currentBatch":[B
    .restart local v4    # "transmitResult":I
    :pswitch_4
    :try_start_4
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on client error, discarded."

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 180
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.CLIENT_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 185
    :pswitch_5
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on RequestFailedException, re-enqueuing batch."

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 186
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.REQUEST_FAILED_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 191
    :pswitch_6
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on IOException, discarded."

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 192
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.IO_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 197
    :pswitch_7
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on IllegalAccessException, discarded."

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 198
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.ILLEGAL_ACCESS_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 203
    :pswitch_8
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on no http response, re-enqueuing batch."

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 204
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.NO_RESPONSE_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 210
    :pswitch_9
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on credentials error, re-enqueuing batch."

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 211
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.CREDENTIALS_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 216
    :pswitch_a
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on server error, re-enqueuing batch"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 217
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.SERVER_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 222
    :pswitch_b
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on network error, re-enqueuing batch"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->warn(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 223
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.NETWORK_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 228
    :pswitch_c
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Batch transmission failed on unknown error, re-enqueuing batch"

    const/4 v10, 0x0

    new-array v10, v10, [Ljava/lang/Object;

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->error(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 229
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.UNEXPECTED_ERROR"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    goto/16 :goto_1

    .line 234
    :pswitch_d
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v7, v7, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mPeriodicMetricReporter:Lcom/amazon/client/metrics/PeriodicMetricReporter;

    invoke-interface {v7}, Lcom/amazon/client/metrics/PeriodicMetricReporter;->getMetricEvent()Lcom/amazon/client/metrics/MetricEvent;

    move-result-object v7

    const-string/jumbo v8, "MetricsTransport.SUCCESS"

    const-wide/high16 v9, 0x3ff0000000000000L    # 1.0

    invoke-interface {v7, v8, v9, v10}, Lcom/amazon/client/metrics/MetricEvent;->incrementCounter(Ljava/lang/String;D)V

    .line 235
    add-int/lit8 v0, v0, 0x1

    goto/16 :goto_1

    .line 258
    .end local v4    # "transmitResult":I
    :cond_2
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v7

    const-string/jumbo v8, "QueuePusher.sendBatches"

    const-string/jumbo v9, "Drained batch queue."

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v13, "Number of "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string/jumbo v13, " queue batches sent"

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    const/4 v11, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v7, v8, v9, v10}, Lcom/amazon/dp/logger/DPLogger;->info(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 259
    iget-boolean v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mBroadcastResultForCurrentRun:Z

    if-eqz v7, :cond_3

    .line 261
    iget-object v7, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mUploadResultBroadcaster:Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;

    const/4 v8, 0x1

    invoke-virtual {v7, v8, v0, v3}, Lcom/amazon/client/metrics/batch/transmitter/UploadResultBroadcaster;->broadcastResult(IILjava/lang/String;)V
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 275
    :cond_3
    iget-object v5, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v5, v5, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mMetricsTransport:Lcom/amazon/client/metrics/transport/MetricsTransport;

    invoke-interface {v5}, Lcom/amazon/client/metrics/transport/MetricsTransport;->close()V

    move v5, v6

    goto/16 :goto_2

    .line 162
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_d
        :pswitch_b
        :pswitch_4
        :pswitch_a
        :pswitch_9
        :pswitch_c
        :pswitch_3
        :pswitch_2
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_8
    .end packed-switch

    .line 241
    :pswitch_data_1
    .packed-switch 0x2
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method


# virtual methods
.method public enableBroadcastResultForNextRun()V
    .locals 2

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mEnableBroadcastResultForNextRun:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 136
    return-void
.end method

.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 115
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicBoolean;->get()Z

    move-result v0

    if-nez v0, :cond_0

    .line 116
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v0

    const-string/jumbo v1, "QueuePusher.run"

    const-string/jumbo v2, "Shutdown invoked."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 128
    :goto_0
    return-void

    .line 124
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mEnableBroadcastResultForNextRun:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v0, v3}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mBroadcastResultForCurrentRun:Z

    .line 126
    # getter for: Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->log:Lcom/amazon/dp/logger/DPLogger;
    invoke-static {}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->access$000()Lcom/amazon/dp/logger/DPLogger;

    move-result-object v0

    const-string/jumbo v1, "QueuePusher.run"

    const-string/jumbo v2, "Transmitting batches."

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 127
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->this$0:Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;

    iget-object v0, v0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter;->mByteArrayQueue:Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;

    invoke-direct {p0, v0}, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->sendBatches(Lcom/amazon/client/metrics/batch/queue/ByteArrayQueue;)Z

    goto :goto_0
.end method

.method public shutdown()V
    .locals 2

    .prologue
    .line 139
    iget-object v0, p0, Lcom/amazon/client/metrics/batch/transmitter/BatchTransmitter$QueuePusher;->mIsActive:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->set(Z)V

    .line 140
    return-void
.end method
