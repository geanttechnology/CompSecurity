.class public Lcom/amazon/mShop/cart/web/WebCartActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "WebCartActivity.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;
.implements Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;


# instance fields
.field private mCartUpdatedMashEventRegistered:Z

.field protected shouldRefeshOnceOnLogin:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    .line 36
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity;->shouldRefeshOnceOnLogin:Z

    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/cart/web/WebCartActivity;)Lcom/amazon/mShop/web/MShopWebFragment;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/cart/web/WebCartActivity;

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    return-object v0
.end method

.method private handleEmptySession()V
    .locals 4

    .prologue
    .line 100
    iget-object v1, p0, Lcom/amazon/mShop/cart/web/WebCartActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/web/MShopWebFragment;->initWebViewContainer(Lcom/amazon/mShop/web/MShopWebActivity;)V

    .line 101
    invoke-virtual {p0}, Lcom/amazon/mShop/cart/web/WebCartActivity;->initLayout()V

    .line 103
    new-instance v0, Lcom/amazon/mShop/cart/web/WebCartActivity$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/cart/web/WebCartActivity$1;-><init>(Lcom/amazon/mShop/cart/web/WebCartActivity;)V

    .line 111
    .local v0, "listener":Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;
    invoke-virtual {p0}, Lcom/amazon/mShop/cart/web/WebCartActivity;->getWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    const/4 v2, 0x0

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->ok:I

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/cart/web/WebCartActivity;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-static {p0, v0, v1, v2, v3}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;Ljava/lang/String;)V

    .line 112
    return-void
.end method


# virtual methods
.method protected handleForceSignIn()V
    .locals 1

    .prologue
    .line 124
    invoke-virtual {p0}, Lcom/amazon/mShop/cart/web/WebCartActivity;->isLaunchedFromPublicUrl()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 125
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->handleSigninPrompt(Landroid/content/Context;)Z

    .line 127
    :cond_0
    return-void
.end method

.method protected initWebView()V
    .locals 2

    .prologue
    .line 90
    invoke-static {}, Lcom/amazon/mShop/net/CookieBridge;->getCurrentSessionId()Ljava/lang/String;

    move-result-object v0

    .line 91
    .local v0, "sessionId":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 92
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->initWebView()V

    .line 96
    :goto_0
    return-void

    .line 94
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/cart/web/WebCartActivity;->handleEmptySession()V

    goto :goto_0
.end method

.method public isCartUpdatedMashEventRegistered()Z
    .locals 1

    .prologue
    .line 115
    iget-boolean v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity;->mCartUpdatedMashEventRegistered:Z

    return v0
.end method

.method public onCartChanged()V
    .locals 1

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/cart/web/WebCartActivity;->isCartUpdatedMashEventRegistered()Z

    move-result v0

    if-nez v0, :cond_0

    .line 65
    invoke-virtual {p0}, Lcom/amazon/mShop/cart/web/WebCartActivity;->refresh()V

    .line 67
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 40
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->onCreate(Landroid/os/Bundle;)V

    .line 42
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 44
    invoke-static {p0}, Lcom/amazon/mShop/web/NativeAppNotification;->addNativeCartSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;)V

    .line 45
    return-void
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 50
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 51
    invoke-static {p0}, Lcom/amazon/mShop/web/NativeAppNotification;->removeNativeCartSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeCartSubscriber;)V

    .line 52
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onDestroy()V

    .line 53
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 1
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 77
    iget-boolean v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity;->shouldRefeshOnceOnLogin:Z

    if-nez v0, :cond_0

    .line 78
    invoke-virtual {p0}, Lcom/amazon/mShop/cart/web/WebCartActivity;->refresh()V

    .line 79
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity;->shouldRefeshOnceOnLogin:Z

    .line 81
    :cond_0
    return-void
.end method

.method public userSignedOut()V
    .locals 1

    .prologue
    .line 85
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity;->shouldRefeshOnceOnLogin:Z

    .line 86
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "user"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 73
    return-void
.end method
