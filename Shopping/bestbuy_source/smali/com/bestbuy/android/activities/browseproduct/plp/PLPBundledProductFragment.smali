.class public Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private c:Landroid/widget/ListView;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 27
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 29
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
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a:Landroid/app/Activity;

    .line 33
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->b:Ljava/util/ArrayList;

    .line 34
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/BBYProduct;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    new-instance v0, Leo;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a:Landroid/app/Activity;

    const v2, 0x7f0300bb

    invoke-direct {v0, v1, v2, p1}, Leo;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    .line 62
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->c:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 63
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 44
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 45
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->f:Lnb;

    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    .line 46
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "Bundle Items"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHome()V

    .line 48
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a:Landroid/app/Activity;

    .line 39
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 52
    const v0, 0x7f03001a

    invoke-virtual {p1, v0, p2, v5}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 53
    const v0, 0x7f0c0075

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->c:Landroid/widget/ListView;

    .line 54
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/FrameLayout;

    .line 55
    new-instance v2, Lhj;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->a:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPBundledProductFragment;->b:Ljava/util/ArrayList;

    invoke-direct {v2, v3, p0, v0, v4}, Lhj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 56
    sget-object v0, Lnb;->h:Ljava/util/concurrent/Executor;

    new-array v3, v5, [Ljava/lang/Void;

    invoke-virtual {v2, v0, v3}, Lhj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 57
    return-object v1
.end method
