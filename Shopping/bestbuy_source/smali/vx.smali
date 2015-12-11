.class public final Lvx;
.super Lwm;


# annotations
.annotation runtime Lzf;
.end annotation


# instance fields
.field private final a:Ljava/lang/Object;

.field private b:Lwa;

.field private c:Lvw;


# direct methods
.method public constructor <init>()V
    .locals 1

    invoke-direct {p0}, Lwm;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lvx;->a:Ljava/lang/Object;

    return-void
.end method


# virtual methods
.method public a()V
    .locals 2

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvx;->c:Lvw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvx;->c:Lvw;

    invoke-interface {v0}, Lvw;->k()V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(I)V
    .locals 3

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvx;->b:Lwa;

    if-eqz v0, :cond_0

    const/4 v0, 0x3

    if-ne p1, v0, :cond_1

    const/4 v0, 0x1

    :goto_0
    iget-object v2, p0, Lvx;->b:Lwa;

    invoke-interface {v2, v0}, Lwa;->a(I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lvx;->b:Lwa;

    :cond_0
    monitor-exit v1

    return-void

    :cond_1
    const/4 v0, 0x2

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Lvw;)V
    .locals 2

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput-object p1, p0, Lvx;->c:Lvw;

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Lwa;)V
    .locals 2

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iput-object p1, p0, Lvx;->b:Lwa;

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public b()V
    .locals 2

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvx;->c:Lvw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvx;->c:Lvw;

    invoke-interface {v0}, Lvw;->l()V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public c()V
    .locals 2

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvx;->c:Lvw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvx;->c:Lvw;

    invoke-interface {v0}, Lvw;->m()V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public d()V
    .locals 2

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvx;->c:Lvw;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvx;->c:Lvw;

    invoke-interface {v0}, Lvw;->n()V

    :cond_0
    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public e()V
    .locals 3

    iget-object v1, p0, Lvx;->a:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lvx;->b:Lwa;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lvx;->b:Lwa;

    const/4 v2, 0x0

    invoke-interface {v0, v2}, Lwa;->a(I)V

    const/4 v0, 0x0

    iput-object v0, p0, Lvx;->b:Lwa;

    monitor-exit v1

    :goto_0
    return-void

    :cond_0
    iget-object v0, p0, Lvx;->c:Lvw;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lvx;->c:Lvw;

    invoke-interface {v0}, Lvw;->o()V

    :cond_1
    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method
