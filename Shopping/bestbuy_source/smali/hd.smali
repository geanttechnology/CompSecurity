.class public Lhd;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


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


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 19
    const/4 v0, 0x0

    sput v0, Lhd;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 22
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 23
    iput-object p3, p0, Lhd;->g:Landroid/view/View;

    .line 24
    iput-object p4, p0, Lhd;->j:Ljava/lang/String;

    .line 25
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lhd;->j:Ljava/lang/String;

    invoke-static {v0}, Lfs;->f(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhd;->a:Ljava/util/ArrayList;

    .line 39
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 58
    iget-object v0, p0, Lhd;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lhd;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 61
    :cond_0
    iget-object v0, p0, Lhd;->a:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhd;->a:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lhd;->a:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 62
    :cond_1
    invoke-virtual {p0}, Lhd;->c()V

    .line 71
    :cond_2
    :goto_0
    return-void

    .line 64
    :cond_3
    const/4 v0, 0x0

    sput v0, Lhd;->k:I

    .line 65
    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 66
    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;

    iget-object v1, p0, Lhd;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 67
    :cond_4
    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 68
    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;

    iget-object v1, p0, Lhd;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ScannedItemCustomerAlsoViewedFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Lhd;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 50
    iget-object v0, p0, Lhd;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 52
    :cond_0
    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 53
    iget-object v0, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPCustomerAlsoBoughtFragment;->b()V

    .line 54
    :cond_1
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 43
    sget v0, Lhd;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhd;->k:I

    .line 44
    new-instance v0, Lhd;

    iget-object v1, p0, Lhd;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhd;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhd;->g:Landroid/view/View;

    iget-object v4, p0, Lhd;->j:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lhd;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhd;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 45
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 29
    iget-object v0, p0, Lhd;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 30
    iget-object v0, p0, Lhd;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 32
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhd;->a:Ljava/util/ArrayList;

    .line 33
    return-void
.end method
