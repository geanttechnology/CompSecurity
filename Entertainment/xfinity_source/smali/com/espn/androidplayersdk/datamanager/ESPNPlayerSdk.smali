.class public Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;
.super Ljava/lang/Object;
.source "ESPNPlayerSdk.java"


# static fields
.field public static DEVICE_OPTION_KEY:Ljava/lang/String;

.field protected static IS_QA:Z

.field public static SDKTAG:Ljava/lang/String;

.field public static SDK_VERSION:Ljava/lang/String;

.field protected static SDK_VERSION_FOR_API:Ljava/lang/String;

.field public static mCtx:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const-string v0, "EspnSDK"

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDKTAG:Ljava/lang/String;

    .line 23
    const-string v0, "1.3.0"

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDK_VERSION:Ljava/lang/String;

    .line 24
    const-string v0, "1.0.3"

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->SDK_VERSION_FOR_API:Ljava/lang/String;

    .line 25
    const-string v0, "device_key"

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->DEVICE_OPTION_KEY:Ljava/lang/String;

    .line 27
    const/4 v0, 0x0

    sput-boolean v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->IS_QA:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static init(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "partner"    # Ljava/lang/String;

    .prologue
    .line 38
    const/4 v0, 0x0

    invoke-static {p0, p1, v0}, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->init(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V

    .line 39
    return-void
.end method

.method public static init(Landroid/content/Context;Ljava/lang/String;Ljava/util/Map;)V
    .locals 5
    .param p0, "ctx"    # Landroid/content/Context;
    .param p1, "partner"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 52
    .local p2, "options":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    sput-object p0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->mCtx:Landroid/content/Context;

    .line 53
    sput-object p0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->ctx:Landroid/content/Context;

    .line 55
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "logging"

    const-string v2, "loggingLevel"

    const-string v3, "6"

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 57
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "startSession"

    const-string v2, "affiliate"

    invoke-virtual {v0, v1, v2, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 62
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->shouldOverwriteAffiliateID()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 63
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "analytics"

    const-string v2, "affiliateId"

    invoke-virtual {v0, v1, v2, p1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    :cond_0
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/DataManager;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/DataManager;-><init>()V

    invoke-virtual {v0, p0}, Lcom/espn/androidplayersdk/datamanager/DataManager;->initializeDataFactory(Landroid/content/Context;)V

    .line 66
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->getUUID()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 67
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v1, "config"

    const-string v2, "uuid"

    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string v4, "android_id"

    invoke-static {v3, v4}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v1, v2, v3}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 69
    :cond_1
    if-eqz p2, :cond_2

    sget-object v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->DEVICE_OPTION_KEY:Ljava/lang/String;

    invoke-interface {p2, v0}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 71
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->DEVICE_OPTION_KEY:Ljava/lang/String;

    invoke-interface {p2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-static {v0}, Lcom/espn/androidplayersdk/datamanager/DeviceData;->overrideDeviceType(Ljava/lang/String;)V

    .line 76
    :goto_0
    return-void

    .line 74
    :cond_2
    invoke-static {}, Lcom/espn/androidplayersdk/datamanager/DeviceData;->getDeviceType()V

    goto :goto_0
.end method

.method public static setIsQA(Z)V
    .locals 0
    .param p0, "flag"    # Z

    .prologue
    .line 120
    sput-boolean p0, Lcom/espn/androidplayersdk/datamanager/ESPNPlayerSdk;->IS_QA:Z

    .line 121
    return-void
.end method

.method public static setLogginglevel(I)V
    .locals 6
    .param p0, "level"    # I

    .prologue
    const/4 v5, 0x6

    .line 99
    :try_start_0
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "logging"

    const-string v3, "loggingLevel"

    invoke-static {p0}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 100
    if-eq p0, v5, :cond_0

    .line 101
    const/4 v1, 0x2

    invoke-static {v1}, Ltv/freewheel/hybrid/utils/Logger;->setLogLevel(I)V

    .line 102
    const/4 v1, 0x1

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v1}, Lcom/conviva/LivePass;->toggleTraces(Ljava/lang/Boolean;)V

    .line 112
    :goto_0
    return-void

    .line 104
    :cond_0
    const/4 v1, 0x6

    invoke-static {v1}, Ltv/freewheel/hybrid/utils/Logger;->setLogLevel(I)V

    .line 105
    const/4 v1, 0x0

    invoke-static {v1}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v1

    invoke-static {v1}, Lcom/conviva/LivePass;->toggleTraces(Ljava/lang/Boolean;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 107
    :catch_0
    move-exception v0

    .line 109
    .local v0, "e":Ljava/lang/Exception;
    new-instance v1, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;

    invoke-direct {v1}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;-><init>()V

    const-string v2, "logging"

    const-string v3, "loggingLevel"

    const-string v4, "1"

    invoke-virtual {v1, v2, v3, v4}, Lcom/espn/androidplayersdk/datamanager/EPSDKPrefs;->putField(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    const-string v1, "Unable to set Logging level. Defaulting to Verbose"

    const/4 v2, 0x5

    const/4 v3, 0x0

    invoke-static {v1, v2, v3}, Lcom/espn/androidplayersdk/utilities/Utils;->sdkLog(Ljava/lang/String;ILjava/lang/Exception;)V

    goto :goto_0
.end method

.method public static unInit()V
    .locals 1

    .prologue
    .line 80
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/DataManager;

    invoke-direct {v0}, Lcom/espn/androidplayersdk/datamanager/DataManager;-><init>()V

    invoke-virtual {v0}, Lcom/espn/androidplayersdk/datamanager/DataManager;->deinitializeDataFactory()V

    .line 81
    return-void
.end method
