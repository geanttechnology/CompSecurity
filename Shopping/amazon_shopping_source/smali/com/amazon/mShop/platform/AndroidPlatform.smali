.class public Lcom/amazon/mShop/platform/AndroidPlatform;
.super Ljava/lang/Object;
.source "AndroidPlatform.java"

# interfaces
.implements Lcom/amazon/mShop/platform/Platform;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/platform/AndroidPlatform$AndroidLogger;
    }
.end annotation


# static fields
.field private static volatile mShopService:Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

.field private static sApplicationName:Ljava/lang/String;


# instance fields
.field private final applicationContext:Landroid/content/Context;

.field private final dataStore:Lcom/amazon/mShop/platform/AndroidDataStore;

.field private final handler:Landroid/os/Handler;

.field private mApplicationId:Ljava/lang/String;

.field private mUserAgent:Ljava/lang/String;

.field private res:Lcom/amazon/mShop/platform/Resources;


# direct methods
.method private constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 67
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    instance-of v0, p1, Landroid/app/Activity;

    if-eqz v0, :cond_0

    .line 75
    invoke-virtual {p1}, Landroid/content/Context;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    .line 80
    :goto_0
    new-instance v0, Lcom/amazon/mShop/platform/AndroidDataStore;

    invoke-direct {v0, p1}, Lcom/amazon/mShop/platform/AndroidDataStore;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->dataStore:Lcom/amazon/mShop/platform/AndroidDataStore;

    .line 81
    new-instance v0, Landroid/os/Handler;

    invoke-virtual {p1}, Landroid/content/Context;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    iput-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->handler:Landroid/os/Handler;

    .line 82
    return-void

    .line 77
    :cond_0
    iput-object p1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    goto :goto_0
.end method

.method public static getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;
    .locals 1

    .prologue
    .line 93
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/platform/AndroidPlatform;

    return-object v0
.end method

