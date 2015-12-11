.class public abstract Lco/vine/android/util/UrlResourceCache;
.super Ljava/lang/Object;
.source "UrlResourceCache.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lco/vine/android/util/UrlResourceCache$ResultRunnable;,
        Lco/vine/android/util/UrlResourceCache$ResourceHttpOperationReader;,
        Lco/vine/android/util/UrlResourceCache$MemoryLruCache;,
        Lco/vine/android/util/UrlResourceCache$FetchRunnable;,
        Lco/vine/android/util/UrlResourceCache$QueueRunnable;,
        Lco/vine/android/util/UrlResourceCache$PendingRes;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<K:",
        "Ljava/lang/Object;",
        "V:",
        "Lco/vine/android/util/UrlResource",
        "<TT;>;T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;"
    }
.end annotation


# static fields
.field protected static final IO_BUFFER_SIZE:I = 0x1000

.field protected static final LOGGABLE:Z

.field static final NEXT_REQUEST_INTERVAL:J = 0xea60L

.field private static final POST_DELAY_MILLIS:J = 0x64L

.field protected static final TAG:Ljava/lang/String; = "ResourceCache"

.field protected static final sExecutor:Ljava/util/concurrent/ExecutorService;

.field private static final sMainHandler:Landroid/os/Handler;


# instance fields
.field private mCacheBinder:Lco/vine/android/util/CacheBinder;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lco/vine/android/util/CacheBinder",
            "<TK;TV;>;"
        }
    .end annotation
.end field

.field protected final mContext:Landroid/content/Context;

.field final mLock:[I

.field protected final mPendingDownload:Ljava/util/LinkedHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/LinkedHashMap",
            "<TK;",
            "Lco/vine/android/util/UrlResourceCache$PendingRes;",
            ">;"
        }
    .end annotation
.end field

.field protected final mQueuedDownload:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<TK;",
            "Lco/vine/android/util/UrlResourceCache$PendingRes;",
            ">;"
        }
    .end annotation
.end field

