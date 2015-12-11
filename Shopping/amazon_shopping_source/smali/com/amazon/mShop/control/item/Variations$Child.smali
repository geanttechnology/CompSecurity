.class public Lcom/amazon/mShop/control/item/Variations$Child;
.super Ljava/lang/Object;
.source "Variations.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/control/item/Variations;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "Child"
.end annotation


# instance fields
.field public final index:I

.field final synthetic this$0:Lcom/amazon/mShop/control/item/Variations;


# direct methods
.method private constructor <init>(Lcom/amazon/mShop/control/item/Variations;I)V
    .locals 0
    .param p2, "variationProductInfoIndex"    # I

    .prologue
    .line 492
    iput-object p1, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 493
    iput p2, p0, Lcom/amazon/mShop/control/item/Variations$Child;->index:I

    .line 494
    return-void
.end method

.method synthetic constructor <init>(Lcom/amazon/mShop/control/item/Variations;ILcom/amazon/mShop/control/item/Variations$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/amazon/mShop/control/item/Variations;
    .param p2, "x1"    # I
    .param p3, "x2"    # Lcom/amazon/mShop/control/item/Variations$1;

    .prologue
    .line 490
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/control/item/Variations$Child;-><init>(Lcom/amazon/mShop/control/item/Variations;I)V

    return-void
.end method

.method private getAttributes(Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;[Ljava/lang/Object;)V
    .locals 5
    .param p2, "attributes"    # [Ljava/lang/Object;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<T:",
            "Ljava/lang/Object;",
            ">(",
            "Lcom/amazon/mShop/control/item/Variations$AttributeFetcher",
            "<TT;>;[",
            "Ljava/lang/Object;",
            ")V"
        }
    .end annotation

    .prologue
    .line 522
    .local p1, "attributeFetcher":Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;, "Lcom/amazon/mShop/control/item/Variations$AttributeFetcher<TT;>;"
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getSelectionCriteria()Ljava/util/List;

    move-result-object v2

    .line 523
    .local v2, "selectionCriteria":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # getter for: Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    invoke-static {v4}, Lcom/amazon/mShop/control/item/Variations;->access$100(Lcom/amazon/mShop/control/item/Variations;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v4

    array-length v4, v4

    if-ge v1, v4, :cond_1

    .line 524
    invoke-interface {p1, v1}, Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;->getAttributes(I)Ljava/util/List;

    move-result-object v0

    .line 525
    .local v0, "dimensionAttributes":Ljava/util/List;, "Ljava/util/List<TT;>;"
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v4

    if-nez v4, :cond_0

    .line 526
    invoke-interface {v2, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Ljava/lang/Integer;

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v3

    .line 527
    .local v3, "selectionIndex":I
    const/4 v4, -0x1

    if-ge v4, v3, :cond_0

    .line 528
    invoke-interface {v0, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    aput-object v4, p2, v1

    .line 523
    .end local v3    # "selectionIndex":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 532
    .end local v0    # "dimensionAttributes":Ljava/util/List;, "Ljava/util/List<TT;>;"
    :cond_1
    return-void
.end method

.method private getSelectionCriteria()Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;"
        }
    .end annotation

    .prologue
    .line 517
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getVariationProductInfo()Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getVariationAttributes()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 2

    .prologue
    .line 607
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getVariationProductInfo()Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v0

    .line 608
    .local v0, "variationProductInfo":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v1

    return-object v1
.end method

.method public getAttributeNames()[Ljava/lang/String;
    .locals 2

    .prologue
    .line 540
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # getter for: Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/Variations;->access$100(Lcom/amazon/mShop/control/item/Variations;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    move-result-object v1

    array-length v1, v1

    new-array v0, v1, [Ljava/lang/String;

    .line 541
    .local v0, "names":[Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # getter for: Lcom/amazon/mShop/control/item/Variations;->valueFetcher:Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;
    invoke-static {v1}, Lcom/amazon/mShop/control/item/Variations;->access$300(Lcom/amazon/mShop/control/item/Variations;)Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;

    move-result-object v1

    invoke-direct {p0, v1, v0}, Lcom/amazon/mShop/control/item/Variations$Child;->getAttributes(Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;[Ljava/lang/Object;)V

    .line 542
    return-object v0
.end method

.method public getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 2

    .prologue
    .line 602
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getVariationProductInfo()Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v0

    .line 603
    .local v0, "variationProductInfo":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    return-object v1
.end method

.method public getImage()[B
    .locals 4

    .prologue
    .line 563
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getSelectionCriteria()Ljava/util/List;

    move-result-object v2

    .line 564
    .local v2, "selectionCriteria":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # invokes: Lcom/amazon/mShop/control/item/Variations;->bestBucketMatchingCriteria(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    invoke-static {v3, v2}, Lcom/amazon/mShop/control/item/Variations;->access$500(Lcom/amazon/mShop/control/item/Variations;Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    move-result-object v0

    .line 565
    .local v0, "bucket":Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    if-eqz v0, :cond_2

    .line 566
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->getBestImage()[B

    move-result-object v1

    .line 567
    .local v1, "image":[B
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v3

    if-nez v3, :cond_1

    .line 579
    .end local v1    # "image":[B
    :cond_0
    :goto_0
    return-object v1

    .line 569
    .restart local v1    # "image":[B
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->getSameAsBucket()Ljava/util/List;

    move-result-object v2

    .line 570
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # invokes: Lcom/amazon/mShop/control/item/Variations;->bestBucketMatchingCriteria(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    invoke-static {v3, v2}, Lcom/amazon/mShop/control/item/Variations;->access$500(Lcom/amazon/mShop/control/item/Variations;Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    move-result-object v0

    .line 571
    if-eqz v0, :cond_2

    .line 572
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->getBestImage()[B

    move-result-object v1

    .line 573
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty([B)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 579
    .end local v1    # "image":[B
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 4

    .prologue
    .line 583
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getSelectionCriteria()Ljava/util/List;

    move-result-object v2

    .line 584
    .local v2, "selectionCriteria":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # invokes: Lcom/amazon/mShop/control/item/Variations;->bestBucketMatchingCriteria(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    invoke-static {v3, v2}, Lcom/amazon/mShop/control/item/Variations;->access$500(Lcom/amazon/mShop/control/item/Variations;Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    move-result-object v0

    .line 585
    .local v0, "bucket":Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    if-eqz v0, :cond_2

    .line 586
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->getBestImageUrl()Ljava/lang/String;

    move-result-object v1

    .line 587
    .local v1, "imageUrl":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 597
    .end local v1    # "imageUrl":Ljava/lang/String;
    :cond_0
    :goto_0
    return-object v1

    .line 589
    .restart local v1    # "imageUrl":Ljava/lang/String;
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->getSameAsBucket()Ljava/util/List;

    move-result-object v2

    .line 590
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # invokes: Lcom/amazon/mShop/control/item/Variations;->bestBucketMatchingCriteria(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    invoke-static {v3, v2}, Lcom/amazon/mShop/control/item/Variations;->access$500(Lcom/amazon/mShop/control/item/Variations;Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    move-result-object v0

    .line 591
    if-eqz v0, :cond_2

    .line 592
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->getBestImageUrl()Ljava/lang/String;

    move-result-object v1

    .line 593
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 597
    .end local v1    # "imageUrl":Ljava/lang/String;
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # getter for: Lcom/amazon/mShop/control/item/Variations;->productController:Lcom/amazon/mShop/control/item/ProductController;
    invoke-static {v3}, Lcom/amazon/mShop/control/item/Variations;->access$600(Lcom/amazon/mShop/control/item/Variations;)Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v3

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # getter for: Lcom/amazon/mShop/control/item/Variations;->productController:Lcom/amazon/mShop/control/item/ProductController;
    invoke-static {v3}, Lcom/amazon/mShop/control/item/Variations;->access$600(Lcom/amazon/mShop/control/item/Variations;)Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ProductController;->getImageUrl()Ljava/lang/String;

    move-result-object v3

    :goto_1
    move-object v1, v3

    goto :goto_0

    :cond_3
    const/4 v3, 0x0

    goto :goto_1
.end method

.method public getVariationProductInfo()Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .locals 2

    .prologue
    .line 497
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations$Child;->this$0:Lcom/amazon/mShop/control/item/Variations;

    # getter for: Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    invoke-static {v0}, Lcom/amazon/mShop/control/item/Variations;->access$200(Lcom/amazon/mShop/control/item/Variations;)[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/control/item/Variations$Child;->index:I

    aget-object v0, v0, v1

    return-object v0
.end method

.method public toString()Ljava/lang/String;
    .locals 5

    .prologue
    .line 617
    new-instance v0, Ljava/lang/StringBuffer;

    invoke-direct {v0}, Ljava/lang/StringBuffer;-><init>()V

    .line 618
    .local v0, "b":Ljava/lang/StringBuffer;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getAttributeNames()[Ljava/lang/String;

    move-result-object v1

    .line 619
    .local v1, "names":[Ljava/lang/String;
    const-string/jumbo v4, " - "

    invoke-static {v1, v0, v4}, Lcom/amazon/mShop/util/Util;->join([Ljava/lang/String;Ljava/lang/StringBuffer;Ljava/lang/String;)V

    .line 620
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/Variations$Child;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v2

    .line 621
    .local v2, "offer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v2, :cond_0

    .line 622
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceViolatesMap()Z

    move-result v4

    if-nez v4, :cond_0

    .line 623
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v3

    .line 624
    .local v3, "price":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-nez v4, :cond_0

    .line 625
    const-string/jumbo v4, ": "

    invoke-virtual {v0, v4}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 626
    invoke-virtual {v0, v3}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 630
    .end local v3    # "price":Ljava/lang/String;
    :cond_0
    invoke-virtual {v0}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v4

    return-object v4
.end method
