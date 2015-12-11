.class public Lcom/amazon/mShop/web/MShopWebView;
.super Lcom/amazon/mobile/mash/MASHWebView;
.source "MShopWebView.java"


# static fields
.field protected static final DEBUG:Z


# instance fields
.field private mIsInitialPageLoad:Z

.field private mIsReceivedError:Z

.field private mIsWebViewDestroyed:Z

.field private mMappingWebViewAndJS:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private mParamtersToJS:Ljava/lang/String;

.field private mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

.field private prevContentHeight:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 52
    invoke-static {}, Lcom/amazon/mShop/debug/DebugSettings;->isDebugEnabled()Z

    move-result v0

    sput-boolean v0, Lcom/amazon/mShop/web/MShopWebView;->DEBUG:Z

    return-void
.end method

.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 90
    new-instance v0, Lcom/amazon/mShop/mash/context/MShopAppContext;

    new-instance v1, Lcom/amazon/mShop/mash/context/MShopCapabilityManager;

    invoke-direct {v1, p1}, Lcom/amazon/mShop/mash/context/MShopCapabilityManager;-><init>(Landroid/content/Context;)V

    invoke-direct {v0, v1}, Lcom/amazon/mShop/mash/context/MShopAppContext;-><init>(Lcom/amazon/mobile/mash/appcontext/CapabilityManager;)V

    invoke-direct {p0, v0, p1}, Lcom/amazon/mobile/mash/MASHWebView;-><init>(Lcom/amazon/mobile/mash/appcontext/AppContext;Landroid/content/Context;)V

    .line 75
    const/4 v0, -0x1

    iput v0, p0, Lcom/amazon/mShop/web/MShopWebView;->prevContentHeight:I

    .line 370
    const-string/jumbo v0, ""

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mParamtersToJS:Ljava/lang/String;

    .line 91
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebView;->initialize()V

    .line 92
    return-void
.end method

.method private callNavigate(Ljava/lang/String;ZZ)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "isForward"    # Z
    .param p3, "isReload"    # Z

    .prologue
    .line 353
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    if-nez v0, :cond_0

    .line 359
    :goto_0
    return-void

    .line 358
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigate(Ljava/lang/String;ZZ)V

    goto :goto_0
.end method

