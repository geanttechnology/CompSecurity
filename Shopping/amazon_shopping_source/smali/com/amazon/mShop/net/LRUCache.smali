.class public Lcom/amazon/mShop/net/LRUCache;
.super Ljava/util/LinkedHashMap;
.source "LRUCache.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
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
        "<TK;TV;>;",
        "Lcom/amazon/mShop/model/auth/UserListener;"
    }
.end annotation


# static fields
.field private static mCurrentLimit:J

.field private static volatile sCacheGets:D

.field private static volatile sCacheHits:D

.field private static final sGlobalCache:Lcom/amazon/mShop/net/LRUCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/net/LRUCache",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private mBitmapSize:J

.field private final mInsertTime:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/net/LRUCache$TimeAttachment;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const-wide/16 v2, 0x0

    .line 57
    new-instance v0, Lcom/amazon/mShop/net/LRUCache;

    invoke-direct {v0}, Lcom/amazon/mShop/net/LRUCache;-><init>()V

    sput-object v0, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    .line 72
    const-wide/32 v0, 0x500000

    sput-wide v0, Lcom/amazon/mShop/net/LRUCache;->mCurrentLimit:J

    .line 93
    sput-wide v2, Lcom/amazon/mShop/net/LRUCache;->sCacheGets:D

    .line 94
    sput-wide v2, Lcom/amazon/mShop/net/LRUCache;->sCacheHits:D

    return-void
.end method

.method private constructor <init>()V
    .locals 3

    .prologue
    .line 89
    .local p0, "this":Lcom/amazon/mShop/net/LRUCache;, "Lcom/amazon/mShop/net/LRUCache<TK;TV;>;"
    const/16 v0, 0xc8

    const/high16 v1, 0x3f400000    # 0.75f

    const/4 v2, 0x1

    invoke-direct {p0, v0, v1, v2}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    .line 78
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    .line 99
    const-wide/16 v0, 0x0

    iput-wide v0, p0, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    .line 90
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 91
    return-void
.end method

