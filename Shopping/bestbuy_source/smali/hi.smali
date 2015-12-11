.class public Lhi;
.super Lka;
.source "SourceFile"


# static fields
.field private static j:I


# instance fields
.field private a:Ljava/lang/String;

.field private k:I

.field private l:I

.field private m:Ljava/lang/String;

.field private n:Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const/4 v0, 0x0

    sput v0, Lhi;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;IILjava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 23
    iput-object p3, p0, Lhi;->g:Landroid/view/View;

    .line 24
    iput-object p4, p0, Lhi;->a:Ljava/lang/String;

    .line 25
    iput p5, p0, Lhi;->k:I

    .line 26
    iput p6, p0, Lhi;->l:I

    .line 27
    iput-object p7, p0, Lhi;->m:Ljava/lang/String;

    .line 28
    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 40
    iget-object v0, p0, Lhi;->a:Ljava/lang/String;

    iget v1, p0, Lhi;->l:I

    iget v2, p0, Lhi;->k:I

    iget-object v3, p0, Lhi;->m:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Ljava/lang/String;IILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    move-result-object v0

    iput-object v0, p0, Lhi;->n:Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    .line 41
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 58
    iget-object v0, p0, Lhi;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lhi;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 61
    :cond_0
    iget-object v0, p0, Lhi;->n:Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhi;->n:Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Lhi;->n:Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 62
    :cond_1
    invoke-virtual {p0}, Lhi;->c()V

    .line 68
    :cond_2
    :goto_0
    return-void

    .line 64
    :cond_3
    const/4 v0, 0x0

    sput v0, Lhi;->j:I

    .line 65
    iget-object v0, p0, Lhi;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhi;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 66
    iget-object v0, p0, Lhi;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v1, p0, Lhi;->n:Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 51
    iget-object v0, p0, Lhi;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lhi;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 54
    :cond_0
    return-void
.end method

.method public d()V
    .locals 8

    .prologue
    .line 45
    sget v0, Lhi;->j:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhi;->j:I

    .line 46
    new-instance v0, Lhi;

    iget-object v1, p0, Lhi;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhi;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhi;->g:Landroid/view/View;

    iget-object v4, p0, Lhi;->a:Ljava/lang/String;

    iget v5, p0, Lhi;->k:I

    iget v6, p0, Lhi;->l:I

    iget-object v7, p0, Lhi;->m:Ljava/lang/String;

    invoke-direct/range {v0 .. v7}, Lhi;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;IILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhi;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 47
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lhi;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lhi;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    return-void
.end method
