.class public Lcom/amazon/mShop/details/ItemViewUtils;
.super Ljava/lang/Object;
.source "ItemViewUtils.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 51
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method private static getBadgeFromBackground(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;Ljava/lang/String;II)V
    .locals 8
    .param p0, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p1, "price"    # Landroid/widget/TextView;
    .param p2, "spanned"    # Landroid/text/SpannableStringBuilder;
    .param p3, "baseUrl"    # Ljava/lang/String;
    .param p4, "imageSpanVerticalAlignment"    # I
    .param p5, "badgeDefaultHyperTextStart"    # I

    .prologue
    .line 427
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;->getMessages()Ljava/util/List;

    move-result-object v1

    const/4 v3, 0x0

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/HyperText;->getText()Ljava/lang/String;

    move-result-object v2

    .line 429
    .local v2, "fallbackText":Ljava/lang/String;
    invoke-virtual {p1}, Landroid/widget/TextView;->getTag()Ljava/lang/Object;

    move-result-object v1

    if-nez v1, :cond_0

    .line 430
    new-instance v0, Lcom/amazon/mShop/details/ItemViewUtils$2;

    move-object v1, p2

    move v3, p5

    move-object v4, p1

    move v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/details/ItemViewUtils$2;-><init>(Landroid/text/SpannableStringBuilder;Ljava/lang/String;ILandroid/widget/TextView;I)V

    .line 466
    .local v0, "badgeSubscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    const/4 v1, 0x2

    invoke-static {v1}, Lcom/amazon/mShop/util/UIUtils;->convertDipToPixel(I)I

    move-result v7

    .line 467
    .local v7, "extraPixels":I
    new-instance v6, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {p1}, Landroid/widget/TextView;->getTextSize()F

    move-result v1

    float-to-int v1, v1

    add-int/2addr v1, v7

    invoke-static {p3, v1}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrlWithMaxHeight(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {v6, v1, p3, v0}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 468
    .local v6, "badgeFetcher":Lcom/amazon/mShop/net/BitmapFetcher;
    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 469
    invoke-virtual {v6}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    .line 471
    .end local v0    # "badgeSubscriber":Lcom/amazon/mShop/net/HttpFetcher$Subscriber;, "Lcom/amazon/mShop/net/HttpFetcher$Subscriber<Landroid/graphics/Bitmap;>;"
    .end local v6    # "badgeFetcher":Lcom/amazon/mShop/net/BitmapFetcher;
    .end local v7    # "extraPixels":I
    :cond_0
    return-void
.end method

.method public static getDisplayByLineAndBinding(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Landroid/content/Context;)Ljava/lang/String;
    .locals 7
    .param p0, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    const/4 v6, 0x1

    const/4 v5, 0x0

    .line 58
    if-nez p0, :cond_1

    .line 59
    const/4 v0, 0x0

    .line 74
    :cond_0
    :goto_0
    return-object v0

    .line 62
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getByLine()Ljava/lang/String;

    move-result-object v1

    .line 63
    .local v1, "byLine":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getShortDescription()Ljava/lang/String;

    move-result-object v0

    .line 64
    .local v0, "binding":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 68
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    .line 70
    .local v2, "res":Landroid/content/res/Resources;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 71
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->item_row_byline_format:I

    new-array v4, v6, [Ljava/lang/Object;

    aput-object v1, v4, v5

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0

    .line 74
    :cond_2
    sget v3, Lcom/amazon/mShop/android/lib/R$string;->item_row_byline_and_binding_format:I

    const/4 v4, 0x2

    new-array v4, v4, [Ljava/lang/Object;

    aput-object v1, v4, v5

    aput-object v0, v4, v6

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    goto :goto_0
.end method

.method public static getNewAndUsed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/content/Context;)Ljava/lang/String;
    .locals 9
    .param p0, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    const/4 v8, 0x1

    const/4 v7, 0x0

    .line 117
    invoke-static {p0, p1}, Lcom/amazon/mShop/control/item/ProductController;->hasMarketPlaceOffers(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 118
    invoke-virtual {p0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getUsedAndNewSummary()Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;

    move-result-object v2

    .line 119
    .local v2, "offersSummary":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    if-eqz v2, :cond_1

    .line 120
    invoke-virtual {p2}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    .line 121
    .local v3, "res":Landroid/content/res/Resources;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getCount()I

    move-result v0

    .line 122
    .local v0, "count":I
    if-lez v0, :cond_0

    .line 124
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->item_row_x_new_and_used_from_y_format:I

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getLowestPrice()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v8

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 135
    .end local v0    # "count":I
    .end local v2    # "offersSummary":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    .end local v3    # "res":Landroid/content/res/Resources;
    :goto_0
    return-object v1

    .line 129
    .restart local v0    # "count":I
    .restart local v2    # "offersSummary":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    .restart local v3    # "res":Landroid/content/res/Resources;
    :cond_0
    sget v4, Lcom/amazon/mShop/android/lib/R$string;->item_row_new_and_used_from_y_format:I

    new-array v5, v8, [Ljava/lang/Object;

    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;->getLowestPrice()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v5, v7

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 131
    .local v1, "newAndUsed":Ljava/lang/String;
    goto :goto_0

    .line 135
    .end local v0    # "count":I
    .end local v1    # "newAndUsed":Ljava/lang/String;
    .end local v2    # "offersSummary":Lcom/amazon/rio/j2me/client/services/mShop/OffersSummary;
    .end local v3    # "res":Landroid/content/res/Resources;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public static setBadgeImage(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;I)V
    .locals 8
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "price"    # Landroid/widget/TextView;
    .param p3, "spanned"    # Landroid/text/SpannableStringBuilder;
    .param p4, "imageSpanVerticalAlignment"    # I

    .prologue
    .line 402
    invoke-static {p1}, Lcom/amazon/mShop/util/BadgeUtils;->isContainedBadge(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 403
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v6

    .line 405
    .local v6, "badge":Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    invoke-static {v6}, Lcom/amazon/mShop/util/BadgeUtils;->hasBadgeUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 406
    invoke-static {v6}, Lcom/amazon/mShop/util/BadgeUtils;->getBadgeImageUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/BadgeUtils;->getCachedBadge(Ljava/lang/String;)Landroid/graphics/Bitmap;

    move-result-object v7

    .line 407
    .local v7, "badgeBitmap":Landroid/graphics/Bitmap;
    if-eqz v7, :cond_1

    .line 409
    invoke-static {p0, v7, p3, p4}, Lcom/amazon/mShop/util/UIUtils;->setImageSpan(Lcom/amazon/mShop/AmazonActivity;Landroid/graphics/Bitmap;Landroid/text/SpannableStringBuilder;I)V

    .line 423
    .end local v6    # "badge":Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    .end local v7    # "badgeBitmap":Landroid/graphics/Bitmap;
    :cond_0
    :goto_0
    return-void

    .line 412
    .restart local v6    # "badge":Lcom/amazon/rio/j2me/client/services/mShop/Badge;
    .restart local v7    # "badgeBitmap":Landroid/graphics/Bitmap;
    :cond_1
    if-eqz p3, :cond_3

    invoke-virtual {p3}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v5

    .line 413
    .local v5, "badgeDefaultHyperTextStart":I
    :goto_1
    invoke-static {v6}, Lcom/amazon/mShop/util/BadgeUtils;->hasBadgeDefaultHyperText(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 414
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    invoke-static {p3, v0, p0}, Lcom/amazon/mShop/util/BadgeUtils;->setBadgeItemSpan(Landroid/text/SpannableStringBuilder;Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;)V

    .line 416
    :cond_2
    invoke-static {v6}, Lcom/amazon/mShop/util/BadgeUtils;->getBadgeImageUrl(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Ljava/lang/String;

    move-result-object v3

    move-object v0, p1

    move-object v1, p2

    move-object v2, p3

    move v4, p4

    invoke-static/range {v0 .. v5}, Lcom/amazon/mShop/details/ItemViewUtils;->getBadgeFromBackground(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;Ljava/lang/String;II)V

    goto :goto_0

    .line 412
    .end local v5    # "badgeDefaultHyperTextStart":I
    :cond_3
    const/4 v5, 0x0

    goto :goto_1

    .line 418
    .end local v7    # "badgeBitmap":Landroid/graphics/Bitmap;
    :cond_4
    invoke-static {v6}, Lcom/amazon/mShop/util/BadgeUtils;->hasBadgeDefaultHyperText(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 420
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/Badge;->getMeta()Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;

    move-result-object v0

    invoke-static {p3, v0, p0}, Lcom/amazon/mShop/util/BadgeUtils;->setBadgeItemSpan(Landroid/text/SpannableStringBuilder;Lcom/amazon/rio/j2me/client/services/mShop/RichMessage;Lcom/amazon/mShop/AmazonActivity;)V

    goto :goto_0
.end method

.method public static updateActualPrice(Lcom/amazon/mShop/control/item/ProductController;Landroid/widget/LinearLayout;)V
    .locals 16
    .param p0, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "priceRow"    # Landroid/widget/LinearLayout;

    .prologue
    .line 238
    sget v12, Lcom/amazon/mShop/android/lib/R$id;->item_price:I

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/widget/TextView;

    .line 240
    .local v9, "price":Landroid/widget/TextView;
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/control/item/ProductController;->isPriceHidden()Z

    move-result v12

    if-nez v12, :cond_4

    .line 241
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/control/item/ProductController;->getDisplayPrice()Ljava/lang/String;

    move-result-object v2

    .line 242
    .local v2, "displayPrice":Ljava/lang/String;
    if-eqz v2, :cond_3

    .line 244
    const/16 v3, 0x21

    .line 245
    .local v3, "flags":I
    new-instance v11, Landroid/text/SpannableStringBuilder;

    invoke-direct {v11}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 246
    .local v11, "spanned":Landroid/text/SpannableStringBuilder;
    invoke-virtual {v11, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 247
    new-instance v12, Landroid/text/style/StyleSpan;

    const/4 v13, 0x1

    invoke-direct {v12, v13}, Landroid/text/style/StyleSpan;-><init>(I)V

    const/4 v13, 0x0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v14

    const/16 v15, 0x21

    invoke-virtual {v11, v12, v13, v14, v15}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 248
    new-instance v12, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual/range {p1 .. p1}, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;

    move-result-object v13

    invoke-virtual {v13}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    sget v14, Lcom/amazon/mShop/android/lib/R$color;->price:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getColor(I)I

    move-result v13

    invoke-direct {v12, v13}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    const/4 v13, 0x0

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v14

    const/16 v15, 0x21

    invoke-virtual {v11, v12, v13, v14, v15}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 253
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/control/item/ProductController;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v1

    .line 254
    .local v1, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    if-eqz v1, :cond_1

    .line 255
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/control/item/ProductController;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v12

    invoke-virtual {v12}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPricePerUnit()Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;

    move-result-object v4

    .line 256
    .local v4, "ppu":Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;
    if-eqz v4, :cond_1

    .line 257
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->getPrice()Ljava/lang/String;

    move-result-object v6

    .line 258
    .local v6, "ppuPrice":Ljava/lang/String;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->getCount()Ljava/lang/String;

    move-result-object v5

    .line 259
    .local v5, "ppuCount":Ljava/lang/String;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;->getUnits()Ljava/lang/String;

    move-result-object v8

    .line 262
    .local v8, "ppuUnits":Ljava/lang/String;
    invoke-static {v6}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_1

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_1

    invoke-static {v8}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_1

    .line 266
    const-string/jumbo v12, "1"

    invoke-virtual {v12, v5}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v12

    if-eqz v12, :cond_0

    .line 267
    const-string/jumbo v5, ""

    .line 270
    :cond_0
    invoke-virtual/range {p1 .. p1}, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;

    move-result-object v12

    invoke-virtual {v12}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v12

    sget v13, Lcom/amazon/mShop/android/lib/R$string;->dp_ppu_format_string:I

    const/4 v14, 0x3

    new-array v14, v14, [Ljava/lang/Object;

    const/4 v15, 0x0

    aput-object v6, v14, v15

    const/4 v15, 0x1

    aput-object v5, v14, v15

    const/4 v15, 0x2

    aput-object v8, v14, v15

    invoke-virtual {v12, v13, v14}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    .line 273
    .local v7, "ppuString":Ljava/lang/String;
    const-string/jumbo v12, " "

    invoke-virtual {v11, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 274
    invoke-virtual {v11, v7}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 275
    new-instance v12, Landroid/text/style/ForegroundColorSpan;

    invoke-virtual/range {p1 .. p1}, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;

    move-result-object v13

    invoke-virtual {v13}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v13

    sget v14, Lcom/amazon/mShop/android/lib/R$color;->price:I

    invoke-virtual {v13, v14}, Landroid/content/res/Resources;->getColor(I)I

    move-result v13

    invoke-direct {v12, v13}, Landroid/text/style/ForegroundColorSpan;-><init>(I)V

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v13

    invoke-virtual {v11}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v14

    const/16 v15, 0x21

    invoke-virtual {v11, v12, v13, v14, v15}, Landroid/text/SpannableStringBuilder;->setSpan(Ljava/lang/Object;III)V

    .line 281
    .end local v4    # "ppu":Lcom/amazon/rio/j2me/client/services/mShop/PricePerUnit;
    .end local v5    # "ppuCount":Ljava/lang/String;
    .end local v6    # "ppuPrice":Ljava/lang/String;
    .end local v7    # "ppuString":Ljava/lang/String;
    .end local v8    # "ppuUnits":Ljava/lang/String;
    :cond_1
    invoke-virtual/range {p0 .. p0}, Lcom/amazon/mShop/control/item/ProductController;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v12

    const/4 v13, 0x0

    move-object/from16 v0, p1

    invoke-static {v0, v12, v13}, Lcom/amazon/mShop/details/PriceBlock;->getShippingPrice(Landroid/view/ViewGroup;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)Ljava/lang/String;

    move-result-object v10

    .line 282
    .local v10, "shippingPrice":Ljava/lang/String;
    invoke-static {v10}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v12

    if-nez v12, :cond_2

    .line 284
    new-instance v12, Ljava/lang/StringBuilder;

    invoke-direct {v12}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v13, " "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-virtual {v11, v12}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 288
    :cond_2
    invoke-virtual/range {p1 .. p1}, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;

    move-result-object v12

    check-cast v12, Lcom/amazon/mShop/AmazonActivity;

    const/4 v13, 0x1

    invoke-static {v12, v1, v9, v11, v13}, Lcom/amazon/mShop/details/ItemViewUtils;->setBadgeImage(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;I)V

    .line 290
    invoke-virtual {v9, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 291
    const/4 v12, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 298
    .end local v1    # "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .end local v2    # "displayPrice":Ljava/lang/String;
    .end local v3    # "flags":I
    .end local v10    # "shippingPrice":Ljava/lang/String;
    .end local v11    # "spanned":Landroid/text/SpannableStringBuilder;
    :goto_0
    return-void

    .line 293
    .restart local v2    # "displayPrice":Ljava/lang/String;
    :cond_3
    const/16 v12, 0x8

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 296
    .end local v2    # "displayPrice":Ljava/lang/String;
    :cond_4
    const/16 v12, 0x8

    move-object/from16 v0, p1

    invoke-virtual {v0, v12}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0
.end method

.method public static updateActualPriceRow(Lcom/amazon/mShop/control/item/ProductController;Landroid/widget/LinearLayout;)V
    .locals 0
    .param p0, "productController"    # Lcom/amazon/mShop/control/item/ProductController;
    .param p1, "priceRow"    # Landroid/widget/LinearLayout;

    .prologue
    .line 230
    invoke-static {p1, p0}, Lcom/amazon/mShop/details/PriceBlock;->updateActualPriceLabel(Landroid/view/ViewGroup;Lcom/amazon/mShop/control/item/ProductController;)V

    .line 231
    invoke-static {p0, p1}, Lcom/amazon/mShop/details/ItemViewUtils;->updateActualPrice(Lcom/amazon/mShop/control/item/ProductController;Landroid/widget/LinearLayout;)V

    .line 232
    return-void
.end method

.method public static updateImage([BLandroid/widget/ImageView;)V
    .locals 3
    .param p0, "thumbnail"    # [B
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 139
    if-eqz p0, :cond_0

    array-length v1, p0

    if-nez v1, :cond_1

    .line 140
    :cond_0
    sget v1, Lcom/amazon/mShop/android/lib/R$drawable;->noimage:I

    invoke-virtual {p1, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 145
    :goto_0
    return-void

    .line 142
    :cond_1
    const/4 v1, 0x0

    array-length v2, p0

    invoke-static {p0, v1, v2}, Landroid/graphics/BitmapFactory;->decodeByteArray([BII)Landroid/graphics/Bitmap;

    move-result-object v0

    .line 143
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    invoke-virtual {p1, v0}, Landroid/widget/ImageView;->setImageBitmap(Landroid/graphics/Bitmap;)V

    goto :goto_0
.end method

.method public static updateImageWithDrawable(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V
    .locals 5
    .param p0, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p1, "imageView"    # Landroid/widget/ImageView;

    .prologue
    .line 157
    new-instance v0, Lcom/amazon/mShop/util/MShopUiOOMHandler;

    invoke-virtual {p1}, Landroid/widget/ImageView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Landroid/app/Activity;

    new-instance v2, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;

    new-instance v3, Lcom/amazon/mShop/details/ItemViewUtils$1;

    invoke-direct {v3, p0, p1}, Lcom/amazon/mShop/details/ItemViewUtils$1;-><init>(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V

    const/4 v4, 0x1

    invoke-direct {v2, v3, v4}, Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;-><init>(Ljava/lang/Runnable;Z)V

    invoke-direct {v0, v1, v2}, Lcom/amazon/mShop/util/MShopUiOOMHandler;-><init>(Landroid/app/Activity;Lcom/amazon/mShop/util/MShopUiOOMHandler$UiRunnable;)V

    .line 168
    .local v0, "oomHandler":Lcom/amazon/mShop/util/MShopUiOOMHandler;
    invoke-virtual {v0}, Lcom/amazon/mShop/util/MShopUiOOMHandler;->execute()V

    .line 169
    return-void
.end method

.method public static updatePrice(Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 3
    .param p0, "price"    # Landroid/widget/TextView;
    .param p1, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    .param p2, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 172
    if-eqz p0, :cond_0

    .line 173
    invoke-static {p1, p2}, Lcom/amazon/mShop/control/item/ProductController;->getPriceToDisplay(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Ljava/lang/String;

    move-result-object v0

    .line 174
    .local v0, "displayPrice":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 175
    invoke-virtual {p0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget-object v2, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {v1, v0, v2}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 176
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 182
    .end local v0    # "displayPrice":Ljava/lang/String;
    :cond_0
    :goto_0
    return-void

    .line 178
    .restart local v0    # "displayPrice":Ljava/lang/String;
    :cond_1
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 179
    const/16 v1, 0x8

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public static updatePriceForMarketplace(Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V
    .locals 5
    .param p0, "price"    # Landroid/widget/TextView;
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    const/16 v3, 0x8

    const/4 v4, 0x0

    .line 307
    if-eqz p0, :cond_1

    .line 308
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 309
    :cond_0
    invoke-virtual {p0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 325
    :cond_1
    :goto_0
    return-void

    .line 310
    :cond_2
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPriceViolatesMap()Z

    move-result v1

    if-eqz v1, :cond_4

    .line 311
    invoke-virtual {p0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->dp_add_to_cart_to_see_price:I

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 312
    .local v0, "priceViolatesMapString":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_3

    .line 313
    invoke-virtual {p0, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 314
    sget-object v1, Landroid/text/TextUtils$TruncateAt;->MIDDLE:Landroid/text/TextUtils$TruncateAt;

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 315
    invoke-virtual {p0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 317
    :cond_3
    invoke-virtual {p0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 320
    .end local v0    # "priceViolatesMapString":Ljava/lang/String;
    :cond_4
    invoke-virtual {p0}, Landroid/widget/TextView;->getContext()Landroid/content/Context;

    move-result-object v1

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getPrice()Ljava/lang/String;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {v1, v2, v3}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v1

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 321
    const/4 v1, 0x0

    invoke-virtual {p0, v1}, Landroid/widget/TextView;->setEllipsize(Landroid/text/TextUtils$TruncateAt;)V

    .line 322
    invoke-virtual {p0, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public static updateShippingPrice(Lcom/amazon/mShop/AmazonActivity;Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;Z)V
    .locals 7
    .param p0, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p1, "shippingTextView"    # Landroid/widget/TextView;
    .param p2, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p3, "extraOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;
    .param p4, "showWithBadge"    # Z

    .prologue
    const/4 v6, 0x0

    .line 334
    if-eqz p1, :cond_2

    .line 335
    new-instance v2, Landroid/text/SpannableStringBuilder;

    invoke-direct {v2}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 336
    .local v2, "spanned":Landroid/text/SpannableStringBuilder;
    invoke-static {p2, p3}, Lcom/amazon/mShop/control/item/ProductController;->getOfferShippingPrice(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/ExtraOfferListing;)Ljava/lang/String;

    move-result-object v0

    .line 338
    .local v0, "shippingMessage":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_3

    .line 339
    invoke-virtual {p1}, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->dp_plus_shipping:I

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    aput-object v0, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 340
    .local v1, "shippingStr":Ljava/lang/String;
    sget-object v3, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->DARK_GRAY:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {p0, v1, v3}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 349
    .end local v1    # "shippingStr":Ljava/lang/String;
    :cond_0
    :goto_0
    if-eqz p4, :cond_1

    .line 350
    invoke-static {p0, p2, p1, v2, v6}, Lcom/amazon/mShop/details/ItemViewUtils;->setBadgeImage(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;I)V

    .line 353
    :cond_1
    invoke-virtual {v2}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v3

    if-lez v3, :cond_4

    .line 354
    invoke-virtual {p1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 355
    invoke-virtual {p1, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 361
    .end local v0    # "shippingMessage":Ljava/lang/String;
    .end local v2    # "spanned":Landroid/text/SpannableStringBuilder;
    :cond_2
    :goto_1
    return-void

    .line 341
    .restart local v0    # "shippingMessage":Ljava/lang/String;
    .restart local v2    # "spanned":Landroid/text/SpannableStringBuilder;
    :cond_3
    invoke-static {p2}, Lcom/amazon/mShop/control/item/ProductController;->isEligibleForSuperSaverShipping(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 342
    invoke-virtual {p1}, Landroid/widget/TextView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->dp_free_super_saver_shipping:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    goto :goto_0

    .line 357
    :cond_4
    const/4 v3, 0x0

    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 358
    const/16 v3, 0x8

    invoke-virtual {p1, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method

.method public static updateTitleBlock(Landroid/view/View;Lcom/amazon/mShop/control/item/ProductController;)V
    .locals 4
    .param p0, "root"    # Landroid/view/View;
    .param p1, "productController"    # Lcom/amazon/mShop/control/item/ProductController;

    .prologue
    .line 82
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->item_title:I

    invoke-virtual {p0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 83
    .local v1, "title":Landroid/widget/TextView;
    if-eqz v1, :cond_0

    .line 84
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 87
    :cond_0
    sget v2, Lcom/amazon/mShop/android/lib/R$id;->item_byline_binding:I

    invoke-virtual {p0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 88
    .local v0, "byline":Landroid/widget/TextView;
    if-eqz v0, :cond_1

    .line 89
    invoke-virtual {p1}, Lcom/amazon/mShop/control/item/ProductController;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v2

    invoke-virtual {p0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/amazon/mShop/details/ItemViewUtils;->getDisplayByLineAndBinding(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 92
    :cond_1
    return-void
.end method
