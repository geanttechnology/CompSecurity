.class Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;
.super Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;
.source "PlayNowBrowseProgramsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getBreadcrumbAdapter()Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter",
        "<",
        "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    .prologue
    .line 246
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/android/util/view/widget/BreadcrumbAdapter;-><init>()V

    return-void
.end method


# virtual methods
.method protected addItemsForFilterMap(Landroid/view/LayoutInflater;Landroid/widget/LinearLayout;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V
    .locals 9
    .param p1, "layoutInflater"    # Landroid/view/LayoutInflater;
    .param p2, "scrollView"    # Landroid/widget/LinearLayout;
    .param p3, "filterValue"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;
    .param p5, "searchCategory"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/view/LayoutInflater;",
            "Landroid/widget/LinearLayout;",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;",
            ")V"
        }
    .end annotation

    .prologue
    .line 312
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;"
    .local p4, "filterMap":Ljava/util/Map;, "Ljava/util/Map<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-interface {p4}, Ljava/util/Map;->entrySet()Ljava/util/Set;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 314
    .local v0, "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->getItemLayoutId()I

    move-result v3

    const/4 v5, 0x0

    invoke-virtual {p1, v3, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 315
    .local v2, "view":Landroid/view/View;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->getItemLabelViewId()I

    move-result v3

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    .line 316
    .local v1, "label":Landroid/widget/TextView;
    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/CharSequence;

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 317
    invoke-virtual {p2}, Landroid/widget/LinearLayout;->getContext()Landroid/content/Context;

    move-result-object v3

    sget v5, Lcom/xfinity/playerlib/R$string;->content_description_button_state_selected:I

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {v1}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v8

    invoke-interface {v8}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v3, v5, v6}, Landroid/content/Context;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 319
    new-instance v3, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;

    invoke-direct {v3, p0, p3, v0, p5}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$3;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map$Entry;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 324
    invoke-virtual {p2, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto :goto_0

    .line 327
    .end local v0    # "entry":Ljava/util/Map$Entry;, "Ljava/util/Map$Entry<Ljava/lang/String;Ljava/lang/String;>;"
    .end local v1    # "label":Landroid/widget/TextView;
    .end local v2    # "view":Landroid/view/View;
    :cond_0
    return-void
.end method

.method public addViews(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V
    .locals 11
    .param p1, "layoutInflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "filterValue"    # Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    .prologue
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;"
    const/4 v5, 0x0

    const/4 v10, 0x1

    const/4 v9, 0x0

    .line 250
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->empty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 309
    :goto_0
    return-void

    .line 254
    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$layout;->breadcrumb_scroll:I

    invoke-virtual {p1, v0, p2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v6

    .line 255
    .local v6, "itemScrollerView":Landroid/view/View;
    sget v0, Lcom/xfinity/playerlib/R$id;->breadcrumb_scroller:I

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    .line 257
    .local v2, "scrollView":Landroid/widget/LinearLayout;
    invoke-virtual {p0, p1, v2}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addLeadIfApplicable(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;)V

    .line 260
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isHideLockOn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 261
    sget v0, Lcom/xfinity/playerlib/R$layout;->breadcrumb_item:I

    invoke-virtual {p1, v0, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v8

    .line 263
    .local v8, "view":Landroid/view/View;
    sget v0, Lcom/xfinity/playerlib/R$id;->label:I

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 264
    .local v7, "label":Landroid/widget/TextView;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->filter_hide_locked:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 265
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_button_state_selected:I

    new-array v3, v10, [Ljava/lang/Object;

    invoke-virtual {v7}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v9

    invoke-virtual {v0, v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 267
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;

    invoke-direct {v0, p0, p3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    invoke-virtual {v8, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 273
    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 276
    .end local v7    # "label":Landroid/widget/TextView;
    .end local v8    # "view":Landroid/view/View;
    :cond_1
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->isDownloadableOn()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 277
    sget v0, Lcom/xfinity/playerlib/R$layout;->breadcrumb_item:I

    invoke-virtual {p1, v0, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v8

    .line 279
    .restart local v8    # "view":Landroid/view/View;
    sget v0, Lcom/xfinity/playerlib/R$id;->label:I

    invoke-virtual {v8, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/widget/TextView;

    .line 280
    .restart local v7    # "label":Landroid/widget/TextView;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->filter_downloadable:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getText(I)Ljava/lang/CharSequence;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 281
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_button_state_selected:I

    new-array v3, v10, [Ljava/lang/Object;

    invoke-virtual {v7}, Landroid/widget/TextView;->getText()Ljava/lang/CharSequence;

    move-result-object v4

    invoke-interface {v4}, Ljava/lang/CharSequence;->toString()Ljava/lang/String;

    move-result-object v4

    aput-object v4, v3, v9

    invoke-virtual {v0, v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v7, v0}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 283
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$2;

    invoke-direct {v0, p0, p3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    invoke-virtual {v8, v0}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 289
    invoke-virtual {v2, v8}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 293
    .end local v7    # "label":Landroid/widget/TextView;
    .end local v8    # "view":Landroid/view/View;
    :cond_2
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentGenreFilters()Ljava/util/HashMap;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->GENRE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addItemsForFilterMap(Landroid/view/LayoutInflater;Landroid/widget/LinearLayout;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 296
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentNetworkFilters()Ljava/util/HashMap;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->NETWORK:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addItemsForFilterMap(Landroid/view/LayoutInflater;Landroid/widget/LinearLayout;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 299
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentAlphaFilters()Ljava/util/HashMap;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->ALPHA:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addItemsForFilterMap(Landroid/view/LayoutInflater;Landroid/widget/LinearLayout;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 302
    invoke-virtual {p3}, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;->getCurrentProgramTypeFilters()Ljava/util/HashMap;

    move-result-object v4

    sget-object v5, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;->PROGRAM_TYPE:Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;

    move-object v0, p0

    move-object v1, p1

    move-object v3, p3

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addItemsForFilterMap(Landroid/view/LayoutInflater;Landroid/widget/LinearLayout;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;Ljava/util/Map;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter$FilterCategory;)V

    .line 304
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addCommasAndSpacing(Landroid/widget/LinearLayout;)V

    .line 306
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->this$0:Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_filter_breadcrumb_container:I

    new-array v3, v10, [Ljava/lang/Object;

    .line 307
    invoke-virtual {v2}, Landroid/widget/LinearLayout;->getChildCount()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    aput-object v4, v3, v9

    .line 306
    invoke-virtual {v0, v1, v3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setContentDescription(Ljava/lang/CharSequence;)V

    goto/16 :goto_0
.end method

.method public bridge synthetic addViews(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 246
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;"
    check-cast p3, Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;

    invoke-virtual {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;->addViews(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Lcom/xfinity/playerlib/view/browseprograms/DibicProgramFilter;)V

    return-void
.end method

.method protected getItemLabelViewId()I
    .locals 1

    .prologue
    .line 331
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;"
    sget v0, Lcom/xfinity/playerlib/R$id;->label:I

    return v0
.end method

.method protected getItemLayoutId()I
    .locals 1

    .prologue
    .line 336
    .local p0, "this":Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;, "Lcom/xfinity/playerlib/view/browseprograms/PlayNowBrowseProgramsFragment$2;"
    sget v0, Lcom/xfinity/playerlib/R$layout;->breadcrumb_item:I

    return v0
.end method
