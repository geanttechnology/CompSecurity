.class public Lcom/amazon/mShop/recommendations/RecommendationsAdapter;
.super Lcom/amazon/mShop/PagedItemAdapter;
.source "RecommendationsAdapter.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/amazon/mShop/PagedItemAdapter",
        "<",
        "Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;",
        ">;"
    }
.end annotation


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mFixRecommendationClickListener:Landroid/view/View$OnClickListener;

.field private mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;

.field private mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "resultsView"    # Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .prologue
    .line 34
    sget v0, Lcom/amazon/mShop/android/lib/R$layout;->recs_item_view:I

    invoke-direct {p0, p1, v0}, Lcom/amazon/mShop/PagedItemAdapter;-><init>(Lcom/amazon/mShop/AmazonActivity;I)V

    .line 67
    new-instance v0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;

    invoke-direct {v0, p0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$1;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)V

    iput-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixRecommendationClickListener:Landroid/view/View$OnClickListener;

    .line 35
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 36
    iput-object p2, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .line 37
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonAlertDialog;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    return-object v0
.end method

.method static synthetic access$002(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;Lcom/amazon/mShop/AmazonAlertDialog;)Lcom/amazon/mShop/AmazonAlertDialog;
    .locals 0
    .param p0, "x0"    # Lcom/amazon/mShop/recommendations/RecommendationsAdapter;
    .param p1, "x1"    # Lcom/amazon/mShop/AmazonAlertDialog;

    .prologue
    .line 25
    iput-object p1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    return-object p1
.end method

