.class public Lcom/bestbuy/android/bbyobjects/BBYWebView;
.super Landroid/webkit/WebView;
.source "SourceFile"

# interfaces
.implements Landroid/webkit/GeolocationPermissions$Callback;


# instance fields
.field public a:Landroid/webkit/GeolocationPermissions$Callback;

.field b:Landroid/webkit/WebChromeClient;

.field c:Landroid/webkit/WebViewClient;

.field private d:Landroid/app/Activity;

.field private e:Lkj;

.field private f:Landroid/view/View;

.field private g:Lnu;

.field private h:Landroid/content/res/Resources;

.field private i:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

.field private j:Z

.field private k:Z

.field private l:Z

.field private m:Ljava/lang/String;

.field private n:Lnb;

.field private o:Z


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/mdot/MdotWebFragment;Landroid/view/View;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 76
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 58
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a:Landroid/webkit/GeolocationPermissions$Callback;

    .line 63
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->j:Z

    .line 64
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->k:Z

    .line 65
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->l:Z

    .line 68
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->o:Z

    .line 116
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$1;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView;)V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b:Landroid/webkit/WebChromeClient;

    .line 180
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView;)V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->c:Landroid/webkit/WebViewClient;

    .line 77
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    .line 78
    iput-object p2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->i:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 79
    iput-object p3, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    .line 80
    invoke-direct {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b()V

    .line 81
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/mdot/MdotWebFragment;Landroid/view/View;Z)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 84
    invoke-direct {p0, p1}, Landroid/webkit/WebView;-><init>(Landroid/content/Context;)V

    .line 58
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a:Landroid/webkit/GeolocationPermissions$Callback;

    .line 63
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->j:Z

    .line 64
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->k:Z

    .line 65
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->l:Z

    .line 68
    iput-boolean v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->o:Z

    .line 116
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$1;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView;)V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b:Landroid/webkit/WebChromeClient;

    .line 180
    new-instance v0, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$2;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView;)V

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->c:Landroid/webkit/WebViewClient;

    .line 85
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    .line 86
    iput-object p2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->i:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    .line 87
    iput-object p3, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    .line 88
    iput-boolean p4, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->l:Z

    .line 89
    invoke-direct {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b()V

    .line 90
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/bbyobjects/BBYWebView;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 600
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->loadUrl(Ljava/lang/String;)V

    .line 601
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z
    .locals 0

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->j:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/view/View;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    return-object v0
.end method

.method private b()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 93
    const-string v0, "http.agent"

    invoke-static {v0}, Ljava/lang/System;->getProperty(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 94
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h:Landroid/content/res/Resources;

    .line 95
    invoke-virtual {p0, v4}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setScrollBarStyle(I)V

    .line 96
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/webkit/WebSettings;->setJavaScriptEnabled(Z)V

    .line 97
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/webkit/WebSettings;->setDomStorageEnabled(Z)V

    .line 98
    new-instance v1, Lnu;

    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    iget-boolean v3, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->l:Z

    invoke-direct {v1, v2, p0, v3}, Lnu;-><init>(Landroid/content/Context;Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)V

    iput-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->g:Lnu;

    .line 99
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->g:Lnu;

    const-string v2, "BBYWebViewJavaScriptInterface"

    invoke-virtual {p0, v1, v2}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->addJavascriptInterface(Ljava/lang/Object;Ljava/lang/String;)V

    .line 100
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/webkit/WebSettings;->setJavaScriptCanOpenWindowsAutomatically(Z)V

    .line 101
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, v4}, Landroid/webkit/WebSettings;->setSupportMultipleWindows(Z)V

    .line 102
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    invoke-virtual {v1, v5}, Landroid/webkit/WebSettings;->setGeolocationEnabled(Z)V

    .line 103
    invoke-virtual {p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "Mozilla/5.0 (Linux; U; Android 4.2.2; en-us; google_sdk Build/JB_MR1.1) AppleWebKit/534.30 (KHTML, like Gecko) Version/4.0 Mobile Safari/534.30"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 104
    const/high16 v0, 0x2000000

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setScrollBarStyle(I)V

    .line 105
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->c:Landroid/webkit/WebViewClient;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setWebViewClient(Landroid/webkit/WebViewClient;)V

    .line 106
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b:Landroid/webkit/WebChromeClient;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setWebChromeClient(Landroid/webkit/WebChromeClient;)V

    .line 107
    invoke-virtual {p0, v4}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setVisibility(I)V

    .line 108
    iput-boolean v4, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->k:Z

    .line 109
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->n:Lnb;

    .line 110
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/bbyobjects/BBYWebView;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 55
    invoke-direct {p0, p1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->b(Ljava/lang/String;)V

    return-void
.end method

.method private b(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 626
    new-instance v0, Lkr;

    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    invoke-direct {v0, v1, p1}, Lkr;-><init>(Landroid/content/Context;Ljava/lang/String;)V

    .line 627
    invoke-virtual {v0}, Lkr;->a()V

    .line 628
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z
    .locals 0

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->k:Z

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/bbyobjects/BBYWebView;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 55
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->m:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic c(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z
    .locals 1

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->l:Z

    return v0
.end method

.method static synthetic c(Lcom/bestbuy/android/bbyobjects/BBYWebView;Z)Z
    .locals 0

    .prologue
    .line 55
    iput-boolean p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->o:Z

    return p1
.end method

.method static synthetic d(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lcom/bestbuy/android/activities/mdot/MdotWebFragment;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->i:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z
    .locals 1

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->k:Z

    return v0
.end method

.method static synthetic f(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z
    .locals 1

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->j:Z

    return v0
.end method

.method static synthetic g(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Landroid/content/res/Resources;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->h:Landroid/content/res/Resources;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnu;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->g:Lnu;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Lnb;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->n:Lnb;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Z
    .locals 1

    .prologue
    .line 55
    iget-boolean v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->o:Z

    return v0
.end method

.method static synthetic k(Lcom/bestbuy/android/bbyobjects/BBYWebView;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 55
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->m:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a()Landroid/view/View;
    .locals 1

    .prologue
    .line 604
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    return-object v0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;)V
    .locals 8

    .prologue
    const/4 v3, 0x0

    const/4 v1, 0x1

    .line 619
    new-instance v7, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;

    invoke-direct {v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragmentContainer;-><init>()V

    .line 620
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "PLP"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuList()Ljava/util/ArrayList;

    move-result-object v4

    const/16 v6, 0x14

    move-object v5, v3

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V

    .line 621
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->i:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v2, v7, v1}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 622
    invoke-virtual {v7, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 623
    return-void
.end method

.method public invoke(Ljava/lang/String;ZZ)V
    .locals 0

    .prologue
    .line 597
    return-void
.end method

.method protected onOverScrolled(IIZZ)V
    .locals 1

    .prologue
    .line 156
    if-nez p2, :cond_0

    if-eqz p4, :cond_0

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->e:Lkj;

    invoke-interface {v0, p1, p2}, Lkj;->a(II)V

    .line 159
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebView;->onOverScrolled(IIZZ)V

    .line 160
    return-void
.end method

.method protected onScrollChanged(IIII)V
    .locals 1

    .prologue
    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->e:Lkj;

    if-eqz v0, :cond_0

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->e:Lkj;

    invoke-interface {v0, p1, p2}, Lkj;->a(II)V

    .line 167
    :cond_0
    invoke-super {p0, p1, p2, p3, p4}, Landroid/webkit/WebView;->onScrollChanged(IIII)V

    .line 168
    return-void
.end method

.method public setCartEmpty(Z)V
    .locals 0

    .prologue
    .line 113
    iput-boolean p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->o:Z

    .line 114
    return-void
.end method

.method public setHtmlContent(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 485
    const-string v0, "You have no items in your shopping cart"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 486
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->g:Lnu;

    invoke-virtual {v0}, Lnu;->executeErrorContent()V

    .line 504
    :goto_0
    return-void

    .line 489
    :cond_0
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v0

    .line 490
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->m:Ljava/lang/String;

    invoke-virtual {v0, v1}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 491
    if-eqz v0, :cond_1

    .line 492
    const-string v1, "context_id="

    invoke-virtual {v0, v1}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v1

    add-int/lit8 v1, v1, 0xb

    .line 493
    const/16 v2, 0xb

    if-le v1, v2, :cond_1

    .line 494
    add-int/lit8 v2, v1, 0x24

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 495
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    invoke-static {v1, v0}, Lgf;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 498
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    if-eqz v0, :cond_2

    .line 499
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setVisibility(I)V

    .line 500
    iget-object v0, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 502
    :cond_2
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/CookieSyncManager;->sync()V

    goto :goto_0
.end method

.method public setHtmlError(Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 508
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 509
    if-eqz p1, :cond_0

    const-string v1, ""

    invoke-virtual {p1, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 510
    invoke-virtual {v0, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 511
    const-string v1, "<strong>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v1

    const-string v2, "<strong>"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, 0x8

    const-string v3, "{{{"

    invoke-virtual {v0, v1, v2, v3}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 512
    const-string v1, "</strong>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v1

    const-string v2, "</strong>"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, 0x9

    const-string v3, "}}}"

    invoke-virtual {v0, v1, v2, v3}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 513
    const-string v1, "<br>"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v1

    const-string v2, "<br>"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, 0x4

    const-string v3, "\n"

    invoke-virtual {v0, v1, v2, v3}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 514
    const-string v1, "{{{"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v1

    const-string v2, "{{{"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, 0x3

    const-string v3, "<span class=\'bold\'>"

    invoke-virtual {v0, v1, v2, v3}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 515
    const-string v1, "}}}"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v1

    const-string v2, "}}}"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->indexOf(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, 0x3

    const-string v3, "</span>"

    invoke-virtual {v0, v1, v2, v3}, Ljava/lang/StringBuilder;->replace(IILjava/lang/String;)Ljava/lang/StringBuilder;

    .line 517
    :cond_0
    invoke-static {}, Landroid/webkit/CookieManager;->getInstance()Landroid/webkit/CookieManager;

    move-result-object v1

    .line 518
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->m:Ljava/lang/String;

    invoke-virtual {v1, v2}, Landroid/webkit/CookieManager;->getCookie(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 519
    if-eqz v1, :cond_1

    .line 520
    const-string v2, "context_id="

    invoke-virtual {v1, v2}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v2

    add-int/lit8 v2, v2, 0xb

    .line 521
    const/16 v3, 0xb

    if-le v2, v3, :cond_1

    .line 522
    add-int/lit8 v3, v2, 0x24

    invoke-virtual {v1, v2, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    .line 523
    iget-object v2, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->d:Landroid/app/Activity;

    invoke-static {v2, v1}, Lgf;->a(Landroid/content/Context;Ljava/lang/String;)V

    .line 527
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    if-eqz v1, :cond_2

    .line 528
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->setVisibility(I)V

    .line 529
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->f:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 531
    :cond_2
    invoke-static {}, Landroid/webkit/CookieSyncManager;->getInstance()Landroid/webkit/CookieSyncManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/CookieSyncManager;->sync()V

    .line 532
    iget-object v1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->i:Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;->b(Ljava/lang/String;)V

    .line 533
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/bbyobjects/BBYWebView$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/bbyobjects/BBYWebView$3;-><init>(Lcom/bestbuy/android/bbyobjects/BBYWebView;)V

    const-wide/16 v2, 0xfa0

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 541
    return-void
.end method

.method public setOnScrollChangedCallback(Lkj;)V
    .locals 0

    .prologue
    .line 177
    iput-object p1, p0, Lcom/bestbuy/android/bbyobjects/BBYWebView;->e:Lkj;

    .line 178
    return-void
.end method