.method private static initLRUCacheSize(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 59
    const-string/jumbo v1, "activity"

    invoke-virtual {p0, v1}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/app/ActivityManager;

    .line 60
    .local v0, "am":Landroid/app/ActivityManager;
    invoke-virtual {v0}, Landroid/app/ActivityManager;->getMemoryClass()I

    move-result v1

    mul-int/lit16 v1, v1, 0x400

    mul-int/lit16 v1, v1, 0x400

    div-int/lit8 v1, v1, 0x4

    int-to-long v1, v1

    invoke-static {v1, v2}, Lcom/amazon/mShop/net/LRUCache;->setCacheLimit(J)V

    .line 61
    return-void
.end method

.method public static setUp(Landroid/content/Context;Ljava/lang/String;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "applicationName"    # Ljava/lang/String;

    .prologue
    .line 49
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    if-nez v0, :cond_0

    .line 50
    new-instance v0, Lcom/amazon/mShop/platform/AndroidPlatform;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/platform/AndroidPlatform;-><init>(Landroid/content/Context;)V

    invoke-static {v0}, Lcom/amazon/mShop/platform/Platform$Factory;->setInstance(Lcom/amazon/mShop/platform/Platform;)V

    .line 51
    sput-object p1, Lcom/amazon/mShop/platform/AndroidPlatform;->sApplicationName:Ljava/lang/String;

    .line 52
    invoke-static {p0}, Lcom/amazon/mShop/util/LocaleUtils;->initLocale(Landroid/content/Context;)V

    .line 53
    invoke-static {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->initLRUCacheSize(Landroid/content/Context;)V

    .line 54
    invoke-static {p0}, Lcom/amazon/mShop/mobileads/AdsHelper;->resetIfNecessary(Landroid/content/Context;)V

    .line 56
    :cond_0
    return-void
.end method


# virtual methods
.method public getAppStartCountForAllLocales()I
    .locals 6

    .prologue
    .line 496
    const/4 v2, 0x0

    .line 497
    .local v2, "startCount":I
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AppLocale;->getSupportedLocaleNameArray()[Ljava/lang/Object;

    move-result-object v3

    .line 498
    .local v3, "supportedLocaleNameArray":[Ljava/lang/Object;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    array-length v4, v3

    if-ge v0, v4, :cond_0

    .line 499
    aget-object v1, v3, v0

    check-cast v1, Ljava/lang/String;

    .line 500
    .local v1, "localeName":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->dataStore:Lcom/amazon/mShop/platform/AndroidDataStore;

    const-string/jumbo v5, "applicationStartCount"

    invoke-virtual {v4, v5, v1}, Lcom/amazon/mShop/platform/AndroidDataStore;->getInt(Ljava/lang/String;Ljava/lang/String;)I

    move-result v4

    add-int/2addr v2, v4

    .line 498
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 502
    .end local v1    # "localeName":Ljava/lang/String;
    :cond_0
    return v2
.end method

.method public getApplicationContext()Landroid/content/Context;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    return-object v0
.end method

.method public bridge synthetic getApplicationContext()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 37
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    return-object v0
.end method

.method public getApplicationId()Ljava/lang/String;
    .locals 14

    .prologue
    const/16 v13, 0x12

    .line 183
    iget-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    if-nez v11, :cond_3

    .line 185
    sget-object v11, Lcom/amazon/mShop/platform/AndroidPlatform;->sApplicationName:Ljava/lang/String;

    invoke-static {v11}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v11

    if-eqz v11, :cond_0

    .line 186
    const-string/jumbo v11, "Amazon"

    const-string/jumbo v12, "Every application should provide an application name!!!!!"

    invoke-static {v11, v12}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 187
    new-instance v11, Ljava/lang/RuntimeException;

    const-string/jumbo v12, "Every application should provide an application name!!!!!"

    invoke-direct {v11, v12}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v11

    .line 198
    :cond_0
    const/4 v3, 0x0

    .line 200
    .local v3, "dsn":Ljava/lang/String;
    :try_start_0
    const-class v11, Landroid/os/Build;

    const-string/jumbo v12, "SERIAL"

    invoke-virtual {v11, v12}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v11

    const-class v12, Landroid/os/Build;

    invoke-virtual {v11, v12}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v11

    move-object v0, v11

    check-cast v0, Ljava/lang/String;

    move-object v3, v0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 204
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    .line 206
    .local v2, "deviceId":Ljava/lang/String;
    iget-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    const-string/jumbo v12, "phone"

    invoke-virtual {v11, v12}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Landroid/telephony/TelephonyManager;

    .line 207
    .local v9, "telephonyManager":Landroid/telephony/TelephonyManager;
    invoke-virtual {v9}, Landroid/telephony/TelephonyManager;->getNetworkOperatorName()Ljava/lang/String;

    move-result-object v6

    .line 209
    .local v6, "network":Ljava/lang/String;
    iget-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    invoke-static {v11}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v10

    .line 210
    .local v10, "version":Ljava/lang/String;
    iget-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    invoke-static {v11}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v8

    .line 213
    .local v8, "tag":Ljava/lang/String;
    const/16 v5, 0x12

    .line 214
    .local v5, "maxOsLength":I
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v12, "Android_"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 215
    .local v7, "os":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->length()I

    move-result v11

    if-ge v13, v11, :cond_1

    .line 216
    const/4 v11, 0x0

    invoke-virtual {v7, v11, v13}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v7

    .line 221
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v11

    sget v12, Lcom/amazon/mShop/android/lib/R$string;->config_marketplace:I

    invoke-static {v11, v12}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/String;->toUpperCase()Ljava/lang/String;

    move-result-object v4

    .line 224
    .local v4, "marketplace":Ljava/lang/String;
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v12, "name="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Lcom/amazon/mShop/platform/AndroidPlatform;->sApplicationName:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "ver="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "device="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    sget-object v12, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "os="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "UDID="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "network="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "tag="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "mp="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    iput-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    .line 234
    if-eqz v3, :cond_2

    .line 235
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v12, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "DSN="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    iput-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    .line 238
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v11

    invoke-static {v11}, Lcom/amazon/mShop/util/BuildUtils;->getBetaName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 239
    .local v1, "betaName":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v11

    if-nez v11, :cond_3

    .line 240
    new-instance v11, Ljava/lang/StringBuilder;

    invoke-direct {v11}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v12, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, "beta="

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    const-string/jumbo v12, ";"

    invoke-virtual {v11, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v11

    invoke-virtual {v11}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    iput-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    .line 246
    .end local v1    # "betaName":Ljava/lang/String;
    .end local v2    # "deviceId":Ljava/lang/String;
    .end local v3    # "dsn":Ljava/lang/String;
    .end local v4    # "marketplace":Ljava/lang/String;
    .end local v5    # "maxOsLength":I
    .end local v6    # "network":Ljava/lang/String;
    .end local v7    # "os":Ljava/lang/String;
    .end local v8    # "tag":Ljava/lang/String;
    .end local v9    # "telephonyManager":Landroid/telephony/TelephonyManager;
    .end local v10    # "version":Ljava/lang/String;
    :cond_3
    iget-object v11, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    return-object v11

    .line 201
    .restart local v3    # "dsn":Ljava/lang/String;
    :catch_0
    move-exception v11

    goto/16 :goto_0
.end method

.method public getApplicationName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 267
    sget-object v0, Lcom/amazon/mShop/platform/AndroidPlatform;->sApplicationName:Ljava/lang/String;

    return-object v0
.end method

.method public getApplicationVersion()Ljava/lang/String;
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;
    .locals 1

    .prologue
    .line 444
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->dataStore:Lcom/amazon/mShop/platform/AndroidDataStore;

    return-object v0
.end method

.method public getDeviceId()Ljava/lang/String;
    .locals 5

    .prologue
    .line 98
    const/4 v2, 0x0

    .line 99
    .local v2, "dsn":Ljava/lang/String;
    const/4 v1, 0x0

    .line 101
    .local v1, "deviceId":Ljava/lang/String;
    :try_start_0
    const-class v3, Landroid/os/Build;

    const-string/jumbo v4, "SERIAL"

    invoke-virtual {v3, v4}, Ljava/lang/Class;->getDeclaredField(Ljava/lang/String;)Ljava/lang/reflect/Field;

    move-result-object v3

    const-class v4, Landroid/os/Build;

    invoke-virtual {v3, v4}, Ljava/lang/reflect/Field;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Ljava/lang/String;

    move-object v2, v0
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 105
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    const-string/jumbo v4, "android_id"

    invoke-static {v3, v4}, Landroid/provider/Settings$Secure;->getString(Landroid/content/ContentResolver;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 106
    const-string/jumbo v3, "9774d56d682e549c"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    if-nez v1, :cond_1

    .line 109
    :cond_0
    move-object v1, v2

    .line 113
    :cond_1
    if-nez v1, :cond_2

    .line 114
    iget-object v3, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->dataStore:Lcom/amazon/mShop/platform/AndroidDataStore;

    const-string/jumbo v4, "UDID"

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/platform/AndroidDataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 115
    if-nez v1, :cond_2

    .line 116
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v1

    .line 117
    iget-object v3, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->dataStore:Lcom/amazon/mShop/platform/AndroidDataStore;

    const-string/jumbo v4, "UDID"

    invoke-virtual {v3, v4, v1}, Lcom/amazon/mShop/platform/AndroidDataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 120
    :cond_2
    return-object v1

    .line 102
    :catch_0
    move-exception v3

    goto :goto_0
.end method

.method public getDeviceName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 312
    sget-object v0, Landroid/os/Build;->MODEL:Ljava/lang/String;

    return-object v0
.end method

.method public getLogger(Ljava/lang/Class;)Lcom/amazon/rio/j2me/client/util/Logger;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Ljava/lang/Class",
            "<TT;>;)",
            "Lcom/amazon/rio/j2me/client/util/Logger;"
        }
    .end annotation

    .prologue
    .line 390
    .local p1, "clazz":Ljava/lang/Class;, "Ljava/lang/Class<TT;>;"
    new-instance v0, Lcom/amazon/mShop/platform/AndroidPlatform$AndroidLogger;

    invoke-direct {v0, p1}, Lcom/amazon/mShop/platform/AndroidPlatform$AndroidLogger;-><init>(Ljava/lang/Class;)V

    return-object v0
.end method

.method public declared-synchronized getMShopService()Lcom/amazon/rio/j2me/client/services/mShop/MShopService;
    .locals 6

    .prologue
    .line 350
    monitor-enter p0

    :try_start_0
    sget-object v3, Lcom/amazon/mShop/platform/AndroidPlatform;->mShopService:Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    if-nez v3, :cond_0

    .line 354
    new-instance v2, Lcom/amazon/mShop/platform/AndroidPlatform$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/platform/AndroidPlatform$1;-><init>(Lcom/amazon/mShop/platform/AndroidPlatform;)V

    .line 362
    .local v2, "serverConnectionFactory":Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;
    new-instance v1, Lcom/amazon/mShop/platform/AndroidPlatform$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/platform/AndroidPlatform$2;-><init>(Lcom/amazon/mShop/platform/AndroidPlatform;)V

    .line 372
    .local v1, "secureServerConnectionFactory":Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;
    new-instance v0, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;

    invoke-direct {v0, v2, v1}, Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;-><init>(Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;)V

    .line 377
    .local v0, "asynchronousServiceCallInvoker":Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;
    new-instance v3, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;

    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationId()Ljava/lang/String;

    move-result-object v4

    invoke-static {}, Lcom/amazon/mShop/net/MShopRioEventListener;->getRioEventListener()Lcom/amazon/rio/j2me/client/services/RioEventListener;

    move-result-object v5

    invoke-direct {v3, v4, v0, v5}, Lcom/amazon/rio/j2me/client/services/mShop/MShopServiceImpl;-><init>(Ljava/lang/String;Lcom/amazon/rio/j2me/client/rsc/ServiceCallInvoker;Lcom/amazon/rio/j2me/client/services/RioEventListener;)V

    sput-object v3, Lcom/amazon/mShop/platform/AndroidPlatform;->mShopService:Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    .line 385
    .end local v0    # "asynchronousServiceCallInvoker":Lcom/amazon/rio/j2me/client/rsc/AsynchronousServiceCallInvoker;
    .end local v1    # "secureServerConnectionFactory":Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;
    .end local v2    # "serverConnectionFactory":Lcom/amazon/rio/j2me/client/trans/ServerConnectionFactory;
    :cond_0
    sget-object v3, Lcom/amazon/mShop/platform/AndroidPlatform;->mShopService:Lcom/amazon/rio/j2me/client/services/mShop/MShopService;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return-object v3

    .line 350
    :catchall_0
    move-exception v3

    monitor-exit p0

    throw v3
.end method

.method public getResources()Lcom/amazon/mShop/platform/Resources;
    .locals 2

    .prologue
    .line 465
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->res:Lcom/amazon/mShop/platform/Resources;

    if-nez v0, :cond_0

    .line 466
    new-instance v0, Lcom/amazon/mShop/platform/AndroidResources;

    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/mShop/platform/AndroidResources;-><init>(Landroid/content/res/Resources;)V

    iput-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->res:Lcom/amazon/mShop/platform/Resources;

    .line 468
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->res:Lcom/amazon/mShop/platform/Resources;

    return-object v0
.end method

.method public getSecureServiceUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 319
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 320
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "currentServiceSecureUrl"

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 321
    .local v0, "url":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 322
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_serviceSecureURL:I

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 323
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "currentServiceSecureUrl"

    invoke-interface {v1, v2, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 328
    .end local v0    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v0

    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_serviceSecureURL:I

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getServiceUrl()Ljava/lang/String;
    .locals 3

    .prologue
    .line 333
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 334
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "currentServiceUrl"

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 335
    .local v0, "url":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 336
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_serviceURL:I

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 337
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const-string/jumbo v2, "currentServiceUrl"

    invoke-interface {v1, v2, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 342
    .end local v0    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v0

    :cond_1
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->config_serviceURL:I

    invoke-static {v1, v2}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getUserAgent()Ljava/lang/String;
    .locals 3

    .prologue
    .line 278
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mUserAgent:Ljava/lang/String;

    if-nez v1, :cond_2

    .line 279
    monitor-enter p0

    .line 280
    :try_start_0
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mUserAgent:Ljava/lang/String;

    if-nez v1, :cond_1

    .line 282
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    invoke-static {v1}, Lcom/amazon/mShop/util/BuildUtils;->getVersionName(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 287
    .local v0, "version":Ljava/lang/String;
    sget-object v1, Lcom/amazon/mShop/platform/AndroidPlatform;->sApplicationName:Ljava/lang/String;

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 288
    const-string/jumbo v1, "Amazon"

    const-string/jumbo v2, "Every application should provide an application name!!!!!"

    invoke-static {v1, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 289
    new-instance v1, Ljava/lang/RuntimeException;

    const-string/jumbo v2, "Every application should provide an application name!!!!!"

    invoke-direct {v1, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 294
    .end local v0    # "version":Ljava/lang/String;
    :catchall_0
    move-exception v1

    monitor-exit p0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v1

    .line 292
    .restart local v0    # "version":Ljava/lang/String;
    :cond_0
    :try_start_1
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v2, Lcom/amazon/mShop/platform/AndroidPlatform;->sApplicationName:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " (Android/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mUserAgent:Ljava/lang/String;

    .line 294
    .end local v0    # "version":Ljava/lang/String;
    :cond_1
    monitor-exit p0
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 296
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mUserAgent:Ljava/lang/String;

    return-object v1
.end method

.method public invokeLater(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 157
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 158
    return-void
.end method

.method public invokeLater(Ljava/lang/Runnable;J)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;
    .param p2, "delayMillis"    # J

    .prologue
    .line 169
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1, p2, p3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 170
    return-void
.end method

.method public isAmazonAppStoreSupported()Z
    .locals 2

    .prologue
    .line 473
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasAmazonAppstore:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/4 v1, 0x4

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAmazonKindleSupported()Z
    .locals 2

    .prologue
    .line 483
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_isAmazonKindleSupported:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    return v0
.end method

.method public isAmazonMp3Supported()Z
    .locals 2

    .prologue
    .line 478
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->applicationContext:Landroid/content/Context;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasAmazonMp3:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-object v0, Landroid/os/Build$VERSION;->SDK:Ljava/lang/String;

    invoke-static {v0}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v0

    const/4 v1, 0x4

    if-lt v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isAmazonVideoSupported()Z
    .locals 2

    .prologue
    .line 488
    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    const-string/jumbo v1, "com.amazon.avod"

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/AppUtils;->isAppInstalled(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public resetApplicationId()V
    .locals 2

    .prologue
    .line 304
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->mApplicationId:Ljava/lang/String;

    .line 305
    sget-object v0, Lcom/amazon/mShop/platform/AndroidPlatform;->mShopService:Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    if-eqz v0, :cond_0

    .line 306
    sget-object v0, Lcom/amazon/mShop/platform/AndroidPlatform;->mShopService:Lcom/amazon/rio/j2me/client/services/mShop/MShopService;

    invoke-virtual {p0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationId()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/services/mShop/MShopService;->setApplicationID(Ljava/lang/String;)V

    .line 308
    :cond_0
    return-void
.end method

.method public runOnUiThread(Ljava/lang/Runnable;)V
    .locals 2
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 144
    invoke-static {}, Ljava/lang/Thread;->currentThread()Ljava/lang/Thread;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->handler:Landroid/os/Handler;

    invoke-virtual {v1}, Landroid/os/Handler;->getLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-virtual {v1}, Landroid/os/Looper;->getThread()Ljava/lang/Thread;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 145
    invoke-interface {p1}, Ljava/lang/Runnable;->run()V

    .line 149
    :goto_0
    return-void

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/platform/AndroidPlatform;->handler:Landroid/os/Handler;

    invoke-virtual {v0, p1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method