.method static synthetic access$100(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/recommendations/RecommendationsAdapter;

    .prologue
    .line 25
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method


# virtual methods
.method public dismissDialog()V
    .locals 1

    .prologue
    .line 213
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 214
    iget-object v0, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixThisRecsDialog:Lcom/amazon/mShop/AmazonAlertDialog;

    invoke-virtual {v0}, Lcom/amazon/mShop/AmazonAlertDialog;->dismiss()V

    .line 216
    :cond_0
    return-void
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 8
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;
    .param p3, "parent"    # Landroid/view/ViewGroup;

    .prologue
    const/16 v7, 0x8

    .line 103
    iget-object v4, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->setCurrentIndex(I)V

    .line 108
    if-nez p2, :cond_0

    .line 109
    iget-object v4, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->layoutInflater:Landroid/view/LayoutInflater;

    iget v5, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->rowResId:I

    const/4 v6, 0x0

    invoke-virtual {v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/recommendations/RecommendationsItemView;

    .line 114
    .local v1, "itemView":Lcom/amazon/mShop/recommendations/RecommendationsItemView;
    :goto_0
    iget-object v4, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getObjectAtIndex(I)Ljava/lang/Object;

    move-result-object v2

    .line 116
    .local v2, "o":Ljava/lang/Object;
    iget-object v4, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v4, p1}, Lcom/amazon/mShop/control/PagedListingBrowser;->getImageAtIndex(I)[B

    move-result-object v3

    .line 117
    .local v3, "thumbnail":[B
    invoke-virtual {v1, p0, v2, v3, p1}, Lcom/amazon/mShop/recommendations/RecommendationsItemView;->update(Lcom/amazon/mShop/ObjectSubscriberAdapter;Ljava/lang/Object;[BI)V

    .line 119
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->fix_this_recommendation:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/recommendations/RecommendationsItemView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 120
    .local v0, "fixThisRecommendation":Landroid/widget/TextView;
    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 121
    iget-object v4, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mFixRecommendationClickListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v4}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 123
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->item_amazonpoints:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/recommendations/RecommendationsItemView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    .line 124
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->item_used_and_new:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/recommendations/RecommendationsItemView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    .line 125
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->item_rating:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/recommendations/RecommendationsItemView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    .line 126
    sget v4, Lcom/amazon/mShop/android/lib/R$id;->item_customer_reviews_count:I

    invoke-virtual {v1, v4}, Lcom/amazon/mShop/recommendations/RecommendationsItemView;->findViewById(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4, v7}, Landroid/view/View;->setVisibility(I)V

    .line 128
    return-object v1

    .end local v0    # "fixThisRecommendation":Landroid/widget/TextView;
    .end local v1    # "itemView":Lcom/amazon/mShop/recommendations/RecommendationsItemView;
    .end local v2    # "o":Ljava/lang/Object;
    .end local v3    # "thumbnail":[B
    :cond_0
    move-object v1, p2

    .line 111
    check-cast v1, Lcom/amazon/mShop/recommendations/RecommendationsItemView;

    .restart local v1    # "itemView":Lcom/amazon/mShop/recommendations/RecommendationsItemView;
    goto :goto_0
.end method

.method protected makeObjectForForward()Ljava/lang/Object;
    .locals 2

    .prologue
    .line 202
    invoke-super {p0}, Lcom/amazon/mShop/PagedItemAdapter;->makeObjectForForward()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/control/item/ProductController;

    .line 203
    .local v0, "controller":Lcom/amazon/mShop/control/item/ProductController;
    sget-object v1, Lcom/amazon/mShop/control/item/ClickStreamTag;->ORIGIN_RECOMMENDEDITEMS:Lcom/amazon/mShop/control/item/ClickStreamTag;

    invoke-virtual {v0, v1}, Lcom/amazon/mShop/control/item/ProductController;->setClickStreamTag(Lcom/amazon/mShop/control/item/ClickStreamTag;)V

    .line 204
    return-object v0
.end method

.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 4
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
    .line 166
    .local p1, "parent":Landroid/widget/AdapterView;, "Landroid/widget/AdapterView<*>;"
    invoke-super/range {p0 .. p5}, Lcom/amazon/mShop/PagedItemAdapter;->onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V

    .line 186
    invoke-static {}, Lcom/amazon/mShop/platform/Platform$Factory;->getInstance()Lcom/amazon/mShop/platform/Platform;

    move-result-object v0

    new-instance v1, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter$2;-><init>(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;)V

    const-wide/16 v2, 0x1f4

    invoke-interface {v0, v1, v2, v3}, Lcom/amazon/mShop/platform/Platform;->invokeLater(Ljava/lang/Runnable;J)V

    .line 193
    return-void
.end method

.method public refreshStatus()V
    .locals 8

    .prologue
    .line 136
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    sget v4, Lcom/amazon/mShop/android/lib/R$id;->search_results_status:I

    invoke-virtual {v3, v4}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    .line 137
    .local v2, "status":Landroid/widget/TextView;
    iget-object v1, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    check-cast v1, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .line 141
    .local v1, "recommendationBrowser":Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    invoke-virtual {v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getReceivedCount()I

    move-result v3

    invoke-virtual {v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->getRatingPendingIndexSet()Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->size()I

    move-result v4

    add-int v0, v3, v4

    .line 143
    .local v0, "receivedCount":I
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->getAvailableCount()I

    move-result v3

    if-gt v3, v0, :cond_2

    invoke-virtual {v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->hasCategoryResult()Z

    move-result v3

    if-eqz v3, :cond_2

    if-eqz v2, :cond_2

    .line 144
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->getBrowser()Lcom/amazon/mShop/control/PagedListingBrowser;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v3

    if-lez v3, :cond_1

    .line 145
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    invoke-virtual {v3}, Lcom/amazon/mShop/AmazonActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/amazon/mShop/android/lib/R$string;->search_end_of_x_top_results_for_y:I

    const/4 v5, 0x2

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->getBrowser()Lcom/amazon/mShop/control/PagedListingBrowser;

    move-result-object v7

    invoke-virtual {v7}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v7

    invoke-static {v7}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v7

    aput-object v7, v5, v6

    const/4 v6, 0x1

    iget-object v7, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    iget-object v7, v7, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mCategoryResult:Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;

    invoke-virtual {v7}, Lcom/amazon/rio/j2me/client/services/mShop/CategoryResult;->getDisplayName()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 153
    :cond_0
    :goto_0
    return-void

    .line 147
    :cond_1
    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->getBrowser()Lcom/amazon/mShop/control/PagedListingBrowser;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v3

    if-nez v3, :cond_0

    .line 148
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->setNoRecommendation(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V

    goto :goto_0

    .line 150
    :cond_2
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->browser:Lcom/amazon/mShop/control/PagedListingBrowser;

    invoke-virtual {v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->getAvailableCount()I

    move-result v3

    if-gt v3, v0, :cond_0

    invoke-virtual {p0}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->getBrowser()Lcom/amazon/mShop/control/PagedListingBrowser;

    move-result-object v3

    invoke-virtual {v3}, Lcom/amazon/mShop/control/PagedListingBrowser;->getReceivedCount()I

    move-result v3

    if-nez v3, :cond_0

    .line 151
    iget-object v3, p0, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->mResultsView:Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    invoke-virtual {p0, v3}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->setNoRecommendation(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V

    goto :goto_0
.end method

.method public removeItemAndRefreshUI(Lcom/amazon/mShop/recommendations/RecommendationsAdapter;II)V
    .locals 5
    .param p1, "recommendationsAdapter"    # Lcom/amazon/mShop/recommendations/RecommendationsAdapter;
    .param p2, "index"    # I
    .param p3, "recsRatingType"    # I

    .prologue
    .line 52
    invoke-virtual {p1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->getBrowser()Lcom/amazon/mShop/control/PagedListingBrowser;

    move-result-object v0

    check-cast v0, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;

    .line 53
    .local v0, "recommendationBrowser":Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->removeItemAt(I)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;

    .line 54
    .local v3, "sr":Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;
    invoke-virtual {v0, p2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->removeItemIndexAt(I)I

    move-result v2

    .line 56
    .local v2, "serverIndex":I
    invoke-virtual {v0, v2}, Lcom/amazon/mShop/control/recommendations/RecommendationsBrowser;->addRatingPendingIndex(I)V

    .line 58
    new-instance v1, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;

    invoke-direct {v1}, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;-><init>()V

    .line 59
    .local v1, "recsRating":Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;
    invoke-virtual {v3}, Lcom/amazon/rio/j2me/client/services/mShop/SearchResult;->getBasicProduct()Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;

    move-result-object v4

    invoke-virtual {v4}, Lcom/amazon/rio/j2me/client/services/mShop/BasicProductInfo;->getAsin()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;->setAsin(Ljava/lang/String;)V

    .line 60
    invoke-virtual {v1, p3}, Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;->setType(I)V

    .line 61
    invoke-static {}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->getInstance()Lcom/amazon/mShop/control/recommendations/RecommendationsController;

    move-result-object v4

    invoke-virtual {v4, v1}, Lcom/amazon/mShop/control/recommendations/RecommendationsController;->addRatingToPendingList(Lcom/amazon/rio/j2me/client/services/mShop/RecsRating;)V

    .line 63
    invoke-virtual {p1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->notifyDataSetChanged()V

    .line 64
    invoke-virtual {p1}, Lcom/amazon/mShop/recommendations/RecommendationsAdapter;->refreshStatus()V

    .line 65
    return-void
.end method

.method public setNoRecommendation(Lcom/amazon/mShop/recommendations/RecommendationsResultsView;)V
    .locals 3
    .param p1, "view"    # Lcom/amazon/mShop/recommendations/RecommendationsResultsView;

    .prologue
    .line 156
    sget v1, Lcom/amazon/mShop/android/lib/R$id;->search_results_status:I

    invoke-virtual {p1, v1}, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    .line 157
    .local v0, "status":Landroid/widget/TextView;
    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 158
    iget-object v1, p1, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    invoke-virtual {v1}, Landroid/widget/TextView;->getVisibility()I

    move-result v1

    if-eqz v1, :cond_0

    .line 159
    iget-object v1, p1, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    sget v2, Lcom/amazon/mShop/android/lib/R$string;->recommendations_no_recs_explanation:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 160
    iget-object v1, p1, Lcom/amazon/mShop/recommendations/RecommendationsResultsView;->mNoRecommendation:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 162
    :cond_0
    return-void
.end method
