.class public Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ListingDetailsDrawerFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# instance fields
.field addToBundleButton:Landroid/widget/Button;

.field private bUpdateViews:Z

.field deleteButtonListener:Landroid/view/View$OnClickListener;

.field deleteListingButton:Landroid/widget/Button;

.field editListingButton:Landroid/widget/Button;

.field private isItemSold:Z

.field private isListingAvailable:Z

.field layoutName:I

.field private loggedInUser:Z

.field markAsAvailableButton:Landroid/widget/Button;

.field markNotForSaleButton:Landroid/widget/Button;

.field parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

.field reportListingButton:Landroid/widget/Button;

.field viewBundleButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 26
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 39
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->bUpdateViews:Z

    .line 271
    new-instance v0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$7;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteButtonListener:Landroid/view/View$OnClickListener;

    return-void
.end method


# virtual methods
.method isListingCreatorSameAsLoggedInUser()Z
    .locals 2

    .prologue
    .line 262
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 264
    .local v0, "listingCreatorId":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 265
    const/4 v1, 0x1

    .line 267
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public logScreenTracking()V
    .locals 0

    .prologue
    .line 258
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 73
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 74
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 43
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 45
    sget-object v0, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 46
    if-nez p1, :cond_0

    .line 47
    const-class v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .line 51
    :goto_0
    return-void

    .line 49
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, p1, v1}, Landroid/support/v4/app/FragmentManager;->getFragment(Landroid/os/Bundle;Ljava/lang/String;)Landroid/support/v4/app/Fragment;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iput-object v0, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 55
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 56
    const v1, 0x7f030066

    iput v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->layoutName:I

    .line 57
    iget v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->layoutName:I

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 58
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 63
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 64
    return-void
.end method

.method public onPMResume()V
    .locals 0

    .prologue
    .line 68
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 69
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 247
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 248
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getSupportFragmentManager()Landroid/support/v4/app/FragmentManager;

    move-result-object v0

    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getFragmentId()Ljava/util/UUID;

    move-result-object v1

    invoke-virtual {v1}, Ljava/util/UUID;->toString()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v0, p1, v1, v2}, Landroid/support/v4/app/FragmentManager;->putFragment(Landroid/os/Bundle;Ljava/lang/String;Landroid/support/v4/app/Fragment;)V

    .line 249
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 253
    return-void
.end method

.method public updateDrawer(Z)V
    .locals 6
    .param p1, "bforceUpdate"    # Z

    .prologue
    const v5, 0x7f0600b8

    const/4 v4, 0x0

    const/16 v3, 0x8

    .line 78
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v0

    .line 79
    .local v0, "v":Landroid/view/View;
    if-eqz v0, :cond_1

    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->bUpdateViews:Z

    if-nez v1, :cond_0

    if-eqz p1, :cond_1

    .line 81
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0193

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->editListingButton:Landroid/widget/Button;

    .line 82
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0194

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markNotForSaleButton:Landroid/widget/Button;

    .line 83
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0195

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markAsAvailableButton:Landroid/widget/Button;

    .line 84
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0196

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    .line 85
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0191

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->reportListingButton:Landroid/widget/Button;

    .line 86
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c00ba

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    .line 87
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0192

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->addToBundleButton:Landroid/widget/Button;

    .line 90
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->isListingCreatorSameAsLoggedInUser()Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->loggedInUser:Z

    .line 91
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->isListingAvailable()Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->isListingAvailable:Z

    .line 92
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    iget-object v1, v1, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->isListingSold()Z

    move-result v1

    iput-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->isItemSold:Z

    .line 94
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->loggedInUser:Z

    if-eqz v1, :cond_4

    .line 96
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->addToBundleButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 97
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 98
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->reportListingButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 99
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 100
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->editListingButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 102
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->editListingButton:Landroid/widget/Button;

    const v2, 0x7f0600c4

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 103
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->editListingButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$1;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$1;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 116
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->isItemSold:Z

    if-eqz v1, :cond_2

    .line 117
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markNotForSaleButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 118
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markAsAvailableButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 126
    :goto_0
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->isListingAvailable:Z

    if-eqz v1, :cond_3

    .line 127
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markNotForSaleButton:Landroid/widget/Button;

    const v2, 0x7f0601a1

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 128
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markAsAvailableButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 135
    :goto_1
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markNotForSaleButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$2;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 156
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markAsAvailableButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$3;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 177
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 178
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 241
    :goto_2
    iput-boolean v4, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->bUpdateViews:Z

    .line 243
    :cond_1
    return-void

    .line 121
    :cond_2
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markNotForSaleButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 122
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markAsAvailableButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0

    .line 131
    :cond_3
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markAsAvailableButton:Landroid/widget/Button;

    const v2, 0x7f06019d

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 132
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markNotForSaleButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_1

    .line 182
    :cond_4
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->isUserAdmin()Z

    move-result v1

    if-eqz v1, :cond_5

    .line 183
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 184
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 185
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 190
    :goto_3
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->editListingButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 191
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markAsAvailableButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 192
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->markNotForSaleButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 193
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->reportListingButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 194
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 195
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->addToBundleButton:Landroid/widget/Button;

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 197
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->addToBundleButton:Landroid/widget/Button;

    const v2, 0x7f060037

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 198
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->addToBundleButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$4;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$4;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 210
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    const v2, 0x7f0602bc

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 211
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$5;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$5;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 222
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->reportListingButton:Landroid/widget/Button;

    const v2, 0x7f060226

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 223
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->reportListingButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment$6;-><init>(Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto/16 :goto_2

    .line 187
    :cond_5
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ListingDetailsDrawerFragment;->deleteListingButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_3
.end method
