.class public Lcom/amazon/mShop/util/DeviceUtils;
.super Ljava/lang/Object;
.source "DeviceUtils.java"


# static fields
.field public static APPLICATOIN_IDENTIFIER:Ljava/lang/String;

.field public static OS_IDENTIFIER_ANDROID:Ljava/lang/String;

.field public static UNIQUE_DEVICE_ID:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const-string/jumbo v0, "Android"

    sput-object v0, Lcom/amazon/mShop/util/DeviceUtils;->OS_IDENTIFIER_ANDROID:Ljava/lang/String;

    .line 18
    const-string/jumbo v0, "AmazonShopping"

    sput-object v0, Lcom/amazon/mShop/util/DeviceUtils;->APPLICATOIN_IDENTIFIER:Ljava/lang/String;

    .line 19
    const-string/jumbo v0, "UDID"

    sput-object v0, Lcom/amazon/mShop/util/DeviceUtils;->UNIQUE_DEVICE_ID:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 16
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getDeviceUniqueId(Landroid/content/Context;)Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 91
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;-><init>()V

    .line 93
    .local v1, "kiangDeviceId":Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceId()Ljava/lang/String;

    move-result-object v0

    .line 94
    .local v0, "deviceId":Ljava/lang/String;
    sget-object v2, Lcom/amazon/mShop/util/DeviceUtils;->UNIQUE_DEVICE_ID:Ljava/lang/String;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;->setType(Ljava/lang/String;)V

    .line 95
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;->setValue(Ljava/lang/String;)V

    .line 97
    return-object v1
.end method

.method public static getKiangAppInfomation(Landroid/content/Context;)Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 62
    new-instance v0, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    invoke-direct {v0}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;-><init>()V

    .line 64
    .local v0, "appInfo":Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->getUbidCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 65
    .local v4, "ubid":Ljava/lang/String;
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v6, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, " "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    sget-object v6, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 66
    .local v2, "hardwareIdentifier":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getApplicationVersion()Ljava/lang/String;

    move-result-object v1

    .line 67
    .local v1, "applicationVersion":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    .line 69
    .local v3, "reftag":Ljava/lang/String;
    if-eqz v4, :cond_0

    .line 70
    :goto_0
    if-eqz v3, :cond_1

    .line 72
    :goto_1
    invoke-virtual {v0, v4}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setUbid(Ljava/lang/String;)V

    .line 73
    invoke-virtual {v0, v2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setHardwareIdentifier(Ljava/lang/String;)V

    .line 74
    sget-object v5, Lcom/amazon/mShop/util/DeviceUtils;->OS_IDENTIFIER_ANDROID:Ljava/lang/String;

    invoke-virtual {v0, v5}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setOsIdentifier(Ljava/lang/String;)V

    .line 75
    sget-object v5, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v0, v5}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setOsVersion(Ljava/lang/String;)V

    .line 76
    sget-object v5, Lcom/amazon/mShop/util/DeviceUtils;->APPLICATOIN_IDENTIFIER:Ljava/lang/String;

    invoke-virtual {v0, v5}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setApplicationIdentifier(Ljava/lang/String;)V

    .line 77
    invoke-virtual {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setApplicationVersion(Ljava/lang/String;)V

    .line 78
    invoke-virtual {v0, v3}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setAssociateTag(Ljava/lang/String;)V

    .line 80
    invoke-static {p0}, Lcom/amazon/mShop/util/DeviceUtils;->getDeviceUniqueId(Landroid/content/Context;)Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;

    move-result-object v5

    invoke-virtual {v0, v5}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;->setDeviceUniqueId(Lcom/amazon/rio/j2me/client/services/mShop/KiangDeviceUniqueId;)V

    .line 82
    return-object v0

    .line 69
    :cond_0
    const-string/jumbo v4, ""

    goto :goto_0

    .line 70
    :cond_1
    const-string/jumbo v3, ""

    goto :goto_1
.end method

.method public static getKiangApplicationState(Landroid/content/Context;)Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 117
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;-><init>()V

    .line 119
    .local v1, "state":Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "applicationInstallId"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 122
    .local v0, "mAppInstallID":Ljava/lang/String;
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->setApplicationInstallId(Ljava/lang/String;)V

    .line 123
    invoke-static {p0}, Lcom/amazon/mShop/util/DeviceUtils;->getKiangAppInfomation(Landroid/content/Context;)Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->setApplicationInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInformation;)V

    .line 128
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->setApplicationInstanceInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationInstanceInformation;)V

    .line 129
    invoke-static {}, Lcom/amazon/mShop/util/DeviceUtils;->getKiangPushInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangApplicationState;->setPushInformation(Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;)V

    .line 131
    return-object v1
.end method

.method public static getKiangPushInformation()Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;
    .locals 4

    .prologue
    .line 30
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;-><init>()V

    .line 32
    .local v1, "pushInfo":Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;
    const/4 v0, 0x0

    .line 33
    .local v0, "provider":Ljava/lang/String;
    const/4 v2, 0x0

    .line 37
    .local v2, "secret":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNotificationProvider()Lcom/amazon/mShop/pushnotification/NotificationProvider;

    move-result-object v3

    if-eqz v3, :cond_0

    .line 39
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNotificationProvider()Lcom/amazon/mShop/pushnotification/NotificationProvider;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->getProviderName()Ljava/lang/String;

    move-result-object v0

    .line 40
    invoke-static {}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getInstance()Lcom/amazon/mShop/pushnotification/PushNotificationManager;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/pushnotification/PushNotificationManager;->getNotificationProvider()Lcom/amazon/mShop/pushnotification/NotificationProvider;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/pushnotification/NotificationProvider;->getCurrentMShopRegistrationToken()Ljava/lang/String;

    move-result-object v2

    .line 43
    :cond_0
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 44
    :cond_1
    const/4 v1, 0x0

    .line 48
    .end local v1    # "pushInfo":Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;
    :goto_0
    return-object v1

    .line 46
    .restart local v1    # "pushInfo":Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;
    :cond_2
    invoke-virtual {v1, v0}, Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;->setProvider(Ljava/lang/String;)V

    .line 47
    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/services/mShop/KiangPushInformation;->setSecret(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static getKiangSecurity()Lcom/amazon/rio/j2me/client/services/mShop/KiangSecurity;
    .locals 1

    .prologue
    .line 104
    const/4 v0, 0x0

    return-object v0
.end method
