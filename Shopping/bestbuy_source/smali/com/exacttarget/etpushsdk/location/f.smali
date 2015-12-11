.class Lcom/exacttarget/etpushsdk/location/f;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/location/LocationListener;


# instance fields
.field final synthetic a:Lcom/exacttarget/etpushsdk/location/e;


# direct methods
.method constructor <init>(Lcom/exacttarget/etpushsdk/location/e;)V
    .locals 0

    .prologue
    .line 146
    iput-object p1, p0, Lcom/exacttarget/etpushsdk/location/f;->a:Lcom/exacttarget/etpushsdk/location/e;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLocationChanged(Landroid/location/Location;)V
    .locals 4

    .prologue
    .line 148
    const-string v0, "~!ld"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Single Location Update Received: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ","

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/exacttarget/etpushsdk/util/m;->a(Ljava/lang/String;Ljava/lang/String;)I

    .line 149
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/f;->a:Lcom/exacttarget/etpushsdk/location/e;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/location/e;->a:Landroid/location/LocationListener;

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    .line 150
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/f;->a:Lcom/exacttarget/etpushsdk/location/e;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/location/e;->a:Landroid/location/LocationListener;

    invoke-interface {v0, p1}, Landroid/location/LocationListener;->onLocationChanged(Landroid/location/Location;)V

    .line 152
    :cond_0
    iget-object v0, p0, Lcom/exacttarget/etpushsdk/location/f;->a:Lcom/exacttarget/etpushsdk/location/e;

    iget-object v0, v0, Lcom/exacttarget/etpushsdk/location/e;->b:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/exacttarget/etpushsdk/location/f;->a:Lcom/exacttarget/etpushsdk/location/e;

    iget-object v1, v1, Lcom/exacttarget/etpushsdk/location/e;->e:Landroid/location/LocationListener;

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 153
    return-void
.end method

.method public onProviderDisabled(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 162
    return-void
.end method

.method public onProviderEnabled(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 159
    return-void
.end method

.method public onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 156
    return-void
.end method
