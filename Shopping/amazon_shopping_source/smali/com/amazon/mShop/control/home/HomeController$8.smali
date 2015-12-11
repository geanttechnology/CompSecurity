.class Lcom/amazon/mShop/control/home/HomeController$8;
.super Ljava/lang/Object;
.source "HomeController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/home/HomeController;->cancelled(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
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
    .line 592
    iput-object p1, p0, Lcom/amazon/mShop/control/home/HomeController$8;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 596
    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController$8;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    const/4 v4, 0x0

    # setter for: Lcom/amazon/mShop/control/home/HomeController;->serviceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v3, v4}, Lcom/amazon/mShop/control/home/HomeController;->access$602(Lcom/amazon/mShop/control/home/HomeController;Lcom/amazon/rio/j2me/client/services/ServiceCall;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .line 598
    new-instance v2, Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController$8;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->subscribers:Ljava/util/List;
    invoke-static {v3}, Lcom/amazon/mShop/control/home/HomeController;->access$200(Lcom/amazon/mShop/control/home/HomeController;)Ljava/util/List;

    move-result-object v3

    invoke-direct {v2, v3}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 599
    .local v2, "subscriberList":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/home/HomeSubscriber;>;"
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/control/home/HomeSubscriber;

    .line 600
    .local v1, "subscriber":Lcom/amazon/mShop/control/home/HomeSubscriber;
    invoke-interface {v1}, Lcom/amazon/mShop/control/home/HomeSubscriber;->onCancelled()V

    goto :goto_0

    .line 603
    .end local v1    # "subscriber":Lcom/amazon/mShop/control/home/HomeSubscriber;
    :cond_0
    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController$8;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # getter for: Lcom/amazon/mShop/control/home/HomeController;->doPhoneHomeAfterCancelComplete:Z
    invoke-static {v3}, Lcom/amazon/mShop/control/home/HomeController;->access$800(Lcom/amazon/mShop/control/home/HomeController;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 604
    iget-object v3, p0, Lcom/amazon/mShop/control/home/HomeController$8;->this$0:Lcom/amazon/mShop/control/home/HomeController;

    # invokes: Lcom/amazon/mShop/control/home/HomeController;->phoneHome()V
    invoke-static {v3}, Lcom/amazon/mShop/control/home/HomeController;->access$900(Lcom/amazon/mShop/control/home/HomeController;)V

    .line 606
    :cond_1
    return-void
.end method
