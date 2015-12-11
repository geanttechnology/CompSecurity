.class Lcom/amazon/device/ads/WebViewFactory;
.super Ljava/lang/Object;
.source "WebViewFactory.java"


# static fields
.field private static instance:Lcom/amazon/device/ads/WebViewFactory;

.field private static isWebViewCheckedAndOk:Z


# instance fields
.field private cookieSyncManagerCreated:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    new-instance v0, Lcom/amazon/device/ads/WebViewFactory;

    invoke-direct {v0}, Lcom/amazon/device/ads/WebViewFactory;-><init>()V

    sput-object v0, Lcom/amazon/device/ads/WebViewFactory;->instance:Lcom/amazon/device/ads/WebViewFactory;

    .line 21
    const/4 v0, 0x0

    sput-boolean v0, Lcom/amazon/device/ads/WebViewFactory;->isWebViewCheckedAndOk:Z

    return-void
.end method

.method protected constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/WebViewFactory;->cookieSyncManagerCreated:Z

    .line 26
    return-void
.end method

.method protected static doesExceptionContainLockedDatabaseMessage(Ljava/lang/Exception;)Z
    .locals 3
    .param p0, "e"    # Ljava/lang/Exception;

    .prologue
    .line 143
    const-string/jumbo v0, "database is locked"

    .line 145
    .local v0, "lockedDatabaseMessage":Ljava/lang/String;
    if-eqz p0, :cond_0

    invoke-virtual {p0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    if-nez v1, :cond_1

    :cond_0
    const/4 v1, 0x0

    :goto_0
    return v1

    :cond_1
    invoke-virtual {p0}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "database is locked"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    goto :goto_0
.end method

.method public static final getInstance()Lcom/amazon/device/ads/WebViewFactory;
    .locals 1

    .prologue
    .line 29
    sget-object v0, Lcom/amazon/device/ads/WebViewFactory;->instance:Lcom/amazon/device/ads/WebViewFactory;

    return-object v0
.end method

.method protected static isDatabaseLocked(Landroid/database/sqlite/SQLiteException;)Z
    .locals 2
    .param p0, "e"    # Landroid/database/sqlite/SQLiteException;

    .prologue
    .line 128
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    .line 130
    invoke-static {p0}, Lcom/amazon/device/ads/AndroidTargetUtils;->isInstanceOfSQLiteDatabaseLockedException(Landroid/database/sqlite/SQLiteException;)Z

    move-result v0

    .line 133
    :goto_0
    return v0

    :cond_0
    invoke-static {p0}, Lcom/amazon/device/ads/WebViewFactory;->doesExceptionContainLockedDatabaseMessage(Ljava/lang/Exception;)Z

    move-result v0

    goto :goto_0
.end method

.method public static isWebViewOk(Landroid/content/Context;)Z
    .locals 7
    .param p0, "c"    # Landroid/content/Context;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 85
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0x8

    if-gt v5, v6, :cond_3

    .line 88
    sget-boolean v5, Lcom/amazon/device/ads/WebViewFactory;->isWebViewCheckedAndOk:Z

    if-nez v5, :cond_3

    .line 90
    invoke-static {p0}, Landroid/webkit/WebViewDatabase;->getInstance(Landroid/content/Context;)Landroid/webkit/WebViewDatabase;

    move-result-object v2

    .line 91
    .local v2, "wvDb":Landroid/webkit/WebViewDatabase;
    if-nez v2, :cond_1

    .line 116
    .end local v2    # "wvDb":Landroid/webkit/WebViewDatabase;
    :cond_0
    :goto_0
    return v3

    .line 96
    .restart local v2    # "wvDb":Landroid/webkit/WebViewDatabase;
    :cond_1
    const/4 v0, 0x0

    .line 99
    .local v0, "cdb":Landroid/database/sqlite/SQLiteDatabase;
    :try_start_0
    const-string/jumbo v3, "webviewCache.db"

    const/4 v5, 0x0

    const/4 v6, 0x0

    invoke-virtual {p0, v3, v5, v6}, Landroid/content/Context;->openOrCreateDatabase(Ljava/lang/String;ILandroid/database/sqlite/SQLiteDatabase$CursorFactory;)Landroid/database/sqlite/SQLiteDatabase;
    :try_end_0
    .catch Landroid/database/sqlite/SQLiteException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 108
    if-eqz v0, :cond_2

    .line 110
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    .line 113
    :cond_2
    sput-boolean v4, Lcom/amazon/device/ads/WebViewFactory;->isWebViewCheckedAndOk:Z

    .end local v0    # "cdb":Landroid/database/sqlite/SQLiteDatabase;
    .end local v2    # "wvDb":Landroid/webkit/WebViewDatabase;
    :cond_3
    move v3, v4

    .line 116
    goto :goto_0

    .line 101
    .restart local v0    # "cdb":Landroid/database/sqlite/SQLiteDatabase;
    .restart local v2    # "wvDb":Landroid/webkit/WebViewDatabase;
    :catch_0
    move-exception v1

    .line 104
    .local v1, "e":Landroid/database/sqlite/SQLiteException;
    :try_start_1
    invoke-static {v1}, Lcom/amazon/device/ads/WebViewFactory;->isDatabaseLocked(Landroid/database/sqlite/SQLiteException;)Z
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    .line 108
    if-eqz v0, :cond_0

    .line 110
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    goto :goto_0

    .line 108
    .end local v1    # "e":Landroid/database/sqlite/SQLiteException;
    :catchall_0
    move-exception v3

    if-eqz v0, :cond_4

    .line 110
    invoke-virtual {v0}, Landroid/database/sqlite/SQLiteDatabase;->close()V

    :cond_4
    throw v3
.end method

.method protected static setInstance(Lcom/amazon/device/ads/WebViewFactory;)V
    .locals 0
    .param p0, "newInstance"    # Lcom/amazon/device/ads/WebViewFactory;

    .prologue
    .line 33
    sput-object p0, Lcom/amazon/device/ads/WebViewFactory;->instance:Lcom/amazon/device/ads/WebViewFactory;

    .line 34
    return-void
.end method

.method public static final setJavaScriptEnabledForWebView(ZLandroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 2
    .param p0, "enable"    # Z
    .param p1, "webView"    # Landroid/webkit/WebView;
    .param p2, "logtag"    # Ljava/lang/String;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    .line 160
    :try_start_0
    invoke-virtual {p1}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, p0}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V
    :try_end_0
    .catch Ljava/lang/NullPointerException; {:try_start_0 .. :try_end_0} :catch_0

    .line 170
    const/4 v1, 0x1

    :goto_0
    return v1

    .line 162
    :catch_0
    move-exception v0

    .line 166
    .local v0, "e":Ljava/lang/NullPointerException;
    const-string/jumbo v1, "Could not set JavaScriptEnabled because a NullPointerException was encountered."

    invoke-static {p2, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 167
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private updateAdIdCookie()V
    .locals 4

    .prologue
    .line 53
    iget-boolean v1, p0, Lcom/amazon/device/ads/WebViewFactory;->cookieSyncManagerCreated:Z

    if-eqz v1, :cond_1

    .line 60
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/device/ads/IInternalAdRegistration;->getRegistrationInfo()Lcom/amazon/device/ads/RegistrationInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/device/ads/RegistrationInfo;->getAdId()Ljava/lang/String;

    move-result-object v0

    .line 61
    .local v0, "adId":Ljava/lang/String;
    if-nez v0, :cond_0

    .line 63
    const-string/jumbo v0, ""

    .line 66
    :cond_0
    const-string/jumbo v1, "http://amazon-adsystem.com"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "ad-id="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "; Domain=.amazon-adsystem.com"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0, v1, v2}, Lcom/amazon/device/ads/WebViewFactory;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 68
    .end local v0    # "adId":Ljava/lang/String;
    :cond_1
    return-void
.end method


# virtual methods
.method public declared-synchronized createWebView(Landroid/content/Context;)Landroid/webkit/WebView;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 38
    monitor-enter p0

    :try_start_0
    new-instance v0, Landroid/webkit/WebView;

    invoke-direct {v0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 39
    .local v0, "webView":Landroid/webkit/WebView;
    iget-boolean v1, p0, Lcom/amazon/device/ads/WebViewFactory;->cookieSyncManagerCreated:Z

    if-nez v1, :cond_0

    .line 41
    invoke-static {p1}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 42
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/device/ads/WebViewFactory;->cookieSyncManagerCreated:Z

    .line 45
    :cond_0
    invoke-direct {p0}, Lcom/amazon/device/ads/WebViewFactory;->updateAdIdCookie()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 47
    monitor-exit p0

    return-object v0

    .line 38
    .end local v0    # "webView":Landroid/webkit/WebView;
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method protected setCookie(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "cookie"    # Ljava/lang/String;

    .prologue
    .line 72
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 73
    return-void
.end method
