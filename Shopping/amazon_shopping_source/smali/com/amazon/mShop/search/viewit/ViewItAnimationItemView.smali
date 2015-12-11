.class public Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;
.super Lcom/amazon/mShop/ItemView;
.source "ViewItAnimationItemView.java"


# instance fields
.field private mItemRowImage:Landroid/widget/ImageView;

.field private mSeeAllMatchesButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Lcom/amazon/mShop/ItemView;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 30
    return-void
.end method


# virtual methods
.method protected onFinishInflate()V
    .locals 1

    .prologue
    .line 34
    invoke-super {p0}, Lcom/amazon/mShop/ItemView;->onFinishInflate()V

    .line 36
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->item_row_image:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->mItemRowImage:Landroid/widget/ImageView;

    .line 37
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->see_all_matched_items_button:I

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->mSeeAllMatchesButton:Landroid/widget/Button;

    .line 38
    return-void
.end method

.method public update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V
    .locals 10
    .param p1, "adapter"    # Lcom/amazon/mShop/ObjectSubscriberAdapter;
    .param p2, "obj"    # Ljava/lang/Object;
    .param p3, "thumbnail"    # [B
    .param p4, "index"    # I

    .prologue
    .line 53
    move-object v6, p2

    check-cast v6, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 54
    .local v6, "searchResult":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicOffer()Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;

    move-result-object v0

    .line 55
    .local v0, "basicOffer":Lcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;
    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v1

    .line 56
    .local v1, "basicProduct":Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;
    invoke-virtual {p0, p2}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->setImageRequester(Ljava/lang/Object;)V

    .line 59
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_item_thumbnail_picture_max_dimension:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    invoke-static {v7, v8}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v2

    .line 60
    .local v2, "imageUrl":Ljava/lang/String;
    const-class v7, Landroid/graphics/Bitmap;

    invoke-static {v2, v7}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/graphics/Bitmap;

    .line 61
    .local v4, "productImageBitmap":Landroid/graphics/Bitmap;
    const/4 v5, 0x0

    .line 62
    .local v5, "productImageDrawable":Landroid/graphics/drawable/Drawable;
    if-eqz v4, :cond_0

    .line 63
    new-instance v3, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    const/4 v7, 0x0

    invoke-direct {v3, v2, v7}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 64
    .local v3, "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    invoke-interface {v7, v8, v4, v3}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    .line 66
    .end local v3    # "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    :cond_0
    iget-object v7, p0, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->mItemRowImage:Landroid/widget/ImageView;

    invoke-static {v5, v7}, Lcom/amazon/mShop/details/ItemViewUtils;->updateImageWithDrawable(Landroid/graphics/drawable/Drawable;Landroid/widget/ImageView;)V

    .line 68
    if-nez v5, :cond_1

    if-nez p3, :cond_1

    if-eqz v1, :cond_1

    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/lang/String;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 69
    invoke-virtual {v1}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {p0}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->getResources()Landroid/content/res/Resources;

    move-result-object v8

    sget v9, Lcom/amazon/mShop/android/lib/R$dimen;->view_it_item_thumbnail_picture_max_dimension:I

    invoke-virtual {v8, v9}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v8

    invoke-virtual {p0, v7, v8}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->getImageFromBackground(Ljava/lang/String;I)V

    .line 72
    :cond_1
    invoke-virtual {p0, p4, v0, v1}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->updateItemView(ILcom/amazon/rio/j2me/client/services/mShop/BasicOfferListing;Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;)V

    .line 73
    return-void
.end method

.method protected updateAnimationItem(Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;)V
    .locals 4
    .param p1, "newItem"    # Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;

    .prologue
    const/4 v1, 0x0

    const/4 v3, 0x0

    .line 41
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 42
    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    const/4 v2, 0x1

    if-le v0, v2, :cond_1

    .line 43
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->mSeeAllMatchesButton:Landroid/widget/Button;

    invoke-virtual {v0, v3}, Landroid/widget/Button;->setVisibility(I)V

    :goto_0
    move-object v0, v1

    .line 47
    check-cast v0, Lcom/amazon/mShop/ObjectSubscriberAdapter;

    invoke-virtual {p1}, Lcom/amazon/mShop/search/viewit/ViewItSearchResultWrapper;->getSearchResults()Ljava/util/List;

    move-result-object v2

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v1, [B

    invoke-virtual {p0, v0, v2, v1, v3}, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V

    .line 49
    :cond_0
    return-void

    .line 45
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/search/viewit/ViewItAnimationItemView;->mSeeAllMatchesButton:Landroid/widget/Button;

    const/16 v2, 0x8

    invoke-virtual {v0, v2}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0
.end method
