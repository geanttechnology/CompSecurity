.class public abstract Lqh;
.super Ljava/lang/Object;

# interfaces
.implements Lqk;
.implements Lqq;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "<R::",
        "Lqt;",
        ">",
        "Ljava/lang/Object;",
        "Lqk",
        "<TR;>;",
        "Lqq",
        "<TR;>;"
    }
.end annotation


# instance fields
.field protected final a:Lqi;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqi",
            "<TR;>;"
        }
    .end annotation
.end field

.field private final b:Ljava/lang/Object;

.field private final c:Ljava/util/concurrent/CountDownLatch;

.field private final d:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lqr;",
            ">;"
        }
    .end annotation
.end field

.field private e:Lqu;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lqu",
            "<TR;>;"
        }
    .end annotation
.end field

.field private volatile f:Lqt;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "TR;"
        }
    .end annotation
.end field

.field private volatile g:Z

.field private h:Z

.field private i:Z

.field private j:Ladl;


# direct methods
.method protected constructor <init>(Landroid/os/Looper;)V
    .locals 2

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lqh;->b:Ljava/lang/Object;

    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    const/4 v1, 0x1

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    iput-object v0, p0, Lqh;->c:Ljava/util/concurrent/CountDownLatch;

    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lqh;->d:Ljava/util/ArrayList;

    new-instance v0, Lqi;

    invoke-direct {v0, p1}, Lqi;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lqh;->a:Lqi;

    return-void
.end method

.method static synthetic a(Lqh;)V
    .locals 0

    invoke-direct {p0}, Lqh;->j()V

    return-void
.end method

.method private b(Lqt;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TR;)V"
        }
    .end annotation

    iput-object p1, p0, Lqh;->f:Lqt;

    const/4 v0, 0x0

    iput-object v0, p0, Lqh;->j:Ladl;

    iget-object v0, p0, Lqh;->c:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    iget-object v0, p0, Lqh;->f:Lqt;

    invoke-interface {v0}, Lqt;->b()Lcom/google/android/gms/common/api/Status;

    move-result-object v1

    iget-object v0, p0, Lqh;->e:Lqu;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lqh;->a:Lqi;

    invoke-virtual {v0}, Lqi;->a()V

    iget-boolean v0, p0, Lqh;->h:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lqh;->a:Lqi;

    iget-object v2, p0, Lqh;->e:Lqu;

    invoke-direct {p0}, Lqh;->h()Lqt;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lqi;->a(Lqu;Lqt;)V

    :cond_0
    iget-object v0, p0, Lqh;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lqr;

    invoke-interface {v0, v1}, Lqr;->a(Lcom/google/android/gms/common/api/Status;)V

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lqh;->d:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    return-void
.end method

.method private h()Lqt;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    iget-object v1, p0, Lqh;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Lqh;->g:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v2, "Result has already been consumed."

    invoke-static {v0, v2}, Lady;->a(ZLjava/lang/Object;)V

    invoke-virtual {p0}, Lqh;->a()Z

    move-result v0

    const-string v2, "Result is not ready."

    invoke-static {v0, v2}, Lady;->a(ZLjava/lang/Object;)V

    iget-object v0, p0, Lqh;->f:Lqt;

    invoke-virtual {p0}, Lqh;->e()V

    monitor-exit v1

    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method private i()V
    .locals 2

    iget-object v1, p0, Lqh;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-virtual {p0}, Lqh;->a()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/android/gms/common/api/Status;->b:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {p0, v0}, Lqh;->a(Lcom/google/android/gms/common/api/Status;)Lqt;

    move-result-object v0

    invoke-virtual {p0, v0}, Lqh;->a(Lqt;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lqh;->i:Z

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

.method private j()V
    .locals 2

    iget-object v1, p0, Lqh;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-virtual {p0}, Lqh;->a()Z

    move-result v0

    if-nez v0, :cond_0

    sget-object v0, Lcom/google/android/gms/common/api/Status;->d:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {p0, v0}, Lqh;->a(Lcom/google/android/gms/common/api/Status;)Lqt;

    move-result-object v0

    invoke-virtual {p0, v0}, Lqh;->a(Lqt;)V

    const/4 v0, 0x1

    iput-boolean v0, p0, Lqh;->i:Z

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


# virtual methods
.method protected abstract a(Lcom/google/android/gms/common/api/Status;)Lqt;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/google/android/gms/common/api/Status;",
            ")TR;"
        }
    .end annotation
.end method

.method public bridge synthetic a(Ljava/lang/Object;)V
    .locals 0

    check-cast p1, Lqt;

    invoke-virtual {p0, p1}, Lqh;->a(Lqt;)V

    return-void
.end method

