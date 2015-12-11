.class public Lcom/amazon/identity/auth/device/token/MAPCookieManager;
.super Ljava/lang/Object;
.source "MAPCookieManager.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;
    }
.end annotation


# static fields
.field private static final FUDGE_FACTOR:J

.field public static final JSON_KEY_RESP_COOKIES:Ljava/lang/String; = "cookies"

.field public static final JSON_KEY_RESP_RESPONSE:Ljava/lang/String; = "response"

.field public static final JSON_KEY_RESP_TOKENS:Ljava/lang/String; = "tokens"

.field private static final METRICS_COMPONENT_NAME:Ljava/lang/String;

.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

.field private final mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

.field private final mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

.field private mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

.field private final mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field private final mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

.field private mSystemWrapper:Lcom/amazon/identity/auth/device/framework/SystemWrapper;


# direct methods
.method static constructor <clinit>()V
    .locals 3

    .prologue
    .line 60
    const-class v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    .line 62
    const-class v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    .line 66
    const-wide/16 v0, 0x1

    sget-object v2, Ljava/util/concurrent/TimeUnit;->MILLISECONDS:Ljava/util/concurrent/TimeUnit;

    invoke-static {v0, v1, v2}, Lcom/amazon/identity/auth/device/utils/TimeUtil;->fromMinutesTo(JLjava/util/concurrent/TimeUnit;)J

    move-result-wide v0

    sput-wide v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->FUDGE_FACTOR:J

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 77
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 78
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    .line 80
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const-string/jumbo v2, "dcp_system"

    invoke-virtual {v1, v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mSystemWrapper:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    .line 82
    new-instance v1, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    .line 84
    new-instance v1, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    .line 86
    new-instance v1, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v1, v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 88
    new-instance v0, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;-><init>(Landroid/content/Context;)V

    .line 89
    .local v0, "cookieDataStorageFactory":Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/CookieDataStoreFactory;->getDataStore()Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    .line 91
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v1

    iput-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 92
    return-void
.end method

.method private addAppParams(Ljava/util/List;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/NameValuePair;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 724
    .local p1, "postParams":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v1, "app_name"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getPackageName()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 725
    new-instance v0, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v1, "app_version"

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/BuildInfo;->getBuildInfo()Lcom/amazon/identity/auth/device/utils/BuildInfo;

    move-result-object v2

    iget v2, v2, Lcom/amazon/identity/auth/device/utils/BuildInfo;->mMapSWVersion:I

    invoke-static {v2}, Ljava/lang/String;->valueOf(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 726
    return-void
.end method

.method private generateCookieListFromCookieJSONArray(Ljava/lang/String;Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/List;
    .locals 10
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "cookiesArray"    # Lorg/json/JSONArray;
    .param p3, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/json/JSONArray;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 650
    new-instance v7, Ljava/util/ArrayList;

    invoke-direct {v7}, Ljava/util/ArrayList;-><init>()V

    .line 651
    .local v7, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-virtual {p2}, Lorg/json/JSONArray;->length()I

    move-result v9

    .line 652
    .local v9, "numCookies":I
    const/4 v8, 0x0

    .local v8, "i":I
    :goto_0
    if-ge v8, v9, :cond_2

    .line 654
    invoke-virtual {p2, v8}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v6

    .line 655
    .local v6, "cookie":Lorg/json/JSONObject;
    new-instance v0, Lcom/amazon/identity/auth/device/token/MAPCookie;

    const-string/jumbo v1, "Name"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    const-string/jumbo v2, "Value"

    invoke-virtual {v6, v2}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "Secure"

    invoke-virtual {v6, v3}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v5

    move-object v3, p3

    move-object v4, p1

    invoke-direct/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/MAPCookie;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 664
    .local v0, "mapCookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    invoke-static {p3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 666
    const-string/jumbo v1, "Domain"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setDomain(Ljava/lang/String;)V

    .line 668
    :cond_0
    const-string/jumbo v1, "Path"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setPath(Ljava/lang/String;)V

    .line 669
    const-string/jumbo v1, "Expires"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->has(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 671
    const-string/jumbo v1, "Expires"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setExpiryDate(Ljava/lang/String;)V

    .line 673
    :cond_1
    const-string/jumbo v1, "HttpOnly"

    invoke-virtual {v6, v1}, Lorg/json/JSONObject;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/amazon/identity/auth/device/token/MAPCookie;->setHttpOnly(Z)V

    .line 674
    invoke-interface {v7, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 652
    add-int/lit8 v8, v8, 0x1

    goto :goto_0

    .line 676
    .end local v0    # "mapCookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    .end local v6    # "cookie":Lorg/json/JSONObject;
    :cond_2
    return-object v7
.end method

.method private getAuthCookiesFromStorage(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
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
    .line 338
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->getAllCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method private getCookieExchangeTokenURL(Ljava/lang/String;)Ljava/net/URL;
    .locals 6
    .param p1, "domain"    # Ljava/lang/String;

    .prologue
    .line 683
    :try_start_0
    new-instance v1, Ljava/net/URL;

    const-string/jumbo v2, "https"

    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getCompleteAuthPortalDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    const/16 v4, 0x1bb

    const-string/jumbo v5, "/ap/exchangetoken/cookies"

    invoke-direct {v1, v2, v3, v4, v5}, Ljava/net/URL;-><init>(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 691
    :goto_0
    return-object v1

    .line 688
    :catch_0
    move-exception v0

    .line 690
    .local v0, "e":Ljava/net/MalformedURLException;
    sget-object v1, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error parsing URL"

    invoke-static {v1, v2, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 691
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private getNonAuthCookiesFromStorage(Ljava/lang/String;)Ljava/util/List;
    .locals 1
    .param p1, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 333
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->getNonAuthCookies(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public static getSidString(Ljava/util/List;)Ljava/lang/String;
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .local p0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    const/4 v2, 0x0

    .line 229
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 249
    :cond_0
    :goto_0
    return-object v2

    .line 234
    :cond_1
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 236
    .local v0, "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v3

    const-string/jumbo v4, "sid"

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 238
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getValue()Ljava/lang/String;

    move-result-object v2

    .line 239
    .local v2, "value":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 241
    sget-object v3, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "The sid value inside the returned cookies is null or a empty string. There\'s a bug on server side!"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 243
    const-string/jumbo v3, "EmptySidCookieValueInsideAuthCookiesFromServer"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method private onSuccess(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 1
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "domain"    # Ljava/lang/String;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            ")V"
        }
    .end annotation

    .prologue
    .line 375
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->addTheSidCookieToTheAuthCookies(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 376
    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getBundleForCookieList(Ljava/util/List;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p4, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 377
    return-void
.end method

.method private parseJSONCookies(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/util/List;
    .locals 7
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "jsonResponse"    # Lorg/json/JSONObject;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/json/JSONObject;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 593
    sget-object v5, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Parsing getCookies Response for id="

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 594
    const-string/jumbo v5, "response"

    invoke-virtual {p2, v5}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 595
    const-string/jumbo v6, "tokens"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v5

    .line 596
    const-string/jumbo v6, "cookies"

    invoke-virtual {v5, v6}, Lorg/json/JSONObject;->getJSONObject(Ljava/lang/String;)Lorg/json/JSONObject;

    move-result-object v4

    .line 598
    .local v4, "jsonCookies":Lorg/json/JSONObject;
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 600
    .local v0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    if-nez v4, :cond_1

    .line 602
    const/4 v0, 0x0

    .line 621
    .end local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_0
    return-object v0

    .line 606
    .restart local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_1
    invoke-virtual {v4}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v3

    .line 608
    .local v3, "domains":Ljava/util/Iterator;
    const/4 v1, 0x0

    .line 609
    .local v1, "cookiesArray":Lorg/json/JSONArray;
    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 611
    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Ljava/lang/String;

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 612
    .local v2, "domain":Ljava/lang/String;
    invoke-virtual {v4, v2}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v1

    .line 614
    if-eqz v1, :cond_2

    .line 616
    invoke-direct {p0, p1, v1, v2}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->generateCookieListFromCookieJSONArray(Ljava/lang/String;Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    invoke-interface {v0, v5}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    goto :goto_0
.end method

.method public static removeTheSidCookieIfExist(Ljava/util/List;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 561
    .local p0, "currentCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p0}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 575
    :cond_0
    :goto_0
    return-void

    .line 566
    :cond_1
    invoke-interface {p0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 568
    .local v0, "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v2

    const-string/jumbo v3, "sid"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 570
    sget-object v2, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    .line 571
    invoke-interface {p0, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method private shouldRefreshCookiesBasedOnExpiry(Ljava/util/List;)Z
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    const/4 v5, 0x1

    const/4 v6, 0x0

    .line 343
    if-eqz p1, :cond_0

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v7

    if-gtz v7, :cond_1

    :cond_0
    move v5, v6

    .line 365
    :goto_0
    return v5

    .line 349
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .local v4, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-eqz v7, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lorg/apache/http/cookie/Cookie;

    .line 351
    .local v0, "cookie":Lorg/apache/http/cookie/Cookie;
    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getExpiryDate()Ljava/util/Date;

    move-result-object v3

    .line 352
    .local v3, "expiry":Ljava/util/Date;
    iget-object v7, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mSystemWrapper:Lcom/amazon/identity/auth/device/framework/SystemWrapper;

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/framework/SystemWrapper;->currentTimeMillis()J

    move-result-wide v1

    .line 353
    .local v1, "currentTime":J
    if-nez v3, :cond_3

    .line 355
    sget-object v7, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Cookie: %s has null expiry date."

    new-array v9, v5, [Ljava/lang/Object;

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v6

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v7, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 358
    :cond_3
    sget-wide v7, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->FUDGE_FACTOR:J

    add-long/2addr v7, v1

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v9

    cmp-long v7, v7, v9

    if-ltz v7, :cond_2

    .line 360
    sget-object v7, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v8, "Cookie: %s near expiry, refreshing"

    new-array v9, v5, [Ljava/lang/Object;

    invoke-interface {v0}, Lorg/apache/http/cookie/Cookie;->getName()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v9, v6

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-static {v7, v6}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .end local v0    # "cookie":Lorg/apache/http/cookie/Cookie;
    .end local v1    # "currentTime":J
    .end local v3    # "expiry":Ljava/util/Date;
    :cond_4
    move v5, v6

    .line 365
    goto :goto_0
.end method

.method public static updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(Ljava/util/List;Ljava/util/Map;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 214
    .local p0, "cookiesReturnedFromRegistration":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .local p1, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getSidString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    .line 215
    .local v0, "sid":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 217
    invoke-static {p0}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->removeTheSidCookieIfExist(Ljava/util/List;)V

    .line 218
    sget-object v1, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    .line 219
    const-string/jumbo v1, "com.amazon.dcp.sso.token.cookie.sid"

    invoke-interface {p1, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 221
    :cond_0
    return-void
.end method


# virtual methods
.method public addTheSidCookieToTheAuthCookies(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V
    .locals 9
    .param p2, "directedId"    # Ljava/lang/String;
    .param p3, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .local p1, "currentCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    const/4 v7, 0x1

    const/4 v5, 0x0

    .line 507
    invoke-static {p2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 554
    :cond_0
    :goto_0
    return-void

    .line 512
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v4, "com.amazon.dcp.sso.token.cookie.sid"

    invoke-virtual {v1, p2, v4}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 513
    .local v2, "sid":Ljava/lang/String;
    invoke-static {v2}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 516
    invoke-static {p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getSidString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    .line 517
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 520
    sget-object v1, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Before we add the sid cookie to the cookies that will be sent out, there\'s already a sid cookie inside; this is a bug since we should have removed the sid cookie before we saved the cookies."

    invoke-static {v1, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 522
    const-string/jumbo v1, "SidCookieExistsInCookiesBeforeAddingOne"

    new-array v4, v5, [Ljava/lang/String;

    invoke-static {v1, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 523
    invoke-static {p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->removeTheSidCookieIfExist(Ljava/util/List;)V

    .line 527
    :cond_2
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/AmazonDomainHelper;->getDomainFromCompleteUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 529
    .local v3, "cookieDomain":Ljava/lang/String;
    sget-object v1, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "Add the sid cookie to cookies that will be sent out. The domain we use to create the sid cookies is "

    invoke-direct {v1, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 532
    new-instance v0, Lcom/amazon/identity/auth/device/token/MAPCookie;

    const-string/jumbo v1, "sid"

    invoke-static {}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->getNonExpiringCookieExpiresString()Ljava/lang/String;

    move-result-object v4

    const-string/jumbo v5, "/"

    const/4 v6, 0x0

    move v8, v7

    invoke-direct/range {v0 .. v8}, Lcom/amazon/identity/auth/device/token/MAPCookie;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZZ)V

    .line 541
    .local v0, "sidCookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    invoke-interface {p1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 545
    .end local v0    # "sidCookie":Lcom/amazon/identity/auth/device/token/MAPCookie;
    .end local v3    # "cookieDomain":Ljava/lang/String;
    :cond_3
    invoke-static {p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getSidString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    .line 546
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 548
    sget-object v1, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "There\'s a sid cookie in the cookies that will be sent out, but we didn\'t update the sid; this is a bug since we should have updated the sid and removed the sid cookie before we saved the cookies."

    invoke-static {v1, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 551
    const-string/jumbo v1, "SidCookieExistsButHaveNotBeenSavedAsAToken"

    new-array v4, v5, [Ljava/lang/String;

    invoke-static {v1, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    goto :goto_0
.end method

.method fetchCookiesFromServer(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/util/List;
    .locals 23
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;",
            "Lcom/amazon/identity/auth/device/api/Callback;",
            "Lcom/amazon/identity/auth/device/framework/Tracer;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 385
    .local p3, "currentCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Fetching cookies"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 387
    new-instance v18, Ljava/util/ArrayList;

    invoke-direct/range {v18 .. v18}, Ljava/util/ArrayList;-><init>()V

    .line 388
    .local v18, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    const/16 v17, 0x0

    .line 392
    .local v17, "conn":Ljava/net/HttpURLConnection;
    :try_start_0
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->METRICS_COMPONENT_NAME:Ljava/lang/String;

    const-string/jumbo v5, "fetchCookiesFromServer"

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v22

    .line 394
    .local v22, "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    move-object/from16 v0, p0

    move-object/from16 v1, p2

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getCookieExchangeTokenURL(Ljava/lang/String;)Ljava/net/URL;

    move-result-object v6

    .line 396
    .local v6, "serviceURL":Ljava/net/URL;
    if-nez v6, :cond_0

    .line 398
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    const-string/jumbo v5, "Invalid Parameter: Domain"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    move-object/from16 v0, p4

    invoke-interface {v0, v4}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    move-object/from16 v19, v18

    .line 492
    .end local v6    # "serviceURL":Ljava/net/URL;
    .end local v18    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .end local v22    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    .local v19, "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :goto_0
    return-object v19

    .line 402
    .end local v19    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .restart local v6    # "serviceURL":Ljava/net/URL;
    .restart local v18    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .restart local v22    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_0
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v8, "Using CookieExchangeToken URL: "

    invoke-direct {v5, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/net/URL;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v5, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 405
    invoke-static/range {p1 .. p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 407
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Requesting just non-auth cookies"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 408
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "requested_token_type"

    const-string/jumbo v9, "auth_cookies"

    invoke-direct {v5, v8, v9}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "domain"

    move-object/from16 v0, p2

    invoke-direct {v5, v8, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->addAppParams(Ljava/util/List;)V

    new-instance v7, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string/jumbo v5, "UTF-8"

    invoke-direct {v7, v4, v5}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .line 419
    .local v7, "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    :goto_1
    move-object/from16 v0, p0

    move-object/from16 v1, p3

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    invoke-virtual {v0, v1, v2, v3}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->addTheSidCookieToTheAuthCookies(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V

    .line 420
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    const/4 v8, 0x0

    const/4 v11, 0x0

    move-object/from16 v9, p3

    move-object/from16 v10, p1

    move-object/from16 v12, p5

    invoke-virtual/range {v4 .. v12}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->startIdentityRequest(Landroid/content/Context;Ljava/net/URL;Lorg/apache/http/client/entity/UrlEncodedFormEntity;ZLjava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/net/HttpURLConnection;

    move-result-object v17

    .line 430
    invoke-virtual/range {v17 .. v17}, Ljava/net/HttpURLConnection;->getResponseCode()I

    move-result v13

    .line 431
    .local v13, "responseCode":I
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Headers received update request to exchange token endpoint"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 433
    invoke-static/range {v17 .. v17}, Lcom/amazon/identity/auth/device/utils/JSONHelpers;->toJson(Ljava/net/HttpURLConnection;)Lorg/json/JSONObject;

    move-result-object v12

    .line 434
    .local v12, "jsonResponse":Lorg/json/JSONObject;
    invoke-virtual/range {v22 .. v22}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 436
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Response parsed for cookie request to exchange token endpoint"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 437
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    invoke-virtual {v4, v13}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->isFailure(I)Z

    move-result v4

    if-eqz v4, :cond_4

    .line 439
    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mAuthPortalHelper:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;

    const/4 v10, 0x0

    sget-object v14, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;->OauthRefreshToCookieExchange:Lcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    move-object/from16 v9, p1

    move-object/from16 v11, p4

    invoke-virtual/range {v8 .. v15}, Lcom/amazon/identity/auth/device/utils/AuthPortalHelper;->handleTokenExchangeError(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;Lorg/json/JSONObject;ILcom/amazon/identity/auth/device/utils/AuthPortalHelper$AuthTokenExchangeType;Lcom/amazon/identity/auth/device/api/MAPAccountManager;)Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;

    move-result-object v16

    .line 447
    .local v16, "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    const-string/jumbo v5, "fetchCookiesFromServerFailure"

    const/4 v4, 0x1

    new-array v8, v4, [Ljava/lang/String;

    const/4 v9, 0x0

    if-nez v16, :cond_3

    const-string/jumbo v4, "InvalidErrorResponse"

    :goto_2
    aput-object v4, v8, v9

    invoke-static {v5, v8}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/io/IOException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException; {:try_start_0 .. :try_end_0} :catch_2
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 486
    if-eqz v17, :cond_1

    .line 488
    invoke-virtual/range {v17 .. v17}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_1
    move-object/from16 v19, v18

    .restart local v19    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    goto/16 :goto_0

    .line 412
    .end local v7    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v12    # "jsonResponse":Lorg/json/JSONObject;
    .end local v13    # "responseCode":I
    .end local v16    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    .end local v19    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_2
    :try_start_1
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mOAuthTokenManager:Lcom/amazon/identity/auth/device/token/OAuthTokenManager;

    const/4 v5, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p5

    invoke-virtual {v4, v0, v5, v1}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager;->getRefreshToken(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/lang/String;

    move-result-object v21

    .line 413
    .local v21, "refreshToken":Ljava/lang/String;
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Requesting all cookies"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 414
    new-instance v4, Ljava/util/ArrayList;

    invoke-direct {v4}, Ljava/util/ArrayList;-><init>()V

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "source_token_type"

    const-string/jumbo v9, "refresh_token"

    invoke-direct {v5, v8, v9}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "source_token"

    move-object/from16 v0, v21

    invoke-direct {v5, v8, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "requested_token_type"

    const-string/jumbo v9, "auth_cookies"

    invoke-direct {v5, v8, v9}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    new-instance v5, Lorg/apache/http/message/BasicNameValuePair;

    const-string/jumbo v8, "domain"

    move-object/from16 v0, p2

    invoke-direct {v5, v8, v0}, Lorg/apache/http/message/BasicNameValuePair;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    invoke-interface {v4, v5}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    move-object/from16 v0, p0

    invoke-direct {v0, v4}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->addAppParams(Ljava/util/List;)V

    new-instance v7, Lorg/apache/http/client/entity/UrlEncodedFormEntity;

    const-string/jumbo v5, "UTF-8"

    invoke-direct {v7, v4, v5}, Lorg/apache/http/client/entity/UrlEncodedFormEntity;-><init>(Ljava/util/List;Ljava/lang/String;)V

    .restart local v7    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    goto/16 :goto_1

    .line 447
    .end local v21    # "refreshToken":Ljava/lang/String;
    .restart local v12    # "jsonResponse":Lorg/json/JSONObject;
    .restart local v13    # "responseCode":I
    .restart local v16    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    :cond_3
    invoke-virtual/range {v16 .. v16}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;->getAuthTypeError()Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthErrorType;->name()Ljava/lang/String;

    move-result-object v4

    goto :goto_2

    .line 453
    .end local v16    # "authEndpointError":Lcom/amazon/identity/auth/device/framework/AuthEndpointErrorParser$AuthEndpointError;
    :cond_4
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Parsing Cookies from JSONObject"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 456
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v12}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->parseJSONCookies(Ljava/lang/String;Lorg/json/JSONObject;)Ljava/util/List;

    move-result-object v18

    .line 458
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Parsing Complete from JSONObject"

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException; {:try_start_1 .. :try_end_1} :catch_2
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 486
    if-eqz v17, :cond_5

    .line 488
    invoke-virtual/range {v17 .. v17}, Ljava/net/HttpURLConnection;->disconnect()V

    .line 491
    .end local v6    # "serviceURL":Ljava/net/URL;
    .end local v7    # "postBody":Lorg/apache/http/client/entity/UrlEncodedFormEntity;
    .end local v12    # "jsonResponse":Lorg/json/JSONObject;
    .end local v13    # "responseCode":I
    .end local v22    # "timer":Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;
    :cond_5
    :goto_3
    const-string/jumbo v4, "fetchCookiesFromServerSuccess"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    move-object/from16 v19, v18

    .line 492
    .restart local v19    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    goto/16 :goto_0

    .line 461
    .end local v19    # "cookies":Ljava/lang/Object;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :catch_0
    move-exception v20

    .line 463
    .local v20, "e":Ljava/io/IOException;
    :try_start_2
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Got IOException when fetching Cookie from server "

    move-object/from16 v0, v20

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 464
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NETWORK_FAILURE:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    invoke-virtual/range {v20 .. v20}, Ljava/io/IOException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    move-object/from16 v0, p4

    invoke-interface {v0, v4}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 466
    const-string/jumbo v4, "fetchCookiesFromServerFailure:IOException"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 486
    if-eqz v17, :cond_5

    .line 488
    invoke-virtual/range {v17 .. v17}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_3

    .line 469
    .end local v20    # "e":Ljava/io/IOException;
    :catch_1
    move-exception v20

    .line 471
    .local v20, "e":Lorg/json/JSONException;
    :try_start_3
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Got JSONException while parsing response "

    move-object/from16 v0, v20

    invoke-static {v4, v5, v0}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 472
    sget-object v4, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->UNRECOGNIZED:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v4}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v4

    invoke-virtual/range {v20 .. v20}, Lorg/json/JSONException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v4

    move-object/from16 v0, p4

    invoke-interface {v0, v4}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 476
    const-string/jumbo v4, "fetchCookiesFromServerFailure:JSONException"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 486
    if-eqz v17, :cond_5

    .line 488
    invoke-virtual/range {v17 .. v17}, Ljava/net/HttpURLConnection;->disconnect()V

    goto :goto_3

    .line 478
    .end local v20    # "e":Lorg/json/JSONException;
    :catch_2
    move-exception v20

    .line 480
    .local v20, "e":Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
    :try_start_4
    sget-object v4, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Get error when fetchAuthCookies: %s"

    const/4 v8, 0x1

    new-array v8, v8, [Ljava/lang/Object;

    const/4 v9, 0x0

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorMsg()Ljava/lang/String;

    move-result-object v10

    aput-object v10, v8, v9

    invoke-static {v5, v8}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 481
    invoke-virtual/range {v20 .. v20}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getErrorCode()I

    move-result v4

    invoke-virtual/range {v20 .. v20}, Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;->getMessage()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p4

    invoke-static {v0, v4, v5}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->callbackError(Lcom/amazon/identity/auth/device/api/Callback;ILjava/lang/String;)V

    .line 482
    const-string/jumbo v4, "fetchCookiesFromServerFailure:OAuthTokenManagerException"

    const/4 v5, 0x0

    new-array v5, v5, [Ljava/lang/String;

    invoke-static {v4, v5}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 486
    if-eqz v17, :cond_5

    .line 488
    invoke-virtual/range {v17 .. v17}, Ljava/net/HttpURLConnection;->disconnect()V

    goto/16 :goto_3

    .line 486
    .end local v20    # "e":Lcom/amazon/identity/auth/device/token/OAuthTokenManager$OAuthTokenManagerException;
    :catchall_0
    move-exception v4

    if-eqz v17, :cond_6

    .line 488
    invoke-virtual/range {v17 .. v17}, Ljava/net/HttpURLConnection;->disconnect()V

    :cond_6
    throw v4
.end method

.method public getAuthCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)V
    .locals 10
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .param p3, "options"    # Landroid/os/Bundle;
    .param p4, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "tracer"    # Lcom/amazon/identity/auth/device/framework/Tracer;

    .prologue
    .line 109
    sget-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Getting cookies for package %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v5, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mContext:Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getPackageName()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v2, v4

    invoke-static {v1, v2}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 112
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mMapAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v0, p1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->isAccountRegistered(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 114
    sget-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Account not registered"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 115
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->NO_ACCOUNT:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v0

    const-string/jumbo v1, "Given Account is currently not registered."

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    invoke-interface {p4, v0}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 178
    :cond_0
    :goto_0
    return-void

    .line 121
    :cond_1
    const-string/jumbo v0, "com.amazon.identity.auth.device.internal.cookiekeys.options.ignorefresh"

    const/4 v1, 0x0

    invoke-virtual {p3, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    .line 123
    if-eqz v0, :cond_3

    .line 126
    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getAuthCookiesFromStorage(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-eqz v0, :cond_2

    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 127
    .local v3, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_2
    invoke-direct {p0, v3, p1, p2, p4}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->onSuccess(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0

    .line 131
    .end local v3    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_3
    const-string/jumbo v0, "com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh"

    const/4 v1, 0x0

    invoke-virtual {p3, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v7

    .line 133
    .local v7, "forceRefresh":Z
    sget-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Try getting the cookies from data store"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 134
    const/4 v0, 0x0

    if-eqz p1, :cond_6

    invoke-direct {p0, p1, p2}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getAuthCookiesFromStorage(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v2

    if-nez v2, :cond_5

    if-nez v7, :cond_4

    const/4 v0, 0x1

    :cond_4
    :goto_1
    new-instance v6, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;

    invoke-direct {v6, v1, v0}, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;-><init>(Ljava/util/List;Z)V

    .line 135
    .local v6, "cacheResponse":Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;
    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;->getCookies()Ljava/util/List;

    move-result-object v3

    .line 137
    .restart local v3    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-virtual {v6}, Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;->shouldReturnCookies()Z

    move-result v9

    .line 138
    .local v9, "returnCachedCookies":Z
    invoke-direct {p0, v3}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->shouldRefreshCookiesBasedOnExpiry(Ljava/util/List;)Z

    move-result v8

    .line 142
    .local v8, "haveCookiesExpired":Z
    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_7

    if-nez v8, :cond_7

    if-eqz v9, :cond_7

    .line 144
    sget-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Returning cached cookies"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 145
    invoke-direct {p0, v3, p1, p2, p4}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->onSuccess(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0

    .line 134
    .end local v3    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .end local v6    # "cacheResponse":Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;
    .end local v8    # "haveCookiesExpired":Z
    .end local v9    # "returnCachedCookies":Z
    :cond_5
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getNonAuthCookiesFromStorage(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    goto :goto_1

    :cond_6
    invoke-direct {p0, p2}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getNonAuthCookiesFromStorage(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    if-nez v7, :cond_4

    const/4 v0, 0x1

    goto :goto_1

    .line 149
    .restart local v3    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .restart local v6    # "cacheResponse":Lcom/amazon/identity/auth/device/token/MAPCookieManager$CookieCacheResponse;
    .restart local v8    # "haveCookiesExpired":Z
    .restart local v9    # "returnCachedCookies":Z
    :cond_7
    sget-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Fetching cookies from server"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    move-object v0, p0

    move-object v1, p1

    move-object v2, p2

    move-object v4, p4

    move-object v5, p5

    .line 150
    invoke-virtual/range {v0 .. v5}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->fetchCookiesFromServer(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/framework/Tracer;)Ljava/util/List;

    move-result-object v3

    .line 151
    invoke-static {v3}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 158
    sget-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "Updating cookie data store with cookie exchange response"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 159
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 161
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    invoke-virtual {v0, p2, v3}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->setNonAuthCookies(Ljava/lang/String;Ljava/util/List;)V

    .line 176
    :cond_8
    :goto_2
    invoke-direct {p0, v3, p1, p2, p4}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->onSuccess(Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto/16 :goto_0

    .line 167
    :cond_9
    invoke-virtual {p0, v3, p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(Ljava/util/List;Ljava/lang/String;)V

    .line 168
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    invoke-virtual {v0, p1, p2, v3}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->setAllCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 171
    if-nez v7, :cond_8

    .line 173
    iget-object v0, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mCookieDataStore:Lcom/amazon/identity/auth/device/storage/CookieDataStore;

    const/4 v1, 0x0

    invoke-virtual {v0, p2, v1}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->setNonAuthCookies(Ljava/lang/String;Ljava/util/List;)V

    .line 174
    sget-object v0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string/jumbo v2, "Cleared non-auth cookies for doamin:"

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2
.end method

.method public getNonAuthCookies(Ljava/lang/String;)Ljava/util/List;
    .locals 2
    .param p1, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .prologue
    .line 274
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getNonAuthCookiesFromStorage(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 275
    .local v0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 277
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 284
    :cond_0
    :goto_0
    return-object v0

    .line 279
    .restart local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_1
    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->shouldRefreshCookiesBasedOnExpiry(Ljava/util/List;)Z

    move-result v1

    .line 280
    if-eqz v1, :cond_0

    .line 282
    new-instance v0, Ljava/util/ArrayList;

    .end local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    goto :goto_0
.end method

.method public parseJSONArrayCookies(Ljava/lang/String;Lorg/json/JSONArray;)Ljava/util/List;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "jsonArray"    # Lorg/json/JSONArray;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Lorg/json/JSONArray;",
            ")",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;"
        }
    .end annotation

    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lorg/json/JSONException;
        }
    .end annotation

    .prologue
    .line 643
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->generateCookieListFromCookieJSONArray(Ljava/lang/String;Lorg/json/JSONArray;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public updateTheSidInStorageAndRemoveTheSidCookieInCookiesIfNecessary(Ljava/util/List;Ljava/lang/String;)V
    .locals 3
    .param p2, "directedID"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 192
    .local p1, "cookiesReturnedFromServer":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->getSidString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v0

    .line 193
    .local v0, "sidInCookies":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 195
    invoke-static {p1}, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->removeTheSidCookieIfExist(Ljava/util/List;)V

    .line 196
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.cookie.sid"

    invoke-virtual {v1, p2, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 203
    :cond_0
    :goto_0
    return-void

    .line 200
    :cond_1
    sget-object v1, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->TAG:Ljava/lang/String;

    .line 201
    iget-object v1, p0, Lcom/amazon/identity/auth/device/token/MAPCookieManager;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "com.amazon.dcp.sso.token.cookie.sid"

    invoke-virtual {v1, p2, v2, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setToken(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
