.class public Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private A:Landroid/widget/RelativeLayout;

.field private B:Ldj;

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

.field private I:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private J:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private K:Ljava/lang/String;

.field private a:Landroid/view/LayoutInflater;

.field private b:Landroid/view/View;

.field private c:Landroid/app/Activity;

.field private g:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
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
            "Lcom/bestbuy/android/api/lib/models/search/FacetValues;",
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
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation
.end field

.field private l:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation
.end field

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;"
        }
    .end annotation
.end field

.field private n:Ldm;

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
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
            ">;"
        }
    .end annotation
.end field

.field private v:Lcom/bestbuy/android/api/lib/models/search/Sort;

.field private w:Ldn;

.field private x:Landroid/widget/ListView;

.field private y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private z:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 78
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    .line 48
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    .line 49
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->m:Ljava/util/ArrayList;

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    .line 55
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    .line 56
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    .line 59
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    .line 71
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    .line 72
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->H:Z

    .line 73
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    .line 74
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->J:Ljava/util/ArrayList;

    .line 75
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->K:Ljava/lang/String;

    .line 79
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/HashMap;Lcom/bestbuy/android/api/lib/models/search/Sort;Ljava/util/List;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;>;",
            "Lcom/bestbuy/android/api/lib/models/search/Sort;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
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

    .line 85
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    .line 48
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    .line 49
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->m:Ljava/util/ArrayList;

    .line 53
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    .line 54
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    .line 55
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    .line 56
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    .line 57
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    .line 58
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    .line 59
    iput-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    .line 70
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    .line 71
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    .line 72
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->H:Z

    .line 73
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    .line 74
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->J:Ljava/util/ArrayList;

    .line 75
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->K:Ljava/lang/String;

    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    .line 87
    iput-object p3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    .line 88
    iput-object p4, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    .line 89
    iput-object p5, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    .line 90
    iput-object p2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    .line 91
    iput-object p8, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    .line 92
    iput-object p7, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->C:Ljava/lang/String;

    .line 93
    iput-object p9, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->D:Ljava/lang/String;

    .line 94
    iput-object p10, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    .line 100
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    return-object v0
.end method

.method private a(ILjava/lang/String;)V
    .locals 7
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 264
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v0, p1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 266
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v3

    .line 267
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 268
    if-nez v1, :cond_6

    .line 269
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object v2, v1

    .line 270
    :goto_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v4, "single"

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 271
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v1, v3}, Ljava/util/ArrayList;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 272
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 273
    invoke-interface {v2, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {p0, v3, v1}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 274
    :cond_0
    invoke-interface {v2}, Ljava/util/List;->clear()V

    .line 283
    :cond_1
    :goto_1
    invoke-interface {v2, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 284
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1, v3, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 285
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1}, Ljava/util/HashMap;->size()I

    move-result v1

    if-lt v1, v5, :cond_2

    .line 286
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->n:Ldm;

    invoke-interface {v1, v5}, Ldm;->a(Z)V

    .line 287
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    const v4, -0xff9855

    invoke-direct {v2, v4}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v1, v2}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 288
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, v5}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 289
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v1, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 291
    :cond_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v2, "Multi"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 292
    const-string v1, "category_facet"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 293
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 294
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->B:Ldj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ldj;->a(Ljava/util/ArrayList;)V

    .line 297
    :cond_3
    invoke-direct {p0, v3, p2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    return-void

    .line 277
    :cond_4
    const-string v1, "category_facet"

    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_1

    .line 278
    invoke-interface {v2}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5

    .line 279
    invoke-interface {v2, v6}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-direct {p0, v3, v1}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 280
    :cond_5
    invoke-interface {v2}, Ljava/util/List;->clear()V

    goto :goto_1

    :cond_6
    move-object v2, v1

    goto/16 :goto_0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;ILjava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(ILjava/lang/String;)V

    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 4
    .annotation build Landroid/annotation/SuppressLint;
        value = {
            "NewApi"
        }
    .end annotation

    .prologue
    .line 301
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p2}, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 302
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 303
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->f:Lnb;

    invoke-virtual {v1}, Lnb;->P()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 307
    invoke-interface {v0, p2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 308
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-eqz v2, :cond_3

    .line 309
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 313
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

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

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 314
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 316
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 318
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 319
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 320
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v1, "Multi"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 321
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 323
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->B:Ldj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ldj;->a(Ljava/util/ArrayList;)V

    .line 324
    return-void

    .line 311
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v2, p1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method private a(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;)V"
        }
    .end annotation

    .prologue
    const v5, 0x7f08012c

    .line 445
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 446
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v1

    .line 447
    invoke-virtual {p0, v5}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    const v3, 0x7f080157

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 448
    :cond_0
    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080077

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080075

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 449
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 450
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 454
    :cond_2
    invoke-virtual {p0, v5}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 455
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v1, :cond_3

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v3, 0x7f08006c

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 456
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v1, v0}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 457
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 461
    :cond_3
    new-instance v3, Ljava/util/ArrayList;

    invoke-direct {v3}, Ljava/util/ArrayList;-><init>()V

    .line 462
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getValues()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v4

    :goto_1
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/FacetValues;

    .line 463
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/FacetValues;->getValue()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v3, v1}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 465
    :cond_4
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 467
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->B:Ldj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->s:Ljava/util/HashMap;

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    invoke-virtual {v0, v1, v2, v3}, Ldj;->a(Ljava/util/HashMap;Ljava/util/List;Ljava/util/HashMap;)V

    .line 468
    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    return-object v0
