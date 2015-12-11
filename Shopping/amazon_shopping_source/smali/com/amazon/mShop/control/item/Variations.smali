.class public Lcom/amazon/mShop/control/item/Variations;
.super Ljava/lang/Object;
.source "Variations.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/mShop/control/item/Variations$Child;,
        Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;
    }
.end annotation


# instance fields
.field private children:[Lcom/amazon/mShop/control/item/Variations$Child;

.field private final dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

.field private final mAvailableMessages:[Ljava/lang/String;

.field private final mPrices:[Ljava/lang/String;

.field private final productController:Lcom/amazon/mShop/control/item/ProductController;

.field private final swatchFetcher:Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/control/item/Variations$AttributeFetcher",
            "<[B>;"
        }
    .end annotation
.end field

.field private final valueFetcher:Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/amazon/mShop/control/item/Variations$AttributeFetcher",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private final variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

.field private visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/item/ProductController;[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;)V
    .locals 2
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "dimensions"    # [Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    .param p3, "variationProductInfos"    # [Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .param p4, "visualBuckets"    # [Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    .prologue
    const/4 v1, 0x0

    .line 49
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 474
    new-instance v0, Lcom/amazon/mShop/control/item/Variations$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/item/Variations$1;-><init>(Lcom/amazon/mShop/control/item/Variations;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->swatchFetcher:Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;

    .line 481
    new-instance v0, Lcom/amazon/mShop/control/item/Variations$2;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/item/Variations$2;-><init>(Lcom/amazon/mShop/control/item/Variations;)V

    iput-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->valueFetcher:Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;

    .line 50
    iput-object p1, p0, Lcom/amazon/mShop/control/item/Variations;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 51
    iput-object p2, p0, Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    .line 52
    iput-object p3, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    .line 53
    iput-object p4, p0, Lcom/amazon/mShop/control/item/Variations;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    .line 54
    invoke-static {p3}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 55
    iput-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mPrices:[Ljava/lang/String;

    .line 56
    iput-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mAvailableMessages:[Ljava/lang/String;

    .line 62
    :goto_0
    return-void

    .line 59
    :cond_0
    array-length v0, p3

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->mPrices:[Ljava/lang/String;

    .line 60
    array-length v0, p3

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->mAvailableMessages:[Ljava/lang/String;

    goto :goto_0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/control/item/Variations;)[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/Variations;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    return-object v0
.end method

.method static synthetic access$200(Lcom/amazon/mShop/control/item/Variations;)[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/Variations;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    return-object v0
.end method

.method static synthetic access$300(Lcom/amazon/mShop/control/item/Variations;)Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/Variations;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->valueFetcher:Lcom/amazon/mShop/control/item/Variations$AttributeFetcher;

    return-object v0
.end method

.method static synthetic access$500(Lcom/amazon/mShop/control/item/Variations;Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/Variations;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 27
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/Variations;->bestBucketMatchingCriteria(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$600(Lcom/amazon/mShop/control/item/Variations;)Lcom/amazon/mShop/control/item/ProductController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/control/item/Variations;

    .prologue
    .line 27
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->productController:Lcom/amazon/mShop/control/item/ProductController;

    return-object v0
.end method

.method private bestBucketMatchingCriteria(Ljava/util/List;)Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;"
        }
    .end annotation

    .prologue
    .line 451
    .local p1, "selectionCriteria":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v1, 0x0

    .line 452
    .local v1, "bestBucket":Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    const/4 v2, 0x0

    .line 454
    .local v2, "bestBucketScore":I
    const/4 v4, 0x0

    .local v4, "i":I
    :goto_0
    iget-object v6, p0, Lcom/amazon/mShop/control/item/Variations;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    array-length v6, v6

    if-ge v4, v6, :cond_2

    .line 455
    iget-object v6, p0, Lcom/amazon/mShop/control/item/Variations;->visualBuckets:[Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;

    aget-object v3, v6, v4

    .line 456
    .local v3, "bucket":Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;->getAttributes()Ljava/util/List;

    move-result-object v0

    .line 457
    .local v0, "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/control/item/Variations;->compareSelectionCriterias(Ljava/util/List;Ljava/util/List;)I

    move-result v5

    .line 458
    .local v5, "score":I
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v6

    if-ne v5, v6, :cond_0

    .line 465
    .end local v0    # "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    .end local v3    # "bucket":Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    .end local v5    # "score":I
    :goto_1
    return-object v3

    .line 460
    .restart local v0    # "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    .restart local v3    # "bucket":Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    .restart local v5    # "score":I
    :cond_0
    if-ge v2, v5, :cond_1

    .line 461
    move-object v1, v3

    .line 462
    move v2, v5

    .line 454
    :cond_1
    add-int/lit8 v4, v4, 0x1

    goto :goto_0

    .end local v0    # "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    .end local v3    # "bucket":Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;
    .end local v5    # "score":I
    :cond_2
    move-object v3, v1

    .line 465
    goto :goto_1
.end method

.method private compareSelectionCriterias(Ljava/util/List;Ljava/util/List;)I
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)I"
        }
    .end annotation

    .prologue
    .line 437
    .local p1, "a":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    .local p2, "b":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v2, 0x0

    .line 438
    .local v2, "score":I
    if-eqz p1, :cond_0

    if-nez p2, :cond_1

    :cond_0
    move v3, v2

    .line 447
    .end local v2    # "score":I
    .local v3, "score":I
    :goto_0
    return v3

    .line 440
    .end local v3    # "score":I
    .restart local v2    # "score":I
    :cond_1
    invoke-interface {p2}, Ljava/util/List;->size()I

    move-result v4

    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v5

    if-eq v4, v5, :cond_2

    move v3, v2

    .line 441
    .end local v2    # "score":I
    .restart local v3    # "score":I
    goto :goto_0

    .line 442
    .end local v3    # "score":I
    .restart local v2    # "score":I
    :cond_2
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    invoke-interface {p1}, Ljava/util/List;->size()I

    move-result v4

    if-ge v0, v4, :cond_4

    .line 443
    invoke-interface {p1, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    .line 444
    .local v1, "o":Ljava/lang/Object;
    if-eqz v1, :cond_3

    invoke-interface {p2, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 445
    add-int/lit8 v2, v2, 0x1

    .line 442
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1    # "o":Ljava/lang/Object;
    :cond_4
    move v3, v2

    .line 447
    .end local v2    # "score":I
    .restart local v3    # "score":I
    goto :goto_0
.end method

.method private getVariationProductInfoIndex(Ljava/lang/String;)I
    .locals 4
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    const/4 v2, -0x1

    .line 153
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    :cond_0
    move v0, v2

    .line 164
    :cond_1
    :goto_0
    return v0

    .line 156
    :cond_2
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    array-length v3, v3

    if-ge v0, v3, :cond_4

    .line 157
    iget-object v3, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    aget-object v1, v3, v0

    .line 158
    .local v1, "inf":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    if-eqz v1, :cond_3

    .line 159
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    .line 156
    :cond_3
    add-int/lit8 v0, v0, 0x1

    goto :goto_1

    .end local v1    # "inf":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    :cond_4
    move v0, v2

    .line 164
    goto :goto_0
.end method

.method private getVariationProductInfoIndex(Ljava/util/List;)I
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)I"
        }
    .end annotation

    .prologue
    .local p1, "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v3, -0x1

    .line 130
    iget-object v4, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty([Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v4

    if-eqz v4, :cond_2

    :cond_0
    move v1, v3

    .line 142
    :cond_1
    :goto_0
    return v1

    .line 133
    :cond_2
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    iget-object v4, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    array-length v4, v4

    if-ge v1, v4, :cond_4

    .line 134
    iget-object v4, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    aget-object v2, v4, v1

    .line 135
    .local v2, "inf":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    if-eqz v2, :cond_3

    .line 136
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;->getVariationAttributes()Ljava/util/List;

    move-result-object v0

    .line 137
    .local v0, "attr":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    invoke-virtual {p1, v0}, Ljava/lang/Object;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 133
    .end local v0    # "attr":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    :cond_3
    add-int/lit8 v1, v1, 0x1

    goto :goto_1

    .end local v2    # "inf":Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    :cond_4
    move v1, v3

    .line 142
    goto :goto_0
.end method


# virtual methods
.method public getAvailableMessage(Ljava/util/List;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 96
    .local p1, "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v0, 0x0

    .line 97
    .local v0, "availableMessage":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/Variations;->getVariationProductInfoIndex(Ljava/util/List;)I

    move-result v1

    .line 98
    .local v1, "index":I
    if-ltz v1, :cond_0

    .line 99
    iget-object v2, p0, Lcom/amazon/mShop/control/item/Variations;->mAvailableMessages:[Ljava/lang/String;

    aget-object v0, v2, v1

    .line 101
    :cond_0
    return-object v0
.end method

.method public getChildWithAsin(Ljava/lang/String;)Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 3
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 201
    invoke-static {p1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 202
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/Variations;->getChildren()[Lcom/amazon/mShop/control/item/Variations$Child;

    move-result-object v0

    .line 203
    .local v0, "c":[Lcom/amazon/mShop/control/item/Variations$Child;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    array-length v2, v0

    if-ge v1, v2, :cond_1

    .line 204
    aget-object v2, v0, v1

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/Variations$Child;->getAsin()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 205
    aget-object v2, v0, v1

    .line 209
    .end local v0    # "c":[Lcom/amazon/mShop/control/item/Variations$Child;
    .end local v1    # "i":I
    :goto_1
    return-object v2

    .line 203
    .restart local v0    # "c":[Lcom/amazon/mShop/control/item/Variations$Child;
    .restart local v1    # "i":I
    :cond_0
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 209
    .end local v0    # "c":[Lcom/amazon/mShop/control/item/Variations$Child;
    .end local v1    # "i":I
    :cond_1
    const/4 v2, 0x0

    goto :goto_1
.end method

.method public getChildren()[Lcom/amazon/mShop/control/item/Variations$Child;
    .locals 4

    .prologue
    .line 191
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->children:[Lcom/amazon/mShop/control/item/Variations$Child;

    if-nez v1, :cond_0

    .line 192
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    array-length v1, v1

    new-array v1, v1, [Lcom/amazon/mShop/control/item/Variations$Child;

    iput-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->children:[Lcom/amazon/mShop/control/item/Variations$Child;

    .line 193
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 194
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->children:[Lcom/amazon/mShop/control/item/Variations$Child;

    new-instance v2, Lcom/amazon/mShop/control/item/Variations$Child;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v0, v3}, Lcom/amazon/mShop/control/item/Variations$Child;-><init>(Lcom/amazon/mShop/control/item/Variations;ILcom/amazon/mShop/control/item/Variations$1;)V

    aput-object v2, v1, v0

    .line 193
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 197
    .end local v0    # "i":I
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->children:[Lcom/amazon/mShop/control/item/Variations$Child;

    return-object v1
.end method

.method public getDimensionLabels()[Ljava/lang/String;
    .locals 3

    .prologue
    .line 176
    iget-object v2, p0, Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    array-length v2, v2

    new-array v0, v2, [Ljava/lang/String;

    .line 177
    .local v0, "dimensionLabels":[Ljava/lang/String;
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    iget-object v2, p0, Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    array-length v2, v2

    if-ge v1, v2, :cond_0

    .line 178
    iget-object v2, p0, Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    aget-object v2, v2, v1

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/Dimension;->getDisplayLabel()Ljava/lang/String;

    move-result-object v2

    aput-object v2, v0, v1

    .line 177
    add-int/lit8 v1, v1, 0x1

    goto :goto_0

    .line 180
    :cond_0
    return-object v0
.end method

.method public getDimensions()[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;
    .locals 1

    .prologue
    .line 257
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->dimensions:[Lcom/amazon/rio/j2me/client/services/mShop/Dimension;

    return-object v0
.end method

.method public getPrice(Ljava/util/List;)Ljava/lang/String;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Ljava/lang/Integer;",
            ">;)",
            "Ljava/lang/String;"
        }
    .end annotation

    .prologue
    .line 70
    .local p1, "attributes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/Integer;>;"
    const/4 v1, 0x0

    .line 71
    .local v1, "price":Ljava/lang/String;
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/Variations;->getVariationProductInfoIndex(Ljava/util/List;)I

    move-result v0

    .line 72
    .local v0, "index":I
    if-ltz v0, :cond_0

    .line 73
    iget-object v2, p0, Lcom/amazon/mShop/control/item/Variations;->mPrices:[Ljava/lang/String;

    aget-object v1, v2, v0

    .line 75
    :cond_0
    return-object v1
.end method

.method public getVariationProductInfos()[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;
    .locals 1

    .prologue
    .line 352
    iget-object v0, p0, Lcom/amazon/mShop/control/item/Variations;->variationProductInfos:[Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;

    return-object v0
.end method

.method public setAvailableMessage(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "availableMessage"    # Ljava/lang/String;

    .prologue
    .line 110
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/Variations;->getVariationProductInfoIndex(Ljava/lang/String;)I

    move-result v0

    .line 111
    .local v0, "index":I
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mAvailableMessages:[Ljava/lang/String;

    if-eqz v1, :cond_0

    if-ltz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mAvailableMessages:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 112
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mAvailableMessages:[Ljava/lang/String;

    aput-object p2, v1, v0

    .line 114
    :cond_0
    return-void
.end method

.method public setPrice(Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .param p1, "asin"    # Ljava/lang/String;
    .param p2, "price"    # Ljava/lang/String;

    .prologue
    .line 84
    invoke-direct {p0, p1}, Lcom/amazon/mShop/control/item/Variations;->getVariationProductInfoIndex(Ljava/lang/String;)I

    move-result v0

    .line 85
    .local v0, "index":I
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mPrices:[Ljava/lang/String;

    if-eqz v1, :cond_0

    if-ltz v0, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mPrices:[Ljava/lang/String;

    array-length v1, v1

    if-ge v0, v1, :cond_0

    .line 86
    iget-object v1, p0, Lcom/amazon/mShop/control/item/Variations;->mPrices:[Ljava/lang/String;

    aput-object p2, v1, v0

    .line 88
    :cond_0
    return-void
.end method
