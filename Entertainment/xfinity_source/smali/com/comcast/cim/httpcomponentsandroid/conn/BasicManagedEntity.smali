.class public Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;
.super Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;
.source "BasicManagedEntity.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/ConnectionReleaseTrigger;
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/EofSensorWatcher;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field protected final attemptReuse:Z

.field protected managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;


# direct methods
.method public constructor <init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;Z)V
    .locals 2
    .param p1, "entity"    # Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;
    .param p2, "conn"    # Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;
    .param p3, "reuse"    # Z

    .prologue
    .line 71
    invoke-direct {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;-><init>(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 73
    if-nez p2, :cond_0

    .line 74
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "Connection may not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 77
    :cond_0
    iput-object p2, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    .line 78
    iput-boolean p3, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->attemptReuse:Z

    .line 79
    return-void
.end method

.method private ensureConsumed()V
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 92
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    if-nez v0, :cond_0

    .line 104
    :goto_0
    return-void

    .line 96
    :cond_0
    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->attemptReuse:Z

    if-eqz v0, :cond_1

    .line 98
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-static {v0}, Lcom/comcast/cim/httpcomponentsandroid/util/EntityUtils;->consume(Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;)V

    .line 99
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 102
    :cond_1
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->releaseManagedConnection()V

    goto :goto_0

    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->releaseManagedConnection()V

    throw v0
.end method


# virtual methods
.method public abortConnection()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 124
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    if-eqz v0, :cond_0

    .line 126
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->abortConnection()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 128
    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    .line 131
    :cond_0
    return-void

    .line 128
    :catchall_0
    move-exception v0

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    throw v0
.end method

.method public eofDetected(Ljava/io/InputStream;)Z
    .locals 1
    .param p1, "wrapped"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 135
    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->attemptReuse:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    if-eqz v0, :cond_0

    .line 138
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V

    .line 139
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 142
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->releaseManagedConnection()V

    .line 144
    const/4 v0, 0x0

    return v0

    .line 142
    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->releaseManagedConnection()V

    throw v0
.end method

.method public getContent()Ljava/io/InputStream;
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 88
    new-instance v0, Lcom/comcast/cim/httpcomponentsandroid/conn/EofSensorInputStream;

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->wrappedEntity:Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v1

    invoke-direct {v0, v1, p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/EofSensorInputStream;-><init>(Ljava/io/InputStream;Lcom/comcast/cim/httpcomponentsandroid/conn/EofSensorWatcher;)V

    return-object v0
.end method

.method public isRepeatable()Z
    .locals 1

    .prologue
    .line 83
    const/4 v0, 0x0

    return v0
.end method

.method public releaseConnection()V
    .locals 0
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 119
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->ensureConsumed()V

    .line 120
    return-void
.end method

.method protected releaseManagedConnection()V
    .locals 2
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 179
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    if-eqz v0, :cond_0

    .line 181
    :try_start_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->releaseConnection()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 183
    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    .line 186
    :cond_0
    return-void

    .line 183
    :catchall_0
    move-exception v0

    iput-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    throw v0
.end method

.method public streamAbort(Ljava/io/InputStream;)Z
    .locals 1
    .param p1, "wrapped"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 162
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    if-eqz v0, :cond_0

    .line 163
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->abortConnection()V

    .line 165
    :cond_0
    const/4 v0, 0x0

    return v0
.end method

.method public streamClosed(Ljava/io/InputStream;)Z
    .locals 1
    .param p1, "wrapped"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 149
    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->attemptReuse:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    if-eqz v0, :cond_0

    .line 152
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V

    .line 153
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 156
    :cond_0
    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->releaseManagedConnection()V

    .line 158
    const/4 v0, 0x0

    return v0

    .line 156
    :catchall_0
    move-exception v0

    invoke-virtual {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->releaseManagedConnection()V

    throw v0
.end method

.method public writeTo(Ljava/io/OutputStream;)V
    .locals 0
    .param p1, "outstream"    # Ljava/io/OutputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/entity/HttpEntityWrapper;->writeTo(Ljava/io/OutputStream;)V

    .line 115
    invoke-direct {p0}, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicManagedEntity;->ensureConsumed()V

    .line 116
    return-void
.end method
