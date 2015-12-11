.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receivedPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V
    .locals 0

    .prologue
    .line 2019
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2023
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$1300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2024
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->setPrimeOneClickShippingOffers(Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->access$1600(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;)V

    .line 2025
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$5;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyProductUpdated()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$700(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2032
    :cond_0
    return-void
.end method
