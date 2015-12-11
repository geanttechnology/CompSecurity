.class Lcom/amazon/mShop/control/cart/CartController$3;
.super Ljava/lang/Object;
.source "CartController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/cart/CartController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/cart/CartController;

.field final synthetic val$e:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 517
    iput-object p1, p0, Lcom/amazon/mShop/control/cart/CartController$3;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    iput-object p2, p0, Lcom/amazon/mShop/control/cart/CartController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/cart/CartController$3;->val$e:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 521
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController$3;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    iget-object v1, p0, Lcom/amazon/mShop/control/cart/CartController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/cart/CartController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/cart/CartController;->access$400(Lcom/amazon/mShop/control/cart/CartController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 522
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController$3;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    # invokes: Lcom/amazon/mShop/control/cart/CartController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/cart/CartController;->access$500(Lcom/amazon/mShop/control/cart/CartController;)V

    .line 523
    iget-object v0, p0, Lcom/amazon/mShop/control/cart/CartController$3;->this$0:Lcom/amazon/mShop/control/cart/CartController;

    iget-object v1, p0, Lcom/amazon/mShop/control/cart/CartController$3;->val$e:Ljava/lang/Exception;

    iget-object v2, p0, Lcom/amazon/mShop/control/cart/CartController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/cart/CartController;->notifyError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/mShop/control/cart/CartController;->access$600(Lcom/amazon/mShop/control/cart/CartController;Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 525
    :cond_0
    return-void
.end method
