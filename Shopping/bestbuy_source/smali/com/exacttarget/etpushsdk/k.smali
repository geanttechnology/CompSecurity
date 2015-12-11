.class Lcom/exacttarget/etpushsdk/k;
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
    .line 616
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    iput-boolean p2, p0, Lcom/exacttarget/etpushsdk/k;->a:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 619
    const-string v0, "~!ETLocationManager"

    const-string v1, "proximityStateThread stop started"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 622
    :try_start_0
    iget-boolean v0, p0, Lcom/exacttarget/etpushsdk/k;->a:Z

    if-eqz v0, :cond_0

    .line 623
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->g(Z)V

    .line 627
    :cond_0
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 628
    const-string v1, "active"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 629
    const-string v1, "has_entered"

    const/4 v2, 0x0

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Integer;)V

    .line 631
    const-string v1, "location_type = ?"

    .line 632
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    const/4 v4, 0x3

    invoke-static {v4}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 633
    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I

    .line 639
    new-instance v0, Landroid/content/ContentValues;

    invoke-direct {v0}, Landroid/content/ContentValues;-><init>()V

    .line 640
    const-string v1, "has_entered"

    sget-object v2, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1, v2}, Landroid/content/ContentValues;->put(Ljava/lang/String;Ljava/lang/Boolean;)V

    .line 641
    const/4 v1, 0x0

    const/4 v2, 0x0

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;[Ljava/lang/String;Landroid/content/ContentValues;)I

    .line 647
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->getMonitoredRegions()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/radiusnetworks/ibeacon/Region;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 649
    :try_start_1
    const-string v2, "~!ETLocationManager"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "stopMonitoringBeaconRegion: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 650
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->stopMonitoringBeaconsInRegion(Lcom/radiusnetworks/ibeacon/Region;)V
    :try_end_1
    .catch Landroid/os/RemoteException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 651
    :catch_0
    move-exception v0

    .line 652
    :try_start_2
    const-string v2, "~!ETLocationManager"

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 677
    :catch_1
    move-exception v0

    .line 678
    :try_start_3
    const-string v1, "~!ETLocationManager"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 680
    const-string v0, "~!ETLocationManager"

    const-string v1, "proximityStateThread stop ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 681
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    .line 683
    :goto_1
    return-void

    .line 655
    :cond_1
    :try_start_4
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->getRangedRegions()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/radiusnetworks/ibeacon/Region;
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_1
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 657
    :try_start_5
    const-string v2, "~!ETLocationManager"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "stopRangingBeaconRegion: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 658
    iget-object v2, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v2

    invoke-virtual {v2, v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->stopRangingBeaconsInRegion(Lcom/radiusnetworks/ibeacon/Region;)V
    :try_end_5
    .catch Landroid/os/RemoteException; {:try_start_5 .. :try_end_5} :catch_2
    .catch Ljava/lang/Exception; {:try_start_5 .. :try_end_5} :catch_1
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto :goto_2

    .line 659
    :catch_2
    move-exception v0

    .line 660
    :try_start_6
    const-string v2, "~!ETLocationManager"

    invoke-virtual {v0}, Landroid/os/RemoteException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_1
    .catchall {:try_start_6 .. :try_end_6} :catchall_0

    goto :goto_2

    .line 680
    :catchall_0
    move-exception v0

    const-string v1, "~!ETLocationManager"

    const-string v2, "proximityStateThread stop ended"

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 681
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i()Ljava/util/concurrent/CountDownLatch;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    throw v0

    .line 663
    :cond_2
    :try_start_7
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->getMonitoredRegions()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v0

    if-lez v0, :cond_3

    .line 664
    const-string v0, "~!ETLocationManager"

    const-string v1, "currentlyMonitoredRegions SHOULD BE ZERO!!!"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 666
    :cond_3
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->getRangedRegions()Ljava/util/Collection;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Collection;->size()I

    move-result v0

    if-lez v0, :cond_4

    .line 667
    const-string v0, "~!ETLocationManager"

    const-string v1, "rangedRegions SHOULD BE ZERO!!!"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 670
    :cond_4
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->isBound(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 671
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->unBind(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)V

    .line 674
    :cond_5
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/k;->b:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i(Lcom/exacttarget/etpushsdk/ETLocationManager;)V

    .line 675
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v1, Lcom/exacttarget/etpushsdk/event/ProximityStatusEvent;

    const/4 v2, 0x0

    invoke-direct {v1, v2}, Lcom/exacttarget/etpushsdk/event/ProximityStatusEvent;-><init>(Z)V

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_7
    .catch Ljava/lang/Exception; {:try_start_7 .. :try_end_7} :catch_1
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 680
    const-string v0, "~!ETLocationManager"

    const-string v1, "proximityStateThread stop ended"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 681
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->i()Ljava/util/concurrent/CountDownLatch;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/concurrent/CountDownLatch;->countDown()V

    goto/16 :goto_1
.end method
