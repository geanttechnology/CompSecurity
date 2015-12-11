.class public final Lcom/google/android/gms/internal/gd;
.super Lcom/google/android/gms/internal/fy;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/google/android/gms/internal/fw",
        "<TT;>.com/google/android/gms/internal/fy<",
        "Ljava/lang/Boolean;",
        ">;"
    }
.end annotation


# instance fields
.field public final b:I

.field public final c:Landroid/os/Bundle;

.field public final d:Landroid/os/IBinder;

.field final synthetic e:Lcom/google/android/gms/internal/fw;


# direct methods
.method public constructor <init>(Lcom/google/android/gms/internal/fw;ILandroid/os/IBinder;Landroid/os/Bundle;)V
    .locals 1

    iput-object p1, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-direct {p0, p1, v0}, Lcom/google/android/gms/internal/fy;-><init>(Lcom/google/android/gms/internal/fw;Ljava/lang/Object;)V

    iput p2, p0, Lcom/google/android/gms/internal/gd;->b:I

    iput-object p3, p0, Lcom/google/android/gms/internal/gd;->d:Landroid/os/IBinder;

    iput-object p4, p0, Lcom/google/android/gms/internal/gd;->c:Landroid/os/Bundle;

    return-void
.end method


# virtual methods
.method protected final synthetic a(Ljava/lang/Object;)V
    .locals 9

    const/4 v1, 0x0

    const/4 v2, 0x1

    const/4 v0, 0x0

    check-cast p1, Ljava/lang/Boolean;

    if-eqz p1, :cond_1

    iget v3, p0, Lcom/google/android/gms/internal/gd;->b:I

    sparse-switch v3, :sswitch_data_0

    iget-object v0, p0, Lcom/google/android/gms/internal/gd;->c:Landroid/os/Bundle;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lcom/google/android/gms/internal/gd;->c:Landroid/os/Bundle;

    const-string v2, "pendingIntent"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/app/PendingIntent;

    :goto_0
    iget-object v2, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v2}, Lcom/google/android/gms/internal/fw;->e(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/gb;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v2}, Lcom/google/android/gms/internal/fw;->f(Lcom/google/android/gms/internal/fw;)Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Lcom/google/android/gms/internal/gi;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/gi;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-virtual {v3}, Lcom/google/android/gms/internal/fw;->a()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v4}, Lcom/google/android/gms/internal/fw;->e(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/gb;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Lcom/google/android/gms/internal/gi;->b(Ljava/lang/String;Lcom/google/android/gms/internal/gb;)V

    iget-object v2, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v2}, Lcom/google/android/gms/internal/fw;->g(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/gb;

    :cond_0
    iget-object v2, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v2, v1}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;Landroid/os/IInterface;)Landroid/os/IInterface;

    iget-object v1, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v1}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/ge;

    move-result-object v1

    new-instance v2, Lcom/google/android/gms/common/a;

    iget v3, p0, Lcom/google/android/gms/internal/gd;->b:I

    invoke-direct {v2, v3, v0}, Lcom/google/android/gms/common/a;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {v1, v2}, Lcom/google/android/gms/internal/ge;->a(Lcom/google/android/gms/common/a;)V

    :cond_1
    :goto_1
    return-void

    :sswitch_0
    :try_start_0
    iget-object v3, p0, Lcom/google/android/gms/internal/gd;->d:Landroid/os/IBinder;

    invoke-interface {v3}, Landroid/os/IBinder;->getInterfaceDescriptor()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-virtual {v4}, Lcom/google/android/gms/internal/fw;->b()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_6

    iget-object v3, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    iget-object v4, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    iget-object v5, p0, Lcom/google/android/gms/internal/gd;->d:Landroid/os/IBinder;

    invoke-virtual {v4, v5}, Lcom/google/android/gms/internal/fw;->a(Landroid/os/IBinder;)Landroid/os/IInterface;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;Landroid/os/IInterface;)Landroid/os/IInterface;

    iget-object v3, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v3}, Lcom/google/android/gms/internal/fw;->d(Lcom/google/android/gms/internal/fw;)Landroid/os/IInterface;

    move-result-object v3

    if-eqz v3, :cond_6

    iget-object v3, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v3}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/ge;

    move-result-object v4

    iget-object v5, v4, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    monitor-enter v5
    :try_end_0
    .catch Landroid/os/RemoteException; {:try_start_0 .. :try_end_0} :catch_0

    :try_start_1
    iget-object v6, v4, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    monitor-enter v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget-boolean v3, v4, Lcom/google/android/gms/internal/ge;->d:Z

    if-nez v3, :cond_3

    move v3, v2

    :goto_2
    invoke-static {v3}, Lcom/google/android/gms/internal/ha;->a(Z)V

    iget-object v3, v4, Lcom/google/android/gms/internal/ge;->f:Landroid/os/Handler;

    const/4 v7, 0x1

    invoke-virtual {v3, v7}, Landroid/os/Handler;->removeMessages(I)V

    const/4 v3, 0x1

    iput-boolean v3, v4, Lcom/google/android/gms/internal/ge;->d:Z

    iget-object v3, v4, Lcom/google/android/gms/internal/ge;->c:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v3

    if-nez v3, :cond_4

    :goto_3
    invoke-static {v2}, Lcom/google/android/gms/internal/ha;->a(Z)V

    iget-object v3, v4, Lcom/google/android/gms/internal/ge;->b:Ljava/util/ArrayList;

    invoke-virtual {v3}, Ljava/util/ArrayList;->size()I

    move-result v7

    move v2, v0

    :goto_4
    if-ge v2, v7, :cond_5

    iget-object v0, v4, Lcom/google/android/gms/internal/ge;->a:Lcom/google/android/gms/internal/gg;

    invoke-interface {v0}, Lcom/google/android/gms/internal/gg;->j()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, v4, Lcom/google/android/gms/internal/ge;->a:Lcom/google/android/gms/internal/gg;

    invoke-interface {v0}, Lcom/google/android/gms/internal/gg;->e()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, v4, Lcom/google/android/gms/internal/ge;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    iget-object v0, v4, Lcom/google/android/gms/internal/ge;->c:Ljava/util/ArrayList;

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v8

    invoke-virtual {v0, v8}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_2

    invoke-virtual {v3, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/common/api/b;

    invoke-interface {v0}, Lcom/google/android/gms/common/api/b;->a()V

    :cond_2
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_4

    :cond_3
    move v3, v0

    goto :goto_2

    :cond_4
    move v2, v0

    goto :goto_3

    :cond_5
    iget-object v0, v4, Lcom/google/android/gms/internal/ge;->c:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    const/4 v0, 0x0

    iput-boolean v0, v4, Lcom/google/android/gms/internal/ge;->d:Z

    monitor-exit v6
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    :try_start_3
    monitor-exit v5

    goto/16 :goto_1

    :catchall_0
    move-exception v0

    monitor-exit v5
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    throw v0
    :try_end_4
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_4} :catch_0

    :catch_0
    move-exception v0

    :cond_6
    iget-object v0, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v0}, Lcom/google/android/gms/internal/fw;->f(Lcom/google/android/gms/internal/fw;)Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/google/android/gms/internal/gi;->a(Landroid/content/Context;)Lcom/google/android/gms/internal/gi;

    move-result-object v0

    iget-object v2, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-virtual {v2}, Lcom/google/android/gms/internal/fw;->a()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v3}, Lcom/google/android/gms/internal/fw;->e(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/gb;

    move-result-object v3

    invoke-virtual {v0, v2, v3}, Lcom/google/android/gms/internal/gi;->b(Ljava/lang/String;Lcom/google/android/gms/internal/gb;)V

    iget-object v0, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v0}, Lcom/google/android/gms/internal/fw;->g(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/gb;

    iget-object v0, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;Landroid/os/IInterface;)Landroid/os/IInterface;

    iget-object v0, p0, Lcom/google/android/gms/internal/gd;->e:Lcom/google/android/gms/internal/fw;

    invoke-static {v0}, Lcom/google/android/gms/internal/fw;->a(Lcom/google/android/gms/internal/fw;)Lcom/google/android/gms/internal/ge;

    move-result-object v0

    new-instance v2, Lcom/google/android/gms/common/a;

    const/16 v3, 0x8

    invoke-direct {v2, v3, v1}, Lcom/google/android/gms/common/a;-><init>(ILandroid/app/PendingIntent;)V

    invoke-virtual {v0, v2}, Lcom/google/android/gms/internal/ge;->a(Lcom/google/android/gms/common/a;)V

    goto/16 :goto_1

    :catchall_1
    move-exception v0

    :try_start_5
    monitor-exit v6
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :try_start_6
    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    :sswitch_1
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string v1, "A fatal developer error has occurred. Check the logs for further information."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    :cond_7
    move-object v0, v1

    goto/16 :goto_0

    nop

    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_0
        0xa -> :sswitch_1
    .end sparse-switch
.end method
