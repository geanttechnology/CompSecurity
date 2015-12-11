.class public Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;
.super Landroid/widget/PopupWindow;
.source "ListingDetailsMenuPopup.java"


# instance fields
.field addToBundleButton:Landroid/widget/TextView;

.field context:Landroid/content/Context;

.field deleteButtonListener:Landroid/view/View$OnClickListener;

.field deleteListingButton:Landroid/widget/TextView;

.field private isItemSold:Z

.field private isListingAvailable:Z

.field listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

.field private loggedInUser:Z

.field parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

.field popupView:Landroid/view/View;

.field reportListingButton:Landroid/widget/TextView;

.field viewBundleButton:Landroid/widget/TextView;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x1

    .line 49
    invoke-direct {p0}, Landroid/widget/PopupWindow;-><init>()V

    .line 175
    new-instance v0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$4;-><init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;)V

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteButtonListener:Landroid/view/View$OnClickListener;

    .line 50
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->setOutsideTouchable(Z)V

    .line 51
    invoke-virtual {p0, v1}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->setFocusable(Z)V

    .line 52
    return-void
.end method


# virtual methods
.method isListingCreatorSameAsLoggedInUser()Z
    .locals 2

    .prologue
    .line 166
    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v1}, Lcom/poshmark/data_model/models/ListingDetails;->getUserId()Ljava/lang/String;

    move-result-object v0

    .line 168
    .local v0, "listingCreatorId":Ljava/lang/String;
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 169
    const/4 v1, 0x1

    .line 171
    :goto_0
    return v1

    :cond_0
    const/4 v1, 0x0

    goto :goto_0
.end method

.method public setup(Lcom/poshmark/data_model/models/ListingDetails;Lcom/poshmark/ui/fragments/ListingDetailsFragment;)V
    .locals 4
    .param p1, "listingDetails"    # Lcom/poshmark/data_model/models/ListingDetails;
    .param p2, "parentFragment"    # Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .prologue
    .line 55
    iput-object p1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    .line 56
    iput-object p2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    .line 57
    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    .line 58
    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v2

    invoke-static {v2}, Landroid/view/LayoutInflater;->from(Landroid/content/Context;)Landroid/view/LayoutInflater;

    move-result-object v0

    .line 59
    .local v0, "inflater":Landroid/view/LayoutInflater;
    const v2, 0x7f030069

    const/4 v3, 0x0

    invoke-virtual {v0, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;)Landroid/view/View;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->popupView:Landroid/view/View;

    .line 60
    invoke-virtual {p2}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/View;->getWidth()I

    move-result v1

    .line 61
    .local v1, "totalWidth":I
    new-instance v2, Landroid/graphics/drawable/ColorDrawable;

    const v3, 0x106000d

    invoke-direct {v2, v3}, Landroid/graphics/drawable/ColorDrawable;-><init>(I)V

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->setBackgroundDrawable(Landroid/graphics/drawable/Drawable;)V

    .line 62
    const/4 v2, 0x1

    const/4 v3, -0x2

    invoke-virtual {p0, v2, v3}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->setWindowLayoutMode(II)V

    .line 63
    div-int/lit8 v2, v1, 0x3

    sub-int v2, v1, v2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->setWidth(I)V

    .line 64
    iget-object v2, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->popupView:Landroid/view/View;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->setContentView(Landroid/view/View;)V

    .line 65
    const/4 v2, 0x0

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->updateDrawer(Z)V

    .line 66
    return-void
.end method

