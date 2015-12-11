.class public Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;
.super Lcom/comcast/cim/android/view/common/BaseActivity;
.source "AnnouncementOverlayActivity.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/common/OverlayDismissedListener;


# instance fields
.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 12
    invoke-direct {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;-><init>()V

    .line 13
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-void
.end method

.method private isOverlayCreated()Z
    .locals 3

    .prologue
    .line 75
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "CellularEnabledOverlay"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    move-result-object v0

    .line 77
    .local v0, "fragment":Landroid/app/Fragment;
    if-nez v0, :cond_0

    .line 78
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "UpgradeOverlay"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    .line 81
    :cond_0
    if-nez v0, :cond_1

    .line 82
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    const-string v2, "ParentalControlsOverlay"

    invoke-virtual {v1, v2}, Landroid/app/FragmentManager;->findFragmentByTag(Ljava/lang/String;)Landroid/app/Fragment;

    .line 85
    :cond_1
    if-eqz v0, :cond_2

    const/4 v1, 0x1

    :goto_0
    return v1

    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method


# virtual methods
.method public onBackPressed()V
    .locals 2

    .prologue
    .line 39
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenParentalControlsMessage()Z

    move-result v1

    if-nez v1, :cond_0

    .line 41
    new-instance v0, Landroid/content/Intent;

    const-string v1, "android.intent.action.MAIN"

    invoke-direct {v0, v1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 42
    .local v0, "startMain":Landroid/content/Intent;
    const-string v1, "android.intent.category.HOME"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->addCategory(Ljava/lang/String;)Landroid/content/Intent;

    .line 43
    const/high16 v1, 0x10000000

    invoke-virtual {v0, v1}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 44
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->startActivity(Landroid/content/Intent;)V

    .line 48
    .end local v0    # "startMain":Landroid/content/Intent;
    :goto_0
    return-void

    .line 46
    :cond_0
    invoke-super {p0}, Lcom/comcast/cim/android/view/common/BaseActivity;->onBackPressed()V

    goto :goto_0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 17
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/common/BaseActivity;->onCreate(Landroid/os/Bundle;)V

    .line 18
    sget v0, Lcom/xfinity/playerlib/R$layout;->announcement_overlay:I

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->setContentView(I)V

    .line 20
    if-nez p1, :cond_0

    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenCellularEnabledMessage()Z

    move-result v0

    if-nez v0, :cond_1

    .line 22
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->container:I

    new-instance v2, Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;

    invoke-direct {v2}, Lcom/xfinity/playerlib/view/common/CellularEnabledOverlay;-><init>()V

    const-string v3, "CellularEnabledOverlay"

    .line 23
    invoke-virtual {v0, v1, v2, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 24
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    .line 35
    :cond_0
    :goto_0
    return-void

    .line 25
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenUpgradeMessage()Z

    move-result v0

    if-nez v0, :cond_2

    .line 26
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->container:I

    new-instance v2, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;

    invoke-direct {v2}, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;-><init>()V

    const-string v3, "UpgradeOverlay"

    .line 27
    invoke-virtual {v0, v1, v2, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 28
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 30
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->container:I

    new-instance v2, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    invoke-direct {v2}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;-><init>()V

    const-string v3, "ParentalControlsOverlay"

    .line 31
    invoke-virtual {v0, v1, v2, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 32
    invoke-virtual {v0}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0
.end method

.method public onOverlayDismissed(Ljava/lang/String;)V
    .locals 4
    .param p1, "tag"    # Ljava/lang/String;

    .prologue
    .line 52
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v0

    .line 53
    .local v0, "fragmentTransaction":Landroid/app/FragmentTransaction;
    sget v1, Lcom/xfinity/playerlib/R$anim;->slide_in_right:I

    sget v2, Lcom/xfinity/playerlib/R$anim;->slide_out_left:I

    invoke-virtual {v0, v1, v2}, Landroid/app/FragmentTransaction;->setCustomAnimations(II)Landroid/app/FragmentTransaction;

    .line 55
    const-string v1, "CellularEnabledOverlay"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_3

    .line 56
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenUpgradeMessage()Z

    move-result v1

    if-nez v1, :cond_1

    .line 57
    sget v1, Lcom/xfinity/playerlib/R$id;->container:I

    new-instance v2, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;

    invoke-direct {v2}, Lcom/xfinity/playerlib/view/common/UpgradeOverlay;-><init>()V

    const-string v3, "UpgradeOverlay"

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    .line 72
    :cond_0
    :goto_0
    return-void

    .line 58
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenParentalControlsMessage()Z

    move-result v1

    if-nez v1, :cond_2

    .line 59
    sget v1, Lcom/xfinity/playerlib/R$id;->container:I

    new-instance v2, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    invoke-direct {v2}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;-><init>()V

    const-string v3, "ParentalControlsOverlay"

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 61
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->finish()V

    goto :goto_0

    .line 63
    :cond_3
    const-string v1, "UpgradeOverlay"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_5

    .line 64
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getHasSeenParentalControlsMessage()Z

    move-result v1

    if-nez v1, :cond_4

    .line 65
    sget v1, Lcom/xfinity/playerlib/R$id;->container:I

    new-instance v2, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    invoke-direct {v2}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;-><init>()V

    const-string v3, "ParentalControlsOverlay"

    invoke-virtual {v0, v1, v2, v3}, Landroid/app/FragmentTransaction;->replace(ILandroid/app/Fragment;Ljava/lang/String;)Landroid/app/FragmentTransaction;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/FragmentTransaction;->commit()I

    goto :goto_0

    .line 67
    :cond_4
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->finish()V

    goto :goto_0

    .line 69
    :cond_5
    const-string v1, "ParentalControlsOverlay"

    invoke-virtual {p1, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 70
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/common/AnnouncementOverlayActivity;->finish()V

    goto :goto_0
.end method
