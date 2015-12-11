.class public Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;
.super Lcom/amazon/mShop/NonPagedItemAdapter;
.source "SnapItSearchResultsView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/search/image/SnapItSearchResultsView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4
    name = "SnapItSearchResultAdapter"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;Lcom/amazon/mShop/AmazonActivity;I)V
    .locals 0
    .param p2, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p3, "rowResId"    # I

    .prologue
    .line 118
    iput-object p1, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    .line 119
    invoke-direct {p0, p2, p3}, Lcom/amazon/mShop/NonPagedItemAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 120
    return-void
.end method

.method private convertDrawableIntoByteArray(Landroid/graphics/drawable/Drawable;)[B
    .locals 4
    .param p1, "d"    # Landroid/graphics/drawable/Drawable;

    .prologue
    .line 166
    const/4 v0, 0x0

    .line 167
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    instance-of v2, p1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    if-eqz v2, :cond_1

    .line 168
    check-cast p1, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;

    .end local p1    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p1}, Lcom/amazon/mShop/ui/WeakReferenceBitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    .line 172
    :cond_0
    :goto_0
    if-eqz v0, :cond_2

    .line 173
    new-instance v1, Ljava/io/ByteArrayOutputStream;

    invoke-direct {v1}, Ljava/io/ByteArrayOutputStream;-><init>()V

    .line 174
    .local v1, "stream":Ljava/io/ByteArrayOutputStream;
    sget-object v2, Landroid/graphics/Bitmap$CompressFormat;->JPEG:Landroid/graphics/Bitmap$CompressFormat;

    const/16 v3, 0x64

    invoke-virtual {v0, v2, v3, v1}, Landroid/graphics/Bitmap;->compress(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z

    .line 175
    invoke-virtual {v1}, Ljava/io/ByteArrayOutputStream;->toByteArray()[B

    move-result-object v2

    .line 177
    .end local v1    # "stream":Ljava/io/ByteArrayOutputStream;
    :goto_1
    return-object v2

    .line 169
    .restart local p1    # "d":Landroid/graphics/drawable/Drawable;
    :cond_1
    instance-of v2, p1, Landroid/graphics/drawable/BitmapDrawable;

    if-eqz v2, :cond_0

    .line 170
    check-cast p1, Landroid/graphics/drawable/BitmapDrawable;

    .end local p1    # "d":Landroid/graphics/drawable/Drawable;
    invoke-virtual {p1}, Landroid/graphics/drawable/BitmapDrawable;->getBitmap()Landroid/graphics/Bitmap;

    move-result-object v0

    goto :goto_0

    .line 177
    :cond_2
    const/4 v2, 0x0

    goto :goto_1
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 152
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;
    invoke-static {v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->access$100(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)Lcom/amazon/mShop/control/search/image/ImageSearchController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->count()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 157
    iget-object v0, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    # getter for: Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->mImageSearchController:Lcom/amazon/mShop/control/search/image/ImageSearchController;
    invoke-static {v0}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->access$100(Lcom/amazon/mShop/search/image/SnapItSearchResultsView;)Lcom/amazon/mShop/control/search/image/ImageSearchController;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/amazon/mShop/control/search/image/ImageSearchController;->getSearchResult(I)Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v0

    return-object v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 10
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v9, 0x0

    .line 187
    if-nez p2, :cond_1

    .line 188
    iget-object v6, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    iget v7, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->mRowResId:I

    invoke-virtual {v6, v7, v9}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/ItemView;

    .line 193
    .local v2, "itemview":Lcom/amazon/mShop/ItemView;
    :goto_0
    const/4 v6, 0x1

    invoke-virtual {v2, v6}, Lcom/amazon/mShop/ItemView;->setIsGetImageFromURL(Z)V

    .line 194
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 195
    .local v4, "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v6

    invoke-virtual {v6}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    invoke-virtual {v7}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$dimen;->item_row_height:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v7

    invoke-static {v6, v7}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v5

    .line 197
    .local v5, "url":Ljava/lang/String;
    const-class v6, Landroid/graphics/Bitmap;

    invoke-static {v5, v6}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 199
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    const/4 v1, 0x0

    .line 200
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 201
    new-instance v3, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-direct {v3, v5, v9}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 202
    .local v3, "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->this$0:Lcom/amazon/mShop/search/image/SnapItSearchResultsView;

    invoke-virtual {v7}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    invoke-interface {v6, v7, v0, v3}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 204
    .end local v3    # "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    :cond_0
    invoke-virtual {v2, p0, v4, v1, p1}, Lcom/amazon/mShop/ItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;Landroid/graphics/drawable/Drawable;I)V

    .line 205
    return-object v2

    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local v2    # "itemview":Lcom/amazon/mShop/ItemView;
    .end local v4    # "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .end local v5    # "url":Ljava/lang/String;
    :cond_1
    move-object v2, p2

    .line 190
    check-cast v2, Lcom/amazon/mShop/ItemView;

    .restart local v2    # "itemview":Lcom/amazon/mShop/ItemView;
    goto :goto_0
.end method

.method protected makeObjectForForward(ILandroid/view/View;)Ljava/lang/Object;
    .locals 5
    .param p1, "index"    # I
    .param p2, "view"    # Landroid/view/View;

    .prologue
    .line 132
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 133
    .local v1, "result":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    new-instance v0, Lcom/amazon/mShop/control/item/ProductController;

    invoke-direct {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/Object;)V

    .line 134
    .local v0, "controller":Lcom/amazon/mShop/control/item/ProductController;
    sget-object v4, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_SNAP_TELL:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0, v4}, Lcom/amazon/mShop/control/item/ProductController;->setClickStreamTag(Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 136
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->item_row_image:I

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/widget/ImageView;

    .line 138
    .local v3, "thumbnailView":Landroid/widget/ImageView;
    if-eqz v3, :cond_0

    .line 139
    invoke-virtual {v3}, Landroid/widget/ImageView;->getDrawable()Landroid/graphics/drawable/Drawable;

    move-result-object v4

    invoke-direct {p0, v4}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->convertDrawableIntoByteArray(Landroid/graphics/drawable/Drawable;)[B

    move-result-object v2

    .line 141
    .local v2, "thumbnail":[B
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/item/ProductController;->setThumbnail([B)V

    .line 145
    .end local v2    # "thumbnail":[B
    :cond_0
    const-string/jumbo v4, "sr_snap_pd"

    invoke-static {v4}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 147
    return-object v0
.end method

.method public setListView(Landroid/widget/ListView;)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 127
    invoke-virtual {p0, p1}, Lcom/amazon/mShop/search/image/SnapItSearchResultsView$SnapItSearchResultAdapter;->setAdapterView(Landroid/widget/AdapterView;)V

    .line 128
    return-void
.end method
