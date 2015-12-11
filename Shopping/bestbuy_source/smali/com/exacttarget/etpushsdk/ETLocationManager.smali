.class public Lcom/exacttarget/etpushsdk/ETLocationManager;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/exacttarget/etpushsdk/event/BackgroundEventListener;
.implements Lcom/exacttarget/etpushsdk/event/BeaconResponseEventListener;
.implements Lcom/exacttarget/etpushsdk/event/GeofenceResponseEventListener;
.implements Lcom/exacttarget/etpushsdk/event/LastKnownLocationEventListener;
.implements Lcom/exacttarget/etpushsdk/event/LocationUpdateEventListener;


# annotations
.annotation build Landroid/annotation/SuppressLint;
    value = {
        "CommitPrefEdits"
    }
.end annotation


# static fields
.field private static final b:Ljava/lang/Object;

.field private static final c:Ljava/lang/Object;

.field private static d:Lcom/exacttarget/etpushsdk/ETLocationManager;

.field private static e:Ljava/lang/Boolean;

.field private static f:Ljava/lang/Boolean;

.field private static g:Ljava/util/concurrent/CountDownLatch;

.field private static h:Ljava/util/concurrent/CountDownLatch;


# instance fields
.field protected a:Lcom/exacttarget/etpushsdk/location/a;

.field private i:Landroid/content/Context;

.field private j:Landroid/app/AlarmManager;

.field private k:Landroid/app/PendingIntent;

.field private l:Landroid/app/PendingIntent;

.field private m:Lqm;

.field private n:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

.field private o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

.field private p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

.field private q:Z

.field private r:Landroid/content/BroadcastReceiver;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 110
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->b:Ljava/lang/Object;

    .line 111
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->c:Ljava/lang/Object;

    .line 115
    sput-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    .line 116
    sput-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    .line 117
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->g:Ljava/util/concurrent/CountDownLatch;

    .line 118
    new-instance v0, Ljava/util/concurrent/CountDownLatch;

    invoke-direct {v0, v1}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->h:Ljava/util/concurrent/CountDownLatch;

    return-void
.end method

.method private constructor <init>(Landroid/content/Context;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 156
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 128
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->q:Z

    .line 129
    new-instance v0, Lcom/exacttarget/etpushsdk/c;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/c;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->r:Landroid/content/BroadcastReceiver;

    .line 157
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    .line 159
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/exacttarget/etpushsdk/util/EventBus;->register(Ljava/lang/Object;)V

    .line 161
    new-instance v0, Lcom/exacttarget/etpushsdk/location/c;

    invoke-direct {v0, p1}, Lcom/exacttarget/etpushsdk/location/c;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    .line 163
    const-string v0, "alarm"

    invoke-virtual {p1, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/AlarmManager;

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    .line 165
    new-instance v0, Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Lcom/exacttarget/etpushsdk/c;)V

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->n:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    .line 167
    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Z)V

    .line 168
    invoke-virtual {p0, v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h(Z)V

    .line 169
    return-void
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    return-object v0
.end method

.method static synthetic a(Ljava/util/concurrent/CountDownLatch;)Ljava/util/concurrent/CountDownLatch;
    .locals 0

    .prologue
    .line 95
    sput-object p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->g:Ljava/util/concurrent/CountDownLatch;

    return-object p0
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETLocationManager;Lqm;)Lqm;
    .locals 0

    .prologue
    .line 95
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->m:Lqm;

    return-object p1
.end method

.method protected static a(Landroid/content/Context;)V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 205
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;

    if-nez v0, :cond_2

    .line 206
    const-string v0, "~!ETLocationManager"

    const-string v1, "readyAimFire()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 207
    new-instance v0, Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-direct {v0, p0}, Lcom/exacttarget/etpushsdk/ETLocationManager;-><init>(Landroid/content/Context;)V

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;

    .line 210
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_key_run_once"

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 213
    const-string v0, "~!ETLocationManager"

    const-string v1, "start receiving passive location updates"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 214
    const-string v0, "location"

    invoke-virtual {p0, v0}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 215
    new-instance v1, Lcom/exacttarget/etpushsdk/location/b;

    invoke-direct {v1, v0}, Lcom/exacttarget/etpushsdk/location/b;-><init>(Landroid/location/LocationManager;)V

    .line 216
    new-instance v0, Landroid/content/Intent;

    const-class v2, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v0, p0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 217
    const-string v2, "et_location_action_passive_location_change"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 218
    const/16 v2, 0x3eb

    const/high16 v3, 0x8000000

    invoke-static {p0, v2, v0, v3}, Landroid/app/PendingIntent;->getActivity(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v6

    .line 219
    const-wide/32 v2, 0x493e0

    const-wide/16 v4, 0x0

    invoke-virtual/range {v1 .. v6}, Lcom/exacttarget/etpushsdk/location/g;->a(JJLandroid/app/PendingIntent;)V

    .line 220
    const-string v0, "~!ETLocationManager"

    const-string v1, "finished receiving passive location updates"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 223
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 224
    const-string v0, "~!ETLocationManager"

    const-string v1, "want to watch locations, so start watching"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 225
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0, v7}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V

    .line 231
    :goto_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 232
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0, v7}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Z)Z

    .line 240
    :goto_1
    return-void

    .line 227
    :cond_0
    const-string v0, "~!ETLocationManager"

    const-string v1, "DO NOT WANT to watch locations"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 228
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    goto :goto_0

    .line 234
    :cond_1
    invoke-static {v7}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    goto :goto_1

    .line 238
    :cond_2
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v1, "You must have called readyAimFire more than once."

    invoke-direct {v0, v1}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method static synthetic a(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)Z
    .locals 0

    .prologue
    .line 95
    iput-boolean p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->q:Z

    return p1
