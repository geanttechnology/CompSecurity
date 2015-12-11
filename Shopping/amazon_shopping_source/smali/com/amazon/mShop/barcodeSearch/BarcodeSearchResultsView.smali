.class public Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;
.super Landroid/widget/ListView;
.source "BarcodeSearchResultsView.java"

# interfaces
.implements Lcom/amazon/mShop/TitleProvider;
.implements Lcom/amazon/mShop/control/ObjectSubscriber;
.implements Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

.field private mBarcodeFormat:Ljava/lang/String;

.field private mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

.field private mBarcodeString:Ljava/lang/String;

.field private mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

.field private mFooterProgressBar:Landroid/widget/ProgressBar;

.field private mFooterProgressBarRow:Landroid/view/ViewGroup;

.field private mFooterStatus:Landroid/widget/TextView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 6
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "barcodeString"    # Ljava/lang/String;
    .param p3, "barcodeFormat"    # Ljava/lang/String;
    .param p4, "clickStreamOrigin"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    const/4 v4, 0x0

    .line 45
    invoke-direct {p0, p1}, Landroid/widget/ListView;-><init>(Landroid/content/Context;)V

    .line 47
    iput-object p1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 48
    iput-object p2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeString:Ljava/lang/String;

    .line 49
    iput-object p3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeFormat:Ljava/lang/String;

    .line 50
    new-instance v0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;-><init>(Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchSubscriber;)V

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    .line 51
    invoke-virtual {p0, v4}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->setHeaderDividersEnabled(Z)V

    .line 52
    invoke-virtual {p0, v4}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->setFooterDividersEnabled(Z)V

    .line 55
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->setItemsCanFocus(Z)V

    .line 58
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->barcode_search_results_view_footer_progressbar_row:I

    invoke-static {p1, v0, v1}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->barcode_search_results_view_footer_progress:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ProgressBar;

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBar:Landroid/widget/ProgressBar;

    .line 60
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    sget v2, Lcom/amazon/mShop/android/lib/R$id;->barcode_search_results_view_footer_status:I

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterStatus:Landroid/widget/TextView;

    .line 61
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->addFooterView(Landroid/view/View;)V

    .line 66
    new-instance v0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    sget v2, Lcom/amazon/mShop/android/lib/R$layout;->item_row:I

    iget-object v3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-direct {v0, p1, v2, v3, p4}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;ILcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    .line 68
    new-instance v0, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    const/16 v2, 0x8

    const/4 v3, 0x3

    const/16 v5, 0x64

    invoke-direct/range {v0 .. v5}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;-><init>(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;IIII)V

    iput-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    .line 69
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->setBrowser(Lcom/amazon/mShop/control/PagedListingBrowser;)V

    .line 73
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->setSecondarySubscriber(Lcom/amazon/mShop/control/ObjectSubscriber;)V

    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->setListView(Landroid/widget/ListView;)V

    .line 76
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;)V
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->startBarcodeSearch()V

    return-void
.end method

.method static synthetic access$100(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;

    .prologue
    .line 26
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method private startBarcodeSearch()V
    .locals 4

    .prologue
    .line 273
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/amazon/mShop/android/lib/R$dimen;->item_row_height:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v1

    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$dimen;->padding:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v2

    sub-int v0, v1, v2

    .line 275
    .local v0, "maxImageDimension":I
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeString:Ljava/lang/String;

    iget-object v3, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeFormat:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->startBarcodeSearch(Ljava/lang/String;Ljava/lang/String;I)V

    .line 276
    return-void
.end method


# virtual methods
.method public bridge synthetic getTitle()Ljava/lang/CharSequence;
    .locals 1

    .prologue
    .line 26
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->getTitle()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTitle()Ljava/lang/String;
    .locals 4

    .prologue
    .line 159
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->isErrorBoxShowing()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 160
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->search_results_title:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    .line 175
    :goto_0
    return-object v2

    .line 163
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 164
    .local v0, "searchResultType":I
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchStatus()I

    move-result v1

    .line 166
    .local v1, "searchStatus":I
    const/4 v2, 0x2

    if-ne v1, v2, :cond_3

    .line 167
    if-nez v0, :cond_1

    .line 168
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->bc_search_no_result:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 169
    :cond_1
    const/4 v2, 0x1

    if-ne v0, v2, :cond_2

    .line 170
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->bc_search_result:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 172
    :cond_2
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->bc_search_result_plural:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0

    .line 175
    :cond_3
    iget-object v2, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v2}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/amazon/mShop/android/lib/R$string;->bc_searching_for:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    goto :goto_0
