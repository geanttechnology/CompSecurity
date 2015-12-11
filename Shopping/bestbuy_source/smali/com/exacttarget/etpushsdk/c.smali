.class Lcom/exacttarget/etpushsdk/c;
.super Landroid/content/BroadcastReceiver;
.source "SourceFile"


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/ETLocationManager;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/ETLocationManager;)V
    .locals 0

    .prologue
    .line 129
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, -0x1

    .line 132
    const-string v0, "android.bluetooth.adapter.action.STATE_CHANGED"

    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 133
    const-string v0, "android.bluetooth.adapter.extra.STATE"

    invoke-virtual {p2, v0, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    const/16 v1, 0xa

    if-ne v0, v1, :cond_1

    .line 134
    const-string v0, "~!ETLocationManager"

    const-string v1, "Bluetooth OFF"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 135
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 136
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/ETLocationManager;->d(Z)V

    .line 152
    :cond_0
    :goto_0
    return-void

    .line 139
    :cond_1
    const-string v0, "android.bluetooth.adapter.extra.STATE"

    invoke-virtual {p2, v0, v2}, Landroid/content/Intent;->getIntExtra(Ljava/lang/String;I)I

    move-result v0

    const/16 v1, 0xc

    if-ne v0, v1, :cond_0

    .line 140
    const-string v0, "~!ETLocationManager"

    const-string v1, "Bluetooth ON"

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 141
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->e()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 142
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->isBound(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 143
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->h(Z)V

    .line 144
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v0}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/radiusnetworks/ibeacon/IBeaconManager;

    move-result-object v0

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-static {v1}, Lcom/exacttarget/etpushsdk/ETLocationManager;->a(Lcom/exacttarget/etpushsdk/ETLocationManager;)Lcom/exacttarget/etpushsdk/ETLocationManager$b;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/radiusnetworks/ibeacon/IBeaconManager;->bind(Lcom/radiusnetworks/ibeacon/IBeaconConsumer;)V

    goto :goto_0

    .line 147
    :cond_2
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/c;->a:Lcom/exacttarget/etpushsdk/ETLocationManager;

    invoke-virtual {v0, v3}, Lcom/exacttarget/etpushsdk/ETLocationManager;->b(Z)Z

    goto :goto_0
.end method
