.class Lcom/amazon/mShop/control/home/HomeController$4;
.super Ljava/lang/Object;
.source "HomeController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/HomeController;->receivedCartItems(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/home/HomeController;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 0

    .prologue
    .line 469
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController$4;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    iput-object p2, p0, Lcom/amazon/mShop/control/home/HomeController$4;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 473
    iget-object v0, p0, Lcom/amazon/mShop/control/home/HomeController$4;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    const/4 v1, 0x0

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/home/HomeController;->access$402(Lcom/amazon/mShop/control/home/HomeController;Z)Z

    .line 474
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/home/HomeController$4;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/cart/CartController;->onCartReceivedFromHomeCall(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 475
    return-void
.end method
