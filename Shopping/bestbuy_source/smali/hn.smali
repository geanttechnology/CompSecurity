.class public Lhn;
.super Lka;
.source "SourceFile"


# static fields
.field private static j:I


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private k:Lcom/bestbuy/android/api/lib/models/home/Recommendation;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 18
    const/4 v0, 0x0

    sput v0, Lhn;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 23
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/home/Recommendation;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0, p1, p2, p3}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 27
    iput-object p4, p0, Lhn;->k:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    .line 28
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lhn;->k:Lcom/bestbuy/android/api/lib/models/home/Recommendation;

    invoke-static {v0}, Lfs;->a(Lcom/bestbuy/android/api/lib/models/home/Recommendation;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhn;->a:Ljava/util/ArrayList;

    .line 42
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 61
    iget-object v0, p0, Lhn;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lhn;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 64
    :cond_0
    iget-object v0, p0, Lhn;->a:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhn;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 65
    :cond_1
    invoke-virtual {p0}, Lhn;->c()V

    .line 71
    :cond_2
    :goto_0
    return-void

    .line 67
    :cond_3
    const/4 v0, 0x0

    sput v0, Lhn;->j:I

    .line 68
    iget-object v0, p0, Lhn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 69
    iget-object v0, p0, Lhn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    iget-object v1, p0, Lhn;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 52
    iget-object v0, p0, Lhn;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lhn;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 55
    :cond_0
    iget-object v0, p0, Lhn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Lhn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/TrendingHomeCardFragment;->b()V

    .line 57
    :cond_1
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 46
    sget v0, Lhn;->j:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhn;->j:I

    .line 47
    new-instance v0, Lhn;

    iget-object v1, p0, Lhn;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhn;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhn;->g:Landroid/view/View;

    invoke-direct {v0, v1, v2, v3}, Lhn;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhn;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 48
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lhn;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lhn;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhn;->a:Ljava/util/ArrayList;

    .line 36
    return-void
.end method
