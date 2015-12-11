.class public Lcom/amazon/mShop/net/SimpleLruMap;
.super Ljava/util/LinkedHashMap;
.source "SimpleLruMap.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/util/LinkedHashMap",
        "<TK;TV;>;"
    }
.end annotation


# instance fields
.field private mCurrentSize:I

.field private mMaxItemSize:I

.field private mMaxTotalCount:I

.field private mMaxTotalSize:I

.field private mProcessor:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor",
            "<TV;>;"
        }
    .end annotation
.end field

.field private final mReadLock:Ljava/util/concurrent/locks/Lock;

.field private final mReadWriteLock:Ljava/util/concurrent/locks/ReadWriteLock;

.field private final mWriteLock:Ljava/util/concurrent/locks/Lock;


# direct methods
.method private constructor <init>(IIILcom/amazon/mShop/net/SimpleLruMap$DataProcessor;)V
    .locals 3
    .param p1, "maxTotalSize"    # I
    .param p2, "maxItemSize"    # I
    .param p3, "maxTotalCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(III",
            "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor",
            "<TV;>;)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/mShop/net/SimpleLruMap;, "Lcom/amazon/mShop/net/SimpleLruMap<TK;TV;>;"
    .local p4, "processor":Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;, "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor<TV;>;"
    const/4 v2, 0x0

    .line 71
    const/high16 v0, 0x3f400000    # 0.75f

    const/4 v1, 0x1

    invoke-direct {p0, v2, v0, v1}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    .line 37
    new-instance v0, Ljava/util/concurrent/locks/ReentrantReadWriteLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantReadWriteLock;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mReadWriteLock:Ljava/util/concurrent/locks/ReadWriteLock;

    .line 38
    iget-object v0, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mReadWriteLock:Ljava/util/concurrent/locks/ReadWriteLock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/ReadWriteLock;->readLock()Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mReadLock:Ljava/util/concurrent/locks/Lock;

    .line 39
    iget-object v0, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mReadWriteLock:Ljava/util/concurrent/locks/ReadWriteLock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/ReadWriteLock;->writeLock()Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mWriteLock:Ljava/util/concurrent/locks/Lock;

    .line 72
    iput p1, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mMaxTotalSize:I

    .line 73
    iput p2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mMaxItemSize:I

    .line 74
    iput p3, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mMaxTotalCount:I

    .line 75
    iput-object p4, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mProcessor:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    .line 76
    iput v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    .line 77
    return-void
.end method

.method public constructor <init>(IILcom/amazon/mShop/net/SimpleLruMap$DataProcessor;)V
    .locals 1
    .param p1, "maxTotalSize"    # I
    .param p2, "maxItemSize"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(II",
            "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor",
            "<TV;>;)V"
        }
    .end annotation

    .prologue
    .line 49
    .local p0, "this":Lcom/amazon/mShop/net/SimpleLruMap;, "Lcom/amazon/mShop/net/SimpleLruMap<TK;TV;>;"
    .local p3, "processor":Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;, "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor<TV;>;"
    const v0, 0x7fffffff

    invoke-direct {p0, p1, p2, v0, p3}, Lcom/amazon/mShop/net/SimpleLruMap;-><init>(IIILcom/amazon/mShop/net/SimpleLruMap$DataProcessor;)V

    .line 50
    return-void
.end method

.method public constructor <init>(ILcom/amazon/mShop/net/SimpleLruMap$DataProcessor;)V
    .locals 1
    .param p1, "maxTotalCount"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor",
            "<TV;>;)V"
        }
    .end annotation

    .prologue
    .local p0, "this":Lcom/amazon/mShop/net/SimpleLruMap;, "Lcom/amazon/mShop/net/SimpleLruMap<TK;TV;>;"
    .local p2, "processor":Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;, "Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor<TV;>;"
    const v0, 0x7fffffff

    .line 59
    invoke-direct {p0, v0, v0, p1, p2}, Lcom/amazon/mShop/net/SimpleLruMap;-><init>(IIILcom/amazon/mShop/net/SimpleLruMap$DataProcessor;)V

    .line 60
    return-void
.end method


