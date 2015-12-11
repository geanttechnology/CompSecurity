.class public Lafd;
.super Laeo;


# instance fields
.field private final e:Lafa;

.field private final f:Lael;

.field private final g:Lacn;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/os/Looper;Ljava/lang/String;Lqo;Lqp;Ljava/lang/String;Ljava/lang/String;)V
    .locals 9

    const/4 v8, 0x0

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p3

    move-object v4, p4

    move-object v5, p5

    move-object v6, p6

    move-object/from16 v7, p7

    invoke-direct/range {v0 .. v8}, Lafd;-><init>(Landroid/content/Context;Landroid/os/Looper;Ljava/lang/String;Lqo;Lqp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/os/Looper;Ljava/lang/String;Lqo;Lqp;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v3, p4

    move-object v4, p5

    move-object v5, p6

    invoke-direct/range {v0 .. v5}, Laeo;-><init>(Landroid/content/Context;Landroid/os/Looper;Lqo;Lqp;Ljava/lang/String;)V

    new-instance v0, Lafa;

    iget-object v1, p0, Lafd;->a:Lafj;

    invoke-direct {v0, p1, v1}, Lafa;-><init>(Landroid/content/Context;Lafj;)V

    iput-object v0, p0, Lafd;->e:Lafa;

    iget-object v0, p0, Lafd;->a:Lafj;

    invoke-static {p1, p7, p8, v0}, Lael;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lafj;)Lael;

    move-result-object v0

    iput-object v0, p0, Lafd;->f:Lael;

    iget-object v0, p0, Lafd;->a:Lafj;

    invoke-static {p1, v0}, Lacn;->a(Landroid/content/Context;Lafj;)Lacn;

    move-result-object v0

    iput-object v0, p0, Lafd;->g:Lacn;

    return-void
.end method


# virtual methods
.method public a(Lahx;)V
    .locals 1

    iget-object v0, p0, Lafd;->e:Lafa;

    invoke-virtual {v0, p1}, Lafa;->a(Lahx;)V

    return-void
.end method

.method public a(Landroid/app/PendingIntent;Laih;)V
    .locals 3

    invoke-virtual {p0}, Lafd;->i()V

    const-string v0, "PendingIntent must be specified."

    invoke-static {p1, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "OnRemoveGeofencesResultListener not provided."

    invoke-static {p2, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-nez p2, :cond_0

    const/4 v0, 0x0

    move-object v1, v0

    :goto_0
    invoke-virtual {p0}, Lafd;->j()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Laex;

    invoke-virtual {p0}, Lafd;->h()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, p1, v1, v2}, Laex;->a(Landroid/app/PendingIntent;Laeu;Ljava/lang/String;)V

    return-void

    :cond_0
    new-instance v0, Laff;

    invoke-direct {v0, p2, p0}, Laff;-><init>(Laih;Lafd;)V

    move-object v1, v0

    goto :goto_0
.end method

.method public a(Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;Laig;)V
    .locals 2

    invoke-virtual {p0}, Lafd;->i()V

    const-string v0, "geofencingRequest can\'t be null."

    invoke-static {p1, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "PendingIntent must be specified."

    invoke-static {p2, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    const-string v0, "OnAddGeofencesResultListener not provided."

    invoke-static {p3, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    if-nez p3, :cond_0

    const/4 v0, 0x0

    move-object v1, v0

    :goto_0
    invoke-virtual {p0}, Lafd;->j()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Laex;

    invoke-interface {v0, p1, p2, v1}, Laex;->a(Lcom/google/android/gms/location/GeofencingRequest;Landroid/app/PendingIntent;Laeu;)V

    return-void

    :cond_0
    new-instance v0, Laff;

    invoke-direct {v0, p3, p0}, Laff;-><init>(Laig;Lafd;)V

    move-object v1, v0

    goto :goto_0
.end method

.method public a(Lcom/google/android/gms/location/LocationRequest;Lahx;Landroid/os/Looper;)V
    .locals 2

    iget-object v1, p0, Lafd;->e:Lafa;

    monitor-enter v1

    :try_start_0
    iget-object v0, p0, Lafd;->e:Lafa;

    invoke-virtual {v0, p1, p2, p3}, Lafa;->a(Lcom/google/android/gms/location/LocationRequest;Lahx;Landroid/os/Looper;)V

    monitor-exit v1

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public a(Ljava/util/List;Laih;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Laih;",
            ")V"
        }
    .end annotation

    const/4 v1, 0x0

    invoke-virtual {p0}, Lafd;->i()V

    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    const-string v2, "geofenceRequestIds can\'t be null nor empty."

    invoke-static {v0, v2}, Lady;->b(ZLjava/lang/Object;)V

    const-string v0, "OnRemoveGeofencesResultListener not provided."

    invoke-static {p2, v0}, Lady;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    new-array v0, v1, [Ljava/lang/String;

    invoke-interface {p1, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Ljava/lang/String;

    if-nez p2, :cond_1

    const/4 v1, 0x0

    move-object v2, v1

    :goto_1
    invoke-virtual {p0}, Lafd;->j()Landroid/os/IInterface;

    move-result-object v1

    check-cast v1, Laex;

    invoke-virtual {p0}, Lafd;->h()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v0, v2, v3}, Laex;->a([Ljava/lang/String;Laeu;Ljava/lang/String;)V

    return-void

    :cond_0
    move v0, v1

    goto :goto_0

    :cond_1
    new-instance v1, Laff;

    invoke-direct {v1, p2, p0}, Laff;-><init>(Laih;Lafd;)V

    move-object v2, v1

    goto :goto_1
.end method

.method public b()V
    .locals 4

    iget-object v1, p0, Lafd;->e:Lafa;

    monitor-enter v1

    :try_start_0
    invoke-virtual {p0}, Lafd;->c()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-eqz v0, :cond_0

    :try_start_1
    iget-object v0, p0, Lafd;->e:Lafa;

    invoke-virtual {v0}, Lafa;->a()V

    iget-object v0, p0, Lafd;->e:Lafa;

    invoke-virtual {v0}, Lafa;->b()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :cond_0
    :goto_0
    :try_start_2
    invoke-super {p0}, Laeo;->b()V

    monitor-exit v1

    return-void

    :catch_0
    move-exception v0

    const-string v2, "LocationClientImpl"

    const-string v3, "Client disconnected before listeners could be cleaned up"

    invoke-static {v2, v3, v0}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    throw v0
.end method
