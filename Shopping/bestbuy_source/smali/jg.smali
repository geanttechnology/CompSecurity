.class public Ljg;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


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

.field private j:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    sput v0, Ljg;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 28
    iput-object p3, p0, Ljg;->g:Landroid/view/View;

    .line 29
    iput-object p4, p0, Ljg;->j:Ljava/lang/String;

    .line 30
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 20
    sput p0, Ljg;->k:I

    return p0
.end method

.method static synthetic a(Ljg;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Ljg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic b(Ljg;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Ljg;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 43
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    .line 44
    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Ljg;->a:Ljava/util/ArrayList;

    .line 45
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 55
    iget-object v0, p0, Ljg;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 56
    iget-object v0, p0, Ljg;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 61
    :cond_0
    iget-object v0, p0, Ljg;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_1

    .line 62
    iget-object v0, p0, Ljg;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Ljg;->a:Ljava/util/ArrayList;

    iget-object v2, p0, Ljg;->j:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->showWishListData(Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 64
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 68
    iget-object v0, p0, Ljg;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 69
    iget-object v0, p0, Ljg;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 70
    :cond_0
    iget-object v0, p0, Ljg;->f:Landroid/app/Activity;

    new-instance v1, Ljg$1;

    invoke-direct {v1, p0}, Ljg$1;-><init>(Ljg;)V

    new-instance v2, Ljg$2;

    invoke-direct {v2, p0}, Ljg$2;-><init>(Ljg;)V

    iget-boolean v3, p0, Ljg;->e:Z

    sget v4, Ljg;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 83
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 49
    sget v0, Ljg;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljg;->k:I

    .line 50
    new-instance v0, Ljg;

    iget-object v1, p0, Ljg;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljg;->g:Landroid/view/View;

    iget-object v4, p0, Ljg;->j:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Ljg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 51
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 33
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 34
    iget-object v0, p0, Ljg;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Ljg;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 36
    iget-object v0, p0, Ljg;->g:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->bringToFront()V

    .line 38
    :cond_0
    return-void
.end method
