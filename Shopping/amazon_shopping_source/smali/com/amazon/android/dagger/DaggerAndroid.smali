.class public final Lcom/amazon/android/dagger/DaggerAndroid;
.super Ljava/lang/Object;
.source "DaggerAndroid.java"


# static fields
.field private static final DAGGER_OBJECT_GRAPH_LATCH:Ljava/util/concurrent/CountDownLatch;

.field private static volatile graph:Ldagger/ObjectGraph;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 18
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->DAGGER_OBJECT_GRAPH_LATCH:Ljava/util/concurrent/CountDownLatch;

    .line 30
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->graph:Ldagger/ObjectGraph;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 23
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 25
    return-void
.end method

.method public static awaitGraphCreation()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 87
    sget-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->DAGGER_OBJECT_GRAPH_LATCH:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V

    .line 88
    return-void
.end method

.method public static varargs declared-synchronized createGraph([Ljava/lang/Object;)Ldagger/ObjectGraph;
    .locals 2
    .param p0, "modules"    # [Ljava/lang/Object;

    .prologue
    .line 62
    const-class v1, Lcom/amazon/android/dagger/DaggerAndroid;

    monitor-enter v1

    :try_start_0
    invoke-static {p0}, Ldagger/ObjectGraph;->create([Ljava/lang/Object;)Ldagger/ObjectGraph;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->graph:Ldagger/ObjectGraph;

    .line 63
    sget-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->graph:Ldagger/ObjectGraph;

    invoke-virtual {v0}, Ldagger/ObjectGraph;->injectStatics()V

    .line 65
    sget-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->DAGGER_OBJECT_GRAPH_LATCH:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 67
    sget-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->graph:Ldagger/ObjectGraph;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 62
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized getGraph()Ldagger/ObjectGraph;
    .locals 2

    .prologue
    .line 48
    const-class v1, Lcom/amazon/android/dagger/DaggerAndroid;

    monitor-enter v1

    :try_start_0
    sget-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->graph:Ldagger/ObjectGraph;

    if-nez v0, :cond_0

    .line 49
    const/4 v0, 0x0

    new-array v0, v0, [Ljava/lang/Object;

    invoke-static {v0}, Lcom/amazon/android/dagger/DaggerAndroid;->createGraph([Ljava/lang/Object;)Ldagger/ObjectGraph;

    move-result-object v0

    sput-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->graph:Ldagger/ObjectGraph;

    .line 51
    :cond_0
    sget-object v0, Lcom/amazon/android/dagger/DaggerAndroid;->graph:Ldagger/ObjectGraph;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v1

    return-object v0

    .line 48
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized inject(Ljava/lang/Object;)V
    .locals 2
    .param p0, "object"    # Ljava/lang/Object;

    .prologue
    .line 77
    const-class v1, Lcom/amazon/android/dagger/DaggerAndroid;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/amazon/android/dagger/DaggerAndroid;->getGraph()Ldagger/ObjectGraph;

    move-result-object v0

    invoke-virtual {v0, p0}, Ldagger/ObjectGraph;->inject(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 78
    monitor-exit v1

    return-void

    .line 77
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method
