.class Lcom/amazon/mShop/control/account/OneClickController$3;
.super Ljava/lang/Object;
.source "OneClickController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/account/OneClickController;->completed(Ljava/lang/Boolean;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/account/OneClickController;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Ljava/lang/Boolean;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;Ljava/lang/Boolean;)V
    .locals 0

    .prologue
    .line 592
    iput-object p1, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iput-object p2, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->val$value:Ljava/lang/Boolean;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 597
    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->isRunningServiceCall(Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z
    invoke-static {v3, v4}, Lcom/amazon/mShop/control/account/OneClickController;->access$700(Lcom/amazon/mShop/control/account/OneClickController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 598
    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->serviceCallCompleted()V
    invoke-static {v3}, Lcom/amazon/mShop/control/account/OneClickController;->access$800(Lcom/amazon/mShop/control/account/OneClickController;)V

    .line 599
    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->val$value:Ljava/lang/Boolean;

    # invokes: Lcom/amazon/mShop/control/account/OneClickController;->setOneClickStatusEnabled(Ljava/lang/Boolean;)V
    invoke-static {v3, v4}, Lcom/amazon/mShop/control/account/OneClickController;->access$900(Lcom/amazon/mShop/control/account/OneClickController;Ljava/lang/Boolean;)V

    .line 600
    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->this$0:Lcom/amazon/mShop/control/account/OneClickController;

    # getter for: Lcom/amazon/mShop/control/account/OneClickController;->subscriber:Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;
    invoke-static {v3}, Lcom/amazon/mShop/control/account/OneClickController;->access$300(Lcom/amazon/mShop/control/account/OneClickController;)Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->val$value:Ljava/lang/Boolean;

    invoke-virtual {v4}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v4

    invoke-interface {v3, v4}, Lcom/amazon/mShop/control/account/OneClickController$OneClickSubscriber;->onSaveOneClickStatus(Z)V

    .line 601
    new-instance v2, Ljava/util/ArrayList;

    # getter for: Lcom/amazon/mShop/control/account/OneClickController;->sOneClickListeners:Ljava/util/List;
    invoke-static {}, Lcom/amazon/mShop/control/account/OneClickController;->access$1000()Ljava/util/List;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 602
    .local v2, "listeners":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/account/OneClickListener;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/account/OneClickListener;

    .line 603
    .local v1, "listener":Lcom/amazon/mShop/control/account/OneClickListener;
    iget-object v3, p0, Lcom/amazon/mShop/control/account/OneClickController$3;->val$value:Ljava/lang/Boolean;

    invoke-virtual {v3}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v3

    invoke-interface {v1, v3}, Lcom/amazon/mShop/control/account/OneClickListener;->oneClickStatusChanged(Z)V

    goto :goto_0

    .line 606
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "listener":Lcom/amazon/mShop/control/account/OneClickListener;
    .end local v2    # "listeners":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/account/OneClickListener;>;"
    :cond_0
    return-void
.end method