.end method

.method static synthetic b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    return-object v0
.end method

.method static synthetic b(Ljava/util/concurrent/CountDownLatch;)Ljava/util/concurrent/CountDownLatch;
    .locals 0

    .prologue
    .line 95
    sput-object p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->h:Ljava/util/concurrent/CountDownLatch;

    return-object p0
.end method

.method static synthetic c(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lqm;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->m:Lqm;

    return-object v0
.end method

.method static synthetic d(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$c;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->n:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    return-object v0
.end method

.method static synthetic e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic f(Lcom/exacttarget/etpushsdk/ETLocationManager;)V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->l()V

    return-void
.end method

.method static synthetic g(Lcom/exacttarget/etpushsdk/ETLocationManager;)Z
    .locals 1

    .prologue
    .line 95
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->q:Z

    return v0
.end method

.method public static declared-synchronized getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;
    .locals 3

    .prologue
    .line 177
    const-class v1, Lcom/exacttarget/etpushsdk/ETLocationManager;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 178
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 179
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;

    if-nez v0, :cond_0

    .line 180
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "You forgot to call readyAimFire first."

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 177
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 182
    :cond_0
    :try_start_1
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->d:Lcom/exacttarget/etpushsdk/ETLocationManager;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    monitor-exit v1

    return-object v0

    .line 184
    :cond_1
    :try_start_2
    new-instance v0, Lcom/exacttarget/etpushsdk/ETException;

    const-string v2, "ETLocationManager disabled. Ensure you called readyAimFire and enabled it first."

    invoke-direct {v0, v2}, Lcom/exacttarget/etpushsdk/ETException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0
.end method

.method static synthetic h(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/BroadcastReceiver;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->r:Landroid/content/BroadcastReceiver;

    return-object v0
.end method

.method static synthetic h()Ljava/util/concurrent/CountDownLatch;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->g:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method static synthetic i()Ljava/util/concurrent/CountDownLatch;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->h:Ljava/util/concurrent/CountDownLatch;

    return-object v0
.end method

.method static synthetic i(Lcom/exacttarget/etpushsdk/ETLocationManager;)V
    .locals 0

    .prologue
    .line 95
    invoke-direct {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->m()V

    return-void
.end method

.method static synthetic j()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    return-object v0
.end method

.method static synthetic k()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 95
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    return-object v0
.end method

.method private l()V
    .locals 12

    .prologue
    const/high16 v11, 0x8000000

    const/4 v10, 0x1

    const-wide/32 v4, 0xdbba0

    const/4 v1, 0x2

    .line 340
    const-string v0, "~!ETLocationManager"

    const-string v2, "startLocationBackgroundWatcher() started"

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 341
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->g()Z

    move-result v0

    if-nez v0, :cond_0

    .line 353
    const-string v0, "~!ETLocationManager"

    const-string v1, "No Location Providers available.  ET will wait patiently until they are turned on to start watching location."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    .line 385
    :goto_0
    return-void

    .line 358
    :cond_0
    const-string v0, "~!ETLocationManager"

    const-string v2, "Getting PowerStatusChangedEvent."

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 359
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    const-class v2, Lcom/exacttarget/etpushsdk/event/PowerStatusChangedEvent;

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/event/PowerStatusChangedEvent;

    .line 360
    const-string v2, "~!ETLocationManager"

    const-string v3, "Have PowerStatusChangedEvent."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 361
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/event/PowerStatusChangedEvent;->getStatus()I

    move-result v0

    if-ne v0, v10, :cond_3

    .line 362
    :cond_1
    const-string v0, "~!ETLocationManager"

    const-string v2, "Getting getLastBestLocation."

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 363
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    const/16 v2, 0x64

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v6

    sub-long/2addr v6, v4

    invoke-interface {v0, v2, v6, v7}, Lcom/exacttarget/etpushsdk/location/a;->a(IJ)Landroid/location/Location;

    move-result-object v0

    .line 365
    if-eqz v0, :cond_2

    .line 366
    const-string v2, "~!ETLocationManager"

    const-string v3, "Have getLastBestLocation.  lat: %.7f lng: %.7f"

    new-array v6, v1, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v0}, Landroid/location/Location;->getLatitude()D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v0}, Landroid/location/Location;->getLongitude()D

    move-result-wide v8

    invoke-static {v8, v9}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v0

    aput-object v0, v6, v10

    invoke-static {v3, v6}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 370
    :cond_2
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-class v3, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 371
    const-string v2, "et_location_action_timeout"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 372
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const/16 v3, 0x3e8

    invoke-static {v2, v3, v0, v11}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    .line 373
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    const-wide/32 v6, 0xea60

    add-long/2addr v2, v6

    iget-object v6, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1, v2, v3, v6}, Landroid/app/AlarmManager;->set(IJLandroid/app/PendingIntent;)V

    .line 375
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    if-nez v0, :cond_3

    .line 377
    const-string v0, "~!ETLocationManager"

    const-string v2, "Set recurring 15-minute locationWakeup Alarm."

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 378
    new-instance v0, Landroid/content/Intent;

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-class v3, Lcom/exacttarget/etpushsdk/ETLocationReceiver;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 379
    const-string v2, "et_location_action_15minute_update"

    invoke-virtual {v0, v2}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 380
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const/16 v3, 0x3e9

    invoke-static {v2, v3, v0, v11}, Landroid/app/PendingIntent;->getBroadcast(Landroid/content/Context;ILandroid/content/Intent;I)Landroid/app/PendingIntent;

    move-result-object v0

    iput-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    .line 381
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    invoke-static {}, Landroid/os/SystemClock;->elapsedRealtime()J

    move-result-wide v2

    add-long/2addr v2, v4

    iget-object v6, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    invoke-virtual/range {v0 .. v6}, Landroid/app/AlarmManager;->setInexactRepeating(IJJLandroid/app/PendingIntent;)V

    .line 384
    :cond_3
    const-string v0, "~!ETLocationManager"

    const-string v1, "startLocationBackgroundWatcher() ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_0
.end method

.method public static declared-synchronized locationManager()Lcom/exacttarget/etpushsdk/ETLocationManager;
    .locals 2
    .annotation runtime Ljava/lang/Deprecated;
    .end annotation

    .prologue
    .line 196
    const-class v0, Lcom/exacttarget/etpushsdk/ETLocationManager;

    monitor-enter v0

    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method private m()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 388
    const-string v0, "~!ETLocationManager"

    const-string v1, "stopLocationBackgroundWatcher() started"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 390
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_2

    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_2

    .line 391
    const-string v0, "~!ETLocationManager"

    const-string v1, "stopLocationBackgroundWatcher stopping services..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 392
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    if-eqz v0, :cond_0

    .line 393
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    invoke-interface {v0}, Lcom/exacttarget/etpushsdk/location/a;->a()V

    .line 395
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    if-eqz v0, :cond_1

    .line 396
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 397
    iput-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    .line 399
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    if-eqz v0, :cond_2

    .line 400
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 401
    iput-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    .line 404
    :cond_2
    const-string v0, "~!ETLocationManager"

    const-string v1, "stopLocationBackgroundWatcher() ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 405
    return-void
.end method


# virtual methods
.method public a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 717
    const-string v0, "~!ETLocationManager"

    const-string v1, "enterLowPowerMode()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 718
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    if-eqz v0, :cond_0

    .line 719
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->a:Lcom/exacttarget/etpushsdk/location/a;

    invoke-interface {v0}, Lcom/exacttarget/etpushsdk/location/a;->a()V

    .line 721
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    if-eqz v0, :cond_1

    .line 722
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 723
    iput-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    .line 725
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    if-eqz v0, :cond_2

    .line 726
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 727
    iput-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->l:Landroid/app/PendingIntent;

    .line 729
    :cond_2
    return-void
.end method

.method protected declared-synchronized a(Z)V
    .locals 6

    .prologue
    .line 255
    monitor-enter p0

    :try_start_0
    const-string v0, "~!ETLocationManager"

    const-string v1, "startWatchingLocation() started"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 256
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-nez v0, :cond_0

    .line 257
    const-string v0, "~!ETLocationManager"

    const-string v1, "nothing to do.  LocationManager is not active"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 337
    :goto_0
    monitor-exit p0

    return-void

    .line 261
    :cond_0
    :try_start_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/util/j;->a(Landroid/content/Context;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 262
    const-string v0, "~!ETLocationManager"

    const-string v1, "nothing to do.  Google Play Services not available"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 255
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 266
    :cond_1
    :try_start_2
    sget-object v1, Lcom/exacttarget/etpushsdk/ETLocationManager;->b:Ljava/lang/Object;

    monitor-enter v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 268
    const/4 v0, 0x1

    :try_start_3
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    .line 269
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->b()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v0

    const/4 v2, 0x1

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/data/Registration;->setLocationEnabled(Ljava/lang/Boolean;)V

    .line 271
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/e;

    invoke-direct {v2, p0, p1}, Lcom/exacttarget/etpushsdk/e;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 312
    sget-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->g:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_2

    .line 313
    const-string v2, "~!ETLocationManager"

    const-string v3, "stopWatchingLocation is not running.  Now continue with locationStateThread start."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 314
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->g:Ljava/util/concurrent/CountDownLatch;

    .line 315
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 334
    :goto_1
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 336
    :try_start_4
    const-string v0, "~!ETLocationManager"

    const-string v1, "startWatchingLocation() ended.  Check locationStateThread start for final result."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 318
    :cond_2
    :try_start_5
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/f;

    invoke-direct {v3, p0, v0}, Lcom/exacttarget/etpushsdk/f;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Ljava/lang/Thread;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_1

    .line 334
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :try_start_6
    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
.end method

.method public b()V
    .locals 1

    .prologue
    .line 735
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V

    .line 736
    return-void
.end method

.method protected declared-synchronized b(Z)Z
    .locals 8

    .prologue
    const/4 v0, 0x0

    const/4 v1, 0x1

    .line 420
    monitor-enter p0

    :try_start_0
    const-string v2, "~!ETLocationManager"

    const-string v3, "startWatchingProximity() started."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 422
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v2

    if-nez v2, :cond_0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->i()Z

    move-result v2

    if-nez v2, :cond_0

    .line 423
    const-string v1, "~!ETLocationManager"

    const-string v2, "Nothing to do.  Neither LocationManager nor Proximity are active"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 510
    :goto_0
    monitor-exit p0

    return v0

    .line 427
    :cond_0
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->i()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 428
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    if-nez v2, :cond_1

    .line 429
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    invoke-static {v2}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->getInstanceForApplication(Landroid/content/Context;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v2

    iput-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    .line 430
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    const-wide/16 v4, 0x1388

    invoke-virtual {v2, v4, v5}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->setBackgroundScanPeriod(J)V

    .line 431
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    const-wide/16 v4, 0x2710

    invoke-virtual {v2, v4, v5}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->setBackgroundBetweenScanPeriod(J)V

    .line 432
    new-instance v2, Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcom/exacttarget/etpushsdk/ETLocationManager$b;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Lcom/exacttarget/etpushsdk/c;)V

    iput-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 437
    :cond_1
    :try_start_2
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v2}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->checkAvailability()Z

    move-result v2

    if-nez v2, :cond_2

    .line 438
    const-string v1, "~!ETLocationManager"

    const-string v2, "Bluetooth LE available, but not currently turned on in settings."

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 441
    :catch_0
    move-exception v0

    .line 442
    const/4 v1, 0x0

    :try_start_3
    iput-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    .line 443
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    .line 444
    throw v0
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 420
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 447
    :cond_2
    :try_start_4
    sget-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->c:Ljava/lang/Object;

    monitor-enter v2
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 448
    const/4 v0, 0x1

    :try_start_5
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    .line 449
    new-instance v0, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/g;

    invoke-direct {v3, p0, p1}, Lcom/exacttarget/etpushsdk/g;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)V

    invoke-direct {v0, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 486
    sget-object v3, Lcom/exacttarget/etpushsdk/ETLocationManager;->h:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v3}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-nez v3, :cond_3

    .line 487
    const-string v3, "~!ETLocationManager"

    const-string v4, "stopWatchingProximityThread is not running.  So continue to start watching proximity."

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 488
    new-instance v3, Ljava/util/concurrent/CountDownLatch;

    const/4 v4, 0x1

    invoke-direct {v3, v4}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v3, Lcom/exacttarget/etpushsdk/ETLocationManager;->h:Ljava/util/concurrent/CountDownLatch;

    .line 489
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 508
    :goto_1
    monitor-exit v2

    move v0, v1

    .line 510
    goto :goto_0

    .line 492
    :cond_3
    new-instance v3, Ljava/lang/Thread;

    new-instance v4, Lcom/exacttarget/etpushsdk/h;

    invoke-direct {v4, p0, v0}, Lcom/exacttarget/etpushsdk/h;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Ljava/lang/Thread;)V

    invoke-direct {v3, v4}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    goto :goto_1

    .line 508
    :catchall_1
    move-exception v0

    monitor-exit v2
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :try_start_6
    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
