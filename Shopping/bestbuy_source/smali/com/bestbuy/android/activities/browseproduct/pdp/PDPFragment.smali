.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lahx;
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Landroid/view/View$OnClickListener;
.implements Lcg;
.implements Lix;
.implements Lqo;
.implements Lqp;


# static fields
.field private static E:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation
.end field

.field private static F:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private static I:Lcom/bestbuy/android/api/lib/models/product/Product;

.field private static R:Ljava/lang/String;

.field private static T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private static b:Ljava/lang/String;

.field private static j:Z


# instance fields
.field private A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private B:Z

.field private C:Z

.field private D:I

.field private G:Landroid/widget/LinearLayout;

.field private H:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private J:Z

.field private K:Lqm;

.field private L:Z

.field private M:Ljava/lang/String;

.field private N:Ljava/lang/String;

.field private O:Z

.field private P:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

.field private Q:Ljava/lang/String;

.field private S:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

.field private U:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

.field private V:Z

.field private W:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

.field private X:Ljava/lang/String;

.field private a:Landroid/view/View;

.field private c:Ljava/lang/String;

.field private g:Landroid/widget/LinearLayout;

.field private h:Landroid/widget/ScrollView;

.field private i:Landroid/view/View;

.field private k:Liw;

.field private l:Landroid/widget/RelativeLayout;

.field private m:Landroid/widget/RelativeLayout;

.field private n:Landroid/widget/RelativeLayout;

.field private o:Landroid/widget/RelativeLayout;

.field private p:Landroid/widget/RelativeLayout;

.field private q:Landroid/widget/RelativeLayout;

.field private r:Landroid/widget/RelativeLayout;

.field private s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

.field private u:Landroid/widget/FrameLayout;

.field private v:Z

.field private w:Z

.field private x:Ljava/lang/String;

.field private y:Landroid/widget/LinearLayout;

.field private z:Landroid/widget/LinearLayout;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 110
    new-instance v0, Ljava/util/ArrayList;

    invoke-direct {v0}, Ljava/util/ArrayList;-><init>()V

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->E:Ljava/util/ArrayList;

    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 130
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    .line 82
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 100
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->v:Z

    .line 101
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 102
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    .line 108
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->C:Z

    .line 115
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 118
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    .line 119
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 128
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 131
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;Z)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 133
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    .line 82
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 100
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->v:Z

    .line 101
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 102
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    .line 108
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->C:Z

    .line 115
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 118
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    .line 119
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 128
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 134
    sput-object p1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    .line 135
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 136
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    .line 137
    sput-boolean v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    .line 138
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 158
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    .line 82
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 100
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->v:Z

    .line 101
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 102
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    .line 108
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->C:Z

    .line 115
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 118
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    .line 119
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 128
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 159
    sput-object p1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    .line 160
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 161
    sput-boolean p3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    .line 162
    iput-boolean p5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    .line 163
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 164
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZLcom/bestbuy/android/api/lib/models/dnm/DNMProduct;ZI)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 166
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    .line 82
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 100
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->v:Z

    .line 101
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 102
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    .line 108
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->C:Z

    .line 115
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 118
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    .line 119
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 128
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 167
    sput-object p1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    .line 168
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 169
    sput-boolean p3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    .line 170
    iput-boolean p5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    .line 171
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    .line 172
    iput p6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->D:I

    .line 173
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZ)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 150
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    .line 82
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 100
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->v:Z

    .line 101
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 102
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    .line 108
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->C:Z

    .line 115
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 118
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    .line 119
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 128
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 151
    sput-object p1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    .line 152
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 153
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    .line 154
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->C:Z

    .line 155
    sput-boolean v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    .line 156
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Ljava/lang/String;ZZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;)V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 140
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 80
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    .line 82
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 100
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->v:Z

    .line 101
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 102
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    .line 108
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->C:Z

    .line 115
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    .line 117
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 118
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    .line 119
    iput-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 128
    const-string v0, ""

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 141
    sput-object p1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    .line 142
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->c:Ljava/lang/String;

    .line 143
    iput-boolean p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    .line 144
    sput-boolean v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    .line 145
    iput-boolean p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 146
    iput-object p5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->P:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 147
    iput-object p6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    .line 148
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)Lcom/bestbuy/android/utils/CustomSwipeToRefresh;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->U:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    return-object v0
.end method

.method public static b()Ljava/lang/String;
    .locals 1

    .prologue
    .line 322
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    return-object v0
.end method

.method public static c()Lcom/bestbuy/android/api/lib/models/product/Product;
    .locals 1

    .prologue
    .line 326
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->I:Lcom/bestbuy/android/api/lib/models/product/Product;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    return-object v0
.end method

.method public static e()Ljava/util/HashMap;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation

    .prologue
    .line 725
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 726
    const-string v1, "WishListData"

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 727
    const-string v1, "sku"

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 728
    const-string v1, "RegistryData"

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->F:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 729
    const-string v1, "Product"

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 730
    const-string v1, "isFromDNM"

    sget-boolean v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    invoke-static {v2}, Ljava/lang/Boolean;->valueOf(Z)Ljava/lang/Boolean;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 731
    return-object v0
