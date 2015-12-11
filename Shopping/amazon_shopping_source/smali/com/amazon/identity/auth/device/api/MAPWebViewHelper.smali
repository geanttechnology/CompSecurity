.class public final Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
.super Ljava/lang/Object;
.source "MAPWebViewHelper.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;,
        Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;
    }
.end annotation


# static fields
.field public static final AP_WEBVIEW_SIGNIN_ACTIVITY_REQUEST_CODE:I = 0x64

.field private static final LOG_TAG:Ljava/lang/String;


# instance fields
.field private final mAuthCallback:Lcom/amazon/identity/auth/device/api/Callback;

.field private final mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

.field private final mContext:Landroid/content/Context;

.field private final mLock:[Ljava/lang/Object;

.field private final mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

.field private final mNeedForceRefreshCookies:Ljava/util/concurrent/atomic/AtomicBoolean;

.field private final mOptions:Landroid/os/Bundle;

.field private mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

.field private mParseUrl:Z

.field private final mSharedPrefCookieUtils:Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;

.field private final mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

.field private final mWebView:Lcom/amazon/android/webkit/AmazonWebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 59
    const-class v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Lcom/amazon/android/webkit/AmazonWebView;Lcom/amazon/identity/auth/device/api/Callback;Lcom/amazon/identity/auth/device/api/Callback;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "webView"    # Lcom/amazon/android/webkit/AmazonWebView;
    .param p3, "clientCallback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p4, "authActivityCallback"    # Lcom/amazon/identity/auth/device/api/Callback;
    .param p5, "options"    # Landroid/os/Bundle;

    .prologue
    const/4 v2, 0x0

    .line 128
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 68
    new-array v0, v2, [Ljava/lang/Object;

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mLock:[Ljava/lang/Object;

    .line 80
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    .line 129
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPInit;->getInstance(Landroid/content/Context;)Lcom/amazon/identity/auth/device/api/MAPInit;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/api/MAPInit;->initialize()V

    .line 130
    iput-object p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mContext:Landroid/content/Context;

    .line 131
    iput-boolean v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParseUrl:Z

    .line 132
    if-nez p5, :cond_0

    new-instance p5, Landroid/os/Bundle;

    .end local p5    # "options":Landroid/os/Bundle;
    invoke-direct {p5}, Landroid/os/Bundle;-><init>()V

    :cond_0
    iput-object p5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mOptions:Landroid/os/Bundle;

    .line 133
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    .line 134
    new-instance v0, Lcom/amazon/identity/auth/device/api/TokenManagement;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/api/TokenManagement;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    .line 135
    new-instance v0, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mContext:Landroid/content/Context;

    invoke-direct {v0, v1}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mSharedPrefCookieUtils:Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;

    .line 136
    iput-object p2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    .line 137
    iput-object p3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 138
    iput-object p4, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mAuthCallback:Lcom/amazon/identity/auth/device/api/Callback;

    .line 139
    new-instance v0, Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-direct {v0, v2}, Ljava/util/concurrent/atomic/AtomicBoolean;-><init>(Z)V

    iput-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mNeedForceRefreshCookies:Ljava/util/concurrent/atomic/AtomicBoolean;

    .line 140
    return-void
.end method

.method static synthetic access$100(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/android/webkit/AmazonWebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setAuthenticationEvent(Lcom/amazon/identity/auth/device/api/Callback;)V

    return-void
.end method

.method static synthetic access$400(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)Lcom/amazon/identity/auth/device/api/Callback;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    .prologue
    .line 54
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;[Ljava/lang/String;)V
    .locals 7
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
    .param p1, "x1"    # [Ljava/lang/String;

    .prologue
    .line 54
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->getAmazonCookieManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v2

    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Lcom/amazon/android/webkit/AmazonCookieManager;->setAcceptCookie(Z)V

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->syncAmazonCookieSyncManager(Landroid/content/Context;)V

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->url:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    sget-object v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    :cond_0
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mSharedPrefCookieUtils:Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;

    invoke-virtual {v1, v0, p1}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->addCookiesToSharedPrefs(Ljava/lang/String;[Ljava/lang/String;)V

    array-length v3, p1

    const/4 v1, 0x0

    :goto_0
    if-ge v1, v3, :cond_1

    aget-object v4, p1, v1

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Adding cookie to CookieManager: "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    invoke-virtual {v2, v0, v4}, Lcom/amazon/android/webkit/AmazonCookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mContext:Landroid/content/Context;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->syncAmazonCookieSyncManager(Landroid/content/Context;)V

    return-void
.end method

.method static synthetic access$600(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->continueLoadingURL()V

    return-void
.end method

.method static synthetic access$700()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$800(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Landroid/app/Activity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;
    .param p1, "x1"    # Landroid/app/Activity;

    .prologue
    .line 54
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->startAuthentication(Landroid/app/Activity;)V

    return-void
.end method

.method private continueLoadingURL()V
    .locals 2

    .prologue
    .line 219
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->returnToURL:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 221
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    new-instance v0, Ljava/lang/StringBuilder;

    const-string/jumbo v1, "Loading ReturnToUrl:"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->returnToURL:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 222
    new-instance v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;

    invoke-direct {v0, p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V

    invoke-static {v0}, Lcom/amazon/identity/auth/device/utils/ThreadUtils;->runOnMainThread(Ljava/lang/Runnable;)V

    .line 231
    :cond_0
    return-void
.end method

.method public static getCookieDomainFromUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 4
    .param p0, "urlToExtract"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 401
    new-instance v2, Ljava/net/URL;

    invoke-direct {v2, p0}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 403
    invoke-virtual {v2}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v0

    .line 404
    .local v0, "host":Ljava/lang/String;
    const-string/jumbo v2, ".amazon."

    invoke-virtual {v0, v2}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v1

    .line 405
    .local v1, "location":I
    if-gez v1, :cond_0

    .line 407
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    .line 408
    new-instance v2, Ljava/net/MalformedURLException;

    const-string/jumbo v3, "Malformed URL: .amazon. is not in the url"

    invoke-direct {v2, v3}, Ljava/net/MalformedURLException;-><init>(Ljava/lang/String;)V

    throw v2

    .line 410
    :cond_0
    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    return-object v2
.end method

.method private getCookiesFromTokenManagement(ZLcom/amazon/identity/auth/device/api/Callback;)V
    .locals 7
    .param p1, "forceRefresh"    # Z
    .param p2, "callback"    # Lcom/amazon/identity/auth/device/api/Callback;

    .prologue
    .line 454
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 455
    .local v2, "options":Landroid/os/Bundle;
    const-string/jumbo v5, "com.amazon.identity.auth.device.api.cookiekeys.options.forcerefresh"

    invoke-virtual {v2, v5, p1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 456
    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    .line 457
    .local v1, "domain":Ljava/lang/String;
    const-string/jumbo v5, "domain"

    invoke-virtual {v2, v5, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 458
    const-string/jumbo v5, "cookietype"

    sget-object v6, Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;->COOKIE:Lcom/amazon/identity/auth/device/AccountManagerConstants$GetCookiesParams$COOKIE_TYPE;

    invoke-virtual {v2, v5, v6}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 460
    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v4, v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->userAgent:Ljava/lang/String;

    .line 461
    .local v4, "userAgent":Ljava/lang/String;
    const-string/jumbo v5, "user_agent"

    invoke-virtual {v2, v5, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 463
    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    .line 465
    if-eqz v1, :cond_0

    .line 467
    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v3, v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->url:Ljava/lang/String;

    .line 469
    .local v3, "url":Ljava/lang/String;
    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v0

    .line 472
    .local v0, "directedId":Ljava/lang/String;
    :try_start_0
    new-instance v5, Ljava/net/URL;

    invoke-direct {v5, v3}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5}, Ljava/net/URL;->getHost()Ljava/lang/String;
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v1

    .line 483
    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mTokenManagement:Lcom/amazon/identity/auth/device/api/TokenManagement;

    new-instance v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;

    invoke-direct {v6, p0, p2}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$3;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Lcom/amazon/identity/auth/device/api/Callback;)V

    invoke-virtual {v5, v0, v1, v2, v6}, Lcom/amazon/identity/auth/device/api/TokenManagement;->getCookies(Ljava/lang/String;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 514
    .end local v0    # "directedId":Ljava/lang/String;
    .end local v3    # "url":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 476
    .restart local v0    # "directedId":Ljava/lang/String;
    .restart local v3    # "url":Ljava/lang/String;
    :catch_0
    move-exception v5

    sget-object v5, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v5

    const-string/jumbo v6, "Domain is incorrect."

    invoke-static {v5, v6}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v5

    invoke-static {v5, p2}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0
.end method

.method private startAuthentication(Landroid/app/Activity;)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 753
    if-nez p1, :cond_0

    .line 755
    new-instance v1, Ljava/security/InvalidParameterException;

    const-string/jumbo v2, "Activity object must not be null"

    invoke-direct {v1, v2}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 758
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 762
    .local v0, "regOptions":Landroid/os/Bundle;
    const-string/jumbo v1, "com.amazon.identity.ap.assoc_handle"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->associationHandle:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 763
    const-string/jumbo v1, "com.amazon.identity.ap.pageid"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->pageId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 764
    const-string/jumbo v1, "com.amazon.identity.ap.clientContext"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->clientContext:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 765
    const-string/jumbo v1, "com.amazon.identity.ap.domain"

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 769
    const-string/jumbo v1, "requestType"

    sget-object v2, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->SIGN_IN:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 774
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mOptions:Landroid/os/Bundle;

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 776
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    sget-object v2, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mAuthCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-virtual {v1, p1, v2, v0, v3}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->registerAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 778
    return-void
.end method


# virtual methods
.method public checkAndCleanUpCookiesAroundRegistrationState()V
    .locals 1

    .prologue
    .line 338
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mSharedPrefCookieUtils:Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->checkIfProcessKnowsSameRegistration()Z

    move-result v0

    if-nez v0, :cond_0

    .line 340
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mSharedPrefCookieUtils:Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;

    invoke-virtual {v0}, Lcom/amazon/identity/auth/device/utils/AmazonWebviewSharedPrefCookieUtils;->cleanUpKnownCookies()V

    .line 342
    :cond_0
    return-void
.end method

.method public getAuthenticationUrlType(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 576
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    const-string/jumbo v0, "/ap/signin"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 578
    :cond_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->REGULAR:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    .line 588
    :goto_0
    return-object v0

    .line 582
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->isConfirmCredentialRequest()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 584
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "URL type set to confirm credential"

    invoke-static {v0, v1}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 585
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    goto :goto_0

    .line 588
    :cond_2
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->SIGNIN:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    goto :goto_0
.end method

.method public getHostFromUrl(Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p1, "urlToExtract"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    .line 390
    new-instance v0, Ljava/net/URL;

    invoke-direct {v0, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    .line 391
    invoke-virtual {v0}, Ljava/net/URL;->getHost()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getParams(Ljava/lang/String;Ljava/lang/String;)V
    .locals 8
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "userAgent"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/security/InvalidParameterException;,
            Ljava/net/MalformedURLException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    .line 649
    invoke-static {p1}, Ljava/net/URI;->create(Ljava/lang/String;)Ljava/net/URI;

    move-result-object v6

    invoke-static {v6, v7}, Lorg/apache/http/client/utils/URLEncodedUtils;->parse(Ljava/net/URI;Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 654
    .local v5, "params":Ljava/util/List;, "Ljava/util/List<Lorg/apache/http/NameValuePair;>;"
    new-instance v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    invoke-direct {v6, p0, v7}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$1;)V

    iput-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    .line 657
    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_a

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lorg/apache/http/NameValuePair;

    .line 659
    .local v2, "pair":Lorg/apache/http/NameValuePair;
    invoke-interface {v2}, Lorg/apache/http/NameValuePair;->getName()Ljava/lang/String;

    move-result-object v3

    .line 663
    .local v3, "paramName":Ljava/lang/String;
    invoke-interface {v2}, Lorg/apache/http/NameValuePair;->getValue()Ljava/lang/String;

    move-result-object v4

    .line 665
    .local v4, "paramValue":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 667
    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v3

    .line 671
    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    .line 673
    const-string/jumbo v6, "openid.return_to"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 676
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 678
    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v7, "No Return to url in the main url"

    invoke-static {v6, v7}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 679
    new-instance v6, Ljava/security/InvalidParameterException;

    const-string/jumbo v7, "No Return to url in the main url"

    invoke-direct {v6, v7}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v6

    .line 682
    :cond_1
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->returnToURL:Ljava/lang/String;

    goto :goto_0

    .line 684
    :cond_2
    const-string/jumbo v6, "siteState"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 686
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->siteState:Ljava/lang/String;

    goto :goto_0

    .line 690
    :cond_3
    iget-boolean v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParseUrl:Z

    if-eqz v6, :cond_4

    const-string/jumbo v6, "openid.assoc_handle"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_4

    .line 692
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->associationHandle:Ljava/lang/String;

    goto :goto_0

    .line 694
    :cond_4
    iget-boolean v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParseUrl:Z

    if-eqz v6, :cond_5

    const-string/jumbo v6, "pageId"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_5

    .line 696
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->pageId:Ljava/lang/String;

    goto :goto_0

    .line 698
    :cond_5
    iget-boolean v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParseUrl:Z

    if-eqz v6, :cond_6

    const-string/jumbo v6, "clientContext"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 700
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->clientContext:Ljava/lang/String;

    goto/16 :goto_0

    .line 704
    :cond_6
    const-string/jumbo v6, "openid.claimed_id"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_7

    .line 706
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    goto/16 :goto_0

    .line 708
    :cond_7
    const-string/jumbo v6, "openid.identity"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_8

    .line 710
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->identity:Ljava/lang/String;

    goto/16 :goto_0

    .line 714
    :cond_8
    const-string/jumbo v6, "openid.pape.max_auth_age"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_9

    .line 716
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->maxAuthAge:Ljava/lang/String;

    goto/16 :goto_0

    .line 718
    :cond_9
    const-string/jumbo v6, "authCookies"

    invoke-virtual {v3, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 720
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v4, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->authCookies:Ljava/lang/String;

    goto/16 :goto_0

    .line 729
    .end local v2    # "pair":Lorg/apache/http/NameValuePair;
    .end local v3    # "paramName":Ljava/lang/String;
    .end local v4    # "paramValue":Ljava/lang/String;
    :cond_a
    invoke-static {p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->getCookieDomainFromUrl(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 730
    .local v0, "domain":Ljava/lang/String;
    sget-object v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string/jumbo v7, "Domain used for parameters : "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    .line 732
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object v0, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    .line 736
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object p1, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->url:Ljava/lang/String;

    .line 738
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iput-object p2, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->userAgent:Ljava/lang/String;

    .line 742
    iget-object v6, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    invoke-virtual {p0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->getAuthenticationUrlType(Ljava/lang/String;)Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->toString()Ljava/lang/String;

    move-result-object v7

    iput-object v7, v6, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->requestType:Ljava/lang/String;

    .line 743
    return-void
.end method

.method public handleAuthResultError(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 241
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 243
    :try_start_0
    sget-object v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v2, "Error in handleAuthActivityResultError"

    invoke-static {v0, v2}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 244
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {p1, v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    .line 245
    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    return-void

    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public handleAuthSuccessResult(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    const/4 v0, 0x1

    .line 187
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 190
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->isWarmSeatAuthenticationRequest()Z

    move-result v2

    if-nez v2, :cond_0

    :goto_0
    if-eqz v0, :cond_1

    .line 193
    const/4 v0, 0x1

    new-instance v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$2;

    invoke-direct {v2, p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$2;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;)V

    invoke-direct {p0, v0, v2}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->getCookiesFromTokenManagement(ZLcom/amazon/identity/auth/device/api/Callback;)V

    .line 202
    :goto_1
    monitor-exit v1

    return-void

    .line 190
    :cond_0
    const/4 v0, 0x0

    goto :goto_0

    .line 198
    :cond_1
    invoke-direct {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->continueLoadingURL()V

    .line 200
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setAuthenticationOnlyEvent(Lcom/amazon/identity/auth/device/api/Callback;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    goto :goto_1

    .line 202
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0
.end method

.method public handleAuthentication(Landroid/app/Activity;Ljava/lang/String;)Z
    .locals 6
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 262
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->checkAndCleanUpCookiesAroundRegistrationState()V

    .line 264
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v2}, Lcom/amazon/android/webkit/AmazonWebView;->getSettings()Lcom/amazon/android/webkit/AmazonWebSettings;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/android/webkit/AmazonWebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v0

    .line 268
    .local v0, "userAgent":Ljava/lang/String;
    :try_start_0
    invoke-virtual {p0, p2, v0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->getParams(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/security/InvalidParameterException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_1

    .line 284
    :goto_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->requestType:Ljava/lang/String;

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->REGULAR:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$URL_TYPE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_5

    .line 286
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string/jumbo v4, "URL TYPE: "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v4, v4, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->requestType:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/utils/MAPLog;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 288
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mWebView:Lcom/amazon/android/webkit/AmazonWebView;

    invoke-virtual {v2}, Lcom/amazon/android/webkit/AmazonWebView;->stopLoading()V

    .line 289
    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    .line 292
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->requestType:Ljava/lang/String;

    sget-object v3, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->CONFIRM_CREDENTIAL:Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;

    invoke-virtual {v3}, Lcom/amazon/identity/auth/device/endpoint/OpenIdRequest$REQUEST_TYPE;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Landroid/text/TextUtils;->equals(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 294
    if-nez p1, :cond_0

    new-instance v1, Ljava/security/InvalidParameterException;

    const-string/jumbo v2, "Activity object must not be null"

    invoke-direct {v1, v2}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v1

    .line 272
    :catch_0
    move-exception v2

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    const-string/jumbo v3, "Invalid Parameter"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0

    .line 278
    :catch_1
    move-exception v2

    sget-object v2, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->BAD_REQUEST:Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager$RegistrationError;->value()I

    move-result v2

    const-string/jumbo v3, "Invalid URL"

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/token/TokenCallbackHelpers;->getErrorBundle(ILjava/lang/String;)Landroid/os/Bundle;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mClientEventCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-static {v2, v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewEventHelper;->setError(Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_0

    .line 294
    :cond_0
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->getAccount()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v4, "com.amazon.identity.ap.assoc_handle"

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v5, v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->associationHandle:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "com.amazon.identity.ap.pageid"

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v5, v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->pageId:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "com.amazon.identity.ap.clientContext"

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v5, v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->clientContext:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v4, "com.amazon.identity.ap.domain"

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v5, v5, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mOptions:Landroid/os/Bundle;

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mAuthCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-virtual {v4, p1, v2, v3, v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->confirmCredential(Landroid/app/Activity;Ljava/lang/String;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    .line 333
    :goto_1
    return v1

    .line 299
    :cond_1
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    invoke-virtual {v2}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->isDeviceRegistered()Z

    move-result v2

    if-nez v2, :cond_2

    .line 301
    invoke-direct {p0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->startAuthentication(Landroid/app/Activity;)V

    goto :goto_1

    .line 308
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->isWarmSeatAuthenticationRequest()Z

    move-result v2

    if-eqz v2, :cond_4

    .line 310
    if-nez p1, :cond_3

    new-instance v1, Ljava/security/InvalidParameterException;

    const-string/jumbo v2, "Activity object must not be null"

    invoke-direct {v1, v2}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v1

    :cond_3
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    const-string/jumbo v3, "com.amazon.identity.ap.assoc_handle"

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v4, v4, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->associationHandle:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "com.amazon.identity.ap.pageid"

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v4, v4, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->pageId:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "com.amazon.identity.ap.clientContext"

    iget-object v4, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v4, v4, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->clientContext:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    const-string/jumbo v3, "isWarmSeatAuthentication"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mOptions:Landroid/os/Bundle;

    invoke-virtual {v2, v3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    iget-object v3, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mMAPAccountManager:Lcom/amazon/identity/auth/device/api/MAPAccountManager;

    sget-object v4, Lcom/amazon/identity/auth/device/api/SigninOption;->WebviewSignin:Lcom/amazon/identity/auth/device/api/SigninOption;

    iget-object v5, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mAuthCallback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-virtual {v3, p1, v4, v2, v5}, Lcom/amazon/identity/auth/device/api/MAPAccountManager;->authenticateAccountWithUI(Landroid/app/Activity;Lcom/amazon/identity/auth/device/api/SigninOption;Landroid/os/Bundle;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/MAPFuture;

    goto :goto_1

    .line 320
    :cond_4
    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mNeedForceRefreshCookies:Ljava/util/concurrent/atomic/AtomicBoolean;

    invoke-virtual {v2, v1}, Ljava/util/concurrent/atomic/AtomicBoolean;->getAndSet(Z)Z

    move-result v2

    sget-object v3, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;

    invoke-direct {v3, p0, p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$4;-><init>(Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;Landroid/app/Activity;)V

    invoke-direct {p0, v2, v3}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->getCookiesFromTokenManagement(ZLcom/amazon/identity/auth/device/api/Callback;)V

    goto :goto_1

    .line 333
    :cond_5
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public handleOnCreate(Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "mapWebviewActivityInterface"    # Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;
    .param p2, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 165
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mLock:[Ljava/lang/Object;

    monitor-enter v1

    .line 167
    if-eqz p1, :cond_0

    :try_start_0
    invoke-interface {p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    if-nez v0, :cond_1

    .line 169
    :cond_0
    new-instance v0, Ljava/security/InvalidParameterException;

    const-string/jumbo v2, "Activity must not be null"

    invoke-direct {v0, v2}, Ljava/security/InvalidParameterException;-><init>(Ljava/lang/String;)V

    throw v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 182
    :catchall_0
    move-exception v0

    monitor-exit v1

    throw v0

    .line 173
    :cond_1
    :try_start_1
    invoke-interface {p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->makeSureAmazonCookieSyncManagerIsInitialized(Landroid/content/Context;)V

    .line 174
    invoke-interface {p1}, Lcom/amazon/identity/auth/device/api/MAPWebViewActivityInterface;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/identity/auth/device/api/AmazonWebViewUtils;->getAmazonCookieManager(Landroid/content/Context;)Lcom/amazon/android/webkit/AmazonCookieManager;

    move-result-object v0

    .line 176
    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Lcom/amazon/android/webkit/AmazonCookieManager;->setAcceptCookie(Z)V

    .line 178
    invoke-virtual {p0, p2}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->setUpLocalState(Landroid/os/Bundle;)V

    .line 181
    invoke-virtual {p0}, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->checkAndCleanUpCookiesAroundRegistrationState()V

    .line 182
    monitor-exit v1
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    return-void
.end method

.method public isConfirmCredentialRequest()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 598
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->identity:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    iget-object v2, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v2, v2, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->identity:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 610
    :cond_0
    :goto_0
    return v0

    .line 604
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    const-string/jumbo v2, "http://www.amazon.com/ap/specs/auth/confirm_credentials"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    const-string/jumbo v2, "/ap/id/"

    invoke-virtual {v1, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 607
    :cond_2
    const/4 v0, 0x1

    goto :goto_0
.end method

.method isWarmSeatAuthenticationRequest()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 621
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->maxAuthAge:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->authCookies:Ljava/lang/String;

    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 631
    :cond_0
    :goto_0
    return v0

    .line 626
    :cond_1
    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->maxAuthAge:Ljava/lang/String;

    const-string/jumbo v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->authCookies:Ljava/lang/String;

    const-string/jumbo v2, "0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 628
    const/4 v0, 0x1

    goto :goto_0
.end method

.method public saveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 839
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->returnToURL:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 841
    const-string/jumbo v0, "return_to_url"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->returnToURL:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 844
    :cond_0
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->siteState:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 846
    const-string/jumbo v0, "site_state"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->siteState:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 849
    :cond_1
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->associationHandle:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_2

    .line 851
    const-string/jumbo v0, "association_handle"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->associationHandle:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 854
    :cond_2
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->pageId:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 856
    const-string/jumbo v0, "page_id"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->pageId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 859
    :cond_3
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->clientContext:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_4

    .line 861
    const-string/jumbo v0, "client_context"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->clientContext:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 864
    :cond_4
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->userAgent:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_5

    .line 866
    const-string/jumbo v0, "user_agent"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->userAgent:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 869
    :cond_5
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->requestType:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 871
    const-string/jumbo v0, "request_type"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->requestType:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 874
    :cond_6
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_7

    .line 876
    const-string/jumbo v0, "domain"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 879
    :cond_7
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->url:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 881
    const-string/jumbo v0, "url"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->url:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 884
    :cond_8
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_9

    .line 886
    const-string/jumbo v0, "claimed_id"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 889
    :cond_9
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->identity:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_a

    .line 891
    const-string/jumbo v0, "identity"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->identity:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 894
    :cond_a
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->maxAuthAge:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_b

    .line 896
    const-string/jumbo v0, "max_auth_age"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->maxAuthAge:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 899
    :cond_b
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v0, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->authCookies:Ljava/lang/String;

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_c

    .line 901
    const-string/jumbo v0, "authCookies"

    iget-object v1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    iget-object v1, v1, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->authCookies:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 903
    :cond_c
    return-void
.end method

.method public setParseUrl(Z)V
    .locals 0
    .param p1, "parseUrl"    # Z

    .prologue
    .line 144
    iput-boolean p1, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParseUrl:Z

    .line 145
    return-void
.end method

.method public setUpLocalState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "inState"    # Landroid/os/Bundle;

    .prologue
    .line 910
    if-nez p1, :cond_1

    .line 981
    :cond_0
    :goto_0
    return-void

    .line 915
    :cond_1
    const-string/jumbo v0, "return_to_url"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 917
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "return_to_url"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->returnToURL:Ljava/lang/String;

    .line 920
    :cond_2
    const-string/jumbo v0, "site_state"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 922
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "site_state"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->siteState:Ljava/lang/String;

    .line 925
    :cond_3
    const-string/jumbo v0, "association_handle"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 927
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "association_handle"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->associationHandle:Ljava/lang/String;

    .line 930
    :cond_4
    const-string/jumbo v0, "page_id"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 932
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "page_id"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->pageId:Ljava/lang/String;

    .line 935
    :cond_5
    const-string/jumbo v0, "client_context"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 937
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "client_context"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->clientContext:Ljava/lang/String;

    .line 940
    :cond_6
    const-string/jumbo v0, "user_agent"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 942
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "user_agent"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->userAgent:Ljava/lang/String;

    .line 945
    :cond_7
    const-string/jumbo v0, "request_type"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 947
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "request_type"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->requestType:Ljava/lang/String;

    .line 950
    :cond_8
    const-string/jumbo v0, "domain"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 952
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "domain"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->domain:Ljava/lang/String;

    .line 955
    :cond_9
    const-string/jumbo v0, "url"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 957
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "url"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->url:Ljava/lang/String;

    .line 960
    :cond_a
    const-string/jumbo v0, "claimed_id"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 962
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "claimed_id"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->claimedId:Ljava/lang/String;

    .line 965
    :cond_b
    const-string/jumbo v0, "identity"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 967
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "identity"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->identity:Ljava/lang/String;

    .line 971
    :cond_c
    const-string/jumbo v0, "max_auth_age"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 973
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "max_auth_age"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->maxAuthAge:Ljava/lang/String;

    .line 976
    :cond_d
    const-string/jumbo v0, "authCookies"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 978
    iget-object v0, p0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper;->mParams:Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;

    const-string/jumbo v1, "authCookies"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, v0, Lcom/amazon/identity/auth/device/api/MAPWebViewHelper$Parameters;->authCookies:Ljava/lang/String;

    goto/16 :goto_0
.end method
