.class Lcom/amazon/mShop/home/HomeView$4;
.super Ljava/lang/Object;
.source "HomeView.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/home/HomeView;->updateLoginButton()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/home/HomeView;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/home/HomeView;)V
    .locals 0

    .prologue
    .line 560
    iput-object p1, p0, Lcom/amazon/mShop/home/HomeView$4;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 6
    .param p1, "view"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 564
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$4;->this$0:Lcom/amazon/mShop/home/HomeView;

    invoke-virtual {v0}, Lcom/amazon/mShop/home/HomeView;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/sso/SSOUtil;->isSSOSupported(Landroid/content/Context;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 565
    invoke-static {}, Lcom/amazon/mShop/sso/SSOUtil;->getCurrentIdentityType()Lcom/amazon/mShop/sso/IdentityType;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/home/HomeView$4;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v1}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v1

    const-string/jumbo v5, "gw"

    move v4, v3

    invoke-virtual/range {v0 .. v5}, Lcom/amazon/mShop/sso/IdentityType;->handleSSOLogin(Landroid/app/Activity;ZZZLjava/lang/String;)V

    .line 570
    :goto_0
    return-void

    .line 568
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/home/HomeView$4;->this$0:Lcom/amazon/mShop/home/HomeView;

    # getter for: Lcom/amazon/mShop/home/HomeView;->mActivity:Lcom/amazon/mShop/home/GatewayActivity;
    invoke-static {v0}, Lcom/amazon/mShop/home/HomeView;->access$1500(Lcom/amazon/mShop/home/HomeView;)Lcom/amazon/mShop/home/GatewayActivity;

    move-result-object v0

    const-string/jumbo v1, "gw"

    const-string/jumbo v4, "hm_si"

    new-array v3, v3, [I

    invoke-static {v0, v1, v2, v4, v3}, Lcom/amazon/mShop/util/ActivityUtils;->startLoginActivity(Landroid/content/Context;Ljava/lang/String;ZLjava/lang/String;[I)Z

    goto :goto_0
.end method
