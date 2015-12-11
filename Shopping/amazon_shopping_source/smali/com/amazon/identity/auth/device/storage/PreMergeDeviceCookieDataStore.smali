.class public Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;
.super Lcom/amazon/identity/auth/device/storage/CookieDataStore;
.source "PreMergeDeviceCookieDataStore.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mContext:Landroid/content/Context;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/identity/auth/device/storage/GenericCookieDataStore;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;-><init>()V

    .line 26
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->mContext:Landroid/content/Context;

    .line 27
    return-void
.end method

.method private static getLocalStoreCookieNamespace(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "directedId"    # Ljava/lang/String;

    .prologue
    .line 86
    const-string/jumbo v0, "%s#%s"

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/Object;

    const/4 v2, 0x0

    const-string/jumbo v3, "com.amazon.identity.auth.device.cookiekeys.namespace"

    aput-object v3, v1, v2

    const/4 v2, 0x1

    aput-object p0, v1, v2

    invoke-static {v0, v1}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public clearCookies(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 2
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "directedId"    # Ljava/lang/String;

    .prologue
    .line 94
    new-instance v0, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    invoke-static {p2}, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->getLocalStoreCookieNamespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v0, p1, v1}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 96
    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->clearStore()Z

    move-result v0

    return v0
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
    .line 108
    .local p2, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-interface {p2}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    sget-object v0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->TAG:Ljava/lang/String;

    .line 111
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    .line 116
    :goto_0
    return-object v0

    .line 114
    :cond_0
    invoke-virtual {p0, p1, p3, p2}, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->setCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 116
    invoke-static {}, Ljava/util/Collections;->emptyMap()Ljava/util/Map;

    move-result-object v0

    goto :goto_0
.end method

.method protected getCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    .locals 6
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
    .line 32
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    .line 35
    if-eqz v4, :cond_1

    .line 37
    new-instance v2, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->mContext:Landroid/content/Context;

    const-string/jumbo v5, "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth"

    invoke-direct {v2, v4, v5}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 44
    .local v2, "keyValueStore":Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;
    :goto_0
    invoke-virtual {v2, p2}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->getValue(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 45
    .local v3, "serializedCookies":Ljava/lang/String;
    invoke-static {v3, p1}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->fromJsonOrSerializedBundle(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 48
    .local v0, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-nez v4, :cond_0

    const-string/jumbo v4, "["

    invoke-virtual {v3, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 51
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 52
    .local v1, "copyOfCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    new-instance v4, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;

    invoke-direct {v4, p0, p1, p2, v1}, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore$1;-><init>(Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    invoke-static {v4}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->submitToBackgroundThread(Ljava/lang/Runnable;)V

    .line 62
    .end local v1    # "copyOfCookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    :cond_0
    return-object v0

    .line 41
    .end local v0    # "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    .end local v2    # "keyValueStore":Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;
    .end local v3    # "serializedCookies":Ljava/lang/String;
    :cond_1
    new-instance v2, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->mContext:Landroid/content/Context;

    invoke-static {p1}, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->getLocalStoreCookieNamespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    invoke-direct {v2, v4, v5}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .restart local v2    # "keyValueStore":Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;
    goto :goto_0
.end method

.method protected setCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 5
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
    .line 68
    .local p3, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    .line 70
    .local v0, "setNonAuthCookies":Z
    invoke-static {p3}, Lcom/amazon/identity/auth/device/utils/CookieUtils;->toJson(Ljava/util/List;)Ljava/lang/String;

    move-result-object v1

    .line 72
    .local v1, "value":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 74
    new-instance v2, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->mContext:Landroid/content/Context;

    const-string/jumbo v4, "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth"

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 75
    invoke-virtual {v2, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->setValue(Ljava/lang/String;Ljava/lang/String;)Z

    .line 82
    :goto_0
    return-void

    .line 79
    :cond_0
    new-instance v2, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->mContext:Landroid/content/Context;

    invoke-static {p1}, Lcom/amazon/identity/auth/device/storage/PreMergeDeviceCookieDataStore;->getLocalStoreCookieNamespace(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 80
    invoke-virtual {v2, p2, v1}, Lcom/amazon/identity/auth/device/storage/LocalKeyValueStore;->setValue(Ljava/lang/String;Ljava/lang/String;)Z

    goto :goto_0
.end method