.method private callNavigateBackward(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "currentUrl"    # Ljava/lang/String;
    .param p2, "destinationUrl"    # Ljava/lang/String;

    .prologue
    .line 339
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    if-nez v0, :cond_0

    .line 350
    :goto_0
    return-void

    .line 344
    :cond_0
    invoke-static {p1, p2}, Lcom/amazon/mShop/util/WebUtils;->isBaseUrlEqual(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 346
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigateBackward(Ljava/lang/String;)V

    goto :goto_0

    .line 348
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigateBackward(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private callNavigateForward(Ljava/lang/String;)V
    .locals 1
    .param p1, "destinationUrl"    # Ljava/lang/String;

    .prologue
    .line 362
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    if-nez v0, :cond_0

    .line 368
    :goto_0
    return-void

    .line 367
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->navigateForward(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private static getDatabasePath()Ljava/lang/String;
    .locals 4

    .prologue
    .line 180
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    .line 181
    .local v0, "appContext":Landroid/content/Context;
    if-eqz v0, :cond_0

    .line 182
    const-string/jumbo v2, "database"

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/content/Context;->getDir(Ljava/lang/String;I)Ljava/io/File;

    move-result-object v1

    .line 183
    .local v1, "file":Ljava/io/File;
    if-eqz v1, :cond_0

    .line 184
    invoke-virtual {v1}, Ljava/io/File;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 188
    .end local v1    # "file":Ljava/io/File;
    :goto_0
    return-object v2

    .line 187
    :cond_0
    const-string/jumbo v2, "MShopWebView"

    const-string/jumbo v3, "Cannot get database path."

    invoke-static {v2, v3}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 188
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private initialize()V
    .locals 1

    .prologue
    .line 102
    const/16 v0, 0x82

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebView;->requestFocus(I)Z

    .line 103
    new-instance v0, Lcom/amazon/mShop/web/MShopWebView$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/web/MShopWebView$1;-><init>(Lcom/amazon/mShop/web/MShopWebView;)V

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 117
    invoke-static {p0}, Lcom/amazon/mShop/web/MShopWebView;->initializeGlobalWebSettings(Landroid/webkit/WebView;)V

    .line 118
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/web/MShopWebView;->initializeWebViewCookies(Landroid/content/Context;)V

    .line 119
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mMappingWebViewAndJS:Ljava/util/Map;

    .line 120
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/web/MShopWebView;->setVerticalScrollBarEnabled(Z)V

    .line 121
    return-void
.end method

.method public static initializeGlobalWebSettings(Landroid/webkit/WebView;)V
    .locals 7
    .param p0, "webView"    # Landroid/webkit/WebView;
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 125
    invoke-virtual {p0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v3

    .line 126
    .local v3, "webSettings":Landroid/webkit/WebSettings;
    invoke-virtual {v3, v6}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 128
    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v2

    .line 129
    .local v2, "platform":Lcom/amazon/mShop/platform/AndroidPlatform;
    invoke-virtual {v2}, Lcom/amazon/mShop/platform/AndroidPlatform;->getUserAgent()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 133
    invoke-virtual {v3, v5}, Landroid/webkit/WebSettings;->setSavePassword(Z)V

    .line 137
    invoke-virtual {v3, v5}, Landroid/webkit/WebSettings;->setSaveFormData(Z)V

    .line 140
    invoke-static {}, Lcom/amazon/mShop/web/MShopWebView;->getDatabasePath()Ljava/lang/String;

    move-result-object v0

    .line 142
    .local v0, "databasePath":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 143
    invoke-virtual {v3, v6}, Landroid/webkit/WebSettings;->setDatabaseEnabled(Z)V

    .line 144
    invoke-virtual {v3, v0}, Landroid/webkit/WebSettings;->setDatabasePath(Ljava/lang/String;)V

    .line 146
    invoke-virtual {v3, v6}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 149
    :cond_0
    invoke-virtual {v3, v5}, Landroid/webkit/WebSettings;->setCacheMode(I)V

    .line 154
    invoke-virtual {p0}, Landroid/webkit/WebView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getCacheDir()Ljava/io/File;

    move-result-object v1

    .line 155
    .local v1, "file":Ljava/io/File;
    if-eqz v1, :cond_1

    .line 157
    invoke-virtual {v1}, Ljava/io/File;->getAbsolutePath()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/webkit/WebSettings;->setAppCachePath(Ljava/lang/String;)V

    .line 160
    :cond_1
    invoke-virtual {v3, v6}, Landroid/webkit/WebSettings;->setAppCacheEnabled(Z)V

    .line 164
    invoke-virtual {v3, v5}, Landroid/webkit/WebSettings;->setNeedInitialFocus(Z)V

    .line 176
    sget-object v4, Landroid/webkit/WebSettings$LayoutAlgorithm;->NARROW_COLUMNS:Landroid/webkit/WebSettings$LayoutAlgorithm;

    invoke-virtual {v3, v4}, Landroid/webkit/WebSettings;->setLayoutAlgorithm(Landroid/webkit/WebSettings$LayoutAlgorithm;)V

    .line 177
    return-void
.end method

.method private initializeWebViewCookies(Landroid/content/Context;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 192
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "dpi:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {p1}, Lcom/amazon/mShop/util/UIUtils;->getDeviceLogicalDPI(Landroid/content/Context;)F

    move-result v5

    invoke-static {v5}, Ljava/lang/Float;->toString(F)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "|"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "w:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {p1}, Lcom/amazon/mShop/util/UIUtils;->getPortraitWidth(Landroid/content/Context;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "|"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "h:"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {p1}, Lcom/amazon/mShop/util/UIUtils;->getPortraitHeight(Landroid/content/Context;)I

    move-result v5

    invoke-static {v5}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 195
    .local v2, "deviceCookie":Ljava/lang/String;
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationName()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationVersion()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-static {p1}, Lcom/amazon/mShop/util/BuildUtils;->getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 197
    .local v0, "amazonCookie":Ljava/lang/String;
    const/4 v4, 0x1

    invoke-static {p1, v4}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v3

    .line 201
    .local v3, "domain":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "www"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "mobile-device-info="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "; Domain="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 202
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "www"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "amzn-app-id="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "; Domain="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 204
    new-instance v1, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getAppContext()Lcom/amazon/mobile/mash/appcontext/AppContext;

    move-result-object v4

    invoke-direct {v1, v4}, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;-><init>(Lcom/amazon/mobile/mash/appcontext/AppContext;)V

    .line 205
    .local v1, "appCookie":Lcom/amazon/mobile/mash/appcontext/AppContextCookie;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v4

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "www"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "amzn-app-ctxt="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v1, p1}, Lcom/amazon/mobile/mash/appcontext/AppContextCookie;->getCookieValue(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, "; Domain="

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v4, v5, v6}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    invoke-static {}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate$Factory;->getInstance()Lcom/amazon/mShop/payment/alipay/AlipayDelegate;

    move-result-object v4

    invoke-virtual {v4, p1, v3}, Lcom/amazon/mShop/payment/alipay/AlipayDelegate;->setCookie(Landroid/content/Context;Ljava/lang/String;)V

    .line 209
    return-void
.end method


# virtual methods
.method public canGoBack()Z
    .locals 3

    .prologue
    .line 329
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 330
    .local v0, "currentUrl":Ljava/lang/String;
    if-eqz v0, :cond_0

    const-string/jumbo v2, "app-nav-type=none"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 331
    invoke-super {p0}, Lcom/amazon/mobile/mash/MASHWebView;->canGoBack()Z

    move-result v2

    .line 334
    :goto_0
    return v2

    .line 333
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v1

    .line 334
    .local v1, "list":Landroid/webkit/WebBackForwardList;
    invoke-static {v1}, Lcom/amazon/mobile/mash/util/MASHUtil;->getTargetForAppNavTypeNone(Landroid/webkit/WebBackForwardList;)I

    move-result v2

    if-ltz v2, :cond_1

    const/4 v2, 0x1

    goto :goto_0

    :cond_1
    const/4 v2, 0x0

    goto :goto_0
.end method

.method public clearAllPendingJs()V
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mMappingWebViewAndJS:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 87
    return-void
.end method

.method public clearHistory()V
    .locals 1

    .prologue
    .line 480
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->isDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    .line 481
    invoke-super {p0}, Lcom/amazon/mobile/mash/MASHWebView;->clearHistory()V

    .line 483
    :cond_0
    return-void
.end method

.method public createPluginManager(Ljava/util/List;)Lorg/apache/cordova/PluginManager;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lorg/apache/cordova/PluginEntry;",
            ">;)",
            "Lorg/apache/cordova/PluginManager;"
        }
    .end annotation

    .prologue
    .line 229
    .local p1, "pluginEntries":Ljava/util/List;, "Ljava/util/List<Lorg/apache/cordova/PluginEntry;>;"
    new-instance v1, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lorg/apache/cordova/CordovaInterface;

    invoke-direct {v1, p0, v0, p1}, Lcom/amazon/mShop/mash/api/MShopMASHPluginManager;-><init>(Lorg/apache/cordova/CordovaWebView;Lorg/apache/cordova/CordovaInterface;Ljava/util/List;)V

    return-object v1
.end method

.method public destroy()V
    .locals 1

    .prologue
    .line 427
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsWebViewDestroyed:Z

    if-eqz v0, :cond_0

    .line 431
    :goto_0
    return-void

    .line 429
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsWebViewDestroyed:Z

    .line 430
    invoke-super {p0}, Lcom/amazon/mobile/mash/MASHWebView;->destroy()V

    goto :goto_0
.end method

.method exposeJavaScriptClient(Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;)V
    .locals 2
    .param p1, "webJSAPI"    # Lcom/amazon/mShop/web/MShopWebViewJavaScriptClient;

    .prologue
    .line 218
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->isInEmbeddedBrowserMode()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 219
    sget-boolean v0, Lcom/amazon/mShop/web/MShopWebView;->DEBUG:Z

    if-eqz v0, :cond_0

    .line 220
    const-string/jumbo v0, "MShopWebView"

    const-string/jumbo v1, "Don\'t expose \'webclient\' in Embedded Browser Mode"

    invoke-static {v0, v1}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 225
    :cond_0
    :goto_0
    return-void

    .line 224
    :cond_1
    const-string/jumbo v0, "webclient"

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/web/MShopWebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public getJsNeedToCall(Ljava/lang/String;)Ljava/lang/String;
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mMappingWebViewAndJS:Ljava/util/Map;

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    return-object v0
.end method

.method public getParamtersToJS()Ljava/lang/String;
    .locals 1

    .prologue
    .line 375
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mParamtersToJS:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 442
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->isReceivedError()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x0

    :goto_0
    return-object v0

    :cond_0
    invoke-super {p0}, Lcom/amazon/mobile/mash/MASHWebView;->getTitle()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public goBack()V
    .locals 9

    .prologue
    .line 287
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsInitialPageLoad:Z

    .line 289
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v6

    instance-of v6, v6, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v6, :cond_0

    .line 290
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v6

    check-cast v6, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v6}, Lcom/amazon/mShop/web/MShopWebActivity;->calcWebviewStartTime()V

    .line 292
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 293
    .local v1, "currentUrl":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v4

    .line 294
    .local v4, "list":Landroid/webkit/WebBackForwardList;
    invoke-virtual {v4}, Landroid/webkit/WebBackForwardList;->getCurrentIndex()I

    move-result v0

    .line 296
    .local v0, "currentIndex":I
    if-gtz v0, :cond_2

    .line 298
    const-string/jumbo v6, "MShopWebView"

    const-string/jumbo v7, "goBack() is called when only one item in web history, there should be something wrong."

    invoke-static {v6, v7}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    .line 325
    :cond_1
    :goto_0
    return-void

    .line 303
    :cond_2
    const-string/jumbo v6, "app-nav-type=none"

    invoke-virtual {v1, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 304
    invoke-static {v4}, Lcom/amazon/mobile/mash/util/MASHUtil;->getTargetForAppNavTypeNone(Landroid/webkit/WebBackForwardList;)I

    move-result v5

    .line 305
    .local v5, "targetPageIndex":I
    invoke-virtual {v4, v5}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;

    move-result-object v6

    invoke-virtual {v6}, Landroid/webkit/WebHistoryItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 306
    .local v2, "destinationUrl":Ljava/lang/String;
    invoke-direct {p0, v1, v2}, Lcom/amazon/mShop/web/MShopWebView;->callNavigateBackward(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    sub-int v6, v5, v0

    invoke-super {p0, v6}, Lcom/amazon/mobile/mash/MASHWebView;->goBackOrForward(I)V

    .line 314
    :goto_1
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->clearAllPendingJs()V

    .line 317
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v7, "javascript:try{app.willReappear("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getParamtersToJS()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, ");}catch(e){}"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 318
    .local v3, "jsToCall":Ljava/lang/String;
    const-string/jumbo v6, ""

    invoke-virtual {p0, v6}, Lcom/amazon/mShop/web/MShopWebView;->setParamtersToJS(Ljava/lang/String;)V

    .line 320
    invoke-virtual {v4, v5}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;

    move-result-object v6

    invoke-virtual {v6}, Landroid/webkit/WebHistoryItem;->getUrl()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0, v6, v3}, Lcom/amazon/mShop/web/MShopWebView;->putJsNeedToCall(Ljava/lang/String;Ljava/lang/String;)V

    .line 322
    sget-boolean v6, Lcom/amazon/mShop/web/MShopWebView;->DEBUG:Z

    if-eqz v6, :cond_1

    .line 323
    const-string/jumbo v6, "MShopWebView"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v8, "goBack, put js to be called : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0

    .line 309
    .end local v2    # "destinationUrl":Ljava/lang/String;
    .end local v3    # "jsToCall":Ljava/lang/String;
    .end local v5    # "targetPageIndex":I
    :cond_3
    add-int/lit8 v5, v0, -0x1

    .line 310
    .restart local v5    # "targetPageIndex":I
    invoke-virtual {v4, v5}, Landroid/webkit/WebBackForwardList;->getItemAtIndex(I)Landroid/webkit/WebHistoryItem;

    move-result-object v6

    invoke-virtual {v6}, Landroid/webkit/WebHistoryItem;->getUrl()Ljava/lang/String;

    move-result-object v2

    .line 311
    .restart local v2    # "destinationUrl":Ljava/lang/String;
    invoke-direct {p0, v1, v2}, Lcom/amazon/mShop/web/MShopWebView;->callNavigateBackward(Ljava/lang/String;Ljava/lang/String;)V

    .line 312
    invoke-super {p0}, Lcom/amazon/mobile/mash/MASHWebView;->goBack()V

    goto :goto_1
.end method

.method public isDestroyed()Z
    .locals 1

    .prologue
    .line 472
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsWebViewDestroyed:Z

    return v0
.end method

.method isInitialPageLoad()Z
    .locals 1

    .prologue
    .line 393
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsInitialPageLoad:Z

    return v0
.end method

.method isReceivedError()Z
    .locals 1

    .prologue
    .line 404
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsReceivedError:Z

    return v0
.end method

.method public loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "data"    # Ljava/lang/String;
    .param p2, "mimeType"    # Ljava/lang/String;
    .param p3, "encoding"    # Ljava/lang/String;

    .prologue
    .line 262
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsWebViewDestroyed:Z

    if-eqz v0, :cond_0

    .line 263
    const-string/jumbo v0, "MShopWebView"

    const-string/jumbo v1, "Call WebView.loadData() after WebView is destroyed."

    invoke-static {v0, v1}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 267
    :goto_0
    return-void

    .line 266
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/amazon/mobile/mash/MASHWebView;->loadData(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public loadUrl(Ljava/lang/String;)V
    .locals 3
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x1

    .line 234
    iget-boolean v1, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsWebViewDestroyed:Z

    if-eqz v1, :cond_1

    .line 235
    const-string/jumbo v1, "MShopWebView"

    const-string/jumbo v2, "Call WebView.loadUrl() after WebView is destroyed."

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 258
    :cond_0
    :goto_0
    return-void

    .line 238
    :cond_1
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 243
    const-string/jumbo v1, "http"

    invoke-virtual {p1, v1}, Ljava/lang/String;->startsWith(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 245
    invoke-static {p1}, Lcom/amazon/mShop/crash/WebViewLogger;->logURL(Ljava/lang/String;)V

    .line 246
    iput-boolean v2, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsInitialPageLoad:Z

    .line 249
    :cond_2
    sget-boolean v1, Lcom/amazon/mShop/web/MShopWebView;->DEBUG:Z

    if-eqz v1, :cond_3

    .line 250
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-static {v1, v2}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v0

    .line 251
    .local v0, "domain":Ljava/lang/String;
    invoke-static {p1, v0}, Lcom/amazon/mShop/util/WebUtils;->initializeCookiesForDevoHost(Ljava/lang/String;Ljava/lang/String;)V

    .line 255
    .end local v0    # "domain":Ljava/lang/String;
    :cond_3
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/web/MShopWebView;->setReceivedError(Z)V

    .line 256
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebView;->callNavigateForward(Ljava/lang/String;)V

    .line 257
    invoke-super {p0, p1}, Lcom/amazon/mobile/mash/MASHWebView;->loadUrl(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onDraw(Landroid/graphics/Canvas;)V
    .locals 5
    .param p1, "canvas"    # Landroid/graphics/Canvas;

    .prologue
    .line 451
    invoke-super {p0, p1}, Lcom/amazon/mobile/mash/MASHWebView;->onDraw(Landroid/graphics/Canvas;)V

    .line 453
    invoke-static {}, Lcom/amazon/mShop/util/ActivityUtils;->isSpinnerV2Enabled()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 454
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContentHeight()I

    move-result v0

    .line 455
    .local v0, "currContentHeight":I
    iget v2, p0, Lcom/amazon/mShop/web/MShopWebView;->prevContentHeight:I

    if-eq v2, v0, :cond_0

    .line 456
    iput v0, p0, Lcom/amazon/mShop/web/MShopWebView;->prevContentHeight:I

    .line 457
    if-lez v0, :cond_0

    .line 458
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->webviewContentHeightChanged()V

    .line 463
    .end local v0    # "currContentHeight":I
    :cond_0
    sget-boolean v2, Lcom/amazon/mShop/web/MShopWebView;->DEBUG:Z

    if-eqz v2, :cond_1

    .line 464
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_2

    invoke-virtual {p1}, Landroid/graphics/Canvas;->isHardwareAccelerated()Z

    move-result v1

    .line 467
    .local v1, "isHAEnabled":Z
    :goto_0
    const-string/jumbo v3, "MShopWebView"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "webview hardware acceleration is "

    invoke-virtual {v2, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    if-eqz v1, :cond_3

    const-string/jumbo v2, "on"

    :goto_1
    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v3, v2}, Landroid/util/Log;->d(Ljava/lang/String;Ljava/lang/String;)I

    .line 469
    .end local v1    # "isHAEnabled":Z
    :cond_1
    return-void

    .line 464
    :cond_2
    const/4 v1, 0x0

    goto :goto_0

    .line 467
    .restart local v1    # "isHAEnabled":Z
    :cond_3
    const-string/jumbo v2, "off"

    goto :goto_1
.end method

.method public postUrl(Ljava/lang/String;[B)V
    .locals 4
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "postData"    # [B

    .prologue
    .line 271
    iget-boolean v1, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsWebViewDestroyed:Z

    if-eqz v1, :cond_0

    .line 272
    const-string/jumbo v1, "MShopWebView"

    const-string/jumbo v2, "Call WebView.postUrl() after WebView is destroyed."

    invoke-static {v1, v2}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 282
    :goto_0
    return-void

    .line 275
    :cond_0
    sget-boolean v1, Lcom/amazon/mShop/web/MShopWebView;->DEBUG:Z

    if-eqz v1, :cond_1

    .line 276
    const-string/jumbo v1, "MShopWebView"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "postUrl >>> "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 277
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    const/4 v2, 0x1

    invoke-static {v1, v2}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v0

    .line 278
    .local v0, "domain":Ljava/lang/String;
    invoke-static {p1, v0}, Lcom/amazon/mShop/util/WebUtils;->initializeCookiesForDevoHost(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    .end local v0    # "domain":Ljava/lang/String;
    :cond_1
    invoke-direct {p0, p1}, Lcom/amazon/mShop/web/MShopWebView;->callNavigateForward(Ljava/lang/String;)V

    .line 281
    invoke-super {p0, p1, p2}, Lcom/amazon/mobile/mash/MASHWebView;->postUrl(Ljava/lang/String;[B)V

    goto :goto_0
.end method

.method public putJsNeedToCall(Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "jsName"    # Ljava/lang/String;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mMappingWebViewAndJS:Ljava/util/Map;

    invoke-interface {v0, p1, p2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 83
    return-void
.end method

.method public reload()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 381
    iput-boolean v1, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsInitialPageLoad:Z

    .line 383
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsReceivedError:Z

    .line 385
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/web/MShopWebActivity;

    if-eqz v0, :cond_0

    .line 386
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebActivity;->calcWebviewStartTime()V

    .line 388
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0, v1, v1}, Lcom/amazon/mShop/web/MShopWebView;->callNavigate(Ljava/lang/String;ZZ)V

    .line 389
    invoke-super {p0}, Lcom/amazon/mobile/mash/MASHWebView;->reload()V

    .line 390
    return-void
.end method

.method setInitialPageLoad(Z)V
    .locals 0
    .param p1, "initialPageLoad"    # Z

    .prologue
    .line 397
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsInitialPageLoad:Z

    .line 398
    return-void
.end method

.method public setNetworkAvailable(Z)V
    .locals 1
    .param p1, "networkUp"    # Z

    .prologue
    .line 418
    iget-boolean v0, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsWebViewDestroyed:Z

    if-eqz v0, :cond_0

    .line 420
    :goto_0
    return-void

    .line 419
    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mobile/mash/MASHWebView;->setNetworkAvailable(Z)V

    goto :goto_0
.end method

.method public setParamtersToJS(Ljava/lang/String;)V
    .locals 0
    .param p1, "paras"    # Ljava/lang/String;

    .prologue
    .line 372
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebView;->mParamtersToJS:Ljava/lang/String;

    .line 373
    return-void
.end method

.method setReceivedError(Z)V
    .locals 0
    .param p1, "isReceivedError"    # Z

    .prologue
    .line 412
    iput-boolean p1, p0, Lcom/amazon/mShop/web/MShopWebView;->mIsReceivedError:Z

    .line 413
    return-void
.end method

.method setWebViewContainer(Lcom/amazon/mShop/web/MShopWebViewContainer;)V
    .locals 0
    .param p1, "container"    # Lcom/amazon/mShop/web/MShopWebViewContainer;

    .prologue
    .line 446
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebView;->mWebViewContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    .line 447
    return-void
.end method
