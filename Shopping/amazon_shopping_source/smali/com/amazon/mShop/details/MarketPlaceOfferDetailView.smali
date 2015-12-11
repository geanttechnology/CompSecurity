.class public Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;
.super Landroid/widget/ScrollView;
.source "MarketPlaceOfferDetailView.java"

# interfaces
.implements Lcom/amazon/mShop/DelayedInitView;
.implements Lcom/amazon/mShop/TitleProvider;


# instance fields
.field private final mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mAmazonLogo:Landroid/view/View;

.field private mInitialized:Z

.field private mItemPrice:Landroid/widget/TextView;

.field private mItemShippingPrice:Landroid/widget/TextView;

.field private mOfferCondition:Landroid/widget/TextView;

.field private mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

.field private mOfferMerchantName:Landroid/widget/TextView;

.field private mOfferMerchantPercentPositive:Landroid/widget/TextView;

.field private mOfferMerchantRatingCount:Landroid/widget/TextView;

.field private mProductController:Lcom/amazon/mShop/control/item/ProductController;

.field private final mResources:Landroid/content/res/Resources;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "product"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p3, "offer"    # Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .prologue
    .line 65
    invoke-direct {p0, p1}, Landroid/widget/ScrollView;-><init>(Landroid/content/Context;)V

    .line 77
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mInitialized:Z

    .line 66
    iput-object p1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 67
    iput-object p2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    .line 68
    iput-object p3, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .line 69
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mResources:Landroid/content/res/Resources;

    .line 70
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method private getAvailabilityMessages()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/amazon/rio/j2me/client/services/mShop/HyperText;",
            ">;"
        }
    .end annotation

    .prologue
    .line 302
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-eqz v1, :cond_0

    .line 303
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 304
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v0, :cond_0

    .line 305
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getAvailabilityMessages()Ljava/util/List;

    move-result-object v1

    .line 308
    .end local v0    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    :goto_0
    return-object v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static getMarketPlaceOfferDetailView(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;
    .locals 1
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p2, "offerListing"    # Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    .prologue
    .line 55
    new-instance v0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)V

    .line 56
    .local v0, "view":Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;
    return-object v0
.end method

.method private getMerchantName()Ljava/lang/String;
    .locals 3

    .prologue
    .line 324
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-eqz v2, :cond_0

    .line 325
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 326
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v0, :cond_0

    .line 327
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getMerchantInfo()Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    move-result-object v1

    .line 328
    .local v1, "merchant":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    if-eqz v1, :cond_0

    .line 329
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getMerchantName()Ljava/lang/String;

    move-result-object v2

    .line 333
    .end local v0    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v1    # "merchant":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    :goto_0
    return-object v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private isAmazon()Z
    .locals 3

    .prologue
    .line 337
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    if-eqz v2, :cond_0

    .line 338
    iget-object v2, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 339
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v0, :cond_0

    .line 340
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getMerchantInfo()Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    move-result-object v1

    .line 341
    .local v1, "merchant":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    if-eqz v1, :cond_0

    .line 342
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getIsAmazon()Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v2

    .line 347
    .end local v0    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v1    # "merchant":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    :goto_0
    return v2

    :cond_0
    const/4 v2, 0x0

    goto :goto_0
.end method

