.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/location/LocationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

.field final synthetic val$locationManager:Landroid/location/LocationManager;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/location/LocationManager;)V
    .locals 0

    .prologue
    .line 445
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    iput-object p2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;->val$locationManager:Landroid/location/LocationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLocationChanged(Landroid/location/Location;)V
    .locals 5
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    .line 449
    if-eqz p1, :cond_0

    .line 450
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation(Landroid/location/Location;)V
    invoke-static {v0, p1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$200(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/location/Location;)V

    .line 451
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v1, v2, v3}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v3

    invoke-virtual {v2, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ""

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchDeliveryLocationByCurrentLocation(Ljava/lang/String;Ljava/lang/String;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$600(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Ljava/lang/String;Ljava/lang/String;)V

    .line 455
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;->val$locationManager:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$7;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->searchByCurrentLocationLocationListener:Landroid/location/LocationListener;
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$700(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/location/LocationListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 457
    :cond_0
    return-void
.end method

.method public onProviderDisabled(Ljava/lang/String;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 469
    return-void
.end method

.method public onProviderEnabled(Ljava/lang/String;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 465
    return-void
.end method

.method public onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;
    .param p2, "status"    # I
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 461
    return-void
.end method
