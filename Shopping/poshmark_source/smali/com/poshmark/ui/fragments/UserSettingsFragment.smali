.class public Lcom/poshmark/ui/fragments/UserSettingsFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "UserSettingsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    }
.end annotation


# instance fields
.field aboutButton:Landroid/widget/Button;

.field commandsButton:Landroid/widget/Button;

.field earnCashButton:Landroid/widget/Button;

.field faqButton:Landroid/widget/Button;

.field findPeopleButton:Landroid/widget/Button;

.field guideToPoshmarkButton:Landroid/widget/Button;

.field listener:Landroid/view/View$OnClickListener;

.field logoutButton:Landroid/widget/Button;

.field myAddressButton:Landroid/widget/Button;

.field myBalanceButton:Landroid/widget/Button;

.field myClosetButton:Landroid/widget/Button;

.field myClosetStatsButton:Landroid/widget/Button;

.field myLikesButton:Landroid/widget/Button;

.field myProfileButton:Landroid/widget/Button;

.field myPurchasesButton:Landroid/widget/Button;

.field mySalesButton:Landroid/widget/Button;

.field mySellerDiscountButton:Landroid/widget/Button;

.field mySizeButton:Landroid/widget/Button;

.field notificationsButton:Landroid/widget/Button;

.field poshEtiquetteButton:Landroid/widget/Button;

.field sharingSettingsButton:Landroid/widget/Button;

.field supportCenterButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    .line 340
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$3;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$3;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    .line 351
    return-void
.end method

.method static synthetic access$000(Lcom/poshmark/ui/fragments/UserSettingsFragment;Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;)V
    .locals 0
    .param p0, "x0"    # Lcom/poshmark/ui/fragments/UserSettingsFragment;
    .param p1, "x1"    # Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .prologue
    .line 23
    invoke-direct {p0, p1}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->launchUrl(Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;)V

    return-void
.end method

