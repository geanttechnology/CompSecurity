.class Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
.end annotation


# instance fields
.field final synthetic a:Ljava/lang/String;

.field final synthetic b:Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

.field final synthetic c:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 0

    .prologue
    .line 252
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->c:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->a:Ljava/lang/String;

    iput-object p3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3

    .prologue
    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->c:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->a:Ljava/lang/String;

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->b:Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    invoke-static {v0, v1, v2}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->c:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->c:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->c:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;->c:Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;

    invoke-static {v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lfe;

    move-result-object v0

    invoke-virtual {v0}, Lfe;->notifyDataSetChanged()V

    .line 261
    return-void
.end method
