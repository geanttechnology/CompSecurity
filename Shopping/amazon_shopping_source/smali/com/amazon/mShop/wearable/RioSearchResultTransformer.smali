.class public Lcom/amazon/mShop/wearable/RioSearchResultTransformer;
.super Ljava/lang/Object;
.source "RioSearchResultTransformer.java"


# static fields
.field private static final EXCLUDED_GROUPS:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 2

    .prologue
    .line 28
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    .line 29
    .local v0, "tempSet":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    const-string/jumbo v1, "mobile_application"

    invoke-interface {v0, v1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 30
    invoke-static {v0}, Ljava/util/Collections;->unmodifiableSet(Ljava/util/Set;)Ljava/util/Set;

    move-result-object v1

    sput-object v1, Lcom/amazon/mShop/wearable/RioSearchResultTransformer;->EXCLUDED_GROUPS:Ljava/util/Set;

    .line 31
    return-void
.end method

.method public constructor <init>()V
    .locals 0

    .prologue
    .line 21
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public apply(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Lcom/amazon/mShop/wearable/model/WearableSearchResult;
    .locals 11
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .prologue
    const/4 v6, 0x0

    const/4 v10, 0x1

    .line 34
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    .line 35
    .local v2, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getProductGroupId()Ljava/lang/String;

    move-result-object v3

    .line 36
    .local v3, "group":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v8

    if-nez v8, :cond_0

    sget-object v8, Lcom/amazon/mShop/wearable/RioSearchResultTransformer;->EXCLUDED_GROUPS:Ljava/util/Set;

    invoke-interface {v8, v3}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_1

    .line 98
    :cond_0
    :goto_0
    return-object v6

    .line 40
    :cond_1
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    .line 41
    .local v1, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v1, :cond_0

    .line 44
    new-instance v6, Lcom/amazon/mShop/wearable/model/WearableSearchResult;

    invoke-direct {v6}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;-><init>()V

    .line 46
    .local v6, "result":Lcom/amazon/mShop/wearable/model/WearableSearchResult;
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getAvailabilityMessages()Ljava/util/List;

    move-result-object v8

    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .local v5, "i$":Ljava/util/Iterator;
    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    .line 47
    .local v4, "ht":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_2

    .line 50
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v8

    sget-object v9, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v8, v9}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v8

    const-string/jumbo v9, "out of stock"

    invoke-virtual {v8, v9}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 51
    invoke-virtual {v6, v10}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setOutOfStock(Z)V

    .line 55
    .end local v4    # "ht":Lcom/amazon/rio/j2me/client/services/mShop/HyperText;
    :cond_3
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setName(Ljava/lang/String;)V

    .line 57
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v8

    if-eqz v8, :cond_b

    .line 58
    invoke-virtual {v6, v10}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setVariations(Z)V

    .line 59
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationParentAsin()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setAsin(Ljava/lang/String;)V

    .line 60
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getVariationPriceRange()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setPrice(Ljava/lang/String;)V

    .line 64
    :goto_1
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getShortDescription()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setBindingSymbol(Ljava/lang/String;)V

    .line 65
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setImageUrl(Ljava/lang/String;)V

    .line 68
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAverageOverallRating()Ljava/lang/Integer;

    move-result-object v8

    if-eqz v8, :cond_4

    .line 69
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAverageOverallRating()Ljava/lang/Integer;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/Integer;->intValue()I

    move-result v8

    int-to-float v8, v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setAvgRating(F)V

    .line 71
    :cond_4
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getCustomerReviewsCount()I

    move-result v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setReviewCount(I)V

    .line 73
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getOfferId()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setOfferId(Ljava/lang/String;)V

    .line 74
    invoke-virtual {v6}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->isVariations()Z

    move-result v8

    if-nez v8, :cond_5

    .line 75
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setPrice(Ljava/lang/String;)V

    .line 77
    :cond_5
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getShippingOffer()Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;

    move-result-object v7

    .line 78
    .local v7, "shippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    if-eqz v7, :cond_6

    .line 79
    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getGetItText()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setShippingOffer(Ljava/lang/String;)V

    .line 80
    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;->getPrice()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setShippingCost(Ljava/lang/String;)V

    .line 82
    :cond_6
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v8

    if-eqz v8, :cond_9

    .line 83
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v8

    if-eqz v8, :cond_9

    .line 84
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v8

    invoke-virtual {v8}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getType()Ljava/lang/String;

    move-result-object v0

    .line 85
    .local v0, "badgeType":Ljava/lang/String;
    const-string/jumbo v8, "PRIME"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_7

    .line 86
    invoke-virtual {v6, v10}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setPrime(Z)V

    .line 88
    :cond_7
    const-string/jumbo v8, "ADD_ON"

    invoke-virtual {v8, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v8

    if-eqz v8, :cond_8

    .line 89
    invoke-virtual {v6, v10}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setAddOnItem(Z)V

    .line 91
    :cond_8
    invoke-virtual {v6, v0}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setBadge(Ljava/lang/String;)V

    .line 94
    .end local v0    # "badgeType":Ljava/lang/String;
    :cond_9
    if-eqz v3, :cond_a

    .line 95
    invoke-virtual {v6, v3}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setGroup(Ljava/lang/String;)V

    .line 97
    :cond_a
    invoke-virtual {v6}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->determineBuyable()V

    goto/16 :goto_0

    .line 62
    .end local v7    # "shippingOffer":Lcom/amazon/rio/j2me/client/services/mShop/ShippingOffer;
    :cond_b
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v6, v8}, Lcom/amazon/mShop/wearable/model/WearableSearchResult;->setAsin(Ljava/lang/String;)V

    goto/16 :goto_1
.end method
