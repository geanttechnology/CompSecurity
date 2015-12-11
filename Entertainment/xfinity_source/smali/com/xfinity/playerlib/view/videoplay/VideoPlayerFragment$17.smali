.class Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;
.super Ljava/lang/Object;
.source "VideoPlayerFragment.java"

# interfaces
.implements Landroid/view/View$OnLongClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->configureVolumeAndBrightnessControls()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 2216
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onLongClick(Landroid/view/View;)Z
    .locals 3
    .param p1, "v"    # Landroid/view/View;

    .prologue
    const/4 v2, 0x0

    .line 2219
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsVolumeControl()Z

    move-result v1

    if-nez v1, :cond_1

    const/4 v1, 0x1

    :goto_0
    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setWantsVolumeControl(Z)V

    .line 2220
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->updateVolumeSlider()V

    .line 2222
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsVolumeControl()Z

    move-result v0

    if-eqz v0, :cond_2

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_2

    .line 2223
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSliderLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0, v2}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 2227
    :cond_0
    :goto_1
    return v2

    :cond_1
    move v1, v2

    .line 2219
    goto :goto_0

    .line 2224
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    # getter for: Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsVolumeControl()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSliderLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v0}, Landroid/widget/LinearLayout;->getVisibility()I

    move-result v0

    if-nez v0, :cond_0

    .line 2225
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;->this$0:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSliderLayout:Landroid/widget/LinearLayout;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/LinearLayout;->setVisibility(I)V

    goto :goto_1
.end method
