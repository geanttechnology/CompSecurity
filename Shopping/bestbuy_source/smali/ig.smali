.class public Lig;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:I

.field private l:Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;

.field private m:Landroid/view/View;

.field private n:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    iput-object p4, p0, Lig;->a:Ljava/lang/String;

    .line 26
    iput-object p5, p0, Lig;->j:Ljava/lang/String;

    .line 27
    iput p6, p0, Lig;->k:I

    .line 28
    iput-object p3, p0, Lig;->m:Landroid/view/View;

    .line 29
    iput-object p7, p0, Lig;->n:Ljava/lang/String;

    .line 30
    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 41
    iget-object v0, p0, Lig;->a:Ljava/lang/String;

    iget-object v1, p0, Lig;->j:Ljava/lang/String;

    iget v2, p0, Lig;->k:I

    iget-object v3, p0, Lig;->n:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;

    move-result-object v0

    iput-object v0, p0, Lig;->l:Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;

    .line 42
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lig;->m:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lig;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 49
    :cond_0
    iget-object v0, p0, Lig;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lig;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    iget-object v0, p0, Lig;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, p0, Lig;->l:Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;)V

    .line 52
    :cond_1
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 56
    iget-object v0, p0, Lig;->m:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lig;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 59
    :cond_0
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 34
    iget-object v0, p0, Lig;->m:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Lig;->m:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 37
    :cond_0
    return-void
.end method
