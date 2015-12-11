.class public Ljs;
.super Lka;
.source "SourceFile"


# static fields
.field private static n:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

.field private k:Z

.field private l:I

.field private m:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    sput v0, Ljs;->n:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;ZLandroid/view/View;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 33
    iput-object p3, p0, Ljs;->a:Ljava/lang/String;

    .line 34
    iput-boolean p4, p0, Ljs;->k:Z

    .line 35
    iput-object p5, p0, Ljs;->g:Landroid/view/View;

    .line 36
    iput p6, p0, Ljs;->l:I

    .line 37
    iput-object p7, p0, Ljs;->m:Ljava/lang/String;

    .line 38
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 20
    sput p0, Ljs;->n:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    .line 49
    const-string v0, "weddingregistrylist"

    .line 50
    iget-boolean v1, p0, Ljs;->k:Z

    if-eqz v1, :cond_0

    .line 51
    const-string v0, "list"

    .line 53
    :cond_0
    iget-object v1, p0, Ljs;->a:Ljava/lang/String;

    iget-boolean v2, p0, Ljs;->k:Z

    iget v3, p0, Ljs;->l:I

    iget-object v4, p0, Ljs;->m:Ljava/lang/String;

    invoke-static {v1, v0, v2, v3, v4}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;ZILjava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    move-result-object v0

    iput-object v0, p0, Ljs;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    .line 54
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 58
    iget-object v0, p0, Ljs;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Ljs;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 61
    :cond_0
    iget-object v0, p0, Ljs;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Ljs;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljs;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 63
    iget-object v0, p0, Ljs;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;

    iget-object v1, p0, Ljs;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistrySearchResults;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;)V

    .line 68
    :cond_1
    :goto_0
    return-void

    .line 64
    :cond_2
    iget-object v0, p0, Ljs;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljs;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 65
    iget-object v0, p0, Ljs;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;

    iget-object v1, p0, Ljs;->j:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ListIdSearchFragment;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishListCompleteData;)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 78
    iget-object v0, p0, Ljs;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Ljs;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 80
    :cond_0
    iget-object v0, p0, Ljs;->f:Landroid/app/Activity;

    new-instance v1, Ljs$1;

    invoke-direct {v1, p0}, Ljs$1;-><init>(Ljs;)V

    new-instance v2, Ljs$2;

    invoke-direct {v2, p0}, Ljs$2;-><init>(Ljs;)V

    iget-boolean v3, p0, Ljs;->e:Z

    sget v4, Ljs;->n:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 91
    return-void
.end method

.method public d()V
    .locals 8

    .prologue
    .line 72
    sget v0, Ljs;->n:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljs;->n:I

    .line 73
    new-instance v0, Ljs;

    iget-object v1, p0, Ljs;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljs;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljs;->a:Ljava/lang/String;

    iget-boolean v4, p0, Ljs;->k:Z

    iget-object v5, p0, Ljs;->g:Landroid/view/View;

    iget v6, p0, Ljs;->l:I

    iget-object v7, p0, Ljs;->m:Ljava/lang/String;

    invoke-direct/range {v0 .. v7}, Ljs;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;ZLandroid/view/View;ILjava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljs;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 74
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 41
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 42
    iget-object v0, p0, Ljs;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 43
    iget-object v0, p0, Ljs;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 45
    :cond_0
    return-void
.end method