.end method

.method public static f()Ljava/lang/String;
    .locals 1

    .prologue
    .line 735
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->R:Ljava/lang/String;

    return-object v0
.end method

.method private j()Z
    .locals 2

    .prologue
    .line 821
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    const-string v1, "location"

    invoke-virtual {v0, v1}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/location/LocationManager;

    .line 822
    const-string v1, "gps"

    invoke-virtual {v0, v1}, Landroid/location/LocationManager;->isProviderEnabled(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;)V
    .locals 11

    .prologue
    const v8, 0x7f0800d3

    const/4 v3, -0x1

    const/16 v7, 0x8

    const/4 v2, 0x1

    const/4 v4, 0x0

    .line 392
    const-string v0, "PDPFragment"

    const-string v1, "The showPDPData methos is called."

    invoke-static {v0, v1}, Lkf;->c(Ljava/lang/String;Ljava/lang/String;)V

    .line 393
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->W:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;

    .line 394
    const/4 v0, 0x0

    .line 395
    if-eqz p1, :cond_2c

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    if-eqz v1, :cond_2c

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v1

    if-eqz v1, :cond_2c

    .line 396
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v1

    iput-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->S:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    .line 397
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v1

    if-eqz v1, :cond_2c

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v1

    if-eqz v1, :cond_2c

    .line 398
    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v0

    .line 399
    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-object v5, v0

    .line 403
    :goto_0
    if-eqz v5, :cond_1

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBreadcrumb()Ljava/util/List;

    move-result-object v0

    if-eqz v0, :cond_1

    move v1, v2

    .line 404
    :goto_1
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBreadcrumb()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 405
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getBreadcrumb()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/BreadCrumb;->getDisplayName()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v6, ": "

    invoke-virtual {v0, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    .line 404
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_1

    .line 407
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v1, ": Product Info"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 408
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    const-string v1, ": Product Info"

    const-string v6, ""

    invoke-virtual {v0, v1, v6}, Ljava/lang/String;->replace(Ljava/lang/CharSequence;Ljava/lang/CharSequence;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    .line 410
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    invoke-virtual {p0, p1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;Ljava/lang/String;)V

    .line 412
    sget-boolean v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    if-eqz v0, :cond_b

    .line 413
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 414
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 427
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->g:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_2

    .line 428
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->removeAllViews()V

    .line 430
    :cond_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_3

    .line 431
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 433
    :cond_3
    const/4 v0, 0x0

    .line 434
    if-eqz v5, :cond_2b

    .line 435
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    move-object v1, v0

    .line 436
    :goto_3
    if-eqz v1, :cond_4

    .line 437
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getUrl()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->x:Ljava/lang/String;

    .line 438
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-nez v0, :cond_8

    .line 439
    if-eqz v1, :cond_17

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isPurchasable()Z

    move-result v0

    if-eqz v0, :cond_17

    .line 440
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->q:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_5

    .line 441
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->q:Landroid/widget/RelativeLayout;

    const v6, 0x7f0c0238

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 442
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v6

    invoke-virtual {v6}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getDisplayName()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 444
    :cond_5
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    const v6, 0x7f080029

    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_12

    .line 445
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_6

    .line 446
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 447
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 448
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v6}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 450
    :cond_6
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 451
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v6, v4}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 452
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 528
    :cond_7
    :goto_4
    if-eqz v1, :cond_8

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isCommerceUnavailable()Z

    move-result v0

    if-eqz v0, :cond_8

    .line 529
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->m:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_8

    .line 530
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->m:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 531
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->m:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 532
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->m:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 537
    :cond_8
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0a0003

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getStringArray(I)[Ljava/lang/String;

    move-result-object v6

    move v0, v3

    move v1, v4

    .line 538
    :goto_5
    array-length v2, v6

    if-ge v0, v2, :cond_29

    .line 539
    const-string v2, ""

    .line 540
    if-ne v0, v3, :cond_21

    .line 541
    const-string v2, "EmptyFragment"

    move-object v4, v2

    .line 546
    :goto_6
    const-string v2, "PDPBundledItemsFragment"

    invoke-virtual {v4, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_9

    .line 554
    :cond_9
    new-instance v7, Landroid/widget/LinearLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-direct {v7, v2}, Landroid/widget/LinearLayout;-><init>(Landroid/content/Context;)V

    .line 556
    const/4 v2, -0x2

    .line 557
    new-instance v8, Landroid/widget/LinearLayout$LayoutParams;

    invoke-direct {v8, v3, v2}, Landroid/widget/LinearLayout$LayoutParams;-><init>(II)V

    .line 558
    invoke-virtual {v7, v8}, Landroid/widget/LinearLayout;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 559
    add-int/lit8 v2, v1, 0x1

    invoke-virtual {v7, v1}, Landroid/widget/LinearLayout;->setId(I)V

    .line 560
    invoke-virtual {v7, v4}, Landroid/widget/LinearLayout;->setTag(Ljava/lang/Object;)V

    .line 561
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->S:Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    iget-object v8, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    sget-boolean v9, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    invoke-static {v4, v1, v5, v8, v9}, Lkb;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v8

    .line 562
    sget-boolean v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    if-eqz v1, :cond_22

    const-string v1, "PDPOverviewFragment"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_22

    .line 538
    :cond_a
    :goto_7
    add-int/lit8 v0, v0, 0x1

    move v1, v2

    goto :goto_5

    .line 416
    :cond_b
    if-eqz v5, :cond_11

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_c

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v0

    if-nez v0, :cond_10

    :cond_c
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_d

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getCondition()Ljava/lang/String;

    move-result-object v0

    const-string v1, "openbox"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-nez v0, :cond_10

    :cond_d
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    if-eqz v0, :cond_e

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getAttributes()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Attributes;->isMarketplace()Z

    move-result v0

    if-nez v0, :cond_10

    :cond_e
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_f

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    move-result-object v0

    if-eqz v0, :cond_f

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getProperties()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Properties;->getContractCondition()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_10

    :cond_f
    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    if-eqz v0, :cond_11

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    if-eqz v0, :cond_11

    invoke-virtual {v5}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isPurchasable()Z

    move-result v0

    if-nez v0, :cond_11

    .line 420
    :cond_10
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v4}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 421
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    goto/16 :goto_2

    .line 424
    :cond_11
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 425
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    goto/16 :goto_2

    .line 453
    :cond_12
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    const v6, 0x7f080028

    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_13

    .line 454
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_7

    .line 455
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 456
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v2}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_4

    .line 458
    :cond_13
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    const v6, 0x7f08002d

    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_14

    .line 459
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->r:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_7

    .line 460
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 461
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->r:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v2}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_4

    .line 463
    :cond_14
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    const v6, 0x7f08002a

    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_15

    .line 464
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->l:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_7

    .line 465
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->l:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 466
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->l:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v2}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    goto/16 :goto_4

    .line 469
    :cond_15
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_16

    .line 470
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 471
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 472
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0b0002

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setBackgroundColor(I)V

    .line 473
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0b0063

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 474
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v6}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 476
    :cond_16
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    goto/16 :goto_4

    .line 478
    :cond_17
    if-eqz v1, :cond_1f

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->isPurchasable()Z

    move-result v0

    if-nez v0, :cond_1f

    .line 479
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    const v6, 0x7f08002e

    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_19

    .line 480
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_18

    .line 481
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 482
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v2, 0x7f0800d7

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 483
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v2}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 484
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 486
    :cond_18
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_7

    .line 487
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_4

    .line 488
    :cond_19
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    const v6, 0x7f08002c

    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1b

    .line 489
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_1a

    .line 490
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 491
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v2, 0x7f0800d5

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 492
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v2}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 493
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 495
    :cond_1a
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_7

    .line 496
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_4

    .line 497
    :cond_1b
    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getButtonState()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/ButtonState;->getButtonStateID()Ljava/lang/String;

    move-result-object v0

    const v6, 0x7f08002b

    invoke-virtual {p0, v6}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1d

    .line 498
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v6, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 499
    iput-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    .line 500
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_1c

    .line 501
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 502
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v2, 0x7f0800d4

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 503
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v2}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 504
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 506
    :cond_1c
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_7

    .line 507
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v7}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    goto/16 :goto_4

    .line 509
    :cond_1d
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-eqz v0, :cond_1e

    .line 510
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, v4}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setVisibility(I)V

    .line 511
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {p0, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 512
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0b0002

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setBackgroundColor(I)V

    .line 513
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v6}, Landroid/app/Activity;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    const v7, 0x7f0b0063

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 514
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v6}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v6

    invoke-virtual {v0, v6}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->startAnimation(Landroid/view/animation/Animation;)V

    .line 516
    :cond_1e
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    .line 517
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v6, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v6, v4}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 518
    iput-boolean v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    goto/16 :goto_4

    .line 521
    :cond_1f
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->p:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_20

    .line 522
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v4}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 523
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->p:Landroid/widget/RelativeLayout;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v2}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v2

    invoke-virtual {v0, v2}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 525
    :cond_20
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    if-eqz v0, :cond_7

    .line 526
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v7}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    goto/16 :goto_4

    .line 543
    :cond_21
    aget-object v2, v6, v0

    move-object v4, v2

    goto/16 :goto_6

    .line 565
    :cond_22
    const-string v1, "PDPCustomerAlsoBoughtFragment"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_23

    const-string v1, "PDPCustomerAlsoViewedFragment"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_24

    .line 566
    :cond_23
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 567
    const-string v9, "isFromMdot"

    iget-boolean v10, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    invoke-virtual {v1, v9, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 568
    const-string v9, "BreadCrumb"

    iget-object v10, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    invoke-virtual {v1, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 569
    invoke-virtual {v8, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->setArguments(Landroid/os/Bundle;)V

    .line 571
    :cond_24
    const-string v1, "PDPReviewAndRatingsFragment"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_25

    const-string v1, "PDPPriceBlockFragment"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_27

    .line 573
    :cond_25
    invoke-virtual {v8}, Lcom/bestbuy/android/base/BBYBaseFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v1

    .line 574
    if-nez v1, :cond_26

    .line 575
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 578
    :cond_26
    const-string v9, "isFromMdot"

    iget-boolean v10, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    invoke-virtual {v1, v9, v10}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 579
    const-string v9, "BreadCrumb"

    iget-object v10, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    invoke-virtual {v1, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 580
    const-string v9, "PDPOverviewResponseRoot"

    invoke-virtual {v1, v9, p1}, Landroid/os/Bundle;->putSerializable(Ljava/lang/String;Ljava/io/Serializable;)V

    .line 581
    invoke-virtual {v8, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->setArguments(Landroid/os/Bundle;)V

    .line 583
    :cond_27
    const-string v1, "PDPAvailabilityFragment"

    invoke-virtual {v4, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_28

    .line 584
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 585
    const-string v4, "NumOfStores"

    iget v9, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->D:I

    invoke-virtual {v1, v4, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 586
    invoke-virtual {v8, v1}, Lcom/bestbuy/android/base/BBYBaseFragment;->setArguments(Landroid/os/Bundle;)V

    .line 588
    :cond_28
    new-instance v1, Landroid/os/Handler;

    invoke-direct {v1}, Landroid/os/Handler;-><init>()V

    new-instance v4, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$1;

    invoke-direct {v4, p0, v7, v8}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;Landroid/widget/LinearLayout;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    invoke-virtual {v1, v4}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 593
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->g:Landroid/widget/LinearLayout;

    if-eqz v1, :cond_a

    .line 594
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->g:Landroid/widget/LinearLayout;

    invoke-virtual {v1, v7}, Landroid/widget/LinearLayout;->addView(Landroid/view/View;)V

    goto/16 :goto_7

    .line 597
    :cond_29
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 598
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v1, :cond_2a

    .line 599
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getOverview()Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Ljava/lang/String;)V

    .line 602
    :cond_2a
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->R:Ljava/lang/String;

    .line 603
    return-void

    :cond_2b
    move-object v1, v0

    goto/16 :goto_3

    :cond_2c
    move-object v5, v0

    goto/16 :goto_0
.end method

.method public a(Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;Ljava/lang/String;)V
    .locals 4

    .prologue
    .line 854
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 855
    const-string v1, "bb.prodView"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 856
    const-string v1, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 857
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,pdp"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 858
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "PDH"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 859
    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    if-eqz v1, :cond_1

    .line 860
    const-string v1, "bb.recClick"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 861
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    const-string v2, "customeralsoviewed"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    const-string v2, "customeralsobought"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 862
    :cond_0
    const-string v1, "bb.recCode"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->P:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getEp()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "pdp"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 867
    :cond_1
    :goto_0
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    if-eqz v1, :cond_3

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    if-eqz v1, :cond_3

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v1

    if-eqz v1, :cond_3

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 868
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getPricingType()Ljava/lang/String;

    move-result-object v1

    .line 869
    const-string v2, "ICR-noPrice"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_2

    const-string v2, "MAP"

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 870
    :cond_2
    const-string v1, "bb.pdpImpression"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 873
    :cond_3
    if-eqz p1, :cond_4

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    if-eqz v1, :cond_4

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v1

    if-eqz v1, :cond_4

    invoke-virtual {p1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponseRoot;->getSi()Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/SIPDPOverviewResponse;->getResponse()Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;->getDistilledReviewSummary()Lcom/bestbuy/android/api/lib/models/pdpreviews/DistilledReviewSummary;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 875
    const-string v1, "bb.distilledReviewImp"

    const-string v2, "1"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 876
    const-string v1, "bb.reviewsInteraction"

    const-string v2, "browse,pdp"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 878
    :cond_4
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "pdp"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 879
    return-void

    .line 864
    :cond_5
    const-string v1, "bb.recCode"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->P:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;->getEp()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ": "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto/16 :goto_0
.end method

.method public a(Ljava/lang/String;)V
    .locals 2

    .prologue
    .line 629
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0082

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->z:Landroid/widget/LinearLayout;

    .line 630
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 631
    :cond_0
    const v0, 0x7f08009e

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object p1

    .line 632
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->z:Landroid/widget/LinearLayout;

    const v1, 0x7f0c0083

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 633
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->z:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 634
    return-void
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 712
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->clear()V

    .line 713
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_1

    .line 714
    invoke-virtual {p1, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 715
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v2

    const-string v3, "weddingregistrylists"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 716
    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->E:Ljava/util/ArrayList;

    invoke-virtual {v2, v0}, Ljava/util/ArrayList;->add(Ljava/lang/Object;)Z

    .line 713
    :goto_1
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 718
    :cond_0
    sput-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->F:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    goto :goto_1

    .line 721
    :cond_1
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->E:Ljava/util/ArrayList;

    invoke-static {v0}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 722
    return-void
.end method

.method public a(Z)V
    .locals 2

    .prologue
    .line 739
    if-eqz p1, :cond_0

    .line 740
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->H:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Item Added"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 744
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->G:Landroid/widget/LinearLayout;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 745
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->G:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 746
    return-void

    .line 742
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->H:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "Item cannot be Added"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public a(ZLcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 753
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->O:Z

    .line 754
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->P:Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;

    .line 755
    iput-object p4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->N:Ljava/lang/String;

    .line 756
    if-eqz p3, :cond_0

    .line 757
    const-string v0, "customeralsobought"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 758
    const-string v0, "customeralsobought"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    .line 775
    :cond_0
    :goto_0
    return-void

    .line 759
    :cond_1
    const-string v0, "customeralsoviewed"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_2

    .line 760
    const-string v0, "customeralsoviewed"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    goto :goto_0

    .line 761
    :cond_2
    const-string v0, "product"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_3

    .line 762
    const-string v0, "Products"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    goto :goto_0

    .line 763
    :cond_3
    const-string v0, "stores"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    .line 764
    const-string v0, "Store Locator"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    goto :goto_0

    .line 765
    :cond_4
    const-string v0, "recentlyviewed"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_5

    .line 766
    const-string v0, "Best Buy"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    goto :goto_0

    .line 767
    :cond_5
    const-string v0, "GHP"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_6

    .line 768
    const-string v0, "Best Buy"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    goto :goto_0

    .line 769
    :cond_6
    const-string v0, "Checkout: Cart \u2013 Empty"

    invoke-virtual {p3, v0}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_7

    .line 770
    const-string v0, "Checkout: Cart \u2013 Empty"

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    goto :goto_0

    .line 772
    :cond_7
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->Q:Ljava/lang/String;

    goto :goto_0
.end method

.method public b(Z)V
    .locals 0

    .prologue
    .line 749
    iput-boolean p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    .line 750
    return-void
.end method

.method public d()V
    .locals 4

    .prologue
    .line 616
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->y:Landroid/widget/LinearLayout;

    invoke-static {v0}, Lll;->b(Landroid/view/View;)V

    .line 617
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->b()Landroid/content/SharedPreferences;

    move-result-object v0

    const-string v1, "cartQuantity"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Landroid/content/SharedPreferences;->getInt(Ljava/lang/String;I)I

    move-result v0

    .line 618
    new-instance v1, Ljava/util/HashMap;

    invoke-direct {v1}, Ljava/util/HashMap;-><init>()V

    .line 619
    if-nez v0, :cond_0

    .line 620
    const-string v0, "bb.scOpen"

    const-string v2, "1"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 622
    :cond_0
    const-string v0, "bb.scAdd"

    const-string v2, "1"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 623
    const-string v0, "&&products"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string v3, ";"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    sget-object v3, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v3}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, ";;;;eVar7=PDH"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 624
    sget-object v0, Llu;->bp:Ljava/lang/String;

    const-string v2, "PDH"

    invoke-virtual {v1, v0, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 625
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->M:Ljava/lang/String;

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string v2, "pdp"

    invoke-virtual {v0, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0, v1}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 626
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 817
    return-void
.end method

.method public h()V
    .locals 2

    .prologue
    .line 846
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->U:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 847
    return-void
.end method

.method public i()V
    .locals 2

    .prologue
    .line 850
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->U:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setEnabled(Z)V

    .line 851
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 233
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 234
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 235
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 236
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 237
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 4

    .prologue
    const/4 v2, 0x1

    const/4 v3, 0x0

    .line 176
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 177
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    .line 178
    if-eqz p1, :cond_0

    move-object v0, p1

    .line 179
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    if-nez v1, :cond_2

    move v1, v2

    :goto_0
    invoke-virtual {v0, p1, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    move-object v0, p1

    .line 180
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    move-object v0, p1

    .line 181
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->changeOptionsVisibility(Z)V

    .line 183
    :cond_0
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    move-object v0, p1

    .line 184
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 185
    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 186
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 187
    new-instance v0, Lqn;

    invoke-direct {v0, p1}, Lqn;-><init>(Landroid/content/Context;)V

    sget-object v1, Lahy;->a:Lpx;

    invoke-virtual {v0, v1}, Lqn;->a(Lpx;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqo;)Lqn;

    move-result-object v0

    invoke-virtual {v0, p0}, Lqn;->a(Lqp;)Lqn;

    move-result-object v0

    invoke-virtual {v0}, Lqn;->b()Lqm;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    .line 192
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    invoke-interface {v0}, Lqm;->b()V

    .line 194
    :cond_1
    return-void

    :cond_2
    move v1, v3

    .line 179
    goto :goto_0
.end method

.method public onClick(Landroid/view/View;)V
    .locals 10

    .prologue
    const/4 v2, 0x0

    const v4, 0x7f0c0033

    const/4 v3, 0x1

    const/4 v9, 0x0

    .line 638
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    if-eq p1, v0, :cond_0

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->r:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_4

    .line 639
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->u:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v9}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 640
    const-string v8, ""

    .line 641
    const-string v7, ""

    .line 642
    const-string v0, ""

    .line 643
    const-string v6, ""

    .line 644
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 645
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    move-result-object v1

    if-eqz v1, :cond_1

    .line 646
    sget-object v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getSellerInfo()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;

    move-result-object v0

    .line 647
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/SellerInfo;->getSellerId()Ljava/lang/String;

    move-result-object v0

    .line 649
    :cond_1
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v1

    if-eqz v1, :cond_9

    .line 650
    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getPriceBlock()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/PriceBlock;->getPrice()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Price;->getListingId()Ljava/lang/String;

    move-result-object v6

    move-object v5, v0

    .line 657
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 658
    iget-object v7, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 659
    :cond_2
    new-instance v0, Lin;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i:Landroid/view/View;

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v2}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getSkuId()Ljava/lang/String;

    move-result-object v4

    move-object v2, p0

    invoke-direct/range {v0 .. v8}, Lin;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    new-array v1, v9, [Ljava/lang/Void;

    invoke-virtual {v0, v1}, Lin;->execute([Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 709
    :cond_3
    :goto_1
    return-void

    .line 660
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    if-ne p1, v0, :cond_5

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->w:Z

    if-ne v0, v3, :cond_5

    .line 661
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-direct {v0, v1}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 662
    const-string v1, "<font face = \'Sans-Serif\'> <small>You will be redirected to BestBuy.com to complete your transaction. Do you want to continue?</small> </font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 664
    const-string v1, "<font face = \'Sans-Serif\'> <b>Yes</b> </font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$2;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$2;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 672
    const-string v1, "<font face = \'Sans-Serif\'>No</font>"

    invoke-static {v1}, Landroid/text/Html;->fromHtml(Ljava/lang/String;)Landroid/text/Spanned;

    move-result-object v1

    new-instance v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$3;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$3;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setNegativeButton(Ljava/lang/CharSequence;Landroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    .line 678
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    .line 679
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->show()Landroid/app/AlertDialog;

    goto :goto_1

    .line 680
    :cond_5
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->y:Landroid/widget/LinearLayout;

    if-ne p1, v0, :cond_6

    .line 683
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_3

    .line 684
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    .line 685
    invoke-virtual {v0, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 686
    instance-of v1, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v1, :cond_3

    .line 687
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 688
    const/4 v1, 0x3

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->a(I)V

    goto :goto_1

    .line 691
    :cond_6
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->m:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_7

    .line 692
    const v0, 0x7f08009f

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Ljava/lang/String;)V

    goto :goto_1

    .line 693
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->l:Landroid/widget/RelativeLayout;

    if-ne p1, v0, :cond_3

    .line 694
    const-string v0, "ProductAvailabilityFragment"

    sget-object v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->T:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-static {v0, v2, v1, v2, v9}, Lkb;->a(Ljava/lang/String;Lcom/bestbuy/android/api/lib/models/pdp/PDPOverviewResponse;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;Z)Lcom/bestbuy/android/base/BBYBaseFragment;

    move-result-object v2

    .line 695
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0, v4}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 696
    instance-of v0, v1, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_8

    move-object v0, v1

    .line 697
    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    .line 698
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 699
    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    invoke-virtual {v0, v2, v3}, Lcom/bestbuy/android/activities/BaseTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 702
    :cond_8
    instance-of v0, v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_3

    move-object v0, v1

    .line 703
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 704
    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v0, :cond_3

    .line 705
    check-cast v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v1, v2, v3}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto/16 :goto_1

    :cond_9
    move-object v5, v0

    goto/16 :goto_0
.end method

.method public onConnected(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 805
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    sget-object v2, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->REQUEST:Lcom/google/android/gms/location/LocationRequest;

    invoke-interface {v0, v1, v2, p0}, Lahr;->a(Lqm;Lcom/google/android/gms/location/LocationRequest;Lahx;)Lqq;

    .line 806
    return-void
.end method

.method public onConnectionFailed(Lpp;)V
    .locals 3

    .prologue
    .line 792
    invoke-virtual {p1}, Lpp;->a()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 794
    :try_start_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    const/16 v1, 0x2328

    invoke-virtual {p1, v0, v1}, Lpp;->a(Landroid/app/Activity;I)V
    :try_end_0
    .catch Landroid/content/IntentSender$SendIntentException; {:try_start_0 .. :try_end_0} :catch_0

    .line 801
    :goto_0
    return-void

    .line 795
    :catch_0
    move-exception v0

    .line 796
    invoke-virtual {v0}, Landroid/content/IntentSender$SendIntentException;->printStackTrace()V

    goto :goto_0

    .line 799
    :cond_0
    const-string v0, "PDPFragment"

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
    .line 810
    const-string v0, "PDPFragment"

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

    .line 811
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 197
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 199
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    .line 200
    if-eqz v0, :cond_0

    const-string v1, "availability_storeid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 201
    const-string v1, "availability_storeid"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    .line 203
    :cond_0
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7

    .prologue
    const v5, 0x7f0b0063

    const/high16 v4, 0x7f0b0000

    const/16 v3, 0x8

    const/4 v1, 0x1

    const/4 v6, 0x0

    .line 241
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    if-nez v0, :cond_8

    .line 242
    const v0, 0x7f030090

    invoke-virtual {p1, v0, p2, v6}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    .line 243
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c006e

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->U:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    .line 244
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->U:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, v4, v5, v4, v5}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setColorScheme(IIII)V

    .line 245
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->U:Lcom/bestbuy/android/utils/CustomSwipeToRefresh;

    invoke-virtual {v0, p0}, Lcom/bestbuy/android/utils/CustomSwipeToRefresh;->setOnRefreshListener(Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;)V

    .line 246
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->V:Z

    .line 247
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->V:Z

    if-nez v0, :cond_3

    .line 248
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->h()V

    .line 252
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0231

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ScrollView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->h:Landroid/widget/ScrollView;

    .line 253
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->h:Landroid/widget/ScrollView;

    invoke-virtual {v0, v6}, Landroid/widget/ScrollView;->setVerticalScrollBarEnabled(Z)V

    .line 254
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->h:Landroid/widget/ScrollView;

    invoke-virtual {v0, v6}, Landroid/widget/ScrollView;->setHorizontalScrollBarEnabled(Z)V

    .line 255
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0232

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->g:Landroid/widget/LinearLayout;

    .line 256
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0064

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i:Landroid/view/View;

    .line 257
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 258
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i:Landroid/view/View;

    invoke-virtual {v0, v6}, Landroid/view/View;->setVisibility(I)V

    .line 259
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0221

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    .line 260
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0222

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 261
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0237

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->q:Landroid/widget/RelativeLayout;

    .line 262
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0236

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->p:Landroid/widget/RelativeLayout;

    .line 263
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0233

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    .line 264
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0239

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->s:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 265
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0235

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->r:Landroid/widget/RelativeLayout;

    .line 266
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c023a

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->m:Landroid/widget/RelativeLayout;

    .line 267
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0234

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/RelativeLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->l:Landroid/widget/RelativeLayout;

    .line 268
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->l:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 269
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->r:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 270
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 271
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0080

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->y:Landroid/widget/LinearLayout;

    .line 272
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->y:Landroid/widget/LinearLayout;

    invoke-virtual {v0, p0}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 273
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0133

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/LinearLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->G:Landroid/widget/LinearLayout;

    .line 274
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v2, 0x7f0c0134

    invoke-virtual {v0, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->H:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 276
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    if-eqz v0, :cond_1

    .line 277
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_6

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v0

    const v2, 0x7f080068

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_6

    .line 278
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuTypeCode()Ljava/lang/String;

    move-result-object v0

    const v2, 0x7f08003a

    invoke-virtual {p0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_4

    move v0, v1

    .line 290
    :goto_1
    if-eqz v0, :cond_7

    .line 291
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->A:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const v1, 0x7f0800d5

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 292
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 293
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 294
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 303
    :cond_1
    :goto_2
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->u:Landroid/widget/FrameLayout;

    .line 304
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->u:Landroid/widget/FrameLayout;

    invoke-virtual {v0, v6}, Landroid/widget/FrameLayout;->setBackgroundColor(I)V

    .line 306
    invoke-direct {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j()Z

    move-result v0

    if-nez v0, :cond_2

    .line 307
    new-instance v0, Liw;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i:Landroid/view/View;

    move-object v4, p0

    invoke-direct/range {v0 .. v5}, Liw;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    .line 308
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liw;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 313
    :cond_2
    :goto_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    return-object v0

    .line 250
    :cond_3
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i()V

    goto/16 :goto_0

    .line 281
    :cond_4
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuDisplayable()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_5

    .line 282
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->t:Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/dnm/DNMProduct;->getSkuDisplayable()Ljava/lang/String;

    move-result-object v0

    const-string v2, "1"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_9

    move v0, v1

    .line 283
    goto :goto_1

    :cond_5
    move v0, v6

    .line 286
    goto :goto_1

    :cond_6
    move v0, v6

    .line 289
    goto :goto_1

    .line 296
    :cond_7
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->o:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 297
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->p:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 298
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, v6}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 299
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-static {v1}, Lll;->b(Landroid/app/Activity;)Landroid/view/animation/Animation;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/RelativeLayout;->startAnimation(Landroid/view/animation/Animation;)V

    .line 300
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->n:Landroid/widget/RelativeLayout;

    invoke-virtual {v0, p0}, Landroid/widget/RelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_2

    .line 311
    :cond_8
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_3

    :cond_9
    move v0, v6

    goto/16 :goto_1
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 331
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 332
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 334
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    if-eqz v0, :cond_0

    .line 335
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Liw;->cancel(Z)Z

    .line 337
    :cond_0
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    if-eqz v0, :cond_5

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    if-eqz v0, :cond_5

    .line 339
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 340
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v1

    .line 341
    const-string v0, "EmptyWeddingRegistryContainer"

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;

    .line 342
    if-eqz v0, :cond_3

    .line 343
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/EmptyWeddingRegistryContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 344
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    if-eqz v1, :cond_2

    .line 345
    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWeddingRegistryList;->c()V

    .line 367
    :cond_1
    :goto_0
    return-void

    .line 346
    :cond_2
    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v1, :cond_1

    .line 347
    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->f()V

    goto :goto_0

    .line 350
    :cond_3
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f:Lnb;

    invoke-virtual {v0}, Lnb;->C()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 351
    const-string v0, "WishListFragmentContainer"

    invoke-virtual {v1, v0}, Landroid/support/v4/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    .line 352
    if-eqz v0, :cond_1

    .line 353
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 354
    if-eqz v0, :cond_4

    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    if-eqz v1, :cond_4

    .line 355
    check-cast v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;->b()V

    goto :goto_0

    .line 356
    :cond_4
    if-eqz v0, :cond_1

    instance-of v1, v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    if-eqz v1, :cond_1

    .line 357
    check-cast v0, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;->f()V

    goto :goto_0

    .line 363
    :cond_5
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->B:Z

    if-nez v0, :cond_1

    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->J:Z

    if-nez v0, :cond_1

    sget-boolean v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    if-nez v0, :cond_1

    .line 364
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f:Lnb;

    invoke-virtual {v1}, Lnb;->T()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 365
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    goto :goto_0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    const/16 v1, 0x8

    .line 371
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroyView()V

    .line 372
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->y:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_0

    .line 373
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->y:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 375
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->z:Landroid/widget/LinearLayout;

    if-eqz v0, :cond_1

    .line 376
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->z:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 378
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 379
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    invoke-interface {v0}, Lqm;->c()V

    .line 381
    :cond_2
    return-void
.end method

.method public onLocationChanged(Landroid/location/Location;)V
    .locals 6

    .prologue
    .line 779
    if-eqz p1, :cond_0

    .line 780
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLatitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->a(D)V

    .line 781
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->f:Lnb;

    invoke-virtual {p1}, Landroid/location/Location;->getLongitude()D

    move-result-wide v2

    invoke-virtual {v0, v2, v3}, Lnb;->b(D)V

    .line 783
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    invoke-interface {v0}, Lqm;->d()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 784
    sget-object v0, Lahy;->b:Lahr;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->K:Lqm;

    invoke-interface {v0, v1, p0}, Lahr;->a(Lqm;Lahx;)Lqq;

    .line 786
    :cond_0
    new-instance v0, Liw;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i:Landroid/view/View;

    move-object v4, p0

    invoke-direct/range {v0 .. v5}, Liw;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    .line 787
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liw;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 788
    return-void
.end method

.method public onPause()V
    .locals 3

    .prologue
    .line 225
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onPause()V

    .line 226
    sget-boolean v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->j:Z

    if-nez v0, :cond_0

    .line 227
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 229
    :cond_0
    return-void
.end method

.method public onRefresh()V
    .locals 4

    .prologue
    .line 827
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i()V

    .line 828
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment$4;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;)V

    const-wide/16 v2, 0x5dc

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 843
    return-void
.end method

.method public onResume()V
    .locals 7

    .prologue
    const/4 v2, 0x1

    const/4 v6, 0x0

    .line 206
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 207
    invoke-static {}, Lcom/inc247/ApplicationStatusModel/ChatRunningStatus;->getChatRunning()Z

    move-result v0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->V:Z

    .line 208
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->V:Z

    if-nez v0, :cond_1

    .line 209
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->h()V

    .line 213
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v6}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 214
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    iget-boolean v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->L:Z

    if-nez v1, :cond_2

    move v1, v2

    :goto_1
    invoke-virtual {v0, v3, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 215
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 216
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 217
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 218
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->l()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 219
    new-instance v0, Liw;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->d:Landroid/app/Activity;

    sget-object v2, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->b:Ljava/lang/String;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->X:Ljava/lang/String;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i:Landroid/view/View;

    move-object v4, p0

    invoke-direct/range {v0 .. v5}, Liw;-><init>(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    .line 220
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->k:Liw;

    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v2, v6, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Liw;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 222
    :cond_0
    return-void

    .line 211
    :cond_1
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->i()V

    goto :goto_0

    :cond_2
    move v1, v6

    .line 214
    goto :goto_1
.end method
