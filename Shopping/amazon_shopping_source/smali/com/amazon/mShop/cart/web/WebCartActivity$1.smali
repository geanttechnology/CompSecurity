.class Lcom/amazon/mShop/cart/web/WebCartActivity$1;
.super Ljava/lang/Object;
.source "WebCartActivity.java"

# interfaces
.implements Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/cart/web/WebCartActivity;->handleEmptySession()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/cart/web/WebCartActivity;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/cart/web/WebCartActivity;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/amazon/mShop/cart/web/WebCartActivity$1;->this$0:Lcom/amazon/mShop/cart/web/WebCartActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onActionButtonClick(I)V
    .locals 2
    .param p1, "errorId"    # I

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity$1;->this$0:Lcom/amazon/mShop/cart/web/WebCartActivity;

    invoke-static {v0}, Lcom/amazon/mShop/util/ActivityUtils;->startHomeActivity(Landroid/content/Context;)Z

    .line 108
    iget-object v0, p0, Lcom/amazon/mShop/cart/web/WebCartActivity$1;->this$0:Lcom/amazon/mShop/cart/web/WebCartActivity;

    iget-object v1, p0, Lcom/amazon/mShop/cart/web/WebCartActivity$1;->this$0:Lcom/amazon/mShop/cart/web/WebCartActivity;

    # getter for: Lcom/amazon/mShop/cart/web/WebCartActivity;->mWebFragment:Lcom/amazon/mShop/web/MShopWebFragment;
    invoke-static {v1}, Lcom/amazon/mShop/cart/web/WebCartActivity;->access$000(Lcom/amazon/mShop/cart/web/WebCartActivity;)Lcom/amazon/mShop/web/MShopWebFragment;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/mShop/web/MShopWebFragment;->getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/cart/web/WebCartActivity;->clearErrorOnView(Landroid/view/View;)V

    .line 109
    return-void
.end method
