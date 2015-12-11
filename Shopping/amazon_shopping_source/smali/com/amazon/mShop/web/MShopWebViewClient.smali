.class public Lcom/amazon/mShop/web/MShopWebViewClient;
.super Lcom/amazon/mobile/mash/MASHWebViewClient;
.source "MShopWebViewClient.java"


# static fields
.field private static final AUTH_PORTAL_SERVER:Ljava/util/regex/Pattern;

.field protected static final DEBUG:Z


# instance fields
.field private mIsAlreadyPageLoadHandled:Z

.field private mNeedHandleSignIn:Z

.field private mPendingUrl:Ljava/lang/String;

.field private mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

.field private mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 66
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    .line 69
    const-string/jumbo v0, "^https?://.*\\.amazon\\.[\\w\\.]+/ap/signin"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    sput-object v0, Lcom/amazon/mShop/web/MShopWebViewClient;->AUTH_PORTAL_SERVER:Ljava/util/regex/Pattern;

    return-void
.end method

.method public constructor <init>(Lorg/apache/cordova/CordovaInterface;)V
    .locals 2
    .param p1, "cordova"    # Lorg/apache/cordova/CordovaInterface;

    .prologue
    .line 79
    new-instance v0, Lcom/amazon/mShop/mash/nav/AmazonNavManager;

    invoke-direct {v0}, Lcom/amazon/mShop/mash/nav/AmazonNavManager;-><init>()V

    new-instance v1, Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter;

    invoke-direct {v1}, Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter;-><init>()V

    invoke-direct {p0, p1, v0, v1}, Lcom/amazon/mobile/mash/MASHWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;)V

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mPendingUrl:Ljava/lang/String;

    .line 76
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mIsAlreadyPageLoadHandled:Z

    .line 99
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mNeedHandleSignIn:Z

    .line 80
    return-void
.end method

.method public constructor <init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mShop/mash/nav/AmazonNavManager;)V
    .locals 1
    .param p1, "cordova"    # Lorg/apache/cordova/CordovaInterface;
    .param p2, "manager"    # Lcom/amazon/mShop/mash/nav/AmazonNavManager;

    .prologue
    .line 83
    new-instance v0, Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter;

    invoke-direct {v0}, Lcom/amazon/mShop/mash/interception/MShopUrlIntercepter;-><init>()V

    invoke-direct {p0, p1, p2, v0}, Lcom/amazon/mobile/mash/MASHWebViewClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;)V

    .line 72
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mPendingUrl:Ljava/lang/String;

    .line 76
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mIsAlreadyPageLoadHandled:Z

    .line 99
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mNeedHandleSignIn:Z

    .line 84
    return-void
.end method

.method private handleURLProtocolUnsupportedScheme(Landroid/content/Context;Ljava/lang/String;)Z
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 529
    if-eqz p2, :cond_0

    .line 532
    :try_start_0
    new-instance v3, Ljava/net/URL;

    invoke-direct {v3, p2}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 556
    :cond_0
    const/4 v3, 0x0

    :goto_0
    return v3

    .line 533
    :catch_0
    move-exception v1

    .line 534
    .local v1, "e":Ljava/net/MalformedURLException;
    sget-boolean v3, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v3, :cond_1

    .line 535
    const-string/jumbo v3, "MShopWebViewClient"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "handleURLProtocolUnsupportedScheme: url = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 542
    :cond_1
    new-instance v2, Landroid/content/Intent;

    const-string/jumbo v3, "android.intent.action.VIEW"

    invoke-direct {v2, v3}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 543
    .local v2, "intent":Landroid/content/Intent;
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->setData(Landroid/net/Uri;)Landroid/content/Intent;

    .line 546
    :try_start_1
    invoke-virtual {p1, v2}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_1
    .catch Landroid/content/ActivityNotFoundException; {:try_start_1 .. :try_end_1} :catch_1

    .line 552
    :goto_1
    const/4 v3, 0x1

    goto :goto_0

    .line 547
    :catch_1
    move-exception v0

    .line 550
    .local v0, "actNotFoundException":Landroid/content/ActivityNotFoundException;
    const-string/jumbo v3, "MShopWebViewClient"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "handleURLProtocolUnsupportedScheme "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v0}, Landroid/content/ActivityNotFoundException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_1
