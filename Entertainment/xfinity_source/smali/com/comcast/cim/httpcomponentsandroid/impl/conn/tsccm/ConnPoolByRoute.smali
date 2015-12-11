.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;
.super Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;
.source "ConnPoolByRoute.java"


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation


# instance fields
.field protected final connPerRoute:Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;

.field private final connTTL:J

.field private final connTTLTimeUnit:Ljava/util/concurrent/TimeUnit;

.field protected final freeConnections:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;",
            ">;"
        }
    .end annotation
.end field

.field protected final leasedConnections:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;",
            ">;"
        }
    .end annotation
.end field

.field private final log:Lorg/apache/commons/logging/Log;

.field protected volatile maxTotalConnections:I

.field protected volatile numConnections:I

.field protected final operator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

.field private final poolLock:Ljava/util/concurrent/locks/Lock;

.field protected final routeToPool:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;",
            ">;"
        }
    .end annotation
.end field

.field protected volatile shutdown:Z

.field protected final waitingThreads:Ljava/util/Queue;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Queue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;IJLjava/util/concurrent/TimeUnit;)V
    .locals 2
    .param p1, "operator"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;
    .param p2, "connPerRoute"    # Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;
    .param p3, "maxTotalConnections"    # I
    .param p4, "connTTL"    # J
    .param p6, "connTTLTimeUnit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 124
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;-><init>()V

    .line 71
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    .line 125
    if-nez p1, :cond_0

    .line 126
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Connection operator may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 128
    :cond_0
    if-nez p2, :cond_1

    .line 129
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Connections per route may not be null"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 131
    :cond_1
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->poolLock:Ljava/util/concurrent/locks/Lock;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    .line 132
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->leasedConnections:Ljava/util/Set;

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->leasedConnections:Ljava/util/Set;

    .line 133
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->operator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    .line 134
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->connPerRoute:Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;

    .line 135
    iput p3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->maxTotalConnections:I

    .line 136
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->createFreeConnQueue()Ljava/util/Queue;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->freeConnections:Ljava/util/Queue;

    .line 137
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->createWaitingThreadQueue()Ljava/util/Queue;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->waitingThreads:Ljava/util/Queue;

    .line 138
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->createRouteToPoolMap()Ljava/util/Map;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->routeToPool:Ljava/util/Map;

    .line 139
    iput-wide p4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->connTTL:J

    .line 140
    iput-object p6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->connTTLTimeUnit:Ljava/util/concurrent/TimeUnit;

    .line 141
    return-void
.end method

.method private closeConnection(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V
    .locals 4
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    .prologue
    .line 218
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v0

    .line 219
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;
    if-eqz v0, :cond_0

    .line 221
    :try_start_0
    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 226
    :cond_0
    :goto_0
    return-void

    .line 222
    :catch_0
    move-exception v1

    .line 223
    .local v1, "ex":Ljava/io/IOException;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "I/O error closing connection"

    invoke-interface {v2, v3, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method


# virtual methods
.method protected createEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .locals 7
    .param p1, "rospl"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    .param p2, "op"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    .prologue
    .line 548
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v0}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 549
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Creating new connection ["

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "]"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 553
    :cond_0
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v3

    iget-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->connTTL:J

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->connTTLTimeUnit:Ljava/util/concurrent/TimeUnit;

    move-object v2, p2

    invoke-direct/range {v1 .. v6}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;JLjava/util/concurrent/TimeUnit;)V

    .line 555
    .local v1, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 557
    :try_start_0
    invoke-virtual {p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->createdEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V

    .line 558
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    .line 559
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->leasedConnections:Ljava/util/Set;

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 561
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 564
    return-object v1

    .line 561
    :catchall_0
    move-exception v0

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method protected createFreeConnQueue()Ljava/util/Queue;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Queue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;",
            ">;"
        }
    .end annotation

    .prologue
    .line 166
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    return-object v0
.end method

.method protected createRouteToPoolMap()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;",
            ">;"
        }
    .end annotation

    .prologue
    .line 186
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    return-object v0
.end method

.method protected createWaitingThreadQueue()Ljava/util/Queue;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Queue",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;",
            ">;"
        }
    .end annotation

    .prologue
    .line 176
    new-instance v0, Ljava/util/LinkedList;

    invoke-direct {v0}, Ljava/util/LinkedList;-><init>()V

    return-object v0
