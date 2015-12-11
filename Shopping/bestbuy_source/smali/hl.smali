.class public Lhl;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field a:Z

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput v0, Lhl;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 18
    const/4 v0, 0x0

    iput-boolean v0, p0, Lhl;->a:Z

    .line 23
    iput-object p3, p0, Lhl;->g:Landroid/view/View;

    .line 24
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 37
    iget-object v0, p0, Lhl;->f:Landroid/app/Activity;

    invoke-static {v0}, Lfs;->a(Landroid/content/Context;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhl;->j:Ljava/util/ArrayList;

    .line 38
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 59
    const/4 v0, 0x0

    sput v0, Lhl;->k:I

    .line 60
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_1

    .line 61
    iget-object v0, p0, Lhl;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhl;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lhl;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 62
    :cond_0
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 63
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b()V

    .line 76
    :cond_1
    :goto_0
    return-void

    .line 64
    :cond_2
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 65
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b()V

    goto :goto_0

    .line 69
    :cond_3
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 70
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v1, p0, Lhl;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 71
    :cond_4
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 72
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    iget-object v1, p0, Lhl;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isDetached()Z

    move-result v0

    if-nez v0, :cond_0

    .line 49
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 50
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b()V

    .line 55
    :cond_0
    :goto_0
    return-void

    .line 51
    :cond_1
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/RecentlyViewedListCard;->b()V

    goto :goto_0
.end method

.method public d()V
    .locals 4

    .prologue
    .line 42
    sget v0, Lhl;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhl;->k:I

    .line 43
    new-instance v0, Lhl;

    iget-object v1, p0, Lhl;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhl;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhl;->g:Landroid/view/View;

    invoke-direct {v0, v1, v2, v3}, Lhl;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhl;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 44
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 28
    iget-object v0, p0, Lhl;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 29
    iget-object v0, p0, Lhl;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 31
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhl;->j:Ljava/util/ArrayList;

    .line 32
    return-void
.end method
