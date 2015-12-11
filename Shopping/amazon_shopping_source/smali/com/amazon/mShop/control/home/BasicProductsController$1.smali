.class Lcom/amazon/mShop/control/home/BasicProductsController$1;
.super Ljava/lang/Object;
.source "BasicProductsController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/BasicProductsController;->error(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

.field final synthetic val$exp:Ljava/lang/Exception;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Exception;)V
    .locals 0

    .prologue
    .line 44
    iput-object p1, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    iput-object p2, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->val$exp:Ljava/lang/Exception;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    iget-object v1, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/home/BasicProductsController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/home/BasicProductsController;->access$000(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    # invokes: Lcom/amazon/mShop/control/home/BasicProductsController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/home/BasicProductsController;->access$100(Lcom/amazon/mShop/control/home/BasicProductsController;)V

    .line 50
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    # getter for: Lcom/amazon/mShop/control/home/BasicProductsController;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/home/BasicProductsController;->access$200(Lcom/amazon/mShop/control/home/BasicProductsController;)Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->val$exp:Ljava/lang/Exception;

    iget-object v2, p0, Lcom/amazon/mShop/control/home/BasicProductsController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v0, v1, v2}, Lcom/amazon/mShop/control/home/BasicProductsSubscriber;->onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V

    .line 52
    :cond_0
    return-void
.end method