.method public showPopup(Landroid/view/View;)V
    .locals 8
    .param p1, "anchorView"    # Landroid/view/View;

    .prologue
    const/4 v7, 0x1

    .line 69
    const/4 v4, 0x2

    new-array v2, v4, [I

    .line 70
    .local v2, "location":[I
    iget-object v4, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->parentFragment:Lcom/poshmark/ui/fragments/ListingDetailsFragment;

    invoke-virtual {v4}, Lcom/poshmark/ui/fragments/ListingDetailsFragment;->getView()Landroid/view/View;

    move-result-object v4

    invoke-virtual {v4}, Landroid/view/View;->getWidth()I

    move-result v3

    .line 71
    .local v3, "totalWidth":I
    invoke-virtual {p1, v2}, Landroid/view/View;->getLocationOnScreen([I)V

    .line 72
    const/4 v4, 0x0

    div-int/lit8 v5, v3, 0x3

    sub-int v5, v3, v5

    add-int/lit8 v5, v5, -0xa

    aget v6, v2, v7

    add-int/lit8 v6, v6, 0x5

    invoke-virtual {p0, p1, v4, v5, v6}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->showAtLocation(Landroid/view/View;III)V

    .line 75
    new-instance v0, Ljava/lang/String;

    const-string v4, "test"

    invoke-direct {v0, v4}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    .line 76
    .local v0, "a":Ljava/lang/String;
    invoke-virtual {v0, v7}, Ljava/lang/String;->charAt(I)C

    move-result v4

    invoke-static {v4}, Ljava/lang/Character;->valueOf(C)Ljava/lang/Character;

    move-result-object v1

    .line 77
    .local v1, "c":Ljava/lang/Character;
    return-void
.end method

.method public updateDrawer(Z)V
    .locals 5
    .param p1, "bforceUpdate"    # Z

    .prologue
    const v4, 0x7f0600b8

    const/16 v3, 0x8

    const/4 v2, 0x0

    .line 80
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->popupView:Landroid/view/View;

    if-eqz v0, :cond_0

    .line 82
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->popupView:Landroid/view/View;

    const v1, 0x7f0c0196

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    .line 83
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->popupView:Landroid/view/View;

    const v1, 0x7f0c0191

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->reportListingButton:Landroid/widget/TextView;

    .line 84
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->popupView:Landroid/view/View;

    const v1, 0x7f0c00ba

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->viewBundleButton:Landroid/widget/TextView;

    .line 85
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->popupView:Landroid/view/View;

    const v1, 0x7f0c0192

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->addToBundleButton:Landroid/widget/TextView;

    .line 88
    invoke-virtual {p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->isListingCreatorSameAsLoggedInUser()Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->loggedInUser:Z

    .line 89
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingDetails;->isListingAvailable()Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->isListingAvailable:Z

    .line 90
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->listingDetails:Lcom/poshmark/data_model/models/ListingDetails;

    invoke-virtual {v0}, Lcom/poshmark/data_model/models/ListingDetails;->isListingSold()Z

    move-result v0

    iput-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->isItemSold:Z

    .line 92
    iget-boolean v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->loggedInUser:Z

    if-eqz v0, :cond_1

    .line 94
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->addToBundleButton:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 95
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->viewBundleButton:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 96
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->reportListingButton:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    .line 97
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 100
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 101
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    :cond_0
    :goto_0
    return-void

    .line 105
    :cond_1
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isUserAdmin()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 106
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 107
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    invoke-virtual {v1, v4}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 108
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteButtonListener:Landroid/view/View$OnClickListener;

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    :goto_1
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->reportListingButton:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 114
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->viewBundleButton:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 115
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->addToBundleButton:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 117
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->addToBundleButton:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    const v2, 0x7f060037

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 118
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->addToBundleButton:Landroid/widget/TextView;

    new-instance v1, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$1;-><init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->viewBundleButton:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    const v2, 0x7f0602bc

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 131
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->viewBundleButton:Landroid/widget/TextView;

    new-instance v1, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$2;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$2;-><init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 142
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->reportListingButton:Landroid/widget/TextView;

    iget-object v1, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->context:Landroid/content/Context;

    const v2, 0x7f060226

    invoke-virtual {v1, v2}, Landroid/content/Context;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 143
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->reportListingButton:Landroid/widget/TextView;

    new-instance v1, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup$3;-><init>(Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_0

    .line 110
    :cond_2
    iget-object v0, p0, Lcom/poshmark/ui/customviews/ListingDetailsMenuPopup;->deleteListingButton:Landroid/widget/TextView;

    invoke-virtual {v0, v3}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_1
.end method
