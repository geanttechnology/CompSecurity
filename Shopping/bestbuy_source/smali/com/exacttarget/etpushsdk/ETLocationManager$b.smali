.class Lcom/exacttarget/etpushsdk/ETLocationManager$b;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Lcom/radiusnetworks/ibeacon/IBeaconConsumer;
.implements Lcom/radiusnetworks/ibeacon/MonitorNotifier;
.implements Lcom/radiusnetworks/ibeacon/RangeNotifier;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETLocationManager;


# direct methods
.method private constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;)V
    .locals 0

    .prologue
    .line 1510
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;Lcom/exacttarget/etpushsdk/c;)V
    .locals 0

    .prologue
    .line 1510
    invoke-direct {p0, p1}, Lcom/exacttarget/etpushsdk/ETLocationManager$b;-><init>(Lcom/exacttarget/etpushsdk/ETLocationManager;)V

    return-void
.end method


# virtual methods
.method public bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z
    .locals 2

    .prologue
    .line 1533
    const-string v0, "~!IBeaconMonitor"

    const-string v1, "bindService"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1534
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p1, p2, p3}, Landroid/content/Context;->bindService(Landroid/content/Intent;Landroid/content/ServiceConnection;I)Z

    move-result v0

    return v0
.end method

.method public didDetermineStateForRegion(ILcom/radiusnetworks/ibeacon/Region;)V
    .locals 3

    .prologue
    .line 1551
    const-string v0, "~!IBeaconMonitor"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "BeaconState - {state: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", id: \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', uuid: \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', major: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", minor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1552
    return-void
.end method

.method public didEnterRegion(Lcom/radiusnetworks/ibeacon/Region;)V
    .locals 4

    .prologue
    .line 1556
    const-string v0, "~!IBeaconMonitor"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "didEnterRegion - {id: \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', uuid: \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', major: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", minor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1558
    :try_start_0
    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v0

    .line 1559
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/Integer;->intValue()I

    move-result v1

    add-int/lit8 v1, v1, 0x1

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setEntryCount(Ljava/lang/Integer;)V

    .line 1560
    sget-object v1, Ljava/lang/Boolean;->TRUE:Ljava/lang/Boolean;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/data/Region;->setHasEntered(Ljava/lang/Boolean;)V

    .line 1561
    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I

    .line 1562
    const-string v1, "~!IBeaconMonitor"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Beacon: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", EntryCount: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1564
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 1565
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(Ljava/lang/String;Z)V

    .line 1568
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v2, Lcom/exacttarget/etpushsdk/event/BeaconRegionEnterEvent;

    invoke-direct {v2, v0}, Lcom/exacttarget/etpushsdk/event/BeaconRegionEnterEvent;-><init>(Lcom/exacttarget/etpushsdk/data/Region;)V

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 1572
    :goto_0
    return-void

    .line 1569
    :catch_0
    move-exception v0

    .line 1570
    const-string v1, "~!IBeaconMonitor"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    goto :goto_0
.end method

