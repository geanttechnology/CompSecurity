.class public Ljj;
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
    .line 29
    const/4 v0, 0x0

    sput v0, Ljj;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 33
    iput-object p4, p0, Ljj;->a:Ljava/lang/String;

    .line 34
    iput-object p3, p0, Ljj;->g:Landroid/view/View;

    .line 35
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 22
    sput p0, Ljj;->l:I

    return p0
.end method

.method static synthetic a(Ljj;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Ljj;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 45
    iget-object v0, p0, Ljj;->a:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lfs;->c(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    iput-object v0, p0, Ljj;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 46
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 50
    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-nez v0, :cond_0

    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-nez v0, :cond_0

    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v0, :cond_2

    .line 51
    :cond_0
    iget-object v0, p0, Ljj;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_6

    .line 52
    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v0, :cond_4

    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 53
    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    iget-object v1, p0, Ljj;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 60
    :cond_1
    :goto_0
    iget-object v0, p0, Ljj;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Ljj;->j:Ljava/lang/String;

    .line 66
    :cond_2
    :goto_1
    iget-object v0, p0, Ljj;->g:Landroid/view/View;

    if-eqz v0, :cond_3

    .line 67
    iget-object v0, p0, Ljj;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    :cond_3
    return-void

    .line 54
    :cond_4
    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    if-eqz v0, :cond_5

    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 55
    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Ljj;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    goto :goto_0

    .line 56
    :cond_5
    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    iget-object v0, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    iget-object v1, p0, Ljj;->k:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    goto :goto_0

    .line 62
    :cond_6
    invoke-virtual {p0}, Ljj;->c()V

    goto :goto_1
.end method

.method public c()V
    .locals 5

    .prologue
    .line 78
    iget-object v0, p0, Ljj;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Ljj;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 80
    :cond_0
    iget-object v0, p0, Ljj;->f:Landroid/app/Activity;

    new-instance v1, Ljj$1;

    invoke-direct {v1, p0}, Ljj$1;-><init>(Ljj;)V

    new-instance v2, Ljj$2;

    invoke-direct {v2, p0}, Ljj$2;-><init>(Ljj;)V

    iget-boolean v3, p0, Ljj;->e:Z

    sget v4, Ljj;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 92
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 72
    sget v0, Ljj;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljj;->l:I

    .line 73
    new-instance v0, Ljj;

    iget-object v1, p0, Ljj;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljj;->g:Landroid/view/View;

    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Ljj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 74
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 38
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 39
    iget-object v0, p0, Ljj;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 40
    iget-object v0, p0, Ljj;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 41
    :cond_0
    return-void
.end method
