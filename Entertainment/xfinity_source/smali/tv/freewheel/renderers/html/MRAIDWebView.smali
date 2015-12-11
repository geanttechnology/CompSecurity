.class final Ltv/freewheel/renderers/html/MRAIDWebView;
.super Landroid/webkit/WebView;
.source "MRAIDWebView.java"

# interfaces
.implements Landroid/media/MediaPlayer$OnCompletionListener;
.implements Landroid/media/MediaPlayer$OnErrorListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;,
        Ltv/freewheel/renderers/html/MRAIDWebView$ILoggerBridge;
    }
.end annotation


# instance fields
.field private final BRIDGE_NAME_IN_JS:Ljava/lang/String;

.field private final LOGGER_BRIDGE_NAME_IN_JS:Ljava/lang/String;

.field private activity:Landroid/app/Activity;

.field private baseURL:Ljava/lang/String;

.field private bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

.field private customVideoView:Landroid/widget/VideoView;

.field private customView:Landroid/view/View;

.field private enableMRAID:Z

.field private fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;

.field private isFullScreen:Z

.field private logger:Ltv/freewheel/utils/Logger;

.field private final loggerBridge:Ltv/freewheel/renderers/html/MRAIDWebView$ILoggerBridge;

.field private pageLoaded:Z

.field private pageShown:Z

.field private webChromeClient:Landroid/webkit/WebChromeClient;

.field private withLoadedCallBack:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Ltv/freewheel/renderers/html/HTMLRenderer;ZZ)V
    .locals 4
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "delegate"    # Ltv/freewheel/renderers/html/HTMLRenderer;
    .param p3, "withLoadedCallBack"    # Z
    .param p4, "enableMRAID"    # Z

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 333
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 40
    const-string v0, "FW_MRAID_RENDERER"

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->BRIDGE_NAME_IN_JS:Ljava/lang/String;

    .line 41
    const-string v0, "FW_LOGGER"

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->LOGGER_BRIDGE_NAME_IN_JS:Ljava/lang/String;

    .line 43
    const-string v0, ""

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    .line 45
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    .line 48
    iput-boolean v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->withLoadedCallBack:Z

    .line 51
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->isFullScreen:Z

    .line 52
    iput-boolean v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->enableMRAID:Z

    .line 53
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->pageLoaded:Z

    .line 54
    iput-boolean v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->pageShown:Z

    .line 55
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->activity:Landroid/app/Activity;

    .line 56
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->webChromeClient:Landroid/webkit/WebChromeClient;

    .line 57
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    .line 58
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;

    .line 59
    iput-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;

    .line 73
    new-instance v0, Ltv/freewheel/renderers/html/MRAIDWebView$1;

    invoke-direct {v0, p0}, Ltv/freewheel/renderers/html/MRAIDWebView$1;-><init>(Ltv/freewheel/renderers/html/MRAIDWebView;)V

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->loggerBridge:Ltv/freewheel/renderers/html/MRAIDWebView$ILoggerBridge;

    .line 334
    invoke-static {p0}, Ltv/freewheel/utils/Logger;->getLogger(Ljava/lang/Object;)Ltv/freewheel/utils/Logger;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    .line 335
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->activity:Landroid/app/Activity;

    .line 336
    iput-boolean p3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->withLoadedCallBack:Z

    .line 337
    iput-boolean p4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->enableMRAID:Z

    .line 338
    invoke-direct {p0, p2}, Ltv/freewheel/renderers/html/MRAIDWebView;->init(Ltv/freewheel/renderers/html/HTMLRenderer;)V

    .line 339
    return-void
.end method

