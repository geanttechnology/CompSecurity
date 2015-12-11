.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Landroid/view/View$OnClickListener;
.implements Lci;
.implements Lqo;
.implements Lqp;


# instance fields
.field private A:Ljava/lang/String;

.field private B:Z

.field private C:Z

.field private D:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private E:Ljava/util/Map;
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

.field private F:Ljava/lang/String;

.field private G:Lnb;

.field private H:Ljava/lang/String;

.field private I:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private J:I

.field private K:Landroid/widget/RelativeLayout;

.field private L:Landroid/widget/LinearLayout;

.field private M:Landroid/view/LayoutInflater;

.field private N:Landroid/widget/LinearLayout;

.field private O:Landroid/widget/ImageView;

.field private P:Ljava/lang/String;

.field private Q:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private R:Z

.field private S:Z

.field private T:Z

.field private U:Z

.field private V:Z

.field private W:Z

.field private X:Z

.field private Y:Z

.field private Z:Ljava/lang/String;

.field private a:Landroid/view/View;

.field private aa:Ljava/lang/String;

.field private ab:I

.field private ac:I

.field private ad:Z

.field private ae:Ljava/lang/String;

.field private af:Ljava/lang/String;

.field private ag:Z

.field private ah:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

.field private ai:Z

.field private aj:Ljava/lang/String;

.field private ak:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private al:Lqm;

.field private am:Z

.field private an:Z

.field private ao:Landroid/content/SharedPreferences;

.field private ap:Landroid/widget/RelativeLayout;

.field private aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

.field private ar:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private as:Landroid/widget/RelativeLayout;

.field private at:Lcom/bestbuy/android/bbyobjects/BBYButton;

.field private au:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private av:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private aw:Landroid/widget/LinearLayout;

.field private ax:Z

.field private ay:Landroid/widget/AbsListView$OnScrollListener;

.field private b:Landroid/widget/ListView;

.field private c:Landroid/widget/RelativeLayout;

.field private g:Ljava/lang/String;

.field private h:Ljava/lang/String;

.field private i:Landroid/view/View;

.field private j:Les;

.field private k:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
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
            "Lcom/bestbuy/android/api/lib/models/search/SortOptions;",
            ">;"
        }
    .end annotation
.end field

.field private n:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/Facet;",
            ">;"
        }
    .end annotation
.end field

.field private o:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/solr/SortOption;",
            ">;"
        }
    .end annotation
.end field

.field private p:Z

.field private q:I

.field private r:I

.field private s:J

.field private t:Z

.field private u:Ljava/lang/String;

.field private v:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

.field private w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

.field private x:Ljava/lang/String;

.field private y:Landroid/view/View;

.field private z:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 168
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 169
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/search/SearchApi;Z)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 249
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 250
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    .line 251
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 252
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    .line 253
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 171
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 172
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    .line 173
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 174
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    .line 175
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 176
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLjava/lang/String;Ljava/lang/String;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 178
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 179
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    .line 180
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 181
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    .line 182
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 183
    iput-object p5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    .line 184
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 238
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 239
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    .line 240
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    .line 241
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/lang/String;I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 255
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 256
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    .line 257
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aa:Ljava/lang/String;

    .line 258
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    .line 259
    iput p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    .line 260
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 218
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 219
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Y:Z

    .line 220
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    .line 221
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 222
    iput-object p5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    .line 223
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Z:Ljava/lang/String;

    .line 224
    iput p6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    .line 225
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 199
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 200
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 201
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    .line 202
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    .line 203
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 204
    iput-object p6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    .line 205
    iput-object p5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->H:Ljava/lang/String;

    .line 206
    iput p7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    .line 207
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 209
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 210
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 211
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    .line 212
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 213
    iput-object p5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    .line 214
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->I:Ljava/util/ArrayList;

    .line 215
    iput p6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    .line 216
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;I)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/lang/String;",
            "Ljava/util/Map",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "I)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 228
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 229
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 230
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ae:Ljava/lang/String;

    .line 231
    iput-object p5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 232
    if-eqz p3, :cond_0

    .line 233
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    invoke-interface {v0, p3}, Ljava/util/Map;->putAll(Ljava/util/Map;)V

    .line 234
    :cond_0
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    .line 235
    iput p6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    .line 236
    return-void
.end method

