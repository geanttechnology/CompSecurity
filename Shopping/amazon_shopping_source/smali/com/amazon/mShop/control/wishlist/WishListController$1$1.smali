.class Lcom/amazon/mShop/control/wishlist/WishListController$1$1;
.super Ljava/lang/Object;
.source "WishListController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/wishlist/WishListController$1;->completed(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/wishlist/WishListController$1;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/wishlist/WishListController$1;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 77
    iput-object p1, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->this$1:Lcom/amazon/mShop/control/wishlist/WishListController$1;

    iput-object p2, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->val$value:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->this$1:Lcom/amazon/mShop/control/wishlist/WishListController$1;

    iget-object v0, v0, Lcom/amazon/mShop/control/wishlist/WishListController$1;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    iget-object v1, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/wishlist/WishListController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/wishlist/WishListController;->access$000(Lcom/amazon/mShop/control/wishlist/WishListController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->this$1:Lcom/amazon/mShop/control/wishlist/WishListController$1;

    iget-object v0, v0, Lcom/amazon/mShop/control/wishlist/WishListController$1;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    # invokes: Lcom/amazon/mShop/control/wishlist/WishListController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/wishlist/WishListController;->access$100(Lcom/amazon/mShop/control/wishlist/WishListController;)V

    .line 83
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->this$1:Lcom/amazon/mShop/control/wishlist/WishListController$1;

    iget-object v0, v0, Lcom/amazon/mShop/control/wishlist/WishListController$1;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    # getter for: Lcom/amazon/mShop/control/wishlist/WishListController;->subscriber:Lcom/amazon/mShop/control/wishlist/WishListSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/wishlist/WishListController;->access$200(Lcom/amazon/mShop/control/wishlist/WishListController;)Lcom/amazon/mShop/control/wishlist/WishListSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;->val$value:Ljava/util/List;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/wishlist/WishListSubscriber;->onListLists(Ljava/util/List;)V

    .line 85
    :cond_0
    return-void
.end method
