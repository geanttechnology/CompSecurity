.class public final Lcom/exacttarget/etpushsdk/ETLocationService;
.super Landroid/app/IntentService;
.source "SourceFile"


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 39
    const-string v0, "~!ETLocationService"

    invoke-direct {p0, v0}, Landroid/app/IntentService;-><init>(Ljava/lang/String;)V

    .line 40
    return-void
.end method

.method private a(Landroid/content/Intent;)V
    .locals 10

    .prologue
    const/4 v9, 0x2

    const/4 v8, 0x1

    const/4 v2, 0x0

    .line 156
    const-string v0, "~!ETLocationService"

    const-string v1, "handleGeofenceCrossEnterExit()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 158
    invoke-static {p1}, Lahv;->a(Landroid/content/Intent;)Lahv;

    move-result-object v0

    invoke-virtual {v0}, Lahv;->c()I

    move-result v4

    .line 160
    if-eq v4, v8, :cond_0

    if-ne v4, v9, :cond_3

    .line 163
    :cond_0
    invoke-static {p1}, Lahv;->a(Landroid/content/Intent;)Lahv;

    move-result-object v0

    invoke-virtual {v0}, Lahv;->d()Ljava/util/List;

    move-result-object v0

    .line 166
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    move v1, v2

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lahs;

    .line 167
    const-string v6, "~!ETLocationService"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v7, "FenceTripped: "

    invoke-virtual {v3, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    add-int/lit8 v3, v1, 0x1

    invoke-virtual {v7, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v7, ", "

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {v0}, Lahs;->f()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v1, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v6, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    invoke-interface {v0}, Lahs;->f()Ljava/lang/String;

    move-result-object v0

    .line 171
    const-string v1, "~~m@g1c_f3nc3~~"

    invoke-virtual {v1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    if-ne v9, v4, :cond_2

    .line 172
    const-string v0, "~!ETLocationService"

    const-string v1, "Magic fence was exited, get new fence data"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 173
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0, v8}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Z)V

    .line 174
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 175
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V

    :cond_1
    :goto_1
    move v1, v3

    .line 181
    goto :goto_0

    .line 179
    :cond_2
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v1

    const/4 v6, -0x1

    invoke-virtual {v1, v0, v4, v6}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/String;II)V

    goto :goto_1

    .line 184
    :cond_3
    const-string v0, "~!ETLocationService"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Invalid Geofence Transition Type: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 186
    :cond_4
    return-void
.end method

.method private b(Landroid/content/Intent;)V
    .locals 4

    .prologue
    .line 189
    invoke-static {p1}, Lahv;->a(Landroid/content/Intent;)Lahv;

    move-result-object v0

    invoke-virtual {v0}, Lahv;->b()I

    move-result v0

    .line 191
    const-string v1, "~!ETLocationService"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "ERROR, LocationStatusCode: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 192
    return-void
.end method


