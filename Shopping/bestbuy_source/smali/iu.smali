.class public Liu;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

.field private j:Ljava/lang/String;

.field private l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 28
    const/4 v0, 0x0

    sput v0, Liu;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Landroid/view/View;Lcom/bestbuy/android/bbyobjects/BBYWebView;)V
    .locals 0

    .prologue
    .line 32
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 33
    iput-object p3, p0, Liu;->j:Ljava/lang/String;

    .line 34
    iput-object p4, p0, Liu;->g:Landroid/view/View;

    .line 35
    iput-object p5, p0, Liu;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    .line 36
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 24
    sput p0, Liu;->k:I

    return p0
.end method

.method static synthetic a(Liu;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Liu;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Liu;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Liu;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic c(Liu;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Liu;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic d(Liu;)Landroid/view/View;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Liu;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic e(Liu;)Lcom/bestbuy/android/bbyobjects/BBYWebView;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Liu;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    return-object v0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 24
    sget v0, Liu;->k:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Liu;->k:I

    return v0
.end method

.method static synthetic f(Liu;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Liu;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    const/4 v2, 0x0

    const/4 v5, 0x0

    .line 51
    iget-object v0, p0, Liu;->j:Ljava/lang/String;

    const-string v1, "promo"

    const-string v4, "Best-Match"

    const/16 v7, 0x14

    const/4 v8, 0x1

    move-object v3, v2

    move v6, v5

    invoke-static/range {v0 .. v8}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;ZZII)Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    move-result-object v0

    iput-object v0, p0, Liu;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 52
    iget-object v0, p0, Liu;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-nez v0, :cond_0

    .line 53
    invoke-virtual {p0}, Liu;->c()V

    .line 55
    :cond_0
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 83
    iget-object v0, p0, Liu;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-eqz v0, :cond_2

    iget-object v0, p0, Liu;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuList()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Liu;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuList()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 84
    const/4 v0, 0x0

    sput v0, Liu;->k:I

    .line 85
    iget-object v0, p0, Liu;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/mdot/MdotWebFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Liu;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 86
    iget-object v0, p0, Liu;->a:Lcom/bestbuy/android/bbyobjects/BBYWebView;

    iget-object v1, p0, Liu;->l:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYWebView;->a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;)V

    .line 93
    :cond_0
    :goto_0
    return-void

    .line 87
    :cond_1
    iget-object v0, p0, Liu;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Liu;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    goto :goto_0

    .line 91
    :cond_2
    invoke-virtual {p0}, Liu;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 59
    iget-object v0, p0, Liu;->f:Landroid/app/Activity;

    new-instance v1, Liu$1;

    invoke-direct {v1, p0}, Liu$1;-><init>(Liu;)V

    new-instance v2, Liu$2;

    invoke-direct {v2, p0}, Liu$2;-><init>(Liu;)V

    iget-boolean v3, p0, Liu;->e:Z

    sget v4, Liu;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 71
    return-void
.end method

.method public e()V
    .locals 2

    .prologue
    .line 40
    iget-object v0, p0, Liu;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 41
    iget-object v0, p0, Liu;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 43
    :cond_0
    return-void
.end method
