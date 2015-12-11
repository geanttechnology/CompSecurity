.class public final Lvl;
.super Ljava/lang/Object;

# interfaces
.implements Lqo;
.implements Lqp;


# instance fields
.field private final a:Lvm;

.field private final b:Lvn;

.field private final c:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lvm;)V
    .locals 1

    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lvl;-><init>(Landroid/content/Context;Lvm;Z)V

    return-void
.end method

.method constructor <init>(Landroid/content/Context;Lvm;Z)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lvl;->c:Ljava/lang/Object;

    iput-object p2, p0, Lvl;->a:Lvm;

    new-instance v0, Lvn;

    const v1, 0x648278

    invoke-direct {v0, p1, p0, p0, v1}, Lvn;-><init>(Landroid/content/Context;Lqo;Lqp;I)V

    iput-object v0, p0, Lvl;->b:Lvn;

    if-nez p3, :cond_0

    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->a()V

    :cond_0
    return-void
.end method


# virtual methods
.method public onConnected(Landroid/os/Bundle;)V
    .locals 4

    invoke-static {}, Lug;->a()Landroid/os/Bundle;

    move-result-object v1

    iget-object v2, p0, Lvl;->c:Ljava/lang/Object;

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->f()Lvo;

    move-result-object v0

    if-eqz v0, :cond_7

    invoke-interface {v0}, Lvo;->a()Landroid/os/Bundle;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    :goto_0
    :try_start_1
    iget-object v1, p0, Lvl;->b:Lvn;

    invoke-virtual {v1}, Lvn;->c()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lvl;->b:Lvn;

    invoke-virtual {v1}, Lvn;->g()Z

    move-result v1

    if-eqz v1, :cond_1

    :cond_0
    iget-object v1, p0, Lvl;->b:Lvn;

    invoke-virtual {v1}, Lvn;->b()V

    :cond_1
    :goto_1
    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    iget-object v1, p0, Lvl;->a:Lvm;

    invoke-interface {v1, v0}, Lvm;->a(Landroid/os/Bundle;)V

    return-void

    :catch_0
    move-exception v0

    :try_start_2
    const-string v3, "Error when get Gservice values"

    invoke-static {v3, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->c()Z

    move-result v0

    if-nez v0, :cond_2

    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->g()Z

    move-result v0

    if-eqz v0, :cond_6

    :cond_2
    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->b()V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    move-object v0, v1

    goto :goto_1

    :catch_1
    move-exception v0

    :try_start_4
    const-string v3, "Error when get Gservice values"

    invoke-static {v3, v0}, Lacb;->d(Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    :try_start_5
    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->c()Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->g()Z

    move-result v0

    if-eqz v0, :cond_6

    :cond_3
    iget-object v0, p0, Lvl;->b:Lvn;

    invoke-virtual {v0}, Lvn;->b()V

    move-object v0, v1

    goto :goto_1

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lvl;->b:Lvn;

    invoke-virtual {v1}, Lvn;->c()Z

    move-result v1

    if-nez v1, :cond_4

    iget-object v1, p0, Lvl;->b:Lvn;

    invoke-virtual {v1}, Lvn;->g()Z

    move-result v1

    if-eqz v1, :cond_5

    :cond_4
    iget-object v1, p0, Lvl;->b:Lvn;

    invoke-virtual {v1}, Lvn;->b()V

    :cond_5
    throw v0

    :catchall_1
    move-exception v0

    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    throw v0

    :cond_6
    move-object v0, v1

    goto :goto_1

    :cond_7
    move-object v0, v1

    goto :goto_0
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 2

    iget-object v0, p0, Lvl;->a:Lvm;

    invoke-static {}, Lug;->a()Landroid/os/Bundle;

    move-result-object v1

    invoke-interface {v0, v1}, Lvm;->a(Landroid/os/Bundle;)V

    return-void
.end method

.method public onConnectionSuspended(I)V
    .locals 1

    const-string v0, "Disconnected from remote ad request service."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    return-void
.end method
