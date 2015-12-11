.class public Liw;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

.field private k:Lnb;

.field private m:Landroid/app/Activity;

.field private n:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    sput v0, Liw;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 35
    invoke-direct {p0}, Lka;-><init>()V

    .line 23
    const-string v0, ""

    iput-object v0, p0, Liw;->a:Ljava/lang/String;

    .line 36
    iput-object p1, p0, Liw;->m:Landroid/app/Activity;

    .line 37
    iput-object p2, p0, Liw;->a:Ljava/lang/String;

    .line 38
    iput-object p3, p0, Liw;->n:Ljava/lang/String;

    .line 39
    iput-object p4, p0, Liw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 40
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Liw;->k:Lnb;

    .line 41
    iput-object p5, p0, Liw;->g:Landroid/view/View;

    .line 42
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 22
    sput p0, Liw;->l:I

    return p0
.end method

.method static synthetic a(Liw;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Liw;->m:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Liw;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Liw;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic c(Liw;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Liw;->n:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Liw;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Liw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic e(Liw;)Landroid/view/View;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Liw;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 22
    sget v0, Liw;->l:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Liw;->l:I

    return v0
.end method

.method private g()Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 9

    .prologue
    .line 96
    :try_start_0
    iget-object v0, p0, Liw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v0, p0, Liw;->k:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v2

    iget-object v0, p0, Liw;->k:Lnb;

    invoke-virtual {v0}, Lnb;->z()D

    move-result-wide v4

    iget-object v6, p0, Liw;->a:Ljava/lang/String;

    const/4 v7, 0x1

    const/16 v8, 0xa

    invoke-static/range {v1 .. v8}, Lfs;->a(Landroid/app/Activity;DDLjava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    .line 97
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    .line 99
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 100
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 106
    :goto_0
    return-object v0

    .line 103
    :catch_0
    move-exception v0

    .line 104
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    .line 106
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 46
    .line 47
    iget-object v0, p0, Liw;->n:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Liw;->n:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 48
    iget-object v0, p0, Liw;->a:Ljava/lang/String;

    iget-object v1, p0, Liw;->n:Ljava/lang/String;

    invoke-static {v0, v1}, Lfs;->f(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    move-result-object v0

    iput-object v0, p0, Liw;->j:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    .line 59
    :cond_0
    :goto_0
    return-void

    .line 50
    :cond_1
    iget-object v0, p0, Liw;->k:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    const-string v2, "0.0"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Liw;->k:Lnb;

    invoke-virtual {v0}, Lnb;->z()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v0

    const-string v2, "0.0"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_3

    .line 51
    invoke-direct {p0}, Liw;->g()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v0

    .line 53
    :goto_1
    if-eqz v0, :cond_2

    iget-object v2, p0, Liw;->a:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Liw;->a:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 54
    iget-object v1, p0, Liw;->a:Ljava/lang/String;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v0

    invoke-static {v1, v0}, Lfs;->f(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    move-result-object v0

    iput-object v0, p0, Liw;->j:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    goto :goto_0

    .line 55
    :cond_2
    iget-object v0, p0, Liw;->a:Ljava/lang/String;

    if-eqz v0, :cond_0

    iget-object v0, p0, Liw;->a:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 56
    iget-object v0, p0, Liw;->a:Ljava/lang/String;

    invoke-static {v0, v1}, Lfs;->f(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    move-result-object v0

    iput-object v0, p0, Liw;->j:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    goto :goto_0

    :cond_3
    move-object v0, v1

    goto :goto_1
.end method

.method public b()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 81
    iget-object v0, p0, Liw;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Liw;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 83
    :cond_0
    iget-object v0, p0, Liw;->j:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    if-eqz v0, :cond_1

    iget-object v0, p0, Liw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lix;

    if-eqz v0, :cond_1

    iget-object v0, p0, Liw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 84
    sput v4, Liw;->l:I

    .line 86
    new-instance v0, Lhc;

    iget-object v1, p0, Liw;->m:Landroid/app/Activity;

    iget-object v2, p0, Liw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Liw;->a:Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3}, Lhc;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhc;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 87
    iget-object v0, p0, Liw;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lix;

    iget-object v1, p0, Liw;->j:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    invoke-interface {v0, v1}, Lix;->a(Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;)V

    .line 92
    :goto_0
    return-void

    .line 89
    :cond_1
    iput-boolean v4, p0, Liw;->e:Z

    .line 90
    invoke-virtual {p0}, Liw;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 63
    iget-object v0, p0, Liw;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Liw;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 65
    :cond_0
    iget-object v0, p0, Liw;->m:Landroid/app/Activity;

    new-instance v1, Liw$1;

    invoke-direct {v1, p0}, Liw$1;-><init>(Liw;)V

    new-instance v2, Liw$2;

    invoke-direct {v2, p0}, Liw$2;-><init>(Liw;)V

    iget-boolean v3, p0, Liw;->e:Z

    sget v4, Liw;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 77
    return-void
.end method
