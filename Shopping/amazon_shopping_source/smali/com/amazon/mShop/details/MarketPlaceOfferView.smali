.class public Lcom/amazon/mShop/details/MarketPlaceOfferView;
.super Landroid/widget/LinearLayout;
.source "MarketPlaceOfferView.java"


# instance fields
.field private mAmazonLogo:Landroid/view/View;

.field private mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

.field private mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

.field private mItemPrice:Landroid/widget/TextView;

.field private mItemShippingPrice:Landroid/widget/TextView;

.field private mOfferCondition:Landroid/widget/TextView;

.field private mOfferMerchantName:Landroid/widget/TextView;

.field private mOfferMerchantPercentPositive:Landroid/widget/TextView;

.field private mOfferMerchantRatingCount:Landroid/widget/TextView;

.field private final mResources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 46
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 47
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mResources:Landroid/content/res/Resources;

    .line 48
    return-void
.end method


# virtual methods
.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 60
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 61
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_price:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mItemPrice:Landroid/widget/TextView;

    .line 62
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_badge:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/BadgeView;

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    .line 63
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_shipping_price:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mItemShippingPrice:Landroid/widget/TextView;

    .line 64
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->offer_condition:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferCondition:Landroid/widget/TextView;

    .line 65
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->offer_merchant_name:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantName:Landroid/widget/TextView;

    .line 66
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->offer_merchant_percent_positive:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    .line 67
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->offer_merchant_rating_count:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    .line 68
    return-void
.end method

.method public update(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)V
    .locals 13
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "offerListing"    # Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .prologue
    .line 71
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v9

    iput-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .line 72
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getExtraOffer()Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    move-result-object v0

    .line 73
    .local v0, "extraOffer":Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-virtual {v9}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getMerchantInfo()Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    move-result-object v2

    .line 74
    .local v2, "merchantInfo":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mItemPrice:Landroid/widget/TextView;

    iget-object v10, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-static {v9, v10}, Lcom/amazon/mShop/details/ItemViewUtils;->updatePriceForMarketplace(Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 75
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->getContext()Landroid/content/Context;

    move-result-object v9

    check-cast v9, Lcom/amazon/mShop/AmazonActivity;

    iget-object v10, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mItemShippingPrice:Landroid/widget/TextView;

    iget-object v11, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    const/4 v12, 0x0

    invoke-static {v9, v10, v11, v0, v12}, Lcom/amazon/mShop/details/ItemViewUtils;->updateShippingPrice(Lcom/amazon/mShop/AmazonActivity;Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;Z)V

    .line 76
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferCondition:Landroid/widget/TextView;

    iget-object v10, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getCondition()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 79
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    if-eqz v9, :cond_0

    .line 80
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-static {v9}, Lcom/amazon/mShop/util/BadgeUtils;->isContainedBadge(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v9

    if-eqz v9, :cond_5

    .line 81
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    iget-object v10, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBasicOffer:Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v10

    invoke-virtual {v10}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/amazon/mShop/ui/BadgeView;->update(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)V

    .line 87
    :cond_0
    :goto_0
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getIsAmazon()Ljava/lang/Boolean;

    move-result-object v9

    if-eqz v9, :cond_6

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getIsAmazon()Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v1

    .line 88
    .local v1, "isAmazon":Z
    :goto_1
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getMerchantName()Ljava/lang/String;

    move-result-object v3

    .line 89
    .local v3, "merchantName":Ljava/lang/String;
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_9

    .line 90
    if-eqz v1, :cond_8

    .line 91
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantName:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 92
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mAmazonLogo:Landroid/view/View;

    if-nez v9, :cond_7

    .line 93
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->amazon_logo_stub:I

    invoke-virtual {p0, v9}, Lcom/amazon/mShop/details/MarketPlaceOfferView;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/view/ViewStub;

    .line 94
    .local v8, "viewStub":Landroid/view/ViewStub;
    invoke-virtual {v8}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    move-result-object v9

    iput-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mAmazonLogo:Landroid/view/View;

    .line 112
    .end local v8    # "viewStub":Landroid/view/ViewStub;
    :cond_1
    :goto_2
    const/4 v6, 0x0

    .line 113
    .local v6, "ratingCount":Ljava/lang/String;
    const/4 v5, 0x0

    .line 115
    .local v5, "percentPositive":Ljava/lang/String;
    if-nez v1, :cond_3

    .line 116
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getMerchantRatingPercentPositive()Ljava/lang/Integer;

    move-result-object v4

    .line 117
    .local v4, "percentPos":Ljava/lang/Integer;
    if-eqz v4, :cond_2

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v9

    if-lez v9, :cond_2

    .line 118
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/mShop/android/lib/R$string;->mp_percent_positive:I

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v4, v11, v12

    invoke-virtual {v9, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 120
    :cond_2
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    if-eqz v9, :cond_3

    .line 121
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getMerchantRatingCount()Ljava/lang/Integer;

    move-result-object v7

    .line 122
    .local v7, "ratings":Ljava/lang/Integer;
    if-eqz v7, :cond_3

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v9

    if-lez v9, :cond_3

    .line 123
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/mShop/android/lib/R$string;->mp_count_ratings:I

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v7, v11, v12

    invoke-virtual {v9, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 128
    .end local v4    # "percentPos":Ljava/lang/Integer;
    .end local v7    # "ratings":Ljava/lang/Integer;
    :cond_3
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 129
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 135
    :goto_3
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_b

    .line 136
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    if-eqz v9, :cond_4

    .line 137
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 143
    :cond_4
    :goto_4
    return-void

    .line 83
    .end local v1    # "isAmazon":Z
    .end local v3    # "merchantName":Ljava/lang/String;
    .end local v5    # "percentPositive":Ljava/lang/String;
    .end local v6    # "ratingCount":Ljava/lang/String;
    :cond_5
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Lcom/amazon/mShop/ui/BadgeView;->setVisibility(I)V

    goto/16 :goto_0

    .line 87
    :cond_6
    const/4 v1, 0x0

    goto/16 :goto_1

    .line 96
    .restart local v1    # "isAmazon":Z
    .restart local v3    # "merchantName":Ljava/lang/String;
    :cond_7
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mAmazonLogo:Landroid/view/View;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2

    .line 99
    :cond_8
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantName:Landroid/widget/TextView;

    invoke-virtual {v9, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 100
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantName:Landroid/widget/TextView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 101
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mAmazonLogo:Landroid/view/View;

    if-eqz v9, :cond_1

    .line 102
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mAmazonLogo:Landroid/view/View;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_2

    .line 106
    :cond_9
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantName:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 107
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mAmazonLogo:Landroid/view/View;

    if-eqz v9, :cond_1

    .line 108
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mAmazonLogo:Landroid/view/View;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_2

    .line 131
    .restart local v5    # "percentPositive":Ljava/lang/String;
    .restart local v6    # "ratingCount":Ljava/lang/String;
    :cond_a
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    invoke-virtual {v9, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 132
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_3

    .line 140
    :cond_b
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    invoke-virtual {v9, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 141
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4
.end method
