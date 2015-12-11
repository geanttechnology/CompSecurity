.class public Lcom/amazon/mShop/appstore/AppstoreUtils;
.super Ljava/lang/Object;
.source "AppstoreUtils.java"


# static fields
.field private static final APPSTORE_COOKIE_USER_LISTENER:Lcom/amazon/mShop/model/auth/UserListener;

.field private static final APPSTORE_DEVICE_INFO_COOKIE_PROVIDER:Landroid/net/Uri;

.field private static final TAG:Ljava/lang/String;

.field private static sAppStoreInitialized:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const-class v0, Lcom/amazon/mShop/appstore/AppstoreUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->TAG:Ljava/lang/String;

    .line 21
    const-string/jumbo v0, "content://com.amazon.mas.client.framework.DeviceInfoCookieContentProvider"

    invoke-static {v0}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->APPSTORE_DEVICE_INFO_COOKIE_PROVIDER:Landroid/net/Uri;

    .line 24
    new-instance v0, Lcom/amazon/mShop/appstore/AppstoreUtils$1;

    invoke-direct {v0}, Lcom/amazon/mShop/appstore/AppstoreUtils$1;-><init>()V

    sput-object v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->APPSTORE_COOKIE_USER_LISTENER:Lcom/amazon/mShop/model/auth/UserListener;

    .line 48
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->sAppStoreInitialized:Z

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 17
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getAppstoreDeviceInfoCookie(Landroid/content/Context;)Ljava/lang/String;
    .locals 8
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    const/4 v2, 0x0

    .line 51
    invoke-virtual {p0}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v0

    sget-object v1, Lcom/amazon/mShop/appstore/AppstoreUtils;->APPSTORE_DEVICE_INFO_COOKIE_PROVIDER:Landroid/net/Uri;

    move-object v3, v2

    move-object v4, v2

    move-object v5, v2

    invoke-virtual/range {v0 .. v5}, Landroid/content/ContentResolver;->query(Landroid/net/Uri;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;

    move-result-object v7

    .line 53
    .local v7, "cursor":Landroid/database/Cursor;
    if-nez v7, :cond_1

    .line 54
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    sget-object v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Cursor returned from content provider is empty."

    invoke-static {v0, v1}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 68
    :cond_0
    :goto_0
    return-object v2

    .line 61
    :cond_1
    :try_start_0
    invoke-interface {v7}, Landroid/database/Cursor;->moveToFirst()Z

    .line 62
    const-string/jumbo v0, "cookie"

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getColumnIndex(Ljava/lang/String;)I

    move-result v0

    invoke-interface {v7, v0}, Landroid/database/Cursor;->getString(I)Ljava/lang/String;

    move-result-object v6

    .line 63
    .local v6, "cookie":Ljava/lang/String;
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 64
    sget-object v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Appstore device info cookie fetched: %s."

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object v6, v2, v3

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    :cond_2
    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    move-object v2, v6

    goto :goto_0

    .end local v6    # "cookie":Ljava/lang/String;
    :catchall_0
    move-exception v0

    invoke-interface {v7}, Landroid/database/Cursor;->close()V

    throw v0
.end method

.method public static isAppstoreAvailable()Z
    .locals 1

    .prologue
    .line 89
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_hasAppstore:I

    invoke-static {v0}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(I)Z

    move-result v0

    if-eqz v0, :cond_0

    sget-boolean v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->sAppStoreInitialized:Z

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static setAppstoreDeviceInfoCookie(Landroid/content/Context;)V
    .locals 5
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 77
    const/4 v2, 0x1

    invoke-static {p0, v2}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 78
    .local v1, "domain":Ljava/lang/String;
    invoke-static {p0}, Lcom/amazon/mShop/appstore/AppstoreUtils;->getAppstoreDeviceInfoCookie(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v0

    .line 79
    .local v0, "cookie":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 80
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "www"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3, v0}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 82
    :cond_0
    return-void
.end method

.method public static setAppstoreInitialized()V
    .locals 1

    .prologue
    .line 95
    const/4 v0, 0x1

    sput-boolean v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->sAppStoreInitialized:Z

    .line 96
    return-void
.end method

.method public static setUpAppstoreDeviceInfoCookieListener()V
    .locals 1

    .prologue
    .line 85
    sget-object v0, Lcom/amazon/mShop/appstore/AppstoreUtils;->APPSTORE_COOKIE_USER_LISTENER:Lcom/amazon/mShop/model/auth/UserListener;

    invoke-static {v0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 86
    return-void
.end method
