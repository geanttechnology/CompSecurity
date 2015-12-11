.class public Lcom/amazon/mShop/sso/MAPCookiesFetcher;
.super Ljava/lang/Object;
.source "MAPCookiesFetcher.java"


# static fields
.field private static final TAG:Ljava/lang/String;


# instance fields
.field private final mAccount:Ljava/lang/String;

.field private final mApplicationContext:Landroid/content/Context;

.field private final mForceSync:Z

.field private final mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

.field private mXCookieOnly:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 35
    const-class v0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;Landroid/content/Context;ZLjava/lang/String;Z)V
    .locals 3
    .param p1, "callback"    # Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;
    .param p2, "applicationContext"    # Landroid/content/Context;
    .param p3, "forceSync"    # Z
    .param p4, "account"    # Ljava/lang/String;
    .param p5, "xCookieOnly"    # Z

    .prologue
    .line 40
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 41
    iput-object p1, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    .line 42
    iput-object p2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    .line 43
    iput-boolean p3, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mForceSync:Z

    .line 44
    iput-object p4, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;

    .line 45
    iput-boolean p5, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mXCookieOnly:Z

    .line 47
    sget-boolean v0, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 48
    sget-object v0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;

    const-string/jumbo v1, "new MAPCookiesFetcher"

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 49
    sget-object v0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "mAccount "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, " mXCookieOnly "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mXCookieOnly:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 51
    :cond_0
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Landroid/content/Context;)V
    .locals 1
    .param p1, "account"    # Ljava/lang/String;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 53
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 54
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    .line 55
    iput-object p1, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;

    .line 56
    iput-object p2, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    .line 57
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mForceSync:Z

    .line 58
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Landroid/content/Context;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$100()Ljava/lang/String;
    .locals 1

    .prologue
    .line 30
    sget-object v0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    .prologue
    .line 30
    iget-boolean v0, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mXCookieOnly:Z

    return v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/sso/MAPCookiesFetcher;)Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/sso/MAPCookiesFetcher;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/sso/MAPCookiesFetcher;Landroid/os/Bundle;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/sso/MAPCookiesFetcher;
    .param p1, "x1"    # Landroid/os/Bundle;

    .prologue
    .line 30
    invoke-direct {p0, p1}, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->failure(Landroid/os/Bundle;)V

    return-void
.end method

