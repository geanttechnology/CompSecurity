.class public Ljz;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

.field private j:D

.field private k:D

.field private m:I

.field private n:I


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    sput v0, Ljz;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 29
    iput-object p3, p0, Ljz;->g:Landroid/view/View;

    .line 30
    iput-wide p4, p0, Ljz;->j:D

    .line 31
    iput-wide p6, p0, Ljz;->k:D

    .line 32
    iput p8, p0, Ljz;->m:I

    .line 33
    iput p9, p0, Ljz;->n:I

    .line 34
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 19
    sput p0, Ljz;->l:I

    return p0
.end method

.method static synthetic a(Ljz;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    .line 45
    iget-object v1, p0, Ljz;->f:Landroid/app/Activity;

    iget-wide v2, p0, Ljz;->j:D

    iget-wide v4, p0, Ljz;->k:D

    const/4 v6, 0x0

    iget v7, p0, Ljz;->m:I

    const/16 v8, 0xa

    invoke-static/range {v1 .. v8}, Lfs;->a(Landroid/app/Activity;DDLjava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    iput-object v0, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    .line 46
    return-void
.end method

.method public b()V
    .locals 11

    .prologue
    const/16 v4, 0xf8

    const/16 v3, 0x4b

    const/16 v2, 0x8

    const/4 v10, 0x0

    .line 80
    iget-object v0, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    if-nez v0, :cond_2

    .line 81
    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 82
    invoke-virtual {p0}, Ljz;->c()V

    .line 125
    :cond_0
    :goto_0
    return-void

    .line 83
    :cond_1
    iget-object v0, p0, Ljz;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_0

    .line 84
    iget-object v0, p0, Ljz;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a()V

    goto :goto_0

    .line 87
    :cond_2
    iget-object v0, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_3

    iget-object v0, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 88
    :cond_3
    iget v0, p0, Ljz;->m:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_8

    .line 89
    iget v0, p0, Ljz;->n:I

    if-eq v0, v4, :cond_6

    .line 90
    iget v0, p0, Ljz;->n:I

    const/16 v1, 0x32

    if-ne v0, v1, :cond_5

    .line 91
    iput v3, p0, Ljz;->n:I

    .line 96
    :cond_4
    :goto_1
    new-instance v0, Ljz;

    iget-object v1, p0, Ljz;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljz;->g:Landroid/view/View;

    iget-wide v4, p0, Ljz;->j:D

    iget-wide v6, p0, Ljz;->k:D

    iget v8, p0, Ljz;->m:I

    iget v9, p0, Ljz;->n:I

    invoke-direct/range {v0 .. v9}, Ljz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v10, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 93
    :cond_5
    iget v0, p0, Ljz;->n:I

    if-ne v0, v3, :cond_4

    .line 94
    iput v4, p0, Ljz;->n:I

    goto :goto_1

    .line 99
    :cond_6
    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_7

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_7

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_7

    .line 100
    invoke-virtual {p0}, Ljz;->c()V

    goto :goto_0

    .line 101
    :cond_7
    iget-object v0, p0, Ljz;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_0

    .line 102
    iget-object v0, p0, Ljz;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a()V

    goto :goto_0

    .line 105
    :cond_8
    iget-object v0, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 106
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    if-eqz v0, :cond_9

    .line 107
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 109
    :cond_9
    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d()V

    goto/16 :goto_0

    .line 114
    :cond_a
    sput v10, Ljz;->l:I

    .line 115
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    if-eqz v0, :cond_b

    .line 116
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 118
    :cond_b
    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_c

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_c

    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 119
    iget-object v0, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/api/lib/models/remix/StoreList;)V

    goto/16 :goto_0

    .line 120
    :cond_c
    iget-object v0, p0, Ljz;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_0

    .line 121
    iget-object v0, p0, Ljz;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    iget-object v1, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Ljz;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->isHasNext()Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a(Ljava/util/ArrayList;Z)V

    goto/16 :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 56
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 57
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 60
    :cond_0
    iget-object v0, p0, Ljz;->f:Landroid/app/Activity;

    new-instance v1, Ljz$1;

    invoke-direct {v1, p0}, Ljz$1;-><init>(Ljz;)V

    new-instance v2, Ljz$2;

    invoke-direct {v2, p0}, Ljz$2;-><init>(Ljz;)V

    iget-boolean v3, p0, Ljz;->e:Z

    sget v4, Ljz;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 76
    return-void
.end method

.method public d()V
    .locals 10

    .prologue
    .line 50
    sget v0, Ljz;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljz;->l:I

    .line 51
    new-instance v0, Ljz;

    iget-object v1, p0, Ljz;->f:Landroid/app/Activity;

    iget-object v2, p0, Ljz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljz;->g:Landroid/view/View;

    iget-wide v4, p0, Ljz;->j:D

    iget-wide v6, p0, Ljz;->k:D

    iget v8, p0, Ljz;->m:I

    iget v9, p0, Ljz;->n:I

    invoke-direct/range {v0 .. v9}, Ljz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;DDII)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 52
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 38
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 39
    iget-object v0, p0, Ljz;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 41
    :cond_0
    return-void
.end method
