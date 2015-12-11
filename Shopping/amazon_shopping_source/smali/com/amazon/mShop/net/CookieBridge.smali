.class public final Lcom/amazon/mShop/net/CookieBridge;
.super Ljava/net/CookieHandler;
.source "CookieBridge.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 45
    invoke-direct {p0}, Ljava/net/CookieHandler;-><init>()V

    return-void
.end method

.method private static buildSetCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 3
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "secure"    # Z
    .param p2, "cookieKey"    # Ljava/lang/String;
    .param p3, "cookieValue"    # Ljava/lang/String;

    .prologue
    .line 170
    invoke-static {p0, p1}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v0

    .line 172
    .local v0, "domain":Ljava/lang/String;
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "; Domain="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "; "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    if-eqz p1, :cond_0

    const-string/jumbo v1, " Secure; "

    :goto_0
    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "Path=/"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    return-object v1

    :cond_0
    const-string/jumbo v1, ""

    goto :goto_0
.end method

.method public static declared-synchronized clearCookiesOfAllLocales(Landroid/content/Context;)V
    .locals 9
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 297
    const-class v7, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v7

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 298
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v4

    .line 300
    .local v4, "webkitCookieManager":Landroid/webkit/CookieManager;
    const-string/jumbo v5, "lc"

    invoke-static {v5, p0}, Lcom/amazon/mShop/net/CookieBridge;->getCookie(Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;

    move-result-object v2

    .line 301
    .local v2, "localeCookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const-string/jumbo v5, "ubid"

    invoke-static {v5, p0}, Lcom/amazon/mShop/net/CookieBridge;->getCookie(Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;

    move-result-object v3

    .line 302
    .local v3, "ubidCookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {v4}, Landroid/webkit/CookieManager;->removeAllCookie()V

    .line 304
    if-eqz v2, :cond_0

    .line 305
    invoke-interface {v2}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 306
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v8, 0x0

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {p0, v8, v5, v6}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 297
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    .end local v2    # "localeCookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v3    # "ubidCookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v4    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v5

    monitor-exit v7

    throw v5

    .line 310
    .restart local v2    # "localeCookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v3    # "ubidCookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .restart local v4    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :cond_0
    if-eqz v3, :cond_1

    .line 311
    :try_start_1
    invoke-interface {v3}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .restart local v1    # "i$":Ljava/util/Iterator;
    :goto_1
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 312
    .restart local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v8, 0x0

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Ljava/lang/String;

    invoke-static {p0, v8, v5, v6}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V

    goto :goto_1

    .line 316
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "i$":Ljava/util/Iterator;
    :cond_1
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v5

    invoke-virtual {v5}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 318
    monitor-exit v7

    return-void
.end method

.method public static declared-synchronized clearCurrentLocaleCookies(Landroid/content/Context;)V
    .locals 11
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 371
    const-class v7, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v7

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 373
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v5

    .line 375
    .local v5, "webkitCookieManager":Landroid/webkit/CookieManager;
    const/4 v6, 0x1

    invoke-static {p0, v6}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 377
    .local v0, "cookies":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v6

    if-eqz v6, :cond_0

    .line 406
    :goto_0
    monitor-exit v7

    return-void

    .line 381
    :cond_0
    :try_start_1
    const-string/jumbo v6, ";"

    invoke-virtual {v0, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 383
    .local v1, "cookiesArray":[Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 384
    const/4 v3, 0x0

    .local v3, "i":I
    :goto_1
    array-length v6, v1

    if-ge v3, v6, :cond_3

    .line 385
    aget-object v6, v1, v3

    const-string/jumbo v8, "="

    invoke-virtual {v6, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 386
    .local v2, "firstEqualsIndex":I
    const/4 v4, 0x0

    .line 387
    .local v4, "key":Ljava/lang/String;
    const/4 v6, -0x1

    if-ne v2, v6, :cond_2

    .line 388
    aget-object v6, v1, v3

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 399
    :goto_2
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string/jumbo v6, "lc"

    invoke-virtual {v4, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    const-string/jumbo v6, "ubid"

    invoke-virtual {v4, v6}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 400
    const/4 v6, 0x0

    const-string/jumbo v8, ""

    invoke-static {p0, v6, v4, v8}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V

    .line 384
    :cond_1
    add-int/lit8 v3, v3, 0x1

    goto :goto_1

    .line 390
    :cond_2
    aget-object v6, v1, v3

    const/4 v8, 0x0

    aget-object v9, v1, v3

    const-string/jumbo v10, "="

    invoke-virtual {v9, v10}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v9

    invoke-virtual {v6, v8, v9}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    goto :goto_2

    .line 405
    .end local v2    # "firstEqualsIndex":I
    .end local v3    # "i":I
    .end local v4    # "key":Ljava/lang/String;
    :cond_3
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v6

    invoke-virtual {v6}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 371
    .end local v0    # "cookies":Ljava/lang/String;
    .end local v1    # "cookiesArray":[Ljava/lang/String;
    .end local v5    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v6

    monitor-exit v7

    throw v6
.end method

.method public static declared-synchronized getAtMainCookie(Landroid/content/Context;)Ljava/lang/String;
    .locals 12
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 473
    const-class v9, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v9

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 474
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v7

    .line 475
    .local v7, "webkitCookieManager":Landroid/webkit/CookieManager;
    const/4 v8, 0x1

    invoke-static {p0, v8}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    .line 477
    .local v4, "cookieString":Ljava/lang/String;
    const/4 v1, 0x0

    .line 478
    .local v1, "atMainCookie":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_1

    .line 480
    const-string/jumbo v8, ";"

    invoke-virtual {v4, v8}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 481
    .local v3, "cookieArray":[Ljava/lang/String;
    move-object v0, v3

    .local v0, "arr$":[Ljava/lang/String;
    array-length v6, v0

    .local v6, "len$":I
    const/4 v5, 0x0

    .local v5, "i$":I
    :goto_0
    if-ge v5, v6, :cond_1

    aget-object v2, v0, v5

    .line 484
    .local v2, "cookie":Ljava/lang/String;
    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 485
    const-string/jumbo v8, "at-main"

    invoke-virtual {v2, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_0

    const-string/jumbo v8, "at-acb"

    invoke-virtual {v2, v8}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 488
    :cond_0
    const-string/jumbo v8, "="

    invoke-virtual {v2, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v8

    add-int/lit8 v8, v8, 0x1

    invoke-virtual {v2, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v10, "\""

    const-string/jumbo v11, ""

    invoke-virtual {v8, v10, v11}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v1

    .line 495
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v2    # "cookie":Ljava/lang/String;
    .end local v3    # "cookieArray":[Ljava/lang/String;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    :cond_1
    monitor-exit v9

    return-object v1

    .line 481
    .restart local v0    # "arr$":[Ljava/lang/String;
    .restart local v2    # "cookie":Ljava/lang/String;
    .restart local v3    # "cookieArray":[Ljava/lang/String;
    .restart local v5    # "i$":I
    .restart local v6    # "len$":I
    :cond_2
    add-int/lit8 v5, v5, 0x1

    goto :goto_0

    .line 473
    .end local v0    # "arr$":[Ljava/lang/String;
    .end local v1    # "atMainCookie":Ljava/lang/String;
    .end local v2    # "cookie":Ljava/lang/String;
    .end local v3    # "cookieArray":[Ljava/lang/String;
    .end local v4    # "cookieString":Ljava/lang/String;
    .end local v5    # "i$":I
    .end local v6    # "len$":I
    .end local v7    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v8

    monitor-exit v9

    throw v8
.end method

.method public static declared-synchronized getCookie(Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;
    .locals 7
    .param p0, "cookieKey"    # Ljava/lang/String;
    .param p1, "applicationContext"    # Landroid/content/Context;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Landroid/content/Context;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 219
    const-class v5, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v5

    :try_start_0
    invoke-static {p1}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 221
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v3

    .line 222
    .local v3, "webkitCookieManager":Landroid/webkit/CookieManager;
    const/4 v4, 0x1

    invoke-static {p1, v4}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 223
    .local v1, "cookieString":Ljava/lang/String;
    if-eqz v1, :cond_0

    .line 224
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "("

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v6, "(-[\\w\\-]+)?)\\s*=\\s*([^;]+)"

    invoke-virtual {v4, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    .line 225
    .local v2, "matcher":Ljava/util/regex/Matcher;
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 226
    .local v0, "cookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    invoke-virtual {v2}, Ljava/util/regex/Matcher;->find()Z

    move-result v4

    if-eqz v4, :cond_1

    .line 227
    const/4 v4, 0x1

    invoke-virtual {v2, v4}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v4

    const/4 v6, 0x3

    invoke-virtual {v2, v6}, Ljava/util/regex/Matcher;->group(I)Ljava/lang/String;

    move-result-object v6

    invoke-interface {v0, v4, v6}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_0

    .line 219
    .end local v0    # "cookie":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "cookieString":Ljava/lang/String;
    .end local v2    # "matcher":Ljava/util/regex/Matcher;
    .end local v3    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v4

    monitor-exit v5

    throw v4

    .line 234
    .restart local v1    # "cookieString":Ljava/lang/String;
    .restart local v3    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :cond_0
    :try_start_1
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result-object v0

    :cond_1
    monitor-exit v5

    return-object v0
.end method

.method public static getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "secure"    # Z

    .prologue
    .line 176
    invoke-static {p0, p1}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 177
    .local v1, "url":Ljava/lang/String;
    invoke-static {p0, v1}, Lcom/amazon/mShop/net/CookieBridge;->getDomainFromURL(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 178
    .local v0, "domain":Ljava/lang/String;
    return-object v0
.end method

.method public static declared-synchronized getCookiesOfCurrentLocale(Landroid/content/Context;Z)Ljava/lang/String;
    .locals 4
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "secure"    # Z

    .prologue
    .line 321
    const-class v3, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v3

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 322
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v1

    .line 323
    .local v1, "webkitCookieManager":Landroid/webkit/CookieManager;
    invoke-static {p0, p1}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 324
    .local v0, "cookies":Ljava/lang/String;
    monitor-exit v3

    return-object v0

    .line 321
    .end local v0    # "cookies":Ljava/lang/String;
    .end local v1    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public static final getCurrentSessionId()Ljava/lang/String;
    .locals 4

    .prologue
    .line 464
    const/4 v1, 0x0

    .line 465
    .local v1, "sessionId":Ljava/lang/String;
    const-string/jumbo v3, "session"

    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v2

    invoke-interface {v2}, Lcom/amazon/mShop/platform/Platform;->getApplicationContext()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/content/Context;

    invoke-static {v3, v2}, Lcom/amazon/mShop/net/CookieBridge;->getCookie(Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;

    move-result-object v0

    .line 466
    .local v0, "cookies":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 467
    const-string/jumbo v2, "session-id"

    invoke-interface {v0, v2}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    .end local v1    # "sessionId":Ljava/lang/String;
    check-cast v1, Ljava/lang/String;

    .line 469
    .restart local v1    # "sessionId":Ljava/lang/String;
    :cond_0
    return-object v1
.end method

.method public static getDomainFromURL(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 195
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v2

    invoke-virtual {v2}, Ljava/net/URI;->getHost()Ljava/lang/String;

    move-result-object v1

    .line 196
    .local v1, "host":Ljava/lang/String;
    const-string/jumbo v2, ".*(\\.amazon\\..*)"

    invoke-static {v2}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v2

    const-string/jumbo v3, "$1"

    invoke-virtual {v2, v3}, Ljava/util/regex/Matcher;->replaceFirst(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 197
    .local v0, "domain":Ljava/lang/String;
    return-object v0
.end method

.method public static getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "secure"    # Z

    .prologue
    .line 182
    if-eqz p1, :cond_0

    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_serviceSecureURL:I

    .line 183
    .local v0, "resourceId":I
    :goto_0
    invoke-static {p0, v0}, Lcom/amazon/mShop/util/ConfigUtils;->getString(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    return-object v1

    .line 182
    .end local v0    # "resourceId":I
    :cond_0
    sget v0, Lcom/amazon/mShop/android/lib/R$string;->config_serviceURL:I

    goto :goto_0
.end method

.method public static declared-synchronized getUbidCookie(Landroid/content/Context;)Ljava/lang/String;
    .locals 5
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 499
    const-class v3, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v3

    const/4 v0, 0x0

    .line 500
    .local v0, "ubid":Ljava/lang/String;
    :try_start_0
    const-string/jumbo v2, "ubid"

    invoke-static {v2, p0}, Lcom/amazon/mShop/net/CookieBridge;->getCookie(Ljava/lang/String;Landroid/content/Context;)Ljava/util/Map;

    move-result-object v1

    .line 501
    .local v1, "ubids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    if-eqz v1, :cond_0

    invoke-interface {v1}, Ljava/util/Map;->size()I

    move-result v2

    const/4 v4, 0x1

    if-ne v2, v4, :cond_0

    .line 502
    invoke-interface {v1}, Ljava/util/Map;->values()Ljava/util/Collection;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    .end local v0    # "ubid":Ljava/lang/String;
    check-cast v0, Ljava/lang/String;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 505
    .restart local v0    # "ubid":Ljava/lang/String;
    :cond_0
    monitor-exit v3

    return-object v0

    .line 499
    .end local v0    # "ubid":Ljava/lang/String;
    .end local v1    # "ubids":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :catchall_0
    move-exception v2

    monitor-exit v3

    throw v2
.end method

.method public static declared-synchronized init(Landroid/content/Context;)V
    .locals 2
    .param p0, "applicationContext"    # Landroid/content/Context;

    .prologue
    .line 62
    const-class v1, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v1

    :try_start_0
    invoke-static {}, Ljava/net/CookieHandler;->getDefault()Ljava/net/CookieHandler;

    move-result-object v0

    if-nez v0, :cond_0

    .line 63
    invoke-static {p0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 64
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->startSync()V

    .line 66
    new-instance v0, Lcom/amazon/mShop/net/CookieBridge;

    invoke-direct {v0}, Lcom/amazon/mShop/net/CookieBridge;-><init>()V

    invoke-static {v0}, Ljava/net/CookieHandler;->setDefault(Ljava/net/CookieHandler;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 68
    :cond_0
    monitor-exit v1

    return-void

    .line 62
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public static declared-synchronized setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V
    .locals 5
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "secure"    # Z
    .param p2, "cookieKey"    # Ljava/lang/String;
    .param p3, "cookieValue"    # Ljava/lang/String;

    .prologue
    .line 136
    const-class v4, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v4

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 138
    invoke-static {p0, p1, p2, p3}, Lcom/amazon/mShop/net/CookieBridge;->buildSetCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 140
    .local v0, "cookie":Ljava/lang/String;
    invoke-static {p0, p1}, Lcom/amazon/mShop/net/CookieBridge;->getMShopURL(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 144
    .local v1, "url":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v2

    .line 145
    .local v2, "webkitCookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {v2, v1, v0}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 146
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v3

    invoke-virtual {v3}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 157
    monitor-exit v4

    return-void

    .line 136
    .end local v0    # "cookie":Ljava/lang/String;
    .end local v1    # "url":Ljava/lang/String;
    .end local v2    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3
.end method

.method public static declared-synchronized setCookies(Landroid/content/Context;Ljava/lang/String;Z)V
    .locals 9
    .param p0, "applicationContext"    # Landroid/content/Context;
    .param p1, "cookies"    # Ljava/lang/String;
    .param p2, "secure"    # Z

    .prologue
    .line 337
    const-class v7, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v7

    :try_start_0
    invoke-static {p0}, Lcom/amazon/mShop/net/CookieBridge;->init(Landroid/content/Context;)V

    .line 338
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v6

    if-eqz v6, :cond_0

    .line 362
    :goto_0
    monitor-exit v7

    return-void

    .line 341
    :cond_0
    :try_start_1
    const-string/jumbo v6, ";"

    invoke-virtual {p1, v6}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 342
    .local v0, "cookiesArray":[Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_4

    .line 343
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_1
    array-length v6, v0

    if-ge v2, v6, :cond_4

    .line 344
    aget-object v6, v0, v2

    const-string/jumbo v8, "="

    invoke-virtual {v6, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 345
    .local v1, "firstEqualsIndex":I
    const/4 v3, 0x0

    .line 346
    .local v3, "key":Ljava/lang/String;
    const/4 v5, 0x0

    .line 347
    .local v5, "value":Ljava/lang/String;
    const/4 v6, -0x1

    if-ne v1, v6, :cond_2

    .line 343
    :cond_1
    :goto_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_1

    .line 350
    :cond_2
    aget-object v6, v0, v2

    const-string/jumbo v8, "="

    invoke-virtual {v6, v8}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v4

    .line 351
    .local v4, "splitIndext":I
    aget-object v6, v0, v2

    const/4 v8, 0x0

    invoke-virtual {v6, v8, v4}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 352
    aget-object v6, v0, v2

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    add-int/lit8 v8, v4, 0x1

    if-le v6, v8, :cond_3

    aget-object v6, v0, v2

    add-int/lit8 v8, v4, 0x1

    invoke-virtual {v6, v8}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v5

    .line 353
    :goto_3
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_1

    .line 358
    invoke-static {p0, p2, v3, v5}, Lcom/amazon/mShop/net/CookieBridge;->setCookie(Landroid/content/Context;ZLjava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_2

    .line 337
    .end local v0    # "cookiesArray":[Ljava/lang/String;
    .end local v1    # "firstEqualsIndex":I
    .end local v2    # "i":I
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "splitIndext":I
    .end local v5    # "value":Ljava/lang/String;
    :catchall_0
    move-exception v6

    monitor-exit v7

    throw v6

    .line 352
    .restart local v0    # "cookiesArray":[Ljava/lang/String;
    .restart local v1    # "firstEqualsIndex":I
    .restart local v2    # "i":I
    .restart local v3    # "key":Ljava/lang/String;
    .restart local v4    # "splitIndext":I
    .restart local v5    # "value":Ljava/lang/String;
    :cond_3
    const/4 v5, 0x0

    goto :goto_3

    .line 361
    .end local v1    # "firstEqualsIndex":I
    .end local v2    # "i":I
    .end local v3    # "key":Ljava/lang/String;
    .end local v4    # "splitIndext":I
    .end local v5    # "value":Ljava/lang/String;
    :cond_4
    :try_start_2
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v6

    invoke-virtual {v6}, Landroid/webkit/CookieSyncManager;->sync()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0
.end method


# virtual methods
.method public final get(Ljava/net/URI;Ljava/util/Map;)Ljava/util/Map;
    .locals 5
    .param p1, "uri"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 75
    .local p2, "requestHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    const-class v3, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v3

    .line 76
    :try_start_0
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 78
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v1

    .line 79
    .local v1, "webkitCookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {p1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 84
    .local v0, "cookies":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 85
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v2

    monitor-exit v3

    .line 87
    :goto_0
    return-object v2

    :cond_0
    const-string/jumbo v2, "Cookie"

    invoke-static {v0}, Ljava/util/Collections;->singletonList(Ljava/lang/Object;)Ljava/util/List;

    move-result-object v4

    invoke-static {v2, v4}, Ljava/util/Collections;->singletonMap(Ljava/lang/Object;Ljava/lang/Object;)Ljava/util/Map;

    move-result-object v2

    monitor-exit v3

    goto :goto_0

    .line 88
    .end local v0    # "cookies":Ljava/lang/String;
    .end local v1    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v2
.end method

.method public final put(Ljava/net/URI;Ljava/util/Map;)V
    .locals 7
    .param p1, "uri"    # Ljava/net/URI;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/net/URI;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;)V"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 96
    .local p2, "responseHeaders":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/util/List<Ljava/lang/String;>;>;"
    const-class v6, Lcom/amazon/mShop/net/CookieBridge;

    monitor-enter v6

    .line 97
    const/4 v2, 0x0

    .line 99
    .local v2, "cookies":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :try_start_0
    const-string/jumbo v5, "Set-Cookie"

    invoke-interface {p2, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 100
    const-string/jumbo v5, "Set-Cookie"

    invoke-interface {p2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Ljava/util/List;

    move-object v2, v0

    .line 107
    :cond_0
    :goto_0
    if-eqz v2, :cond_1

    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v5

    if-eqz v5, :cond_3

    .line 108
    :cond_1
    monitor-exit v6

    .line 119
    :goto_1
    return-void

    .line 103
    :cond_2
    const-string/jumbo v5, "set-cookie"

    invoke-interface {p2, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 104
    const-string/jumbo v5, "set-cookie"

    invoke-interface {p2, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v5

    move-object v0, v5

    check-cast v0, Ljava/util/List;

    move-object v2, v0

    goto :goto_0

    .line 110
    :cond_3
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v4

    .line 111
    .local v4, "webkitCookieManager":Landroid/webkit/CookieManager;
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 115
    .local v1, "cookie":Ljava/lang/String;
    invoke-virtual {p1}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5, v1}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2

    .line 118
    .end local v1    # "cookie":Ljava/lang/String;
    .end local v3    # "i$":Ljava/util/Iterator;
    .end local v4    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :catchall_0
    move-exception v5

    monitor-exit v6
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v5

    .line 117
    .restart local v3    # "i$":Ljava/util/Iterator;
    .restart local v4    # "webkitCookieManager":Landroid/webkit/CookieManager;
    :cond_4
    :try_start_1
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v5

    invoke-virtual {v5}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 118
    monitor-exit v6
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_1
.end method
