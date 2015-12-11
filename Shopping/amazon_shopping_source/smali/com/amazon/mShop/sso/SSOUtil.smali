.class public Lcom/amazon/mShop/sso/SSOUtil;
.super Ljava/lang/Object;
.source "SSOUtil.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/sso/SSOUtil$1;,
        Lcom/amazon/mShop/sso/SSOUtil$AuthPool;,
        Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameTask;,
        Lcom/amazon/mShop/sso/SSOUtil$FetchUserFullNameListener;
    }
.end annotation


# static fields
.field public static final DEBUG:Z

.field private static volatile sLoginTriggeredFromApplication:Z

.field private static volatile sLogoutTriggeredFromApplication:Z

.field private static sTempAccountForCurrentLocale:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 124
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    .line 197
    sput-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->sLogoutTriggeredFromApplication:Z

    .line 207
    sput-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->sLoginTriggeredFromApplication:Z

    .line 545
    const/4 v0, 0x0

    sput-object v0, Lcom/amazon/mShop/sso/SSOUtil;->sTempAccountForCurrentLocale:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 63
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 218
    return-void
.end method

.method public static addAccountCustomKeyMapping(Ljava/lang/String;)V
    .locals 7
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 514
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 543
    :goto_0
    return-void

    .line 518
    :cond_0
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCustomKeyForAccountMapping()Ljava/lang/String;

    move-result-object v0

    .line 523
    .local v0, "accountKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getMultipleAccountManager()Lcom/amazon/identity/auth/device/api/MultipleAccountManager;

    move-result-object v1

    .line 525
    .local v1, "multipleAccountManager":Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
    new-instance v2, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v3

    invoke-direct {v2, v3}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0, v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 530
    new-array v2, v6, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$PackageMappingType;-><init>(Ljava/lang/String;)V

    aput-object v3, v2, v5

    invoke-virtual {v1, p0, v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    .line 534
    :cond_1
    new-instance v2, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;

    invoke-direct {v2, v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p0, v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->doesAccountHaveMapping(Ljava/lang/String;Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    move-result v2

    if-nez v2, :cond_3

    .line 535
    sget-boolean v2, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v2, :cond_2

    .line 536
    const-string/jumbo v2, "Amazon.SSOUtil"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "addCustomKeyMapping "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string/jumbo v4, " for "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 538
    :cond_2
    new-array v2, v6, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    new-instance v3, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;

    invoke-direct {v3, v0}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;-><init>(Ljava/lang/String;)V

    aput-object v3, v2, v5

    invoke-virtual {v1, p0, v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->setAccountMappings(Ljava/lang/String;[Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Z

    .line 542
    :cond_3
    const/4 v2, 0x0

    invoke-static {v2}, Lcom/amazon/mShop/sso/SSOUtil;->setTempAccountForCurrentLocale(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public static clearCookieAndCookieJarForAllLocales(Landroid/content/Context;)V
    .locals 4
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 422
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAllLocalesList()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 423
    .local v1, "localeName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "secureCookieJar.mShop"

    invoke-interface {v2, v3, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    .line 424
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "cookieJar.mShop"

    invoke-interface {v2, v3, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 428
    .end local v1    # "localeName":Ljava/lang/String;
    :cond_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->clearCookiesOfAllLocales(Landroid/content/Context;)V

    .line 429
    return-void
.end method

.method public static clearCookieAndCookieJarForWorldwideAuthPool(Landroid/content/Context;)V
    .locals 4
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 432
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getWorldWideAuthPoolLocalesList()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 433
    .local v1, "localeName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "secureCookieJar.mShop"

    invoke-interface {v2, v3, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    .line 434
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    const-string/jumbo v3, "cookieJar.mShop"

    invoke-interface {v2, v3, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 436
    .end local v1    # "localeName":Ljava/lang/String;
    :cond_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->clearCookiesOfAllLocales(Landroid/content/Context;)V

    .line 437
    return-void
.end method

.method public static clearCurrentLocaleCookieAndCookieJar(Landroid/content/Context;)V
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 415
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "secureCookieJar.mShop"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 416
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    const-string/jumbo v1, "cookieJar.mShop"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 417
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->clearCurrentLocaleCookies(Landroid/content/Context;)V

    .line 418
    return-void
.end method

.method public static clearLastSkipSiginTimeForAllAuthPools(Landroid/content/Context;)V
    .locals 8
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 786
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 788
    .local v2, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->values()[Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    move-result-object v0

    .local v0, "arr$":[Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
    array-length v4, v0

    .local v4, "len$":I
    const/4 v3, 0x0

    .local v3, "i$":I
    :goto_0
    if-ge v3, v4, :cond_0

    aget-object v1, v0, v3

    .line 789
    .local v1, "authPool":Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
    const-string/jumbo v5, "LAST_SKIP_SIGN_IN_TIME_IN_MS"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "MSHOP-ACCOUNT-"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->name()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v2, v5, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    .line 788
    add-int/lit8 v3, v3, 0x1

    goto :goto_0

    .line 791
    .end local v1    # "authPool":Lcom/amazon/mShop/sso/SSOUtil$AuthPool;
    :cond_0
    return-void
.end method

.method public static clearMShopUserDataInWorldwideAuthPool(Landroid/content/Context;)V
    .locals 1
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 444
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->clearCookieAndCookieJarForWorldwideAuthPool(Landroid/content/Context;)V

    .line 445
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->clearUserFullNameForWorldWideAuthPool()V

    .line 446
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->removePreviousAccountInWorldwideAuthPool()V

    .line 447
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->clearLastSkipSiginTimeForAllAuthPools(Landroid/content/Context;)V

    .line 450
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getWorldWideAuthPoolLocalesList()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/search/SearchActivity;->clearPreviousSearchTermForLocales(Ljava/util/List;)V

    .line 451
    return-void
.end method

.method public static clearMapSSOUserDataInAllLocales(Landroid/content/Context;)V
    .locals 1
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 460
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->clearCookieAndCookieJarForAllLocales(Landroid/content/Context;)V

    .line 461
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->removePreviousAccountInAllLocales()V

    .line 462
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->clearUserFullNameForAllLocales()V

    .line 463
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->clearLastSkipSiginTimeForAllAuthPools(Landroid/content/Context;)V

    .line 466
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAllLocalesList()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/search/SearchActivity;->clearPreviousSearchTermForLocales(Ljava/util/List;)V

    .line 467
    return-void
.end method

.method public static clearUserFullNameForAllLocales()V
    .locals 4

    .prologue
    .line 569
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 570
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getAllLocalesList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 571
    .local v2, "localeName":Ljava/lang/String;
    const-string/jumbo v3, "userFullName"

    invoke-interface {v0, v3, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 573
    .end local v2    # "localeName":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static clearUserFullNameForWorldWideAuthPool()V
    .locals 4

    .prologue
    .line 562
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 563
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    sget-object v3, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->Amazon:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getLocaleList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 564
    .local v2, "localeName":Ljava/lang/String;
    const-string/jumbo v3, "userFullName"

    invoke-interface {v0, v3, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 566
    .end local v2    # "localeName":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static clearUserInfoOfCurrentLocale()V
    .locals 2

    .prologue
    .line 406
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 408
    .local v0, "applicationContext":Landroid/content/Context;
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 410
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->removePreviouslySeenAmazonAccount()V

    .line 411
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->clearCurrentLocaleCookieAndCookieJar(Landroid/content/Context;)V

    .line 412
    return-void
.end method

.method public static getAllAccounts()Ljava/util/Set;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 470
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccounts()Ljava/util/Set;

    move-result-object v0

    return-object v0
.end method

.method public static getAllLocalesList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 291
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getAllLocalesList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getAuthPoolForCurrentLocale()Ljava/lang/String;
    .locals 2

    .prologue
    .line 581
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 582
    .local v0, "applicationContext":Landroid/content/Context;
    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_auth_pool:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getAuthPoolFromAccount(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 604
    const-string/jumbo v0, "com.amazon.dcp.sso.token.device.accountpool"

    .line 605
    .local v0, "key":Ljava/lang/String;
    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.accountpool"

    invoke-static {p0, v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCustomerAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;
    .locals 9
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 329
    const-string/jumbo v0, ""

    .line 331
    .local v0, "currentAccount":Ljava/lang/String;
    sget-object v5, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v6

    if-ne v5, v6, :cond_2

    .line 332
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->getPrimaryAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 333
    .local v4, "primaryAccount":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 334
    move-object v0, v4

    .end local v4    # "primaryAccount":Ljava/lang/String;
    :cond_0
    :goto_0
    move-object v1, v0

    .line 350
    :cond_1
    return-object v1

    .line 336
    :cond_2
    sget-object v5, Lcom/amazon/mShop/sso/IdentityType;->DISTRIBUTED_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v6

    if-ne v5, v6, :cond_0

    .line 338
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getTempAccountForCurrentLocale()Ljava/lang/String;

    move-result-object v1

    .line 339
    .local v1, "currentTempAccount":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 343
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCustomKeyForAccountMapping()Ljava/lang/String;

    move-result-object v2

    .line 344
    .local v2, "customKey":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getMultipleAccountManager()Lcom/amazon/identity/auth/device/api/MultipleAccountManager;

    move-result-object v5

    const/4 v6, 0x1

    new-array v6, v6, [Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;

    const/4 v7, 0x0

    new-instance v8, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;

    invoke-direct {v8, v2}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager$CustomKeyMappingType;-><init>(Ljava/lang/String;)V

    aput-object v8, v6, v7

    invoke-virtual {v5, v6}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;->getAccountForMapping([Lcom/amazon/identity/auth/device/api/MultipleAccountManager$AccountMappingType;)Ljava/lang/String;

    move-result-object v3

    .line 345
    .local v3, "directedId":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 346
    move-object v0, v3

    goto :goto_0
.end method

.method public static getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;
    .locals 4

    .prologue
    .line 305
    invoke-static {}, Lcom/amazon/mShop/platform/AppLocale;->getInstance()Lcom/amazon/mShop/platform/AppLocale;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AppLocale;->getCurrentLocale()Ljava/util/Locale;

    move-result-object v3

    invoke-virtual {v3}, Ljava/util/Locale;->toString()Ljava/lang/String;

    move-result-object v1

    .line 306
    .local v1, "localeName":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 308
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->hasAmazonAuthenticator(Landroid/content/Context;)Z

    move-result v3

    if-nez v3, :cond_0

    sget-object v2, Lcom/amazon/mShop/sso/IdentityType;->DISTRIBUTED_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    .line 312
    .local v2, "ssoType":Lcom/amazon/mShop/sso/IdentityType;
    :goto_0
    return-object v2

    .line 308
    .end local v2    # "ssoType":Lcom/amazon/mShop/sso/IdentityType;
    :cond_0
    const-string/jumbo v3, "zh_CN"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    const-string/jumbo v3, "ja_JP"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    sget-object v2, Lcom/amazon/mShop/sso/IdentityType;->CENTRAL_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    goto :goto_0

    :cond_1
    sget-object v2, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    goto :goto_0
.end method

.method private static getCustomKeyForAccountMapping()Ljava/lang/String;
    .locals 3

    .prologue
    .line 576
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v0

    .line 577
    .local v0, "authPoolName":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "MSHOP-ACCOUNT-"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method private static getCustomerAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 7
    .param p0, "account"    # Ljava/lang/String;
    .param p1, "attributeKey"    # Ljava/lang/String;

    .prologue
    .line 626
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 627
    .local v0, "applicationContext":Landroid/content/Context;
    const/4 v5, 0x0

    .line 629
    .local v5, "value":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 630
    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    move-result-object v2

    .line 631
    .local v2, "customerAttStore":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    const/4 v6, 0x0

    invoke-virtual {v2, p0, p1, v6}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getAttribute(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v4

    .line 633
    .local v4, "future":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :try_start_0
    invoke-interface {v4}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .line 634
    .local v1, "bundle":Landroid/os/Bundle;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getValueOrAttributeDefault(Landroid/os/Bundle;)Ljava/lang/String;
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    move-result-object v5

    .line 643
    .end local v1    # "bundle":Landroid/os/Bundle;
    .end local v2    # "customerAttStore":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    .end local v4    # "future":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :cond_0
    :goto_0
    return-object v5

    .line 635
    .restart local v2    # "customerAttStore":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    .restart local v4    # "future":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :catch_0
    move-exception v3

    .line 636
    .local v3, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->printStackTrace()V

    goto :goto_0

    .line 637
    .end local v3    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    :catch_1
    move-exception v3

    .line 638
    .local v3, "e":Ljava/lang/InterruptedException;
    invoke-virtual {v3}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_0

    .line 639
    .end local v3    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v3

    .line 640
    .local v3, "e":Ljava/util/concurrent/ExecutionException;
    invoke-virtual {v3}, Ljava/util/concurrent/ExecutionException;->printStackTrace()V

    goto :goto_0
.end method

.method public static getFullNameFromCustomerAttribute(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 615
    const-string/jumbo v0, "com.amazon.dcp.sso.property.username"

    .line 616
    .local v0, "key":Ljava/lang/String;
    const-string/jumbo v1, "com.amazon.dcp.sso.property.username"

    invoke-static {p0, v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCustomerAttribute(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    .locals 1
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 355
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method private static getMultipleAccountManager()Lcom/amazon/identity/auth/device/api/MultipleAccountManager;
    .locals 2

    .prologue
    .line 554
    new-instance v0, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MultipleAccountManager;-><init>(Landroid/content/Context;)V

    return-object v0
.end method

.method public static declared-synchronized getPreviouslySeenAmazonAccount()Ljava/lang/String;
    .locals 3

    .prologue
    .line 651
    const-class v2, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v2

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 652
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "previousAmazonAccount"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getString(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    monitor-exit v2

    return-object v1

    .line 651
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static getPrimaryAccount(Landroid/content/Context;)Ljava/lang/String;
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 359
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->getMAPAccountManager(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-result-object v0

    .line 360
    .local v0, "mapAccManager":Lcom/amazon/identity/auth/device/api/MAPAccountManager;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getPrimaryAccount()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public static declared-synchronized getTempAccountForCurrentLocale()Ljava/lang/String;
    .locals 2

    .prologue
    .line 550
    const-class v0, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v0

    :try_start_0
    sget-object v1, Lcom/amazon/mShop/sso/SSOUtil;->sTempAccountForCurrentLocale:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return-object v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static getWorldWideAuthPoolLocalesList()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 287
    sget-object v0, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->Amazon:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getLocaleList()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static handleSSOAccount(Landroid/content/Context;Ljava/lang/String;)V
    .locals 14
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 680
    invoke-static {p1}, Lcom/amazon/mShop/sso/SSOUtil;->addAccountCustomKeyMapping(Ljava/lang/String;)V

    .line 681
    invoke-static {p0, p1}, Lcom/amazon/mShop/sso/SSOUtil;->setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V

    .line 683
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v9

    .line 684
    .local v9, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v0, "hasFetchedNonauthCookies"

    invoke-interface {v9, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;)Z

    move-result v10

    .line 686
    .local v10, "hasFetchedNonAuthCookies":Z
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v11, 0x1

    .line 689
    .local v11, "hasSessionID":Z
    :goto_0
    if-eqz v11, :cond_1

    if-nez v10, :cond_1

    const/4 v13, 0x1

    .line 690
    .local v13, "xMainOnly":Z
    :goto_1
    if-eqz v13, :cond_3

    .line 691
    new-instance v8, Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    invoke-direct {v8, p1, p0}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;-><init>(Ljava/lang/String;Landroid/content/Context;)V

    .line 692
    .local v8, "cookieFetcher":Lcom/amazon/mShop/sso/MAPCookiesFetcher;
    invoke-virtual {v8}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->peekXCookie()Z

    move-result v12

    .line 694
    .local v12, "successful":Z
    if-eqz v12, :cond_2

    .line 696
    new-instance v0, Lcom/amazon/mShop/model/auth/User;

    const-string/jumbo v1, ""

    invoke-static {p1}, Lcom/amazon/mShop/sso/SSOUtil;->getFullNameFromCustomerAttribute(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const/4 v3, 0x0

    const/4 v4, 0x0

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-static {v6}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v6

    const/4 v7, 0x0

    invoke-direct/range {v0 .. v7}, Lcom/amazon/mShop/model/auth/User;-><init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/amazon/rio/j2me/client/services/mShop/Date;Ljava/lang/Boolean;Ljava/lang/String;)V

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->saveUser(Lcom/amazon/mShop/model/auth/User;)V

    .line 700
    new-instance v0, Lcom/amazon/mShop/sso/MShopCheckLogin;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-direct {v0, p0, v1, v2}, Lcom/amazon/mShop/sso/MShopCheckLogin;-><init>(Landroid/content/Context;ZLcom/amazon/mShop/sso/MShopCheckLogin$Subscriber;)V

    invoke-virtual {v0}, Lcom/amazon/mShop/sso/MShopCheckLogin;->checkLogin()V

    .line 711
    .end local v8    # "cookieFetcher":Lcom/amazon/mShop/sso/MAPCookiesFetcher;
    .end local v12    # "successful":Z
    :goto_2
    return-void

    .line 686
    .end local v11    # "hasSessionID":Z
    .end local v13    # "xMainOnly":Z
    :cond_0
    const/4 v11, 0x0

    goto :goto_0

    .line 689
    .restart local v11    # "hasSessionID":Z
    :cond_1
    const/4 v13, 0x0

    goto :goto_1

    .line 703
    .restart local v8    # "cookieFetcher":Lcom/amazon/mShop/sso/MAPCookiesFetcher;
    .restart local v12    # "successful":Z
    .restart local v13    # "xMainOnly":Z
    :cond_2
    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x1

    invoke-static {p0, v0, v1, p1, v2}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;Z)V

    goto :goto_2

    .line 708
    .end local v8    # "cookieFetcher":Lcom/amazon/mShop/sso/MAPCookiesFetcher;
    .end local v12    # "successful":Z
    :cond_3
    const/4 v0, 0x0

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-static {p0, v0, v1, p1, v2}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager;->syncAndWait(Landroid/content/Context;ZZLjava/lang/String;Z)V

    goto :goto_2
.end method

.method public static handleSigninPrompt(Landroid/content/Context;)Z
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 761
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->postSignInPromptFeatureTrigger()V

    .line 762
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->needSigninPrompt()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 763
    invoke-static {p0}, Lcom/amazon/mShop/util/ActivityUtils;->startSigninPromptActivity(Landroid/content/Context;)V

    .line 764
    const/4 v0, 0x1

    .line 766
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static hasAmazonAccount()Z
    .locals 1

    .prologue
    .line 193
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static hasAmazonAuthenticator(Landroid/content/Context;)Z
    .locals 11
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    const/4 v7, 0x0

    .line 162
    :try_start_0
    invoke-static {p0}, Landroid/accounts/AccountManager;->get(Landroid/content/Context;)Landroid/accounts/AccountManager;

    move-result-object v8

    invoke-virtual {v8}, Landroid/accounts/AccountManager;->getAuthenticatorTypes()[Landroid/accounts/AuthenticatorDescription;
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 167
    .local v1, "authTypes":[Landroid/accounts/AuthenticatorDescription;
    if-eqz v1, :cond_0

    array-length v8, v1

    if-lez v8, :cond_0

    .line 168
    move-object v0, v1

    .local v0, "arr$":[Landroid/accounts/AuthenticatorDescription;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_0

    aget-object v3, v0, v5

    .line 169
    .local v3, "desc":Landroid/accounts/AuthenticatorDescription;
    const-string/jumbo v8, "com.amazon.account"

    iget-object v9, v3, Landroid/accounts/AuthenticatorDescription;->type:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 170
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v8

    iget-object v9, v3, Landroid/accounts/AuthenticatorDescription;->packageName:Ljava/lang/String;

    invoke-virtual {p0}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v8, v9, v10}, Landroid/content/pm/PackageManager;->checkSignatures(Ljava/lang/String;Ljava/lang/String;)I

    move-result v2

    .line 172
    .local v2, "checkResult":I
    if-eqz v2, :cond_1

    .line 173
    const-string/jumbo v8, "Amazon.SSOUtil"

    const-string/jumbo v9, "Account Manager account type match but central package signature check failed"

    invoke-static {v8, v9}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 182
    .end local v0    # "arr$":[Landroid/accounts/AuthenticatorDescription;
    .end local v1    # "authTypes":[Landroid/accounts/AuthenticatorDescription;
    .end local v2    # "checkResult":I
    .end local v3    # "desc":Landroid/accounts/AuthenticatorDescription;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :cond_0
    :goto_1
    return v7

    .line 163
    :catch_0
    move-exception v4

    .line 164
    .local v4, "ex":Ljava/lang/RuntimeException;
    goto :goto_1

    .line 177
    .end local v4    # "ex":Ljava/lang/RuntimeException;
    .restart local v0    # "arr$":[Landroid/accounts/AuthenticatorDescription;
    .restart local v1    # "authTypes":[Landroid/accounts/AuthenticatorDescription;
    .restart local v2    # "checkResult":I
    .restart local v3    # "desc":Landroid/accounts/AuthenticatorDescription;
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    :cond_1
    const/4 v7, 0x1

    goto :goto_1

    .line 168
    .end local v2    # "checkResult":I
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0
.end method

.method public static ignoreOptOutSSOIfneeded()V
    .locals 5

    .prologue
    .line 809
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v0

    .line 810
    .local v0, "currentAuthPool":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v1

    .line 811
    .local v1, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v3, "ignoreOptOutFirstLaunch"

    invoke-interface {v1, v3, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getBoolean(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    .line 812
    .local v2, "optOutFirstLaunch":Z
    if-nez v2, :cond_0

    .line 813
    const-string/jumbo v3, "ignoreOptOutFirstLaunch"

    const/4 v4, 0x1

    invoke-interface {v1, v3, v4, v0}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putBoolean(Ljava/lang/String;ZLjava/lang/String;)V

    .line 815
    :cond_0
    return-void
.end method

.method public static isAppstoreInstalledWithSpecificVersion(Landroid/content/Context;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 718
    const-string/jumbo v4, "com.amazon.venezia"

    .line 719
    .local v4, "packageName":Ljava/lang/String;
    const v5, 0x25f7d940

    .line 721
    .local v5, "versionCode":I
    const/4 v0, 0x0

    .line 723
    .local v0, "appInstalled":Z
    :try_start_0
    invoke-virtual {p0}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 724
    .local v2, "manager":Landroid/content/pm/PackageManager;
    const/4 v6, 0x0

    invoke-virtual {v2, v4, v6}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v3

    .line 725
    .local v3, "packageInfo":Landroid/content/pm/PackageInfo;
    if-eqz v3, :cond_0

    iget v6, v3, Landroid/content/pm/PackageInfo;->versionCode:I
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    if-lt v6, v5, :cond_0

    .line 726
    const/4 v0, 0x1

    .line 732
    .end local v2    # "manager":Landroid/content/pm/PackageManager;
    .end local v3    # "packageInfo":Landroid/content/pm/PackageInfo;
    :cond_0
    :goto_0
    return v0

    .line 729
    :catch_0
    move-exception v1

    .line 730
    .local v1, "ex":Landroid/content/pm/PackageManager$NameNotFoundException;
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static declared-synchronized isLoginTriggeredFromApplication()Z
    .locals 2

    .prologue
    .line 212
    const-class v0, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v0

    :try_start_0
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->sLoginTriggeredFromApplication:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized isLogoutTriggeredFromApplication()Z
    .locals 2

    .prologue
    .line 202
    const-class v0, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v0

    :try_start_0
    sget-boolean v1, Lcom/amazon/mShop/sso/SSOUtil;->sLogoutTriggeredFromApplication:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit v0

    return v1

    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static isSSOSupported(Landroid/content/Context;)Z
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 144
    sget-object v0, Lcom/amazon/mShop/sso/IdentityType;->NON_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v1

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private static isSkipSigninOverdue(Landroid/content/Context;)Z
    .locals 7
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 801
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v5

    invoke-interface {v5}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 802
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v5, "LAST_SKIP_SIGN_IN_TIME_IN_MS"

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCustomKeyForAccountMapping()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v5, v6}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->getLong(Ljava/lang/String;Ljava/lang/String;)J

    move-result-wide v3

    .line 803
    .local v3, "lastSkipSignInTime":J
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    sub-long v1, v5, v3

    .line 804
    .local v1, "delta":J
    const-wide v5, 0x9a7ec800L

    cmp-long v5, v1, v5

    if-lez v5, :cond_0

    const/4 v5, 0x1

    :goto_0
    return v5

    :cond_0
    const/4 v5, 0x0

    goto :goto_0
.end method

.method public static needSigninPrompt()Z
    .locals 3

    .prologue
    .line 745
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 746
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 748
    .local v1, "currentAccount":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSignInPrompt()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->isSkipSigninOverdue(Landroid/content/Context;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v2, 0x1

    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public static peekAuthPoolFromAccount(Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 592
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 593
    .local v0, "applicationContext":Landroid/content/Context;
    const-string/jumbo v1, "com.amazon.dcp.sso.token.device.accountpool"

    .line 594
    .local v1, "key":Ljava/lang/String;
    const-string/jumbo v2, "com.amazon.dcp.sso.token.device.accountpool"

    invoke-static {v0, p0, v2}, Lcom/amazon/mShop/sso/SSOUtil;->peekCustomerAttributeForAccount(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static peekCustomerAttribute(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "key"    # Ljava/lang/String;

    .prologue
    .line 364
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 365
    .local v1, "currentAccount":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/content/Context;

    .line 366
    .local v0, "applicationContext":Landroid/content/Context;
    invoke-static {v0, v1, p1}, Lcom/amazon/mShop/sso/SSOUtil;->peekCustomerAttributeForAccount(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method public static peekCustomerAttributeForAccount(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "key"    # Ljava/lang/String;

    .prologue
    .line 379
    const/4 v0, 0x0

    .line 380
    .local v0, "attribute":Ljava/lang/String;
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 381
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;

    move-result-object v2

    .line 382
    .local v2, "customerAttStore":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    invoke-virtual {v2, p1, p2}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->peekAttribute(Ljava/lang/String;Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v1

    .line 383
    .local v1, "attributeBundle":Landroid/os/Bundle;
    invoke-static {v1}, Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;->getValueOrAttributeDefault(Landroid/os/Bundle;)Ljava/lang/String;

    move-result-object v0

    .line 385
    .end local v1    # "attributeBundle":Landroid/os/Bundle;
    .end local v2    # "customerAttStore":Lcom/amazon/identity/auth/device/api/CustomerAttributeStore;
    :cond_0
    return-object v0
.end method

.method public static removePreviousAccountInAllLocales()V
    .locals 4

    .prologue
    .line 389
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 390
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getAllLocalesList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 391
    .local v2, "localeName":Ljava/lang/String;
    const-string/jumbo v3, "previousAmazonAccount"

    invoke-interface {v0, v3, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 393
    .end local v2    # "localeName":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static removePreviousAccountInWorldwideAuthPool()V
    .locals 4

    .prologue
    .line 396
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 397
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    sget-object v3, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->Amazon:Lcom/amazon/mShop/sso/SSOUtil$AuthPool;

    invoke-virtual {v3}, Lcom/amazon/mShop/sso/SSOUtil$AuthPool;->getLocaleList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 398
    .local v2, "localeName":Ljava/lang/String;
    const-string/jumbo v3, "previousAmazonAccount"

    invoke-interface {v0, v3, v2}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 400
    .end local v2    # "localeName":Ljava/lang/String;
    :cond_0
    return-void
.end method

.method public static declared-synchronized removePreviouslySeenAmazonAccount()V
    .locals 3

    .prologue
    .line 661
    const-class v2, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v2

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 662
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "previousAmazonAccount"

    invoke-interface {v0, v1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 663
    monitor-exit v2

    return-void

    .line 661
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static selectMatchedAccount()Ljava/lang/String;
    .locals 8

    .prologue
    .line 483
    const-string/jumbo v5, ""

    .line 484
    .local v5, "selectedAccount":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    .line 485
    .local v1, "applicationContext":Landroid/content/Context;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 487
    .local v2, "currentLocaleAccount":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 489
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getAuthPoolForCurrentLocale()Ljava/lang/String;

    move-result-object v3

    .line 490
    .local v3, "localeAuthPool":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->getPrimaryAccount(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v4

    .line 491
    .local v4, "primaryAccount":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/sso/SSOUtil;->peekAuthPoolFromAccount(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 492
    .local v0, "accountAuthPool":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 493
    move-object v5, v4

    .line 500
    .end local v0    # "accountAuthPool":Ljava/lang/String;
    .end local v3    # "localeAuthPool":Ljava/lang/String;
    .end local v4    # "primaryAccount":Ljava/lang/String;
    :cond_0
    :goto_0
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    sget-object v6, Lcom/amazon/mShop/sso/IdentityType;->DISTRIBUTED_SSO_TYPE:Lcom/amazon/mShop/sso/IdentityType;

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v7

    if-ne v6, v7, :cond_1

    .line 501
    invoke-static {v5}, Lcom/amazon/mShop/sso/SSOUtil;->addAccountCustomKeyMapping(Ljava/lang/String;)V

    .line 503
    :cond_1
    return-object v5

    .line 496
    :cond_2
    move-object v5, v2

    goto :goto_0
.end method

.method public static declared-synchronized setLoginTriggeredFromApplication(Z)V
    .locals 2
    .param p0, "loginTriggeredFromApplication"    # Z

    .prologue
    .line 209
    const-class v0, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v0

    :try_start_0
    sput-boolean p0, Lcom/amazon/mShop/sso/SSOUtil;->sLoginTriggeredFromApplication:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 210
    monitor-exit v0

    return-void

    .line 209
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setLogoutTriggeredFromApplication(Z)V
    .locals 2
    .param p0, "logoutTriggeredFromApplication"    # Z

    .prologue
    .line 199
    const-class v0, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v0

    :try_start_0
    sput-boolean p0, Lcom/amazon/mShop/sso/SSOUtil;->sLogoutTriggeredFromApplication:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 200
    monitor-exit v0

    return-void

    .line 199
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static declared-synchronized setPreviouslySeenAmazonAccount(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "account"    # Ljava/lang/String;

    .prologue
    .line 656
    const-class v2, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v2

    :try_start_0
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 657
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v1, "previousAmazonAccount"

    invoke-interface {v0, v1, p1}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 658
    monitor-exit v2

    return-void

    .line 656
    .end local v0    # "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    :catchall_0
    move-exception v1

    monitor-exit v2

    throw v1
.end method

.method public static declared-synchronized setTempAccountForCurrentLocale(Ljava/lang/String;)V
    .locals 2
    .param p0, "account"    # Ljava/lang/String;

    .prologue
    .line 547
    const-class v0, Lcom/amazon/mShop/sso/SSOUtil;

    monitor-enter v0

    :try_start_0
    sput-object p0, Lcom/amazon/mShop/sso/SSOUtil;->sTempAccountForCurrentLocale:Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 548
    monitor-exit v0

    return-void

    .line 547
    :catchall_0
    move-exception v1

    monitor-exit v0

    throw v1
.end method

.method public static skipSigin(Landroid/content/Context;)V
    .locals 5
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 780
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v3

    invoke-interface {v3}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v2

    .line 781
    .local v2, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    .line 782
    .local v0, "currentTime":J
    const-string/jumbo v3, "LAST_SKIP_SIGN_IN_TIME_IN_MS"

    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCustomKeyForAccountMapping()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v2, v3, v0, v1, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->putLong(Ljava/lang/String;JLjava/lang/String;)V

    .line 783
    return-void
.end method
