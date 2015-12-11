.class Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8$1;
.super Ljava/lang/Object;
.source "PlayNowFlyinMenuActivity.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;->onPostExecute(Ljava/lang/Boolean;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;)V
    .locals 0
    .param p1, "this$1"    # Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;

    .prologue
    .line 370
    iput-object p1, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8$1;->this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 373
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8$1;->this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->openOptionsMenu()V

    .line 374
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8$1;->this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setHasSeenMenuOptions(Z)V

    .line 375
    iget-object v0, p0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8$1;->this$1:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity$8;->this$0:Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/flyinmenu/PlayNowFlyinMenuActivity;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->saveUserAsync()V

    .line 376
    return-void
.end method
