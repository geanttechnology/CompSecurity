.class public Lcom/bestbuy/android/activities/dnm/DNMListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcd;


# instance fields
.field private A:Landroid/widget/RelativeLayout;

.field private B:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

.field private C:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacet;",
            ">;"
        }
    .end annotation
.end field

.field private D:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMSortOption;",
            ">;"
        }
    .end annotation
.end field

.field private E:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private F:Ljava/lang/String;

.field private G:I

.field private H:Landroid/widget/RelativeLayout;

.field private I:Ljava/lang/String;

.field private J:Landroid/widget/LinearLayout;

.field private K:Landroid/widget/RelativeLayout;

.field private L:Landroid/widget/LinearLayout;

.field private M:Landroid/view/LayoutInflater;

.field private N:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private O:Landroid/widget/AbsListView$OnScrollListener;

.field private a:Landroid/app/Activity;

.field private b:Landroid/view/View;

.field private c:Ljava/lang/String;

.field private g:Landroid/widget/ImageView;

.field private h:D

.field private i:D

.field private j:Landroid/view/View;

.field private k:I

.field private l:Ljava/lang/String;

.field private m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private o:Landroid/widget/LinearLayout;

.field private p:Landroid/widget/EditText;

.field private q:Landroid/widget/ListView;

.field private r:Lfh;

.field private s:Landroid/view/View;

.field private t:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field

.field private u:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;",
            ">;"
        }
    .end annotation
.end field

.field private v:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private w:Z

.field private x:I

.field private y:Ljava/lang/String;

