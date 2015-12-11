.class Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/ExpandableListView$OnChildClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)V
    .locals 0

    .prologue
    .line 163
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChildClick(Landroid/widget/ExpandableListView;Landroid/view/View;IIJ)Z
    .locals 5

    .prologue
    const/16 v4, 0x8

    const v3, 0x7f0c030b

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->i(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v1

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ldj;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Ldj;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    .line 171
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v0

    .line 172
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getVisibility()I

    move-result v2

    if-ne v2, v4, :cond_0

    .line 173
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 174
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v1, p3, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;ILjava/lang/String;)V

    .line 179
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->k(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)V

    .line 189
    const/4 v0, 0x1

    return v0

    .line 176
    :cond_0
    invoke-virtual {p2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v4}, Landroid/view/View;->setVisibility(I)V

    .line 177
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v2, v1, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
