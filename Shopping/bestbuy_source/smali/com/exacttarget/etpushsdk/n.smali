.class Lcom/exacttarget/etpushsdk/n;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lqu;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

.field final synthetic b:Lcom/exacttarget/etpushsdk/ETLocationManager$c;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/exacttarget/etpushsdk/ETLocationManager$a;)V
    .locals 0

    .prologue
    .line 1444
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/n;->b:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    iput-object p2, p0, Lcom/exacttarget/etpushsdk/n;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public a(Lcom/google/android/gms/common/api/Status;)V
    .locals 7

    .prologue
    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 1447
    const-string v0, "~!RegionMonitor"

    const-string v1, "PendingResult<Status> Code: %1$d, Message: %2$s, isSuccess: %3$s"

    const/4 v2, 0x3

    new-array v2, v2, [Ljava/lang/Object;

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->f()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->c()Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->e()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v3

    aput-object v3, v2, v6

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1448
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager$1;->a:[I

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/n;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager$a;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1468
    const-string v0, "~!RegionMonitor"

    const-string v1, "We should not be here."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 1471
    :goto_0
    return-void

    .line 1450
    :pswitch_0
    const-string v0, "~!RegionMonitor"

    const-string v1, "buildGeofenceResultCallback() - %1$s - Success: %2$s"

    new-array v2, v6, [Ljava/lang/Object;

    const-string v3, "REMOVE_ALL"

    aput-object v3, v2, v4

    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->e()Z

    move-result v3

    invoke-static {v3}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v2, v5

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1451
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/n;->b:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    sget-object v1, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Ljava/lang/Boolean;)Ljava/lang/Boolean;

    .line 1454
    :try_start_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 1455
    const-string v1, "active"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1456
    const-string v1, "location_type = ?"

    .line 1457
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 1458
    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1463
    :catch_0
    move-exception v0

    .line 1464
    const-string v1, "~!RegionMonitor"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 1448
    nop

    :pswitch_data_0
    .packed-switch 0x3
        :pswitch_0
    .end packed-switch
.end method

.method public synthetic onResult(Lqt;)V
    .locals 0

    .prologue
    .line 1444
    check-cast p1, Lcom/google/android/gms/common/api/Status;

    invoke-virtual {p0, p1}, Lcom/exacttarget/etpushsdk/n;->a(Lcom/google/android/gms/common/api/Status;)V

    return-void
.end method
