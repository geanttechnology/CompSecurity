.class public Lcom/thin/downloadmanager/DownloadRequestQueue;
.super Ljava/lang/Object;
.source "DownloadRequestQueue.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;
    }
.end annotation


# static fields
.field private static final DEFAULT_DOWNLOAD_THREAD_POOL_SIZE:I = 0x1


# instance fields
.field private mCurrentRequests:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/thin/downloadmanager/DownloadRequest;",
            ">;"
        }
    .end annotation
.end field

.field private mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

.field private mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

.field private mDownloadQueue:Ljava/util/concurrent/PriorityBlockingQueue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/PriorityBlockingQueue",
            "<",
            "Lcom/thin/downloadmanager/DownloadRequest;",
            ">;"
        }
    .end annotation
.end field

.field private mSequenceGenerator:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 82
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    .line 23
    new-instance v0, Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-direct {v0}, Ljava/util/concurrent/PriorityBlockingQueue;-><init>()V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    .line 29
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mSequenceGenerator:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 83
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/thin/downloadmanager/DownloadDispatcher;

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    .line 84
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-direct {v0, p0, v1}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;-><init>(Lcom/thin/downloadmanager/DownloadRequestQueue;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    .line 85
    return-void
.end method

.method public constructor <init>(I)V
    .locals 3
    .param p1, "threadPoolSize"    # I

    .prologue
    .line 90
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    .line 23
    new-instance v0, Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-direct {v0}, Ljava/util/concurrent/PriorityBlockingQueue;-><init>()V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    .line 29
    new-instance v0, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v0}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mSequenceGenerator:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 91
    new-instance v0, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    new-instance v1, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v2

    invoke-direct {v1, v2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    invoke-direct {v0, p0, v1}, Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;-><init>(Lcom/thin/downloadmanager/DownloadRequestQueue;Landroid/os/Handler;)V

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    .line 92
    if-lez p1, :cond_0

    const/4 v0, 0x4

    if-gt p1, v0, :cond_0

    .line 93
    new-array v0, p1, [Lcom/thin/downloadmanager/DownloadDispatcher;

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    .line 97
    :goto_0
    return-void

    .line 95
    :cond_0
    const/4 v0, 0x1

    new-array v0, v0, [Lcom/thin/downloadmanager/DownloadDispatcher;

    iput-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    goto :goto_0
.end method

.method private getDownloadId()I
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mSequenceGenerator:Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-virtual {v0}, Ljava/util/concurrent/atomic/AtomicInteger;->incrementAndGet()I

    move-result v0

    return v0
.end method

.method private stop()V
    .locals 2

    .prologue
    .line 225
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    array-length v1, v1

    if-ge v0, v1, :cond_1

    .line 226
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    aget-object v1, v1, v0

    if-eqz v1, :cond_0

    .line 227
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    aget-object v1, v1, v0

    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadDispatcher;->quit()V

    .line 225
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 230
    :cond_1
    return-void
.end method


# virtual methods
.method add(Lcom/thin/downloadmanager/DownloadRequest;)I
    .locals 3
    .param p1, "request"    # Lcom/thin/downloadmanager/DownloadRequest;

    .prologue
    .line 118
    invoke-direct {p0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->getDownloadId()I

    move-result v0

    .line 120
    .local v0, "downloadId":I
    invoke-virtual {p1, p0}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadRequestQueue(Lcom/thin/downloadmanager/DownloadRequestQueue;)V

    .line 122
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    monitor-enter v2

    .line 123
    :try_start_0
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    invoke-interface {v1, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 124
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 127
    invoke-virtual {p1, v0}, Lcom/thin/downloadmanager/DownloadRequest;->setDownloadId(I)V

    .line 128
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/PriorityBlockingQueue;->add(Ljava/lang/Object;)Z

    .line 130
    return v0

    .line 124
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1
.end method

.method cancel(I)I
    .locals 4
    .param p1, "downloadId"    # I

    .prologue
    .line 172
    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    monitor-enter v3

    .line 173
    :try_start_0
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/thin/downloadmanager/DownloadRequest;

    .line 174
    .local v1, "request":Lcom/thin/downloadmanager/DownloadRequest;
    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v2

    if-ne v2, p1, :cond_0

    .line 175
    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->cancel()V

    .line 176
    const/4 v2, 0x1

    monitor-exit v3

    .line 181
    .end local v1    # "request":Lcom/thin/downloadmanager/DownloadRequest;
    :goto_0
    return v2

    .line 179
    :cond_1
    monitor-exit v3

    .line 181
    const/4 v2, 0x0

    goto :goto_0

    .line 179
    .end local v0    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method cancelAll()V
    .locals 4

    .prologue
    .line 155
    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    monitor-enter v3

    .line 156
    :try_start_0
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/thin/downloadmanager/DownloadRequest;

    .line 157
    .local v1, "request":Lcom/thin/downloadmanager/DownloadRequest;
    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->cancel()V

    goto :goto_0

    .line 162
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "request":Lcom/thin/downloadmanager/DownloadRequest;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2

    .line 161
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->clear()V

    .line 162
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 163
    return-void
.end method

.method finish(Lcom/thin/downloadmanager/DownloadRequest;)V
    .locals 2
    .param p1, "request"    # Lcom/thin/downloadmanager/DownloadRequest;

    .prologue
    .line 185
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    if-eqz v0, :cond_0

    .line 187
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    monitor-enter v1

    .line 188
    :try_start_0
    iget-object v0, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 189
    monitor-exit v1

    .line 191
    :cond_0
    return-void

    .line 189
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method query(I)I
    .locals 4
    .param p1, "downloadId"    # I

    .prologue
    .line 140
    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    monitor-enter v3

    .line 141
    :try_start_0
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/thin/downloadmanager/DownloadRequest;

    .line 142
    .local v1, "request":Lcom/thin/downloadmanager/DownloadRequest;
    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadId()I

    move-result v2

    if-ne v2, p1, :cond_0

    .line 143
    invoke-virtual {v1}, Lcom/thin/downloadmanager/DownloadRequest;->getDownloadState()I

    move-result v2

    monitor-exit v3

    .line 147
    .end local v1    # "request":Lcom/thin/downloadmanager/DownloadRequest;
    :goto_0
    return v2

    .line 146
    :cond_1
    monitor-exit v3

    .line 147
    const/16 v2, 0x20

    goto :goto_0

    .line 146
    .end local v0    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method release()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 197
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    if-eqz v1, :cond_0

    .line 198
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    monitor-enter v2

    .line 199
    :try_start_0
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->clear()V

    .line 200
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mCurrentRequests:Ljava/util/Set;

    .line 201
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 204
    :cond_0
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    if-eqz v1, :cond_1

    .line 205
    iput-object v3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    .line 208
    :cond_1
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    if-eqz v1, :cond_3

    .line 209
    invoke-direct {p0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->stop()V

    .line 211
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    array-length v1, v1

    if-ge v0, v1, :cond_2

    .line 212
    iget-object v1, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    aput-object v3, v1, v0

    .line 211
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 201
    .end local v0    # "i":I
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 214
    .restart local v0    # "i":I
    :cond_2
    iput-object v3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    .line 217
    .end local v0    # "i":I
    :cond_3
    return-void
.end method

.method public start()V
    .locals 4

    .prologue
    .line 100
    invoke-direct {p0}, Lcom/thin/downloadmanager/DownloadRequestQueue;->stop()V

    .line 103
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 104
    new-instance v0, Lcom/thin/downloadmanager/DownloadDispatcher;

    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadQueue:Ljava/util/concurrent/PriorityBlockingQueue;

    iget-object v3, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDelivery:Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;

    invoke-direct {v0, v2, v3}, Lcom/thin/downloadmanager/DownloadDispatcher;-><init>(Ljava/util/concurrent/BlockingQueue;Lcom/thin/downloadmanager/DownloadRequestQueue$CallBackDelivery;)V

    .line 105
    .local v0, "downloadDispatcher":Lcom/thin/downloadmanager/DownloadDispatcher;
    iget-object v2, p0, Lcom/thin/downloadmanager/DownloadRequestQueue;->mDownloadDispatchers:[Lcom/thin/downloadmanager/DownloadDispatcher;

    aput-object v0, v2, v1

    .line 106
    invoke-virtual {v0}, Lcom/thin/downloadmanager/DownloadDispatcher;->start()V

    .line 103
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 108
    .end local v0    # "downloadDispatcher":Lcom/thin/downloadmanager/DownloadDispatcher;
    :cond_0
    return-void
.end method
