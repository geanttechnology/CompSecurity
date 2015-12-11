.class public Lcom/amazon/mShop/wearable/model/WearableSearchResult;
.super Ljava/lang/Object;
.source "WearableSearchResult.java"

# interfaces
.implements Ljava/io/Serializable;


# instance fields
.field addOnItem:Z

.field asin:Ljava/lang/String;

.field avgRating:F

.field badge:Ljava/lang/String;

.field bindingSymbol:Ljava/lang/String;

.field buyable:Z

.field deliveryDate:Ljava/lang/String;

.field group:Ljava/lang/String;

.field icon:Ljava/lang/String;

.field id:Ljava/lang/String;

.field imageUrl:Ljava/lang/String;

.field merchantId:Ljava/lang/String;

.field name:Ljava/lang/String;

.field offerId:Ljava/lang/String;

.field oneClickEnabled:Z

.field outOfStock:Z

.field price:Ljava/lang/String;

.field prime:Z

.field reviewCount:I

.field shippingCost:Ljava/lang/String;

.field shippingOffer:Ljava/lang/String;

.field variations:Z


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 81
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 11
    invoke-static {}, Ljava/util/UUID;->randomUUID()Ljava/util/UUID;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->id:Ljava/lang/String;

    .line 16
    const/4 v0, 0x0

    iput v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->avgRating:F

    .line 17
    iput v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->reviewCount:I

    .line 18
    iput-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->prime:Z

    .line 19
    iput-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->oneClickEnabled:Z

    .line 20
    iput-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->buyable:Z

    .line 31
    iput-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->outOfStock:Z

    .line 32
    iput-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->variations:Z

    .line 33
    iput-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->addOnItem:Z

    .line 82
    return-void
.end method

