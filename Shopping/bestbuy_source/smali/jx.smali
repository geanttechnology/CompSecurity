.class public Ljx;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/remix/Store;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    sput v0, Ljx;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 28
    iput-object p3, p0, Ljx;->g:Landroid/view/View;

    .line 29
    iput-object p4, p0, Ljx;->a:Ljava/lang/String;

    .line 30
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 21
    sput p0, Ljx;->k:I

    return p0
.end method

.method static synthetic a(Ljx;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Ljx;->a:Ljava/lang/String;

    invoke-static {v0}, Lfs;->c(Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/remix/Store;

    move-result-object v0

    iput-object v0, p0, Ljx;->j:Lcom/bestbuy/android/api/lib/models/remix/Store;

    .line 42
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 74
    iget-object v0, p0, Ljx;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Ljx;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 77
    :cond_0
    const/4 v0, 0x0

    sput v0, Ljx;->k:I

    .line 78
    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 79
    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;

    iget-object v1, p0, Ljx;->j:Lcom/bestbuy/android/api/lib/models/remix/Store;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/mybby/MyBBYDetailedReceipt;->a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V

    .line 85
    :cond_1
    :goto_0
    return-void

    .line 80
    :cond_2
    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    if-eqz v0, :cond_3

    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 81
    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;

    iget-object v1, p0, Ljx;->j:Lcom/bestbuy/android/api/lib/models/remix/Store;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreDetailsFragment;->a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V

    goto :goto_0

    .line 82
    :cond_3
    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 83
    iget-object v0, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Ljx;->j:Lcom/bestbuy/android/api/lib/models/remix/Store;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 52
    iget-object v0, p0, Ljx;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Ljx;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 55
    :cond_0
    iget-object v0, p0, Ljx;->f:Landroid/app/Activity;

    new-instance v1, Ljx$1;

    invoke-direct {v1, p0}, Ljx$1;-><init>(Ljx;)V

    new-instance v2, Ljx$2;

    invoke-direct {v2, p0}, Ljx$2;-><init>(Ljx;)V

    iget-boolean v3, p0, Ljx;->e:Z

    sget v4, Ljx;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 70
    return-void
.end method

.method public d()V
    .locals 5

    .prologue
    .line 46
    sget v0, Ljx;->k:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljx;->k:I

    .line 47
    new-instance v0, Ljx;

    iget-object v1, p0, Ljx;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljx;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljx;->g:Landroid/view/View;

    iget-object v4, p0, Ljx;->a:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3, v4}, Ljx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 48
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 34
    iget-object v0, p0, Ljx;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 35
    iget-object v0, p0, Ljx;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 37
    :cond_0
    return-void
.end method
