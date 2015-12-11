.class public Ljr;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private j:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    sput v0, Ljr;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 26
    iput-object p4, p0, Ljr;->a:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 27
    iput-object p3, p0, Ljr;->g:Landroid/view/View;

    .line 28
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 18
    sput p0, Ljr;->k:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 39
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ljr;->a:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;->getListType()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ljr;->a:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-static {v0, v1, v2, v3}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Z

    move-result v0

    iput-boolean v0, p0, Ljr;->j:Z

    .line 40
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 44
    iget-object v0, p0, Ljr;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Ljr;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 46
    :cond_0
    iget-boolean v0, p0, Ljr;->j:Z

    if-eqz v0, :cond_1

    .line 47
    iget-object v0, p0, Ljr;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljr;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Ljr;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d()V

    .line 78
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 88
    iget-object v0, p0, Ljr;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Ljr;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 90
    :cond_0
    iget-object v0, p0, Ljr;->f:Landroid/app/Activity;

    new-instance v1, Ljr$1;

    invoke-direct {v1, p0}, Ljr$1;-><init>(Ljr;)V

    new-instance v2, Ljr$2;

    invoke-direct {v2, p0}, Ljr$2;-><init>(Ljr;)V

    iget-boolean v3, p0, Ljr;->e:Z

    sget v4, Ljr;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 101
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 82
    sget v0, Ljr;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljr;->k:I

    .line 83
    new-instance v0, Ljr;

    iget-object v1, p0, Ljr;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljr;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljr;->g:Landroid/view/View;

    iget-object v4, p0, Ljr;->a:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0, v1, v2, v3, v4}, Ljr;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljr;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 84
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 31
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 32
    iget-object v0, p0, Ljr;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Ljr;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    return-void
.end method
