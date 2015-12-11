.class public Lcom/amazon/mShop/util/UpgradeUtil;
.super Ljava/lang/Object;
.source "UpgradeUtil.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method public static checkForUpgrade()V
    .locals 2

    .prologue
    .line 226
    new-instance v0, Lcom/amazon/mShop/upgrade/UpgradeController;

    invoke-direct {v0}, Lcom/amazon/mShop/upgrade/UpgradeController;-><init>()V

    .line 227
    .local v0, "controller":Lcom/amazon/mShop/upgrade/UpgradeController;
    new-instance v1, Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;

    invoke-direct {v1}, Lcom/amazon/mShop/upgrade/UpgradeSubscriberAdapter;-><init>()V

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/upgrade/UpgradeController;->setSubscriber(Lcom/amazon/mShop/upgrade/UpgradeSubscriber;)V

    .line 228
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/upgrade/UpgradeController;->checkForUpgrade(Lcom/amazon/mShop/control/TaskCallback;)V

    .line 229
    return-void
.end method

.method public static checkForUpgradeLater()V
    .locals 5

    .prologue
    .line 256
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 257
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "upgradeLastCheckTime"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putLong(Ljava/lang/String;J)V

    .line 259
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    new-instance v2, Lcom/amazon/mShop/util/UpgradeUtil$7;

    invoke-direct {v2}, Lcom/amazon/mShop/util/UpgradeUtil$7;-><init>()V

    const-wide/16 v3, 0x7530

    invoke-interface {v1, v2, v3, v4}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 267
    return-void
.end method

.method public static checkTimeout(JJ)Z
    .locals 4
    .param p0, "time"    # J
    .param p2, "timeout"    # J

    .prologue
    .line 35
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 36
    .local v0, "newTime":J
    sub-long v2, v0, p0

    invoke-static {v2, v3}, Ljava/lang/Math;->abs(J)J

    move-result-wide v2

    cmp-long v2, v2, p2

    if-lez v2, :cond_0

    .line 37
    const/4 v2, 0x1

    .line 39
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static clearNewUpgradeInfo()V
    .locals 3

    .prologue
    .line 71
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 72
    .local v0, "ds":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "upgradeShouldShowDialog"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 74
    return-void
.end method

