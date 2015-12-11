.class public Lhx;
.super Lka;
.source "SourceFile"


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private k:Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

.field private l:Lcom/bestbuy/android/base/BBYBaseFragment;

.field private m:Landroid/view/View;

.field private n:Ljava/lang/String;

.field private o:I


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V
    .locals 1

    .prologue
    .line 28
    invoke-direct {p0}, Lka;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput v0, p0, Lhx;->o:I

    .line 29
    iput-object p1, p0, Lhx;->f:Landroid/app/Activity;

    .line 30
    iput-object p2, p0, Lhx;->l:Lcom/bestbuy/android/base/BBYBaseFragment;

    .line 31
    iput-object p3, p0, Lhx;->m:Landroid/view/View;

    .line 32
    iput-object p4, p0, Lhx;->a:Ljava/lang/String;

    .line 33
    iput-object p5, p0, Lhx;->j:Ljava/lang/String;

    .line 34
    iput-object p6, p0, Lhx;->n:Ljava/lang/String;

    .line 35
    return-void
.end method

.method static synthetic a(Lhx;)I
    .locals 2

    .prologue
    .line 18
    iget v0, p0, Lhx;->o:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lhx;->o:I

    return v0
.end method

.method static synthetic a(Lhx;I)I
    .locals 0

    .prologue
    .line 18
    iput p1, p0, Lhx;->o:I

    return p1
.end method

.method static synthetic b(Lhx;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic c(Lhx;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhx;->l:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic d(Lhx;)Landroid/view/View;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhx;->m:Landroid/view/View;

    return-object v0
.end method

.method static synthetic e(Lhx;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhx;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f(Lhx;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhx;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic g(Lhx;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhx;->n:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic h(Lhx;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 18
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 39
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    iget-object v1, p0, Lhx;->a:Ljava/lang/String;

    iget-object v2, p0, Lhx;->j:Ljava/lang/String;

    iget-object v3, p0, Lhx;->n:Ljava/lang/String;

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Landroid/app/Activity;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    move-result-object v0

    iput-object v0, p0, Lhx;->k:Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    .line 40
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 44
    iget-object v0, p0, Lhx;->m:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lhx;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 46
    :cond_0
    iget-object v0, p0, Lhx;->k:Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    if-eqz v0, :cond_4

    .line 47
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    if-eqz v0, :cond_1

    .line 48
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;

    iget-object v1, p0, Lhx;->k:Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/askexpert/HelpMenuActivity;->a(Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;)V

    .line 49
    :cond_1
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    if-eqz v0, :cond_2

    .line 50
    iget-object v0, p0, Lhx;->k:Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->isBookABlueShirt()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 51
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    iget-object v1, p0, Lhx;->k:Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/blueshirt/FeatureFlagResponse;->getBookABlueShirtStores()Ljava/util/ArrayList;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a(Ljava/util/ArrayList;)V

    .line 62
    :cond_2
    :goto_0
    return-void

    .line 53
    :cond_3
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a()V

    goto :goto_0

    .line 56
    :cond_4
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    instance-of v0, v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    if-eqz v0, :cond_5

    .line 57
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/activities/blueassist/BlueAssistStoreSelectionActivity;->a()V

    goto :goto_0

    .line 59
    :cond_5
    invoke-virtual {p0}, Lhx;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 66
    iget-object v0, p0, Lhx;->m:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lhx;->m:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 68
    :cond_0
    iget-object v0, p0, Lhx;->f:Landroid/app/Activity;

    new-instance v1, Lhx$1;

    invoke-direct {v1, p0}, Lhx$1;-><init>(Lhx;)V

    new-instance v2, Lhx$2;

    invoke-direct {v2, p0}, Lhx$2;-><init>(Lhx;)V

    iget-boolean v3, p0, Lhx;->e:Z

    iget v4, p0, Lhx;->o:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    .line 79
    return-void
.end method