# virtual methods
.method protected onHandleIntent(Landroid/content/Intent;)V
    .locals 10

    .prologue
    const-wide/32 v8, 0x493e0

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 44
    const-string v0, "~!ETLocationService"

    const-string v3, "%s.onHandleIntent()"

    new-array v4, v2, [Ljava/lang/Object;

    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v4, v1

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 46
    const-string v0, "power"

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/PowerManager;

    .line 47
    const-string v3, "~!ETLocationService"

    invoke-virtual {v0, v2, v3}, Landroid/os/PowerManager;->newWakeLock(ILjava/lang/String;)Landroid/os/PowerManager$WakeLock;

    move-result-object v3

    .line 48
    invoke-virtual {v3}, Landroid/os/PowerManager$WakeLock;->acquire()V

    .line 50
    invoke-static {p1}, Lcom/exacttarget/etpushsdk/ETLocationReceiver;->completeWakefulIntent(Landroid/content/Intent;)Z

    .line 53
    :try_start_0
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v4

    .line 55
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 57
    const/4 v0, -0x1

    invoke-virtual {v4}, Ljava/lang/String;->hashCode()I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v5

    sparse-switch v5, :sswitch_data_0

    :cond_0
    :goto_0
    packed-switch v0, :pswitch_data_0

    .line 151
    :cond_1
    :goto_1
    invoke-virtual {v3}, Landroid/os/PowerManager$WakeLock;->release()V

    .line 153
    :goto_2
    return-void

    .line 57
    :sswitch_0
    :try_start_1
    const-string v2, "android.intent.action.PROVIDER_CHANGED"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    move v0, v1

    goto :goto_0

    :sswitch_1
    const-string v1, "et_location_action_timeout"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    move v0, v2

    goto :goto_0

    :sswitch_2
    const-string v1, "et_location_action_15minute_update"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x2

    goto :goto_0

    :sswitch_3
    const-string v1, "et_location_action_geofence_cross"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x3

    goto :goto_0

    :sswitch_4
    const-string v1, "et_location_action_passive_location_change"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const/4 v0, 0x4

    goto :goto_0

    .line 59
    :pswitch_0
    const-string v0, "~!ETLocationService"

    const-string v1, "Providers changed."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 61
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->g()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 62
    const-string v0, "~!ETLocationService"

    const-string v1, "Location Provider enabled."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 63
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 64
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1

    .line 148
    :catch_0
    move-exception v0

    .line 149
    :try_start_2
    const-string v1, "~!ETLocationService"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 151
    invoke-virtual {v3}, Landroid/os/PowerManager$WakeLock;->release()V

    goto :goto_2

    .line 67
    :cond_2
    :try_start_3
    const-string v0, "~!ETLocationService"

    const-string v1, "Location Provider disabled."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 70
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Z)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_1

    .line 151
    :catchall_0
    move-exception v0

    invoke-virtual {v3}, Landroid/os/PowerManager$WakeLock;->release()V

    throw v0

    .line 76
    :pswitch_1
    :try_start_4
    const-string v0, "~!ETLocationService"

    const-string v1, "Location timeout."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 77
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    if-eqz v0, :cond_1

    .line 78
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    invoke-interface {v0}, Lcom/exacttarget/etpushsdk/location/a;->a()V

    goto/16 :goto_1

    .line 83
    :pswitch_2
    const-string v0, "~!ETLocationService"

    const-string v1, "Location 15 minute update."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 84
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 85
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V

    goto/16 :goto_1

    .line 87
    :cond_3
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->stopWatchingLocation()V

    goto/16 :goto_1

    .line 91
    :pswitch_3
    const-string v0, "~!ETLocationService"

    const-string v1, "Location geofence crossed."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 93
    invoke-static {p1}, Lahv;->a(Landroid/content/Intent;)Lahv;

    move-result-object v0

    invoke-virtual {v0}, Lahv;->a()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 94
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETLocationService;->b(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 96
    :cond_4
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETLocationService;->a(Landroid/content/Intent;)V

    goto/16 :goto_1

    .line 101
    :pswitch_4
    const-string v0, "~!ETLocationService"

    const-string v1, "Location changed (passively)."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 103
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingLocation()Z

    move-result v0

    if-nez v0, :cond_5

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingProximity()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 104
    :cond_5
    const-string v0, "~!ETLocationService"

    const-string v1, "Location on and watching location..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 106
    const-string v0, "location"

    .line 109
    invoke-virtual {p1, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_6

    .line 112
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Location;

    .line 140
    :goto_3
    if-eqz v0, :cond_1

    .line 141
    const-string v1, "~!ETLocationService"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "New Passive Location: "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v4, ", "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v4

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 142
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v2, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-direct {v2, v0}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;-><init>(Landroid/location/Location;)V

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->b(Ljava/lang/Object;)V

    goto/16 :goto_1

    .line 119
    :cond_6
    new-instance v0, Lcom/exacttarget/etpushsdk/location/e;

    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/location/e;-><init>(Landroid/content/Context;)V

    .line 120
    const/4 v1, 0x0

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    sub-long/2addr v4, v8

    invoke-virtual {v0, v1, v4, v5}, Lcom/exacttarget/etpushsdk/location/e;->a(IJ)Landroid/location/Location;

    move-result-object v1

    .line 123
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    const-class v2, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    .line 124
    if-eqz v0, :cond_8

    .line 125
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v0

    .line 133
    invoke-virtual {v0}, Landroid/location/Location;->getTime()J

    move-result-wide v4

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v8

    cmp-long v2, v4, v6

    if-gtz v2, :cond_7

    invoke-virtual {v0, v1}, Landroid/location/Location;->distanceTo(Landroid/location/Location;)F
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result v0

    const/4 v2, 0x0

    cmpg-float v0, v0, v2

    if-gez v0, :cond_8

    .line 134
    :cond_7
    const/4 v0, 0x0

    goto :goto_3

    :cond_8
    move-object v0, v1

    goto :goto_3

    .line 57
    nop

    :sswitch_data_0
    .sparse-switch
        -0x78a64a1f -> :sswitch_2
        -0x5c528e6d -> :sswitch_4
        -0x471ea16e -> :sswitch_1
        0x1ec60c70 -> :sswitch_3
        0x6316690b -> :sswitch_0
    .end sparse-switch

    :pswitch_data_0
    .packed-switch 0x0
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
    .end packed-switch
.end method
