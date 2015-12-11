.class public Lcom/amazon/mShop/wishlist/web/WebWishListActivity;
.super Lcom/amazon/mShop/web/MShopWebActivity;
.source "WebWishListActivity.java"

# interfaces
.implements Lcom/amazon/mShop/model/auth/UserListener;
.implements Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;


# instance fields
.field protected shouldRefeshOnceOnLogin:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 19
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopWebActivity;-><init>()V

    .line 24
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;->shouldRefeshOnceOnLogin:Z

    return-void
.end method


# virtual methods
.method protected handleForceSignIn()V
    .locals 1

    .prologue
    .line 69
    invoke-virtual {p0}, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;->isLaunchedFromPublicUrl()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 70
    invoke-static {p0}, Lcom/amazon/mShop/sso/SSOUtil;->handleSigninPrompt(Landroid/content/Context;)Z

    .line 72
    :cond_0
    return-void
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 28
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopWebActivity;->onCreate(Landroid/os/Bundle;)V

    .line 30
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->addUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 31
    invoke-static {p0}, Lcom/amazon/mShop/web/NativeAppNotification;->addNativeWishListSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;)V

    .line 33
    return-void
.end method

.method protected onDestroy()V
    .locals 0

    .prologue
    .line 38
    invoke-static {p0}, Lcom/amazon/mShop/model/auth/User;->removeUserListener(Lcom/amazon/mShop/model/auth/UserListener;)V

    .line 39
    invoke-static {p0}, Lcom/amazon/mShop/web/NativeAppNotification;->removeNativeWishListSubscriber(Lcom/amazon/mShop/web/NativeAppNotification$NativeWishListSubscriber;)V

    .line 40
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopWebActivity;->onDestroy()V

    .line 41
    return-void
.end method

.method public onWishListChanged()V
    .locals 0

    .prologue
    .line 64
    invoke-virtual {p0}, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;->refresh()V

    .line 65
    return-void
.end method

.method public userSignedIn(Lcom/amazon/mShop/model/auth/User;)V
    .locals 1
    .param p1, "arg0"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 45
    iget-boolean v0, p0, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;->shouldRefeshOnceOnLogin:Z

    if-nez v0, :cond_0

    .line 46
    invoke-virtual {p0}, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;->refresh()V

    .line 47
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;->shouldRefeshOnceOnLogin:Z

    .line 49
    :cond_0
    return-void
.end method

.method public userSignedOut()V
    .locals 1

    .prologue
    .line 53
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/wishlist/web/WebWishListActivity;->shouldRefeshOnceOnLogin:Z

    .line 54
    return-void
.end method

.method public userUpdated(Lcom/amazon/mShop/model/auth/User;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/mShop/model/auth/User;

    .prologue
    .line 59
    return-void
.end method
