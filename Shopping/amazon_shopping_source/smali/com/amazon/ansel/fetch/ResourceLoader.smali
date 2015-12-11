.class public abstract Lcom/amazon/ansel/fetch/ResourceLoader;
.super Ljava/lang/Object;
.source "ResourceLoader.java"

# interfaces
.implements Lcom/amazon/ansel/fetch/MutablePrioritized;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/ansel/fetch/ResourceLoader$Listener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<Result:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Lcom/amazon/ansel/fetch/MutablePrioritized;"
    }
.end annotation


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final context:Lcom/amazon/ansel/fetch/LoaderContext;

.field private disposed:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private loaderListeners:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<",
            "Lcom/amazon/ansel/fetch/LoaderListener;",
            ">;>;"
        }
    .end annotation
.end field

.field private volatile priority:J

.field private volatile resourceKey:Ljava/lang/Object;

.field private resourceListenerRef:Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<TResult;>;>;"
        }
    .end annotation
.end field

.field private final resultClass:Ljava/lang/Class;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/Class",
            "<*>;"
        }
    .end annotation
.end field

.field private volatile state:I

.field private volatile stateLock:Ljava/lang/Object;

.field private volatile task:Lcom/amazon/ansel/fetch/LoaderTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/LoaderTask",
            "<TResult;>;"
        }
    .end annotation
.end field

.field private volatile taskListener:Lcom/amazon/ansel/fetch/LoaderTask$Listener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/ansel/fetch/LoaderTask$Listener",
            "<TResult;>;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const-class v0, Lcom/amazon/ansel/fetch/ResourceLoader;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/ansel/fetch/ResourceLoader;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/ansel/fetch/LoaderContext;Ljava/lang/Class;Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;J)V
    .locals 2
    .param p1, "context"    # Lcom/amazon/ansel/fetch/LoaderContext;
    .param p4, "priority"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/LoaderContext;",
            "Ljava/lang/Class",
            "<TResult;>;",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<TResult;>;>;J)V"
        }
    .end annotation

    .prologue
    .line 31
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    .local p2, "resultClass":Ljava/lang/Class;, "Ljava/lang/Class<TResult;>;"
    .local p3, "resourceListenerRef":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<Lcom/amazon/ansel/fetch/ResourceListener<TResult;>;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    const/4 v0, 0x1

    iput v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    .line 16
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->stateLock:Ljava/lang/Object;

    .line 20
    new-instance v0, Ljava/util/concurrent/CopyOnWriteArrayList;

    invoke-direct {v0}, Ljava/util/concurrent/CopyOnWriteArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->loaderListeners:Ljava/util/List;

    .line 26
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->disposed:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 32
    iput-object p1, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    .line 33
    iput-object p2, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resultClass:Ljava/lang/Class;

    .line 34
    iput-object p3, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resourceListenerRef:Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    .line 35
    iput-wide p4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->priority:J

    .line 36
    new-instance v0, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/ansel/fetch/ResourceLoader$Listener;-><init>(Lcom/amazon/ansel/fetch/ResourceLoader;Lcom/amazon/ansel/fetch/ResourceLoader$1;)V

    iput-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->taskListener:Lcom/amazon/ansel/fetch/LoaderTask$Listener;

    .line 37
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resourceListenerRef:Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/ansel/fetch/ResourceLoader;)Lcom/amazon/ansel/fetch/LoaderContext;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/ansel/fetch/ResourceLoader;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->loaderListeners:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/ansel/fetch/ResourceLoader;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;

    .prologue
    .line 14
    iget v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    return v0
.end method

.method static synthetic access$402(Lcom/amazon/ansel/fetch/ResourceLoader;I)I
    .locals 0
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;
    .param p1, "x1"    # I

    .prologue
    .line 14
    iput p1, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    return p1
.end method

