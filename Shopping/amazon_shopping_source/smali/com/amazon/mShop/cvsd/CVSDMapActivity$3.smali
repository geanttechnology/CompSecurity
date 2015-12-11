.class Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;
.super Ljava/lang/Object;
.source "CVSDMapActivity.java"

# interfaces
.implements Landroid/location/LocationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation()V
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
    .line 294
    iput-object p1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    iput-object p2, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;->val$locationManager:Landroid/location/LocationManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLocationChanged(Landroid/location/Location;)V
    .locals 2
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    .line 298
    if-eqz p1, :cond_0

    .line 299
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # invokes: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocation(Landroid/location/Location;)V
    invoke-static {v0, p1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$200(Lcom/amazon/mShop/cvsd/CVSDMapActivity;Landroid/location/Location;)V

    .line 303
    iget-object v0, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;->val$locationManager:Landroid/location/LocationManager;

    iget-object v1, p0, Lcom/amazon/mShop/cvsd/CVSDMapActivity$3;->this$0:Lcom/amazon/mShop/cvsd/CVSDMapActivity;

    # getter for: Lcom/amazon/mShop/cvsd/CVSDMapActivity;->flyToCurrentLocationLocationListener:Landroid/location/LocationListener;
    invoke-static {v1}, Lcom/amazon/mShop/cvsd/CVSDMapActivity;->access$300(Lcom/amazon/mShop/cvsd/CVSDMapActivity;)Landroid/location/LocationListener;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->removeUpdates(Landroid/location/LocationListener;)V

    .line 305
    :cond_0
    return-void
.end method

.method public onProviderDisabled(Ljava/lang/String;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 317
    return-void
.end method

.method public onProviderEnabled(Ljava/lang/String;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 313
    return-void
.end method

.method public onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;
    .param p2, "status"    # I
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 309
    return-void
.end method
