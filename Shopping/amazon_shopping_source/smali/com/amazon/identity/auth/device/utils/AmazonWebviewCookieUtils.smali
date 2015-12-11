.class public final Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;
.super Ljava/lang/Object;
.source "AmazonWebviewCookieUtils.java"


# static fields
.field private static final LOG_TAG:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const-class v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method private constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 30
    return-void
.end method

.method public static getCookieFromCookieManager(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lorg/apache/http/cookie/Cookie;
    .locals 4
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "directedID"    # Ljava/lang/String;
    .param p2, "cookieUrl"    # Ljava/lang/String;
    .param p3, "cookieName"    # Ljava/lang/String;

    .prologue
    .line 126
    invoke-static {p0, p2, p1}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->getCookiesFromCookieManager(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 127
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 129
    .local v0, "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v2

    .line 130
    .local v2, "name":Ljava/lang/String;
    invoke-virtual {p3, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 136
    .end local v0    # "cookie":Lorg/apache/http/cookie/Cookie;
    .end local v2    # "name":Ljava/lang/String;
    :goto_0
    return-object v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public static getCookiesFromCookieManager(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 3
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "domain"    # Ljava/lang/String;
    .param p2, "directedId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 44
    invoke-static {p0, p1}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->getCookiesStringFromCookieManager(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 45
    .local v0, "cookies":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->LOG_TAG:Ljava/lang/String;

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    aput-object p1, v1, v2

    const/4 v2, 0x1

    aput-object p2, v1, v2

    .line 46
    invoke-static {p1, p2, v0}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->parseCookieString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 48
    return-object v1
.end method

.method public static getCookiesStringFromCookieManager(Landroid/content/Context;Ljava/lang/String;)Ljava/lang/String;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 141
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->getAmazonCookieManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v0

    .line 142
    .local v0, "cookieManager":Lcom/amazon/android/webkit/AmazonCookieManager;
    const/4 v3, 0x1

    invoke-virtual {v0, v3}, Lcom/amazon/android/webkit/AmazonCookieManager;->setAcceptCookie(Z)V

    .line 144
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->syncAmazonCookieSyncManager(Landroid/content/Context;)V

    .line 147
    move-object v2, p1

    .local v2, "getCookieDomain":Ljava/lang/String;
    const-string/jumbo v3, "."

    invoke-virtual {p1, v3}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 149
    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "www"

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 152
    :cond_0
    invoke-virtual {v0, v2}, Lcom/amazon/android/webkit/AmazonCookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 153
    .local v1, "cookies":Ljava/lang/String;
    sget-object v3, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Extracting cookies from CookieManager for domain="

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 154
    return-object v1
.end method

.method public static parseCookieString(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 12
    .param p0, "domain"    # Ljava/lang/String;
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "cookieString"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    const/4 v11, 0x2

    const/4 v10, 0x1

    const/4 v5, 0x0

    .line 64
    new-instance v9, Ljava/util/ArrayList;

    invoke-direct {v9}, Ljava/util/ArrayList;-><init>()V

    .line 65
    .local v9, "parsedCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    if-eqz p2, :cond_1

    .line 70
    new-instance v8, Ljava/util/StringTokenizer;

    const-string/jumbo v0, ";"

    invoke-direct {v8, p2, v0}, Ljava/util/StringTokenizer;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 72
    .local v8, "cookiesParser":Ljava/util/StringTokenizer;
    :goto_0
    invoke-virtual {v8}, Ljava/util/StringTokenizer;->hasMoreTokens()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 76
    invoke-virtual {v8}, Ljava/util/StringTokenizer;->nextToken()Ljava/lang/String;

    move-result-object v7

    .line 88
    .local v7, "cookiePair":Ljava/lang/String;
    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v3, "="

    invoke-virtual {v0, v3, v11}, Ljava/lang/String;->split(Ljava/lang/String;I)[Ljava/lang/String;

    move-result-object v6

    .line 90
    .local v6, "cookieNameAndCookieValue":[Ljava/lang/String;
    array-length v0, v6

    if-ne v0, v11, :cond_0

    .line 92
    aget-object v1, v6, v5

    .line 93
    .local v1, "cookieName":Ljava/lang/String;
    aget-object v2, v6, v10

    .line 94
    .local v2, "cookieValue":Ljava/lang/String;
    new-instance v0, Lcom/amazon/identity/auth/device/token/MAPCookie;

    move-object v3, p0

    move-object v4, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/MAPCookie;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    invoke-interface {v9, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 98
    .end local v1    # "cookieName":Ljava/lang/String;
    .end local v2    # "cookieValue":Ljava/lang/String;
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v3, "Unexpected cookie format"

    invoke-static {v0, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 99
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->LOG_TAG:Ljava/lang/String;

    new-array v0, v11, [Ljava/lang/Object;

    aput-object v7, v0, v5

    aput-object p2, v0, v10

    goto :goto_0

    .line 106
    .end local v6    # "cookieNameAndCookieValue":[Ljava/lang/String;
    .end local v7    # "cookiePair":Ljava/lang/String;
    .end local v8    # "cookiesParser":Ljava/util/StringTokenizer;
    :cond_1
    sget-object v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->LOG_TAG:Ljava/lang/String;

    new-array v0, v10, [Ljava/lang/Object;

    aput-object p0, v0, v5

    .line 109
    :cond_2
    return-object v9
.end method

.method public static setCookie(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/token/MAPCookie;)V
    .locals 2
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "cookie"    # Lcom/amazon/identity/auth/device/token/MAPCookie;

    .prologue
    .line 162
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->getAmazonCookieManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v0

    .line 163
    .local v0, "cookieManager":Lcom/amazon/android/webkit/AmazonCookieManager;
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/android/webkit/AmazonCookieManager;->setAcceptCookie(Z)V

    .line 164
    invoke-virtual {p2}, Lcom/amazon/identity/auth/device/token/MAPCookie;->getSetCookieHeader()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Lcom/amazon/android/webkit/AmazonCookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 166
    invoke-static {p0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->syncAmazonCookieSyncManager(Landroid/content/Context;)V

    .line 167
    return-void
.end method

.method public static setCookie(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 10
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "cookieUrl"    # Ljava/lang/String;
    .param p2, "cookieName"    # Ljava/lang/String;
    .param p3, "cookieValue"    # Ljava/lang/String;
    .param p4, "pathAttribute"    # Ljava/lang/String;
    .param p5, "expiresAttribute"    # Ljava/lang/String;
    .param p6, "secureAttribute"    # Z
    .param p7, "httpOnlyAttribute"    # Z

    .prologue
    .line 197
    :try_start_0
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->getCookieDomainFromUrl(Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v3

    .line 206
    .local v3, "domainAttribute":Ljava/lang/String;
    new-instance v0, Lcom/amazon/identity/auth/device/token/MAPCookie;

    const/4 v6, 0x0

    move-object v1, p2

    move-object v2, p3

    move-object v4, p5

    move-object v5, p4

    move/from16 v7, p6

    move/from16 v8, p7

    invoke-direct/range {v0 .. v8}, Lcom/amazon/identity/auth/device/token/MAPCookie;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 216
    .local v0, "cookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    invoke-static {p0, p1, v0}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->setCookie(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/identity/auth/device/token/MAPCookie;)V

    .line 217
    .end local v0    # "cookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    .end local v3    # "domainAttribute":Ljava/lang/String;
    :goto_0
    return-void

    .line 199
    :catch_0
    move-exception v9

    .line 201
    .local v9, "e":Ljava/net/MalformedURLException;
    const-string/jumbo v1, "failedParsingCookieDomain"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/String;

    const/4 v4, 0x0

    const-string/jumbo v5, "MalformedURLException"

    aput-object v5, v2, v4

    invoke-static {v1, v2}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 202
    sget-object v1, Lcom/amazon/identity/auth/device/utils/AmazonWebviewCookieUtils;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "Could not parse cookie domain from malformed URL."

    invoke-static {v1, v2, v9}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
