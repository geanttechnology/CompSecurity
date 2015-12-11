.class public Lhf;
.super Lka;
.source "SourceFile"


# static fields
.field private static o:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:I

.field private m:I

.field private n:Z

.field private p:Lnb;

.field private q:Z

.field private r:Lcom/bestbuy/android/api/lib/models/store/BBYStore;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 24
    const/4 v0, 0x0

    sput v0, Lhf;->o:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;IIZLandroid/view/View;Z)V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0, p1, p2, p8}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 20
    new-instance v0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;-><init>()V

    iput-object v0, p0, Lhf;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 31
    iput-object p3, p0, Lhf;->j:Ljava/lang/String;

    .line 32
    iput-object p4, p0, Lhf;->k:Ljava/lang/String;

    .line 33
    iput p5, p0, Lhf;->l:I

    .line 34
    iput p6, p0, Lhf;->m:I

    .line 35
    iput-boolean p7, p0, Lhf;->n:Z

    .line 36
    iput-boolean p9, p0, Lhf;->q:Z

    .line 37
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;IIZLandroid/view/View;ZLcom/bestbuy/android/api/lib/models/store/BBYStore;)V
    .locals 1

    .prologue
    .line 40
    invoke-direct {p0, p1, p2, p8}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 20
    new-instance v0, Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;-><init>()V

    iput-object v0, p0, Lhf;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 41
    iput-object p3, p0, Lhf;->j:Ljava/lang/String;

    .line 42
    iput-object p4, p0, Lhf;->k:Ljava/lang/String;

    .line 43
    iput p5, p0, Lhf;->l:I

    .line 44
    iput p6, p0, Lhf;->m:I

    .line 45
    iput-boolean p7, p0, Lhf;->n:Z

    .line 46
    iput-boolean p9, p0, Lhf;->q:Z

    .line 47
    iput-object p10, p0, Lhf;->r:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 48
    return-void
.end method

.method private f()Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 78
    :try_start_0
    iget-object v0, p0, Lhf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v0, p0, Lhf;->p:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v2

    iget-object v0, p0, Lhf;->p:Lnb;

    invoke-virtual {v0}, Lnb;->z()D

    move-result-wide v4

    const/4 v6, 0x0

    const/4 v7, 0x1

    const/4 v8, 0x1

    invoke-static/range {v1 .. v8}, Lfs;->a(Landroid/app/Activity;DDLjava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    .line 79
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    .line 80
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 81
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 87
    :goto_0
    return-object v0

    .line 84
    :catch_0
    move-exception v0

    .line 85
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_0
    move-object v0, v9

    .line 87
    goto :goto_0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 59
    const/4 v0, 0x0

    .line 60
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    iput-object v1, p0, Lhf;->p:Lnb;

    .line 61
    iget-boolean v1, p0, Lhf;->q:Z

    if-eqz v1, :cond_1

    .line 62
    iget-object v1, p0, Lhf;->p:Lnb;

    invoke-virtual {v1}, Lnb;->y()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v1

    const-string v2, "0.0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lhf;->p:Lnb;

    invoke-virtual {v1}, Lnb;->z()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v1

    const-string v2, "0.0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 63
    iget-object v0, p0, Lhf;->r:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-eqz v0, :cond_2

    .line 64
    iget-object v0, p0, Lhf;->r:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 69
    :cond_0
    :goto_0
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lhf;->j:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "&facetsOnly=false&storeId="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lhf;->j:Ljava/lang/String;

    .line 72
    :cond_1
    iget-object v1, p0, Lhf;->j:Ljava/lang/String;

    iget-object v2, p0, Lhf;->k:Ljava/lang/String;

    iget v3, p0, Lhf;->m:I

    invoke-static {v1, v2, v3}, Lfs;->b(Ljava/lang/String;Ljava/lang/String;I)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v1

    iput-object v1, p0, Lhf;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 73
    iget-object v1, p0, Lhf;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->setStoreDetails(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    .line 74
    return-void

    .line 66
    :cond_2
    invoke-direct {p0}, Lhf;->f()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v0

    goto :goto_0
.end method

.method public b()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 102
    iget-object v0, p0, Lhf;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 103
    iget-object v0, p0, Lhf;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 105
    :cond_0
    iget-object v0, p0, Lhf;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-nez v0, :cond_2

    .line 106
    invoke-virtual {p0}, Lhf;->c()V

    .line 113
    :cond_1
    :goto_0
    return-void

    .line 108
    :cond_2
    sput v2, Lhf;->o:I

    .line 109
    iget-object v0, p0, Lhf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 110
    iget-object v0, p0, Lhf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Lhf;->a:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Z)V

    goto :goto_0
.end method

.method public c()V
    .locals 2

    .prologue
    .line 92
    iget-object v0, p0, Lhf;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 93
    iget-object v0, p0, Lhf;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 95
    :cond_0
    iget-object v0, p0, Lhf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/DODHomeCard;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 96
    iget-object v0, p0, Lhf;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/DODHomeCard;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/DODHomeCard;->b()V

    .line 98
    :cond_1
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 52
    iget-object v0, p0, Lhf;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 53
    iget-object v0, p0, Lhf;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 55
    :cond_0
    return-void
.end method
