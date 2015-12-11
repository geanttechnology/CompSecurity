.class public Lip;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Landroid/location/Address;

.field private j:Ljava/lang/String;

.field private l:Landroid/widget/LinearLayout;

.field private m:D

.field private n:D


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput v0, Lip;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DD)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 34
    iput-object p3, p0, Lip;->g:Landroid/view/View;

    .line 35
    iput-wide p4, p0, Lip;->m:D

    .line 36
    iput-wide p6, p0, Lip;->n:D

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 28
    iput-object p3, p0, Lip;->g:Landroid/view/View;

    .line 29
    iput-object p4, p0, Lip;->j:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Landroid/widget/LinearLayout;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 41
    iput-object p3, p0, Lip;->g:Landroid/view/View;

    .line 42
    iput-object p4, p0, Lip;->j:Ljava/lang/String;

    .line 43
    iput-object p5, p0, Lip;->l:Landroid/widget/LinearLayout;

    .line 44
    return-void
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    const-wide/16 v2, 0x0

    .line 55
    iget-wide v0, p0, Lip;->m:D

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lip;->n:D

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Lip;->f:Landroid/app/Activity;

    iget-wide v2, p0, Lip;->m:D

    iget-wide v4, p0, Lip;->n:D

    invoke-static {v0, v2, v3, v4, v5}, Lfs;->a(Landroid/content/Context;DD)Landroid/location/Address;

    move-result-object v0

    iput-object v0, p0, Lip;->a:Landroid/location/Address;

    .line 59
    :goto_0
    return-void

    .line 58
    :cond_0
    iget-object v0, p0, Lip;->f:Landroid/app/Activity;

    iget-object v1, p0, Lip;->j:Ljava/lang/String;

    invoke-static {v0, v1}, Lfs;->b(Landroid/content/Context;Ljava/lang/String;)Landroid/location/Address;

    move-result-object v0

    iput-object v0, p0, Lip;->a:Landroid/location/Address;

    goto :goto_0
.end method

.method public b()V
    .locals 4

    .prologue
    .line 88
    iget-object v0, p0, Lip;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lip;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 91
    :cond_0
    iget-object v0, p0, Lip;->a:Landroid/location/Address;

    if-nez v0, :cond_2

    .line 92
    invoke-virtual {p0}, Lip;->c()V

    .line 105
    :cond_1
    :goto_0
    return-void

    .line 94
    :cond_2
    const/4 v0, 0x0

    sput v0, Lip;->k:I

    .line 95
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    if-eqz v0, :cond_3

    .line 96
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;

    iget-object v1, p0, Lip;->j:Ljava/lang/String;

    iget-object v2, p0, Lip;->a:Landroid/location/Address;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/dnm/DNMSearchFragment;->a(Ljava/lang/String;Landroid/location/Address;)V

    goto :goto_0

    .line 97
    :cond_3
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    if-eqz v0, :cond_4

    .line 98
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    iget-object v1, p0, Lip;->j:Ljava/lang/String;

    iget-object v2, p0, Lip;->a:Landroid/location/Address;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Ljava/lang/String;Landroid/location/Address;)V

    goto :goto_0

    .line 99
    :cond_4
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_5

    .line 100
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Lip;->a:Landroid/location/Address;

    invoke-virtual {v1}, Landroid/location/Address;->getLatitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v1

    iget-object v2, p0, Lip;->a:Landroid/location/Address;

    invoke-virtual {v2}, Landroid/location/Address;->getLongitude()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Ljava/lang/Double;Ljava/lang/Double;)V

    goto :goto_0

    .line 101
    :cond_5
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    if-eqz v0, :cond_1

    .line 102
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    iget-object v1, p0, Lip;->a:Landroid/location/Address;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;->a(Landroid/location/Address;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 74
    iget-object v0, p0, Lip;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lip;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 77
    :cond_0
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_2

    .line 78
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Lip;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->b(Ljava/lang/String;)V

    .line 84
    :cond_1
    :goto_0
    return-void

    .line 79
    :cond_2
    iget-object v0, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WeddingAddressFragment;

    if-nez v0, :cond_1

    .line 81
    iget-object v0, p0, Lip;->l:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 82
    iget-object v0, p0, Lip;->l:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    goto :goto_0
.end method

.method public d()V
    .locals 9

    .prologue
    const-wide/16 v2, 0x0

    const/4 v8, 0x0

    .line 63
    sget v0, Lip;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lip;->k:I

    .line 64
    iget-wide v0, p0, Lip;->m:D

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    iget-wide v0, p0, Lip;->n:D

    cmpl-double v0, v0, v2

    if-eqz v0, :cond_0

    .line 65
    new-instance v0, Lip;

    iget-object v1, p0, Lip;->f:Landroid/app/Activity;

    iget-object v2, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lip;->g:Landroid/view/View;

    iget-wide v4, p0, Lip;->m:D

    iget-wide v6, p0, Lip;->n:D

    invoke-direct/range {v0 .. v7}, Lip;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DD)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lip;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 70
    :goto_0
    return-void

    .line 66
    :cond_0
    iget-object v0, p0, Lip;->l:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    .line 67
    new-instance v0, Lip;

    iget-object v1, p0, Lip;->f:Landroid/app/Activity;

    iget-object v2, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lip;->g:Landroid/view/View;

    iget-object v4, p0, Lip;->j:Ljava/lang/String;

    iget-object v5, p0, Lip;->l:Landroid/widget/LinearLayout;

    invoke-direct/range {v0 .. v5}, Lip;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Landroid/widget/LinearLayout;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lip;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 69
    :cond_1
    new-instance v0, Lip;

    iget-object v1, p0, Lip;->f:Landroid/app/Activity;

    iget-object v2, p0, Lip;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lip;->g:Landroid/view/View;

    iget-object v4, p0, Lip;->j:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lip;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lip;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public e()V
    .locals 2

    .prologue
    .line 48
    iget-object v0, p0, Lip;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 49
    iget-object v0, p0, Lip;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 51
    :cond_0
    return-void
.end method