# virtual methods
.method public addItem(Ljava/lang/Object;Ljava/lang/Object;)Z
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)Z"
        }
    .end annotation

    .prologue
    .line 89
    .local p0, "this":Lcom/amazon/mShop/net/SimpleLruMap;, "Lcom/amazon/mShop/net/SimpleLruMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Ljava/lang/Object;, "TV;"
    const/4 v6, 0x0

    .line 91
    .local v6, "status":Z
    iget-object v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mWriteLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v7}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 94
    :try_start_0
    iget-object v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mProcessor:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    invoke-interface {v7, p2}, Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;->getSize(Ljava/lang/Object;)I

    move-result v2

    .line 95
    .local v2, "newItemSize":I
    iget v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mMaxItemSize:I

    if-gt v2, v7, :cond_5

    .line 100
    move v0, v2

    .line 101
    .local v0, "averageItemSize":I
    invoke-virtual {p0}, Lcom/amazon/mShop/net/SimpleLruMap;->size()I

    move-result v7

    if-eqz v7, :cond_0

    .line 102
    iget v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    invoke-virtual {p0}, Lcom/amazon/mShop/net/SimpleLruMap;->size()I

    move-result v8

    div-int v0, v7, v8

    .line 104
    :cond_0
    const/4 v1, 0x1

    .line 105
    .local v1, "maxRepeatTime":I
    if-eqz v0, :cond_1

    .line 106
    div-int v7, v2, v0

    mul-int/lit8 v1, v7, 0x2

    .line 114
    :cond_1
    const/4 v5, 0x0

    .line 115
    .local v5, "repeatCount":I
    iget v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    add-int/2addr v7, v2

    iput v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    .line 122
    :cond_2
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/net/SimpleLruMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    .line 123
    .local v3, "oldValue":Ljava/lang/Object;, "TV;"
    if-eqz v3, :cond_3

    if-nez v5, :cond_3

    .line 128
    iget-object v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mProcessor:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    invoke-interface {v7, v3}, Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;->evict(Ljava/lang/Object;)I

    move-result v4

    .line 129
    .local v4, "releasedSize":I
    iget v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    sub-int/2addr v7, v4

    iput v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    .line 132
    .end local v4    # "releasedSize":I
    :cond_3
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/net/SimpleLruMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 133
    add-int/lit8 v5, v5, 0x1

    .line 134
    iget v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    iget v8, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mMaxTotalSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-le v7, v8, :cond_4

    if-lt v5, v1, :cond_2

    .line 136
    :cond_4
    const/4 v6, 0x1

    .line 139
    .end local v0    # "averageItemSize":I
    .end local v1    # "maxRepeatTime":I
    .end local v3    # "oldValue":Ljava/lang/Object;, "TV;"
    .end local v5    # "repeatCount":I
    :cond_5
    iget-object v7, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mWriteLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v7}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 142
    return v6

    .line 139
    .end local v2    # "newItemSize":I
    :catchall_0
    move-exception v7

    iget-object v8, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mWriteLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v8}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v7
.end method

.method public getItem(Ljava/lang/Object;)Ljava/lang/Object;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .prologue
    .line 153
    .local p0, "this":Lcom/amazon/mShop/net/SimpleLruMap;, "Lcom/amazon/mShop/net/SimpleLruMap<TK;TV;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iget-object v1, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mReadLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 156
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/net/SimpleLruMap;->get(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 158
    .local v0, "value":Ljava/lang/Object;, "TV;"
    iget-object v1, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mReadLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 161
    if-eqz v0, :cond_0

    .line 167
    iget-object v1, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mProcessor:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-interface {v1, v0, v2, v3}, Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;->setAccessTime(Ljava/lang/Object;J)V

    .line 169
    :cond_0
    return-object v0

    .line 158
    .end local v0    # "value":Ljava/lang/Object;, "TV;"
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mReadLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method

.method protected removeEldestEntry(Ljava/util/Map$Entry;)Z
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;)Z"
        }
    .end annotation

    .prologue
    .line 220
    .local p0, "this":Lcom/amazon/mShop/net/SimpleLruMap;, "Lcom/amazon/mShop/net/SimpleLruMap<TK;TV;>;"
    .local p1, "eldest":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    const/4 v1, 0x0

    .line 222
    .local v1, "status":Z
    iget-object v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mWriteLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 224
    :try_start_0
    iget v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    iget v3, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mMaxTotalSize:I

    if-gt v2, v3, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/net/SimpleLruMap;->size()I

    move-result v2

    iget v3, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mMaxTotalCount:I

    if-le v2, v3, :cond_1

    .line 225
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mProcessor:Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/amazon/mShop/net/SimpleLruMap$DataProcessor;->evict(Ljava/lang/Object;)I

    move-result v0

    .line 226
    .local v0, "releasedSize":I
    iget v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I

    sub-int/2addr v2, v0

    iput v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mCurrentSize:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 227
    const/4 v1, 0x1

    .line 230
    .end local v0    # "releasedSize":I
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mWriteLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 233
    return v1

    .line 230
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/amazon/mShop/net/SimpleLruMap;->mWriteLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v2
.end method
