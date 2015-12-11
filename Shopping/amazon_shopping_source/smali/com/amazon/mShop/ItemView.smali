.class public Lcom/amazon/mShop/ItemView;
.super Landroid/widget/LinearLayout;
.source "ItemView.java"

# interfaces
.implements Lcom/amazon/mShop/net/HttpFetcher$Subscriber;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Landroid/widget/LinearLayout;",
        "Lcom/amazon/mShop/net/HttpFetcher$Subscriber",
        "<",
        "Landroid/graphics/Bitmap;",
        ">;"
    }
.end annotation


# instance fields
.field private mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

.field private mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

.field private mImageRequester:Ljava/lang/Object;

.field private mIsGetImageFromURL:Z

.field private mItemRowAmazonpoints:Landroid/widget/LinearLayout;

.field private mItemRowBylineBinding:Landroid/widget/TextView;

.field private mItemRowCustomerReviewsCount:Landroid/widget/TextView;

.field private mItemRowImage:Landroid/widget/ImageView;

.field private mItemRowPrice:Landroid/widget/TextView;

.field private mItemRowRating:Lcom/amazon/mShop/Stars;

.field private mItemRowTitle:Landroid/widget/TextView;

.field private mItemRowUsedAndNew:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 62
    invoke-direct {p0, p1, p2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 63
    return-void
.end method

.method private cancelBitmapFetcher()V
    .locals 1

    .prologue
    .line 326
    iget-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_0

    .line 327
    iget-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->cancel()V

    .line 328
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 330
    :cond_0
    return-void
.end method

.method private getImageUrlFromObject(Ljava/lang/Object;)Ljava/lang/String;
    .locals 2
    .param p1, "obj"    # Ljava/lang/Object;

    .prologue
    .line 281
    instance-of v1, p1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    if-eqz v1, :cond_0

    .line 282
    check-cast p1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .end local p1    # "obj":Ljava/lang/Object;
    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v0

    .line 283
    .local v0, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    if-eqz v0, :cond_1

    .line 284
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    .line 293
    .end local v0    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    :goto_0
    return-object v1

    .line 286
    .restart local p1    # "obj":Ljava/lang/Object;
    :cond_0
    instance-of v1, p1, Lcom/amazon/mShop/control/item/Product;

    if-eqz v1, :cond_1

    .line 287
    check-cast p1, Lcom/amazon/mShop/control/item/Product;

    .end local p1    # "obj":Ljava/lang/Object;
    invoke-interface {p1}, Lcom/amazon/mShop/control/item/Product;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v0

    .line 288
    .restart local v0    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    if-eqz v0, :cond_1

    .line 289
    invoke-virtual {v0}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v1

    goto :goto_0

    .line 293
    .end local v0    # "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    :cond_1
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method protected getImageFromBackground(Ljava/lang/String;)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;

    .prologue
    .line 302
    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/mShop/android/lib/R$dimen;->item_row_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    invoke-virtual {p0, p1, v0}, Lcom/amazon/mShop/ItemView;->getImageFromBackground(Ljava/lang/String;I)V

    .line 303
    return-void
.end method

.method protected getImageFromBackground(Ljava/lang/String;I)V
    .locals 2
    .param p1, "url"    # Ljava/lang/String;
    .param p2, "maxDimension"    # I

    .prologue
    .line 307
    iget-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v0

    if-nez v0, :cond_2

    .line 308
    iget-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->getParams()Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 320
    :cond_0
    :goto_0
    return-void

    .line 312
    :cond_1
    invoke-direct {p0}, Lcom/amazon/mShop/ItemView;->cancelBitmapFetcher()V

    .line 315
    :cond_2
    if-eqz p1, :cond_0

    .line 316
    new-instance v0, Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-static {p2}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-direct {v0, p1, v1, p0}, Lcom/amazon/mShop/net/BitmapFetcher;-><init>(Ljava/lang/String;Ljava/lang/Integer;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 317
    iget-object v0, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v0}, Lcom/amazon/mShop/net/BitmapFetcher;->fetch()V

    goto :goto_0
.end method

.method public onDetachedFromWindow()V
    .locals 0

    .prologue
    .line 334
    invoke-super {p0}, Landroid/widget/LinearLayout;->onDetachedFromWindow()V

    .line 335
    invoke-direct {p0}, Lcom/amazon/mShop/ItemView;->cancelBitmapFetcher()V

    .line 336
    return-void
.end method

.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 247
    invoke-super {p0}, Landroid/widget/LinearLayout;->onFinishInflate()V

    .line 249
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_row_image:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowImage:Landroid/widget/ImageView;

    .line 250
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_title:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowTitle:Landroid/widget/TextView;

    .line 251
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_byline_binding:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowBylineBinding:Landroid/widget/TextView;

    .line 252
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_price:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    .line 253
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_amazonpoints:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowAmazonpoints:Landroid/widget/LinearLayout;

    .line 254
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_used_and_new:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowUsedAndNew:Landroid/widget/TextView;

    .line 255
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_rating:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/Stars;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowRating:Lcom/amazon/mShop/Stars;

    .line 256
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_customer_reviews_count:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mItemRowCustomerReviewsCount:Landroid/widget/TextView;

    .line 257
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_badge:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/ui/BadgeView;

    iput-object v0, p0, Lcom/amazon/mShop/ItemView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    .line 258
    return-void
.end method

.method public onHttpRequestFailed(Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 277
    .local p1, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    return-void
.end method

.method public onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 4
    .param p1, "response"    # Landroid/graphics/Bitmap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/graphics/Bitmap;",
            "Lcom/amazon/mShop/net/HttpFetcher$Params",
            "<",
            "Landroid/graphics/Bitmap;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 265
    .local p2, "params":Lcom/amazon/mShop/net/HttpFetcher$Params;, "Lcom/amazon/mShop/net/HttpFetcher$Params<Landroid/graphics/Bitmap;>;"
    iget-object v1, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher;->isCancelled()Z

    move-result v1

    if-nez v1, :cond_1

    move-object v1, p2

    .line 266
    check-cast v1, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-virtual {v1}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;->getBaseUrl()Ljava/lang/String;

    move-result-object v0

    .line 267
    .local v0, "baseUrl":Ljava/lang/String;
    iget-object v1, p0, Lcom/amazon/mShop/ItemView;->mImageRequester:Ljava/lang/Object;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/amazon/mShop/ItemView;->mImageRequester:Ljava/lang/Object;

    invoke-direct {p0, v1}, Lcom/amazon/mShop/ItemView;->getImageUrlFromObject(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 268
    iget-object v1, p0, Lcom/amazon/mShop/ItemView;->mItemRowImage:Landroid/widget/ImageView;

    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v2

    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    invoke-interface {v2, v3, p1, p2}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/ImageView;->setImageDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 270
    :cond_0
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/amazon/mShop/ItemView;->mBitmapFetcher:Lcom/amazon/mShop/net/BitmapFetcher;

    .line 272
    .end local v0    # "baseUrl":Ljava/lang/String;
    :cond_1
    return-void
.end method

.method public bridge synthetic onHttpResponseReceived(Ljava/lang/Object;Lcom/amazon/mShop/net/HttpFetcher$Params;)V
    .locals 0
    .param p1, "x0"    # Ljava/lang/Object;
    .param p2, "x1"    # Lcom/amazon/mShop/net/HttpFetcher$Params;

    .prologue
    .line 42
    check-cast p1, Landroid/graphics/Bitmap;

    .end local p1    # "x0":Ljava/lang/Object;
    invoke-virtual {p0, p1, p2}, Lcom/amazon/mShop/ItemView;->onHttpResponseReceived(Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)V

    return-void
.end method

.method protected setImageRequester(Ljava/lang/Object;)V
    .locals 0
    .param p1, "requester"    # Ljava/lang/Object;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/amazon/mShop/ItemView;->mImageRequester:Ljava/lang/Object;

    .line 111
    return-void
.end method

.method public setIsGetImageFromURL(Z)V
    .locals 0
    .param p1, "isGetImageFromURL"    # Z

    .prologue
    .line 58
    iput-boolean p1, p0, Lcom/amazon/mShop/ItemView;->mIsGetImageFromURL:Z

    .line 59
    return-void
.end method

.method protected shouldShowItemBadge(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z
    .locals 1
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    .prologue
    .line 211
    invoke-static {p1}, Lcom/amazon/mShop/util/BadgeUtils;->isContainedBadge(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v0

    return v0
.end method

.method protected showBadgeImageTogetherWithPrice(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    .locals 5
    .param p1, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p2, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .prologue
    const/4 v4, 0x0

    .line 219
    iget-object v2, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/amazon/mShop/ItemView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    if-nez v2, :cond_1

    .line 220
    new-instance v1, Landroid/text/SpannableStringBuilder;

    invoke-direct {v1}, Landroid/text/SpannableStringBuilder;-><init>()V

    .line 221
    .local v1, "spanned":Landroid/text/SpannableStringBuilder;
    invoke-static {p2, p1}, Lcom/amazon/mShop/control/item/ProductController;->getPriceToDisplay(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Ljava/lang/String;

    move-result-object v0

    .line 222
    .local v0, "displayPrice":Ljava/lang/String;
    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 223
    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getContext()Landroid/content/Context;

    move-result-object v2

    sget-object v3, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->RED:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {v2, v0, v3}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/text/SpannableStringBuilder;->append(Ljava/lang/CharSequence;)Landroid/text/SpannableStringBuilder;

    .line 226
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getContext()Landroid/content/Context;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/AmazonActivity;

    iget-object v3, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    invoke-static {v2, p1, v3, v1, v4}, Lcom/amazon/mShop/details/ItemViewUtils;->setBadgeImage(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/widget/TextView;Landroid/text/SpannableStringBuilder;I)V

    .line 228
    invoke-virtual {v1}, Landroid/text/SpannableStringBuilder;->length()I

    move-result v2

    if-lez v2, :cond_2

    .line 229
    iget-object v2, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 230
    iget-object v2, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    invoke-virtual {v2, v4}, Landroid/widget/TextView;->setVisibility(I)V

    .line 236
    .end local v0    # "displayPrice":Ljava/lang/String;
    .end local v1    # "spanned":Landroid/text/SpannableStringBuilder;
    :cond_1
    :goto_0
    return-void

    .line 232
    .restart local v0    # "displayPrice":Ljava/lang/String;
    .restart local v1    # "spanned":Landroid/text/SpannableStringBuilder;
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 233
    iget-object v2, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method public update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;Landroid/graphics/drawable/Drawable;I)V
    .locals 4
    .param p1, "adapter"    # Lcom/amazon/mShop/ObjectSubscriberAdapter;
    .param p2, "o"    # Ljava/lang/Object;
    .param p3, "drawable"    # Landroid/graphics/drawable/Drawable;
    .param p4, "index"    # I

    .prologue
    .line 122
    iget-object v3, p0, Lcom/amazon/mShop/ItemView;->mItemRowImage:Landroid/widget/ImageView;

    invoke-static {p3, v3}, Lcom/amazon/mShop/details/ItemViewUtils;->updateImageWithDrawable(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V

    .line 124
    const/4 v0, 0x0

    .line 125
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    const/4 v1, 0x0

    .line 126
    .local v1, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    instance-of v3, p2, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    if-eqz v3, :cond_0

    .line 128
    iput-object p2, p0, Lcom/amazon/mShop/ItemView;->mImageRequester:Ljava/lang/Object;

    move-object v2, p2

    .line 129
    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 130
    .local v2, "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 131
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 134
    iget-boolean v3, p0, Lcom/amazon/mShop/ItemView;->mIsGetImageFromURL:Z

    if-eqz v3, :cond_0

    if-nez p3, :cond_0

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v3

    invoke-static {v3}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 135
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/ItemView;->getImageFromBackground(Ljava/lang/String;)V

    .line 139
    .end local v2    # "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_0
    invoke-virtual {p0, p4, v0, v1}, Lcom/amazon/mShop/ItemView;->updateItemView(ILcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 140
    return-void
.end method

.method public update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V
    .locals 6
    .param p1, "adapter"    # Lcom/amazon/mShop/ObjectSubscriberAdapter;
    .param p2, "o"    # Ljava/lang/Object;
    .param p3, "thumbnail"    # [B
    .param p4, "index"    # I

    .prologue
    .line 74
    iget-object v5, p0, Lcom/amazon/mShop/ItemView;->mItemRowImage:Landroid/widget/ImageView;

    invoke-static {p3, v5}, Lcom/amazon/mShop/details/ItemViewUtils;->updateImage([BLandroid/widget/ImageView;)V

    .line 75
    const/4 v0, 0x0

    .line 76
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    const/4 v1, 0x0

    .line 77
    .local v1, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    instance-of v5, p2, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    if-eqz v5, :cond_2

    move-object v4, p2

    .line 79
    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 80
    .local v4, "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 81
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 84
    iget-boolean v5, p0, Lcom/amazon/mShop/ItemView;->mIsGetImageFromURL:Z

    if-eqz v5, :cond_0

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 85
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {p0, v5}, Lcom/amazon/mShop/ItemView;->getImageFromBackground(Ljava/lang/String;)V

    .line 101
    .end local v4    # "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    :cond_0
    :goto_0
    invoke-virtual {p0, p4, v0, v1}, Lcom/amazon/mShop/ItemView;->updateItemView(ILcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 102
    :cond_1
    return-void

    .line 88
    :cond_2
    instance-of v5, p2, Lcom/amazon/mShop/control/item/Product;

    if-eqz v5, :cond_3

    move-object v3, p2

    .line 90
    check-cast v3, Lcom/amazon/mShop/control/item/Product;

    .line 91
    .local v3, "product":Lcom/amazon/mShop/control/item/Product;
    invoke-interface {v3}, Lcom/amazon/mShop/control/item/Product;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 92
    invoke-interface {v3}, Lcom/amazon/mShop/control/item/Product;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 93
    goto :goto_0

    .end local v3    # "product":Lcom/amazon/mShop/control/item/Product;
    :cond_3
    instance-of v5, p2, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    if-eqz v5, :cond_1

    move-object v2, p2

    .line 94
    check-cast v2, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;

    .line 95
    .local v2, "homeItem":Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 96
    invoke-virtual {v2}, Lcom/amazon/rio/j2me/client/services/mShop/HomeItem;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 97
    goto :goto_0
.end method

.method protected updateItemView(ILcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V
    .locals 9
    .param p1, "index"    # I
    .param p2, "basicOffer"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    .param p3, "basicProduct"    # Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    .prologue
    const/4 v8, 0x0

    const/16 v7, 0x8

    .line 143
    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {p3, v4}, Lcom/amazon/mShop/details/ItemViewUtils;->getDisplayByLineAndBinding(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v1

    .line 144
    .local v1, "byLineBinding":Ljava/lang/String;
    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_1

    .line 145
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowBylineBinding:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 152
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowPrice:Landroid/widget/TextView;

    invoke-static {v4, p3, p2}, Lcom/amazon/mShop/details/ItemViewUtils;->updatePrice(Landroid/widget/TextView;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)V

    .line 157
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    if-eqz v4, :cond_0

    .line 158
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/ItemView;->shouldShowItemBadge(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 159
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    invoke-virtual {p2}, Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;->getBadgeInfo()Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BadgeInfo;->getBadge()Lcom/amazon/rio/j2me/client/services/mShop/Badge;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/ui/BadgeView;->update(Lcom/amazon/rio/j2me/client/services/mShop/Badge;)V

    .line 166
    :cond_0
    :goto_1
    if-eqz p3, :cond_5

    .line 167
    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v4

    invoke-static {v4}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v4

    if-eqz v4, :cond_3

    .line 168
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 177
    :goto_2
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowRating:Lcom/amazon/mShop/Stars;

    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAverageOverallRating()Ljava/lang/Integer;

    move-result-object v5

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/Stars;->setRating(Ljava/lang/Integer;)V

    .line 178
    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAverageOverallRating()Ljava/lang/Integer;

    move-result-object v4

    if-eqz v4, :cond_4

    .line 179
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowCustomerReviewsCount:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 180
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowCustomerReviewsCount:Landroid/widget/TextView;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v6, "("

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getCustomerReviewsCount()I

    move-result v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string/jumbo v6, ")"

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 191
    :goto_3
    invoke-static {p2}, Lcom/amazon/mShop/control/item/ProductController;->getAmazonPoints(Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;)Ljava/lang/String;

    move-result-object v0

    .line 192
    .local v0, "amazonPoints":Ljava/lang/String;
    if-eqz v0, :cond_6

    .line 193
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowAmazonpoints:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v8}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 194
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->item_amazonpoints_value:I

    invoke-virtual {p0, v4}, Lcom/amazon/mShop/ItemView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 199
    :goto_4
    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getContext()Landroid/content/Context;

    move-result-object v4

    invoke-static {p3, p2, v4}, Lcom/amazon/mShop/details/ItemViewUtils;->getNewAndUsed(Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Landroid/content/Context;)Ljava/lang/String;

    move-result-object v2

    .line 200
    .local v2, "newAndUsed":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getContext()Landroid/content/Context;

    move-result-object v4

    sget v5, Lcom/amazon/mShop/android/lib/R$string;->config_hasMarketplaceOffers:I

    invoke-static {v4, v5}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v4

    if-eqz v4, :cond_7

    if-eqz v2, :cond_7

    .line 201
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowUsedAndNew:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/amazon/mShop/ItemView;->getContext()Landroid/content/Context;

    move-result-object v5

    sget-object v6, Lcom/amazon/mShop/util/UIUtils$CharacterColor;->DARK_GRAY:Lcom/amazon/mShop/util/UIUtils$CharacterColor;

    invoke-static {v5, v2, v6}, Lcom/amazon/mShop/util/UIUtils;->convertUnsupportedCharacter(Landroid/content/Context;Ljava/lang/String;Lcom/amazon/mShop/util/UIUtils$CharacterColor;)Ljava/lang/CharSequence;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 202
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowUsedAndNew:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 206
    :goto_5
    return-void

    .line 147
    .end local v0    # "amazonPoints":Ljava/lang/String;
    .end local v2    # "newAndUsed":Ljava/lang/String;
    :cond_1
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowBylineBinding:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 148
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowBylineBinding:Landroid/widget/TextView;

    invoke-virtual {v4, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_0

    .line 161
    :cond_2
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mBadgeView:Lcom/amazon/mShop/ui/BadgeView;

    invoke-virtual {v4, v7}, Lcom/amazon/mShop/ui/BadgeView;->setVisibility(I)V

    goto/16 :goto_1

    .line 170
    :cond_3
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v8}, Landroid/widget/TextView;->setVisibility(I)V

    .line 173
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    add-int/lit8 v5, p1, 0x1

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string/jumbo v5, ". "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    .line 174
    .local v3, "title":Ljava/lang/String;
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 182
    .end local v3    # "title":Ljava/lang/String;
    :cond_4
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowCustomerReviewsCount:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    .line 186
    :cond_5
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowTitle:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 187
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowRating:Lcom/amazon/mShop/Stars;

    const/4 v5, 0x0

    invoke-virtual {v4, v5}, Lcom/amazon/mShop/Stars;->setRating(Ljava/lang/Integer;)V

    .line 188
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowCustomerReviewsCount:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    .line 196
    .restart local v0    # "amazonPoints":Ljava/lang/String;
    :cond_6
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowAmazonpoints:Landroid/widget/LinearLayout;

    invoke-virtual {v4, v7}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_4

    .line 204
    .restart local v2    # "newAndUsed":Ljava/lang/String;
    :cond_7
    iget-object v4, p0, Lcom/amazon/mShop/ItemView;->mItemRowUsedAndNew:Landroid/widget/TextView;

    invoke-virtual {v4, v7}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_5
.end method
