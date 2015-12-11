.class public abstract Lcom/amazon/mobile/mash/appcontext/AppContext;
.super Ljava/lang/Object;
.source "AppContext.java"


# instance fields
.field private mCapabilityManager:Lcom/amazon/mobile/mash/appcontext/CapabilityManager;


# direct methods
.method public constructor <init>(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V
    .locals 0
    .param p1, "capabilityManager"    # Lcom/amazon/mobile/mash/appcontext/CapabilityManager;

    .prologue
    .line 27
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 28
    iput-object p1, p0, Lcom/amazon/mobile/mash/appcontext/AppContext;->mCapabilityManager:Lcom/amazon/mobile/mash/appcontext/CapabilityManager;

    .line 29
    return-void
.end method


# virtual methods
.method public getAppContextSchemaVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    const-string/jumbo v0, "1.3"

    return-object v0
.end method

.method public abstract getAppName()Ljava/lang/String;
.end method

.method public abstract getAppVersion()Ljava/lang/String;
.end method

.method public getCapability()J
    .locals 2

    .prologue
    .line 80
    iget-object v0, p0, Lcom/amazon/mobile/mash/appcontext/AppContext;->mCapabilityManager:Lcom/amazon/mobile/mash/appcontext/CapabilityManager;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/appcontext/CapabilityManager;->formatCapabilities()J

    move-result-wide v0

    return-wide v0
.end method

.method public abstract getDebugWeinreServerHost()Ljava/lang/String;
.end method

.method public abstract getDebugWeinreServerPort()I
.end method

.method public abstract getDebugWeinreServerSatus()Z
.end method

.method public getDeviceCarrier(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 120
    const-string/jumbo v1, "phone"

    invoke-virtual {p1, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/telephony/TelephonyManager;

    .line 121
    .local v0, "tm":Landroid/telephony/TelephonyManager;
    invoke-virtual {v0}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getDeviceConnectionType(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 128
    const-string/jumbo v2, "connectivity"

    invoke-virtual {p1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 129
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 130
    .local v1, "info":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isConnected()Z

    move-result v2

    if-nez v2, :cond_1

    .line 131
    :cond_0
    const/4 v2, 0x0

    .line 133
    :goto_0
    return-object v2

    :cond_1
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getTypeName()Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method public getDeviceDisplayHeight(Landroid/content/Context;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 147
    invoke-static {p1}, Lcom/amazon/mobile/mash/util/UIUtils;->getPortraitHeight(Landroid/content/Context;)I

    move-result v0

    return v0
.end method

.method public getDeviceDisplayWidth(Landroid/content/Context;)I
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 141
    invoke-static {p1}, Lcom/amazon/mobile/mash/util/UIUtils;->getPortraitWidth(Landroid/content/Context;)I

    move-result v0

    return v0
.end method

.method public abstract getDeviceDmsDeviceType()Ljava/lang/String;
.end method

.method public abstract getDeviceDmsSerialNumber()Ljava/lang/String;
.end method

.method public getDeviceLogicalDensity(Landroid/content/Context;)F
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 153
    invoke-static {p1}, Lcom/amazon/mobile/mash/util/UIUtils;->getDeviceDisplayMetrics(Landroid/content/Context;)Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->density:F

    return v0
.end method

.method public getDeviceManufacturer()Ljava/lang/String;
    .locals 1

    .prologue
    .line 106
    sget-object v0, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceModal()Ljava/lang/String;
    .locals 1

    .prologue
    .line 94
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    return-object v0
.end method

.method public getDeviceModalVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 100
    sget-object v0, Landroid/os/Build;->DEVICE:Ljava/lang/String;

    return-object v0
.end method

.method public getDevicePhysicalDensityX(Landroid/content/Context;)F
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 159
    invoke-static {p1}, Lcom/amazon/mobile/mash/util/UIUtils;->getDeviceDisplayMetrics(Landroid/content/Context;)Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->xdpi:F

    return v0
.end method

.method public getDevicePhysicalDensityY(Landroid/content/Context;)F
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 165
    invoke-static {p1}, Lcom/amazon/mobile/mash/util/UIUtils;->getDeviceDisplayMetrics(Landroid/content/Context;)Landroid/util/DisplayMetrics;

    move-result-object v0

    iget v0, v0, Landroid/util/DisplayMetrics;->ydpi:F

    return v0
.end method

.method public getDeviceProductLine()Ljava/lang/String;
    .locals 1

    .prologue
    .line 88
    sget-object v0, Landroid/os/Build;->PRODUCT:Ljava/lang/String;

    return-object v0
.end method

.method public getMASHApiVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 61
    const-string/jumbo v0, "1.11.0"

    return-object v0
.end method

.method public getMASHUrlIntercepterVersion()I
    .locals 1

    .prologue
    .line 67
    const/4 v0, 0x2

    return v0
.end method

.method public abstract getOSName()Ljava/lang/String;
.end method

.method public getOSVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 74
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    return-object v0
.end method
