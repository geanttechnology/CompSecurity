.class Lcom/newrelic/agent/android/AndroidAgentImpl$2;
.super Ljava/lang/Object;
.source "AndroidAgentImpl.java"

# interfaces
.implements Landroid/location/LocationListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/newrelic/agent/android/AndroidAgentImpl;->addLocationListener()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/newrelic/agent/android/AndroidAgentImpl;


# direct methods
.method constructor <init>(Lcom/newrelic/agent/android/AndroidAgentImpl;)V
    .locals 0

    .prologue
    .line 738
    iput-object p1, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$2;->this$0:Lcom/newrelic/agent/android/AndroidAgentImpl;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLocationChanged(Landroid/location/Location;)V
    .locals 1
    .param p1, "location"    # Landroid/location/Location;

    .prologue
    .line 742
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$2;->this$0:Lcom/newrelic/agent/android/AndroidAgentImpl;

    # invokes: Lcom/newrelic/agent/android/AndroidAgentImpl;->isAccurate(Landroid/location/Location;)Z
    invoke-static {v0, p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->access$000(Lcom/newrelic/agent/android/AndroidAgentImpl;Landroid/location/Location;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 743
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$2;->this$0:Lcom/newrelic/agent/android/AndroidAgentImpl;

    invoke-virtual {v0, p1}, Lcom/newrelic/agent/android/AndroidAgentImpl;->setLocation(Landroid/location/Location;)V

    .line 745
    :cond_0
    return-void
.end method

.method public onProviderDisabled(Ljava/lang/String;)V
    .locals 1
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 749
    const-string v0, "passive"

    if-ne p1, v0, :cond_0

    .line 750
    iget-object v0, p0, Lcom/newrelic/agent/android/AndroidAgentImpl$2;->this$0:Lcom/newrelic/agent/android/AndroidAgentImpl;

    # invokes: Lcom/newrelic/agent/android/AndroidAgentImpl;->removeLocationListener()V
    invoke-static {v0}, Lcom/newrelic/agent/android/AndroidAgentImpl;->access$100(Lcom/newrelic/agent/android/AndroidAgentImpl;)V

    .line 751
    :cond_0
    return-void
.end method

.method public onProviderEnabled(Ljava/lang/String;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;

    .prologue
    .line 755
    return-void
.end method

.method public onStatusChanged(Ljava/lang/String;ILandroid/os/Bundle;)V
    .locals 0
    .param p1, "provider"    # Ljava/lang/String;
    .param p2, "status"    # I
    .param p3, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 759
    return-void
.end method
