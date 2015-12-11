.class public Lco/vine/android/recorder/ByteBufferQueue;
.super Ljava/lang/Object;
.source "ByteBufferQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/recorder/ByteBufferQueue$QueueItem;,
        Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;
    }
.end annotation


# static fields
.field private static final sQueues:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Lco/vine/android/recorder/ByteBufferQueue;",
            ">;>;"
        }
    .end annotation
.end field


# instance fields
.field private final LOCK:[I

.field private mBuffer:Ljava/nio/ByteBuffer;

.field private mBufferPointer:Lcom/googlecode/javacpp/BytePointer;

.field private mGetBuffer:[B

.field private mInitialCount:I

.field private mPutHasEnded:Z

.field private mSpaceLeft:I

.field private mStartIndex:I

.field private mStarts:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation
.end field

.field private mTags:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/ref/WeakReference",
            "<",
            "Ljava/lang/Object;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lco/vine/android/recorder/ByteBufferQueue;->sQueues:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>(IILco/vine/android/recorder/ByteBufferQueue$MemoryResponder;)V
    .locals 14
    .param p1, "count"    # I
    .param p2, "singleCapacity"    # I
    .param p3, "memoryResponder"    # Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;

    .prologue
    .line 34
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const/4 v9, 0x0

    new-array v9, v9, [I

    iput-object v9, p0, Lco/vine/android/recorder/ByteBufferQueue;->LOCK:[I

    .line 35
    sget-object v9, Lco/vine/android/recorder/ByteBufferQueue;->sQueues:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->size()I

    move-result v9

    const/16 v10, 0x14

    if-le v9, v10, :cond_0

    .line 36
    sget-object v9, Lco/vine/android/recorder/ByteBufferQueue;->sQueues:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->clear()V

    .line 38
    :cond_0
    sget-object v9, Lco/vine/android/recorder/ByteBufferQueue;->sQueues:Ljava/util/ArrayList;

    new-instance v10, Ljava/lang/ref/WeakReference;

    invoke-direct {v10, p0}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v9, v10}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 39
    const/4 v4, 0x0

    .line 40
    .local v4, "n":I
    sget-object v9, Lco/vine/android/recorder/ByteBufferQueue;->sQueues:Ljava/util/ArrayList;

    invoke-virtual {v9}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_1
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/ref/WeakReference;

    .line 41
    .local v5, "queue":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/recorder/ByteBufferQueue;>;"
    invoke-virtual {v5}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v9

    if-eqz v9, :cond_1

    .line 42
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .line 45
    .end local v5    # "queue":Ljava/lang/ref/WeakReference;, "Ljava/lang/ref/WeakReference<Lco/vine/android/recorder/ByteBufferQueue;>;"
    :cond_2
    const-string v9, "[mem] Current byte buffer queue count: {}."

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Lco/vine/android/util/CrashUtil;->log(Ljava/lang/String;[Ljava/lang/Object;)V

    .line 47
    sget-boolean v9, Lcom/edisonwang/android/slog/SLog;->sLogsOn:Z

    if-eqz v9, :cond_3

    .line 48
    invoke-static {}, Ljava/lang/Runtime;->getRuntime()Ljava/lang/Runtime;

    move-result-object v6

    .line 49
    .local v6, "runtime":Ljava/lang/Runtime;
    invoke-virtual {v6}, Ljava/lang/Runtime;->totalMemory()J

    move-result-wide v9

    invoke-virtual {v6}, Ljava/lang/Runtime;->freeMemory()J

    move-result-wide v11

    sub-long/2addr v9, v11

    const-wide/32 v11, 0x100000

    div-long v7, v9, v11

    .line 50
    .local v7, "usedMem":J
    invoke-virtual {v6}, Ljava/lang/Runtime;->maxMemory()J

    move-result-wide v9

    const-wide/32 v11, 0x100000

    div-long v2, v9, v11

    .line 52
    .local v2, "maxHeap":J
    const-string v9, "[mem] Allocating: {}."

    mul-int v10, p2, p1

    int-to-long v10, v10

    const-wide/32 v12, 0x100000

    div-long/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 53
    const-string v9, "[mem] Free: {}."

    invoke-virtual {v6}, Ljava/lang/Runtime;->freeMemory()J

    move-result-wide v10

    const-wide/32 v12, 0x100000

    div-long/2addr v10, v12

    invoke-static {v10, v11}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 54
    const-string v9, "[mem] Used mem: {}."

    invoke-static {v7, v8}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 55
    const-string v9, "[mem] Max mem: {}."

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v10

    invoke-static {v9, v10}, Lcom/edisonwang/android/slog/SLog;->d(Ljava/lang/String;Ljava/lang/Object;)V

    .line 58
    .end local v2    # "maxHeap":J
    .end local v6    # "runtime":Ljava/lang/Runtime;
    .end local v7    # "usedMem":J
    :cond_3
    :try_start_0
    invoke-virtual/range {p0 .. p2}, Lco/vine/android/recorder/ByteBufferQueue;->reset(II)V
    :try_end_0
    .catch Ljava/lang/OutOfMemoryError; {:try_start_0 .. :try_end_0} :catch_0

    .line 66
    :goto_1
    return-void

    .line 59
    :catch_0
    move-exception v0

    .line 60
    .local v0, "e":Ljava/lang/OutOfMemoryError;
    if-eqz p3, :cond_4

    .line 61
    invoke-interface/range {p3 .. p3}, Lco/vine/android/recorder/ByteBufferQueue$MemoryResponder;->requestForMoreMemory()V

    .line 63
    :cond_4
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 64
    invoke-virtual/range {p0 .. p2}, Lco/vine/android/recorder/ByteBufferQueue;->reset(II)V

    goto :goto_1
.end method


# virtual methods
.method public endOfPut()V
    .locals 1

    .prologue
    .line 126
    const/4 v0, 0x1

    iput-boolean v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mPutHasEnded:Z

    .line 127
    return-void
.end method

.method protected finalize()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 93
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 94
    invoke-virtual {p0}, Lco/vine/android/recorder/ByteBufferQueue;->release()V

    .line 95
    return-void
.end method

.method public get()Lco/vine/android/recorder/ByteBufferQueue$QueueItem;
    .locals 6

    .prologue
    .line 145
    iget-object v4, p0, Lco/vine/android/recorder/ByteBufferQueue;->LOCK:[I

    monitor-enter v4

    .line 146
    :try_start_0
    iget v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStartIndex:I

    iget-object v5, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStarts:Ljava/util/ArrayList;

    invoke-virtual {v5}, Ljava/util/ArrayList;->size()I

    move-result v5

    if-ne v3, v5, :cond_0

    .line 147
    const/4 v3, 0x0

    monitor-exit v4

    .line 157
    :goto_0
    return-object v3

    .line 149
    :cond_0
    iget-object v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStarts:Ljava/util/ArrayList;

    iget v5, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStartIndex:I

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Integer;

    .line 150
    .local v0, "next":Ljava/lang/Integer;
    iget-object v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mTags:Ljava/util/ArrayList;

    iget v5, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStartIndex:I

    invoke-virtual {v3, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/ref/WeakReference;

    invoke-virtual {v3}, Ljava/lang/ref/WeakReference;->get()Ljava/lang/Object;

    move-result-object v2

    .line 151
    .local v2, "tag":Ljava/lang/Object;
    iget v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStartIndex:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStartIndex:I

    .line 152
    iget v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mSpaceLeft:I

    add-int/lit8 v3, v3, 0x1

    iput v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mSpaceLeft:I

    .line 153
    iget-object v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v3}, Ljava/nio/ByteBuffer;->position()I

    move-result v1

    .line 154
    .local v1, "originalPosition":I
    iget-object v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v5

    invoke-virtual {v3, v5}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 155
    iget-object v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    iget-object v5, p0, Lco/vine/android/recorder/ByteBufferQueue;->mGetBuffer:[B

    invoke-virtual {v3, v5}, Ljava/nio/ByteBuffer;->get([B)Ljava/nio/ByteBuffer;

    .line 156
    iget-object v3, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v3, v1}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 157
    new-instance v3, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;

    iget-object v5, p0, Lco/vine/android/recorder/ByteBufferQueue;->mGetBuffer:[B

    invoke-direct {v3, v5, v2}, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;-><init>([BLjava/lang/Object;)V

    monitor-exit v4

    goto :goto_0

    .line 158
    .end local v0    # "next":Ljava/lang/Integer;
    .end local v1    # "originalPosition":I
    .end local v2    # "tag":Ljava/lang/Object;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method public isEndOfPut()Z
    .locals 1

    .prologue
    .line 130
    iget-boolean v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mPutHasEnded:Z

    return v0
.end method

.method public isFresh()Z
    .locals 1

    .prologue
    .line 167
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStarts:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public put(Lco/vine/android/recorder/ByteBufferQueue$QueueItem;)Z
    .locals 4
    .param p1, "item"    # Lco/vine/android/recorder/ByteBufferQueue$QueueItem;

    .prologue
    const/4 v0, 0x0

    .line 108
    iget-object v1, p0, Lco/vine/android/recorder/ByteBufferQueue;->LOCK:[I

    monitor-enter v1

    .line 109
    :try_start_0
    iget v2, p0, Lco/vine/android/recorder/ByteBufferQueue;->mSpaceLeft:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lco/vine/android/recorder/ByteBufferQueue;->mSpaceLeft:I

    .line 110
    iget v2, p0, Lco/vine/android/recorder/ByteBufferQueue;->mSpaceLeft:I

    if-gez v2, :cond_0

    .line 111
    monitor-exit v1

    .line 119
    :goto_0
    return v0

    .line 113
    :cond_0
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStarts:Ljava/util/ArrayList;

    iget-object v2, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->position()I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 114
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mTags:Ljava/util/ArrayList;

    new-instance v2, Ljava/lang/ref/WeakReference;

    iget-object v3, p1, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;->tag:Ljava/lang/Object;

    invoke-direct {v2, v3}, Ljava/lang/ref/WeakReference;-><init>(Ljava/lang/Object;)V

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 115
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    iget-object v2, p1, Lco/vine/android/recorder/ByteBufferQueue$QueueItem;->bytes:[B

    invoke-virtual {v0, v2}, Ljava/nio/ByteBuffer;->put([B)Ljava/nio/ByteBuffer;

    .line 116
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->position()I

    move-result v0

    iget-object v2, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v2}, Ljava/nio/ByteBuffer;->limit()I

    move-result v2

    if-ne v0, v2, :cond_1

    .line 117
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 119
    :cond_1
    const/4 v0, 0x1

    monitor-exit v1

    goto :goto_0

    .line 121
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public release()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 98
    iput-object v1, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    .line 99
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBufferPointer:Lcom/googlecode/javacpp/BytePointer;

    if-eqz v0, :cond_1

    .line 100
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBufferPointer:Lcom/googlecode/javacpp/BytePointer;

    invoke-virtual {v0}, Lcom/googlecode/javacpp/BytePointer;->isNull()Z

    move-result v0

    if-nez v0, :cond_0

    .line 101
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBufferPointer:Lcom/googlecode/javacpp/BytePointer;

    invoke-virtual {v0}, Lcom/googlecode/javacpp/BytePointer;->deallocate()V

    .line 103
    :cond_0
    iput-object v1, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBufferPointer:Lcom/googlecode/javacpp/BytePointer;

    .line 105
    :cond_1
    return-void
.end method

.method public reset(II)V
    .locals 3
    .param p1, "count"    # I
    .param p2, "capacity"    # I

    .prologue
    .line 69
    iget-object v1, p0, Lco/vine/android/recorder/ByteBufferQueue;->LOCK:[I

    monitor-enter v1

    .line 70
    :try_start_0
    iput p1, p0, Lco/vine/android/recorder/ByteBufferQueue;->mSpaceLeft:I

    .line 71
    iput p1, p0, Lco/vine/android/recorder/ByteBufferQueue;->mInitialCount:I

    .line 72
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    invoke-virtual {v0}, Ljava/nio/ByteBuffer;->capacity()I

    move-result v0

    mul-int v2, p2, p1

    if-ge v0, v2, :cond_1

    .line 73
    :cond_0
    invoke-virtual {p0}, Lco/vine/android/recorder/ByteBufferQueue;->release()V

    .line 74
    new-instance v0, Lcom/googlecode/javacpp/BytePointer;

    mul-int v2, p2, p1

    invoke-direct {v0, v2}, Lcom/googlecode/javacpp/BytePointer;-><init>(I)V

    iput-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBufferPointer:Lcom/googlecode/javacpp/BytePointer;

    .line 75
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBufferPointer:Lcom/googlecode/javacpp/BytePointer;

    invoke-virtual {v0}, Lcom/googlecode/javacpp/BytePointer;->asByteBuffer()Ljava/nio/ByteBuffer;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    .line 76
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    if-nez v0, :cond_1

    .line 77
    mul-int v0, p2, p1

    invoke-static {v0}, Ljava/nio/ByteBuffer;->allocate(I)Ljava/nio/ByteBuffer;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    .line 80
    :cond_1
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mGetBuffer:[B

    if-eqz v0, :cond_2

    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mGetBuffer:[B

    array-length v0, v0

    if-eq v0, p2, :cond_3

    .line 81
    :cond_2
    new-array v0, p2, [B

    iput-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mGetBuffer:[B

    .line 83
    :cond_3
    iget-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mBuffer:Ljava/nio/ByteBuffer;

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Ljava/nio/ByteBuffer;->position(I)Ljava/nio/Buffer;

    .line 84
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStarts:Ljava/util/ArrayList;

    .line 85
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mTags:Ljava/util/ArrayList;

    .line 86
    const/4 v0, 0x0

    iput-boolean v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mPutHasEnded:Z

    .line 87
    const/4 v0, 0x0

    iput v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mStartIndex:I

    .line 88
    monitor-exit v1

    .line 89
    return-void

    .line 88
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public size()I
    .locals 2

    .prologue
    .line 163
    iget v0, p0, Lco/vine/android/recorder/ByteBufferQueue;->mInitialCount:I

    iget v1, p0, Lco/vine/android/recorder/ByteBufferQueue;->mSpaceLeft:I

    sub-int/2addr v0, v1

    return v0
.end method
