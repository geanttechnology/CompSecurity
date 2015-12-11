.class Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;
.super Ljava/lang/Object;
.source "ParentalControlsOverlay.java"

# interfaces
.implements Landroid/view/View$OnClickListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    .prologue
    .line 24
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 3
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 27
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->getActivity()Landroid/app/Activity;

    move-result-object v1

    const-class v2, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragmentActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 28
    .local v0, "intent":Landroid/content/Intent;
    const-string v1, "resource"

    const-string v2, "parental_control_prefs"

    invoke-virtual {v0, v1, v2}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;

    .line 30
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    # getter for: Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->access$000(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v2, 0x1

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setHasSeenParentalControlsMessage(Z)V

    .line 31
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    # getter for: Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->access$000(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    .line 32
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    const-string v2, "ParentalControlsOverlay"

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->dismissOverlay(Ljava/lang/String;)V

    .line 33
    iget-object v1, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$1;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->startActivity(Landroid/content/Intent;)V

    .line 34
    return-void
.end method
