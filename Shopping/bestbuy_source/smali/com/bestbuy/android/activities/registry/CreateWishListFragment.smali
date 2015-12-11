.class public Lcom/bestbuy/android/activities/registry/CreateWishListFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/view/View$OnClickListener;
.implements Lcg;


# instance fields
.field private a:Lcp;

.field private b:Landroid/widget/ListView;

.field private c:Ljava/lang/String;

.field private g:Landroid/view/View;

.field private h:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

.field private i:Landroid/widget/TableLayout;

.field private j:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 41
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 37
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->h:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 43
    return-void
.end method

.method public constructor <init>(Ljava/lang/String;Z)V
    .locals 1

    .prologue
    .line 53
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 37
    new-instance v0, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    invoke-direct {v0}, Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->h:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    .line 54
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->c:Ljava/lang/String;

    .line 55
    iput-boolean p2, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->j:Z

    .line 56
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->h:Lcom/bestbuy/android/api/lib/models/registry/WishListReqData;

    return-object v0
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;)Ljava/lang/String;
    .locals 1

    .prologue
    .line 31
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->c:Ljava/lang/String;

    return-object v0
.end method


# virtual methods
.method public a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/ListTypes;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 96
    new-instance v0, Lcp;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->d:Landroid/app/Activity;

    const v2, 0x7f030116

    invoke-direct {v0, v1, v2, p1}, Lcp;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a:Lcp;

    .line 97
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->b:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->a:Lcp;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->b:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;

    invoke-direct {v1, p0, p1}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/CreateWishListFragment;Ljava/util/ArrayList;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 129
    return-void
.end method

.method public g()V
    .locals 0

    .prologue
    .line 134
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 2

    .prologue
    .line 60
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 61
    check-cast v0, Landroid/support/v4/app/FragmentActivity;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->d:Landroid/app/Activity;

    move-object v0, p1

    .line 62
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f080337

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    move-object v0, p1

    .line 63
    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0, p1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 64
    sget-object v0, Llu;->K:Ljava/lang/String;

    invoke-static {v0}, Llu;->a(Ljava/lang/String;)V

    .line 65
    return-void
.end method

.method public onClick(Landroid/view/View;)V
    .locals 0

    .prologue
    .line 139
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 69
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 70
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5

    .prologue
    const/4 v4, 0x0

    .line 84
    const v0, 0x7f030027

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 85
    const v0, 0x7f0c0076

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TableLayout;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->i:Landroid/widget/TableLayout;

    .line 86
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->g:Landroid/view/View;

    .line 87
    if-eqz v1, :cond_0

    .line 88
    const v0, 0x7f0c004d

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->b:Landroid/widget/ListView;

    .line 89
    new-instance v0, Lje;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->d:Landroid/app/Activity;

    iget-object v3, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->g:Landroid/view/View;

    invoke-direct {v0, v2, p0, v3}, Lje;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v2, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v3, v4, [Ljava/lang/Void;

    invoke-virtual {v0, v2, v3}, Lje;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 91
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->i:Landroid/widget/TableLayout;

    invoke-virtual {v0, p0}, Landroid/widget/TableLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 92
    return-object v1
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 74
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 75
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 76
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const v1, 0x7f080337

    invoke-virtual {p0, v1}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 77
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 78
    return-void
.end method
