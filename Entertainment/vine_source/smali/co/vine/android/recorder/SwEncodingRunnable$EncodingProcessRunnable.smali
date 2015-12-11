.class Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;
.super Ljava/lang/Object;
.source "SwEncodingRunnable.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lco/vine/android/recorder/SwEncodingRunnable;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = "EncodingProcessRunnable"
.end annotation


# instance fields
.field private final LOCK:[I

.field private mBufferedVideoData:Ljava/util/LinkedList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedList",
            "<",
            "Lco/vine/android/recorder/VideoData;",
            ">;"
        }
    .end annotation
.end field

.field private mParent:Lco/vine/android/recorder/SwEncodingRunnable;

.field public mRun:Z

.field private totalSizeToWait:I


# direct methods
.method public constructor <init>(Lco/vine/android/recorder/SwEncodingRunnable;)V
    .locals 1
    .param p1, "parent"    # Lco/vine/android/recorder/SwEncodingRunnable;

    .prologue
    .line 99
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 95
    const/4 v0, 0x0

    new-array v0, v0, [I

    iput-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->LOCK:[I

    .line 96
    const/4 v0, -0x1

    iput v0, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    .line 100
    iput-object p1, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    .line 101
    iget-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    # invokes: Lco/vine/android/recorder/SwEncodingRunnable;->makeNewEncoder()V
    invoke-static {v0}, Lco/vine/android/recorder/SwEncodingRunnable;->access$000(Lco/vine/android/recorder/SwEncodingRunnable;)V

    .line 102
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    .line 103
    return-void
.end method


# virtual methods
.method public add(Lco/vine/android/recorder/VideoData;)[B
    .locals 5
    .param p1, "next"    # Lco/vine/android/recorder/VideoData;

    .prologue
    .line 145
    iget-object v3, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->LOCK:[I

    monitor-enter v3

    .line 146
    :try_start_0
    iget-object v1, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    .line 147
    .local v1, "parent":Lco/vine/android/recorder/SwEncodingRunnable;
    iget-object v0, p1, Lco/vine/android/recorder/VideoData;->data:[B

    .line 148
    .local v0, "bytes":[B
    if-eqz v0, :cond_0

    if-eqz v1, :cond_0

    # getter for: Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v1}, Lco/vine/android/recorder/SwEncodingRunnable;->access$100(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v2

    new-instance v4, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;

    invoke-direct {v4, v0, p1}, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;-><init>([BLjava/lang/Object;)V

    invoke-virtual {v2, v4}, Lco/vine/android/recorder/ByteBufferQueue;->put(Lco/vine/android/recorder/ByteBufferQueue$QueueItem;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 149
    const-string v2, "Not enough memory left. (BufferOverflow)"

    invoke-static {v2}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;)V

    .line 151
    :cond_0
    iget-object v2, p1, Lco/vine/android/recorder/VideoData;->data:[B

    monitor-exit v3

    return-object v2

    .line 152
    .end local v0    # "bytes":[B
    .end local v1    # "parent":Lco/vine/android/recorder/SwEncodingRunnable;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public run()V
    .locals 7

    .prologue
    .line 107
    const/16 v4, 0x13

    invoke-static {v4}, Landroid/os/Process;->setThreadPriority(I)V

    .line 108
    :goto_0
    iget-boolean v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mRun:Z

    if-eqz v4, :cond_4

    .line 109
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v4}, Lco/vine/android/recorder/SwEncodingRunnable;->access$100(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/ByteBufferQueue;->get()Lco/vine/android/recorder/ByteBufferQueue$QueueItem;

    move-result-object v0

    .line 110
    .local v0, "data":Lco/vine/android/recorder/ByteBufferQueue$QueueItem;
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/SwEncodingRunnable;->mProducer:Lco/vine/android/recorder/RecordController;
    invoke-static {v4}, Lco/vine/android/recorder/SwEncodingRunnable;->access$200(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/RecordController;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/RecordController;->isRecordingStarted()Z

    move-result v4

    if-nez v4, :cond_1

    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/SwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;
    invoke-static {v4}, Lco/vine/android/recorder/SwEncodingRunnable;->access$300(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/BaseFinishProcessTask;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 111
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v4}, Lco/vine/android/recorder/SwEncodingRunnable;->access$100(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/ByteBufferQueue;->size()I

    move-result v3

    .line 112
    .local v3, "size":I
    const/4 v4, 0x1

    invoke-static {v3, v4}, Ljava/lang/Math;->max(II)I

    move-result v3

    .line 113
    iget v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    const/4 v5, -0x1

    if-ne v4, v5, :cond_0

    .line 114
    iput v3, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    .line 115
    const/4 v4, -0x8

    invoke-static {v4}, Landroid/os/Process;->setThreadPriority(I)V

    .line 116
    const-string v4, "Size to wait: {}."

    iget v5, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/edisonwang/android/slog/SLog;->i(Ljava/lang/String;Ljava/lang/Object;)V

    .line 118
    :cond_0
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/SwEncodingRunnable;->mAsyncTask:Lco/vine/android/recorder/BaseFinishProcessTask;
    invoke-static {v4}, Lco/vine/android/recorder/SwEncodingRunnable;->access$300(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/BaseFinishProcessTask;

    move-result-object v4

    iget v5, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    sub-int/2addr v5, v3

    mul-int/lit8 v5, v5, 0x5a

    iget v6, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->totalSizeToWait:I

    div-int/2addr v5, v6

    invoke-virtual {v4, v5}, Lco/vine/android/recorder/BaseFinishProcessTask;->publish(I)V

    .line 120
    .end local v3    # "size":I
    :cond_1
    if-eqz v0, :cond_2

    .line 121
    iget-object v2, v0, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;->tag:Ljava/lang/Object;

    check-cast v2, Lco/vine/android/recorder/VideoData;

    .line 122
    .local v2, "next":Lco/vine/android/recorder/VideoData;
    iget-object v4, v0, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;->bytes:[B

    iput-object v4, v2, Lco/vine/android/recorder/VideoData;->data:[B

    .line 124
    :try_start_0
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    iget-object v5, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    invoke-virtual {v4, v5, v2}, Lco/vine/android/recorder/SwEncodingRunnable;->processVideoData(Ljava/util/LinkedList;Lco/vine/android/recorder/VideoData;)[B
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 125
    :catch_0
    move-exception v1

    .line 126
    .local v1, "e":Ljava/lang/Exception;
    new-instance v4, Ljava/lang/RuntimeException;

    invoke-direct {v4, v1}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/Throwable;)V

    throw v4

    .line 129
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v2    # "next":Lco/vine/android/recorder/VideoData;
    :cond_2
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    # getter for: Lco/vine/android/recorder/SwEncodingRunnable;->mByteBufferQueue:Lco/vine/android/recorder/ByteBufferQueue;
    invoke-static {v4}, Lco/vine/android/recorder/SwEncodingRunnable;->access$100(Lco/vine/android/recorder/SwEncodingRunnable;)Lco/vine/android/recorder/ByteBufferQueue;

    move-result-object v4

    invoke-virtual {v4}, Lco/vine/android/recorder/ByteBufferQueue;->isEndOfPut()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 130
    const/4 v4, 0x0

    iput-boolean v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mRun:Z

    goto :goto_0

    .line 133
    :cond_3
    const-wide/16 v4, 0x32

    :try_start_1
    invoke-static {v4, v5}, Ljava/lang/Thread;->sleep(J)V
    :try_end_1
    .catch Ljava/lang/InterruptedException; {:try_start_1 .. :try_end_1} :catch_1

    goto/16 :goto_0

    .line 134
    :catch_1
    move-exception v1

    .line 135
    .local v1, "e":Ljava/lang/InterruptedException;
    const-string v4, "Interrupted."

    invoke-static {v4}, Lcom/edisonwang/android/slog/SLog;->e(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 140
    .end local v0    # "data":Lco/vine/android/recorder/ByteBufferQueue$QueueItem;
    .end local v1    # "e":Ljava/lang/InterruptedException;
    :cond_4
    iget-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    iget-object v5, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mBufferedVideoData:Ljava/util/LinkedList;

    # invokes: Lco/vine/android/recorder/SwEncodingRunnable;->stopEncoder(Ljava/util/LinkedList;)V
    invoke-static {v4, v5}, Lco/vine/android/recorder/SwEncodingRunnable;->access$400(Lco/vine/android/recorder/SwEncodingRunnable;Ljava/util/LinkedList;)V

    .line 141
    const/4 v4, 0x0

    iput-object v4, p0, Lco/vine/android/recorder/SwEncodingRunnable$EncodingProcessRunnable;->mParent:Lco/vine/android/recorder/SwEncodingRunnable;

    .line 142
    return-void
.end method