.end method

.method private b(Ljava/lang/String;Ljava/lang/String;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v4, -0x2

    const/16 v3, 0xa

    .line 327
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 328
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    invoke-virtual {v0, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->K:Ljava/lang/String;

    .line 330
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->K:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " : "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->a(Ljava/lang/String;)V

    .line 331
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

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

    .line 332
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->D:Ljava/lang/String;

    invoke-virtual {p2, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 362
    :goto_0
    return-void

    .line 334
    :cond_1
    new-instance v1, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    invoke-direct {v1, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 335
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v4, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 336
    invoke-virtual {v1, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 337
    invoke-virtual {v1, v5}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 338
    invoke-virtual {v1, v3, v3, v3, v3}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 339
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a:Landroid/view/LayoutInflater;

    const v2, 0x7f0300b8

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    .line 340
    const v0, 0x7f0c02f3

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 341
    const v0, 0x7f0c02f2

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v3, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;

    invoke-direct {v3, p0, p1, p2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$4;-><init>(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/lang/String;Ljava/lang/String;)V

    invoke-virtual {v0, v3}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 359
    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 360
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 361
    invoke-virtual {v1, p2}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    goto :goto_0
.end method

.method private b(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/search/Facets;",
            ">;)V"
        }
    .end annotation

    .prologue
    const v5, 0x7f08012c

    .line 471
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    .line 472
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    .line 473
    if-eqz p1, :cond_5

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 474
    invoke-virtual {p1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_5

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 475
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v2

    .line 476
    invoke-virtual {p0, v5}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_1

    const v3, 0x7f080157

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 477
    :cond_1
    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v3, :cond_2

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f08012a

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080077

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f080075

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 481
    :cond_2
    invoke-virtual {p0, v5}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_3

    .line 482
    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v3, :cond_3

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v4, 0x7f08006c

    invoke-virtual {p0, v4}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 486
    :cond_3
    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 487
    const v3, 0x7f0800f0

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 488
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->H:Z

    .line 490
    :cond_4
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getValues()Ljava/util/ArrayList;

    move-result-object v2

    .line 491
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-nez v3, :cond_0

    .line 492
    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v3, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0

    .line 496
    :cond_5
    return-void
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    return-object v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method private e()V
    .locals 3

    .prologue
    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 219
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 221
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->B:Ldj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->F:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ldj;->a(Ljava/util/ArrayList;)V

    .line 222
    return-void
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Lcom/bestbuy/android/api/lib/models/search/Sort;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    return-object v0
.end method

.method private f()V
    .locals 9

    .prologue
    const v8, 0x7f08012c

    .line 225
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 226
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v4

    .line 227
    :cond_0
    invoke-interface {v4}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_6

    .line 228
    invoke-interface {v4}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 229
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 230
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v2, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 231
    invoke-virtual {p0, v8}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_1

    const v2, 0x7f080157

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 232
    :cond_1
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v2, :cond_2

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v3, 0x7f08012a

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v3, 0x7f080077

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v3, 0x7f080075

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 236
    :cond_2
    invoke-virtual {p0, v8}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 237
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->E:Ljava/lang/String;

    const v3, 0x7f08006c

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 241
    :cond_3
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 243
    const-string v2, "category_facet"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_5

    .line 244
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->f:Lnb;

    invoke-virtual {v2}, Lnb;->P()Ljava/util/HashMap;

    move-result-object v6

    .line 245
    if-eqz v6, :cond_5

    .line 246
    invoke-virtual {v6}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v2

    .line 247
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v7

    .line 248
    :cond_4
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_5

    .line 249
    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 250
    invoke-virtual {v6, v2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Ljava/lang/String;

    .line 251
    invoke-virtual {v3, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_4

    move-object v1, v2

    .line 258
    :cond_5
    invoke-direct {p0, v0, v1}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 261
    :cond_6
    return-void
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ldn;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->w:Ldn;

    return-object v0
.end method

.method private g()V
    .locals 7

    .prologue
    .line 537
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 538
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 539
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 540
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 541
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 542
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    .line 543
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v3

    :goto_0
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 544
    iget-object v4, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

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

    .line 547
    :cond_1
    return-void
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ljava/util/List;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)Ldj;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->B:Ldj;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g()V

    return-void
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
    .line 365
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

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
    .line 369
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->t:Ljava/util/ArrayList;

    return-object v0
.end method

.method public d()Ljava/lang/String;
    .locals 1

    .prologue
    .line 550
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 114
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 115
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 103
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 104
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    .line 105
    check-cast p1, Ldm;

    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->n:Ldm;

    .line 106
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const v5, 0x7f0c0311

    const/4 v4, 0x0

    const v3, 0x7f0c0313

    const/16 v2, 0x8

    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_3

    .line 508
    invoke-direct {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g()V

    .line 509
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->q:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->entrySet()Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    .line 510
    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 511
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/Map$Entry;

    .line 512
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v1, v3}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 513
    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->J:Ljava/util/ArrayList;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v5

    invoke-virtual {v1, v5}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, " : "

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-interface {v0}, Ljava/util/Map$Entry;->getValue()Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    const-string v5, "["

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    const-string v5, "]"

    const-string v6, ""

    invoke-virtual {v4, v5, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v3, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 515
    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    invoke-interface {v0}, Ljava/util/Map$Entry;->getKey()Ljava/lang/Object;

    move-result-object v0

    invoke-virtual {v1, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->K:Ljava/lang/String;

    goto :goto_0

    .line 518
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->J:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;->a(Ljava/util/ArrayList;)V

    .line 519
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->n:Ldm;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->p:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ldm;->a(Ljava/util/ArrayList;Ljava/lang/String;)V

    .line 534
    :cond_2
    :goto_1
    return-void

    .line 521
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_2

    .line 522
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v2, :cond_4

    .line 523
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    const v1, 0x7f020020

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 524
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 525
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 526
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0012

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    goto :goto_1

    .line 528
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 529
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 530
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    const v1, 0x7f020021

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 531
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0005

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 109
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 110
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 119
    iput-object p1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a:Landroid/view/LayoutInflater;

    .line 120
    const v0, 0x7f0300bf

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    .line 121
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00bd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->i:Landroid/widget/LinearLayout;

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c030d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->j:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0310

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c030f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    if-eqz v0, :cond_0

    .line 127
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Sort;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->z:Ljava/lang/String;

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->y:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Sort;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 130
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->A:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->l:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b(Ljava/util/ArrayList;)V

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0312

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ExpandableListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v3}, Landroid/widget/ExpandableListView;->setGroupIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v3}, Landroid/widget/ExpandableListView;->setChildIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 135
    new-instance v0, Ldj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    iget-object v4, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->h:Ljava/util/HashMap;

    iget-object v5, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->D:Ljava/lang/String;

    move-object v2, p0

    invoke-direct/range {v0 .. v5}, Ldj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;Ljava/util/List;Ljava/util/Map;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->B:Ldj;

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->B:Ldj;

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->G:Ljava/lang/String;

    const-string v1, "single"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 138
    invoke-direct {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->e()V

    .line 139
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0313

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->x:Landroid/widget/ListView;

    .line 140
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->x:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$1;-><init>(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 157
    new-instance v0, Ldn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->c:Landroid/app/Activity;

    const v2, 0x7f0300c2

    iget-object v3, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->u:Ljava/util/List;

    iget-object v4, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->v:Lcom/bestbuy/android/api/lib/models/search/Sort;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/search/Sort;->getDisplayName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Ldn;-><init>(Landroid/app/Activity;ILjava/util/List;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->w:Ldn;

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->x:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->w:Ldn;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->g:Ljava/util/List;

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Facets;

    .line 160
    iget-object v2, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->I:Ljava/util/HashMap;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getFacetField()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Facets;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v3, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 163
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    new-instance v1, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$2;-><init>(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setOnChildClickListener(Landroid/widget/ExpandableListView$OnChildClickListener;)V

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->o:Landroid/widget/ExpandableListView;

    new-instance v1, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment$3;-><init>(Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setOnGroupClickListener(Landroid/widget/ExpandableListView$OnGroupClickListener;)V

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 205
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->H:Z

    if-nez v0, :cond_3

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->r:Ljava/util/HashMap;

    const-string v1, "category_facet"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 208
    :cond_3
    invoke-direct {p0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->f()V

    .line 210
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->k:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->a(Ljava/util/ArrayList;)V

    .line 214
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/search/plp/SearchPLPNarrowResultsFilterFragment;->b:Landroid/view/View;

    return-object v0
.end method
