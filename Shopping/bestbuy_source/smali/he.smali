.class public Lhe;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


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

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput v0, Lhe;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2, p3}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 25
    iput-object p4, p0, Lhe;->j:Ljava/lang/String;

    .line 26
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0, p1, p2, p4}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 30
    iput-object p3, p0, Lhe;->k:Ljava/lang/String;

    .line 31
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 44
    iget-object v0, p0, Lhe;->j:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhe;->j:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 45
    iget-object v0, p0, Lhe;->j:Ljava/lang/String;

    invoke-static {v0}, Lfs;->e(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhe;->a:Ljava/util/ArrayList;

    .line 49
    :cond_0
    :goto_0
    return-void

    .line 46
    :cond_1
    iget-object v0, p0, Lhe;->k:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lhe;->k:Ljava/lang/String;

    invoke-static {v0}, Lfs;->g(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhe;->a:Ljava/util/ArrayList;

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 73
    iget-object v0, p0, Lhe;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lhe;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 76
    :cond_0
    iget-object v0, p0, Lhe;->a:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhe;->a:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lhe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 77
    :cond_1
    invoke-virtual {p0}, Lhe;->c()V

    .line 90
    :cond_2
    :goto_0
    return-void

    .line 79
    :cond_3
    const/4 v0, 0x0

    sput v0, Lhe;->l:I

    .line 80
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_4

    .line 81
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v1, p0, Lhe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 83
    :cond_4
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;

    if-eqz v0, :cond_5

    .line 84
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;

    iget-object v1, p0, Lhe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 86
    :cond_5
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 87
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iget-object v1, p0, Lhe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 59
    iget-object v0, p0, Lhe;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lhe;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 62
    :cond_0
    const/4 v0, 0x0

    sput v0, Lhe;->l:I

    .line 63
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 64
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;

    iget-object v1, p0, Lhe;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/recentlyviewed/RecentlyViewedHomeCard;->b(Ljava/util/ArrayList;)V

    .line 69
    :cond_1
    :goto_0
    return-void

    .line 66
    :cond_2
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 67
    iget-object v0, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoViewedFragment;->b()V

    goto :goto_0
.end method

.method public d()V
    .locals 5

    .prologue
    .line 53
    sget v0, Lhe;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhe;->l:I

    .line 54
    new-instance v0, Lhe;

    iget-object v1, p0, Lhe;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhe;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhe;->g:Landroid/view/View;

    iget-object v4, p0, Lhe;->j:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lhe;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhe;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 55
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 35
    iget-object v0, p0, Lhe;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lhe;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 38
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhe;->a:Ljava/util/ArrayList;

    .line 39
    return-void
.end method
