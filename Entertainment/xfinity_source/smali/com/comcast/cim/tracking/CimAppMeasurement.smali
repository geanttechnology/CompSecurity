.class public abstract Lcom/comcast/cim/tracking/CimAppMeasurement;
.super Ljava/lang/Object;
.source "CimAppMeasurement.java"


# instance fields
.field private cdata:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/app/Application;Ljava/lang/String;Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;Lcom/comcast/cim/android/PropertyService;)V
    .locals 1
    .param p1, "currentApplication"    # Landroid/app/Application;
    .param p2, "applicationVersion"    # Ljava/lang/String;
    .param p3, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;
    .param p4, "propertyService"    # Lcom/comcast/cim/android/PropertyService;

    .prologue
    .line 18
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 15
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/comcast/cim/tracking/CimAppMeasurement;->cdata:Ljava/util/HashMap;

    .line 19
    invoke-static {p1}, Lcom/adobe/mobile/Config;->setContext(Landroid/content/Context;)V

    .line 20
    invoke-interface {p4}, Lcom/comcast/cim/android/PropertyService;->getOmnitureDebug()Z

    move-result v0

    invoke-static {v0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v0

    invoke-static {v0}, Lcom/adobe/mobile/Config;->setDebugLogging(Ljava/lang/Boolean;)V

    .line 22
    invoke-direct {p0, p2}, Lcom/comcast/cim/tracking/CimAppMeasurement;->setAppVersion(Ljava/lang/String;)V

    .line 23
    invoke-direct {p0, p3}, Lcom/comcast/cim/tracking/CimAppMeasurement;->setAndroidOsVersionField(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V

    .line 24
    invoke-virtual {p0}, Lcom/comcast/cim/tracking/CimAppMeasurement;->configureAppSpecificFields()V

    .line 25
    return-void
.end method

.method private setAndroidOsVersionField(Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;)V
    .locals 2
    .param p1, "androidDevice"    # Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .prologue
    .line 28
    invoke-virtual {p1}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->getAndroidPrefixedBuildVersionRelease()Ljava/lang/String;

    move-result-object v0

    .line 29
    .local v0, "osVersionField":Ljava/lang/String;
    const-string v1, "OSVersion"

    invoke-virtual {p0, v1, v0}, Lcom/comcast/cim/tracking/CimAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 30
    return-void
.end method

.method private setAppVersion(Ljava/lang/String;)V
    .locals 1
    .param p1, "applicationVersion"    # Ljava/lang/String;

    .prologue
    .line 33
    const-string v0, "appVersion"

    invoke-virtual {p0, v0, p1}, Lcom/comcast/cim/tracking/CimAppMeasurement;->putCdata(Ljava/lang/String;Ljava/lang/Object;)V

    .line 34
    return-void
.end method


# virtual methods
.method protected abstract configureAppSpecificFields()V
.end method

.method public putCdata(Ljava/lang/String;Ljava/lang/Object;)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/Object;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/comcast/cim/tracking/CimAppMeasurement;->cdata:Ljava/util/HashMap;

    invoke-virtual {v0, p1, p2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 38
    return-void
.end method

.method public setEvents(Ljava/lang/String;)V
    .locals 2
    .param p1, "events"    # Ljava/lang/String;

    .prologue
    .line 49
    iget-object v0, p0, Lcom/comcast/cim/tracking/CimAppMeasurement;->cdata:Ljava/util/HashMap;

    const-string v1, "&&events"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 50
    return-void
.end method

.method public setProducts(Ljava/lang/String;)V
    .locals 2
    .param p1, "products"    # Ljava/lang/String;

    .prologue
    .line 53
    iget-object v0, p0, Lcom/comcast/cim/tracking/CimAppMeasurement;->cdata:Ljava/util/HashMap;

    const-string v1, "&&products"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 54
    return-void
.end method

.method public trackAction(Ljava/lang/String;)V
    .locals 1
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 41
    iget-object v0, p0, Lcom/comcast/cim/tracking/CimAppMeasurement;->cdata:Ljava/util/HashMap;

    invoke-static {p1, v0}, Lcom/adobe/mobile/Analytics;->trackAction(Ljava/lang/String;Ljava/util/Map;)V

    .line 42
    return-void
.end method

.method public trackState(Ljava/lang/String;)V
    .locals 1
    .param p1, "state"    # Ljava/lang/String;

    .prologue
    .line 45
    iget-object v0, p0, Lcom/comcast/cim/tracking/CimAppMeasurement;->cdata:Ljava/util/HashMap;

    invoke-static {p1, v0}, Lcom/adobe/mobile/Analytics;->trackState(Ljava/lang/String;Ljava/util/Map;)V

    .line 46
    return-void
.end method
