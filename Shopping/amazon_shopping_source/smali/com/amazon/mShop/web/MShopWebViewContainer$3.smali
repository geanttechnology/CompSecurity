.class Lcom/amazon/mShop/web/MShopWebViewContainer$3;
.super Ljava/lang/Object;
.source "MShopWebViewContainer.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebViewContainer;->showSslError(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebViewContainer;)V
    .locals 0

    .prologue
    .line 585
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$3;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 588
    invoke-virtual {p1}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 591
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$3;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getContext()Landroid/content/Context;

    move-result-object v0

    instance-of v0, v0, Lcom/amazon/mShop/home/web/MShopWebGatewayActivity;

    if-eqz v0, :cond_0

    .line 593
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$3;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/web/MShopWebViewContainer;->mIsHTTPBlockedErrorShown:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$302(Lcom/amazon/mShop/web/MShopWebViewContainer;Z)Z

    .line 594
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebViewContainer$3;->this$0:Lcom/amazon/mShop/web/MShopWebViewContainer;

    # invokes: Lcom/amazon/mShop/web/MShopWebViewContainer;->clearError()V
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->access$200(Lcom/amazon/mShop/web/MShopWebViewContainer;)V

    .line 596
    :cond_0
    return-void
.end method
