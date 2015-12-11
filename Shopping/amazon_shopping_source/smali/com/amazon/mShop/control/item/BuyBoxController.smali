.class public Lcom/amazon/mShop/control/item/BuyBoxController;
.super Ljava/lang/Object;
.source "BuyBoxController.java"


# instance fields
.field private final isAddToCartOnly:Z

.field private final isAddToWishListEnabled:Z

.field private final offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

.field private final productController:Lcom/amazon/mShop/control/item/ProductController;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)V
    .locals 1
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "offerListing"    # Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .prologue
    .line 76
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 77
    iput-object p1, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    .line 78
    iput-object p2, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .line 79
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToCartOnly:Z

    .line 80
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToWishListEnabled:Z

    .line 81
    return-void
.end method

.method private getPrimeShippingOffers()[Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 195
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v0

    .line 196
    .local v0, "primeOneClickShippingOffers":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    if-nez v0, :cond_1

    .line 206
    :cond_0
    :goto_0
    return-object v2

    .line 199
    :cond_1
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->getShippingOffers()Ljava/util/List;

    move-result-object v1

    .line 200
    .local v1, "primeShippingOffers":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;>;"
    if-eqz v1, :cond_0

    .line 203
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-eqz v3, :cond_0

    .line 206
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    new-array v2, v2, [Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    invoke-interface {v1, v2}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v2

    check-cast v2, [Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    goto :goto_0
.end method

.method private isAddToWishListEnabled()Z
    .locals 6

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 228
    iget-boolean v4, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToWishListEnabled:Z

    if-nez v4, :cond_1

    .line 254
    :cond_0
    :goto_0
    return v2

    .line 232
    :cond_1
    iget-boolean v4, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToCartOnly:Z

    if-nez v4, :cond_0

    .line 236
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getAsin()Ljava/lang/String;

    move-result-object v0

    .line 237
    .local v0, "asin":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 240
    iget-object v4, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    if-eqz v4, :cond_0

    .line 243
    iget-object v4, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/ProductController;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 244
    .local v1, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    if-eqz v1, :cond_0

    .line 247
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAvailabilityCondition()I

    move-result v4

    const/4 v5, 0x3

    if-ne v4, v5, :cond_2

    move v2, v3

    .line 248
    goto :goto_0

    .line 250
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/ProductController;->mustSelectVariationChild()Z

    move-result v4

    if-eq v4, v3, :cond_0

    move v2, v3

    .line 254
    goto :goto_0
.end method


# virtual methods
.method public getAddButtons()[Lcom/amazon/mShop/control/item/BuyButtonController;
    .locals 7

    .prologue
    .line 403
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 404
    .local v0, "buyButtons":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/BuyButtonController;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getOfferId()Ljava/lang/String;

    move-result-object v3

    .line 405
    .local v3, "offerId":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getDealId()Ljava/lang/String;

    move-result-object v2

    .line 407
    .local v2, "dealId":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->isBuyable()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 408
    new-instance v1, Lcom/amazon/mShop/control/item/BuyButtonController;

    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_CART:Lcom/amazon/mShop/control/item/BuyButtonType;

    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v1, v5, v6, v3, v2}, Lcom/amazon/mShop/control/item/BuyButtonController;-><init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;Ljava/lang/String;)V

    .line 410
    .local v1, "cart":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 414
    .end local v1    # "cart":Lcom/amazon/mShop/control/item/BuyButtonController;
    :cond_0
    invoke-direct {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToWishListEnabled()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 415
    new-instance v4, Lcom/amazon/mShop/control/item/BuyButtonController;

    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_WISH_LIST:Lcom/amazon/mShop/control/item/BuyButtonType;

    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v4, v5, v6}, Lcom/amazon/mShop/control/item/BuyButtonController;-><init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;)V

    .line 417
    .local v4, "wish":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-interface {v0, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 420
    .end local v4    # "wish":Lcom/amazon/mShop/control/item/BuyButtonController;
    :cond_1
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    new-array v5, v5, [Lcom/amazon/mShop/control/item/BuyButtonController;

    invoke-interface {v0, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Lcom/amazon/mShop/control/item/BuyButtonController;

    return-object v5
.end method

.method public getAsin()Ljava/lang/String;
    .locals 1

    .prologue
    .line 115
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->getAsin()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getBasicOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .locals 1

    .prologue
    .line 119
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-eqz v0, :cond_0

    .line 120
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 122
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    goto :goto_0
.end method

.method public getBuyButtons()[Lcom/amazon/mShop/control/item/BuyButtonController;
    .locals 7

    .prologue
    .line 379
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 381
    .local v0, "buyButtons":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/BuyButtonController;>;"
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getOfferId()Ljava/lang/String;

    move-result-object v4

    .line 382
    .local v4, "offerId":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getDealId()Ljava/lang/String;

    move-result-object v2

    .line 384
    .local v2, "dealId":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->isBuyable()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 385
    invoke-virtual {p0, v4, v2, v0}, Lcom/amazon/mShop/control/item/BuyBoxController;->populateBuyButtons(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V

    .line 398
    :cond_0
    :goto_0
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    new-array v5, v5, [Lcom/amazon/mShop/control/item/BuyButtonController;

    invoke-interface {v0, v5}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v5

    check-cast v5, [Lcom/amazon/mShop/control/item/BuyButtonController;

    return-object v5

    .line 387
    :cond_1
    iget-object v5, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/item/ProductController;->isAvailableFromThirdPartiesOnly()Z

    move-result v5

    if-eqz v5, :cond_2

    .line 388
    new-instance v3, Lcom/amazon/mShop/control/item/BuyButtonController;

    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->SEE_MORE_BUYING_OPTIONS:Lcom/amazon/mShop/control/item/BuyButtonType;

    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v3, v5, v6}, Lcom/amazon/mShop/control/item/BuyButtonController;-><init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;)V

    .line 390
    .local v3, "more":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-interface {v0, v3}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 392
    .end local v3    # "more":Lcom/amazon/mShop/control/item/BuyButtonController;
    :cond_2
    iget-object v5, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v5}, Lcom/amazon/mShop/control/item/ProductController;->shouldBuyFromFriendApp()Z

    move-result v5

    if-eqz v5, :cond_0

    .line 393
    new-instance v1, Lcom/amazon/mShop/control/item/BuyButtonController;

    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->FRIEND_APP_BUTTON:Lcom/amazon/mShop/control/item/BuyButtonType;

    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v1, v5, v6}, Lcom/amazon/mShop/control/item/BuyButtonController;-><init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;)V

    .line 395
    .local v1, "controller":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-interface {v0, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0
.end method

.method public getDealId()Ljava/lang/String;
    .locals 1

    .prologue
    .line 135
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-eqz v0, :cond_0

    .line 136
    const/4 v0, 0x0

    .line 138
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->getDealId()Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public getOfferId()Ljava/lang/String;
    .locals 2

    .prologue
    .line 127
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getBasicOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 128
    .local v0, "basicOfferListing":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v0, :cond_0

    .line 129
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getOfferId()Ljava/lang/String;

    move-result-object v1

    .line 131
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    .locals 1

    .prologue
    .line 179
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-eqz v0, :cond_0

    .line 180
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v0

    .line 182
    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/ProductController;->getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v0

    goto :goto_0
.end method

.method public getPrimeOneClickShippingOffersNote()Ljava/lang/String;
    .locals 2

    .prologue
    .line 187
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v0

    .line 188
    .local v0, "primeOneClickShippingOffers":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    if-eqz v0, :cond_0

    .line 189
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->getNote()Ljava/lang/String;

    move-result-object v1

    .line 191
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public getPrimeShippingOffersRemainingMinutes()Ljava/lang/Integer;
    .locals 7

    .prologue
    const/4 v5, 0x0

    .line 210
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getPrimeOneClickShippingOffers()Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;

    move-result-object v1

    .line 211
    .local v1, "primeOneClickShippingOffers":Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;
    if-nez v1, :cond_1

    .line 224
    :cond_0
    :goto_0
    return-object v5

    .line 214
    :cond_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/PrimeOneClickShippingOffers;->getShippingOffers()Ljava/util/List;

    move-result-object v2

    .line 215
    .local v2, "primeShippingOffers":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;>;"
    const v3, 0x7fffffff

    .line 216
    .local v3, "remainingMinutes":I
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :cond_2
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    .line 217
    .local v4, "shippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getRemainingMinutes()Ljava/lang/Integer;

    move-result-object v6

    if-eqz v6, :cond_2

    .line 218
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getRemainingMinutes()Ljava/lang/Integer;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/Integer;->intValue()I

    move-result v6

    invoke-static {v3, v6}, Ljava/lang/Math;->min(II)I

    move-result v3

    goto :goto_1

    .line 221
    .end local v4    # "shippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    :cond_3
    const v6, 0x7fffffff

    if-eq v3, v6, :cond_0

    .line 224
    new-instance v5, Ljava/lang/Integer;

    invoke-direct {v5, v3}, Ljava/lang/Integer;-><init>(I)V

    goto :goto_0
.end method

.method public getProductController()Lcom/amazon/mShop/control/item/ProductController;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    return-object v0
.end method

.method public isBuyable()Z
    .locals 7

    .prologue
    const/4 v4, 0x1

    const/4 v5, 0x0

    .line 271
    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-nez v6, :cond_1

    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/item/ProductController;->isAvailableFromThirdPartiesOnly()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 297
    :cond_0
    :goto_0
    return v5

    .line 275
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getBasicOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 276
    .local v0, "basicOfferListing":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v0, :cond_0

    .line 280
    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/item/ProductController;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 281
    .local v1, "basicProductInfo":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    if-eqz v1, :cond_0

    .line 285
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getAsin()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getOfferId()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 289
    iget-boolean v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToCartOnly:Z

    if-nez v6, :cond_2

    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/item/ProductController;->mustSelectVariationChild()Z

    move-result v6

    if-nez v6, :cond_0

    .line 294
    :cond_2
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAvailabilityCondition()I

    move-result v3

    .line 295
    .local v3, "productAvailabilityCondition":I
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getAvailabilityCondition()I

    move-result v2

    .line 297
    .local v2, "offerAvailabilityCondition":I
    if-nez v3, :cond_4

    if-eqz v2, :cond_3

    if-ne v2, v4, :cond_4

    :cond_3
    :goto_1
    move v5, v4

    goto :goto_0

    :cond_4
    move v4, v5

    goto :goto_1
.end method

.method public isPreOrder()Z
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 304
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getBasicOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 305
    .local v0, "basicOfferListing":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-nez v0, :cond_0

    .line 311
    :goto_0
    return v3

    .line 309
    :cond_0
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getAvailabilityCondition()I

    move-result v1

    .line 311
    .local v1, "offerAvailabilityCondition":I
    if-ne v1, v2, :cond_1

    :goto_1
    move v3, v2

    goto :goto_0

    :cond_1
    move v2, v3

    goto :goto_1
.end method

.method public isWaitingForPrime1ClickShippingOffers()Z
    .locals 8

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 149
    iget-boolean v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToCartOnly:Z

    if-eqz v6, :cond_1

    .line 174
    :cond_0
    :goto_0
    return v4

    .line 153
    :cond_1
    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->offerListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-nez v6, :cond_0

    .line 156
    iget-object v6, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/item/ProductController;->getPrimeOneClickShippingOffersReceived()Z

    move-result v6

    if-nez v6, :cond_0

    .line 159
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v2

    .line 160
    .local v2, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v2, :cond_3

    invoke-virtual {v2}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-virtual {v2}, Lcom/amazon/mShop/model/auth/User;->isPrime()Z

    move-result v6

    if-eqz v6, :cond_3

    move v3, v5

    .line 161
    .local v3, "userIsOneClickPrime":Z
    :goto_1
    if-eqz v3, :cond_0

    .line 164
    invoke-virtual {p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getBasicOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    .line 165
    .local v1, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v1, :cond_0

    .line 166
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    .line 169
    .local v0, "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v6

    if-eqz v6, :cond_0

    sget-object v6, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME:Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v6}, Lcom/amazon/mShop/ui/resources/BadgeType;->name()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-nez v6, :cond_2

    sget-object v6, Lcom/amazon/mShop/ui/resources/BadgeType;->PRIME_PLUS:Lcom/amazon/mShop/ui/resources/BadgeType;

    invoke-virtual {v6}, Lcom/amazon/mShop/ui/resources/BadgeType;->name()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getType()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v6

    if-eqz v6, :cond_0

    :cond_2
    move v4, v5

    .line 171
    goto :goto_0

    .end local v0    # "badgeInfo":Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;
    .end local v1    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v3    # "userIsOneClickPrime":Z
    :cond_3
    move v3, v4

    .line 160
    goto :goto_1
.end method

.method protected populateBuyButtons(Ljava/lang/String;Ljava/lang/String;Ljava/util/List;)V
    .locals 17
    .param p1, "offerId"    # Ljava/lang/String;
    .param p2, "dealId"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/control/item/BuyButtonController;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 335
    .local p3, "buyButtons":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/BuyButtonController;>;"
    if-eqz p2, :cond_1

    .line 376
    :cond_0
    :goto_0
    return-void

    .line 339
    :cond_1
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/amazon/mShop/control/item/BuyBoxController;->isAddToCartOnly:Z

    if-nez v2, :cond_0

    .line 340
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->isPreOrder()Z

    move-result v13

    .line 341
    .local v13, "isPreOrder":Z
    invoke-direct/range {p0 .. p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getPrimeShippingOffers()[Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    move-result-object v6

    .line 342
    .local v6, "primeOneClickShippingOffers":[Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    if-eqz v6, :cond_3

    array-length v2, v6

    if-eqz v2, :cond_3

    .line 345
    if-eqz v13, :cond_2

    .line 346
    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    .local v5, "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    :goto_1
    move-object/from16 v2, p0

    move-object/from16 v3, p1

    move-object/from16 v4, p2

    move-object/from16 v7, p3

    .line 350
    invoke-virtual/range {v2 .. v7}, Lcom/amazon/mShop/control/item/BuyBoxController;->populatePrimeShippingOptions(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/item/BuyButtonType;[Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;Ljava/util/List;)V

    goto :goto_0

    .line 348
    .end local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    :cond_2
    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK_PRIME:Lcom/amazon/mShop/control/item/BuyButtonType;

    .restart local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    goto :goto_1

    .line 351
    .end local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    :cond_3
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/control/item/BuyBoxController;->isWaitingForPrime1ClickShippingOffers()Z

    move-result v2

    if-nez v2, :cond_0

    .line 352
    invoke-static {}, Lcom/amazon/mShop/model/auth/User;->getUser()Lcom/amazon/mShop/model/auth/User;

    move-result-object v15

    .line 353
    .local v15, "user":Lcom/amazon/mShop/model/auth/User;
    if-eqz v15, :cond_4

    invoke-virtual {v15}, Lcom/amazon/mShop/model/auth/User;->isOneClick()Z

    move-result v2

    if-eqz v2, :cond_4

    const/16 v16, 0x1

    .line 355
    .local v16, "userIsOneClick":Z
    :goto_2
    if-eqz v16, :cond_6

    .line 356
    if-eqz v13, :cond_5

    .line 357
    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 361
    .restart local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    :goto_3
    new-instance v7, Lcom/amazon/mShop/control/item/BuyButtonController;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    const-string/jumbo v12, "default"

    move-object v8, v5

    move-object/from16 v10, p1

    move-object/from16 v11, p2

    invoke-direct/range {v7 .. v12}, Lcom/amazon/mShop/control/item/BuyButtonController;-><init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 363
    .local v7, "oneClick":Lcom/amazon/mShop/control/item/BuyButtonController;
    move-object/from16 v0, p3

    invoke-interface {v0, v7}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 353
    .end local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    .end local v7    # "oneClick":Lcom/amazon/mShop/control/item/BuyButtonController;
    .end local v16    # "userIsOneClick":Z
    :cond_4
    const/16 v16, 0x0

    goto :goto_2

    .line 359
    .restart local v16    # "userIsOneClick":Z
    :cond_5
    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW_1_CLICK:Lcom/amazon/mShop/control/item/BuyButtonType;

    .restart local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    goto :goto_3

    .line 365
    .end local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    :cond_6
    if-eqz v13, :cond_7

    .line 366
    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->PRE_ORDER_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    .line 370
    .restart local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    :goto_4
    new-instance v14, Lcom/amazon/mShop/control/item/BuyButtonController;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-direct {v14, v5, v2, v0, v1}, Lcom/amazon/mShop/control/item/BuyButtonController;-><init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;Ljava/lang/String;)V

    .line 372
    .local v14, "now":Lcom/amazon/mShop/control/item/BuyButtonController;
    move-object/from16 v0, p3

    invoke-interface {v0, v14}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 368
    .end local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    .end local v14    # "now":Lcom/amazon/mShop/control/item/BuyButtonController;
    :cond_7
    sget-object v5, Lcom/amazon/mShop/control/item/BuyButtonType;->BUY_NOW:Lcom/amazon/mShop/control/item/BuyButtonType;

    .restart local v5    # "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    goto :goto_4
.end method

.method protected populatePrimeShippingOptions(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/control/item/BuyButtonType;[Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;Ljava/util/List;)V
    .locals 9
    .param p1, "offerId"    # Ljava/lang/String;
    .param p2, "dealId"    # Ljava/lang/String;
    .param p3, "type"    # Lcom/amazon/mShop/control/item/BuyButtonType;
    .param p4, "primeOneClickShippingOffers"    # [Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Lcom/amazon/mShop/control/item/BuyButtonType;",
            "[",
            "Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/mShop/control/item/BuyButtonController;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 325
    .local p5, "buyButtons":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/control/item/BuyButtonController;>;"
    move-object v6, p4

    .local v6, "arr$":[Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    array-length v8, v6

    .local v8, "len$":I
    const/4 v7, 0x0

    .local v7, "i$":I
    :goto_0
    if-ge v7, v8, :cond_0

    aget-object v5, v6, v7

    .line 326
    .local v5, "primeOneClickShippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    new-instance v0, Lcom/amazon/mShop/control/item/BuyButtonController;

    iget-object v2, p0, Lcom/amazon/mShop/control/item/BuyBoxController;->productController:Lcom/amazon/mShop/control/item/ProductController;

    move-object v1, p3

    move-object v3, p1

    move-object v4, p2

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/control/item/BuyButtonController;-><init>(Lcom/amazon/mShop/control/item/BuyButtonType;Lcom/amazon/mShop/control/item/ProductController;Ljava/lang/String;Ljava/lang/String;Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;)V

    .line 329
    .local v0, "prime":Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-interface {p5, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 325
    add-int/lit8 v7, v7, 0x1

    goto :goto_0

    .line 331
    .end local v0    # "prime":Lcom/amazon/mShop/control/item/BuyButtonController;
    .end local v5    # "primeOneClickShippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    :cond_0
    return-void
.end method
