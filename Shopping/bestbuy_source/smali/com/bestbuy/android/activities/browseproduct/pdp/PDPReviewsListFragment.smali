.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lcj;


# instance fields
.field private A:Landroid/widget/RelativeLayout;

.field private B:Landroid/widget/TextView;

.field private C:Ljava/lang/String;

.field private D:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

.field private E:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

.field private F:Landroid/widget/AdapterView$OnItemSelectedListener;

.field private G:Landroid/widget/AbsListView$OnScrollListener;

.field private a:Landroid/view/View;

.field private b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private c:Landroid/view/View;

.field private g:I

.field private h:I

.field private i:Z

.field private j:I

.field private k:I

.field private l:Landroid/widget/ListView;

.field private m:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewResults;",
            ">;"
        }
    .end annotation
.end field

.field private n:Lfb;

.field private o:Lcom/bestbuy/android/activities/stores/DialogSpinner;

.field private p:Landroid/view/View;

.field private q:Z

.field private r:Ljava/lang/String;

.field private s:Landroid/widget/LinearLayout;

.field private t:Landroid/widget/LinearLayout;

.field private u:Landroid/widget/RelativeLayout;

.field private v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

.field private w:Landroid/view/View;

.field private x:Ljava/lang/String;

.field private y:Ljava/lang/String;

.field private z:I


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 72
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 48
    const/16 v0, 0xa

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    .line 49
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    .line 51
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->j:I

    .line 52
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    .line 59
    const-string v0, "Helpfulness:desc,SubmissionTime:desc"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    .line 64
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    .line 65
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->z:I

    .line 160
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->F:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 276
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->G:Landroid/widget/AbsListView$OnScrollListener;

    .line 74
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 80
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 48
    const/16 v0, 0xa

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    .line 49
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    .line 51
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->j:I

    .line 52
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    .line 59
    const-string v0, "Helpfulness:desc,SubmissionTime:desc"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    .line 64
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    .line 65
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->z:I

    .line 160
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->F:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 276
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->G:Landroid/widget/AbsListView$OnScrollListener;

    .line 81
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 82
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 83
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 85
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 48
    const/16 v0, 0xa

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    .line 49
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    .line 51
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->j:I

    .line 52
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    .line 59
    const-string v0, "Helpfulness:desc,SubmissionTime:desc"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    .line 64
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    .line 65
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->z:I

    .line 160
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->F:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 276
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->G:Landroid/widget/AbsListView$OnScrollListener;

    .line 86
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 87
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 88
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->D:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 89
    return-void
.end method

.method public constructor <init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Ljava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 91
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 48
    const/16 v0, 0xa

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    .line 49
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    .line 51
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->j:I

    .line 52
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    .line 54
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    .line 59
    const-string v0, "Helpfulness:desc,SubmissionTime:desc"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    .line 64
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    .line 65
    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->z:I

    .line 160
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->F:Landroid/widget/AdapterView$OnItemSelectedListener;

    .line 276
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->G:Landroid/widget/AbsListView$OnScrollListener;

    .line 92
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 93
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 94
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    .line 95
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;I)I
    .locals 0

    .prologue
    .line 43
    iput p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    return p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Landroid/widget/TextView;)Landroid/widget/TextView;
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->B:Landroid/widget/TextView;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/activities/stores/DialogSpinner;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->o:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 43
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z
    .locals 0

    .prologue
    .line 43
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->q:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;I)I
    .locals 0

    .prologue
    .line 43
    iput p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->j:I

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c:Landroid/view/View;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Z)Z
    .locals 0

    .prologue
    .line 43
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->i:Z

    return p1
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    return v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    return v0
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->A:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Z
    .locals 1

    .prologue
    .line 43
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->i:Z

    return v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/ListView;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    return v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->y:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I
    .locals 1

    .prologue
    .line 43
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->z:I

    return v0
.end method

