.class public Lht;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Lmq;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private l:Ljava/lang/String;

.field private m:Ljava/lang/String;

.field private n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private o:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lmq;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 24
    iput-object p2, p0, Lht;->a:Lmq;

    .line 25
    iput-object p3, p0, Lht;->j:Ljava/lang/String;

    .line 26
    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lht;->k:Ljava/lang/String;

    .line 27
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lmq;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 1

    .prologue
    .line 39
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 40
    iput-object p2, p0, Lht;->a:Lmq;

    .line 41
    iput-object p3, p0, Lht;->j:Ljava/lang/String;

    .line 42
    invoke-virtual {p5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getSkuId()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lht;->k:Ljava/lang/String;

    .line 43
    invoke-virtual {p5}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getEp()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lht;->l:Ljava/lang/String;

    .line 44
    iput-object p4, p0, Lht;->m:Ljava/lang/String;

    .line 45
    iput-object p5, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 46
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lmq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 30
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 31
    iput-object p2, p0, Lht;->a:Lmq;

    .line 32
    iput-object p3, p0, Lht;->j:Ljava/lang/String;

    .line 33
    invoke-static {}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lht;->k:Ljava/lang/String;

    .line 34
    iput-object p4, p0, Lht;->l:Ljava/lang/String;

    .line 35
    iput-object p5, p0, Lht;->m:Ljava/lang/String;

    .line 36
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lmq;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)V
    .locals 1

    .prologue
    .line 49
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 50
    iput-object p2, p0, Lht;->a:Lmq;

    .line 51
    iput-object p3, p0, Lht;->j:Ljava/lang/String;

    .line 52
    iput-object p4, p0, Lht;->m:Ljava/lang/String;

    .line 53
    iput-object p5, p0, Lht;->o:Ljava/lang/String;

    .line 54
    iput-object p6, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 55
    return-void
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 63
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "load"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 64
    iget-object v0, p0, Lht;->a:Lmq;

    invoke-virtual {v0}, Lmq;->b()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lht;->a:Lmq;

    invoke-virtual {v0}, Lmq;->b()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 65
    iget-object v0, p0, Lht;->a:Lmq;

    invoke-virtual {v0}, Lmq;->g()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    .line 67
    :cond_0
    iget-object v0, p0, Lht;->a:Lmq;

    invoke-virtual {v0}, Lmq;->a()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lht;->a:Lmq;

    invoke-virtual {v0}, Lmq;->a()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 68
    iget-object v0, p0, Lht;->a:Lmq;

    invoke-virtual {v0}, Lmq;->h()Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    .line 95
    :cond_1
    :goto_0
    return-void

    .line 70
    :cond_2
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "clickcustomeralsoviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_3

    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "clickcustomeralsobought"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 71
    :cond_3
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2}, Lmq;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto :goto_0

    .line 72
    :cond_4
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "addtocart"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 73
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->k:Ljava/lang/String;

    iget-object v2, p0, Lht;->l:Ljava/lang/String;

    iget-object v3, p0, Lht;->m:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lmq;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto :goto_0

    .line 74
    :cond_5
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "productsloadmostpopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "cartloadmostpopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "storeloadmostpopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 75
    :cond_6
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->l:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lmq;->b(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto :goto_0

    .line 76
    :cond_7
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "productsclickmostpopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "cartclickmostpopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_8

    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "storesclickmostpopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    .line 77
    :cond_8
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2}, Lmq;->c(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 78
    :cond_9
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "homeloadrecentlyviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_a

    .line 79
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->o:Ljava/lang/String;

    iget-object v3, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v3}, Lmq;->a(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 80
    :cond_a
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "homeclickrecentlyviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 81
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2}, Lmq;->d(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 82
    :cond_b
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "homeloadalsoviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_c

    .line 83
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->o:Ljava/lang/String;

    iget-object v3, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v3}, Lmq;->b(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 84
    :cond_c
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "homeclickcustomeralsoviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_d

    .line 85
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2}, Lmq;->e(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 86
    :cond_d
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "homeloadtrendingnow"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_e

    .line 87
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->l:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lmq;->a(Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 88
    :cond_e
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "homeclicktrendingnow"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_f

    .line 89
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2}, Lmq;->b(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 90
    :cond_f
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "wishlistloadrecentlyviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_10

    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "registryloadrecentlyviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_11

    .line 91
    :cond_10
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->o:Ljava/lang/String;

    iget-object v3, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2, v3}, Lmq;->a(Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0

    .line 92
    :cond_11
    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "wishlistclickrecentlyviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_12

    iget-object v0, p0, Lht;->j:Ljava/lang/String;

    const-string v1, "registryclickrecentlyviewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 93
    :cond_12
    iget-object v0, p0, Lht;->a:Lmq;

    iget-object v1, p0, Lht;->m:Ljava/lang/String;

    iget-object v2, p0, Lht;->n:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v0, v1, v2}, Lmq;->d(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lfs;->a(Ljava/util/List;)V

    goto/16 :goto_0
.end method

.method public b()V
    .locals 0

    .prologue
    .line 99
    return-void
.end method

.method public c()V
    .locals 0

    .prologue
    .line 103
    return-void
.end method

.method public onPreExecute()V
    .locals 0

    .prologue
    .line 58
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 59
    return-void
.end method
