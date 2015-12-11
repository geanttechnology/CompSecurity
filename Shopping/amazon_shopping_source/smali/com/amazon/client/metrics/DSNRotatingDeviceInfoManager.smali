.class public Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;
.super Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;
.source "DSNRotatingDeviceInfoManager.java"


# static fields
.field private static final DEFAULT_EXPIRATION_PERIOD_MILLIS:J = 0x5265c00L

.field private static final LAST_ROTATION_TIME_KEY:Ljava/lang/String; = "lastDSNRotationTime"


# instance fields
.field private mExpirationPeriodMillis:J


# direct methods
.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/lang/String;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "deviceUtil"    # Lcom/amazon/device/utils/DeviceUtil;
    .param p3, "sharedPrefsDSNKey"    # Ljava/lang/String;

    .prologue
    .line 47
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;-><init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/lang/String;)V

    .line 48
    const-wide/32 v0, 0x5265c00

    iput-wide v0, p0, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->mExpirationPeriodMillis:J

    .line 49
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/util/Map;Ljava/lang/String;)V
    .locals 0
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
    .line 67
    .local p3, "extraInfo":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;-><init>(Landroid/content/Context;Lcom/amazon/device/utils/DeviceUtil;Ljava/util/Map;Ljava/lang/String;)V

    .line 68
    return-void
.end method

.method private getLastRotationTime()J
    .locals 4

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->mSharedPrefs:Landroid/content/SharedPreferences;

    const-string/jumbo v1, "lastDSNRotationTime"

    const-wide/16 v2, 0x0

    invoke-interface {v0, v1, v2, v3}, Landroid/content/SharedPreferences;->getLong(Ljava/lang/String;J)J

    move-result-wide v0

    return-wide v0
.end method


# virtual methods
.method protected getDeviceSerialNumber()Ljava/lang/String;
    .locals 7

    .prologue
    .line 76
    invoke-direct {p0}, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->getLastRotationTime()J

    move-result-wide v1

    .line 78
    .local v1, "lastRotationTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v3

    sub-long/2addr v3, v1

    iget-wide v5, p0, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->mExpirationPeriodMillis:J

    cmp-long v3, v3, v5

    if-lez v3, :cond_0

    .line 79
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->mCachedAnonymousDSN:Ljava/lang/String;

    .line 80
    iget-object v3, p0, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->mSharedPrefs:Landroid/content/SharedPreferences;

    invoke-interface {v3}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    .line 81
    .local v0, "editor":Landroid/content/SharedPreferences$Editor;
    iget-object v3, p0, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->mSharedPrefsDSNKey:Ljava/lang/String;

    invoke-interface {v0, v3}, Landroid/content/SharedPreferences$Editor;->remove(Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    .line 82
    const-string/jumbo v3, "lastDSNRotationTime"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v4

    invoke-interface {v0, v3, v4, v5}, Landroid/content/SharedPreferences$Editor;->putLong(Ljava/lang/String;J)Landroid/content/SharedPreferences$Editor;

    .line 83
    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 85
    .end local v0    # "editor":Landroid/content/SharedPreferences$Editor;
    :cond_0
    invoke-super {p0}, Lcom/amazon/client/metrics/DSNOverridingDeviceInfoManager;->getDeviceSerialNumber()Ljava/lang/String;

    move-result-object v3

    return-object v3
.end method

.method public setExpirationPeriodMillis(J)V
    .locals 0
    .param p1, "expirationPeriodMillis"    # J

    .prologue
    .line 57
    iput-wide p1, p0, Lcom/amazon/client/metrics/DSNRotatingDeviceInfoManager;->mExpirationPeriodMillis:J

    .line 58
    return-void
.end method