.field private final mResourceCache:Landroid/support/v4/util/LruCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Landroid/support/v4/util/LruCache",
            "<TK;TV;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 31
    const-string v0, "ResourceCache"

    const/4 v1, 0x3

    invoke-static {v0, v1}, Landroid/util/Log;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    sput-boolean v0, Lco/vine/android/util/UrlResourceCache;->LOGGABLE:Z

    .line 33
    invoke-static {}, Ljava/util/concurrent/Executors;->newSingleThreadExecutor()Ljava/util/concurrent/ExecutorService;

    move-result-object v0

    sput-object v0, Lco/vine/android/util/UrlResourceCache;->sExecutor:Ljava/util/concurrent/ExecutorService;

    .line 36
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    sput-object v0, Lco/vine/android/util/UrlResourceCache;->sMainHandler:Landroid/os/Handler;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;I)V
    .locals 4
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "maxCacheSize"    # I

    .prologue
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    const/16 v3, 0x14

    const/high16 v2, 0x41200000    # 10.0f

    .line 58
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 48
    const/4 v0, 0x0

    new-array v0, v0, [I

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mLock:[I

    .line 59
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mContext:Landroid/content/Context;

    .line 60
    new-instance v0, Ljava/util/LinkedHashMap;

    const/4 v1, 0x1

    invoke-direct {v0, v3, v2, v1}, Ljava/util/LinkedHashMap;-><init>(IFZ)V

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mPendingDownload:Ljava/util/LinkedHashMap;

    .line 61
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0, v3, v2}, Ljava/util/HashMap;-><init>(IF)V

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mQueuedDownload:Ljava/util/HashMap;

    .line 62
    if-lez p2, :cond_0

    .line 63
    new-instance v0, Lco/vine/android/util/UrlResourceCache$MemoryLruCache;

    invoke-direct {v0, p2}, Lco/vine/android/util/UrlResourceCache$MemoryLruCache;-><init>(I)V

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    .line 67
    :goto_0
    return-void

    .line 65
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    goto :goto_0
.end method

.method static synthetic access$000()Landroid/os/Handler;
    .locals 1

    .prologue
    .line 27
    sget-object v0, Lco/vine/android/util/UrlResourceCache;->sMainHandler:Landroid/os/Handler;

    return-object v0
.end method

.method private queueResourceLoad(JLjava/lang/Object;Ljava/lang/String;ZZ)Lco/vine/android/util/UrlResource;
    .locals 6
    .param p1, "ownerId"    # J
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "persist"    # Z
    .param p6, "isPeekOnly"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTK;",
            "Ljava/lang/String;",
            "ZZ)TV;"
        }
    .end annotation

    .prologue
    .line 240
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p3, "key":Ljava/lang/Object;, "TK;"
    invoke-static {p4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 241
    if-eqz p6, :cond_0

    .line 242
    invoke-virtual {p0, p1, p2, p3, p4}, Lco/vine/android/util/UrlResourceCache;->loadResource(JLjava/lang/Object;Ljava/lang/String;)Lco/vine/android/util/UrlResource;

    move-result-object v1

    .line 257
    :goto_0
    return-object v1

    .line 244
    :cond_0
    iget-object v2, p0, Lco/vine/android/util/UrlResourceCache;->mLock:[I

    monitor-enter v2

    .line 245
    :try_start_0
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mPendingDownload:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p3}, Ljava/util/LinkedHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 246
    new-instance v0, Lco/vine/android/util/UrlResourceCache$PendingRes;

    invoke-direct {v0, p4, p5}, Lco/vine/android/util/UrlResourceCache$PendingRes;-><init>(Ljava/lang/String;Z)V

    .line 247
    .local v0, "pendingRes":Lco/vine/android/util/UrlResourceCache$PendingRes;
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mPendingDownload:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p3, v0}, Ljava/util/LinkedHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 248
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mQueuedDownload:Ljava/util/HashMap;

    invoke-virtual {v1, p3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 252
    sget-object v1, Lco/vine/android/util/UrlResourceCache;->sMainHandler:Landroid/os/Handler;

    new-instance v3, Lco/vine/android/util/UrlResourceCache$QueueRunnable;

    invoke-direct {v3, p0, p1, p2}, Lco/vine/android/util/UrlResourceCache$QueueRunnable;-><init>(Lco/vine/android/util/UrlResourceCache;J)V

    const-wide/16 v4, 0x64

    invoke-virtual {v1, v3, v4, v5}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 254
    .end local v0    # "pendingRes":Lco/vine/android/util/UrlResourceCache$PendingRes;
    :cond_1
    monitor-exit v2

    .line 257
    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    .line 254
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method


# virtual methods
.method public cancel(Ljava/lang/Object;)I
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)I"
        }
    .end annotation

    .prologue
    .line 150
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iget-object v2, p0, Lco/vine/android/util/UrlResourceCache;->mLock:[I

    monitor-enter v2

    .line 151
    :try_start_0
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mQueuedDownload:Ljava/util/HashMap;

    invoke-virtual {v1, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/UrlResourceCache$PendingRes;

    .line 152
    .local v0, "pendingRes":Lco/vine/android/util/UrlResourceCache$PendingRes;
    if-eqz v0, :cond_0

    .line 153
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mPendingDownload:Ljava/util/LinkedHashMap;

    invoke-virtual {v1, p1}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    const/4 v1, 0x1

    monitor-exit v2

    .line 157
    :goto_0
    return v1

    .line 156
    :cond_0
    monitor-exit v2

    .line 157
    const/4 v1, 0x0

    goto :goto_0

    .line 156
    .end local v0    # "pendingRes":Lco/vine/android/util/UrlResourceCache$PendingRes;
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public cancel(Ljava/util/List;)I
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<TK;>;)I"
        }
    .end annotation

    .prologue
    .line 167
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p1, "keys":Ljava/util/List;, "Ljava/util/List<TK;>;"
    const/4 v0, 0x0

    .line 168
    .local v0, "count":I
    iget-object v4, p0, Lco/vine/android/util/UrlResourceCache;->mLock:[I

    monitor-enter v4

    .line 169
    :try_start_0
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    .line 170
    .local v2, "key":Ljava/lang/Object;, "TK;"
    invoke-virtual {p0, v2}, Lco/vine/android/util/UrlResourceCache;->cancel(Ljava/lang/Object;)I

    move-result v3

    add-int/2addr v0, v3

    .line 171
    goto :goto_0

    .line 172
    .end local v2    # "key":Ljava/lang/Object;, "TK;"
    :cond_0
    monitor-exit v4

    .line 173
    return v0

    .line 172
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v3

    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3
.end method

.method public clear()V
    .locals 2

    .prologue
    .line 77
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    if-eqz v0, :cond_0

    .line 78
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    monitor-enter v1

    .line 79
    :try_start_0
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0}, Landroid/support/v4/util/LruCache;->evictAll()V

    .line 80
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 82
    :cond_0
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mLock:[I

    monitor-enter v1

    .line 83
    :try_start_1
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mPendingDownload:Ljava/util/LinkedHashMap;

    invoke-virtual {v0}, Ljava/util/LinkedHashMap;->clear()V

    .line 84
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 85
    return-void

    .line 80
    :catchall_0
    move-exception v0

    :try_start_2
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    .line 84
    :catchall_1
    move-exception v0

    :try_start_3
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v0
.end method

.method protected final get(JLjava/lang/Object;Ljava/lang/String;Z)Lco/vine/android/util/UrlResource;
    .locals 7
    .param p1, "ownerId"    # J
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "persist"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTK;",
            "Ljava/lang/String;",
            "Z)TV;"
        }
    .end annotation

    .prologue
    .line 189
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p3, "key":Ljava/lang/Object;, "TK;"
    const/4 v6, 0x0

    move-object v0, p0

    move-wide v1, p1

    move-object v3, p3

    move-object v4, p4

    move v5, p5

    invoke-virtual/range {v0 .. v6}, Lco/vine/android/util/UrlResourceCache;->get(JLjava/lang/Object;Ljava/lang/String;ZZ)Lco/vine/android/util/UrlResource;

    move-result-object v0

    return-object v0