.method public didExitRegion(Lcom/radiusnetworks/ibeacon/Region;)V
    .locals 6

    .prologue
    .line 1576
    const-string v0, "~!IBeaconMonitor"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "didExitRegion - {id: \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', uuid: \'"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\', major: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", minor: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "}"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1580
    :try_start_0
    invoke-virtual {p1}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v1

    .line 1581
    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getExitCount()Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Integer;->intValue()I

    move-result v0

    add-int/lit8 v0, v0, 0x1

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/Region;->setExitCount(Ljava/lang/Integer;)V

    .line 1582
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v1, v0}, Lcom/exacttarget/etpushsdk/data/Region;->setHasEntered(Ljava/lang/Boolean;)V

    .line 1583
    invoke-static {v1}, Lcom/exacttarget/etpushsdk/database/g;->c(Lcom/exacttarget/etpushsdk/data/Region;)I

    .line 1584
    const-string v0, "~!IBeaconMonitor"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Beacon: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", ExitCount: "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getEntryCount()Ljava/lang/Integer;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v2}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1587
    const-string v0, "region_id = ?"

    .line 1588
    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v3, 0x0

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v2, v3

    .line 1589
    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    invoke-static {v0, v2, v3, v4, v5}, Lcom/exacttarget/etpushsdk/database/f;->a(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1596
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/data/RegionMessage;

    .line 1597
    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/RegionMessage;->getMessage()Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/data/Message;->getId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/database/e;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Message;

    move-result-object v3

    .line 1598
    sget-object v0, Ljava/lang/Boolean;->FALSE:Ljava/lang/Boolean;

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Message;->setHasEntered(Ljava/lang/Boolean;)V

    .line 1599
    const-wide/16 v4, 0x0

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Message;->setEntryTime(Ljava/lang/Long;)V

    .line 1600
    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Message;->getEphemeralMessage()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Message;->getNotifyId()Ljava/lang/Integer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 1601
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v0

    const-string v4, "notification"

    invoke-virtual {v0, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/NotificationManager;

    .line 1602
    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Message;->getNotifyId()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v4

    invoke-virtual {v0, v4}, Landroid/app/NotificationManager;->cancel(I)V

    .line 1603
    const/4 v0, 0x0

    invoke-virtual {v3, v0}, Lcom/exacttarget/etpushsdk/data/Message;->setNotifyId(Ljava/lang/Integer;)V

    .line 1605
    :cond_0
    invoke-static {v3}, Lcom/exacttarget/etpushsdk/database/e;->c(Lcom/exacttarget/etpushsdk/data/Message;)I
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1613
    :catch_0
    move-exception v0

    .line 1614
    const-string v1, "~!IBeaconMonitor"

    invoke-virtual {v0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2, v0}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1616
    :goto_1
    return-void

    .line 1608
    :cond_1
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/d;->f()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1609
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a()Lcom/exacttarget/etpushsdk/ETAnalytics;

    move-result-object v0

    invoke-virtual {v1}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/ETAnalytics;->a(Ljava/lang/String;)V

    .line 1612
    :cond_2
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    new-instance v2, Lcom/exacttarget/etpushsdk/event/BeaconRegionExitEvent;

    invoke-direct {v2, v1}, Lcom/exacttarget/etpushsdk/event/BeaconRegionExitEvent;-><init>(Lcom/exacttarget/etpushsdk/data/Region;)V

    invoke-virtual {v0, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1
.end method

.method public didRangeBeaconsInRegion(Ljava/util/Collection;Lcom/radiusnetworks/ibeacon/Region;)V
    .locals 10

    .prologue
    .line 1624
    :try_start_0
    invoke-interface {p1}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    :goto_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lcom/radiusnetworks/ibeacon/IBeacon;

    move-object v6, v0

    .line 1625
    const-string v2, "~!IBeaconMonitor"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "didRangeBeaconsInRegion - {proximity: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v6}, Lcom/radiusnetworks/ibeacon/IBeacon;->getProximity()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", id: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\', uuid: \'"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getProximityUuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\', major: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getMajor()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, ", minor: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getMinor()Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "}"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1627
    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Lcom/exacttarget/etpushsdk/database/g;->a(Ljava/lang/String;)Lcom/exacttarget/etpushsdk/data/Region;

    move-result-object v3

    .line 1628
    if-eqz v3, :cond_0

    .line 1629
    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Region;->getHasEntered()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1630
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETPush;->getInstance()Lcom/exacttarget/etpushsdk/ETPush;

    move-result-object v2

    invoke-virtual {p2}, Lcom/radiusnetworks/ibeacon/Region;->getUniqueId()Ljava/lang/String;

    move-result-object v4

    const/4 v5, -0x1

    invoke-virtual {v6}, Lcom/radiusnetworks/ibeacon/IBeacon;->getProximity()I

    move-result v7

    invoke-virtual {v2, v4, v5, v7}, Lcom/exacttarget/etpushsdk/ETPush;->a(Ljava/lang/String;II)V

    .line 1631
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v9

    new-instance v2, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;

    invoke-virtual {v6}, Lcom/radiusnetworks/ibeacon/IBeacon;->getProximity()I

    move-result v4

    invoke-virtual {v6}, Lcom/radiusnetworks/ibeacon/IBeacon;->getRssi()I

    move-result v5

    invoke-virtual {v6}, Lcom/radiusnetworks/ibeacon/IBeacon;->getAccuracy()D

    move-result-wide v6

    invoke-direct/range {v2 .. v7}, Lcom/exacttarget/etpushsdk/event/BeaconRegionRangeEvent;-><init>(Lcom/exacttarget/etpushsdk/data/Region;IID)V

    invoke-virtual {v9, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Object;)V
    :try_end_0
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 1638
    :catch_0
    move-exception v2

    .line 1639
    const-string v3, "~!IBeaconMonitor"

    invoke-virtual {v2}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4, v2}, Lcom/exacttarget/etpushsdk/util/m;->c(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 1641
    :cond_1
    return-void

    .line 1633
    :cond_2
    :try_start_1
    const-string v2, "~!IBeaconMonitor"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Ranged region "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v3}, Lcom/exacttarget/etpushsdk/data/Region;->getId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " but monitoring hasn\'t yet entered"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_0
.end method

.method public getApplicationContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 1539
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e(Lcom/exacttarget/etpushsdk/ETLocationManager;)Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public onIBeaconServiceConnect()V
    .locals 3

    .prologue
    .line 1515
    const-string v0, "~!IBeaconMonitor"

    const-string v1, "onIBeaconServiceConnect"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1516
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->setMonitorNotifier(Lcom/radiusnetworks/ibeacon/MonitorNotifier;)V

    .line 1517
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->setRangeNotifier(Lcom/radiusnetworks/ibeacon/RangeNotifier;)V

    .line 1519
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->k()Ljava/lang/Boolean;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->f()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 1521
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Z)Z

    .line 1524
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v0

    const-class v1, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/util/EventBus;->a(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;

    .line 1525
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/event/BackgroundEvent;->isInBackground()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1526
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    move-result-object v1

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->setBackgroundMode(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;Z)Z

    .line 1529
    :cond_2
    return-void
.end method

.method public unbindService(Landroid/content/ServiceConnection;)V
    .locals 2

    .prologue
    .line 1544
    const-string v0, "~!IBeaconMonitor"

    const-string v1, "unbindService"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 1545
    invoke-virtual {p0}, Lcom/exacttarget/etpushsdk/ETLocationManager$b;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/content/Context;->unbindService(Landroid/content/ServiceConnection;)V

    .line 1546
    return-void
.end method
