.class public Lcom/amazon/mShop/details/BuyBoxView;
.super Landroid/widget/LinearLayout;
.source "BuyBoxView.java"


# instance fields
.field private mAddToCartAction:Landroid/view/View$OnClickListener;

.field private mAddToWishlistAction:Landroid/view/View$OnClickListener;

.field protected mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

.field private mBuyNowAction:Landroid/view/View$OnClickListener;

.field private mFriendAppAction:Lcom/amazon/mShop/details/FriendAppAction;

.field private mMarketPlaceAction:Lcom/amazon/mShop/details/MarketPlaceAction;

.field private mSnsAction:Lcom/amazon/mShop/sns/SnsAction;

.field mTextViewAboveBuyButtons:Landroid/widget/TextView;

.field mTextViewAboveVariationFilters:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 44
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 233
    new-instance v0, Lcom/amazon/mShop/cart/AddToCartAction;

    invoke-direct {v0}, Lcom/amazon/mShop/cart/AddToCartAction;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mAddToCartAction:Landroid/view/View$OnClickListener;

    .line 234
    new-instance v0, Lcom/amazon/mShop/wishlist/AddToWishlistAction;

    invoke-direct {v0}, Lcom/amazon/mShop/wishlist/AddToWishlistAction;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mAddToWishlistAction:Landroid/view/View$OnClickListener;

    .line 235
    new-instance v0, Lcom/amazon/mShop/opl/BuyNowAction;

    invoke-direct {v0}, Lcom/amazon/mShop/opl/BuyNowAction;-><init>()V

    iput-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyNowAction:Landroid/view/View$OnClickListener;

    .line 45
    return-void
.end method

.method private getMarketplaceAction()Lcom/amazon/mShop/details/MarketPlaceAction;
    .locals 3

    .prologue
    .line 206
    iget-object v1, p0, Lcom/amazon/mShop/details/BuyBoxView;->mMarketPlaceAction:Lcom/amazon/mShop/details/MarketPlaceAction;

    if-nez v1, :cond_0

    .line 207
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    .line 208
    .local v0, "activity":Lcom/amazon/mShop/AmazonActivity;
    new-instance v1, Lcom/amazon/mShop/details/MarketPlaceAction;

    iget-object v2, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/BuyBoxController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v2

    invoke-direct {v1, v0, v2}, Lcom/amazon/mShop/details/MarketPlaceAction;-><init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v1, p0, Lcom/amazon/mShop/details/BuyBoxView;->mMarketPlaceAction:Lcom/amazon/mShop/details/MarketPlaceAction;

    .line 210
    .end local v0    # "activity":Lcom/amazon/mShop/AmazonActivity;
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/details/BuyBoxView;->mMarketPlaceAction:Lcom/amazon/mShop/details/MarketPlaceAction;

    return-object v1
.end method

