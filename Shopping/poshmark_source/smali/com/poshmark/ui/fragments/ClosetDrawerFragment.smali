.class public Lcom/poshmark/ui/fragments/ClosetDrawerFragment;
.super Lcom/poshmark/ui/fragments/PMFragment;
.source "ClosetDrawerFragment.java"

# interfaces
.implements Lcom/poshmark/notifications/PMNotificationListener;


# instance fields
.field blockUserButton:Landroid/widget/Button;

.field isUserBlocked:Z

.field parentFragmentId:Ljava/util/UUID;

.field reportUserButton:Landroid/widget/Button;

.field shareClosetButton:Landroid/widget/Button;

.field unblockUserButton:Landroid/widget/Button;

.field userId:Ljava/lang/String;

.field viewBundleButton:Landroid/widget/Button;


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 25
    invoke-direct {p0}, Lcom/poshmark/ui/fragments/PMFragment;-><init>()V

    return-void
.end method


# virtual methods
.method public handleNotification(Landroid/content/Intent;)V
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 219
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v2

    const-string v3, "com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION"

    invoke-virtual {v2, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 220
    const-string v2, "RESULT"

    invoke-virtual {p1, v2}, Landroid/content/Intent;->getBundleExtra(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v0

    .line 221
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "PARENT_ID"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    check-cast v1, Landroid/os/ParcelUuid;

    .line 222
    .local v1, "uuidParcel":Landroid/os/ParcelUuid;
    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->parentFragmentId:Ljava/util/UUID;

    invoke-virtual {v1}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/util/UUID;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 223
    const-string v2, "BLOCK_USER_STATUS"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->isUserBlocked:Z

    .line 224
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->updateViews()V

    .line 227
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "uuidParcel":Landroid/os/ParcelUuid;
    :cond_0
    return-void
.end method

.method public logScreenTracking()V
    .locals 0

    .prologue
    .line 97
    return-void
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 70
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 71
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getActivity()Landroid/support/v4/app/FragmentActivity;

    move-result-object v0

    check-cast v0, Lcom/poshmark/ui/PMContainerActivity;

    .line 72
    .local v0, "parent":Lcom/poshmark/ui/PMContainerActivity;
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->updateViews()V

    .line 73
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 39
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onCreate(Landroid/os/Bundle;)V

    .line 40
    sget-object v2, Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;->DRAWER:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->fragmentType:Lcom/poshmark/ui/fragments/PMFragment$FRAGMENT_TYPE;

    .line 41
    if-nez p1, :cond_1

    .line 42
    const-class v2, Landroid/os/Bundle;

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getFragmentDataOfType(Ljava/lang/Class;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/os/Bundle;

    .line 43
    .local v1, "parentInfo":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 44
    const-string v2, "PARENT_FRAGMENT_ID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/ParcelUuid;

    .line 45
    .local v0, "parcelUuid":Landroid/os/ParcelUuid;
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->parentFragmentId:Ljava/util/UUID;

    .line 46
    const-string v2, "USER_ID"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->userId:Ljava/lang/String;

    .line 47
    const-string v2, "BLOCK_USER_STATUS"

    invoke-virtual {v1, v2}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v2

    iput-boolean v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->isUserBlocked:Z

    .line 54
    .end local v0    # "parcelUuid":Landroid/os/ParcelUuid;
    .end local v1    # "parentInfo":Landroid/os/Bundle;
    :cond_0
    :goto_0
    return-void

    .line 50
    :cond_1
    const-string v2, "PARENT_FRAGMENT_ID"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Landroid/os/ParcelUuid;

    .line 51
    .restart local v0    # "parcelUuid":Landroid/os/ParcelUuid;
    invoke-virtual {v0}, Landroid/os/ParcelUuid;->getUuid()Ljava/util/UUID;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->parentFragmentId:Ljava/util/UUID;

    .line 52
    const-string v2, "USER_ID"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    iput-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->userId:Ljava/lang/String;

    goto :goto_0
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 58
    invoke-super {p0, p1, p2, p3}, Lcom/poshmark/ui/fragments/PMFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    .line 59
    const v1, 0x7f030025

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 60
    .local v0, "v":Landroid/view/View;
    return-object v0
.end method

.method public onDestroyView()V
    .locals 0

    .prologue
    .line 65
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onDestroyView()V

    .line 66
    return-void
.end method

.method public onPMResume()V
    .locals 2

    .prologue
    .line 77
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPMResume()V

    .line 78
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    const-string v1, "com.poshmark.intents.SET_BLOCK_USER_STATUS_ACTION"

    invoke-virtual {v0, v1, p0}, Lcom/poshmark/notifications/PMNotificationManager;->registerForEvent(Ljava/lang/String;Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 79
    return-void
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 83
    invoke-super {p0}, Lcom/poshmark/ui/fragments/PMFragment;->onPause()V

    .line 84
    invoke-static {}, Lcom/poshmark/notifications/PMNotificationManager;->getNotificationManager()Lcom/poshmark/notifications/PMNotificationManager;

    move-result-object v0

    invoke-virtual {v0, p0}, Lcom/poshmark/notifications/PMNotificationManager;->unregisterAllEvents(Lcom/poshmark/notifications/PMNotificationListener;)V

    .line 85
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 3
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 89
    invoke-super {p0, p1}, Lcom/poshmark/ui/fragments/PMFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 90
    const-string v0, "PARENT_FRAGMENT_ID"

    new-instance v1, Landroid/os/ParcelUuid;

    iget-object v2, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->parentFragmentId:Ljava/util/UUID;

    invoke-direct {v1, v2}, Landroid/os/ParcelUuid;-><init>(Ljava/util/UUID;)V

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 91
    const-string v0, "USER_ID"

    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->userId:Ljava/lang/String;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 92
    return-void
.end method

.method public setViewNameForAnalytics()V
    .locals 0

    .prologue
    .line 101
    return-void
.end method

.method public updateViews()V
    .locals 8

    .prologue
    const v7, 0x7f0c00be

    const v6, 0x7f0c00bc

    const v5, 0x7f060227

    const/4 v3, 0x0

    const/16 v2, 0x8

    .line 104
    const/4 v0, 0x0

    .line 105
    .local v0, "isLoggedInUserCloset":Z
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->userId:Ljava/lang/String;

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v4

    invoke-virtual {v4}, Lcom/poshmark/application/PMApplicationSession;->getUserId()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    invoke-static {}, Lcom/poshmark/application/PMApplicationSession;->GetPMSession()Lcom/poshmark/application/PMApplicationSession;

    move-result-object v1

    invoke-virtual {v1}, Lcom/poshmark/application/PMApplicationSession;->isLoggedIn()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 106
    const/4 v0, 0x1

    .line 109
    :cond_0
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v4, 0x7f0c00ba

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    .line 110
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    const v4, 0x7f0602bc

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 111
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    if-eqz v0, :cond_1

    move v1, v2

    :goto_0
    invoke-virtual {v4, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 112
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->viewBundleButton:Landroid/widget/Button;

    new-instance v4, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$1;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$1;-><init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment;)V

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 124
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v4, 0x7f0c00bb

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->shareClosetButton:Landroid/widget/Button;

    .line 125
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->shareClosetButton:Landroid/widget/Button;

    const v4, 0x7f060255

    invoke-virtual {p0, v4}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 126
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->reportUserButton:Landroid/widget/Button;

    .line 127
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->reportUserButton:Landroid/widget/Button;

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 129
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->shareClosetButton:Landroid/widget/Button;

    new-instance v4, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$2;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$2;-><init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment;)V

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 141
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v6}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->reportUserButton:Landroid/widget/Button;

    .line 142
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->reportUserButton:Landroid/widget/Button;

    invoke-virtual {p0, v5}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 143
    iget-object v4, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->reportUserButton:Landroid/widget/Button;

    if-eqz v0, :cond_2

    move v1, v2

    :goto_1
    invoke-virtual {v4, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 144
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->reportUserButton:Landroid/widget/Button;

    new-instance v4, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;

    invoke-direct {v4, p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$3;-><init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment;)V

    invoke-virtual {v1, v4}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 162
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    const v4, 0x7f0c00bd

    invoke-virtual {v1, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->blockUserButton:Landroid/widget/Button;

    .line 163
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->unblockUserButton:Landroid/widget/Button;

    .line 165
    if-eqz v0, :cond_3

    .line 166
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->blockUserButton:Landroid/widget/Button;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 167
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->unblockUserButton:Landroid/widget/Button;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 216
    :goto_2
    return-void

    :cond_1
    move v1, v3

    .line 111
    goto/16 :goto_0

    :cond_2
    move v1, v3

    .line 143
    goto :goto_1

    .line 171
    :cond_3
    iget-boolean v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->isUserBlocked:Z

    if-eqz v1, :cond_4

    .line 172
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->blockUserButton:Landroid/widget/Button;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 173
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->unblockUserButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 174
    invoke-virtual {p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getView()Landroid/view/View;

    move-result-object v1

    invoke-virtual {v1, v7}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->unblockUserButton:Landroid/widget/Button;

    .line 175
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->unblockUserButton:Landroid/widget/Button;

    const v2, 0x7f0602a4

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 176
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->unblockUserButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$4;-><init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_2

    .line 195
    :cond_4
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->unblockUserButton:Landroid/widget/Button;

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setVisibility(I)V

    .line 196
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->blockUserButton:Landroid/widget/Button;

    invoke-virtual {v1, v3}, Landroid/widget/Button;->setVisibility(I)V

    .line 197
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->blockUserButton:Landroid/widget/Button;

    const v2, 0x7f060054

    invoke-virtual {p0, v2}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 198
    iget-object v1, p0, Lcom/poshmark/ui/fragments/ClosetDrawerFragment;->blockUserButton:Landroid/widget/Button;

    new-instance v2, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$5;

    invoke-direct {v2, p0}, Lcom/poshmark/ui/fragments/ClosetDrawerFragment$5;-><init>(Lcom/poshmark/ui/fragments/ClosetDrawerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    goto :goto_2
.end method
