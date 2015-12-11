.class public abstract Lcom/amazon/identity/auth/device/storage/CookieDataStore;
.super Ljava/lang/Object;
.source "CookieDataStore.java"


# static fields
.field public static final COOKIE_STORAGE_NAMESPACE:Ljava/lang/String; = "com.amazon.identity.auth.device.cookiekeys.namespace"

.field public static final NON_AUTH_COOKIE_STORAGE_NAMESPACE:Ljava/lang/String; = "com.amazon.identity.auth.device.cookiekeys.namespace.nonAuth"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public abstract clearCookies(Landroid/content/Context;Ljava/lang/String;)Z
.end method

.method public getAllCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
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
    .line 31
    invoke-virtual {p0, p1, p2}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->getCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public abstract getCookieTokenMapOrWriteToDataStoreFromRegistrationData(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)Ljava/util/Map;
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
.end method

.method protected abstract getCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
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
.end method

.method public getNonAuthCookies(Ljava/lang/String;)Ljava/util/List;
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
    .line 26
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->getCookies(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public setAllCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 0
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
    .line 41
    .local p3, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    invoke-virtual {p0, p1, p2, p3}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->setCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 42
    return-void
.end method

.method protected abstract setCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
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
.end method

.method public setNonAuthCookies(Ljava/lang/String;Ljava/util/List;)V
    .locals 1
    .param p1, "domain"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lorg/apache/http/cookie/Cookie;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p2, "cookies":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/cookie/Cookie;>;"
    const/4 v0, 0x0

    invoke-virtual {p0, v0, p1, p2}, Lcom/amazon/identity/auth/device/storage/CookieDataStore;->setCookies(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 37
    return-void
.end method
