.class public Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
.super Ljava/lang/Object;
.source "VideoStateController.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final activityContext:Landroid/app/Activity;

.field private amsErrorCount:Ljava/util/concurrent/atomic/AtomicInteger;

.field private final androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private final authContinueExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

.field private authContinueFuture:Ljava/util/concurrent/ScheduledFuture;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ScheduledFuture",
            "<*>;"
        }
    .end annotation
.end field

.field private final cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

.field private currentBitrate:J

.field private currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

.field private downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

.field private drmKey:Ljava/lang/String;

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private final errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private hasPreroll:Z

.field private final httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private httpPort:I

.field private ignoreMobileDataWarningSettingThisSession:Z

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

.field private final liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation
.end field

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

.field private localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

.field private manifestUrl:Ljava/lang/String;

.field private mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

.field private final movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;"
        }
    .end annotation
.end field

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

.field private playbackStarted:Z

.field private final playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

.field private final playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

.field private final playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private prerollChecked:Z

.field private final providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private final seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation
.end field

.field private final splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

.field private ticks:I

.field private final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private final uiController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

.field private final uiThreadExecutor:Ljava/util/concurrent/Executor;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private final videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

.field private final videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field

.field private videoEventListener:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;

.field private videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

.field private final videoTrackController:Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

.field private watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

