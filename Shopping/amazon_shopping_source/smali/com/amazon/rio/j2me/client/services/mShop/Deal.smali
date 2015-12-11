.class public Lcom/amazon/rio/j2me/client/services/mShop/Deal;
.super Ljava/lang/Object;
.source "Deal.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private averageOverallRating:Ljava/lang/Integer;

.field private customerPurchaseStatus:Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;

.field private customerReviewsCount:Ljava/lang/Integer;

.field private dealId:Ljava/lang/String;

.field private dealVariationChildren:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;",
            ">;"
        }
    .end annotation
.end field

.field private dealVariationDimensions:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Dimension;",
            ">;"
        }
    .end annotation
.end field

.field private desc:Ljava/lang/String;

.field private eligibleForPrimeShipping:Ljava/lang/Boolean;

.field private endTime:Ljava/lang/Integer;

.field private image:[B

.field private imageName:Ljava/lang/String;

.field private isRedeemedToCustomer:Ljava/lang/Boolean;

.field private isSoldOut:Ljava/lang/Boolean;

.field private msToCacheExpires:Ljava/lang/Integer;

.field private msToEnd:Ljava/lang/Integer;

.field private msToStart:Ljava/lang/Integer;

.field private offerId:Ljava/lang/String;

.field private percentageSold:Ljava/lang/Integer;

.field private priceViolatesMap:Ljava/lang/Boolean;

.field private savings:Lcom/amazon/rio/j2me/client/services/mShop/Savings;

.field private startTime:Ljava/lang/Integer;

.field private title:Ljava/lang/String;

.field private totalAvailable:Ljava/lang/String;

.field private url:Ljava/lang/String;

.field private visualBuckets:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;",
            ">;"
        }
    .end annotation
.end field


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
    .line 45
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 71
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->dealId:Ljava/lang/String;

    return-object v0
.end method

.method public getImage()[B
    .locals 1

    .prologue
    .line 318
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->image:[B

    return-object v0
.end method

.method public getMsToEnd()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 201
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->msToEnd:Ljava/lang/Integer;

    return-object v0
.end method

.method public getMsToStart()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 175
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->msToStart:Ljava/lang/Integer;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;
    .locals 1

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->savings:Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->title:Ljava/lang/String;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 50
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->asin:Ljava/lang/String;

    .line 51
    return-void
.end method

.method public setAverageOverallRating(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 271
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->averageOverallRating:Ljava/lang/Integer;

    .line 272
    return-void
.end method

.method public setCustomerPurchaseStatus(Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;

    .prologue
    .line 258
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->customerPurchaseStatus:Lcom/amazon/rio/j2me/client/services/mShop/CustomerDealPurchaseStatus;

    .line 259
    return-void
.end method

.method public setCustomerReviewsCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 284
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->customerReviewsCount:Ljava/lang/Integer;

    .line 285
    return-void
.end method

.method public setDealId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 76
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->dealId:Ljava/lang/String;

    .line 77
    return-void
.end method

.method public setDealVariationChildren(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 362
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VariationProductInfo;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->dealVariationChildren:Ljava/util/List;

    .line 363
    return-void
.end method

.method public setDealVariationDimensions(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/Dimension;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 349
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/Dimension;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->dealVariationDimensions:Ljava/util/List;

    .line 350
    return-void
.end method

.method public setDesc(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 102
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->desc:Ljava/lang/String;

    .line 103
    return-void
.end method

.method public setEligibleForPrimeShipping(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 297
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->eligibleForPrimeShipping:Ljava/lang/Boolean;

    .line 298
    return-void
.end method

.method public setEndTime(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 219
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->endTime:Ljava/lang/Integer;

    .line 220
    return-void
.end method

.method public setImage([B)V
    .locals 0
    .param p1, "value_"    # [B

    .prologue
    .line 323
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->image:[B

    .line 324
    return-void
.end method

.method public setImageName(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 336
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->imageName:Ljava/lang/String;

    .line 337
    return-void
.end method

.method public setIsRedeemedToCustomer(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 115
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->isRedeemedToCustomer:Ljava/lang/Boolean;

    .line 116
    return-void
.end method

.method public setIsSoldOut(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 128
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->isSoldOut:Ljava/lang/Boolean;

    .line 129
    return-void
.end method

.method public setMsToCacheExpires(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 167
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->msToCacheExpires:Ljava/lang/Integer;

    .line 168
    return-void
.end method

.method public setMsToEnd(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 206
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->msToEnd:Ljava/lang/Integer;

    .line 207
    return-void
.end method

.method public setMsToStart(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 180
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->msToStart:Ljava/lang/Integer;

    .line 181
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 63
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->offerId:Ljava/lang/String;

    .line 64
    return-void
.end method

.method public setPercentageSold(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 141
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->percentageSold:Ljava/lang/Integer;

    .line 142
    return-void
.end method

.method public setPriceViolatesMap(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 310
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->priceViolatesMap:Ljava/lang/Boolean;

    .line 311
    return-void
.end method

.method public setSavings(Lcom/amazon/rio/j2me/client/services/mShop/Savings;)V
    .locals 0
    .param p1, "value_"    # Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    .prologue
    .line 232
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->savings:Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    .line 233
    return-void
.end method

.method public setStartTime(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 193
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->startTime:Ljava/lang/Integer;

    .line 194
    return-void
.end method

.method public setTitle(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->title:Ljava/lang/String;

    .line 90
    return-void
.end method

.method public setTotalAvailable(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 154
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->totalAvailable:Ljava/lang/String;

    .line 155
    return-void
.end method

.method public setUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 245
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->url:Ljava/lang/String;

    .line 246
    return-void
.end method

.method public setVisualBuckets(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 375
    .local p1, "value_":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/VisualBucket;>;"
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/Deal;->visualBuckets:Ljava/util/List;

    .line 376
    return-void
.end method
