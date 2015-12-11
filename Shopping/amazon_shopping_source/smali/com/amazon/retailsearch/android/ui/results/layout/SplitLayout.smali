.class public Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;
.super Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;
.source "SplitLayout.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$1;,
        Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;
    }
.end annotation


# instance fields
.field private asinEntryGroupIndex:I

.field private dividerWidth:I

.field private horizontalDivider:Landroid/graphics/drawable/Drawable;

.field private horizontalProgressBar:Landroid/widget/LinearLayout;

.field private horizontalScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;

.field private horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

.field private isProgressBarVisible:Z

.field private verticalDivider:Landroid/graphics/drawable/Drawable;

.field private verticalProgressBar:Landroid/widget/LinearLayout;

.field private verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;


# direct methods
.method public constructor <init>(Landroid/view/ViewGroup;Lcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;I)V
    .locals 8
    .param p1, "container"    # Landroid/view/ViewGroup;
    .param p2, "resourceProvider"    # Lcom/amazon/ansel/fetch/ResourceProvider;
    .param p3, "asinImpressionTracker"    # Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;
    .param p4, "index"    # I

    .prologue
    const/4 v2, 0x1

    .line 42
    sget v5, Lcom/amazon/retailsearch/R$dimen;->rs_results_image_width_gallery:I

    sget v6, Lcom/amazon/retailsearch/R$dimen;->rs_results_image_height_gallery:I

    sget v7, Lcom/amazon/retailsearch/R$integer;->config_rs_atf_product_count_gallery:I

    move-object v0, p0

    move-object v1, p1

    move-object v3, p2

    move-object v4, p3

    invoke-direct/range {v0 .. v7}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;-><init>(Landroid/view/ViewGroup;ILcom/amazon/ansel/fetch/ResourceProvider;Lcom/amazon/retailsearch/metrics/impressions/AsinImpressionTracker;III)V

    .line 34
    new-instance v0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;

    const/4 v1, 0x0

    invoke-direct {v0, p0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;-><init>(Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$1;)V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;

    .line 35
    iput-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->isProgressBarVisible:Z

    .line 51
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_split_list_divider:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalDivider:Landroid/graphics/drawable/Drawable;

    .line 52
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$drawable;->rs_split_view_vertical_divider:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalDivider:Landroid/graphics/drawable/Drawable;

    .line 53
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-virtual {v0}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/amazon/retailsearch/R$dimen;->rs_results_divider_line:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->dividerWidth:I

    .line 54
    iput p4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->asinEntryGroupIndex:I

    .line 55
    return-void
.end method

.method private createVerticalStackView()Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 78
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$layout;->rs_vertical_stack_view:I

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v4

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 80
    .local v0, "root":Landroid/view/View;
    sget v2, Lcom/amazon/retailsearch/R$id;->rs_vertical_stack_view:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    .line 81
    .local v1, "stackView":Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;
    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_vertical_splitview_background:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->setBackgroundResource(I)V

    .line 82
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getScrollListener()Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout$ScrollListener;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 83
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$layout;->rs_search_spinner:I

    invoke-virtual {v2, v3, v1, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    .line 85
    iget-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->isProgressBarVisible:Z

    if-nez v2, :cond_0

    .line 87
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 89
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v6}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 90
    return-object v1
.end method


# virtual methods
.method protected add(Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;)V
    .locals 0
    .param p1, "viewEntry"    # Lcom/amazon/retailsearch/android/ui/listadapter/ViewEntry;
    .param p2, "layoutElementModel"    # Lcom/amazon/retailsearch/android/ui/results/layout/LayoutElementModel;

    .prologue
    .line 67
    return-void
.end method

.method protected addCategoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;I)V
    .locals 1
    .param p1, "categoryCorrected"    # Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;
    .param p2, "index"    # I

    .prologue
    .line 230
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->asinEntryGroupIndex:I

    if-ne p2, v0, :cond_0

    .line 231
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addCategoryCorrected(Lcom/amazon/searchapp/retailsearch/model/CategoryCorrected;)V

    .line 233
    :cond_0
    return-void
.end method

.method protected addDidYouMean(Lcom/amazon/searchapp/retailsearch/model/DidYouMean;)V
    .locals 0
    .param p1, "didYouMean"    # Lcom/amazon/searchapp/retailsearch/model/DidYouMean;

    .prologue
    .line 198
    return-void
.end method

.method protected addFkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;I)V
    .locals 1
    .param p1, "fkmr"    # Lcom/amazon/searchapp/retailsearch/model/FKMR;
    .param p2, "index"    # I

    .prologue
    .line 209
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->asinEntryGroupIndex:I

    if-ne p2, v0, :cond_0

    .line 210
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addFkmr(Lcom/amazon/searchapp/retailsearch/model/FKMR;)V

    .line 212
    :cond_0
    return-void
.end method

