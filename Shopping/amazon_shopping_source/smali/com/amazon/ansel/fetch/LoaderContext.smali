.class public Lcom/amazon/ansel/fetch/LoaderContext;
.super Ljava/lang/Object;
.source "LoaderContext.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/ansel/fetch/LoaderContext$Builder;
    }
.end annotation


# static fields
.field private static final PRIORITY_COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final callbackExecutor:Ljava/util/concurrent/Executor;

.field private final executor:Ljava/util/concurrent/ThreadPoolExecutor;

.field private final primaryCache:Lcom/amazon/ansel/fetch/cache/ResourceCache;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/cache/ResourceCache",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;"
        }
    .end annotation
.end field

.field private final readCache:Z

.field private final readPrimaryCache:Z

.field private final references:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<+",
            "Lcom/amazon/ansel/fetch/LoaderListener;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private final removalInvalidates:Z

.field private final tasks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/LoaderTask",
            "<*>;>;"
        }
    .end annotation
.end field

.field private final trackReferences:Z

.field private final useCache:Z

.field private final usePrimaryCache:Z

.field private final useWeakResourceListeners:Z

.field private final webClientFactory:Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

.field private final writeCache:Z

.field private final writePrimaryCache:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    new-instance v0, Lcom/amazon/ansel/fetch/LoaderContext$1;

    invoke-direct {v0}, Lcom/amazon/ansel/fetch/LoaderContext$1;-><init>()V

    sput-object v0, Lcom/amazon/ansel/fetch/LoaderContext;->PRIORITY_COMPARATOR:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>(ZZZZZZZZZLcom/amazon/ansel/fetch/cache/ResourceCacheFactory;Ljava/util/concurrent/ThreadPoolExecutor;Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;Ljava/util/concurrent/Executor;)V
    .locals 2
    .param p1, "useWeakResourceListeners"    # Z
    .param p2, "useCache"    # Z
    .param p3, "readCache"    # Z
    .param p4, "writeCache"    # Z
    .param p5, "usePrimaryCache"    # Z
    .param p6, "readPrimaryCache"    # Z
    .param p7, "writePrimaryCache"    # Z
    .param p8, "removalInvalidates"    # Z
    .param p9, "trackReferences"    # Z
    .param p11, "executor"    # Ljava/util/concurrent/ThreadPoolExecutor;
    .param p12, "webClientFactory"    # Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;
    .param p13, "callbackExecutor"    # Ljava/util/concurrent/Executor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(ZZZZZZZZZ",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;",
            "Ljava/util/concurrent/ThreadPoolExecutor;",
            "Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;",
            "Ljava/util/concurrent/Executor;",
            ")V"
        }
    .end annotation

    .prologue
    .local p10, "primaryCacheFactory":Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory<Ljava/lang/Object;Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<*>;>;"
    const/16 v1, 0x8

    .line 88
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 56
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0, v1}, Ljava/util/concurrent/ConcurrentHashMap;-><init>(I)V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->tasks:Ljava/util/Map;

    .line 62
    new-instance v0, Ljava/util/IdentityHashMap;

    invoke-direct {v0, v1}, Ljava/util/IdentityHashMap;-><init>(I)V

    invoke-static {v0}, Ljava/util/Collections;->synchronizedMap(Ljava/util/Map;)Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->references:Ljava/util/Map;

    .line 89
    iput-boolean p1, p0, Lcom/amazon/ansel/fetch/LoaderContext;->useWeakResourceListeners:Z

    .line 90
    iput-boolean p2, p0, Lcom/amazon/ansel/fetch/LoaderContext;->useCache:Z

    .line 91
    iput-boolean p3, p0, Lcom/amazon/ansel/fetch/LoaderContext;->readCache:Z

    .line 92
    iput-boolean p4, p0, Lcom/amazon/ansel/fetch/LoaderContext;->writeCache:Z

    .line 93
    iput-boolean p5, p0, Lcom/amazon/ansel/fetch/LoaderContext;->usePrimaryCache:Z

    .line 94
    iput-boolean p6, p0, Lcom/amazon/ansel/fetch/LoaderContext;->readPrimaryCache:Z

    .line 95
    iput-boolean p7, p0, Lcom/amazon/ansel/fetch/LoaderContext;->writePrimaryCache:Z

    .line 96
    iput-boolean p8, p0, Lcom/amazon/ansel/fetch/LoaderContext;->removalInvalidates:Z

    .line 97
    iput-boolean p9, p0, Lcom/amazon/ansel/fetch/LoaderContext;->trackReferences:Z

    .line 98
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/LoaderContext;->createPrimaryCacheListener()Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;

    move-result-object v0

    invoke-interface {p10, v0}, Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;->getCache(Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;)Lcom/amazon/ansel/fetch/cache/ResourceCache;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->primaryCache:Lcom/amazon/ansel/fetch/cache/ResourceCache;

    .line 99
    iput-object p11, p0, Lcom/amazon/ansel/fetch/LoaderContext;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    .line 100
    iput-object p12, p0, Lcom/amazon/ansel/fetch/LoaderContext;->webClientFactory:Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

    .line 101
    iput-object p13, p0, Lcom/amazon/ansel/fetch/LoaderContext;->callbackExecutor:Ljava/util/concurrent/Executor;

    .line 102
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/ansel/fetch/LoaderContext;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/LoaderContext;

    .prologue
    .line 36
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->removalInvalidates:Z

    return v0
