.class public Lii;
.super Lka;
.source "SourceFile"


# static fields
.field private static j:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    sput v0, Lii;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 29
    iput-object p3, p0, Lii;->g:Landroid/view/View;

    .line 30
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 23
    sput p0, Lii;->j:I

    return p0
.end method

.method static synthetic a(Lii;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic b(Lii;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 23
    iget-object v0, p0, Lii;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 34
    invoke-static {}, Lfs;->c()Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    move-result-object v0

    iput-object v0, p0, Lii;->a:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    .line 35
    return-void
.end method

.method public a(Ljava/lang/Void;)V
    .locals 2

    .prologue
    .line 93
    invoke-super {p0, p1}, Lka;->onCancelled(Ljava/lang/Object;)V

    .line 94
    iget-object v0, p0, Lii;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 95
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 46
    iget-object v0, p0, Lii;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 47
    iget-object v0, p0, Lii;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 48
    :cond_0
    const/4 v0, 0x0

    sput v0, Lii;->j:I

    .line 49
    iget-object v0, p0, Lii;->a:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lii;->a:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->getHeader()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 50
    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 51
    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    iget-object v1, p0, Lii;->a:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a(Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;)V

    .line 61
    :cond_1
    :goto_0
    return-void

    .line 56
    :cond_2
    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;

    iget-object v1, p0, Lii;->a:Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/browse/UberCategoryList;->getHeader()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/appsettings/NotificationsCategoryFragment;->a(Ljava/util/List;)V

    goto :goto_0

    .line 59
    :cond_3
    invoke-virtual {p0}, Lii;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 65
    iget-object v0, p0, Lii;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 66
    iget-object v0, p0, Lii;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    :cond_0
    iget-object v0, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isVisible()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 69
    iget-object v0, p0, Lii;->f:Landroid/app/Activity;

    new-instance v1, Lii$1;

    invoke-direct {v1, p0}, Lii$1;-><init>(Lii;)V

    new-instance v2, Lii$2;

    invoke-direct {v2, p0}, Lii$2;-><init>(Lii;)V

    iget-boolean v3, p0, Lii;->e:Z

    sget v4, Lii;->j:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 89
    :cond_1
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 40
    sget v0, Lii;->j:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lii;->j:I

    .line 41
    new-instance v0, Lii;

    iget-object v1, p0, Lii;->f:Landroid/app/Activity;

    iget-object v2, p0, Lii;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lii;->g:Landroid/view/View;

    invoke-direct {v0, v1, v2, v3}, Lii;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Landroid/os/AsyncTask;->THREAD_POOL_EXECUTOR:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lii;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 42
    return-void
.end method

.method public synthetic onCancelled(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 23
    check-cast p1, Ljava/lang/Void;

    invoke-virtual {p0, p1}, Lii;->a(Ljava/lang/Void;)V

    return-void
.end method
