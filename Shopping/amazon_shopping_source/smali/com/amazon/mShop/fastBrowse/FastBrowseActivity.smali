.class public Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "FastBrowseActivity.java"

# interfaces
.implements Lcom/amazon/mShop/search/ScopedSearch;


# instance fields
.field private mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

.field private mBrowseView:Landroid/view/View;

.field private mGNODrawerListener:Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

.field private mIsRoot:Z

.field private mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;",
            ">;"
        }
    .end annotation
.end field

.field private mOnBackUrlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 78
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    .line 88
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    .prologue
    .line 78
    invoke-direct {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->clearWebViewData()V

    return-void
.end method

.method static synthetic access$102(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 78
    iput-boolean p1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 78
    invoke-direct {p0, p1}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getSearchMetadata(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$300(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    return-object v0
.end method

.method static synthetic access$400(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method private clearWebViewData()V
    .locals 1

    .prologue
    .line 276
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->stopLoading()V

    .line 277
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->clearHistory()V

    .line 278
    return-void
.end method

.method private getSearchMetadata(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 315
    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 349
    :goto_0
    return-void

    .line 320
    :cond_0
    new-instance v0, Ljava/lang/Thread;

    new-instance v1, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3;

    invoke-direct {v1, p0, p1}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$3;-><init>(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;Ljava/lang/String;)V

    invoke-direct {v0, v1}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 348
    .local v0, "loaderThread":Ljava/lang/Thread;
    invoke-virtual {v0}, Ljava/lang/Thread;->start()V

    goto :goto_0
.end method


# virtual methods
.method public beginBackwardTransition(Ljava/lang/String;)V
    .locals 0
    .param p1, "requestUrl"    # Ljava/lang/String;

    .prologue
    .line 302
    return-void
.end method

.method public beginForwardTransition(Ljava/lang/String;)V
    .locals 0
    .param p1, "requestUrl"    # Ljava/lang/String;

    .prologue
    .line 294
    return-void
.end method

.method protected createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 6

    .prologue
    .line 283
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    .line 284
    .local v1, "webviewContainer":Lcom/amazon/mShop/web/MShopWebViewContainer;
    const-string/jumbo v2, "%s Mobile"

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v5

    invoke-virtual {v5}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v5

    invoke-virtual {v5}, Landroid/webkit/WebSettings;->getUserAgentString()Ljava/lang/String;

    move-result-object v5

    aput-object v5, v3, v4

    invoke-static {v2, v3}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 285
    .local v0, "ua":Ljava/lang/String;
    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getSettings()Landroid/webkit/WebSettings;

    move-result-object v2

    invoke-virtual {v2, v0}, Landroid/webkit/WebSettings;->setUserAgentString(Ljava/lang/String;)V

    .line 286
    return-object v1
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 3
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    const/4 v2, 0x4

    const/4 v0, 0x1

    .line 247
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v2, v1, :cond_0

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->isRightMenuOpen()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->isRightMenuLock()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 249
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->finish()V

    .line 269
    :goto_0
    return v0

    .line 255
    :cond_0
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v2, v1, :cond_1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->isRightMenuOpen()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 257
    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->unlockAndCloseRightMenu()V

    goto :goto_0

    .line 262
    :cond_1
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v2, v1, :cond_2

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v1

    if-nez v1, :cond_2

    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/gno/GNODrawer;->isClosed()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 264
    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v2

    invoke-virtual {v2}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->backOne(Ljava/lang/String;)V

    goto :goto_0

    .line 269
    :cond_2
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method public getCategoryMetadata()Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;
    .locals 2

    .prologue
    .line 371
    iget-boolean v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 376
    iget-object v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mMetadataCache:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/categoryBrowse/CategoryMetadata;

    .line 379
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentDepartmentDepth()I
    .locals 2

    .prologue
    .line 360
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1}, Landroid/webkit/WebView;->copyBackForwardList()Landroid/webkit/WebBackForwardList;

    move-result-object v0

    .line 361
    .local v0, "backForwardList":Landroid/webkit/WebBackForwardList;
    if-nez v0, :cond_0

    const/4 v1, 0x0

    :goto_0
    return v1

    :cond_0
    invoke-virtual {v0}, Landroid/webkit/WebBackForwardList;->getSize()I

    move-result v1

    goto :goto_0
.end method

.method protected initLayout()V
    .locals 5

    .prologue
    .line 139
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->initLayout()V

    .line 141
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getLayoutInflater()Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$layout;->fast_browse_layout:I

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    iput-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseView:Landroid/view/View;

    .line 144
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseView:Landroid/view/View;

    sget v3, Lcom/amazon/mShop/android/lib/R$id;->fastbrowse_view:I

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    iput-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    .line 147
    new-instance v2, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$1;-><init>(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)V

    iput-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mOnBackUrlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    .line 201
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    iget-object v3, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mOnBackUrlListener:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->useListener(Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView$OnBackUrlListener;)V

    .line 203
    new-instance v2, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$2;

    invoke-direct {v2, p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity$2;-><init>(Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;)V

    iput-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mGNODrawerListener:Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

    .line 226
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getGNODrawer()Lcom/amazon/mShop/gno/GNODrawer;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mGNODrawerListener:Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/gno/GNODrawer;->addListener(Lcom/amazon/mShop/gno/GNODrawer$GNODrawerListener;)V

    .line 228
    iget-boolean v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z

    if-nez v2, :cond_0

    .line 229
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->updateListView(Ljava/lang/String;)V

    .line 230
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->config()V

    .line 235
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getViewAnimator()Landroid/widget/ViewAnimator;

    move-result-object v0

    .line 236
    .local v0, "animator":Landroid/widget/ViewAnimator;
    invoke-virtual {v0}, Landroid/widget/ViewAnimator;->getParent()Landroid/view/ViewParent;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    .line 237
    .local v1, "animatorParent":Landroid/view/ViewGroup;
    invoke-virtual {v1, v0}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 238
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v2, v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->useView(Landroid/view/View;)V

    .line 239
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseView:Landroid/view/View;

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 240
    return-void

    .line 232
    .end local v0    # "animator":Landroid/widget/ViewAnimator;
    .end local v1    # "animatorParent":Landroid/view/ViewGroup;
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v2}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->load()V

    goto :goto_0
.end method

.method protected loadUrl()V
    .locals 2

    .prologue
    .line 125
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getUrl()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "/s/browse?node=aps"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 126
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z

    .line 131
    :goto_0
    return-void

    .line 128
    :cond_0
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z

    .line 129
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->loadUrl()V

    goto :goto_0
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 3
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 94
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->setIntent(Landroid/content/Intent;)V

    .line 98
    invoke-static {p0}, Lorg/apache/cordova/Config;->init(Landroid/app/Activity;)V

    .line 99
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->calcWebviewStartTime()V

    .line 101
    invoke-static {}, Lcom/amazon/mobile/mash/constants/WebConstants;->getWebViewUrlKey()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p1, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 102
    .local v0, "newUrl":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 107
    invoke-direct {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->clearWebViewData()V

    .line 108
    invoke-virtual {p0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v1

    invoke-virtual {v1, v0}, Landroid/webkit/WebView;->loadUrl(Ljava/lang/String;)V

    .line 109
    invoke-direct {p0, v0}, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->getSearchMetadata(Ljava/lang/String;)V

    .line 110
    const-string/jumbo v1, "/s/browse?node=aps"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 111
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z

    .line 112
    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->updateListView(Ljava/lang/String;)V

    .line 118
    :cond_0
    :goto_0
    return-void

    .line 114
    :cond_1
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mIsRoot:Z

    .line 115
    iget-object v1, p0, Lcom/amazon/mShop/fastBrowse/FastBrowseActivity;->mBrowseBaseView:Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;

    invoke-virtual {v1, v0}, Lcom/amazon/retailsearch/android/fastBrowse/FastBrowseBaseView;->updateListView(Ljava/lang/String;)V

    goto :goto_0
.end method
