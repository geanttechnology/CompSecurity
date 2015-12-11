.class Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;
.super Landroid/widget/BaseAdapter;
.source "SearchResultsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/search/SearchResultsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "SearchResultsAccessibleAdapter"
.end annotation


# instance fields
.field private context:Landroid/content/Context;

.field private inflater:Landroid/view/LayoutInflater;

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

.field final synthetic this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment;Landroid/content/Context;)V
    .locals 1
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 825
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    .line 826
    invoke-direct {p0}, Landroid/widget/BaseAdapter;-><init>()V

    .line 821
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->searchResults:Ljava/util/List;

    .line 827
    iput-object p2, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->context:Landroid/content/Context;

    .line 828
    invoke-static {p2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->inflater:Landroid/view/LayoutInflater;

    .line 829
    return-void
.end method


# virtual methods
.method public getCount()I
    .locals 1

    .prologue
    .line 833
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->searchResults:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    return v0
.end method

.method public getItem(I)Ljava/lang/Object;
    .locals 1
    .param p1, "position"    # I

    .prologue
    .line 838
    iget-object v0, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->searchResults:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    return-object v0
.end method

.method public getItemId(I)J
    .locals 2
    .param p1, "position"    # I

    .prologue
    .line 843
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public getView(ILandroid/view/View;Landroid/view/ViewGroup;)Landroid/view/View;
    .locals 7
    .param p1, "position"    # I
    .param p2, "view"    # Landroid/view/View;
    .param p3, "viewGroup"    # Landroid/view/ViewGroup;

    .prologue
    const/4 v6, 0x0

    .line 853
    if-nez p2, :cond_0

    .line 854
    iget-object v4, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->inflater:Landroid/view/LayoutInflater;

    sget v5, Lcom/xfinity/playerlib/R$layout;->search_results_item:I

    invoke-virtual {v4, v5, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object p2

    .line 855
    new-instance v0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;

    invoke-direct {v0, v6}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;-><init>(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$1;)V

    .line 856
    .local v0, "holder":Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;
    sget v4, Lcom/xfinity/playerlib/R$id;->program_title:I

    invoke-virtual {p2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Landroid/widget/TextView;

    # setter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;
    invoke-static {v0, v4}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->access$2402(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;Landroid/widget/TextView;)Landroid/widget/TextView;

    .line 857
    invoke-virtual {p2, v0}, Landroid/view/View;->setTag(Ljava/lang/Object;)V

    .line 862
    :goto_0
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->getItem(I)Ljava/lang/Object;

    move-result-object v4

    invoke-static {v4}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    .line 863
    .local v2, "item":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v3, v2, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v3, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 864
    .local v3, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->access$2400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getTitle()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 865
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v4

    if-eqz v4, :cond_1

    sget v1, Lcom/xfinity/playerlib/R$drawable;->icn_search_movies:I

    .line 867
    .local v1, "iconId":I
    :goto_1
    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->access$2400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->context:Landroid/content/Context;

    invoke-virtual {v5}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v5

    invoke-virtual {v5, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v5

    invoke-virtual {v4, v5, v6, v6, v6}, Landroid/widget/TextView;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 868
    # getter for: Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->title:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;->access$2400(Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsViewHolder;)Landroid/widget/TextView;

    move-result-object v4

    iget-object v5, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->this$0:Lcom/xfinity/playerlib/view/search/SearchResultsFragment;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->getCount()I

    move-result v6

    invoke-virtual {v5, v2, p1, v6}, Lcom/xfinity/playerlib/view/search/SearchResultsFragment;->getVideoContentDescription(Lcom/comcast/cim/cmasl/utils/container/Tuple;II)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v4, v5}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 870
    return-object p2

    .line 859
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

    .line 865
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
    .line 847
    .local p1, "searchResults":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/view/search/SearchResultsFragment$ListSection;Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/search/SearchResultsFragment$SearchResultsAccessibleAdapter;->searchResults:Ljava/util/List;

    .line 848
    return-void
.end method
