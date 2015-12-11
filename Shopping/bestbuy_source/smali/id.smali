.class public Lid;
.super Lka;
.source "SourceFile"


# static fields
.field private static l:I


# instance fields
.field private a:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

.field private j:Ljava/lang/String;

.field private k:Ljava/lang/String;

.field private m:I

.field private n:I

.field private o:Z

.field private p:Ljava/lang/String;

.field private q:Ljava/lang/String;

.field private r:Ljava/util/ArrayList;
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
    .line 28
    const/4 v0, 0x0

    sput v0, Lid;->l:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "IIZ)V"
        }
    .end annotation

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 40
    iput-object p6, p0, Lid;->j:Ljava/lang/String;

    .line 41
    iput-object p3, p0, Lid;->g:Landroid/view/View;

    .line 42
    iput-object p8, p0, Lid;->k:Ljava/lang/String;

    .line 43
    iput p9, p0, Lid;->m:I

    .line 44
    iput p10, p0, Lid;->n:I

    .line 45
    iput-boolean p11, p0, Lid;->o:Z

    .line 46
    iput-object p4, p0, Lid;->p:Ljava/lang/String;

    .line 47
    iput-object p7, p0, Lid;->q:Ljava/lang/String;

    .line 48
    iput-object p5, p0, Lid;->r:Ljava/util/ArrayList;

    .line 49
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 24
    sput p0, Lid;->l:I

    return p0
.end method

.method static synthetic a(Lid;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lid;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic b(Lid;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lid;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 9

    .prologue
    .line 64
    iget-object v0, p0, Lid;->r:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lid;->r:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 65
    :cond_0
    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "MostPopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "RecenltyViewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "CustomerAlsoBought"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "CustomerAlsoViewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_1

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "Trending"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 66
    :cond_1
    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    iget-object v1, p0, Lid;->f:Landroid/app/Activity;

    iget-object v2, p0, Lid;->j:Ljava/lang/String;

    iget-object v3, p0, Lid;->q:Ljava/lang/String;

    iget-object v4, p0, Lid;->k:Ljava/lang/String;

    iget v5, p0, Lid;->m:I

    iget v6, p0, Lid;->n:I

    iget-boolean v7, p0, Lid;->o:Z

    invoke-static/range {v0 .. v7}, Lfs;->b(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    iput-object v0, p0, Lid;->a:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    .line 78
    :goto_0
    return-void

    .line 68
    :cond_2
    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    iget-object v1, p0, Lid;->f:Landroid/app/Activity;

    iget-object v2, p0, Lid;->j:Ljava/lang/String;

    iget-object v3, p0, Lid;->q:Ljava/lang/String;

    iget-object v4, p0, Lid;->k:Ljava/lang/String;

    iget v5, p0, Lid;->m:I

    iget v6, p0, Lid;->n:I

    iget-boolean v7, p0, Lid;->o:Z

    invoke-static/range {v0 .. v7}, Lfs;->a(Ljava/lang/String;Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    iput-object v0, p0, Lid;->a:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    goto :goto_0

    .line 72
    :cond_3
    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "MostPopular"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "RecenltyViewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "CustomerAlsoBought"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "CustomerAlsoViewed"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_4

    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    const-string v1, "Trending"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 73
    :cond_4
    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    iget-object v1, p0, Lid;->f:Landroid/app/Activity;

    iget-object v2, p0, Lid;->r:Ljava/util/ArrayList;

    iget-object v3, p0, Lid;->j:Ljava/lang/String;

    iget-object v4, p0, Lid;->q:Ljava/lang/String;

    iget-object v5, p0, Lid;->k:Ljava/lang/String;

    iget v6, p0, Lid;->m:I

    iget v7, p0, Lid;->n:I

    iget-boolean v8, p0, Lid;->o:Z

    invoke-static/range {v0 .. v8}, Lfs;->b(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    iput-object v0, p0, Lid;->a:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    goto :goto_0

    .line 75
    :cond_5
    iget-object v0, p0, Lid;->p:Ljava/lang/String;

    iget-object v1, p0, Lid;->f:Landroid/app/Activity;

    iget-object v2, p0, Lid;->r:Ljava/util/ArrayList;

    iget-object v3, p0, Lid;->j:Ljava/lang/String;

    iget-object v4, p0, Lid;->q:Ljava/lang/String;

    iget-object v5, p0, Lid;->k:Ljava/lang/String;

    iget v6, p0, Lid;->m:I

    iget v7, p0, Lid;->n:I

    iget-boolean v8, p0, Lid;->o:Z

    invoke-static/range {v0 .. v8}, Lfs;->a(Ljava/lang/String;Landroid/content/Context;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    move-result-object v0

    iput-object v0, p0, Lid;->a:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    goto :goto_0
.end method

.method public b()V
    .locals 4

    .prologue
    const/4 v0, 0x1

    const/4 v1, 0x0

    .line 121
    iget-object v2, p0, Lid;->g:Landroid/view/View;

    if-eqz v2, :cond_0

    .line 122
    iget-object v2, p0, Lid;->g:Landroid/view/View;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/view/View;->setVisibility(I)V

    .line 124
    :cond_0
    iget-object v2, p0, Lid;->a:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    if-eqz v2, :cond_3

    .line 125
    sput v1, Lid;->l:I

    .line 126
    iget-object v2, p0, Lid;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v2, v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lid;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v2}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 128
    iget v2, p0, Lid;->m:I

    if-le v2, v0, :cond_1

    move v1, v0

    .line 130
    :cond_1
    iget-object v0, p0, Lid;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    iget-object v2, p0, Lid;->a:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    invoke-virtual {v0, v2, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;Z)V

    .line 135
    :cond_2
    :goto_0
    return-void

    .line 133
    :cond_3
    invoke-virtual {p0}, Lid;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 88
    iget-object v0, p0, Lid;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 89
    iget-object v0, p0, Lid;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 91
    :cond_0
    iget-object v0, p0, Lid;->f:Landroid/app/Activity;

    new-instance v1, Lid$1;

    invoke-direct {v1, p0}, Lid$1;-><init>(Lid;)V

    new-instance v2, Lid$2;

    invoke-direct {v2, p0}, Lid$2;-><init>(Lid;)V

    iget-boolean v3, p0, Lid;->e:Z

    sget v4, Lid;->l:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 117
    return-void
.end method

.method public d()V
    .locals 12

    .prologue
    .line 82
    sget v0, Lid;->l:I

    add-int/lit8 v0, v0, 0x1

    sput v0, Lid;->l:I

    .line 83
    new-instance v0, Lid;

    iget-object v1, p0, Lid;->f:Landroid/app/Activity;

    iget-object v2, p0, Lid;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    iget-object v3, p0, Lid;->g:Landroid/view/View;

    iget-object v4, p0, Lid;->p:Ljava/lang/String;

    iget-object v5, p0, Lid;->r:Ljava/util/ArrayList;

    iget-object v6, p0, Lid;->j:Ljava/lang/String;

    iget-object v7, p0, Lid;->q:Ljava/lang/String;

    iget-object v8, p0, Lid;->k:Ljava/lang/String;

    iget v9, p0, Lid;->m:I

    iget v10, p0, Lid;->n:I

    iget-boolean v11, p0, Lid;->o:Z

    invoke-direct/range {v0 .. v11}, Lid;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lid;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 84
    return-void
.end method

.method public e()V
    .locals 0

    .prologue
    .line 60
    return-void
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 52
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 53
    iget-object v0, p0, Lid;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 54
    iget-object v0, p0, Lid;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 56
    :cond_0
    return-void
.end method