.method private updateAvailabilityBlock(Landroid/view/ViewGroup;)V
    .locals 10
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    const/16 v9, 0x8

    const/4 v8, 0x0

    .line 260
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->market_details_availability:I

    invoke-virtual {p1, v5}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 261
    .local v0, "avail":Landroid/widget/TextView;
    invoke-direct {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->getAvailabilityMessages()Ljava/util/List;

    move-result-object v1

    .line 262
    .local v1, "availabilityHyperTexts":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/rio/j2me/client/services/mShop/HyperText;>;"
    if-nez v1, :cond_0

    .line 263
    invoke-virtual {v0, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 274
    :goto_0
    sget v5, Lcom/amazon/mShop/android/lib/R$id;->market_details_legal_information_link:I

    invoke-virtual {p1, v5}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 275
    .local v2, "legalInfoLink":Landroid/widget/TextView;
    invoke-virtual {v2}, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->legal_info_text:I

    invoke-virtual {v5, v6}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 276
    .local v3, "legalInfoText":Ljava/lang/String;
    new-instance v4, Landroid/text/SpannableString;

    invoke-direct {v4, v3}, Landroid/text/SpannableString;-><init>(Ljava/lang/CharSequence;)V

    .line 277
    .local v4, "legalSpannableString":Landroid/text/SpannableString;
    new-instance v5, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$2;

    invoke-direct {v5, p0}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$2;-><init>(Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;)V

    invoke-virtual {v3}, Ljava/lang/String;->length()I

    move-result v6

    const/16 v7, 0x21

    invoke-virtual {v4, v5, v8, v6, v7}, Landroid/text/SpannableString;->setSpan(Ljava/lang/Object;III)V

    .line 288
    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 289
    invoke-static {}, Landroid/text/method/LinkMovementMethod;->getInstance()Landroid/text/method/MovementMethod;

    move-result-object v5

    invoke-virtual {v2, v5}, Landroid/widget/TextView;->setMovementMethod(Landroid/text/method/MovementMethod;)V

    .line 292
    invoke-direct {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->isAmazon()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 293
    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 295
    invoke-virtual {v2, v8}, Landroid/widget/TextView;->setFocusable(Z)V

    .line 299
    :goto_1
    return-void

    .line 265
    .end local v2    # "legalInfoLink":Landroid/widget/TextView;
    .end local v3    # "legalInfoText":Ljava/lang/String;
    .end local v4    # "legalSpannableString":Landroid/text/SpannableString;
    :cond_0
    iget-object v5, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v0, v5, v1}, Lcom/amazon/mShop/util/UIUtils;->setHyperTexts(Landroid/widget/TextView;Lcom/amazon/mShop/AmazonActivity;Ljava/util/List;)V

    .line 266
    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 268
    invoke-virtual {v0, v8}, Landroid/widget/TextView;->setFocusable(Z)V

    goto :goto_0

    .line 297
    .restart local v2    # "legalInfoLink":Landroid/widget/TextView;
    .restart local v3    # "legalInfoText":Ljava/lang/String;
    .restart local v4    # "legalSpannableString":Landroid/text/SpannableString;
    :cond_1
    invoke-virtual {v2, v9}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method private updateImage(Landroid/widget/ImageView;)V
    .locals 7
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 118
    iget-object v3, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ProductController;->getImage()[B

    move-result-object v2

    .line 119
    .local v2, "thumbnail":[B
    if-nez v2, :cond_1

    .line 123
    iget-object v3, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ProductController;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    .line 124
    .local v1, "previewImageUrl":Ljava/lang/String;
    iget-object v3, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/item/ProductController;->getMaxImageDimension()I

    move-result v0

    .line 126
    .local v0, "previewImageDimension":I
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 127
    new-instance v3, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    const/4 v5, 0x0

    invoke-static {v5}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    new-instance v6, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;

    invoke-direct {v6, p0, p1, v2}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView$1;-><init>(Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;Landroid/widget/ImageView;[B)V

    invoke-direct {v3, v1, v4, v5, v6}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    invoke-virtual {v3}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    .line 145
    .end local v0    # "previewImageDimension":I
    .end local v1    # "previewImageUrl":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 143
    :cond_1
    invoke-static {v2, p1}, Lcom/amazon/mShop/details/ItemViewUtils;->updateImage([BLandroid/widget/ImageView;)V

    goto :goto_0
.end method

.method private updateMerchantBlock(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V
    .locals 13
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;
    .param p2, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p3, "extraOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .prologue
    .line 187
    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 256
    :cond_0
    :goto_0
    return-void

    .line 190
    :cond_1
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->market_details_merchant_name:I

    invoke-virtual {p1, v9}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantName:Landroid/widget/TextView;

    .line 191
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->market_details_merchant_percent_positive:I

    invoke-virtual {p1, v9}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    .line 192
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->market_details_merchant_rating_count:I

    invoke-virtual {p1, v9}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    iput-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    .line 194
    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getMerchantInfo()Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;

    move-result-object v1

    .line 195
    .local v1, "merchantInfo":Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;
    if-eqz v1, :cond_0

    .line 198
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getIsAmazon()Ljava/lang/Boolean;

    move-result-object v9

    if-eqz v9, :cond_5

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getIsAmazon()Ljava/lang/Boolean;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    .line 199
    .local v0, "isAmazon":Z
    :goto_1
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/MerchantInfo;->getMerchantName()Ljava/lang/String;

    move-result-object v2

    .line 200
    .local v2, "merchantName":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-nez v9, :cond_8

    .line 201
    if-eqz v0, :cond_7

    .line 202
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantName:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 203
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    if-nez v9, :cond_6

    .line 204
    sget v9, Lcom/amazon/mShop/android/lib/R$id;->market_details_amazon_logo_stub:I

    invoke-virtual {p1, v9}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v8

    check-cast v8, Landroid/view/ViewStub;

    .line 205
    .local v8, "viewStub":Landroid/view/ViewStub;
    invoke-virtual {v8}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    move-result-object v9

    iput-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    .line 209
    .end local v8    # "viewStub":Landroid/view/ViewStub;
    :goto_2
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v3

    .line 210
    .local v3, "padding":I
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    invoke-virtual {v9, v3, v3, v3, v3}, Landroid/view/View;->setPadding(IIII)V

    .line 225
    .end local v3    # "padding":I
    :cond_2
    :goto_3
    const/4 v6, 0x0

    .line 226
    .local v6, "ratingCount":Ljava/lang/String;
    const/4 v5, 0x0

    .line 228
    .local v5, "percentPositive":Ljava/lang/String;
    if-nez v0, :cond_4

    .line 229
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getMerchantRatingPercentPositive()Ljava/lang/Integer;

    move-result-object v4

    .line 230
    .local v4, "percentPos":Ljava/lang/Integer;
    if-eqz v4, :cond_3

    invoke-virtual {v4}, Ljava/lang/Integer;->intValue()I

    move-result v9

    if-lez v9, :cond_3

    .line 231
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/mShop/android/lib/R$string;->mp_percent_positive:I

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v4, v11, v12

    invoke-virtual {v9, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v5

    .line 233
    :cond_3
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    if-eqz v9, :cond_4

    .line 234
    invoke-virtual/range {p3 .. p3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getMerchantRatingCount()Ljava/lang/Integer;

    move-result-object v7

    .line 235
    .local v7, "ratings":Ljava/lang/Integer;
    if-eqz v7, :cond_4

    invoke-virtual {v7}, Ljava/lang/Integer;->intValue()I

    move-result v9

    if-lez v9, :cond_4

    .line 236
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mResources:Landroid/content/res/Resources;

    sget v10, Lcom/amazon/mShop/android/lib/R$string;->mp_count_ratings:I

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    aput-object v7, v11, v12

    invoke-virtual {v9, v10, v11}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    .line 241
    .end local v4    # "percentPos":Ljava/lang/Integer;
    .end local v7    # "ratings":Ljava/lang/Integer;
    :cond_4
    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_9

    .line 242
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 248
    :goto_4
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_a

    .line 249
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    if-eqz v9, :cond_0

    .line 250
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0

    .line 198
    .end local v0    # "isAmazon":Z
    .end local v2    # "merchantName":Ljava/lang/String;
    .end local v5    # "percentPositive":Ljava/lang/String;
    .end local v6    # "ratingCount":Ljava/lang/String;
    :cond_5
    const/4 v0, 0x0

    goto/16 :goto_1

    .line 207
    .restart local v0    # "isAmazon":Z
    .restart local v2    # "merchantName":Ljava/lang/String;
    :cond_6
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/view/View;->setVisibility(I)V

    goto :goto_2

    .line 212
    :cond_7
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantName:Landroid/widget/TextView;

    invoke-virtual {v9, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 213
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantName:Landroid/widget/TextView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 214
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    if-eqz v9, :cond_2

    .line 215
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/view/View;->setVisibility(I)V

    goto :goto_3

    .line 219
    :cond_8
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantName:Landroid/widget/TextView;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 220
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    if-eqz v9, :cond_2

    .line 221
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonLogo:Landroid/view/View;

    const/16 v10, 0x8

    invoke-virtual {v9, v10}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_3

    .line 244
    .restart local v5    # "percentPositive":Ljava/lang/String;
    .restart local v6    # "ratingCount":Ljava/lang/String;
    :cond_9
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    invoke-virtual {v9, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 245
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantPercentPositive:Landroid/widget/TextView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_4

    .line 253
    :cond_a
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    invoke-virtual {v9, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 254
    iget-object v9, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferMerchantRatingCount:Landroid/widget/TextView;

    const/4 v10, 0x0

    invoke-virtual {v9, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_0
.end method

.method private updateProductBlock(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V
    .locals 10
    .param p1, "viewGroup"    # Landroid/view/ViewGroup;
    .param p2, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p3, "extraOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 149
    if-eqz p2, :cond_0

    if-nez p3, :cond_1

    .line 183
    :cond_0
    :goto_0
    return-void

    .line 152
    :cond_1
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->market_details_item_price:I

    invoke-virtual {p1, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    iput-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mItemPrice:Landroid/widget/TextView;

    .line 153
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->market_details_item_shipping_price:I

    invoke-virtual {p1, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    iput-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mItemShippingPrice:Landroid/widget/TextView;

    .line 154
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->market_details_offer_condition:I

    invoke-virtual {p1, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v6

    check-cast v6, Landroid/widget/TextView;

    iput-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferCondition:Landroid/widget/TextView;

    .line 156
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mItemPrice:Landroid/widget/TextView;

    invoke-static {v6, p2}, Lcom/amazon/mShop/details/ItemViewUtils;->updatePriceForMarketplace(Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 157
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    iget-object v7, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mItemShippingPrice:Landroid/widget/TextView;

    invoke-static {v6, v7, p2, p3, v8}, Lcom/amazon/mShop/details/ItemViewUtils;->updateShippingPrice(Lcom/amazon/mShop/AmazonActivity;Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;Z)V

    .line 158
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferCondition:Landroid/widget/TextView;

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getCondition()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 160
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->market_details_full_tax_include_text:I

    invoke-virtual {p1, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/TextView;

    .line 161
    .local v3, "fullTaxIncludeText":Landroid/widget/TextView;
    invoke-virtual {p1}, Landroid/view/ViewGroup;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->dp_all_prices_include_tax:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 162
    .local v2, "fullTaxIncludeMessage":Ljava/lang/String;
    invoke-static {v2}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_3

    .line 163
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 164
    invoke-virtual {v3, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 169
    :goto_1
    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getComments()Ljava/lang/String;

    move-result-object v0

    .line 170
    .local v0, "comments":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_2

    .line 171
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->offer_comments:I

    invoke-virtual {p1, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 172
    .local v1, "commentsView":Landroid/widget/TextView;
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mResources:Landroid/content/res/Resources;

    sget v7, Lcom/amazon/mShop/android/lib/R$string;->mp_comments:I

    new-array v8, v8, [Ljava/lang/Object;

    aput-object v0, v8, v9

    invoke-virtual {v6, v7, v8}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 173
    invoke-virtual {v1, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 174
    invoke-virtual {v1, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 177
    .end local v1    # "commentsView":Landroid/widget/TextView;
    :cond_2
    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;->getMerchantRatingMessage()Ljava/lang/String;

    move-result-object v4

    .line 178
    .local v4, "ratingMessage":Ljava/lang/String;
    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v6

    if-nez v6, :cond_0

    .line 179
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->offer_merchant_rating_message:I

    invoke-virtual {p1, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 180
    .local v5, "ratingView":Landroid/widget/TextView;
    invoke-virtual {v5, v9}, Landroid/widget/TextView;->setVisibility(I)V

    .line 181
    invoke-virtual {v5, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 166
    .end local v0    # "comments":Ljava/lang/String;
    .end local v4    # "ratingMessage":Ljava/lang/String;
    .end local v5    # "ratingView":Landroid/widget/TextView;
    :cond_3
    const/16 v6, 0x8

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 47
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 3

    .prologue
    .line 316
    invoke-direct {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->getMerchantName()Ljava/lang/String;

    move-result-object v0

    .line 317
    .local v0, "merchantName":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    const/4 v2, 0x1

    if-eq v1, v2, :cond_0

    .line 320
    .end local v0    # "merchantName":Ljava/lang/String;
    :goto_0
    return-object v0

    .restart local v0    # "merchantName":Ljava/lang/String;
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mResources:Landroid/content/res/Resources;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->mp_new_and_used_offers:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public onPushViewCompleted()V
    .locals 9

    .prologue
    .line 89
    iget-boolean v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mInitialized:Z

    if-nez v6, :cond_0

    .line 90
    invoke-virtual {p0}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->getContext()Landroid/content/Context;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->marketplace_offer_details:I

    const/4 v8, 0x0

    invoke-static {v6, v7, v8}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 92
    .local v2, "content":Landroid/view/ViewGroup;
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->marketplace_offer_details_header:I

    invoke-virtual {v2, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/view/ViewGroup;

    .line 93
    .local v4, "header":Landroid/view/ViewGroup;
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    invoke-static {v4, v6}, Lcom/amazon/mShop/details/ItemViewUtils;->updateTitleBlock(Landroid/view/View;Lcom/amazon/mShop/control/item/ProductController;)V

    .line 95
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->item_row_image:I

    invoke-virtual {v4, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/ImageView;

    .line 96
    .local v5, "imageView":Landroid/widget/ImageView;
    invoke-direct {p0, v5}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->updateImage(Landroid/widget/ImageView;)V

    .line 98
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->buy_box:I

    invoke-virtual {v2, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/details/BuyBoxView;

    .line 99
    .local v1, "buyBox":Lcom/amazon/mShop/details/BuyBoxView;
    new-instance v6, Lcom/amazon/mShop/control/item/BuyBoxController;

    iget-object v7, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mProductController:Lcom/amazon/mShop/control/item/ProductController;

    iget-object v8, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-direct {v6, v7, v8}, Lcom/amazon/mShop/control/item/BuyBoxController;-><init>(Lcom/amazon/mShop/control/item/ProductController;Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;)V

    invoke-virtual {v1, v6}, Lcom/amazon/mShop/details/BuyBoxView;->setBuyBoxController(Lcom/amazon/mShop/control/item/BuyBoxController;)V

    .line 100
    invoke-virtual {v1}, Lcom/amazon/mShop/details/BuyBoxView;->update()V

    .line 102
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 103
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mOfferListing:Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/OfferListing;->getExtraOffer()Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;

    move-result-object v3

    .line 105
    .local v3, "extraOffer":Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    invoke-direct {p0, v2, v0, v3}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->updateProductBlock(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V

    .line 106
    invoke-direct {p0, v2, v0, v3}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->updateMerchantBlock(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)V

    .line 107
    invoke-direct {p0, v2}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->updateAvailabilityBlock(Landroid/view/ViewGroup;)V

    .line 110
    iget-object v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mAmazonActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-static {v2, v0, v6}, Lcom/amazon/mShop/util/BadgeUtils;->updateAddOnMessageBlocks(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/mShop/AmazonActivity;)V

    .line 112
    invoke-virtual {p0, v2}, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->addView(Landroid/view/View;)V

    .line 113
    const/4 v6, 0x1

    iput-boolean v6, p0, Lcom/amazon/mShop/details/MarketPlaceOfferDetailView;->mInitialized:Z

    .line 115
    .end local v0    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v1    # "buyBox":Lcom/amazon/mShop/details/BuyBoxView;
    .end local v2    # "content":Landroid/view/ViewGroup;
    .end local v3    # "extraOffer":Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    .end local v4    # "header":Landroid/view/ViewGroup;
    .end local v5    # "imageView":Landroid/widget/ImageView;
    :cond_0
    return-void
.end method
