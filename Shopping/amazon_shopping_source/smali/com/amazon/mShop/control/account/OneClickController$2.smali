.class Lcom/amazon/mShop/control/account/OneClickController$2;
.super Ljava/lang/Object;
.source "OneClickController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/account/OneClickController;->completed(Ljava/util/List;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/account/OneClickController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Ljava/util/List;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 570
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iput-object p2, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->val$value:Ljava/util/List;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 575
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->access$400(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 576
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->serviceCallCompleted()V
    invoke-static {v0}, Lcom/amazon/mShop/control/account/OneClickController;->access$500(Lcom/amazon/mShop/control/account/OneClickController;)V

    .line 577
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->val$value:Ljava/util/List;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->setOneClickAddresses(Ljava/util/List;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController;->access$600(Lcom/amazon/mShop/control/account/OneClickController;Ljava/util/List;)V

    .line 578
    iget-object v0, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    # getter for: Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;
    invoke-static {v0}, Lcom/amazon/mShop/control/account/OneClickController;->access$300(Lcom/amazon/mShop/control/account/OneClickController;)Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/control/account/OneClickController$2;->val$value:Ljava/util/List;

    invoke-interface {v0, v1}, Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;->onReceiveOneClickAddresses(Ljava/util/List;)V

    .line 580
    :cond_0
    return-void
.end method
