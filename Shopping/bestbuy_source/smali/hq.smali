.class public Lhq;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


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

.field private k:Landroid/view/View;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    sput v0, Lhq;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Landroid/support/v4/app/Fragment;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 27
    check-cast p2, Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 22
    const/4 v0, 0x0

    iput-boolean v0, p0, Lhq;->a:Z

    .line 28
    iput-object p3, p0, Lhq;->k:Landroid/view/View;

    .line 29
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 40
    invoke-static {}, Lfs;->a()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhq;->j:Ljava/util/List;

    .line 41
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v2, 0x0

    .line 59
    iget-object v0, p0, Lhq;->j:Ljava/util/List;

    if-eqz v0, :cond_1

    move v1, v2

    .line 60
    :goto_0
    iget-object v0, p0, Lhq;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 61
    iget-object v0, p0, Lhq;->j:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/offers/Offer;

    .line 62
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getRzLevels()Ljava/util/ArrayList;

    move-result-object v3

    if-eqz v3, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/offers/Offer;->getRzLevels()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 64
    iget-boolean v0, p0, Lhq;->a:Z

    if-nez v0, :cond_0

    .line 65
    iget-object v0, p0, Lhq;->j:Ljava/util/List;

    invoke-interface {v0, v1}, Ljava/util/List;->remove(I)Ljava/lang/Object;

    .line 60
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 71
    :cond_1
    iget-object v0, p0, Lhq;->j:Ljava/util/List;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lhq;->j:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_4

    .line 72
    sput v2, Lhq;->l:I

    .line 73
    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_2

    .line 74
    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    iget-object v1, p0, Lhq;->j:Ljava/util/List;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->a(Ljava/util/List;)V

    .line 79
    :cond_2
    :goto_1
    iget-object v0, p0, Lhq;->k:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 80
    iget-object v0, p0, Lhq;->k:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 82
    :cond_3
    return-void

    .line 76
    :cond_4
    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_2

    .line 77
    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->b()V

    goto :goto_1
.end method

.method public c()V
    .locals 2

    .prologue
    .line 51
    iget-object v0, p0, Lhq;->k:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lhq;->k:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 53
    :cond_0
    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_1

    .line 54
    iget-object v0, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/GHPBannersHomeCard;->b()V

    .line 55
    :cond_1
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 45
    sget v0, Lhq;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhq;->l:I

    .line 46
    new-instance v0, Lhq;

    iget-object v1, p0, Lhq;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhq;->k:Landroid/view/View;

    invoke-direct {v0, v1, v2, v3}, Lhq;-><init>(Landroid/app/Activity;Landroid/support/v4/app/Fragment;Landroid/view/View;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 47
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 33
    iget-object v0, p0, Lhq;->k:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Lhq;->k:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhq;->j:Ljava/util/List;

    .line 36
    return-void
.end method
