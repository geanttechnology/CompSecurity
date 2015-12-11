.class public Lcom/amazon/device/ads/AmazonOOAdRegistration;
.super Ljava/lang/Object;
.source "AmazonOOAdRegistration.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;,
        Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;,
        Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;
    }
.end annotation


# static fields
.field protected static final IDENTIFY_USER_WITH_SIS_INTERVAL_MSEC:J = 0x1b77400L

.field protected static final LAST_IDENTIFY_USER_WITH_SIS_TIME_KEY:Ljava/lang/String; = "lastIdentifyUserWithSisTime"

.field private static final LOG_TAG:Ljava/lang/String; = "AmazonOOAdRegistration"

.field private static instance:Lcom/amazon/device/ads/AmazonOOAdRegistration;

.field protected static sLastIdentifyUserWithSisTime:J


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 35
    const-wide/16 v0, 0x0

    sput-wide v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;->sLastIdentifyUserWithSisTime:J

    .line 37
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;

    invoke-direct {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;->instance:Lcom/amazon/device/ads/AmazonOOAdRegistration;

    return-void
.end method

.method constructor <init>()V
    .locals 2

    .prologue
    .line 43
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 44
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/Configuration;->setIsFirstParty(Z)V

    .line 45
    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->isMAPLibraryAvailable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 47
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->createPreferredMarketplaceRetriever()Lcom/amazon/device/ads/PreferredMarketplaceRetriever;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/Configuration;->setPreferredMarketplaceRetriever(Lcom/amazon/device/ads/PreferredMarketplaceRetriever;)V

    .line 53
    :goto_0
    return-void

    .line 51
    :cond_0
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "MAP Library not available"

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method static synthetic access$100(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 0
    .param p0, "x0"    # Ljava/util/HashMap;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Z

    .prologue
    .line 27
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    return-void
.end method

.method private static addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 1
    .param p1, "key"    # Ljava/lang/String;
    .param p2, "value"    # Ljava/lang/String;
    .param p3, "shouldURLDecode"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 257
    .local p0, "params":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz p2, :cond_0

    .line 259
    invoke-static {p3, p2}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->decodeIfNeeded(ZLjava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 261
    :cond_0
    return-void
.end method

.method private static decodeIfNeeded(ZLjava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "shouldURLDecode"    # Z
    .param p1, "string"    # Ljava/lang/String;

    .prologue
    .line 253
    if-eqz p0, :cond_0

    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->getURLDecodedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object p1

    .end local p1    # "string":Ljava/lang/String;
    :cond_0
    return-object p1
.end method

.method public static final enableLogging(Z)V
    .locals 1
    .param p0, "enable"    # Z

    .prologue
    .line 113
    const-string/jumbo v0, "AmazonOOAdRegistration"

    invoke-static {v0, p0}, Lcom/amazon/device/ads/Log;->enableLoggingWithSetterNotification(Ljava/lang/String;Z)V

    .line 114
    return-void
.end method

.method public static enableTLS(Z)V
    .locals 6
    .param p0, "enable"    # Z

    .prologue
    const/4 v5, 0x1

    .line 390
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x8

    if-lt v0, v1, :cond_1

    .line 392
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "tlsEnabled"

    invoke-virtual {v0, v1, p0}, Lcom/amazon/device/ads/Settings;->putTransientBoolean(Ljava/lang/String;Z)V

    .line 393
    const-string/jumbo v1, "AmazonOOAdRegistration"

    const-string/jumbo v2, "Transport Layer Security %s by default."

    new-array v3, v5, [Ljava/lang/Object;

    const/4 v4, 0x0

    if-eqz p0, :cond_0

    const-string/jumbo v0, "enabled"

    :goto_0
    aput-object v0, v3, v4

    invoke-static {v5, v1, v2, v3}, Lcom/amazon/device/ads/Log;->i(ZLjava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 399
    :goto_1
    return-void

    .line 393
    :cond_0
    const-string/jumbo v0, "disabled"

    goto :goto_0

    .line 397
    :cond_1
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "Enabling Transport Layer Security is only supported on Android API Level 8 and higher."

    invoke-static {v5, v0, v1}, Lcom/amazon/device/ads/Log;->i(ZLjava/lang/String;Ljava/lang/String;)V

    goto :goto_1
.end method

.method public static final enableTesting(Z)V
    .locals 3
    .param p0, "enable"    # Z

    .prologue
    .line 125
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "testingEnabled"

    invoke-virtual {v0, v1, p0}, Lcom/amazon/device/ads/Settings;->putTransientBoolean(Ljava/lang/String;Z)V

    .line 126
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "Test mode"

    invoke-static {p0}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 127
    return-void
.end method

.method public static fetchAdPreferencesURL(Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;)V
    .locals 1
    .param p0, "listener"    # Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;

    .prologue
    .line 408
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;-><init>(Lcom/amazon/device/ads/AmazonOOAdPreferencesURLListener;)V

    .line 409
    .local v0, "fetcher":Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AdPreferencesURLFetcher;->start()V

    .line 410
    return-void
.end method

.method public static getDeviceNativeParams()Ljava/util/Map;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v3, 0x0

    .line 243
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 244
    .local v0, "deviceNativeDataParams":Ljava/util/HashMap;, "Ljava/util/HashMap<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v1, "os"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getOS()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 245
    const-string/jumbo v1, "model"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getModel()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 246
    const-string/jumbo v1, "make"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getMake()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 247
    const-string/jumbo v1, "osVersion"

    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getOSVersion()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->addParam(Ljava/util/HashMap;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 248
    return-object v0
.end method

.method static getInstance()Lcom/amazon/device/ads/AmazonOOAdRegistration;
    .locals 1

    .prologue
    .line 60
    sget-object v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;->instance:Lcom/amazon/device/ads/AmazonOOAdRegistration;

    return-object v0
.end method

.method public static final getVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 137
    invoke-static {}, Lcom/amazon/device/ads/Version;->getSDKVersion()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public static identifyAmazonUserUsingDMS(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "adpToken"    # Ljava/lang/String;
    .param p2, "privateKey"    # Ljava/lang/String;

    .prologue
    .line 273
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->getInstance()Lcom/amazon/device/ads/PermissionChecker;

    move-result-object v0

    const-string/jumbo v1, "AmazonOOAdRegistration"

    invoke-virtual {v0, p0, v1}, Lcom/amazon/device/ads/PermissionChecker;->passesInternetPermissionCheck(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 280
    :goto_0
    return-void

    .line 278
    :cond_0
    invoke-static {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;)V

    .line 279
    new-instance v0, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;

    invoke-direct {v0, p1, p2}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/amazon/device/ads/AmazonOODMSUserIdentifier;->executeRequest()V

    goto :goto_0
.end method

.method public static identifyAmazonUserUsingMAP()V
    .locals 2

    .prologue
    .line 289
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->isRegistered()Z

    move-result v0

    if-nez v0, :cond_0

    .line 291
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "AmazonOOAdRegistration.registerApp must be called before identify user."

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 293
    :cond_0
    new-instance v0, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;

    invoke-direct {v0}, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;-><init>()V

    invoke-virtual {v0}, Lcom/amazon/device/ads/AmazonOOMAPUserIdentifier;->executeRequest()V

    .line 294
    return-void
.end method

.method public static final listenForRegistrationInfo(Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V
    .locals 1
    .param p0, "listener"    # Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    .prologue
    .line 168
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;-><init>(Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V

    .line 169
    .local v0, "startUpWaiter":Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;
    invoke-virtual {v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;->start()V

    .line 170
    return-void
.end method

.method public static final prepareRegistrationInfo(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 199
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0, p0}, Lcom/amazon/device/ads/IInternalAdRegistration;->contextReceived(Landroid/content/Context;)V

    .line 200
    return-void
.end method

.method public static final prepareRegistrationInfo(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V
    .locals 0
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "listener"    # Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    .prologue
    .line 211
    invoke-static {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;)V

    .line 212
    invoke-static {p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->listenForRegistrationInfo(Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V

    .line 213
    return-void
.end method

.method public static final registerApp(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 158
    const/4 v0, 0x0

    invoke-static {p0, v0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->registerApp(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V

    .line 159
    return-void
.end method

.method public static final registerApp(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "listener"    # Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    .prologue
    .line 179
    invoke-static {}, Lcom/amazon/device/ads/PermissionChecker;->getInstance()Lcom/amazon/device/ads/PermissionChecker;

    move-result-object v0

    const-string/jumbo v1, "AmazonOOAdRegistration"

    invoke-virtual {v0, p0, v1}, Lcom/amazon/device/ads/PermissionChecker;->passesInternetPermissionCheck(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 190
    :cond_0
    :goto_0
    return-void

    .line 184
    :cond_1
    invoke-static {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;)V

    .line 185
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->register()V

    .line 186
    if-eqz p1, :cond_0

    .line 188
    invoke-static {p1}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->listenForRegistrationInfo(Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V

    goto :goto_0
.end method

.method public static registerEvent(Landroid/content/Context;Lcom/amazon/device/ads/AmazonOOAppEvent;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "appEvent"    # Lcom/amazon/device/ads/AmazonOOAppEvent;

    .prologue
    .line 361
    if-nez p1, :cond_0

    .line 363
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "Application event was null. Could not register the application event."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 380
    :goto_0
    return-void

    .line 366
    :cond_0
    invoke-virtual {p1}, Lcom/amazon/device/ads/AmazonOOAppEvent;->getEventName()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/amazon/device/ads/AmazonOOAppEvent;->getEventName()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, ""

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 368
    :cond_1
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "Event name should not be null or empty. Could not register the application event."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 371
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/device/ads/AmazonOOAppEvent;->getTimestamp()J

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-gtz v0, :cond_3

    .line 373
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "Invalid time stamp value for the event. Could not register the application event."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 376
    :cond_3
    invoke-static {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;)V

    .line 378
    invoke-static {}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->getInstance()Lcom/amazon/device/ads/AppEventRegistrationHandler;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->addEventToAppEventsCacheFile(Lcom/amazon/device/ads/AppEvent;)V

    .line 379
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "New event"

    invoke-virtual {p1}, Lcom/amazon/device/ads/AmazonOOAppEvent;->getEventName()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static setAppDefinedMarketplace(Ljava/lang/String;)V
    .locals 1
    .param p0, "appDefinedMarketplace"    # Ljava/lang/String;

    .prologue
    .line 233
    invoke-static {}, Lcom/amazon/device/ads/Configuration;->getInstance()Lcom/amazon/device/ads/Configuration;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/device/ads/Configuration;->setAppDefinedMarketplace(Ljava/lang/String;)V

    .line 234
    return-void
.end method

.method public static final setAppKey(Ljava/lang/String;)V
    .locals 1
    .param p0, "appKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/IllegalArgumentException;
        }
    .end annotation

    .prologue
    .line 103
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/device/ads/RegistrationInfo;->putAppKey(Ljava/lang/String;)V

    .line 104
    return-void
.end method

.method public static setAppName(Ljava/lang/String;)V
    .locals 1
    .param p0, "appName"    # Ljava/lang/String;

    .prologue
    .line 222
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/amazon/device/ads/RegistrationInfo;->putAppName(Ljava/lang/String;)V

    .line 223
    return-void
.end method

.method public static final setReferrer(Landroid/content/Context;Ljava/lang/String;)V
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "referrer"    # Ljava/lang/String;

    .prologue
    .line 338
    invoke-static {p1}, Lcom/amazon/device/ads/Utils;->isNullOrEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 340
    const-string/jumbo v1, "AmazonOOAdRegistration"

    const-string/jumbo v2, "Referrer was null or emtpy. Could not set the referrer."

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 349
    :goto_0
    return-void

    .line 343
    :cond_0
    invoke-static {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;)V

    .line 345
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAppEvent;

    const-string/jumbo v1, "INSTALL_REFERRER"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-direct {v0, v1, v2, v3}, Lcom/amazon/device/ads/AmazonOOAppEvent;-><init>(Ljava/lang/String;J)V

    .line 346
    .local v0, "appEvent":Lcom/amazon/device/ads/AppEvent;
    const-string/jumbo v1, "referrer"

    invoke-virtual {v0, v1, p1}, Lcom/amazon/device/ads/AppEvent;->setProperty(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/device/ads/AppEvent;

    .line 347
    invoke-static {}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->getInstance()Lcom/amazon/device/ads/AppEventRegistrationHandler;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/device/ads/AppEventRegistrationHandler;->addEventToAppEventsCacheFile(Lcom/amazon/device/ads/AppEvent;)V

    .line 348
    const-string/jumbo v1, "AmazonOOAdRegistration"

    const-string/jumbo v2, "Referrer"

    invoke-static {v1, v2, p1}, Lcom/amazon/device/ads/Log;->logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method

.method public static setShouldPauseWebViewTimersInWebViewRelatedActivities(Landroid/content/Context;Z)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "shouldPause"    # Z

    .prologue
    .line 325
    invoke-static {p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration;->prepareRegistrationInfo(Landroid/content/Context;)V

    .line 326
    invoke-static {}, Lcom/amazon/device/ads/Settings;->getInstance()Lcom/amazon/device/ads/Settings;

    move-result-object v0

    const-string/jumbo v1, "shouldPauseWebViewTimersInWebViewRelatedActivities"

    invoke-virtual {v0, v1, p1}, Lcom/amazon/device/ads/Settings;->putBoolean(Ljava/lang/String;Z)V

    .line 327
    const-string/jumbo v0, "AmazonOOAdRegistration"

    const-string/jumbo v1, "WebView timer pausing"

    invoke-static {p1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->logSetterNotification(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;)V

    .line 328
    return-void
.end method

.method public static updateLastIdentifyUserWithSISTime(Landroid/content/Context;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 306
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/device/ads/AmazonOOAdRegistration;->sLastIdentifyUserWithSisTime:J

    .line 307
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdRegistration$1;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/AmazonOOAdRegistration$1;-><init>(Landroid/content/Context;)V

    invoke-static {v0}, Lcom/amazon/device/ads/ThreadUtils;->executeRunnable(Ljava/lang/Runnable;)V

    .line 316
    return-void
.end method


# virtual methods
.method createPreferredMarketplaceRetriever()Lcom/amazon/device/ads/PreferredMarketplaceRetriever;
    .locals 3

    .prologue
    .line 78
    :try_start_0
    new-instance v1, Lcom/amazon/device/ads/AmazonOOMAPPreferredMarketplaceRetriever;

    invoke-direct {v1}, Lcom/amazon/device/ads/AmazonOOMAPPreferredMarketplaceRetriever;-><init>()V
    :try_end_0
    .catch Ljava/lang/VerifyError; {:try_start_0 .. :try_end_0} :catch_0

    .line 83
    :goto_0
    return-object v1

    .line 80
    :catch_0
    move-exception v0

    .line 82
    .local v0, "e":Ljava/lang/VerifyError;
    const-string/jumbo v1, "AmazonOOAdRegistration"

    const-string/jumbo v2, "Incompatible version of MAP found. Upgrade to MAP R5 to allow preferred marketplace to be retrieved."

    invoke-static {v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 83
    const/4 v1, 0x0

    goto :goto_0
.end method

.method isMAPLibraryAvailable()Z
    .locals 1

    .prologue
    .line 68
    const-string/jumbo v0, "com.amazon.identity.auth.device.api.MAPAccountManager"

    invoke-static {v0}, Lcom/amazon/device/ads/ReflectionUtils;->isClassAvailable(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method