.method private failure(Landroid/os/Bundle;)V
    .locals 6
    .param p1, "results"    # Landroid/os/Bundle;

    .prologue
    .line 159
    const/4 v2, 0x0

    .line 160
    .local v2, "errorMsg":Ljava/lang/String;
    if-eqz p1, :cond_1

    .line 161
    const-string/jumbo v4, "com.amazon.dcp.sso.ErrorCode"

    const/4 v5, -0x1

    invoke-virtual {p1, v4, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 162
    .local v0, "errorCode":I
    const-string/jumbo v4, "com.amazon.dcp.sso.ErrorMessage"

    invoke-virtual {p1, v4}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 164
    .local v3, "message":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "Cookie Fetch Fail. Code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "; errorMsg: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    const-string/jumbo v3, ""

    .end local v3    # "message":Ljava/lang/String;
    :cond_0
    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 165
    sget-boolean v4, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v4, :cond_1

    .line 166
    sget-object v4, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->TAG:Ljava/lang/String;

    invoke-static {v4, v2}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 169
    .end local v0    # "errorCode":I
    :cond_1
    move-object v1, v2

    .line 171
    .local v1, "errorMessage":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    if-eqz v4, :cond_2

    .line 172
    iget-object v4, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mUserSubscriberCallback:Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;

    invoke-virtual {v4, v1}, Lcom/amazon/mShop/sso/AccountCookiesSyncManager$UserSubscriberCallback;->onFailed(Ljava/lang/String;)V

    .line 174
    :cond_2
    return-void
.end method


# virtual methods
.method public getCookies()V
    .locals 9

    .prologue
    const/4 v7, 0x1

    .line 94
    new-instance v4, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v5, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    invoke-direct {v4, v5}, Lcom/amazon/identity/auth/device/api/TokenManagement;-><init>(Landroid/content/Context;)V

    .line 96
    .local v4, "tokenManagement":Lcom/amazon/identity/auth/device/api/TokenManagement;
    const/4 v2, 0x0

    .line 97
    .local v2, "options":Landroid/os/Bundle;
    iget-boolean v5, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mForceSync:Z

    if-eqz v5, :cond_0

    .line 98
    new-instance v2, Landroid/os/Bundle;

    .end local v2    # "options":Landroid/os/Bundle;
    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 99
    .restart local v2    # "options":Landroid/os/Bundle;
    const-string/jumbo v5, "com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh"

    iget-boolean v6, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mForceSync:Z

    invoke-virtual {v2, v5, v6}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 103
    :cond_0
    new-instance v3, Lcom/amazon/mShop/net/ServiceCallIdentifier;

    const-string/jumbo v6, "MobileAuthenticationPlatform"

    iget-object v5, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_1

    const-string/jumbo v5, "getAuthCookie"

    :goto_0
    invoke-direct {v3, v6, v5}, Lcom/amazon/mShop/net/ServiceCallIdentifier;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    .line 105
    .local v3, "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    invoke-static {v3}, Lcom/amazon/mShop/net/CallObserver;->start(Lcom/amazon/mShop/net/ServiceCallIdentifier;)Lcom/amazon/mShop/net/CallObserver;

    move-result-object v0

    .line 106
    .local v0, "callObserver":Lcom/amazon/mShop/net/CallObserver;
    iget-object v5, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    invoke-static {v5, v7}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 108
    .local v1, "cookieDomain":Ljava/lang/String;
    iget-object v5, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;

    const-string/jumbo v6, "www%s"

    new-array v7, v7, [Ljava/lang/Object;

    const/4 v8, 0x0

    aput-object v1, v7, v8

    invoke-static {v6, v7}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    new-instance v7, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;

    invoke-direct {v7, p0, v1, v0}, Lcom/amazon/mShop/sso/MAPCookiesFetcher$1;-><init>(Lcom/amazon/mShop/sso/MAPCookiesFetcher;Ljava/lang/String;Lcom/amazon/mShop/net/CallObserver;)V

    invoke-virtual {v4, v5, v6, v2, v7}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 156
    return-void

    .line 103
    .end local v0    # "callObserver":Lcom/amazon/mShop/net/CallObserver;
    .end local v1    # "cookieDomain":Ljava/lang/String;
    .end local v3    # "serviceCallIdentifier":Lcom/amazon/mShop/net/ServiceCallIdentifier;
    :cond_1
    const-string/jumbo v5, "getNonAuthCookie"

    goto :goto_0
.end method

.method public peekXCookie()Z
    .locals 10

    .prologue
    const/4 v9, 0x1

    const/4 v6, 0x0

    .line 68
    new-instance v5, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v7, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    invoke-direct {v5, v7}, Lcom/amazon/identity/auth/device/api/TokenManagement;-><init>(Landroid/content/Context;)V

    .line 69
    .local v5, "tokenManagement":Lcom/amazon/identity/auth/device/api/TokenManagement;
    iget-object v7, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    invoke-static {v7, v9}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v0

    .line 70
    .local v0, "cookieDomain":Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mAccount:Ljava/lang/String;

    const-string/jumbo v8, "www%s"

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v0, v9, v6

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    const/4 v9, 0x0

    invoke-virtual {v5, v7, v8, v9}, Lcom/amazon/identity/auth/device/api/TokenManagement;->peekCookies(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    move-result-object v3

    .line 72
    .local v3, "future":Lcom/amazon/identity/auth/device/api/MAPFuture;, "Lcom/amazon/identity/auth/device/api/MAPFuture<Landroid/os/Bundle;>;"
    :try_start_0
    invoke-interface {v3}, Lcom/amazon/identity/auth/device/api/MAPFuture;->get()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/os/Bundle;

    .line 73
    .local v4, "result":Landroid/os/Bundle;
    const-string/jumbo v7, "com.amazon.identity.auth.device.api.cookiekeys.all"

    invoke-virtual {v4, v7}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 74
    .local v1, "cookies":[Ljava/lang/String;
    iget-object v7, p0, Lcom/amazon/mShop/sso/MAPCookiesFetcher;->mApplicationContext:Landroid/content/Context;

    invoke-static {v7, v1}, Lcom/amazon/mShop/sso/CookieHelper;->setXCookie(Landroid/content/Context;[Ljava/lang/String;)Z
    :try_end_0
    .catch Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/InterruptedException; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/util/concurrent/ExecutionException; {:try_start_0 .. :try_end_0} :catch_2

    move-result v6

    .line 89
    .end local v1    # "cookies":[Ljava/lang/String;
    .end local v4    # "result":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return v6

    .line 75
    :catch_0
    move-exception v2

    .line 76
    .local v2, "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    sget-boolean v7, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v7, :cond_0

    .line 77
    const-string/jumbo v7, "Amazon.SSOUtil"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "peekXCookie: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 79
    .end local v2    # "e":Lcom/amazon/identity/auth/device/api/MAPCallbackErrorException;
    :catch_1
    move-exception v2

    .line 80
    .local v2, "e":Ljava/lang/InterruptedException;
    sget-boolean v7, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v7, :cond_0

    .line 81
    const-string/jumbo v7, "Amazon.SSOUtil"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "peekXCookie: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v2}, Ljava/lang/InterruptedException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 83
    .end local v2    # "e":Ljava/lang/InterruptedException;
    :catch_2
    move-exception v2

    .line 84
    .local v2, "e":Ljava/util/concurrent/ExecutionException;
    sget-boolean v7, Lcom/amazon/mShop/sso/SSOUtil;->DEBUG:Z

    if-eqz v7, :cond_0

    .line 85
    const-string/jumbo v7, "Amazon.SSOUtil"

    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v9, "peekXCookie: "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v2}, Ljava/util/concurrent/ExecutionException;->getMessage()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
