.class Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b(Ljava/lang/String;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 305
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->b:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 309
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->b:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 310
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 311
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 312
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->i(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Leu;

    move-result-object v0

    invoke-virtual {v0}, Leu;->notifyDataSetChanged()V

    .line 314
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->P()Ljava/util/HashMap;

    move-result-object v0

    .line 315
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 316
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;

    invoke-static {v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 320
    :cond_0
    return-void
.end method