.end method

.method protected onAttachedToWindow()V
    .locals 0

    .prologue
    .line 82
    invoke-super {p0}, Landroid/widget/ListView;->onAttachedToWindow()V

    .line 83
    invoke-direct {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->startBarcodeSearch()V

    .line 84
    return-void
.end method

.method public onAvailableCountReceived(I)V
    .locals 0
    .param p1, "availableCount"    # I

    .prologue
    .line 97
    return-void
.end method

.method public onCancelled()V
    .locals 0

    .prologue
    .line 102
    return-void
.end method

.method public onCompleted()V
    .locals 4

    .prologue
    const/16 v2, 0x8

    .line 182
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v1, p0}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 184
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 185
    .local v0, "resultType":I
    if-nez v0, :cond_1

    .line 186
    const-string/jumbo v1, "scan_no_matches"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    .line 192
    :goto_0
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->hasMoreResults()Z

    move-result v1

    if-nez v1, :cond_0

    .line 193
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v1, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 194
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterStatus:Landroid/widget/TextView;

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 195
    if-nez v0, :cond_0

    .line 196
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    invoke-virtual {p0, v1}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->removeFooterView(Landroid/view/View;)Z

    .line 197
    new-instance v2, Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->getContext()Landroid/content/Context;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/AmazonActivity;

    const-string/jumbo v3, "scanItSearchResultsType"

    invoke-direct {v2, v1, v3}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;-><init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->addFooterView(Landroid/view/View;)V

    .line 200
    :cond_0
    return-void

    .line 188
    :cond_1
    const-string/jumbo v1, "scan_success"

    invoke-static {v1}, Lcom/amazon/mShop/net/RefMarkerObserver;->logRefMarker(Ljava/lang/String;)V

    goto :goto_0
.end method

.method protected onDetachedFromWindow()V
    .locals 1

    .prologue
    .line 88
    invoke-super {p0}, Landroid/widget/ListView;->onDetachedFromWindow()V

    .line 90
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->cancel()V

    .line 91
    return-void
.end method

.method public onError(Ljava/lang/Exception;Lcom/amazon/rio/j2me/client/services/ServiceCall;)V
    .locals 2
    .param p1, "e"    # Ljava/lang/Exception;
    .param p2, "sc"    # Lcom/amazon/rio/j2me/client/services/ServiceCall;

    .prologue
    .line 142
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    const/4 v1, 0x2

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->setBarcodeSearchStatus(I)V

    .line 145
    invoke-virtual {p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->getContext()Landroid/content/Context;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/AmazonActivity;

    new-instance v1, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView$1;-><init>(Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;)V

    invoke-static {v0, v1, p0, p1}, Lcom/amazon/mShop/util/AmazonErrorUtils;->reportMShopServerError(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/error/AmazonErrorBox$AmazonErrorBoxActionListener;Landroid/view/View;Ljava/lang/Exception;)V

    .line 151
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v0, p0}, Lcom/amazon/mShop/AmazonActivity;->updateTitle(Landroid/view/View;)V

    .line 154
    return-void
.end method

.method public onImageReceived([BI)V
    .locals 0
    .param p1, "value"    # [B
    .param p2, "index"    # I

    .prologue
    .line 210
    return-void
.end method

.method public onMatchedItemReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;)V
    .locals 1
    .param p1, "result"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .prologue
    .line 218
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->notifyDataSetChanged()V

    .line 219
    return-void
.end method

