.class public Lcom/amazon/mShop/AmazonBrandedWebView;
.super Landroid/widget/LinearLayout;
.source "AmazonBrandedWebView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;,
        Lcom/amazon/mShop/AmazonBrandedWebView$DialogDismisser;,
        Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;
    }
.end annotation


# instance fields
.field private final mDialog:Lcom/amazon/mShop/AmazonProgressDialog;

.field private mIsAttachedToWindow:Z

.field private mIsReceivedError:Z

.field private mPageStartCount:I

.field private mTitle:Ljava/lang/String;

.field private final mWebView:Landroid/webkit/WebView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "_title"    # Ljava/lang/String;

    .prologue
    .line 53
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, p3, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;-><init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V

    .line 54
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 5
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "url"    # Ljava/lang/String;
    .param p3, "_title"    # Ljava/lang/String;
    .param p4, "updateTitle"    # Z
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "SetJavaScriptEnabled"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 64
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 48
    iput-boolean v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mIsReceivedError:Z

    .line 159
    iput-boolean v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mIsAttachedToWindow:Z

    .line 65
    iput-object p3, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mTitle:Ljava/lang/String;

    .line 67
    invoke-virtual {p0, v3}, Lcom/amazon/mShop/AmazonBrandedWebView;->setOrientation(I)V

    .line 68
    invoke-static {}, Lcom/amazon/mShop/util/LayoutUtils;->fillBoth()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 70
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/AmazonBrandedWebView;->initializeBrandedWebViewCookie(Landroid/content/Context;)V

    .line 72
    new-instance v0, Landroid/webkit/WebView;

    invoke-direct {v0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-static {}, Lcom/amazon/mShop/util/LayoutUtils;->fillBoth()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 74
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;

    invoke-direct {v1, p0, v4}, Lcom/amazon/mShop/AmazonBrandedWebView$MyWebViewClient;-><init>(Lcom/amazon/mShop/AmazonBrandedWebView;Lcom/amazon/mShop/AmazonBrandedWebView$1;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 75
    if-eqz p4, :cond_0

    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;

    invoke-direct {v1, p0, v4}, Lcom/amazon/mShop/AmazonBrandedWebView$DefaultWebChromeClient;-><init>(Lcom/amazon/mShop/AmazonBrandedWebView;Lcom/amazon/mShop/AmazonBrandedWebView$1;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 79
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0, v2}, Landroid/webkit/WebView;->setScrollBarStyle(I)V

    .line 80
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;->addView(Landroid/view/View;)V

    .line 82
    new-instance v0, Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-direct {v0, p1}, Lcom/amazon/mShop/AmazonProgressDialog;-><init>(Landroid/content/Context;)V

    iput-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->web_view_loading:I

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonProgressDialog;->setTitle(I)V

    .line 85
    iput v2, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mPageStartCount:I

    .line 87
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0, p2}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v0}, Landroid/webkit/WebView;->requestFocus()Z

    .line 92
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    const/16 v1, 0x82

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->requestFocus(I)Z

    .line 93
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    new-instance v1, Lcom/amazon/mShop/AmazonBrandedWebView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/AmazonBrandedWebView$1;-><init>(Lcom/amazon/mShop/AmazonBrandedWebView;)V

    invoke-virtual {v0, v1}, Landroid/webkit/WebView;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 107
    return-void
.end method

.method static synthetic access$200(Lcom/amazon/mShop/AmazonBrandedWebView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;

    .prologue
    .line 43
    iget v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mPageStartCount:I

    return v0
.end method

.method static synthetic access$204(Lcom/amazon/mShop/AmazonBrandedWebView;)I
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;

    .prologue
    .line 43
    iget v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mPageStartCount:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mPageStartCount:I

    return v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/AmazonBrandedWebView;)Lcom/amazon/mShop/AmazonProgressDialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/AmazonBrandedWebView;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mIsReceivedError:Z

    return v0
.end method

