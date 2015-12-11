.class Lcom/amazon/mShop/control/home/HomeController$7;
.super Ljava/lang/Object;
.source "HomeController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/HomeController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/home/HomeController;

.field final synthetic val$e:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/home/HomeController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 0

    .prologue
    .line 561
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController$7;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    iput-object p2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->val$e:Ljava/lang/Exception;

    iput-object p3, p0, Lcom/amazon/mShop/control/home/HomeController$7;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 565
    iget-object v2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v2, v3}, Lcom/amazon/mShop/control/home/HomeController;->access$602(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 567
    iget-object v2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z
    invoke-static {v2}, Lcom/amazon/mShop/control/home/HomeController;->access$400(Lcom/amazon/mShop/control/home/HomeController;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 569
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v2

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/control/cart/CartController;->onCartReceivedFromHomeCall(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 570
    iget-object v2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    const/4 v3, 0x0

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z
    invoke-static {v2, v3}, Lcom/amazon/mShop/control/home/HomeController;->access$402(Lcom/amazon/mShop/control/home/HomeController;Z)Z

    .line 573
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;
    invoke-static {v2}, Lcom/amazon/mShop/control/home/HomeController;->access$200(Lcom/amazon/mShop/control/home/HomeController;)Ljava/util/List;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 574
    .local v1, "subcriber":Lcom/amazon/mShop/control/home/HomeSubscriber;
    iget-object v2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->val$e:Ljava/lang/Exception;

    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController$7;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v1, v2, v3}, Lcom/amazon/mShop/control/home/HomeSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    goto :goto_0

    .line 577
    .end local v1    # "subcriber":Lcom/amazon/mShop/control/home/HomeSubscriber;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->doPhoneHomeAfterCancelComplete:Z
    invoke-static {v2}, Lcom/amazon/mShop/control/home/HomeController;->access$800(Lcom/amazon/mShop/control/home/HomeController;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 578
    iget-object v2, p0, Lcom/amazon/mShop/control/home/HomeController$7;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # invokes: Lcom/amazon/mShop/control/home/HomeController;->phoneHome()V
    invoke-static {v2}, Lcom/amazon/mShop/control/home/HomeController;->access$900(Lcom/amazon/mShop/control/home/HomeController;)V

    .line 580
    :cond_2
    return-void
.end method
