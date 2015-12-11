.class public Lcom/amazon/mShop/opl/web/WebPurchaseActivity;
.super Lcom/amazon/mShop/web/MShopModalWebActivity;
.source "WebPurchaseActivity.java"


# instance fields
.field private mIsPlacingOrder:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Ljava/lang/String;)Z
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/opl/web/WebPurchaseActivity;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 20
    invoke-direct {p0, p1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isThankYouPage(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$102(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/opl/web/WebPurchaseActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 20
    iput-boolean p1, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z

    return p1
.end method

.method static synthetic access$200(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/opl/web/WebPurchaseActivity;

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->exitModal()V

    return-void
.end method

.method private exitModal()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 194
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->setStopBehavior(I)V

    .line 195
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->setSupportMenu(Z)V

    .line 196
    invoke-virtual {p0, v1}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->setSupportGNO(Z)V

    .line 197
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0}, Landroid/content/Intent;-><init>()V

    .line 198
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "com.amazon.mShop.TopMostViewChangedReceiverIntent"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setAction(Ljava/lang/String;)Landroid/content/Intent;

    .line 200
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->sendBroadcast(Landroid/content/Intent;)V

    .line 201
    return-void
.end method

.method private isThankYouPage(Ljava/lang/String;)Z
    .locals 4
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    const/4 v2, 0x0

    .line 65
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_2

    .line 66
    invoke-static {p1}, Landroid/net/Uri;->parse(Ljava/lang/String;)Landroid/net/Uri;

    move-result-object v1

    .line 67
    .local v1, "uri":Landroid/net/Uri;
    invoke-virtual {v1}, Landroid/net/Uri;->getPath()Ljava/lang/String;

    move-result-object v0

    .line 68
    .local v0, "path":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    const-string/jumbo v3, "/gp/buy/spc/handlers/static-submit-decoupled.html"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    const-string/jumbo v3, "/gp/buy/thankyou/handlers/display.html"

    invoke-virtual {v0, v3}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_1

    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isOneClick()Z

    move-result v3

    if-eqz v3, :cond_2

    :cond_1
    const/4 v2, 0x1

    .line 70
    .end local v0    # "path":Ljava/lang/String;
    .end local v1    # "uri":Landroid/net/Uri;
    :cond_2
    return v2
.end method


# virtual methods
.method public canLaunchHomeFromActionBar()Z
    .locals 1

    .prologue
    .line 205
    iget-boolean v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z

    if-nez v0, :cond_0

    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->canLaunchHomeFromActionBar()Z

    move-result v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method protected createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;
    .locals 1

    .prologue
    .line 76
    new-instance v0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity$1;-><init>(Lcom/amazon/mShop/opl/web/WebPurchaseActivity;Lorg/apache/cordova/CordovaInterface;)V

    return-object v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 187
    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    iget-boolean v0, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mIsPlacingOrder:Z

    if-eqz v0, :cond_0

    .line 188
    const/4 v0, 0x1

    .line 190
    :goto_0
    return v0

    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopModalWebActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    goto :goto_0
.end method

.method protected initWebView()V
    .locals 2

    .prologue
    .line 32
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->initWebView()V

    .line 33
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    const/16 v1, 0x50

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setProgressHideSpinner(I)V

    .line 34
    return-void
.end method

.method protected isOneClick()Z
    .locals 3

    .prologue
    .line 56
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "oneClick"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method protected loadUrl()V
    .locals 3

    .prologue
    .line 61
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getPostParameters()[B

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Landroid/webkit/WebView;->postUrl(Ljava/lang/String;[B)V

    .line 62
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 166
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isSupportGNO()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 167
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onSearchRequested()Z

    move-result v0

    .line 171
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onSearchRequested(Ljava/lang/String;Z)Z
    .locals 1
    .param p1, "searchTerm"    # Ljava/lang/String;
    .param p2, "selectInitialQuery"    # Z

    .prologue
    .line 176
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isSupportGNO()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 177
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onSearchRequested(Ljava/lang/String;Z)Z

    move-result v0

    .line 181
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onStop()V
    .locals 5

    .prologue
    const/4 v2, 0x0

    .line 210
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    if-eqz v3, :cond_1

    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v3

    const-string/jumbo v4, "isCartPurchase"

    invoke-virtual {v3, v4, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v1

    .line 211
    .local v1, "isCartPruchase":Z
    :goto_0
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v3

    if-eqz v3, :cond_2

    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v3

    invoke-virtual {v3}, Landroid/webkit/WebView;->getUrl()Ljava/lang/String;

    move-result-object v0

    .line 212
    .local v0, "crrentUrl":Ljava/lang/String;
    :goto_1
    if-eqz v1, :cond_0

    invoke-direct {p0, v0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->isThankYouPage(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    iget-object v3, p0, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v3}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isWebViewReceivedError()Z

    move-result v3

    if-nez v3, :cond_0

    .line 221
    invoke-static {v2}, Lcom/amazon/mShop/web/MShopWebViewNotification;->notifyCartCountChanged(I)V

    .line 224
    :cond_0
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onStop()V

    .line 225
    return-void

    .end local v0    # "crrentUrl":Ljava/lang/String;
    .end local v1    # "isCartPruchase":Z
    :cond_1
    move v1, v2

    .line 210
    goto :goto_0

    .line 211
    .restart local v1    # "isCartPruchase":Z
    :cond_2
    const/4 v0, 0x0

    goto :goto_1
.end method

.method public startActivityForResult(Landroid/content/Intent;I)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "requestCode"    # I

    .prologue
    .line 153
    invoke-super {p0, p1, p2}, Lcom/amazon/mShop/web/MShopModalWebActivity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 154
    const/16 v0, 0x2712

    if-ne v0, p2, :cond_0

    .line 159
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->skipNextStopBehavior()V

    .line 161
    :cond_0
    return-void
.end method

.method public userSuccessfullySignedIn()V
    .locals 3

    .prologue
    .line 49
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->userSuccessfullySignedIn()V

    .line 50
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string/jumbo v1, "isCartPurchase"

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    invoke-virtual {p0}, Lcom/amazon/mShop/opl/web/WebPurchaseActivity;->finish()V

    .line 53
    :cond_0
    return-void
.end method
