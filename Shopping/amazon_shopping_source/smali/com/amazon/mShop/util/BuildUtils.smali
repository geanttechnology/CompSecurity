.class public Lcom/amazon/mShop/util/BuildUtils;
.super Ljava/lang/Object;
.source "BuildUtils.java"


# static fields
.field private static final PARTNER_NAME:Ljava/lang/String; = "partnerName"

.field private static final TAG:Ljava/lang/String; = "Amazon"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static getBetaName(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 291
    sget v1, Lcom/amazon/mShop/android/lib/R$raw;->beta_name:I

    invoke-static {p0, v1}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 292
    .local v0, "betaName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 293
    const-string/jumbo v1, "Amazon"

    const-string/jumbo v2, "missing build beta name"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 295
    :cond_0
    return-object v0
.end method

.method public static getPartnerName(Landroid/content/Context;)Ljava/lang/String;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 226
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "partnerName"

    invoke-interface {v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 227
    .local v0, "partnerName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    move-object v1, v0

    .line 236
    .end local v0    # "partnerName":Ljava/lang/String;
    .local v1, "partnerName":Ljava/lang/String;
    :goto_0
    return-object v1

    .line 231
    .end local v1    # "partnerName":Ljava/lang/String;
    .restart local v0    # "partnerName":Ljava/lang/String;
    :cond_0
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->getPartnerNameIfEmptyInDataStore(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 232
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 234
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "partnerName"

    invoke-interface {v2, v3, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    :cond_1
    move-object v1, v0

    .line 236
    .end local v0    # "partnerName":Ljava/lang/String;
    .restart local v1    # "partnerName":Ljava/lang/String;
    goto :goto_0
.end method

.method private static getPartnerNameIfEmptyInDataStore(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 245
    invoke-virtual {p0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->config_oemConfigFileName:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 246
    .local v3, "oemConfigurationFileName":Ljava/lang/String;
    new-instance v2, Ljava/io/File;

    invoke-direct {v2, v3}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 247
    .local v2, "oemConfigFile":Ljava/io/File;
    invoke-virtual {v2}, Ljava/io/File;->exists()Z

    move-result v6

    if-nez v6, :cond_0

    .line 249
    sget v6, Lcom/amazon/mShop/android/lib/R$raw;->partner_name:I

    invoke-static {p0, v6}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v6

    .line 272
    :goto_0
    return-object v6

    .line 253
    :cond_0
    sget v6, Lcom/amazon/mShop/android/lib/R$raw;->distribution:I

    invoke-static {p0, v6}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 254
    .local v0, "distribution":Ljava/lang/String;
    const-string/jumbo v6, "oem"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 256
    new-instance v5, Ljava/util/Properties;

    invoke-direct {v5}, Ljava/util/Properties;-><init>()V

    .line 258
    .local v5, "props":Ljava/util/Properties;
    :try_start_0
    new-instance v6, Ljava/io/FileInputStream;

    invoke-direct {v6, v3}, Ljava/io/FileInputStream;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v6}, Ljava/util/Properties;->load(Ljava/io/InputStream;)V

    .line 259
    const-string/jumbo v6, "partnerName"

    invoke-virtual {v5, v6}, Ljava/util/Properties;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 260
    .local v4, "partnerName":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 261
    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    goto :goto_0

    .line 263
    .end local v4    # "partnerName":Ljava/lang/String;
    :catch_0
    move-exception v1

    .line 264
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v6, "Amazon"

    invoke-static {v6, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/Throwable;)I

    .line 272
    .end local v1    # "e":Ljava/lang/Exception;
    .end local v5    # "props":Ljava/util/Properties;
    :cond_1
    const/4 v6, 0x0

    goto :goto_0

    .line 267
    :cond_2
    const-string/jumbo v6, "market"

    invoke-virtual {v6, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 269
    sget v6, Lcom/amazon/mShop/android/lib/R$raw;->partner_name:I

    invoke-static {p0, v6}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v6

    goto :goto_0
.end method

.method public static getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 279
    sget v1, Lcom/amazon/mShop/android/lib/R$raw;->build_revision:I

    invoke-static {p0, v1}, Lcom/amazon/mShop/util/AttributionUtils;->readStringFromRawResourceFile(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v0

    .line 280
    .local v0, "revision":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 281
    const-string/jumbo v1, "Amazon"

    const-string/jumbo v2, "missing build revision number"

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 283
    :cond_0
    return-object v0
.end method

.method public static getVersionCode(Landroid/content/Context;)I
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 56
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 57
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    const/4 v3, 0x0

    .line 59
    .local v3, "packageName":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 60
    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 61
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget v4, v1, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 64
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    :goto_0
    return v4

    .line 62
    :catch_0
    move-exception v0

    .line 63
    .local v0, "ex":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string/jumbo v4, "Amazon"

    const-string/jumbo v5, "Package name is unknown"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 64
    const/4 v4, -0x1

    goto :goto_0
.end method

.method public static getVersionName(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 37
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 38
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    const/4 v3, 0x0

    .line 40
    .local v3, "packageName":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    .line 41
    const/4 v6, 0x0

    invoke-virtual {v2, v3, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v1

    .line 42
    .local v1, "packageInfo":Landroid/content/pm/PackageInfo;
    iget-object v5, v1, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    .line 44
    .local v5, "versionName":Ljava/lang/String;
    const/16 v6, 0x5f

    invoke-virtual {v5, v6}, Ljava/lang/String;->indexOf(I)I

    move-result v4

    .line 45
    .local v4, "suffixIndex":I
    const/4 v6, -0x1

    if-eq v4, v6, :cond_0

    .line 46
    const/4 v6, 0x0

    invoke-virtual {v5, v6, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v5

    .line 51
    .end local v1    # "packageInfo":Landroid/content/pm/PackageInfo;
    .end local v4    # "suffixIndex":I
    .end local v5    # "versionName":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v5

    .line 49
    :catch_0
    move-exception v0

    .line 50
    .local v0, "ex":Landroid/content/pm/PackageManager$NameNotFoundException;
    const-string/jumbo v6, "Amazon"

    const-string/jumbo v7, "Package name is unknown"

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    const/4 v5, 0x0

    goto :goto_0
.end method

.method public static isAssociatesTagUpdate(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 88
    invoke-static {p0}, Lcom/amazon/mShop/util/AttributionUtils;->getAssociatesTag(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 89
    .local v0, "currentAssociateTag":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 90
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "associatesTagCheckChange"

    invoke-interface {v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 92
    .local v2, "previousAssociateTag":Ljava/lang/String;
    const-string/jumbo v3, "associatesTagCheckChange"

    invoke-static {v2, v0, v3}, Lcom/amazon/mShop/util/BuildUtils;->isStringValueUpdate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    return v3
.end method

.method public static isGlobalVersionUpdate(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 103
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->getVersionCode(Landroid/content/Context;)I

    move-result v0

    .line 104
    .local v0, "currenGlobaltVersionCode":I
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 105
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "globalApplicationVersion"

    invoke-interface {v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v2

    .line 107
    .local v2, "previousGlobalVersion":I
    const-string/jumbo v3, "globalApplicationVersion"

    invoke-static {v2, v0, v3}, Lcom/amazon/mShop/util/BuildUtils;->isIntValueUpdate(IILjava/lang/String;)Z

    move-result v3

    return v3
.end method

.method public static isHardwareIdentifierUpdate(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 131
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Landroid/os/Build;->MANUFACTURER:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Landroid/os/Build;->MODEL:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 132
    .local v1, "hardwareIdentifier":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 133
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "hardwareIdentifier"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 135
    .local v2, "preHardwareIdentifier":Ljava/lang/String;
    const-string/jumbo v3, "hardwareIdentifier"

    invoke-static {v2, v1, v3}, Lcom/amazon/mShop/util/BuildUtils;->isStringValueUpdate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    return v3
.end method

.method public static isIntValueUpdate(IILjava/lang/String;)Z
    .locals 2
    .param p0, "oldValue"    # I
    .param p1, "newValue"    # I
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 205
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 206
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    if-eq p0, p1, :cond_0

    .line 207
    invoke-interface {v0, p2, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putInt(Ljava/lang/String;I)V

    .line 209
    :cond_0
    if-eq p0, p1, :cond_1

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isKiangUpdateActivated(Landroid/content/Context;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 71
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->isAssociatesTagUpdate(Landroid/content/Context;)Z

    move-result v0

    .line 72
    .local v0, "isAssociatesTagUpdate":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->isGlobalVersionUpdate(Landroid/content/Context;)Z

    move-result v1

    .line 73
    .local v1, "isGlobalVersionUpdate":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->isOSVersionUpdate(Landroid/content/Context;)Z

    move-result v4

    .line 74
    .local v4, "isOSVersionUpdate":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->isHardwareIdentifierUpdate(Landroid/content/Context;)Z

    move-result v2

    .line 75
    .local v2, "isHardwareIdentifierUpdate":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->isUBIDUpdate(Landroid/content/Context;)Z

    move-result v5

    .line 76
    .local v5, "isUBIDUpdate":Z
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->isLocaleChanged(Landroid/content/Context;)Z

    move-result v3

    .line 78
    .local v3, "isLocaleChanged":Z
    if-nez v0, :cond_0

    if-nez v1, :cond_0

    if-nez v4, :cond_0

    if-nez v2, :cond_0

    if-nez v5, :cond_0

    if-eqz v3, :cond_1

    :cond_0
    const/4 v6, 0x1

    :goto_0
    return v6

    :cond_1
    const/4 v6, 0x0

    goto :goto_0
.end method

.method public static isLocaleChanged(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 176
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 177
    .local v0, "currentLocaleName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 178
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "currentLocaleName"

    invoke-interface {v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 180
    .local v2, "preLocaleName":Ljava/lang/String;
    const-string/jumbo v3, "currentLocaleName"

    invoke-static {v2, v0, v3}, Lcom/amazon/mShop/util/BuildUtils;->isStringValueUpdate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    return v3
.end method

.method public static isOSVersionUpdate(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 117
    sget-object v0, Landroid/os/Build$VERSION;->RELEASE:Ljava/lang/String;

    .line 118
    .local v0, "currentOSVersion":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 119
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "osVersion"

    invoke-interface {v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 121
    .local v2, "preOSVersion":Ljava/lang/String;
    const-string/jumbo v3, "osVersion"

    invoke-static {v2, v0, v3}, Lcom/amazon/mShop/util/BuildUtils;->isStringValueUpdate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    return v3
.end method

.method public static isStringValueUpdate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z
    .locals 2
    .param p0, "oldValue"    # Ljava/lang/String;
    .param p1, "newValue"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 194
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 196
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    invoke-virtual {p1, p0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 197
    :cond_0
    const/4 v1, 0x0

    .line 200
    :goto_0
    return v1

    .line 199
    :cond_1
    invoke-interface {v0, p2, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 200
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static isUBIDUpdate(Landroid/content/Context;)Z
    .locals 4
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 144
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->getUbidCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 145
    .local v0, "currentUbid":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 146
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "Ubid"

    invoke-interface {v1, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 148
    .local v2, "preUbid":Ljava/lang/String;
    const-string/jumbo v3, "Ubid"

    invoke-static {v2, v0, v3}, Lcom/amazon/mShop/util/BuildUtils;->isStringValueUpdate(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    return v3
.end method

.method public static isVersionUpdate(Landroid/content/Context;)Z
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 157
    invoke-static {p0}, Lcom/amazon/mShop/util/BuildUtils;->getVersionCode(Landroid/content/Context;)I

    move-result v0

    .line 158
    .local v0, "currentVersionCode":I
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 159
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v4, "applicationVersion"

    invoke-interface {v1, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getInt(Ljava/lang/String;)I

    move-result v3

    .line 161
    .local v3, "previousVersion":I
    const-string/jumbo v4, "applicationVersion"

    invoke-static {v3, v0, v4}, Lcom/amazon/mShop/util/BuildUtils;->isIntValueUpdate(IILjava/lang/String;)Z

    move-result v2

    .line 162
    .local v2, "isVersionUpdated":Z
    if-eqz v2, :cond_0

    .line 165
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->clearNewUpgradeInfo()V

    .line 167
    :cond_0
    return v2
.end method
