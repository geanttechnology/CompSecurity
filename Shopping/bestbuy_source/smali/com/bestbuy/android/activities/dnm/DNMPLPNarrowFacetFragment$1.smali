.class Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/widget/AdapterView$OnItemClickListener;


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
    .line 159
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

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
    .line 162
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getValue()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/lang/String;)Ljava/lang/String;

    .line 163
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-result-object v1

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, p3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 164
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0313

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 165
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/view/View;

    move-result-object v0

    const v1, 0x7f0c0311

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 166
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->d(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const v1, 0x7f020021

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 167
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->f(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lfj;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->e(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lfj;->a(Ljava/lang/String;)V

    .line 168
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;->a:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 171
    return-void
.end method