.method public static clearCache()V
    .locals 4

    .prologue
    .line 238
    sget-object v1, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    monitor-enter v1

    .line 239
    :try_start_0
    sget-object v0, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/LRUCache;->clear()V

    .line 240
    sget-object v0, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-object v0, v0, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 241
    sget-object v0, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    const-wide/16 v2, 0x0

    iput-wide v2, v0, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    .line 242
    monitor-exit v1

    .line 243
    return-void

    .line 242
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public static getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;
    .locals 14
    .param p0, "uriStr"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/Class",
            "<*>;)",
            "Ljava/lang/Object;"
        }
    .end annotation

    .prologue
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<*>;"
    const-wide/high16 v12, 0x3ff0000000000000L    # 1.0

    .line 119
    const/4 v1, 0x0

    .line 120
    .local v1, "o":Ljava/lang/Object;
    if-nez p0, :cond_1

    .line 121
    sget-wide v4, Lcom/amazon/mShop/net/LRUCache;->sCacheGets:D

    add-double/2addr v4, v12

    sput-wide v4, Lcom/amazon/mShop/net/LRUCache;->sCacheGets:D

    .line 161
    .end local v1    # "o":Ljava/lang/Object;
    :cond_0
    :goto_0
    return-object v1

    .line 128
    .restart local v1    # "o":Ljava/lang/Object;
    :cond_1
    invoke-static {p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->uriStrToKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 130
    .local v0, "key":Ljava/lang/String;
    sget-object v5, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    monitor-enter v5

    .line 131
    :try_start_0
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-object v4, v4, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-interface {v4, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;

    .line 132
    .local v3, "ta":Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
    if-eqz v3, :cond_4

    invoke-virtual {v3}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->getTime()Ljava/lang/Long;

    move-result-object v2

    .line 133
    .local v2, "t":Ljava/lang/Long;
    :goto_1
    if-eqz v2, :cond_5

    const-wide/32 v6, 0x36ee80

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v8

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    sub-long/2addr v8, v10

    cmp-long v4, v6, v8

    if-gez v4, :cond_5

    .line 137
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    invoke-virtual {v4, v0}, Lcom/amazon/mShop/net/LRUCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 138
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-object v4, v4, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-interface {v4, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    .end local v1    # "o":Ljava/lang/Object;
    :cond_2
    :goto_2
    if-eqz v1, :cond_3

    invoke-virtual {p1, v1}, Ljava/lang/Class;->isInstance(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_3

    .line 150
    const/4 v1, 0x0

    .line 151
    .restart local v1    # "o":Ljava/lang/Object;
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    invoke-virtual {v4, v0}, Lcom/amazon/mShop/net/LRUCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 152
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-object v4, v4, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-interface {v4, v0}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 155
    .end local v1    # "o":Ljava/lang/Object;
    :cond_3
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 157
    sget-wide v4, Lcom/amazon/mShop/net/LRUCache;->sCacheGets:D

    add-double/2addr v4, v12

    sput-wide v4, Lcom/amazon/mShop/net/LRUCache;->sCacheGets:D

    .line 158
    if-eqz v1, :cond_0

    .line 159
    sget-wide v4, Lcom/amazon/mShop/net/LRUCache;->sCacheHits:D

    add-double/2addr v4, v12

    sput-wide v4, Lcom/amazon/mShop/net/LRUCache;->sCacheHits:D

    goto :goto_0

    .line 132
    .end local v2    # "t":Ljava/lang/Long;
    .restart local v1    # "o":Ljava/lang/Object;
    :cond_4
    const/4 v2, 0x0

    goto :goto_1

    .line 140
    .restart local v2    # "t":Ljava/lang/Long;
    :cond_5
    :try_start_1
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    invoke-virtual {v4, v0}, Lcom/amazon/mShop/net/LRUCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .line 143
    if-eqz v3, :cond_2

    .line 144
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->setTime(Ljava/lang/Long;)V

    goto :goto_2

    .line 155
    .end local v1    # "o":Ljava/lang/Object;
    .end local v2    # "t":Ljava/lang/Long;
    .end local v3    # "ta":Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4
.end method

.method private static makeSortedList()Ljava/util/List;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/net/LRUCache$TimeAttachment;",
            ">;"
        }
    .end annotation

    .prologue
    .line 322
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 323
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/LRUCache$TimeAttachment;>;"
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    monitor-enter v4

    .line 324
    :try_start_0
    sget-object v3, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-object v3, v3, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-interface {v3}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;

    .line 325
    .local v2, "ta":Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
    invoke-interface {v1, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 328
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v2    # "ta":Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 327
    .restart local v0    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    invoke-static {v1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 328
    monitor-exit v4
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 329
    return-object v1
.end method

.method public static onLowMemory()V
    .locals 0

    .prologue
    .line 252
    invoke-static {}, Lcom/amazon/mShop/net/LRUCache;->clearCache()V

    .line 253
    return-void
.end method

.method public static putValue(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p0, "uriStr"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 174
    invoke-static {p0}, Lcom/amazon/mShop/net/MShopDiskCachePolicy;->uriStrToKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 176
    .local v0, "key":Ljava/lang/String;
    invoke-static {v0, p1}, Lcom/amazon/mShop/net/LRUCache;->putValueWithKey(Ljava/lang/String;Ljava/lang/Object;)V

    .line 177
    return-void
.end method

.method public static putValueWithKey(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 8
    .param p0, "key"    # Ljava/lang/String;
    .param p1, "value"    # Ljava/lang/Object;

    .prologue
    .line 186
    sget-object v3, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    monitor-enter v3

    .line 187
    :try_start_0
    sget-object v2, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    invoke-virtual {v2, p0, p1}, Lcom/amazon/mShop/net/LRUCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 188
    sget-object v2, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-object v2, v2, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    new-instance v4, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v5

    invoke-static {v5, v6}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v5

    invoke-direct {v4, p0, v5}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;-><init>(Ljava/lang/String;Ljava/lang/Long;)V

    invoke-interface {v2, p0, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 189
    if-eqz p1, :cond_0

    instance-of v2, p1, Landroid/graphics/Bitmap;

    if-eqz v2, :cond_0

    .line 190
    move-object v0, p1

    check-cast v0, Landroid/graphics/Bitmap;

    move-object v1, v0

    .line 191
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    sget-object v2, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-wide v4, v2, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    invoke-static {v1}, Lcom/amazon/mShop/util/ImageUtil;->sizeOfBitmap(Landroid/graphics/Bitmap;)J

    move-result-wide v6

    add-long/2addr v4, v6

    iput-wide v4, v2, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    .line 192
    sget-object v2, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-wide v4, v2, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    sget-wide v6, Lcom/amazon/mShop/net/LRUCache;->mCurrentLimit:J

    cmp-long v2, v4, v6

    if-lez v2, :cond_0

    .line 195
    const/16 v2, 0x19

    invoke-static {v2}, Lcom/amazon/mShop/net/LRUCache;->reduceByPercent(I)V

    .line 201
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    :cond_0
    monitor-exit v3

    .line 202
    return-void

    .line 201
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public static reduceByPercent(I)V
    .locals 8
    .param p0, "percent"    # I

    .prologue
    .line 336
    const/16 v4, 0x64

    if-lt p0, v4, :cond_0

    .line 337
    invoke-static {}, Lcom/amazon/mShop/net/LRUCache;->clearCache()V

    .line 349
    :goto_0
    return-void

    .line 341
    :cond_0
    if-gez p0, :cond_1

    .line 342
    const/4 p0, 0x0

    .line 343
    goto :goto_0

    .line 346
    :cond_1
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-wide v0, v4, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    .line 347
    .local v0, "size":J
    int-to-long v4, p0

    mul-long/2addr v4, v0

    const-wide/16 v6, 0x64

    div-long v2, v4, v6

    .line 348
    .local v2, "sizePercent":J
    invoke-static {v2, v3}, Lcom/amazon/mShop/net/LRUCache;->reduceBySize(J)V

    goto :goto_0
.end method

.method public static reduceBySize(J)V
    .locals 1
    .param p0, "size"    # J

    .prologue
    .line 287
    invoke-static {}, Lcom/amazon/mShop/net/LRUCache;->makeSortedList()Ljava/util/List;

    move-result-object v0

    invoke-static {v0, p0, p1}, Lcom/amazon/mShop/net/LRUCache;->reduceBySizeInternal(Ljava/util/List;J)J

    .line 288
    return-void
.end method

.method private static reduceBySizeInternal(Ljava/util/List;J)J
    .locals 13
    .param p1, "size"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/net/LRUCache$TimeAttachment;",
            ">;J)J"
        }
    .end annotation

    .prologue
    .line 297
    .local p0, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/net/LRUCache$TimeAttachment;>;"
    const-wide/16 v6, 0x0

    .line 298
    .local v6, "reduced":J
    sget-object v10, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    monitor-enter v10

    .line 299
    const-wide/16 v11, 0x0

    cmp-long v9, p1, v11

    if-lez v9, :cond_1

    .line 300
    :try_start_0
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v9

    if-eqz v9, :cond_1

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;

    .line 301
    .local v8, "ta":Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
    if-eqz v8, :cond_0

    .line 302
    sget-object v9, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    invoke-virtual {v8}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->getKey()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Lcom/amazon/mShop/net/LRUCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    .line 303
    .local v5, "o":Ljava/lang/Object;
    if-eqz v5, :cond_0

    instance-of v9, v5, Landroid/graphics/Bitmap;

    if-eqz v9, :cond_0

    .line 304
    move-object v0, v5

    check-cast v0, Landroid/graphics/Bitmap;

    move-object v1, v0

    .line 305
    .local v1, "bitmap":Landroid/graphics/Bitmap;
    invoke-static {v1}, Lcom/amazon/mShop/util/ImageUtil;->sizeOfBitmap(Landroid/graphics/Bitmap;)J

    move-result-wide v2

    .line 306
    .local v2, "bitmapSize":J
    add-long/2addr v6, v2

    .line 307
    sget-object v9, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    invoke-virtual {v8}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->getKey()Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v9, v11}, Lcom/amazon/mShop/net/LRUCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 308
    sget-object v9, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-object v9, v9, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-virtual {v8}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->getKey()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v9, v11}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 309
    sget-object v9, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-wide v11, v9, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    sub-long/2addr v11, v2

    iput-wide v11, v9, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    .line 310
    cmp-long v9, v6, p1

    if-ltz v9, :cond_0

    .line 317
    .end local v1    # "bitmap":Landroid/graphics/Bitmap;
    .end local v2    # "bitmapSize":J
    .end local v4    # "i$":Ljava/util/Iterator;
    .end local v5    # "o":Ljava/lang/Object;
    .end local v8    # "ta":Lcom/amazon/mShop/net/LRUCache$TimeAttachment;
    :cond_1
    monitor-exit v10

    .line 318
    return-wide v6

    .line 317
    :catchall_0
    move-exception v9

    monitor-exit v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v9
.end method

.method public static setCacheLimit(J)V
    .locals 0
    .param p0, "size"    # J

    .prologue
    .line 265
    sput-wide p0, Lcom/amazon/mShop/net/LRUCache;->mCurrentLimit:J

    .line 266
    return-void
.end method


# virtual methods
.method protected removeEldestEntry(Ljava/util/Map$Entry;)Z
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map$Entry",
            "<TK;TV;>;)Z"
        }
    .end annotation

    .prologue
    .line 211
    .local p0, "this":Lcom/amazon/mShop/net/LRUCache;, "Lcom/amazon/mShop/net/LRUCache<TK;TV;>;"
    .local p1, "eldest":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    sget-object v4, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    monitor-enter v4

    .line 212
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mShop/net/LRUCache;->size()I

    move-result v3

    const/16 v5, 0xc8

    if-le v3, v5, :cond_2

    const/4 v1, 0x1

    .line 214
    .local v1, "remove":Z
    :goto_0
    if-nez v1, :cond_0

    .line 215
    iget-object v3, p0, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;

    invoke-virtual {v3}, Lcom/amazon/mShop/net/LRUCache$TimeAttachment;->getTime()Ljava/lang/Long;

    move-result-object v2

    .line 216
    .local v2, "t":Ljava/lang/Long;
    if-eqz v2, :cond_0

    const-wide/32 v5, 0x36ee80

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v7

    invoke-virtual {v2}, Ljava/lang/Long;->longValue()J

    move-result-wide v9

    sub-long/2addr v7, v9

    cmp-long v3, v5, v7

    if-gez v3, :cond_0

    .line 217
    const/4 v1, 0x1

    .line 220
    .end local v2    # "t":Ljava/lang/Long;
    :cond_0
    if-eqz v1, :cond_1

    .line 224
    iget-object v3, p0, Lcom/amazon/mShop/net/LRUCache;->mInsertTime:Ljava/util/Map;

    invoke-interface {p1}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    invoke-interface {v3, v5}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 225
    invoke-interface {p1}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v0

    .line 226
    .local v0, "o":Ljava/lang/Object;
    if-eqz v0, :cond_1

    instance-of v3, v0, Landroid/graphics/Bitmap;

    if-eqz v3, :cond_1

    .line 227
    sget-object v3, Lcom/amazon/mShop/net/LRUCache;->sGlobalCache:Lcom/amazon/mShop/net/LRUCache;

    iget-wide v5, v3, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    check-cast v0, Landroid/graphics/Bitmap;

    .end local v0    # "o":Ljava/lang/Object;
    invoke-static {v0}, Lcom/amazon/mShop/util/ImageUtil;->sizeOfBitmap(Landroid/graphics/Bitmap;)J

    move-result-wide v7

    sub-long/2addr v5, v7

    iput-wide v5, v3, Lcom/amazon/mShop/net/LRUCache;->mBitmapSize:J

    .line 230
    :cond_1
    monitor-exit v4

    return v1

    .line 212
    .end local v1    # "remove":Z
    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    .line 231
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 275
    .local p0, "this":Lcom/amazon/mShop/net/LRUCache;, "Lcom/amazon/mShop/net/LRUCache<TK;TV;>;"
    return-void
.end method

.method public userSignedOut()V
    .locals 0

    .prologue
    .line 279
    .local p0, "this":Lcom/amazon/mShop/net/LRUCache;, "Lcom/amazon/mShop/net/LRUCache<TK;TV;>;"
    invoke-static {}, Lcom/amazon/mShop/net/LRUCache;->clearCache()V

    .line 280
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 271
    .local p0, "this":Lcom/amazon/mShop/net/LRUCache;, "Lcom/amazon/mShop/net/LRUCache<TK;TV;>;"
    return-void
.end method
