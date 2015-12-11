.class public Lhm;
.super Lka;
.source "SourceFile"


# static fields
.field private static j:I


# instance fields
.field private a:Ljava/lang/String;

.field private k:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 15
    const/4 v0, 0x0

    sput v0, Lhm;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 19
    invoke-direct {p0, p1, p2, p3}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 20
    iput-object p4, p0, Lhm;->a:Ljava/lang/String;

    .line 21
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 32
    iget-object v0, p0, Lhm;->a:Ljava/lang/String;

    invoke-static {v0}, Lfs;->d(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    move-result-object v0

    iput-object v0, p0, Lhm;->k:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    .line 33
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 52
    iget-object v0, p0, Lhm;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lhm;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 55
    :cond_0
    iget-object v0, p0, Lhm;->k:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhm;->k:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;->getCategories()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 56
    :cond_1
    invoke-virtual {p0}, Lhm;->c()V

    .line 62
    :cond_2
    :goto_0
    return-void

    .line 58
    :cond_3
    const/4 v0, 0x0

    sput v0, Lhm;->j:I

    .line 59
    iget-object v0, p0, Lhm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 60
    iget-object v0, p0, Lhm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v1, p0, Lhm;->k:Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a(Lcom/bestbuy/android/api/lib/models/deals/StoreDeals;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 43
    iget-object v0, p0, Lhm;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lhm;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 46
    :cond_0
    iget-object v0, p0, Lhm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 47
    iget-object v0, p0, Lhm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b()V

    .line 48
    :cond_1
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 37
    sget v0, Lhm;->j:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhm;->j:I

    .line 38
    new-instance v0, Lhm;

    iget-object v1, p0, Lhm;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhm;->g:Landroid/view/View;

    iget-object v4, p0, Lhm;->a:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lhm;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhm;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 39
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 25
    iget-object v0, p0, Lhm;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 26
    iget-object v0, p0, Lhm;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 28
    :cond_0
    return-void
.end method
