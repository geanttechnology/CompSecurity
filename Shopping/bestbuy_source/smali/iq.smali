.class public Liq;
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

.field private p:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/dnm/DNMFacetFilter;",
            ">;"
        }
    .end annotation
.end field

.field private q:Ljava/lang/String;

.field private r:I

.field private s:I

.field private t:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 27
    const/4 v0, 0x0

    sput v0, Liq;->a:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/bestbuy/android/base/BBYBaseFragment;",
            "Landroid/view/View;",
            "Ljava/lang/String;",
            "DDIII",
            "Ljava/lang/String;",
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
    .line 41
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 42
    iput-object p3, p0, Liq;->g:Landroid/view/View;

    .line 43
    move-object/from16 v0, p14

    iput-object v0, p0, Liq;->q:Ljava/lang/String;

    .line 44
    iput-object p4, p0, Liq;->k:Ljava/lang/String;

    .line 45
    iput-wide p5, p0, Liq;->l:D

    .line 46
    iput-wide p7, p0, Liq;->m:D

    .line 47
    iput p9, p0, Liq;->n:I

    .line 48
    iput-object p12, p0, Liq;->o:Ljava/lang/String;

    .line 49
    move-object/from16 v0, p13

    iput-object v0, p0, Liq;->p:Ljava/util/ArrayList;

    .line 50
    iput p10, p0, Liq;->r:I

    .line 51
    iput p11, p0, Liq;->s:I

    .line 52
    move-object/from16 v0, p15

    iput-object v0, p0, Liq;->t:Ljava/lang/String;

    .line 53
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 25
    sput p0, Liq;->a:I

    return p0
.end method

.method static synthetic a(Liq;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Liq;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic c(Liq;)Landroid/view/View;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic d(Liq;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->k:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Liq;)D
    .locals 2

    .prologue
    .line 25
    iget-wide v0, p0, Liq;->l:D

    return-wide v0
.end method

.method static synthetic f(Liq;)D
    .locals 2

    .prologue
    .line 25
    iget-wide v0, p0, Liq;->m:D

    return-wide v0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 25
    sget v0, Liq;->a:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Liq;->a:I

    return v0
.end method

.method static synthetic g(Liq;)I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Liq;->n:I

    return v0
.end method

.method static synthetic h(Liq;)I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Liq;->r:I

    return v0
.end method

.method static synthetic i(Liq;)I
    .locals 1

    .prologue
    .line 25
    iget v0, p0, Liq;->s:I

    return v0
.end method

.method static synthetic j(Liq;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->o:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic k(Liq;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->p:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic l(Liq;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->q:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic m(Liq;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->t:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic n(Liq;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 25
    iget-object v0, p0, Liq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 13

    .prologue
    .line 57
    iget-object v1, p0, Liq;->k:Ljava/lang/String;

    iget-wide v2, p0, Liq;->l:D

    iget-wide v4, p0, Liq;->m:D

    iget v6, p0, Liq;->n:I

    iget v7, p0, Liq;->r:I

    iget v8, p0, Liq;->s:I

    iget-object v9, p0, Liq;->o:Ljava/lang/String;

    iget-object v10, p0, Liq;->p:Ljava/util/ArrayList;

    iget-object v11, p0, Liq;->q:Ljava/lang/String;

    iget-object v12, p0, Liq;->t:Ljava/lang/String;

    invoke-static/range {v1 .. v12}, Lfs;->a(Ljava/lang/String;DDIIILjava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    move-result-object v0

    iput-object v0, p0, Liq;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    .line 58
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 62
    iget-object v0, p0, Liq;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 63
    iget-object v0, p0, Liq;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 65
    :cond_0
    iget-object v0, p0, Liq;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    if-nez v0, :cond_2

    .line 66
    invoke-virtual {p0}, Liq;->c()V

    .line 73
    :cond_1
    :goto_0
    return-void

    .line 68
    :cond_2
    const/4 v0, 0x0

    sput v0, Liq;->a:I

    .line 69
    iget-object v0, p0, Liq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    if-eqz v0, :cond_1

    .line 70
    iget-object v0, p0, Liq;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/dnm/DNMListFragment;

    iget-object v1, p0, Liq;->j:Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/dnm/DNMListFragment;->a(Lcom/bestbuy/android/api/lib/models/dnm/DNMResponse;)V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 77
    iget-object v0, p0, Liq;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 78
    iget-object v0, p0, Liq;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 79
    :cond_0
    iget v0, p0, Liq;->r:I

    const/4 v1, 0x1

    if-le v0, v1, :cond_1

    .line 106
    :goto_0
    return-void

    .line 82
    :cond_1
    iget-object v0, p0, Liq;->f:Landroid/app/Activity;

    new-instance v1, Liq$1;

    invoke-direct {v1, p0}, Liq$1;-><init>(Liq;)V

    new-instance v2, Liq$2;

    invoke-direct {v2, p0}, Liq$2;-><init>(Liq;)V

    iget-boolean v3, p0, Liq;->e:Z

    sget v4, Liq;->a:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    goto :goto_0
.end method
