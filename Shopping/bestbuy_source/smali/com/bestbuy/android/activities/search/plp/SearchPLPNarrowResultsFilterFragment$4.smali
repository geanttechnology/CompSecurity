.class Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b(Ljava/lang/String;Ljava/lang/String;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Ljava/lang/String;

.field final synthetic c:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 341
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->b:Ljava/lang/String;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 346
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->b:Ljava/lang/String;

    invoke-static {v0, v1, v2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V

    .line 347
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 348
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 349
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;->c:Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ldj;

    move-result-object v0

    invoke-virtual {v0}, Ldj;->notifyDataSetChanged()V

    .line 357
    return-void
.end method
