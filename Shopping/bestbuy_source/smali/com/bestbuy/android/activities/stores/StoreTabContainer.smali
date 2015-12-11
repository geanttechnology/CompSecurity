.class public Lcom/bestbuy/android/activities/stores/StoreTabContainer;
.super Lcom/bestbuy/android/activities/BaseTabContainer;
.source "SourceFile"


# instance fields
.field private a:Z

.field private b:Lnb;

.field private c:Landroid/support/v4/app/Fragment;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;-><init>()V

    .line 26
    return-void
.end method

.method private d()V
    .locals 3

    .prologue
    .line 49
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    .line 50
    sget-object v1, Llu;->bo:Ljava/lang/String;

    const-string v2, "browse,store-locator"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 51
    sget-object v1, Llu;->bp:Ljava/lang/String;

    const-string v2, "STLM"

    invoke-virtual {v0, v1, v2}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 52
    sget-object v1, Llu;->E:Ljava/lang/String;

    invoke-static {v1, v0}, Llu;->b(Ljava/lang/String;Ljava/util/HashMap;)V

    .line 53
    new-instance v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    invoke-direct {v0}, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;-><init>()V

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->c:Landroid/support/v4/app/Fragment;

    .line 54
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->c:Landroid/support/v4/app/Fragment;

    const/4 v1, 0x0

    invoke-virtual {p0, v0, v1}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->a(Landroid/support/v4/app/Fragment;Z)V

    .line 55
    return-void
.end method


# virtual methods
.method public b()Landroid/support/v4/app/Fragment;
    .locals 2

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 72
    invoke-virtual {p0}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->getChildFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    const v1, 0x7f0c009e

    invoke-virtual {v0, v1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v0

    .line 73
    :goto_0
    return-object v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 37
    invoke-super {p0, p1}, Lcom/bestbuy/android/activities/BaseTabContainer;->onActivityCreated(Landroid/os/Bundle;)V

    .line 38
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2

    .prologue
    .line 30
    invoke-static {}, Lnb;->a()Lnb;

    move-result-object v0

    iput-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->b:Lnb;

    .line 32
    const v0, 0x7f0300d3

    const/4 v1, 0x0

    invoke-virtual {p1, v0, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 58
    invoke-super {p0}, Lcom/bestbuy/android/activities/BaseTabContainer;->onResume()V

    .line 59
    iget-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->a:Z

    if-nez v0, :cond_1

    .line 60
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->a:Z

    .line 61
    invoke-direct {p0}, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->d()V

    .line 68
    :cond_0
    :goto_0
    return-void

    .line 63
    :cond_1
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->c:Landroid/support/v4/app/Fragment;

    instance-of v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    if-eqz v0, :cond_0

    sget-boolean v0, Lcom/bestbuy/android/activities/home/HomeActivity;->inStoresFragment:Z

    if-eqz v0, :cond_0

    .line 64
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->c:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a:Ldp;

    if-eqz v0, :cond_0

    .line 65
    iget-object v0, p0, Lcom/bestbuy/android/activities/stores/StoreTabContainer;->c:Landroid/support/v4/app/Fragment;

    check-cast v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;

    iget-object v0, v0, Lcom/bestbuy/android/activities/stores/StoreSearchMapFragment;->a:Ldp;

    invoke-interface {v0}, Ldp;->onStoresFramentLaunch()V

    goto :goto_0
.end method
