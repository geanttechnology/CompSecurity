.class public Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;
.super Landroid/app/Fragment;
.source "ResultsFragment.java"


# annotations
.annotation build Landroid/annotation/TargetApi;
    value = 0xb
.end annotation


# instance fields
.field coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 25
    new-instance v0, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-direct {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;-><init>()V

    iput-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    return-void
.end method


# virtual methods
.method public onConfigurationChanged(Landroid/content/res/Configuration;)V
    .locals 1
    .param p1, "newConfig"    # Landroid/content/res/Configuration;

    .prologue
    .line 72
    invoke-super {p0, p1}, Landroid/app/Fragment;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 73
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    if-eqz v0, :cond_0

    .line 75
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0, p1}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onConfigurationChanged(Landroid/content/res/Configuration;)V

    .line 77
    :cond_0
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 30
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 31
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 1
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 37
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0, p1, p2, p3}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 51
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 52
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onPause()V

    .line 53
    return-void
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 44
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 45
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onResume()V

    .line 46
    return-void
.end method

.method public onStart()V
    .locals 1

    .prologue
    .line 58
    invoke-super {p0}, Landroid/app/Fragment;->onStart()V

    .line 59
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onStart()V

    .line 60
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 65
    invoke-super {p0}, Landroid/app/Fragment;->onStop()V

    .line 66
    iget-object v0, p0, Lcom/amazon/retailsearch/android/ui/search/ResultsFragment;->coreFragment:Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;

    invoke-virtual {v0}, Lcom/amazon/retailsearch/android/ui/search/CoreResultsFragment;->onStop()V

    .line 67
    return-void
.end method
