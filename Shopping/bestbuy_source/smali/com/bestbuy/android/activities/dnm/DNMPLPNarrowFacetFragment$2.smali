.class Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/ExpandableListView$OnChildClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)V
    .locals 0

    .prologue
    .line 175
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onChildClick(Landroid/widget/ExpandableListView;Landroid/view/View;IIJ)Z
    .locals 4

    .prologue
    const/16 v3, 0x8

    const v2, 0x7f0c030b

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lfe;

    move-result-object v0

    invoke-virtual {v0, p3, p4}, Lfe;->getChild(II)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 182
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getVisibility()I

    move-result v1

    if-ne v1, v3, :cond_0

    .line 183
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 184
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v1, p3, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;ILcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    .line 190
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->j(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)V

    .line 192
    const/4 v0, 0x1

    return v0

    .line 186
    :cond_0
    invoke-virtual {p2, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v3}, Landroid/view/View;->setVisibility(I)V

    .line 187
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->i(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v1

    .line 188
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v2, v1, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    goto :goto_0
.end method
