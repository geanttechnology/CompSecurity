.class public Lla;
.super Landroid/app/Dialog;
.source "SourceFile"


# instance fields
.field private a:Landroid/content/Context;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;"
        }
    .end annotation
.end field

.field private c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private d:[Ljava/lang/String;

.field private e:[Ljava/lang/String;

.field private f:Landroid/widget/ListView;

.field private g:Landroid/view/View;

.field private h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

.field private l:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;"
        }
    .end annotation
.end field

.field private m:Ljava/util/HashMap;
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

.field private n:Ljava/lang/String;

.field private o:Landroid/support/v4/app/Fragment;

.field private p:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private q:Z

.field private r:Ljava/lang/String;


# direct methods
.method public constructor <init>(Landroid/content/Context;Landroid/support/v4/app/Fragment;Ljava/util/HashMap;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/content/Context;",
            "Landroid/support/v4/app/Fragment;",
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Ljava/lang/Object;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 58
    const v0, 0x7f0e002b

    invoke-direct {p0, p1, v0}, Landroid/app/Dialog;-><init>(Landroid/content/Context;I)V

    .line 50
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lla;->m:Ljava/util/HashMap;

    .line 59
    iput-object p1, p0, Lla;->a:Landroid/content/Context;

    .line 60
    iput-object p2, p0, Lla;->o:Landroid/support/v4/app/Fragment;

    .line 61
    iput-object p3, p0, Lla;->l:Ljava/util/HashMap;

    .line 62
    return-void
.end method

.method static synthetic a(Lla;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lla;->p:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object p1
.end method

.method static synthetic a(Lla;Ljava/lang/String;)Ljava/lang/String;
    .locals 0

    .prologue
    .line 39
    iput-object p1, p0, Lla;->n:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic a(Lla;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->l:Ljava/util/HashMap;

    return-object v0
.end method

.method private a()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    .line 187
    iget-object v0, p0, Lla;->o:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    if-eqz v0, :cond_1

    .line 188
    iget-object v0, p0, Lla;->o:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    instance-of v0, v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    if-eqz v0, :cond_0

    .line 189
    iget-object v0, p0, Lla;->o:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeTabFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeTabFragment;->e()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/BaseTabContainer;

    .line 190
    invoke-virtual {v0}, Lcom/bestbuy/android/activities/BaseTabContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 191
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v1, :cond_0

    .line 192
    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 193
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v1, :cond_0

    .line 195
    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Z)V

    .line 206
    :cond_0
    :goto_0
    return-void

    .line 199
    :cond_1
    iget-object v0, p0, Lla;->o:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    if-eqz v0, :cond_0

    .line 200
    iget-object v0, p0, Lla;->o:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragmentContainer;->b()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    .line 201
    instance-of v1, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;

    if-eqz v1, :cond_0

    .line 203
    invoke-virtual {v0, v2}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPFragment;->a(Z)V

    goto :goto_0
.end method

.method static synthetic a(Lla;Z)Z
    .locals 0

    .prologue
    .line 39
    iput-boolean p1, p0, Lla;->q:Z

    return p1
.end method

.method static synthetic b(Lla;)Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->p:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    return-object v0
.end method

.method private b()V
    .locals 3

    .prologue
    .line 209
    iget-object v0, p0, Lla;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    const-string v1, "+ Create a New Wedding Registry"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 210
    iget-object v0, p0, Lla;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lla;->a:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    const/high16 v2, 0x7f0b0000

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getColor(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setTextColor(I)V

    .line 211
    iget-object v0, p0, Lla;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Lla$4;

    invoke-direct {v1, p0}, Lla$4;-><init>(Lla;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 236
    return-void
.end method

.method static synthetic c(Lla;)V
    .locals 0

    .prologue
    .line 39
    invoke-direct {p0}, Lla;->a()V

    return-void
.end method

.method static synthetic d(Lla;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->n:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lla;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->a:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic f(Lla;)Landroid/support/v4/app/Fragment;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->o:Landroid/support/v4/app/Fragment;

    return-object v0
.end method

.method static synthetic g(Lla;)Landroid/view/View;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic h(Lla;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method

.method static synthetic i(Lla;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic j(Lla;)[Ljava/lang/String;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->e:[Ljava/lang/String;

    return-object v0
.end method

.method static synthetic k(Lla;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 39
    iget-object v0, p0, Lla;->m:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic l(Lla;)Z
    .locals 1

    .prologue
    .line 39
    iget-boolean v0, p0, Lla;->q:Z

    return v0
.end method


# virtual methods
.method public onCreate(Landroid/os/Bundle;)V
    .locals 5

    .prologue
    const/16 v4, 0x8

    .line 65
    invoke-super {p0, p1}, Landroid/app/Dialog;->onCreate(Landroid/os/Bundle;)V

    .line 66
    const v0, 0x7f03002a

    invoke-virtual {p0, v0}, Lla;->setContentView(I)V

    .line 67
    const v0, 0x7f0c00b0

    invoke-virtual {p0, v0}, Lla;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lla;->h:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 68
    const v0, 0x7f0c00b3

    invoke-virtual {p0, v0}, Lla;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lla;->i:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 69
    const v0, 0x7f0c00b2

    invoke-virtual {p0, v0}, Lla;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lla;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 70
    const v0, 0x7f0c00b4

    invoke-virtual {p0, v0}, Lla;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iput-object v0, p0, Lla;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    .line 71
    const v0, 0x7f0c00b1

    invoke-virtual {p0, v0}, Lla;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lla;->f:Landroid/widget/ListView;

    .line 72
    iget-object v0, p0, Lla;->l:Ljava/util/HashMap;

    const-string v1, "WishListData"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/ArrayList;

    iput-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    .line 73
    iget-object v0, p0, Lla;->l:Ljava/util/HashMap;

    const-string v1, "RegistryData"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    iput-object v0, p0, Lla;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    .line 74
    const v0, 0x7f0c0064

    invoke-virtual {p0, v0}, Lla;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lla;->g:Landroid/view/View;

    .line 75
    iget-object v0, p0, Lla;->l:Ljava/util/HashMap;

    const-string v1, "RegistryName"

    invoke-virtual {v0, v1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    iput-object v0, p0, Lla;->r:Ljava/lang/String;

    .line 76
    iget-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lla;->d:[Ljava/lang/String;

    .line 79
    iget-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    new-array v0, v0, [Ljava/lang/String;

    iput-object v0, p0, Lla;->e:[Ljava/lang/String;

    .line 80
    const/4 v0, 0x0

    move v1, v0

    :goto_0
    iget-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    invoke-virtual {v0}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ge v1, v0, :cond_0

    .line 81
    iget-object v2, p0, Lla;->d:[Ljava/lang/String;

    iget-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v1

    .line 82
    iget-object v2, p0, Lla;->e:[Ljava/lang/String;

    iget-object v0, p0, Lla;->b:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Ljava/util/ArrayList;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getUuid()Ljava/lang/String;

    move-result-object v0

    aput-object v0, v2, v1

    .line 80
    add-int/lit8 v0, v1, 0x1

    move v1, v0

    goto :goto_0

    .line 85
    :cond_0
    iget-object v0, p0, Lla;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    if-eqz v0, :cond_4

    .line 86
    iget-object v0, p0, Lla;->r:Ljava/lang/String;

    if-eqz v0, :cond_3

    iget-object v0, p0, Lla;->r:Ljava/lang/String;

    invoke-virtual {v0}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_3

    .line 87
    iget-object v0, p0, Lla;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    iget-object v1, p0, Lla;->c:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getShortDescription()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 88
    iget-object v0, p0, Lla;->k:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Lla$1;

    invoke-direct {v1, p0}, Lla$1;-><init>(Lla;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 119
    :goto_1
    iget-object v0, p0, Lla;->j:Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Lla$2;

    invoke-direct {v1, p0}, Lla$2;-><init>(Lla;)V

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 144
    iget-object v0, p0, Lla;->d:[Ljava/lang/String;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lla;->d:[Ljava/lang/String;

    array-length v0, v0

    if-lez v0, :cond_2

    .line 145
    new-instance v0, Landroid/widget/ArrayAdapter;

    iget-object v1, p0, Lla;->a:Landroid/content/Context;

    const v2, 0x7f03010c

    iget-object v3, p0, Lla;->d:[Ljava/lang/String;

    invoke-direct {v0, v1, v2, v3}, Landroid/widget/ArrayAdapter;-><init>(Landroid/content/Context;I[Ljava/lang/Object;)V

    .line 146
    iget-object v1, p0, Lla;->f:Landroid/widget/ListView;

    invoke-virtual {v1}, Landroid/widget/ListView;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v1

    .line 147
    iget-object v2, p0, Lla;->d:[Ljava/lang/String;

    array-length v2, v2

    if-gt v2, v4, :cond_5

    .line 148
    iget-object v2, p0, Lla;->d:[Ljava/lang/String;

    array-length v2, v2

    mul-int/lit8 v2, v2, 0x1e

    int-to-float v2, v2

    invoke-static {v2}, Ljava/lang/Float;->valueOf(F)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    iget-object v3, p0, Lla;->a:Landroid/content/Context;

    invoke-static {v2, v3}, Lnf;->b(FLandroid/content/Context;)I

    move-result v2

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 149
    iget-object v2, p0, Lla;->f:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    .line 156
    :cond_1
    :goto_2
    iget-object v1, p0, Lla;->f:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 157
    iget-object v0, p0, Lla;->f:Landroid/widget/ListView;

    new-instance v1, Lla$3;

    invoke-direct {v1, p0}, Lla$3;-><init>(Lla;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 184
    :cond_2
    return-void

    .line 113
    :cond_3
    invoke-direct {p0}, Lla;->b()V

    goto :goto_1

    .line 116
    :cond_4
    invoke-direct {p0}, Lla;->b()V

    goto :goto_1

    .line 151
    :cond_5
    iget-object v2, p0, Lla;->d:[Ljava/lang/String;

    array-length v2, v2

    if-le v2, v4, :cond_1

    .line 152
    const-string v2, "250"

    invoke-static {v2}, Ljava/lang/Float;->valueOf(Ljava/lang/String;)Ljava/lang/Float;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Float;->floatValue()F

    move-result v2

    iget-object v3, p0, Lla;->a:Landroid/content/Context;

    invoke-static {v2, v3}, Lnf;->b(FLandroid/content/Context;)I

    move-result v2

    iput v2, v1, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 153
    iget-object v2, p0, Lla;->f:Landroid/widget/ListView;

    invoke-virtual {v2, v1}, Landroid/widget/ListView;->setLayoutParams(Landroid/view/ViewGroup$LayoutParams;)V

    goto :goto_2
.end method
