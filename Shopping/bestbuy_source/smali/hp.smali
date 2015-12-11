.class public Lhp;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field a:Z

.field private j:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/offers/Offer;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 20
    const/4 v0, 0x0

    sput v0, Lhp;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 19
    const/4 v0, 0x0

    iput-boolean v0, p0, Lhp;->a:Z

    .line 24
    iput-object p3, p0, Lhp;->g:Landroid/view/View;

    .line 25
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 37
    invoke-static {}, Lfs;->b()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhp;->j:Ljava/util/List;

    .line 38
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 57
    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    .line 58
    iget-object v0, p0, Lhp;->j:Ljava/util/List;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhp;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 59
    const/4 v0, 0x0

    sput v0, Lhp;->k:I

    .line 60
    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    .line 61
    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    iget-object v1, p0, Lhp;->j:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->a(Ljava/util/List;)V

    .line 67
    :cond_0
    :goto_0
    iget-object v0, p0, Lhp;->g:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 68
    iget-object v0, p0, Lhp;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 70
    :cond_1
    return-void

    .line 63
    :cond_2
    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    .line 64
    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->b()V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 48
    iget-object v0, p0, Lhp;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lhp;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 51
    :cond_0
    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_1

    .line 52
    iget-object v0, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/LEBannerHomeCard;->b()V

    .line 53
    :cond_1
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 42
    sget v0, Lhp;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhp;->k:I

    .line 43
    new-instance v0, Lhp;

    iget-object v1, p0, Lhp;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhp;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhp;->g:Landroid/view/View;

    invoke-direct {v0, v1, v2, v3}, Lhp;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhp;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 44
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 29
    iget-object v0, p0, Lhp;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 30
    iget-object v0, p0, Lhp;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 32
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhp;->j:Ljava/util/List;

    .line 33
    return-void
.end method
