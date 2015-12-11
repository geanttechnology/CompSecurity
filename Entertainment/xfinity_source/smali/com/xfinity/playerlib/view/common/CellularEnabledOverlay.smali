.class public Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;
.super Lcom/xfinity/playerlib/view/common/UpgradeOverlay;
.source "CellularEnabledOverlay.java"


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 9
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;-><init>()V

    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 14
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 16
    .local v0, "view":Landroid/view/View;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;->primaryCopy:Landroid/widget/TextView;

    sget v2, Lcom/xfinity/playerlib/R$string;->cellular_upgrade_overlay_primary:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 17
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;->secondaryCopy:Landroid/widget/TextView;

    sget v2, Lcom/xfinity/playerlib/R$string;->cellular_upgrade_overlay_secondary:I

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(I)V

    .line 18
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;->closeButton:Landroid/widget/Button;

    sget v2, Lcom/xfinity/playerlib/R$string;->cellular_upgrade_close_button:I

    invoke-virtual {v1, v2}, Landroid/widget/Button;->setText(I)V

    .line 20
    return-object v0
.end method

.method protected save()V
    .locals 2

    .prologue
    .line 25
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setHasSeenCellularEnabledMessage(Z)V

    .line 26
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    .line 27
    return-void
.end method
