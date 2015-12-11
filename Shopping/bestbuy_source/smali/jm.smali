.class public Ljm;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private j:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    sput v0, Ljm;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 26
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 27
    iput-object p4, p0, Ljm;->j:Ljava/lang/String;

    .line 28
    iput-object p3, p0, Ljm;->g:Landroid/view/View;

    .line 29
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 19
    sput p0, Ljm;->k:I

    return p0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 19
    sget v0, Ljm;->k:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Ljm;->k:I

    return v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 40
    const/4 v0, 0x0

    sput v0, Ljm;->k:I

    .line 41
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ljm;->j:Ljava/lang/String;

    const-string v2, "weddingregistrylists"

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    iput-object v0, p0, Ljm;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 42
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 52
    const/4 v0, 0x0

    sput v0, Ljm;->k:I

    .line 53
    iget-object v0, p0, Ljm;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Ljm;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 55
    :cond_0
    iget-object v0, p0, Ljm;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 57
    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    iget-object v1, p0, Ljm;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 65
    :cond_1
    :goto_0
    return-void

    .line 58
    :cond_2
    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    if-eqz v0, :cond_3

    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 59
    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Ljm;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    goto :goto_0

    .line 60
    :cond_3
    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 61
    iget-object v0, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    iget-object v1, p0, Ljm;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->a(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 68
    iget-object v0, p0, Ljm;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Ljm;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 70
    :cond_0
    iget-object v0, p0, Ljm;->f:Landroid/app/Activity;

    new-instance v1, Ljm$1;

    invoke-direct {v1, p0}, Ljm$1;-><init>(Ljm;)V

    new-instance v2, Ljm$2;

    invoke-direct {v2, p0}, Ljm$2;-><init>(Ljm;)V

    iget-boolean v3, p0, Ljm;->e:Z

    sget v4, Ljm;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 83
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 46
    sget v0, Ljm;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljm;->k:I

    .line 47
    new-instance v0, Ljm;

    iget-object v1, p0, Ljm;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljm;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljm;->g:Landroid/view/View;

    iget-object v4, p0, Ljm;->j:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Ljm;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljm;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 48
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 32
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 33
    iget-object v0, p0, Ljm;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Ljm;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 36
    :cond_0
    return-void
.end method
