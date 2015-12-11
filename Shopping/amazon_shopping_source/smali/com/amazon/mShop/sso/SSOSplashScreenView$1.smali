.class Lcom/amazon/mShop/sso/SSOSplashScreenView$1;
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
    .line 68
    iput-object p1, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$1;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 1
    .param p1, "v"    # Landroid/view/View;

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$1;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonActivity;->finish()V

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/sso/SSOSplashScreenView$1;->this$0:Lcom/amazon/mShop/sso/SSOSplashScreenView;

    # getter for: Lcom/amazon/mShop/sso/SSOSplashScreenView;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOSplashScreenView;->access$000(Lcom/amazon/mShop/sso/SSOSplashScreenView;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->isAppstoreInstalledWithSpecificVersion(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 74
    const-string/jumbo v0, "sso_wl_continue_wappstore"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 78
    :goto_0
    return-void

    .line 76
    :cond_0
    const-string/jumbo v0, "sso_wl_continue"

    invoke-static {v0}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method
