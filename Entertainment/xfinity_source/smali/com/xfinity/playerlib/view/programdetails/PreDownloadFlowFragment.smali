.class public Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.super Landroid/app/Fragment;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;,
        Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;,
        Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;,
        Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;,
        Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;,
        Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;,
        Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;
    }
.end annotation


# static fields
.field public static final FRAGMENT_TAG:Ljava/lang/String;

.field private static final MEDIA_AUDIO_PROFILE_COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;",
            ">;"
        }
    .end annotation
.end field

.field private static final MEDIA_PROFILE_BANDWIDTH_COMPARATOR:Ljava/util/Comparator;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Comparator",
            "<",
            "Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private final LOG:Lorg/slf4j/Logger;

.field private final abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;

.field private final abortFlowDismissListener:Landroid/content/DialogInterface$OnDismissListener;

.field private alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

.field private alternateAudioProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

.field private final application:Landroid/app/Application;

.field private final cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

.field private dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

.field private final downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

.field private final entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private final errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private flowAborted:Z

.field private flowEventListener:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;

.field private final handler:Landroid/os/Handler;

.field private final hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/hls/HlsDownloadClient",
            "<",
            "Lcom/comcast/cim/httpcomponentsandroid/client/methods/HttpUriRequest;",
            ">;"
        }
    .end annotation
.end field

.field private final httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private licenseExpirationDate:Ljava/util/Date;

.field private manifestUrl:Ljava/lang/String;

.field private final mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

.field private metaDownloadProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

.field private final pcSettingsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation
.end field

.field private final playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

.field private profileToDownload:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

.field private progressDialog:Landroid/app/ProgressDialog;

.field private progressDialogMessage:Ljava/lang/String;

.field private final registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

.field private final resources:Landroid/content/res/Resources;

.field private selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

.field private selectedVideoQuality:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

.field private shouldShowProgressDialogIfResumed:Z

.field private final taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private final thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

.field private titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;

.field private final titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

.field private watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 101
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v0}, Ljava/lang/Class;->getSimpleName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->FRAGMENT_TAG:Ljava/lang/String;

    .line 161
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$3;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$3;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->MEDIA_PROFILE_BANDWIDTH_COMPARATOR:Ljava/util/Comparator;

    .line 173
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$4;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$4;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->MEDIA_AUDIO_PROFILE_COMPARATOR:Ljava/util/Comparator;

    return-void
.end method

