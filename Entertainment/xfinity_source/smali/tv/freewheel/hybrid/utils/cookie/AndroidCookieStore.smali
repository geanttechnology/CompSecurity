.class public Ltv/freewheel/hybrid/utils/cookie/AndroidCookieStore;
.super Ljava/lang/Object;
.source "AndroidCookieStore.java"

# interfaces
.implements Ltv/freewheel/hybrid/utils/cookie/IAndroidCookieStore;


# static fields
.field public static context:Landroid/content/Context;


# instance fields
.field private logger:Ltv/freewheel/hybrid/utils/Logger;


# direct methods
.method public constructor <init>()V
    .locals 3
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/ClassNotFoundException;
        }
    .end annotation

    .prologue
    .line 19
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 20
    const-class v1, Ltv/freewheel/hybrid/utils/URLLoader;

    invoke-virtual {v1}, Ljava/lang/Class;->getClassLoader()Ljava/lang/ClassLoader;

    move-result-object v0

    .line 21
    .local v0, "cl":Ljava/lang/ClassLoader;
    const-string v1, "android.webkit.CookieManager"

    const/4 v2, 0x1

    invoke-static {v1, v2, v0}, Ljava/lang/Class;->forName(Ljava/lang/String;ZLjava/lang/ClassLoader;)Ljava/lang/Class;

    .line 23
    invoke-static {p0}, Ltv/freewheel/hybrid/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/hybrid/utils/Logger;

    move-result-object v1

    iput-object v1, p0, Ltv/freewheel/hybrid/utils/cookie/AndroidCookieStore;->logger:Ltv/freewheel/hybrid/utils/Logger;

    .line 24
    return-void
.end method

.method public static initialize(Landroid/content/Context;)V
    .locals 1
    .param p0, "context"    # Landroid/content/Context;

    .prologue
    .line 14
    sput-object p0, Ltv/freewheel/hybrid/utils/cookie/AndroidCookieStore;->context:Landroid/content/Context;

    .line 15
    invoke-static {p0}, Landroid/webkit/CookieSyncManager;->createInstance(Landroid/content/Context;)Landroid/webkit/CookieSyncManager;

    .line 16
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeExpiredCookie()V

    .line 17
    return-void
.end method


# virtual methods
.method public getCookie(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 43
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public removeExpiredCookie()V
    .locals 1

    .prologue
    .line 39
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieManager;->removeExpiredCookie()V

    .line 40
    return-void
.end method

.method public setCookie(Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "cookie"    # Ljava/lang/String;

    .prologue
    .line 27
    iget-object v0, p0, Ltv/freewheel/hybrid/utils/cookie/AndroidCookieStore;->logger:Ltv/freewheel/hybrid/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "got cookie: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", for url: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/hybrid/utils/Logger;->verbose(Ljava/lang/String;)V

    .line 30
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 31
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 32
    return-void
.end method
