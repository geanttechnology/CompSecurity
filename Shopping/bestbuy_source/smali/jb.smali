.class public Ljb;
.super Lka;
.source "SourceFile"


# static fields
.field private static m:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Z

.field private n:Landroid/widget/ProgressBar;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    sput v0, Ljb;->m:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 27
    iput-object p3, p0, Ljb;->a:Ljava/lang/String;

    .line 28
    iput-object p4, p0, Ljb;->j:Ljava/lang/String;

    .line 29
    iput-object p5, p0, Ljb;->k:Ljava/lang/String;

    .line 30
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Landroid/widget/ProgressBar;)V
    .locals 0

    .prologue
    .line 33
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 34
    iput-object p1, p0, Ljb;->f:Landroid/app/Activity;

    .line 35
    iput-object p2, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 36
    iput-object p3, p0, Ljb;->a:Ljava/lang/String;

    .line 37
    iput-object p4, p0, Ljb;->j:Ljava/lang/String;

    .line 38
    iput-object p5, p0, Ljb;->k:Ljava/lang/String;

    .line 39
    iput-object p6, p0, Ljb;->n:Landroid/widget/ProgressBar;

    .line 40
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 18
    sput p0, Ljb;->m:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    .line 53
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ljb;->a:Ljava/lang/String;

    iget-object v2, p0, Ljb;->j:Ljava/lang/String;

    iget-object v3, p0, Ljb;->k:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v4

    invoke-static {v0, v1, v2, v3, v4}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Ljb;->l:Z

    .line 54
    return-void
.end method

.method public b()V
    .locals 5

    .prologue
    .line 58
    iget-object v0, p0, Ljb;->n:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Ljb;->n:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 61
    :cond_0
    const/4 v0, 0x0

    sput v0, Ljb;->m:I

    .line 62
    iget-object v0, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 63
    iget-object v0, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-boolean v1, p0, Ljb;->l:Z

    iget-object v2, p0, Ljb;->j:Ljava/lang/String;

    iget-object v3, p0, Ljb;->a:Ljava/lang/String;

    iget-object v4, p0, Ljb;->k:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 64
    iget-object v0, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Z)V

    .line 69
    :cond_1
    :goto_0
    return-void

    .line 65
    :cond_2
    iget-object v0, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 66
    iget-object v0, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 79
    iget-object v0, p0, Ljb;->n:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 80
    iget-object v0, p0, Ljb;->n:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 82
    :cond_0
    iget-object v0, p0, Ljb;->f:Landroid/app/Activity;

    new-instance v1, Ljb$1;

    invoke-direct {v1, p0}, Ljb$1;-><init>(Ljb;)V

    new-instance v2, Ljb$2;

    invoke-direct {v2, p0}, Ljb$2;-><init>(Ljb;)V

    iget-boolean v3, p0, Ljb;->e:Z

    sget v4, Ljb;->m:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 93
    return-void
.end method

.method public d()V
    .locals 6

    .prologue
    .line 73
    sget v0, Ljb;->m:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljb;->m:I

    .line 74
    new-instance v0, Ljb;

    iget-object v1, p0, Ljb;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljb;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljb;->a:Ljava/lang/String;

    iget-object v4, p0, Ljb;->j:Ljava/lang/String;

    iget-object v5, p0, Ljb;->k:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Ljb;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljb;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 75
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 44
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 45
    iget-object v0, p0, Ljb;->n:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 46
    iget-object v0, p0, Ljb;->n:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 47
    iget-object v0, p0, Ljb;->n:Landroid/widget/ProgressBar;

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->bringToFront()V

    .line 49
    :cond_0
    return-void
.end method
