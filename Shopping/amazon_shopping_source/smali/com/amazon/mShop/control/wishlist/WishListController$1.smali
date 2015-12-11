.class Lcom/amazon/mShop/control/wishlist/WishListController$1;
.super Ljava/lang/Object;
.source "WishListController.java"

# interfaces
.implements Lcom/amazon/rio/j2me/client/services/mShop/GetListListsResponseListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/wishlist/WishListController;->getListList(Ljava/lang/String;Lcom/amazon/mShop/control/TaskCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/wishlist/WishListController;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/wishlist/WishListController;)V
    .locals 0

    .prologue
    .line 74
    iput-object p1, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/control/wishlist/WishListController;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 91
    return-void
.end method

.method public completed(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/ListList;",
            ">;",
            "Lcom/amazon/rio/j2me/client/services/ServiceCall;",
            ")V"
        }
    .end annotation

    .prologue
    .line 77
    .local p1, "value":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ListList;>;"
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;

    invoke-direct {v1, p0, p2, p1}, Lcom/amazon/mShop/control/wishlist/WishListController$1$1;-><init>(Lcom/amazon/mShop/control/wishlist/WishListController$1;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/util/List;)V

    invoke-interface {v0, v1}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;)V

    .line 87
    return-void
.end method

.method public error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 94
    iget-object v0, p0, Lcom/amazon/mShop/control/wishlist/WishListController$1;->this$0:Lcom/amazon/mShop/control/wishlist/WishListController;

    invoke-virtual {v0, p1, p2}, Lcom/amazon/mShop/control/wishlist/WishListController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 95
    return-void
.end method
