.class public Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;
.super Ljava/lang/Object;
.source "ProductRequest.java"


# instance fields
.field private asin:Ljava/lang/String;

.field private clickStreamOrigin:Ljava/lang/String;

.field private excludeImage:Ljava/lang/Boolean;

.field private maxImageDimension:I

.field private maxSwatchDimension:Ljava/lang/Integer;

.field private noPrefetchChildren:Ljava/lang/Boolean;

.field private offerId:Ljava/lang/String;

.field private offerListingsCount:I

.field private reviewsCount:I

.field private simsCount:Ljava/lang/Integer;

.field private variationChild:Z

.field private variationsModelOverride:Ljava/lang/Integer;


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
    .line 28
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->asin:Ljava/lang/String;

    return-object v0
.end method

.method public getClickStreamOrigin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->clickStreamOrigin:Ljava/lang/String;

    return-object v0
.end method

.method public getExcludeImage()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 120
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->excludeImage:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getMaxImageDimension()I
    .locals 1

    .prologue
    .line 51
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->maxImageDimension:I

    return v0
.end method

.method public getMaxSwatchDimension()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 133
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->maxSwatchDimension:Ljava/lang/Integer;

    return-object v0
.end method

.method public getNoPrefetchChildren()Ljava/lang/Boolean;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->noPrefetchChildren:Ljava/lang/Boolean;

    return-object v0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->offerId:Ljava/lang/String;

    return-object v0
.end method

.method public getOfferListingsCount()I
    .locals 1

    .prologue
    .line 71
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->offerListingsCount:I

    return v0
.end method

.method public getReviewsCount()I
    .locals 1

    .prologue
    .line 61
    iget v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->reviewsCount:I

    return v0
.end method

.method public getSimsCount()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 156
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->simsCount:Ljava/lang/Integer;

    return-object v0
.end method

.method public getVariationChild()Z
    .locals 1

    .prologue
    .line 94
    iget-boolean v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->variationChild:Z

    return v0
.end method

.method public getVariationsModelOverride()Ljava/lang/Integer;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->variationsModelOverride:Ljava/lang/Integer;

    return-object v0
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 33
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->asin:Ljava/lang/String;

    .line 34
    return-void
.end method

.method public setClickStreamOrigin(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 148
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->clickStreamOrigin:Ljava/lang/String;

    .line 149
    return-void
.end method

.method public setExcludeImage(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->excludeImage:Ljava/lang/Boolean;

    .line 126
    return-void
.end method

.method public setMaxImageDimension(I)V
    .locals 0
    .param p1, "value_"    # I

    .prologue
    .line 56
    iput p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->maxImageDimension:I

    .line 57
    return-void
.end method

.method public setMaxSwatchDimension(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->maxSwatchDimension:Ljava/lang/Integer;

    .line 139
    return-void
.end method

.method public setNoPrefetchChildren(Ljava/lang/Boolean;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Boolean;

    .prologue
    .line 112
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->noPrefetchChildren:Ljava/lang/Boolean;

    .line 113
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/String;

    .prologue
    .line 46
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->offerId:Ljava/lang/String;

    .line 47
    return-void
.end method

.method public setSimsCount(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 161
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->simsCount:Ljava/lang/Integer;

    .line 162
    return-void
.end method

.method public setVariationChild(Z)V
    .locals 0
    .param p1, "value_"    # Z

    .prologue
    .line 99
    iput-boolean p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->variationChild:Z

    .line 100
    return-void
.end method

.method public setVariationsModelOverride(Ljava/lang/Integer;)V
    .locals 0
    .param p1, "value_"    # Ljava/lang/Integer;

    .prologue
    .line 89
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/services/mShop/ProductRequest;->variationsModelOverride:Ljava/lang/Integer;

    .line 90
    return-void
.end method
