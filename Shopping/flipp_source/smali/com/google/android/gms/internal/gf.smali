.class final Lcom/google/android/gms/internal/gf;
.super Landroid/os/Handler;


# instance fields
.field final synthetic a:Lcom/google/android/gms/internal/ge;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/ge;Landroid/os/Looper;)V
    .locals 0

    iput-object p1, p0, Lcom/google/android/gms/internal/gf;->a:Lcom/google/android/gms/internal/ge;

    invoke-direct {p0, p2}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    return-void
.end method


# virtual methods
.method public final handleMessage(Landroid/os/Message;)V
    .locals 3

    iget v0, p1, Landroid/os/Message;->what:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    iget-object v0, p0, Lcom/google/android/gms/internal/gf;->a:Lcom/google/android/gms/internal/ge;

    iget-object v1, v0, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lcom/google/android/gms/internal/gf;->a:Lcom/google/android/gms/internal/ge;

    iget-object v0, v0, Lcom/google/android/gms/internal/ge;->a:Lcom/google/android/gms/internal/gg;

    invoke-interface {v0}, Lcom/google/android/gms/internal/gg;->j()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/gf;->a:Lcom/google/android/gms/internal/ge;

    iget-object v0, v0, Lcom/google/android/gms/internal/ge;->a:Lcom/google/android/gms/internal/gg;

    invoke-interface {v0}, Lcom/google/android/gms/internal/gg;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/google/android/gms/internal/gf;->a:Lcom/google/android/gms/internal/ge;

    iget-object v0, v0, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    iget-object v2, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/google/android/gms/common/api/b;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/b;->a()V

    :cond_0
    monitor-exit v1

    :goto_0
    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_1
    const-string v0, "GmsClientEvents"

    const-string v1, "Don\'t know how to handle this message."

    invoke-static {v0, v1}, Landroid/util/Log;->wtf(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
