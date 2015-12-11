.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/ExpandableListView$OnChildClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)V
    .locals 0

    .prologue
    .line 156
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChildClick(Landroid/widget/ExpandableListView;Landroid/view/View;IIJ)Z
    .locals 4

    .prologue
    const/16 v3, 0x8

    const v2, 0x7f0c030b

    .line 162
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->i(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Leu;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Leu;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Value;

    .line 163
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v1

    .line 164
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v3, :cond_1

    .line 165
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v2, 0x0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0, p3, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;ILjava/lang/String;)V

    .line 172
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->k(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)V

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->P()Ljava/util/HashMap;

    move-result-object v0

    .line 175
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 176
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 182
    :cond_0
    const/4 v0, 0x1

    return v0

    .line 168
    :cond_1
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v3}, Landroid/view/View;->setVisibility(I)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

    move-result-object v0

    .line 170
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v2, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method
