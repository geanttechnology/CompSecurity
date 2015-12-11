.class final Lcom/google/android/gms/internal/fx;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/fw;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/fw;Landroid/os/Looper;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/fx;->a:Lcom/google/android/gms/internal/fw;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 5

    const/4 v4, 0x2

    const/4 v3, 0x1

    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v3, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/fx;->a:Lcom/google/android/gms/internal/fw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/fw;->f()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/gms/internal/fy;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/fy;->b()V

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lcom/google/android/gms/internal/fx;->a:Lcom/google/android/gms/internal/fw;

    invoke-static {v0}, Lcom/google/android/gms/internal/fw;->b(Lcom/google/android/gms/internal/fw;)Ljava/lang/Object;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/fx;->a:Lcom/google/android/gms/internal/fw;

    const/4 v2, 0x0

    iput-boolean v2, v0, Lcom/google/android/gms/internal/fw;->d:Z

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x3

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/fx;->a:Lcom/google/android/gms/internal/fw;

    invoke-static {v0}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/ge;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/common/a;

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    const/4 v3, 0x0

    invoke-direct {v2, v0, v3}, Lcom/google/android/gms/common/a;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/ge;->a(Lcom/google/android/gms/common/a;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    :try_start_1
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v0

    :cond_1
    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x4

    if-ne v0, v1, :cond_2

    iget-object v0, p0, Lcom/google/android/gms/internal/fx;->a:Lcom/google/android/gms/internal/fw;

    invoke-static {v0}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/ge;

    move-result-object v1

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Ljava/lang/Integer;

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    invoke-virtual {v1}, Lcom/google/android/gms/internal/ge;->a()V

    goto :goto_0

    :cond_2
    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v4, :cond_3

    iget-object v0, p0, Lcom/google/android/gms/internal/fx;->a:Lcom/google/android/gms/internal/fw;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/fw;->e()Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/gms/internal/fy;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/fy;->b()V

    goto :goto_0

    :cond_3
    iget v0, p1, Landroid/os/Message;->what:I

    if-eq v0, v4, :cond_4

    iget v0, p1, Landroid/os/Message;->what:I

    if-ne v0, v3, :cond_5

    :cond_4
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/gms/internal/fy;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/fy;->a()V

    goto :goto_0

    :cond_5
    const-string v0, "GmsClient"

    const-string v1, "Don\'t know how to handle this message."

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
