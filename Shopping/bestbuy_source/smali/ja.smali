.class public Lja;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    sput v0, Lja;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 28
    iput-object p4, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 29
    iput-object p3, p0, Lja;->g:Landroid/view/View;

    .line 31
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 18
    sput p0, Lja;->k:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 42
    iget-object v0, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setCreatedBy(Ljava/lang/String;)V

    .line 43
    iget-object v0, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {}, Lfr;->c()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setLastModifiedBy(Ljava/lang/String;)V

    .line 44
    iget-object v0, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {}, Lfr;->e()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setFirstName(Ljava/lang/String;)V

    .line 45
    iget-object v0, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {}, Lfr;->f()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->setLastName(Ljava/lang/String;)V

    .line 46
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getListType()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    iput-object v0, p0, Lja;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 47
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 51
    iget-object v0, p0, Lja;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 52
    iget-object v0, p0, Lja;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 54
    :cond_0
    const/4 v0, 0x0

    sput v0, Lja;->k:I

    .line 55
    iget-object v0, p0, Lja;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lja;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lja;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Lja;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;

    iget-object v1, p0, Lja;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishlistAdditionalOptions;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 58
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 68
    iget-object v0, p0, Lja;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Lja;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 71
    :cond_0
    iget-object v0, p0, Lja;->f:Landroid/app/Activity;

    new-instance v1, Lja$1;

    invoke-direct {v1, p0}, Lja$1;-><init>(Lja;)V

    new-instance v2, Lja$2;

    invoke-direct {v2, p0}, Lja$2;-><init>(Lja;)V

    iget-boolean v3, p0, Lja;->e:Z

    sget v4, Lja;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 82
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 62
    sget v0, Lja;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lja;->k:I

    .line 63
    new-instance v0, Lja;

    iget-object v1, p0, Lja;->f:Landroid/app/Activity;

    iget-object v2, p0, Lja;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lja;->g:Landroid/view/View;

    iget-object v4, p0, Lja;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0, v1, v2, v3, v4}, Lja;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lja;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 64
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 34
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 35
    iget-object v0, p0, Lja;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lja;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 38
    :cond_0
    return-void
.end method
