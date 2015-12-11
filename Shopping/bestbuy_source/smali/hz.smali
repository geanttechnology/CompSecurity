.class public Lhz;
.super Lka;
.source "SourceFile"


# static fields
.field private static a:I


# instance fields
.field private j:Ljava/lang/String;

.field private k:I

.field private l:I

.field private m:Ljava/lang/String;

.field private n:Z

.field private o:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private p:Z

.field private q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

.field private r:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

.field private s:Z

.field private t:Ljava/lang/String;

.field private u:Z

.field private v:Lnb;

.field private w:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private x:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    sput v0, Lhz;->a:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;II)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "II)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 114
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 33
    iput-boolean v1, p0, Lhz;->n:Z

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lhz;->o:Ljava/util/Map;

    .line 38
    iput-boolean v1, p0, Lhz;->s:Z

    .line 115
    iput-object p3, p0, Lhz;->g:Landroid/view/View;

    .line 116
    iput-object p4, p0, Lhz;->j:Ljava/lang/String;

    .line 117
    iput p7, p0, Lhz;->l:I

    .line 118
    iput p8, p0, Lhz;->k:I

    .line 119
    iput-object p5, p0, Lhz;->o:Ljava/util/Map;

    .line 120
    iput-object p6, p0, Lhz;->m:Ljava/lang/String;

    .line 121
    iput-object p2, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 122
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;IIZZZLjava/lang/String;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "IIZZZ",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 83
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 33
    iput-boolean v1, p0, Lhz;->n:Z

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lhz;->o:Ljava/util/Map;

    .line 38
    iput-boolean v1, p0, Lhz;->s:Z

    .line 84
    iput-object p3, p0, Lhz;->g:Landroid/view/View;

    .line 85
    iput-object p4, p0, Lhz;->j:Ljava/lang/String;

    .line 86
    iput p7, p0, Lhz;->k:I

    .line 87
    iput p8, p0, Lhz;->l:I

    .line 88
    iput-object p2, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 89
    iput-object p5, p0, Lhz;->o:Ljava/util/Map;

    .line 90
    iput-object p6, p0, Lhz;->m:Ljava/lang/String;

    .line 91
    iput-boolean p9, p0, Lhz;->p:Z

    .line 92
    iput-boolean p10, p0, Lhz;->s:Z

    .line 93
    iput-object p12, p0, Lhz;->x:Ljava/lang/String;

    .line 94
    iput-object p13, p0, Lhz;->t:Ljava/lang/String;

    .line 95
    iput-boolean p11, p0, Lhz;->u:Z

    .line 96
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/store/BBYStore;IIZZZ)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            "IIZZZ)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 65
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 33
    iput-boolean v1, p0, Lhz;->n:Z

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lhz;->o:Ljava/util/Map;

    .line 38
    iput-boolean v1, p0, Lhz;->s:Z

    .line 66
    iput-object p3, p0, Lhz;->g:Landroid/view/View;

    .line 67
    iput-object p4, p0, Lhz;->j:Ljava/lang/String;

    .line 68
    iput p8, p0, Lhz;->k:I

    .line 69
    iput p9, p0, Lhz;->l:I

    .line 70
    iput-object p2, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 71
    iput-object p5, p0, Lhz;->o:Ljava/util/Map;

    .line 72
    iput-object p6, p0, Lhz;->m:Ljava/lang/String;

    .line 73
    iput-boolean p10, p0, Lhz;->p:Z

    .line 74
    iput-boolean p11, p0, Lhz;->s:Z

    .line 75
    iput-object p7, p0, Lhz;->w:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 76
    iput-boolean p12, p0, Lhz;->u:Z

    .line 77
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;IIZZ)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "IIZZ)V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 48
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 33
    iput-boolean v1, p0, Lhz;->n:Z

    .line 34
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lhz;->o:Ljava/util/Map;

    .line 38
    iput-boolean v1, p0, Lhz;->s:Z

    .line 49
    iput-object p3, p0, Lhz;->g:Landroid/view/View;

    .line 50
    iput-object p4, p0, Lhz;->j:Ljava/lang/String;

    .line 51
    iput p8, p0, Lhz;->k:I

    .line 52
    iput p9, p0, Lhz;->l:I

    .line 53
    iput-object p2, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 54
    iput-object p5, p0, Lhz;->o:Ljava/util/Map;

    .line 55
    iput-object p6, p0, Lhz;->m:Ljava/lang/String;

    .line 56
    iput-boolean p10, p0, Lhz;->p:Z

    .line 57
    iput-boolean p11, p0, Lhz;->s:Z

    .line 58
    iput-object p7, p0, Lhz;->t:Ljava/lang/String;

    .line 59
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 27
    sput p0, Lhz;->a:I

    return p0