.end method

.method protected declared-synchronized c(Z)V
    .locals 6

    .prologue
    .line 526
    monitor-enter p0

    :try_start_0
    const-string v0, "~!ETLocationManager"

    const-string v1, "stopWatchingLocation() started"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 528
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-nez v0, :cond_0

    .line 529
    const-string v0, "~!ETLocationManager"

    const-string v1, "nothing to do.  LocationManager is not active"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 592
    :goto_0
    monitor-exit p0

    return-void

    .line 533
    :cond_0
    :try_start_1
    sget-object v1, Lcom/exacttarget/etpushsdk/ETLocationManager;->b:Ljava/lang/Object;

    monitor-enter v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 535
    :try_start_2
    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    .line 536
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->b()Lcom/exacttarget/etpushsdk/data/Registration;

    move-result-object v0

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/data/Registration;->setLocationEnabled(Ljava/lang/Boolean;)V

    .line 538
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/i;

    invoke-direct {v2, p0, p1}, Lcom/exacttarget/etpushsdk/i;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 567
    sget-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->g:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_1

    .line 568
    const-string v2, "~!ETLocationManager"

    const-string v3, "startWatchingLocation is not running.  Now continue with locationStateThread stop."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 569
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->g:Ljava/util/concurrent/CountDownLatch;

    .line 570
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 589
    :goto_1
    monitor-exit v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 591
    :try_start_3
    const-string v0, "~!ETLocationManager"

    const-string v1, "stopWatchingLocation() ended.  check locationStateThread stop for final result."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto :goto_0

    .line 526
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 573
    :cond_1
    :try_start_4
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/j;

    invoke-direct {v3, p0, v0}, Lcom/exacttarget/etpushsdk/j;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Ljava/lang/Thread;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_1

    .line 589
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    :try_start_5
    throw v0
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0
.end method