.method private static formatDialogMessage(Landroid/content/Context;I)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "resId"    # I

    .prologue
    .line 114
    invoke-virtual {p0, p1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 119
    .local v1, "message":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v4

    const-string/jumbo v5, "Android_UpgradeThruAppstore"

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v0

    .line 120
    .local v0, "isUpgradeThruAppstoreWeblabOn":Z
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v4

    if-eqz v4, :cond_0

    if-eqz v0, :cond_0

    move-object v2, v1

    .line 139
    .end local v1    # "message":Ljava/lang/String;
    .local v2, "message":Ljava/lang/String;
    :goto_0
    return-object v2

    .line 124
    .end local v2    # "message":Ljava/lang/String;
    .restart local v1    # "message":Ljava/lang/String;
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v4

    const/4 v5, 0x1

    invoke-static {p0, v4, v5}, Lcom/amazon/mShop/util/AttributionUtils;->readAssociatesTag(Landroid/content/Context;Lcom/amazon/rio/j2me/client/persistence/DataStore;Z)Ljava/lang/String;

    move-result-object v3

    .line 127
    .local v3, "rawAssociateTag":Ljava/lang/String;
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->upgrade_google_play_prefix:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_1

    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->checkGooglePackage()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 130
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->upgrade_dialog_visit_googleplay:I

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    :goto_1
    move-object v2, v1

    .line 139
    .end local v1    # "message":Ljava/lang/String;
    .restart local v2    # "message":Ljava/lang/String;
    goto :goto_0

    .line 131
    .end local v2    # "message":Ljava/lang/String;
    .restart local v1    # "message":Ljava/lang/String;
    :cond_1
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->upgrade_amazon_appstore_prefix:I

    invoke-virtual {p0, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->checkAmazonAppstorePackage()Z

    move-result v4

    if-eqz v4, :cond_2

    .line 134
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->upgrade_dialog_visit_amazonappstore:I

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1

    .line 136
    :cond_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, " "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->upgrade_dialog_general_store:I

    invoke-virtual {p0, v5}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    goto :goto_1
.end method

.method private static getASINforPackage()Ljava/lang/String;
    .locals 3

    .prologue
    .line 273
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v1

    .line 274
    .local v1, "packageName":Ljava/lang/String;
    const-string/jumbo v0, "B004GJDQT8"

    .line 275
    .local v0, "asin":Ljava/lang/String;
    const-string/jumbo v2, "de"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 276
    const-string/jumbo v0, "B00N2DG1UA"

    .line 280
    :cond_0
    :goto_0
    return-object v0

    .line 277
    :cond_1
    const-string/jumbo v2, "uk"

    invoke-virtual {v1, v2}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 278
    const-string/jumbo v0, "B00N2DM6I6"

    goto :goto_0
.end method

.method private static goToAppstoreApp()V
    .locals 1

    .prologue
    .line 320
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->checkAmazonAppstorePackage()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 321
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->startAmazonAppStore()V

    .line 325
    :goto_0
    return-void

    .line 323
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->installAmazonAppStore()V

    goto :goto_0
.end method

.method public static goToUpgradePage()V
    .locals 7

    .prologue
    const/4 v2, 0x0

    .line 205
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 209
    .local v0, "context":Landroid/content/Context;
    invoke-static {}, Lcom/amazon/mShop/feature/Features;->getInstance()Lcom/amazon/mShop/feature/Features;

    move-result-object v1

    const-string/jumbo v3, "Android_UpgradeThruAppstore"

    invoke-virtual {v1, v3}, Lcom/amazon/mShop/feature/Features;->isFeatureActivated(Ljava/lang/String;)Z

    move-result v6

    .line 210
    .local v6, "isUpgradeThruAppstoreWeblabOn":Z
    invoke-static {}, Lcom/amazon/mShop/appstore/AppstoreUtils;->isAppstoreAvailable()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 211
    if-eqz v6, :cond_0

    .line 212
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->getASINforPackage()Ljava/lang/String;

    move-result-object v1

    const/high16 v5, 0x10000000

    move-object v3, v2

    move-object v4, v2

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/util/ActivityUtils;->startAppstoreActivityWithAsinAndFlag(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V

    .line 223
    :goto_0
    return-void

    .line 214
    :cond_0
    invoke-static {v0}, Lcom/amazon/mShop/util/UpgradeUtil;->goToUpgradePageBaseOnAssoHandler(Landroid/content/Context;)V

    goto :goto_0

    .line 217
    :cond_1
    invoke-static {v0}, Lcom/amazon/mShop/util/UpgradeUtil;->isFromGooglePlay(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_2

    if-eqz v6, :cond_2

    .line 218
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->goToAppstoreApp()V

    goto :goto_0

    .line 220
    :cond_2
    invoke-static {v0}, Lcom/amazon/mShop/util/UpgradeUtil;->goToUpgradePageBaseOnAssoHandler(Landroid/content/Context;)V

    goto :goto_0
.end method

.method private static goToUpgradePageBaseOnAssoHandler(Landroid/content/Context;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 287
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {p0, v1, v2}, Lcom/amazon/mShop/util/AttributionUtils;->getTrimmedAssociateTag(Landroid/content/Context;Lcom/amazon/rio/j2me/client/persistence/DataStore;Z)Ljava/lang/String;

    move-result-object v0

    .line 289
    .local v0, "associateTag":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/mShop/util/UpgradeUtil;->isFromGooglePlay(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 291
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->startGooglePlay()V

    .line 304
    :goto_0
    return-void

    .line 292
    :cond_0
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->upgrade_amazon_appstore_prefix:I

    invoke-virtual {p0, v1}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 295
    invoke-static {}, Lcom/amazon/mShop/util/UpgradeUtil;->goToAppstoreApp()V

    goto :goto_0

    .line 298
    :cond_1
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->isCnPackage()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 299
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->openAmazonAppHostPage()V

    goto :goto_0

    .line 301
    :cond_2
    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->openGeneralMarketApp()V

    goto :goto_0
.end method

.method private static initUpgradeButtonGroup(Landroid/content/Context;Landroid/view/ViewGroup;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "root"    # Landroid/view/ViewGroup;

    .prologue
    .line 233
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocaleName()Ljava/lang/String;

    move-result-object v0

    .line 234
    .local v0, "currentLocaleName":Ljava/lang/String;
    const-string/jumbo v1, "ja_JP"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "zh_CN"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "de_DE"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "fr_CA"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    const-string/jumbo v1, "es_ES"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 239
    :cond_0
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->upgrade_notification_dialog_buttons_1:I

    invoke-virtual {v1, v2, p1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 243
    :goto_0
    return-void

    .line 241
    :cond_1
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->upgrade_notification_dialog_buttons_2:I

    invoke-virtual {v1, v2, p1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    goto :goto_0
.end method

.method private static isFromGooglePlay(Landroid/content/Context;)Z
    .locals 3
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    const/4 v1, 0x1

    .line 311
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    invoke-static {p0, v2, v1}, Lcom/amazon/mShop/util/AttributionUtils;->getTrimmedAssociateTag(Landroid/content/Context;Lcom/amazon/rio/j2me/client/persistence/DataStore;Z)Ljava/lang/String;

    move-result-object v0

    .line 312
    .local v0, "associateTag":Ljava/lang/String;
    sget v2, Lcom/amazon/mShop/android/lib/R$string;->upgrade_google_play_prefix:I

    invoke-virtual {p0, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {}, Lcom/amazon/mShop/util/ThirdPartyActivityUtils;->checkGooglePackage()Z

    move-result v2

    if-eqz v2, :cond_0

    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static isNewUpgrade(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;Z)Z
    .locals 6
    .param p0, "info"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;
    .param p1, "awareUniqueId"    # Z

    .prologue
    .line 47
    const/4 v1, 0x0

    .line 49
    .local v1, "result":Z
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 50
    .local v0, "ds":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 51
    if-nez p1, :cond_1

    .line 52
    const/4 v1, 0x1

    .line 67
    :cond_0
    :goto_0
    return v1

    .line 54
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_2

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "upgradeLastUniqueId"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 56
    const-string/jumbo v2, "upgradeLastDialogTime"

    invoke-interface {v0, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getLong(Ljava/lang/String;)J

    move-result-wide v2

    const-wide v4, 0x9a7ec800L

    invoke-static {v2, v3, v4, v5}, Lcom/amazon/mShop/util/UpgradeUtil;->checkTimeout(JJ)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 57
    const/4 v1, 0x1

    goto :goto_0

    .line 62
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method

.method public static saveNewUpgradeInfo(Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;)V
    .locals 3
    .param p0, "info"    # Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;

    .prologue
    .line 77
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 78
    .local v0, "ds":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "upgradeShouldShowDialog"

    const/4 v2, 0x1

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;Z)V

    .line 79
    const-string/jumbo v1, "upgradeLastUniqueId"

    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/UpgradeInfo;->getUniqueId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 80
    return-void
.end method

.method public static shouldCheckUpgrade()Z
    .locals 5

    .prologue
    .line 249
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 250
    .local v0, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "upgradeLastCheckTime"

    invoke-interface {v0, v3}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getLong(Ljava/lang/String;)J

    move-result-wide v1

    .line 252
    .local v1, "time":J
    const-wide/32 v3, 0x36ee80

    invoke-static {v1, v2, v3, v4}, Lcom/amazon/mShop/util/UpgradeUtil;->checkTimeout(JJ)Z

    move-result v3

    return v3
.end method

.method public static showForceUpdateDialog(Landroid/content/Context;)V
    .locals 6
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 83
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 84
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    const/4 v4, 0x1

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setCancelable(Z)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 85
    new-instance v4, Lcom/amazon/mShop/util/UpgradeUtil$1;

    invoke-direct {v4}, Lcom/amazon/mShop/util/UpgradeUtil$1;-><init>()V

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 94
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v1

    .line 95
    .local v1, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 96
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$layout;->upgrade_dialog:I

    invoke-virtual {v4, v5}, Landroid/view/Window;->setContentView(I)V

    .line 97
    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$id;->upgrade_dialog_message:I

    invoke-virtual {v4, v5}, Landroid/view/Window;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 98
    .local v2, "messageTextView":Landroid/widget/TextView;
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->upgrade_dialog_message:I

    invoke-static {p0, v4}, Lcom/amazon/mShop/util/UpgradeUtil;->formatDialogMessage(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->upgrade_now:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/AmazonAlertDialog;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/Button;

    .line 101
    .local v3, "upgradeNowButton":Landroid/widget/Button;
    new-instance v4, Lcom/amazon/mShop/util/UpgradeUtil$2;

    invoke-direct {v4, v1}, Lcom/amazon/mShop/util/UpgradeUtil$2;-><init>(Lcom/amazon/mShop/AmazonAlertDialog;)V

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 111
    return-void
.end method

.method public static showUpgradeNotificationDialog(Landroid/content/Context;)V
    .locals 12
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 145
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v9

    invoke-virtual {v9}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v7

    .line 147
    .local v7, "store":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    new-instance v0, Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 148
    .local v0, "builder":Lcom/amazon/mShop/AmazonAlertDialog$Builder;
    const/4 v9, 0x1

    invoke-virtual {v0, v9}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setCancelable(Z)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 149
    new-instance v9, Lcom/amazon/mShop/util/UpgradeUtil$3;

    invoke-direct {v9}, Lcom/amazon/mShop/util/UpgradeUtil$3;-><init>()V

    invoke-virtual {v0, v9}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Lcom/amazon/mShop/AmazonAlertDialog$Builder;

    .line 157
    invoke-static {p0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v9

    sget v10, Lcom/amazon/mShop/android/lib/R$layout;->upgrade_notification_dialog:I

    const/4 v11, 0x0

    invoke-virtual {v9, v10, v11}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 158
    .local v2, "contentView":Landroid/view/View;
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->upgrade_dialog_button_container:I

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 159
    .local v1, "buttonContainer":Landroid/view/ViewGroup;
    invoke-static {p0, v1}, Lcom/amazon/mShop/util/UpgradeUtil;->initUpgradeButtonGroup(Landroid/content/Context;Landroid/view/ViewGroup;)V

    .line 161
    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog$Builder;->create()Lcom/amazon/mShop/AmazonAlertDialog;

    move-result-object v3

    .line 162
    .local v3, "dialog":Lcom/amazon/mShop/AmazonAlertDialog;
    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->show()V

    .line 163
    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonAlertDialog;->getWindow()Landroid/view/Window;

    move-result-object v9

    invoke-virtual {v9, v2}, Landroid/view/Window;->setContentView(Landroid/view/View;)V

    .line 164
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->upgrade_notification_dialog_message:I

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    .line 165
    .local v4, "messageTextView":Landroid/widget/TextView;
    sget v9, Lcom/amazon/mShop/android/lib/R$string;->upgrade_notification_dialog_message:I

    invoke-static {p0, v9}, Lcom/amazon/mShop/util/UpgradeUtil;->formatDialogMessage(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v4, v9}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 167
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->upgrade_now:I

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/widget/Button;

    .line 168
    .local v8, "upgradeNowButton":Landroid/widget/Button;
    new-instance v9, Lcom/amazon/mShop/util/UpgradeUtil$4;

    invoke-direct {v9, v3, v7}, Lcom/amazon/mShop/util/UpgradeUtil$4;-><init>(Lcom/amazon/mShop/AmazonAlertDialog;Lcom/amazon/rio/j2me/client/persistence/DataStore;)V

    invoke-virtual {v8, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 179
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->no_thanks:I

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/Button;

    .line 180
    .local v5, "noThanks":Landroid/widget/Button;
    new-instance v9, Lcom/amazon/mShop/util/UpgradeUtil$5;

    invoke-direct {v9, v3, v7}, Lcom/amazon/mShop/util/UpgradeUtil$5;-><init>(Lcom/amazon/mShop/AmazonAlertDialog;Lcom/amazon/rio/j2me/client/persistence/DataStore;)V

    invoke-virtual {v5, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 190
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->remind_me_later:I

    invoke-virtual {v2, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/Button;

    .line 191
    .local v6, "remindLater":Landroid/widget/Button;
    new-instance v9, Lcom/amazon/mShop/util/UpgradeUtil$6;

    invoke-direct {v9, v3, v7}, Lcom/amazon/mShop/util/UpgradeUtil$6;-><init>(Lcom/amazon/mShop/AmazonAlertDialog;Lcom/amazon/rio/j2me/client/persistence/DataStore;)V

    invoke-virtual {v6, v9}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 201
    const-string/jumbo v9, "upgradeLastDialogTime"

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v10

    invoke-interface {v7, v9, v10, v11}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putLong(Ljava/lang/String;J)V

    .line 202
    return-void
.end method
