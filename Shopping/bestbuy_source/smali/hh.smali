.class public Lhh;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/home/pageconfiguration/SIOffer;",
            ">;"
        }
    .end annotation
.end field

.field private j:Ljava/lang/String;

.field private k:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 23
    const/4 v0, 0x0

    iput v0, p0, Lhh;->k:I

    .line 28
    iput-object p3, p0, Lhh;->g:Landroid/view/View;

    .line 29
    iput-object p4, p0, Lhh;->j:Ljava/lang/String;

    .line 30
    return-void
.end method

.method static synthetic a(Lhh;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lhh;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Lhh;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lhh;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lhh;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lhh;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic d(Lhh;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 20
    iget-object v0, p0, Lhh;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 34
    iget-object v0, p0, Lhh;->j:Ljava/lang/String;

    invoke-static {v0}, Lgq;->i(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhh;->a:Ljava/util/ArrayList;

    .line 35
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 39
    iget-object v0, p0, Lhh;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 40
    iget-object v0, p0, Lhh;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 42
    :cond_0
    iget-object v0, p0, Lhh;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhh;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 43
    iget-object v0, p0, Lhh;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;

    iget-object v1, p0, Lhh;->a:Ljava/util/ArrayList;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPCustomOffersFragment;->a(Ljava/util/List;Z)V

    .line 45
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 55
    invoke-super {p0}, Lka;->c()V

    .line 56
    iget-object v0, p0, Lhh;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Lhh;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 59
    :cond_0
    iget-object v0, p0, Lhh;->f:Landroid/app/Activity;

    new-instance v1, Lhh$1;

    invoke-direct {v1, p0}, Lhh$1;-><init>(Lhh;)V

    new-instance v2, Lhh$2;

    invoke-direct {v2, p0}, Lhh$2;-><init>(Lhh;)V

    iget-boolean v3, p0, Lhh;->e:Z

    iget v4, p0, Lhh;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 75
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 49
    iget v0, p0, Lhh;->k:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lhh;->k:I

    .line 50
    new-instance v0, Lhh;

    iget-object v1, p0, Lhh;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhh;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhh;->g:Landroid/view/View;

    iget-object v4, p0, Lhh;->j:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Lhh;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhh;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 51
    return-void
.end method
