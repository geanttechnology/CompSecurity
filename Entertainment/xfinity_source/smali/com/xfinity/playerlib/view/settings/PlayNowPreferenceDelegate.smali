.class public Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;
.super Lcom/comcast/cim/android/view/settings/PreferenceDelegate;
.source "PlayNowPreferenceDelegate.java"


# instance fields
.field protected androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private final app:Lcom/xfinity/playerlib/PlayerApplication;

.field private final availableConfigurations:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ">;"
        }
    .end annotation
.end field

.field private final ccPrefDelegate:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;

.field private final configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

.field private context:Landroid/app/Activity;

.field private deviceList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;"
        }
    .end annotation
.end field

.field private deviceListListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;>;"
        }
    .end annotation
.end field

.field private deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/downloads/RegisteredDevice;",
            ">;>;"
        }
    .end annotation
.end field

.field private final errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private final liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation
.end field

.field private final notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

.field private final parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation
.end field

.field private final playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private prefFragment:Landroid/preference/PreferenceFragment;

.field private final registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

.field private final taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private final unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

.field private userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;


# direct methods
.method public constructor <init>(Landroid/preference/PreferenceFragment;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/downloads/RegistrationListClient;Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Lcom/xfinity/playerlib/config/PlayerConfiguration;Ljava/util/List;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)V
    .locals 4
    .param p1, "fragment"    # Landroid/preference/PreferenceFragment;
    .param p2, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p4, "taskExecutorFactory"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .param p5, "unregisterDeviceClient"    # Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;
    .param p6, "playerDownloadServiceManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p7, "registrationListClient"    # Lcom/xfinity/playerlib/downloads/RegistrationListClient;
    .param p8, "errorFormatter"    # Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .param p9, "configuration"    # Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/preference/PreferenceFragment;",
            "Lcom/xfinity/playerlib/model/user/PlayNowUserManager;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;",
            "Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;",
            "Lcom/xfinity/playerlib/downloads/RegistrationListClient;",
            "Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/config/PlayerConfiguration;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .local p3, "parentalControlsCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;>;"
    .local p10, "availableConfigurations":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/config/PlayerConfiguration;>;"
    .local p11, "liveStreamResourceCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    const/4 v3, 0x0

    .line 89
    invoke-virtual {p1}, Landroid/preference/PreferenceFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/comcast/cim/android/view/settings/PreferenceDelegate;-><init>(Landroid/content/Context;)V

    .line 57
    invoke-static {}, Lcom/xfinity/playerlib/PlayerApplication;->getInstance()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    .line 67
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 68
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getNotificationQueueManager()Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    .line 72
    iput-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 73
    iput-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 74
    iput-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceList:Ljava/util/List;

    .line 91
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->prefFragment:Landroid/preference/PreferenceFragment;

    .line 92
    invoke-virtual {p1}, Landroid/preference/PreferenceFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    .line 93
    iput-object p2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 94
    iput-object p3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 95
    iput-object p4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 96
    iput-object p5, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    .line 97
    iput-object p6, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 98
    iput-object p7, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    .line 99
    iput-object p8, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 100
    iput-object p9, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 101
    iput-object p10, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->availableConfigurations:Ljava/util/List;

    .line 102
    iput-object p11, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 104
    new-instance v0, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPrefFragment()Landroid/preference/PreferenceFragment;

    move-result-object v2

    invoke-direct {v0, v1, v3, v2}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;-><init>(Landroid/content/Context;Landroid/preference/PreferenceActivity;Landroid/preference/PreferenceFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->ccPrefDelegate:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;

    .line 105
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->notificationQueueManager:Lcom/xfinity/playerlib/model/downloads/NotificationQueueManager;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/downloads/RegistrationListClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->registrationListClient:Lcom/xfinity/playerlib/downloads/RegistrationListClient;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1102(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceList:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;I)Landroid/preference/Preference;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;
    .param p1, "x1"    # I

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/preference/PreferenceScreen;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDevice()V

    return-void
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/Exception;)Landroid/app/AlertDialog$Builder;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;
    .param p1, "x1"    # Ljava/lang/Exception;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getErrorDialogBuilder(Ljava/lang/Exception;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/String;)Landroid/preference/Preference;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(Ljava/lang/String;)Landroid/preference/Preference;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->unregisterDeviceClient:Lcom/xfinity/playerlib/downloads/UnregisterDeviceClient;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Landroid/app/Activity;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/String;)Landroid/preference/Preference;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(Ljava/lang/String;)Landroid/preference/Preference;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$2100(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Ljava/lang/Exception;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;
    .param p1, "x1"    # Ljava/lang/Exception;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->showUnregisterErrorDialog(Ljava/lang/Exception;)V

    return-void
