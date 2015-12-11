.class Lcom/exacttarget/etpushsdk/location/d;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/location/c;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/location/c;)V
    .locals 0

    .prologue
    .line 69
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/location/d;->a:Lcom/exacttarget/etpushsdk/location/c;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3

    .prologue
    .line 72
    const-string v0, "~!lc"

    const-string v1, "onReceive()"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 75
    :try_start_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/d;->a:Lcom/exacttarget/etpushsdk/location/c;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/location/c;->f:Landroid/content/BroadcastReceiver;

    invoke-virtual {p1, v0}, Landroid/content/Context;->unregisterReceiver(Landroid/content/BroadcastReceiver;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 82
    :try_start_1
    invoke-static {}, Lcom/exacttarget/etpushsdk/ETLocationManager;->getInstance()Lcom/exacttarget/etpushsdk/ETLocationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->g()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 84
    const-string v0, "location"

    .line 85
    invoke-virtual {p2}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/Location;

    .line 87
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/d;->a:Lcom/exacttarget/etpushsdk/location/c;

    iget-object v1, v1, Lcom/exacttarget/etpushsdk/location/c;->b:Landroid/location/LocationListener;

    if-eqz v1, :cond_0

    if-eqz v0, :cond_0

    .line 88
    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/d;->a:Lcom/exacttarget/etpushsdk/location/c;

    iget-object v1, v1, Lcom/exacttarget/etpushsdk/location/c;->b:Landroid/location/LocationListener;

    invoke-interface {v1, v0}, Landroid/location/LocationListener;->onLocationChanged(Landroid/location/Location;)V

    .line 91
    :cond_0
    invoke-static {}, Lcom/exacttarget/etpushsdk/util/EventBus;->getInstance()Lcom/exacttarget/etpushsdk/util/EventBus;

    move-result-object v1

    new-instance v2, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;

    invoke-direct {v2, v0}, Lcom/exacttarget/etpushsdk/event/LastKnownLocationEvent;-><init>(Landroid/location/Location;)V

    invoke-virtual {v1, v2}, Lcom/exacttarget/etpushsdk/util/EventBus;->b(Ljava/lang/Object;)V

    .line 94
    :cond_1
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/d;->a:Lcom/exacttarget/etpushsdk/location/c;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/location/c;->c:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/d;->a:Lcom/exacttarget/etpushsdk/location/c;

    iget-object v1, v1, Lcom/exacttarget/etpushsdk/location/c;->a:Landroid/app/PendingIntent;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/app/PendingIntent;)V
    :try_end_1
    .catch Lcom/exacttarget/etpushsdk/ETException; {:try_start_1 .. :try_end_1} :catch_1

    .line 98
    :goto_0
    return-void

    .line 76
    :catch_0
    move-exception v0

    .line 77
    const-string v1, "~!lc"

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 95
    :catch_1
    move-exception v0

    .line 96
    const-string v1, "~!lc"

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETException;->getMessage()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/exacttarget/etpushsdk/util/m;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
