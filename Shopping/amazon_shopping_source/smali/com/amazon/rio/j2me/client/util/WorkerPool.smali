.class public Lcom/amazon/rio/j2me/client/util/WorkerPool;
.super Lcom/amazon/rio/j2me/client/util/ObjectPool;
.source "WorkerPool.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/rio/j2me/client/util/ObjectPool",
        "<",
        "Lcom/amazon/rio/j2me/client/util/Worker;",
        ">;"
    }
.end annotation


# static fields
.field private static final instance:Lcom/amazon/rio/j2me/client/util/WorkerPool;


# instance fields
.field private final stillRunning:Ljava/util/Vector;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Vector",
            "<",
            "Lcom/amazon/rio/j2me/client/util/Worker;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    .line 11
    new-instance v0, Lcom/amazon/rio/j2me/client/util/WorkerPool;

    const-string/jumbo v1, "Worker Threads"

    const/4 v2, 0x5

    const/16 v3, 0x3e8

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/rio/j2me/client/util/WorkerPool;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/amazon/rio/j2me/client/util/WorkerPool;->instance:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 1
    .param p1, "name"    # Ljava/lang/String;
    .param p2, "freeSizeLimit"    # I
    .param p3, "totalSizeLimit"    # I

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;

    invoke-direct {v0, p1}, Lcom/amazon/rio/j2me/client/util/WorkerPool$1;-><init>(Ljava/lang/String;)V

    invoke-direct {p0, p1, v0, p2, p3}, Lcom/amazon/rio/j2me/client/util/ObjectPool;-><init>(Ljava/lang/String;Lcom/amazon/rio/j2me/client/util/LifecycleManager;II)V

    .line 17
    new-instance v0, Ljava/util/Vector;

    invoke-direct {v0}, Ljava/util/Vector;-><init>()V

    iput-object v0, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool;->stillRunning:Ljava/util/Vector;

    .line 30
    return-void
.end method

.method private declared-synchronized addStillRunning(Lcom/amazon/rio/j2me/client/util/Worker;)V
    .locals 1
    .param p1, "worker"    # Lcom/amazon/rio/j2me/client/util/Worker;

    .prologue
    .line 87
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool;->stillRunning:Ljava/util/Vector;

    invoke-virtual {v0, p1}, Ljava/util/Vector;->addElement(Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 88
    monitor-exit p0

    return-void

    .line 87
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public static getInstance()Lcom/amazon/rio/j2me/client/util/WorkerPool;
    .locals 1

    .prologue
    .line 15
    sget-object v0, Lcom/amazon/rio/j2me/client/util/WorkerPool;->instance:Lcom/amazon/rio/j2me/client/util/WorkerPool;

    return-object v0
.end method


# virtual methods
.method public acquireWorker()Lcom/amazon/rio/j2me/client/util/Worker;
    .locals 5
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/amazon/rio/j2me/client/util/LifecycleException;
        }
    .end annotation

    .prologue
    .line 54
    const/4 v1, 0x0

    .line 55
    .local v1, "worker":Lcom/amazon/rio/j2me/client/util/Worker;
    monitor-enter p0

    .line 56
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->cleanoutStillRunning()V

    .line 57
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->acquireObject()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lcom/amazon/rio/j2me/client/util/Worker;

    move-object v1, v0

    .line 58
    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 60
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/util/Worker;->getWorkerState()Lcom/amazon/rio/j2me/client/util/Worker$State;

    move-result-object v2

    sget-object v3, Lcom/amazon/rio/j2me/client/util/Worker$State;->IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-eq v2, v3, :cond_0

    .line 61
    new-instance v2, Lcom/amazon/rio/j2me/client/util/LifecycleException;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "worker was expected to be in state="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Lcom/amazon/rio/j2me/client/util/Worker$State;->IDLE:Lcom/amazon/rio/j2me/client/util/Worker$State;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, ": worker="

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/rio/j2me/client/util/LifecycleException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 58
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    .line 64
    :cond_0
    const/4 v2, 0x5

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/util/Worker;->setPriority(I)V

    .line 65
    return-object v1
.end method

.method public declared-synchronized cleanoutStillRunning()V
    .locals 4

    .prologue
    .line 75
    monitor-enter p0

    :try_start_0
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool;->stillRunning:Ljava/util/Vector;

    invoke-virtual {v2}, Ljava/util/Vector;->size()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 76
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool;->stillRunning:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->elementAt(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/util/Worker;

    .line 77
    .local v1, "worker":Lcom/amazon/rio/j2me/client/util/Worker;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/util/Worker;->getWorkerState()Lcom/amazon/rio/j2me/client/util/Worker$State;

    move-result-object v2

    sget-object v3, Lcom/amazon/rio/j2me/client/util/Worker$State;->EXECUTING:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-ne v2, v3, :cond_0

    .line 75
    :goto_1
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 81
    :cond_0
    iget-object v2, p0, Lcom/amazon/rio/j2me/client/util/WorkerPool;->stillRunning:Ljava/util/Vector;

    invoke-virtual {v2, v0}, Ljava/util/Vector;->removeElementAt(I)V

    .line 82
    invoke-virtual {p0, v1}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->releaseWorker(Lcom/amazon/rio/j2me/client/util/Worker;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 75
    .end local v0    # "i":I
    .end local v1    # "worker":Lcom/amazon/rio/j2me/client/util/Worker;
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2

    .line 84
    .restart local v0    # "i":I
    :cond_1
    monitor-exit p0

    return-void
.end method

.method public releaseWorker(Lcom/amazon/rio/j2me/client/util/Worker;)V
    .locals 2
    .param p1, "worker"    # Lcom/amazon/rio/j2me/client/util/Worker;

    .prologue
    .line 92
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/util/Worker;->getWorkerState()Lcom/amazon/rio/j2me/client/util/Worker$State;

    move-result-object v0

    .line 93
    .local v0, "state":Lcom/amazon/rio/j2me/client/util/Worker$State;
    sget-object v1, Lcom/amazon/rio/j2me/client/util/Worker$State;->STOPPED:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-ne v0, v1, :cond_0

    .line 94
    invoke-virtual {p0, p1}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->destroyObject(Ljava/lang/Object;)V

    .line 102
    :goto_0
    return-void

    .line 96
    :cond_0
    sget-object v1, Lcom/amazon/rio/j2me/client/util/Worker$State;->EXECUTING:Lcom/amazon/rio/j2me/client/util/Worker$State;

    if-ne v0, v1, :cond_1

    .line 97
    invoke-direct {p0, p1}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->addStillRunning(Lcom/amazon/rio/j2me/client/util/Worker;)V

    goto :goto_0

    .line 100
    :cond_1
    invoke-virtual {p0, p1}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->releaseObject(Ljava/lang/Object;)V

    goto :goto_0
.end method
