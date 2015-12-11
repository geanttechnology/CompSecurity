.class public Lhj;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field a:Z

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 31
    const/4 v0, 0x0

    sput v0, Lhj;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 34
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 29
    const/4 v0, 0x0

    iput-boolean v0, p0, Lhj;->a:Z

    .line 35
    iput-object p3, p0, Lhj;->g:Landroid/view/View;

    .line 36
    iput-object p4, p0, Lhj;->k:Ljava/util/ArrayList;

    .line 37
    return-void
.end method

.method static synthetic a(Lhj;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhj;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Lhj;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhj;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lhj;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhj;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic d(Lhj;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhj;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic e(Lhj;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method private f()V
    .locals 3

    .prologue
    .line 87
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lhj;->f:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 88
    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setCancelable(Z)Landroid/app/AlertDialog$Builder;

    .line 89
    const v1, 0x7f0802e9

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(I)Landroid/app/AlertDialog$Builder;

    .line 90
    const v1, 0x7f080283

    new-instance v2, Lhj$3;

    invoke-direct {v2, p0}, Lhj$3;-><init>(Lhj;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNeutralButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 96
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v0

    .line 97
    invoke-virtual {v0}, Landroid/app/AlertDialog;->show()V

    .line 98
    return-void
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 50
    iget-object v0, p0, Lhj;->k:Ljava/util/ArrayList;

    invoke-static {v0}, Lfs;->a(Ljava/util/ArrayList;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lhj;->j:Ljava/util/ArrayList;

    .line 51
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 102
    iget-object v0, p0, Lhj;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lhj;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 105
    :cond_0
    iget-object v0, p0, Lhj;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhj;->j:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lhj;->j:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 106
    :cond_1
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    if-eqz v0, :cond_3

    .line 107
    invoke-direct {p0}, Lhj;->f()V

    .line 127
    :cond_2
    :goto_0
    return-void

    .line 110
    :cond_3
    invoke-virtual {p0}, Lhj;->c()V

    goto :goto_0

    .line 113
    :cond_4
    const/4 v0, 0x0

    sput v0, Lhj;->l:I

    .line 114
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 115
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;

    iget-object v1, p0, Lhj;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 117
    :cond_5
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    if-eqz v0, :cond_6

    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 118
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/cart/MyCartFragment;

    iget-object v1, p0, Lhj;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/cart/MyCartFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 119
    :cond_6
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_7

    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 120
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Lhj;->j:Ljava/util/ArrayList;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/util/ArrayList;Z)V

    goto :goto_0

    .line 121
    :cond_7
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    if-eqz v0, :cond_8

    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 122
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;

    iget-object v1, p0, Lhj;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/registry/ScannedItemFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 123
    :cond_8
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 124
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;

    iget-object v1, p0, Lhj;->j:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 61
    iget-object v0, p0, Lhj;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Lhj;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 64
    :cond_0
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 65
    iget-object v0, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->b()V

    .line 83
    :goto_0
    return-void

    .line 67
    :cond_1
    iget-object v0, p0, Lhj;->f:Landroid/app/Activity;

    new-instance v1, Lhj$1;

    invoke-direct {v1, p0}, Lhj$1;-><init>(Lhj;)V

    new-instance v2, Lhj$2;

    invoke-direct {v2, p0}, Lhj$2;-><init>(Lhj;)V

    iget-boolean v3, p0, Lhj;->e:Z

    sget v4, Lhj;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    goto :goto_0
.end method

.method public d()V
    .locals 5

    .prologue
    .line 55
    sget v0, Lhj;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lhj;->l:I

    .line 56
    new-instance v0, Lhj;

    iget-object v1, p0, Lhj;->f:Landroid/app/Activity;

    iget-object v2, p0, Lhj;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lhj;->g:Landroid/view/View;

    iget-object v4, p0, Lhj;->k:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3, v4}, Lhj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 57
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 41
    iget-object v0, p0, Lhj;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 42
    iget-object v0, p0, Lhj;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 44
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lhj;->j:Ljava/util/ArrayList;

    .line 45
    return-void
.end method