.end method

.method static synthetic a(Lhz;)Landroid/view/View;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    return-object v0
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 10

    .prologue
    const/4 v9, 0x0

    const/4 v0, 0x0

    .line 169
    .line 171
    if-eqz p1, :cond_1

    :try_start_0
    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 172
    const/4 v1, 0x0

    const/4 v2, 0x0

    const/16 v3, 0xc8

    invoke-static {p1, v1, v2, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v1

    .line 173
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v2

    .line 174
    if-eqz v2, :cond_2

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    move v1, v0

    .line 175
    :goto_0
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_2

    .line 176
    invoke-virtual {v2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 177
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v3, p2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 193
    :goto_1
    return-object v0

    .line 175
    :cond_0
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 183
    :cond_1
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v1

    iget-object v0, p0, Lhz;->v:Lnb;

    invoke-virtual {v0}, Lnb;->y()D

    move-result-wide v2

    iget-object v0, p0, Lhz;->v:Lnb;

    invoke-virtual {v0}, Lnb;->z()D

    move-result-wide v4

    const/4 v6, 0x0

    const/4 v7, 0x1

    const/4 v8, 0x1

    invoke-static/range {v1 .. v8}, Lfs;->a(Landroid/app/Activity;DDLjava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    .line 184
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    .line 185
    if-eqz v0, :cond_2

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 186
    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 190
    :catch_0
    move-exception v0

    .line 191
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    :cond_2
    move-object v0, v9

    .line 193
    goto :goto_1
.end method

.method static synthetic b(Lhz;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lhz;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic d(Lhz;)Landroid/view/View;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic e(Lhz;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 27
    sget v0, Lhz;->a:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Lhz;->a:I

    return v0
.end method

.method static synthetic f(Lhz;)Ljava/util/Map;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->o:Ljava/util/Map;

    return-object v0
.end method

.method static synthetic g(Lhz;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->m:Ljava/lang/String;

    return-object v0
.end method

.method private g()Z
    .locals 2

    .prologue
    .line 163
    iget-object v0, p0, Lhz;->f:Landroid/app/Activity;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 164
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic h(Lhz;)I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lhz;->l:I

    return v0
.end method

.method private h()V
    .locals 5

    .prologue
    .line 253
    iget-object v0, p0, Lhz;->f:Landroid/app/Activity;

    new-instance v1, Lhz$2;

    invoke-direct {v1, p0}, Lhz$2;-><init>(Lhz;)V

    new-instance v2, Lhz$3;

    invoke-direct {v2, p0}, Lhz$3;-><init>(Lhz;)V

    iget-boolean v3, p0, Lhz;->e:Z

    sget v4, Lhz;->a:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 266
    return-void
.end method

.method static synthetic i(Lhz;)I
    .locals 1

    .prologue
    .line 27
    iget v0, p0, Lhz;->k:I

    return v0
.end method

.method static synthetic j(Lhz;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lhz;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 10

    .prologue
    const/4 v5, 0x0

    .line 139
    const/4 v0, 0x0

    .line 140
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    iput-object v1, p0, Lhz;->v:Lnb;

    .line 141
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    invoke-virtual {v1}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v1

    const-string v2, "show_availability"

    invoke-interface {v1, v2, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v1

    iput-boolean v1, p0, Lhz;->u:Z

    .line 142
    iget-boolean v1, p0, Lhz;->u:Z

    if-eqz v1, :cond_1

    invoke-direct {p0}, Lhz;->g()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 143
    iget-object v1, p0, Lhz;->v:Lnb;

    invoke-virtual {v1}, Lnb;->y()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v1

    const-string v2, "0.0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    iget-object v1, p0, Lhz;->v:Lnb;

    invoke-virtual {v1}, Lnb;->z()D

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/String;->valueOf(D)Ljava/lang/String;

    move-result-object v1

    const-string v2, "0.0"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 144
    iget-object v0, p0, Lhz;->w:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-eqz v0, :cond_0

    .line 145
    iget-object v0, p0, Lhz;->w:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-object v9, v0

    .line 150
    :goto_0
    iget-object v0, p0, Lhz;->j:Ljava/lang/String;

    const-string v1, "search"

    invoke-virtual {v9}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lhz;->o:Ljava/util/Map;

    iget-object v4, p0, Lhz;->m:Ljava/lang/String;

    iget v7, p0, Lhz;->l:I

    iget v8, p0, Lhz;->k:I

    move v6, v5

    invoke-static/range {v0 .. v8}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZZII)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v0

    iput-object v0, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 151
    iget-object v0, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0, v9}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->setStoreDetails(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    .line 160
    :goto_1
    return-void

    .line 147
    :cond_0
    iget-object v0, p0, Lhz;->x:Ljava/lang/String;

    iget-object v1, p0, Lhz;->t:Ljava/lang/String;

    invoke-direct {p0, v0, v1}, Lhz;->a(Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v0

    move-object v9, v0

    goto :goto_0

    .line 153
    :cond_1
    iget-object v0, p0, Lhz;->j:Ljava/lang/String;

    const-string v1, "search"

    const-string v2, ""

    iget-object v3, p0, Lhz;->o:Ljava/util/Map;

    iget-object v4, p0, Lhz;->m:Ljava/lang/String;

    iget v7, p0, Lhz;->l:I

    iget v8, p0, Lhz;->k:I

    move v6, v5

    invoke-static/range {v0 .. v8}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZZII)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v0

    iput-object v0, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    goto :goto_1

    :cond_2
    move-object v9, v0

    goto :goto_0
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v2, 0x1

    .line 198
    const/4 v0, 0x0

    sput v0, Lhz;->a:I

    .line 199
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_4

    .line 200
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 201
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 202
    :cond_0
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 203
    iget-object v0, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-eqz v0, :cond_2

    .line 204
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Z)V

    .line 226
    :cond_1
    :goto_0
    return-void

    .line 205
    :cond_2
    iget-object v0, p0, Lhz;->r:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    if-eqz v0, :cond_3

    .line 206
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Lhz;->r:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;Z)V

    goto :goto_0

    .line 208
    :cond_3
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Lhz;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 211
    :cond_4
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/base/BBYBaseFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 212
    iget-object v0, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_5

    .line 213
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v1, p0, Lhz;->q:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    iget-object v2, p0, Lhz;->j:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragment;->a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Ljava/lang/String;)V

    .line 216
    :goto_1
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    if-eqz v0, :cond_1

    .line 217
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    new-instance v1, Lhz$1;

    invoke-direct {v1, p0}, Lhz$1;-><init>(Lhz;)V

    const-wide/16 v2, 0x3e8

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/View;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0

    .line 215
    :cond_5
    iget-object v0, p0, Lhz;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Lhz;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->showErrorBanner(Ljava/lang/String;)V

    goto :goto_1
.end method

.method public c()V
    .locals 2

    .prologue
    .line 230
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 231
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 232
    :cond_0
    iget-boolean v0, p0, Lhz;->e:Z

    if-eqz v0, :cond_1

    .line 233
    invoke-direct {p0}, Lhz;->h()V

    .line 250
    :goto_0
    return-void

    .line 235
    :cond_1
    iget-boolean v0, p0, Lhz;->n:Z

    if-nez v0, :cond_2

    .line 236
    invoke-direct {p0}, Lhz;->h()V

    goto :goto_0

    .line 238
    :cond_2
    iget-object v0, p0, Lhz;->j:Ljava/lang/String;

    const-string v1, "http://"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 239
    invoke-direct {p0}, Lhz;->h()V

    goto :goto_0

    .line 241
    :cond_3
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_4

    .line 242
    iget-object v0, p0, Lhz;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v1, p0, Lhz;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;)V

    goto :goto_0

    .line 245
    :cond_4
    iget-object v0, p0, Lhz;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Lhz;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->showErrorBanner(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 125
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 126
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lhz;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 128
    :cond_0
    iget-object v0, p0, Lhz;->j:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lhz;->j:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 129
    const-string v0, "[^A-Za-z0-9]"

    invoke-static {v0}, Ljava/util/regex/Pattern;->compile(Ljava/lang/String;)Ljava/util/regex/Pattern;

    move-result-object v0

    .line 130
    iget-object v1, p0, Lhz;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/regex/Pattern;->matcher(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;

    move-result-object v0

    .line 131
    invoke-virtual {v0}, Ljava/util/regex/Matcher;->find()Z

    move-result v0

    .line 132
    if-eqz v0, :cond_1

    .line 133
    const/4 v0, 0x1

    iput-boolean v0, p0, Lhz;->n:Z

    .line 135
    :cond_1
    return-void
.end method
