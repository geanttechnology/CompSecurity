.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;
.super Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersBaseAdapter;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "SearchResultsAdapter"
.end annotation


# instance fields
.field private final fullResultsHeader:Ljava/lang/String;

.field private inflater:Landroid/view/LayoutInflater;

.field private final newResultsHeader:Ljava/lang/String;

.field private searchResults:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>(Landroid/content/Context;)V
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 652
    invoke-direct {p0, p1}, Lcom/emilsjolander/components/StickyListHeaders/StickyListHeadersBaseAdapter;-><init>(Landroid/content/Context;)V

    .line 644
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->searchResults:Ljava/util/List;

    .line 653
    invoke-static {p1}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 654
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->search_new_results_header:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->newResultsHeader:Ljava/lang/String;

    .line 655
    invoke-virtual {p1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->search_full_results_header:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->fullResultsHeader:Ljava/lang/String;

    .line 656
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 707
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->searchResults:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getHeaderId(I)J
    .locals 4
    .param p1, "position"    # I

    .prologue
    .line 680
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v1

    invoke-static {v1}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 681
    .local v0, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v1, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    sget-object v2, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->NEW:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    const-wide/16 v2, 0x1

    :goto_0
    return-wide v2

    :cond_0
    const-wide/16 v2, 0x2

    goto :goto_0
.end method

.method public getHeaderView(ILandroid/view/View;)Landroid/view/View;
    .locals 5
    .param p1, "position"    # I
    .param p2, "convertView"    # Landroid/view/View;

    .prologue
    const/4 v4, 0x0

    .line 662
    if-nez p2, :cond_0

    .line 663
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;

    invoke-direct {v0, v4}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V

    .line 664
    .local v0, "holder":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v3, Lcom/xfinity/playerlib/R$layout;->search_results_header:I

    invoke-virtual {v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 665
    sget v2, Lcom/xfinity/playerlib/R$id;->search_header:I

    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;->text:Landroid/widget/TextView;
    invoke-static {v0, v2}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;->access$2202(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;Landroid/widget/TextView;)Landroid/widget/TextView;

    .line 666
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 671
    :goto_0
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v2

    invoke-static {v2}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 672
    .local v1, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;->text:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;->access$2200(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;)Landroid/widget/TextView;

    move-result-object v3

    iget-object v2, v1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    sget-object v4, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->NEW:Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->newResultsHeader:Ljava/lang/String;

    :goto_1
    invoke-virtual {v3, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 674
    return-object p2

    .line 668
    .end local v0    # "holder":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;
    .end local v1    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;

    .restart local v0    # "holder":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$HeaderViewHolder;
    goto :goto_0

    .line 672
    .restart local v1    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->fullResultsHeader:Ljava/lang/String;

    goto :goto_1
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 712
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->searchResults:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 717
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method protected getView(ILandroid/view/View;)Landroid/view/View;
    .locals 7
    .param p1, "i"    # I
    .param p2, "view"    # Landroid/view/View;

    .prologue
    const/4 v6, 0x0

    .line 687
    if-nez p2, :cond_0

    .line 688
    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v5, Lcom/xfinity/playerlib/R$layout;->search_results_item:I

    invoke-virtual {v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 689
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;

    invoke-direct {v0, v6}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V

    .line 690
    .local v0, "holder":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;
    sget v4, Lcom/xfinity/playerlib/R$id;->program_title:I

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;
    invoke-static {v0, v4}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->access$2402(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;Landroid/widget/TextView;)Landroid/widget/TextView;

    .line 691
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 696
    :goto_0
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 697
    .local v2, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v3, v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v3, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 698
    .local v3, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->access$2400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 699
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v4

    if-eqz v4, :cond_1

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_search_movies:I

    .line 700
    .local v1, "iconId":I
    :goto_1
    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->access$2400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->getContext()Landroid/content/Context;

    move-result-object v5

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5, v6, v6, v6}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 702
    return-object p2

    .line 693
    .end local v0    # "holder":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;
    .end local v1    # "iconId":I
    .end local v2    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .end local v3    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_0
    invoke-virtual {p2}, Landroid/view/View;->getTag()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;

    .restart local v0    # "holder":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;
    goto :goto_0

    .line 699
    .restart local v2    # "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    .restart local v3    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_search_tv_series:I

    goto :goto_1
.end method

.method public setSearchResults(Ljava/util/List;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 721
    .local p1, "searchResults":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAdapter;->searchResults:Ljava/util/List;

    .line 722
    return-void
.end method
