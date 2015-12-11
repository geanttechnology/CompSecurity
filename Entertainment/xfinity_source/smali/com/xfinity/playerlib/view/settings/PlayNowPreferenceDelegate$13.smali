.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "PlayNowPreferenceDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDevice()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Ljava/lang/Void;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

.field final synthetic val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 451
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 451
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;->execute()Ljava/lang/Void;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/lang/Void;
    .locals 3

    .prologue
    .line 454
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1900(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    move-result-object v1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$900(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v0

    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;->val$settings:Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getDeviceRegistration()Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/downloads/DeviceRegistration;->getDeviceId()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v0, v2}, Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;->unregisterDevice(Lcom/comcast/cim/model/user/AuthKeys;Ljava/lang/String;)V

    .line 455
    const/4 v0, 0x0

    return-object v0
.end method
