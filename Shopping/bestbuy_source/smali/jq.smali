.class public Ljq;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

.field private j:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 21
    const/4 v0, 0x0

    sput v0, Ljq;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    iput-object p4, p0, Ljq;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    .line 26
    iput-object p3, p0, Ljq;->g:Landroid/view/View;

    .line 27
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 17
    sput p0, Ljq;->k:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 38
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Ljq;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;->getListType()Ljava/lang/String;

    move-result-object v1

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Ljq;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-static {v0, v1, v2, v3}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)Z

    move-result v0

    iput-boolean v0, p0, Ljq;->j:Z

    .line 39
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 43
    const/4 v0, 0x0

    sput v0, Ljq;->k:I

    .line 44
    iget-object v0, p0, Ljq;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Ljq;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 46
    :cond_0
    iget-boolean v0, p0, Ljq;->j:Z

    if-eqz v0, :cond_1

    .line 47
    iget-object v0, p0, Ljq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Ljq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    iget-object v1, p0, Ljq;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->a(Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    .line 51
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 61
    iget-object v0, p0, Ljq;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Ljq;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 63
    :cond_0
    iget-object v0, p0, Ljq;->f:Landroid/app/Activity;

    new-instance v1, Ljq$1;

    invoke-direct {v1, p0}, Ljq$1;-><init>(Ljq;)V

    new-instance v2, Ljq$2;

    invoke-direct {v2, p0}, Ljq$2;-><init>(Ljq;)V

    iget-boolean v3, p0, Ljq;->e:Z

    sget v4, Ljq;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 74
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 55
    sget v0, Ljq;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljq;->k:I

    .line 56
    new-instance v0, Ljq;

    iget-object v1, p0, Ljq;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljq;->g:Landroid/view/View;

    iget-object v4, p0, Ljq;->a:Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;

    invoke-direct {v0, v1, v2, v3, v4}, Ljq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Lcom/bestbuy/android/api/lib/models/registry/WeddingRegistryData;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 57
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 30
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 31
    iget-object v0, p0, Ljq;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Ljq;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 34
    :cond_0
    return-void
.end method
