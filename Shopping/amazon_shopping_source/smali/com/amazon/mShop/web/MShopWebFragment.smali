.class public Lcom/amazon/mShop/web/MShopWebFragment;
.super Landroid/support/v4/app/Fragment;
.source "MShopWebFragment.java"


# instance fields
.field private mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 11
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    return-void
.end method

.method public static add(Landroid/support/v4/app/FragmentManager;I)Lcom/amazon/mShop/web/MShopWebFragment;
    .locals 2
    .param p0, "manager"    # Landroid/support/v4/app/FragmentManager;
    .param p1, "containerId"    # I

    .prologue
    .line 67
    invoke-virtual {p0, p1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    if-eqz v1, :cond_0

    .line 68
    invoke-virtual {p0, p1}, Landroid/support/v4/app/FragmentManager;->findFragmentById(I)Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/amazon/mShop/web/MShopWebFragment;

    .line 75
    :goto_0
    return-object v1

    .line 70
    :cond_0
    new-instance v0, Lcom/amazon/mShop/web/MShopWebFragment;

    invoke-direct {v0}, Lcom/amazon/mShop/web/MShopWebFragment;-><init>()V

    .line 71
    .local v0, "fragment":Lcom/amazon/mShop/web/MShopWebFragment;
    invoke-virtual {p0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1, p1, v0}, Landroid/support/v4/app/FragmentTransaction;->add(ILandroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/support/v4/app/FragmentTransaction;->commit()I

    move-object v1, v0

    .line 75
    goto :goto_0
.end method


# virtual methods
.method public attach()V
    .locals 1

    .prologue
    .line 92
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentTransaction;->attach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 96
    return-void
.end method

.method public detach()V
    .locals 1

    .prologue
    .line 82
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebFragment;->getFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentManager;->beginTransaction()Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0, p0}, Landroid/support/v4/app/FragmentTransaction;->detach(Landroid/support/v4/app/Fragment;)Landroid/support/v4/app/FragmentTransaction;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 86
    return-void
.end method

.method public getContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;
    .locals 1

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    return-object v0
.end method

.method public initWebViewContainer(Lcom/amazon/mShop/web/MShopWebActivity;)V
    .locals 1
    .param p1, "activity"    # Lcom/amazon/mShop/web/MShopWebActivity;

    .prologue
    .line 103
    invoke-virtual {p1}, Lcom/amazon/mShop/web/MShopWebActivity;->createWebViewContainer()Lcom/amazon/mShop/web/MShopWebViewContainer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    .line 104
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 18
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    if-nez v2, :cond_0

    .line 19
    invoke-virtual {p0}, Lcom/amazon/mShop/web/MShopWebFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    check-cast v2, Lcom/amazon/mShop/web/MShopWebActivity;

    invoke-virtual {p0, v2}, Lcom/amazon/mShop/web/MShopWebFragment;->initWebViewContainer(Lcom/amazon/mShop/web/MShopWebActivity;)V

    .line 29
    :cond_0
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v2}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getParent()Landroid/view/ViewParent;

    move-result-object v0

    .line 30
    .local v0, "parent":Landroid/view/ViewParent;
    if-eqz v0, :cond_1

    instance-of v2, v0, Landroid/view/ViewGroup;

    if-eqz v2, :cond_1

    move-object v1, v0

    .line 31
    check-cast v1, Landroid/view/ViewGroup;

    .line 32
    .local v1, "parentGroup":Landroid/view/ViewGroup;
    invoke-virtual {v1}, Landroid/view/ViewGroup;->removeAllViews()V

    .line 34
    .end local v1    # "parentGroup":Landroid/view/ViewGroup;
    :cond_1
    iget-object v2, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    return-object v2
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 57
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onDestroy()V

    .line 58
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 59
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->destroy()V

    .line 61
    :cond_0
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 45
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 46
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->onPause()V

    .line 47
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 39
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 40
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/webkit/WebView;->onResume()V

    .line 41
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 51
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 52
    iget-object v0, p0, Lcom/amazon/mShop/web/MShopWebFragment;->mContainer:Lcom/amazon/mShop/web/MShopWebViewContainer;

    invoke-virtual {v0}, Lcom/amazon/mShop/web/MShopWebViewContainer;->getWebView()Landroid/webkit/WebView;

    move-result-object v0

    invoke-virtual {v0, p1}, Landroid/webkit/WebView;->saveState(Landroid/os/Bundle;)Landroid/webkit/WebBackForwardList;

    .line 53
    return-void
.end method
