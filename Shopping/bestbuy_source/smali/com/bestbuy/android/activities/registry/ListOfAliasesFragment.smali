.class public Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Lcg;


# instance fields
.field private a:Lcn;

.field private b:Landroid/widget/ListView;

.field private c:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/AliasesList;",
            ">;"
        }
    .end annotation
.end field

.field private g:Landroid/view/View;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 34
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 36
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)Ljava/util/ArrayList;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->c:Ljava/util/ArrayList;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)Lcn;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->a:Lcn;

    return-object v0
.end method

.method static synthetic c(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 27
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->g:Landroid/view/View;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;Ljava/lang/String;)V
    .locals 7
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Ljava/lang/String;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    const/4 v1, 0x1

    .line 102
    new-instance v0, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;

    const-string v2, "PLP"

    const-string v5, ""

    const/16 v6, 0x14

    move-object v3, p2

    move-object v4, p1

    invoke-direct/range {v0 .. v6}, Lcom/bestbuy/android/activities/browseproduct/plp/PLPFragment;-><init>(ZLjava/lang/String;Ljava/lang/String;Ljava/util/ArrayList;Ljava/lang/String;I)V

    .line 103
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v2

    .line 104
    instance-of v3, v2, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v3, :cond_1

    .line 105
    check-cast v2, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 109
    :cond_0
    :goto_0
    return-void

    .line 106
    :cond_1
    instance-of v3, v2, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v3, :cond_0

    .line 107
    check-cast v2, Lcom/bestbuy/android/base/BaseFragmentContainer;

    invoke-virtual {v2, v0, v1}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    goto :goto_0
.end method

.method public g()V
    .locals 0

    .prologue
    .line 114
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 44
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 45
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->d:Landroid/app/Activity;

    .line 46
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v1

    move-object v0, p1

    .line 47
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->getCurrentActionBarTitle()Ljava/lang/String;

    move-result-object v0

    .line 49
    invoke-virtual {v1, v0}, Lnb;->i(Ljava/lang/String;)V

    move-object v0, p1

    .line 50
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f0801ec

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 51
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 52
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 56
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 57
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    .line 71
    const v0, 0x7f030008

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 73
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->g:Landroid/view/View;

    .line 74
    if-eqz v1, :cond_0

    .line 75
    const v0, 0x7f0c004d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->b:Landroid/widget/ListView;

    .line 76
    new-instance v0, Lcn;

    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    const v3, 0x7f030007

    iget-object v4, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->c:Ljava/util/ArrayList;

    invoke-direct {v0, v2, v3, v4}, Lcn;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->a:Lcn;

    .line 78
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->b:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->a:Lcn;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 80
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->b:Landroid/widget/ListView;

    new-instance v2, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;)V

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 98
    :cond_0
    return-object v1
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 61
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 62
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f0801ec

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/ListOfAliasesFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 65
    return-void
.end method
