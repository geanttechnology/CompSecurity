.class public Lafa;
.super Ljava/lang/Object;


# instance fields
.field private final a:Lafj;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lafj",
            "<",
            "Laex;",
            ">;"
        }
    .end annotation
.end field

.field private final b:Landroid/content/Context;

.field private c:Landroid/content/ContentProviderClient;

.field private d:Z

.field private e:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Lahx;",
            "Lafc;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;Lafj;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lafj",
            "<",
            "Laex;",
            ">;)V"
        }
    .end annotation

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    const/4 v0, 0x0

    iput-object v0, p0, Lafa;->c:Landroid/content/ContentProviderClient;

    const/4 v0, 0x0

    iput-boolean v0, p0, Lafa;->d:Z

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lafa;->e:Ljava/util/HashMap;

    iput-object p1, p0, Lafa;->b:Landroid/content/Context;

    iput-object p2, p0, Lafa;->a:Lafj;

    return-void
.end method

.method private a(Lahx;Landroid/os/Looper;)Lafc;
    .locals 3

    if-nez p2, :cond_0

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    const-string v1, "Can\'t create handler inside thread that has not called Looper.prepare()"

    invoke-static {v0, v1}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    :cond_0
    iget-object v1, p0, Lafa;->e:Ljava/util/HashMap;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lafa;->e:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lafc;

    if-nez v0, :cond_1

    new-instance v0, Lafc;

    invoke-direct {v0, p1, p2}, Lafc;-><init>(Lahx;Landroid/os/Looper;)V

    :cond_1
    iget-object v2, p0, Lafa;->e:Ljava/util/HashMap;

    invoke-virtual {v2, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    monitor-exit v1

    return-object v0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method


# virtual methods
.method public a()V
    .locals 4

    :try_start_0
    iget-object v2, p0, Lafa;->e:Ljava/util/HashMap;

    monitor-enter v2
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v0, p0, Lafa;->e:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :cond_0
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lafc;

    if-eqz v0, :cond_0

    iget-object v1, p0, Lafa;->a:Lafj;

    invoke-interface {v1}, Lafj;->c()Landroid/os/IInterface;

    move-result-object v1

    check-cast v1, Laex;

    invoke-interface {v1, v0}, Laex;->a(Laic;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    throw v0
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :cond_1
    :try_start_3
    iget-object v0, p0, Lafa;->e:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    monitor-exit v2
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    return-void
.end method

.method public a(Lahx;)V
    .locals 3

    iget-object v0, p0, Lafa;->a:Lafj;

    invoke-interface {v0}, Lafj;->a()V

    const-string v0, "Invalid null listener"

    invoke-static {p1, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v2, p0, Lafa;->e:Ljava/util/HashMap;

    monitor-enter v2

    :try_start_0
    iget-object v0, p0, Lafa;->e:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lafc;

    iget-object v1, p0, Lafa;->c:Landroid/content/ContentProviderClient;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lafa;->e:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lafa;->c:Landroid/content/ContentProviderClient;

    invoke-virtual {v1}, Landroid/content/ContentProviderClient;->release()Z

    const/4 v1, 0x0

    iput-object v1, p0, Lafa;->c:Landroid/content/ContentProviderClient;

    :cond_0
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lafc;->a()V

    iget-object v1, p0, Lafa;->a:Lafj;

    invoke-interface {v1}, Lafj;->c()Landroid/os/IInterface;

    move-result-object v1

    check-cast v1, Laex;

    invoke-interface {v1, v0}, Laex;->a(Laic;)V

    :cond_1
    monitor-exit v2

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v2
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Lcom/google/android/gms/location/LocationRequest;Lahx;Landroid/os/Looper;)V
    .locals 2

    iget-object v0, p0, Lafa;->a:Lafj;

    invoke-interface {v0}, Lafj;->a()V

    invoke-direct {p0, p2, p3}, Lafa;->a(Lahx;Landroid/os/Looper;)Lafc;

    move-result-object v1

    iget-object v0, p0, Lafa;->a:Lafj;

    invoke-interface {v0}, Lafj;->c()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Laex;

    invoke-interface {v0, p1, v1}, Laex;->a(Lcom/google/android/gms/location/LocationRequest;Laic;)V

    return-void
.end method

.method public a(Z)V
    .locals 1

    iget-object v0, p0, Lafa;->a:Lafj;

    invoke-interface {v0}, Lafj;->a()V

    iget-object v0, p0, Lafa;->a:Lafj;

    invoke-interface {v0}, Lafj;->c()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Laex;

    invoke-interface {v0, p1}, Laex;->a(Z)V

    iput-boolean p1, p0, Lafa;->d:Z

    return-void
.end method

.method public b()V
    .locals 2

    iget-boolean v0, p0, Lafa;->d:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0, v0}, Lafa;->a(Z)V
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :cond_0
    return-void

    :catch_0
    move-exception v0

    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1
.end method
