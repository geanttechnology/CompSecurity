.class public Lcom/amazon/mShop/sso/CookieHelper;
.super Ljava/lang/Object;
.source "CookieHelper.java"


# static fields
.field private static final DEBUG:Z

.field private static final TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/sso/CookieHelper;->DEBUG:Z

    .line 18
    const-class v0, Lcom/amazon/mShop/sso/CookieHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/sso/CookieHelper;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static extractXCookie(Landroid/content/Context;[Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "cookieSet"    # [Ljava/lang/String;

    .prologue
    .line 58
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_0
    if-ge v2, v3, :cond_2

    aget-object v1, v0, v2

    .line 59
    .local v1, "cookie":Ljava/lang/String;
    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 60
    .local v4, "trimmedCookie":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    const-string/jumbo v5, "x-main"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    const-string/jumbo v5, "x-acb"

    invoke-virtual {v4, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 66
    .end local v1    # "cookie":Ljava/lang/String;
    .end local v4    # "trimmedCookie":Ljava/lang/String;
    :cond_0
    :goto_1
    return-object v4

    .line 58
    .restart local v1    # "cookie":Ljava/lang/String;
    .restart local v4    # "trimmedCookie":Ljava/lang/String;
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 66
    .end local v1    # "cookie":Ljava/lang/String;
    .end local v4    # "trimmedCookie":Ljava/lang/String;
    :cond_2
    const/4 v4, 0x0

    goto :goto_1
.end method

.method public static declared-synchronized setCookies(Landroid/content/Context;[Ljava/lang/String;)V
    .locals 10
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "cookies"    # [Ljava/lang/String;

    .prologue
    .line 78
    const-class v7, Lcom/amazon/mShop/sso/CookieHelper;

    monitor-enter v7

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v6

    if-eqz v6, :cond_0

    .line 99
    :goto_0
    monitor-exit v7

    return-void

    .line 82
    :cond_0
    :try_start_1
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v5

    .line 85
    .local v5, "webkitCookieManager":Landroid/webkit/CookieManager;
    const/4 v6, 0x1

    invoke-static {p0, v6}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v4

    .line 87
    .local v4, "url":Ljava/lang/String;
    move-object v0, p1

    .local v0, "arr$":[Ljava/lang/String;
    array-length v3, v0

    .local v3, "len$":I
    const/4 v2, 0x0

    .local v2, "i$":I
    :goto_1
    if-ge v2, v3, :cond_2

    aget-object v1, v0, v2

    .line 88
    .local v1, "cookie":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 89
    invoke-virtual {v5, v4, v1}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 87
    :cond_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 93
    .end local v1    # "cookie":Ljava/lang/String;
    :cond_2
    sget-boolean v6, Lcom/amazon/mShop/sso/CookieHelper;->DEBUG:Z

    if-eqz v6, :cond_3

    .line 94
    sget-object v6, Lcom/amazon/mShop/sso/CookieHelper;->TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "setCookies: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v5, v4}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v6, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 97
    :cond_3
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v6

    invoke-virtual {v6}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 78
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "i$":I
    .end local v3    # "len$":I
    .end local v4    # "url":Ljava/lang/String;
    .end local v5    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v6

    monitor-exit v7

    throw v6
.end method

.method public static declared-synchronized setXCookie(Landroid/content/Context;[Ljava/lang/String;)Z
    .locals 8
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "cookieSet"    # [Ljava/lang/String;

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 31
    const-class v5, Lcom/amazon/mShop/sso/CookieHelper;

    monitor-enter v5

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v6

    if-eqz v6, :cond_1

    .line 47
    :cond_0
    :goto_0
    monitor-exit v5

    return v3

    .line 35
    :cond_1
    :try_start_1
    invoke-static {p0, p1}, Lcom/amazon/mShop/sso/CookieHelper;->extractXCookie(Landroid/content/Context;[Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 36
    .local v2, "xCookie":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 37
    const/4 v3, 0x1

    invoke-static {p0, v3}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v0

    .line 38
    .local v0, "url":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v1

    .line 40
    .local v1, "webkitCookieManager":Landroid/webkit/CookieManager;
    sget-boolean v3, Lcom/amazon/mShop/sso/CookieHelper;->DEBUG:Z

    if-eqz v3, :cond_2

    .line 41
    sget-object v3, Lcom/amazon/mShop/sso/CookieHelper;->TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "setXCookie: "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v3, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 43
    :cond_2
    invoke-virtual {v1, v0, v2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 44
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move v3, v4

    .line 45
    goto :goto_0

    .line 31
    .end local v0    # "url":Ljava/lang/String;
    .end local v1    # "webkitCookieManager":Landroid/webkit/CookieManager;
    .end local v2    # "xCookie":Ljava/lang/String;
    :catchall_0
    move-exception v3

    monitor-exit v5

    throw v3
.end method