.method private launchUrl(Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;)V
    .locals 6
    .param p1, "info"    # Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .prologue
    const/4 v5, 0x0

    .line 333
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMActivity;

    .line 334
    .local v0, "parentActivity":Lcom/poshmark/ui/PMActivity;
    iget-object v1, p1, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    iget-object v2, p1, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    invoke-virtual {v0, v1, v2, v5}, Lcom/poshmark/ui/PMActivity;->launchFragmentInNewActivity(Landroid/os/Bundle;Ljava/lang/Class;Ljava/lang/Object;)V

    .line 335
    iget-object v1, p1, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->trackingLabel:Ljava/lang/String;

    if-eqz v1, :cond_0

    .line 336
    invoke-static {}, Lcom/poshmark/analytics/Analytics;->getInstance()Lcom/poshmark/analytics/Analytics;

    move-result-object v1

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->viewNameForAnalytics:Ljava/lang/String;

    const-string v3, "user"

    iget-object v4, p1, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->trackingLabel:Ljava/lang/String;

    invoke-virtual {v1, v2, v3, v4, v5}, Lcom/poshmark/analytics/Analytics;->trackEvent(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 338
    :cond_0
    return-void
.end method

.method private setupButtons()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 103
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 105
    .local v0, "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02f9

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->guideToPoshmarkButton:Landroid/widget/Button;

    .line 106
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->guideToPoshmarkButton:Landroid/widget/Button;

    const v2, 0x7f0602d2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 107
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 108
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/posh_guide"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 109
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "posh_guide_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 110
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->guideToPoshmarkButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 111
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->guideToPoshmarkButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 113
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02fa

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->poshEtiquetteButton:Landroid/widget/Button;

    .line 114
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->poshEtiquetteButton:Landroid/widget/Button;

    const v2, 0x7f06020d

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 115
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 116
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 117
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/posh_etiquette"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 118
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "posh_etiquette_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 119
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->poshEtiquetteButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 120
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->poshEtiquetteButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 122
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02fb

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->earnCashButton:Landroid/widget/Button;

    .line 123
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->earnCashButton:Landroid/widget/Button;

    const v2, 0x7f060158

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 124
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 125
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/ShareFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 126
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->SHARE_MODE_INVITE_FRIENDS:Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/utils/ShareManager_Old$SHARE_MODE;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 127
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->earnCashButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 128
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->earnCashButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 130
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c003a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->findPeopleButton:Landroid/widget/Button;

    .line 131
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->findPeopleButton:Landroid/widget/Button;

    const v2, 0x7f060129

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 132
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->findPeopleButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 133
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 134
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/FindPeopleFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 135
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->findPeopleButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 136
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->findPeopleButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 138
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02fc

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetButton:Landroid/widget/Button;

    .line 139
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetButton:Landroid/widget/Button;

    const v2, 0x7f0601af

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 140
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 141
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/ClosetFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 142
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "NAME"

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v3

    invoke-virtual {v3}, Lcom/poshmark/application/PMApplicationSession;->getDisplayHandle()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 143
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 144
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 146
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02cb

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myLikesButton:Landroid/widget/Button;

    .line 147
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myLikesButton:Landroid/widget/Button;

    const v2, 0x7f0601b2

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 148
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 149
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MyLikesFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 150
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "callFromUserSettings"

    const/4 v3, 0x1

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 151
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myLikesButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 152
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myLikesButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 154
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02fd

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myProfileButton:Landroid/widget/Button;

    .line 155
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myProfileButton:Landroid/widget/Button;

    const v2, 0x7f0601b5

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 156
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 157
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/EditProfileFormFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 158
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "MODE"

    sget-object v3, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->PROFILE_MODE_EDIT:Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;

    invoke-virtual {v3}, Lcom/poshmark/ui/fragments/EditProfileFormFragment$PROFILE_MODE;->ordinal()I

    move-result v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 159
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myProfileButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 160
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myProfileButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02fe

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySizeButton:Landroid/widget/Button;

    .line 163
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySizeButton:Landroid/widget/Button;

    const v2, 0x7f0601ba

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 164
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySizeButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 165
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 166
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MySizeFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 167
    iput-object v5, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    .line 168
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySizeButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 170
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0300

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myPurchasesButton:Landroid/widget/Button;

    .line 171
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myPurchasesButton:Landroid/widget/Button;

    const v2, 0x7f0601b6

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 172
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 173
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 174
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/purchases"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 175
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "items_bought_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 176
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myPurchasesButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 177
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myPurchasesButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 179
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0301

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySalesButton:Landroid/widget/Button;

    .line 180
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySalesButton:Landroid/widget/Button;

    const v2, 0x7f0601b7

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 181
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 182
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 183
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/sales"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 184
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "items_sold_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySalesButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 186
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySalesButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 198
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0302

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myBalanceButton:Landroid/widget/Button;

    .line 199
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myBalanceButton:Landroid/widget/Button;

    const v2, 0x7f0601ad

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 200
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 201
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 202
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/account_list"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?pageName=USER_ACCOUNT-account_list"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 207
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "account_balances_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 208
    const-string v1, "account_balance_row_tapped"

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->trackingLabel:Ljava/lang/String;

    .line 209
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myBalanceButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 210
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myBalanceButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 212
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0304

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetStatsButton:Landroid/widget/Button;

    .line 213
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetStatsButton:Landroid/widget/Button;

    const v2, 0x7f0601b0

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 214
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 215
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 216
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/closet_stats"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 220
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "my_selling_tools"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetStatsButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 222
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myClosetStatsButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 224
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0303

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySellerDiscountButton:Landroid/widget/Button;

    .line 225
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySellerDiscountButton:Landroid/widget/Button;

    const v2, 0x7f0601b8

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 226
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 227
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 228
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/seller_tools/seller_discounts"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 232
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "my_selling_tools"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 233
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySellerDiscountButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 234
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->mySellerDiscountButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 249
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c02ff

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myAddressButton:Landroid/widget/Button;

    .line 250
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myAddressButton:Landroid/widget/Button;

    const v2, 0x7f0601ac

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 251
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 252
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 253
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/address/address_book"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "?pageType=new&pageName=ADDRESS_BOOK"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 258
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "my_address_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 259
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myAddressButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 260
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->myAddressButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 262
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0305

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->sharingSettingsButton:Landroid/widget/Button;

    .line 263
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->sharingSettingsButton:Landroid/widget/Button;

    const v2, 0x7f06025e

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 264
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 265
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/SharingSettingsFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 266
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->sharingSettingsButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 267
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->sharingSettingsButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 269
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0306

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->notificationsButton:Landroid/widget/Button;

    .line 270
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->notificationsButton:Landroid/widget/Button;

    const v2, 0x7f0601d5

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 271
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 272
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 273
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "https://www.poshmark.com/mapp/users/"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "/notification_settings"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 278
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "notification_settings_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 279
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->notificationsButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 280
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->notificationsButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 282
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0307

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->logoutButton:Landroid/widget/Button;

    .line 283
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->logoutButton:Landroid/widget/Button;

    const v2, 0x7f060199

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 284
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->logoutButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/UserSettingsFragment$2;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$2;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 292
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0308

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->supportCenterButton:Landroid/widget/Button;

    .line 293
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->supportCenterButton:Landroid/widget/Button;

    const v2, 0x7f060215

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 294
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 295
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 296
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/support_center"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 297
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "support_center_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->supportCenterButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 299
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->supportCenterButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 301
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0309

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->faqButton:Landroid/widget/Button;

    .line 302
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->faqButton:Landroid/widget/Button;

    const v2, 0x7f060137

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 303
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 304
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 305
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/faqs"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 306
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "faqs_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 307
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->faqButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 308
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->faqButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 310
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c0217

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->aboutButton:Landroid/widget/Button;

    .line 311
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->aboutButton:Landroid/widget/Button;

    const v2, 0x7f06002c

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 312
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 313
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/AboutFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 314
    iput-object v5, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    .line 315
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->aboutButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 316
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->aboutButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 318
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v2, 0x7f0c030a

    invoke-virtual {v1, v2}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->commandsButton:Landroid/widget/Button;

    .line 319
    sget-object v1, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v2, Lcom/poshmark/config/Env;->RC:Lcom/poshmark/config/Env;

    if-eq v1, v2, :cond_0

    sget-object v1, Lcom/poshmark/config/EnvConfig;->ENV:Lcom/poshmark/config/Env;

    sget-object v2, Lcom/poshmark/config/Env;->PRODUCTION:Lcom/poshmark/config/Env;

    if-eq v1, v2, :cond_0

    .line 320
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->commandsButton:Landroid/widget/Button;

    const v2, 0x7f06008c

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 321
    new-instance v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;

    .end local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    invoke-direct {v0, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    .line 322
    .restart local v0    # "buttonInfo":Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;
    const-class v1, Lcom/poshmark/ui/fragments/MappPageFragment;

    iput-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentToLaunch:Ljava/lang/Class;

    .line 323
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "URL"

    const-string v3, "https://www.poshmark.com/mapp/test/webcommands"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 324
    iget-object v1, v0, Lcom/poshmark/ui/fragments/UserSettingsFragment$SettingsButtonInfo;->fragmentData:Landroid/os/Bundle;

    const-string v2, "ANALYTICS_PAGE_NAME"

    const-string v3, "webcommand_webview_screen"

    invoke-virtual {v1, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 325
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->commandsButton:Landroid/widget/Button;

    invoke-virtual {v1, v0}, Landroid/widget/Button;->setTag(Ljava/lang/Object;)V

    .line 326
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->commandsButton:Landroid/widget/Button;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->listener:Landroid/view/View$OnClickListener;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 330
    :goto_0
    return-void

    .line 328
    :cond_0
    iget-object v1, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->commandsButton:Landroid/widget/Button;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    goto :goto_0
.end method


# virtual methods
.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 62
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 63
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 0
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 50
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 51
    return-void
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
    const v1, 0x7f0300cc

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 57
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onPMResume()V
    .locals 0

    .prologue
    .line 67
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 68
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->setupButtons()V

    .line 70
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 1

    .prologue
    .line 99
    const-string v0, "settings_screen"

    iput-object v0, p0, Lcom/poshmark/ui/fragments/UserSettingsFragment;->viewNameForAnalytics:Ljava/lang/String;

    .line 100
    return-void
.end method

.method public setupActionBar()V
    .locals 2

    .prologue
    .line 74
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->setupActionBar()V

    .line 75
    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v0

    invoke-virtual {v0}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 76
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string v1, "@"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->getUserName()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->setTitle(Ljava/lang/String;)V

    .line 77
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/support/v4/app/FragmentActivity;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    const v1, 0x7f0200f0

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v0

    new-instance v1, Lcom/poshmark/ui/fragments/UserSettingsFragment$1;

    invoke-direct {v1, p0}, Lcom/poshmark/ui/fragments/UserSettingsFragment$1;-><init>(Lcom/poshmark/ui/fragments/UserSettingsFragment;)V

    invoke-virtual {p0, v0, v1}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->setCutomRightImageButton(Landroid/graphics/drawable/Drawable;Landroid/view/View$OnClickListener;)V

    .line 96
    :goto_0
    return-void

    .line 94
    :cond_0
    const v0, 0x7f06024d

    invoke-virtual {p0, v0}, Lcom/poshmark/ui/fragments/UserSettingsFragment;->setTitle(I)V

    goto :goto_0
.end method
