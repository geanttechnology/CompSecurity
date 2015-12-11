.class public Lit;
.super Lka;
.source "SourceFile"


# static fields
.field private static j:I


# instance fields
.field protected a:Lnb;

.field private k:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 17
    const/4 v0, 0x0

    sput v0, Lit;->j:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 18
    const/4 v0, 0x0

    iput-object v0, p0, Lit;->k:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    .line 22
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lit;->a:Lnb;

    .line 23
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 15
    sput p0, Lit;->j:I

    return p0
.end method

.method static synthetic a(Lit;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lit;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Lit;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lit;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic c(Lit;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 15
    iget-object v0, p0, Lit;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 15
    sget v0, Lit;->j:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Lit;->j:I

    return v0
.end method


# virtual methods
.method public a()V
    .locals 2

    .prologue
    .line 28
    sget-object v0, Lft;->a:Lft;

    iget-object v1, p0, Lit;->f:Landroid/app/Activity;

    invoke-static {v0, v1}, Lfs;->a(Lft;Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    move-result-object v0

    iput-object v0, p0, Lit;->k:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    .line 29
    return-void
.end method

.method public b()V
    .locals 3

    .prologue
    .line 33
    iget-object v0, p0, Lit;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lit;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 34
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->n()Llr;

    move-result-object v0

    iget-object v1, p0, Lit;->k:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    iget-object v2, p0, Lit;->f:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Llr;->a(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;Landroid/content/Context;)Z

    move-result v0

    .line 35
    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lit;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/HomeFragment;->e()V

    .line 46
    :cond_0
    :goto_0
    return-void

    .line 38
    :cond_1
    iget-object v0, p0, Lit;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/SplashFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lit;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 39
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->n()Llr;

    move-result-object v0

    iget-object v1, p0, Lit;->k:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    iget-object v2, p0, Lit;->f:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Llr;->b(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;Landroid/content/Context;)Z

    move-result v0

    .line 40
    if-eqz v0, :cond_2

    .line 41
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0}, Lnb;->n()Llr;

    move-result-object v0

    iget-object v1, p0, Lit;->k:Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;

    iget-object v2, p0, Lit;->f:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Llr;->c(Lcom/bestbuy/android/api/lib/models/releasemgt/SupportedVersionsResponse;Landroid/content/Context;)Llc;

    move-result-object v0

    invoke-virtual {v0}, Llc;->a()V

    goto :goto_0

    .line 43
    :cond_2
    iget-object v0, p0, Lit;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/SplashFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/home/SplashFragment;->b()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 50
    iget-object v0, p0, Lit;->f:Landroid/app/Activity;

    new-instance v1, Lit$1;

    invoke-direct {v1, p0}, Lit$1;-><init>(Lit;)V

    new-instance v2, Lit$2;

    invoke-direct {v2, p0}, Lit$2;-><init>(Lit;)V

    iget-boolean v3, p0, Lit;->e:Z

    sget v4, Lit;->j:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 61
    return-void
.end method
