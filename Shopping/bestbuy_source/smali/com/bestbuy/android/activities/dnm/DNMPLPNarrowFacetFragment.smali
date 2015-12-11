.class public Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;


# instance fields
.field private A:Ljava/lang/String;

.field private B:D

.field private C:D

.field private D:I

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

.field private a:Landroid/view/LayoutInflater;

.field private b:Landroid/view/View;

.field private c:Landroid/app/Activity;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/RelativeLayout;

.field private i:Landroid/widget/ExpandableListView;

.field private j:Landroid/widget/ListView;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private l:Landroid/widget/RelativeLayout;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private n:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;>;"
        }
    .end annotation
.end field

.field private o:Lfe;

.field private p:Lfj;

.field private q:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;"
        }
    .end annotation
.end field

.field private r:Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

.field private s:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private t:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private u:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;>;"
        }
    .end annotation
.end field

.field private v:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private w:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private x:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private y:Ljava/lang/String;

.field private z:Lcb;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->v:Ljava/util/ArrayList;

    .line 71
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->F:Ljava/util/ArrayList;

    .line 75
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Ljava/util/ArrayList;Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            "Ljava/lang/String;",
            "DDI",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 80
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 42
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    .line 50
    new-instance v0, Ljava/util/ArrayList;

    const/16 v1, 0xa

    invoke-direct {v0, v1}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    .line 59
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->v:Ljava/util/ArrayList;

    .line 71
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->F:Ljava/util/ArrayList;

    .line 81
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->s:Ljava/util/ArrayList;

    .line 82
    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->t:Ljava/util/ArrayList;

    .line 83
    iput-object p3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->q:Ljava/util/ArrayList;

    .line 84
    iput-object p5, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->r:Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    .line 85
    iput-object p6, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->A:Ljava/lang/String;

    .line 86
    iput-wide p7, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->B:D

    .line 87
    iput-wide p9, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->C:D

    .line 88
    iput p11, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->D:I

    .line 89
    iput-object p12, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->E:Ljava/lang/String;

    .line 90
    iput-object p4, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->x:Ljava/util/ArrayList;

    .line 91
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->y:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->q:Ljava/util/ArrayList;

    return-object v0
.end method

