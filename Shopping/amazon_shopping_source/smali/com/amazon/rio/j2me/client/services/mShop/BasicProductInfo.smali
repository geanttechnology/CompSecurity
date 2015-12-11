.class public Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
.super Ljava/lang/Object;
.source "BasicProductInfo.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private availabilityCondition:I

.field private averageOverallRating:Ljava/lang/Integer;

.field private bindingSymbol:Ljava/lang/String;

.field private blackCurtain:Ljava/lang/Boolean;

.field private byLine:Ljava/lang/String;

.field private customerReviewsCount:I

.field private defaultParent:Ljava/lang/Boolean;

.field private imageUrl:Ljava/lang/String;

.field private imagesCount:I

.field private listPrice:Ljava/lang/String;

.field private newSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

.field private productGroupId:Ljava/lang/String;

.field private shortDescription:Ljava/lang/String;

.field private title:Ljava/lang/String;

.field private tradeInPrice:Ljava/lang/String;

.field private usedAndNewSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

.field private variationParentAsin:Ljava/lang/String;

.field private variationPriceRange:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getAvailabilityCondition()I
    .locals 1

    .prologue
    .line 120
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->availabilityCondition:I

    return v0
.end method

.method public getAverageOverallRating()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 221
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->averageOverallRating:Ljava/lang/Integer;

    return-object v0
.end method

.method public getBindingSymbol()Ljava/lang/String;
    .locals 1

    .prologue
    .line 97
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->bindingSymbol:Ljava/lang/String;

    return-object v0
.end method

.method public getBlackCurtain()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 244
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->blackCurtain:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getByLine()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->byLine:Ljava/lang/String;

    return-object v0
.end method

.method public getCustomerReviewsCount()I
    .locals 1

    .prologue
    .line 231
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->customerReviewsCount:I

    return v0
.end method

.method public getImageUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 110
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->imageUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getListPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->listPrice:Ljava/lang/String;

    return-object v0
.end method

.method public getProductGroupId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->productGroupId:Ljava/lang/String;

    return-object v0
.end method

.method public getShortDescription()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->shortDescription:Ljava/lang/String;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 45
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->title:Ljava/lang/String;

    return-object v0
.end method

.method public getUsedAndNewSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    .locals 1

    .prologue
    .line 185
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->usedAndNewSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    return-object v0
.end method

.method public getVariationParentAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 146
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->variationParentAsin:Ljava/lang/String;

    return-object v0
.end method

.method public getVariationPriceRange()Ljava/lang/String;
    .locals 1

    .prologue
    .line 159
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->variationPriceRange:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 40
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->asin:Ljava/lang/String;

    .line 41
    return-void
.end method

.method public setAvailabilityCondition(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 125
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->availabilityCondition:I

    .line 126
    return-void
.end method

.method public setAverageOverallRating(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->averageOverallRating:Ljava/lang/Integer;

    .line 227
    return-void
.end method

.method public setBindingSymbol(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->bindingSymbol:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setBlackCurtain(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 249
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->blackCurtain:Ljava/lang/Boolean;

    .line 250
    return-void
.end method

.method public setByLine(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->byLine:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setCustomerReviewsCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 236
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->customerReviewsCount:I

    .line 237
    return-void
.end method

.method public setDefaultParent(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 177
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->defaultParent:Ljava/lang/Boolean;

    .line 178
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->imageUrl:Ljava/lang/String;

    .line 116
    return-void
.end method

.method public setImagesCount(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 213
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->imagesCount:I

    .line 214
    return-void
.end method

.method public setListPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->listPrice:Ljava/lang/String;

    .line 139
    return-void
.end method

.method public setNewSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .prologue
    .line 203
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->newSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .line 204
    return-void
.end method

.method public setProductGroupId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->productGroupId:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setShortDescription(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->shortDescription:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->title:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setTradeInPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 262
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->tradeInPrice:Ljava/lang/String;

    .line 263
    return-void
.end method

.method public setUsedAndNewSummary(Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .prologue
    .line 190
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->usedAndNewSummary:Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    .line 191
    return-void
.end method

.method public setVariationParentAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 151
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->variationParentAsin:Ljava/lang/String;

    .line 152
    return-void
.end method

.method public setVariationPriceRange(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 164
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->variationPriceRange:Ljava/lang/String;

    .line 165
    return-void
.end method