.method public constructor <init>(ZLjava/util/ArrayList;Ljava/lang/String;Z)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(Z",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 186
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 95
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 99
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 102
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    .line 103
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 104
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 105
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 106
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 107
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 108
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 109
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 115
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 119
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    .line 121
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 122
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    .line 127
    iput v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 133
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    .line 138
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    .line 139
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 140
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    .line 147
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 152
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 153
    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 1209
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;

    invoke-direct {v0, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$5;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    .line 187
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Q:Ljava/util/ArrayList;

    .line 188
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->R:Z

    .line 189
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    .line 190
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    .line 191
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;I)I
    .locals 0

    .prologue
    .line 92
    iput p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    return p1
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Landroid/widget/RelativeLayout;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 92
    invoke-direct {p0, p1, p2, p3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-void
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;)V
    .locals 7

    .prologue
    const/16 v4, 0xa

    const/4 v6, 0x0

    .line 744
    .line 745
    new-instance v2, Landroid/widget/LinearLayout;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-direct {v2, v0}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 746
    new-instance v0, Landroid/widget/LinearLayout$LayoutParams;

    const/4 v1, -0x1

    const/4 v3, -0x2

    invoke-direct {v0, v1, v3}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 747
    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 748
    const/4 v0, 0x1

    invoke-virtual {v2, v0}, Landroid/widget/LinearLayout;->setOrientation(I)V

    .line 749
    invoke-virtual {v2, v4, v6, v6, v4}, Landroid/widget/LinearLayout;->setPadding(IIII)V

    .line 750
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->M:Landroid/view/LayoutInflater;

    const v1, 0x7f0300b8

    const/4 v3, 0x0

    invoke-virtual {v0, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v3

    .line 751
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {v0}, Lnb;->P()Ljava/util/HashMap;

    move-result-object v4

    .line 752
    const v0, 0x7f0c02f2

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;

    invoke-direct {v1, p0, p2, v4, p1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$4;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Ljava/lang/String;Ljava/util/HashMap;Ljava/lang/String;)V

    invoke-virtual {v0, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 763
    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    .line 765
    const-string v0, "category_facet"

    invoke-virtual {p1, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 766
    if-eqz v4, :cond_1

    .line 767
    invoke-virtual {v4}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 768
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v5

    .line 769
    :cond_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 770
    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 771
    invoke-virtual {v4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 772
    invoke-virtual {v1, p2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    move-object v1, v0

    .line 779
    :goto_0
    const v0, 0x7f0c02f3

    invoke-virtual {v3, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 780
    invoke-virtual {v2, p2}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    .line 781
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->L:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2, v6}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;I)V

    .line 782
    return-void

    :cond_1
    move-object v1, p2

    goto :goto_0
.end method

.method private a(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 7

    .prologue
    const/4 v5, 0x1

    .line 785
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->L:Landroid/widget/LinearLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->L:Landroid/widget/LinearLayout;

    invoke-virtual {v1, p3}, Landroid/widget/LinearLayout;->findViewWithTag(Ljava/lang/Object;)Landroid/view/View;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->removeView(Landroid/view/View;)V

    .line 786
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 788
    :try_start_0
    const-string v1, "UTF-8"

    invoke-static {v0, v1}, Ljava/net/URLDecoder;->decode(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v0

    .line 792
    :goto_0
    if-eqz v0, :cond_4

    const-string v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_4

    .line 793
    const-string v1, "|"

    const-string v2, "&&"

    invoke-virtual {v0, v1, v2}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 794
    const-string v1, "&&"

    invoke-static {v0, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v0

    .line 795
    new-instance v2, Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Arrays;->asList([Ljava/lang/Object;)Ljava/util/List;

    move-result-object v0

    invoke-direct {v2, v0}, Ljava/util/ArrayList;-><init>(Ljava/util/Collection;)V

    .line 796
    invoke-virtual {v2, p2}, Ljava/util/ArrayList;->remove(Ljava/lang/Object;)Z

    .line 797
    if-eqz v2, :cond_0

    invoke-virtual {v2}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 798
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 820
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 821
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->K:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 822
    invoke-direct {p0, v5}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Z)V

    .line 823
    return-void

    .line 789
    :catch_0
    move-exception v1

    .line 790
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 800
    :cond_1
    const-string v0, ""

    .line 801
    invoke-virtual {v2}, Ljava/util/ArrayList;->iterator()Ljava/util/Iterator;

    move-result-object v3

    move-object v1, v0

    :goto_2
    invoke-interface {v3}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_3

    invoke-interface {v3}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 803
    :try_start_1
    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_3

    move-result-object v0

    .line 804
    :try_start_2
    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v1

    if-le v1, v5, :cond_2

    .line 805
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v4, "|"

    invoke-virtual {v1, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_1

    move-result-object v0

    :cond_2
    :goto_3
    move-object v1, v0

    .line 809
    goto :goto_2

    .line 806
    :catch_1
    move-exception v1

    .line 807
    :goto_4
    invoke-virtual {v1}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_3

    .line 811
    :cond_3
    :try_start_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    invoke-interface {v0, p1, v1}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_2

    goto :goto_1

    .line 812
    :catch_2
    move-exception v0

    .line 814
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 818
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    invoke-interface {v0, p1}, Ljava/util/Map;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 806
    :catch_3
    move-exception v0

    move-object v6, v0

    move-object v0, v1

    move-object v1, v6

    goto :goto_4
.end method

.method private a(Ljava/util/ArrayList;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v0, 0x0

    .line 694
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {v1}, Lnb;->P()Ljava/util/HashMap;

    move-result-object v3

    .line 695
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->clear()V

    .line 696
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-nez v1, :cond_0

    .line 697
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_0

    .line 698
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const-string v2, "category_facet"

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    invoke-interface {v1, v2, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 701
    :cond_0
    if-eqz p1, :cond_a

    invoke-virtual {p1}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_a

    move v2, v0

    .line 702
    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_a

    .line 703
    invoke-virtual {p1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 704
    const-string v1, "="

    invoke-static {v0, v1}, Landroid/text/TextUtils;->split(Ljava/lang/String;Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v4

    .line 706
    :try_start_0
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v5, 0x0

    aget-object v5, v4, v5

    invoke-interface {v1, v5}, Ljava/util/Map;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 707
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v5, 0x0

    aget-object v5, v4, v5

    invoke-interface {v1, v5}, Ljava/util/Map;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 708
    const-string v5, "category_facet"

    invoke-virtual {v0, v5}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 709
    const/4 v0, 0x1

    aget-object v0, v4, v0

    const-string v1, "pcmcat"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    aget-object v0, v4, v0

    const-string v1, "abcat"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    const/4 v0, 0x1

    aget-object v0, v4, v0

    const-string v1, "cat"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 710
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v1, 0x0

    aget-object v1, v4, v1

    const/4 v5, 0x1

    aget-object v4, v4, v5

    invoke-interface {v0, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 702
    :goto_1
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_0

    .line 712
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v1, 0x0

    aget-object v1, v4, v1

    const/4 v5, 0x1

    aget-object v4, v4, v5

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v0, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_1

    .line 736
    :catch_0
    move-exception v0

    .line 737
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_1

    .line 715
    :cond_3
    :try_start_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-nez v0, :cond_4

    .line 716
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/4 v1, 0x1

    aget-object v1, v4, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    .line 719
    :goto_2
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v5, 0x0

    aget-object v4, v4, v5

    invoke-interface {v1, v4, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 718
    :cond_4
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v1, "|"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const/4 v1, 0x1

    aget-object v1, v4, v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    goto :goto_2

    .line 722
    :cond_5
    const-string v1, "category_facet"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_8

    .line 723
    const/4 v0, 0x1

    aget-object v0, v4, v0

    const-string v1, "pcmcat"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    const/4 v0, 0x1

    aget-object v0, v4, v0

    const-string v1, "abcat"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_6

    const/4 v0, 0x1

    aget-object v0, v4, v0

    const-string v1, "cat"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 724
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v1, 0x0

    aget-object v1, v4, v1

    const/4 v5, 0x1

    aget-object v4, v4, v5

    invoke-interface {v0, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1

    .line 726
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v1, 0x0

    aget-object v1, v4, v1

    const/4 v5, 0x1

    aget-object v4, v4, v5

    invoke-virtual {v3, v4}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    invoke-interface {v0, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1

    .line 730
    :cond_8
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-nez v0, :cond_9

    .line 731
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v1, 0x0

    aget-object v1, v4, v1

    const/4 v5, 0x1

    aget-object v4, v4, v5

    invoke-interface {v0, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_1

    .line 733
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const/4 v1, 0x0

    aget-object v1, v4, v1

    const/4 v5, 0x1

    aget-object v4, v4, v5

    invoke-interface {v0, v1, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 741
    :cond_a
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Z)Z
    .locals 0

    .prologue
    .line 92
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;I)I
    .locals 0

    .prologue
    .line 92
    iput p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    return p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;Z)V
    .locals 0

    .prologue
    .line 92
    invoke-direct {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Z)V

    return-void
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    return v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    return-object v0
.end method

.method private d()V
    .locals 2

    .prologue
    .line 282
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 283
    new-instance v0, Lqn;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v1, Lahy;->a:Lpx;

    invoke-virtual {v0, v1}, Lqn;->a(Lpx;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqo;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqp;)Lqn;

    move-result-object v0

    invoke-virtual {v0}, Lqn;->b()Lqm;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    .line 288
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 294
    :goto_0
    return-void

    .line 289
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v0, :cond_1

    .line 290
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e()V

    goto :goto_0

    .line 292
    :cond_1
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g()V

    goto :goto_0
.end method

.method static synthetic d(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    return v0
.end method

.method static synthetic e(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    return-object v0
.end method

.method private e()V
    .locals 2

    .prologue
    .line 297
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_0

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 299
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    invoke-virtual {v0}, Landroid/widget/RelativeLayout;->bringToFront()V

    .line 301
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->at:Lcom/bestbuy/android/bbyobjects/BBYButton;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYButton;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 308
    return-void
.end method

.method private e(Z)V
    .locals 14

    .prologue
    .line 666
    const/4 v3, 0x0

    .line 667
    if-eqz p1, :cond_0

    .line 668
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    .line 669
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v0, :cond_3

    .line 670
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-eqz v0, :cond_1

    .line 672
    new-instance v0, Lhz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ae:Ljava/lang/String;

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    iget v8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    const/16 v9, 0x14

    iget-boolean v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    iget-boolean v11, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    iget-boolean v12, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v12}, Lhz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/store/BBYStore;IIZZZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 691
    :goto_0
    return-void

    .line 676
    :cond_1
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "availability_zip"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v12

    .line 677
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "availability_storeid"

    const-string v2, ""

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v13

    .line 678
    if-eqz v12, :cond_2

    invoke-virtual {v12}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    if-eqz v13, :cond_2

    invoke-virtual {v13}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 679
    new-instance v0, Lhz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ae:Ljava/lang/String;

    iget v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    const/16 v8, 0x14

    iget-boolean v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    iget-boolean v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    iget-boolean v11, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v13}, Lhz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;IIZZZLjava/lang/String;Ljava/lang/String;)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 683
    :cond_2
    new-instance v0, Lhz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ae:Ljava/lang/String;

    const/4 v7, 0x0

    iget v8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    const/16 v9, 0x14

    iget-boolean v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    iget-boolean v11, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    iget-boolean v12, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v12}, Lhz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/store/BBYStore;IIZZZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 688
    :cond_3
    new-instance v0, Lhz;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ae:Ljava/lang/String;

    const-string v7, ""

    iget v8, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    const/16 v9, 0x14

    iget-boolean v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    iget-boolean v11, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    move-object v2, p0

    invoke-direct/range {v0 .. v11}, Lhz;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Ljava/lang/String;IIZZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhz;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_0
.end method

.method private f()V
    .locals 2

    .prologue
    .line 334
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 335
    return-void
.end method

.method static synthetic f(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    return v0
.end method

.method private g()V
    .locals 13

    .prologue
    const/16 v5, 0x14

    const/16 v1, 0x8

    const/4 v8, 0x0

    const/4 v11, 0x1

    const/4 v12, 0x0

    .line 338
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-eqz v0, :cond_1

    .line 339
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 340
    new-instance v0, Lid;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->I:Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->H:Ljava/lang/String;

    iget v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    iget v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    move-object v2, p0

    invoke-direct/range {v0 .. v11}, Lid;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v12, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lid;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 376
    :cond_0
    :goto_0
    return-void

    .line 342
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->R:Z

    if-eqz v0, :cond_4

    .line 343
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ag:Z

    if-eqz v0, :cond_3

    .line 344
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 345
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 348
    :cond_3
    :try_start_0
    new-instance v0, Lhj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Q:Ljava/util/ArrayList;

    invoke-direct {v0, v1, p0, v2, v3}, Lhj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 349
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 350
    :catch_0
    move-exception v0

    .line 351
    invoke-virtual {v0}, Ljava/lang/Exception;->printStackTrace()V

    goto :goto_0

    .line 353
    :cond_4
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Y:Z

    if-eqz v0, :cond_6

    .line 354
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-eqz v0, :cond_5

    .line 355
    new-instance v0, Lhf;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Z:Ljava/lang/String;

    const-string v4, "Best-Match"

    iget-boolean v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    iget-object v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-object v2, p0

    move v6, v11

    move v7, v12

    invoke-direct/range {v0 .. v10}, Lhf;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;IIZLandroid/view/View;ZLcom/bestbuy/android/api/lib/models/store/BBYStore;)V

    new-array v1, v12, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhf;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 357
    :cond_5
    new-instance v0, Lhf;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Z:Ljava/lang/String;

    const-string v4, "Best-Match"

    iget-boolean v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    move-object v2, p0

    move v6, v11

    move v7, v12

    invoke-direct/range {v0 .. v9}, Lhf;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Ljava/lang/String;Ljava/lang/String;IIZLandroid/view/View;Z)V

    new-array v1, v12, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lhf;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 360
    :cond_6
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    if-eqz v0, :cond_7

    .line 361
    new-instance v5, Ljh;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aa:Ljava/lang/String;

    iget v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    move-object v7, p0

    invoke-direct/range {v5 .. v10}, Ljh;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;I)V

    sget-object v0, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v1, v12, [Ljava/lang/Void;

    invoke-virtual {v5, v0, v1}, Ljh;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0

    .line 362
    :cond_7
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-eqz v0, :cond_9

    .line 363
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-nez v0, :cond_8

    .line 364
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {p0, v0, v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Z)V

    goto/16 :goto_0

    .line 366
    :cond_8
    invoke-direct {p0, v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Z)V

    goto/16 :goto_0

    .line 369
    :cond_9
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    const-string v1, "categoryid$"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_a

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    const-string v1, "si/products/search/www"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_b

    .line 370
    :cond_a
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    .line 373
    :cond_b
    invoke-direct {p0, v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Z)V

    goto/16 :goto_0
.end method

.method static synthetic g(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    return v0
.end method

.method private h()Z
    .locals 2

    .prologue
    .line 416
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 417
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method static synthetic h(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    return v0
.end method

.method static synthetic i(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    return v0
.end method

.method static synthetic j(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    return v0
.end method

.method static synthetic k(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)J
    .locals 2

    .prologue
    .line 92
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    return-wide v0
.end method

.method static synthetic l(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    return v0
.end method

.method static synthetic m(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic n(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->I:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic o(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic p(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->H:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic q(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)I
    .locals 1

    .prologue
    .line 92
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    return v0
.end method

.method static synthetic r(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aa:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic s(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Y:Z

    return v0
.end method

.method static synthetic t(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Lcom/bestbuy/android/api/lib/models/store/BBYStore;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    return-object v0
.end method

.method static synthetic u(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Z:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic v(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ah:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    return-object v0
.end method

.method static synthetic w(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    return v0
.end method

.method static synthetic x(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Z
    .locals 1

    .prologue
    .line 92
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    return v0
.end method

.method static synthetic y(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 92
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a(I)V
    .locals 7

    .prologue
    const/4 v3, 0x0

    .line 1434
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ax:Z

    if-eqz v0, :cond_0

    .line 1435
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ax:Z

    .line 1436
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(I)V

    .line 1540
    :goto_0
    return-void

    .line 1437
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    if-eqz v0, :cond_f

    .line 1438
    new-instance v4, Ljava/util/HashMap;

    invoke-direct {v4}, Ljava/util/HashMap;-><init>()V

    .line 1439
    const-string v0, "bb.numResults"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1440
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_e

    .line 1441
    const-string v1, ""

    .line 1442
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-direct {v5}, Ljava/lang/StringBuilder;-><init>()V

    move v2, v3

    .line 1443
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_3

    .line 1444
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v6, "Category"

    invoke-virtual {v0, v6}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1445
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    const-string v1, "Category"

    const-string v6, ""

    invoke-virtual {v0, v1, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    .line 1443
    :goto_2
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    move-object v1, v0

    goto :goto_1

    .line 1446
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-lez v0, :cond_2

    .line 1447
    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, " | "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v5, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    :cond_2
    move-object v0, v1

    goto :goto_2

    .line 1450
    :cond_3
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v0, :cond_4

    .line 1451
    sget-object v0, Llu;->br:Ljava/lang/String;

    const-string v2, "1"

    invoke-virtual {v4, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1453
    :cond_4
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-nez v0, :cond_b

    .line 1454
    sget-object v0, Llu;->e:Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    .line 1455
    const-string v0, "bb.searchTerm"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    invoke-virtual {v4, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1456
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v2, "SRCLF"

    invoke-virtual {v4, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1457
    sget-object v0, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,search,results"

    invoke-virtual {v4, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1458
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->an:Z

    if-eqz v0, :cond_6

    .line 1459
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1460
    sget-object v2, Llu;->e:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1461
    iget-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    if-eqz v2, :cond_5

    .line 1462
    sget-object v2, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1464
    :cond_5
    sget-object v2, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1465
    sget-object v2, Llu;->bm:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1466
    sget-object v2, Llu;->bq:Ljava/lang/String;

    invoke-virtual {v4, v2, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1468
    :cond_6
    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_9

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_9

    .line 1469
    const-string v0, "bb.fullFacetList "

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->length()I

    move-result v2

    add-int/lit8 v2, v2, -0x2

    invoke-virtual {v1, v3, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1495
    :cond_7
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    const-string v1, "Category"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_8

    .line 1496
    const-string v0, "bb.currentFacetValue"

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1498
    :cond_8
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    sget-object v1, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v4}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 1471
    :cond_9
    if-eqz v5, :cond_a

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 1472
    const-string v0, "bb.fullFacetList "

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Category"

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x2

    invoke-virtual {v2, v3, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_3

    .line 1474
    :cond_a
    const-string v0, "bb.fullFacetList "

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, "Category"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 1478
    :cond_b
    if-eqz v5, :cond_c

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_c

    .line 1479
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v2, "BRCLF"

    invoke-virtual {v4, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1480
    sget-object v0, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,category"

    invoke-virtual {v4, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1481
    const-string v0, "bb.fullFacetList "

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v6, "Category: "

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-virtual {v2, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " | "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    add-int/lit8 v5, v5, -0x2

    invoke-virtual {v2, v3, v5}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v4, v0, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1484
    :cond_c
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->an:Z

    if-eqz v0, :cond_7

    .line 1485
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    .line 1486
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1487
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    if-eqz v1, :cond_d

    .line 1488
    sget-object v1, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1490
    :cond_d
    sget-object v1, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1491
    sget-object v1, Llu;->bm:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1492
    sget-object v1, Llu;->bq:Ljava/lang/String;

    invoke-virtual {v4, v1, v0}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_3

    .line 1500
    :cond_e
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(I)V

    goto/16 :goto_0

    .line 1504
    :cond_f
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    if-eqz v0, :cond_14

    .line 1505
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1506
    const-string v1, "bb.numResults"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1507
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v1, :cond_10

    .line 1508
    sget-object v1, Llu;->br:Ljava/lang/String;

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1510
    :cond_10
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-nez v1, :cond_12

    .line 1511
    const-string v1, "bb.searchTerm"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1512
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,search,results"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1513
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "SRCLF"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1514
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->an:Z

    if-eqz v1, :cond_11

    .line 1515
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 1516
    sget-object v2, Llu;->e:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1517
    sget-object v2, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1518
    sget-object v2, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1519
    sget-object v2, Llu;->bm:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1520
    sget-object v2, Llu;->bq:Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1522
    :cond_11
    sget-object v1, Llu;->f:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 1524
    :cond_12
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,category"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1525
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "BRCLF"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1526
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->an:Z

    if-eqz v1, :cond_13

    .line 1527
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    .line 1528
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1529
    sget-object v2, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1530
    sget-object v2, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1531
    sget-object v2, Llu;->bm:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1532
    sget-object v2, Llu;->bq:Ljava/lang/String;

    invoke-virtual {v0, v2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1534
    :cond_13
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    sget-object v2, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto/16 :goto_0

    .line 1537
    :cond_14
    invoke-virtual {p0, p1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b(I)V

    goto/16 :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/remix/Store;)V
    .locals 3

    .prologue
    .line 1182
    new-instance v0, Llh;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-direct {v0, v1, v2, p1}, Llh;-><init>(Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/store/BBYStore;Lcom/bestbuy/android/api/lib/models/remix/Store;)V

    .line 1183
    invoke-virtual {v0}, Llh;->show()V

    .line 1184
    return-void
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Z)V
    .locals 9

    .prologue
    const v8, 0x7f0c0304

    const v7, 0x7f0c0303

    const/4 v5, 0x1

    const/16 v6, 0x8

    const/4 v4, 0x0

    .line 976
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 977
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 980
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 981
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 983
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v0, :cond_8

    .line 984
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->N:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 985
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f080077

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 986
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f020168

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 995
    :cond_1
    :goto_0
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    .line 996
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/HashMap;)V

    .line 997
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    if-eqz v0, :cond_9

    .line 998
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ab:I

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    .line 1002
    :goto_1
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_c

    .line 1003
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v0, v6}, Landroid/widget/ListView;->setVisibility(I)V

    .line 1004
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->K:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1005
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->L:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 1006
    const/4 v0, 0x0

    .line 1007
    if-eqz p1, :cond_27

    .line 1008
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestedFacets()Ljava/util/HashMap;

    move-result-object v0

    move-object v5, v0

    .line 1013
    :goto_2
    if-eqz v5, :cond_13

    .line 1014
    invoke-virtual {v5}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 1015
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 1016
    :cond_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 1017
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1018
    invoke-virtual {v5, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    move v3, v4

    .line 1019
    :goto_3
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v3, v2, :cond_2

    .line 1020
    const v2, 0x7f08012c

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    const v2, 0x7f080157

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 1021
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v2, :cond_a

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f080077

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f080075

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f08012a

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 1019
    :cond_4
    :goto_4
    add-int/lit8 v2, v3, 0x1

    move v3, v2

    goto :goto_3

    .line 987
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f080075

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 988
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f020158

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 989
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f08012a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 990
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f02007a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 991
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f08006c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 992
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f020133

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 994
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->N:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v6}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 1000
    :cond_9
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getTotal()I

    move-result v0

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    goto/16 :goto_1

    .line 1025
    :cond_a
    const v2, 0x7f08012c

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 1026
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f08006c

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 1030
    :cond_b
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 1031
    invoke-interface {v1, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {p0, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_4

    .line 1037
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v0, v4}, Landroid/widget/ListView;->setVisibility(I)V

    .line 1038
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-nez v0, :cond_d

    .line 1039
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1041
    :cond_d
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    if-nez v0, :cond_e

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Y:Z

    if-eqz v0, :cond_f

    .line 1042
    :cond_e
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1048
    :cond_f
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->K:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1049
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    if-nez v0, :cond_10

    .line 1050
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getFacets()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    .line 1051
    :cond_10
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    if-nez v0, :cond_11

    .line 1052
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSortOptions()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    .line 1053
    :cond_11
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_12

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_14

    :cond_12
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Y:Z

    if-nez v0, :cond_14

    .line 1054
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-eqz v0, :cond_13

    .line 1055
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;)V

    .line 1179
    :cond_13
    :goto_5
    return-void

    .line 1058
    :cond_14
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    if-gt v0, v5, :cond_21

    .line 1059
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->c()Landroid/content/SharedPreferences;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ao:Landroid/content/SharedPreferences;

    .line 1060
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ao:Landroid/content/SharedPreferences;

    const-string v1, "FIRST_PLP_LAUNCH"

    invoke-interface {v0, v1, v5}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_18

    .line 1061
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ao:Landroid/content/SharedPreferences;

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "FIRST_PLP_LAUNCH"

    invoke-interface {v0, v1, v4}, Landroid/content/SharedPreferences$Editor;->putBoolean(Ljava/lang/String;Z)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1062
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 1066
    :goto_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 1068
    iput-boolean v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 1069
    iput v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 1070
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 1071
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getFooterViewsCount()I

    move-result v0

    if-nez v0, :cond_15

    .line 1072
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v4}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 1074
    :cond_15
    iput v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 1075
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-eqz v0, :cond_19

    .line 1076
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 1079
    :goto_7
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-gtz v0, :cond_16

    .line 1080
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 1081
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 1083
    :cond_16
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Y:Z

    if-eqz v0, :cond_1a

    move v1, v4

    .line 1084
    :goto_8
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1d

    .line 1085
    new-instance v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;-><init>()V

    .line 1086
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V

    .line 1087
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 1088
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getSkuid()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSkuId(Ljava/lang/String;)V

    .line 1089
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v0, :cond_17

    .line 1090
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setStoreAvailability(Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;)V

    .line 1092
    :cond_17
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1084
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_8

    .line 1064
    :cond_18
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto/16 :goto_6

    .line 1078
    :cond_19
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_7

    .line 1095
    :cond_1a
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->isPlpAvailabilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_1c

    move v2, v4

    .line 1096
    :goto_9
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_1d

    .line 1097
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 1098
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v1, :cond_1b

    .line 1099
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setStoreAvailability(Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;)V

    .line 1101
    :cond_1b
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1096
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_9

    .line 1104
    :cond_1c
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1109
    :cond_1d
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(I)V

    .line 1111
    new-instance v0, Les;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const v2, 0x7f0300bb

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-direct {v0, v1, p0, v2, v3}, Les;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    .line 1112
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    if-eqz v0, :cond_1e

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v0

    if-eqz v0, :cond_1e

    .line 1113
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Les;->a(Ljava/lang/String;)V

    .line 1115
    :cond_1e
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    invoke-virtual {v0, v1}, Les;->a(Z)V

    .line 1116
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 1117
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeHeaderView(Landroid/view/View;)Z

    .line 1119
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->isPlpAvailabilityEnabled()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->setStoreAvailabilityVisible(Z)V

    .line 1120
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->setCheckedStatus()V

    .line 1122
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v0, :cond_20

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v0

    if-eqz v0, :cond_20

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->isPlpAvailabilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_20

    .line 1124
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "availability_zip"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getZipCode()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1125
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences;->edit()Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    const-string v1, "availability_storeid"

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences$Editor;->putString(Ljava/lang/String;Ljava/lang/String;)Landroid/content/SharedPreferences$Editor;

    move-result-object v0

    invoke-interface {v0}, Landroid/content/SharedPreferences$Editor;->commit()Z

    .line 1127
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-static {v0}, Lnr;->a(Lcom/bestbuy/android/api/lib/models/store/BBYStore;)Ljava/lang/String;

    move-result-object v0

    .line 1128
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getDistance()Ljava/lang/String;

    move-result-object v1

    .line 1129
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreDetails()Lcom/bestbuy/android/api/lib/models/store/StoreDetails;

    move-result-object v2

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/store/StoreDetails;->getName()Ljava/lang/String;

    move-result-object v2

    .line 1130
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    invoke-virtual {v3, v5}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;)V

    .line 1131
    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ar:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v3, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1132
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->av:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v3, " mi - "

    invoke-virtual {v1, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 1133
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->au:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1134
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ar:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1135
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->av:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1136
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aw:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 1170
    :goto_a
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_13

    .line 1171
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-eqz v0, :cond_1f

    .line 1172
    iput v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 1173
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 1175
    :cond_1f
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_5

    .line 1140
    :cond_20
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeHeaderView(Landroid/view/View;)Z

    goto :goto_a

    .line 1143
    :cond_21
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->Y:Z

    if-eqz v0, :cond_23

    move v1, v4

    .line 1144
    :goto_b
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_26

    .line 1145
    new-instance v2, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-direct {v2}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;-><init>()V

    .line 1146
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getSummary()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSummary(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Summary;)V

    .line 1147
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setPriceBlock(Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;)V

    .line 1148
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getSkuid()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setSkuId(Ljava/lang/String;)V

    .line 1149
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v0, :cond_22

    .line 1150
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    move-result-object v0

    invoke-virtual {v2, v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setStoreAvailability(Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;)V

    .line 1152
    :cond_22
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1144
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_b

    .line 1155
    :cond_23
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->isPlpAvailabilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_25

    move v2, v4

    .line 1156
    :goto_c
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v2, v0, :cond_26

    .line 1157
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 1158
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v1, :cond_24

    .line 1159
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getDocuments()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v1, v2}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/bestbuy/android/api/lib/models/search/Documents;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/Documents;->getStoreAvailability()Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->setStoreAvailability(Lcom/bestbuy/android/api/lib/models/search/BBYStoreAvailability;)V

    .line 1162
    :cond_24
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v1, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 1156
    add-int/lit8 v0, v2, 0x1

    move v2, v0

    goto :goto_c

    .line 1165
    :cond_25
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getSkuDetails()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 1168
    :cond_26
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    invoke-virtual {v0}, Les;->notifyDataSetChanged()V

    goto/16 :goto_a

    :cond_27
    move-object v5, v0

    goto/16 :goto_2
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;Z)V
    .locals 9

    .prologue
    const v8, 0x7f0c0304

    const v7, 0x7f0c0303

    const/4 v6, 0x1

    const/16 v4, 0x8

    const/4 v5, 0x0

    .line 864
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v0, :cond_8

    .line 865
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->N:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v5}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 866
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f080077

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 867
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f020168

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    .line 876
    :cond_0
    :goto_0
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    .line 877
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v1

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/HashMap;)V

    .line 878
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    if-eqz v0, :cond_9

    .line 879
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ab:I

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    .line 883
    :goto_1
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    const-wide/16 v2, 0x0

    cmp-long v0, v0, v2

    if-nez v0, :cond_c

    .line 884
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v0, v4}, Landroid/widget/ListView;->setVisibility(I)V

    .line 885
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->K:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 886
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->L:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 887
    const/4 v0, 0x0

    .line 888
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getFacets()Ljava/util/ArrayList;

    move-result-object v1

    if-eqz v1, :cond_19

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    move-result-object v1

    if-eqz v1, :cond_19

    .line 889
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->getRequestedFacets()Ljava/util/HashMap;

    move-result-object v0

    move-object v3, v0

    .line 891
    :goto_2
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v0, :cond_1

    if-eqz v3, :cond_1

    .line 892
    const-string v0, "category_facet"

    invoke-virtual {v3, v0}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 894
    :cond_1
    if-eqz v3, :cond_12

    .line 895
    invoke-virtual {v3}, Ljava/util/HashMap;->keySet()Ljava/util/Set;

    move-result-object v0

    .line 896
    invoke-interface {v0}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    .line 897
    :cond_2
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_12

    .line 898
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 899
    invoke-virtual {v3, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/util/List;

    move v4, v5

    .line 900
    :goto_3
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v2

    if-ge v4, v2, :cond_2

    .line 901
    const v2, 0x7f08012c

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_3

    const v2, 0x7f080157

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 902
    :cond_3
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v2, :cond_a

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f080077

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f080075

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f08012a

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_a

    .line 900
    :cond_4
    :goto_4
    add-int/lit8 v2, v4, 0x1

    move v4, v2

    goto :goto_3

    .line 868
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f080075

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 869
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f020158

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 870
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f08012a

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 871
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f02007a

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 872
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v1, 0x7f08006c

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 873
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    const v1, 0x7f020133

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setImageResource(I)V

    goto/16 :goto_0

    .line 875
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->N:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto/16 :goto_0

    .line 881
    :cond_9
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getTotalCount()I

    move-result v0

    int-to-long v0, v0

    iput-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    goto/16 :goto_1

    .line 906
    :cond_a
    const v2, 0x7f08012c

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_b

    .line 907
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v2, :cond_b

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v7, 0x7f08006c

    invoke-virtual {p0, v7}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 911
    :cond_b
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    if-eqz v2, :cond_4

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v7

    invoke-virtual {v2, v7}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 912
    invoke-interface {v1, v4}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    invoke-direct {p0, v0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_4

    .line 918
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v0, v5}, Landroid/widget/ListView;->setVisibility(I)V

    .line 919
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-nez v0, :cond_d

    .line 920
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v5}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 922
    :cond_d
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    if-eqz v0, :cond_e

    .line 923
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 929
    :cond_e
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->K:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 930
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    if-nez v0, :cond_f

    .line 931
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getFacets()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    .line 932
    :cond_f
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    if-nez v0, :cond_10

    .line 933
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getSortOptions()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    .line 934
    :cond_10
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getBbyProducts()Ljava/util/ArrayList;

    move-result-object v0

    if-eqz v0, :cond_11

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getBbyProducts()Ljava/util/ArrayList;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/ArrayList;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_13

    .line 935
    :cond_11
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-eqz v0, :cond_12

    .line 936
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/lang/String;)V

    .line 973
    :cond_12
    :goto_5
    return-void

    .line 939
    :cond_13
    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    if-gt v0, v6, :cond_18

    .line 940
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 942
    iput-boolean v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 943
    iput v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->q:I

    .line 944
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 945
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->getFooterViewsCount()I

    move-result v0

    if-nez v0, :cond_14

    .line 946
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v5}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 948
    :cond_14
    iput v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 949
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-eqz v0, :cond_17

    .line 950
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 953
    :goto_6
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-gtz v0, :cond_15

    .line 954
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    .line 955
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    .line 957
    :cond_15
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getBbyProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 958
    new-instance v0, Les;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const v2, 0x7f0300bb

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-direct {v0, v1, p0, v2, v3}, Les;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    .line 959
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 964
    :goto_7
    iget-wide v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->s:J

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v2}, Ljava/util/ArrayList;->size()I

    move-result v2

    int-to-long v2, v2

    cmp-long v0, v0, v2

    if-nez v0, :cond_12

    .line 965
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-eqz v0, :cond_16

    .line 966
    iput v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->J:I

    .line 967
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->removeFooterView(Landroid/view/View;)Z

    .line 969
    :cond_16
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_5

    .line 952
    :cond_17
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v8}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    invoke-virtual {v0, v5}, Landroid/view/View;->setVisibility(I)V

    goto :goto_6

    .line 961
    :cond_18
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getBbyProducts()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 962
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    invoke-virtual {v0}, Les;->notifyDataSetChanged()V

    goto :goto_7

    :cond_19
    move-object v3, v0

    goto/16 :goto_2
.end method

.method public a(Ljava/lang/String;)V
    .locals 3

    .prologue
    .line 826
    const-string v0, "categoryid"

    invoke-virtual {p1, v0}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 827
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 828
    const-string v1, "bb.failedSearchTerm"

    invoke-virtual {v0, v1, p1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 829
    const-string v1, "bb.numResults"

    const-string v2, "zero"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 830
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,search,failed"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 831
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "SRCL"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 832
    sget-object v1, Llu;->d:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 836
    :goto_0
    const-string v0, "NoSearchResultFragment"

    invoke-static {v0}, Lkb;->a(Ljava/lang/String;)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v1

    .line 837
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 838
    const-string v2, "Query"

    invoke-virtual {v0, v2, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 839
    invoke-virtual {v1, v0}, Landroid/support/v4/app/Fragment;->setArguments(Landroid/os/Bundle;)V

    .line 840
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 841
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 842
    return-void

    .line 834
    :cond_0
    const-string p1, "The selected category"

    goto :goto_0
.end method

.method public a(Ljava/util/ArrayList;I)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;I)V"
        }
    .end annotation

    .prologue
    const/16 v10, 0x14

    const/4 v11, 0x1

    const/4 v8, 0x0

    const/4 v12, 0x0

    .line 1196
    iput p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ab:I

    .line 1197
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    if-eqz v0, :cond_0

    .line 1198
    iput-boolean v12, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ad:Z

    .line 1199
    new-instance v0, Lid;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    const-string v4, "Best-Match"

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->H:Ljava/lang/String;

    iget v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    move-object v2, p0

    move-object v5, p1

    invoke-direct/range {v0 .. v11}, Lid;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v12, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lid;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 1203
    :goto_0
    return-void

    .line 1201
    :cond_0
    new-instance v0, Lid;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const-string v4, "Best-Match"

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->H:Ljava/lang/String;

    iget v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    move-object v2, p0

    move-object v3, v8

    move-object v5, p1

    invoke-direct/range {v0 .. v11}, Lid;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v12, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lid;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto :goto_0
.end method

.method public a(Ljava/util/ArrayList;Z)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    const/16 v1, 0x8

    const/4 v3, 0x0

    .line 845
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 846
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ag:Z

    if-eqz v0, :cond_1

    .line 847
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 848
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 850
    :cond_1
    if-eqz p2, :cond_2

    iget v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    const/4 v1, 0x1

    if-gt v0, v1, :cond_2

    .line 851
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 853
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-virtual {v0, p1}, Ljava/util/ArrayList;->addAll(Ljava/util/Collection;)Z

    .line 854
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    if-nez v0, :cond_3

    .line 855
    new-instance v0, Les;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const v2, 0x7f0300bb

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->k:Ljava/util/ArrayList;

    invoke-direct {v0, v1, p0, v2, v3}, Les;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    .line 856
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 860
    :goto_0
    return-void

    .line 858
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->j:Les;

    invoke-virtual {v0}, Les;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method public a(Z)V
    .locals 3

    .prologue
    const/16 v1, 0x8

    .line 313
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->an:Z

    .line 314
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_0

    .line 315
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 316
    :cond_0
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    .line 318
    const/4 v0, 0x1

    iput v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 319
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h()Z

    move-result v0

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 320
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 321
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 323
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 331
    :goto_0
    return-void

    .line 325
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v0, :cond_2

    .line 326
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e()V

    goto :goto_0

    .line 328
    :cond_2
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->f()V

    goto :goto_0
.end method

.method public b()V
    .locals 2

    .prologue
    .line 1426
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ah:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 1427
    return-void
.end method

.method public b(I)V
    .locals 4

    .prologue
    .line 1543
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 1544
    const-string v1, "bb.numResults"

    invoke-static {p1}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1545
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    if-eqz v1, :cond_0

    .line 1546
    sget-object v1, Llu;->br:Ljava/lang/String;

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1549
    :cond_0
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v1, :cond_2

    .line 1550
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,category"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1551
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "BRCL"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1552
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->an:Z

    if-eqz v1, :cond_1

    .line 1553
    sget-object v1, Llu;->bq:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Llu;->bm:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1555
    :cond_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1565
    :goto_0
    return-void

    .line 1557
    :cond_2
    const-string v1, "bb.searchTerm"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1558
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,list,search,results"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1559
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "SRCL"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1560
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->an:Z

    if-eqz v1, :cond_3

    .line 1561
    sget-object v1, Llu;->bq:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Llu;->e:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Llu;->bm:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1563
    :cond_3
    sget-object v1, Llu;->e:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    goto :goto_0
.end method

.method public b(Z)V
    .locals 0

    .prologue
    .line 1206
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    .line 1207
    return-void
.end method

.method public c()V
    .locals 2

    .prologue
    .line 1430
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ah:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 1431
    return-void
.end method

.method public c(Z)V
    .locals 0

    .prologue
    .line 1389
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->T:Z

    .line 1390
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 471
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 472
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 473
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    if-nez v0, :cond_0

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-eqz v0, :cond_1

    .line 474
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V

    .line 475
    :cond_1
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 627
    invoke-super {p0, p1, p2, p3}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 628
    if-eqz p3, :cond_2

    .line 629
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    .line 630
    iput-boolean v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->p:Z

    .line 631
    iput v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    .line 632
    const-string v0, "SELECTED_FACETS"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 633
    const-string v0, "SELECTED_FACETS"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    .line 634
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->D:Ljava/util/ArrayList;

    invoke-direct {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Ljava/util/ArrayList;)V

    .line 635
    const-string v0, "SORT_ORDER"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ae:Ljava/lang/String;

    .line 636
    invoke-direct {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Z)V

    .line 649
    :cond_0
    :goto_0
    const-string v0, "Selected_Facets_For_Analytics"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    const-string v0, "Latest_Facet_Selected"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 650
    const-string v0, "Latest_Facet_Selected"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aj:Ljava/lang/String;

    .line 651
    const-string v0, "Selected_Facets_For_Analytics"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->getStringArrayListExtra(Ljava/lang/String;)Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ak:Ljava/util/ArrayList;

    .line 654
    :cond_1
    const-string v0, "SelectedStore"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 655
    invoke-virtual {p3}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 656
    const-string v1, "SelectedStore"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getSerializable(Ljava/lang/String;)Ljava/io/Serializable;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    .line 657
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g()V

    .line 660
    :cond_2
    const/16 v0, 0x1388

    if-ne p1, v0, :cond_3

    .line 661
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d()V

    .line 663
    :cond_3
    return-void

    .line 637
    :cond_4
    const-string v0, "CLEAR_ALL"

    invoke-virtual {p3, v0}, Landroid/content/Intent;->hasExtra(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 638
    const-string v0, "CLEAR_ALL"

    const/4 v1, 0x0

    invoke-virtual {p3, v0, v1}, Landroid/content/Intent;->getBooleanExtra(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ax:Z

    .line 639
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    invoke-interface {v0}, Ljava/util/Map;->clear()V

    .line 640
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ae:Ljava/lang/String;

    .line 641
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-nez v0, :cond_5

    .line 642
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 643
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->E:Ljava/util/Map;

    const-string v1, "category_facet"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    invoke-interface {v0, v1, v2}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 646
    :cond_5
    invoke-direct {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Z)V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 263
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 264
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 265
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 267
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "show_availability"

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    .line 268
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h()Z

    move-result v0

    if-nez v0, :cond_0

    .line 269
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->am:Z

    .line 271
    :cond_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    .line 272
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    .line 273
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 9

    .prologue
    const/4 v4, 0x1

    const/16 v8, 0x270f

    const/4 v1, 0x0

    const v7, 0x7f04000e

    const v6, 0x7f040005

    .line 1250
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_c

    .line 1254
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    if-eqz v0, :cond_6

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-nez v0, :cond_6

    .line 1255
    new-instance v3, Landroid/content/Intent;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/browseproduct/plp/PLPSortAndFilterActivity;

    invoke-direct {v3, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1256
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    if-eqz v0, :cond_0

    .line 1257
    const-string v0, "BASE_FACETS"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->n:Ljava/util/ArrayList;

    invoke-virtual {v3, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 1258
    const-string v0, "BASE_SORT_OPTIONS"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->o:Ljava/util/ArrayList;

    invoke-virtual {v3, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 1260
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    if-nez v0, :cond_1

    .line 1261
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 1266
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    if-eqz v0, :cond_2

    .line 1267
    const/4 v2, 0x0

    .line 1268
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getFacets()Ljava/util/ArrayList;

    move-result-object v4

    .line 1269
    :goto_0
    invoke-virtual {v4}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_18

    .line 1270
    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0}, Ljava/util/HashMap;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_5

    .line 1271
    invoke-virtual {v4, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/solr/Facet;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/Facet;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v0

    .line 1276
    :goto_1
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-virtual {v1}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_2

    .line 1277
    if-eqz v0, :cond_2

    .line 1278
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    .line 1279
    if-nez v0, :cond_2

    .line 1280
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/solr/SolrRequestInfo;->getRequestedFacets()Ljava/util/HashMap;

    move-result-object v0

    .line 1281
    const-string v1, "category_facet"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1286
    :cond_2
    const v0, 0x7f080082

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->v:Lcom/bestbuy/android/api/lib/models/solr/SolrResponse;

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 1287
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 1288
    const v0, 0x7f08005a

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1289
    :cond_3
    const v0, 0x7f08007c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1290
    const-string v0, "isSearch"

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1291
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v3, v8}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1292
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v7, v6}, Landroid/app/Activity;->overridePendingTransition(II)V

    .line 1376
    :cond_4
    :goto_2
    return-void

    .line 1269
    :cond_5
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto/16 :goto_0

    .line 1293
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-eqz v0, :cond_4

    .line 1294
    new-instance v3, Landroid/content/Intent;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/search/plp/SearchPLPSortAndFilterActivity;

    invoke-direct {v3, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1295
    const-string v0, "BreadCrumb"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    invoke-virtual {v3, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1296
    const-string v0, "isFacetsSearch"

    iget-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    invoke-virtual {v3, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1297
    const-string v0, "isBrowseProduct"

    iget-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    invoke-virtual {v3, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1298
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    if-eqz v0, :cond_7

    .line 1299
    const-string v0, "SEARCH_BASE_FACETS"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l:Ljava/util/ArrayList;

    invoke-virtual {v3, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 1300
    const-string v0, "SEARCH_BASE_SORT_OPTIONS"

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->m:Ljava/util/ArrayList;

    invoke-virtual {v3, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 1302
    :cond_7
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v0, :cond_8

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    if-nez v0, :cond_8

    .line 1303
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    .line 1304
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestedFacets()Ljava/util/HashMap;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->setRequestedFacets(Ljava/util/HashMap;)V

    .line 1306
    :cond_8
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->V:Z

    if-eqz v0, :cond_a

    .line 1307
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_a

    .line 1308
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 1309
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getCategoryMap()Ljava/util/HashMap;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    .line 1310
    if-nez v0, :cond_a

    .line 1311
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestedFacets()Ljava/util/HashMap;

    move-result-object v4

    .line 1312
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    move-result-object v0

    if-eqz v0, :cond_a

    .line 1313
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->getRequestInfo()Lcom/bestbuy/android/api/lib/models/search/RequestInfo;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/RequestInfo;->getQuery()Ljava/lang/String;

    move-result-object v5

    .line 1314
    const-string v0, "category_facet"

    invoke-virtual {v4, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 1315
    if-eqz v0, :cond_a

    move v2, v1

    .line 1316
    :goto_3
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v1

    if-ge v2, v1, :cond_a

    .line 1317
    if-eqz v5, :cond_9

    invoke-interface {v0, v2}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/CharSequence;

    invoke-virtual {v5, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_9

    .line 1318
    const-string v1, "category_facet"

    invoke-virtual {v4, v1}, Ljava/util/HashMap;->remove(Ljava/lang/Object;)Ljava/lang/Object;

    .line 1316
    :cond_9
    add-int/lit8 v1, v2, 0x1

    move v2, v1

    goto :goto_3

    .line 1326
    :cond_a
    const v0, 0x7f08007b

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/io/Serializable;)Landroid/content/Intent;

    .line 1327
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    if-eqz v0, :cond_b

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_b

    .line 1328
    const v0, 0x7f08005a

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1329
    :cond_b
    const v0, 0x7f08007c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1330
    const-string v0, "isSearch"

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    invoke-virtual {v3, v0, v1}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 1331
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v3, v8}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1332
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v7, v6}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto/16 :goto_2

    .line 1334
    :cond_c
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->N:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_11

    .line 1335
    new-instance v1, Landroid/content/Intent;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const-class v2, Lcom/bestbuy/android/activities/dnm/DNMDetailsModel;

    invoke-direct {v1, v0, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1336
    const-string v0, ""

    .line 1337
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v3, 0x7f080077

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_e

    .line 1338
    const v0, 0x7f08029f

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 1345
    :cond_d
    :goto_4
    const v2, 0x7f080379

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

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

    .line 1346
    const v0, 0x7f08003b

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    invoke-virtual {v1, v0, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 1347
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 1348
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v7, v6}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto/16 :goto_2

    .line 1339
    :cond_e
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v3, 0x7f080075

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_f

    .line 1340
    const v0, 0x7f08029e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_4

    .line 1341
    :cond_f
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v3, 0x7f08012a

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_10

    .line 1342
    const v0, 0x7f08029c

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_4

    .line 1343
    :cond_10
    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->P:Ljava/lang/String;

    const v3, 0x7f08006c

    invoke-virtual {p0, v3}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_d

    .line 1344
    const v0, 0x7f08029d

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    goto :goto_4

    .line 1349
    :cond_11
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->au:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_14

    .line 1351
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 1352
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    .line 1353
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v0, :cond_13

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    :goto_5
    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1354
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    if-eqz v0, :cond_12

    .line 1355
    sget-object v0, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1357
    :cond_12
    sget-object v0, Llu;->bq:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v3, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Llu;->bk:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1358
    sget-object v0, Llu;->bk:Ljava/lang/String;

    invoke-static {v0, v1}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1360
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    const-class v2, Lcom/bestbuy/android/activities/plpstoreavailability/PLPStoreSelectionActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 1361
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v1, v0, v8}, Landroid/app/Activity;->startActivityForResult(Landroid/content/Intent;I)V

    .line 1362
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v7, v6}, Landroid/app/Activity;->overridePendingTransition(II)V

    goto/16 :goto_2

    .line 1353
    :cond_13
    sget-object v0, Llu;->e:Ljava/lang/String;

    goto :goto_5

    .line 1363
    :cond_14
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ar:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eq p1, v0, :cond_15

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->av:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eq p1, v0, :cond_15

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aw:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_4

    .line 1365
    :cond_15
    new-instance v2, Ljava/util/HashMap;

    invoke-direct {v2}, Ljava/util/HashMap;-><init>()V

    .line 1366
    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    .line 1367
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v0, :cond_17

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->af:Ljava/lang/String;

    :goto_6
    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1368
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->C:Z

    if-eqz v0, :cond_16

    .line 1369
    sget-object v0, Llu;->bn:Ljava/lang/String;

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    .line 1371
    :cond_16
    sget-object v0, Llu;->bq:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    invoke-direct {v4}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v4, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Llu;->bl:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    sget-object v4, Llu;->bj:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v0, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 1372
    sget-object v0, Llu;->bj:Ljava/lang/String;

    invoke-static {v0, v2}, Llu;->a(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 1374
    new-instance v0, Ljx;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const/4 v3, 0x0

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aq:Lcom/bestbuy/android/api/lib/models/store/BBYStore;

    invoke-virtual {v4}, Lcom/bestbuy/android/api/lib/models/store/BBYStore;->getStoreId()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v0, v2, p0, v3, v4}, Ljx;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;)V

    sget-object v2, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v1, v1, [Ljava/lang/Void;

    invoke-virtual {v0, v2, v1}, Ljx;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    goto/16 :goto_2

    .line 1367
    :cond_17
    sget-object v0, Llu;->e:Ljava/lang/String;

    goto :goto_6

    :cond_18
    move-object v0, v2

    goto/16 :goto_1
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 405
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 406
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 407
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 408
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 392
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 394
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const/16 v1, 0x2328

    invoke-virtual {p1, v0, v1}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 401
    :goto_0
    return-void

    .line 395
    :catch_0
    move-exception v0

    .line 396
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 399
    :cond_0
    const-string v0, "PLPFragment"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services connection failed with code "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {p1}, Lpp;->c()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onConnectionSuspended(I)V
    .locals 3

    .prologue
    .line 412
    const-string v0, "PLPFragment"

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Location services suspended cause:  "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lkf;->b(Ljava/lang/String;Ljava/lang/String;)V

    .line 413
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 1

    .prologue
    .line 465
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 466
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnStoreAvailabiltyClickListener(Lci;)V

    .line 467
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    const v3, 0x7f0b0063

    const/high16 v2, 0x7f0b0000

    .line 544
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->M:Landroid/view/LayoutInflater;

    .line 545
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    if-nez v0, :cond_5

    .line 546
    const v0, 0x7f0300ba

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    .line 547
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c02f9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ah:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    .line 548
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ah:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, v2, v3, v2, v3}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setColorScheme(IIII)V

    .line 549
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ah:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 550
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ai:Z

    .line 551
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ai:Z

    if-nez v0, :cond_3

    .line 552
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b()V

    .line 556
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    .line 557
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0036

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    .line 558
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0037

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYButton;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->at:Lcom/bestbuy/android/bbyobjects/BBYButton;

    .line 559
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00bd

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->L:Landroid/widget/LinearLayout;

    .line 560
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0075

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    .line 561
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00b9

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->K:Landroid/widget/RelativeLayout;

    .line 562
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00be

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    .line 563
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 564
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-eqz v0, :cond_0

    .line 565
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 566
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00c2

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->O:Landroid/widget/ImageView;

    .line 567
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c00c1

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->N:Landroid/widget/LinearLayout;

    .line 568
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->N:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 569
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    const/high16 v1, -0x80000000

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelection(I)V

    .line 570
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ay:Landroid/widget/AbsListView$OnScrollListener;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 571
    const v0, 0x7f0300bc

    invoke-virtual {p1, v0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->y:Landroid/view/View;

    .line 572
    const v0, 0x7f0300b5

    invoke-virtual {p1, v0, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    .line 573
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    const v1, 0x7f0c0024

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ar:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 574
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    const v1, 0x7f0c02ee

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->au:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 575
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    const v1, 0x7f0c02ed

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->av:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 576
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->z:Landroid/view/View;

    const v1, 0x7f0c02ec

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aw:Landroid/widget/LinearLayout;

    .line 578
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    if-eqz v0, :cond_4

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_4

    .line 579
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 585
    :cond_1
    :goto_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getActivateLayout()Landroid/widget/RelativeLayout;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    .line 586
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_2

    .line 587
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 594
    :cond_2
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d()V

    .line 597
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 623
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    return-object v0

    .line 554
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c()V

    goto/16 :goto_0

    .line 580
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_1

    .line 581
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    .line 582
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h:Ljava/lang/String;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->u:Ljava/lang/String;

    goto :goto_1

    .line 596
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_2
.end method

.method public onDestroy()V
    .locals 4

    .prologue
    .line 479
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 480
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    if-eqz v0, :cond_0

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_0

    .line 482
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 483
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 484
    const-string v0, "EmptyWeddingRegistryContainer"

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    .line 485
    if-eqz v0, :cond_7

    .line 486
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 487
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v1, :cond_6

    .line 507
    :cond_0
    :goto_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v0, :cond_1

    .line 509
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 510
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 511
    sget-object v2, Llu;->bo:Ljava/lang/String;

    const-string v3, "browse,deptCat"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 512
    sget-object v2, Llu;->bp:Ljava/lang/String;

    const-string v3, "PRD"

    invoke-virtual {v1, v2, v3}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 513
    if-eqz v0, :cond_1

    .line 514
    const-string v2, "Category"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/String;->isEmpty()Z

    move-result v2

    if-nez v2, :cond_1

    .line 515
    const-string v2, "Category"

    const-string v3, ""

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 519
    :cond_1
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->S:Z

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-nez v0, :cond_2

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->U:Z

    if-eqz v0, :cond_3

    .line 520
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V

    .line 522
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_4

    .line 523
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ap:Landroid/widget/RelativeLayout;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 525
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 526
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    .line 528
    :cond_5
    return-void

    .line 489
    :cond_6
    instance-of v0, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v0, :cond_0

    goto :goto_0

    .line 493
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {v0}, Lnb;->C()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 494
    const-string v0, "WishListFragmentContainer"

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    .line 495
    if-eqz v0, :cond_0

    .line 496
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 498
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    if-eqz v1, :cond_0

    .line 499
    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b()V

    goto/16 :goto_0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 532
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroyView()V

    .line 533
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->setStoreAvailabilityVisible(Z)V

    .line 534
    return-void
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 4

    .prologue
    .line 380
    if-eqz p1, :cond_0

    .line 381
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 382
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 383
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 384
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->al:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 387
    :cond_0
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g()V

    .line 388
    return-void
.end method

.method public onRefresh()V
    .locals 4

    .prologue
    .line 1395
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c()V

    .line 1396
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment$6;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 1423
    return-void
.end method

.method public onResume()V
    .locals 13

    .prologue
    const/4 v8, 0x0

    const/4 v11, 0x1

    const/4 v12, 0x0

    .line 422
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 423
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ai:Z

    .line 424
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ai:Z

    if-nez v0, :cond_3

    .line 425
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->b()V

    .line 429
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 431
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->G:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 432
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->W:Z

    if-eqz v0, :cond_4

    .line 433
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 437
    :goto_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 438
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->B:Z

    if-eqz v0, :cond_5

    .line 439
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    if-eqz v0, :cond_0

    .line 440
    new-instance v0, Lid;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->i:Landroid/view/View;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->A:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->I:Ljava/util/ArrayList;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->g:Ljava/lang/String;

    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->H:Ljava/lang/String;

    iget v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    iget v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->ac:I

    move-object v2, p0

    invoke-direct/range {v0 .. v11}, Lid;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IIZ)V

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v12, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lid;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 450
    :cond_0
    :goto_2
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->X:Z

    if-eqz v0, :cond_1

    .line 451
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->F:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 452
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v12}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeActionBarSearchVisibility(Landroid/app/Activity;Z)V

    .line 453
    new-instance v5, Ljh;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    iget-object v9, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->aa:Ljava/lang/String;

    iget v10, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->r:I

    move-object v7, p0

    invoke-direct/range {v5 .. v10}, Ljh;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;I)V

    sget-object v0, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v1, v12, [Ljava/lang/Void;

    invoke-virtual {v5, v0, v1}, Ljh;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 456
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->isPlpAvailabilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 457
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/search/SearchApi;->isPlpAvailabilityEnabled()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeActivity;->setStoreAvailabilityVisible(Z)V

    .line 458
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->h()Z

    move-result v0

    if-nez v0, :cond_2

    .line 459
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->as:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v12}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 462
    :cond_2
    return-void

    .line 427
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->c()V

    goto/16 :goto_0

    .line 435
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->x:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    goto/16 :goto_1

    .line 443
    :cond_5
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->t:Z

    if-eqz v0, :cond_6

    .line 444
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->w:Lcom/bestbuy/android/api/lib/models/search/SearchApi;

    invoke-virtual {p0, v0, v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->a(Lcom/bestbuy/android/api/lib/models/search/SearchApi;Z)V

    goto :goto_2

    .line 446
    :cond_6
    invoke-direct {p0, v11}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->e(Z)V

    goto :goto_2
.end method

.method public onStart()V
    .locals 0

    .prologue
    .line 278
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onStart()V

    .line 279
    return-void
.end method

.method public onStop()V
    .locals 4

    .prologue
    .line 538
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onStop()V

    .line 539
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    const-string v3, ""

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarSearchAndQueryVisibility(Landroid/app/Activity;ZLjava/lang/String;)V

    .line 540
    return-void
.end method
