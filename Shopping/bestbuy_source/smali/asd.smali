.class Lasd;
.super Ljava/lang/Object;

# interfaces
.implements Laqe;


# instance fields
.field private a:Laqd;

.field private b:Laqd;

.field private c:Lcom/google/android/gms/common/api/Status;

.field private d:Lasf;

.field private e:Lase;

.field private f:Z

.field private g:Laql;


# virtual methods
.method public declared-synchronized a()V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lasd;->f:Z

    if-eqz v0, :cond_0

    const-string v0, "Releasing a released ContainerHolder."

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    const/4 v0, 0x1

    :try_start_1
    iput-boolean v0, p0, Lasd;->f:Z

    iget-object v0, p0, Lasd;->g:Laql;

    invoke-virtual {v0, p0}, Laql;->a(Lasd;)Z

    iget-object v0, p0, Lasd;->a:Laqd;

    invoke-virtual {v0}, Laqd;->b()V

    const/4 v0, 0x0

    iput-object v0, p0, Lasd;->a:Laqd;

    const/4 v0, 0x0

    iput-object v0, p0, Lasd;->b:Laqd;

    const/4 v0, 0x0

    iput-object v0, p0, Lasd;->e:Lase;

    const/4 v0, 0x0

    iput-object v0, p0, Lasd;->d:Lasf;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized a(Ljava/lang/String;)V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lasd;->f:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-object v0, p0, Lasd;->a:Laqd;

    invoke-virtual {v0, p1}, Laqd;->a(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public b()Lcom/google/android/gms/common/api/Status;
    .locals 1

    iget-object v0, p0, Lasd;->c:Lcom/google/android/gms/common/api/Status;

    return-object v0
.end method

.method b(Ljava/lang/String;)V
    .locals 1

    iget-boolean v0, p0, Lasd;->f:Z

    if-eqz v0, :cond_0

    const-string v0, "setCtfeUrlPathAndQuery called on a released ContainerHolder."

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lasd;->e:Lase;

    invoke-interface {v0, p1}, Lase;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public declared-synchronized c()V
    .locals 1

    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Lasd;->f:Z

    if-eqz v0, :cond_0

    const-string v0, "Refreshing a released ContainerHolder."

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :goto_0
    monitor-exit p0

    return-void

    :cond_0
    :try_start_1
    iget-object v0, p0, Lasd;->e:Lase;

    invoke-interface {v0}, Lase;->a()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method d()Ljava/lang/String;
    .locals 1

    iget-boolean v0, p0, Lasd;->f:Z

    if-eqz v0, :cond_0

    const-string v0, "getContainerId called on a released ContainerHolder."

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lasd;->a:Laqd;

    invoke-virtual {v0}, Laqd;->a()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method e()Ljava/lang/String;
    .locals 1

    iget-boolean v0, p0, Lasd;->f:Z

    if-eqz v0, :cond_0

    const-string v0, "setCtfeUrlPathAndQuery called on a released ContainerHolder."

    invoke-static {v0}, Laqv;->a(Ljava/lang/String;)V

    const-string v0, ""

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lasd;->e:Lase;

    invoke-interface {v0}, Lase;->b()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
