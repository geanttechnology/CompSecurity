.class Lcom/amazon/mShop/control/item/ProductController$DealListener$1;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$DealListener;->receivedDeal(Lcom/amazon/rio/j2me/client/services/mShop/Deal;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

.field final synthetic val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/Deal;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$DealListener;Lcom/amazon/rio/j2me/client/services/ServiceCall;Lcom/amazon/rio/j2me/client/services/mShop/Deal;)V
    .locals 0

    .prologue
    .line 2437
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iput-object p3, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2440
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->val$sc:Lcom/amazon/rio/j2me/client/services/ServiceCall;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$DealListener;->dealServiceCall:Lcom/amazon/rio/j2me/client/services/ServiceCall;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/ProductController$DealListener;->access$3700(Lcom/amazon/mShop/control/item/ProductController$DealListener;)Lcom/amazon/rio/j2me/client/services/ServiceCall;

    move-result-object v1

    if-ne v0, v1, :cond_0

    .line 2441
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/Deal;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setDeal(Lcom/amazon/rio/j2me/client/services/mShop/Deal;)V

    .line 2442
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$DealListener$1;->this$1:Lcom/amazon/mShop/control/item/ProductController$DealListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$DealListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyDealBlockUpdated()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$3100(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2444
    :cond_0
    return-void
.end method
