.class public Lje;
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
            "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    sput v0, Lje;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 26
    iput-object p3, p0, Lje;->g:Landroid/view/View;

    .line 27
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 19
    sput p0, Lje;->j:I

    return p0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 19
    sget v0, Lje;->j:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Lje;->j:I

    return v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 37
    const/4 v0, 0x0

    sput v0, Lje;->j:I

    .line 38
    invoke-static {}, Lfs;->d()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lje;->a:Ljava/util/ArrayList;

    .line 39
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 43
    iget-object v0, p0, Lje;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 44
    iget-object v0, p0, Lje;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 46
    :cond_0
    iget-object v0, p0, Lje;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lje;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 47
    iget-object v0, p0, Lje;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    iget-object v1, p0, Lje;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a(Ljava/util/ArrayList;)V

    .line 49
    :cond_1
    iget-object v0, p0, Lje;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lje;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 50
    iget-object v0, p0, Lje;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;

    iget-object v1, p0, Lje;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/WishListSettingsFragment;->a(Ljava/util/ArrayList;)V

    .line 52
    :cond_2
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 62
    iget-object v0, p0, Lje;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Lje;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 64
    :cond_0
    iget-object v0, p0, Lje;->f:Landroid/app/Activity;

    new-instance v1, Lje$1;

    invoke-direct {v1, p0}, Lje$1;-><init>(Lje;)V

    new-instance v2, Lje$2;

    invoke-direct {v2, p0}, Lje$2;-><init>(Lje;)V

    iget-boolean v3, p0, Lje;->e:Z

    sget v4, Lje;->j:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 76
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 56
    sget v0, Lje;->j:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lje;->j:I

    .line 57
    new-instance v0, Lje;

    iget-object v1, p0, Lje;->f:Landroid/app/Activity;

    iget-object v2, p0, Lje;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lje;->g:Landroid/view/View;

    invoke-direct {v0, v1, v2, v3}, Lje;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lje;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 58
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 30
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 31
    iget-object v0, p0, Lje;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 32
    iget-object v0, p0, Lje;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 33
    :cond_0
    return-void
.end method