.end method

.method protected final get(JLjava/lang/Object;Ljava/lang/String;ZZ)Lco/vine/android/util/UrlResource;
    .locals 5
    .param p1, "ownerId"    # J
    .param p4, "url"    # Ljava/lang/String;
    .param p5, "persist"    # Z
    .param p6, "isPeekOnly"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTK;",
            "Ljava/lang/String;",
            "ZZ)TV;"
        }
    .end annotation

    .prologue
    .line 206
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p3, "key":Ljava/lang/Object;, "TK;"
    if-nez p4, :cond_1

    .line 207
    const/4 v0, 0x0

    .line 236
    :cond_0
    :goto_0
    return-object v0

    .line 209
    :cond_1
    sget-boolean v1, Lco/vine/android/util/UrlResourceCache;->LOGGABLE:Z

    if-eqz v1, :cond_2

    .line 210
    const-string v1, "ResourceCache"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Url: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 213
    :cond_2
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    if-eqz v1, :cond_5

    .line 214
    iget-object v2, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    monitor-enter v2

    .line 215
    :try_start_0
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v1, p3}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/UrlResource;

    .line 216
    .local v0, "resource":Lco/vine/android/util/UrlResource;, "TV;"
    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 221
    :goto_1
    if-eqz v0, :cond_6

    .line 222
    sget-boolean v1, Lco/vine/android/util/UrlResourceCache;->LOGGABLE:Z

    if-eqz v1, :cond_3

    .line 223
    const-string v1, "ResourceCache"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Have resource: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, v0, Lco/vine/android/util/UrlResource;->url:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 225
    :cond_3
    iget-object v1, v0, Lco/vine/android/util/UrlResource;->url:Ljava/lang/String;

    invoke-virtual {v1, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    iget-wide v1, v0, Lco/vine/android/util/UrlResource;->nextRequestTime:J

    const-wide/16 v3, 0x0

    cmp-long v1, v1, v3

    if-lez v1, :cond_0

    iget-wide v1, v0, Lco/vine/android/util/UrlResource;->nextRequestTime:J

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    cmp-long v1, v1, v3

    if-gez v1, :cond_0

    .line 228
    :cond_4
    invoke-direct/range {p0 .. p6}, Lco/vine/android/util/UrlResourceCache;->queueResourceLoad(JLjava/lang/Object;Ljava/lang/String;ZZ)Lco/vine/android/util/UrlResource;

    move-result-object v0

    goto :goto_0

    .line 216
    .end local v0    # "resource":Lco/vine/android/util/UrlResource;, "TV;"
    :catchall_0
    move-exception v1

    :try_start_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v1

    .line 218
    :cond_5
    const/4 v0, 0x0

    .restart local v0    # "resource":Lco/vine/android/util/UrlResource;, "TV;"
    goto :goto_1

    .line 231
    :cond_6
    sget-boolean v1, Lco/vine/android/util/UrlResourceCache;->LOGGABLE:Z

    if-eqz v1, :cond_7

    .line 232
    const-string v1, "ResourceCache"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Looking in persistent storage: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 234
    :cond_7
    invoke-direct/range {p0 .. p6}, Lco/vine/android/util/UrlResourceCache;->queueResourceLoad(JLjava/lang/Object;Ljava/lang/String;ZZ)Lco/vine/android/util/UrlResource;

    move-result-object v0

    goto/16 :goto_0
.end method

.method public getCacheBinder()Lco/vine/android/util/CacheBinder;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lco/vine/android/util/CacheBinder",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 285
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    if-eqz v0, :cond_1

    .line 286
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    monitor-enter v1

    .line 287
    :try_start_0
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mCacheBinder:Lco/vine/android/util/CacheBinder;

    if-nez v0, :cond_0

    .line 288
    new-instance v0, Lco/vine/android/util/CacheBinder;

    iget-object v2, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-direct {v0, v2}, Lco/vine/android/util/CacheBinder;-><init>(Landroid/support/v4/util/LruCache;)V

    iput-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mCacheBinder:Lco/vine/android/util/CacheBinder;

    .line 290
    :cond_0
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 291
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mCacheBinder:Lco/vine/android/util/CacheBinder;

    .line 293
    :goto_0
    return-object v0

    .line 290
    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    .line 293
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected abstract instantiateResource(Ljava/lang/Object;Ljava/lang/String;Ljava/lang/Object;)Lco/vine/android/util/UrlResource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Ljava/lang/String;",
            "TT;)TV;"
        }
    .end annotation
