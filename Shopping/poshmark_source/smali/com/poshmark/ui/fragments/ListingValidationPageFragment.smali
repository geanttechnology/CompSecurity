.class public Lcom/poshmark/ui/fragments/ListingValidationPageFragment;
.super Lcom/poshmark/ui/fragments/MappPageFragment;
.source "ListingValidationPageFragment.java"


# instance fields
.field private newListing:Lcom/poshmark/data_model/models/NewListing;

.field showRefreshButton:Z


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;-><init>()V

    .line 26
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->showRefreshButton:Z

    return-void
.end method


# virtual methods
.method public cancelListing(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 80
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->finishActivity()V

    .line 81
    return-void
.end method

.method public editListing(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 0
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 70
    return-void
.end method

.method public finishedListing(Lcom/poshmark/webcommands/WebCommand;)V
    .locals 4
    .param p1, "command"    # Lcom/poshmark/webcommands/WebCommand;

    .prologue
    .line 73
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 74
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "FINISH_LISTING"

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 75
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->getTargetFragment()Landroid/support/v4/app/Fragment;

    move-result-object v1

    check-cast v1, Lcom/poshmark/ui/fragments/PMFragment;

    .line 76
    .local v1, "callingFragment":Lcom/poshmark/ui/fragments/PMFragment;
    const/4 v2, 0x2

    invoke-virtual {v1, v0, v2}, Lcom/poshmark/ui/fragments/PMFragment;->onFragmentResult(Landroid/os/Bundle;I)V

    .line 77
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 45
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 46
    return-void
.end method

.method public onActivityResult(IILandroid/content/Intent;)V
    .locals 0
    .param p1, "requestCode"    # I
    .param p2, "resultCode"    # I
    .param p3, "data"    # Landroid/content/Intent;

    .prologue
    .line 50
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/MappPageFragment;->onActivityResult(IILandroid/content/Intent;)V

    .line 51
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 30
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/MappPageFragment;->onCreate(Landroid/os/Bundle;)V

    .line 32
    const-class v0, Lcom/poshmark/data_model/models/NewListing;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/data_model/models/NewListing;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->newListing:Lcom/poshmark/data_model/models/NewListing;

    .line 33
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v1, "SHOW_REFRESH"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->showRefreshButton:Z

    .line 34
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/MappPageFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 39
    const v1, 0x7f0300d2

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 40
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onDestroy()V
    .locals 0

    .prologue
    .line 55
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->hideProgressDialog()V

    .line 56
    invoke-super {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->onDestroy()V

    .line 57
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 65
    const-string v0, "listing_validation_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingValidationPageFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 66
    return-void
.end method

.method public setupActionBar()V
    .locals 0

    .prologue
    .line 61
    invoke-super {p0}, Lcom/poshmark/ui/fragments/MappPageFragment;->setupActionBar()V

    .line 62
    return-void
.end method
