.class public Lcom/amazon/mShop/mash/context/MShopAppContext;
.super Lcom/amazon/mobile/mash/appcontext/AppContext;
.source "MShopAppContext.java"


# direct methods
.method public constructor <init>(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V
    .locals 0
    .param p1, "capabilityManager"    # Lcom/amazon/mobile/mash/appcontext/CapabilityManager;

    .prologue
    .line 19
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/appcontext/AppContext;-><init>(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V

    .line 20
    return-void
.end method


# virtual methods
.method public getAppName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getAppVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 29
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDebugWeinreServerHost()Ljava/lang/String;
    .locals 2

    .prologue
    .line 65
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "weinreServerHost"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDebugWeinreServerPort()I
    .locals 2

    .prologue
    .line 70
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "weinreServerPort"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public getDebugWeinreServerSatus()Z
    .locals 3

    .prologue
    .line 75
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "weinreServerStatus"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public getDeviceDmsDeviceType()Ljava/lang/String;
    .locals 5

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 53
    .local v0, "context":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 55
    :try_start_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    move-result-object v2

    invoke-virtual {v0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/identity/auth/device/api/DeviceDataKeys;->getDeviceTypeKeyForPackage(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getValue(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/DeviceDataStoreException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 60
    :goto_0
    return-object v2

    .line 56
    :catch_0
    move-exception v1

    .line 57
    .local v1, "e":Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
    const-string/jumbo v2, "AppContext"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "error while retrieving device data: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 60
    .end local v1    # "e":Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getDeviceDmsSerialNumber()Ljava/lang/String;
    .locals 5

    .prologue
    .line 39
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 40
    .local v0, "context":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 42
    :try_start_0
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/DeviceDataStore;

    move-result-object v2

    const-string/jumbo v3, "Device Serial Number"

    invoke-virtual {v2, v3}, Lcom/amazon/identity/auth/device/api/DeviceDataStore;->getValue(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/DeviceDataStoreException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v2

    .line 47
    :goto_0
    return-object v2

    .line 43
    :catch_0
    move-exception v1

    .line 44
    .local v1, "e":Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
    const-string/jumbo v2, "AppContext"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "error while retrieving device data: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 47
    .end local v1    # "e":Lcom/amazon/identity/auth/device/api/DeviceDataStoreException;
    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public getOSName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 34
    const-string/jumbo v0, "Android"

    return-object v0
.end method
