.class Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$11;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "PlayNowPreferenceDelegate.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->fetchDevices()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 369
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$11;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method


# virtual methods
.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 369
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$11;->execute()Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method public execute()Ljava/util/List;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;"
        }
    .end annotation

    .prologue
    .line 372
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$11;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$1000(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    move-result-object v1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$11;->this$0:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    # getter for: Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->access$900(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getAuthKeys()Lcom/comcast/cim/model/user/AuthKeys;

    move-result-object v0

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/downloads/RegistrationListClient;->getDeviceRegistrationList(Lcom/comcast/cim/model/user/AuthKeys;)Ljava/util/List;

    move-result-object v0

    invoke-static {v0}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    return-object v0
.end method