.method private a(ILcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v1

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v0, v1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 212
    if-eqz v0, :cond_0

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 213
    const/4 v2, 0x0

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    invoke-direct {p0, v1, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    .line 214
    :cond_0
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 215
    invoke-interface {v0, p2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 216
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v2, v1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->size()I

    move-result v0

    if-lt v0, v4, :cond_1

    .line 218
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->z:Lcb;

    invoke-interface {v0, v4}, Lcb;->a(Z)V

    .line 219
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    const v3, -0xff9855

    invoke-direct {v2, v3}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 221
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 223
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->o:Lfe;

    invoke-virtual {v0}, Lfe;->a()V

    .line 224
    invoke-direct {p0, v1, p2}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    .line 225
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;ILcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(ILcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0, p1, p2}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    return-void
.end method

.method private a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 5

    .prologue
    .line 228
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 230
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_1

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 231
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 232
    invoke-interface {v0, v1}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    goto :goto_0

    .line 234
    :cond_1
    if-eqz v0, :cond_2

    invoke-interface {v0}, Ljava/util/List;->isEmpty()Z

    move-result v1

    if-eqz v1, :cond_3

    .line 235
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 238
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 239
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    new-instance v1, Landroid/graphics/drawable/ColorDrawable;

    const v2, -0xff9855

    invoke-direct {v1, v2}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackground(Landroid/graphics/drawable/Drawable;)V

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 241
    return-void

    .line 237
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v1, p1, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lcom/bestbuy/android/bbyobjects/BBYTextView;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    return-object v0
.end method

.method private b(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 6

    .prologue
    const/4 v5, 0x0

    const/4 v3, -0x2

    .line 244
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0, p2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 245
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v1

    .line 246
    new-instance v2, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c:Landroid/app/Activity;

    invoke-direct {v2, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 247
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v0, v3, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 248
    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 249
    invoke-virtual {v2, v5}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a:Landroid/view/LayoutInflater;

    const v3, 0x7f0300b8

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 251
    const v0, 0x7f0c02f3

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 252
    const v0, 0x7f0c02f2

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;

    invoke-direct {v1, p0, p1, p2}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$4;-><init>(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 263
    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 264
    invoke-virtual {p2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFilterQuery()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    .line 265
    new-instance v0, Landroid/view/View;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/view/View;-><init>(Landroid/content/Context;)V

    .line 266
    new-instance v1, Landroid/widget/RelativeLayout$LayoutParams;

    const/16 v3, 0xb

    const/4 v4, 0x1

    invoke-direct {v1, v3, v4}, Landroid/widget/RelativeLayout$LayoutParams;-><init>(II)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 267
    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 268
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 269
    return-void
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->l:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method private d()V
    .locals 4

    .prologue
    .line 272
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->x:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :cond_0
    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 273
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFacetTitle()Ljava/lang/String;

    move-result-object v1

    const-string v3, "Discount Type"

    invoke-virtual {v1, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 274
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->z:Lcb;

    const/4 v3, 0x1

    invoke-interface {v1, v3}, Lcb;->a(Z)V

    .line 275
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFacetTitle()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1, v0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    .line 276
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFacetTitle()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v3}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/ArrayList;

    .line 277
    if-eqz v1, :cond_1

    invoke-virtual {v1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 278
    :cond_1
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 280
    :cond_2
    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 281
    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getFacetTitle()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 284
    :cond_3
    return-void
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->r:Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    return-object v0
.end method

.method private e()V
    .locals 4

    .prologue
    .line 287
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 288
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 289
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 290
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 291
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 292
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    invoke-interface {v2, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 293
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_0

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 294
    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v3, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 297
    :cond_1
    return-void
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lfj;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->p:Lfj;

    return-object v0
.end method

.method private f()V
    .locals 15

    .prologue
    const/16 v3, 0xa

    const/4 v4, 0x0

    .line 324
    new-instance v7, Ljava/util/HashMap;

    invoke-direct {v7}, Ljava/util/HashMap;-><init>()V

    .line 325
    new-instance v8, Ljava/util/HashMap;

    invoke-direct {v8}, Ljava/util/HashMap;-><init>()V

    .line 326
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0, v3}, Ljava/util/ArrayList;-><init>(I)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    move v0, v4

    .line 327
    :goto_0
    if-ge v0, v3, :cond_0

    .line 328
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    new-instance v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;-><init>()V

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 327
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 330
    :cond_0
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->w:Ljava/util/Map;

    .line 331
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 332
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 333
    new-instance v3, Ljava/util/HashSet;

    invoke-direct {v3}, Ljava/util/HashSet;-><init>()V

    .line 334
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->s:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 336
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v8, v6, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 337
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getFilters()Ljava/util/ArrayList;

    move-result-object v9

    invoke-interface {v1, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 338
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 341
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->t:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    .line 342
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 343
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-interface {v7, v6, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 344
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getFilters()Ljava/util/ArrayList;

    move-result-object v9

    invoke-interface {v2, v6, v9}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 345
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v0

    invoke-interface {v3, v0}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    goto :goto_2

    .line 348
    :cond_2
    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v9

    .line 349
    invoke-interface {v3}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v10

    .line 350
    :goto_3
    invoke-interface {v10}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_a

    .line 351
    invoke-interface {v10}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 352
    invoke-interface {v9, v0}, Ljava/util/Set;->contains(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 353
    invoke-interface {v7, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 354
    invoke-interface {v8, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 355
    if-nez v1, :cond_4

    .line 356
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getFilters()Ljava/util/ArrayList;

    move-result-object v1

    .line 357
    invoke-virtual {v1}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_4
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 358
    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->w:Ljava/util/Map;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v3, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_4

    .line 359
    :cond_3
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getIndex()I

    move-result v2

    invoke-virtual {v1, v2, v0}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 362
    :cond_4
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getFilters()Ljava/util/ArrayList;

    move-result-object v11

    .line 363
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getFilters()Ljava/util/ArrayList;

    move-result-object v12

    move v3, v4

    .line 364
    :goto_5
    invoke-virtual {v12}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ge v3, v1, :cond_8

    .line 366
    invoke-virtual {v12, v3}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    move v5, v4

    move v6, v4

    .line 367
    :goto_6
    invoke-virtual {v11}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-ge v5, v2, :cond_6

    .line 368
    invoke-virtual {v11, v5}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 369
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v13, v14}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v13

    if-eqz v13, :cond_5

    .line 370
    invoke-virtual {v12, v3, v2}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    .line 371
    const/4 v6, 0x1

    .line 367
    :cond_5
    add-int/lit8 v2, v5, 0x1

    move v5, v2

    goto :goto_6

    .line 374
    :cond_6
    if-nez v6, :cond_7

    .line 376
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->w:Ljava/util/Map;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 364
    :cond_7
    add-int/lit8 v1, v3, 0x1

    move v3, v1

    goto :goto_5

    .line 379
    :cond_8
    invoke-virtual {v0, v12}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->setFilters(Ljava/util/ArrayList;)V

    .line 380
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getIndex()I

    move-result v2

    invoke-virtual {v1, v2, v0}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 382
    :cond_9
    invoke-interface {v7, v0}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 383
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    invoke-interface {v9}, Ljava/util/Set;->size()I

    move-result v2

    invoke-virtual {v1, v2, v0}, Ljava/util/ArrayList;->set(ILjava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 386
    :cond_a
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 387
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_b
    :goto_7
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_c

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 388
    if-eqz v0, :cond_b

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_b

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_b

    .line 389
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    goto :goto_7

    .line 391
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 392
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->s:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 393
    return-void
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Lfe;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->o:Lfe;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->e()V

    return-void
.end method


# virtual methods
.method public b()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/util/List",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->u:Ljava/util/Map;

    return-object v0
.end method

.method public c()Ljava/util/Map;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation

    .prologue
    .line 304
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->w:Ljava/util/Map;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 126
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 127
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 115
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 116
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c:Landroid/app/Activity;

    .line 117
    check-cast p1, Lcb;

    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->z:Lcb;

    .line 118
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 6

    .prologue
    const v5, 0x7f0c0311

    const/4 v4, 0x0

    const v3, 0x7f0c0313

    const/16 v2, 0x8

    .line 95
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_1

    .line 96
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->e()V

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->z:Lcb;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->v:Ljava/util/ArrayList;

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->y:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->s:Ljava/util/ArrayList;

    invoke-interface {v0, v1, v2, v3}, Lcb;->a(Ljava/util/ArrayList;Ljava/lang/String;Ljava/util/ArrayList;)V

    .line 112
    :cond_0
    :goto_0
    return-void

    .line 99
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->l:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/View;->getVisibility()I

    move-result v0

    if-ne v0, v2, :cond_2

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->l:Landroid/widget/RelativeLayout;

    const v1, 0x7f020020

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 102
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 103
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 104
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const v2, 0x7f0b0012

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    goto :goto_0

    .line 106
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    invoke-virtual {v0, v5}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->l:Landroid/widget/RelativeLayout;

    const v1, 0x7f020021

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setBackgroundResource(I)V

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c:Landroid/app/Activity;

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
    .line 121
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 122
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const/4 v2, 0x0

    .line 131
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->a:Landroid/view/LayoutInflater;

    .line 132
    const v0, 0x7f0300bf

    invoke-virtual {p1, v0, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    .line 133
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00bd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->g:Landroid/widget/LinearLayout;

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    const v1, 0x7f0c030d

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    .line 135
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->h:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->setClickable(Z)V

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0310

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    const v1, 0x7f0c030f

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->l:Landroid/widget/RelativeLayout;

    .line 138
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->f()V

    .line 139
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    .line 140
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->n:Ljava/util/Map;

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;

    .line 142
    if-eqz v0, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v2

    if-eqz v2, :cond_0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 143
    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->n:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getName()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;->getFilters()Ljava/util/ArrayList;

    move-result-object v0

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0

    .line 148
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->r:Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    if-eqz v0, :cond_2

    .line 149
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->r:Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getValue()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->y:Ljava/lang/String;

    .line 150
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->r:Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 152
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->l:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0312

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ExpandableListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->i:Landroid/widget/ExpandableListView;

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->i:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v4}, Landroid/widget/ExpandableListView;->setGroupIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 155
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->i:Landroid/widget/ExpandableListView;

    invoke-virtual {v0, v4}, Landroid/widget/ExpandableListView;->setChildIndicator(Landroid/graphics/drawable/Drawable;)V

    .line 156
    new-instance v0, Lfe;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->m:Ljava/util/ArrayList;

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->n:Ljava/util/Map;

    invoke-direct {v0, v1, p0, v2, v3}, Lfe;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;Ljava/util/ArrayList;Ljava/util/Map;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->o:Lfe;

    .line 157
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->i:Landroid/widget/ExpandableListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->o:Lfe;

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setAdapter(Landroid/widget/ExpandableListAdapter;)V

    .line 158
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    const v1, 0x7f0c0313

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->j:Landroid/widget/ListView;

    .line 159
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->j:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$1;-><init>(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 173
    new-instance v0, Lfj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->c:Landroid/app/Activity;

    const v2, 0x7f0300c2

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->q:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->r:Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;->getDisplayName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v1, v2, v3, v4}, Lfj;-><init>(Landroid/app/Activity;ILjava/util/List;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->p:Lfj;

    .line 174
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->j:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->p:Lfj;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 175
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->i:Landroid/widget/ExpandableListView;

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$2;-><init>(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setOnChildClickListener(Landroid/widget/ExpandableListView$OnChildClickListener;)V

    .line 195
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->i:Landroid/widget/ExpandableListView;

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment$3;-><init>(Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ExpandableListView;->setOnGroupClickListener(Landroid/widget/ExpandableListView$OnGroupClickListener;)V

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->x:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->x:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 204
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->d()V

    .line 206
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMPLPNarrowFacetFragment;->b:Landroid/view/View;

    return-object v0
.end method
