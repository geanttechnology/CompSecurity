.class Lcom/amazon/mShop/control/account/OneClickController$1;
.super Ljava/lang/Object;
.source "OneClickController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/account/OneClickController;->completed(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/account/OneClickController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V
    .locals 0

    .prologue
    .line 543
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iput-object p2, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 548
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->access$000(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 549
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/account/OneClickController;->access$100(Lcom/amazon/mShop/control/account/OneClickController;)V

    .line 550
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->setOneClickConfigResponse(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->access$200(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V

    .line 552
    const-string/jumbo v0, "set_one_click_config_v21"

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/services/ServiceCall;->getMethod()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 553
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    # getter for: Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/account/OneClickController;->access$300(Lcom/amazon/mShop/control/account/OneClickController;)Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;->getOneClickStatus()Z

    move-result v1

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;->onSaveOneClickStatus(Z)V

    .line 558
    :cond_0
    :goto_0
    return-void

    .line 555
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    # getter for: Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/account/OneClickController;->access$300(Lcom/amazon/mShop/control/account/OneClickController;)Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;->onReceiveOneClickConfig(Lcom/amazon/rio/j2me/client/services/mShop/OneClickConfigResponse;)V

    goto :goto_0
.end method
