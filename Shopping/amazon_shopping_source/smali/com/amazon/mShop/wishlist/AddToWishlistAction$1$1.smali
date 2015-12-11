.class Lcom/amazon/mShop/wishlist/AddToWishlistAction$1$1;
.super Ljava/lang/Object;
.source "AddToWishlistAction.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;->onActionButtonClick(I)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;)V
    .locals 0

    .prologue
    .line 119
    iput-object p1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1$1;->this$1:Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 123
    iget-object v0, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1$1;->this$1:Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;

    iget-object v0, v0, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;->this$0:Lcom/amazon/mShop/wishlist/AddToWishlistAction;

    # getter for: Lcom/amazon/mShop/wishlist/AddToWishlistAction;->mActivity:Lcom/amazon/mShop/AmazonActivity;
    invoke-static {v0}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;->access$000(Lcom/amazon/mShop/wishlist/AddToWishlistAction;)Lcom/amazon/mShop/AmazonActivity;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1$1;->this$1:Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;

    iget-object v1, v1, Lcom/amazon/mShop/wishlist/AddToWishlistAction$1;->val$currentView:Landroid/view/View;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/AmazonActivity;->clearErrorOnView(Landroid/view/View;)V

    .line 124
    return-void
.end method