.end method

.method protected abstract loadResource(JLjava/lang/Object;Ljava/lang/String;)Lco/vine/android/util/UrlResource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTK;",
            "Ljava/lang/String;",
            ")TV;"
        }
    .end annotation
.end method

.method protected abstract obtainResource(Ljava/lang/Object;Ljava/lang/String;Ljava/io/InputStream;)Lco/vine/android/util/UrlResource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Ljava/lang/String;",
            "Ljava/io/InputStream;",
            ")TV;"
        }
    .end annotation
.end method

.method protected abstract onResourceError(Ljava/lang/Object;Lco/vine/android/network/HttpResult;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;",
            "Lco/vine/android/network/HttpResult;",
            ")V"
        }
    .end annotation
.end method

.method protected abstract onResourceLoaded(Ljava/util/HashMap;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<TK;TV;>;)V"
        }
    .end annotation
.end method

.method public peek(Ljava/lang/Object;)Lco/vine/android/util/UrlResource;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .prologue
    .line 114
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    if-eqz v0, :cond_0

    .line 115
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    monitor-enter v1

    .line 116
    :try_start_0
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0, p1}, Landroid/support/v4/util/LruCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/UrlResource;

    monitor-exit v1

    .line 119
    :goto_0
    return-object v0

    .line 117
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 119
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public put(Ljava/lang/Object;Lco/vine/android/util/UrlResource;)Lco/vine/android/util/UrlResource;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;TV;)TV;"
        }
    .end annotation

    .prologue
    .line 124
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    .local p2, "value":Lco/vine/android/util/UrlResource;, "TV;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    if-eqz v0, :cond_0

    .line 125
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    monitor-enter v1

    .line 126
    :try_start_0
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0, p1, p2}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/UrlResource;

    monitor-exit v1

    .line 129
    :goto_0
    return-object v0

    .line 127
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 129
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public remove(Ljava/lang/Object;)Lco/vine/android/util/UrlResource;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TK;)TV;"
        }
    .end annotation

    .prologue
    .line 134
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p1, "key":Ljava/lang/Object;, "TK;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    if-eqz v0, :cond_0

    .line 135
    iget-object v1, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    monitor-enter v1

    .line 136
    :try_start_0
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0, p1}, Landroid/support/v4/util/LruCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lco/vine/android/util/UrlResource;

    monitor-exit v1

    .line 139
    :goto_0
    return-object v0

    .line 137
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 139
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected abstract saveResource(JLjava/lang/Object;Ljava/lang/String;Ljava/io/InputStream;Z)Lco/vine/android/util/UrlResource;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(JTK;",
            "Ljava/lang/String;",
            "Ljava/io/InputStream;",
            "Z)TV;"
        }
    .end annotation
