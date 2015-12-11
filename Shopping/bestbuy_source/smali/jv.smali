.class public Ljv;
.super Lka;
.source "SourceFile"


# static fields
.field private static n:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Z

.field private m:Z

.field private o:Landroid/widget/ProgressBar;

.field private p:Lmp;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    sput v0, Ljv;->n:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/ProgressBar;Lmp;)V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 30
    iput-object p3, p0, Ljv;->a:Ljava/lang/String;

    .line 31
    iput-object p4, p0, Ljv;->j:Ljava/lang/String;

    .line 32
    iput-object p5, p0, Ljv;->k:Ljava/lang/String;

    .line 33
    iput-boolean p6, p0, Ljv;->l:Z

    .line 34
    iput-object p7, p0, Ljv;->o:Landroid/widget/ProgressBar;

    .line 35
    iput-object p8, p0, Ljv;->p:Lmp;

    .line 36
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 19
    sput p0, Ljv;->n:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    .line 49
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ljv;->a:Ljava/lang/String;

    iget-object v2, p0, Ljv;->j:Ljava/lang/String;

    iget-object v3, p0, Ljv;->k:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v4

    iget-boolean v5, p0, Ljv;->l:Z

    invoke-static/range {v0 .. v5}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Ljv;->m:Z

    .line 50
    return-void
.end method

.method public b()V
    .locals 6

    .prologue
    .line 54
    const/4 v0, 0x0

    sput v0, Ljv;->n:I

    .line 55
    iget-object v0, p0, Ljv;->o:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Ljv;->o:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 58
    :cond_0
    iget-object v0, p0, Ljv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 59
    iget-object v0, p0, Ljv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-boolean v1, p0, Ljv;->m:Z

    iget-object v2, p0, Ljv;->a:Ljava/lang/String;

    iget-object v3, p0, Ljv;->k:Ljava/lang/String;

    iget-object v4, p0, Ljv;->j:Ljava/lang/String;

    iget-object v5, p0, Ljv;->p:Lmp;

    invoke-virtual/range {v0 .. v5}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Lmp;)V

    .line 63
    :cond_1
    :goto_0
    return-void

    .line 60
    :cond_2
    iget-object v0, p0, Ljv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 61
    iget-object v0, p0, Ljv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    iget-boolean v1, p0, Ljv;->l:Z

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a(Z)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 74
    iget-object v0, p0, Ljv;->o:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Ljv;->o:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 77
    :cond_0
    iget-object v0, p0, Ljv;->f:Landroid/app/Activity;

    new-instance v1, Ljv$1;

    invoke-direct {v1, p0}, Ljv$1;-><init>(Ljv;)V

    new-instance v2, Ljv$2;

    invoke-direct {v2, p0}, Ljv$2;-><init>(Ljv;)V

    iget-boolean v3, p0, Ljv;->e:Z

    sget v4, Ljv;->n:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 88
    return-void
.end method

.method public d()V
    .locals 9

    .prologue
    .line 67
    sget v0, Ljv;->n:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljv;->n:I

    .line 68
    new-instance v0, Ljv;

    iget-object v1, p0, Ljv;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljv;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljv;->a:Ljava/lang/String;

    iget-object v4, p0, Ljv;->j:Ljava/lang/String;

    iget-object v5, p0, Ljv;->k:Ljava/lang/String;

    iget-boolean v6, p0, Ljv;->l:Z

    iget-object v7, p0, Ljv;->o:Landroid/widget/ProgressBar;

    iget-object v8, p0, Ljv;->p:Lmp;

    invoke-direct/range {v0 .. v8}, Ljv;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLandroid/widget/ProgressBar;Lmp;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljv;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 70
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 40
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 41
    iget-object v0, p0, Ljv;->o:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 42
    iget-object v0, p0, Ljv;->o:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 43
    iget-object v0, p0, Ljv;->o:Landroid/widget/ProgressBar;

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->bringToFront()V

    .line 45
    :cond_0
    return-void
.end method
