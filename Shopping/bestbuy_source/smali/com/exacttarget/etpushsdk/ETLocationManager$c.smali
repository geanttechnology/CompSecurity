.class Lcom/exacttarget/etpushsdk/ETLocationManager$c;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lqo;
.implements Lqp;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETLocationManager;

.field private b:Ljava/lang/Boolean;

.field private c:Ljava/util/List;

.field private d:Ljava/util/List;

.field private e:Landroid/app/PendingIntent;


# direct methods
.method private constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 1233
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1236
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->b:Ljava/lang/Boolean;

    .line 1237
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->c:Ljava/util/List;

    .line 1238
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->d:Ljava/util/List;

    return-void
.end method

.method synthetic constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Lcom/exacttarget/etpushsdk/c;)V
    .locals 0

    .prologue
    .line 1233
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;)V

    return-void
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Ljava/lang/Boolean;)Ljava/lang/Boolean;
    .locals 0

    .prologue
    .line 1233
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->b:Ljava/lang/Boolean;

    return-object p1
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/google/android/gms/common/api/Status;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1233
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/google/android/gms/common/api/Status;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method private a(Lcom/google/android/gms/common/api/Status;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 1416
    if-nez p1, :cond_0

    .line 1417
    const-string v0, "NULL"

    .line 1439
    :goto_0
    return-object v0

    .line 1420
    :cond_0
    invoke-virtual {p1}, Lcom/google/android/gms/common/api/Status;->f()I

    move-result v0

    sparse-switch v0, :sswitch_data_0

    .line 1437
    const-string v0, "UNKNOWN_ERROR"

    goto :goto_0

    .line 1422
    :sswitch_0
    const-string v0, "GEOFENCE_NOT_AVAILABLE"

    goto :goto_0

    .line 1425
    :sswitch_1
    const-string v0, "GEOFENCE_TOO_MANY_GEOFENCES"

    goto :goto_0

    .line 1428
    :sswitch_2
    const-string v0, "GEOFENCE_TOO_MANY_PENDING_INTENTS"

    goto :goto_0

    .line 1431
    :sswitch_3
    const-string v0, "UNSPECIFIED_ERROR"

    goto :goto_0

    .line 1434
    :sswitch_4
    const-string v0, "SUCCESS"

    goto :goto_0

    .line 1420
    :sswitch_data_0
    .sparse-switch
        0x0 -> :sswitch_4
        0x1 -> :sswitch_3
        0x3e8 -> :sswitch_0
        0x3e9 -> :sswitch_1
        0x3ea -> :sswitch_2
    .end sparse-switch
.end method

.method private a(Lcom/exacttarget/etpushsdk/ETLocationManager$a;Landroid/app/PendingIntent;)Lqu;
    .locals 1

    .prologue
    .line 1444
    new-instance v0, Lcom/exacttarget/etpushsdk/n;

    invoke-direct {v0, p0, p1}, Lcom/exacttarget/etpushsdk/n;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/exacttarget/etpushsdk/ETLocationManager$a;)V

    return-object v0
.end method

.method private a(Lcom/exacttarget/etpushsdk/ETLocationManager$a;Ljava/util/List;)Lqu;
    .locals 1

    .prologue
    .line 1362
    new-instance v0, Lcom/exacttarget/etpushsdk/m;

    invoke-direct {v0, p0, p1, p2}, Lcom/exacttarget/etpushsdk/m;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager$c;Lcom/exacttarget/etpushsdk/ETLocationManager$a;Ljava/util/List;)V

    return-object v0
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;)V
    .locals 0

    .prologue
    .line 1233
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->c()V

    return-void
.end method

