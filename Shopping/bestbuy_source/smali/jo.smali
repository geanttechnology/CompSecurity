.class public Ljo;
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
    .line 21
    const/4 v0, 0x0

    sput v0, Ljo;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 25
    iput-object p3, p0, Ljo;->g:Landroid/view/View;

    .line 26
    iput-object p4, p0, Ljo;->j:Ljava/lang/String;

    .line 27
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 17
    sput p0, Ljo;->k:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 38
    iget-object v0, p0, Ljo;->j:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lfs;->d(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    move-result-object v0

    iput-object v0, p0, Ljo;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 39
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 43
    sput v0, Ljo;->k:I

    .line 44
    iget-object v1, p0, Ljo;->g:Landroid/view/View;

    if-eqz v1, :cond_0

    .line 45
    iget-object v1, p0, Ljo;->g:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 46
    :cond_0
    iget-object v1, p0, Ljo;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v1, v1, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;

    if-eqz v1, :cond_1

    iget-object v1, p0, Ljo;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 48
    iget-object v1, p0, Ljo;->a:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v1, :cond_2

    .line 49
    const/4 v0, 0x1

    move v1, v0

    .line 51
    :goto_0
    iget-object v0, p0, Ljo;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/RegistryAndGiftsFragment;->a(Z)V

    .line 53
    :cond_1
    return-void

    :cond_2
    move v1, v0

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 63
    iget-object v0, p0, Ljo;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Ljo;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 65
    :cond_0
    iget-object v0, p0, Ljo;->f:Landroid/app/Activity;

    new-instance v1, Ljo$1;

    invoke-direct {v1, p0}, Ljo$1;-><init>(Ljo;)V

    new-instance v2, Ljo$2;

    invoke-direct {v2, p0}, Ljo$2;-><init>(Ljo;)V

    iget-boolean v3, p0, Ljo;->e:Z

    sget v4, Ljo;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 76
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 57
    sget v0, Ljo;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljo;->k:I

    .line 58
    new-instance v0, Ljo;

    iget-object v1, p0, Ljo;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljo;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljo;->g:Landroid/view/View;

    iget-object v4, p0, Ljo;->j:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Ljo;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljo;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 59
    return-void
.end method

.method protected onPreExecute()V
    .locals 2

    .prologue
    .line 31
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 32
    iget-object v0, p0, Ljo;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Ljo;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    return-void
.end method
