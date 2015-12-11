.class public Ladj;
.super Ljava/lang/Object;

# interfaces
.implements Landroid/content/ServiceConnection;


# instance fields
.field final synthetic a:Ladi;


# direct methods
.method public constructor <init>(Ladi;)V
    .locals 0

    iput-object p1, p0, Ladj;->a:Ladi;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V
    .locals 3

    iget-object v0, p0, Ladj;->a:Ladi;

    iget-object v0, v0, Ladi;->a:Ladh;

    invoke-static {v0}, Ladh;->a(Ladh;)Ljava/util/HashMap;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Ladj;->a:Ladi;

    invoke-static {v0, p2}, Ladi;->a(Ladi;Landroid/os/IBinder;)Landroid/os/IBinder;

    iget-object v0, p0, Ladj;->a:Ladi;

    invoke-static {v0, p1}, Ladi;->a(Ladi;Landroid/content/ComponentName;)Landroid/content/ComponentName;

    iget-object v0, p0, Ladj;->a:Ladi;

    invoke-static {v0}, Ladi;->a(Ladi;)Ljava/util/HashSet;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ladc;

    invoke-virtual {v0, p1, p2}, Ladc;->onServiceConnected(Landroid/content/ComponentName;Landroid/os/IBinder;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Ladj;->a:Ladi;

    const/4 v2, 0x1

    invoke-static {v0, v2}, Ladi;->a(Ladi;I)I

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method

.method public onServiceDisconnected(Landroid/content/ComponentName;)V
    .locals 3

    iget-object v0, p0, Ladj;->a:Ladi;

    iget-object v0, v0, Ladi;->a:Ladh;

    invoke-static {v0}, Ladh;->a(Ladh;)Ljava/util/HashMap;

    move-result-object v1

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Ladj;->a:Ladi;

    const/4 v2, 0x0

    invoke-static {v0, v2}, Ladi;->a(Ladi;Landroid/os/IBinder;)Landroid/os/IBinder;

    iget-object v0, p0, Ladj;->a:Ladi;

    invoke-static {v0, p1}, Ladi;->a(Ladi;Landroid/content/ComponentName;)Landroid/content/ComponentName;

    iget-object v0, p0, Ladj;->a:Ladi;

    invoke-static {v0}, Ladi;->a(Ladi;)Ljava/util/HashSet;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashSet;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ladc;

    invoke-virtual {v0, p1}, Ladc;->onServiceDisconnected(Landroid/content/ComponentName;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_0
    :try_start_1
    iget-object v0, p0, Ladj;->a:Ladi;

    const/4 v2, 0x2

    invoke-static {v0, v2}, Ladi;->a(Ladi;I)I

    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method