.method static synthetic access$500(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 14
    invoke-direct {p0, p1}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/ansel/fetch/ResourceLoader;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;

    .prologue
    .line 14
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->stateLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$700(Lcom/amazon/ansel/fetch/ResourceLoader;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/ansel/fetch/ResourceLoader;

    .prologue
    .line 14
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->dispose()V

    return-void
.end method

.method private dispose()V
    .locals 3

    .prologue
    .line 309
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->disposed:Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;->compareAndSet(ZZ)Z

    move-result v0

    if-nez v0, :cond_0

    .line 316
    :goto_0
    return-void

    .line 313
    :cond_0
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    .line 314
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->sendDone()V

    .line 315
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->loaderListeners:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->clear()V

    goto :goto_0
.end method

.method private loadFromPrimaryCache()Z
    .locals 5

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    const/4 v3, 0x0

    .line 199
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v1

    .line 201
    .local v1, "key":Ljava/lang/Object;
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getUseCache()Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getReadCache()Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getUsePrimaryCache()Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getReadPrimaryCache()Z

    move-result v4

    if-eqz v4, :cond_0

    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getPrimaryCache()Lcom/amazon/ansel/fetch/cache/ResourceCache;

    move-result-object v4

    if-nez v4, :cond_1

    .line 238
    :cond_0
    :goto_0
    return v3

    .line 207
    :cond_1
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getPrimaryCache()Lcom/amazon/ansel/fetch/cache/ResourceCache;

    move-result-object v4

    invoke-interface {v4, v1}, Lcom/amazon/ansel/fetch/cache/ResourceCache;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;

    .line 209
    .local v0, "el":Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;, "Lcom/amazon/ansel/fetch/cache/ResourceCacheValue<TResult;>;"
    if-nez v0, :cond_2

    .line 210
    const-string/jumbo v4, "Cache miss"

    invoke-direct {p0, v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    goto :goto_0

    .line 212
    :cond_2
    const-string/jumbo v4, "Cache hit"

    invoke-direct {p0, v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    .line 214
    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->isExpired()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 215
    const-string/jumbo v4, "Cache element expired"

    invoke-direct {p0, v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    .line 216
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getPrimaryCache()Lcom/amazon/ansel/fetch/cache/ResourceCache;

    move-result-object v4

    invoke-interface {v4, v1}, Lcom/amazon/ansel/fetch/cache/ResourceCache;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 218
    :cond_3
    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/cache/ResourceCacheValue;->getValue()Ljava/lang/Object;

    move-result-object v2

    .line 222
    .local v2, "result":Ljava/lang/Object;, "TResult;"
    iget-object v3, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    new-instance v4, Lcom/amazon/ansel/fetch/ResourceLoader$1;

    invoke-direct {v4, p0, v1, v2}, Lcom/amazon/ansel/fetch/ResourceLoader$1;-><init>(Lcom/amazon/ansel/fetch/ResourceLoader;Ljava/lang/Object;Ljava/lang/Object;)V

    invoke-virtual {v3, v4}, Lcom/amazon/ansel/fetch/LoaderContext;->executeCallback(Ljava/lang/Runnable;)V

    .line 234
    const/4 v3, 0x1

    goto :goto_0
.end method

.method private loadFromPrimaryCacheAndFinish()Z
    .locals 4

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    const/4 v1, 0x1

    const/4 v0, 0x0

    .line 181
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->loadFromPrimaryCache()Z

    move-result v2

    if-nez v2, :cond_0

    .line 195
    :goto_0
    return v0

    .line 185
    :cond_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->stateLock:Ljava/lang/Object;

    monitor-enter v2

    .line 186
    :try_start_0
    iget v3, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    if-eq v3, v1, :cond_1

    .line 187
    monitor-exit v2

    goto :goto_0

    .line 191
    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    .line 190
    :cond_1
    const/4 v0, 0x2

    :try_start_1
    iput v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    .line 191
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 193
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->dispose()V

    move v0, v1

    .line 195
    goto :goto_0
.end method

.method private log(Ljava/lang/String;)V
    .locals 3
    .param p1, "msg"    # Ljava/lang/String;

    .prologue
    .line 319
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    sget-object v0, Lcom/amazon/ansel/fetch/ResourceLoader;->TAG:Ljava/lang/String;

    const/4 v1, 0x2

    invoke-static {v0, v1}, Lcom/amazon/ansel/fetch/log/AppLog;->isLoggable(Ljava/lang/String;I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 320
    sget-object v0, Lcom/amazon/ansel/fetch/ResourceLoader;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " (resource: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ", thread: ["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-static {}, Lcom/amazon/ansel/fetch/ThreadUtil;->infoString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "])"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/ansel/fetch/log/AppLog;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 322
    :cond_0
    return-void
.end method

.method private sendDone()V
    .locals 2

    .prologue
    .line 244
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    new-instance v1, Lcom/amazon/ansel/fetch/ResourceLoader$2;

    invoke-direct {v1, p0}, Lcom/amazon/ansel/fetch/ResourceLoader$2;-><init>(Lcom/amazon/ansel/fetch/ResourceLoader;)V

    invoke-virtual {v0, v1}, Lcom/amazon/ansel/fetch/LoaderContext;->executeCallback(Ljava/lang/Runnable;)V

    .line 262
    return-void
.end method


# virtual methods
.method public addListener(Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference",
            "<",
            "Lcom/amazon/ansel/fetch/LoaderListener;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 70
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    .local p1, "listener":Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;, "Lcom/amazon/ansel/fetch/tools/ref/ObjectReference<Lcom/amazon/ansel/fetch/LoaderListener;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->loaderListeners:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 71
    return-void
.end method

.method public cancel()V
    .locals 4

    .prologue
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    const/4 v3, 0x1

    .line 265
    iget v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    if-eq v1, v3, :cond_0

    .line 284
    :goto_0
    return-void

    .line 269
    :cond_0
    iget-object v2, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->stateLock:Ljava/lang/Object;

    monitor-enter v2

    .line 270
    :try_start_0
    iget v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    if-eq v1, v3, :cond_1

    .line 271
    monitor-exit v2

    goto :goto_0

    .line 275
    :catchall_0
    move-exception v1

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 274
    :cond_1
    const/4 v1, 0x4

    :try_start_1
    iput v1, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    .line 275
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 277
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    .line 279
    .local v0, "loaderTask":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    if-eqz v0, :cond_2

    .line 280
    const/4 v1, 0x0

    invoke-virtual {v0, p0, v1}, Lcom/amazon/ansel/fetch/LoaderTask;->removeLoader(Lcom/amazon/ansel/fetch/ResourceLoader;Z)V

    .line 283
    :cond_2
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->dispose()V

    goto :goto_0
.end method

.method public final execute()V
    .locals 1

    .prologue
    .line 122
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    const-string/jumbo v0, "Start execute"

    invoke-direct {p0, v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    .line 123
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->executeLoader()V

    .line 124
    const-string/jumbo v0, "End execute"

    invoke-direct {p0, v0}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    .line 125
    return-void
.end method

.method protected executeLoader()V
    .locals 6

    .prologue
    .line 129
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    const/4 v5, 0x1

    if-eq v4, v5, :cond_1

    .line 178
    :cond_0
    :goto_0
    return-void

    .line 135
    :cond_1
    invoke-direct {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->loadFromPrimaryCacheAndFinish()Z

    move-result v4

    if-nez v4, :cond_0

    .line 139
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v1

    .line 143
    .local v1, "key":Ljava/lang/Object;
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderContext;->getTasks()Ljava/util/Map;

    move-result-object v3

    .line 145
    .local v3, "tasks":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/Object;Lcom/amazon/ansel/fetch/LoaderTask<*>;>;"
    monitor-enter v3

    .line 146
    :try_start_0
    invoke-interface {v3, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/ansel/fetch/LoaderTask;

    .line 148
    .local v2, "loaderTask":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    if-eqz v2, :cond_2

    invoke-virtual {v2, p0}, Lcom/amazon/ansel/fetch/LoaderTask;->addLoader(Lcom/amazon/ansel/fetch/ResourceLoader;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 149
    iput-object v2, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    .line 150
    monitor-exit v3

    goto :goto_0

    .line 152
    .end local v2    # "loaderTask":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    :catchall_0
    move-exception v4

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .restart local v2    # "loaderTask":Lcom/amazon/ansel/fetch/LoaderTask;, "Lcom/amazon/ansel/fetch/LoaderTask<TResult;>;"
    :cond_2
    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 156
    monitor-enter v3

    .line 157
    :try_start_2
    invoke-interface {v3, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    move-object v0, v4

    check-cast v0, Lcom/amazon/ansel/fetch/LoaderTask;

    move-object v2, v0

    .line 159
    if-eqz v2, :cond_3

    .line 160
    const-string/jumbo v4, "Found existing task"

    invoke-direct {p0, v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    .line 162
    invoke-virtual {v2, p0}, Lcom/amazon/ansel/fetch/LoaderTask;->addLoader(Lcom/amazon/ansel/fetch/ResourceLoader;)Z

    move-result v4

    if-nez v4, :cond_4

    .line 163
    const-string/jumbo v4, "Failed to attach to task"

    invoke-direct {p0, v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    .line 170
    :cond_3
    const-string/jumbo v4, "Creating new task"

    invoke-direct {p0, v4}, Lcom/amazon/ansel/fetch/ResourceLoader;->log(Ljava/lang/String;)V

    .line 172
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->newLoaderTask()Lcom/amazon/ansel/fetch/LoaderTask;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    .line 173
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    invoke-virtual {v4, p0}, Lcom/amazon/ansel/fetch/LoaderTask;->addLoader(Lcom/amazon/ansel/fetch/ResourceLoader;)Z

    .line 174
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderTask;->addToTaskMap()V

    .line 175
    monitor-exit v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 177
    iget-object v4, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    invoke-virtual {v4}, Lcom/amazon/ansel/fetch/LoaderTask;->submit()V

    goto :goto_0

    .line 165
    :cond_4
    :try_start_3
    iput-object v2, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    .line 166
    monitor-exit v3

    goto :goto_0

    .line 175
    :catchall_1
    move-exception v4

    monitor-exit v3
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    throw v4
.end method

.method protected generateResourceKey()Ljava/lang/Object;
    .locals 3

    .prologue
    .line 112
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    new-instance v0, Lcom/amazon/ansel/fetch/ResourceKey;

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->getOperation()Ljava/lang/Object;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceRequest()Ljava/lang/Object;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/ansel/fetch/ResourceKey;-><init>(Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v0
.end method

.method public getContext()Lcom/amazon/ansel/fetch/LoaderContext;
    .locals 1

    .prologue
    .line 54
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->context:Lcom/amazon/ansel/fetch/LoaderContext;

    return-object v0
.end method

.method protected getOperation()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 116
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getPriority()J
    .locals 2

    .prologue
    .line 79
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget-wide v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->priority:J

    return-wide v0
.end method

.method public declared-synchronized getResourceKey()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 100
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resourceKey:Ljava/lang/Object;

    if-nez v0, :cond_0

    .line 101
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->generateResourceKey()Ljava/lang/Object;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resourceKey:Ljava/lang/Object;

    .line 104
    :cond_0
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resourceKey:Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v0

    .line 100
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public getResourceListener()Lcom/amazon/ansel/fetch/ResourceListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/ResourceListener",
            "<TResult;>;"
        }
    .end annotation

    .prologue
    .line 66
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resourceListenerRef:Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->resourceListenerRef:Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;

    invoke-interface {v0}, Lcom/amazon/ansel/fetch/tools/ref/ObjectReference;->get()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/ansel/fetch/ResourceListener;

    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public abstract getResourceRequest()Ljava/lang/Object;
.end method

.method protected getTaskListener()Lcom/amazon/ansel/fetch/LoaderTask$Listener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/LoaderTask$Listener",
            "<TResult;>;"
        }
    .end annotation

    .prologue
    .line 96
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->taskListener:Lcom/amazon/ansel/fetch/LoaderTask$Listener;

    return-object v0
.end method

.method public abstract newLoaderTask()Lcom/amazon/ansel/fetch/LoaderTask;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/amazon/ansel/fetch/LoaderTask",
            "<TResult;>;"
        }
    .end annotation
.end method

.method public setPriority(J)V
    .locals 2
    .param p1, "priority"    # J

    .prologue
    .line 84
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    iput-wide p1, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->priority:J

    .line 86
    iget v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->state:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderTask;->getPriority()J

    move-result-wide v0

    cmp-long v0, v0, p1

    if-gez v0, :cond_0

    .line 87
    iget-object v0, p0, Lcom/amazon/ansel/fetch/ResourceLoader;->task:Lcom/amazon/ansel/fetch/LoaderTask;

    invoke-virtual {v0}, Lcom/amazon/ansel/fetch/LoaderTask;->update()V

    .line 89
    :cond_0
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 1

    .prologue
    .line 326
    .local p0, "this":Lcom/amazon/ansel/fetch/ResourceLoader;, "Lcom/amazon/ansel/fetch/ResourceLoader<TResult;>;"
    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/ansel/fetch/ResourceLoader;->getResourceKey()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
