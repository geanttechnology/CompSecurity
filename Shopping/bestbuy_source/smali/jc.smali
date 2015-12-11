.class public Ljc;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    sput v0, Ljc;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 26
    iput-object p4, p0, Ljc;->a:Ljava/lang/String;

    .line 27
    iput-object p5, p0, Ljc;->j:Ljava/lang/String;

    .line 28
    iput-object p3, p0, Ljc;->g:Landroid/view/View;

    .line 29
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 17
    sput p0, Ljc;->l:I

    return p0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 39
    invoke-static {}, Lfr;->d()Ljava/lang/String;

    move-result-object v0

    .line 40
    iget-object v1, p0, Ljc;->j:Ljava/lang/String;

    iget-object v2, p0, Ljc;->a:Ljava/lang/String;

    invoke-static {}, Lfr;->b()Ljava/lang/String;

    move-result-object v3

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Ljc;->k:Z

    .line 41
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 45
    const/4 v0, 0x0

    sput v0, Ljc;->l:I

    .line 46
    iget-object v0, p0, Ljc;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Ljc;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 48
    :cond_0
    iget-boolean v0, p0, Ljc;->k:Z

    if-eqz v0, :cond_1

    .line 49
    iget-object v0, p0, Ljc;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljc;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 50
    iget-object v0, p0, Ljc;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->d()V

    .line 55
    :cond_1
    :goto_0
    return-void

    .line 51
    :cond_2
    iget-object v0, p0, Ljc;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljc;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 52
    iget-object v0, p0, Ljc;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WeddingRegistrySettings;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 66
    iget-object v0, p0, Ljc;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Ljc;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    :cond_0
    iget-object v0, p0, Ljc;->f:Landroid/app/Activity;

    new-instance v1, Ljc$1;

    invoke-direct {v1, p0}, Ljc$1;-><init>(Ljc;)V

    new-instance v2, Ljc$2;

    invoke-direct {v2, p0}, Ljc$2;-><init>(Ljc;)V

    iget-boolean v3, p0, Ljc;->e:Z

    sget v4, Ljc;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 79
    return-void
.end method

.method public d()V
    .locals 6

    .prologue
    .line 59
    sget v0, Ljc;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljc;->l:I

    .line 60
    new-instance v0, Ljc;

    iget-object v1, p0, Ljc;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljc;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljc;->g:Landroid/view/View;

    iget-object v4, p0, Ljc;->a:Ljava/lang/String;

    iget-object v5, p0, Ljc;->j:Ljava/lang/String;

    invoke-direct/range {v0 .. v5}, Ljc;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljc;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 62
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 32
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 33
    iget-object v0, p0, Ljc;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 34
    iget-object v0, p0, Ljc;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 35
    :cond_0
    return-void
.end method
