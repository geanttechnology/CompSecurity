.class Lcom/amazon/mShop/control/wishlist/WishListController$4;
.super Ljava/lang/Object;
.source "WishListController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/wishlist/WishListController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/AddListItemsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/wishlist/WishListController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 196
    iput-object p1, p0, Lcom/amazon/mShop/control/wishlist/WishListController$4;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    iput-object p2, p0, Lcom/amazon/mShop/control/wishlist/WishListController$4;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 200
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$4;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    iget-object v1, p0, Lcom/amazon/mShop/control/wishlist/WishListController$4;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/wishlist/WishListController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/wishlist/WishListController;->access$700(Lcom/amazon/mShop/control/wishlist/WishListController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$4;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    # invokes: Lcom/amazon/mShop/control/wishlist/WishListController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/wishlist/WishListController;->access$800(Lcom/amazon/mShop/control/wishlist/WishListController;)V

    .line 202
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$4;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    # getter for: Lcom/amazon/mShop/control/wishlist/WishListController;->subscriber:Lcom/amazon/mShop/control/wishlist/WishListSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/wishlist/WishListController;->access$200(Lcom/amazon/mShop/control/wishlist/WishListController;)Lcom/amazon/mShop/control/wishlist/WishListSubscriber;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/mShop/control/wishlist/WishListSubscriber;->onWishListItemAdded()V

    .line 204
    :cond_0
    return-void
.end method
