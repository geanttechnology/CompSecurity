.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private A:Landroid/widget/RelativeLayout;

.field private B:Leu;

.field private C:Ljava/lang/String;

.field private D:Ljava/lang/String;

.field private E:Ljava/lang/String;

.field private F:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private G:Ljava/lang/String;

.field private H:Z

.field private a:Landroid/view/LayoutInflater;

.field private b:Landroid/view/View;

.field private c:Landroid/app/Activity;

.field private g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private h:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Value;",
            ">;>;"
        }
    .end annotation
.end field

.field private i:Landroid/widget/LinearLayout;

.field private j:Landroid/widget/RelativeLayout;

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private l:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private n:Lca;

.field private o:Landroid/widget/ExpandableListView;

.field private p:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private q:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private r:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private s:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation
.end field

.field private t:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private u:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

.field private w:Lex;

.field private x:Landroid/widget/ListView;

.field private y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private z:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 75
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 43
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    .line 49
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    .line 50
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->m:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    .line 55
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    .line 56
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    .line 57
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    .line 60
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    .line 71
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    .line 72
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    .line 73
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->H:Z

    .line 76
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/HashMap;Lcom/bestbuy/android/api/lib/models/solr/SortOption;Ljava/util/List;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x0

    .line 82
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 43
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    .line 49
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    .line 50
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    .line 51
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->m:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    .line 55
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    .line 56
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    .line 57
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    .line 60
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    .line 71
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    .line 72
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    .line 73
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->H:Z

    .line 83
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    .line 84
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    .line 85
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    .line 86
    iput-object p5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    .line 87
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    .line 88
    iput-object p8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    .line 89
    iput-object p7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->C:Ljava/lang/String;

    .line 90
    iput-object p9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->D:Ljava/lang/String;

    .line 91
    iput-object p10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    .line 97
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    return-object v0
.end method

