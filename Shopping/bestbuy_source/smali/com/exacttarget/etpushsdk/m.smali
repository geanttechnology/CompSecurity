.class Lcom/exacttarget/etpushsdk/m;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lqu;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

.field final synthetic b:Ljava/util/List;

.field final synthetic c:Lcom/exacttarget/etpushsdk/ETLocationManager$c;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/exacttarget/etpushsdk/ETLocationManager$a;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 1362
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/m;->c:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    iput-object p2, p0, Lcom/exacttarget/etpushsdk/m;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    iput-object p3, p0, Lcom/exacttarget/etpushsdk/m;->b:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/common/api/Status;)V
    .locals 8

    .prologue
    const/4 v4, 0x3

    const/4 v7, 0x2

    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 1365
    const-string v0, "~!RegionMonitor"

    const-string v1, "PendingResult<Status> Code: %1$d, Message: %2$s, isSuccess: %3$s"

    new-array v2, v4, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->f()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v5

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/m;->c:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    invoke-static {v3, p1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/google/android/gms/common/api/Status;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->e()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v2, v7

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1366
    const-string v1, "~!RegionMonitor"

    const-string v2, "buildGeofenceResultCallback() - %1$s - Num Fences: %2$d - Success: %3$s"

    new-array v3, v4, [Ljava/lang/Object;

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/m;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    sget-object v4, Lcom/exacttarget/etpushsdk/ETLocationManager$a;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    if-ne v0, v4, :cond_1

    const-string v0, "ADD"

    :goto_0
    aput-object v0, v3, v5

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/m;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    aput-object v0, v3, v6

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->e()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v0

    aput-object v0, v3, v7

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1367
    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1368
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager$1;->a:[I

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/m;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager$a;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1383
    const-string v0, "~!RegionMonitor"

    const-string v1, "We should not be here."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1411
    :cond_0
    :goto_1
    return-void

    .line 1366
    :cond_1
    const-string v0, "REMOVE"

    goto :goto_0

    .line 1370
    :pswitch_0
    const-string v0, "~!RegionMonitor"

    const-string v1, "SUCCESS: Region(s) Added"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1371
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/m;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_2
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 1372
    const-string v2, "~!RegionMonitor"

    const-string v3, "Now Monitoring Region: %1$s"

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_2

    .line 1376
    :pswitch_1
    const-string v0, "~!RegionMonitor"

    const-string v1, "SUCCESS: Region(s) Removed"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1377
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/m;->b:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :goto_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    .line 1378
    const-string v2, "~!RegionMonitor"

    const-string v3, "No Longer Monitoring Region: %1$s"

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_3

    .line 1386
    :cond_2
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager$1;->a:[I

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/m;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager$a;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_1

    .line 1408
    const-string v0, "~!RegionMonitor"

    const-string v1, "We should not be here."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 1389
    :pswitch_2
    const-string v0, "~!RegionMonitor"

    const-string v1, "%1$s: Unable to monitor geofences, set them to inactive in db."

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/m;->c:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    invoke-static {v3, p1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/google/android/gms/common/api/Status;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1391
    :try_start_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1392
    const-string v1, "active"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1393
    const-string v1, "location_type = ?"

    .line 1394
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 1395
    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_1

    .line 1400
    :catch_0
    move-exception v0

    .line 1401
    const-string v1, "~!RegionMonitor"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_1

    .line 1405
    :pswitch_3
    const-string v0, "~!RegionMonitor"

    const-string v1, "%1$s: Unable to remove monitored geofences."

    new-array v2, v6, [Ljava/lang/Object;

    iget-object v3, p0, Lcom/exacttarget/etpushsdk/m;->c:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    invoke-static {v3, p1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/google/android/gms/common/api/Status;)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    .line 1368
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
    .end packed-switch

    .line 1386
    :pswitch_data_1
    .packed-switch 0x1
        :pswitch_2
        :pswitch_3
    .end packed-switch
.end method

.method public synthetic onResult(Lqt;)V
    .locals 0

    .prologue
    .line 1362
    check-cast p1, Lcom/google/android/gms/common/api/Status;

    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/m;->a(Lcom/google/android/gms/common/api/Status;)V

    return-void
.end method
