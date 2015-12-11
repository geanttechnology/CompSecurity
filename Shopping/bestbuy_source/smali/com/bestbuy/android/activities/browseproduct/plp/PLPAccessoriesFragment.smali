.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 29
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 31
    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a:Landroid/app/Activity;

    .line 35
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->b:Ljava/util/ArrayList;

    .line 36
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->b:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;)Landroid/app/Activity;
    .locals 1

    .prologue
    .line 24
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a:Landroid/app/Activity;

    return-object v0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 47
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Additional Accessories"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 49
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 50
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 39
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 40
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a:Landroid/app/Activity;

    .line 41
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/16 v3, 0x8

    .line 54
    const v0, 0x7f0300ba

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    .line 55
    const v0, 0x7f0c0075

    invoke-virtual {v2, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    .line 56
    const v1, 0x7f0c0064

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/FrameLayout;

    .line 57
    invoke-virtual {v1, v3}, Landroid/widget/FrameLayout;->setVisibility(I)V

    .line 58
    const v1, 0x7f0c00be

    invoke-virtual {v2, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/RelativeLayout;

    .line 59
    invoke-virtual {v1, v3}, Landroid/widget/RelativeLayout;->setVisibility(I)V

    .line 60
    new-instance v1, Lem;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->a:Landroid/app/Activity;

    const v4, 0x7f0300bb

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;->b:Ljava/util/ArrayList;

    invoke-direct {v1, v3, v4, v5}, Lem;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    .line 61
    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 62
    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/plp/PLPAccessoriesFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 84
    return-object v2
.end method
