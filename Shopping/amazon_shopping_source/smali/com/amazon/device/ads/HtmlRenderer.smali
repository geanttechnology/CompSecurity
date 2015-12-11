.class Lcom/amazon/device/ads/HtmlRenderer;
.super Lcom/amazon/device/ads/AdRenderer;
.source "HtmlRenderer.java"


# static fields
.field public static final LOG_TAG:Ljava/lang/String;


# instance fields
.field protected adView_:Landroid/webkit/WebView;

.field protected hasLoadedAd:Z

.field protected shouldForceRenderFailure:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const-class v0, Lcom/amazon/device/ads/HtmlRenderer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/device/ads/HtmlRenderer;->LOG_TAG:Ljava/lang/String;

    return-void
.end method

.method protected constructor <init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;Landroid/webkit/WebView;Landroid/content/Context;)V
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/AdData;
    .param p2, "controller"    # Lcom/amazon/device/ads/IAdController;
    .param p3, "webView"    # Landroid/webkit/WebView;
    .param p4, "context"    # Landroid/content/Context;

    .prologue
    const/4 v0, 0x0

    .line 28
    invoke-direct {p0, p1, p2, p4}, Lcom/amazon/device/ads/AdRenderer;-><init>(Lcom/amazon/device/ads/AdData;Lcom/amazon/device/ads/IAdController;Landroid/content/Context;)V

    .line 23
    iput-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->hasLoadedAd:Z

    .line 24
    iput-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->shouldForceRenderFailure:Z

    .line 30
    iput-object p3, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    .line 31
    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->setupAdView()V

    .line 33
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-lt v0, v1, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->shouldDisableWebViewHardwareAcceleration()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 35
    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->disableHardwareAcceleration()V

    .line 37
    :cond_0
    return-void
.end method


# virtual methods
.method protected adLoaded(Lcom/amazon/device/ads/AdProperties;)V
    .locals 3
    .param p1, "props"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    const/4 v2, -0x2

    .line 135
    new-instance v0, Landroid/widget/FrameLayout$LayoutParams;

    const/16 v1, 0x11

    invoke-direct {v0, v2, v2, v1}, Landroid/widget/FrameLayout$LayoutParams;-><init>(III)V

    .line 139
    .local v0, "layoutParams":Landroid/widget/FrameLayout$LayoutParams;
    iget-object v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v1}, Lcom/amazon/device/ads/IAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v1, v2, v0}, Lcom/amazon/device/ads/AdLayout;->addView(Landroid/view/View;Landroid/view/ViewGroup$LayoutParams;)V

    .line 141
    invoke-super {p0, p1}, Lcom/amazon/device/ads/AdRenderer;->adLoaded(Lcom/amazon/device/ads/AdProperties;)V

    .line 142
    return-void
.end method

.method protected destroy()V
    .locals 2

    .prologue
    .line 165
    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->isAdViewNull()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 167
    sget-object v0, Lcom/amazon/device/ads/HtmlRenderer;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Called destroy(), but view is already null."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    :goto_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->isDestroyed:Z

    .line 176
    return-void

    .line 171
    :cond_0
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 172
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    goto :goto_0
.end method

.method protected disableHardwareAcceleration()V
    .locals 1

    .prologue
    .line 66
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-static {v0}, Lcom/amazon/device/ads/AndroidTargetUtils;->disableHardwareAcceleration(Landroid/view/View;)V

    .line 67
    return-void
.end method

.method protected getAdState(Lcom/amazon/device/ads/AdRenderer$AdState;)Z
    .locals 1
    .param p1, "c"    # Lcom/amazon/device/ads/AdRenderer$AdState;

    .prologue
    .line 72
    const/4 v0, 0x0

    return v0
.end method

.method public initialize()V
    .locals 0

    .prologue
    .line 42
    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->setupAdView()V

    .line 43
    invoke-super {p0}, Lcom/amazon/device/ads/AdRenderer;->initialize()V

    .line 44
    return-void
.end method

.method protected isAdViewNull()Z
    .locals 1

    .prologue
    .line 190
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public launchExternalBrowserForLink(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 196
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->context:Landroid/content/Context;

    invoke-static {p1, v0}, Lcom/amazon/device/ads/AdUtils;->launchActivityForIntentLink(Ljava/lang/String;Landroid/content/Context;)Z

    .line 197
    const/4 v0, 0x1

    return v0
.end method

.method public onPageFinished()V
    .locals 1

    .prologue
    .line 119
    iget-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->isDestroyed:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->hasLoadedAd:Z

    if-nez v0, :cond_0

    .line 121
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->hasLoadedAd:Z

    .line 122
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getProperties()Lcom/amazon/device/ads/AdProperties;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/device/ads/HtmlRenderer;->adLoaded(Lcom/amazon/device/ads/AdProperties;)V

    .line 124
    :cond_0
    return-void
.end method

.method protected prepareToGoAway()V
    .locals 0

    .prologue
    .line 130
    return-void
.end method

.method protected removeView()V
    .locals 2

    .prologue
    .line 154
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v0}, Lcom/amazon/device/ads/IAdController;->getAdLayout()Lcom/amazon/device/ads/AdLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/AdLayout;->removeView(Landroid/view/View;)V

    .line 159
    :cond_0
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->viewRemoved:Z

    .line 160
    return-void