.method protected addProductWrapper(Lcom/amazon/searchapp/retailsearch/model/Product;)V
    .locals 1
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 202
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getEntryGroupIndex()I

    move-result v0

    if-nez v0, :cond_0

    .line 203
    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->addProduct(Lcom/amazon/searchapp/retailsearch/model/Product;)Z

    .line 205
    :cond_0
    return-void
.end method

.method protected addRelatedSearches(Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;)V
    .locals 0
    .param p1, "relatedSearches"    # Lcom/amazon/searchapp/retailsearch/model/RelatedSearches;

    .prologue
    .line 71
    return-void
.end method

.method protected addSpellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;I)V
    .locals 1
    .param p1, "spellCorrected"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
    .param p2, "index"    # I

    .prologue
    .line 216
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->asinEntryGroupIndex:I

    if-ne p2, v0, :cond_0

    .line 217
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addSpellCorrected(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    .line 219
    :cond_0
    return-void
.end method

.method protected addWordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;I)V
    .locals 1
    .param p1, "wordSplitter"    # Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;
    .param p2, "index"    # I

    .prologue
    .line 223
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->asinEntryGroupIndex:I

    if-ne p2, v0, :cond_0

    .line 224
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->addWordSplitter(Lcom/amazon/searchapp/retailsearch/model/SpellCorrected;)V

    .line 226
    :cond_0
    return-void
.end method

