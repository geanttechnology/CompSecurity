.class Lcom/exacttarget/etpushsdk/g;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Ljava/lang/Runnable;


# instance fields
.field final synthetic a:Z

.field final synthetic b:Lcom/exacttarget/etpushsdk/ETLocationManager;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)V
    .locals 0

    .prologue
    .line 449
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    iput-boolean p2, p0, Lcom/exacttarget/etpushsdk/g;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 452
    const-string v0, "~!ETLocationManager"

    const-string v1, "proximityStateThread start started"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 455
    :try_start_0
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/g;->a:Z

    if-eqz v0, :cond_0

    .line 456
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->g(Z)V

    .line 459
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 461
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h(Z)V

    .line 463
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->g(Lcom/exacttarget/etpushsdk/ETLocationManager;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 464
    new-instance v0, Landroid/content/IntentFilter;

    const-string v1, "android.bluetooth.adapter.action.STATE_CHANGED"

    invoke-direct {v0, v1}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    .line 465
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/BroadcastReceiver;

    move-result-object v2

    invoke-virtual {v1, v2, v0}, Landroid/content/Context;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 466
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;Z)Z

    .line 470
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->isBound(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 471
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->bind(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)V

    .line 475
    :goto_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/ProximityStatusEvent;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/event/ProximityStatusEvent;-><init>(Z)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 480
    :cond_2
    const-string v0, "~!ETLocationManager"

    const-string v1, "proximityStateThread start ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 481
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 483
    :goto_1
    return-void

    .line 473
    :cond_3
    :try_start_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/g;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f(Lcom/exacttarget/etpushsdk/ETLocationManager;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 477
    :catch_0
    move-exception v0

    .line 478
    :try_start_2
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 480
    const-string v0, "~!ETLocationManager"

    const-string v1, "proximityStateThread start ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 481
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto :goto_1

    .line 480
    :catchall_0
    move-exception v0

    const-string v1, "~!ETLocationManager"

    const-string v2, "proximityStateThread start ended"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 481
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i()Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0
.end method
