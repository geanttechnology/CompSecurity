.class Lcom/exacttarget/etpushsdk/d;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

.field final synthetic b:Lcom/exacttarget/etpushsdk/ETLocationManager;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;)V
    .locals 0

    .prologue
    .line 907
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    iput-object p2, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 911
    :try_start_0
    new-instance v0, Ljava/util/Date;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v1

    invoke-virtual {v1}, Landroid/location/Location;->getTime()J

    move-result-wide v2

    invoke-direct {v0, v2, v3}, Ljava/util/Date;-><init>(J)V

    .line 913
    const-string v1, "timestamp = ?"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/n;->a(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v1, v2, v3, v4, v5}, Lcom/exacttarget/etpushsdk/database/d;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 920
    const-string v2, "~!ETLocationManager"

    const-string v3, "Location updates count: %1$d"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v6

    invoke-static {v6}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 921
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_0

    .line 922
    const-string v1, "~!ETLocationManager"

    const-string v2, "Create new location in DB"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 925
    new-instance v1, Lcom/exacttarget/etpushsdk/data/LocationUpdate;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v2

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;-><init>(Landroid/content/Context;)V

    .line 926
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->setLatitude(Ljava/lang/Double;)V

    .line 927
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->setLongitude(Ljava/lang/Double;)V

    .line 928
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getAccuracy()F

    move-result v2

    invoke-static {v2}, Ljava/lang/Math;->round(F)I

    move-result v2

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->setAccuracy(Ljava/lang/Integer;)V

    .line 929
    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/LocationUpdate;->setTimestamp(Ljava/util/Date;)V

    .line 930
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/d;->a(Lcom/exacttarget/etpushsdk/data/LocationUpdate;)V

    .line 934
    :cond_0
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 935
    const-string v1, "et_send_type_extra"

    const-string v2, "et_send_type_location"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 936
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 938
    const-string v0, "~!ETLocationManager"

    const-string v1, "isWatchingLocation: %1$s and getGeofenceInvalidated(): %2$s"

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->j()Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d()Z

    move-result v4

    invoke-static {v4}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v4

    aput-object v4, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 939
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->j()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 940
    const-string v0, "~!ETLocationManager"

    const-string v1, "Retrieve geofence data"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 943
    new-instance v0, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;-><init>(Landroid/content/Context;)V

    .line 944
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v1

    invoke-virtual {v1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->setLatitude(Ljava/lang/Double;)V

    .line 945
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v1

    invoke-virtual {v1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/GeofenceRequest;->setLongitude(Ljava/lang/Double;)V

    .line 947
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/c;->a(Lcom/exacttarget/etpushsdk/event/GeofenceRequest;)V

    .line 950
    const-string v0, "~!ETLocationManager"

    const-string v1, "Requesting new Geofence data"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 951
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 952
    const-string v1, "et_send_type_extra"

    const-string v2, "et_send_type_geofence"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 953
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V

    .line 956
    :cond_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->k()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 957
    const-string v0, "~!ETLocationManager"

    const-string v1, "Retrieve beacon data"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 958
    new-instance v0, Lcom/exacttarget/etpushsdk/event/BeaconRequest;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/event/BeaconRequest;-><init>(Landroid/content/Context;)V

    .line 959
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v1

    invoke-virtual {v1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->setLatitude(Ljava/lang/Double;)V

    .line 960
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->a:Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v1

    invoke-virtual {v1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/event/BeaconRequest;->setLongitude(Ljava/lang/Double;)V

    .line 962
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/b;->a(Lcom/exacttarget/etpushsdk/event/BeaconRequest;)V

    .line 965
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/exacttarget/etpushsdk/ETPushReceiver;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 966
    const-string v1, "et_send_type_extra"

    const-string v2, "et_send_type_proximity"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 967
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/d;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/content/Context;->sendBroadcast(Landroid/content/Intent;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 972
    :cond_2
    :goto_0
    return-void

    .line 969
    :catch_0
    move-exception v0

    .line 970
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method
