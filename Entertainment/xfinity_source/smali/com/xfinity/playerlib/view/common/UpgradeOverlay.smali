.class public Lcom/xfinity/playerlib/view/common/UpgradeOverlay;
.super Lcom/xfinity/playerlib/view/common/OverlayFragment;
.source "UpgradeOverlay.java"


# instance fields
.field protected closeButton:Landroid/widget/Button;

.field protected primaryCopy:Landroid/widget/TextView;

.field protected secondaryCopy:Landroid/widget/TextView;

.field protected final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 13
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/common/OverlayFragment;-><init>()V

    .line 15
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 23
    sget v1, Lcom/xfinity/playerlib/R$layout;->upgrade_message_overlay:I

    const/4 v2, 0x0

    invoke-virtual {p1, v1, p2, v2}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    .line 24
    .local v0, "view":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->primary_copy:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->primaryCopy:Landroid/widget/TextView;

    .line 25
    sget v1, Lcom/xfinity/playerlib/R$id;->secondary_copy:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->secondaryCopy:Landroid/widget/TextView;

    .line 27
    sget v1, Lcom/xfinity/playerlib/R$id;->close_button:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->closeButton:Landroid/widget/Button;

    .line 29
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->primaryCopy:Landroid/widget/TextView;

    sget v2, Lcom/xfinity/playerlib/R$string;->overlay_upgrade_primary:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 30
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->secondaryCopy:Landroid/widget/TextView;

    sget v2, Lcom/xfinity/playerlib/R$string;->overlay_upgrade_secondary:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 32
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->closeButton:Landroid/widget/Button;

    new-instance v2, Lcom/xfinity/playerlib/view/common/UpgradeOverlay$1;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/common/UpgradeOverlay$1;-><init>(Lcom/xfinity/playerlib/view/common/UpgradeOverlay;)V

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 40
    return-object v0
.end method

.method protected save()V
    .locals 2

    .prologue
    .line 44
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setHasSeenUpgradeMessage(Z)V

    .line 45
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    .line 46
    return-void
.end method
