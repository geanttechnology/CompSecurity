.class public Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;
.super Landroid/support/v4/app/Fragment;
.source "CompatResultsFragment.java"


# instance fields
.field coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Landroid/support/v4/app/Fragment;-><init>()V

    .line 23
    new-instance v0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    return-void
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 70
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 71
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    if-eqz v0, :cond_0

    .line 73
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 75
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 28
    invoke-super {p0, p1}, Landroid/support/v4/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 29
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 49
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onPause()V

    .line 50
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onPause()V

    .line 51
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 42
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onResume()V

    .line 43
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onResume()V

    .line 44
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 56
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onStart()V

    .line 57
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onStart()V

    .line 58
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 63
    invoke-super {p0}, Landroid/support/v4/app/Fragment;->onStop()V

    .line 64
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/CompatResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onStop()V

    .line 65
    return-void
.end method
