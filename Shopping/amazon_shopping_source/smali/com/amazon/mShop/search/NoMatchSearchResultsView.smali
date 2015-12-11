.class public Lcom/amazon/mShop/search/NoMatchSearchResultsView;
.super Landroid/widget/LinearLayout;
.source "NoMatchSearchResultsView.java"


# instance fields
.field private mActivity:Lcom/amazon/mShop/AmazonActivity;

.field private mGoldBox:Landroid/widget/Button;

.field private mHelp:Landroid/widget/Button;

.field private mMoreOptionsTitle:Landroid/widget/TextView;

.field private mRecommendedForYou:Landroid/widget/Button;

.field private mResultsType:Ljava/lang/String;

.field private mSearchAgainButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>(Lcom/amazon/mShop/AmazonActivity;Ljava/lang/String;)V
    .locals 3
    .param p1, "activity"    # Lcom/amazon/mShop/AmazonActivity;
    .param p2, "resultsType"    # Ljava/lang/String;

    .prologue
    .line 33
    invoke-direct {p0, p1}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 34
    iput-object p1, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    .line 35
    iput-object p2, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mResultsType:Ljava/lang/String;

    .line 36
    sget v1, Lcom/amazon/mShop/android/lib/R$layout;->search_results_no_match_view:I

    const/4 v2, 0x0

    invoke-static {p1, v1, v2}, Landroid/view/View;->inflate(Landroid/content/Context;ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    .line 37
    .local v0, "contentView":Landroid/view/View;
    invoke-direct {p0, v0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->init(Landroid/view/View;)V

    .line 38
    invoke-virtual {p0, v0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->addView(Landroid/view/View;)V

    .line 39
    return-void
.end method

.method static synthetic access$000(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Lcom/amazon/mShop/AmazonActivity;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    return-object v0
.end method

.method static synthetic access$100(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/amazon/mShop/search/NoMatchSearchResultsView;

    .prologue
    .line 17
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mResultsType:Ljava/lang/String;

    return-object v0
.end method

.method private init(Landroid/view/View;)V
    .locals 2
    .param p1, "contentView"    # Landroid/view/View;

    .prologue
    .line 43
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->search_results_view_research_button:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mSearchAgainButton:Landroid/widget/Button;

    .line 44
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mSearchAgainButton:Landroid/widget/Button;

    new-instance v1, Lcom/amazon/mShop/search/NoMatchSearchResultsView$1;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView$1;-><init>(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 52
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->search_results_view_group_title:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mMoreOptionsTitle:Landroid/widget/TextView;

    .line 53
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mMoreOptionsTitle:Landroid/widget/TextView;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->more:I

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(I)V

    .line 55
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->search_dead_end_link_recommendations:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mRecommendedForYou:Landroid/widget/Button;

    .line 56
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mRecommendedForYou:Landroid/widget/Button;

    new-instance v1, Lcom/amazon/mShop/search/NoMatchSearchResultsView$2;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView$2;-><init>(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 66
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->search_dead_end_link_goldbox:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mGoldBox:Landroid/widget/Button;

    .line 67
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mGoldBox:Landroid/widget/Button;

    new-instance v1, Lcom/amazon/mShop/search/NoMatchSearchResultsView$3;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView$3;-><init>(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 75
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mActivity:Lcom/amazon/mShop/AmazonActivity;

    sget v1, Lcom/amazon/mShop/android/lib/R$string;->config_hasGoldbox:I

    invoke-static {v0, v1}, Lcom/amazon/mShop/util/ConfigUtils;->isEnabled(Landroid/content/Context;I)Z

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 76
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mGoldBox:Landroid/widget/Button;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 81
    :goto_0
    sget v0, Lcom/amazon/mShop/android/lib/R$id;->search_dead_end_link_help:I

    invoke-virtual {p1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/Button;

    iput-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mHelp:Landroid/widget/Button;

    .line 82
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mHelp:Landroid/widget/Button;

    new-instance v1, Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;

    invoke-direct {v1, p0}, Lcom/amazon/mShop/search/NoMatchSearchResultsView$4;-><init>(Lcom/amazon/mShop/search/NoMatchSearchResultsView;)V

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 93
    return-void

    .line 78
    :cond_0
    iget-object v0, p0, Lcom/amazon/mShop/search/NoMatchSearchResultsView;->mGoldBox:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0
.end method