.method public onMatchedItemThumbnailReceived([B)V
    .locals 1
    .param p1, "value"    # [B

    .prologue
    .line 225
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->notifyDataSetChanged()V

    .line 226
    return-void
.end method

.method public onMatchedItemsReturnedReceived(Z)V
    .locals 3
    .param p1, "value"    # Z

    .prologue
    .line 232
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 233
    .local v0, "barcodeSearchResultType":I
    if-nez v0, :cond_0

    .line 234
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->setBarcodeSearchStatus(I)V

    .line 239
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    invoke-virtual {v1}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->notifyDataSetChanged()V

    .line 240
    return-void
.end method

.method public onObjectReceived(Ljava/lang/Object;I)V
    .locals 1
    .param p1, "o"    # Ljava/lang/Object;
    .param p2, "index"    # I

    .prologue
    .line 106
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    if-eqz v0, :cond_0

    .line 107
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->notifyDataSetChanged()V

    .line 109
    :cond_0
    return-void
.end method

.method public onObjectsReceived()V
    .locals 0

    .prologue
    .line 114
    return-void
.end method

.method public onPageComplete()V
    .locals 4

    .prologue
    const/4 v3, 0x2

    const/16 v2, 0x8

    .line 122
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->getAvailableCount()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->getReceivedCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 125
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 126
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->removeFooterView(Landroid/view/View;)Z

    .line 127
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->setBarcodeSearchStatus(I)V

    .line 138
    :goto_0
    return-void

    .line 128
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    invoke-virtual {v0}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->getAvailableCount()I

    move-result v0

    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->getReceivedCount()I

    move-result v1

    if-gt v0, v1, :cond_1

    .line 130
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBar:Landroid/widget/ProgressBar;

    invoke-virtual {v0, v2}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 131
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterStatus:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 132
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    invoke-virtual {p0, v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->removeFooterView(Landroid/view/View;)Z

    .line 133
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v0, v3}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->setBarcodeSearchStatus(I)V

    goto :goto_0

    .line 135
    :cond_1
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterProgressBarRow:Landroid/view/ViewGroup;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 136
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mFooterStatus:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->loading:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    goto :goto_0
.end method

.method public onQueryDescriptorReceived(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V
    .locals 4
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;

    .prologue
    const/4 v2, 0x2

    .line 246
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;->getQueryData()Ljava/util/List;

    move-result-object v1

    invoke-static {v1}, Lcom/amazon/mShop/util/Util;->isEmpty(Ljava/util/Collection;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 247
    :cond_0
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v1, v2}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->setBarcodeSearchStatus(I)V

    .line 257
    :cond_1
    :goto_0
    return-void

    .line 250
    :cond_2
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBarcodeSearchController:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;

    invoke-virtual {v1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchController;->getBarcodeSearchResultType()I

    move-result v0

    .line 252
    .local v0, "barcodeSearchResultType":I
    const/4 v1, 0x1

    if-eq v0, v1, :cond_3

    if-ne v0, v2, :cond_1

    .line 254
    :cond_3
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    invoke-virtual {v1, p1}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->setQueryDescriptor(Lcom/amazon/rio/j2me/client/services/mShop/QueryDescriptor;)V

    .line 255
    iget-object v1, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mBrowser:Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;

    const v2, 0x7fffffff

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3}, Lcom/amazon/mShop/control/barcodeSearch/BarcodeSearchBrowser;->startFirstPageRequest(ILjava/util/List;)Z

    goto :goto_0
.end method

.method public onResultsTitleReceived(Ljava/lang/String;)V
    .locals 1
    .param p1, "title"    # Ljava/lang/String;

    .prologue
    .line 262
    iget-object v0, p0, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsView;->mAdapter:Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;

    invoke-virtual {v0}, Lcom/amazon/mShop/barcodeSearch/BarcodeSearchResultsAdapter;->notifyDataSetChanged()V

    .line 263
    return-void
.end method

.method public onSearchResultReceived(Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;I)V
    .locals 0
    .param p1, "value"    # Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    .param p2, "index"    # I

    .prologue
    .line 269
    return-void
.end method
