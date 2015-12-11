.class public Lcom/comcast/cim/httpcomponentsandroid/protocol/SyncBasicHttpContext;
.super Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;
.source "SyncBasicHttpContext.java"


# virtual methods
.method public declared-synchronized getAttribute(Ljava/lang/String;)Ljava/lang/Object;
    .locals 1
    .param p1, "id"    # Ljava/lang/String;

    .prologue
    .line 42
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;->getAttribute(Ljava/lang/String;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    monitor-exit p0

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "id"    # Ljava/lang/String;
    .param p2, "obj"    # Ljava/lang/Object;

    .prologue
    .line 46
    monitor-enter p0

    :try_start_0
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/httpcomponentsandroid/protocol/BasicHttpContext;->setAttribute(Ljava/lang/String;Ljava/lang/Object;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 47
    monitor-exit p0

    return-void

    .line 46
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