.end method

.method protected deleteEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V
    .locals 5
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    .prologue
    .line 581
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getPlannedRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v1

    .line 583
    .local v1, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 584
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Deleting connection ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getState()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 588
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 591
    :try_start_0
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->closeConnection(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V

    .line 593
    const/4 v2, 0x1

    invoke-virtual {p0, v1, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->getRoutePool(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Z)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    move-result-object v0

    .line 594
    .local v0, "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->deleteEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)Z

    .line 595
    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    .line 596
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->isUnused()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 597
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->routeToPool:Ljava/util/Map;

    invoke-interface {v2, v1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 601
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 603
    return-void

    .line 601
    .end local v0    # "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v2
.end method

.method protected deleteLeastUsedEntry()V
    .locals 3

    .prologue
    .line 611
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 614
    :try_start_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->freeConnections:Ljava/util/Queue;

    invoke-interface {v1}, Ljava/util/Queue;->remove()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    .line 616
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    if-eqz v0, :cond_1

    .line 617
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->deleteEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 623
    :cond_0
    :goto_0
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 625
    return-void

    .line 618
    :cond_1
    :try_start_1
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v1}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 619
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "No free connection to delete"

    invoke-interface {v1, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 623
    .end local v0    # "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    :catchall_0
    move-exception v1

    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v1
.end method

.method public freeEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;ZJLjava/util/concurrent/TimeUnit;)V
    .locals 7
    .param p1, "entry"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .param p2, "reusable"    # Z
    .param p3, "validDuration"    # J
    .param p5, "timeUnit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 432
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getPlannedRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v1

    .line 433
    .local v1, "route":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 434
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Releasing connection ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getState()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 438
    :cond_0
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 440
    :try_start_0
    iget-boolean v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->shutdown:Z

    if-eqz v3, :cond_1

    .line 443
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->closeConnection(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 474
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 476
    :goto_0
    return-void

    .line 448
    :cond_1
    :try_start_1
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->leasedConnections:Ljava/util/Set;

    invoke-interface {v3, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 450
    const/4 v3, 0x1

    invoke-virtual {p0, v1, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->getRoutePool(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Z)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    move-result-object v0

    .line 452
    .local v0, "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    if-eqz p2, :cond_4

    .line 453
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 455
    const-wide/16 v4, 0x0

    cmp-long v3, p3, v4

    if-lez v3, :cond_3

    .line 456
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3, p4}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 460
    .local v2, "s":Ljava/lang/String;
    :goto_1
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Pooling connection ["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]["

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getState()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "]; keep alive "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 463
    .end local v2    # "s":Ljava/lang/String;
    :cond_2
    invoke-virtual {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->freeEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V

    .line 464
    invoke-virtual {p1, p3, p4, p5}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->updateExpiry(JLjava/util/concurrent/TimeUnit;)V

    .line 465
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->freeConnections:Ljava/util/Queue;

    invoke-interface {v3, p1}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 471
    :goto_2
    invoke-virtual {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->notifyWaitingThread(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 474
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0

    .line 458
    :cond_3
    :try_start_2
    const-string v2, "indefinitely"

    .restart local v2    # "s":Ljava/lang/String;
    goto :goto_1

    .line 467
    .end local v2    # "s":Ljava/lang/String;
    :cond_4
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->dropEntry()V

    .line 468
    iget v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    add-int/lit8 v3, v3, -0x1

    iput v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_2

    .line 474
    .end local v0    # "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    :catchall_0
    move-exception v3

    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v4}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v3
.end method

.method public getConnectionsInPool()I
    .locals 2

    .prologue
    .line 270
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 272
    :try_start_0
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 274
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return v0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method protected getEntryBlocking(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;JLjava/util/concurrent/TimeUnit;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .locals 15
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "state"    # Ljava/lang/Object;
    .param p3, "timeout"    # J
    .param p5, "tunit"    # Ljava/util/concurrent/TimeUnit;
    .param p6, "aborter"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;,
            Ljava/lang/InterruptedException;
        }
    .end annotation

    .prologue
    .line 330
    const/4 v4, 0x0

    .line 331
    .local v4, "deadline":Ljava/util/Date;
    const-wide/16 v10, 0x0

    cmp-long v10, p3, v10

    if-lez v10, :cond_0

    .line 332
    new-instance v4, Ljava/util/Date;

    .end local v4    # "deadline":Ljava/util/Date;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    move-object/from16 v0, p5

    move-wide/from16 v1, p3

    invoke-virtual {v0, v1, v2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v12

    add-long/2addr v10, v12

    invoke-direct {v4, v10, v11}, Ljava/util/Date;-><init>(J)V

    .line 336
    .restart local v4    # "deadline":Ljava/util/Date;
    :cond_0
    const/4 v5, 0x0

    .line 337
    .local v5, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v10}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 340
    const/4 v10, 0x1

    :try_start_0
    move-object/from16 v0, p1

    invoke-virtual {p0, v0, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->getRoutePool(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Z)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    move-result-object v7

    .line 341
    .local v7, "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    const/4 v9, 0x0

    .line 343
    .local v9, "waitingThread":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;
    :cond_1
    :goto_0
    if-nez v5, :cond_4

    .line 345
    iget-boolean v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->shutdown:Z

    if-eqz v10, :cond_2

    .line 346
    new-instance v10, Ljava/lang/IllegalStateException;

    const-string v11, "Connection pool shut down"

    invoke-direct {v10, v11}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 424
    .end local v7    # "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    .end local v9    # "waitingThread":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;
    :catchall_0
    move-exception v10

    iget-object v11, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v11}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v10

    .line 349
    .restart local v7    # "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    .restart local v9    # "waitingThread":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;
    :cond_2
    :try_start_1
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v10}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v10

    if-eqz v10, :cond_3

    .line 350
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "] total kept alive: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget-object v12, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->freeConnections:Ljava/util/Queue;

    invoke-interface {v12}, Ljava/util/Queue;->size()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ", total issued: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget-object v12, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->leasedConnections:Ljava/util/Set;

    invoke-interface {v12}, Ljava/util/Set;->size()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, ", total allocated: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget v12, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " out of "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    iget v12, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->maxTotalConnections:I

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v11}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 361
    :cond_3
    move-object/from16 v0, p2

    invoke-virtual {p0, v7, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->getFreeEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v5

    .line 362
    if-eqz v5, :cond_5

    .line 424
    :cond_4
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v10}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 426
    return-object v5

    .line 366
    :cond_5
    :try_start_2
    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getCapacity()I

    move-result v10

    if-lez v10, :cond_7

    const/4 v6, 0x1

    .line 368
    .local v6, "hasCapacity":Z
    :goto_1
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v10}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v10

    if-eqz v10, :cond_6

    .line 369
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Available capacity: "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getCapacity()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " out of "

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getMaxEntries()I

    move-result v12

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, " ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "]["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    move-object/from16 v0, p2

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "]"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v11}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 374
    :cond_6
    if-eqz v6, :cond_8

    iget v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    iget v11, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->maxTotalConnections:I

    if-ge v10, v11, :cond_8

    .line 376
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->operator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    invoke-virtual {p0, v7, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->createEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    move-result-object v5

    goto/16 :goto_0

    .line 366
    .end local v6    # "hasCapacity":Z
    :cond_7
    const/4 v6, 0x0

    goto :goto_1

    .line 378
    .restart local v6    # "hasCapacity":Z
    :cond_8
    if-eqz v6, :cond_9

    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->freeConnections:Ljava/util/Queue;

    invoke-interface {v10}, Ljava/util/Queue;->isEmpty()Z

    move-result v10

    if-nez v10, :cond_9

    .line 380
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->deleteLeastUsedEntry()V

    .line 383
    const/4 v10, 0x1

    move-object/from16 v0, p1

    invoke-virtual {p0, v0, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->getRoutePool(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Z)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    move-result-object v7

    .line 384
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->operator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    invoke-virtual {p0, v7, v10}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->createEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    move-result-object v5

    goto/16 :goto_0

    .line 388
    :cond_9
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v10}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v10

    if-eqz v10, :cond_a

    .line 389
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string v12, "Need to wait for connection ["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    move-object/from16 v0, p1

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "]["

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    move-object/from16 v0, p2

    invoke-virtual {v11, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string v12, "]"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    invoke-interface {v10, v11}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 393
    :cond_a
    if-nez v9, :cond_b

    .line 394
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v10}, Ljava/util/concurrent/locks/Lock;->newCondition()Ljava/util/concurrent/locks/Condition;

    move-result-object v10

    invoke-virtual {p0, v10, v7}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->newWaitingThread(Ljava/util/concurrent/locks/Condition;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;

    move-result-object v9

    .line 396
    move-object/from16 v0, p6

    invoke-virtual {v0, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;->setWaitingThread(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 399
    :cond_b
    const/4 v8, 0x0

    .line 401
    .local v8, "success":Z
    :try_start_3
    invoke-virtual {v7, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->queueThread(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;)V

    .line 402
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->waitingThreads:Ljava/util/Queue;

    invoke-interface {v10, v9}, Ljava/util/Queue;->add(Ljava/lang/Object;)Z

    .line 403
    invoke-virtual {v9, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;->await(Ljava/util/Date;)Z
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-result v8

    .line 410
    :try_start_4
    invoke-virtual {v7, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->removeThread(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;)V

    .line 411
    iget-object v10, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->waitingThreads:Ljava/util/Queue;

    invoke-interface {v10, v9}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z

    .line 415
    if-nez v8, :cond_1

    if-eqz v4, :cond_1

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v10

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v12

    cmp-long v10, v10, v12

    if-gtz v10, :cond_1

    .line 417
    new-instance v10, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;

    const-string v11, "Timeout waiting for connection"

    invoke-direct {v10, v11}, Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionPoolTimeoutException;-><init>(Ljava/lang/String;)V

    throw v10

    .line 410
    :catchall_1
    move-exception v10

    invoke-virtual {v7, v9}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->removeThread(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;)V

    .line 411
    iget-object v11, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->waitingThreads:Ljava/util/Queue;

    invoke-interface {v11, v9}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z

    throw v10
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method

.method protected getFreeEntry(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .locals 5
    .param p1, "rospl"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    .param p2, "state"    # Ljava/lang/Object;

    .prologue
    .line 488
    const/4 v1, 0x0

    .line 489
    .local v1, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 491
    const/4 v0, 0x0

    .line 492
    .local v0, "done":Z
    :cond_0
    :goto_0
    if-nez v0, :cond_5

    .line 494
    :try_start_0
    invoke-virtual {p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->allocEntry(Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    move-result-object v1

    .line 496
    if-eqz v1, :cond_4

    .line 497
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 498
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Getting free connection ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 502
    :cond_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->freeConnections:Ljava/util/Queue;

    invoke-interface {v2, v1}, Ljava/util/Queue;->remove(Ljava/lang/Object;)Z

    .line 503
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->isExpired(J)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 506
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 507
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Closing expired free connection ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 509
    :cond_2
    invoke-direct {p0, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->closeConnection(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V

    .line 513
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->dropEntry()V

    .line 514
    iget v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I

    add-int/lit8 v2, v2, -0x1

    iput v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->numConnections:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto/16 :goto_0

    .line 529
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v2

    .line 516
    :cond_3
    :try_start_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->leasedConnections:Ljava/util/Set;

    invoke-interface {v2, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 517
    const/4 v0, 0x1

    goto/16 :goto_0

    .line 521
    :cond_4
    const/4 v0, 0x1

    .line 522
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 523
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "No free connections ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 529
    :cond_5
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 531
    return-object v1
.end method

.method protected getLock()Ljava/util/concurrent/locks/Lock;
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    return-object v0
.end method

.method public getMaxTotalConnections()I
    .locals 1

    .prologue
    .line 832
    iget v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->maxTotalConnections:I

    return v0
.end method

.method protected getRoutePool(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Z)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    .locals 4
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "create"    # Z

    .prologue
    .line 239
    const/4 v1, 0x0

    .line 240
    .local v1, "rospl":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 243
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->routeToPool:Ljava/util/Map;

    invoke-interface {v2, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    move-object v1, v0

    .line 244
    if-nez v1, :cond_0

    if-eqz p2, :cond_0

    .line 246
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->newRouteSpecificPool(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    move-result-object v1

    .line 247
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->routeToPool:Ljava/util/Map;

    invoke-interface {v2, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 251
    :cond_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 254
    return-object v1

    .line 251
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v2
.end method

.method protected newRouteSpecificPool(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;
    .locals 2
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    .prologue
    .line 199
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->connPerRoute:Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;

    invoke-direct {v0, p1, v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Lcom/comcast/cim/httpcomponentsandroid/conn/params/ConnPerRoute;)V

    return-object v0
.end method

.method protected newWaitingThread(Ljava/util/concurrent/locks/Condition;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;
    .locals 1
    .param p1, "cond"    # Ljava/util/concurrent/locks/Condition;
    .param p2, "rospl"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    .prologue
    .line 214
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;

    invoke-direct {v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;-><init>(Ljava/util/concurrent/locks/Condition;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;)V

    return-object v0
.end method

.method protected notifyWaitingThread(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;)V
    .locals 5
    .param p1, "rospl"    # Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;

    .prologue
    .line 662
    const/4 v1, 0x0

    .line 664
    .local v1, "waitingThread":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 667
    if-eqz p1, :cond_3

    :try_start_0
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->hasThread()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 668
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 669
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Notifying thread waiting on pool ["

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->getRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "]"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 672
    :cond_0
    invoke-virtual {p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RouteSpecificPool;->nextThread()Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;

    move-result-object v1

    .line 682
    :cond_1
    :goto_0
    if-eqz v1, :cond_2

    .line 683
    invoke-virtual {v1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;->wakeup()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 687
    :cond_2
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 689
    return-void

    .line 673
    :cond_3
    :try_start_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->waitingThreads:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_5

    .line 674
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 675
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "Notifying thread waiting on any pool"

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 677
    :cond_4
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->waitingThreads:Ljava/util/Queue;

    invoke-interface {v2}, Ljava/util/Queue;->remove()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;

    move-object v1, v0

    goto :goto_0

    .line 678
    :cond_5
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v2}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 679
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "Notifying no-one, there are no waiting threads"

    invoke-interface {v2, v3}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 687
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v2
.end method

.method public requestPoolEntry(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/PoolEntryRequest;
    .locals 2
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "state"    # Ljava/lang/Object;

    .prologue
    .line 283
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;-><init>()V

    .line 285
    .local v0, "aborter":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;
    new-instance v1, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;

    invoke-direct {v1, p0, v0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute$1;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThreadAborter;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)V

    return-object v1
.end method

.method public setMaxTotalConnections(I)V
    .locals 2
    .param p1, "max"    # I

    .prologue
    .line 819
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 821
    :try_start_0
    iput p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->maxTotalConnections:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 823
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 825
    return-void

    .line 823
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public shutdown()V
    .locals 8

    .prologue
    .line 772
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 774
    :try_start_0
    iget-boolean v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->shutdown:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v5, :cond_0

    .line 811
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 813
    :goto_0
    return-void

    .line 777
    :cond_0
    const/4 v5, 0x1

    :try_start_1
    iput-boolean v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->shutdown:Z

    .line 780
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->leasedConnections:Ljava/util/Set;

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 781
    .local v1, "iter1":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;>;"
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 782
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    .line 783
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    .line 784
    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->closeConnection(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 811
    .end local v0    # "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .end local v1    # "iter1":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;>;"
    :catchall_0
    move-exception v5

    iget-object v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v6}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v5

    .line 788
    .restart local v1    # "iter1":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;>;"
    :cond_1
    :try_start_2
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->freeConnections:Ljava/util/Queue;

    invoke-interface {v5}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 789
    .local v2, "iter2":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;>;"
    :goto_2
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 790
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    .line 791
    .restart local v0    # "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    invoke-interface {v2}, Ljava/util/Iterator;->remove()V

    .line 793
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v5}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 794
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->log:Lorg/apache/commons/logging/Log;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "Closing connection ["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getPlannedRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]["

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getState()Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "]"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v5, v6}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 797
    :cond_2
    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->closeConnection(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;)V

    goto :goto_2

    .line 801
    .end local v0    # "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    :cond_3
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->waitingThreads:Ljava/util/Queue;

    invoke-interface {v5}, Ljava/util/Queue;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .line 802
    .local v3, "iwth":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;>;"
    :goto_3
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    .line 803
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;

    .line 804
    .local v4, "waiter":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;
    invoke-interface {v3}, Ljava/util/Iterator;->remove()V

    .line 805
    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;->wakeup()V

    goto :goto_3

    .line 808
    .end local v4    # "waiter":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/WaitingThread;
    :cond_4
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->routeToPool:Ljava/util/Map;

    invoke-interface {v5}, Ljava/util/Map;->clear()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 811
    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/ConnPoolByRoute;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v5}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto/16 :goto_0
.end method
