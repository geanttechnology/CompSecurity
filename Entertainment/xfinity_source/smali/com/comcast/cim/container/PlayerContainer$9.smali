.class Lcom/comcast/cim/container/PlayerContainer$9;
.super Ljava/lang/Object;
.source "PlayerContainer.java"

# interfaces
.implements Lcom/comcast/cim/model/user/UserManager$UserManagerListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/model/user/UserManager$UserManagerListener",
        "<",
        "Lcom/xfinity/playerlib/model/user/PlayNowUser;",
        "Lcom/xfinity/playerlib/model/user/PlayerUserSettings;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/container/PlayerContainer;


# direct methods
.method constructor <init>(Lcom/comcast/cim/container/PlayerContainer;)V
    .locals 0
    .param p1, "this$0"    # Lcom/comcast/cim/container/PlayerContainer;

    .prologue
    .line 946
    iput-object p1, p0, Lcom/comcast/cim/container/PlayerContainer$9;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic onUserChanged(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0

    .prologue
    .line 946
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    check-cast p2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/container/PlayerContainer$9;->onUserChanged(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    return-void
.end method

.method public onUserChanged(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 0
    .param p1, "newUser"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .param p2, "settings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 965
    return-void
.end method

.method public bridge synthetic onUserLoaded(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0

    .prologue
    .line 946
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    check-cast p2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/container/PlayerContainer$9;->onUserLoaded(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    return-void
.end method

.method public onUserLoaded(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 0
    .param p1, "user"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .param p2, "settings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 950
    return-void
.end method

.method public bridge synthetic onUserLoggedIn(Lcom/comcast/cim/model/user/User;Lcom/comcast/cim/model/user/service/UserSettings;)V
    .locals 0

    .prologue
    .line 946
    check-cast p1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    check-cast p2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {p0, p1, p2}, Lcom/comcast/cim/container/PlayerContainer$9;->onUserLoggedIn(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    return-void
.end method

.method public onUserLoggedIn(Lcom/xfinity/playerlib/model/user/PlayNowUser;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 2
    .param p1, "user"    # Lcom/xfinity/playerlib/model/user/PlayNowUser;
    .param p2, "settings"    # Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .prologue
    .line 954
    iget-object v0, p0, Lcom/comcast/cim/container/PlayerContainer$9;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/container/PlayerContainer$9;->this$0:Lcom/comcast/cim/container/PlayerContainer;

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configureESPNPlayer(Landroid/content/Context;)V

    .line 955
    return-void
.end method

.method public onUserLoggedOut()V
    .locals 0

    .prologue
    .line 960
    return-void
.end method
