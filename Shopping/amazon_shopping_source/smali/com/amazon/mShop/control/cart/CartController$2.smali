.class Lcom/amazon/mShop/control/cart/CartController$2;
.super Ljava/lang/Object;
.source "CartController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/cart/CartController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/cart/CartController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    .locals 0

    .prologue
    .line 503
    iput-object p1, p0, Lcom/amazon/mShop/control/cart/CartController$2;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    iput-object p2, p0, Lcom/amazon/mShop/control/cart/CartController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/cart/CartController$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 507
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController$2;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    iget-object v1, p0, Lcom/amazon/mShop/control/cart/CartController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/cart/CartController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/cart/CartController;->access$100(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 508
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController$2;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    # invokes: Lcom/amazon/mShop/control/cart/CartController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/cart/CartController;->access$200(Lcom/amazon/mShop/control/cart/CartController;)V

    .line 509
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController$2;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    iget-object v1, p0, Lcom/amazon/mShop/control/cart/CartController$2;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/CartItems;

    # invokes: Lcom/amazon/mShop/control/cart/CartController;->notifyCartReceived(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/cart/CartController;->access$300(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 511
    :cond_0
    return-void
.end method