.method private b()Landroid/app/PendingIntent;
    .locals 4

    .prologue
    .line 1250
    const-string v0, "~!RegionMonitor"

    const-string v1, "getGeofencePendingIntent()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1252
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->e:Landroid/app/PendingIntent;

    if-nez v0, :cond_0

    .line 1253
    const-string v0, "~!RegionMonitor"

    const-string v1, "Create New GeofencePendingIntent"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1254
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1255
    const-string v1, "et_location_action_geofence_cross"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 1256
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    const/16 v2, 0x3ea

    const/high16 v3, 0x8000000

    invoke-static {v1, v2, v0, v3}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->e:Landroid/app/PendingIntent;

    .line 1260
    :goto_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->e:Landroid/app/PendingIntent;

    return-object v0

    .line 1258
    :cond_0
    const-string v0, "~!RegionMonitor"

    const-string v1, "Reuse Existing GeofencePendingIntent"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method private c()V
    .locals 9

    .prologue
    .line 1264
    const-string v0, "~!RegionMonitor"

    const-string v1, "updateGeofencesFromDatabase()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1265
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->c:Ljava/util/List;

    if-nez v0, :cond_0

    .line 1266
    const-string v0, "~!RegionMonitor"

    const-string v1, "No Monitored Regions Yet"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1359
    :goto_0
    return-void

    .line 1271
    :cond_0
    :try_start_0
    const-string v0, "location_type = ? AND active = ?"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    const/4 v2, 0x1

    const-string v3, "1"

    aput-object v3, v1, v2

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v3, v4}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 1277
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 1278
    const-string v0, "~!RegionMonitor"

    const-string v1, "Removing Regions ..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1279
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->c:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    .line 1280
    invoke-interface {v2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    const-string v1, "~~m@g1c_f3nc3~~"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 1282
    :cond_1
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1285
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getName()Ljava/lang/String;

    move-result-object v1

    .line 1286
    :goto_2
    const-string v5, "~~m@g1c_f3nc3~~"

    invoke-virtual {v1, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 1287
    const-string v5, "~!RegionMonitor"

    const-string v6, "Removing Region: %1$s @ (%2$s, %3$s)"

    const/4 v7, 0x3

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v1, v7, v8

    const/4 v1, 0x1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getLatitude()Ljava/lang/Double;

    move-result-object v8

    aput-object v8, v7, v1

    const/4 v1, 0x2

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getLongitude()Ljava/lang/Double;

    move-result-object v0

    aput-object v0, v7, v1

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v5, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 1356
    :catch_0
    move-exception v0

    .line 1357
    const-string v1, "~!RegionMonitor"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_0

    .line 1285
    :cond_2
    :try_start_1
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v1

    goto :goto_2

    .line 1289
    :cond_3
    const-string v0, "~!RegionMonitor"

    const-string v5, "Removing Region: %1$s"

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1

    .line 1292
    :cond_4
    const-string v5, "~!RegionMonitor"

    const-string v6, "Ignoring %1$s Region: %2$s"

    const/4 v1, 0x2

    new-array v7, v1, [Ljava/lang/Object;

    const/4 v8, 0x0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getActive()Ljava/lang/Boolean;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    if-eqz v1, :cond_5

    const-string v1, "ACTIVE"

    :goto_3
    aput-object v1, v7, v8

    const/4 v1, 0x1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getName()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v7, v1

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v5, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_1

    :cond_5
    const-string v1, "INACTIVE"

    goto :goto_3

    .line 1296
    :cond_6
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_7

    .line 1297
    const-string v0, "~!RegionMonitor"

    const-string v1, "Removing %1$d Region(s)"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v1, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1298
    sget-object v0, Lahy;->c:Lahu;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;

    move-result-object v1

    invoke-interface {v0, v1, v3}, Lahu;->a(Lqm;Ljava/util/List;)Lqq;

    move-result-object v0

    .line 1299
    sget-object v1, Lcom/exacttarget/etpushsdk/ETLocationManager$a;->c:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    invoke-direct {p0, v1, v3}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$a;Ljava/util/List;)Lqu;

    move-result-object v1

    invoke-interface {v0, v1}, Lqq;->a(Lqu;)V

    .line 1303
    :cond_7
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 1304
    const-string v0, "~!RegionMonitor"

    const-string v1, "Adding Regions ..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1305
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_4
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    .line 1306
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->c:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_8

    const-string v1, "~~m@g1c_f3nc3~~"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_b

    .line 1308
    :cond_8
    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 1311
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_9

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getName()Ljava/lang/String;

    move-result-object v1

    .line 1312
    :goto_5
    const-string v4, "~~m@g1c_f3nc3~~"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_a

    .line 1313
    const-string v4, "~!RegionMonitor"

    const-string v5, "Adding Region: %1$s @ (%2$s, %3$s)"

    const/4 v6, 0x3

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    const/4 v1, 0x1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getLatitude()Ljava/lang/Double;

    move-result-object v7

    aput-object v7, v6, v1

    const/4 v1, 0x2

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getLongitude()Ljava/lang/Double;

    move-result-object v0

    aput-object v0, v6, v1

    invoke-static {v5, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v4, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_4

    .line 1311
    :cond_9
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v1

    goto :goto_5

    .line 1315
    :cond_a
    const-string v0, "~!RegionMonitor"

    const-string v4, "Adding Region: %1$s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v1, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_4

    .line 1318
    :cond_b
    const-string v1, "~!RegionMonitor"

    const-string v4, "Already Monitoring Region: %1$s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getName()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_4

    .line 1321
    :cond_c
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->d:Ljava/util/List;

    .line 1322
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_6
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_f

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    .line 1324
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    .line 1326
    const-string v1, "region_id = ?"

    .line 1327
    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/String;

    const/4 v6, 0x0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    .line 1328
    const/4 v6, 0x0

    const/4 v7, 0x0

    const/4 v8, 0x0

    invoke-static {v1, v5, v6, v7, v8}, Lcom/exacttarget/etpushsdk/database/f;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 1336
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_d
    :goto_7
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_e

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    .line 1337
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getMessage()Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v1

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v1

    .line 1338
    if-eqz v1, :cond_d

    .line 1339
    invoke-interface {v4, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_7

    .line 1342
    :cond_e
    invoke-virtual {v0, v4}, Lcom/exacttarget/etpushsdk/data/Region;->setMessages(Ljava/util/List;)V

    .line 1344
    const-string v1, "~!RegionMonitor"

    const-string v4, "Creating Geofence from Region: %1$s at (%2$s, %3$s) w/Radius of %4$dm"

    const/4 v5, 0x4

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getLatitude()Ljava/lang/Double;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x2

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getLongitude()Ljava/lang/Double;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x3

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getRadius()Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v4, v5}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-static {v1, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1345
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->d:Ljava/util/List;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->a()Lahs;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_6

    .line 1349
    :cond_f
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->d:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_10

    .line 1350
    const-string v0, "~!RegionMonitor"

    const-string v1, "Adding %1$d Region(s)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    invoke-static {v3}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v3

    aput-object v3, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1351
    sget-object v0, Lahy;->c:Lahu;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->d:Ljava/util/List;

    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->b()Landroid/app/PendingIntent;

    move-result-object v3

    invoke-interface {v0, v1, v2, v3}, Lahu;->a(Lqm;Ljava/util/List;Landroid/app/PendingIntent;)Lqq;

    move-result-object v0

    .line 1352
    sget-object v1, Lcom/exacttarget/etpushsdk/ETLocationManager$a;->a:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->d:Ljava/util/List;

    invoke-direct {p0, v1, v2}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$a;Ljava/util/List;)Lqu;

    move-result-object v1

    invoke-interface {v0, v1}, Lqq;->a(Lqu;)V

    goto/16 :goto_0

    .line 1354
    :cond_10
    const-string v0, "~!RegionMonitor"

    const-string v1, "No New Fences to Monitor"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    .line 1499
    const-string v0, "~!RegionMonitor"

    const-string v1, "Removing All Geofences"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1500
    sget-object v0, Lahy;->c:Lahu;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;

    move-result-object v1

    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->b()Landroid/app/PendingIntent;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lahu;->a(Lqm;Landroid/app/PendingIntent;)Lqq;

    move-result-object v0

    .line 1501
    sget-object v1, Lcom/exacttarget/etpushsdk/ETLocationManager$a;->b:Lcom/exacttarget/etpushsdk/ETLocationManager$a;

    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->b()Landroid/app/PendingIntent;

    move-result-object v2

    invoke-direct {p0, v1, v2}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$a;Landroid/app/PendingIntent;)Lqu;

    move-result-object v1

    invoke-interface {v0, v1}, Lqq;->a(Lqu;)V

    .line 1502
    return-void
.end method

.method public a(Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 1246
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->b:Ljava/lang/Boolean;

    .line 1247
    return-void
.end method

.method public a(Ljava/util/List;)V
    .locals 0

    .prologue
    .line 1242
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->c:Ljava/util/List;

    .line 1243
    return-void
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 1483
    const-string v0, "~!RegionMonitor"

    const-string v1, "GoogleApiClient onConnected()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1486
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-nez v0, :cond_0

    .line 1487
    const-string v0, "~!RegionMonitor"

    const-string v1, "Not Watching Location, Return"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1496
    :goto_0
    return-void

    .line 1491
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->b:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1492
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a()V

    goto :goto_0

    .line 1494
    :cond_1
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->c()V

    goto :goto_0
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 1477
    const-string v0, "~!RegionMonitor"

    const-string v1, "onConnectionFailed()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1478
    const-string v0, "~!RegionMonitor"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "PlayServices connection failed: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lpp;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 1479
    return-void
.end method

.method public onConnectionSuspended(I)V
    .locals 5

    .prologue
    .line 1506
    const-string v0, "~!RegionMonitor"

    const-string v1, "onConnectionSuspended(%1$d)"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1507
    return-void
.end method
