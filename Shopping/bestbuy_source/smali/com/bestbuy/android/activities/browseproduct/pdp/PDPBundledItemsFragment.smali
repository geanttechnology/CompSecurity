.class public Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"


# instance fields
.field private a:Landroid/app/Activity;

.field private b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

.field private c:Landroid/view/View;

.field private g:Landroid/view/View;

.field private h:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private i:Ldy;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 32
    return-void
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 4
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
    const/4 v3, 0x1

    .line 70
    new-instance v0, Ldy;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->a:Landroid/app/Activity;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    invoke-direct {v0, v1, p1, v2, v3}, Ldy;-><init>(Landroid/app/Activity;Ljava/util/ArrayList;Landroid/support/v4/app/Fragment;Z)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->i:Ldy;

    .line 71
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->i:Ldy;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 72
    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v0

    if-ne v0, v3, :cond_0

    .line 73
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPagingEnabled(Z)V

    .line 74
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0210

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYTextView;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, " Items"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYTextView;->setText(Ljava/lang/String;)V

    .line 75
    return-void
.end method

.method public b()V
    .locals 1

    .prologue
    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->g:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 79
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->g:Landroid/view/View;

    invoke-static {v0}, Lll;->a(Landroid/view/View;)V

    .line 81
    :cond_0
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    .line 64
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 65
    new-instance v0, Lhj;

    iget-object v1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->a:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->c:Landroid/view/View;

    iget-object v3, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->h:Ljava/util/ArrayList;

    invoke-direct {v0, v1, p0, v2, v3}, Lhj;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;Ljava/util/ArrayList;)V

    .line 66
    sget-object v1, Lnb;->h:Ljava/util/concurrent/Executor;

    const/4 v2, 0x0

    new-array v2, v2, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Lhj;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 67
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0

    .prologue
    .line 40
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 41
    iput-object p1, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->a:Landroid/app/Activity;

    .line 42
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 55
    const v0, 0x7f03008a

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->g:Landroid/view/View;

    .line 56
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->g:Landroid/view/View;

    const v1, 0x7f0c0064

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->c:Landroid/view/View;

    .line 57
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->g:Landroid/view/View;

    const v1, 0x7f0c005e

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    iput-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    .line 58
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->b:Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;

    const/16 v1, 0xf

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/bbyobjects/BBYProductViewPager;->setPageMargin(I)V

    .line 59
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->g:Landroid/view/View;

    return-object v0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 46
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 47
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->i:Ldy;

    if-eqz v0, :cond_0

    .line 48
    iget-object v0, p0, Lcom/bestbuy/android/activities/browseproduct/pdp/PDPBundledItemsFragment;->i:Ldy;

    invoke-virtual {v0}, Ldy;->notifyDataSetChanged()V

    .line 50
    :cond_0
    return-void
.end method
