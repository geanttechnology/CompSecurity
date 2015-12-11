.class Lcom/amazon/mShop/control/home/BasicProductsController$2;
.super Ljava/lang/Object;
.source "BasicProductsController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/BasicProductsController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

.field final synthetic val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V
    .locals 0

    .prologue
    .line 59
    iput-object p1, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    iput-object p2, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 63
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    iget-object v1, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/home/BasicProductsController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/home/BasicProductsController;->access$300(Lcom/amazon/mShop/control/home/BasicProductsController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    # invokes: Lcom/amazon/mShop/control/home/BasicProductsController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/home/BasicProductsController;->access$400(Lcom/amazon/mShop/control/home/BasicProductsController;)V

    .line 65
    iget-object v0, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->this$0:Lcom/amazon/mShop/control/home/BasicProductsController;

    # getter for: Lcom/amazon/mShop/control/home/BasicProductsController;->mBasicProductsSubscriber:Lcom/amazon/mShop/control/home/BasicProductsSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/home/BasicProductsController;->access$200(Lcom/amazon/mShop/control/home/BasicProductsController;)Lcom/amazon/mShop/control/home/BasicProductsSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/home/BasicProductsController$2;->val$response:Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/home/BasicProductsSubscriber;->onBasicProductsReceived(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductsResponse;)V

    .line 67
    :cond_0
    return-void
.end method
