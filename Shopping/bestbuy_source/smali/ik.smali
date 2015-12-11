.class public Lik;
.super Lka;
.source "SourceFile"


# static fields
.field private static k:I


# instance fields
.field private a:Ljava/lang/String;

.field private j:Ljava/lang/String;

.field private l:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/store/BBYStore;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 22
    const/4 v0, 0x0

    sput v0, Lik;->k:I

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/lang/String;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0, p1, p2, p3}, Lka;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    .line 29
    iput-object p5, p0, Lik;->a:Ljava/lang/String;

    .line 30
    iput-object p4, p0, Lik;->j:Ljava/lang/String;

    .line 31
    return-void
.end method

.method static synthetic a(I)I
    .locals 0

    .prologue
    .line 19
    sput p0, Lik;->k:I

    return p0
.end method

.method static synthetic a(Lik;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lik;->f:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic b(Lik;)Lcom/bestbuy/android/base/BBYBaseFragment;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    return-object v0
.end method

.method static synthetic c(Lik;)Landroid/view/View;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lik;->g:Landroid/view/View;

    return-object v0
.end method

.method static synthetic d(Lik;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lik;->j:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic e(Lik;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 19
    iget-object v0, p0, Lik;->a:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic f()I
    .locals 2

    .prologue
    .line 19
    sget v0, Lik;->k:I

    add-int/lit8 v1, v0, 0x1

    sput v1, Lik;->k:I

    return v0
.end method


# virtual methods
.method public a()V
    .locals 4

    .prologue
    .line 43
    iget-object v0, p0, Lik;->j:Ljava/lang/String;

    iget-object v1, p0, Lik;->a:Ljava/lang/String;

    const/4 v2, 0x0

    const/16 v3, 0x19

    invoke-static {v0, v1, v2, v3}, Lfs;->a(Ljava/lang/String;Ljava/lang/String;II)Lcom/bestbuy/android/api/lib/models/remix/StoreList;

    move-result-object v0

    .line 44
    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/remix/StoreList;->getStores()Ljava/util/ArrayList;

    move-result-object v0

    iput-object v0, p0, Lik;->l:Ljava/util/ArrayList;

    .line 45
    return-void
.end method

.method public b()V
    .locals 2

    .prologue
    .line 49
    const/4 v0, 0x0

    sput v0, Lik;->k:I

    .line 50
    iget-object v0, p0, Lik;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 51
    iget-object v0, p0, Lik;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 53
    :cond_0
    iget-object v0, p0, Lik;->l:Ljava/util/ArrayList;

    if-eqz v0, :cond_3

    .line 54
    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPAvailabilityFragment;

    if-eqz v0, :cond_2

    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 62
    :cond_1
    :goto_0
    return-void

    .line 56
    :cond_2
    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 57
    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Lik;->l:Ljava/util/ArrayList;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Ljava/util/ArrayList;)V

    goto :goto_0

    .line 60
    :cond_3
    invoke-virtual {p0}, Lik;->c()V

    goto :goto_0
.end method

.method public c()V
    .locals 5

    .prologue
    .line 66
    iget-object v0, p0, Lik;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 67
    iget-object v0, p0, Lik;->g:Landroid/view/View;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 69
    :cond_0
    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragment;->isAdded()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 70
    iget-object v0, p0, Lik;->i:Lcom/bestbuy/android/base/BBYBaseFragment;

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;

    iget-object v1, p0, Lik;->j:Ljava/lang/String;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/ProductAvailabilityFragment;->a(Ljava/lang/String;)V

    .line 83
    :goto_0
    return-void

    .line 72
    :cond_1
    iget-object v0, p0, Lik;->f:Landroid/app/Activity;

    new-instance v1, Lik$1;

    invoke-direct {v1, p0}, Lik$1;-><init>(Lik;)V

    new-instance v2, Lik$2;

    invoke-direct {v2, p0}, Lik$2;-><init>(Lik;)V

    iget-boolean v3, p0, Lik;->e:Z

    sget v4, Lik;->k:I

    invoke-static {v0, v1, v2, v3, v4}, Lnm;->a(Landroid/content/Context;Lno;Lnn;ZI)V

    goto :goto_0
.end method

.method public onPreExecute()V
    .locals 2

    .prologue
    .line 34
    invoke-super {p0}, Lka;->onPreExecute()V

    .line 35
    iget-object v0, p0, Lik;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 36
    iget-object v0, p0, Lik;->g:Landroid/view/View;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 38
    :cond_0
    return-void
.end method