.end method

.method protected render()Z
    .locals 1

    .prologue
    .line 78
    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->isAdViewNull()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->isAdViewDestroyed()Z

    move-result v0

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->shouldForceRenderFailure:Z

    if-eqz v0, :cond_1

    .line 80
    :cond_0
    const/4 v0, 0x0

    .line 84
    :goto_0
    return v0

    .line 83
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->renderAdView()V

    .line 84
    const/4 v0, 0x1

    goto :goto_0
.end method

.method protected renderAdView()V
    .locals 6

    .prologue
    .line 92
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    const-string/jumbo v1, "about:blank"

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 93
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->hasLoadedAd:Z

    .line 95
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adData:Lcom/amazon/device/ads/AdData;

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getCreative()Ljava/lang/String;

    move-result-object v2

    .line 97
    .local v2, "html":Ljava/lang/String;
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "<html><meta name=\"viewport\" content=\"width="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v1}, Lcom/amazon/device/ads/IAdController;->getWindowWidth()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", height="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v1}, Lcom/amazon/device/ads/IAdController;->getWindowHeight()I

    move-result v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", initial-scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->getScalingMultiplier()D

    move-result-wide v3

    invoke-static {v3, v4}, Lcom/amazon/device/ads/AdUtils;->getViewportInitialScale(D)D

    move-result-wide v3

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", minimum-scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->getScalingMultiplier()D

    move-result-wide v3

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", maximum-scale="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/device/ads/HtmlRenderer;->getScalingMultiplier()D

    move-result-wide v3

    invoke-virtual {v0, v3, v4}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\">"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "</html>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 111
    const-string/jumbo v0, "<head>"

    const-string/jumbo v1, "<head><script type=\"text/javascript\">htmlWillCallFinishLoad = 1;</script>"

    invoke-virtual {v2, v0, v1}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v2

    .line 113
    iget-object v0, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    const-string/jumbo v1, "http://amazon-adsystem.amazon.com/"

    const-string/jumbo v3, "text/html"

    const-string/jumbo v4, "utf-8"

    const/4 v5, 0x0

    invoke-virtual/range {v0 .. v5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    return-void
.end method

.method protected sendCommand(Ljava/lang/String;Ljava/util/Map;)Z
    .locals 1
    .param p1, "command"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;)Z"
        }
    .end annotation

    .prologue
    .line 148
    .local p2, "args":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    const/4 v0, 0x1

    return v0
.end method

.method protected setupAdView()V
    .locals 5

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    .line 48
    iget-object v3, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v3, v2}, Landroid/webkit/WebView;->setHorizontalScrollBarEnabled(Z)V

    .line 49
    iget-object v3, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v3, v2}, Landroid/webkit/WebView;->setHorizontalScrollbarOverlay(Z)V

    .line 50
    iget-object v3, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v3, v2}, Landroid/webkit/WebView;->setVerticalScrollBarEnabled(Z)V

    .line 51
    iget-object v3, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v3, v2}, Landroid/webkit/WebView;->setVerticalScrollbarOverlay(Z)V

    .line 52
    iget-object v3, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v3}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 56
    iget-object v3, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    sget-object v4, Lcom/amazon/device/ads/HtmlRenderer;->LOG_TAG:Ljava/lang/String;

    invoke-static {v1, v3, v4}, Lcom/amazon/device/ads/WebViewFactory;->setJavaScriptEnabledForWebView(ZLandroid/webkit/WebView;Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    :goto_0
    iput-boolean v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->shouldForceRenderFailure:Z

    .line 58
    iget-object v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v1, v2}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 59
    new-instance v0, Lcom/amazon/device/ads/AdWebViewClient;

    iget-object v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->context:Landroid/content/Context;

    invoke-direct {v0, p0, v1}, Lcom/amazon/device/ads/AdWebViewClient;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V

    .line 60
    .local v0, "adWebViewClient":Lcom/amazon/device/ads/AdWebViewClient;
    const-string/jumbo v1, "amazonmobile"

    iget-object v2, p0, Lcom/amazon/device/ads/HtmlRenderer;->controller:Lcom/amazon/device/ads/IAdController;

    invoke-interface {v2}, Lcom/amazon/device/ads/IAdController;->getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/amazon/device/ads/AdWebViewClient;->putUrlExecutor(Ljava/lang/String;Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;)V

    .line 61
    iget-object v1, p0, Lcom/amazon/device/ads/HtmlRenderer;->adView_:Landroid/webkit/WebView;

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 62
    return-void

    .end local v0    # "adWebViewClient":Lcom/amazon/device/ads/AdWebViewClient;
    :cond_0
    move v1, v2

    .line 56
    goto :goto_0
.end method

.method protected shouldReuse()Z
    .locals 1

    .prologue
    .line 181
    const/4 v0, 0x1

    return v0
.end method