.method static synthetic n(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    return-object v0
.end method

.method static synthetic o(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)I
    .locals 2

    .prologue
    .line 43
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    return v0
.end method

.method static synthetic p(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->C:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic q(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;)Landroid/widget/TextView;
    .locals 1

    .prologue
    .line 43
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->B:Landroid/widget/TextView;

    return-object v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;)V
    .locals 4

    .prologue
    .line 250
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->A:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 251
    if-eqz p1, :cond_3

    .line 252
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    add-int/2addr v0, v1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    .line 253
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;->getNext()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->y:Ljava/lang/String;

    .line 254
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    if-nez v0, :cond_4

    .line 255
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    .line 256
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    .line 257
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 258
    new-instance v0, Lfb;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3}, Lfb;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n:Lfb;

    .line 260
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->y:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->y:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 262
    const/4 v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->z:I

    .line 264
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n:Lfb;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 269
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->y:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->y:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 270
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n:Lfb;

    invoke-virtual {v0}, Lfb;->notifyDataSetChanged()V

    .line 274
    :cond_3
    return-void

    .line 266
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpfeaturereviews/FeatureReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 267
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n:Lfb;

    invoke-virtual {v0}, Lfb;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 222
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->A:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 223
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->getTotalResults()I

    move-result v0

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    .line 224
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    if-gtz v0, :cond_3

    .line 225
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    .line 226
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    if-eqz v0, :cond_1

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->isHasErrors()Z

    move-result v0

    if-nez v0, :cond_1

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getHeaderViewsCount()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getFooterViewsCount()I

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    const/4 v1, 0x1

    if-le v0, v1, :cond_0

    .line 229
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->w:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 230
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 232
    :cond_0
    new-instance v0, Lfb;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    invoke-direct {v0, v1, v2, v3}, Lfb;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n:Lfb;

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n:Lfb;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 244
    :cond_1
    :goto_0
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->k:I

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v1}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-ne v0, v1, :cond_2

    .line 245
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 247
    :cond_2
    return-void

    .line 236
    :cond_3
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->q:Z

    if-eqz v0, :cond_4

    .line 237
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    .line 242
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->n:Lfb;

    invoke-virtual {v0}, Lfb;->notifyDataSetChanged()V

    goto :goto_0

    .line 240
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewsResponse;->getResults()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    goto :goto_1
.end method

.method public a(Ljava/lang/String;)V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 397
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    .line 398
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    if-eqz v0, :cond_0

    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_0

    .line 399
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarClearVisibility(Landroid/app/Activity;Z)V

    .line 400
    new-instance v0, Lig;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    const/4 v7, 0x0

    move-object v2, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v7}, Lig;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lig;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 417
    :goto_0
    return-void

    .line 403
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v8}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarClearVisibility(Landroid/app/Activity;Z)V

    .line 404
    new-instance v0, Lhi;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    iget v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Lhi;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;IILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhi;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 405
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    .line 406
    const-string v1, "Most Helpful"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 407
    const-string v1, "Newest"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 408
    const-string v1, "Oldest"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 409
    const-string v1, "Highest Rated"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 410
    const-string v1, "Lowest Rated"

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 411
    new-instance v1, Landroid/widget/ArrayAdapter;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    const v3, 0x7f03002c

    invoke-direct {v1, v2, v3, v0}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;ILjava/util/List;)V

    .line 412
    const v0, 0x1090009

    invoke-virtual {v1, v0}, Landroid/widget/ArrayAdapter;->setDropDownViewResource(I)V

    .line 413
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->o:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setAdapter(Landroid/widget/SpinnerAdapter;)V

    .line 414
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->o:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    const/high16 v1, -0x80000000

    invoke-virtual {v0, v1, v8}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setSelection(IZ)V

    .line 415
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->o:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->F:Landroid/widget/AdapterView$OnItemSelectedListener;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/stores/DialogSpinner;->setOnItemSelectedListener(Landroid/widget/AdapterView$OnItemSelectedListener;)V

    goto :goto_0
.end method

