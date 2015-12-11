.class public final Lcom/google/android/gms/internal/iu;
.super Lcom/google/android/gms/internal/fw;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/fw",
        "<",
        "Lcom/google/android/gms/internal/io;",
        ">;"
    }
.end annotation


# instance fields
.field public final f:Lcom/google/android/gms/internal/ir;

.field private final g:Lcom/google/android/gms/internal/ix;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/google/android/gms/internal/ix",
            "<",
            "Lcom/google/android/gms/internal/io;",
            ">;"
        }
    .end annotation
.end field

.field private final h:Ljava/util/HashMap;

.field private final i:Ljava/lang/String;

.field private final j:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;Ljava/lang/String;)V
    .locals 2

    const/4 v1, 0x0

    new-array v0, v1, [Ljava/lang/String;

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/google/android/gms/internal/fw;-><init>(Landroid/content/Context;Lcom/google/android/gms/common/c;Lcom/google/android/gms/common/d;[Ljava/lang/String;)V

    new-instance v0, Lcom/google/android/gms/internal/iv;

    invoke-direct {v0, p0, v1}, Lcom/google/android/gms/internal/iv;-><init>(Lcom/google/android/gms/internal/iu;B)V

    iput-object v0, p0, Lcom/google/android/gms/internal/iu;->g:Lcom/google/android/gms/internal/ix;

    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/google/android/gms/internal/iu;->h:Ljava/util/HashMap;

    new-instance v0, Lcom/google/android/gms/internal/ir;

    iget-object v1, p0, Lcom/google/android/gms/internal/iu;->g:Lcom/google/android/gms/internal/ix;

    invoke-direct {v0, p1, v1}, Lcom/google/android/gms/internal/ir;-><init>(Landroid/content/Context;Lcom/google/android/gms/internal/ix;)V

    iput-object v0, p0, Lcom/google/android/gms/internal/iu;->f:Lcom/google/android/gms/internal/ir;

    iput-object p4, p0, Lcom/google/android/gms/internal/iu;->i:Ljava/lang/String;

    const/4 v0, 0x0

    iput-object v0, p0, Lcom/google/android/gms/internal/iu;->j:Ljava/lang/String;

    return-void
.end method

.method static synthetic a(Lcom/google/android/gms/internal/iu;)V
    .locals 0

    invoke-virtual {p0}, Lcom/google/android/gms/internal/iu;->h()V

    return-void
.end method

.method static synthetic b(Lcom/google/android/gms/internal/iu;)Landroid/os/IInterface;
    .locals 1

    invoke-virtual {p0}, Lcom/google/android/gms/internal/iu;->i()Landroid/os/IInterface;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method protected final synthetic a(Landroid/os/IBinder;)Landroid/os/IInterface;
    .locals 1

    invoke-static {p1}, Lcom/google/android/gms/internal/ip;->a(Landroid/os/IBinder;)Lcom/google/android/gms/internal/io;

    move-result-object v0

    return-object v0
.end method

.method protected final a()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.location.internal.GoogleLocationManagerService.START"

    return-object v0
.end method

.method protected final a(Lcom/google/android/gms/internal/gr;Lcom/google/android/gms/internal/ga;)V
    .locals 3

    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    const-string v1, "client_name"

    iget-object v2, p0, Lcom/google/android/gms/internal/iu;->i:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const v1, 0x40ba50

    iget-object v2, p0, Lcom/google/android/gms/internal/fw;->a:Landroid/content/Context;

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {p1, p2, v1, v2, v0}, Lcom/google/android/gms/internal/gr;->e(Lcom/google/android/gms/internal/gn;ILjava/lang/String;Landroid/os/Bundle;)V

    return-void
.end method

.method protected final b()Ljava/lang/String;
    .locals 1

    const-string v0, "com.google.android.gms.location.internal.IGoogleLocationManagerService"

    return-object v0
.end method

.method public final g()V
    .locals 6

    iget-object v2, p0, Lcom/google/android/gms/internal/iu;->f:Lcom/google/android/gms/internal/ir;

    monitor-enter v2

    :try_start_0
    invoke-virtual {p0}, Lcom/google/android/gms/internal/iu;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v3, p0, Lcom/google/android/gms/internal/iu;->f:Lcom/google/android/gms/internal/ir;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    iget-object v4, v3, Lcom/google/android/gms/internal/ir;->d:Ljava/util/HashMap;

    monitor-enter v4
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    :try_start_2
    iget-object v0, v3, Lcom/google/android/gms/internal/ir;->d:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->values()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/it;

    if-eqz v0, :cond_0

    iget-object v1, v3, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    invoke-interface {v1}, Lcom/google/android/gms/internal/ix;->b()Landroid/os/IInterface;

    move-result-object v1

    check-cast v1, Lcom/google/android/gms/internal/io;

    invoke-interface {v1, v0}, Lcom/google/android/gms/internal/io;->a(Lcom/google/android/gms/location/j;)V

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v4
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    throw v0
    :try_end_3
    .catch Landroid/os/RemoteException; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    :catch_0
    move-exception v0

    :try_start_4
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :catchall_1
    move-exception v0

    monitor-exit v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    throw v0

    :cond_1
    :try_start_5
    iget-object v0, v3, Lcom/google/android/gms/internal/ir;->d:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->clear()V

    monitor-exit v4
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    iget-object v1, p0, Lcom/google/android/gms/internal/iu;->f:Lcom/google/android/gms/internal/ir;

    iget-boolean v0, v1, Lcom/google/android/gms/internal/ir;->c:Z

    if-eqz v0, :cond_2

    iget-object v0, v1, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ix;->a()V
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    :try_start_7
    iget-object v0, v1, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ix;->b()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/io;

    const/4 v3, 0x0

    invoke-interface {v0, v3}, Lcom/google/android/gms/internal/io;->a(Z)V
    :try_end_7
    .catch Landroid/os/RemoteException; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    const/4 v0, 0x0

    :try_start_8
    iput-boolean v0, v1, Lcom/google/android/gms/internal/ir;->c:Z

    :cond_2
    invoke-super {p0}, Lcom/google/android/gms/internal/fw;->g()V

    monitor-exit v2

    return-void

    :catch_1
    move-exception v0

    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_1
.end method
