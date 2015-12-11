.class Lqw$2;
.super Ljava/lang/Object;

# interfaces
.implements Lqo;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lqw;
.end annotation


# instance fields
.field final synthetic a:Lqw;


# direct methods
.method constructor <init>(Lqw;)V
    .locals 0

    iput-object p1, p0, Lqw$2;->a:Lqw;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onConnected(Landroid/os/Bundle;)V
    .locals 2

    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    :try_start_0
    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->b(Lqw;)I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    if-eqz p1, :cond_0

    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->c(Lqw;)Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    :cond_0
    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->d(Lqw;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    :cond_1
    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    return-void

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw$2;->a:Lqw;

    invoke-static {v1}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0
.end method

.method public onConnectionSuspended(I)V
    .locals 4

    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->lock()V

    packed-switch p1, :pswitch_data_0

    :goto_0
    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    :goto_1
    return-void

    :pswitch_0
    :try_start_0
    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0, p1}, Lqw;->a(Lqw;I)V

    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-virtual {v0}, Lqw;->b()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    :catchall_0
    move-exception v0

    iget-object v1, p0, Lqw$2;->a:Lqw;

    invoke-static {v1}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/concurrent/locks/Lock;->unlock()V

    throw v0

    :pswitch_1
    :try_start_1
    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-virtual {v0}, Lqw;->f()Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0}, Lqw;->a(Lqw;)Ljava/util/concurrent/locks/Lock;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/concurrent/locks/Lock;->unlock()V

    goto :goto_1

    :cond_0
    :try_start_2
    iget-object v0, p0, Lqw$2;->a:Lqw;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lqw;->a(Lqw;Z)Z

    iget-object v0, p0, Lqw$2;->a:Lqw;

    new-instance v1, Lqx;

    iget-object v2, p0, Lqw$2;->a:Lqw;

    invoke-direct {v1, v2}, Lqx;-><init>(Lqw;)V

    iput-object v1, v0, Lqw;->c:Landroid/content/BroadcastReceiver;

    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.intent.action.PACKAGE_ADDED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    const-string v1, "package"

    invoke-virtual {v0, v1}, Landroid/content/IntentFilter;->addDataScheme(Ljava/lang/String;)V

    iget-object v1, p0, Lqw$2;->a:Lqw;

    invoke-static {v1}, Lqw;->e(Lqw;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lqw$2;->a:Lqw;

    iget-object v2, v2, Lqw;->c:Landroid/content/BroadcastReceiver;

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    iget-object v0, p0, Lqw$2;->a:Lqw;

    iget-object v0, v0, Lqw;->b:Landroid/os/Handler;

    iget-object v1, p0, Lqw$2;->a:Lqw;

    iget-object v1, v1, Lqw;->b:Landroid/os/Handler;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lqw$2;->a:Lqw;

    invoke-static {v2}, Lqw;->f(Lqw;)J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    iget-object v0, p0, Lqw$2;->a:Lqw;

    iget-object v0, v0, Lqw;->b:Landroid/os/Handler;

    iget-object v1, p0, Lqw$2;->a:Lqw;

    iget-object v1, v1, Lqw;->b:Landroid/os/Handler;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/os/Handler;->obtainMessage(I)Landroid/os/Message;

    move-result-object v1

    iget-object v2, p0, Lqw$2;->a:Lqw;

    invoke-static {v2}, Lqw;->g(Lqw;)J

    move-result-wide v2

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    iget-object v0, p0, Lqw$2;->a:Lqw;

    invoke-static {v0, p1}, Lqw;->a(Lqw;I)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_0

    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
    .end packed-switch
.end method
