.class public Lhg;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private m:I

.field private n:I

.field private o:Z


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    sput v0, Lhg;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IIZ)V
    .locals 1

    .prologue
    .line 29
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 30
    iput-object p4, p0, Lhg;->j:Ljava/lang/String;

    .line 31
    iput-object p3, p0, Lhg;->g:Landroid/view/View;

    .line 32
    iput-object p5, p0, Lhg;->k:Ljava/lang/String;

    .line 33
    iput p6, p0, Lhg;->m:I

    .line 34
    iput p7, p0, Lhg;->n:I

    .line 35
    iput-boolean p8, p0, Lhg;->o:Z

    .line 36
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhg;->a:Ljava/util/ArrayList;

    .line 37
    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 53
    iget-object v0, p0, Lhg;->j:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lhg;->j:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 54
    :cond_0
    const-string v0, "all"

    iput-object v0, p0, Lhg;->j:Ljava/lang/String;

    .line 55
    :cond_1
    iget-object v0, p0, Lhg;->j:Ljava/lang/String;

    iget v1, p0, Lhg;->m:I

    iget v2, p0, Lhg;->n:I

    iget-boolean v3, p0, Lhg;->o:Z

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Ljava/lang/String;IIZ)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhg;->a:Ljava/util/ArrayList;

    .line 57
    return-void
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 86
    iget-object v2, p0, Lhg;->g:Landroid/view/View;

    if-eqz v2, :cond_0

    .line 87
    iget-object v2, p0, Lhg;->g:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 89
    :cond_0
    iget-object v2, p0, Lhg;->a:Ljava/util/ArrayList;

    if-eqz v2, :cond_7

    iget-object v2, p0, Lhg;->a:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_7

    .line 90
    sput v1, Lhg;->l:I

    .line 91
    iget-object v2, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v2, v2, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 92
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    iget-object v1, p0, Lhg;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->a(Ljava/util/ArrayList;)V

    .line 111
    :cond_1
    :goto_0
    return-void

    .line 94
    :cond_2
    iget-object v2, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v2, v2, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 95
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    iget-object v1, p0, Lhg;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 97
    :cond_3
    iget-object v2, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v2, v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v2, :cond_5

    iget-object v2, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 99
    iget v2, p0, Lhg;->m:I

    if-le v2, v0, :cond_4

    move v1, v0

    .line 101
    :cond_4
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v2, p0, Lhg;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/util/ArrayList;Z)V

    goto :goto_0

    .line 102
    :cond_5
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 103
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    iget-object v1, p0, Lhg;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 105
    :cond_6
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 106
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v1, p0, Lhg;->a:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 109
    :cond_7
    invoke-virtual {p0}, Lhg;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 67
    iget-object v0, p0, Lhg;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 68
    iget-object v0, p0, Lhg;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 70
    :cond_0
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    if-eqz v0, :cond_2

    .line 71
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b()V

    .line 82
    :cond_1
    :goto_0
    return-void

    .line 73
    :cond_2
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 74
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseCategoryFragment;->b()V

    goto :goto_0

    .line 75
    :cond_3
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 76
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/BrowseSuperSubCategoryFragment;->b()V

    goto :goto_0

    .line 77
    :cond_4
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 78
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->d()V

    goto :goto_0

    .line 79
    :cond_5
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 80
    iget-object v0, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->b()V

    goto :goto_0
.end method

.method public d()V
    .locals 9

    .prologue
    .line 61
    sget v0, Lhg;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhg;->l:I

    .line 62
    new-instance v0, Lhg;

    iget-object v1, p0, Lhg;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhg;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhg;->g:Landroid/view/View;

    iget-object v4, p0, Lhg;->j:Ljava/lang/String;

    iget-object v5, p0, Lhg;->k:Ljava/lang/String;

    iget v6, p0, Lhg;->m:I

    iget v7, p0, Lhg;->n:I

    iget-boolean v8, p0, Lhg;->o:Z

    invoke-direct/range {v0 .. v8}, Lhg;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;IIZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhg;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 63
    return-void
.end method

.method public e()V
    .locals 0

    .prologue
    .line 48
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 40
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 41
    iget-object v0, p0, Lhg;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 42
    iget-object v0, p0, Lhg;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 44
    :cond_0
    return-void
.end method
