.class public Lir;
.super Lka;
.source "SourceFile"


# static fields
.field private static a:I


# instance fields
.field private j:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

.field private k:Ljava/lang/String;

.field private l:D

.field private m:D

.field private n:I

.field private o:Ljava/lang/String;

.field private p:Ljava/lang/String;

.field private q:I

.field private r:I

.field private s:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private t:Ljava/lang/String;

.field private u:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 23
    const/4 v0, 0x0

    sput v0, Lir;->a:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDILjava/lang/String;Ljava/lang/String;IILjava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            "DDI",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            "II",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 51
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 52
    iput-object p3, p0, Lir;->g:Landroid/view/View;

    .line 53
    iput-object p4, p0, Lir;->k:Ljava/lang/String;

    .line 54
    iput-wide p5, p0, Lir;->l:D

    .line 55
    iput-wide p7, p0, Lir;->m:D

    .line 56
    iput p9, p0, Lir;->n:I

    .line 57
    iput-object p10, p0, Lir;->o:Ljava/lang/String;

    .line 58
    iput-object p11, p0, Lir;->p:Ljava/lang/String;

    .line 59
    iput p12, p0, Lir;->q:I

    .line 60
    iput p13, p0, Lir;->r:I

    .line 61
    iput-object p14, p0, Lir;->s:Ljava/util/ArrayList;

    .line 62
    move-object/from16 v0, p15

    iput-object v0, p0, Lir;->t:Ljava/lang/String;

    .line 63
    move-object/from16 v0, p16

    iput-object v0, p0, Lir;->u:Ljava/lang/String;

    .line 64
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 21
    sput p0, Lir;->a:I

    return p0
.end method

.method static synthetic a(Lir;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Lir;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic c(Lir;)Landroid/view/View;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic d(Lir;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lir;)D
    .locals 2

    .prologue
    .line 21
    iget-wide v0, p0, Lir;->l:D

    return-wide v0
.end method

.method static synthetic f(Lir;)D
    .locals 2

    .prologue
    .line 21
    iget-wide v0, p0, Lir;->m:D

    return-wide v0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 21
    sget v0, Lir;->a:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Lir;->a:I

    return v0
.end method

.method static synthetic g(Lir;)I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lir;->n:I

    return v0
.end method

.method static synthetic h(Lir;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->o:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic i(Lir;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->p:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic j(Lir;)I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lir;->q:I

    return v0
.end method

.method static synthetic k(Lir;)I
    .locals 1

    .prologue
    .line 21
    iget v0, p0, Lir;->r:I

    return v0
.end method

.method static synthetic l(Lir;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->s:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic m(Lir;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->t:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic n(Lir;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->u:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic o(Lir;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 21
    iget-object v0, p0, Lir;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 13

    .prologue
    .line 68
    iget-wide v0, p0, Lir;->l:D

    iget-wide v2, p0, Lir;->m:D

    iget v4, p0, Lir;->n:I

    iget v5, p0, Lir;->q:I

    iget v6, p0, Lir;->r:I

    iget-object v7, p0, Lir;->o:Ljava/lang/String;

    iget-object v8, p0, Lir;->p:Ljava/lang/String;

    iget-object v9, p0, Lir;->k:Ljava/lang/String;

    iget-object v10, p0, Lir;->s:Ljava/util/ArrayList;

    iget-object v11, p0, Lir;->t:Ljava/lang/String;

    iget-object v12, p0, Lir;->u:Ljava/lang/String;

    invoke-static/range {v0 .. v12}, Lfs;->a(DDIIILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    move-result-object v0

    iput-object v0, p0, Lir;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    .line 69
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 73
    iget-object v0, p0, Lir;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 74
    iget-object v0, p0, Lir;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 75
    :cond_0
    iget-object v0, p0, Lir;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    if-eqz v0, :cond_1

    .line 76
    iget-object v0, p0, Lir;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;

    iget-object v1, p0, Lir;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMSubListFragment;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;)V

    .line 78
    :cond_1
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 82
    iget-object v0, p0, Lir;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 83
    iget-object v0, p0, Lir;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 84
    :cond_0
    iget-object v0, p0, Lir;->f:Landroid/app/Activity;

    new-instance v1, Lir$1;

    invoke-direct {v1, p0}, Lir$1;-><init>(Lir;)V

    new-instance v2, Lir$2;

    invoke-direct {v2, p0}, Lir$2;-><init>(Lir;)V

    iget-boolean v3, p0, Lir;->e:Z

    sget v4, Lir;->a:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 95
    return-void
.end method