.end method

.method public static createDefaultExecutor(Ljava/util/concurrent/BlockingQueue;)Ljava/util/concurrent/ThreadPoolExecutor;
    .locals 7
    .annotation build Landroid/annotation/TargetApi;
        value = 0x9
    .end annotation

    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/concurrent/BlockingQueue",
            "<",
            "Ljava/lang/Runnable;",
            ">;)",
            "Ljava/util/concurrent/ThreadPoolExecutor;"
        }
    .end annotation

    .prologue
    .local p0, "queue":Ljava/util/concurrent/BlockingQueue;, "Ljava/util/concurrent/BlockingQueue<Ljava/lang/Runnable;>;"
    const/16 v1, 0xa

    .line 289
    if-nez p0, :cond_0

    .line 290
    invoke-static {}, Lcom/amazon/ansel/fetch/LoaderContext;->createDefaultQueue()Ljava/util/concurrent/BlockingQueue;

    move-result-object p0

    .line 293
    :cond_0
    new-instance v0, Ljava/util/concurrent/ThreadPoolExecutor;

    const-wide/32 v3, 0xea60

    sget-object v5, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    move v2, v1

    move-object v6, p0

    invoke-direct/range {v0 .. v6}, Ljava/util/concurrent/ThreadPoolExecutor;-><init>(IIJLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/BlockingQueue;)V

    .line 295
    .local v0, "executor":Ljava/util/concurrent/ThreadPoolExecutor;
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0xe

    if-lt v1, v2, :cond_1

    .line 296
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ThreadPoolExecutor;->allowCoreThreadTimeOut(Z)V

    .line 299
    :cond_1
    return-object v0
.end method

.method public static createDefaultPrimaryCacheFactory(I)Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory;
    .locals 1
    .param p0, "maxBytes"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheFactory",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 274
    new-instance v0, Lcom/amazon/ansel/fetch/LoaderContext$2;

    invoke-direct {v0, p0}, Lcom/amazon/ansel/fetch/LoaderContext$2;-><init>(I)V

    return-object v0
.end method

.method public static createDefaultQueue()Ljava/util/concurrent/BlockingQueue;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/concurrent/BlockingQueue",
            "<",
            "Ljava/lang/Runnable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 284
    new-instance v0, Ljava/util/concurrent/PriorityBlockingQueue;

    const/16 v1, 0xa

    sget-object v2, Lcom/amazon/ansel/fetch/LoaderContext;->PRIORITY_COMPARATOR:Ljava/util/Comparator;

    invoke-direct {v0, v1, v2}, Ljava/util/concurrent/PriorityBlockingQueue;-><init>(ILjava/util/Comparator;)V

    return-object v0
.end method

.method public static createDefaultWebClientFactory()Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;
    .locals 1

    .prologue
    .line 303
    new-instance v0, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/DefaultApacheWebClientFactory;

    invoke-direct {v0}, Lcom/amazon/ansel/fetch/tools/web/apache/apache40/DefaultApacheWebClientFactory;-><init>()V

    return-object v0
.end method

.method private createPrimaryCacheListener()Lcom/amazon/ansel/fetch/cache/ResourceCacheListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheListener",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 307
    new-instance v0, Lcom/amazon/ansel/fetch/LoaderContext$3;

    invoke-direct {v0, p0}, Lcom/amazon/ansel/fetch/LoaderContext$3;-><init>(Lcom/amazon/ansel/fetch/LoaderContext;)V

    return-object v0
.end method

