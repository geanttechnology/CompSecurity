.class public abstract Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
.super Ljava/lang/Object;
.source "BoundServiceManager.java"

# interfaces
.implements Landroid/content/ServiceConnection;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;,
        Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;,
        Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Ljava/lang/Object;",
        "Landroid/content/ServiceConnection;"
    }
.end annotation


# static fields
.field static final CONNECTION_TIMEOUT:J

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private mBindInitiated:Z

.field private mBoundService:Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TT;"
        }
    .end annotation
.end field

.field private mComponentName:Landroid/content/ComponentName;

.field private final mContext:Landroid/content/Context;

.field private final mExecutor:Ljava/util/concurrent/Executor;

.field private final mHandler:Landroid/os/Handler;

.field private final mOutstandingCallbacks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;>;"
        }
    .end annotation
.end field

.field private mQueue:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager",
            "<TT;>.RunnableBoundServiceCallback;>;"
        }
    .end annotation
.end field

.field private final mServiceClassName:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 31
    sget-object v0, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    const-wide/16 v1, 0x3

    sget-object v3, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/concurrent/TimeUnit;->convert(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->CONNECTION_TIMEOUT:J

    .line 33
    const-class v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/util/concurrent/Executor;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "serviceClassName"    # Ljava/lang/String;
    .param p3, "executor"    # Ljava/util/concurrent/Executor;

    .prologue
    .line 91
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 92
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mContext:Landroid/content/Context;

    .line 93
    iput-object p2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mServiceClassName:Ljava/lang/String;

    .line 94
    iput-object p3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mExecutor:Ljava/util/concurrent/Executor;

    .line 95
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mOutstandingCallbacks:Ljava/util/List;

    .line 96
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mHandler:Landroid/os/Handler;

    .line 97
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Ljava/lang/Object;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 26
    sget-object v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Landroid/content/ComponentName;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$302(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 26
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Ljava/util/concurrent/Executor;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager;
    .param p1, "x1"    # Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    .prologue
    .line 26
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->callbackWhenServiceIsAvailable(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    return-void
.end method

.method private declared-synchronized callbackWhenServiceIsAvailable(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 268
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    .local p1, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    monitor-enter p0

    :try_start_0
    new-instance v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;

    invoke-direct {v0, p0, p1}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;-><init>(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    .line 269
    .local v0, "runnableHandler":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;

    if-nez v1, :cond_1

    .line 271
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;

    if-nez v1, :cond_0

    .line 273
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;

    .line 280
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mHandler:Landroid/os/Handler;

    new-instance v2, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;

    invoke-direct {v2, p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;-><init>(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)V

    sget-wide v3, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->CONNECTION_TIMEOUT:J

    invoke-virtual {v1, v2, v3, v4}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 312
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 318
    :goto_0
    monitor-exit p0

    return-void

    .line 316
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mExecutor:Ljava/util/concurrent/Executor;

    invoke-interface {v1, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 268
    .end local v0    # "runnableHandler":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private declared-synchronized getComponentName()Landroid/content/ComponentName;
    .locals 3

    .prologue
    .line 248
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    if-eqz v0, :cond_0

    .line 250
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 263
    :goto_0
    monitor-exit p0

    return-object v0

    .line 253
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mContext:Landroid/content/Context;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mServiceClassName:Ljava/lang/String;

    sget-object v2, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;->SERVICE_FINDER:Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/framework/SSOIntentFactory;->findSSOComponent(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/SSOIntentFactory$ComponentFinder;)Landroid/content/ComponentName;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    .line 255
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    if-nez v0, :cond_1

    .line 257
    sget-object v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Couldn\'t find "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mServiceClassName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 263
    :goto_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    goto :goto_0

    .line 261
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Found service "

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 248
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method protected abstract asInterface(Landroid/os/IBinder;)Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/os/IBinder;",
            ")TT;"
        }
    .end annotation
.end method

.method public declared-synchronized doneUsingService(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 199
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    .local p1, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mOutstandingCallbacks:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 200
    monitor-exit p0

    return-void

    .line 199
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 5
    .param p1, "componentName"    # Landroid/content/ComponentName;
    .param p2, "binder"    # Landroid/os/IBinder;

    .prologue
    .line 206
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    monitor-enter p0

    .line 208
    :try_start_0
    sget-object v3, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "onServiceConnected: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 210
    invoke-virtual {p0, p2}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->asInterface(Landroid/os/IBinder;)Ljava/lang/Object;

    move-result-object v3

    iput-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;

    .line 212
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;

    .line 213
    .local v2, "queue":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;>;"
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;

    .line 214
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 217
    if-eqz v2, :cond_0

    .line 219
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;

    .line 221
    .local v0, "handler":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mExecutor:Ljava/util/concurrent/Executor;

    invoke-interface {v3, v0}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 214
    .end local v0    # "handler":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "queue":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;>;"
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 224
    .restart local v2    # "queue":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;>;"
    :cond_0
    return-void
.end method

.method public declared-synchronized onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 4
    .param p1, "componentName"    # Landroid/content/ComponentName;

    .prologue
    .line 229
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    monitor-enter p0

    :try_start_0
    sget-object v2, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string/jumbo v3, "onServiceDisconnected: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 230
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;

    .line 231
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mOutstandingCallbacks:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    .line 233
    .local v0, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mExecutor:Ljava/util/concurrent/Executor;

    new-instance v3, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;

    invoke-direct {v3, v0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;-><init>(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    invoke-interface {v2, v3}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 229
    .end local v0    # "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 235
    .restart local v1    # "i$":Ljava/util/Iterator;
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mOutstandingCallbacks:Ljava/util/List;

    invoke-interface {v2}, Ljava/util/List;->clear()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 236
    monitor-exit p0

    return-void
.end method

.method public declared-synchronized startUsingServiceAsynchronously(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 188
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    .local p1, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mOutstandingCallbacks:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 189
    monitor-exit p0

    return-void

    .line 188
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized tryToBind()Z
    .locals 7

    .prologue
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    const/4 v3, 0x1

    const/4 v4, 0x0

    .line 138
    monitor-enter p0

    :try_start_0
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;

    if-eqz v5, :cond_0

    .line 140
    sget-object v4, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "already bound: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 177
    :goto_0
    monitor-exit p0

    return v3

    .line 144
    :cond_0
    :try_start_1
    iget-boolean v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBindInitiated:Z

    if-eqz v5, :cond_1

    .line 146
    sget-object v4, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "bind already initiated: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 138
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3

    .line 150
    :cond_1
    :try_start_2
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->getComponentName()Landroid/content/ComponentName;

    move-result-object v0

    .line 151
    .local v0, "componentName":Landroid/content/ComponentName;
    if-nez v0, :cond_2

    move v3, v4

    .line 153
    goto :goto_0

    .line 156
    :cond_2
    new-instance v2, Landroid/content/Intent;

    invoke-direct {v2}, Landroid/content/Intent;-><init>()V

    .line 157
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v2, v0}, Landroid/content/Intent;->setComponent(Landroid/content/ComponentName;)Landroid/content/Intent;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 160
    :try_start_3
    iget-object v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mContext:Landroid/content/Context;

    const/16 v6, 0x15

    invoke-virtual {v5, v2, p0, v6}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 162
    sget-object v5, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "binding: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 163
    const/4 v5, 0x1

    iput-boolean v5, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBindInitiated:Z
    :try_end_3
    .catch Ljava/lang/SecurityException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 173
    :catch_0
    move-exception v1

    .line 175
    .local v1, "e":Ljava/lang/SecurityException;
    :try_start_4
    const-string/jumbo v3, "BindFailed"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v3, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 176
    sget-object v3, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "bind failed: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move v3, v4

    .line 177
    goto :goto_0

    .line 168
    .end local v1    # "e":Ljava/lang/SecurityException;
    :cond_3
    :try_start_5
    const-string/jumbo v3, "BindFailed"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v3, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 169
    sget-object v3, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "bind failed: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Ljava/lang/SecurityException; {:try_start_5 .. :try_end_5} :catch_0
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    move v3, v4

    .line 170
    goto/16 :goto_0
.end method

.method public declared-synchronized useService(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 105
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    .local p1, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    monitor-enter p0

    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->tryToBind()Z

    move-result v0

    if-nez v0, :cond_0

    .line 107
    invoke-virtual {p1}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;->onError()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 112
    :goto_0
    monitor-exit p0

    return-void

    .line 111
    :cond_0
    :try_start_1
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->callbackWhenServiceIsAvailable(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 105
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized useServiceIfAlreadyBound(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)Z
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback",
            "<TT;>;)Z"
        }
    .end annotation

    .prologue
    .line 121
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>;"
    .local p1, "callback":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback<TT;>;"
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-nez v0, :cond_0

    .line 123
    const/4 v0, 0x0

    .line 128
    :goto_0
    monitor-exit p0

    return v0

    .line 127
    :cond_0
    :try_start_1
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->callbackWhenServiceIsAvailable(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 128
    const/4 v0, 0x1

    goto :goto_0

    .line 121
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
