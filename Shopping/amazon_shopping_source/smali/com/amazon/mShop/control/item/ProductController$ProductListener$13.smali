.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->receivedExtraOffer(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

.field final synthetic val$value:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V
    .locals 0

    .prologue
    .line 2281
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iput-object p2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 2284
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$1300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2285
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;->val$value:Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setExtraOfferListing(Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V

    .line 2286
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$13;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyProductUpdated()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$700(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2288
    :cond_0
    return-void
.end method