.method public changeOrientation(ILcom/amazon/retailsearch/android/ui/results/layout/UserState;)V
    .locals 4
    .param p1, "orientation"    # I
    .param p2, "userState"    # Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .prologue
    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 135
    invoke-super {p0, p1, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->changeOrientation(ILcom/amazon/retailsearch/android/ui/results/layout/UserState;)V

    .line 136
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getStackView()Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    .line 137
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-nez v0, :cond_0

    .line 138
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->addView(Landroid/view/View;)V

    .line 140
    :cond_0
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getOrientation()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_3

    .line 141
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    if-eqz v0, :cond_1

    .line 142
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 144
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 151
    :goto_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getAdapter()Lcom/amazon/retailsearch/android/ui/listadapter/GeneratorAdapter;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 152
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->update()V

    .line 153
    if-eqz p2, :cond_2

    .line 154
    invoke-virtual {p0, p2}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->restoreUserState(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V

    .line 156
    :cond_2
    return-void

    .line 146
    :cond_3
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    if-eqz v0, :cond_4

    .line 147
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 149
    :cond_4
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0
.end method

.method protected createHorizontalStackView()Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;
    .locals 7

    .prologue
    const/4 v6, 0x0

    .line 98
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$layout;->rs_horizontal_stack_view:I

    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v4

    const/4 v5, 0x1

    invoke-virtual {v2, v3, v4, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 100
    .local v0, "root":Landroid/view/View;
    sget v2, Lcom/amazon/retailsearch/R$id;->rs_horizontal_stack_view:I

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    .line 101
    .local v1, "stackView":Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;
    sget v2, Lcom/amazon/retailsearch/R$drawable;->rs_horizontal_stack_view_background:I

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->setBackgroundResource(I)V

    .line 102
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalScrollListener:Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout$HorizontalScrollListener;

    invoke-virtual {v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->setOnScrollListener(Lcom/amazon/retailsearch/android/ui/HorizontalListView$OnScrollListener;)V

    .line 103
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getContainer()Landroid/view/ViewGroup;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/ViewGroup;->getContext()Landroid/content/Context;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v2

    sget v3, Lcom/amazon/retailsearch/R$layout;->rs_search_spinner:I

    invoke-virtual {v2, v3, v1, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    iput-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    .line 105
    iget-boolean v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->isProgressBarVisible:Z

    if-nez v2, :cond_0

    .line 107
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 109
    :cond_0
    iget-object v2, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    const/4 v3, 0x0

    invoke-virtual {v1, v2, v3, v6}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 110
    return-object v1
.end method

.method protected createProductCell(Lcom/amazon/searchapp/retailsearch/model/Product;)Lcom/amazon/retailsearch/android/ui/listadapter/ViewBuilderEntry;
    .locals 3
    .param p1, "product"    # Lcom/amazon/searchapp/retailsearch/model/Product;

    .prologue
    .line 59
    const/16 v0, 0x10

    const-class v1, Lcom/amazon/retailsearch/android/ui/results/SplitProduct;

    invoke-virtual {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->createProductViewModel(Lcom/amazon/searchapp/retailsearch/model/Product;)Lcom/amazon/retailsearch/android/ui/results/ProductViewModel;

    move-result-object v2

    invoke-static {v0, v1, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->createContentView(ILjava/lang/Class;Ljava/lang/Object;)Lcom/amazon/retailsearch/android/ui/listadapter/ModelViewEntry;

    move-result-object v0

    return-object v0
.end method

.method protected detachViews()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 160
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    if-eqz v0, :cond_1

    .line 161
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 162
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 164
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 165
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 168
    :cond_1
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    if-eqz v0, :cond_3

    .line 169
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 170
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {v1}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    .line 172
    :cond_2
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->getAdapter()Landroid/widget/ListAdapter;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 173
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {v0, v2}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 176
    :cond_3
    return-void
.end method

.method public enable(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V
    .locals 1
    .param p1, "state"    # Lcom/amazon/retailsearch/android/ui/results/layout/UserState;

    .prologue
    .line 245
    invoke-virtual {p1}, Lcom/amazon/retailsearch/android/ui/results/layout/UserState;->getEntryIndex()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->setEntryGroupIndex(I)V

    .line 246
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->enable(Lcom/amazon/retailsearch/android/ui/results/layout/UserState;)V

    .line 247
    return-void
.end method

.method public getEntryGroupIndex()I
    .locals 1

    .prologue
    .line 240
    iget v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->asinEntryGroupIndex:I

    return v0
.end method

.method protected getFirstVisibleItemPosition(Landroid/view/View;)I
    .locals 6
    .param p1, "firstVisibleView"    # Landroid/view/View;

    .prologue
    const/4 v0, 0x0

    .line 181
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getOrientation()I

    move-result v4

    const/4 v5, 0x2

    if-ne v4, v5, :cond_1

    .line 182
    invoke-super {p0, p1}, Lcom/amazon/retailsearch/android/ui/results/layout/StackLayout;->getFirstVisibleItemPosition(Landroid/view/View;)I

    move-result v1

    .line 192
    :cond_0
    :goto_0
    return v1

    .line 184
    :cond_1
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getFirstVisiblePosition()I

    move-result v1

    .line 185
    .local v1, "firstVisiblePosition":I
    invoke-virtual {p1}, Landroid/view/View;->getWidth()I

    move-result v4

    div-int/lit8 v2, v4, 0x2

    .line 186
    .local v2, "halfItemWidth":I
    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    invoke-interface {v4, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/StackView;->getChildAt(I)Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getLeft()I

    move-result v3

    .line 187
    .local v3, "rowLeft":I
    invoke-static {v3}, Ljava/lang/Math;->abs(I)I

    move-result v4

    if-le v4, v2, :cond_2

    const/4 v0, 0x1

    .line 188
    .local v0, "firstVisibleItemHasSufficientlyScrolledAway":Z
    :cond_2
    if-eqz v0, :cond_0

    iget-object v4, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->results:Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;

    invoke-virtual {v4}, Lcom/amazon/retailsearch/android/ui/results/layout/ResultsController;->size()I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    if-ge v1, v4, :cond_0

    .line 190
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method protected getProgressBar()Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 303
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    :goto_0
    return-object v0

    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    goto :goto_0
.end method

.method protected getStackView()Lcom/amazon/retailsearch/android/ui/results/layout/StackView;
    .locals 2

    .prologue
    .line 115
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getOrientation()I

    move-result v0

    const/4 v1, 0x2

    if-ne v0, v1, :cond_2

    .line 116
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    if-nez v0, :cond_0

    .line 117
    invoke-direct {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->createVerticalStackView()Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    .line 118
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalDivider:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 119
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->dividerWidth:I

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;->setDividerHeight(I)V

    .line 121
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/VerticalStackView;

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->setStackView(Lcom/amazon/retailsearch/android/ui/results/layout/StackView;)V

    .line 130
    :cond_1
    :goto_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->stackView:Lcom/amazon/retailsearch/android/ui/results/layout/StackView;

    return-object v0

    .line 122
    :cond_2
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->getOrientation()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 123
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    if-nez v0, :cond_3

    .line 124
    invoke-virtual {p0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->createHorizontalStackView()Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    .line 125
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    iget-object v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalDivider:Landroid/graphics/drawable/Drawable;

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->setDivider(Landroid/graphics/drawable/Drawable;)V

    .line 126
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    iget v1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->dividerWidth:I

    invoke-virtual {v0, v1}, Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;->setDividerWidth(I)V

    .line 128
    :cond_3
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalStackView:Lcom/amazon/retailsearch/android/ui/results/layout/HorizontalStackView;

    invoke-virtual {p0, v0}, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->setStackView(Lcom/amazon/retailsearch/android/ui/results/layout/StackView;)V

    goto :goto_0
.end method

.method protected hideProgressBar()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 275
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->isProgressBarVisible:Z

    .line 276
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 278
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 280
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    .line 282
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 284
    :cond_1
    return-void
.end method

.method public setEntryGroupIndex(I)V
    .locals 0
    .param p1, "index"    # I

    .prologue
    .line 236
    iput p1, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->asinEntryGroupIndex:I

    .line 237
    return-void
.end method

.method protected showProgressBar()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 289
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->isProgressBarVisible:Z

    .line 290
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 292
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->verticalProgressBar:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 294
    :cond_0
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    .line 296
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/results/layout/SplitLayout;->horizontalProgressBar:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 298
    :cond_1
    return-void
.end method
