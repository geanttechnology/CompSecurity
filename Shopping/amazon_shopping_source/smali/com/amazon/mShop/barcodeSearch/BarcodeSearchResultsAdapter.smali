.class public Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;
.super Lcom/amazon/mShop/PagedListingAdapter;
.source "BarcodeSearchResultsAdapter.java"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/PagedListingAdapter",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
        ">;",
        "Landroid/widget/AdapterView$OnItemClickListener;"
    }
.end annotation


# instance fields
.field private final mActivity:Landroid/app/Activity;

.field private final mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

.field private final mClickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

.field private final mLayoutInflater:Landroid/view/LayoutInflater;

.field private mListView:Landroid/widget/ListView;

.field protected final mSearchResultItemResId:I


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Ljava/lang/String;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "searchResultItemResId"    # I
    .param p3, "controller"    # Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .param p4, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    .line 42
    invoke-direct {p0, p1}, Lcom/amazon/mShop/PagedListingAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;)V

    .line 43
    iput p2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mSearchResultItemResId:I

    .line 44
    iput-object p3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    .line 45
    iput-object p1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    invoke-static {v0}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    .line 47
    new-instance v0, Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v0, p4}, Lcom/amazon/mShop/control/item/ClickStreamTag;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mClickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    .line 48
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    .prologue
    .line 32
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    return-object v0
.end method

