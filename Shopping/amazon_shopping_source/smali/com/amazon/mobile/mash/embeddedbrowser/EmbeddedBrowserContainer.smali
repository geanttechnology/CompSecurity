.class public Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;
.super Landroid/widget/FrameLayout;
.source "EmbeddedBrowserContainer.java"


# static fields
.field protected static final TAG:Ljava/lang/String;


# instance fields
.field private mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

.field private mShouldShowOpenExternalButton:Z

.field private mShouldShowRefreshButton:Z

.field private mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 36
    const-class v0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->TAG:Ljava/lang/String;

    return-void
.end method

.method public constructor <init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;)V
    .locals 9
    .param p1, "activity"    # Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    .prologue
    const/4 v7, 0x1

    const/4 v8, -0x1

    .line 60
    invoke-direct {p0, p1}, Landroid/widget/FrameLayout;-><init>(Landroid/content/Context;)V

    .line 61
    iput-object p1, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    .line 62
    invoke-direct {p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->initalizeWebView()V

    .line 65
    iget-object v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    .line 66
    .local v0, "intent":Landroid/content/Intent;
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 67
    .local v3, "targetUrl":Ljava/lang/String;
    const-string/jumbo v6, "method"

    invoke-virtual {v0, v6}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 68
    .local v1, "method":Ljava/lang/String;
    const-string/jumbo v6, "postParams"

    invoke-virtual {v0, v6}, Landroid/content/Intent;->getByteArrayExtra(Ljava/lang/String;)[B

    move-result-object v2

    .line 69
    .local v2, "postDataByteArray":[B
    const-string/jumbo v6, "showActionButton"

    invoke-virtual {v0, v6, v7}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v6

    iput-boolean v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mShouldShowOpenExternalButton:Z

    .line 70
    const-string/jumbo v6, "showRefreshButton"

    invoke-virtual {v0, v6, v7}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v6

    iput-boolean v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mShouldShowRefreshButton:Z

    .line 72
    const-string/jumbo v6, "GET"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_1

    .line 73
    iget-object v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v6, v3}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->loadUrl(Ljava/lang/String;)V

    .line 78
    :cond_0
    :goto_0
    iget-object v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    invoke-virtual {v6}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v6

    sget v7, Lcom/amazon/mobile/mash/R$layout;->embedded_browser_container:I

    invoke-virtual {v6, v7, p0}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v4

    .line 80
    .local v4, "webViewLayout":Landroid/view/View;
    new-instance v5, Landroid/widget/RelativeLayout$LayoutParams;

    invoke-direct {v5, v8, v8}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    .line 82
    .local v5, "wrp":Landroid/widget/RelativeLayout$LayoutParams;
    iget-object v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v6, v5}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 83
    sget v6, Lcom/amazon/mobile/mash/R$id;->webview_container:I

    invoke-virtual {v4, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/view/ViewGroup;

    iget-object v7, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v6, v7}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 85
    invoke-direct {p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->initializeButtons()V

    .line 86
    iget-object v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-direct {p0, v6}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->updateNavigationButtons(Lcom/amazon/mobile/mash/MASHWebView;)V

    .line 87
    return-void

    .line 74
    .end local v4    # "webViewLayout":Landroid/view/View;
    .end local v5    # "wrp":Landroid/widget/RelativeLayout$LayoutParams;
    :cond_1
    const-string/jumbo v6, "POST"

    invoke-virtual {v6, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 75
    iget-object v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v6, v3, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->postUrl(Ljava/lang/String;[B)V

    goto :goto_0
.end method

.method static synthetic access$000(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;Lcom/amazon/mobile/mash/MASHWebView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;
    .param p1, "x1"    # Lcom/amazon/mobile/mash/MASHWebView;

    .prologue
    .line 31
    invoke-direct {p0, p1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->updateNavigationButtons(Lcom/amazon/mobile/mash/MASHWebView;)V

    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    .prologue
    .line 31
    iget-boolean v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mShouldShowRefreshButton:Z

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    return-object v0
.end method

.method private initalizeWebView()V
    .locals 7

    .prologue
    const/4 v4, 0x0

    .line 93
    new-instance v0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    iget-object v1, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    invoke-direct {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    .line 95
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    new-instance v1, Lcom/amazon/mobile/mash/MASHWebChromeClient;

    iget-object v2, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    iget-object v3, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-direct {v1, v2, v3}, Lcom/amazon/mobile/mash/MASHWebChromeClient;-><init>(Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/MASHWebView;)V

    invoke-virtual {v0, v1}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->setWebChromeClient(Lorg/apache/cordova/CordovaChromeClient;)V

    .line 97
    iget-object v6, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    new-instance v0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;

    iget-object v2, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mActivity:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserActivity;

    iget-object v3, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    move-object v1, p0

    move-object v5, v4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$1;-><init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;Lorg/apache/cordova/CordovaInterface;Lcom/amazon/mobile/mash/MASHWebView;Lcom/amazon/mobile/mash/nav/MASHNavDelegate;Lcom/amazon/mobile/mash/interception/MASHUrlIntercepter;)V

    invoke-virtual {v6, v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->setWebViewClient(Lorg/apache/cordova/CordovaWebViewClient;)V

    .line 116
    return-void
.end method

.method private initializeButtons()V
    .locals 5

    .prologue
    const/16 v4, 0x8

    .line 151
    sget v2, Lcom/amazon/mobile/mash/R$id;->back_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$2;

    invoke-direct {v3, p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$2;-><init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 159
    sget v2, Lcom/amazon/mobile/mash/R$id;->forward_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$3;

    invoke-direct {v3, p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$3;-><init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 167
    sget v2, Lcom/amazon/mobile/mash/R$id;->done_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$4;

    invoke-direct {v3, p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$4;-><init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 174
    sget v2, Lcom/amazon/mobile/mash/R$id;->refresh_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 175
    .local v1, "refreshButton":Landroid/widget/ImageButton;
    iget-boolean v2, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mShouldShowRefreshButton:Z

    if-eqz v2, :cond_0

    .line 176
    new-instance v2, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$5;

    invoke-direct {v2, p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$5;-><init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)V

    invoke-virtual {v1, v2}, Landroid/widget/ImageButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 186
    :goto_0
    sget v2, Lcom/amazon/mobile/mash/R$id;->open_in_external_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 187
    .local v0, "openExternalButton":Landroid/widget/ImageButton;
    iget-boolean v2, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mShouldShowOpenExternalButton:Z

    if-eqz v2, :cond_1

    .line 188
    sget v2, Lcom/amazon/mobile/mash/R$id;->open_in_external_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v2

    new-instance v3, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$6;

    invoke-direct {v3, p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer$6;-><init>(Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 197
    :goto_1
    return-void

    .line 183
    .end local v0    # "openExternalButton":Landroid/widget/ImageButton;
    :cond_0
    invoke-virtual {v1, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_0

    .line 195
    .restart local v0    # "openExternalButton":Landroid/widget/ImageButton;
    :cond_1
    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setVisibility(I)V

    goto :goto_1
.end method

.method private updateNavigationButtons(Lcom/amazon/mobile/mash/MASHWebView;)V
    .locals 5
    .param p1, "view"    # Lcom/amazon/mobile/mash/MASHWebView;

    .prologue
    const/16 v4, 0xff

    const/16 v3, 0x66

    .line 205
    sget v2, Lcom/amazon/mobile/mash/R$id;->back_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageButton;

    .line 206
    .local v0, "backButton":Landroid/widget/ImageButton;
    sget v2, Lcom/amazon/mobile/mash/R$id;->forward_button:I

    invoke-virtual {p0, v2}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageButton;

    .line 208
    .local v1, "forwardButton":Landroid/widget/ImageButton;
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/MASHWebView;->canGoBack()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 209
    invoke-virtual {v0, v4}, Landroid/widget/ImageButton;->setAlpha(I)V

    .line 213
    :goto_0
    invoke-virtual {p1}, Lcom/amazon/mobile/mash/MASHWebView;->canGoForward()Z

    move-result v2

    if-eqz v2, :cond_1

    .line 214
    invoke-virtual {v1, v4}, Landroid/widget/ImageButton;->setAlpha(I)V

    .line 218
    :goto_1
    return-void

    .line 211
    :cond_0
    invoke-virtual {v0, v3}, Landroid/widget/ImageButton;->setAlpha(I)V

    goto :goto_0

    .line 216
    :cond_1
    invoke-virtual {v1, v3}, Landroid/widget/ImageButton;->setAlpha(I)V

    goto :goto_1
.end method


# virtual methods
.method public destroy()V
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->destroy()V

    .line 225
    return-void
.end method

.method public goBack()Z
    .locals 1

    .prologue
    .line 124
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->canGoBack()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 125
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->goBack()V

    .line 126
    const/4 v0, 0x1

    .line 128
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public handleOnPause()V
    .locals 1

    .prologue
    .line 136
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->pauseTimers()V

    .line 137
    return-void
.end method

.method public handleOnResume()V
    .locals 1

    .prologue
    .line 144
    iget-object v0, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->resumeTimers()V

    .line 145
    return-void
.end method

.method public openInExternalBrowser()V
    .locals 7

    .prologue
    .line 233
    iget-object v4, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    .line 234
    .local v1, "currentUrl":Ljava/lang/String;
    if-nez v1, :cond_1

    .line 235
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_0

    .line 236
    const-string/jumbo v3, "The current URL is null. Reverting to the original URL for external browser."

    .line 237
    .local v3, "msg":Ljava/lang/String;
    sget-object v4, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "The current URL is null. Reverting to the original URL for external browser."

    invoke-static {v4, v5}, Landroid/util/Log;->w(Ljava/lang/String;Ljava/lang/String;)I

    .line 239
    .end local v3    # "msg":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->mWebView:Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;

    invoke-virtual {v4}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserWebView;->getOriginalUrl()Ljava/lang/String;

    move-result-object v1

    .line 241
    :cond_1
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 242
    const-string/jumbo v1, "about:blank"

    .line 244
    :cond_2
    invoke-static {}, Lcom/amazon/mobile/mash/util/MASHDebug;->isEnabled()Z

    move-result v4

    if-eqz v4, :cond_3

    .line 245
    sget-object v4, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->TAG:Ljava/lang/String;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "Launching intent for external browser for url: "

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v4, v5}, Landroid/util/Log;->i(Ljava/lang/String;Ljava/lang/String;)I

    .line 247
    :cond_3
    new-instance v0, Landroid/content/Intent;

    const-string/jumbo v4, "android.intent.action.VIEW"

    invoke-static {v1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v5

    invoke-direct {v0, v4, v5}, Landroid/content/Intent;-><init>(Ljava/lang/String;Landroid/net/Uri;)V

    .line 248
    .local v0, "actionIntent":Landroid/content/Intent;
    const/high16 v4, 0x10000000

    invoke-virtual {v0, v4}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 250
    :try_start_0
    invoke-virtual {p0}, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4, v0}, Landroid/content/Context;->startActivity(Landroid/content/Intent;)V
    :try_end_0
    .catch Landroid/content/ActivityNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 254
    :goto_0
    return-void

    .line 251
    :catch_0
    move-exception v2

    .line 252
    .local v2, "e":Landroid/content/ActivityNotFoundException;
    sget-object v4, Lcom/amazon/mobile/mash/embeddedbrowser/EmbeddedBrowserContainer;->TAG:Ljava/lang/String;

    const-string/jumbo v5, "Could not launch intent for url"

    invoke-static {v4, v5}, Landroid/util/Log;->e(Ljava/lang/String;Ljava/lang/String;)I

    goto :goto_0
.end method