.method static synthetic access$502(Lcom/amazon/mShop/AmazonBrandedWebView;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;
    .param p1, "x1"    # Z

    .prologue
    .line 43
    iput-boolean p1, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mIsReceivedError:Z

    return p1
.end method

.method static synthetic access$602(Lcom/amazon/mShop/AmazonBrandedWebView;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/AmazonBrandedWebView;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 43
    iput-object p1, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mTitle:Ljava/lang/String;

    return-object p1
.end method


# virtual methods
.method public dismissDialogIfShowing()V
    .locals 1

    .prologue
    .line 182
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 183
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mDialog:Lcom/amazon/mShop/AmazonProgressDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonProgressDialog;->dismiss()V

    .line 185
    :cond_0
    return-void
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 5
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x1

    .line 134
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonBrandedWebView;->getContext()Landroid/content/Context;

    move-result-object v1

    .line 135
    .local v1, "context":Landroid/content/Context;
    instance-of v3, v1, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v3, :cond_0

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    .end local v1    # "context":Landroid/content/Context;
    invoke-virtual {v1, p1}, Lcom/amazon/mShop/AmazonActivity;->menuDispatchedKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 155
    :goto_0
    return v2

    .line 139
    :cond_0
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v3

    const/4 v4, 0x4

    if-ne v3, v4, :cond_2

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v3

    if-nez v3, :cond_2

    .line 140
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonBrandedWebView;->dismissDialogIfShowing()V

    .line 141
    iget-object v3, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 146
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonBrandedWebView;->getContext()Landroid/content/Context;

    move-result-object v3

    instance-of v3, v3, Lcom/amazon/mShop/AmazonActivity;

    if-eqz v3, :cond_1

    .line 147
    invoke-virtual {p0}, Lcom/amazon/mShop/AmazonBrandedWebView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 148
    .local v0, "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->clearErrorOnView(Landroid/view/View;)V

    .line 149
    iget-object v3, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/webkit/WebView;->setVisibility(I)V

    .line 151
    .end local v0    # "amazonActivity":Lcom/amazon/mShop/AmazonActivity;
    :cond_1
    iget-object v3, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mWebView:Landroid/webkit/WebView;

    invoke-virtual {v3}, Landroid/webkit/WebView;->goBack()V

    goto :goto_0

    .line 155
    :cond_2
    invoke-super {p0, p1}, Landroid/widget/LinearLayout;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v2

    goto :goto_0
.end method

.method public getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 116
    iget-object v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mTitle:Ljava/lang/String;

    return-object v0
.end method

.method public initializeBrandedWebViewCookie(Landroid/content/Context;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 188
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {}, Lcom/amazon/mShop/platform/AndroidPlatform;->getInstance()Lcom/amazon/mShop/platform/AndroidPlatform;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/platform/AndroidPlatform;->getApplicationVersion()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, "/"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-static {p1}, Lcom/amazon/mShop/util/BuildUtils;->getRevisionNumber(Landroid/content/Context;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 189
    .local v0, "amazonCookie":Ljava/lang/String;
    const/4 v2, 0x1

    invoke-static {p1, v2}, Lcom/amazon/mShop/net/CookieBridge;->getCookieDomain(Landroid/content/Context;Z)Ljava/lang/String;

    move-result-object v1

    .line 190
    .local v1, "domain":Ljava/lang/String;
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v4, "www"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v5, "amzn-app-id="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, "; Domain="

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v2, v3, v4}, Landroid/webkit/CookieManager;->setCookie(Ljava/lang/String;Ljava/lang/String;)V

    .line 191
    return-void
.end method

.method public isAttachedToWindow()Z
    .locals 1

    .prologue
    .line 162
    iget-boolean v0, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mIsAttachedToWindow:Z

    return v0
.end method

.method protected onAttachedToWindow()V
    .locals 1

    .prologue
    .line 171
    invoke-super {p0}, Landroid/widget/LinearLayout;->onAttachedToWindow()V

    .line 172
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;->setAttachedtoWindow(Z)V

    .line 173
    return-void
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 177
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 178
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/AmazonBrandedWebView;->setAttachedtoWindow(Z)V

    .line 179
    return-void
.end method

.method public setAttachedtoWindow(Z)V
    .locals 0
    .param p1, "isAttached"    # Z

    .prologue
    .line 166
    iput-boolean p1, p0, Lcom/amazon/mShop/AmazonBrandedWebView;->mIsAttachedToWindow:Z

    .line 167
    return-void
.end method