.method public static isDigital(Ljava/lang/String;)Z
    .locals 3
    .param p0, "group"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 271
    if-nez p0, :cond_1

    .line 290
    :cond_0
    :goto_0
    return v1

    .line 274
    :cond_1
    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {p0, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    .line 275
    .local v0, "groupIdLowerCase":Ljava/lang/String;
    const-string/jumbo v2, "generic"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "wir_plan_option_display_on_website"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "wir_bundle_display_on_website"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "wir_plan_display_on_website"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "magazine_display"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "video_rental"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "digital"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "kindle"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "mp3"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "download"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "ebooks"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "mobile_application"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string/jumbo v2, "audible"

    invoke-virtual {v0, v2}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 288
    :cond_2
    const/4 v1, 0x1

    goto :goto_0
.end method


# virtual methods
.method public determineBuyable()V
    .locals 2

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->group:Ljava/lang/String;

    invoke-static {v0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->isDigital(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 255
    :cond_0
    :goto_0
    return-void

    .line 231
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->getPrice()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_2

    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->getPrice()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "-"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 237
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->getPrice()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->getPrice()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 242
    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->isVariations()Z

    move-result v0

    if-nez v0, :cond_0

    .line 246
    iget-boolean v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->outOfStock:Z

    if-nez v0, :cond_0

    .line 250
    invoke-virtual {p0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->isPantryItem()Z

    move-result v0

    if-nez v0, :cond_0

    .line 254
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setBuyable(Z)V

    goto :goto_0
.end method

.method public getPrice()Ljava/lang/String;
    .locals 1

    .prologue
    .line 121
    iget-object v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->price:Ljava/lang/String;

    return-object v0
.end method

.method public isPantryItem()Z
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->badge:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->badge:Ljava/lang/String;

    const-string/jumbo v1, "PRIME_PANTRY"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    .line 43
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isVariations()Z
    .locals 1

    .prologue
    .line 149
    iget-boolean v0, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->variations:Z

    return v0
.end method

.method public setAddOnItem(Z)V
    .locals 0
    .param p1, "addOnItem"    # Z

    .prologue
    .line 54
    iput-boolean p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->addOnItem:Z

    .line 55
    return-void
.end method

.method public setAsin(Ljava/lang/String;)V
    .locals 0
    .param p1, "asin"    # Ljava/lang/String;

    .prologue
    .line 109
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->asin:Ljava/lang/String;

    .line 110
    return-void
.end method

.method public setAvgRating(F)V
    .locals 0
    .param p1, "avgRating"    # F

    .prologue
    .line 141
    iput p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->avgRating:F

    .line 142
    return-void
.end method

.method public setBadge(Ljava/lang/String;)V
    .locals 0
    .param p1, "badge"    # Ljava/lang/String;

    .prologue
    .line 62
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->badge:Ljava/lang/String;

    .line 63
    return-void
.end method

.method public setBindingSymbol(Ljava/lang/String;)V
    .locals 0
    .param p1, "bindingSymbol"    # Ljava/lang/String;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->bindingSymbol:Ljava/lang/String;

    .line 71
    return-void
.end method

.method public setBuyable(Z)V
    .locals 0
    .param p1, "buyable"    # Z

    .prologue
    .line 97
    iput-boolean p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->buyable:Z

    .line 98
    return-void
.end method

.method public setGroup(Ljava/lang/String;)V
    .locals 0
    .param p1, "group"    # Ljava/lang/String;

    .prologue
    .line 101
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->group:Ljava/lang/String;

    .line 102
    return-void
.end method

.method public setImageUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "imageUrl"    # Ljava/lang/String;

    .prologue
    .line 173
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->imageUrl:Ljava/lang/String;

    .line 174
    return-void
.end method

.method public setName(Ljava/lang/String;)V
    .locals 0
    .param p1, "name"    # Ljava/lang/String;

    .prologue
    .line 117
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->name:Ljava/lang/String;

    .line 118
    return-void
.end method

.method public setOfferId(Ljava/lang/String;)V
    .locals 0
    .param p1, "offerId"    # Ljava/lang/String;

    .prologue
    .line 189
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->offerId:Ljava/lang/String;

    .line 190
    return-void
.end method

.method public setOutOfStock(Z)V
    .locals 0
    .param p1, "outOfStock"    # Z

    .prologue
    .line 262
    iput-boolean p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->outOfStock:Z

    .line 263
    return-void
.end method

.method public setPrice(Ljava/lang/String;)V
    .locals 0
    .param p1, "price"    # Ljava/lang/String;

    .prologue
    .line 125
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->price:Ljava/lang/String;

    .line 126
    return-void
.end method

.method public setPrime(Z)V
    .locals 0
    .param p1, "isPrime"    # Z

    .prologue
    .line 157
    iput-boolean p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->prime:Z

    .line 158
    return-void
.end method

.method public setReviewCount(I)V
    .locals 0
    .param p1, "reviewCount"    # I

    .prologue
    .line 213
    iput p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->reviewCount:I

    .line 214
    return-void
.end method

.method public setShippingCost(Ljava/lang/String;)V
    .locals 0
    .param p1, "shippingCost"    # Ljava/lang/String;

    .prologue
    .line 78
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->shippingCost:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public setShippingOffer(Ljava/lang/String;)V
    .locals 0
    .param p1, "shippingOffer"    # Ljava/lang/String;

    .prologue
    .line 197
    iput-object p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->shippingOffer:Ljava/lang/String;

    .line 198
    return-void
.end method

.method public setVariations(Z)V
    .locals 0
    .param p1, "variations"    # Z

    .prologue
    .line 153
    iput-boolean p1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->variations:Z

    .line 154
    return-void
.end method

.method public toString()Ljava/lang/String;
    .locals 2

    .prologue
    .line 218
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "WearableSearchResult [id="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->id:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", asin="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->asin:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", name="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->name:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", price="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->price:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", avgRating="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->avgRating:F

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(F)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", reviewCount="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->reviewCount:I

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", prime="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->prime:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "oneClickEnabled="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->oneClickEnabled:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", buyable="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->buyable:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", icon="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->icon:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", imageUrl="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->imageUrl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", merchantId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->merchantId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", offerId="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->offerId:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", "

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "shippingOffer="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->shippingOffer:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", deliveryDate="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->deliveryDate:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", group="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->group:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, ", variations="

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-boolean v1, p0, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->variations:Z

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Z)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "]"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
