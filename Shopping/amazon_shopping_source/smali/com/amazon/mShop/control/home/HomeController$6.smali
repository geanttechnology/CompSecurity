.class Lcom/amazon/mShop/control/home/HomeController$6;
.super Ljava/lang/Object;
.source "HomeController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/HomeController;->completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/control/home/HomeController;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/home/HomeController;)V
    .locals 0

    .prologue
    .line 515
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 8

    .prologue
    const/4 v7, 0x0

    .line 519
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v5

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->lastPhoneHomeTimeMillis:J
    invoke-static {v4, v5, v6}, Lcom/amazon/mShop/control/home/HomeController;->access$502(Lcom/amazon/mShop/control/home/HomeController;J)J

    .line 521
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v4, v7}, Lcom/amazon/mShop/control/home/HomeController;->access$602(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 524
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v4

    invoke-interface {v4}, Lcom/amazon/mShop/platform/Platform;->getDataStore()Lcom/amazon/rio/j2me/client/persistence/DataStore;

    move-result-object v0

    .line 525
    .local v0, "dataStore":Lcom/amazon/rio/j2me/client/persistence/DataStore;
    const-string/jumbo v4, "applicationExitReason"

    invoke-interface {v0, v4}, Lcom/amazon/rio/j2me/client/persistence/DataStore;->remove(Ljava/lang/String;)V

    .line 528
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z
    invoke-static {v4}, Lcom/amazon/mShop/control/home/HomeController;->access$400(Lcom/amazon/mShop/control/home/HomeController;)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 530
    invoke-static {}, Lcom/amazon/mShop/control/cart/CartController;->getInstance()Lcom/amazon/mShop/control/cart/CartController;

    move-result-object v4

    invoke-virtual {v4, v7}, Lcom/amazon/mShop/control/cart/CartController;->onCartReceivedFromHomeCall(Lcom/amazon/rio/j2me/client/services/mShop/CartItems;)V

    .line 531
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    const/4 v5, 0x0

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->loadingCart:Z
    invoke-static {v4, v5}, Lcom/amazon/mShop/control/home/HomeController;->access$402(Lcom/amazon/mShop/control/home/HomeController;Z)Z

    .line 534
    :cond_0
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->loginDataReceived:Z
    invoke-static {v4}, Lcom/amazon/mShop/control/home/HomeController;->access$000(Lcom/amazon/mShop/control/home/HomeController;)Z

    move-result v4

    if-nez v4, :cond_1

    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 537
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    const/4 v5, 0x1

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->forcingUserSignOut:Z
    invoke-static {v4, v5}, Lcom/amazon/mShop/control/home/HomeController;->access$702(Lcom/amazon/mShop/control/home/HomeController;Z)Z

    .line 538
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->userSignedOut()V

    .line 541
    :cond_1
    new-instance v3, Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;
    invoke-static {v4}, Lcom/amazon/mShop/control/home/HomeController;->access$200(Lcom/amazon/mShop/control/home/HomeController;)Ljava/util/List;

    move-result-object v4

    invoke-direct {v3, v4}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 542
    .local v3, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/home/HomeSubscriber;>;"
    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .local v1, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v4

    if-eqz v4, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 543
    .local v2, "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    invoke-interface {v2}, Lcom/amazon/mShop/control/home/HomeSubscriber;->onPageComplete()V

    goto :goto_0

    .line 546
    .end local v2    # "sub":Lcom/amazon/mShop/control/home/HomeSubscriber;
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->doPhoneHomeAfterCancelComplete:Z
    invoke-static {v4}, Lcom/amazon/mShop/control/home/HomeController;->access$800(Lcom/amazon/mShop/control/home/HomeController;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 547
    iget-object v4, p0, Lcom/amazon/mShop/control/home/HomeController$6;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # invokes: Lcom/amazon/mShop/control/home/HomeController;->phoneHome()V
    invoke-static {v4}, Lcom/amazon/mShop/control/home/HomeController;->access$900(Lcom/amazon/mShop/control/home/HomeController;)V

    .line 549
    :cond_3
    return-void
.end method
