.class public Lis;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

.field private k:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0, p1, p2}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;)V

    .line 16
    const-class v0, Lis;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lis;->a:Ljava/lang/String;

    .line 18
    const/4 v0, 0x0

    iput v0, p0, Lis;->k:I

    .line 22
    iput-object p3, p0, Lis;->g:Landroid/view/View;

    .line 23
    return-void
.end method

.method static synthetic a(Lis;)I
    .locals 2

    .prologue
    .line 14
    iget v0, p0, Lis;->k:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lis;->k:I

    return v0
.end method

.method static synthetic a(Lis;I)I
    .locals 0

    .prologue
    .line 14
    iput p1, p0, Lis;->k:I

    return p1
.end method

.method static synthetic b(Lis;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lis;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lis;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lis;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic d(Lis;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 14
    iget-object v0, p0, Lis;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lis;->f:Landroid/app/Activity;

    invoke-static {v0}, Lgq;->a(Landroid/content/Context;)Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    move-result-object v0

    iput-object v0, p0, Lis;->j:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    .line 28
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 32
    iget-object v0, p0, Lis;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lis;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 33
    iget-object v0, p0, Lis;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeFragment;

    iget-object v1, p0, Lis;->j:Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/home/HomeFragment;->a(Lcom/bestbuy/android/api/lib/models/home/HomeFragmentResponse;)V

    .line 35
    :cond_0
    return-void
.end method

.method public c()V
    .locals 5

    .prologue
    .line 39
    iget-object v0, p0, Lis;->f:Landroid/app/Activity;

    new-instance v1, Lis$1;

    invoke-direct {v1, p0}, Lis$1;-><init>(Lis;)V

    new-instance v2, Lis$2;

    invoke-direct {v2, p0}, Lis$2;-><init>(Lis;)V

    iget-boolean v3, p0, Lis;->e:Z

    iget v4, p0, Lis;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 50
    return-void
.end method
