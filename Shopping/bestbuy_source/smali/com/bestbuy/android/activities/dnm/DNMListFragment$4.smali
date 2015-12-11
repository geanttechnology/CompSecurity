.class Lcom/bestbuy/android/activities/dnm/DNMListFragment$4;
.super Ljava/lang/Object;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
.end annotation


# instance fields
.field final synthetic a:Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

.field final synthetic b:Lcom/bestbuy/android/activities/dnm/DNMListFragment;


# direct methods
.method constructor <init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 0

    .prologue
    .line 372
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$4;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$4;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2

    .prologue
    .line 376
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$4;->b:Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$4;->a:Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    invoke-static {v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    .line 377
    return-void
.end method
