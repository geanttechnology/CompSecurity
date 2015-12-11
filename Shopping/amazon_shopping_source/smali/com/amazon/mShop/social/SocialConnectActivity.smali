.class public Lcom/amazon/mShop/social/SocialConnectActivity;
.super Lcom/amazon/mShop/web/MShopModalWebActivity;
.source "SocialConnectActivity.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/social/SocialConnectActivity$1;,
        Lcom/amazon/mShop/social/SocialConnectActivity$SocialWebViewClient;,
        Lcom/amazon/mShop/social/SocialConnectActivity$SocialNavManager;
    }
.end annotation


# instance fields
.field private mSocialConnectDoNotShowAgain:Z


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 20
    invoke-direct {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;-><init>()V

    .line 52
    return-void
.end method

.method static synthetic access$002(Lcom/amazon/mShop/social/SocialConnectActivity;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/social/SocialConnectActivity;
    .param p1, "x1"    # Z

    .prologue
    .line 20
    iput-boolean p1, p0, Lcom/amazon/mShop/social/SocialConnectActivity;->mSocialConnectDoNotShowAgain:Z

    return p1
.end method


# virtual methods
.method protected createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;
    .locals 1

    .prologue
    .line 37
    new-instance v0, Lcom/amazon/mShop/social/SocialConnectActivity$SocialWebViewClient;

    invoke-direct {v0, p0, p0}, Lcom/amazon/mShop/social/SocialConnectActivity$SocialWebViewClient;-><init>(Lcom/amazon/mShop/social/SocialConnectActivity;Lorg/apache/cordova/CordovaInterface;)V

    return-object v0
.end method

.method protected createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 3

    .prologue
    .line 27
    new-instance v0, Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v1, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/social/SocialConnectActivity;->createWebViewClient()Lcom/amazon/mShop/web/MShopWebViewClient;

    move-result-object v2

    invoke-direct {v0, p0, v1, v2, p0}, Lcom/amazon/mShop/web/MShopWebViewContainer;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;Lcom/amazon/mShop/web/MShopWebViewClient;Lcom/amazon/mShop/web/MShopWebViewTransitionManager;)V

    .line 32
    .local v0, "container":Lcom/amazon/mShop/web/MShopWebViewContainer;
    return-object v0
.end method

.method protected onCreate(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 67
    invoke-super {p0, p1}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onCreate(Landroid/os/Bundle;)V

    .line 68
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/social/SocialConnectActivity;->setStopBehavior(I)V

    .line 69
    return-void
.end method

.method protected onDestroy()V
    .locals 1

    .prologue
    .line 61
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onDestroy()V

    .line 62
    iget-boolean v0, p0, Lcom/amazon/mShop/social/SocialConnectActivity;->mSocialConnectDoNotShowAgain:Z

    invoke-static {v0}, Lcom/amazon/mShop/social/SocialConnectHelper;->socialConnectFinished(Z)V

    .line 63
    return-void
.end method

.method protected onResume()V
    .locals 0

    .prologue
    .line 85
    invoke-super {p0}, Lcom/amazon/mShop/web/MShopModalWebActivity;->onResume()V

    .line 87
    invoke-static {p0}, Lcom/amazon/mShop/actionBar/ActionBarHelper;->hideActionBar(Lcom/amazon/mShop/AmazonActivity;)V

    .line 88
    return-void
.end method

.method public onSearchRequested()Z
    .locals 1

    .prologue
    .line 94
    const/4 v0, 0x0

    return v0
.end method

.method public onSearchRequested(Ljava/lang/String;Z)Z
    .locals 1
    .param p1, "searchTerm"    # Ljava/lang/String;
    .param p2, "selectInitialQuery"    # Z

    .prologue
    .line 101
    const/4 v0, 0x0

    return v0
.end method

.method protected registerPushNotification()V
    .locals 0

    .prologue
    .line 81
    return-void
.end method

.method protected updateGNOMenuItems()V
    .locals 0

    .prologue
    .line 75
    return-void
.end method
