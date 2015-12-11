.class public Ljy;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

.field private j:I

.field private k:Ljava/lang/String;

.field private m:I

.field private n:Landroid/app/Activity;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 25
    const/4 v0, 0x0

    sput v0, Ljy;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V
    .locals 0

    .prologue
    .line 30
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 31
    iput-object p1, p0, Ljy;->n:Landroid/app/Activity;

    .line 32
    iput-object p4, p0, Ljy;->k:Ljava/lang/String;

    .line 33
    iput-object p3, p0, Ljy;->g:Landroid/view/View;

    .line 34
    iput p5, p0, Ljy;->j:I

    .line 35
    iput p6, p0, Ljy;->m:I

    .line 36
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 21
    sput p0, Ljy;->l:I

    return p0
.end method

.method static synthetic a(Ljy;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/16 v3, 0xa

    .line 47
    iget-object v0, p0, Ljy;->k:Ljava/lang/String;

    invoke-static {v0}, Lnr;->c(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 48
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    iget-object v1, p0, Ljy;->k:Ljava/lang/String;

    iget v2, p0, Ljy;->j:I

    invoke-static {v0, v1, v4, v2, v3}, Lfs;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    iput-object v0, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    .line 51
    :goto_0
    return-void

    .line 50
    :cond_0
    iget-object v0, p0, Ljy;->k:Ljava/lang/String;

    iget v1, p0, Ljy;->j:I

    invoke-static {v0, v4, v1, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    iput-object v0, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    goto :goto_0
.end method

.method public b()V
    .locals 8

    .prologue
    const/16 v4, 0xf8

    const/16 v3, 0x4b

    const/16 v2, 0x8

    const/4 v7, 0x0

    .line 88
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 90
    :cond_0
    iget-object v0, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    if-nez v0, :cond_3

    .line 91
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 92
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->e()V

    .line 130
    :cond_1
    :goto_0
    return-void

    .line 93
    :cond_2
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_1

    .line 94
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a()V

    goto :goto_0

    .line 97
    :cond_3
    iget-object v0, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_4

    iget-object v0, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_b

    .line 98
    :cond_4
    iget v0, p0, Ljy;->j:I

    const/4 v1, 0x1

    if-ne v0, v1, :cond_9

    .line 99
    iget v0, p0, Ljy;->m:I

    if-eq v0, v4, :cond_7

    .line 100
    iget v0, p0, Ljy;->m:I

    const/16 v1, 0x32

    if-ne v0, v1, :cond_6

    .line 101
    iput v3, p0, Ljy;->m:I

    .line 105
    :cond_5
    :goto_1
    new-instance v0, Ljy;

    iget-object v1, p0, Ljy;->n:Landroid/app/Activity;

    iget-object v2, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljy;->g:Landroid/view/View;

    iget-object v4, p0, Ljy;->k:Ljava/lang/String;

    iget v5, p0, Ljy;->j:I

    iget v6, p0, Ljy;->m:I

    invoke-direct/range {v0 .. v6}, Ljy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v7, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 102
    :cond_6
    iget v0, p0, Ljy;->m:I

    if-ne v0, v3, :cond_5

    .line 103
    iput v4, p0, Ljy;->m:I

    goto :goto_1

    .line 107
    :cond_7
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_8

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_8

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 108
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->e()V

    goto :goto_0

    .line 109
    :cond_8
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_1

    .line 110
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a()V

    goto :goto_0

    .line 113
    :cond_9
    iget-object v0, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 114
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    if-eqz v0, :cond_a

    .line 115
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 117
    :cond_a
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 118
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->d()V

    goto/16 :goto_0

    .line 122
    :cond_b
    sput v7, Ljy;->l:I

    .line 123
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_c

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_c

    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_c

    .line 124
    iget-object v0, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v1, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a(Lcom/bestbuy/android/api/lib/models/remix/StoreList;)V

    goto/16 :goto_0

    .line 125
    :cond_c
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_1

    .line 126
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    iget-object v1, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Ljy;->a:Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->isHasNext()Z

    move-result v2

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a(Ljava/util/ArrayList;Z)V

    goto/16 :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 61
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 62
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 64
    :cond_0
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    if-eqz v0, :cond_1

    .line 65
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;->a()V

    .line 84
    :goto_0
    return-void

    .line 67
    :cond_1
    iget-object v0, p0, Ljy;->n:Landroid/app/Activity;

    new-instance v1, Ljy$1;

    invoke-direct {v1, p0}, Ljy$1;-><init>(Ljy;)V

    new-instance v2, Ljy$2;

    invoke-direct {v2, p0}, Ljy$2;-><init>(Ljy;)V

    iget-boolean v3, p0, Ljy;->e:Z

    sget v4, Ljy;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    goto :goto_0
.end method

.method public d()V
    .locals 7

    .prologue
    .line 55
    sget v0, Ljy;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Ljy;->l:I

    .line 56
    new-instance v0, Ljy;

    iget-object v1, p0, Ljy;->n:Landroid/app/Activity;

    iget-object v2, p0, Ljy;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Ljy;->g:Landroid/view/View;

    iget-object v4, p0, Ljy;->k:Ljava/lang/String;

    iget v5, p0, Ljy;->j:I

    iget v6, p0, Ljy;->m:I

    invoke-direct/range {v0 .. v6}, Ljy;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;II)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljy;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 57
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Ljy;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 43
    :cond_0
    return-void
.end method
