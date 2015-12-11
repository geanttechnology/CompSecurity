.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/view/View;

.field private b:Landroid/widget/ListView;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;",
            ">;"
        }
    .end annotation
.end field

.field private g:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 30
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 28
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->g:Z

    .line 32
    return-void
.end method

.method public constructor <init>(Ljava/util/ArrayList;Z)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/pdp/ContractOption;",
            ">;Z)V"
        }
    .end annotation

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 28
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->g:Z

    .line 35
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->c:Ljava/util/ArrayList;

    .line 36
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->g:Z

    .line 37
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;)Z
    .locals 1

    .prologue
    .line 22
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->g:Z

    return v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 22
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->c:Ljava/util/ArrayList;

    return-object v0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 3

    .prologue
    .line 46
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 48
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 41
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 42
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->d:Landroid/app/Activity;

    .line 43
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 51
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 52
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->a:Landroid/view/View;

    if-nez v0, :cond_1

    .line 57
    const v0, 0x7f030094

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->a:Landroid/view/View;

    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->a:Landroid/view/View;

    const v1, 0x7f0c0244

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->b:Landroid/widget/ListView;

    .line 59
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->g:Z

    if-eqz v0, :cond_0

    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->b:Landroid/widget/ListView;

    const v1, 0x7f0b004f

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setSelector(I)V

    .line 61
    :cond_0
    new-instance v0, Lei;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->d:Landroid/app/Activity;

    const v2, 0x7f030095

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->c:Ljava/util/ArrayList;

    iget-boolean v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->g:Z

    invoke-direct {v0, v1, v2, v3, v4}, Lei;-><init>(Landroid/content/Context;ILjava/util/ArrayList;Z)V

    .line 62
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->b:Landroid/widget/ListView;

    invoke-virtual {v1, v0}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 63
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->b:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment$1;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment$1;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 79
    :goto_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->a:Landroid/view/View;

    return-object v0

    .line 77
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->a:Landroid/view/View;

    invoke-virtual {v0}, Landroid/view/View;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->a:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->removeView(Landroid/view/View;)V

    goto :goto_0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 83
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 84
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOptionsSubFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 85
    return-void
.end method
