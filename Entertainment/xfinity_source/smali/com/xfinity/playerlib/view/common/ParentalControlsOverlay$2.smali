.class Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$2;
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
    .line 37
    iput-object p1, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$2;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onClick(Landroid/view/View;)V
    .locals 2
    .param p1, "view"    # Landroid/view/View;

    .prologue
    .line 40
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$2;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    # getter for: Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->access$000(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setHasSeenParentalControlsMessage(Z)V

    .line 41
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$2;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    # getter for: Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->access$000(Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    .line 42
    iget-object v0, p0, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay$2;->this$0:Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;

    const-string v1, "ParentalControlsOverlay"

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/common/ParentalControlsOverlay;->dismissOverlay(Ljava/lang/String;)V

    .line 43
    return-void
.end method
