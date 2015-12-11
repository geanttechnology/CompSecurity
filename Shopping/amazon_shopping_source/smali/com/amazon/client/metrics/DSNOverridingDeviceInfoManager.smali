.class public Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;
.super Lcom/amazon/client/metrics/AndroidDeviceInfoManager;
.source "DSNOverridingDeviceInfoManager.java"


# static fields
.field protected static final SHARED_PREFS_FILENAME:Ljava/lang/String; = "com.amazon.client.metrics"

.field protected static final log:Lcom/amazon/dp/logger/DPLogger;


# instance fields
.field protected mCachedAnonymousDSN:Ljava/lang/String;

.field protected mSharedPrefs:Landroid/content/SharedPreferences;

.field protected mSharedPrefsDSNKey:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 38
    new-instance v0, Lcom/amazon/dp/logger/DPLogger;

    invoke-direct {v0}, Lcom/amazon/dp/logger/DPLogger;-><init>()V

    sput-object v0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->log:Lcom/amazon/dp/logger/DPLogger;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;
    .param p3, "sharedPrefsDSNKey"    # Ljava/lang/String;

    .prologue
    .line 51
    invoke-direct {p0, p2}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;-><init>(Lcom/amazon/device/utils/DeviceUtil;)V

    .line 52
    if-nez p1, :cond_0

    .line 53
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 55
    :cond_0
    iput-object p3, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefsDSNKey:Ljava/lang/String;

    .line 56
    const-string/jumbo v0, "com.amazon.client.metrics"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefs:Landroid/content/SharedPreferences;

    .line 58
    invoke-direct {p0}, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->fetchAnonymousDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mCachedAnonymousDSN:Ljava/lang/String;

    .line 59
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/util/Map;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;
    .param p4, "sharedPrefsDSNKey"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Lcom/amazon/device/utils/DeviceUtil;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 69
    .local p3, "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p2, p3}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;-><init>(Lcom/amazon/device/utils/DeviceUtil;Ljava/util/Map;)V

    .line 70
    if-nez p1, :cond_0

    .line 71
    new-instance v0, Ljava/lang/IllegalArgumentException;

    const-string/jumbo v1, "Context must not be null."

    invoke-direct {v0, v1}, Ljava/lang/IllegalArgumentException;-><init>(Ljava/lang/String;)V

    throw v0

    .line 73
    :cond_0
    iput-object p4, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefsDSNKey:Ljava/lang/String;

    .line 74
    const-string/jumbo v0, "com.amazon.client.metrics"

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/content/Context;->getSharedPreferences(Ljava/lang/String;I)Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefs:Landroid/content/SharedPreferences;

    .line 76
    invoke-direct {p0}, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->fetchAnonymousDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mCachedAnonymousDSN:Ljava/lang/String;

    .line 77
    return-void
.end method

.method private fetchAnonymousDeviceSerialNumber()Ljava/lang/String;
    .locals 6

    .prologue
    .line 80
    iget-object v2, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefs:Landroid/content/SharedPreferences;

    iget-object v3, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefsDSNKey:Ljava/lang/String;

    const/4 v4, 0x0

    invoke-interface {v2, v3, v4}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 81
    .local v0, "anonymousID":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 82
    sget-object v2, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v3, "fetchAnonymousDeviceSerialNumber"

    const-string/jumbo v4, " No existing ID found, generating a new UUID"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/Object;

    invoke-virtual {v2, v3, v4, v5}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 83
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v2

    invoke-virtual {v2}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    .line 84
    iget-object v2, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v2}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v1

    .line 85
    .local v1, "editor":Landroid/content/SharedPreferences$Editor;
    iget-object v2, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mSharedPrefsDSNKey:Ljava/lang/String;

    invoke-interface {v1, v2, v0}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 86
    invoke-interface {v1}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 88
    .end local v1    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    return-object v0
.end method


# virtual methods
.method protected getDeviceSerialNumber()Ljava/lang/String;
    .locals 4

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mDeviceUtil:Lcom/amazon/device/utils/DeviceUtil;

    invoke-interface {v0}, Lcom/amazon/device/utils/DeviceUtil;->isDeviceSerialNumberAnonymous()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 95
    sget-object v0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->log:Lcom/amazon/dp/logger/DPLogger;

    const-string/jumbo v1, "getDeviceSerialNumber"

    const-string/jumbo v2, "Returning secondary anonymous DSN"

    const/4 v3, 0x0

    new-array v3, v3, [Ljava/lang/Object;

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/dp/logger/DPLogger;->verbose(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 96
    iget-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mCachedAnonymousDSN:Ljava/lang/String;

    if-nez v0, :cond_0

    .line 97
    invoke-direct {p0}, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->fetchAnonymousDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mCachedAnonymousDSN:Ljava/lang/String;

    .line 99
    :cond_0
    iget-object v0, p0, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->mCachedAnonymousDSN:Ljava/lang/String;

    .line 101
    :goto_0
    return-object v0

    :cond_1
    invoke-super {p0}, Lcom/amazon/client/metrics/AndroidDeviceInfoManager;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method
