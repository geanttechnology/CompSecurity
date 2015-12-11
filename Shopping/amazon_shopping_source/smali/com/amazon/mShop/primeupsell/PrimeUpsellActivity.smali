.class public Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;
.super Lcom/amazon/mShop/web/MShopModalWebActivity;
.source "PrimeUpsellActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$1;,
        Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeWebViewClient;,
        Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeNavManager;,
        Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    }
.end annotation


# instance fields
.field private mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;-><init>()V

    .line 37
    sget-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_USER_CANCELLED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    iput-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 79
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;)Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;
    .param p1, "x1"    # Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .prologue
    .line 19
    iput-object p1, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    return-object p1
.end method


# virtual methods
.method protected createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;
    .locals 1

    .prologue
    .line 54
    new-instance v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeWebViewClient;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeWebViewClient;-><init>(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;Lorg/apache/cordova/CordovaInterface;)V

    return-object v0
.end method

.method protected createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 3

    .prologue
    .line 42
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;

    move-result-object v2

    invoke-direct {v0, p0, v1, v2, p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/amazon/mShop/web/MShopWebViewClient;Lcom/amazon/mShop/web/MShopWebViewTransitionManager;)V

    .line 48
    .local v0, "container":Lcom/amazon/mShop/web/MShopWebViewContainer;
    const/16 v1, 0x5a

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setProgressHideSpinner(I)V

    .line 49
    return-object v0
.end method

.method public dispatchKeyEvent(Landroid/view/KeyEvent;)Z
    .locals 2
    .param p1, "event"    # Landroid/view/KeyEvent;

    .prologue
    .line 148
    const/4 v0, 0x4

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getKeyCode()I

    move-result v1

    if-ne v0, v1, :cond_1

    invoke-virtual {p1}, Landroid/view/KeyEvent;->getAction()I

    move-result v0

    if-nez v0, :cond_1

    .line 152
    invoke-virtual {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->canGoBack()Z

    move-result v0

    if-nez v0, :cond_1

    invoke-virtual {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isShowingSpinner()Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->isWebViewReceivedError()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 154
    :cond_0
    sget-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_OFFER_PAGE_NOT_DISPLAYED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    iput-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 157
    :cond_1
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopModalWebActivity;->dispatchKeyEvent(Landroid/view/KeyEvent;)Z

    move-result v0

    return v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 119
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onCreate(Landroid/os/Bundle;)V

    .line 120
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->setStopBehavior(I)V

    .line 121
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 105
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onDestroy()V

    .line 108
    iget-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    invoke-static {v0}, Lcom/amazon/mShop/primeupsell/PrimeUpsellHelper;->primeUpsellFinished(Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;)V

    .line 109
    return-void
.end method

.method protected onNewIntent(Landroid/content/Intent;)V
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 113
    sget-object v0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;->RESULT_USER_CANCELLED:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    iput-object v0, p0, Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity;->mPrimeUpsellResult:Lcom/amazon/mShop/primeupsell/PrimeUpsellActivity$PrimeUpsellResult;

    .line 114
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onNewIntent(Landroid/content/Intent;)V

    .line 115
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 141
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onResume()V

    .line 143
    invoke-static {p0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->hideActionBar(Lcom/amazon/mShop/AmazonActivity;)V

    .line 144
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 165
    const/4 v0, 0x0

    return v0
.end method

.method public onSearchRequested(Ljava/lang/String;Z)Z
    .locals 1
    .param p1, "searchTerm"    # Ljava/lang/String;
    .param p2, "selectInitialQuery"    # Z

    .prologue
    .line 173
    const/4 v0, 0x0

    return v0
.end method

.method protected registerPushNotification()V
    .locals 0

    .prologue
    .line 137
    return-void
.end method

.method protected updateGNOMenuItems()V
    .locals 0

    .prologue
    .line 129
    return-void
.end method
