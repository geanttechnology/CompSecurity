.class public abstract Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;
.super Ljava/lang/Object;
.source "AbstractConnPool.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/RefQueueHandler;


# annotations
.annotation runtime Ljava/lang/Deprecated;
.end annotation


# instance fields
.field protected idleConnHandler:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;

.field protected volatile isShutDown:Z

.field protected leasedConnections:Ljava/util/Set;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation

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

.field protected final poolLock:Ljava/util/concurrent/locks/Lock;


# direct methods
.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 89
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->log:Lorg/apache/commons/logging/Log;

    .line 91
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->leasedConnections:Ljava/util/Set;

    .line 92
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;

    invoke-direct {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->idleConnHandler:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;

    .line 93
    new-instance v0, Ljava/util/concurrent/locks/ReentrantLock;

    invoke-direct {v0}, Ljava/util/concurrent/locks/ReentrantLock;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->poolLock:Ljava/util/concurrent/locks/Lock;

    .line 94
    return-void
.end method


# virtual methods
.method protected closeConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V
    .locals 3
    .param p1, "conn"    # Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    .prologue
    .line 224
    if-eqz p1, :cond_0

    .line 226
    :try_start_0
    invoke-interface {p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->close()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0

    .line 231
    :cond_0
    :goto_0
    return-void

    .line 227
    :catch_0
    move-exception v0

    .line 228
    .local v0, "ex":Ljava/io/IOException;
    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->log:Lorg/apache/commons/logging/Log;

    const-string v2, "I/O error closing connection"

    invoke-interface {v1, v2, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0
.end method

.method public handleReference(Ljava/lang/ref/Reference;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/ref/Reference",
            "<*>;)V"
        }
    .end annotation

    .prologue
    .line 148
    .local p1, "ref":Ljava/lang/ref/Reference;, "Ljava/lang/ref/Reference<*>;"
    return-void
.end method

.method public shutdown()V
    .locals 4

    .prologue
    .line 195
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->lock()V

    .line 198
    :try_start_0
    iget-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->isShutDown:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v2, :cond_0

    .line 213
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    .line 215
    :goto_0
    return-void

    .line 202
    :cond_0
    :try_start_1
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->leasedConnections:Ljava/util/Set;

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 203
    .local v1, "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;>;"
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 204
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;

    .line 205
    .local v0, "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    .line 206
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;->getConnection()Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    move-result-object v2

    invoke-virtual {p0, v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->closeConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 213
    .end local v0    # "entry":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;
    .end local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;>;"
    :catchall_0
    move-exception v2

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v3}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v2

    .line 208
    .restart local v1    # "iter":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/BasicPoolEntry;>;"
    :cond_1
    :try_start_2
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->idleConnHandler:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/IdleConnectionHandler;->removeAll()V

    .line 210
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->isShutDown:Z
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 213
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/tsccm/AbstractConnPool;->poolLock:Ljava/util/concurrent/locks/Lock;

    invoke-interface {v2}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_0
.end method
