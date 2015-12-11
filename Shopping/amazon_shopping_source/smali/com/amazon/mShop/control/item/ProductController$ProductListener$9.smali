.class Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;
.super Ljava/lang/Object;
.source "ProductController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/mShop/control/item/ProductController$ProductListener;->completed(Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;


# direct methods
.method constructor <init>(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)V
    .locals 0

    .prologue
    .line 2160
    iput-object p1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 2165
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->cancelled:Z
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$1300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2168
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    const/4 v1, 0x1

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->setPrimeOneClickShippineOffersReceived(Z)V
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->access$1900(Lcom/amazon/mShop/control/item/ProductController;Z)V

    .line 2172
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyProductUpdated()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$700(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2174
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2000(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2100(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2178
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    new-instance v1, Lcom/amazon/mShop/control/item/Variations;

    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v2, v2, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    invoke-static {v3}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2000(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-static {v4}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2100(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    invoke-static {v5}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    move-result-object v5

    invoke-direct {v1, v2, v3, v4, v5}, Lcom/amazon/mShop/control/item/Variations;-><init>(Lcom/amazon/mShop/control/item/ProductController;[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;)V

    # setter for: Lcom/amazon/mShop/control/item/ProductController;->variations:Lcom/amazon/mShop/control/item/Variations;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->access$2202(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/Variations;)Lcom/amazon/mShop/control/item/Variations;

    .line 2179
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v1, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v1, v1, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v2, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    invoke-static {v2}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2000(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-static {v3}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2100(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v3

    iget-object v4, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    # getter for: Lcom/amazon/mShop/control/item/ProductController$ProductListener;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    invoke-static {v4}, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->access$2300(Lcom/amazon/mShop/control/item/ProductController$ProductListener;)[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    move-result-object v4

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->getPreselectedVariationChild([Lcom/amazon/rio/j2me/client/services/mShop/Dimension;[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;)Lcom/amazon/mShop/control/item/Variations$Child;
    invoke-static {v1, v2, v3, v4}, Lcom/amazon/mShop/control/item/ProductController;->access$2400(Lcom/amazon/mShop/control/item/ProductController;[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;)Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v1

    # setter for: Lcom/amazon/mShop/control/item/ProductController;->selectedChild:Lcom/amazon/mShop/control/item/Variations$Child;
    invoke-static {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->access$1102(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/mShop/control/item/Variations$Child;)Lcom/amazon/mShop/control/item/Variations$Child;

    .line 2185
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->getDealId()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_2

    .line 2186
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$2500(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/control/item/ProductController$DealListener;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 2187
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # getter for: Lcom/amazon/mShop/control/item/ProductController;->mDealListener:Lcom/amazon/mShop/control/item/ProductController$DealListener;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$2500(Lcom/amazon/mShop/control/item/ProductController;)Lcom/amazon/mShop/control/item/ProductController$DealListener;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController$DealListener;->cancel()V

    .line 2189
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0, v6}, Lcom/amazon/mShop/control/item/ProductController;->setDeal(Lcom/amazon/rio/j2me/client/services/mShop/Deal;)V

    .line 2192
    :cond_2
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # setter for: Lcom/amazon/mShop/control/item/ProductController;->mPendingDealId:Ljava/lang/String;
    invoke-static {v0, v6}, Lcom/amazon/mShop/control/item/ProductController;->access$2602(Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;)Ljava/lang/String;

    .line 2194
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->notifyServiceCallComplete()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$800(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2196
    iget-object v0, p0, Lcom/amazon/mShop/control/item/ProductController$ProductListener$9;->this$1:Lcom/amazon/mShop/control/item/ProductController$ProductListener;

    iget-object v0, v0, Lcom/amazon/mShop/control/item/ProductController$ProductListener;->this$0:Lcom/amazon/mShop/control/item/ProductController;

    # invokes: Lcom/amazon/mShop/control/item/ProductController;->productRequestEnded()V
    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->access$900(Lcom/amazon/mShop/control/item/ProductController;)V

    .line 2202
    return-void
.end method