.end method

.method static synthetic access$2200(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->fetchDevices()V

    return-void
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->signout()V

    return-void
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/PlayerApplication;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->availableConfigurations:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method private fetchDevices()V
    .locals 2

    .prologue
    .line 369
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v1, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$11;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$11;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 375
    new-instance v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$12;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 437
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 438
    return-void
.end method

.method private getErrorDialogBuilder(Ljava/lang/Exception;)Landroid/app/AlertDialog$Builder;
    .locals 9
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 510
    instance-of v4, p1, Lcom/comcast/cim/downloads/DownloadServiceException;

    if-eqz v4, :cond_0

    .line 511
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    sget v5, Lcom/xfinity/playerlib/R$string;->device_registration_failed_title:I

    invoke-virtual {v4, v5}, Landroid/app/Activity;->getString(I)Ljava/lang/String;

    move-result-object v3

    .line 512
    .local v3, "title":Ljava/lang/String;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    sget v5, Lcom/xfinity/playerlib/R$string;->device_registration_failed_message:I

    const/4 v6, 0x1

    new-array v6, v6, [Ljava/lang/Object;

    const/4 v7, 0x0

    invoke-virtual {p1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    aput-object v8, v6, v7

    invoke-virtual {v4, v5, v6}, Landroid/app/Activity;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    .line 519
    .local v1, "description":Ljava/lang/String;
    :goto_0
    new-instance v0, Landroid/app/AlertDialog$Builder;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    invoke-direct {v0, v4}, Landroid/app/AlertDialog$Builder;-><init>(Landroid/content/Context;)V

    .line 520
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    invoke-virtual {v0, v1}, Landroid/app/AlertDialog$Builder;->setMessage(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    move-result-object v4

    .line 521
    invoke-virtual {v4, v3}, Landroid/app/AlertDialog$Builder;->setTitle(Ljava/lang/CharSequence;)Landroid/app/AlertDialog$Builder;

    .line 523
    return-object v0

    .line 514
    .end local v0    # "builder":Landroid/app/AlertDialog$Builder;
    .end local v1    # "description":Ljava/lang/String;
    .end local v3    # "title":Ljava/lang/String;
    :cond_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    invoke-interface {v4, p1}, Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v2

    .line 515
    .local v2, "formatted":Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    invoke-virtual {v2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getTitle()Ljava/lang/String;

    move-result-object v3

    .line 516
    .restart local v3    # "title":Ljava/lang/String;
    invoke-virtual {v2}, Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;->getDescription()Ljava/lang/String;

    move-result-object v1

    .restart local v1    # "description":Ljava/lang/String;
    goto :goto_0
.end method

.method private getPreferenceScreen()Landroid/preference/PreferenceScreen;
    .locals 1

    .prologue
    .line 365
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->prefFragment:Landroid/preference/PreferenceFragment;

    invoke-virtual {v0}, Landroid/preference/PreferenceFragment;->getPreferenceScreen()Landroid/preference/PreferenceScreen;

    move-result-object v0

    return-object v0
.end method

.method private isIntentAvailable(Ljava/lang/String;)Z
    .locals 4
    .param p1, "action"    # Ljava/lang/String;

    .prologue
    .line 351
    iget-object v3, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    invoke-virtual {v3}, Landroid/app/Activity;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v2

    .line 352
    .local v2, "packageManager":Landroid/content/pm/PackageManager;
    new-instance v0, Landroid/content/Intent;

    invoke-direct {v0, p1}, Landroid/content/Intent;-><init>(Ljava/lang/String;)V

    .line 353
    .local v0, "intent":Landroid/content/Intent;
    const/high16 v3, 0x10000

    invoke-virtual {v2, v0, v3}, Landroid/content/pm/PackageManager;->queryIntentActivities(Landroid/content/Intent;I)Ljava/util/List;

    move-result-object v1

    .line 355
    .local v1, "list":Ljava/util/List;, "Ljava/util/List<Landroid/content/pm/ResolveInfo;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    const/4 v3, 0x1

    :goto_0
    return v3

    :cond_0
    const/4 v3, 0x0

    goto :goto_0
.end method

.method private showUnregisterErrorDialog(Ljava/lang/Exception;)V
    .locals 4
    .param p1, "exception"    # Ljava/lang/Exception;

    .prologue
    .line 527
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->getErrorDialogBuilder(Ljava/lang/Exception;)Landroid/app/AlertDialog$Builder;

    move-result-object v0

    .line 528
    .local v0, "builder":Landroid/app/AlertDialog$Builder;
    sget v1, Lcom/xfinity/playerlib/R$string;->dlg_btn_try_again:I

    new-instance v2, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$17;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$17;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    invoke-virtual {v0, v1, v2}, Landroid/app/AlertDialog$Builder;->setPositiveButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->dlg_btn_ok:I

    new-instance v3, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$16;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$16;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    .line 535
    invoke-virtual {v1, v2, v3}, Landroid/app/AlertDialog$Builder;->setNegativeButton(ILandroid/content/DialogInterface$OnClickListener;)Landroid/app/AlertDialog$Builder;

    move-result-object v1

    new-instance v2, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$15;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    .line 540
    invoke-virtual {v1, v2}, Landroid/app/AlertDialog$Builder;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)Landroid/app/AlertDialog$Builder;

    .line 558
    invoke-virtual {v0}, Landroid/app/AlertDialog$Builder;->create()Landroid/app/AlertDialog;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/AlertDialog;->show()V

    .line 559
    return-void
.end method

.method private signout()V
    .locals 3

    .prologue
    .line 500
    new-instance v0, Landroid/content/Intent;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    const-class v2, Lcom/xfinity/playerlib/view/authentication/PlayNowSignoutActivity;

    invoke-direct {v0, v1, v2}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 501
    .local v0, "intent":Landroid/content/Intent;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    invoke-virtual {v1, v0}, Landroid/app/Activity;->startActivity(Landroid/content/Intent;)V

    .line 502
    return-void
.end method

.method private unregisterDevice()V
    .locals 4

    .prologue
    .line 450
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 451
    .local v0, "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v3, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;

    invoke-direct {v3, p0, v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$13;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v1

    .line 458
    .local v1, "unregisterResourceProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Ljava/lang/Void;>;"
    new-instance v2, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;

    invoke-direct {v2, p0, v0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$14;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 497
    return-void
.end method


# virtual methods
.method public cancelListeners()V
    .locals 2

    .prologue
    .line 444
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 445
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->deviceListListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 447
    :cond_0
    return-void
.end method

.method protected getPrefFragment()Landroid/preference/PreferenceFragment;
    .locals 1

    .prologue
    .line 360
    iget-object v0, p0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->prefFragment:Landroid/preference/PreferenceFragment;

    return-object v0
.end method

.method public initPreferences()V
    .locals 34

    .prologue
    .line 109
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_show_adult:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v20

    check-cast v20, Landroid/preference/CheckBoxPreference;

    .line 110
    .local v20, "showAdultContentPref":Landroid/preference/CheckBoxPreference;
    if-eqz v20, :cond_0

    .line 111
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v19

    check-cast v19, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 112
    .local v19, "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z

    move-result v28

    move-object/from16 v0, v20

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 113
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$1;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    move-object/from16 v0, v20

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 133
    .end local v19    # "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :cond_0
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_signout:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v23

    .line 134
    .local v23, "signout":Landroid/preference/Preference;
    if-eqz v23, :cond_1

    .line 135
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v28

    check-cast v28, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/model/user/PlayNowUser;->getUserName()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v23

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 136
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$2;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$2;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    move-object/from16 v0, v23

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/Preference;->setOnPreferenceClickListener(Landroid/preference/Preference$OnPreferenceClickListener;)V

    .line 145
    :cond_1
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->context:Landroid/app/Activity;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Landroid/app/Activity;->getApplicationContext()Landroid/content/Context;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v17

    .line 147
    .local v17, "packageName":Ljava/lang/String;
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_app_version_info:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v4

    .line 149
    .local v4, "appVersionInfo":Landroid/preference/Preference;
    if-eqz v4, :cond_2

    .line 150
    const-string v26, "not available"

    .line 152
    .local v26, "versionString":Ljava/lang/String;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/PlayerApplication;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v28

    const/16 v29, 0x0

    move-object/from16 v0, v28

    move-object/from16 v1, v17

    move/from16 v2, v29

    invoke-virtual {v0, v1, v2}, Landroid/content/pm/PackageManager;->getPackageInfo(Ljava/lang/String;I)Landroid/content/pm/PackageInfo;

    move-result-object v28

    move-object/from16 v0, v28

    iget-object v0, v0, Landroid/content/pm/PackageInfo;->versionName:Ljava/lang/String;

    move-object/from16 v26, v0
    :try_end_0
    .catch Landroid/content/pm/PackageManager$NameNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .line 157
    :goto_0
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    move-object/from16 v0, v28

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    const-string v29, " "

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Lcom/comcast/cim/container/PlayerContainer;->getConfigurationVersion()Ljava/lang/String;

    move-result-object v29

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    .line 159
    new-instance v28, Ljava/lang/StringBuilder;

    invoke-direct/range {v28 .. v28}, Ljava/lang/StringBuilder;-><init>()V

    const-string v29, "Application Version "

    invoke-virtual/range {v28 .. v29}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    move-object/from16 v0, v28

    move-object/from16 v1, v26

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v4, v0}, Landroid/preference/Preference;->setTitle(Ljava/lang/CharSequence;)V

    .line 162
    .end local v26    # "versionString":Ljava/lang/String;
    :cond_2
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_use_cellular_data:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v24

    check-cast v24, Landroid/preference/CheckBoxPreference;

    .line 163
    .local v24, "useCellular":Landroid/preference/CheckBoxPreference;
    if-eqz v24, :cond_3

    .line 164
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v19

    check-cast v19, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 165
    .restart local v19    # "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getUseCellularWhenAvailable()Z

    move-result v28

    move-object/from16 v0, v24

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 166
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$3;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    move-object/from16 v0, v24

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 181
    .end local v19    # "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    :cond_3
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_manage_devices_loading_key:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v16

    .line 182
    .local v16, "loadingDevices":Landroid/preference/Preference;
    if-eqz v16, :cond_4

    .line 183
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->fetchDevices()V

    .line 186
    :cond_4
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v19

    check-cast v19, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 187
    .restart local v19    # "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_show_volume:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v22

    check-cast v22, Landroid/preference/CheckBoxPreference;

    .line 188
    .local v22, "showVolumeControlCheck":Landroid/preference/CheckBoxPreference;
    if-eqz v22, :cond_5

    .line 189
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsVolumeControl()Z

    move-result v28

    move-object/from16 v0, v22

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 190
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$4;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$4;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    move-object/from16 v0, v22

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 201
    :cond_5
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_show_brightness:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v21

    check-cast v21, Landroid/preference/CheckBoxPreference;

    .line 202
    .local v21, "showBrightnessControlCheck":Landroid/preference/CheckBoxPreference;
    if-eqz v21, :cond_6

    .line 203
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsBrightnessControl()Z

    move-result v28

    move-object/from16 v0, v21

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 204
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$5;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$5;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    move-object/from16 v0, v21

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/CheckBoxPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 215
    :cond_6
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_video_quality:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v27

    check-cast v27, Landroid/preference/ListPreference;

    .line 216
    .local v27, "videoQualityPreference":Landroid/preference/ListPreference;
    if-eqz v27, :cond_7

    .line 217
    invoke-virtual/range {v19 .. v19}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsStaticBitrate()Z

    move-result v28

    invoke-static/range {v28 .. v28}, Ljava/lang/String;->valueOf(Z)Ljava/lang/String;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    .line 218
    invoke-virtual/range {v27 .. v27}, Landroid/preference/ListPreference;->getEntry()Ljava/lang/CharSequence;

    move-result-object v28

    invoke-virtual/range {v27 .. v28}, Landroid/preference/ListPreference;->setSummary(Ljava/lang/CharSequence;)V

    .line 219
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$6;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    move-object/from16 v2, v19

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$6;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Lcom/xfinity/playerlib/model/user/PlayerUserSettings;)V

    invoke-virtual/range {v27 .. v28}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 231
    :cond_7
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_cc_options:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v6

    check-cast v6, Landroid/preference/PreferenceScreen;

    .line 232
    .local v6, "ccOptionsScreen":Landroid/preference/PreferenceScreen;
    if-eqz v6, :cond_8

    .line 233
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->ccPrefDelegate:Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v28

    check-cast v28, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;

    move-object/from16 v0, v29

    move-object/from16 v1, v28

    invoke-virtual {v0, v1, v6}, Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreferenceDelegate;->setupPreferences(Lcom/comcast/cim/cmasl/android708compatlib/view/preference/CCPreviewPreference$CCPreferenceStore;Landroid/preference/PreferenceScreen;)V

    .line 237
    :cond_8
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_developer_options:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v13

    check-cast v13, Landroid/preference/PreferenceScreen;

    .line 238
    .local v13, "developerOptions":Landroid/preference/PreferenceScreen;
    if-eqz v13, :cond_c

    .line 239
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_developer_configuration:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v11

    check-cast v11, Landroid/preference/ListPreference;

    .line 240
    .local v11, "devConfiguration":Landroid/preference/ListPreference;
    if-eqz v11, :cond_a

    .line 241
    new-instance v8, Ljava/util/ArrayList;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->availableConfigurations:Ljava/util/List;

    move-object/from16 v28, v0

    invoke-interface/range {v28 .. v28}, Ljava/util/List;->size()I

    move-result v28

    move/from16 v0, v28

    invoke-direct {v8, v0}, Ljava/util/ArrayList;-><init>(I)V

    .line 242
    .local v8, "configurationValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    move-object/from16 v28, v0

    sget v29, Lcom/xfinity/playerlib/R$string;->settings_developer_configuration_default:I

    invoke-virtual/range {v28 .. v29}, Lcom/xfinity/playerlib/PlayerApplication;->getString(I)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 243
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->availableConfigurations:Ljava/util/List;

    move-object/from16 v28, v0

    invoke-interface/range {v28 .. v28}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v28

    :goto_1
    invoke-interface/range {v28 .. v28}, Ljava/util/Iterator;->hasNext()Z

    move-result v29

    if-eqz v29, :cond_9

    invoke-interface/range {v28 .. v28}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/config/PlayerConfiguration;

    .line 244
    .local v7, "config":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    invoke-virtual {v7}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-interface {v8, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_1

    .line 247
    .end local v7    # "config":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    :cond_9
    invoke-interface {v8}, Ljava/util/List;->size()I

    move-result v28

    move/from16 v0, v28

    new-array v0, v0, [Ljava/lang/CharSequence;

    move-object/from16 v28, v0

    move-object/from16 v0, v28

    invoke-interface {v8, v0}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v25

    check-cast v25, [Ljava/lang/CharSequence;

    .line 248
    .local v25, "values":[Ljava/lang/CharSequence;
    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setEntries([Ljava/lang/CharSequence;)V

    .line 249
    move-object/from16 v0, v25

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setEntryValues([Ljava/lang/CharSequence;)V

    .line 251
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->getDeveloperConfiguration()Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-result-object v9

    .line 252
    .local v9, "currentConfig":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    if-eqz v9, :cond_12

    .line 253
    invoke-virtual {v9}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v28

    invoke-virtual/range {v28 .. v28}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    .line 254
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    move-object/from16 v28, v0

    sget v29, Lcom/xfinity/playerlib/R$string;->settings_title_developer_configuration:I

    const/16 v30, 0x1

    move/from16 v0, v30

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v30, v0

    const/16 v31, 0x0

    invoke-virtual {v9}, Ljava/lang/Object;->getClass()Ljava/lang/Class;

    move-result-object v32

    invoke-virtual/range {v32 .. v32}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v32

    aput-object v32, v30, v31

    invoke-virtual/range {v28 .. v30}, Lcom/xfinity/playerlib/PlayerApplication;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setTitle(Ljava/lang/CharSequence;)V

    .line 260
    :goto_2
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$7;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    move-object/from16 v0, v28

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 280
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDeveloperModeEnabled()Z

    move-result v28

    move/from16 v0, v28

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setEnabled(Z)V

    .line 283
    .end local v8    # "configurationValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v9    # "currentConfig":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .end local v25    # "values":[Ljava/lang/CharSequence;
    :cond_a
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_show_dark_streams:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v10

    check-cast v10, Landroid/preference/CheckBoxPreference;

    .line 284
    .local v10, "darkStreams":Landroid/preference/CheckBoxPreference;
    if-eqz v10, :cond_b

    .line 285
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDeveloperModeEnabled()Z

    move-result v28

    move/from16 v0, v28

    invoke-virtual {v10, v0}, Landroid/preference/CheckBoxPreference;->setEnabled(Z)V

    .line 286
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDarkStreamsEnabled()Z

    move-result v28

    move/from16 v0, v28

    invoke-virtual {v10, v0}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 287
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$8;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$8;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    move-object/from16 v0, v28

    invoke-virtual {v10, v0}, Landroid/preference/CheckBoxPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 299
    :cond_b
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_dev_mode_on:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v12

    check-cast v12, Landroid/preference/CheckBoxPreference;

    .line 300
    .local v12, "devModeBox":Landroid/preference/CheckBoxPreference;
    if-eqz v12, :cond_c

    .line 301
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->configuration:Lcom/xfinity/playerlib/config/PlayerConfiguration;

    move-object/from16 v28, v0

    invoke-virtual/range {v28 .. v28}, Lcom/xfinity/playerlib/config/PlayerConfiguration;->isDeveloperModeEnabled()Z

    move-result v28

    move/from16 v0, v28

    invoke-virtual {v12, v0}, Landroid/preference/CheckBoxPreference;->setChecked(Z)V

    .line 302
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-direct {v0, v1, v11, v10}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$9;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;Landroid/preference/ListPreference;Landroid/preference/CheckBoxPreference;)V

    move-object/from16 v0, v28

    invoke-virtual {v12, v0}, Landroid/preference/CheckBoxPreference;->setOnPreferenceChangeListener(Landroid/preference/Preference$OnPreferenceChangeListener;)V

    .line 316
    .end local v10    # "darkStreams":Landroid/preference/CheckBoxPreference;
    .end local v11    # "devConfiguration":Landroid/preference/ListPreference;
    .end local v12    # "devModeBox":Landroid/preference/CheckBoxPreference;
    :cond_c
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_call_us:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v5

    .line 317
    .local v5, "callUs":Landroid/preference/Preference;
    if-eqz v5, :cond_d

    .line 319
    const-string v28, "android.intent.action.DIAL"

    move-object/from16 v0, p0

    move-object/from16 v1, v28

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->isIntentAvailable(Ljava/lang/String;)Z

    move-result v28

    if-nez v28, :cond_d

    .line 320
    new-instance v28, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$10;

    move-object/from16 v0, v28

    move-object/from16 v1, p0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate$10;-><init>(Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;)V

    move-object/from16 v0, v28

    invoke-virtual {v5, v0}, Landroid/preference/Preference;->setOnPreferenceClickListener(Landroid/preference/Preference$OnPreferenceClickListener;)V

    .line 329
    :cond_d
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_developer_viper_version:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v18

    .line 330
    .local v18, "playerPlatformVersion":Landroid/preference/Preference;
    if-eqz v18, :cond_e

    .line 331
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;->getPlayerPlatformVersion()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v18

    move-object/from16 v1, v28

    invoke-virtual {v0, v1}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 334
    :cond_e
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_developer_adobe_version:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v3

    .line 335
    .local v3, "adobeVersion":Landroid/preference/Preference;
    if-eqz v3, :cond_f

    .line 336
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;->getAdobeVersion()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v3, v0}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 339
    :cond_f
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_developer_disney_version:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v14

    .line 340
    .local v14, "disneyVersion":Landroid/preference/Preference;
    if-eqz v14, :cond_10

    .line 341
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;->getDisneyVersion()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v14, v0}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 344
    :cond_10
    sget v28, Lcom/xfinity/playerlib/R$string;->settings_key_developer_espn_version:I

    move-object/from16 v0, p0

    move/from16 v1, v28

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->findPreference(I)Landroid/preference/Preference;

    move-result-object v15

    .line 345
    .local v15, "espnVersion":Landroid/preference/Preference;
    if-eqz v15, :cond_11

    .line 346
    invoke-static {}, Lcom/comcast/playerplatform/primetime/android/util/PlayerPlatformVersion;->getEspnVersion()Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v15, v0}, Landroid/preference/Preference;->setSummary(Ljava/lang/CharSequence;)V

    .line 348
    :cond_11
    return-void

    .line 256
    .end local v3    # "adobeVersion":Landroid/preference/Preference;
    .end local v5    # "callUs":Landroid/preference/Preference;
    .end local v14    # "disneyVersion":Landroid/preference/Preference;
    .end local v15    # "espnVersion":Landroid/preference/Preference;
    .end local v18    # "playerPlatformVersion":Landroid/preference/Preference;
    .restart local v8    # "configurationValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .restart local v9    # "currentConfig":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .restart local v11    # "devConfiguration":Landroid/preference/ListPreference;
    .restart local v25    # "values":[Ljava/lang/CharSequence;
    :cond_12
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    move-object/from16 v28, v0

    sget v29, Lcom/xfinity/playerlib/R$string;->settings_developer_configuration_default:I

    invoke-virtual/range {v28 .. v29}, Lcom/xfinity/playerlib/PlayerApplication;->getString(I)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setValue(Ljava/lang/String;)V

    .line 257
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    move-object/from16 v28, v0

    sget v29, Lcom/xfinity/playerlib/R$string;->settings_title_developer_configuration:I

    const/16 v30, 0x1

    move/from16 v0, v30

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v30, v0

    const/16 v31, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/settings/PlayNowPreferenceDelegate;->app:Lcom/xfinity/playerlib/PlayerApplication;

    move-object/from16 v32, v0

    sget v33, Lcom/xfinity/playerlib/R$string;->settings_developer_configuration_default:I

    invoke-virtual/range {v32 .. v33}, Lcom/xfinity/playerlib/PlayerApplication;->getString(I)Ljava/lang/String;

    move-result-object v32

    aput-object v32, v30, v31

    invoke-virtual/range {v28 .. v30}, Lcom/xfinity/playerlib/PlayerApplication;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v28

    move-object/from16 v0, v28

    invoke-virtual {v11, v0}, Landroid/preference/ListPreference;->setTitle(Ljava/lang/CharSequence;)V

    goto/16 :goto_2

    .line 153
    .end local v6    # "ccOptionsScreen":Landroid/preference/PreferenceScreen;
    .end local v8    # "configurationValues":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v9    # "currentConfig":Lcom/xfinity/playerlib/config/PlayerConfiguration;
    .end local v11    # "devConfiguration":Landroid/preference/ListPreference;
    .end local v13    # "developerOptions":Landroid/preference/PreferenceScreen;
    .end local v16    # "loadingDevices":Landroid/preference/Preference;
    .end local v19    # "settings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    .end local v21    # "showBrightnessControlCheck":Landroid/preference/CheckBoxPreference;
    .end local v22    # "showVolumeControlCheck":Landroid/preference/CheckBoxPreference;
    .end local v24    # "useCellular":Landroid/preference/CheckBoxPreference;
    .end local v25    # "values":[Ljava/lang/CharSequence;
    .end local v27    # "videoQualityPreference":Landroid/preference/ListPreference;
    .restart local v26    # "versionString":Ljava/lang/String;
    :catch_0
    move-exception v28

    goto/16 :goto_0
.end method