.method public a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;Ljava/lang/String;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;",
            ">;",
            "Landroid/widget/LinearLayout;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v0, -0x2

    const/4 v2, 0x0

    .line 309
    new-instance v3, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v3, v0, v0}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 310
    const/16 v0, 0xa

    invoke-virtual {v3, v2, v2, v2, v0}, Landroid/widget/LinearLayout$LayoutParams;->setMargins(IIII)V

    .line 311
    new-instance v4, Landroid/widget/TextView;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {v4, v0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 312
    const-string v0, "Cons"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 313
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b000d

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 317
    :cond_0
    :goto_0
    invoke-virtual {v4, p1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 318
    const/high16 v0, 0x41f00000    # 30.0f

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setTextSize(F)V

    .line 319
    invoke-virtual {v4, v3}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 320
    const/16 v0, 0xf

    invoke-virtual {v4, v2, v2, v2, v0}, Landroid/widget/TextView;->setPadding(IIII)V

    move v1, v2

    .line 321
    :goto_1
    invoke-virtual {p2}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_5

    .line 323
    new-instance v5, Landroid/widget/TextView;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getContext()Landroid/content/Context;

    move-result-object v0

    invoke-direct {v5, v0}, Landroid/widget/TextView;-><init>(Landroid/content/Context;)V

    .line 324
    const-string v0, "UnClicked"

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 325
    const/high16 v0, 0x41700000    # 15.0f

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTextSize(F)V

    .line 326
    invoke-virtual {p4}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getFeature()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0, p4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 327
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v6, 0x7f0b0063

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 328
    const v0, 0x7f0201b0

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setBackgroundResource(I)V

    .line 329
    const-string v0, "Clicked"

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTag(Ljava/lang/Object;)V

    .line 330
    iput-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->B:Landroid/widget/TextView;

    .line 335
    :goto_2
    invoke-virtual {v5, v3}, Landroid/widget/TextView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 336
    invoke-virtual {v5, v1}, Landroid/widget/TextView;->setId(I)V

    .line 337
    const-string v0, "Cons"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 338
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getFeature()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, " ("

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getNegativeReviewsMentioned()I

    move-result v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ")"

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 343
    :cond_1
    :goto_3
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;

    invoke-direct {v0, p0, p1, v5, p2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;Ljava/lang/String;Landroid/widget/TextView;Ljava/util/ArrayList;)V

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 384
    invoke-virtual {p3, v5}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 321
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_1

    .line 314
    :cond_2
    const-string v0, "Pros"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 315
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0b0007

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v4, v0}, Landroid/widget/TextView;->setTextColor(I)V

    goto/16 :goto_0

    .line 332
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v6, 0x7f0b0031

    invoke-virtual {v0, v6}, Landroid/content/res/Resources;->getColor(I)I

    move-result v0

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setTextColor(I)V

    .line 333
    const v0, 0x7f0201b1

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setBackgroundResource(I)V

    goto/16 :goto_2

    .line 339
    :cond_4
    const-string v0, "Pros"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 340
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getFeature()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, " ("

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {p2, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/ReviewFeaturesDetails;->getPositiveReviewsMentioned()I

    move-result v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ")"

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto/16 :goto_3

    .line 386
    :cond_5
    invoke-virtual {p3, v4, v2}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 387
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 391
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->e()Z

    .line 392
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-direct {v1, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;)V

    .line 393
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 394
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 107
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 108
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 109
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnClearReviewsListener(Lcj;)V

    .line 110
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1

    .prologue
    .line 99
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 100
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    .line 103
    check-cast p1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v0, "Ratings & Reviews"

    invoke-virtual {p1, v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 104
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 113
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 114
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 115
    if-eqz v0, :cond_0

    .line 116
    const-string v1, "BreadCrumb"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->C:Ljava/lang/String;

    .line 117
    const-string v1, "PDPOverviewResponseRoot"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->E:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    .line 119
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 123
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    if-nez v0, :cond_3

    .line 124
    const v0, 0x7f0300b0

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    .line 125
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c:Landroid/view/View;

    .line 126
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    const v1, 0x7f0c02bb

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    .line 127
    const v0, 0x7f0300d9

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->p:Landroid/view/View;

    .line 128
    const v0, 0x7f03003c

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->w:Landroid/view/View;

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->w:Landroid/view/View;

    const v1, 0x7f0c00fc

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->u:Landroid/widget/RelativeLayout;

    .line 130
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->w:Landroid/view/View;

    const v1, 0x7f0c00fe

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->A:Landroid/widget/RelativeLayout;

    .line 131
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->w:Landroid/view/View;

    const v1, 0x7f0c0100

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/stores/DialogSpinner;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->o:Lcom/bestbuy/android/activities/stores/DialogSpinner;

    .line 132
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->G:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 134
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Ljava/lang/String;)V

    .line 136
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    if-eqz v0, :cond_2

    .line 137
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->u:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 138
    const v0, 0x7f0300d4

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v1

    .line 139
    const v0, 0x7f0c034c

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->s:Landroid/widget/LinearLayout;

    .line 140
    const v0, 0x7f0c034d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->t:Landroid/widget/LinearLayout;

    .line 141
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->u:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->addView(Landroid/view/View;)V

    .line 142
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getBestFeatures()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getBestFeatures()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_0

    .line 144
    const-string v0, "Pros"

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getBestFeatures()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->s:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;Ljava/lang/String;)V

    .line 147
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getWorstFeatures()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getWorstFeatures()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_1

    .line 149
    const-string v0, "Cons"

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;->getWorstFeatures()Ljava/util/ArrayList;

    move-result-object v1

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->t:Landroid/widget/LinearLayout;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    invoke-virtual {p0, v0, v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a(Ljava/lang/String;Ljava/util/ArrayList;Landroid/widget/LinearLayout;Ljava/lang/String;)V

    .line 151
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->w:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 157
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    return-object v0

    .line 153
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->u:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto :goto_0

    .line 156
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 205
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 206
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 207
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarClearVisibility(Landroid/app/Activity;Z)V

    .line 208
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->D:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_0

    .line 209
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->D:Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->E:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->C:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;Ljava/lang/String;)V

    .line 211
    :cond_0
    return-void
.end method

.method public onResume()V
    .locals 9

    .prologue
    const/4 v8, 0x0

    .line 190
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Ratings & Reviews"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 193
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 194
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 195
    new-instance v0, Lig;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->v:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->x:Ljava/lang/String;

    iget v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    const/4 v7, 0x0

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Lig;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;ILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lig;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 202
    :cond_0
    :goto_0
    return-void

    .line 198
    :cond_1
    new-instance v0, Lhi;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->c:Landroid/view/View;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    iget v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->g:I

    iget v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->h:I

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPReviewsListFragment;->r:Ljava/lang/String;

    move-object v2, p0

    invoke-direct/range {v0 .. v7}, Lhi;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;IILjava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v8, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhi;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method