.method public final a(Lqt;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TR;)V"
        }
    .end annotation

    const/4 v0, 0x1

    const/4 v1, 0x0

    iget-object v3, p0, Lqh;->b:Ljava/lang/Object;

    monitor-enter v3

    :try_start_0
    iget-boolean v2, p0, Lqh;->i:Z

    if-nez v2, :cond_0

    iget-boolean v2, p0, Lqh;->h:Z

    if-eqz v2, :cond_1

    :cond_0
    invoke-static {p1}, Lqg;->a(Lqt;)V

    monitor-exit v3

    :goto_0
    return-void

    :cond_1
    invoke-virtual {p0}, Lqh;->a()Z

    move-result v2

    if-nez v2, :cond_2

    move v2, v0

    :goto_1
    const-string v4, "Results have already been set"

    invoke-static {v2, v4}, Lady;->a(ZLjava/lang/Object;)V

    iget-boolean v2, p0, Lqh;->g:Z

    if-nez v2, :cond_3

    :goto_2
    const-string v1, "Result has already been consumed"

    invoke-static {v0, v1}, Lady;->a(ZLjava/lang/Object;)V

    invoke-direct {p0, p1}, Lqh;->b(Lqt;)V

    monitor-exit v3

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_2
    move v2, v1

    goto :goto_1

    :cond_3
    move v0, v1

    goto :goto_2
.end method

.method public final a(Lqu;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lqu",
            "<TR;>;)V"
        }
    .end annotation

    iget-boolean v0, p0, Lqh;->g:Z

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v1, "Result has already been consumed."

    invoke-static {v0, v1}, Lady;->a(ZLjava/lang/Object;)V

    iget-object v1, p0, Lqh;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    invoke-virtual {p0}, Lqh;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    monitor-exit v1

    :goto_1
    return-void

    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    :cond_1
    invoke-virtual {p0}, Lqh;->a()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lqh;->a:Lqi;

    invoke-direct {p0}, Lqh;->h()Lqt;

    move-result-object v2

    invoke-virtual {v0, p1, v2}, Lqi;->a(Lqu;Lqt;)V

    :goto_2
    monitor-exit v1

    goto :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0

    :cond_2
    :try_start_1
    iput-object p1, p0, Lqh;->e:Lqu;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2
.end method

.method public final a()Z
    .locals 4

    iget-object v0, p0, Lqh;->c:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public final b()Lqt;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()TR;"
        }
    .end annotation

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v3

    if-eq v0, v3, :cond_0

    move v0, v1

    :goto_0
    const-string v3, "await must not be called on the UI thread"

    invoke-static {v0, v3}, Lady;->a(ZLjava/lang/Object;)V

    iget-boolean v0, p0, Lqh;->g:Z

    if-nez v0, :cond_1

    :goto_1
    const-string v0, "Result has already been consumed"

    invoke-static {v1, v0}, Lady;->a(ZLjava/lang/Object;)V

    :try_start_0
    iget-object v0, p0, Lqh;->c:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->await()V
    :try_end_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_0

    :goto_2
    invoke-virtual {p0}, Lqh;->a()Z

    move-result v0

    const-string v1, "Result is not ready."

    invoke-static {v0, v1}, Lady;->a(ZLjava/lang/Object;)V

    invoke-direct {p0}, Lqh;->h()Lqt;

    move-result-object v0

    return-object v0

    :cond_0
    move v0, v2

    goto :goto_0

    :cond_1
    move v1, v2

    goto :goto_1

    :catch_0
    move-exception v0

    invoke-direct {p0}, Lqh;->i()V

    goto :goto_2
.end method

.method public c()V
    .locals 2

    iget-object v1, p0, Lqh;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Lqh;->h:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lqh;->g:Z

    if-eqz v0, :cond_1

    :cond_0
    monitor-exit v1

    :goto_0
    return-void

    :cond_1
    iget-object v0, p0, Lqh;->j:Ladl;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    if-eqz v0, :cond_2

    :try_start_1
    iget-object v0, p0, Lqh;->j:Ladl;

    invoke-interface {v0}, Ladl;->a()V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_2
    :goto_1
    :try_start_2
    iget-object v0, p0, Lqh;->f:Lqt;

    invoke-static {v0}, Lqg;->a(Lqt;)V

    const/4 v0, 0x0

    iput-object v0, p0, Lqh;->e:Lqu;

    const/4 v0, 0x1

    iput-boolean v0, p0, Lqh;->h:Z

    sget-object v0, Lcom/google/android/gms/common/api/Status;->e:Lcom/google/android/gms/common/api/Status;

    invoke-virtual {p0, v0}, Lqh;->a(Lcom/google/android/gms/common/api/Status;)Lqt;

    move-result-object v0

    invoke-direct {p0, v0}, Lqh;->b(Lqt;)V

    monitor-exit v1

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0

    :catch_0
    move-exception v0

    goto :goto_1
.end method

.method public d()Z
    .locals 2

    iget-object v1, p0, Lqh;->b:Ljava/lang/Object;

    monitor-enter v1

    :try_start_0
    iget-boolean v0, p0, Lqh;->h:Z

    monitor-exit v1

    return v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method protected e()V
    .locals 2

    const/4 v1, 0x0

    const/4 v0, 0x1

    iput-boolean v0, p0, Lqh;->g:Z

    iput-object v1, p0, Lqh;->f:Lqt;

    iput-object v1, p0, Lqh;->e:Lqu;

    return-void
.end method
