.class public Lcom/amazon/mShop/details/PriceBlock;
.super Ljava/lang/Object;
.source "PriceBlock.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 15
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method protected static getShippingPrice(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)Ljava/lang/String;
    .locals 5
    .param p0, "root"    # Landroid/view/ViewGroup;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "extraOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .prologue
    .line 87
    const/4 v0, 0x0

    .line 88
    .local v0, "shippingMessage":Ljava/lang/String;
    if-eqz p0, :cond_0

    .line 89
    invoke-static {p1, p2}, Lcom/amazon/mShop/control/item/ProductController;->getOfferShippingPrice(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)Ljava/lang/String;

    move-result-object v0

    .line 90
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 91
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->dp_plus_shipping:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v0, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 95
    :cond_0
    return-object v0
.end method

.method public static updateActualPriceLabel(Landroid/view/ViewGroup;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 9
    .param p0, "root"    # Landroid/view/ViewGroup;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 53
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->item_price_title:I

    invoke-virtual {p0, v4}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 54
    .local v3, "priceTitle":Landroid/widget/TextView;
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->isPriceHidden()Z

    move-result v4

    if-nez v4, :cond_0

    .line 55
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getDisplayPrice()Ljava/lang/String;

    move-result-object v0

    .line 56
    .local v0, "displayPrice":Ljava/lang/String;
    if-eqz v0, :cond_0

    .line 58
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->dp_price:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    .line 59
    .local v1, "priceLabelString":Ljava/lang/String;
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getProductSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v4

    if-eqz v4, :cond_1

    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getProductSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->getPromoPriceLabel()Ljava/lang/String;

    move-result-object v4

    if-eqz v4, :cond_1

    .line 60
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getProductSavings()Lcom/amazon/rio/j2me/client/services/mShop/Savings;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/Savings;->getPromoPriceLabel()Ljava/lang/String;

    move-result-object v1

    .line 61
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$color;->price:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    .line 65
    :goto_0
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->name_colon_value:I

    const/4 v6, 0x2

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    aput-object v1, v6, v7

    const/4 v7, 0x1

    const-string/jumbo v8, ""

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v2

    .line 66
    .local v2, "priceLabelStringWithColon":Ljava/lang/String;
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 69
    .end local v0    # "displayPrice":Ljava/lang/String;
    .end local v1    # "priceLabelString":Ljava/lang/String;
    .end local v2    # "priceLabelStringWithColon":Ljava/lang/String;
    :cond_0
    return-void

    .line 63
    .restart local v0    # "displayPrice":Ljava/lang/String;
    .restart local v1    # "priceLabelString":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$color;->gray_text:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setTextColor(I)V

    goto :goto_0
.end method
