.class public Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;
.super Ljava/lang/Object;
.source "BasicEofSensorWatcher.java"

# interfaces
.implements Lcom/comcast/cim/httpcomponentsandroid/conn/EofSensorWatcher;


# annotations
.annotation build Lcom/comcast/cim/httpcomponentsandroid/annotation/NotThreadSafe;
.end annotation


# instance fields
.field protected final attemptReuse:Z

.field protected final managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;


# virtual methods
.method public eofDetected(Ljava/io/InputStream;)Z
    .locals 2
    .param p1, "wrapped"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 70
    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->attemptReuse:Z

    if-eqz v0, :cond_0

    .line 73
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V

    .line 74
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 77
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->releaseConnection()V

    .line 79
    const/4 v0, 0x0

    return v0

    .line 77
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->releaseConnection()V

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
    .line 101
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->abortConnection()V

    .line 102
    const/4 v0, 0x0

    return v0
.end method

.method public streamClosed(Ljava/io/InputStream;)Z
    .locals 2
    .param p1, "wrapped"    # Ljava/io/InputStream;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 86
    :try_start_0
    iget-boolean v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->attemptReuse:Z

    if-eqz v0, :cond_0

    .line 89
    invoke-virtual {p1}, Ljava/io/InputStream;->close()V

    .line 90
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->markReusable()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 93
    :cond_0
    iget-object v0, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v0}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->releaseConnection()V

    .line 95
    const/4 v0, 0x0

    return v0

    .line 93
    :catchall_0
    move-exception v0

    iget-object v1, p0, Lcom/comcast/cim/httpcomponentsandroid/conn/BasicEofSensorWatcher;->managedConn:Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;

    invoke-interface {v1}, Lcom/comcast/cim/httpcomponentsandroid/conn/ManagedClientConnection;->releaseConnection()V

    throw v0
.end method
