.class public Ljk;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    sput v0, Ljk;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 31
    iput-object p4, p0, Ljk;->a:Ljava/lang/String;

    .line 32
    iput-object p5, p0, Ljk;->j:Ljava/lang/String;

    .line 33
    iput-object p3, p0, Ljk;->g:Landroid/view/View;

    .line 34
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 20
    sput p0, Ljk;->l:I

    return p0
.end method

.method static synthetic a(Ljk;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Ljk;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 44
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ljk;->a:Ljava/lang/String;

    iget-object v2, p0, Ljk;->j:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    iput-object v0, p0, Ljk;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 45
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 49
    iget-object v0, p0, Ljk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 50
    iget-object v0, p0, Ljk;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Ljk;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 53
    :cond_0
    iget-object v0, p0, Ljk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, p0, Ljk;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 57
    :cond_1
    :goto_0
    return-void

    .line 54
    :cond_2
    iget-object v0, p0, Ljk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 55
    iget-object v0, p0, Ljk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v1, p0, Ljk;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 67
    iget-object v0, p0, Ljk;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Ljk;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 69
    :cond_0
    iget-object v0, p0, Ljk;->f:Landroid/app/Activity;

    new-instance v1, Ljk$1;

    invoke-direct {v1, p0}, Ljk$1;-><init>(Ljk;)V

    new-instance v2, Ljk$2;

    invoke-direct {v2, p0}, Ljk$2;-><init>(Ljk;)V

    iget-boolean v3, p0, Ljk;->e:Z

    sget v4, Ljk;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 81
    return-void
.end method

.method public d()V
    .locals 6

    .prologue
    .line 61
    sget v0, Ljk;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljk;->l:I

    .line 62
    new-instance v0, Ljk;

    iget-object v1, p0, Ljk;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljk;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljk;->g:Landroid/view/View;

    iget-object v4, p0, Ljk;->a:Ljava/lang/String;

    iget-object v5, p0, Ljk;->j:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Ljk;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljk;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 63
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 37
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 38
    iget-object v0, p0, Ljk;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 39
    iget-object v0, p0, Ljk;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 40
    :cond_0
    return-void
.end method