.method private a(ILjava/lang/String;)V
    .locals 7

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 238
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

    move-result-object v3

    .line 239
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 240
    if-nez v1, :cond_6

    .line 241
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v2, v1

    .line 242
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v4, "single"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 243
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 244
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 245
    invoke-interface {v2, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {p0, v3, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 246
    :cond_0
    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 255
    :cond_1
    :goto_1
    invoke-interface {v2, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 256
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 257
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->size()I

    move-result v1

    if-lt v1, v5, :cond_2

    .line 258
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->n:Lca;

    invoke-interface {v1, v5}, Lca;->a(Z)V

    .line 259
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    const v4, -0xff9855

    invoke-direct {v2, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 260
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v5}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 261
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 263
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v2, "Multi"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 264
    const-string v1, "category_facet"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 265
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->B:Leu;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Leu;->a(Ljava/util/ArrayList;)V

    .line 269
    :cond_3
    invoke-direct {p0, v3, p2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 270
    return-void

    .line 249
    :cond_4
    const-string v1, "category_facet"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 250
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5

    .line 251
    invoke-interface {v2, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {p0, v3, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 252
    :cond_5
    invoke-interface {v2}, Ljava/util/List;->clear()V

    goto :goto_1

    :cond_6
    move-object v2, v1

    goto/16 :goto_0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 273
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p2}, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 274
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 275
    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 276
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 277
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->P()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 281
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 282
    if-eqz v0, :cond_1

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_1

    .line 284
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 286
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 288
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v1, "Multi"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 289
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 291
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->B:Leu;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Leu;->a(Ljava/util/ArrayList;)V

    .line 292
    return-void

    .line 279
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private a(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 407
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 408
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

    move-result-object v1

    .line 409
    const v3, 0x7f08012c

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    const v3, 0x7f080157

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 410
    :cond_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v3, 0x7f080077

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_1

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v3, 0x7f080075

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 411
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 412
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 416
    :cond_2
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 417
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getValues()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/solr/Value;

    .line 418
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/solr/Value;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 420
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 422
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->B:Leu;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    invoke-virtual {v0, v1, v2, v3}, Leu;->a(Ljava/util/HashMap;Ljava/util/List;Ljava/util/HashMap;)V

    .line 423
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    return-object v0
.end method

.method private b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, -0x2

    const/16 v3, 0xa

    .line 295
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 296
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->D:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 325
    :goto_0
    return-void

    .line 298
    :cond_0
    new-instance v1, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    invoke-direct {v1, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 299
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 300
    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 301
    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 302
    invoke-virtual {v1, v3, v3, v3, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 303
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a:Landroid/view/LayoutInflater;

    const v2, 0x7f0300b8

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 304
    const v0, 0x7f0c02f3

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 305
    const v0, 0x7f0c02f2

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v3, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;

    invoke-direct {v3, p0, p1, p2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$4;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 322
    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 323
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 324
    invoke-virtual {v1, p2}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private b(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 426
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    .line 427
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    .line 428
    if-eqz p1, :cond_4

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 429
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 430
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

    move-result-object v2

    .line 431
    const v3, 0x7f08012c

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    const v3, 0x7f080157

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 432
    :cond_1
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f08006c

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f08012a

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080077

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080075

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 436
    :cond_2
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 437
    const v3, 0x7f0800f0

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 438
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->H:Z

    .line 440
    :cond_3
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getValues()Ljava/util/ArrayList;

    move-result-object v2

    .line 441
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 442
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 446
    :cond_4
    return-void
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method private e()V
    .locals 3

    .prologue
    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    .line 212
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getFacetField()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 214
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->B:Leu;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Leu;->a(Ljava/util/ArrayList;)V

    .line 215
    return-void
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/api/lib/models/solr/SortOption;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    return-object v0
.end method

.method private f()V
    .locals 5

    .prologue
    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 219
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 220
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 221
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 222
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 223
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v3, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 224
    const v3, 0x7f08012c

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    const v3, 0x7f080157

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 225
    :cond_1
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f08006c

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f08012a

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080077

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080075

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 229
    :cond_2
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 230
    invoke-direct {p0, v0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 233
    :cond_3
    return-void
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Lex;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->w:Lex;

    return-object v0
.end method

.method private g()V
    .locals 7

    .prologue
    .line 477
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 478
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 479
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 480
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 481
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 482
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 483
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 484
    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v6, "="

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 487
    :cond_1
    return-void
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Leu;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->B:Leu;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)V
    .locals 0

    .prologue
    .line 40
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g()V

    return-void
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 40
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->D:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public b()Ljava/util/HashMap;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 328
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    return-object v0
.end method

.method public c()Ljava/util/ArrayList;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation

    .prologue
    .line 332
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 490
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 111
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 112
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 100
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 101
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    .line 102
    check-cast p1, Lca;

    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->n:Lca;

    .line 103
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const v5, 0x7f0c0311

    const/4 v4, 0x0

    const v3, 0x7f0c0313

    const/16 v2, 0x8

    .line 457
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_1

    .line 458
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g()V

    .line 459
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->n:Lca;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Lca;->a(Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 474
    :cond_0
    :goto_0
    return-void

    .line 461
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 462
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v2, :cond_2

    .line 463
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    const v1, 0x7f020020

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 464
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 465
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 466
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0012

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    goto :goto_0

    .line 468
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 469
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 470
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    const v1, 0x7f020021

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 471
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0005

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 106
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 107
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 116
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a:Landroid/view/LayoutInflater;

    .line 117
    const v0, 0x7f0300bf

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    .line 118
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00bd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    .line 119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c030d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    .line 120
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0310

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c030f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    if-eqz v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 127
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b(Ljava/util/ArrayList;)V

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0312

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ExpandableListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v3}, Landroid/widget/ExpandableListView;->setGroupIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v3}, Landroid/widget/ExpandableListView;->setChildIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 132
    new-instance v0, Leu;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->D:Ljava/lang/String;

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Leu;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->B:Leu;

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->B:Leu;

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v1, "single"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 135
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->e()V

    .line 136
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0313

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->x:Landroid/widget/ListView;

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->x:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 154
    new-instance v0, Lex;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    const v2, 0x7f0300c2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SortOption;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/solr/SortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lex;-><init>(Landroid/app/Activity;ILjava/util/List;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->w:Lex;

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->x:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->w:Lex;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 156
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setOnChildClickListener(Landroid/widget/ExpandableListView$OnChildClickListener;)V

    .line 185
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setOnGroupClickListener(Landroid/widget/ExpandableListView$OnGroupClickListener;)V

    .line 197
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 198
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->H:Z

    if-nez v0, :cond_2

    .line 199
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    const-string v1, "category_facet"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 201
    :cond_2
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->f()V

    .line 203
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->a(Ljava/util/ArrayList;)V

    .line 207
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    return-object v0
.end method
