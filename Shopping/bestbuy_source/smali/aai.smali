.class public final Laai;
.super Laag;

# interfaces
.implements Lqo;
.implements Lqp;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Laaf;

.field private final b:Laaj;

.field private final c:Ljava/lang/Object;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/internal/fh;Laaf;)V
    .locals 2

    invoke-direct {p0, p2, p3}, Laag;-><init>(Lcom/google/android/gms/internal/fh;Laaf;)V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Laai;->c:Ljava/lang/Object;

    iput-object p3, p0, Laai;->a:Laaf;

    new-instance v0, Laaj;

    iget-object v1, p2, Lcom/google/android/gms/internal/fh;->k:Lcom/google/android/gms/internal/gs;

    iget v1, v1, Lcom/google/android/gms/internal/gs;->d:I

    invoke-direct {v0, p1, p0, p0, v1}, Laaj;-><init>(Landroid/content/Context;Lqo;Lqp;I)V

    iput-object v0, p0, Laai;->b:Laaj;

    iget-object v0, p0, Laai;->b:Laaj;

    invoke-virtual {v0}, Laaj;->a()V

    return-void
.end method


# virtual methods
.method public c()V
    .locals 2

    iget-object v1, p0, Laai;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Laai;->b:Laaj;

    invoke-virtual {v0}, Laaj;->c()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Laai;->b:Laaj;

    invoke-virtual {v0}, Laaj;->g()Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    iget-object v0, p0, Laai;->b:Laaj;

    invoke-virtual {v0}, Laaj;->b()V

    :cond_1
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public d()Laan;
    .locals 2

    iget-object v1, p0, Laai;->c:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Laai;->b:Laaj;

    invoke-virtual {v0}, Laaj;->f()Laan;
    :try_end_0
    .catch Ljava/lang/IllegalStateException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Landroid/os/DeadObjectException; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    :try_start_1
    monitor-exit v1

    :goto_0
    return-object v0

    :catch_0
    move-exception v0

    :goto_1
    const/4 v0, 0x0

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :catch_1
    move-exception v0

    goto :goto_1
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 0

    invoke-virtual {p0}, Laai;->e()V

    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    iget-object v0, p0, Laai;->a:Laaf;

    new-instance v1, Lcom/google/android/gms/internal/fj;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/google/android/gms/internal/fj;-><init>(I)V

    invoke-interface {v0, v1}, Laaf;->a(Lcom/google/android/gms/internal/fj;)V

    return-void
.end method

.method public onConnectionSuspended(I)V
    .locals 1

    const-string v0, "Disconnected from remote ad request service."

    invoke-static {v0}, Lacb;->a(Ljava/lang/String;)V

    return-void
.end method
