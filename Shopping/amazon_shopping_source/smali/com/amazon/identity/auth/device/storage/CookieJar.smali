.class public Lcom/amazon/identity/auth/device/storage/CookieJar;
.super Ljava/lang/Object;
.source "CookieJar.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mCookies:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/kcpsdk/auth/Cookie;",
            ">;"
        }
    .end annotation
.end field

.field private final mInit:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private mInternationalXmainCookies:Lorg/json/JSONObject;

.field private mXmain:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 16
    const-class v0, Lcom/amazon/identity/auth/device/storage/CookieJar;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/storage/CookieJar;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Ljava/util/List;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/identity/kcpsdk/auth/Cookie;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 34
    .local p1, "cookies":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/kcpsdk/auth/Cookie;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 27
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    const/4 v1, 0x0

    invoke-direct {v0, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mInit:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 35
    if-eqz p1, :cond_0

    .line 37
    iput-object p1, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mCookies:Ljava/util/List;

    .line 44
    :goto_0
    new-instance v0, Lorg/json/JSONObject;

    invoke-direct {v0}, Lorg/json/JSONObject;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mInternationalXmainCookies:Lorg/json/JSONObject;

    .line 45
    return-void

    .line 41
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mCookies:Ljava/util/List;

    goto :goto_0
.end method

.method private ensureInitialized()V
    .locals 8

    .prologue
    const/4 v5, 0x1

    .line 63
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mInit:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v4, v5}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 94
    :cond_0
    return-void

    .line 68
    :cond_1
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mCookies:Ljava/util/List;

    invoke-interface {v4}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    .local v3, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/identity/kcpsdk/auth/Cookie;

    .line 72
    .local v0, "cookieData":Lcom/amazon/identity/kcpsdk/auth/Cookie;
    :try_start_0
    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 74
    .local v1, "cookieValue":Ljava/lang/String;
    if-eqz v1, :cond_2

    .line 79
    const-string/jumbo v4, "x-main"

    invoke-virtual {v1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 81
    invoke-direct {p0, v1}, Lcom/amazon/identity/auth/device/storage/CookieJar;->parseXmain(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mXmain:Ljava/lang/String;

    .line 84
    :cond_3
    const-string/jumbo v4, "x-main"

    invoke-virtual {v1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_4

    const-string/jumbo v4, "x-acb"

    invoke-virtual {v1, v4}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_5

    :cond_4
    move v4, v5

    :goto_1
    if-eqz v4, :cond_2

    .line 86
    iget-object v4, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mInternationalXmainCookies:Lorg/json/JSONObject;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "https://www"

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->getUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0}, Lcom/amazon/identity/kcpsdk/auth/Cookie;->getValue()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lorg/json/JSONObject;->put(Ljava/lang/String;Ljava/lang/Object;)Lorg/json/JSONObject;
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 89
    .end local v1    # "cookieValue":Ljava/lang/String;
    :catch_0
    move-exception v2

    .line 91
    .local v2, "e":Lorg/json/JSONException;
    sget-object v4, Lcom/amazon/identity/auth/device/storage/CookieJar;->TAG:Ljava/lang/String;

    const-string/jumbo v6, "Adding JSON value failed"

    invoke-static {v4, v6, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 84
    .end local v2    # "e":Lorg/json/JSONException;
    .restart local v1    # "cookieValue":Ljava/lang/String;
    :cond_5
    const/4 v4, 0x0

    goto :goto_1
.end method

.method private parseXmain(Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "cookieValue"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 102
    :try_start_0
    const-string/jumbo v3, ";"

    invoke-virtual {p1, v3}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    if-gtz v4, :cond_0

    sget-object v3, Lcom/amazon/identity/auth/device/storage/CookieJar;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cookie does not seem to be in a valid format"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v2

    .line 103
    .local v1, "httpCookieValue":Ljava/lang/String;
    :goto_0
    if-eqz v1, :cond_2

    .line 114
    .end local v1    # "httpCookieValue":Ljava/lang/String;
    :goto_1
    return-object v1

    .line 102
    :cond_0
    const/4 v4, 0x0

    aget-object v3, v3, v4

    const-string/jumbo v4, "="

    invoke-virtual {v3, v4}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    array-length v4, v3

    const/4 v5, 0x2

    if-eq v4, v5, :cond_1

    sget-object v3, Lcom/amazon/identity/auth/device/storage/CookieJar;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Cookie name/value pair does not seem to be in a valid format"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object v1, v2

    goto :goto_0

    :cond_1
    const/4 v4, 0x1

    aget-object v1, v3, v4

    goto :goto_0

    .line 108
    .restart local v1    # "httpCookieValue":Ljava/lang/String;
    :cond_2
    sget-object v3, Lcom/amazon/identity/auth/device/storage/CookieJar;->TAG:Ljava/lang/String;

    const-string/jumbo v4, "Found no x-main cookie in RegisterDeviceResponse"

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/lang/IllegalArgumentException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v1    # "httpCookieValue":Ljava/lang/String;
    :goto_2
    move-object v1, v2

    .line 114
    goto :goto_1

    .line 110
    :catch_0
    move-exception v0

    .line 112
    .local v0, "e":Ljava/lang/IllegalArgumentException;
    sget-object v3, Lcom/amazon/identity/auth/device/storage/CookieJar;->TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string/jumbo v5, "Caught exception parsing the cookie value out of RegisterDeviceResponse"

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/lang/IllegalArgumentException;->getMessage()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_2
.end method


# virtual methods
.method public getInternationalXMainAndXAcbCookies()Ljava/lang/String;
    .locals 1

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->ensureInitialized()V

    .line 58
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mInternationalXmainCookies:Lorg/json/JSONObject;

    invoke-virtual {v0}, Lorg/json/JSONObject;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getXmain()Ljava/lang/String;
    .locals 1

    .prologue
    .line 49
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/storage/CookieJar;->ensureInitialized()V

    .line 51
    iget-object v0, p0, Lcom/amazon/identity/auth/device/storage/CookieJar;->mXmain:Ljava/lang/String;

    return-object v0
.end method
