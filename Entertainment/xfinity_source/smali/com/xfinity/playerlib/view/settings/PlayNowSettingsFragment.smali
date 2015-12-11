.class public Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;
.super Lcom/comcast/cim/android/view/settings/SettingsFragment;
.source "PlayNowSettingsFragment.java"


# instance fields
.field private final configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field private final configurationList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ">;"
        }
    .end annotation
.end field

.field private final errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private final liveStreamsResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation
.end field

.field private parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation
.end field

.field private playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private preferenceDelegate:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

.field private registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

.field private taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field protected final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

.field private userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 24
    invoke-direct {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;-><init>()V

    .line 25
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 26
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getParentalControlsCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 27
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 28
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUnregisterDeviceClient()Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    .line 29
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 30
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getRegistrationListClient()Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    .line 31
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 32
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 33
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 34
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAvailableConfigurations()Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->configurationList:Ljava/util/List;

    .line 35
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->liveStreamsResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 37
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->preferenceDelegate:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    return-void
.end method


# virtual methods
.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 41
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 43
    .local v0, "layout":Landroid/view/View;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->SETTINGS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V

    .line 45
    return-object v0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 58
    invoke-super {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->onPause()V

    .line 60
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->preferenceDelegate:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    if-eqz v0, :cond_0

    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->preferenceDelegate:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->cancelListeners()V

    .line 62
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->preferenceDelegate:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .line 64
    :cond_0
    return-void
.end method

.method public onResumeInternal()V
    .locals 12

    .prologue
    .line 50
    invoke-super {p0}, Lcom/comcast/cim/android/view/settings/SettingsFragment;->onResumeInternal()V

    .line 52
    new-instance v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    iget-object v9, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    iget-object v10, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->configurationList:Ljava/util/List;

    iget-object v11, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->liveStreamsResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-object v1, p0

    invoke-direct/range {v0 .. v11}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;-><init>(Landroid/preference/PreferenceFragment;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/downloads/RegistrationListClient;Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Lcom/xfinity/playerlib/config/PlayerConfiguration;Ljava/util/List;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->preferenceDelegate:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .line 53
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowSettingsFragment;->preferenceDelegate:Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->initPreferences()V

    .line 54
    return-void
.end method
