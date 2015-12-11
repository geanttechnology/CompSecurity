.class Lcom/amazon/device/ads/InterstitialAdActivityAdapter;
.super Ljava/lang/Object;
.source "InterstitialAdActivityAdapter.java"

# interfaces
.implements Lcom/amazon/device/ads/AdView;
.implements Lcom/amazon/device/ads/IAdActivityAdapter;


# instance fields
.field private final CLOSE_BUTTON_SIZE_DP:I

.field private final CLOSE_BUTTON_TAP_TARGET_SIZE_DP:I

.field private activity:Landroid/app/Activity;

.field private uniqueId:Ljava/lang/String;


# direct methods
.method constructor <init>()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 30
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    .line 34
    iput-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->uniqueId:Ljava/lang/String;

    .line 36
    const/16 v0, 0x3c

    iput v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->CLOSE_BUTTON_SIZE_DP:I

    .line 37
    const/16 v0, 0x50

    iput v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->CLOSE_BUTTON_TAP_TARGET_SIZE_DP:I

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/device/ads/InterstitialAdActivityAdapter;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/device/ads/InterstitialAdActivityAdapter;

    .prologue
    .line 30
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method private addNativeCloseButton(Landroid/widget/FrameLayout;)V
    .locals 10
    .param p1, "parentView"    # Landroid/widget/FrameLayout;

    .prologue
    const/high16 v9, 0x3f000000    # 0.5f

    .line 121
    new-instance v7, Landroid/util/DisplayMetrics;

    invoke-direct {v7}, Landroid/util/DisplayMetrics;-><init>()V

    .line 122
    .local v7, "metrics":Landroid/util/DisplayMetrics;
    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    const-string/jumbo v2, "window"

    invoke-virtual {v1, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v8

    check-cast v8, Landroid/view/WindowManager;

    .line 123
    .local v8, "wm":Landroid/view/WindowManager;
    invoke-interface {v8}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/view/Display;->getMetrics(Landroid/util/DisplayMetrics;)V

    .line 124
    const/high16 v1, 0x42700000    # 60.0f

    iget v2, v7, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    add-float/2addr v1, v9

    float-to-int v5, v1

    .line 125
    .local v5, "buttonSize":I
    const/high16 v1, 0x42a00000    # 80.0f

    iget v2, v7, Landroid/util/DisplayMetrics;->density:F

    mul-float/2addr v1, v2

    add-float/2addr v1, v9

    float-to-int v6, v1

    .line 127
    .local v6, "tapTargetSize":I
    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v2

    const-string/jumbo v9, "amazon_ads_interstitial_close_normal.png"

    invoke-virtual {v2, v9}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/device/ads/AndroidTargetUtils;->getNewBitmapDrawable(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v3

    .line 128
    .local v3, "closeNormal":Landroid/graphics/drawable/BitmapDrawable;
    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    invoke-static {}, Lcom/amazon/device/ads/Assets;->getInstance()Lcom/amazon/device/ads/Assets;

    move-result-object v2

    const-string/jumbo v9, "amazon_ads_interstitial_close_pressed.png"

    invoke-virtual {v2, v9}, Lcom/amazon/device/ads/Assets;->getFilePath(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/amazon/device/ads/AndroidTargetUtils;->getNewBitmapDrawable(Landroid/content/res/Resources;Ljava/lang/String;)Landroid/graphics/drawable/BitmapDrawable;

    move-result-object v4

    .line 130
    .local v4, "closePressed":Landroid/graphics/drawable/BitmapDrawable;
    new-instance v0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;

    move-object v1, p0

    move-object v2, p1

    invoke-direct/range {v0 .. v6}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter$1;-><init>(Lcom/amazon/device/ads/InterstitialAdActivityAdapter;Landroid/widget/FrameLayout;Landroid/graphics/drawable/BitmapDrawable;Landroid/graphics/drawable/BitmapDrawable;II)V

    .line 185
    .local v0, "closeButtonTask":Landroid/os/AsyncTask;, "Landroid/os/AsyncTask<Ljava/lang/Void;Ljava/lang/Void;Landroid/widget/RelativeLayout;>;"
    const/4 v1, 0x0

    new-array v1, v1, [Ljava/lang/Void;

    invoke-static {v0, v1}, Lcom/amazon/device/ads/ThreadUtils;->executeAsyncTask(Landroid/os/AsyncTask;[Ljava/lang/Object;)V

    .line 186
    return-void
.end method

.method private sendBroadcast(Ljava/lang/String;)V
    .locals 3
    .param p1, "broadcastAction"    # Ljava/lang/String;

    .prologue
    .line 226
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v1, "amazon.mobile.ads.interstitial"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 227
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "action"

    invoke-virtual {v0, v1, p1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 228
    const-string/jumbo v1, "uniqueIdentifier"

    iget-object v2, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->uniqueId:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 229
    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->sendBroadcast(Landroid/content/Intent;)V

    .line 230
    return-void
.end method


# virtual methods
.method getActivity()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 209
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    return-object v0
.end method

.method public getHeight()I
    .locals 1

    .prologue
    .line 245
    const/4 v0, 0x0

    return v0
.end method

.method public getSpecialUrlExecutor()Lcom/amazon/device/ads/AdWebViewClient$UrlExecutor;
    .locals 2

    .prologue
    .line 251
    new-instance v0, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-direct {v0, p0, v1}, Lcom/amazon/device/ads/AdWebViewClient$AmazonMobileExecutor;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;)V

    return-object v0
.end method

.method public isAdViewRenderable()Z
    .locals 1

    .prologue
    .line 215
    const/4 v0, 0x1

    return v0
.end method

.method public launchExternalBrowserForLink(Ljava/lang/String;)Z
    .locals 1
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 235
    invoke-virtual {p0}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->isAdViewRenderable()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 237
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-static {p1, v0}, Lcom/amazon/device/ads/AdUtils;->launchActivityForIntentLink(Ljava/lang/String;Landroid/content/Context;)Z

    move-result v0

    .line 239
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onCreate()V
    .locals 6

    .prologue
    .line 64
    invoke-static {}, Lcom/amazon/device/ads/WebViewFactory;->getInstance()Lcom/amazon/device/ads/WebViewFactory;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v4, v5}, Lcom/amazon/device/ads/WebViewFactory;->createWebView(Landroid/content/Context;)Landroid/webkit/WebView;

    move-result-object v3

    .line 65
    .local v3, "webView":Landroid/webkit/WebView;
    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getUserAgentString()Ljava/lang/String;

    move-result-object v4

    if-nez v4, :cond_0

    .line 67
    invoke-virtual {v3}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v4

    invoke-virtual {v4}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v2

    .line 68
    .local v2, "userAgent":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/device/ads/DeviceInfo;->setUserAgentString(Ljava/lang/String;)V

    .line 70
    .end local v2    # "userAgent":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string/jumbo v5, "uniqueIdentifier"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->uniqueId:Ljava/lang/String;

    .line 71
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v4}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v4

    const-string/jumbo v5, "creative"

    invoke-virtual {v4, v5}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 77
    .local v0, "html":Ljava/lang/String;
    const-string/jumbo v4, "<head>"

    const-string/jumbo v5, "<head>\n  <script type=\'text/javascript\'>\n  function fireImpression(a) {\n    var container = document.createElement(\'div\');\n    var pix = document.createElement(\'img\');\n    pix.setAttribute(\'src\', a);\n    pix.style.position = \'absolute\';\n    pix.style.top = \'0px\';\n    pix.style.right = \'0px\';\n    pix.style.display = \'none\';\n    container.appendChild(pix);\n    document.body.appendChild(container);\n  }\n  </script>\n"

    invoke-virtual {v0, v4, v5}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 94
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->uniqueId:Ljava/lang/String;

    invoke-static {v4}, Lcom/amazon/device/ads/MraidView;->removeCachedMraidView(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView;

    move-result-object v1

    .line 95
    .local v1, "mraidView":Lcom/amazon/device/ads/MraidView;
    if-nez v1, :cond_1

    .line 97
    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/webkit/WebView;->setBackgroundColor(I)V

    .line 98
    new-instance v1, Lcom/amazon/device/ads/MraidView;

    .end local v1    # "mraidView":Lcom/amazon/device/ads/MraidView;
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-direct {v1, p0, v4, v3}, Lcom/amazon/device/ads/MraidView;-><init>(Lcom/amazon/device/ads/AdView;Landroid/content/Context;Landroid/webkit/WebView;)V

    .line 105
    .restart local v1    # "mraidView":Lcom/amazon/device/ads/MraidView;
    :goto_0
    const-string/jumbo v4, "http://amazon-adsystem.amazon.com/"

    invoke-virtual {v1, v4, v0}, Lcom/amazon/device/ads/MraidView;->loadHtmlData(Ljava/lang/String;Ljava/lang/String;)Z

    .line 106
    invoke-direct {p0, v1}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->addNativeCloseButton(Landroid/widget/FrameLayout;)V

    .line 108
    iget-object v4, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v4, v1}, Landroid/app/Activity;->setContentView(Landroid/view/View;)V

    .line 109
    return-void

    .line 102
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView;->registerReceivers()V

    .line 103
    invoke-virtual {v1, p0}, Lcom/amazon/device/ads/MraidView;->setAdView(Lcom/amazon/device/ads/AdView;)V

    goto :goto_0
.end method

.method public onPageFinished()V
    .locals 1

    .prologue
    .line 221
    const-string/jumbo v0, "finished"

    invoke-direct {p0, v0}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->sendBroadcast(Ljava/lang/String;)V

    .line 222
    return-void
.end method

.method public onPause()V
    .locals 0

    .prologue
    .line 190
    return-void
.end method

.method public onResume()V
    .locals 0

    .prologue
    .line 194
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->isFinishing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 203
    const-string/jumbo v0, "dismissed"

    invoke-direct {p0, v0}, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->sendBroadcast(Ljava/lang/String;)V

    .line 205
    :cond_0
    return-void
.end method

.method public preOnCreate()V
    .locals 3

    .prologue
    const/16 v2, 0x400

    .line 50
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->requestWindowFeature(I)Z

    .line 52
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-virtual {v0}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v0

    invoke-virtual {v0, v2, v2}, Landroid/view/Window;->setFlags(II)V

    .line 55
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0xb

    if-le v0, v1, :cond_0

    .line 57
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    invoke-static {v0}, Lcom/amazon/device/ads/AndroidTargetUtils;->hideActionAndStatusBars(Landroid/app/Activity;)V

    .line 59
    :cond_0
    return-void
.end method

.method public setActivity(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 42
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAdActivityAdapter;->activity:Landroid/app/Activity;

    .line 43
    return-void
.end method

.method public shouldDisableWebViewHardwareAcceleration()Z
    .locals 1

    .prologue
    .line 257
    const/4 v0, 0x0

    return v0
.end method
