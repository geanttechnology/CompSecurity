.class public Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;
.super Lcom/amazon/identity/auth/device/storage/CookieDataStore;
.source "GenericCookieDataStore.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const-class v0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 31
    invoke-static {p1}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->create(Landroid/content/Context;)Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/framework/ServiceWrappingContext;->getDataStorage()Lcom/amazon/identity/auth/device/storage/DataStorage;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;-><init>(Lcom/amazon/identity/auth/device/storage/DataStorage;)V

    .line 32
    return-void
.end method

.method public constructor <init>(Lcom/amazon/identity/auth/device/storage/DataStorage;)V
    .locals 0
    .param p1, "dataStorage"    # Lcom/amazon/identity/auth/device/storage/DataStorage;

    .prologue
    .line 35
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;-><init>()V

    .line 36
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    .line 37
    return-void
.end method

.method private backfillOldCookieFormat(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 2
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 127
    .local p3, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 130
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, p3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 131
    .local v0, "copyOfCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    new-instance v1, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore$1;

    invoke-direct {v1, p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore$1;-><init>(Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    invoke-static {v1}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 140
    .end local v0    # "copyOfCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_0
    return-void
.end method

.method private static cookiesToTokenMap(Ljava/lang/String;Ljava/util/List;)Ljava/util/Map;
    .locals 3
    .param p0, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 144
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 145
    .local v0, "tokens":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->getCookieTokenKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->toSerializedBundleString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    invoke-static {p0}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->getJsonCookieTokenKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->toJson(Ljava/util/List;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 147
    return-object v0
.end method

.method static getCookieTokenKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "domain"    # Ljava/lang/String;

    .prologue
    .line 156
    const-string/jumbo v0, "%s.%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string/jumbo v3, "com.amazon.dcp.sso.token.amazon.cookies"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getJsonCookieTokenKey(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "domain"    # Ljava/lang/String;

    .prologue
    .line 165
    const-string/jumbo v0, "%s.json.%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string/jumbo v3, "com.amazon.dcp.sso.token.amazon.cookies"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static getJsonDeviceDataKeyForDomain(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p0, "domain"    # Ljava/lang/String;

    .prologue
    .line 174
    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "json."

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0, p0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public clearCookies(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 42
    new-instance v0, Ljava/lang/IllegalStateException;

    const-string/jumbo v1, "Clear cookies is not supported"

    invoke-direct {v0, v1}, Ljava/lang/IllegalStateException;-><init>(Ljava/lang/String;)V

    throw v0
.end method

.method public getCookieTokenMapOrWriteToDataStoreFromRegistrationData(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Ljava/util/Map;
    .locals 1
    .param p1, "directedId"    # Ljava/lang/String;
    .param p3, "cookieDomain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;",
            "Ljava/lang/String;",
            ")",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 54
    .local p2, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 56
    sget-object v0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->TAG:Ljava/lang/String;

    .line 57
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    .line 60
    :goto_0
    return-object v0

    :cond_0
    invoke-static {p3, p2}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->cookiesToTokenMap(Ljava/lang/String;Ljava/util/List;)Ljava/util/Map;

    move-result-object v0

    goto :goto_0
.end method

.method protected getCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 5
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
    const/4 v4, 0x0

    .line 66
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    .line 69
    if-eqz v1, :cond_1

    .line 71
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth"

    invoke-virtual {v1, v2, p2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v4}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 77
    .local v0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 79
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth"

    invoke-static {p2}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->getJsonDeviceDataKeyForDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getDeviceData(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v4}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromJson(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 84
    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->backfillOldCookieFormat(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 104
    :cond_0
    :goto_0
    return-object v0

    .line 89
    .end local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {p2}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->getCookieTokenKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 95
    .restart local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/CollectionUtils;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 97
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {p2}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->getJsonCookieTokenKey(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->getToken(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromJson(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 100
    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->backfillOldCookieFormat(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    goto :goto_0
.end method

.method protected setCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 3
    .param p1, "directedId"    # Ljava/lang/String;
    .param p2, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 110
    .local p3, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    .line 112
    if-eqz v1, :cond_0

    .line 114
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 115
    .local v0, "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->toSerializedBundleString(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, p2, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 116
    invoke-static {p2}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->getJsonDeviceDataKeyForDomain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->toJson(Ljava/util/List;)Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 117
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    const-string/jumbo v2, "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth"

    invoke-virtual {v1, v2, v0}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setDeviceData(Ljava/lang/String;Ljava/util/Map;)V

    .line 123
    .end local v0    # "data":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    :goto_0
    return-void

    .line 121
    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->mDataStorage:Lcom/amazon/identity/auth/device/storage/DataStorage;

    invoke-static {p2, p3}, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;->cookiesToTokenMap(Ljava/lang/String;Ljava/util/List;)Ljava/util/Map;

    move-result-object v2

    invoke-virtual {v1, p1, v2}, Lcom/amazon/identity/auth/device/storage/DataStorage;->setTokens(Ljava/lang/String;Ljava/util/Map;)V

    goto :goto_0
.end method
