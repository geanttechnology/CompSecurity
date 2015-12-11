.class Lcom/amazon/mShop/web/MShopWebActivity$1;
.super Ljava/lang/Object;
.source "MShopWebActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/web/MShopWebActivity;->doTransitionAnimation()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/web/MShopWebActivity;

.field final synthetic val$container:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/web/MShopWebActivity;Lcom/amazon/mShop/web/MShopWebViewContainer;)V
    .locals 0

    .prologue
    .line 499
    iput-object p1, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->this$0:Lcom/amazon/mShop/web/MShopWebActivity;

    iput-object p2, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->val$container:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 503
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->this$0:Lcom/amazon/mShop/web/MShopWebActivity;

    # getter for: Lcom/amazon/mShop/web/MShopWebActivity;->mForwardTransitionPending:Z
    invoke-static {v0}, Lcom/amazon/mShop/web/MShopWebActivity;->access$000(Lcom/amazon/mShop/web/MShopWebActivity;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->this$0:Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebActivity;->isPushAnimationInProgress()Z

    move-result v0

    if-nez v0, :cond_0

    .line 504
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->this$0:Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebActivity;->goForwardTransition()V

    .line 505
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->this$0:Lcom/amazon/mShop/web/MShopWebActivity;

    # setter for: Lcom/amazon/mShop/web/MShopWebActivity;->mForwardTransitionPending:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/web/MShopWebActivity;->access$002(Lcom/amazon/mShop/web/MShopWebActivity;Z)Z

    .line 506
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->val$container:Lcom/amazon/mShop/web/MShopWebViewContainer;

    if-eqz v0, :cond_0

    .line 507
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebActivity$1;->val$container:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/web/MShopWebViewContainer;->setShouldDelayTransition(Z)V

    .line 510
    :cond_0
    return-void
.end method