.method static synthetic access$000(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/utils/Logger;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    return-object v0
.end method

.method static synthetic access$100(Ltv/freewheel/renderers/html/MRAIDWebView;)Landroid/widget/VideoView;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;

    return-object v0
.end method

.method static synthetic access$1000(Ltv/freewheel/renderers/html/MRAIDWebView;Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;
    .param p1, "x1"    # Ljava/lang/String;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Ltv/freewheel/renderers/html/MRAIDWebView;->injectScriptToHTML(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$102(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/widget/VideoView;)Landroid/widget/VideoView;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;
    .param p1, "x1"    # Landroid/widget/VideoView;

    .prologue
    .line 39
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;

    return-object p1
.end method

.method static synthetic access$200(Ltv/freewheel/renderers/html/MRAIDWebView;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$202(Ltv/freewheel/renderers/html/MRAIDWebView;Landroid/view/View;)Landroid/view/View;
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;
    .param p1, "x1"    # Landroid/view/View;

    .prologue
    .line 39
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;

    return-object p1
.end method

.method static synthetic access$300(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/renderers/html/MRAIDBackgroundView;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    return-object v0
.end method

.method static synthetic access$400(Ltv/freewheel/renderers/html/MRAIDWebView;)Z
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->pageLoaded:Z

    return v0
.end method

.method static synthetic access$402(Ltv/freewheel/renderers/html/MRAIDWebView;Z)Z
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;
    .param p1, "x1"    # Z

    .prologue
    .line 39
    iput-boolean p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->pageLoaded:Z

    return p1
.end method

.method static synthetic access$500(Ltv/freewheel/renderers/html/MRAIDWebView;)Z
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->withLoadedCallBack:Z

    return v0
.end method

.method static synthetic access$600(Ltv/freewheel/renderers/html/MRAIDWebView;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 39
    invoke-direct {p0, p1}, Ltv/freewheel/renderers/html/MRAIDWebView;->setBaseURL(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$700(Ltv/freewheel/renderers/html/MRAIDWebView;)V
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    invoke-direct {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->tryTriggerLoaded()V

    return-void
.end method

.method static synthetic access$802(Ltv/freewheel/renderers/html/MRAIDWebView;Z)Z
    .locals 0
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;
    .param p1, "x1"    # Z

    .prologue
    .line 39
    iput-boolean p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->pageShown:Z

    return p1
.end method

.method static synthetic access$900(Ltv/freewheel/renderers/html/MRAIDWebView;)Ltv/freewheel/renderers/html/HTMLRenderer;
    .locals 1
    .param p0, "x0"    # Ltv/freewheel/renderers/html/MRAIDWebView;

    .prologue
    .line 39
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    return-object v0
.end method

.method private init(Ltv/freewheel/renderers/html/HTMLRenderer;)V
    .locals 7
    .param p1, "bridge"    # Ltv/freewheel/renderers/html/HTMLRenderer;

    .prologue
    const/4 v3, 0x1

    const/4 v5, 0x0

    .line 142
    iput-object p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    .line 143
    invoke-virtual {p0, v3}, Ltv/freewheel/renderers/html/MRAIDWebView;->setFocusable(Z)V

    .line 144
    invoke-virtual {p0, v3}, Ltv/freewheel/renderers/html/MRAIDWebView;->setFocusableInTouchMode(Z)V

    .line 145
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 146
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/webkit/WebSettings;->setSaveFormData(Z)V

    .line 147
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/webkit/WebSettings;->setSavePassword(Z)V

    .line 148
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/webkit/WebSettings;->setSupportZoom(Z)V

    .line 149
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/webkit/WebSettings;->setBuiltInZoomControls(Z)V

    .line 150
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/webkit/WebSettings;->setAllowFileAccess(Z)V

    .line 151
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V

    .line 152
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v5}, Landroid/webkit/WebSettings;->setGeolocationEnabled(Z)V

    .line 153
    new-instance v2, Ltv/freewheel/renderers/html/MRAIDWebView$2;

    invoke-direct {v2, p0}, Ltv/freewheel/renderers/html/MRAIDWebView$2;-><init>(Ltv/freewheel/renderers/html/MRAIDWebView;)V

    iput-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->webChromeClient:Landroid/webkit/WebChromeClient;

    .line 240
    iget-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->webChromeClient:Landroid/webkit/WebChromeClient;

    invoke-virtual {p0, v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 242
    iget-boolean v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->enableMRAID:Z

    if-eqz v2, :cond_3

    .line 243
    new-instance v2, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;

    iget-object v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->activity:Landroid/app/Activity;

    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->webChromeClient:Landroid/webkit/WebChromeClient;

    invoke-direct {v2, v3, v4}, Ltv/freewheel/renderers/html/MRAIDCustomViewBackgroundView;-><init>(Landroid/app/Activity;Landroid/webkit/WebChromeClient;)V

    iput-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    .line 248
    :goto_0
    iget-boolean v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->enableMRAID:Z

    if-eqz v2, :cond_0

    .line 249
    iget-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v3, "enabling MRAID for the webView"

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 250
    iget-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->loggerBridge:Ltv/freewheel/renderers/html/MRAIDWebView$ILoggerBridge;

    const-string v3, "FW_LOGGER"

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/renderers/html/MRAIDWebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 251
    iget-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    const-string v3, "FW_MRAID_RENDERER"

    invoke-virtual {p0, v2, v3}, Ltv/freewheel/renderers/html/MRAIDWebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 254
    :cond_0
    invoke-virtual {p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/renderers/html/Parameters;

    move-result-object v2

    iget-object v1, v2, Ltv/freewheel/renderers/html/Parameters;->shouldBackgroundTransparent:Ljava/lang/Boolean;

    .line 255
    .local v1, "pval":Ljava/lang/Boolean;
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 256
    iget-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "enabling transparent: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p1}, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/renderers/html/Parameters;

    move-result-object v4

    iget-object v4, v4, Ltv/freewheel/renderers/html/Parameters;->bootstrap:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 257
    invoke-virtual {p0, v5}, Ltv/freewheel/renderers/html/MRAIDWebView;->setBackgroundColor(I)V

    .line 258
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 259
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0xb

    if-lt v2, v3, :cond_1

    .line 261
    :try_start_0
    const-class v2, Landroid/view/View;

    const-string v3, "setLayerType"

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Class;

    const/4 v5, 0x0

    sget-object v6, Ljava/lang/Integer;->TYPE:Ljava/lang/Class;

    aput-object v6, v4, v5

    const/4 v5, 0x1

    const-class v6, Landroid/graphics/Paint;

    aput-object v6, v4, v5

    invoke-virtual {v2, v3, v4}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;

    move-result-object v0

    .line 262
    .local v0, "method":Ljava/lang/reflect/Method;
    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const/4 v4, 0x1

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v2, v3

    const/4 v3, 0x1

    new-instance v4, Landroid/graphics/Paint;

    invoke-direct {v4}, Landroid/graphics/Paint;-><init>()V

    aput-object v4, v2, v3

    invoke-virtual {v0, p0, v2}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 270
    .end local v0    # "method":Ljava/lang/reflect/Method;
    :cond_1
    :goto_1
    new-instance v2, Ltv/freewheel/renderers/html/MRAIDWebView$3;

    invoke-direct {v2, p0, p1}, Ltv/freewheel/renderers/html/MRAIDWebView$3;-><init>(Ltv/freewheel/renderers/html/MRAIDWebView;Ltv/freewheel/renderers/html/HTMLRenderer;)V

    invoke-virtual {p0, v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 320
    iget-boolean v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->withLoadedCallBack:Z

    if-eqz v2, :cond_2

    .line 321
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v2

    new-instance v3, Ltv/freewheel/renderers/html/MRAIDWebView$4;

    invoke-direct {v3, p0}, Ltv/freewheel/renderers/html/MRAIDWebView$4;-><init>(Ltv/freewheel/renderers/html/MRAIDWebView;)V

    invoke-virtual {v2, v3}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 330
    :cond_2
    return-void

    .line 245
    .end local v1    # "pval":Ljava/lang/Boolean;
    :cond_3
    new-instance v2, Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    iget-object v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->activity:Landroid/app/Activity;

    invoke-direct {v2, v3}, Ltv/freewheel/renderers/html/MRAIDBackgroundView;-><init>(Landroid/app/Activity;)V

    iput-object v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->fullScreenBackgroundView:Ltv/freewheel/renderers/html/MRAIDBackgroundView;

    goto/16 :goto_0

    .line 263
    .restart local v1    # "pval":Ljava/lang/Boolean;
    :catch_0
    move-exception v2

    goto :goto_1
.end method

.method private injectScriptToHTML(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    .locals 6
    .param p1, "html"    # Ljava/lang/String;
    .param p2, "script"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 446
    iget-object v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "Inject script into html: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 447
    const-string v1, ""

    .line 448
    .local v1, "js":Ljava/lang/String;
    if-nez p2, :cond_0

    .line 449
    const-string p2, ""

    .line 451
    :cond_0
    iget-boolean v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->enableMRAID:Z

    if-eqz v3, :cond_1

    .line 452
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "(function(){window.mraid=new function(){this.expandProperties={width:0,height:0,useCustomClose:!1,isModal:!0};this.maxSize={width:0,height:0};this.screenSize={width:0,height:0};this.defaultPosition={x:0,y:0,width:0,height:0};this.currentPosition={x:0,y:0,width:0,height:0};this.supportsFeatures={sms:!1,tel:!1,calendar:!1,storePicture:!1,inlineVideo:!1};this.resizeProperties={};this.orientationProperties={allowOrientationChange:!0,forceOrientation:\"none\"};this.state=\"loading\";this.placementType=null; \nthis.listeners={};this.viewable=!0;this._Update=function(a,b,c,d,e,h,i,j,f,k){var g=this.state,l=b!=this.viewable,f=JSON.parse(f),m=f.width!=this.currentPosition.width||f.height!=this.currentPosition.height;this.state=a;this.viewable=b;this.placementType=c;this.expandProperties=JSON.parse(d);this.resizeProperties=JSON.parse(e);this.maxSize=JSON.parse(h);this.screenSize=JSON.parse(i);this.defaultPosition=JSON.parse(j);this.currentPosition=f;\"loading\"==g&&\"default\"==a&&this.dispatchEvent(\"ready\");l&& \nthis.dispatchEvent(\"viewableChange\",b);\"loading\"!=g&&\"hidden\"!=a&&m&&this.dispatchEvent(\"sizeChange\",f.width,f.height);(g!=a||\"resized\"==a&&\"resized\"==g&&k)&&this.dispatchEvent(\"stateChange\",a)};this._setSupportingFeatures=function(a,b,c,d,e){this.supportsFeatures={sms:a,tel:b,calendar:c,storePicture:d,inlineVideo:e}};this._log=function(a){try{FW_LOGGER.log(a)}catch(b){void 0!==window.console&&window.console.log(a+\", error:\"+b)}};this._debug=function(a){try{FW_LOGGER.debug(a)}catch(b){void 0!==window.console&& \nwindow.console.log(a+\", error:\"+b)}};this.addEventListener=function(a,b){void 0===this.listeners[a]&&(this.listeners[a]=[]);this.listeners[a].push(b)};this.removeEventListener=function(a,b){if(this.listeners[a]instanceof Array){var c=this.listeners[a],d,e;if(null!==c){e=c.length;for(d=0;d<e;d++)if(c[d]===b){c.splice(d,1);break}}}};this.dispatchEvent=function(a){if(void 0!==a&&this.listeners[a]instanceof Array){var b=this.listeners[a],c,d;d=b.length;for(c=0;c<d;c++)try{b[c]&&b[c].apply(this,Array.prototype.slice.call(arguments, \n1))}catch(e){this._debug(\"Exception in dispatchEvent:event=\"+a+\", exception=\"+e.toString())}}};this.onError=function(a,b){this._debug(\"onError: message=\"+a+\", action=\"+b)};this.open=function(a){try{FW_MRAID_RENDERER.mraidOpen(encodeURI(a.toString()))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"open\")}};this.close=function(){try{FW_MRAID_RENDERER.mraidClose()}catch(a){this.dispatchEvent(\"error\",\"\"+a,\"close\")}};this.useCustomClose=function(a){this.expandProperties.useCustomClose=!!a;try{FW_MRAID_RENDERER.mraidUseCustomClose(this.expandProperties.useCustomClose)}catch(b){this.dispatchEvent(\"error\", \n\"\"+b,\"close\")}};this.expand=function(a){try{void 0===a?FW_MRAID_RENDERER.mraidExpand():FW_MRAID_RENDERER.mraidExpand(encodeURI(a.toString()))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"expand\")}};this.setExpandProperties=function(a){this.expandProperties.width=\"undefined\"===typeof a||\"undefined\"===typeof a.width?0:Math.round(a.width);this.expandProperties.height=\"undefined\"===typeof a||\"undefined\"===typeof a.height?0:Math.round(a.height);this.expandProperties.useCustomClose=\"undefined\"===typeof a|| \n\"undefined\"===typeof a.useCustomClose?!1:!!a.useCustomClose;try{FW_MRAID_RENDERER.setExpandProperties(JSON.stringify(this.expandProperties))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"setExpandProperties\")}};this.detachBridgeInterface=function(){this.open=this.close=this.expand=this.setExpandProperties=function(){};this._log=this._debug=function(){}};this.getExpandProperties=function(){return this.expandProperties};this.isViewable=function(){return this.viewable};this.getState=function(){return this.state}; \nthis.getVersion=function(){return\"2.0\"};this.getPlacementType=function(){return this.placementType};this.createCalendarEvent=function(a){try{FW_MRAID_RENDERER.createCalendarEvent(JSON.stringify(a))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"createCalendarEvent\")}};this.getOrientationProperties=function(){return this.orientationProperties};this.setOrientationProperties=function(){this.dispatchEvent(\"error\",\"Not supported\",\"setOrientationProperties\")};this.getCurrentPosition=function(){return this.currentPosition}; \nthis.getDefaultPosition=function(){return this.defaultPosition};this.getMaxSize=function(){return this.maxSize};this.getResizeProperties=function(){return this.resizeProperties};this.setResizeProperties=function(a){if(\"undefined\"===typeof a||\"undefined\"===typeof a.width||\"undefined\"===typeof a.height||\"undefined\"===typeof a.offsetX||\"undefined\"===typeof a.offsetY)this.dispatchEvent(\"error\",\"Missing required parameters\",\"setResizeProperties\");else{this.resizeProperties.width=Math.round(a.width);this.resizeProperties.height= \nMath.round(a.height);this.resizeProperties.offsetX=Math.round(a.offsetX);this.resizeProperties.offsetY=Math.round(a.offsetY);this.resizeProperties.customClosePosition=\"undefined\"===typeof a.customClosePosition?\"top-right\":a.customClosePosition;this.resizeProperties.allowOffscreen=\"undefined\"!==typeof a.allowOffscreen&&!1===a.allowOffscreen?!1:!0;try{FW_MRAID_RENDERER.setResizeProperties(JSON.stringify(this.resizeProperties))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"setResizeProperties\")}}};this.resize= \nfunction(){try{FW_MRAID_RENDERER.mraidResize()}catch(a){this.dispatchEvent(\"error\",\"\"+a,\"resize\")}};this.getScreenSize=function(){return this.screenSize};this.playVideo=function(a){try{FW_MRAID_RENDERER.playVideo(encodeURI(a.toString()))}catch(b){this.dispatchEvent(\"error\",\"\"+b,\"playVideo\")}};this.storePicture=function(){this.dispatchEvent(\"error\",\"Not supported\",\"storePicture\")};this.supports=function(a){return!!this.supportsFeatures[a]};this.addEventListener(\"error\",this.onError)}})(); \n\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 454
    :cond_1
    iget-object v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v3}, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/renderers/html/Parameters;

    move-result-object v3

    iget-object v3, v3, Ltv/freewheel/renderers/html/Parameters;->bootstrap:Ljava/lang/String;

    if-eqz v3, :cond_2

    iget-object v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v3}, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/renderers/html/Parameters;

    move-result-object v3

    iget-object v3, v3, Ltv/freewheel/renderers/html/Parameters;->bootstrap:Ljava/lang/String;

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v3

    if-lez v3, :cond_2

    .line 455
    iget-object v3, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string v5, "bootstrap js code: "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v5}, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/renderers/html/Parameters;

    move-result-object v5

    iget-object v5, v5, Ltv/freewheel/renderers/html/Parameters;->bootstrap:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 456
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v4}, Ltv/freewheel/renderers/html/HTMLRenderer;->parameters()Ltv/freewheel/renderers/html/Parameters;

    move-result-object v4

    iget-object v4, v4, Ltv/freewheel/renderers/html/Parameters;->bootstrap:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 458
    :cond_2
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "<script type=\"text/javascript\">"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "</script>\n"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 460
    const-string v3, "<head>"

    invoke-virtual {p1, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 461
    .local v0, "insertPos":I
    if-gez v0, :cond_4

    .line 462
    const-string v3, "<script>"

    invoke-virtual {p1, v3}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v0

    .line 463
    if-gez v0, :cond_3

    move v0, v2

    .line 467
    :goto_0
    if-nez v0, :cond_5

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    :goto_1
    return-object v2

    .line 463
    :cond_3
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 465
    :cond_4
    add-int/lit8 v0, v0, 0x6

    goto :goto_0

    .line 467
    :cond_5
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1, v2, v0}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1, v0}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    goto :goto_1
.end method

.method private setBaseURL(Ljava/lang/String;)V
    .locals 7
    .param p1, "urlString"    # Ljava/lang/String;

    .prologue
    .line 364
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "setBaseURL("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 365
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v4

    if-nez v4, :cond_1

    .line 394
    :cond_0
    :goto_0
    return-void

    .line 367
    :cond_1
    invoke-static {p1}, Landroid/webkit/URLUtil;->isHttpUrl(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_2

    invoke-static {p1}, Landroid/webkit/URLUtil;->isHttpsUrl(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 370
    :cond_2
    const/4 v3, 0x0

    .line 372
    .local v3, "url":Ljava/net/URL;
    :try_start_0
    new-instance v3, Ljava/net/URL;

    .end local v3    # "url":Ljava/net/URL;
    invoke-direct {v3, p1}, Ljava/net/URL;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/MalformedURLException; {:try_start_0 .. :try_end_0} :catch_0

    .line 378
    .restart local v3    # "url":Ljava/net/URL;
    if-eqz v3, :cond_4

    invoke-virtual {v3}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 379
    invoke-virtual {v3}, Ljava/net/URL;->getProtocol()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    .line 380
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "://"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    .line 381
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v3}, Ljava/net/URL;->getAuthority()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_5

    invoke-virtual {v3}, Ljava/net/URL;->getAuthority()Ljava/lang/String;

    move-result-object v4

    :goto_1
    invoke-virtual {v5, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    .line 382
    invoke-virtual {v3}, Ljava/net/URL;->getPath()Ljava/lang/String;

    move-result-object v2

    .line 383
    .local v2, "path":Ljava/lang/String;
    if-nez v2, :cond_6

    .line 384
    const-string v2, ""

    .line 391
    :cond_3
    :goto_2
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "/"

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    iput-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    .line 393
    .end local v2    # "path":Ljava/lang/String;
    :cond_4
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "base url:"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    iget-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 373
    .end local v3    # "url":Ljava/net/URL;
    :catch_0
    move-exception v0

    .line 374
    .local v0, "e":Ljava/net/MalformedURLException;
    iget-object v4, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v0}, Ljava/net/MalformedURLException;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 381
    .end local v0    # "e":Ljava/net/MalformedURLException;
    .restart local v3    # "url":Ljava/net/URL;
    :cond_5
    const-string v4, ""

    goto :goto_1

    .line 386
    .restart local v2    # "path":Ljava/lang/String;
    :cond_6
    const-string v4, "/"

    invoke-virtual {v2, v4}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    .line 387
    .local v1, "idx":I
    if-ltz v1, :cond_3

    .line 388
    const/4 v4, 0x0

    invoke-virtual {v2, v4, v1}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    goto :goto_2
.end method

.method private declared-synchronized tryTriggerLoaded()V
    .locals 1

    .prologue
    .line 581
    monitor-enter p0

    :try_start_0
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->withLoadedCallBack:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->enableMRAID:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->pageLoaded:Z

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->pageShown:Z

    if-eqz v0, :cond_0

    .line 582
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->mraidLoaded()V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 584
    :cond_0
    monitor-exit p0

    return-void

    .line 581
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method


# virtual methods
.method URLWithBaseURL(Ljava/lang/String;)Ljava/lang/String;
    .locals 10
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v5, 0x0

    .line 398
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->length()I

    move-result v6

    if-nez v6, :cond_2

    .line 399
    :cond_0
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    .line 430
    :cond_1
    :goto_0
    return-object v5

    .line 400
    :cond_2
    iget-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    const-string v8, "URLWithBaseURL: url passed in: "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 401
    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object p1

    .line 403
    const/4 v3, 0x0

    .line 405
    .local v3, "uri":Ljava/net/URI;
    :try_start_0
    new-instance v4, Ljava/net/URI;

    invoke-direct {v4, p1}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Ljava/net/URISyntaxException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v3    # "uri":Ljava/net/URI;
    .local v4, "uri":Ljava/net/URI;
    move-object v3, v4

    .line 421
    .end local v4    # "uri":Ljava/net/URI;
    .restart local v3    # "uri":Ljava/net/URI;
    :goto_1
    if-eqz v3, :cond_1

    .line 423
    invoke-virtual {v3}, Ljava/net/URI;->isAbsolute()Z

    move-result v6

    if-eqz v6, :cond_4

    .line 424
    invoke-virtual {v3}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 406
    :catch_0
    move-exception v0

    .line 408
    .local v0, "e":Ljava/net/URISyntaxException;
    :try_start_1
    invoke-static {p1}, Ltv/freewheel/utils/URIUtil;->getFixedString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 411
    .local v2, "tmp":Ljava/lang/String;
    if-nez v2, :cond_3

    .line 413
    new-instance v6, Ljava/net/URI;

    const/4 v7, 0x0

    const/4 v8, 0x0

    const/4 v9, 0x0

    invoke-direct {v6, v7, v8, p1, v9}, Ljava/net/URI;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v2

    .line 415
    :cond_3
    new-instance v4, Ljava/net/URI;

    invoke-direct {v4, v2}, Ljava/net/URI;-><init>(Ljava/lang/String;)V
    :try_end_1
    .catch Ljava/net/URISyntaxException; {:try_start_1 .. :try_end_1} :catch_1

    .end local v3    # "uri":Ljava/net/URI;
    .restart local v4    # "uri":Ljava/net/URI;
    move-object v3, v4

    .line 418
    .end local v4    # "uri":Ljava/net/URI;
    .restart local v3    # "uri":Ljava/net/URI;
    goto :goto_1

    .line 416
    .end local v2    # "tmp":Ljava/lang/String;
    :catch_1
    move-exception v1

    .line 417
    .local v1, "f":Ljava/net/URISyntaxException;
    iget-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v1}, Ljava/net/URISyntaxException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_1

    .line 427
    .end local v0    # "e":Ljava/net/URISyntaxException;
    .end local v1    # "f":Ljava/net/URISyntaxException;
    :cond_4
    :try_start_2
    new-instance v6, Ljava/net/URL;

    new-instance v7, Ljava/net/URL;

    iget-object v8, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    invoke-direct {v7, v8}, Ljava/net/URL;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/net/URI;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-direct {v6, v7, v8}, Ljava/net/URL;-><init>(Ljava/net/URL;Ljava/lang/String;)V

    invoke-virtual {v6}, Ljava/net/URL;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/net/MalformedURLException; {:try_start_2 .. :try_end_2} :catch_2

    move-result-object v5

    goto :goto_0

    .line 428
    :catch_2
    move-exception v0

    .line 429
    .local v0, "e":Ljava/net/MalformedURLException;
    iget-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v0}, Ljava/net/MalformedURLException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public closeCustomView()V
    .locals 3

    .prologue
    .line 546
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v2, "closeCustomView"

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 548
    :try_start_0
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;

    if-eqz v1, :cond_0

    .line 549
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customVideoView:Landroid/widget/VideoView;

    invoke-virtual {v1}, Landroid/widget/VideoView;->stopPlayback()V

    .line 551
    :cond_0
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->customView:Landroid/view/View;

    if-eqz v1, :cond_1

    .line 552
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->webChromeClient:Landroid/webkit/WebChromeClient;

    invoke-virtual {v1}, Landroid/webkit/WebChromeClient;->onHideCustomView()V
    :try_end_0
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_0

    .line 557
    :cond_1
    :goto_0
    return-void

    .line 554
    :catch_0
    move-exception v0

    .line 555
    .local v0, "e":Ljava/lang/Throwable;
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v0}, Ljava/lang/Throwable;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public dispose()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 356
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "dispose"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 357
    invoke-virtual {p0, v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 358
    invoke-virtual {p0, v2}, Ltv/freewheel/renderers/html/MRAIDWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 359
    const-string v0, "window.mraid.detachBridgeInterface();"

    invoke-virtual {p0, v0}, Ltv/freewheel/renderers/html/MRAIDWebView;->runJavaScript(Ljava/lang/String;)V

    .line 360
    const-string v0, "about:blank"

    invoke-super {p0, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 361
    return-void
.end method

.method public loadCreativeWithScript(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "creativeUrl"    # Ljava/lang/String;
    .param p2, "creativeContent"    # Ljava/lang/String;
    .param p3, "script"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 535
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "load creative url: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " or content: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " with script:"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 537
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 538
    :cond_0
    invoke-direct {p0, p2, p3}, Ltv/freewheel/renderers/html/MRAIDWebView;->injectScriptToHTML(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 539
    .local v2, "htmlcontent":Ljava/lang/String;
    const-string v3, "text/html"

    const-string v4, "utf8"

    move-object v0, p0

    move-object v5, v1

    invoke-virtual/range {v0 .. v5}, Ltv/freewheel/renderers/html/MRAIDWebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 543
    .end local v2    # "htmlcontent":Ljava/lang/String;
    :goto_0
    return-void

    .line 541
    :cond_1
    new-instance v0, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;

    invoke-direct {v0, p0, v1}, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;-><init>(Ltv/freewheel/renderers/html/MRAIDWebView;Ltv/freewheel/renderers/html/MRAIDWebView$1;)V

    const/4 v1, 0x2

    new-array v1, v1, [Ljava/lang/String;

    const/4 v3, 0x0

    aput-object p1, v1, v3

    const/4 v3, 0x1

    aput-object p3, v1, v3

    invoke-virtual {v0, v1}, Ltv/freewheel/renderers/html/MRAIDWebView$downloadHTMLContentTask;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "baseUrl"    # Ljava/lang/String;
    .param p2, "data"    # Ljava/lang/String;
    .param p3, "mimeType"    # Ljava/lang/String;
    .param p4, "encoding"    # Ljava/lang/String;
    .param p5, "failUrl"    # Ljava/lang/String;

    .prologue
    .line 437
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "loadDataWithBaseURL"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 438
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v0

    if-nez v0, :cond_1

    .line 439
    :cond_0
    const-string p1, "http://m1.fwmrm.net/ad/mraid/start/"

    .line 441
    :cond_1
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "/"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->baseURL:Ljava/lang/String;

    .line 442
    invoke-super/range {p0 .. p5}, Landroid/webkit/WebView;->loadDataWithBaseURL(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 443
    return-void
.end method

.method protected onAttachedToWindow()V
    .locals 4

    .prologue
    .line 574
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v2, "onAttachedToWindow"

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 575
    invoke-super {p0}, Landroid/webkit/WebView;->onAttachedToWindow()V

    .line 576
    invoke-virtual {p0}, Ltv/freewheel/renderers/html/MRAIDWebView;->supportsInlineVideo()Z

    move-result v0

    .line 577
    .local v0, "flag":Z
    iget-object v1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Android API level "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget v3, Landroid/os/Build$VERSION;->SDK_INT:I

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ", hardware acceleration "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ltv/freewheel/utils/Logger;->info(Ljava/lang/String;)V

    .line 578
    return-void
.end method

.method public onCompletion(Landroid/media/MediaPlayer;)V
    .locals 2
    .param p1, "mp"    # Landroid/media/MediaPlayer;

    .prologue
    .line 130
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v1, "onCompletion ot the video"

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 131
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->webChromeClient:Landroid/webkit/WebChromeClient;

    invoke-virtual {v0}, Landroid/webkit/WebChromeClient;->onHideCustomView()V

    .line 132
    return-void
.end method

.method public onError(Landroid/media/MediaPlayer;II)Z
    .locals 3
    .param p1, "mp"    # Landroid/media/MediaPlayer;
    .param p2, "what"    # I
    .param p3, "extra"    # I

    .prologue
    .line 136
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onError ot the video what="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ",extra="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 137
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->webChromeClient:Landroid/webkit/WebChromeClient;

    invoke-virtual {v0}, Landroid/webkit/WebChromeClient;->onHideCustomView()V

    .line 138
    const/4 v0, 0x0

    return v0
.end method

.method public onKeyDown(ILandroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "keyCode"    # I
    .param p2, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 561
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "onKeyDown,keyCode:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ", isFullScreen:"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-boolean v2, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->isFullScreen:Z

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 562
    iget-boolean v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->isFullScreen:Z

    if-nez v0, :cond_0

    .line 563
    const/4 v0, 0x0

    .line 569
    :goto_0
    return v0

    .line 565
    :cond_0
    const/4 v0, 0x4

    if-ne p1, v0, :cond_1

    .line 566
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->bridge:Ltv/freewheel/renderers/html/HTMLRenderer;

    invoke-virtual {v0}, Ltv/freewheel/renderers/html/HTMLRenderer;->mraidClose()V

    .line 567
    const/4 v0, 0x1

    goto :goto_0

    .line 569
    :cond_1
    invoke-super {p0, p1, p2}, Landroid/webkit/WebView;->onKeyDown(ILandroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public runJavaScript(Ljava/lang/String;)V
    .locals 3
    .param p1, "script"    # Ljava/lang/String;

    .prologue
    .line 342
    iget-object v0, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "runJavaScript("

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, ")"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 343
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->length()I

    move-result v0

    if-eqz v0, :cond_0

    .line 344
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "javascript:"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-super {p0, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 345
    :cond_0
    return-void
.end method

.method setFullScreen(Z)V
    .locals 0
    .param p1, "isFullScreen"    # Z

    .prologue
    .line 64
    iput-boolean p1, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->isFullScreen:Z

    .line 65
    return-void
.end method

.method public supportsInlineVideo()Z
    .locals 8

    .prologue
    .line 90
    sget v5, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v6, 0xb

    if-ge v5, v6, :cond_0

    .line 91
    const/4 v3, 0x0

    .line 125
    :goto_0
    return v3

    .line 94
    :cond_0
    const/4 v1, 0x0

    .line 95
    .local v1, "description":Ljava/lang/String;
    const/4 v3, 0x0

    .line 97
    .local v3, "isInAccel":Z
    :try_start_0
    invoke-virtual {p0}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v6

    const-string v7, "isHardwareAccelerated"

    const/4 v5, 0x0

    check-cast v5, [Ljava/lang/Class;

    invoke-virtual {v6, v7, v5}, Ljava/lang/Class;->getMethod(Ljava/lang/String;[Ljava/lang/Class;)Ljava/lang/reflect/Method;
    :try_end_0
    .catch Ljava/lang/SecurityException; {:try_start_0 .. :try_end_0} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_0 .. :try_end_0} :catch_4
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result-object v0

    .line 99
    .local v0, "accel":Ljava/lang/reflect/Method;
    const/4 v5, 0x0

    :try_start_1
    check-cast v5, [Ljava/lang/Object;

    invoke-virtual {v0, p0, v5}, Ljava/lang/reflect/Method;->invoke(Ljava/lang/Object;[Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    .line 100
    .local v4, "retObj":Ljava/lang/Object;
    instance-of v5, v4, Ljava/lang/Boolean;

    if-eqz v5, :cond_1

    .line 101
    check-cast v4, Ljava/lang/Boolean;

    .end local v4    # "retObj":Ljava/lang/Object;
    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z
    :try_end_1
    .catch Ljava/lang/IllegalArgumentException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/IllegalAccessException; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/reflect/InvocationTargetException; {:try_start_1 .. :try_end_1} :catch_2
    .catch Ljava/lang/SecurityException; {:try_start_1 .. :try_end_1} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_1 .. :try_end_1} :catch_4
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    move-result v3

    .line 115
    :cond_1
    :goto_1
    if-eqz v1, :cond_2

    .line 116
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v5, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 118
    :cond_2
    if-eqz v3, :cond_3

    .line 119
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v6, "using HardWare Acceleration"

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 103
    :catch_0
    move-exception v2

    .line 104
    .local v2, "e":Ljava/lang/IllegalArgumentException;
    :try_start_2
    invoke-virtual {v2}, Ljava/lang/IllegalArgumentException;->toString()Ljava/lang/String;

    move-result-object v1

    .line 109
    goto :goto_1

    .line 105
    .end local v2    # "e":Ljava/lang/IllegalArgumentException;
    :catch_1
    move-exception v2

    .line 106
    .local v2, "e":Ljava/lang/IllegalAccessException;
    invoke-virtual {v2}, Ljava/lang/IllegalAccessException;->toString()Ljava/lang/String;

    move-result-object v1

    .line 109
    goto :goto_1

    .line 107
    .end local v2    # "e":Ljava/lang/IllegalAccessException;
    :catch_2
    move-exception v2

    .line 108
    .local v2, "e":Ljava/lang/reflect/InvocationTargetException;
    invoke-virtual {v2}, Ljava/lang/reflect/InvocationTargetException;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/SecurityException; {:try_start_2 .. :try_end_2} :catch_3
    .catch Ljava/lang/NoSuchMethodException; {:try_start_2 .. :try_end_2} :catch_4
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    move-result-object v1

    goto :goto_1

    .line 121
    .end local v2    # "e":Ljava/lang/reflect/InvocationTargetException;
    :cond_3
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v6, "No HardWare Acceleration, the inline video is not supported"

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 110
    .end local v0    # "accel":Ljava/lang/reflect/Method;
    :catch_3
    move-exception v2

    .line 111
    .local v2, "e":Ljava/lang/SecurityException;
    :try_start_3
    invoke-virtual {v2}, Ljava/lang/SecurityException;->toString()Ljava/lang/String;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    move-result-object v1

    .line 115
    if-eqz v1, :cond_4

    .line 116
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v5, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 118
    :cond_4
    if-eqz v3, :cond_5

    .line 119
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v6, "using HardWare Acceleration"

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 121
    :cond_5
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v6, "No HardWare Acceleration, the inline video is not supported"

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_0

    .line 112
    .end local v2    # "e":Ljava/lang/SecurityException;
    :catch_4
    move-exception v2

    .line 113
    .local v2, "e":Ljava/lang/NoSuchMethodException;
    :try_start_4
    invoke-virtual {v2}, Ljava/lang/NoSuchMethodException;->toString()Ljava/lang/String;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    move-result-object v1

    .line 115
    if-eqz v1, :cond_6

    .line 116
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v5, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 118
    :cond_6
    if-eqz v3, :cond_7

    .line 119
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v6, "using HardWare Acceleration"

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    goto :goto_0

    .line 121
    :cond_7
    iget-object v5, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v6, "No HardWare Acceleration, the inline video is not supported"

    invoke-virtual {v5, v6}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 115
    .end local v2    # "e":Ljava/lang/NoSuchMethodException;
    :catchall_0
    move-exception v5

    if-eqz v1, :cond_8

    .line 116
    iget-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    invoke-virtual {v6, v1}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 118
    :cond_8
    if-eqz v3, :cond_9

    .line 119
    iget-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v7, "using HardWare Acceleration"

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->debug(Ljava/lang/String;)V

    .line 121
    :goto_2
    throw v5

    :cond_9
    iget-object v6, p0, Ltv/freewheel/renderers/html/MRAIDWebView;->logger:Ltv/freewheel/utils/Logger;

    const-string v7, "No HardWare Acceleration, the inline video is not supported"

    invoke-virtual {v6, v7}, Ltv/freewheel/utils/Logger;->warn(Ljava/lang/String;)V

    goto :goto_2
.end method