.method public c()Z
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 777
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v1, "et_geo_enabled_key"

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v5, "~!ETLocationManager"

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method protected declared-synchronized d(Z)V
    .locals 6

    .prologue
    .line 602
    monitor-enter p0

    :try_start_0
    const-string v0, "~!ETLocationManager"

    const-string v1, "stopWatchingProximity() Began"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 604
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->i()Z

    move-result v0

    if-nez v0, :cond_0

    .line 605
    const-string v0, "~!ETLocationManager"

    const-string v1, "Nothing to do.  Either Location or Proximity was not enabled in readyAimFire()."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 711
    :goto_0
    monitor-exit p0

    return-void

    .line 609
    :cond_0
    :try_start_1
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->isWatchingProximity()Z

    move-result v0

    if-nez v0, :cond_1

    .line 610
    const-string v0, "~!ETLocationManager"

    const-string v1, "Nothing to do. Not watching proximity."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 602
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 614
    :cond_1
    :try_start_2
    sget-object v1, Lcom/exacttarget/etpushsdk/ETLocationManager;->c:Ljava/lang/Object;

    monitor-enter v1
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 615
    const/4 v0, 0x0

    :try_start_3
    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    .line 616
    new-instance v0, Ljava/lang/Thread;

    new-instance v2, Lcom/exacttarget/etpushsdk/k;

    invoke-direct {v2, p0, p1}, Lcom/exacttarget/etpushsdk/k;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)V

    invoke-direct {v0, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 686
    sget-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->h:Ljava/util/concurrent/CountDownLatch;

    invoke-virtual {v2}, Ljava/util/concurrent/CountDownLatch;->getCount()J

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmp-long v2, v2, v4

    if-nez v2, :cond_2

    .line 687
    const-string v2, "~!ETLocationManager"

    const-string v3, "startWatchingProximityThread is not running.  So continue to stop watching proximity."

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 688
    new-instance v2, Ljava/util/concurrent/CountDownLatch;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/CountDownLatch;-><init>(I)V

    sput-object v2, Lcom/exacttarget/etpushsdk/ETLocationManager;->h:Ljava/util/concurrent/CountDownLatch;

    .line 689
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 708
    :goto_1
    monitor-exit v1
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 710
    :try_start_4
    const-string v0, "~!ETLocationManager"

    const-string v1, "stopWatchingProximity() Ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_0

    .line 692
    :cond_2
    :try_start_5
    new-instance v2, Ljava/lang/Thread;

    new-instance v3, Lcom/exacttarget/etpushsdk/l;

    invoke-direct {v3, p0, v0}, Lcom/exacttarget/etpushsdk/l;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Ljava/lang/Thread;)V

    invoke-direct {v2, v3}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v2}, Ljava/lang/Thread;->start()V

    goto :goto_1

    .line 708
    :catchall_1
    move-exception v0

    monitor-exit v1
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    :try_start_6
    throw v0
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_0
.end method

