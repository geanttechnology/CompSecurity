.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

.field private c:Landroid/view/View;

.field private g:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

.field private h:Lek;

.field private i:I

.field private j:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 30
    return-void
.end method

.method public constructor <init>(ILcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/util/ArrayList;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I",
            "Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 32
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 33
    iput-object p2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    .line 34
    iput p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->i:I

    .line 35
    iput-object p3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->j:Ljava/util/ArrayList;

    .line 36
    return-void
.end method


# virtual methods
.method public b()Lek;
    .locals 1

    .prologue
    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->h:Lek;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 6

    .prologue
    .line 47
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 49
    new-instance v0, Lek;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->g:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->a:Landroid/app/Activity;

    iget-object v4, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    iget-object v5, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->j:Ljava/util/ArrayList;

    move-object v1, p0

    invoke-direct/range {v0 .. v5}, Lek;-><init>(Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;Landroid/widget/ExpandableListView;Landroid/content/Context;Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;Ljava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->h:Lek;

    .line 50
    new-instance v0, Lfd;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->h:Lek;

    invoke-direct {v0, v1}, Lfd;-><init>(Landroid/widget/ExpandableListAdapter;)V

    .line 51
    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->g:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    invoke-virtual {v1, v0}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setAdapter(Lfd;)V

    .line 52
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->g:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->i:I

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->expandGroup(I)Z

    .line 53
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->g:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iget v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->i:I

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;->setSelectedGroup(I)V

    .line 54
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 40
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->a:Landroid/app/Activity;

    .line 42
    check-cast p1, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v0

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v0

    const/16 v1, 0xf

    invoke-virtual {p1, v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateOverviewActionBarTitle(Ljava/lang/String;I)V

    .line 43
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 58
    const v0, 0x7f0300a4

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->c:Landroid/view/View;

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->c:Landroid/view/View;

    const v1, 0x7f0c0256

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->g:Lcom/bestbuy/android/activities/browseproduct/pdp/StickyGroupExpandableListView;

    .line 60
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->c:Landroid/view/View;

    return-object v0
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    .line 68
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 69
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->d:Landroid/app/Activity;

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 70
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 73
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 74
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPOverviewDetailListFragment;->b:Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/pdp/OverviewResponse;->getNames()Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;

    move-result-object v1

    invoke-virtual {v1}, Lcom/bestbuy/android/api/lib/models/summariesNpriceBlock/Names;->getShortName()Ljava/lang/String;

    move-result-object v1

    const/16 v2, 0xf

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateOverviewActionBarTitle(Ljava/lang/String;I)V

    .line 75
    return-void
.end method
