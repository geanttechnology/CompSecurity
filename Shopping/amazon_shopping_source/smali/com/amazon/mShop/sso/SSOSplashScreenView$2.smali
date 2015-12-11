.class Lcom/amazon/mShop/sso/SSOSplashScreenView$2;
.super Ljava/lang/Object;
.source "SSOSplashScreenView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/sso/SSOSplashScreenView;->initSplashScreen()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/sso/SSOSplashScreenView;)V
    .locals 0

    .prologue
    .line 91
    iput-object p1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$2;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 94
    iget-object v1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$2;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 97
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$2;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    const-class v2, Lcom/amazon/mShop/sso/DistributedSSOLoginActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 98
    .local v0, "intent":Landroid/content/Intent;
    const-string/jumbo v1, "force_signin"

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 99
    iget-object v1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$2;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    invoke-virtual {v1, v0}, Lcom/amazon/mShop/AmazonActivity;->startActivity(Landroid/content/Intent;)V

    .line 100
    iget-object v1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$2;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/sso/SSOUtil;->isAppstoreInstalledWithSpecificVersion(Landroid/content/Context;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 101
    const-string/jumbo v1, "sso_wl_switch_account_wappstore"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 106
    :goto_0
    const/4 v1, 0x0

    invoke-static {v1}, Lcom/amazon/mShop/sso/MShopCheckLogin;->savePendingNotification(Lcom/amazon/rio/j2me/client/services/mShop/Notification;)V

    .line 107
    return-void

    .line 103
    :cond_0
    const-string/jumbo v1, "sso_wl_switch_account"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