.method protected d()Z
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 785
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v1, "et_geofence_invalidated_key"

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v5, "~!ETLocationManager"

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public e(Z)V
    .locals 3

    .prologue
    .line 781
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_geo_enabled_key"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 782
    return-void
.end method

.method public e()Z
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 796
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v1, "et_proximity_enabled_key"

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v5, "~!ETLocationManager"

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public f(Z)V
    .locals 3

    .prologue
    .line 789
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_geofence_invalidated_key"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 790
    return-void
.end method

.method protected f()Z
    .locals 7

    .prologue
    const/4 v3, 0x1

    const/4 v6, 0x0

    .line 804
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v1, "et_proximity_invalidated_key"

    invoke-static {v3}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    new-array v3, v3, [Ljava/lang/Object;

    iget-object v4, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v5, "~!ETLocationManager"

    invoke-virtual {v4, v5, v6}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v4

    aput-object v4, v3, v6

    invoke-static {v0, v1, v2, v3}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0
.end method

.method public g(Z)V
    .locals 3

    .prologue
    .line 800
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_proximity_enabled_key"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 801
    return-void
.end method

.method public g()Z
    .locals 2

    .prologue
    .line 812
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->i:Landroid/content/Context;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 813
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string v1, "network"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public h(Z)V
    .locals 3

    .prologue
    .line 808
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_proximity_invalidated_key"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 809
    return-void
.end method

.method public isWatchingLocation()Z
    .locals 3

    .prologue
    .line 744
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 746
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    .line 747
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 754
    :cond_0
    :goto_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0

    .line 749
    :catch_0
    move-exception v0

    .line 750
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 751
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    goto :goto_0
.end method

.method public isWatchingProximity()Z
    .locals 3

    .prologue
    .line 763
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 765
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    if-nez v0, :cond_0

    .line 766
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 773
    :cond_0
    :goto_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    return v0

    .line 768
    :catch_0
    move-exception v0

    .line 769
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 770
    const/4 v0, 0x1

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    sput-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    goto :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/BackgroundEvent;)V
    .locals 3

    .prologue
    .line 825
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 826
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->h()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 827
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->isInBackground()Z

    move-result v0

    if-nez v0, :cond_3

    .line 829
    const-string v0, "~!ETLocationManager"

    const-string v1, "In FOREGROUND..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 830
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 831
    const-string v0, "~!ETLocationManager"

    const-string v1, "... and watching location, so get updated location"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 833
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Z)V

    .line 834
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V

    .line 837
    :cond_0
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 838
    const-string v0, "~!ETLocationManager"

    const-string v1, "... and watching proximity, so change proximity checking"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 839
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->isBound(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 840
    const-string v0, "~!ETLocationManager"

    const-string v1, "BeaconManager: In FOREGROUND"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 841
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->setBackgroundMode(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;Z)Z

    .line 844
    :cond_1
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h(Z)V

    .line 845
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Z)Z

    .line 862
    :cond_2
    :goto_0
    return-void

    .line 849
    :cond_3
    const-string v0, "~!ETLocationManager"

    const-string v1, "In BACKGROUND..."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 850
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->f:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 851
    const-string v0, "~!ETLocationManager"

    const-string v1, "... and watching proximity, so change proximity checking"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 852
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->isBound(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 853
    const-string v0, "~!ETLocationManager"

    const-string v1, "BeaconManager: In BACKGROUND"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 854
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->setBackgroundMode(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;Z)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 859
    :catch_0
    move-exception v0

    .line 860
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;)V
    .locals 8

    .prologue
    const/4 v5, 0x3

    .line 1092
    const-string v0, "~!ETLocationManager"

    const-string v1, "onEvent(BeaconResponseEvent)"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1095
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 1097
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->checkAvailability()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1098
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->isBound(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 1099
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->p:Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->bind(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)V

    .line 1100
    const-string v0, "~!ETLocationManager"

    const-string v1, "for some weird reason, iBeaconMonitor wasn\'t bound."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    .line 1227
    :cond_0
    :goto_0
    return-void

    .line 1106
    :cond_1
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    invoke-static {v0, v1, v2, v3, v4}, Lcom/exacttarget/etpushsdk/database/f;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1113
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1114
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    .line 1115
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getRegion()Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v3

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v3

    .line 1116
    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Region;->getLocationType()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-ne v3, v5, :cond_2

    .line 1117
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getId()Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 1223
    :catch_0
    move-exception v0

    .line 1224
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 1120
    :cond_3
    :try_start_1
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 1121
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/f;->a(Ljava/util/List;)I

    .line 1125
    :cond_4
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->getBeacons()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_f

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->getBeacons()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_f

    .line 1126
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->getBeacons()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_5
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    .line 1127
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getMessages()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_5

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/exacttarget/etpushsdk/data/Message;

    .line 1128
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v4

    .line 1129
    if-eqz v4, :cond_6

    .line 1130
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getLastShownDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/exacttarget/etpushsdk/data/Message;->setLastShownDate(Ljava/util/Date;)V

    .line 1131
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getNextAllowedShow()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/exacttarget/etpushsdk/data/Message;->setNextAllowedShow(Ljava/util/Date;)V

    .line 1132
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getShowCount()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/exacttarget/etpushsdk/data/Message;->setShowCount(Ljava/lang/Integer;)V

    .line 1133
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getHasEntered()Ljava/lang/Boolean;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/exacttarget/etpushsdk/data/Message;->setHasEntered(Ljava/lang/Boolean;)V

    .line 1134
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_8

    .line 1135
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodShowCount(Ljava/lang/Integer;)V

    .line 1142
    :cond_6
    :goto_3
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-gtz v4, :cond_7

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-lez v4, :cond_7

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_7

    .line 1143
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setMessagesPerPeriod(Ljava/lang/Integer;)V

    .line 1146
    :cond_7
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/e;->b(Lcom/exacttarget/etpushsdk/data/Message;)V

    .line 1149
    new-instance v4, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    invoke-direct {v4, v0, v1}, Lcom/exacttarget/etpushsdk/data/RegionMessage;-><init>(Lcom/exacttarget/etpushsdk/data/Region;Lcom/exacttarget/etpushsdk/data/Message;)V

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/database/f;->a(Lcom/exacttarget/etpushsdk/data/RegionMessage;)V

    goto :goto_2

    .line 1138
    :cond_8
    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodShowCount(Ljava/lang/Integer;)V

    goto :goto_3

    .line 1152
    :cond_9
    const-string v0, "location_type = ? AND active = ?"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x3

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

    move-result-object v0

    .line 1160
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_a
    :goto_4
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    .line 1161
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->getBeacons()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    move-result v2

    if-nez v2, :cond_a

    .line 1164
    :try_start_2
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/data/Region;->setActive(Ljava/lang/Boolean;)V

    .line 1165
    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/data/Region;->setHasEntered(Ljava/lang/Boolean;)V

    .line 1166
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I

    .line 1168
    new-instance v2, Lcom/radiusnetworks/ibeacon/Region;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getGuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v0

    invoke-direct {v2, v3, v4, v5, v0}, Lcom/radiusnetworks/ibeacon/Region;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V

    .line 1169
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v0, v2}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->stopMonitoringBeaconsInRegion(Lcom/radiusnetworks/ibeacon/Region;)V

    .line 1170
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v0, v2}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->stopRangingBeaconsInRegion(Lcom/radiusnetworks/ibeacon/Region;)V

    .line 1171
    const-string v0, "~!ETLocationManager"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "stopRangingBeacon - {id: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\', uuid: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\', major: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", minor: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v2}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "}"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Landroid/os/RemoteException; {:try_start_2 .. :try_end_2} :catch_1
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0

    goto/16 :goto_4

    .line 1172
    :catch_1
    move-exception v0

    .line 1173
    :try_start_3
    const-string v2, "~!ETLocationManager"

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto/16 :goto_4

    .line 1178
    :cond_b
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/BeaconResponseEvent;->getBeacons()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_5
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_10

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    .line 1179
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v1

    .line 1180
    if-nez v1, :cond_c

    .line 1182
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setActive(Ljava/lang/Boolean;)V

    .line 1183
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Lcom/exacttarget/etpushsdk/data/Region;)V

    move-object v1, v0

    .line 1200
    :goto_6
    new-instance v0, Lcom/radiusnetworks/ibeacon/Region;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getGuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v6

    invoke-direct {v0, v3, v4, v5, v6}, Lcom/radiusnetworks/ibeacon/Region;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_0

    .line 1203
    :try_start_4
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v3}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->getRangedRegions()Ljava/util/Collection;

    move-result-object v3

    invoke-interface {v3, v0}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_e

    .line 1204
    const-string v3, "~!ETLocationManager"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "startRangingBeacon - {id: \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\', uuid: \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\', major: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", minor: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "}"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1205
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v3, v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->startMonitoringBeaconsInRegion(Lcom/radiusnetworks/ibeacon/Region;)V

    .line 1206
    iget-object v3, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v3, v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->startRangingBeaconsInRegion(Lcom/radiusnetworks/ibeacon/Region;)V
    :try_end_4
    .catch Landroid/os/RemoteException; {:try_start_4 .. :try_end_4} :catch_2
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0

    goto/16 :goto_5

    .line 1210
    :catch_2
    move-exception v0

    .line 1211
    :try_start_5
    const-string v3, "~!ETLocationManager"

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1213
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/Region;->setActive(Ljava/lang/Boolean;)V

    .line 1214
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I

    goto/16 :goto_5

    .line 1185
    :cond_c
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getActive()Ljava/lang/Boolean;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/Boolean;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_d

    .line 1186
    new-instance v3, Lcom/radiusnetworks/ibeacon/Region;

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getGuid()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v7

    invoke-direct {v3, v4, v5, v6, v7}, Lcom/radiusnetworks/ibeacon/Region;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V

    .line 1187
    iget-object v4, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->o:Lcom/radiusnetworks/ibeacon/IBeaconManager;

    invoke-virtual {v4}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->getRangedRegions()Ljava/util/Collection;

    move-result-object v4

    invoke-interface {v4, v3}, Ljava/util/Collection;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_d

    .line 1188
    const-string v0, "~!ETLocationManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "alreadyRangingBeacon - {id: \'"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v3}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "\', uuid: \'"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v3}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "\', major: "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v3}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, ", minor: "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v3}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, "}"

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    goto/16 :goto_5

    .line 1193
    :cond_d
    sget-object v3, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v1, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setActive(Ljava/lang/Boolean;)V

    .line 1194
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getGuid()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setGuid(Ljava/lang/String;)V

    .line 1195
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v1, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setMajor(Ljava/lang/Integer;)V

    .line 1196
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/Region;->setMinor(Ljava/lang/Integer;)V

    .line 1197
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I
    :try_end_5
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_0

    goto/16 :goto_6

    .line 1208
    :cond_e
    :try_start_6
    const-string v3, "~!ETLocationManager"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "alreadyMonitoringBeacon2 - {id: \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\', uuid: \'"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "\', major: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, ", minor: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v4, "}"

    invoke-virtual {v0, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v3, v0}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catch Landroid/os/RemoteException; {:try_start_6 .. :try_end_6} :catch_2
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_0

    goto/16 :goto_5

    .line 1219
    :cond_f
    :try_start_7
    const-string v0, "~!ETLocationManager"

    const-string v1, "Empty beacon list from server."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1221
    :cond_10
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h(Z)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_0

    goto/16 :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/GeofenceResponseEvent;)V
    .locals 7

    .prologue
    const/4 v5, 0x1

    .line 985
    const-string v0, "~!ETLocationManager"

    const-string v1, "onEventGeofenceResponse()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 988
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 989
    sget-object v0, Lcom/exacttarget/etpushsdk/ETLocationManager;->e:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-nez v0, :cond_0

    .line 990
    const-string v0, "~!ETLocationManager"

    const-string v1, "No longer watching locations.  Skipping the geoFenceResponseEvent update."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1089
    :goto_0
    return-void

    .line 994
    :cond_0
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/GeofenceResponseEvent;->getRefreshCenter()Lcom/exacttarget/etpushsdk/util/l;

    move-result-object v0

    if-nez v0, :cond_1

    .line 995
    const-string v0, "~!ETLocationManager"

    const-string v1, "Got a bad response from retrieving geofences. Try to get them the next time we get a location."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;)I

    .line 996
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Z)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1086
    :catch_0
    move-exception v0

    .line 1087
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0

    .line 1001
    :cond_1
    const/4 v0, 0x0

    const/4 v1, 0x0

    const/4 v2, 0x0

    const/4 v3, 0x0

    const/4 v4, 0x0

    :try_start_1
    invoke-static {v0, v1, v2, v3, v4}, Lcom/exacttarget/etpushsdk/database/f;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1008
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 1009
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_2
    :goto_1
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    .line 1010
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getRegion()Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v3

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v3

    .line 1011
    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Region;->getLocationType()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Integer;->intValue()I

    move-result v3

    if-ne v3, v5, :cond_2

    .line 1012
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getId()Ljava/lang/Integer;

    move-result-object v0

    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 1015
    :cond_3
    invoke-interface {v1}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 1016
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/f;->a(Ljava/util/List;)I

    .line 1020
    :cond_4
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

    move-result-object v0

    .line 1027
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->n:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Ljava/util/List;)V

    .line 1030
    const-string v0, "location_type = ?"

    .line 1031
    const/4 v1, 0x1

    new-array v1, v1, [Ljava/lang/String;

    const/4 v2, 0x0

    const/4 v3, 0x1

    invoke-static {v3}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v3

    aput-object v3, v1, v2

    .line 1033
    new-instance v2, Landroid/content/ContentValues;

    invoke-direct {v2}, Landroid/content/ContentValues;-><init>()V

    .line 1034
    const-string v3, "active"

    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 1036
    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I

    .line 1043
    const-string v0, "~~m@g1c_f3nc3~~"

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v0

    .line 1044
    if-nez v0, :cond_5

    .line 1045
    new-instance v0, Lcom/exacttarget/etpushsdk/data/Region;

    invoke-direct {v0}, Lcom/exacttarget/etpushsdk/data/Region;-><init>()V

    .line 1046
    const-string v1, "~~m@g1c_f3nc3~~"

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setId(Ljava/lang/String;)V

    .line 1049
    :cond_5
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setActive(Ljava/lang/Boolean;)V

    .line 1050
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/GeofenceResponseEvent;->getRefreshCenter()Lcom/exacttarget/etpushsdk/util/l;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setCenter(Lcom/exacttarget/etpushsdk/util/l;)V

    .line 1051
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/GeofenceResponseEvent;->getRefreshRadius()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setRadius(Ljava/lang/Integer;)V

    .line 1052
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->b(Lcom/exacttarget/etpushsdk/data/Region;)V

    .line 1055
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/GeofenceResponseEvent;->getFences()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_6
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_b

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/Region;

    .line 1056
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setActive(Ljava/lang/Boolean;)V

    .line 1057
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v1

    .line 1058
    if-eqz v1, :cond_7

    .line 1059
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/data/Region;->setEntryCount(Ljava/lang/Integer;)V

    .line 1060
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getExitCount()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setExitCount(Ljava/lang/Integer;)V

    .line 1062
    :cond_7
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->b(Lcom/exacttarget/etpushsdk/data/Region;)V

    .line 1063
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getMessages()Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_6

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/exacttarget/etpushsdk/data/Message;

    .line 1064
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v4

    .line 1065
    if-eqz v4, :cond_8

    .line 1066
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getLastShownDate()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/exacttarget/etpushsdk/data/Message;->setLastShownDate(Ljava/util/Date;)V

    .line 1067
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getNextAllowedShow()Ljava/util/Date;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/exacttarget/etpushsdk/data/Message;->setNextAllowedShow(Ljava/util/Date;)V

    .line 1068
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getShowCount()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1, v5}, Lcom/exacttarget/etpushsdk/data/Message;->setShowCount(Ljava/lang/Integer;)V

    .line 1069
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_a

    .line 1070
    invoke-virtual {v4}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodShowCount()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodShowCount(Ljava/lang/Integer;)V

    .line 1076
    :cond_8
    :goto_3
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getMessagesPerPeriod()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-gtz v4, :cond_9

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getNumberOfPeriods()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    if-lez v4, :cond_9

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Message;->getPeriodType()Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/Integer;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_9

    .line 1077
    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setMessagesPerPeriod(Ljava/lang/Integer;)V

    .line 1079
    :cond_9
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/e;->b(Lcom/exacttarget/etpushsdk/data/Message;)V

    .line 1081
    new-instance v4, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    invoke-direct {v4, v0, v1}, Lcom/exacttarget/etpushsdk/data/RegionMessage;-><init>(Lcom/exacttarget/etpushsdk/data/Region;Lcom/exacttarget/etpushsdk/data/Message;)V

    invoke-static {v4}, Lcom/exacttarget/etpushsdk/database/f;->a(Lcom/exacttarget/etpushsdk/data/RegionMessage;)V

    goto :goto_2

    .line 1073
    :cond_a
    const/4 v4, 0x0

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/exacttarget/etpushsdk/data/Message;->setPeriodShowCount(Ljava/lang/Integer;)V

    goto :goto_3

    .line 1084
    :cond_b
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Z)V

    .line 1085
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->n:Lcom/exacttarget/etpushsdk/ETLocationManager$c;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager$c;->a(Lcom/exacttarget/etpushsdk/ETLocationManager$c;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;)V
    .locals 6

    .prologue
    .line 894
    const-string v0, "~!ETLocationManager"

    const-string v1, "onEventLocationChanged()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 897
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 898
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getTime()J

    move-result-wide v2

    sub-long/2addr v0, v2

    const-wide/32 v2, 0xdbba0

    cmp-long v0, v0, v2

    if-gez v0, :cond_1

    .line 900
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    if-eqz v0, :cond_0

    .line 901
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->j:Landroid/app/AlarmManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager;->k:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/app/AlarmManager;->cancel(Landroid/app/PendingIntent;)V

    .line 903
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_last_location_latitude"

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 904
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->a()Landroid/content/Context;

    move-result-object v0

    const-string v1, "et_last_location_longitude"

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/exacttarget/etpushsdk/util/d;->a(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V

    .line 906
    const-string v0, "~!ETLocationManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Provider: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getProvider()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", Lat: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", Lon: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", Accuracy: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v2

    invoke-virtual {v2}, Landroid/location/Location;->getAccuracy()F

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", Timestamp: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    new-instance v2, Ljava/util/Date;

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;->getLocation()Landroid/location/Location;

    move-result-object v3

    invoke-virtual {v3}, Landroid/location/Location;->getTime()J

    move-result-wide v4

    invoke-direct {v2, v4, v5}, Ljava/util/Date;-><init>(J)V

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 907
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/exacttarget/etpushsdk/d;

    invoke-direct {v1, p0, p1}, Lcom/exacttarget/etpushsdk/d;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    .line 982
    :goto_0
    return-void

    .line 977
    :cond_1
    const-string v0, "~!ETLocationManager"

    const-string v1, "stale location, older than 15 minutes."

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 979
    :catch_0
    move-exception v0

    .line 980
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public onEvent(Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;)V
    .locals 4

    .prologue
    .line 873
    :try_start_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->c()V

    .line 874
    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->getId()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/d;->a(I)I

    move-result v0

    .line 876
    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 877
    const-string v0, "~!ETLocationManager"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "removed locationupdate id: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/exacttarget/etpushsdk/event/LocationUpdateEvent;->getId()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 884
    :goto_0
    return-void

    .line 879
    :cond_0
    const-string v1, "~!ETLocationManager"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Error: rowsUpdated = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 881
    :catch_0
    move-exception v0

    .line 882
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public declared-synchronized startWatchingLocation()V
    .locals 1

    .prologue
    .line 246
    monitor-enter p0

    const/4 v0, 0x1

    :try_start_0
    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 247
    monitor-exit p0

    return-void

    .line 246
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public startWatchingProximity()Z
    .locals 1

    .prologue
    .line 413
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Z)Z

    move-result v0

    return v0
.end method

.method public declared-synchronized stopWatchingLocation()V
    .locals 1

    .prologue
    .line 517
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->c(Z)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 518
    monitor-exit p0

    return-void

    .line 517
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public stopWatchingProximity()V
    .locals 1

    .prologue
    .line 598
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d(Z)V

    .line 599
    return-void
.end method
