.class public Liz;
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
    .line 22
    const/4 v0, 0x0

    sput v0, Liz;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 26
    iput-object p4, p0, Liz;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 27
    iput-object p3, p0, Liz;->g:Landroid/view/View;

    .line 28
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 18
    sput p0, Liz;->k:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 39
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    const-string v1, "weddingregistrylists"

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Liz;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    iput-object v0, p0, Liz;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 40
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 44
    iget-object v0, p0, Liz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Liz;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 47
    :cond_0
    iget-object v0, p0, Liz;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Liz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    if-eqz v0, :cond_1

    iget-object v0, p0, Liz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Liz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;

    iget-object v1, p0, Liz;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAdditionalOptions;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 50
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 60
    iget-object v0, p0, Liz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Liz;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 63
    :cond_0
    iget-object v0, p0, Liz;->f:Landroid/app/Activity;

    new-instance v1, Liz$1;

    invoke-direct {v1, p0}, Liz$1;-><init>(Liz;)V

    new-instance v2, Liz$2;

    invoke-direct {v2, p0}, Liz$2;-><init>(Liz;)V

    iget-boolean v3, p0, Liz;->e:Z

    sget v4, Liz;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 74
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 54
    sget v0, Liz;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Liz;->k:I

    .line 55
    new-instance v0, Liz;

    iget-object v1, p0, Liz;->f:Landroid/app/Activity;

    iget-object v2, p0, Liz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Liz;->g:Landroid/view/View;

    iget-object v4, p0, Liz;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0, v1, v2, v3, v4}, Liz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 56
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 31
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 32
    iget-object v0, p0, Liz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Liz;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    return-void
.end method