.field private final watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 75
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>(Landroid/app/Activity;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/comcast/cim/model/system/PlayerAndroidDevice;Lcom/xfinity/playerlib/authorization/VideoAuthManager;Ljava/util/concurrent/Executor;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V
    .locals 8
    .param p1, "activityContext"    # Landroid/app/Activity;
    .param p2, "uiController"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
    .param p3, "playerDownloadServiceManager"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .param p4, "providerFactory"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .param p10, "watchableCodec"    # Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
    .param p11, "internetConnection"    # Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .param p12, "userManager"    # Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .param p13, "androidDevice"    # Lcom/comcast/cim/model/system/PlayerAndroidDevice;
    .param p14, "videoAuthManager"    # Lcom/xfinity/playerlib/authorization/VideoAuthManager;
    .param p15, "uiThreadExecutor"    # Ljava/util/concurrent/Executor;
    .param p17, "videoBookmarkDAO"    # Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;
    .param p18, "liveStreamBookmarkDAO"    # Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .param p19, "playerApplication"    # Lcom/xfinity/playerlib/PlayerApplication;
    .param p20, "httpClient"    # Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .param p21, "cimAssetFactory"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;
    .param p22, "playerConfigUtil"    # Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;
    .param p23, "splunker"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .param p24, "foxLogger"    # Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .param p25, "trackingService"    # Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    .param p26, "errorFormatter"    # Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;
    .param p27, "errorDialogFactory"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Landroid/app/Activity;",
            "Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;",
            "Lcom/xfinity/playerlib/model/consumable/WatchableCodec;",
            "Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;",
            "Lcom/xfinity/playerlib/model/user/PlayNowUserManager;",
            "Lcom/comcast/cim/model/system/PlayerAndroidDevice;",
            "Lcom/xfinity/playerlib/authorization/VideoAuthManager;",
            "Ljava/util/concurrent/Executor;",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;",
            "Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;",
            "Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;",
            "Lcom/xfinity/playerlib/PlayerApplication;",
            "Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;",
            "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;",
            "Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;",
            "Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;",
            "Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;",
            "Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;",
            "Lcom/comcast/cim/android/view/common/ErrorDialogFactory;",
            ")V"
        }
    .end annotation

    .prologue
    .line 161
    .local p5, "movieCacheMap":Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;"
    .local p6, "seriesCacheMap":Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory<Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    .local p7, "liveStreamMetaDataResourceFactory":Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;, "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory<Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;>;"
    .local p8, "videoEntitlementCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    .local p9, "liveStreamResourceCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    .local p16, "parentalControlsCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;>;"
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 82
    new-instance v2, Ljava/util/concurrent/atomic/AtomicInteger;

    invoke-direct {v2}, Ljava/util/concurrent/atomic/AtomicInteger;-><init>()V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->amsErrorCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 91
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 92
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 93
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 94
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 95
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ignoreMobileDataWarningSettingThisSession:Z

    .line 96
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->manifestUrl:Ljava/lang/String;

    .line 97
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->drmKey:Ljava/lang/String;

    .line 98
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    .line 99
    const/16 v2, 0x2122

    iput v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpPort:I

    .line 100
    const/4 v2, 0x0

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueFuture:Ljava/util/concurrent/ScheduledFuture;

    .line 121
    new-instance v2, Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    const/4 v3, 0x1

    invoke-direct {v2, v3}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;-><init>(I)V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    .line 133
    const-wide/16 v2, -0x1

    iput-wide v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentBitrate:J

    .line 136
    const/4 v2, 0x0

    iput v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I

    .line 141
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->prerollChecked:Z

    .line 142
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->hasPreroll:Z

    .line 1072
    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;

    const/4 v3, 0x0

    invoke-direct {v2, p0, v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoEventListener:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;

    .line 162
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->activityContext:Landroid/app/Activity;

    .line 163
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->uiController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    .line 164
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 165
    iput-object p4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 166
    iput-object p5, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 167
    iput-object p6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 168
    iput-object p7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 169
    move-object/from16 v0, p8

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 170
    move-object/from16 v0, p9

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 171
    move-object/from16 v0, p10

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    .line 172
    move-object/from16 v0, p11

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 173
    move-object/from16 v0, p12

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 174
    move-object/from16 v0, p13

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 175
    move-object/from16 v0, p14

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    .line 176
    move-object/from16 v0, p15

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    .line 177
    move-object/from16 v0, p16

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 178
    move-object/from16 v0, p19

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    .line 179
    move-object/from16 v0, p20

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 180
    move-object/from16 v0, p25

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 181
    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    move-object/from16 v3, p17

    move-object/from16 v4, p18

    move-object/from16 v5, p12

    move-object/from16 v6, p25

    move-object/from16 v7, p24

    invoke-direct/range {v2 .. v7}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;-><init>(Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoTrackController:Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    .line 182
    move-object/from16 v0, p21

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    .line 183
    move-object/from16 v0, p22

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .line 184
    move-object/from16 v0, p23

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .line 185
    move-object/from16 v0, p26

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 186
    move-object/from16 v0, p27

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 190
    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 191
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/authorization/VideoAuthManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    return-object v0
.end method

.method static synthetic access$100()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 73
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playbackStarted:Z

    return v0
.end method

.method static synthetic access$1202(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p1, "x1"    # Z

    .prologue
    .line 73
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playbackStarted:Z

    return p1
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Ljava/util/concurrent/atomic/AtomicInteger;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->amsErrorCount:Ljava/util/concurrent/atomic/AtomicInteger;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Ljava/util/concurrent/Executor;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method static synthetic access$402(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;J)J
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .param p1, "x1"    # J

    .prologue
    .line 73
    iput-wide p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentBitrate:J

    return-wide p1
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I

    return v0
.end method

.method static synthetic access$708(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)I
    .locals 2
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I

    add-int/lit8 v1, v0, 0x1

    iput v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I

    return v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    return-object v0
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    return-object v0
.end method


# virtual methods
.method public cancelAmsContinueCalls()V
    .locals 2

    .prologue
    .line 618
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueFuture:Ljava/util/concurrent/ScheduledFuture;

    if-eqz v0, :cond_0

    .line 619
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueFuture:Ljava/util/concurrent/ScheduledFuture;

    const/4 v1, 0x1

    invoke-interface {v0, v1}, Ljava/util/concurrent/ScheduledFuture;->cancel(Z)Z

    .line 620
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueFuture:Ljava/util/concurrent/ScheduledFuture;

    .line 622
    :cond_0
    return-void
.end method

.method public checkShouldPauseDownloads()V
    .locals 3

    .prologue
    .line 741
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    if-eqz v1, :cond_1

    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v1

    if-eqz v1, :cond_2

    .line 743
    :cond_1
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->initiateTemporaryPause()V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 753
    :goto_0
    return-void

    .line 744
    :catch_0
    move-exception v0

    .line 746
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Failed to pause downloads"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0

    .line 751
    .end local v0    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->unpauseDownloads()V

    goto :goto_0
.end method

.method public createAsset()Lcom/comcast/playerplatform/primetime/android/asset/Asset;
    .locals 10

    .prologue
    .line 718
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    if-eqz v0, :cond_3

    .line 719
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isEspn()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 720
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "liveEventID"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    .line 721
    .local v3, "eventId":Ljava/lang/String;
    if-nez v3, :cond_0

    .line 722
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getSchemeSpecificPart()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDrmKey()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v4

    invoke-virtual {v0, v1, v2, v4}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->create(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    .line 734
    .end local v3    # "eventId":Ljava/lang/String;
    :goto_0
    return-object v0

    .line 724
    .restart local v3    # "eventId":Ljava/lang/String;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getSchemeSpecificPart()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDrmKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v5

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->create(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    goto :goto_0

    .line 726
    .end local v3    # "eventId":Ljava/lang/String;
    :cond_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isDisney()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 727
    iget-object v4, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getSchemeSpecificPart()Ljava/lang/String;

    move-result-object v5

    .line 728
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getSchemeSpecificPart()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDrmKey()Ljava/lang/String;

    move-result-object v7

    .line 729
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v8

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v9

    .line 727
    invoke-virtual/range {v4 .. v9}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->create(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/player/DisneyEspnTokenDelegate;Landroid/app/Activity;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    goto :goto_0

    .line 731
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getManifestUrl()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDrmKey()Ljava/lang/String;

    move-result-object v2

    sget-object v4, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v5

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v0, v1, v2, v4, v5}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->create(Ljava/lang/String;Ljava/lang/String;Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    goto :goto_0

    .line 734
    :cond_3
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getManifestUrl()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getDrmKey()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v5

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    if-nez v0, :cond_4

    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->STREAMING:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    :goto_1
    invoke-virtual {v1, v2, v4, v5, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;->create(Ljava/lang/String;Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;)Lcom/comcast/playerplatform/primetime/android/asset/Asset;

    move-result-object v0

    goto :goto_0

    :cond_4
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;->LOCAL:Lcom/comcast/playerplatform/primetime/android/enums/DrmWorkflow;

    goto :goto_1
.end method

.method public formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;
    .locals 1
    .param p1, "error"    # Ljava/lang/Throwable;

    .prologue
    .line 580
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    invoke-interface {v0, p1}, Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;->formatError(Ljava/lang/Throwable;)Lcom/comcast/cim/android/view/common/errorformatter/FormattedError;

    move-result-object v0

    return-object v0
.end method

.method public getActivityContext()Landroid/app/Activity;
    .locals 1

    .prologue
    .line 479
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->activityContext:Landroid/app/Activity;

    return-object v0
.end method

.method public getAdDuration()J
    .locals 2

    .prologue
    .line 1079
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getCurrentAdDuration()J

    move-result-wide v0

    return-wide v0
.end method

.method public getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;
    .locals 1

    .prologue
    .line 531
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    return-object v0
.end method

.method public getBasicVideoErrorEventData(Ljava/lang/String;)Lcom/comcast/cim/analytics/VideoErrorEventData;
    .locals 4
    .param p1, "failureEvent"    # Ljava/lang/String;

    .prologue
    .line 1017
    new-instance v0, Lcom/comcast/cim/analytics/VideoErrorEventData;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getHashedOmnitureGuid()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionNumber()Ljava/lang/String;

    move-result-object v2

    invoke-direct {v0, p1, v1, v2}, Lcom/comcast/cim/analytics/VideoErrorEventData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    .line 1019
    .local v0, "videoErrorEventData":Lcom/comcast/cim/analytics/VideoErrorEventData;
    iget-wide v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentBitrate:J

    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setBitrate(J)V

    .line 1020
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    if-eqz v1, :cond_1

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPosition()J

    move-result-wide v2

    :goto_0
    invoke-virtual {v0, v2, v3}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setCurrentPlaybackPosition(J)V

    .line 1021
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    if-eqz v1, :cond_2

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->isAdPlaying()Z

    move-result v1

    if-eqz v1, :cond_2

    const/4 v1, 0x1

    :goto_1
    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setInAd(Z)V

    .line 1023
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    if-eqz v1, :cond_3

    .line 1024
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setVideoTitle(Ljava/lang/String;)V

    .line 1025
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getPid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setPid(Ljava/lang/String;)V

    .line 1026
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getReleaseURL()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setReleaseUrl(Ljava/lang/String;)V

    .line 1027
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isCC()Z

    move-result v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setCc(Z)V

    .line 1028
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getLanguageCodes()Ljava/util/List;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setLanguages(Ljava/util/List;)V

    .line 1035
    :cond_0
    :goto_2
    return-object v0

    .line 1020
    :cond_1
    const-wide/16 v2, -0x1

    goto :goto_0

    .line 1021
    :cond_2
    const/4 v1, 0x0

    goto :goto_1

    .line 1029
    :cond_3
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    if-eqz v1, :cond_0

    .line 1030
    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "Live: "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setVideoTitle(Ljava/lang/String;)V

    .line 1031
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setPid(Ljava/lang/String;)V

    .line 1032
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/analytics/VideoErrorEventData;->setReleaseUrl(Ljava/lang/String;)V

    goto :goto_2
.end method

.method public getDownloadedFile()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .locals 1

    .prologue
    .line 437
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    return-object v0
.end method

.method public getDrmKey()Ljava/lang/String;
    .locals 1

    .prologue
    .line 462
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->drmKey:Ljava/lang/String;

    return-object v0
.end method

.method public getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .locals 1

    .prologue
    .line 584
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    return-object v0
.end method

.method public getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;
    .locals 1

    .prologue
    .line 568
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    return-object v0
.end method

.method public getHttpPort()I
    .locals 1

    .prologue
    .line 1116
    iget v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpPort:I

    return v0
.end method

.method public getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;
    .locals 1

    .prologue
    .line 523
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    return-object v0
.end method

.method public getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .locals 1

    .prologue
    .line 407
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    return-object v0
.end method

.method public getLiveStreamMetaDataResourceFactory()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Ljava/lang/String;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation

    .prologue
    .line 515
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method public getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 511
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method public getLocalHostServer()Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;
    .locals 1

    .prologue
    .line 470
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    return-object v0
.end method

.method public getManifestUrl()Ljava/lang/String;
    .locals 1

    .prologue
    .line 454
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->manifestUrl:Ljava/lang/String;

    return-object v0
.end method

.method public getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;
    .locals 1

    .prologue
    .line 483
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    return-object v0
.end method

.method public getMediaStreamExecutor()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 548
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    return-object v0
.end method

.method public getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 499
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method public getNextVideoItem()Lcom/comcast/cim/cmasl/utils/container/Tuple;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 433
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getLanguage()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v1, v2}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getNextVideoItem(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v0

    return-object v0
.end method

.method public getParentalControlsCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/model/parentalcontrols/ParentalControlsSettings;",
            ">;"
        }
    .end annotation

    .prologue
    .line 556
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method public getPlayerApplication()Lcom/xfinity/playerlib/PlayerApplication;
    .locals 1

    .prologue
    .line 560
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    return-object v0
.end method

.method public getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;
    .locals 1

    .prologue
    .line 572
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    return-object v0
.end method

.method public getPlayerDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1

    .prologue
    .line 491
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    return-object v0
.end method

.method public getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory",
            "<",
            "Lcom/xfinity/playerlib/model/MerlinId;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;",
            ">;"
        }
    .end annotation

    .prologue
    .line 503
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method public getSplunker()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;
    .locals 1

    .prologue
    .line 576
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    return-object v0
.end method

.method public getStateName()Ljava/lang/String;
    .locals 1

    .prologue
    .line 211
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->getStateName()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method public getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .locals 1

    .prologue
    .line 495
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    return-object v0
.end method

.method public getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
    .locals 1

    .prologue
    .line 487
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->uiController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    return-object v0
.end method

.method public getUiThreadExecutor()Ljava/util/concurrent/Executor;
    .locals 1

    .prologue
    .line 552
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    return-object v0
.end method

.method public getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1

    .prologue
    .line 527
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method public getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;
    .locals 1

    .prologue
    .line 544
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    return-object v0
.end method

.method public getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation

    .prologue
    .line 507
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method public getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .locals 1

    .prologue
    .line 411
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    return-object v0
.end method

.method public getVideoPlaybackEventData(Ljava/lang/String;)Lcom/comcast/cim/analytics/VideoPlaybackEventData;
    .locals 9
    .param p1, "ev"    # Ljava/lang/String;

    .prologue
    .line 1039
    const/4 v5, 0x0

    .line 1040
    .local v5, "trackingEntityType":Ljava/lang/String;
    const/4 v7, 0x0

    .line 1041
    .local v7, "mediaId":Ljava/lang/String;
    const/4 v6, 0x0

    .line 1042
    .local v6, "networkName":Ljava/lang/String;
    const/4 v8, 0x0

    .line 1044
    .local v8, "duration":Ljava/lang/String;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v0

    if-eqz v0, :cond_1

    .line 1045
    const-string v5, "liveStream"

    .line 1046
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v7

    .line 1047
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getTitle()Ljava/lang/String;

    move-result-object v6

    .line 1048
    const-string v8, "NA"

    .line 1062
    :cond_0
    :goto_0
    new-instance v0, Lcom/comcast/cim/analytics/VideoPlaybackEventData;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/PlayerApplication;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->appId:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    .line 1063
    invoke-virtual {v2}, Lcom/xfinity/playerlib/PlayerApplication;->getVersionNumber()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 1064
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getHashedOmnitureGuid()Ljava/lang/String;

    move-result-object v3

    move-object v4, p1

    invoke-direct/range {v0 .. v8}, Lcom/comcast/cim/analytics/VideoPlaybackEventData;-><init>(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V

    return-object v0

    .line 1049
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    if-eqz v0, :cond_0

    .line 1050
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isMovie()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 1051
    const-string v5, "movie"

    .line 1056
    :goto_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v7

    .line 1057
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getName()Ljava/lang/String;

    move-result-object v6

    .line 1058
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getDuration()J

    move-result-wide v0

    invoke-static {v0, v1}, Ljava/lang/String;->valueOf(J)Ljava/lang/String;

    move-result-object v8

    goto :goto_0

    .line 1053
    :cond_2
    const-string v5, "tvEpisode"

    goto :goto_1
.end method

.method public getVideoTrackController()Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;
    .locals 1

    .prologue
    .line 564
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoTrackController:Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    return-object v0
.end method

.method public getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;
    .locals 1

    .prologue
    .line 429
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    return-object v0
.end method

.method public getWatchableCodec()Lcom/xfinity/playerlib/model/consumable/WatchableCodec;
    .locals 1

    .prologue
    .line 519
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    return-object v0
.end method

.method public hasPreroll()Z
    .locals 9

    .prologue
    const/4 v8, 0x1

    .line 599
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->prerollChecked:Z

    if-nez v3, :cond_1

    .line 600
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getTimeline()Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;

    move-result-object v1

    .line 601
    .local v1, "playerTimeLine":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    if-eqz v1, :cond_0

    .line 602
    invoke-virtual {v1}, Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;->timelineMarkers()Ljava/util/Iterator;

    move-result-object v2

    .line 603
    .local v2, "timelineIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;>;"
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 604
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;

    .line 605
    .local v0, "marker":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    invoke-virtual {v0}, Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;->getTime()J

    move-result-wide v4

    const-wide/16 v6, 0x0

    cmp-long v3, v4, v6

    if-nez v3, :cond_0

    .line 607
    iput-boolean v8, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->hasPreroll:Z

    .line 611
    .end local v0    # "marker":Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;
    .end local v2    # "timelineIterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/playerplatform/primetime/android/primetime/TimelineMarker;>;"
    :cond_0
    iput-boolean v8, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->prerollChecked:Z

    .line 614
    .end local v1    # "playerTimeLine":Lcom/comcast/playerplatform/primetime/android/primetime/PlayerTimeline;
    :cond_1
    iget-boolean v3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->hasPreroll:Z

    return v3
.end method

.method public incrementHttpPort()V
    .locals 2

    .prologue
    .line 1120
    iget v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpPort:I

    const/16 v1, 0x3a98

    if-ge v0, v1, :cond_0

    .line 1121
    iget v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpPort:I

    add-int/lit8 v0, v0, 0x1

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpPort:I

    .line 1125
    :goto_0
    return-void

    .line 1123
    :cond_0
    const/16 v0, 0x2122

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpPort:I

    goto :goto_0
.end method

.method public initPlayerPlatformMediaPlayer()V
    .locals 3

    .prologue
    .line 194
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;-><init>(Landroid/app/Activity;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    .line 195
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoEventListener:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->addEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 196
    const/4 v0, 0x0

    iput v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ticks:I

    .line 197
    return-void
.end method

.method public isAdPlaying()Z
    .locals 1

    .prologue
    .line 1075
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->isAdPlaying()Z

    move-result v0

    return v0
.end method

.method public isCC()Z
    .locals 1

    .prologue
    .line 419
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 420
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isCC()Z

    move-result v0

    .line 425
    :goto_0
    return v0

    .line 421
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    if-eqz v0, :cond_1

    .line 422
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->hasCC()Z

    move-result v0

    goto :goto_0

    .line 425
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public isIgnoreMobileDataWarningSettingThisSession()Z
    .locals 1

    .prologue
    .line 445
    iget-boolean v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ignoreMobileDataWarningSettingThisSession:Z

    return v0
.end method

.method public isLiveStream()Z
    .locals 1

    .prologue
    .line 415
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v0

    if-eqz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAMSContinueException(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 333
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onAMSContinueException(Ljava/lang/Exception;)V

    .line 334
    return-void
.end method

.method public onActivityPaused()V
    .locals 1

    .prologue
    .line 364
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onActivityPaused()V

    .line 365
    return-void
.end method

.method public onActivityResumed()V
    .locals 1

    .prologue
    .line 368
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    if-eqz v0, :cond_0

    .line 369
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onActivityResumed()V

    .line 370
    :cond_0
    return-void
.end method

.method public onAmsAuthenticationException(Ljava/lang/Exception;)V
    .locals 1
    .param p1, "e"    # Ljava/lang/Exception;

    .prologue
    .line 321
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onAmsAuthenticationException(Ljava/lang/Exception;)V

    .line 322
    return-void
.end method

.method public onAmsAuthenticationSuccess()V
    .locals 1

    .prologue
    .line 313
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onAmsAuthenticationSuccess()V

    .line 314
    return-void
.end method

.method public onAmsPinRequired()V
    .locals 1

    .prologue
    .line 317
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onAmsPinRequired()V

    .line 318
    return-void
.end method

.method public onBabyGuideButton()V
    .locals 1

    .prologue
    .line 228
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onBabyGuideButton()V

    .line 229
    return-void
.end method

.method public onBackButton()V
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onBackButton()V

    .line 269
    return-void
.end method

.method public onCCButton()V
    .locals 1

    .prologue
    .line 220
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onCCButton()V

    .line 221
    return-void
.end method

.method public onConfigurationLoaded()V
    .locals 1

    .prologue
    .line 297
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onConfigurationLoaded()V

    .line 298
    return-void
.end method

.method public onConnectivityChanged()V
    .locals 1

    .prologue
    .line 348
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onConnectivityChanged()V

    .line 349
    return-void
.end method

.method public onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 1
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 264
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 265
    return-void
.end method

.method public onFavoritesButton()V
    .locals 1

    .prologue
    .line 236
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onFavoritesButton()V

    .line 237
    return-void
.end method

.method public onFragmentDestroyed()V
    .locals 1

    .prologue
    .line 373
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onFragmentDestroyed()V

    .line 374
    return-void
.end method

.method public onHeadsetButtonEvent(I)V
    .locals 1
    .param p1, "keyEventCode"    # I

    .prologue
    .line 356
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onHeadsetButtonEvent(I)V

    .line 357
    return-void
.end method

.method public onHeadsetNoiseDetected()V
    .locals 1

    .prologue
    .line 360
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onHeadsetNoiseDetected()V

    .line 361
    return-void
.end method

.method public onHistoryButton()V
    .locals 1

    .prologue
    .line 232
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onHistoryButton()V

    .line 233
    return-void
.end method

.method public onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 1
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 260
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 261
    return-void
.end method

.method public onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 1
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 309
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 310
    return-void
.end method

.method public onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V
    .locals 1
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 252
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onLiveStreamPlaySelected(Ljava/lang/String;)V

    .line 253
    return-void
.end method

.method public onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 1
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 248
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 249
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 1
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 244
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 245
    return-void
.end method

.method public onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 240
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 241
    return-void
.end method

.method public onPauseButton()V
    .locals 1

    .prologue
    .line 276
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onPauseButton()V

    .line 277
    return-void
.end method

.method public onPinCanceled()V
    .locals 1

    .prologue
    .line 329
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onPinCanceled()V

    .line 330
    return-void
.end method

.method public onPlayButton()V
    .locals 1

    .prologue
    .line 272
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onPlayButton()V

    .line 273
    return-void
.end method

.method public onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V
    .locals 1
    .param p1, "surfaceHolder"    # Landroid/view/SurfaceHolder;

    .prologue
    .line 767
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onPlayerSurfaceCreated(Landroid/view/SurfaceHolder;)V

    .line 768
    return-void
.end method

.method public onSAPButton()V
    .locals 1

    .prologue
    .line 224
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onSAPButton()V

    .line 225
    return-void
.end method

.method public onScreenTouch()V
    .locals 1

    .prologue
    .line 216
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onScreenTouch()V

    .line 217
    return-void
.end method

.method public onSeekRequest(J)V
    .locals 1
    .param p1, "position"    # J

    .prologue
    .line 280
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onSeekRequest(J)V

    .line 281
    return-void
.end method

.method public onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 1
    .param p1, "seriesWatchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 256
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 257
    return-void
.end method

.method public onUserMovedSeekBar(I)V
    .locals 1
    .param p1, "progress"    # I

    .prologue
    .line 292
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onUserMovedSeekBar(I)V

    .line 293
    return-void
.end method

.method public onUserSeekEnded(Z)V
    .locals 1
    .param p1, "willSeek"    # Z

    .prologue
    .line 288
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onUserSeekEnded(Z)V

    .line 289
    return-void
.end method

.method public onUserSeekStarted()V
    .locals 1

    .prologue
    .line 284
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onUserSeekStarted()V

    .line 285
    return-void
.end method

.method public onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V
    .locals 1
    .param p1, "pinInput"    # Ljava/lang/String;
    .param p2, "validationListener"    # Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;

    .prologue
    .line 325
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onValidatePin(Ljava/lang/String;Lcom/comcast/cim/android/view/common/PinKeypadFragment$PinValidationCompletedListener;)V

    .line 326
    return-void
.end method

.method public onVideoFetchFailed()V
    .locals 1

    .prologue
    .line 301
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onVideoFetchFailed()V

    .line 302
    return-void
.end method

.method public onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 305
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 306
    return-void
.end method

.method public onVolumeChanged()V
    .locals 1

    .prologue
    .line 377
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->onVolumeChanged()V

    .line 378
    return-void
.end method

.method public performAmsAuthorization(Ljava/lang/String;)V
    .locals 2
    .param p1, "pin"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/lang/Exception;
        }
    .end annotation

    .prologue
    .line 535
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    if-eqz v0, :cond_1

    .line 536
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v0, v1, p1}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->performVideoAuthorization(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Ljava/lang/String;)V

    .line 540
    :cond_0
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->amsErrorCount:Ljava/util/concurrent/atomic/AtomicInteger;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Ljava/util/concurrent/atomic/AtomicInteger;->set(I)V

    .line 541
    return-void

    .line 537
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    if-eqz v0, :cond_0

    .line 538
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {v0, v1, p1}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->performLiveStreamAuthorization(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V

    goto :goto_0
.end method

.method public reset()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 1083
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->reset()V

    .line 1086
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->cancelAmsContinueCalls()V

    .line 1090
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    if-eqz v0, :cond_0

    .line 1091
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->destroy()V

    .line 1092
    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->mediaPlayer:Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    .line 1097
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    if-eqz v0, :cond_1

    .line 1098
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->stop()V

    .line 1099
    iput-object v2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    .line 1103
    :cond_1
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->hasPreroll:Z

    .line 1104
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->prerollChecked:Z

    .line 1105
    iput-boolean v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playbackStarted:Z

    .line 1106
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 1107
    return-void
.end method

.method public resetLiveStream()V
    .locals 1

    .prologue
    .line 403
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 404
    return-void
.end method

.method public resetVideoAndWatchable()V
    .locals 1

    .prologue
    const/4 v0, 0x0

    .line 390
    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 391
    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 392
    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 393
    return-void
.end method

.method public scheduleAmsContinueCalls()V
    .locals 7

    .prologue
    const-wide/16 v2, 0x78

    .line 628
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/authorization/VideoAuthManager;->shouldMakeContinueCall()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 629
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;

    const-string v1, "####Schedule AMS continue call now..."

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 631
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    new-instance v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$1;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;)V

    sget-object v6, Ljava/util/concurrent/TimeUnit;->SECONDS:Ljava/util/concurrent/TimeUnit;

    move-wide v4, v2

    invoke-virtual/range {v0 .. v6}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->scheduleAtFixedRate(Ljava/lang/Runnable;JJLjava/util/concurrent/TimeUnit;)Ljava/util/concurrent/ScheduledFuture;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueFuture:Ljava/util/concurrent/ScheduledFuture;

    .line 696
    :cond_0
    return-void
.end method

.method public setDownloadedFile(Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;)V
    .locals 0
    .param p1, "downloadedFile"    # Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .prologue
    .line 441
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 442
    return-void
.end method

.method public setDrmKey(Ljava/lang/String;)V
    .locals 0
    .param p1, "drmKey"    # Ljava/lang/String;

    .prologue
    .line 466
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->drmKey:Ljava/lang/String;

    .line 467
    return-void
.end method

.method public setIgnoreMobileDataWarningSettingThisSession(Z)V
    .locals 0
    .param p1, "ignoreMobileDataWarningSettingThisSession"    # Z

    .prologue
    .line 450
    iput-boolean p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->ignoreMobileDataWarningSettingThisSession:Z

    .line 451
    return-void
.end method

.method public setLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 1
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 396
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->liveStream:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 397
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoTrackController:Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->setTrackingItems(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 399
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetVideoAndWatchable()V

    .line 400
    return-void
.end method

.method public setLocalHostServer(Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;)V
    .locals 0
    .param p1, "localHostServer"    # Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    .prologue
    .line 474
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    .line 475
    return-void
.end method

.method public setManifestUrl(Ljava/lang/String;)V
    .locals 0
    .param p1, "manifestUrl"    # Ljava/lang/String;

    .prologue
    .line 458
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->manifestUrl:Ljava/lang/String;

    .line 459
    return-void
.end method

.method setState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 4
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 201
    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Changing states from {} to {}"

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->getStateName()Ljava/lang/String;

    move-result-object v0

    :goto_0
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->getStateName()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v1, v2, v0, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;)V

    .line 202
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .line 203
    invoke-interface {p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->run()V

    .line 204
    return-void

    .line 201
    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public setVideoAndWatchable(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "videoFacade"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 382
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoFacade:Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 383
    iput-object p2, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->watchable:Lcom/xfinity/playerlib/model/consumable/Watchable;

    .line 384
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoTrackController:Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/videoplay/VideoTrackController;->setTrackingItems(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 386
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetLiveStream()V

    .line 387
    return-void
.end method

.method public shouldUseDownloadFile()Z
    .locals 2

    .prologue
    .line 589
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    if-eqz v0, :cond_0

    .line 590
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->isDownloadComplete()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->downloadedFile:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v0

    sget-object v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->AAW_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-eq v0, v1, :cond_0

    .line 591
    const/4 v0, 0x1

    .line 595
    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public shutdown()V
    .locals 2

    .prologue
    .line 704
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeVideoView()V

    .line 705
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->removeMainControlTimeout()V

    .line 706
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 707
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->videoEventListener:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController$VideoPlayerEventListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->removeEventListener(Lcom/comcast/playerplatform/primetime/android/events/AbstractPlayerPlatformVideoEventListener;)V

    .line 708
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->destroy()V

    .line 710
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->authContinueExecutor:Ljava/util/concurrent/ScheduledThreadPoolExecutor;

    invoke-virtual {v0}, Ljava/util/concurrent/ScheduledThreadPoolExecutor;->shutdownNow()Ljava/util/List;

    .line 711
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    if-eqz v0, :cond_1

    .line 712
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;->stop()V

    .line 713
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->localHostServer:Lcom/xfinity/playerlib/model/videoplay/NanoHTTPD;

    .line 715
    :cond_1
    return-void
.end method

.method public shutdownAndFinishActivity()V
    .locals 1

    .prologue
    .line 699
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->shutdown()V

    .line 700
    invoke-virtual {p0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->finish()V

    .line 701
    return-void
.end method

.method public transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V
    .locals 1
    .param p1, "state"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    .prologue
    .line 207
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->currentState:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;

    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;->transitionToState(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoState;)V

    .line 208
    return-void
.end method

.method public unpauseDownloads()V
    .locals 3

    .prologue
    .line 757
    :try_start_0
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->isTemporarilyPaused()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 758
    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->resumeDownloading()V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 764
    :cond_0
    :goto_0
    return-void

    .line 760
    :catch_0
    move-exception v0

    .line 762
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->LOG:Lorg/slf4j/Logger;

    const-string v2, "Failed to resume downloads"

    invoke-interface {v1, v2, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