.field private z:I


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 87
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    iput v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    .line 66
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->v:Ljava/util/ArrayList;

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->w:Z

    .line 68
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->x:I

    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    .line 74
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    .line 75
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    .line 76
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    .line 77
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->G:I

    .line 318
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;-><init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->O:Landroid/widget/AbsListView$OnScrollListener;

    .line 89
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;DDLjava/lang/String;)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 95
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    iput v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    .line 66
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->v:Ljava/util/ArrayList;

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->w:Z

    .line 68
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->x:I

    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    .line 74
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    .line 75
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    .line 76
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    .line 77
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->G:I

    .line 318
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;-><init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->O:Landroid/widget/AbsListView$OnScrollListener;

    .line 96
    iput-object p6, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    .line 97
    iput-wide p2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    .line 98
    iput-wide p4, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    .line 99
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->l:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3

    .prologue
    const/4 v2, 0x1

    const/4 v1, 0x0

    .line 102
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    iput v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    .line 64
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    .line 65
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    .line 66
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->v:Ljava/util/ArrayList;

    .line 67
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->w:Z

    .line 68
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->x:I

    .line 73
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    .line 74
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    .line 75
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    .line 76
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    .line 77
    iput v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->G:I

    .line 318
    new-instance v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment$3;-><init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->O:Landroid/widget/AbsListView$OnScrollListener;

    .line 103
    iput-object p3, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    .line 104
    iput-object p2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    .line 105
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->l:Ljava/lang/String;

    .line 106
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;I)I
    .locals 0

    .prologue
    .line 46
    iput p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->x:I

    return p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b(Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 46
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b(Ljava/lang/String;)V

    return-void
.end method

.method private a(Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 7

    .prologue
    const/16 v6, 0xa

    const/4 v5, 0x0

    .line 364
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;->getDisplayText()Ljava/lang/String;

    move-result-object v1

    .line 365
    new-instance v2, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    invoke-direct {v2, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 366
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v3, -0x1

    const/4 v4, -0x2

    invoke-direct {v0, v3, v4}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 367
    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 368
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 369
    invoke-virtual {v2, v6, v5, v5, v6}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 370
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->M:Landroid/view/LayoutInflater;

    const v3, 0x7f0300b8

    const/4 v4, 0x0

    invoke-virtual {v0, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 371
    const v0, 0x7f0c02f3

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 372
    const v0, 0x7f0c02f2

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMListFragment$4;

    invoke-direct {v1, p0, p1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment$4;-><init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 379
    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 380
    invoke-virtual {v2, p1}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    .line 381
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->L:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 382
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/dnm/DNMListFragment;Z)Z
    .locals 0

    .prologue
    .line 46
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->w:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/dnm/DNMListFragment;I)I
    .locals 0

    .prologue
    .line 46
    iput p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    const v2, 0x7f080079

    .line 179
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00c4

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 180
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00c5

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 181
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->g:Landroid/widget/ImageView;

    .line 182
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00c3

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->o:Landroid/widget/LinearLayout;

    .line 183
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00c6

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/EditText;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->p:Landroid/widget/EditText;

    .line 184
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->p:Landroid/widget/EditText;

    new-instance v1, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment$2;-><init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setOnEditorActionListener(Landroid/widget/TextView$OnEditorActionListener;)V

    .line 202
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v1, 0x7f0c00c1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->H:Landroid/widget/RelativeLayout;

    .line 203
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->H:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 204
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    const v1, 0x7f08006c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 205
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->g:Landroid/widget/ImageView;

    const v1, 0x7f020133

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 208
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->l:Ljava/lang/String;

    const v1, 0x7f080156

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 209
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->l:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 212
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 217
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 220
    return-void

    .line 207
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->g:Landroid/widget/ImageView;

    const v1, 0x7f02007a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto :goto_0

    .line 211
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->l:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_1
.end method

.method private b(Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V
    .locals 19

    .prologue
    .line 385
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->K:Landroid/widget/RelativeLayout;

    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 386
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setVisibility(I)V

    .line 387
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    move-object/from16 v0, p1

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 388
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->L:Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->L:Landroid/widget/LinearLayout;

    move-object/from16 v0, p1

    invoke-virtual {v3, v0}, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 389
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget v13, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    const/16 v14, 0x14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v5, p0

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 390
    return-void
.end method

.method private b(Ljava/lang/String;)V
    .locals 6

    .prologue
    .line 292
    new-instance v0, Lip;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    iget-object v5, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->J:Landroid/widget/LinearLayout;

    move-object v2, p0

    move-object v4, p1

    invoke-direct/range {v0 .. v5}, Lip;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Landroid/widget/LinearLayout;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lip;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 293
    return-void
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    return-object v0
.end method

.method private c()V
    .locals 19

    .prologue
    .line 304
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 305
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 306
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    .line 307
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    if-eqz v2, :cond_0

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_0

    .line 308
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 309
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    if-eqz v2, :cond_1

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 310
    const-string v2, ""

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    .line 311
    :cond_1
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    if-eqz v2, :cond_2

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_2

    .line 312
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 313
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    if-eqz v2, :cond_3

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_3

    .line 314
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 315
    :cond_3
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget v13, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    const/16 v14, 0x14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v5, p0

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 316
    return-void
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)D
    .locals 2

    .prologue
    .line 46
    iget-wide v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    return-wide v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)D
    .locals 2

    .prologue
    .line 46
    iget-wide v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    return-wide v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/widget/EditText;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->p:Landroid/widget/EditText;

    return-object v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Landroid/widget/LinearLayout;
    .locals 1

    .prologue
    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->o:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)Z
    .locals 1

    .prologue
    .line 46
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->w:Z

    return v0
.end method

.method static synthetic n(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->x:I

    return v0
.end method

.method static synthetic o(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->G:I

    return v0
.end method

.method static synthetic p(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->z:I

    return v0
.end method

.method static synthetic q(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)I
    .locals 1

    .prologue
    .line 46
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    return v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;)V
    .locals 11

    .prologue
    const v10, 0x7f0c0304

    const v9, 0x7f0c0303

    const/4 v8, 0x1

    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 223
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->B:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    .line 224
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getTotalCount()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->z:I

    .line 225
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->z:I

    if-nez v0, :cond_1

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->A:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->K:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 228
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    const v1, 0x7f08012a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->N:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "There are no Clearance items in this area. \nPlease try another."

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 231
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    invoke-virtual {v0, v7}, Landroid/widget/ListView;->setVisibility(I)V

    .line 232
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->L:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    if-eqz v0, :cond_7

    .line 234
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_7

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;

    .line 235
    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;)V

    goto :goto_0

    .line 239
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->A:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 240
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->K:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    invoke-virtual {v0, v6}, Landroid/widget/ListView;->setVisibility(I)V

    .line 242
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 243
    :cond_2
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getFacetsFilters()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    .line 244
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 245
    :cond_4
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getSortOptions()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    .line 246
    :cond_5
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    if-gt v0, v8, :cond_9

    .line 247
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 248
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 249
    iput-boolean v8, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->w:Z

    .line 250
    iput v6, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->x:I

    .line 251
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-nez v0, :cond_8

    .line 252
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->A:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->K:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    invoke-virtual {v0, v7}, Landroid/widget/ListView;->setVisibility(I)V

    .line 276
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->O:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 277
    iget v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->z:I

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_7

    .line 278
    iput v6, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->G:I

    .line 279
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 280
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 281
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->A:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->getVisibility()I

    move-result v0

    if-eqz v0, :cond_6

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 283
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v8, :cond_7

    .line 284
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v9}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/View;->setVisibility(I)V

    .line 285
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    invoke-virtual {v0, v10}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 289
    :cond_7
    return-void

    .line 256
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 259
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProductSkus()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v6}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 263
    iput v8, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->G:I

    .line 264
    new-instance v0, Lfh;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    const v2, 0x7f0300bb

    iget-object v3, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    iget-object v4, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    iget-object v5, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->f:Lnb;

    invoke-direct/range {v0 .. v5}, Lfh;-><init>(Landroid/content/Context;ILjava/util/ArrayList;Ljava/util/ArrayList;Lnb;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->r:Lfh;

    .line 265
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->r:Lfh;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    goto/16 :goto_1

    .line 268
    :cond_9
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProducts()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 269
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->t:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 270
    :cond_a
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_b

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->u:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getDnmProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 272
    :cond_b
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProductSkus()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_c

    .line 273
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->v:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;->getProductSkus()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 274
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->r:Lfh;

    invoke-virtual {v0}, Lfh;->notifyDataSetChanged()V

    goto/16 :goto_1
.end method

.method public a(Ljava/lang/String;)V
    .locals 19

    .prologue
    .line 433
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    .line 434
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    .line 435
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget v13, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    const/16 v14, 0x14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v5, p0

    move-object/from16 v18, p1

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 436
    return-void
.end method

.method public a(Ljava/lang/String;Landroid/location/Address;)V
    .locals 3

    .prologue
    .line 296
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    .line 297
    invoke-virtual {p2}, Landroid/location/Address;->getLatitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    .line 298
    invoke-virtual {p2}, Landroid/location/Address;->getLongitude()D

    move-result-wide v0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->m:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Results for \""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "\""

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 300
    invoke-direct {p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c()V

    .line 301
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 121
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 122
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 123
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 124
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 125
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 19

    .prologue
    .line 339
    invoke-super/range {p0 .. p3}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 340
    if-eqz p3, :cond_0

    .line 341
    const-string v2, "CLEAR_ALL"

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 342
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->clear()V

    .line 343
    const-string v2, ""

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    .line 344
    invoke-direct/range {p0 .. p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c()V

    .line 361
    :cond_0
    :goto_0
    return-void

    .line 346
    :cond_1
    const-string v2, "SELECTED_FACETS"

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 347
    const-string v2, "SELECTED_FACETS"

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getSerializableExtra(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v2

    check-cast v2, Ljava/util/ArrayList;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    .line 349
    :cond_2
    const-string v2, "SORT_ORDER"

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 350
    const-string v2, "SORT_ORDER"

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    .line 351
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    const-string v3, "rating"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 352
    const-string v2, ""

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    .line 354
    :cond_3
    const-string v2, "BASE_FACETS"

    move-object/from16 v0, p3

    invoke-virtual {v0, v2}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 357
    :cond_4
    const/4 v2, 0x1

    move-object/from16 v0, p0

    iput v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    .line 358
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget v13, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    const/16 v14, 0x14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v5, p0

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 109
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 110
    iput-object p1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    .line 111
    check-cast p1, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1, p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnDNMSearchListener(Lcd;)V

    .line 112
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 7

    .prologue
    const v6, 0x7f04000e

    const v5, 0x7f040005

    const/4 v2, 0x0

    const/16 v1, 0x8

    .line 394
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->n:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_2

    .line 395
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->p:Landroid/widget/EditText;

    invoke-virtual {v0}, Landroid/widget/EditText;->getVisibility()I

    move-result v0

    if-ne v0, v1, :cond_1

    .line 396
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->p:Landroid/widget/EditText;

    invoke-virtual {v0, v2}, Landroid/widget/EditText;->setVisibility(I)V

    .line 397
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->o:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 429
    :cond_0
    :goto_0
    return-void

    .line 399
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->p:Landroid/widget/EditText;

    invoke-virtual {v0, v1}, Landroid/widget/EditText;->setVisibility(I)V

    .line 400
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->o:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_0

    .line 402
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->A:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_3

    .line 403
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/dnm/DNMPLPFacetAndFilterActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 404
    const-string v1, "DNM_RESPONSE"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->B:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 405
    const-string v1, "DNM_BASE_FACETS"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->C:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 406
    const-string v1, "DNM_BASE_SORTOPTIONS"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->D:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 407
    const-string v1, "STORE_ID"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 408
    const-string v1, "LAT"

    iget-wide v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;D)Landroid/content/Intent;

    .line 409
    const-string v1, "LNG"

    iget-wide v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;D)Landroid/content/Intent;

    .line 410
    const-string v1, "RADIUS"

    const/16 v2, 0x32

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;I)Landroid/content/Intent;

    .line 411
    const-string v1, "DNM_TYPE"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 412
    const-string v1, "SELECTED_SORT_OPTION"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 413
    const-string v1, "SELECTED_FACETS"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 414
    const-string v1, "SEARCH_QUERY"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 415
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    const/16 v2, 0x115c

    invoke-virtual {v1, v0, v2}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 416
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v0, v6, v5}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto :goto_0

    .line 417
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->H:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_0

    .line 418
    new-instance v1, Landroid/content/Intent;

    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 419
    const-string v0, ""

    .line 420
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    const-string v2, "OpenBox"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 421
    const v0, 0x7f08029d

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 424
    :goto_1
    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "file:///android_asset/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v1, v2, v0}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 425
    const-string v0, "DNM_TYPE"

    iget-object v2, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 426
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 427
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v0, v6, v5}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto/16 :goto_0

    .line 423
    :cond_4
    const v0, 0x7f08029c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_1
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 116
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 117
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 19

    .prologue
    .line 129
    move-object/from16 v0, p1

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->M:Landroid/view/LayoutInflater;

    .line 130
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    if-nez v2, :cond_0

    .line 131
    const v2, 0x7f03002f

    const/4 v3, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v2, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    .line 132
    const v2, 0x7f030030

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    const/4 v4, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v3

    .line 133
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v4, 0x7f0c0064

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    .line 134
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v4, 0x7f0c00b9

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->K:Landroid/widget/RelativeLayout;

    .line 135
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v4, 0x7f0c00bb

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->N:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 136
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v4, 0x7f0c00bd

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->L:Landroid/widget/LinearLayout;

    .line 137
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v4, 0x7f0c00c0

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->J:Landroid/widget/LinearLayout;

    .line 138
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v4, 0x7f0c00b8

    invoke-virtual {v2, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ListView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    .line 139
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 140
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    const v3, 0x7f0c00be

    invoke-virtual {v2, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->A:Landroid/widget/RelativeLayout;

    .line 141
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->A:Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    invoke-virtual {v2, v0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->O:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 143
    const v2, 0x7f0300bc

    const/4 v3, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->s:Landroid/view/View;

    .line 144
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget v13, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    const/16 v14, 0x14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v5, p0

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 145
    invoke-direct/range {p0 .. p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b()V

    .line 149
    :goto_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->q:Landroid/widget/ListView;

    new-instance v3, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment$1;-><init>(Lcom/bestbuy/android/activities/dnm/DNMListFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 164
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    return-object v2

    .line 147
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    invoke-virtual {v2}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->b:Landroid/view/View;

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 4

    .prologue
    .line 449
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 450
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    const/4 v2, 0x1

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V

    .line 451
    return-void
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 440
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 441
    iget-object v0, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    const-string v1, "input_method"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 442
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 443
    iget-object v1, p0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 445
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 19

    .prologue
    .line 169
    invoke-super/range {p0 .. p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 170
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    check-cast v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v3, ""

    invoke-virtual {v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 171
    invoke-virtual/range {p0 .. p0}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->l()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 172
    new-instance v3, Liq;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a:Landroid/app/Activity;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->j:Landroid/view/View;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->y:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-wide v8, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->h:D

    move-object/from16 v0, p0

    iget-wide v10, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->i:D

    const/16 v12, 0x32

    move-object/from16 v0, p0

    iget v13, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->k:I

    const/16 v14, 0x14

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->c:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->E:Ljava/util/ArrayList;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->F:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->I:Ljava/lang/String;

    move-object/from16 v18, v0

    move-object/from16 v5, p0

    invoke-direct/range {v3 .. v18}, Liq;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/Void;

    invoke-virtual {v3, v2, v4}, Liq;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 174
    :cond_0
    return-void
.end method
