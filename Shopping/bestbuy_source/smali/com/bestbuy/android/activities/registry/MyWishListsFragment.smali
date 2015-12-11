.class public Lcom/bestbuy/android/activities/registry/MyWishListsFragment;
.super Lcom/bestbuy/android/base/BBYBaseFragment;
.source "SourceFile"

# interfaces
.implements Landroid/support/v4/widget/SwipeRefreshLayout$OnRefreshListener;
.implements Lcg;


# static fields
.field public static a:Z


# instance fields
.field private b:Lde;

.field private c:Landroid/widget/ListView;

.field private g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

.field private h:Landroid/view/View;

.field private i:Landroid/view/View;

.field private j:Ljava/lang/String;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 50
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 51
    const/4 v0, 0x0

    sput-boolean v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a:Z

    .line 52
    return-void
.end method

.method public constructor <init>(ZLjava/lang/String;)V
    .locals 0

    .prologue
    .line 54
    invoke-direct {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;-><init>()V

    .line 55
    sput-boolean p1, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a:Z

    .line 56
    iput-object p2, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->j:Ljava/lang/String;

    .line 57
    return-void
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/MyWishListsFragment;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object v0
.end method

.method static synthetic a(Lcom/bestbuy/android/activities/registry/MyWishListsFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;
    .locals 0

    .prologue
    .line 38
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    return-object p1
.end method

.method static synthetic b(Lcom/bestbuy/android/activities/registry/MyWishListsFragment;)Landroid/view/View;
    .locals 1

    .prologue
    .line 38
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->h:Landroid/view/View;

    return-object v0
.end method

.method private b()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 96
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->l(Z)V

    .line 97
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->j(Z)V

    .line 98
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    invoke-virtual {v0, v1}, Lnb;->k(Z)V

    .line 99
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->f:Lnb;

    invoke-virtual {v0, v1}, Lnb;->b(Z)V

    .line 100
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->f:Lnb;

    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    invoke-virtual {v0, v1}, Lnb;->a(Ljava/util/ArrayList;)V

    .line 101
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->f:Lnb;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lnb;->e(Ljava/lang/String;)V

    .line 102
    return-void
.end method


# virtual methods
.method public a(Lcom/bestbuy/android/base/BaseFragmentContainer;)V
    .locals 3

    .prologue
    .line 185
    new-instance v0, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v0, v1}, Lcom/bestbuy/android/activities/registry/MyEmptyWishListFragment;-><init>(Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;)V

    .line 186
    const/4 v1, 0x1

    const-string v2, "MyEmptyWishListFragment"

    invoke-virtual {p1, v0, v1, v2}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 187
    return-void
.end method

.method public a(Ljava/lang/String;)V
    .locals 5

    .prologue
    const/4 v4, 0x1

    .line 190
    .line 191
    if-eqz p1, :cond_2

    invoke-virtual {p1}, Ljava/lang/String;->isEmpty()Z

    move-result v0

    if-nez v0, :cond_2

    .line 192
    new-instance v0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-direct {v0, p1, v4}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;-><init>(Ljava/lang/String;Z)V

    move-object v2, v0

    .line 196
    :goto_0
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    .line 197
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/WishListFragmentContainer;

    if-eqz v0, :cond_0

    move-object v0, v1

    .line 198
    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v3, "CreateWishListFragment"

    invoke-virtual {v0, v2, v4, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 200
    :cond_0
    instance-of v0, v1, Lcom/bestbuy/android/activities/registry/RegistryFragmentContainer;

    if-eqz v0, :cond_1

    .line 201
    check-cast v1, Lcom/bestbuy/android/base/BaseFragmentContainer;

    const-string v0, "CreateWishListFragment"

    invoke-virtual {v1, v2, v4, v0}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 203
    :cond_1
    return-void

    .line 194
    :cond_2
    new-instance v0, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/registry/CreateWishListFragment;-><init>()V

    move-object v2, v0

    goto :goto_0
.end method

.method public a(Ljava/util/ArrayList;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 151
    invoke-static {p1}, Ljava/util/Collections;->sort(Ljava/util/List;)V

    .line 152
    new-instance v0, Lde;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    const v2, 0x7f03006d

    invoke-direct {v0, v1, v2, p1}, Lde;-><init>(Landroid/app/Activity;ILjava/util/ArrayList;)V

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->b:Lde;

    .line 153
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->c:Landroid/widget/ListView;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->b:Lde;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 154
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->c:Landroid/widget/ListView;

    new-instance v1, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$3;

    invoke-direct {v1, p0, p1}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$3;-><init>(Lcom/bestbuy/android/activities/registry/MyWishListsFragment;Ljava/util/ArrayList;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 166
    return-void
.end method

.method public b(Ljava/util/ArrayList;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/ArrayList",
            "<",
            "Lcom/bestbuy/android/api/lib/models/registry/Entities;",
            ">;)V"
        }
    .end annotation

    .prologue
    const/4 v4, 0x0

    .line 169
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-virtual {v0}, Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;->getType()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v1

    .line 170
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->c:Landroid/widget/ListView;

    const/4 v2, 0x4

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setVisibility(I)V

    .line 171
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->getParentFragment()Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BaseFragmentContainer;

    .line 173
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Ljava/util/ArrayList;->size()I

    move-result v2

    if-lez v2, :cond_0

    .line 174
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Llu;->L:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Llu;->a(Ljava/lang/String;)V

    .line 175
    new-instance v1, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->g:Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;

    invoke-direct {v1, p0, v2, p1}, Lcom/bestbuy/android/activities/registry/WishListWithProductsFragment;-><init>(Lcom/bestbuy/android/base/BBYBaseFragment;Lcom/bestbuy/android/api/lib/models/registry/RegistryWishList;Ljava/util/ArrayList;)V

    .line 176
    const/4 v2, 0x1

    const-string v3, "WishListWithProductsFragment"

    invoke-virtual {v0, v1, v2, v3}, Lcom/bestbuy/android/base/BaseFragmentContainer;->a(Landroid/support/v4/app/Fragment;ZLjava/lang/String;)V

    .line 181
    :goto_0
    return-void

    .line 178
    :cond_0
    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v3, Llu;->y:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v1}, Ljava/lang/String;->length()I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-virtual {v1, v4, v3}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Llu;->a(Ljava/lang/String;)V

    .line 179
    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a(Lcom/bestbuy/android/base/BaseFragmentContainer;)V

    goto :goto_0
.end method

.method public g()V
    .locals 0

    .prologue
    .line 227
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 127
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 128
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    invoke-virtual {v0, p0, v1, v3}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 129
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 130
    sget-boolean v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a:Z

    if-nez v0, :cond_0

    .line 131
    new-instance v0, Ljf;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->h:Landroid/view/View;

    invoke-direct {v0, v1, p0, v2}, Ljf;-><init>(Landroid/app/Activity;Lcom/bestbuy/android/base/BBYBaseFragment;Landroid/view/View;)V

    sget-object v1, Lnb;->g:Ljava/util/concurrent/Executor;

    new-array v2, v3, [Ljava/lang/Void;

    invoke-virtual {v0, v1, v2}, Ljf;->executeOnExecutor(Ljava/util/concurrent/Executor;[Ljava/lang/Object;)Landroid/os/AsyncTask;

    .line 135
    :goto_0
    return-void

    .line 133
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->j:Ljava/lang/String;

    invoke-virtual {p0, v0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 3

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onAttach(Landroid/app/Activity;)V

    .line 74
    iput-object p1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    .line 75
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 76
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "profile,lifeEvents,dashboard"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 77
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "LE"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 78
    sget-object v1, Llu;->z:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 79
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 83
    invoke-super {p0, p1}, Lcom/bestbuy/android/base/BBYBaseFragment;->onCreate(Landroid/os/Bundle;)V

    .line 84
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 106
    const v0, 0x7f03006c

    invoke-virtual {p1, v0, p2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v1

    .line 107
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    const-string v2, "input_method"

    invoke-virtual {v0, v2}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/view/inputmethod/InputMethodManager;

    .line 108
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v2

    if-eqz v2, :cond_0

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 109
    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v2}, Landroid/app/Activity;->getCurrentFocus()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getWindowToken()Landroid/os/IBinder;

    move-result-object v2

    invoke-virtual {v0, v2, v3}, Landroid/view/inputmethod/InputMethodManager;->hideSoftInputFromWindow(Landroid/os/IBinder;I)Z

    .line 111
    :cond_0
    const v0, 0x7f03011a

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->i:Landroid/view/View;

    .line 112
    const v0, 0x7f0c0181

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->c:Landroid/widget/ListView;

    .line 113
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->c:Landroid/widget/ListView;

    const/4 v2, 0x1

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->setLongClickable(Z)V

    .line 114
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->c:Landroid/widget/ListView;

    iget-object v2, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->i:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/widget/ListView;->addFooterView(Landroid/view/View;)V

    .line 115
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->i:Landroid/view/View;

    new-instance v2, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$1;

    invoke-direct {v2, p0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$1;-><init>(Lcom/bestbuy/android/activities/registry/MyWishListsFragment;)V

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 121
    const v0, 0x7f0c0064

    invoke-virtual {v1, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->h:Landroid/view/View;

    .line 122
    return-object v1
.end method

.method public onDestroy()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 207
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onDestroy()V

    .line 208
    sget-boolean v0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->a:Z

    if-eqz v0, :cond_0

    .line 210
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarAddToVisibility(Landroid/app/Activity;Z)V

    .line 211
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 212
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, ""

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 213
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1, v2}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->changeActionBarShareVisibility(Landroid/app/Activity;Z)V

    .line 217
    :goto_0
    return-void

    .line 215
    :cond_0
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    invoke-virtual {v0}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->showActionBarHome()V

    goto :goto_0
.end method

.method public onRefresh()V
    .locals 4

    .prologue
    .line 140
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    new-instance v1, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$2;

    invoke-direct {v1, p0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment$2;-><init>(Lcom/bestbuy/android/activities/registry/MyWishListsFragment;)V

    const-wide/16 v2, 0x1388

    invoke-virtual {v0, v1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 148
    return-void
.end method

.method public onResume()V
    .locals 3

    .prologue
    .line 88
    invoke-super {p0}, Lcom/bestbuy/android/base/BBYBaseFragment;->onResume()V

    .line 89
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    const-string v1, "My Wish Lists"

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->updateActionBarTitle(Ljava/lang/String;)V

    .line 90
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;

    iget-object v1, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    invoke-virtual {v0, v1}, Lcom/bestbuy/android/base/BBYBaseFragmentActivity;->hideActionBarHomeAndSearchBox(Landroid/app/Activity;)V

    .line 91
    iget-object v0, p0, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->d:Landroid/app/Activity;

    check-cast v0, Lcom/bestbuy/android/activities/home/HomeActivity;

    const-string v1, ""

    const/4 v2, 0x0

    invoke-virtual {v0, p0, v1, v2}, Lcom/bestbuy/android/activities/home/HomeActivity;->setOnLifeEventsTopNavigationListener(Lcg;Ljava/lang/String;Z)V

    .line 92
    invoke-direct {p0}, Lcom/bestbuy/android/activities/registry/MyWishListsFragment;->b()V

    .line 93
    return-void
.end method
