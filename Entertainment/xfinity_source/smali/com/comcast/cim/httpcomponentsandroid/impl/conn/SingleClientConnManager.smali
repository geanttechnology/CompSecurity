.class public Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;
.super Ljava/lang/Object;
.source "SingleClientConnManager.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/ThreadSafe;
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;,
        Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;
    }
.end annotation


# instance fields
.field protected final alwaysShutDown:Z

.field protected final connOperator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

.field protected volatile connectionExpiresTime:J
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field protected volatile isShutDown:Z

.field protected volatile lastReleaseTime:J
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field private final log:Lorg/apache/commons/logging/Log;

.field protected volatile managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field

.field protected final schemeRegistry:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

.field protected volatile uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;
    .annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/GuardedBy;
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 135
    invoke-static {}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SchemeRegistryFactory;->createDefault()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)V

    .line 136
    return-void
.end method

.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)V
    .locals 3
    .param p1, "schreg"    # Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    .prologue
    const/4 v2, 0x0

    .line 117
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 64
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v0

    invoke-static {v0}, Lorg/apache/commons/logging/LogFactory;->getLog(Ljava/lang/Class;)Lorg/apache/commons/logging/Log;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    .line 118
    if-nez p1, :cond_0

    .line 119
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Scheme registry must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 122
    :cond_0
    iput-object p1, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->schemeRegistry:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    .line 123
    invoke-virtual {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->createConnectionOperator(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    move-result-object v0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connOperator:Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;

    .line 124
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    invoke-direct {v0, p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;)V

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    .line 125
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 126
    const-wide/16 v0, -0x1

    iput-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J

    .line 127
    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->alwaysShutDown:Z

    .line 128
    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->isShutDown:Z

    .line 129
    return-void
.end method


# virtual methods
.method protected final assertStillUp()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalStateException;
        }
    .end annotation

    .prologue
    .line 174
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->isShutDown:Z

    if-eqz v0, :cond_0

    .line 175
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "Manager is shut down."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 176
    :cond_0
    return-void
.end method

.method public closeExpiredConnections()V
    .locals 5

    .prologue
    .line 315
    iget-wide v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connectionExpiresTime:J

    .line 316
    .local v0, "time":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    cmp-long v2, v2, v0

    if-ltz v2, :cond_0

    .line 317
    const-wide/16 v2, 0x0

    sget-object v4, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-virtual {p0, v2, v3, v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->closeIdleConnections(JLjava/util/concurrent/TimeUnit;)V

    .line 319
    :cond_0
    return-void
.end method

.method public closeIdleConnections(JLjava/util/concurrent/TimeUnit;)V
    .locals 9
    .param p1, "idletime"    # J
    .param p3, "tunit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    .line 322
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->assertStillUp()V

    .line 325
    if-nez p3, :cond_0

    .line 326
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Time unit must not be null."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 329
    :cond_0
    monitor-enter p0

    .line 330
    :try_start_0
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    iget-object v3, v3, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v3}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isOpen()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 331
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-virtual {p3, p1, p2}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v6

    sub-long v0, v4, v6

    .line 333
    .local v0, "cutoff":J
    iget-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    cmp-long v3, v4, v0

    if-gtz v3, :cond_1

    .line 335
    :try_start_1
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->close()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 342
    .end local v0    # "cutoff":J
    :cond_1
    :goto_0
    :try_start_2
    monitor-exit p0

    .line 343
    return-void

    .line 336
    .restart local v0    # "cutoff":J
    :catch_0
    move-exception v2

    .line 338
    .local v2, "iox":Ljava/io/IOException;
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Problem closing idle connection."

    invoke-interface {v3, v4, v2}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 342
    .end local v0    # "cutoff":J
    .end local v2    # "iox":Ljava/io/IOException;
    :catchall_0
    move-exception v3

    monitor-exit p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v3
.end method

.method protected createConnectionOperator(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionOperator;
    .locals 1
    .param p1, "schreg"    # Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    .prologue
    .line 165
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnectionOperator;

    invoke-direct {v0, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/DefaultClientConnectionOperator;-><init>(Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;)V

    return-object v0
.end method

.method protected finalize()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Throwable;
        }
    .end annotation

    .prologue
    .line 141
    :try_start_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->shutdown()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 143
    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    .line 145
    return-void

    .line 143
    :catchall_0
    move-exception v0

    invoke-super {p0}, Ljava/lang/Object;->finalize()V

    throw v0
.end method

.method public getConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    .locals 7
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "state"    # Ljava/lang/Object;

    .prologue
    .line 206
    if-nez p1, :cond_0

    .line 207
    new-instance v4, Ljava/lang/IllegalArgumentException;

    const-string v5, "Route may not be null."

    invoke-direct {v4, v5}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 209
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->assertStillUp()V

    .line 211
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v4}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 212
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Get connection for route "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v4, v5}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 215
    :cond_1
    monitor-enter p0

    .line 216
    :try_start_0
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    if-eqz v4, :cond_2

    .line 217
    new-instance v4, Ljava/lang/IllegalStateException;

    const-string v5, "Invalid use of SingleClientConnManager: connection still allocated.\nMake sure to release the connection before allocating another one."

    invoke-direct {v4, v5}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v4

    .line 254
    :catchall_0
    move-exception v4

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v4

    .line 220
    :cond_2
    const/4 v1, 0x0

    .line 221
    .local v1, "recreate":Z
    const/4 v2, 0x0

    .line 224
    .local v2, "shutdown":Z
    :try_start_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->closeExpiredConnections()V

    .line 226
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    iget-object v4, v4, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->connection:Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;

    invoke-interface {v4}, Lcom/comcast/cim/httpcomponentsandroid/conn/OperatedClientConnection;->isOpen()Z

    move-result v4

    if-eqz v4, :cond_7

    .line 227
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    iget-object v3, v4, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->tracker:Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;

    .line 228
    .local v3, "tracker":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;
    if-eqz v3, :cond_3

    invoke-virtual {v3}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;->toRoute()Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;

    move-result-object v4

    invoke-virtual {v4, p1}, Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;->equals(Ljava/lang/Object;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v4

    if-nez v4, :cond_6

    :cond_3
    const/4 v2, 0x1

    .line 239
    .end local v3    # "tracker":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;
    :goto_0
    if-eqz v2, :cond_4

    .line 240
    const/4 v1, 0x1

    .line 242
    :try_start_2
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    invoke-virtual {v4}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->shutdown()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 248
    :cond_4
    :goto_1
    if-eqz v1, :cond_5

    .line 249
    :try_start_3
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    invoke-direct {v4, p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;)V

    iput-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    .line 251
    :cond_5
    new-instance v4, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    iget-object v5, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    invoke-direct {v4, p0, v5, p1}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;)V

    iput-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 253
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    monitor-exit p0

    return-object v4

    .line 228
    .restart local v3    # "tracker":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;
    :cond_6
    const/4 v2, 0x0

    goto :goto_0

    .line 236
    .end local v3    # "tracker":Lcom/comcast/cim/httpcomponentsandroid/conn/routing/RouteTracker;
    :cond_7
    const/4 v1, 0x1

    goto :goto_0

    .line 243
    :catch_0
    move-exception v0

    .line 244
    .local v0, "iox":Ljava/io/IOException;
    iget-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    const-string v5, "Problem shutting down connection."

    invoke-interface {v4, v5, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_1
.end method

.method public getSchemeRegistry()Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;
    .locals 1

    .prologue
    .line 148
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->schemeRegistry:Lcom/comcast/cim/httpcomponentsandroid/conn/scheme/SchemeRegistry;

    return-object v0
.end method

.method public releaseConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;JLjava/util/concurrent/TimeUnit;)V
    .locals 8
    .param p1, "conn"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    .param p2, "validDuration"    # J
    .param p4, "timeUnit"    # Ljava/util/concurrent/TimeUnit;

    .prologue
    const-wide/16 v6, 0x0

    .line 260
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->assertStillUp()V

    .line 262
    instance-of v3, p1, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    if-nez v3, :cond_0

    .line 263
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Connection class mismatch, connection not obtained from this manager."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 268
    :cond_0
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 269
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Releasing connection "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    :cond_1
    move-object v2, p1

    .line 272
    check-cast v2, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 273
    .local v2, "sca":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;
    monitor-enter v2

    .line 274
    :try_start_0
    iget-object v3, v2, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->poolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/AbstractPoolEntry;

    if-nez v3, :cond_2

    .line 275
    monitor-exit v2

    .line 312
    :goto_0
    return-void

    .line 276
    :cond_2
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->getManager()Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;

    move-result-object v1

    .line 277
    .local v1, "manager":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    if-eqz v1, :cond_3

    if-eq v1, p0, :cond_3

    .line 278
    new-instance v3, Ljava/lang/IllegalArgumentException;

    const-string v4, "Connection not obtained from this manager."

    invoke-direct {v3, v4}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 311
    .end local v1    # "manager":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    :catchall_0
    move-exception v3

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v3

    .line 283
    .restart local v1    # "manager":Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionManager;
    :cond_3
    :try_start_1
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->isOpen()Z

    move-result v3

    if-eqz v3, :cond_6

    iget-boolean v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->alwaysShutDown:Z

    if-nez v3, :cond_4

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->isMarkedReusable()Z

    move-result v3

    if-nez v3, :cond_6

    .line 286
    :cond_4
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_5

    .line 287
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Released connection open but not reusable."

    invoke-interface {v3, v4}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;)V

    .line 294
    :cond_5
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->shutdown()V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_3

    .line 301
    :cond_6
    :try_start_2
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->detach()V

    .line 302
    monitor-enter p0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 303
    const/4 v3, 0x0

    :try_start_3
    iput-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 304
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J

    .line 305
    cmp-long v3, p2, v6

    if-lez v3, :cond_7

    .line 306
    invoke-virtual {p4, p2, p3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v4

    iget-wide v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connectionExpiresTime:J

    .line 309
    :goto_1
    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 311
    :goto_2
    :try_start_4
    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 308
    :cond_7
    const-wide v4, 0x7fffffffffffffffL

    :try_start_5
    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connectionExpiresTime:J

    goto :goto_1

    .line 309
    :catchall_1
    move-exception v3

    monitor-exit p0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :try_start_6
    throw v3
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    .line 296
    :catch_0
    move-exception v0

    .line 297
    .local v0, "iox":Ljava/io/IOException;
    :try_start_7
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    invoke-interface {v3}, Lorg/apache/commons/logging/Log;->isDebugEnabled()Z

    move-result v3

    if-eqz v3, :cond_8

    .line 298
    iget-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    const-string v4, "Exception shutting down released connection."

    invoke-interface {v3, v4, v0}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 301
    :cond_8
    :try_start_8
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->detach()V

    .line 302
    monitor-enter p0
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 303
    const/4 v3, 0x0

    :try_start_9
    iput-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 304
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J

    .line 305
    cmp-long v3, p2, v6

    if-lez v3, :cond_9

    .line 306
    invoke-virtual {p4, p2, p3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v4

    iget-wide v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connectionExpiresTime:J

    .line 309
    :goto_3
    monitor-exit p0

    goto :goto_2

    :catchall_2
    move-exception v3

    monitor-exit p0
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_2

    :try_start_a
    throw v3
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 308
    :cond_9
    const-wide v4, 0x7fffffffffffffffL

    :try_start_b
    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connectionExpiresTime:J
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_2

    goto :goto_3

    .line 301
    .end local v0    # "iox":Ljava/io/IOException;
    :catchall_3
    move-exception v3

    :try_start_c
    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->detach()V

    .line 302
    monitor-enter p0
    :try_end_c
    .catchall {:try_start_c .. :try_end_c} :catchall_0

    .line 303
    const/4 v4, 0x0

    :try_start_d
    iput-object v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 304
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J

    .line 305
    cmp-long v4, p2, v6

    if-lez v4, :cond_a

    .line 306
    invoke-virtual {p4, p2, p3}, Ljava/util/concurrent/TimeUnit;->toMillis(J)J

    move-result-wide v4

    iget-wide v6, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->lastReleaseTime:J

    add-long/2addr v4, v6

    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connectionExpiresTime:J

    .line 309
    :goto_4
    monitor-exit p0
    :try_end_d
    .catchall {:try_start_d .. :try_end_d} :catchall_4

    :try_start_e
    throw v3
    :try_end_e
    .catchall {:try_start_e .. :try_end_e} :catchall_0

    .line 308
    :cond_a
    const-wide v4, 0x7fffffffffffffffL

    :try_start_f
    iput-wide v4, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->connectionExpiresTime:J

    goto :goto_4

    .line 309
    :catchall_4
    move-exception v3

    monitor-exit p0
    :try_end_f
    .catchall {:try_start_f .. :try_end_f} :catchall_4

    :try_start_10
    throw v3
    :try_end_10
    .catchall {:try_start_10 .. :try_end_10} :catchall_0
.end method

.method public final requestConnection(Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)Lcom/comcast/cim/httpcomponentsandroid/conn/ClientConnectionRequest;
    .locals 1
    .param p1, "route"    # Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;
    .param p2, "state"    # Ljava/lang/Object;

    .prologue
    .line 182
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;

    invoke-direct {v0, p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$1;-><init>(Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;Lcom/comcast/cim/httpcomponentsandroid/conn/routing/HttpRoute;Ljava/lang/Object;)V

    return-object v0
.end method

.method public shutdown()V
    .locals 4

    .prologue
    .line 346
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->isShutDown:Z

    .line 348
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 349
    .local v0, "conn":Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;
    if-eqz v0, :cond_0

    .line 350
    invoke-virtual {v0}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;->detach()V

    .line 352
    :cond_0
    monitor-enter p0

    .line 354
    :try_start_0
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    if-eqz v2, :cond_1

    .line 355
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    invoke-virtual {v2}, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;->shutdown()V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    .line 360
    :cond_1
    const/4 v2, 0x0

    :try_start_1
    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    .line 361
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    .line 363
    :goto_0
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 364
    return-void

    .line 356
    :catch_0
    move-exception v1

    .line 358
    .local v1, "iox":Ljava/io/IOException;
    :try_start_2
    iget-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->log:Lorg/apache/commons/logging/Log;

    const-string v3, "Problem while shutting down manager."

    invoke-interface {v2, v3, v1}, Lorg/apache/commons/logging/Log;->debug(Ljava/lang/Object;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 360
    const/4 v2, 0x0

    :try_start_3
    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    .line 361
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    goto :goto_0

    .line 363
    .end local v1    # "iox":Ljava/io/IOException;
    :catchall_0
    move-exception v2

    monitor-exit p0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    throw v2

    .line 360
    :catchall_1
    move-exception v2

    const/4 v3, 0x0

    :try_start_4
    iput-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->uniquePoolEntry:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$PoolEntry;

    .line 361
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/impl/conn/SingleClientConnManager$ConnAdapter;

    throw v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0
.end method
