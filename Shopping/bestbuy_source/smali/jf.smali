.class public Ljf;
.super Lka;
.source "SourceFile"


# static fields
.field private static j:I


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    sput v0, Ljf;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 28
    iput-object p3, p0, Ljf;->g:Landroid/view/View;

    .line 29
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 21
    sput p0, Ljf;->j:I

    return p0
.end method

.method static synthetic a(Ljf;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic b(Ljf;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Ljf;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 41
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    .line 42
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lfs;->e(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Ljf;->a:Ljava/util/ArrayList;

    .line 43
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 53
    iget-object v0, p0, Ljf;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Ljf;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 55
    :cond_0
    iget-object v0, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 56
    iget-object v0, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;

    iget-object v1, p0, Ljf;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a(Ljava/util/ArrayList;)V

    .line 58
    :cond_1
    iget-object v0, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 59
    iget-object v0, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    iget-object v1, p0, Ljf;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Ljava/util/ArrayList;)V

    .line 61
    :cond_2
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 65
    iget-object v0, p0, Ljf;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Ljf;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 67
    :cond_0
    iget-object v0, p0, Ljf;->f:Landroid/app/Activity;

    new-instance v1, Ljf$1;

    invoke-direct {v1, p0}, Ljf$1;-><init>(Ljf;)V

    new-instance v2, Ljf$2;

    invoke-direct {v2, p0}, Ljf$2;-><init>(Ljf;)V

    iget-boolean v3, p0, Ljf;->e:Z

    sget v4, Ljf;->j:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 80
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 47
    sget v0, Ljf;->j:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljf;->j:I

    .line 48
    new-instance v0, Ljf;

    iget-object v1, p0, Ljf;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljf;->g:Landroid/view/View;

    invoke-direct {v0, v1, v2, v3}, Ljf;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljf;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 49
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 32
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 33
    iget-object v0, p0, Ljf;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Ljf;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 36
    :cond_0
    return-void
.end method