.method public constructor <init>()V
    .locals 1

    .prologue
    .line 230
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 99
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    .line 111
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->handler:Landroid/os/Handler;

    .line 113
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    .line 114
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 115
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 116
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->application:Landroid/app/Application;

    .line 117
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 119
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 120
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getParentalControlsSettingsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->pcSettingsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 121
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getNonDegradingVideoEntitlementProvider()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 123
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getRegisterDeviceClient()Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    .line 124
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTitaniumTicketClient()Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    .line 125
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getMediaLicenseClient()Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .line 127
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getHlsDownloadClient()Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    .line 129
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getThePlatformClient()Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    .line 131
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 133
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getCimAssetFactory()Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    .line 135
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .line 137
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 138
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 140
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->flowAborted:Z

    .line 142
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 148
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    .line 231
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;)V
    .locals 1
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p3, "flowCompletedListener"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;

    .prologue
    .line 216
    invoke-direct {p0}, Landroid/app/Fragment;-><init>()V

    .line 99
    const-class v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    .line 111
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->handler:Landroid/os/Handler;

    .line 113
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    .line 114
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 115
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 116
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->application:Landroid/app/Application;

    .line 117
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 119
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 120
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getParentalControlsSettingsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->pcSettingsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 121
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getNonDegradingVideoEntitlementProvider()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 123
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getRegisterDeviceClient()Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    .line 124
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTitaniumTicketClient()Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    .line 125
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getMediaLicenseClient()Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    .line 127
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getHlsDownloadClient()Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    .line 129
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getThePlatformClient()Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    .line 131
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 133
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getCimAssetFactory()Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    .line 135
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .line 137
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 138
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 140
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->flowAborted:Z

    .line 142
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    .line 148
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    .line 217
    invoke-static {p1}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 218
    invoke-static {p2}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 219
    invoke-static {p3}, Lorg/apache/commons/lang3/Validate;->notNull(Ljava/lang/Object;)Ljava/lang/Object;

    .line 220
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 221
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 222
    iput-object p3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->flowEventListener:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;

    .line 223
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->ensureSDCardPresent()V

    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lorg/slf4j/Logger;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchVideoEntitlement()V

    return-void
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    .param p2, "x2"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    .prologue
    .line 97
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->setSelectedHalVideoProfileAndProceedToNextStep(Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;)V

    return-void
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/authorization/ThePlatformClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->thePlatformClient:Lcom/xfinity/playerlib/authorization/ThePlatformClient;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1402(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/lang/String;)Ljava/lang/String;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->manifestUrl:Ljava/lang/String;

    return-object p1
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Ljava/lang/String;

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsVariantPlaylistAndSelectEmbeddedMediaProfile(Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->hlsDownloadClient:Lcom/comcast/cim/cmasl/hls/HlsDownloadClient;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 97
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1800()Ljava/util/Comparator;
    .locals 1

    .prologue
    .line 97
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->MEDIA_PROFILE_BANDWIDTH_COMPARATOR:Ljava/util/Comparator;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedVideoQuality:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object v0
.end method

.method static synthetic access$2000()Ljava/util/Comparator;
    .locals 1

    .prologue
    .line 97
    sget-object v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->MEDIA_AUDIO_PROFILE_COMPARATOR:Ljava/util/Comparator;

    return-object v0
.end method

.method static synthetic access$202(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object p1
.end method

.method static synthetic access$2100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    return-object v0
.end method

.method static synthetic access$2102(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaAudioProfile;

    return-object p1
.end method

.method static synthetic access$2200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->metaDownloadProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    return-object v0
.end method

.method static synthetic access$2202(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;)Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->metaDownloadProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    return-object p1
.end method

.method static synthetic access$2300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsSimplePlaylistForMediaProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V

    return-void
.end method

.method static synthetic access$2402(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->profileToDownload:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    return-object p1
.end method

.method static synthetic access$2500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchHlsAlternateAudio()V

    return-void
.end method

.method static synthetic access$2600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->ensureDeviceRegistration()V

    return-void
.end method

.method static synthetic access$2702(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;)Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    return-object p1
.end method

.method static synthetic access$2800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->registerDevice()V

    return-void
.end method

.method static synthetic access$2900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->registerDeviceClient:Lcom/xfinity/playerlib/downloads/RegisterDeviceClient;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->chooseVideoFormat()V

    return-void
.end method

.method static synthetic access$3000(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->checkParentalControls()V

    return-void
.end method

.method static synthetic access$3100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    return-object v0
.end method

.method static synthetic access$3200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/utils/provider/Provider;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Z

    .prologue
    .line 97
    invoke-direct {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic access$3300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    return-object v0
.end method

.method static synthetic access$3400(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    .param p2, "x2"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 97
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->pinRequiredForVideo(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$3500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    .prologue
    .line 97
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->promptForParentalControlPin(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V

    return-void
.end method

.method static synthetic access$3600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchTitaniumTicket()V

    return-void
.end method

.method static synthetic access$3700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicketClient:Lcom/xfinity/playerlib/downloads/TitaniumTicketClient;

    return-object v0
.end method

.method static synthetic access$3800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    return-object v0
.end method

.method static synthetic access$3802(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/downloads/TitaniumTicket;)Lcom/xfinity/playerlib/downloads/TitaniumTicket;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->titaniumTicket:Lcom/xfinity/playerlib/downloads/TitaniumTicket;

    return-object p1
.end method

.method static synthetic access$3900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->configurePlayer()V

    return-void
.end method

.method static synthetic access$4000(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->promptToRegisterDevice()V

    return-void
.end method

.method static synthetic access$4100(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->acquireMediaLicense()V

    return-void
.end method

.method static synthetic access$4200(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    return-object v0
.end method

.method static synthetic access$4300(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/downloads/MediaLicenseClient;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->mediaLicenseClient:Lcom/xfinity/playerlib/downloads/MediaLicenseClient;

    return-object v0
.end method

.method static synthetic access$4402(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/util/Date;)Ljava/util/Date;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Ljava/util/Date;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->licenseExpirationDate:Ljava/util/Date;

    return-object p1
.end method

.method static synthetic access$4500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->submitDownload()V

    return-void
.end method

.method static synthetic access$4600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    return-object v0
.end method

.method static synthetic access$4900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    return-object v0
.end method

.method static synthetic access$4902(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;)Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    .prologue
    .line 97
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    return-object p1
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/res/Resources;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnDismissListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Landroid/content/DialogInterface$OnCancelListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    return-object v0
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .prologue
    .line 97
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method private acquireMediaLicense()V
    .locals 6

    .prologue
    .line 867
    new-instance v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->application:Landroid/app/Application;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct {v1, v3, v4}, Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;-><init>(Landroid/content/Context;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    .line 868
    .local v1, "playerPlatformAPI":Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v4, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;

    invoke-direct {v4, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$26;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/playerplatform/primetime/android/player/PlayerPlatformAPI;)V

    invoke-virtual {v3, v4}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    .line 876
    .local v0, "mediaEventProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Ljava/util/Date;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v4, "Fetching media license for manifest url {}"

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->manifestUrl:Ljava/lang/String;

    invoke-interface {v3, v4, v5}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 877
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;

    invoke-direct {v2, p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$27;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 910
    .local v2, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Ljava/util/Date;>;"
    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v4, 0x0

    invoke-direct {v3, p0, v2, v4}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v0, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 911
    return-void
.end method

.method private checkParentalControls()V
    .locals 4

    .prologue
    .line 763
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Fetching parental control settings"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 764
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    sget v2, Lcom/xfinity/playerlib/R$string;->checking_parental_controls_progress_message:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;)V

    .line 765
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->pcSettingsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$21;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 779
    .local v0, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->pcSettingsProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v0, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 780
    return-void
.end method

.method private chooseVideoFormat()V
    .locals 4

    .prologue
    .line 431
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Prompting for video format"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 432
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLowQualityDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v1

    .line 433
    .local v1, "lowQualityProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    if-nez v1, :cond_0

    .line 434
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDefaultDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v2

    sget-object v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;->DEFAULT:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    invoke-direct {p0, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->setSelectedHalVideoProfileAndProceedToNextStep(Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;)V

    .line 467
    :goto_0
    return-void

    .line 436
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getHighQualityDownloadProfile()Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    move-result-object v0

    .line 437
    .local v0, "highQualityProfile":Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;

    invoke-direct {v2, p0, v1, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$9;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;)V

    const-string v3, "chooseVideoFormat"

    invoke-direct {p0, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private configurePlayer()V
    .locals 2

    .prologue
    .line 847
    invoke-static {}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->getInstance()Lcom/comcast/playerplatform/util/android/ConfigurationManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/playerplatform/util/android/ConfigurationManager;->isReady()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 848
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->acquireMediaLicense()V

    .line 864
    :goto_0
    return-void

    .line 850
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$25;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$25;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;->configurePlayerPlatform(Lcom/xfinity/playerlib/model/videoplay/PlayerConfigurationListener;)V

    goto :goto_0
.end method

.method private dismissProgressDialogIfShowing()V
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 298
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 300
    :cond_0
    return-void
.end method

.method private ensureDeviceRegistration()V
    .locals 4

    .prologue
    .line 672
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 673
    .local v1, "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getDeviceRegistration()Lcom/xfinity/playerlib/downloads/DeviceRegistration;

    move-result-object v0

    .line 674
    .local v0, "registration":Lcom/xfinity/playerlib/downloads/DeviceRegistration;
    if-nez v0, :cond_0

    .line 675
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v3, "No saved registration"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 676
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->promptToRegisterDevice()V

    .line 681
    :goto_0
    return-void

    .line 678
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Device registration found"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 679
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->checkParentalControls()V

    goto :goto_0
.end method

.method private ensureRequiredConnectivity()V
    .locals 3

    .prologue
    .line 385
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnectedNotOnWiFi()Z

    move-result v1

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getUseCellularWhenAvailable()Z

    move-result v1

    if-nez v1, :cond_0

    .line 387
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Device currently has download over cellular turned off, asking permission"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 389
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    sget v2, Lcom/xfinity/playerlib/R$string;->content_acquisition_allow_over_cellular_message:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    .line 391
    .local v0, "message":Ljava/lang/String;
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;

    invoke-direct {v1, p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$8;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/lang/String;)V

    const-string v2, "ensureRequiredConnectivity"

    invoke-direct {p0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    .line 426
    .end local v0    # "message":Ljava/lang/String;
    :goto_0
    return-void

    .line 423
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Not connected on cellular or cellular is allowed, continuing download flow"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 424
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchVideoEntitlement()V

    goto :goto_0
.end method

.method private ensureSDCardPresent()V
    .locals 2

    .prologue
    .line 361
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->isExternalStorageConnected()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 362
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->ensureRequiredConnectivity()V

    .line 382
    :goto_0
    return-void

    .line 364
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Storage unavailable, we cannot download a file without it."

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 365
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$7;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$7;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    const-string v1, "ensureSDCardPresent"

    invoke-direct {p0, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private fetchHlsAlternateAudio()V
    .locals 4

    .prologue
    .line 654
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$16;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    .line 661
    .local v0, "hlsProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;>;"
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$17;

    invoke-direct {v1, p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$17;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 668
    .local v1, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;>;"
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v0, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 669
    return-void
.end method

.method private fetchHlsSimplePlaylistForMediaProfile(Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V
    .locals 4
    .param p1, "mediaProfile"    # Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;

    .prologue
    .line 602
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$14;

    invoke-direct {v3, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$14;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist$MediaProfile;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    .line 609
    .local v0, "hlsProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;>;"
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;

    invoke-direct {v1, p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$15;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 650
    .local v1, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;>;"
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v0, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 651
    return-void
.end method

.method private fetchHlsVariantPlaylistAndSelectEmbeddedMediaProfile(Ljava/lang/String;)V
    .locals 4
    .param p1, "hlsVariantPlaylistUrl"    # Ljava/lang/String;

    .prologue
    .line 495
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;

    invoke-direct {v3, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$12;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Ljava/lang/String;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    .line 502
    .local v0, "hlsProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;>;"
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;

    invoke-direct {v1, p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$13;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 598
    .local v1, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;>;"
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v0, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 599
    return-void
.end method

.method private fetchSMILAndExtractSignedManifestUrl()V
    .locals 4

    .prologue
    .line 477
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    sget v3, Lcom/xfinity/playerlib/R$string;->fetching_download_quality_progress:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;)V

    .line 478
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$10;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$10;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    .line 484
    .local v0, "smilProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/authorization/SMILResource;>;"
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$11;

    invoke-direct {v1, p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$11;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 491
    .local v1, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Lcom/xfinity/playerlib/authorization/SMILResource;>;"
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v1, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v0, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 492
    return-void
.end method

.method private fetchTitaniumTicket()V
    .locals 4

    .prologue
    .line 807
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v3, "Fetching titanium ticket"

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 808
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    sget v3, Lcom/xfinity/playerlib/R$string;->acquiring_license_progress_message:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;)V

    .line 809
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$23;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    invoke-virtual {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v1

    .line 815
    .local v1, "titaniumTicketProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/downloads/TitaniumTicket;>;"
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$24;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 843
    .local v0, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Lcom/xfinity/playerlib/downloads/TitaniumTicket;>;"
    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v0, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 844
    return-void
.end method

.method private fetchVideoEntitlement()V
    .locals 4

    .prologue
    .line 347
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Fetching entitlement"

    invoke-interface {v1, v2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 348
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    sget v2, Lcom/xfinity/playerlib/R$string;->fetching_entitlements_progress_message:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;)V

    .line 349
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    invoke-direct {v0, p0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$6;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 357
    .local v0, "taskExecutionListener":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$RetryingExecutionListener<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->entitlementProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v0, v3}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 358
    return-void
.end method

.method private pinRequiredForVideo(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;Lcom/xfinity/playerlib/model/consumable/VideoFacade;)Z
    .locals 4
    .param p1, "pcSettings"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;
    .param p2, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .prologue
    .line 783
    invoke-virtual {p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getProtectedRatings()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoRating()Lcom/comcast/cim/model/Rating;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    invoke-virtual {p1}, Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;->getProtectedNetworkIds()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getNetworkId()J

    move-result-wide v2

    invoke-static {v2, v3}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v1

    invoke-interface {v0, v1}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private promptForParentalControlPin(Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V
    .locals 1
    .param p1, "pin"    # Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;

    .prologue
    .line 787
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;

    invoke-direct {v0, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$22;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/model/parentalcontrols/ParentalControlsPin;)V

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showParentalControlsPinFragment(Lcom/comcast/cim/cmasl/utils/provider/Provider;)V

    .line 804
    return-void
.end method

.method private promptToRegisterDevice()V
    .locals 2

    .prologue
    .line 684
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$18;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    const-string v1, "promptToRegisterDevice"

    invoke-direct {p0, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    .line 714
    return-void
.end method

.method private registerDevice()V
    .locals 3

    .prologue
    .line 717
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    sget v2, Lcom/xfinity/playerlib/R$string;->registering_device_progress_message:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;)V

    .line 718
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v2, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$19;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$19;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    .line 727
    .local v0, "regProvider":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/downloads/DeviceRegistration;>;"
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$20;

    invoke-direct {v1, p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$20;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 760
    return-void
.end method

.method private removeFromFragmentManager()V
    .locals 3

    .prologue
    .line 339
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 340
    .local v0, "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Landroid/app/Activity;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    .line 341
    .local v1, "fm":Landroid/app/FragmentManager;
    invoke-virtual {v1}, Landroid/app/FragmentManager;->beginTransaction()Landroid/app/FragmentTransaction;

    move-result-object v2

    .line 342
    .local v2, "ft":Landroid/app/FragmentTransaction;
    invoke-virtual {v2, p0}, Landroid/app/FragmentTransaction;->remove(Landroid/app/Fragment;)Landroid/app/FragmentTransaction;

    .line 343
    invoke-virtual {v2}, Landroid/app/FragmentTransaction;->commitAllowingStateLoss()I

    .line 344
    return-void
.end method

.method private reportProgress(Ljava/lang/String;)V
    .locals 1
    .param p1, "message"    # Ljava/lang/String;

    .prologue
    .line 282
    const/4 v0, 0x1

    invoke-direct {p0, p1, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;Z)V

    .line 283
    return-void
.end method

.method private reportProgress(Ljava/lang/String;Z)V
    .locals 3
    .param p1, "message"    # Ljava/lang/String;
    .param p2, "cancelable"    # Z

    .prologue
    .line 286
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 287
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, p1}, Landroid/app/ProgressDialog;->setMessage(Ljava/lang/CharSequence;)V

    .line 292
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0, p2}, Landroid/app/ProgressDialog;->setCancelable(Z)V

    .line 293
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialogMessage:Ljava/lang/String;

    .line 294
    return-void

    .line 289
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    const-string v1, ""

    const/4 v2, 0x1

    invoke-static {v0, v1, p1, v2}, Landroid/app/ProgressDialog;->show(Landroid/content/Context;Ljava/lang/CharSequence;Ljava/lang/CharSequence;Z)Landroid/app/ProgressDialog;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    .line 290
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlowCancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-virtual {v0, v1}, Landroid/app/ProgressDialog;->setOnCancelListener(Landroid/content/DialogInterface$OnCancelListener;)V

    goto :goto_0
.end method

.method private setSelectedHalVideoProfileAndProceedToNextStep(Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;)V
    .locals 0
    .param p1, "halVideoProfile"    # Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;
    .param p2, "quality"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    .prologue
    .line 470
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    .line 471
    iput-object p2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedVideoQuality:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$VideoQuality;

    .line 473
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->fetchSMILAndExtractSignedManifestUrl()V

    .line 474
    return-void
.end method

.method private showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V
    .locals 1
    .param p2, "id"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/comcast/cim/android/view/common/CALDialogFragment;",
            ">;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 303
    .local p1, "provider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/comcast/cim/android/view/common/CALDialogFragment;>;"
    const/4 v0, 0x1

    invoke-direct {p0, p1, p2, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V

    .line 304
    return-void
.end method

.method private showDialog(Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;Z)V
    .locals 2
    .param p2, "id"    # Ljava/lang/String;
    .param p3, "dismissProgressDialog"    # Z
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/comcast/cim/android/view/common/CALDialogFragment;",
            ">;",
            "Ljava/lang/String;",
            "Z)V"
        }
    .end annotation

    .prologue
    .line 307
    .local p1, "provider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/comcast/cim/android/view/common/CALDialogFragment;>;"
    if-eqz p3, :cond_0

    .line 308
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dismissProgressDialogIfShowing()V

    .line 310
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Setting lifecycle manager for dialog {}"

    invoke-interface {v0, v1, p2}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 311
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;

    invoke-direct {v0, p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DefaultDialogLifecycleManager;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;Ljava/lang/String;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    .line 312
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->onResume()V

    .line 313
    return-void
.end method

.method private showParentalControlsPinFragment(Lcom/comcast/cim/cmasl/utils/provider/Provider;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/provider/Provider",
            "<",
            "Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 316
    .local p1, "fragmentProvider":Lcom/comcast/cim/cmasl/utils/provider/Provider;, "Lcom/comcast/cim/cmasl/utils/provider/Provider<Lcom/xfinity/playerlib/view/common/ParentalControlPinFragment;>;"
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dismissProgressDialogIfShowing()V

    .line 317
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Setting lifecycle manager for parental controls pin fragment"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 318
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;

    invoke-direct {v0, p0, p1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$ParentalControlPinFragmentLifecycleManager;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/utils/provider/Provider;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    .line 319
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->onResume()V

    .line 320
    return-void
.end method

.method private submitDownload()V
    .locals 9

    .prologue
    .line 914
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->resources:Landroid/content/res/Resources;

    sget v1, Lcom/xfinity/playerlib/R$string;->submitting_download_progress_message:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;Z)V

    .line 915
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->licenseExpirationDate:Ljava/util/Date;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->profileToDownload:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->metaDownloadProfile:Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->alternateAudioPlaylist:Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->selectedHalVideoProfile:Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;

    new-instance v8, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;

    invoke-direct {v8, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$28;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    invoke-virtual/range {v0 .. v8}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->downloadHlsFileWithWatchable(Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/util/Date;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/comcast/cim/cmasl/hls/HlsVariantPlaylist;Lcom/comcast/cim/cmasl/hls/HlsSimplePlaylist;Lcom/xfinity/playerlib/model/consumable/hal/HalVideoProfile;Lcom/google/common/util/concurrent/FutureCallback;)V

    .line 944
    return-void
.end method


# virtual methods
.method public abortFlow()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    .line 323
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->flowAborted:Z

    if-nez v0, :cond_0

    .line 324
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Flow aborted"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 325
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->application:Landroid/app/Application;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->application:Landroid/app/Application;

    sget v2, Lcom/xfinity/playerlib/R$string;->download_cancelled_toast:I

    invoke-virtual {v1, v2}, Landroid/app/Application;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1, v3}, Landroid/widget/Toast;->makeText(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/Toast;->show()V

    .line 327
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->removeFromFragmentManager()V

    .line 328
    iput-boolean v3, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->flowAborted:Z

    .line 330
    :cond_0
    return-void
.end method

.method public completeFlow()V
    .locals 2

    .prologue
    .line 333
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Flow completed"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 334
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->removeFromFragmentManager()V

    .line 335
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->flowEventListener:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->video:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;->onPreDownloadFlowCompleted(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    .line 336
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 235
    invoke-super {p0, p1}, Landroid/app/Fragment;->onCreate(Landroid/os/Bundle;)V

    .line 236
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->setRetainInstance(Z)V

    .line 237
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    if-nez v0, :cond_0

    .line 242
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->LOG:Lorg/slf4j/Logger;

    const-string v1, "Prerequisites not found in onCreate, aborting"

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 243
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlow()V

    .line 254
    :goto_0
    return-void

    .line 248
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->handler:Landroid/os/Handler;

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$5;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$5;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    goto :goto_0
.end method

.method public onPause()V
    .locals 1

    .prologue
    .line 269
    invoke-super {p0}, Landroid/app/Fragment;->onPause()V

    .line 270
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->isShowing()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 271
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->shouldShowProgressDialogIfResumed:Z

    .line 272
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialog:Landroid/app/ProgressDialog;

    invoke-virtual {v0}, Landroid/app/ProgressDialog;->dismiss()V

    .line 276
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    if-eqz v0, :cond_0

    .line 277
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->onPause()V

    .line 279
    :cond_0
    return-void

    .line 274
    :cond_1
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->shouldShowProgressDialogIfResumed:Z

    goto :goto_0
.end method

.method public onResume()V
    .locals 1

    .prologue
    .line 258
    invoke-super {p0}, Landroid/app/Fragment;->onResume()V

    .line 259
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->shouldShowProgressDialogIfResumed:Z

    if-eqz v0, :cond_0

    .line 260
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->progressDialogMessage:Ljava/lang/String;

    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->reportProgress(Ljava/lang/String;)V

    .line 262
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    if-eqz v0, :cond_1

    .line 263
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->dialogLifecycleManager:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DialogLifecycleManager;->onResume()V

    .line 265
    :cond_1
    return-void
.end method

.method public setFlowEventListener(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;)V
    .locals 0
    .param p1, "flowEventListener"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;

    .prologue
    .line 226
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->flowEventListener:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$PreDownloadFlowEventListener;

    .line 227
    return-void
.end method