.method private getAndUpdateItemView(ILandroid/view/View;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "searchResult"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .prologue
    const/4 v8, 0x0

    .line 176
    if-nez p2, :cond_1

    .line 177
    iget-object v5, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    iget v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mSearchResultItemResId:I

    invoke-virtual {v5, v6, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/ItemView;

    .line 178
    .local v2, "itemView":Lcom/amazon/mShop/ItemView;
    const/4 v5, 0x1

    invoke-virtual {v2, v5}, Lcom/amazon/mShop/ItemView;->setIsGetImageFromURL(Z)V

    .line 183
    :goto_0
    invoke-virtual {p3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v5

    invoke-virtual {v5}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getImageUrl()Ljava/lang/String;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/amazon/mShop/android/lib/R$dimen;->item_row_height:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v6

    invoke-static {v5, v6}, Lcom/amazon/mShop/util/ImageUtil;->getImageUrl(Ljava/lang/String;I)Ljava/lang/String;

    move-result-object v4

    .line 185
    .local v4, "url":Ljava/lang/String;
    const-class v5, Landroid/graphics/Bitmap;

    invoke-static {v4, v5}, Lcom/amazon/mShop/net/LRUCache;->getValue(Ljava/lang/String;Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/graphics/Bitmap;

    .line 187
    .local v0, "bitmap":Landroid/graphics/Bitmap;
    const/4 v1, 0x0

    .line 188
    .local v1, "drawable":Landroid/graphics/drawable/Drawable;
    if-eqz v0, :cond_0

    .line 189
    new-instance v3, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;

    invoke-direct {v3, v4, v8}, Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;-><init>(Ljava/lang/String;Lcom/amazon/mShop/net/HttpFetcher$Subscriber;)V

    .line 190
    .local v3, "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    invoke-static {}, Lcom/amazon/mShop/ui/DrawableFactory;->getInstance()Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;

    move-result-object v5

    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    invoke-interface {v5, v6, v0, v3}, Lcom/amazon/mShop/ui/DrawableFactory$DrawableFactoryInterface;->createDrawable(Landroid/content/res/Resources;Landroid/graphics/Bitmap;Lcom/amazon/mShop/net/HttpFetcher$Params;)Landroid/graphics/drawable/Drawable;

    move-result-object v1

    .line 193
    .end local v3    # "params":Lcom/amazon/mShop/net/BitmapFetcher$BitmapFetcherParams;
    :cond_0
    invoke-virtual {v2, p0, p3, v1, p1}, Lcom/amazon/mShop/ItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;Landroid/graphics/drawable/Drawable;I)V

    .line 195
    return-object v2

    .end local v0    # "bitmap":Landroid/graphics/Bitmap;
    .end local v1    # "drawable":Landroid/graphics/drawable/Drawable;
    .end local v2    # "itemView":Lcom/amazon/mShop/ItemView;
    .end local v4    # "url":Ljava/lang/String;
    :cond_1
    move-object v2, p2

    .line 180
    check-cast v2, Lcom/amazon/mShop/ItemView;

    .restart local v2    # "itemView":Lcom/amazon/mShop/ItemView;
    goto :goto_0
.end method


# virtual methods
.method public getCount()I
    .locals 6

    .prologue
    const/4 v5, 0x2

    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 63
    iget-object v3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 65
    .local v0, "barcodeSearchResultType":I
    if-ne v0, v2, :cond_1

    .line 66
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v2

    if-lez v2, :cond_0

    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v2

    add-int/lit8 v1, v2, 0x1

    .line 67
    .local v1, "relatedItemsCount":I
    :cond_0
    add-int/lit8 v2, v1, 0x2

    .line 72
    .end local v1    # "relatedItemsCount":I
    :goto_0
    return v2

    .line 68
    :cond_1
    if-ne v0, v5, :cond_3

    .line 69
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v3

    iget-object v4, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchStatus()I

    move-result v4

    if-ne v4, v5, :cond_2

    move v1, v2

    :cond_2
    add-int v2, v3, v1

    goto :goto_0

    .line 72
    :cond_3
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v2

    goto :goto_0
.end method

.method public getItemViewType(I)I
    .locals 5
    .param p1, "position"    # I

    .prologue
    const/4 v3, 0x2

    const/4 v1, 0x0

    const/4 v2, 0x1

    .line 240
    iget-object v4, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 241
    .local v0, "barcodeSearchResultType":I
    if-ne v0, v2, :cond_5

    .line 242
    if-nez p1, :cond_1

    .line 262
    :cond_0
    :goto_0
    return v1

    .line 244
    :cond_1
    if-ne p1, v2, :cond_2

    move v1, v2

    .line 246
    goto :goto_0

    .line 247
    :cond_2
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v2

    if-lez v2, :cond_3

    if-ne p1, v3, :cond_3

    move v1, v3

    .line 248
    goto :goto_0

    .line 249
    :cond_3
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v2

    if-lez v2, :cond_4

    const/4 v2, 0x3

    if-ge p1, v2, :cond_0

    .line 262
    :cond_4
    const/4 v1, -0x1

    goto :goto_0

    .line 252
    :cond_5
    if-ne v0, v3, :cond_4

    .line 253
    iget-object v3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v3

    if-lt p1, v3, :cond_0

    move v1, v2

    .line 257
    goto :goto_0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 9
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v3, 0x0

    .line 98
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 99
    .local v0, "barcodeSearchResultType":I
    if-ne v0, v7, :cond_4

    .line 100
    if-nez p1, :cond_1

    .line 102
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getMatchItemSearchResult()Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v6

    invoke-direct {p0, p1, p2, v6}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->getAndUpdateItemView(ILandroid/view/View;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Landroid/view/View;

    move-result-object v3

    .line 171
    :cond_0
    :goto_0
    return-object v3

    .line 103
    :cond_1
    if-ne p1, v7, :cond_2

    .line 106
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->barcode_search_results_view_no_match_row:I

    invoke-virtual {v6, v7, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    .line 107
    .local v3, "noMatchBlock":Landroid/view/ViewGroup;
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->barcode_search_results_view_not_match_hint:I

    invoke-virtual {v3, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 108
    .local v2, "mismatchHint":Landroid/widget/TextView;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    invoke-virtual {v7}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->bc_search_bad_match_prompt:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    invoke-virtual {v7}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->bc_search_bad_match:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 110
    new-instance v6, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$1;-><init>(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)V

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 128
    .end local v2    # "mismatchHint":Landroid/widget/TextView;
    .end local v3    # "noMatchBlock":Landroid/view/ViewGroup;
    :cond_2
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v6

    if-lez v6, :cond_3

    if-ne p1, v8, :cond_3

    .line 131
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->search_results_view_title_row:I

    const/4 v8, 0x0

    invoke-virtual {v6, v7, v3, v8}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/LinearLayout;

    .line 132
    .local v4, "title":Landroid/widget/LinearLayout;
    sget v6, Lcom/amazon/mShop/android/lib/R$color;->blue_dark:I

    invoke-virtual {v4, v6}, Landroid/widget/LinearLayout;->setBackgroundResource(I)V

    .line 133
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->search_results_view_group_title:I

    invoke-virtual {v4, v6}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v5

    check-cast v5, Landroid/widget/TextView;

    .line 134
    .local v5, "titleText":Landroid/widget/TextView;
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getResultsTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    move-object v3, v4

    .line 135
    goto :goto_0

    .line 136
    .end local v4    # "title":Landroid/widget/LinearLayout;
    .end local v5    # "titleText":Landroid/widget/TextView;
    :cond_3
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v6

    if-lez v6, :cond_0

    const/4 v6, 0x3

    if-lt p1, v6, :cond_0

    .line 137
    add-int/lit8 v1, p1, -0x3

    .line 138
    .local v1, "currentIndexInBrowser":I
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v6, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 139
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v6, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getObjectAtIndex(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-direct {p0, v1, p2, v6}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->getAndUpdateItemView(ILandroid/view/View;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Landroid/view/View;

    move-result-object v3

    goto/16 :goto_0

    .line 141
    .end local v1    # "currentIndexInBrowser":I
    :cond_4
    if-ne v0, v8, :cond_0

    .line 142
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v6}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v6

    if-ge p1, v6, :cond_5

    .line 143
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v6, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 144
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v6, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getObjectAtIndex(I)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    invoke-direct {p0, p1, p2, v6}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->getAndUpdateItemView(ILandroid/view/View;Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)Landroid/view/View;

    move-result-object v3

    goto/16 :goto_0

    .line 147
    :cond_5
    iget-object v6, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mLayoutInflater:Landroid/view/LayoutInflater;

    sget v7, Lcom/amazon/mShop/android/lib/R$layout;->barcode_search_results_view_no_match_row:I

    invoke-virtual {v6, v7, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    .line 148
    .restart local v3    # "noMatchBlock":Landroid/view/ViewGroup;
    sget v6, Lcom/amazon/mShop/android/lib/R$id;->barcode_search_results_view_not_match_hint:I

    invoke-virtual {v3, v6}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 149
    .restart local v2    # "mismatchHint":Landroid/widget/TextView;
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v7, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    invoke-virtual {v7}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->bc_search_bad_match_prompt:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string/jumbo v7, " "

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    iget-object v7, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mActivity:Landroid/app/Activity;

    invoke-virtual {v7}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v7

    sget v8, Lcom/amazon/mShop/android/lib/R$string;->bc_search_bad_match:I

    invoke-virtual {v7, v8}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 151
    new-instance v6, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$2;

    invoke-direct {v6, p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter$2;-><init>(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;)V

    invoke-virtual {v2, v6}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_0
.end method

.method public getViewTypeCount()I
    .locals 1

    .prologue
    .line 268
    const/4 v0, 0x3

    return v0
.end method

.method public isEnabled(I)Z
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 84
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 85
    .local v0, "barcodeSearchResultType":I
    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 86
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v1

    if-lez v1, :cond_0

    const/4 v1, 0x2

    if-ne p1, v1, :cond_0

    .line 87
    const/4 v1, 0x0

    .line 91
    :goto_0
    return v1

    :cond_0
    invoke-super {p0, p1}, Lcom/amazon/mShop/PagedListingAdapter;->isEnabled(I)Z

    move-result v1

    goto :goto_0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 6
    .param p2, "view"    # Landroid/view/View;
    .param p3, "position"    # I
    .param p4, "id"    # J
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/widget/AdapterView",
            "<*>;",
            "Landroid/view/View;",
            "IJ)V"
        }
    .end annotation

    .prologue
    .line 201
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 203
    .local v0, "barcodeSearchResultType":I
    const/4 v2, 0x1

    if-ne v0, v2, :cond_2

    .line 204
    if-nez p3, :cond_1

    .line 205
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->getAmazonActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/control/item/ProductController;

    iget-object v4, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getMatchItemSearchResult()Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mClickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v3, v4, v5}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/Object;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->forward(Ljava/lang/Object;)Z

    .line 208
    const-string/jumbo v2, "sr_scan_pd"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 209
    const-string/jumbo v2, "scan_first_dp"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 232
    :cond_0
    :goto_0
    return-void

    .line 211
    :cond_1
    invoke-super {p0}, Lcom/amazon/mShop/PagedListingAdapter;->getCount()I

    move-result v2

    if-lez v2, :cond_0

    const/4 v2, 0x3

    if-lt p3, v2, :cond_0

    .line 212
    add-int/lit8 v1, p3, -0x3

    .line 213
    .local v1, "currentIndexInBrowser":I
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v2, v1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 214
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->getAmazonActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/control/item/ProductController;

    iget-object v4, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject()Ljava/lang/Object;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mClickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v3, v4, v5}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/Object;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->forward(Ljava/lang/Object;)Z

    .line 217
    const-string/jumbo v2, "sr_scan_pd"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 218
    const-string/jumbo v2, "scan_other_dp"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    .line 221
    .end local v1    # "currentIndexInBrowser":I
    :cond_2
    const/4 v2, 0x2

    if-ne v0, v2, :cond_0

    .line 222
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v2

    if-ge p3, v2, :cond_0

    .line 223
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v2, p3}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 224
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->getAmazonActivity()Lcom/amazon/mShop/AmazonActivity;

    move-result-object v2

    new-instance v3, Lcom/amazon/mShop/control/item/ProductController;

    iget-object v4, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4}, Lcom/amazon/mShop/control/PagedListingBrowser;->getCurrentObject()Ljava/lang/Object;

    move-result-object v4

    iget-object v5, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mClickStreamOrigin:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-direct {v3, v4, v5}, Lcom/amazon/mShop/control/item/ProductController;-><init>(Ljava/lang/Object;Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    invoke-virtual {v2, v3}, Lcom/amazon/mShop/AmazonActivity;->forward(Ljava/lang/Object;)Z

    .line 227
    const-string/jumbo v2, "sr_scan_pd"

    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 228
    if-nez p3, :cond_3

    const-string/jumbo v2, "scan_first_dp"

    :goto_1
    invoke-static {v2}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0

    :cond_3
    const-string/jumbo v2, "scan_other_dp"

    goto :goto_1
.end method

.method public setListView(Landroid/widget/ListView;)V
    .locals 0
    .param p1, "listView"    # Landroid/widget/ListView;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->mListView:Landroid/widget/ListView;

    .line 56
    invoke-virtual {p1, p0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 57
    invoke-virtual {p1, p0}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 58
    return-void
.end method