.method public static getPrimeCountdownString(Ljava/lang/Integer;Landroid/content/res/Resources;)Ljava/lang/String;
    .locals 8
    .param p0, "remainingMinutesObject"    # Ljava/lang/Integer;
    .param p1, "resources"    # Landroid/content/res/Resources;

    .prologue
    const/4 v7, 0x1

    const/4 v6, 0x0

    .line 266
    invoke-virtual {p0}, Ljava/lang/Integer;->intValue()I

    move-result v2

    .line 267
    .local v2, "remainingMinutes":I
    div-int/lit8 v1, v2, 0x3c

    .line 268
    .local v1, "remainingHours":I
    mul-int/lit8 v3, v1, 0x3c

    sub-int/2addr v2, v3

    .line 271
    if-eqz v1, :cond_1

    .line 272
    if-eqz v2, :cond_0

    .line 273
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->buy_box_order_within_hr_min_for:I

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v7

    invoke-virtual {p1, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .line 283
    .local v0, "primeMessage":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 276
    .end local v0    # "primeMessage":Ljava/lang/String;
    :cond_0
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->buy_box_order_within_hr_for:I

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {p1, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "primeMessage":Ljava/lang/String;
    goto :goto_0

    .line 280
    .end local v0    # "primeMessage":Ljava/lang/String;
    :cond_1
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->buy_box_order_within_min_for:I

    new-array v4, v7, [Ljava/lang/Object;

    invoke-static {v2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v5

    aput-object v5, v4, v6

    invoke-virtual {p1, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    .restart local v0    # "primeMessage":Ljava/lang/String;
    goto :goto_0
.end method

.method private removeAllDisabledButtons(Landroid/widget/LinearLayout;)V
    .locals 3
    .param p1, "parentViewGroup"    # Landroid/widget/LinearLayout;

    .prologue
    .line 125
    invoke-virtual {p1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v2

    add-int/lit8 v0, v2, -0x1

    .local v0, "i":I
    :goto_0
    if-ltz v0, :cond_1

    .line 126
    invoke-virtual {p1, v0}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v1

    .line 127
    .local v1, "view":Landroid/view/View;
    instance-of v2, v1, Lcom/amazon/mShop/details/BuyButtonView;

    if-eqz v2, :cond_0

    invoke-virtual {v1}, Landroid/view/View;->isEnabled()Z

    move-result v2

    if-nez v2, :cond_0

    .line 128
    invoke-virtual {p1, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 125
    :cond_0
    add-int/lit8 v0, v0, -0x1

    goto :goto_0

    .line 131
    .end local v1    # "view":Landroid/view/View;
    :cond_1
    return-void
.end method

.method private setUpStatusMessage()V
    .locals 12

    .prologue
    const/4 v11, 0x0

    const/16 v10, 0x8

    .line 314
    const-string/jumbo v3, ""

    .line 315
    .local v3, "statusMsg":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getBuyBoxController()Lcom/amazon/mShop/control/item/BuyBoxController;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/control/item/BuyBoxController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v1

    .line 316
    .local v1, "productController":Lcom/amazon/mShop/control/item/ProductController;
    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ProductController;->getVariations()Lcom/amazon/mShop/control/item/Variations;

    move-result-object v4

    .line 317
    .local v4, "variations":Lcom/amazon/mShop/control/item/Variations;
    invoke-virtual {v1}, Lcom/amazon/mShop/control/item/ProductController;->mustSelectVariationChild()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 319
    if-eqz v4, :cond_0

    .line 320
    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/Variations;->getDimensionLabels()[Ljava/lang/String;

    move-result-object v0

    .line 321
    .local v0, "dimensions":[Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    sget v6, Lcom/amazon/mShop/android/lib/R$string;->buy_box_to_buy_select:I

    const/4 v7, 0x1

    new-array v7, v7, [Ljava/lang/Object;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$string;->buy_box_to_buy_select_separator:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v8

    invoke-static {v0, v8}, Lcom/amazon/mShop/util/Util;->join([Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v8

    aput-object v8, v7, v11

    invoke-virtual {v5, v6, v7}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    .line 348
    .end local v0    # "dimensions":[Ljava/lang/String;
    :cond_0
    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    .line 350
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 351
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 358
    :goto_0
    return-void

    .line 327
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getBuyBoxController()Lcom/amazon/mShop/control/item/BuyBoxController;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/control/item/BuyBoxController;->getPrimeOneClickShippingOffersNote()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 328
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getBuyBoxController()Lcom/amazon/mShop/control/item/BuyBoxController;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/control/item/BuyBoxController;->getPrimeOneClickShippingOffersNote()Ljava/lang/String;

    move-result-object v3

    .line 329
    if-eqz v4, :cond_0

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 330
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 331
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    invoke-virtual {v5, v11}, Landroid/widget/TextView;->setVisibility(I)V

    .line 332
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 337
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getBuyBoxController()Lcom/amazon/mShop/control/item/BuyBoxController;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/mShop/control/item/BuyBoxController;->getPrimeShippingOffersRemainingMinutes()Ljava/lang/Integer;

    move-result-object v2

    .line 338
    .local v2, "remainingMinutesObject":Ljava/lang/Integer;
    if-eqz v2, :cond_0

    .line 339
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-static {v2, v5}, Lcom/amazon/mShop/details/BuyBoxView;->getPrimeCountdownString(Ljava/lang/Integer;Landroid/content/res/Resources;)Ljava/lang/String;

    move-result-object v3

    .line 340
    if-eqz v4, :cond_0

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 341
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    .line 342
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    invoke-virtual {v5, v11}, Landroid/widget/TextView;->setVisibility(I)V

    .line 343
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_0

    .line 354
    .end local v2    # "remainingMinutesObject":Ljava/lang/Integer;
    :cond_3
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    invoke-virtual {v5, v11}, Landroid/widget/TextView;->setVisibility(I)V

    .line 355
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 356
    iget-object v5, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private updateBuyNowButtonStatus(Lcom/amazon/mShop/details/BuyButtonView;)V
    .locals 1
    .param p1, "buyNowButton"    # Lcom/amazon/mShop/details/BuyButtonView;

    .prologue
    .line 191
    if-eqz p1, :cond_0

    .line 192
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/item/BuyBoxController;->getBasicOfferListing()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForAddOnItem(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 193
    const/16 v0, 0x8

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/details/BuyButtonView;->setVisibility(I)V

    .line 198
    :cond_0
    :goto_0
    return-void

    .line 195
    :cond_1
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Lcom/amazon/mShop/details/BuyButtonView;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public getBuyBoxController()Lcom/amazon/mShop/control/item/BuyBoxController;
    .locals 1

    .prologue
    .line 254
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    return-object v0
.end method

.method public getFriendAppAction()Lcom/amazon/mShop/details/FriendAppAction;
    .locals 3

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mFriendAppAction:Lcom/amazon/mShop/details/FriendAppAction;

    if-nez v0, :cond_0

    .line 219
    new-instance v0, Lcom/amazon/mShop/details/FriendAppAction;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/BuyBoxController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/details/FriendAppAction;-><init>(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mFriendAppAction:Lcom/amazon/mShop/details/FriendAppAction;

    .line 221
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mFriendAppAction:Lcom/amazon/mShop/details/FriendAppAction;

    return-object v0
.end method

.method public getSnsAction()Lcom/amazon/mShop/sns/SnsAction;
    .locals 3

    .prologue
    .line 227
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mSnsAction:Lcom/amazon/mShop/sns/SnsAction;

    if-nez v0, :cond_0

    .line 228
    new-instance v0, Lcom/amazon/mShop/sns/SnsAction;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getContext()Landroid/content/Context;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/BuyBoxController;->getProductController()Lcom/amazon/mShop/control/item/ProductController;

    move-result-object v2

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/sns/SnsAction;-><init>(Landroid/content/Context;Lcom/amazon/mShop/control/item/ProductController;)V

    iput-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mSnsAction:Lcom/amazon/mShop/sns/SnsAction;

    .line 230
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mSnsAction:Lcom/amazon/mShop/sns/SnsAction;

    return-object v0
.end method

.method public setButtonsVisibility(I)V
    .locals 3
    .param p1, "visiblility"    # I

    .prologue
    .line 64
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->buy_box_buy_buttons_container:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 65
    .local v1, "buyButtons":Landroid/view/View;
    invoke-virtual {v1, p1}, Landroid/view/View;->setVisibility(I)V

    .line 66
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->buy_box_add_buttons_container:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    .line 67
    .local v0, "addButtons":Landroid/view/View;
    invoke-virtual {v0, p1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    return-void
.end method

.method public setBuyBoxController(Lcom/amazon/mShop/control/item/BuyBoxController;)V
    .locals 0
    .param p1, "buyBoxController"    # Lcom/amazon/mShop/control/item/BuyBoxController;

    .prologue
    .line 261
    iput-object p1, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    .line 262
    return-void
.end method

.method protected setUpLoadingIndicator(Z)V
    .locals 3
    .param p1, "isLoading"    # Z

    .prologue
    .line 238
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->loading_indicator:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    .line 239
    .local v1, "loadingIndicator":Landroid/view/View;
    iget-object v2, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/item/BuyBoxController;->isWaitingForPrime1ClickShippingOffers()Z

    move-result v2

    if-nez v2, :cond_0

    if-eqz p1, :cond_3

    .line 240
    :cond_0
    if-nez v1, :cond_1

    .line 241
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->loading_indicator_stub:I

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewStub;

    .line 242
    .local v0, "indicatorStub":Landroid/view/ViewStub;
    invoke-virtual {v0}, Landroid/view/ViewStub;->inflate()Landroid/view/View;

    move-result-object v1

    .line 244
    .end local v0    # "indicatorStub":Landroid/view/ViewStub;
    :cond_1
    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 248
    :cond_2
    :goto_0
    return-void

    .line 245
    :cond_3
    if-eqz v1, :cond_2

    .line 246
    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method public update()V
    .locals 1

    .prologue
    .line 48
    const/4 v0, 0x0

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/BuyBoxView;->update(Z)V

    .line 49
    return-void
.end method

.method public update(Z)V
    .locals 5
    .param p1, "isLoading"    # Z

    .prologue
    .line 52
    new-instance v0, Lcom/amazon/mShop/util/MShopUiOOMHandler;

    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    new-instance v2, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;

    new-instance v3, Lcom/amazon/mShop/details/BuyBoxView$1;

    invoke-direct {v3, p0, p1}, Lcom/amazon/mShop/details/BuyBoxView$1;-><init>(Lcom/amazon/mShop/details/BuyBoxView;Z)V

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;-><init>(Ljava/lang/Runnable;Z)V

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/util/MShopUiOOMHandler;-><init>(Landroid/app/Activity;Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;)V

    .line 60
    .local v0, "oomHandler":Lcom/amazon/mShop/util/MShopUiOOMHandler;
    invoke-virtual {v0}, Lcom/amazon/mShop/util/MShopUiOOMHandler;->execute()V

    .line 61
    return-void
.end method

.method protected updateButtons(Landroid/widget/LinearLayout;[Lcom/amazon/mShop/control/item/BuyButtonController;)V
    .locals 9
    .param p1, "parentViewGroup"    # Landroid/widget/LinearLayout;
    .param p2, "buttonControllers"    # [Lcom/amazon/mShop/control/item/BuyButtonController;

    .prologue
    .line 135
    if-nez p1, :cond_1

    .line 185
    :cond_0
    return-void

    .line 138
    :cond_1
    if-eqz p2, :cond_0

    .line 142
    invoke-direct {p0, p1}, Lcom/amazon/mShop/details/BuyBoxView;->removeAllDisabledButtons(Landroid/widget/LinearLayout;)V

    .line 144
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 145
    .local v1, "buttonViews":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/mShop/details/BuyButtonView;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    invoke-virtual {p1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v7

    if-ge v2, v7, :cond_3

    .line 146
    invoke-virtual {p1, v2}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v6

    .line 147
    .local v6, "view":Landroid/view/View;
    instance-of v7, v6, Lcom/amazon/mShop/details/BuyButtonView;

    if-eqz v7, :cond_2

    .line 148
    check-cast v6, Lcom/amazon/mShop/details/BuyButtonView;

    .end local v6    # "view":Landroid/view/View;
    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 145
    :cond_2
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 152
    :cond_3
    :goto_1
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    array-length v8, p2

    if-le v7, v8, :cond_4

    .line 153
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Landroid/view/View;

    invoke-virtual {p1, v7}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 154
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-interface {v1, v7}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    goto :goto_1

    .line 157
    :cond_4
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    array-length v8, p2

    if-ge v7, v8, :cond_5

    .line 158
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getContext()Landroid/content/Context;

    move-result-object v7

    invoke-static {v7}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v3

    .line 159
    .local v3, "inflater":Landroid/view/LayoutInflater;
    :goto_2
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v7

    array-length v8, p2

    if-ge v7, v8, :cond_5

    .line 160
    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->buy_button_view:I

    invoke-virtual {v3, v7, p1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    .line 161
    invoke-virtual {p1}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v7

    add-int/lit8 v7, v7, -0x1

    invoke-virtual {p1, v7}, Landroid/widget/LinearLayout;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/amazon/mShop/details/BuyButtonView;

    .line 162
    .local v4, "newView":Lcom/amazon/mShop/details/BuyButtonView;
    invoke-interface {v1, v4}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 166
    .end local v3    # "inflater":Landroid/view/LayoutInflater;
    .end local v4    # "newView":Lcom/amazon/mShop/details/BuyButtonView;
    :cond_5
    const/4 v2, 0x0

    :goto_3
    array-length v7, p2

    if-ge v2, v7, :cond_0

    .line 167
    invoke-interface {v1, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/details/BuyButtonView;

    .line 168
    .local v0, "button":Lcom/amazon/mShop/details/BuyButtonView;
    aget-object v7, p2, v2

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/details/BuyButtonView;->update(Lcom/amazon/mShop/control/item/BuyButtonController;)V

    .line 169
    aget-object v7, p2, v2

    invoke-virtual {v7}, Lcom/amazon/mShop/control/item/BuyButtonController;->getBuyButtonType()Lcom/amazon/mShop/control/item/BuyButtonType;

    move-result-object v5

    .line 170
    .local v5, "type":Lcom/amazon/mShop/control/item/BuyButtonType;
    sget-object v7, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_CART:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v7, v5, :cond_6

    .line 171
    iget-object v7, p0, Lcom/amazon/mShop/details/BuyBoxView;->mAddToCartAction:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/details/BuyButtonView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 166
    :goto_4
    add-int/lit8 v2, v2, 0x1

    goto :goto_3

    .line 172
    :cond_6
    sget-object v7, Lcom/amazon/mShop/control/item/BuyButtonType;->ADD_TO_WISH_LIST:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v7, v5, :cond_7

    .line 173
    iget-object v7, p0, Lcom/amazon/mShop/details/BuyBoxView;->mAddToWishlistAction:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/details/BuyButtonView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_4

    .line 174
    :cond_7
    sget-object v7, Lcom/amazon/mShop/control/item/BuyButtonType;->SEE_MORE_BUYING_OPTIONS:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v7, v5, :cond_8

    .line 175
    invoke-direct {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getMarketplaceAction()Lcom/amazon/mShop/details/MarketPlaceAction;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/details/BuyButtonView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_4

    .line 176
    :cond_8
    sget-object v7, Lcom/amazon/mShop/control/item/BuyButtonType;->FRIEND_APP_BUTTON:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v7, v5, :cond_9

    .line 177
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getFriendAppAction()Lcom/amazon/mShop/details/FriendAppAction;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/details/BuyButtonView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_4

    .line 178
    :cond_9
    sget-object v7, Lcom/amazon/mShop/control/item/BuyButtonType;->SUBSCRIBER_AND_SAVE:Lcom/amazon/mShop/control/item/BuyButtonType;

    if-ne v7, v5, :cond_a

    .line 179
    invoke-virtual {p0}, Lcom/amazon/mShop/details/BuyBoxView;->getSnsAction()Lcom/amazon/mShop/sns/SnsAction;

    move-result-object v7

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/details/BuyButtonView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_4

    .line 181
    :cond_a
    iget-object v7, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyNowAction:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v7}, Lcom/amazon/mShop/details/BuyButtonView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 182
    invoke-direct {p0, v0}, Lcom/amazon/mShop/details/BuyBoxView;->updateBuyNowButtonStatus(Lcom/amazon/mShop/details/BuyButtonView;)V

    goto :goto_4
.end method

.method public updateButtons(Z)V
    .locals 7
    .param p1, "isLoading"    # Z

    .prologue
    const/16 v6, 0x8

    const/4 v5, 0x0

    .line 71
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->buy_box_buy_buttons_container:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/LinearLayout;

    .line 72
    .local v3, "buyButtonsContainer":Landroid/widget/LinearLayout;
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->buy_box_add_buttons_container:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    .line 73
    .local v1, "addButtonsContainer":Landroid/widget/LinearLayout;
    const/4 v4, 0x1

    if-ne p1, v4, :cond_0

    .line 74
    invoke-virtual {v3, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 75
    invoke-virtual {v1, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 89
    :goto_0
    return-void

    .line 79
    :cond_0
    invoke-virtual {v3, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 80
    iget-object v4, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/BuyBoxController;->getBuyButtons()[Lcom/amazon/mShop/control/item/BuyButtonController;

    move-result-object v2

    .line 81
    .local v2, "buyButtonControllers":[Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-virtual {p0, v3, v2}, Lcom/amazon/mShop/details/BuyBoxView;->updateButtons(Landroid/widget/LinearLayout;[Lcom/amazon/mShop/control/item/BuyButtonController;)V

    .line 84
    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 85
    iget-object v4, p0, Lcom/amazon/mShop/details/BuyBoxView;->mBuyBoxController:Lcom/amazon/mShop/control/item/BuyBoxController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/item/BuyBoxController;->getAddButtons()[Lcom/amazon/mShop/control/item/BuyButtonController;

    move-result-object v0

    .line 86
    .local v0, "addButtonControllers":[Lcom/amazon/mShop/control/item/BuyButtonController;
    invoke-virtual {p0, v1, v0}, Lcom/amazon/mShop/details/BuyBoxView;->updateButtons(Landroid/widget/LinearLayout;[Lcom/amazon/mShop/control/item/BuyButtonController;)V

    goto :goto_0
.end method

.method public updateStatus(Z)V
    .locals 2
    .param p1, "isLoading"    # Z

    .prologue
    const/16 v1, 0x8

    .line 287
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    if-nez v0, :cond_0

    .line 288
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->buy_box_status_message:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    .line 290
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    if-nez v0, :cond_1

    .line 291
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->buy_box_status_message_above_buy_buttons:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/details/BuyBoxView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    .line 293
    :cond_1
    if-eqz p1, :cond_2

    .line 295
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveVariationFilters:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 296
    iget-object v0, p0, Lcom/amazon/mShop/details/BuyBoxView;->mTextViewAboveBuyButtons:Landroid/widget/TextView;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 301
    :goto_0
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/details/BuyBoxView;->setUpLoadingIndicator(Z)V

    .line 302
    return-void

    .line 299
    :cond_2
    invoke-direct {p0}, Lcom/amazon/mShop/details/BuyBoxView;->setUpStatusMessage()V

    goto :goto_0
.end method