.end method

.method private logViewHistoryInUDP(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 8
    .param p1, "webView"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 474
    iget-object v5, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v5}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getTransitionManager()Lcom/amazon/mShop/web/MShopWebViewTransitionManager;

    move-result-object v4

    .line 477
    .local v4, "transitionManager":Lcom/amazon/mShop/web/MShopWebViewTransitionManager;
    if-eqz v4, :cond_1

    invoke-interface {v4}, Lcom/amazon/mShop/web/MShopWebViewTransitionManager;->isBackTransitionPending()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 505
    :cond_0
    :goto_0
    return-void

    .line 483
    :cond_1
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-virtual {v5}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 484
    .local v2, "path":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    const-string/jumbo v5, "/gp/aw/d/"

    invoke-virtual {v2, v5}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 485
    const/4 v0, 0x0

    .line 486
    .local v0, "asin":Ljava/lang/String;
    const-string/jumbo v5, "/gp/aw/d/"

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v3

    .line 487
    .local v3, "start":I
    const-string/jumbo v5, "/"

    invoke-virtual {v2, v5, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;I)I

    move-result v1

    .line 488
    .local v1, "end":I
    const/4 v5, -0x1

    if-eq v1, v5, :cond_3

    .line 490
    invoke-virtual {v2, v3, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 497
    :goto_1
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 498
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-static {v5, v0}, Lcom/amazon/mShop/util/ActivityUtils;->logViewHistory(Landroid/content/Context;Ljava/lang/String;)V

    .line 501
    :cond_2
    sget-boolean v5, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v5, :cond_0

    .line 502
    const-string/jumbo v5, "MShopWebViewClient"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "logViewHistory In UDP, asin = "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 494
    :cond_3
    invoke-virtual {v2, v3}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method


# virtual methods
.method public doUpdateVisitedHistory(Landroid/webkit/WebView;Ljava/lang/String;Z)V
    .locals 2
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "isReload"    # Z

    .prologue
    .line 587
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/MASHWebViewClient;->doUpdateVisitedHistory(Landroid/webkit/WebView;Ljava/lang/String;Z)V

    .line 588
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->doUpdateVisitedHistory(Z)V

    .line 589
    return-void
.end method

.method public handleAuthentication(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 4
    .param p1, "webView"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 426
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->isAuthenticationRedirect(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    instance-of v2, v2, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v2, :cond_0

    .line 427
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 428
    .local v0, "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v2

    const-string/jumbo v3, "openid.return_to"

    invoke-virtual {v2, v3}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 430
    .local v1, "urlAfterSuccessfulLogin":Ljava/lang/String;
    new-instance v2, Lcom/amazon/mShop/web/MShopWebViewClient$1;

    invoke-direct {v2, p0, v0, v1, p1}, Lcom/amazon/mShop/web/MShopWebViewClient$1;-><init>(Lcom/amazon/mShop/web/MShopWebViewClient;Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Landroid/webkit/WebView;)V

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Lcom/amazon/mShop/AmazonActivity;->authenticateUser(Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;Lcom/amazon/mShop/model/auth/UserSubscriber$Callback;)V

    .line 450
    const/4 v2, 0x1

    .line 452
    .end local v0    # "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    .end local v1    # "urlAfterSuccessfulLogin":Ljava/lang/String;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method protected handlePageLoadNatively(Lcom/amazon/mobile/mash/MASHWebView;Ljava/lang/String;)Z
    .locals 2
    .param p1, "view"    # Lcom/amazon/mobile/mash/MASHWebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 284
    invoke-super {p0, p1, p2}, Lcom/amazon/mobile/mash/MASHWebViewClient;->handlePageLoadNatively(Lcom/amazon/mobile/mash/MASHWebView;Ljava/lang/String;)Z

    move-result v0

    .line 285
    .local v0, "isPageLoadHandledNatively":Z
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mIsAlreadyPageLoadHandled:Z

    .line 293
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setIsPageLoadHandledNatively(Z)V

    .line 294
    return v0
.end method

.method protected isAuthenticationRedirect(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 4
    .param p1, "webView"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 399
    sget-boolean v2, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v2, :cond_1

    .line 400
    sget-object v1, Lcom/amazon/mShop/web/MShopWebViewClient;->AUTH_PORTAL_SERVER:Ljava/util/regex/Pattern;

    invoke-virtual {v1, p2}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/regex/Matcher;->find()Z

    move-result v1

    .line 403
    :cond_0
    :goto_0
    return v1

    .line 402
    :cond_1
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->authportal:I

    invoke-virtual {v2, v3}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 403
    .local v0, "authPortalUrl":Ljava/lang/String;
    invoke-virtual {p2}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v3

    if-le v2, v3, :cond_0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v2

    invoke-virtual {p2, v1, v2}, Ljava/lang/String;->subSequence(II)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    const/4 v1, 0x1

    goto :goto_0
.end method

.method public onFormResubmission(Landroid/webkit/WebView;Landroid/os/Message;Landroid/os/Message;)V
    .locals 0
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "dontResend"    # Landroid/os/Message;
    .param p3, "resend"    # Landroid/os/Message;

    .prologue
    .line 582
    invoke-virtual {p3}, Landroid/os/Message;->sendToTarget()V

    .line 583
    return-void
.end method

.method public onLoadResource(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 458
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 459
    const-string/jumbo v0, "MShopWebViewClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onLoadResource: url = "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->v(Ljava/lang/String;Ljava/lang/String;)I

    .line 461
    :cond_0
    return-void
.end method

.method public onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V
    .locals 6
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 299
    sget-boolean v3, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v3, :cond_0

    .line 300
    const-string/jumbo v3, "MShopWebViewClient"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "onPageFinished: url = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 302
    :cond_0
    invoke-super {p0, p1, p2}, Lcom/amazon/mobile/mash/MASHWebViewClient;->onPageFinished(Landroid/webkit/WebView;Ljava/lang/String;)V

    .line 304
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    if-eqz v3, :cond_1

    .line 310
    :try_start_0
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 316
    :cond_1
    :goto_0
    const/4 v3, 0x0

    iput-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mPendingUrl:Ljava/lang/String;

    .line 317
    const/4 v3, 0x1

    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mNeedHandleSignIn:Z

    move-object v0, p1

    .line 318
    check-cast v0, Lcom/amazon/mShop/web/MShopWebView;

    .line 319
    .local v0, "amazonWebView":Lcom/amazon/mShop/web/MShopWebView;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebView;->getJsNeedToCall(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 320
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/web/MShopWebView;->getJsNeedToCall(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 321
    .local v2, "js":Ljava/lang/String;
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/web/MShopWebView;->loadUrl(Ljava/lang/String;)V

    .line 322
    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->clearAllPendingJs()V

    .line 324
    sget-boolean v3, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v3, :cond_2

    .line 325
    const-string/jumbo v3, "MShopWebViewClient"

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "onPageFinished: call js = "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 329
    .end local v2    # "js":Ljava/lang/String;
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v3, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->onPageFinished(Ljava/lang/String;)V

    .line 330
    const/4 v3, 0x0

    iput-boolean v3, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mIsAlreadyPageLoadHandled:Z

    .line 332
    return-void

    .line 311
    .end local v0    # "amazonWebView":Lcom/amazon/mShop/web/MShopWebView;
    :catch_0
    move-exception v1

    .line 312
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "MShopWebViewClient"

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method

.method public onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V
    .locals 11
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "favicon"    # Landroid/graphics/Bitmap;

    .prologue
    const/4 v9, 0x1

    const/4 v10, 0x0

    .line 190
    sget-boolean v6, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v6, :cond_0

    .line 191
    const-string/jumbo v6, "MShopWebViewClient"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "onPageStarted: url = "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 193
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/MASHWebViewClient;->onPageStarted(Landroid/webkit/WebView;Ljava/lang/String;Landroid/graphics/Bitmap;)V

    .line 195
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v2

    .line 196
    .local v2, "cookieManager":Landroid/webkit/CookieManager;
    invoke-virtual {v2, v9}, Landroid/webkit/CookieManager;->setAcceptCookie(Z)V

    .line 198
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    .line 204
    .local v5, "uri":Landroid/net/Uri;
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mPendingUrl:Ljava/lang/String;

    if-nez v6, :cond_2

    .line 205
    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mPendingUrl:Ljava/lang/String;

    :cond_1
    move-object v0, p1

    .line 221
    check-cast v0, Lcom/amazon/mShop/web/MShopWebView;

    .line 222
    .local v0, "amazonWebView":Lcom/amazon/mShop/web/MShopWebView;
    const/4 v4, 0x0

    .line 225
    .local v4, "isPageLoadHandledNatively":Z
    iget-boolean v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mIsAlreadyPageLoadHandled:Z

    if-nez v6, :cond_4

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebView;->isInitialPageLoad()Z

    move-result v6

    if-nez v6, :cond_4

    move-object v6, p1

    .line 227
    check-cast v6, Lcom/amazon/mShop/web/MShopWebView;

    invoke-virtual {p0, v6, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->handlePageLoadNatively(Lcom/amazon/mobile/mash/MASHWebView;Ljava/lang/String;)Z

    move-result v4

    .line 232
    :goto_0
    if-eqz v4, :cond_5

    .line 233
    invoke-virtual {p1}, Landroid/webkit/WebView;->stopLoading()V

    .line 280
    .end local v0    # "amazonWebView":Lcom/amazon/mShop/web/MShopWebView;
    .end local v4    # "isPageLoadHandledNatively":Z
    :goto_1
    return-void

    .line 207
    :cond_2
    iget-boolean v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mNeedHandleSignIn:Z

    if-eqz v6, :cond_1

    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->handleAuthentication(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 208
    iput-boolean v10, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mNeedHandleSignIn:Z

    .line 209
    invoke-virtual {p1}, Landroid/webkit/WebView;->stopLoading()V

    .line 210
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    if-eqz v6, :cond_3

    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonProgressDialog;->isShowing()Z

    move-result v6

    if-eqz v6, :cond_3

    .line 211
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V

    .line 213
    :cond_3
    const/4 v6, 0x0

    iput-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mPendingUrl:Ljava/lang/String;

    goto :goto_1

    .line 229
    .restart local v0    # "amazonWebView":Lcom/amazon/mShop/web/MShopWebView;
    .restart local v4    # "isPageLoadHandledNatively":Z
    :cond_4
    invoke-virtual {v0, v10}, Lcom/amazon/mShop/web/MShopWebView;->setInitialPageLoad(Z)V

    goto :goto_0

    .line 241
    :cond_5
    invoke-static {p1, p2}, Lcom/amazon/mShop/web/security/WebViewSecurity;->shouldBlockWebViewLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v1

    .line 242
    .local v1, "blocked":Z
    invoke-static {p2}, Lcom/amazon/mShop/web/security/WebViewSecurity;->isHTTPUrl(Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_6

    .line 245
    invoke-virtual {p1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6, p2, v1}, Lcom/amazon/mShop/web/security/WebViewSecurity;->logMetricsForHTTPRequest(Ljava/lang/String;Ljava/lang/String;Z)V

    .line 247
    :cond_6
    if-eqz v1, :cond_7

    .line 248
    invoke-virtual {p1}, Landroid/webkit/WebView;->stopLoading()V

    .line 249
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v7, 0x5

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSslError(I)V

    goto :goto_1

    .line 256
    :cond_7
    if-eqz v5, :cond_9

    invoke-virtual {v5}, Landroid/net/Uri;->isHierarchical()Z

    move-result v6

    if-eqz v6, :cond_9

    .line 257
    const-string/jumbo v6, "app-loading-dialog-title"

    invoke-virtual {v5, v6}, Landroid/net/Uri;->getQueryParameter(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 258
    .local v3, "dialogTitle":Ljava/lang/String;
    invoke-static {v3}, Landroid/net/Uri;->decode(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 259
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_9

    .line 260
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    if-nez v6, :cond_8

    .line 261
    new-instance v6, Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-direct {v6, v7}, Lcom/amazon/mShop/AmazonProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 263
    :cond_8
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->sns_loading_dialog_title:I

    new-array v9, v9, [Ljava/lang/Object;

    aput-object v3, v9, v10

    invoke-virtual {v7, v8, v9}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Lcom/amazon/mShop/AmazonProgressDialog;->setTitle(Ljava/lang/CharSequence;)V

    .line 264
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mProgressDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v6}, Lcom/amazon/mShop/AmazonProgressDialog;->show()V

    .line 274
    .end local v3    # "dialogTitle":Ljava/lang/String;
    :cond_9
    iget-object v6, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v6, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->onPageStarted(Ljava/lang/String;)V

    .line 279
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->logViewHistoryInUDP(Landroid/webkit/WebView;Ljava/lang/String;)V

    goto/16 :goto_1
.end method

.method public onReceivedError(Landroid/webkit/WebView;ILjava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "errorCode"    # I
    .param p3, "description"    # Ljava/lang/String;
    .param p4, "failingUrl"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 337
    move-object v0, p1

    check-cast v0, Lcom/amazon/mShop/web/MShopWebView;

    .line 340
    .local v0, "amazonWebView":Lcom/amazon/mShop/web/MShopWebView;
    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebView;->setInitialPageLoad(Z)V

    .line 341
    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebView;->setReceivedError(Z)V

    .line 348
    invoke-virtual {p1}, Landroid/webkit/WebView;->clearView()V

    .line 349
    const/16 v1, 0x8

    invoke-virtual {p1, v1}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 351
    iget-object v1, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showError()V

    .line 353
    invoke-static {p2, p3, p4}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postWebViewError(ILjava/lang/String;Ljava/lang/String;)V

    .line 355
    sget-boolean v1, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v1, :cond_0

    .line 356
    const-string/jumbo v1, "MShopWebViewClient"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "onReceivedError: errorCode = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, ", description = "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 359
    :cond_0
    return-void
.end method

.method public onReceivedHttpAuthRequest(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/HttpAuthHandler;
    .param p3, "host"    # Ljava/lang/String;
    .param p4, "realm"    # Ljava/lang/String;

    .prologue
    .line 561
    sget-boolean v2, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v2, :cond_1

    .line 565
    invoke-virtual {p1, p3, p4}, Landroid/webkit/WebView;->getHttpAuthUsernamePassword(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v1

    .line 566
    .local v1, "credentials":[Ljava/lang/String;
    invoke-virtual {p2}, Landroid/webkit/HttpAuthHandler;->useHttpAuthUsernamePassword()Z

    move-result v2

    if-eqz v2, :cond_0

    if-eqz v1, :cond_0

    array-length v2, v1

    const/4 v3, 0x2

    if-ne v2, v3, :cond_0

    .line 567
    const/4 v2, 0x0

    aget-object v2, v1, v2

    const/4 v3, 0x1

    aget-object v3, v1, v3

    invoke-virtual {p2, v2, v3}, Landroid/webkit/HttpAuthHandler;->proceed(Ljava/lang/String;Ljava/lang/String;)V

    .line 576
    .end local v1    # "credentials":[Ljava/lang/String;
    :goto_0
    return-void

    .line 569
    .restart local v1    # "credentials":[Ljava/lang/String;
    :cond_0
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Landroid/app/Activity;

    .line 571
    .local v0, "activity":Landroid/app/Activity;
    invoke-static {v0, p1, p2, p3, p4}, Lcom/amazon/mShop/util/DebugUtil;->handleOnReceivedHTTPAuthenticationRequest(Landroid/app/Activity;Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 574
    .end local v0    # "activity":Landroid/app/Activity;
    .end local v1    # "credentials":[Ljava/lang/String;
    :cond_1
    invoke-super {p0, p1, p2, p3, p4}, Lcom/amazon/mobile/mash/MASHWebViewClient;->onReceivedHttpAuthRequest(Landroid/webkit/WebView;Landroid/webkit/HttpAuthHandler;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onReceivedSslError(Landroid/webkit/WebView;Landroid/webkit/SslErrorHandler;Landroid/net/http/SslError;)V
    .locals 3
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "handler"    # Landroid/webkit/SslErrorHandler;
    .param p3, "error"    # Landroid/net/http/SslError;

    .prologue
    .line 363
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 364
    const-string/jumbo v0, "MShopWebViewClient"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v2, "onReceivedSslError: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 367
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->proceed()V

    .line 386
    :goto_0
    return-void

    :cond_0
    move-object v0, p1

    .line 372
    check-cast v0, Lcom/amazon/mShop/web/MShopWebView;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebView;->setReceivedError(Z)V

    .line 374
    invoke-virtual {p2}, Landroid/webkit/SslErrorHandler;->cancel()V

    .line 375
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSslError(I)V

    .line 378
    if-eqz p3, :cond_1

    .line 379
    invoke-virtual {p3}, Landroid/net/http/SslError;->getPrimaryError()I

    move-result v0

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p3}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string/jumbo v2, "  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p3}, Landroid/net/http/SslError;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/util/AmazonErrorUtils;->postWebViewError(ILjava/lang/String;Ljava/lang/String;)V

    .line 383
    :cond_1
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 385
    const-string/jumbo v0, "ssl_error_html"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method

.method setWebViewContainer(Lcom/amazon/mShop/web/MShopWebViewContainer;)V
    .locals 0
    .param p1, "webViewContainer"    # Lcom/amazon/mShop/web/MShopWebViewContainer;

    .prologue
    .line 105
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    .line 106
    return-void
.end method

.method public shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z
    .locals 7
    .param p1, "view"    # Landroid/webkit/WebView;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 111
    sget-boolean v2, Lcom/amazon/mShop/web/MShopWebViewClient;->DEBUG:Z

    if-eqz v2, :cond_0

    .line 112
    const-string/jumbo v2, "MShopWebViewClient"

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "shouldOverrideUrl: url = "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v2, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 116
    :cond_0
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    instance-of v2, v2, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v2, :cond_1

    .line 117
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebActivity;->calcWebviewStartTime()V

    .line 120
    :cond_1
    invoke-static {p2}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 124
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {v1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 125
    .local v0, "path":Ljava/lang/String;
    if-eqz v0, :cond_2

    const-string/jumbo v2, "404.html"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 126
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->alert_error_service_please_try_again:I

    invoke-static {v2, v4}, Lcom/amazon/mShop/util/UIUtils;->alert(Landroid/content/Context;I)V

    move v2, v3

    .line 185
    :goto_0
    return v2

    .line 132
    :cond_2
    iget-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mNeedHandleSignIn:Z

    if-eqz v2, :cond_3

    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->handleAuthentication(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 133
    iput-boolean v4, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mNeedHandleSignIn:Z

    move v2, v3

    .line 134
    goto :goto_0

    .line 140
    :cond_3
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2, p2}, Lcom/amazon/mShop/util/WebUtils;->handleMailtoLink(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    move v2, v3

    .line 141
    goto :goto_0

    .line 147
    :cond_4
    invoke-super {p0, p1, p2}, Lcom/amazon/mobile/mash/MASHWebViewClient;->shouldOverrideUrlLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_5

    move v2, v3

    .line 148
    goto :goto_0

    .line 154
    :cond_5
    invoke-virtual {p1}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-direct {p0, v2, p2}, Lcom/amazon/mShop/web/MShopWebViewClient;->handleURLProtocolUnsupportedScheme(Landroid/content/Context;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_6

    move v2, v3

    .line 155
    goto :goto_0

    .line 161
    :cond_6
    invoke-static {p1, p2}, Lcom/amazon/mShop/web/security/WebViewSecurity;->shouldBlockWebViewLoading(Landroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_7

    .line 162
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v4, 0x5

    invoke-virtual {v2, v4}, Lcom/amazon/mShop/web/MShopWebViewContainer;->showSslError(I)V

    .line 166
    invoke-virtual {p1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-static {v2, p2, v3}, Lcom/amazon/mShop/web/security/WebViewSecurity;->logMetricsForHTTPRequest(Ljava/lang/String;Ljava/lang/String;Z)V

    move v2, v3

    .line 167
    goto :goto_0

    .line 184
    :cond_7
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebViewClient;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v2, p2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigateForward(Ljava/lang/String;)V

    move v2, v4

    .line 185
    goto :goto_0
.end method
