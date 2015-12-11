.class final Lcom/wishabi/flipp/b/ac;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/google/android/gms/common/c;


# instance fields
.field final synthetic a:J

.field final synthetic b:I

.field final synthetic c:Lcom/wishabi/flipp/b/ab;


# direct methods
.method constructor <init>(Lcom/wishabi/flipp/b/ab;J)V
    .locals 2

    .prologue
    .line 78
    iput-object p1, p0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    iput-wide p2, p0, Lcom/wishabi/flipp/b/ac;->a:J

    const/16 v0, 0x64

    iput v0, p0, Lcom/wishabi/flipp/b/ac;->b:I

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public final a_()V
    .locals 14

    .prologue
    const-wide v12, 0x7fffffffffffffffL

    const/4 v11, 0x1

    const/4 v10, 0x0

    const-wide/16 v8, 0x2710

    const-wide/16 v6, 0x0

    .line 85
    iget-object v0, p0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    invoke-virtual {v0}, Lcom/google/android/gms/location/e;->a()Landroid/location/Location;

    move-result-object v0

    .line 86
    if-eqz v0, :cond_0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v4

    sub-long/2addr v2, v4

    iget-wide v4, p0, Lcom/wishabi/flipp/b/ac;->a:J

    cmp-long v1, v2, v4

    if-gez v1, :cond_0

    .line 88
    new-instance v1, Ljava/util/Date;

    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v2

    invoke-direct {v1, v2, v3}, Ljava/util/Date;-><init>(J)V

    .line 89
    new-instance v2, Ljava/text/SimpleDateFormat;

    const-string v3, "EEE MMM dd HH:mm:ss zzz yyyy a"

    invoke-direct {v2, v3}, Ljava/text/SimpleDateFormat;-><init>(Ljava/lang/String;)V

    .line 91
    const-string v3, "Canada/Eastern"

    invoke-static {v3}, Ljava/util/TimeZone;->getTimeZone(Ljava/lang/String;)Ljava/util/TimeZone;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/text/SimpleDateFormat;->setTimeZone(Ljava/util/TimeZone;)V

    .line 92
    const-string v3, "Found cached location: %f %f %s"

    const/4 v4, 0x3

    new-array v4, v4, [Ljava/lang/Object;

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    aput-object v5, v4, v10

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v6

    invoke-static {v6, v7}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v5

    aput-object v5, v4, v11

    const/4 v5, 0x2

    invoke-virtual {v2, v1}, Ljava/text/SimpleDateFormat;->format(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v1

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    .line 95
    iget-object v1, p0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    invoke-virtual {v1, v0, v10}, Lcom/wishabi/flipp/b/ab;->a(Landroid/location/Location;I)V

    .line 96
    iget-object v0, p0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    invoke-virtual {v0}, Lcom/google/android/gms/internal/iu;->g()V

    .line 97
    iget-object v0, p0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    const/4 v1, 0x0

    iput-object v1, v0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    .line 122
    :goto_0
    return-void

    .line 101
    :cond_0
    new-instance v2, Lcom/google/android/gms/location/LocationRequest;

    invoke-direct {v2}, Lcom/google/android/gms/location/LocationRequest;-><init>()V

    .line 102
    iget v0, p0, Lcom/wishabi/flipp/b/ac;->b:I

    packed-switch v0, :pswitch_data_0

    :pswitch_0
    new-instance v1, Ljava/lang/IllegalArgumentException;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "invalid quality: "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {v1, v0}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v1

    :pswitch_1
    iput v0, v2, Lcom/google/android/gms/location/LocationRequest;->b:I

    .line 103
    iput v11, v2, Lcom/google/android/gms/location/LocationRequest;->g:I

    .line 104
    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v0

    sub-long v4, v12, v0

    cmp-long v3, v8, v4

    if-lez v3, :cond_2

    iput-wide v12, v2, Lcom/google/android/gms/location/LocationRequest;->f:J

    :goto_1
    iget-wide v0, v2, Lcom/google/android/gms/location/LocationRequest;->f:J

    cmp-long v0, v0, v6

    if-gez v0, :cond_1

    iput-wide v6, v2, Lcom/google/android/gms/location/LocationRequest;->f:J

    .line 105
    :cond_1
    cmp-long v0, v6, v6

    if-gez v0, :cond_3

    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string v1, "invalid interval: 0"

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 104
    :cond_2
    add-long/2addr v0, v8

    iput-wide v0, v2, Lcom/google/android/gms/location/LocationRequest;->f:J

    goto :goto_1

    .line 105
    :cond_3
    iput-wide v6, v2, Lcom/google/android/gms/location/LocationRequest;->c:J

    iget-boolean v0, v2, Lcom/google/android/gms/location/LocationRequest;->e:Z

    if-nez v0, :cond_4

    iget-wide v0, v2, Lcom/google/android/gms/location/LocationRequest;->c:J

    long-to-double v0, v0

    const-wide/high16 v4, 0x4018000000000000L    # 6.0

    div-double/2addr v0, v4

    double-to-long v0, v0

    iput-wide v0, v2, Lcom/google/android/gms/location/LocationRequest;->d:J

    .line 107
    :cond_4
    iget-object v0, p0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ab;->b:Lcom/google/android/gms/location/e;

    new-instance v3, Lcom/wishabi/flipp/b/ad;

    invoke-direct {v3, p0}, Lcom/wishabi/flipp/b/ad;-><init>(Lcom/wishabi/flipp/b/ac;)V

    iget-object v0, v0, Lcom/google/android/gms/location/e;->a:Lcom/google/android/gms/internal/iu;

    iget-object v4, v0, Lcom/google/android/gms/internal/iu;->f:Lcom/google/android/gms/internal/ir;

    monitor-enter v4

    :try_start_0
    iget-object v5, v0, Lcom/google/android/gms/internal/iu;->f:Lcom/google/android/gms/internal/ir;

    iget-object v0, v5, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ix;->a()V

    invoke-static {}, Landroid/os/Looper;->myLooper()Landroid/os/Looper;

    move-result-object v0

    const-string v1, "Can\'t create handler inside thread that has not called Looper.prepare()"

    invoke-static {v0, v1}, Lcom/google/android/gms/internal/ha;->a(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    iget-object v6, v5, Lcom/google/android/gms/internal/ir;->d:Ljava/util/HashMap;

    monitor-enter v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    :try_start_1
    iget-object v0, v5, Lcom/google/android/gms/internal/ir;->d:Ljava/util/HashMap;

    invoke-virtual {v0, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/it;

    if-nez v0, :cond_5

    new-instance v0, Lcom/google/android/gms/internal/it;

    invoke-direct {v0, v3}, Lcom/google/android/gms/internal/it;-><init>(Lcom/google/android/gms/location/g;)V

    move-object v1, v0

    :goto_2
    iget-object v0, v5, Lcom/google/android/gms/internal/ir;->d:Ljava/util/HashMap;

    invoke-virtual {v0, v3, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    :try_start_2
    iget-object v0, v5, Lcom/google/android/gms/internal/ir;->a:Lcom/google/android/gms/internal/ix;

    invoke-interface {v0}, Lcom/google/android/gms/internal/ix;->b()Landroid/os/IInterface;

    move-result-object v0

    check-cast v0, Lcom/google/android/gms/internal/io;

    iget-object v3, v5, Lcom/google/android/gms/internal/ir;->b:Landroid/content/Context;

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v0, v2, v1, v3}, Lcom/google/android/gms/internal/io;->a(Lcom/google/android/gms/location/LocationRequest;Lcom/google/android/gms/location/j;Ljava/lang/String;)V
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    :try_start_3
    monitor-exit v6
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    :try_start_4
    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 115
    iget-object v0, p0, Lcom/wishabi/flipp/b/ac;->c:Lcom/wishabi/flipp/b/ab;

    iget-object v0, v0, Lcom/wishabi/flipp/b/ab;->c:Landroid/os/Handler;

    new-instance v1, Lcom/wishabi/flipp/b/ae;

    invoke-direct {v1, p0}, Lcom/wishabi/flipp/b/ae;-><init>(Lcom/wishabi/flipp/b/ac;)V

    invoke-virtual {v0, v1, v8, v9}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto/16 :goto_0

    .line 107
    :catch_0
    move-exception v0

    :try_start_5
    new-instance v1, Ljava/lang/IllegalStateException;

    invoke-direct {v1, v0}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/Throwable;)V

    throw v1

    :catchall_0
    move-exception v0

    monitor-exit v6
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    throw v0

    :catchall_1
    move-exception v0

    monitor-exit v4
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    throw v0

    :cond_5
    move-object v1, v0

    goto :goto_2

    .line 102
    :pswitch_data_0
    .packed-switch 0x64
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_0
        :pswitch_1
        :pswitch_1
    .end packed-switch
.end method

.method public final b()V
    .locals 0

    .prologue
    .line 125
    return-void
.end method