.end method

.method public snapShot()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<TK;TV;>;"
        }
    .end annotation

    .prologue
    .line 70
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    iget-object v0, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v0}, Landroid/support/v4/util/LruCache;->snapshot()Ljava/util/Map;

    move-result-object v0

    return-object v0
.end method

.method urlResourceLoaded(Ljava/util/HashMap;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<TK;TV;>;)V"
        }
    .end annotation

    .prologue
    .line 266
    .local p0, "this":Lco/vine/android/util/UrlResourceCache;, "Lco/vine/android/util/UrlResourceCache<TK;TV;TT;>;"
    .local p1, "result":Ljava/util/HashMap;, "Ljava/util/HashMap<TK;TV;>;"
    invoke-virtual {p1}, Ljava/util/HashMap;->isEmpty()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 282
    :goto_0
    return-void

    .line 269
    :cond_0
    invoke-virtual {p1}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 270
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v2

    .line 271
    .local v2, "key":Ljava/lang/Object;, "TK;"
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lco/vine/android/util/UrlResource;

    .line 272
    .local v3, "resource":Lco/vine/android/util/UrlResource;, "TV;"
    iget-object v4, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    if-eqz v4, :cond_1

    if-eqz v3, :cond_1

    .line 273
    iget-object v5, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    monitor-enter v5

    .line 274
    :try_start_0
    iget-object v4, p0, Lco/vine/android/util/UrlResourceCache;->mResourceCache:Landroid/support/v4/util/LruCache;

    invoke-virtual {v4, v2, v3}, Landroid/support/v4/util/LruCache;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 275
    monitor-exit v5
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 277
    :cond_1
    iget-object v5, p0, Lco/vine/android/util/UrlResourceCache;->mLock:[I

    monitor-enter v5

    .line 278
    :try_start_1
    iget-object v4, p0, Lco/vine/android/util/UrlResourceCache;->mPendingDownload:Ljava/util/LinkedHashMap;

    invoke-virtual {v4, v2}, Ljava/util/LinkedHashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 279
    monitor-exit v5

    goto :goto_1

    :catchall_0
    move-exception v4

    monitor-exit v5
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v4

    .line 275
    :catchall_1
    move-exception v4

    :try_start_2
    monitor-exit v5
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    throw v4

    .line 281
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<TK;TV;>;"
    .end local v2    # "key":Ljava/lang/Object;, "TK;"
    .end local v3    # "resource":Lco/vine/android/util/UrlResource;, "TV;"
    :cond_2
    invoke-virtual {p0, p1}, Lco/vine/android/util/UrlResourceCache;->onResourceLoaded(Ljava/util/HashMap;)V

    goto :goto_0
.end method
