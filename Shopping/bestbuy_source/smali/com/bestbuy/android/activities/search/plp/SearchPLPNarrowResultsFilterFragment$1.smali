.class Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


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
    .line 140
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onItemClick(Landroid/widget/AdapterView;Landroid/view/View;IJ)V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

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
    .line 143
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/SortOptions;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SortOptions;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 144
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 145
    const-string v1, "ProductsFilterSortOrder"

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 146
    sget-object v1, Llu;->ac:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 147
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v1

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, p3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/SortOptions;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SortOptions;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 148
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->d(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0313

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->d(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0311

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->e(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const v1, 0x7f020021

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 151
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ldn;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->f(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/api/lib/models/search/Sort;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Sort;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ldn;->a(Ljava/lang/String;)V

    .line 152
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;->a:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 155
    return-void
.end method