.method public static getDefaultPrimaryCacheMemSize(Landroid/content/Context;)I
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .annotation build Landroid/annotation/TargetApi;
        value = 0xb
    .end annotation

    .prologue
    const/high16 v5, 0x100000

    .line 255
    const-string/jumbo v3, "activity"

    invoke-virtual {p0, v3}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 256
    .local v0, "am":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getMemoryClass()I

    move-result v3

    mul-int/lit16 v3, v3, 0x400

    mul-int/lit16 v3, v3, 0x400

    div-int/lit8 v2, v3, 0xa

    .line 258
    .local v2, "size":I
    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v4, 0xb

    if-lt v3, v4, :cond_0

    .line 259
    invoke-virtual {p0}, Landroid/content/Context;->getApplicationInfo()Landroid/content/pm/ApplicationInfo;

    move-result-object v3

    iget v3, v3, Landroid/content/pm/ApplicationInfo;->flags:I

    and-int/2addr v3, v5

    if-eqz v3, :cond_1

    const/4 v1, 0x1

    .line 261
    .local v1, "largeHeap":Z
    :goto_0
    if-eqz v1, :cond_0

    .line 262
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getLargeMemoryClass()I

    move-result v3

    mul-int/lit16 v3, v3, 0x400

    mul-int/lit16 v3, v3, 0x400

    div-int/lit8 v3, v3, 0x14

    invoke-static {v2, v3}, Ljava/lang/Math;->max(II)I

    move-result v2

    .line 266
    .end local v1    # "largeHeap":Z
    :cond_0
    const/high16 v3, 0x3000000

    invoke-static {v2, v3}, Ljava/lang/Math;->min(II)I

    move-result v3

    invoke-static {v5, v3}, Ljava/lang/Math;->max(II)I

    move-result v3

    return v3

    .line 259
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public addReference(Ljava/lang/Object;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;)V
    .locals 4
    .param p1, "resourceKey"    # Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<+",
            "Lcom/amazon/ansel/fetch/LoaderListener;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 181
    .local p2, "listenerReference":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;"
    iget-boolean v1, p0, Lcom/amazon/ansel/fetch/LoaderContext;->trackReferences:Z

    if-eqz v1, :cond_0

    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    .line 196
    :cond_0
    :goto_0
    return-void

    .line 185
    :cond_1
    iget-object v2, p0, Lcom/amazon/ansel/fetch/LoaderContext;->references:Ljava/util/Map;

    monitor-enter v2

    .line 186
    :try_start_0
    iget-object v1, p0, Lcom/amazon/ansel/fetch/LoaderContext;->references:Ljava/util/Map;

    invoke-interface {v1, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 188
    .local v0, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    if-nez v0, :cond_2

    .line 189
    new-instance v1, Ljava/util/ArrayList;

    const/4 v3, 0x1

    invoke-direct {v1, v3}, Ljava/util/ArrayList;-><init>(I)V

    invoke-static {v1}, Ljava/util/Collections;->synchronizedList(Ljava/util/List;)Ljava/util/List;

    move-result-object v0

    .line 191
    iget-object v1, p0, Lcom/amazon/ansel/fetch/LoaderContext;->references:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 194
    :cond_2
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 195
    monitor-exit v2

    goto :goto_0

    .end local v0    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1
.end method

.method public executeCallback(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 173
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->callbackExecutor:Ljava/util/concurrent/Executor;

    if-nez v0, :cond_0

    .line 174
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 178
    :goto_0
    return-void

    .line 176
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->callbackExecutor:Ljava/util/concurrent/Executor;

    invoke-interface {v0, p1}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0
.end method

.method public getExecutor()Ljava/util/concurrent/ThreadPoolExecutor;
    .locals 1

    .prologue
    .line 145
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->executor:Ljava/util/concurrent/ThreadPoolExecutor;

    return-object v0
.end method

.method public getPrimaryCache()Lcom/amazon/ansel/fetch/cache/ResourceCache;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/cache/ResourceCache",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 141
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->primaryCache:Lcom/amazon/ansel/fetch/cache/ResourceCache;

    return-object v0
.end method

.method public getReadCache()Z
    .locals 1

    .prologue
    .line 113
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->readCache:Z

    return v0
.end method

.method public getReadPrimaryCache()Z
    .locals 1

    .prologue
    .line 125
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->readPrimaryCache:Z

    return v0
.end method

.method public getTasks()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Object;",
            "Lcom/amazon/ansel/fetch/LoaderTask",
            "<*>;>;"
        }
    .end annotation

    .prologue
    .line 149
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->tasks:Ljava/util/Map;

    return-object v0
.end method

.method public getUseCache()Z
    .locals 1

    .prologue
    .line 109
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->useCache:Z

    return v0
.end method

.method public getUsePrimaryCache()Z
    .locals 1

    .prologue
    .line 121
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->usePrimaryCache:Z

    return v0
.end method

.method public getWebClientFactory()Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;
    .locals 1

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->webClientFactory:Lcom/amazon/ansel/fetch/tools/web/WebClientFactory;

    return-object v0
.end method

.method public getWriteCache()Z
    .locals 1

    .prologue
    .line 117
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->writeCache:Z

    return v0
.end method

.method public getWritePrimaryCache()Z
    .locals 1

    .prologue
    .line 129
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->writePrimaryCache:Z

    return v0
.end method

.method public invalidateResource(Ljava/lang/Object;)V
    .locals 8
    .param p1, "resourceKey"    # Ljava/lang/Object;

    .prologue
    .line 219
    iget-boolean v6, p0, Lcom/amazon/ansel/fetch/LoaderContext;->trackReferences:Z

    if-eqz v6, :cond_0

    if-nez p1, :cond_1

    .line 246
    :cond_0
    return-void

    .line 223
    :cond_1
    const/4 v2, 0x0

    .line 225
    .local v2, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    iget-object v7, p0, Lcom/amazon/ansel/fetch/LoaderContext;->references:Ljava/util/Map;

    monitor-enter v7

    .line 226
    :try_start_0
    iget-object v6, p0, Lcom/amazon/ansel/fetch/LoaderContext;->references:Ljava/util/Map;

    invoke-interface {v6, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/util/List;

    .line 228
    .local v4, "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    if-eqz v4, :cond_2

    .line 229
    monitor-enter v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 230
    :try_start_1
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 231
    .end local v2    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    .local v3, "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    :try_start_2
    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_2

    move-object v2, v3

    .line 234
    .end local v3    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    .restart local v2    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    :cond_2
    :try_start_3
    iget-object v6, p0, Lcom/amazon/ansel/fetch/LoaderContext;->references:Ljava/util/Map;

    invoke-interface {v6, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 235
    monitor-exit v7
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 237
    if-eqz v2, :cond_0

    .line 238
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_3
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    .line 239
    .local v0, "el":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;"
    invoke-interface {v0}, Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;->get()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/amazon/ansel/fetch/LoaderListener;

    .line 241
    .local v5, "listener":Lcom/amazon/ansel/fetch/LoaderListener;
    if-eqz v5, :cond_3

    .line 242
    invoke-interface {v5}, Lcom/amazon/ansel/fetch/LoaderListener;->invalidate()V

    goto :goto_0

    .line 231
    .end local v0    # "el":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v5    # "listener":Lcom/amazon/ansel/fetch/LoaderListener;
    :catchall_0
    move-exception v6

    :goto_1
    :try_start_4
    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    throw v6

    .line 235
    .end local v4    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    :catchall_1
    move-exception v6

    monitor-exit v7
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    throw v6

    .line 231
    .end local v2    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    .restart local v3    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    .restart local v4    # "list":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    :catchall_2
    move-exception v6

    move-object v2, v3

    .end local v3    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    .restart local v2    # "items":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<+Lcom/amazon/ansel/fetch/LoaderListener;>;>;"
    goto :goto_1
.end method

.method public newResourceListenerReference(Lcom/amazon/ansel/fetch/ResourceListener;)Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<TT;>;)",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<TT;>;>;"
        }
    .end annotation

    .prologue
    .line 162
    .local p1, "resourceListener":Lcom/amazon/ansel/fetch/ResourceListener;, "Lcom/amazon/ansel/fetch/ResourceListener<TT;>;"
    iget-boolean v0, p0, Lcom/amazon/ansel/fetch/LoaderContext;->useWeakResourceListeners:Z

    if-eqz v0, :cond_0

    new-instance v0, Lcom/amazon/ansel/fetch/tools/ref/WeakObjectReference;

    invoke-direct {v0, p1}, Lcom/amazon/ansel/fetch/tools/ref/WeakObjectReference;-><init>(Ljava/lang/Object;)V

    :goto_0
    return-object v0

    :cond_0
    new-instance v0, Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;

    invoke-direct {v0, p1}, Lcom/amazon/ansel/fetch/tools/ref/StrongObjectReference;-><init>(Ljava/lang/Object;)V

    goto :goto_0
.end method
