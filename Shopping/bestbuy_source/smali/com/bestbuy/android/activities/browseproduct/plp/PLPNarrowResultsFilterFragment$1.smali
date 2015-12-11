.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


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
    .line 137
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
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
    .line 140
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 141
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 142
    const-string v1, "ProductsFilterSortOrder"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 143
    sget-object v1, Llu;->ac:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 144
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 145
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0313

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 146
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0311

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->e(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const v1, 0x7f020021

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Lex;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->f(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lex;->a(Ljava/lang/String;)V

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 152
    return-void
.end method
