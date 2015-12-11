.class public Ljw;
.super Lka;
.source "SourceFile"


# static fields
.field private static m:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:I

.field private n:Z

.field private o:Landroid/widget/ProgressBar;

.field private p:Lmp;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    sput v0, Ljw;->m:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/widget/ProgressBar;Lmp;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 31
    iput-object p3, p0, Ljw;->a:Ljava/lang/String;

    .line 32
    iput-object p4, p0, Ljw;->j:Ljava/lang/String;

    .line 33
    iput-object p5, p0, Ljw;->k:Ljava/lang/String;

    .line 34
    iput p6, p0, Ljw;->l:I

    .line 35
    iput-object p7, p0, Ljw;->o:Landroid/widget/ProgressBar;

    .line 36
    iput-object p8, p0, Ljw;->p:Lmp;

    .line 37
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 18
    sput p0, Ljw;->m:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 6

    .prologue
    .line 50
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ljw;->a:Ljava/lang/String;

    iget-object v2, p0, Ljw;->j:Ljava/lang/String;

    iget-object v3, p0, Ljw;->k:Ljava/lang/String;

    iget v4, p0, Ljw;->l:I

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v5

    invoke-static/range {v0 .. v5}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Ljw;->n:Z

    .line 51
    return-void
.end method

.method public b()V
    .locals 7

    .prologue
    .line 55
    const/4 v0, 0x0

    sput v0, Ljw;->m:I

    .line 56
    iget-object v0, p0, Ljw;->o:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Ljw;->o:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 59
    :cond_0
    iget-object v0, p0, Ljw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 60
    iget-object v0, p0, Ljw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-boolean v1, p0, Ljw;->n:Z

    iget-object v2, p0, Ljw;->a:Ljava/lang/String;

    iget-object v3, p0, Ljw;->k:Ljava/lang/String;

    iget-object v4, p0, Ljw;->j:Ljava/lang/String;

    iget v5, p0, Ljw;->l:I

    iget-object v6, p0, Ljw;->p:Lmp;

    invoke-virtual/range {v0 .. v6}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;ILmp;)V

    .line 61
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 72
    iget-object v0, p0, Ljw;->o:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Ljw;->o:Landroid/widget/ProgressBar;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 75
    :cond_0
    iget-object v0, p0, Ljw;->f:Landroid/app/Activity;

    new-instance v1, Ljw$1;

    invoke-direct {v1, p0}, Ljw$1;-><init>(Ljw;)V

    new-instance v2, Ljw$2;

    invoke-direct {v2, p0}, Ljw$2;-><init>(Ljw;)V

    iget-boolean v3, p0, Ljw;->e:Z

    sget v4, Ljw;->m:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 86
    return-void
.end method

.method public d()V
    .locals 9

    .prologue
    .line 65
    sget v0, Ljw;->m:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljw;->m:I

    .line 66
    new-instance v0, Ljw;

    iget-object v1, p0, Ljw;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljw;->a:Ljava/lang/String;

    iget-object v4, p0, Ljw;->j:Ljava/lang/String;

    iget-object v5, p0, Ljw;->k:Ljava/lang/String;

    iget v6, p0, Ljw;->l:I

    iget-object v7, p0, Ljw;->o:Landroid/widget/ProgressBar;

    iget-object v8, p0, Ljw;->p:Lmp;

    invoke-direct/range {v0 .. v8}, Ljw;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ILandroid/widget/ProgressBar;Lmp;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljw;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 68
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 41
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 42
    iget-object v0, p0, Ljw;->o:Landroid/widget/ProgressBar;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Ljw;->o:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 44
    iget-object v0, p0, Ljw;->o:Landroid/widget/ProgressBar;

    invoke-virtual {v0}, Landroid/widget/ProgressBar;->bringToFront()V

    .line 46
    :cond_0
    return-void
.end method
