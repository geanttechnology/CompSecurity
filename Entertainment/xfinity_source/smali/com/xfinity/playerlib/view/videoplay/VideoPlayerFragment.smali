.class public Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "VideoPlayerFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;
.implements Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$VideoPlayOrResumePressedListener;
.implements Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;
.implements Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;
.implements Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;
.implements Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PauseRunnable;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayRunnable;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;,
        Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private adAnnouced:Z

.field private adView:Landroid/webkit/WebView;

.field private adZeroSeconds:Z

.field private adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

.field private adsCountDown:Landroid/widget/TextView;

.field private afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private final androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field private audioOnlyView:Landroid/widget/TextView;

.field private babyGuideMenu:Landroid/widget/LinearLayout;

.field private bitrateTextView:Landroid/widget/TextView;

.field protected brightnessIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

.field protected brightnessSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

.field protected brightnessSliderLayout:Landroid/widget/LinearLayout;

.field private bufferingProgress:Landroid/widget/LinearLayout;

.field private bufferingText:Landroid/widget/TextView;

.field private ccButton:Landroid/widget/ImageView;

.field private ccContainer:Landroid/widget/RelativeLayout;

.field private cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

.field private clickableAdButton:Landroid/widget/Button;

.field private connectionTypeChangeReceiver:Landroid/content/BroadcastReceiver;

.field protected currentTime:Landroid/widget/TextView;

.field private final errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

.field private final errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

.field private favoriteMenu:Landroid/widget/LinearLayout;

.field private firstTimePlayed:Z

.field private final foxLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

.field protected handler:Landroid/os/Handler;

.field private headsetNoiseReceiver:Landroid/content/BroadcastReceiver;

.field private hideAdViewOnResume:Z

.field private historyMenu:Landroid/widget/LinearLayout;

.field private final httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

.field private infoPanel:Landroid/widget/LinearLayout;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private isAdsActionBarAdjustedForStatusBar:Z

.field private isMuted:Z

.field private isPhone:Z

.field private layout:Landroid/view/ViewGroup;

.field private final liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

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

.field private mAudioManager:Landroid/media/AudioManager;

.field private mLastSystemVisibility:I

.field private mRemoteControlResponder:Landroid/content/ComponentName;

.field private manualControlToggleOn:Z

.field private menuTabs:Landroid/widget/LinearLayout;

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

.field protected muteButton:Lcom/xfinity/playerlib/view/CustomStateImageView;

.field private mutedVolume:I

.field private networkLogo:Landroid/widget/ImageView;

.field private final networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field private networkName:Landroid/widget/TextView;

.field private onNow:Landroid/widget/TextView;

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

.field protected pauseButton:Landroid/widget/ImageView;

.field protected playButton:Landroid/widget/ImageView;

.field private final playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

.field private final playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

.field private playerControls:Landroid/view/ViewGroup;

.field private final playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private playerFrame:Landroid/widget/FrameLayout;

.field private playerLayout:Landroid/widget/RelativeLayout;

.field private playerOnClickListener:Landroid/view/View$OnClickListener;

.field private playerOnSystemUiVisibilityChangeListener:Landroid/view/View$OnSystemUiVisibilityChangeListener;

.field private playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

.field protected programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

.field private progressBarLayout:Landroid/widget/LinearLayout;

.field private remoteControlKeyReceiver:Landroid/content/BroadcastReceiver;

.field private sapButton:Landroid/widget/ImageView;

.field private selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

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

.field private speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

.field private final splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

.field startupDialog:Landroid/view/ViewGroup;

.field startupMatureContentRating:Landroid/widget/TextView;

.field startupMatureContentWarning:Landroid/widget/TextView;

.field startupMessaging:Landroid/widget/TextView;

.field private statsView:Landroid/view/View;

.field private final taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private thumbTime:Landroid/widget/TextView;

.field private title:Landroid/widget/TextView;

.field private trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private final uiThreadExecutor:Ljava/util/concurrent/Executor;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private final videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

.field private final videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

.field protected videoDuration:Landroid/widget/TextView;

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

.field private final videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;

.field private videoPlayingBeforeSpeechSwipe:Z

.field private videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

.field protected volumeIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

.field protected volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

.field protected volumeSliderLayout:Landroid/widget/LinearLayout;

.field private final watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 131
    const-class v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    const/4 v2, 0x0

    const/4 v1, 0x0

    .line 123
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    .line 138
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoPlayUtil()Lcom/xfinity/playerlib/VideoPlayUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;

    .line 149
    const/4 v0, -0x1

    iput v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mLastSystemVisibility:I

    .line 208
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 209
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 210
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 211
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 212
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamMetaDataResourceFactory()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 213
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 214
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 215
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getWatchableCodec()Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    .line 216
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 217
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 218
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 219
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoAuthManager()Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    .line 220
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUiThreadExecutor()Lcom/comcast/cim/android/concurrent/UIThreadExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    .line 221
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getParentalControlsCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 222
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    .line 223
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 224
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getApplication()Lcom/xfinity/playerlib/PlayerApplication;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    .line 225
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getHttpClient()Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    .line 226
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getCimAssetFactory()Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    .line 227
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 228
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayerConfigUtil()Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    .line 229
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSplunkLogger()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .line 230
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getFoxAnalyticsLogger()Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->foxLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    .line 231
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 232
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getPlayerErrorFormatter()Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    .line 233
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    .line 234
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 242
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z

    .line 243
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adZeroSeconds:Z

    .line 246
    new-instance v0, Landroid/os/Handler;

    invoke-direct {v0}, Landroid/os/Handler;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->handler:Landroid/os/Handler;

    .line 266
    iput-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .line 267
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z

    .line 268
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->firstTimePlayed:Z

    .line 269
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    .line 272
    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayingBeforeSpeechSwipe:Z

    .line 273
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;

    invoke-direct {v0, p0, v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$AdobePlayerFragmentSpeechListener;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    .line 276
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    .line 288
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$2;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->connectionTypeChangeReceiver:Landroid/content/BroadcastReceiver;

    .line 301
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$3;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$3;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->remoteControlKeyReceiver:Landroid/content/BroadcastReceiver;

    .line 317
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$4;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$4;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->headsetNoiseReceiver:Landroid/content/BroadcastReceiver;

    .line 328
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$5;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$5;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerOnClickListener:Landroid/view/View$OnClickListener;

    .line 336
    new-instance v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$6;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$6;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerOnSystemUiVisibilityChangeListener:Landroid/view/View$OnSystemUiVisibilityChangeListener;

    .line 2484
    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/content/ComponentName;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mRemoteControlResponder:Landroid/content/ComponentName;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AccessibilityUtil;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # I

    .prologue
    .line 123
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->changeAccessibilityControlToggleContentDescription(I)V

    return-void
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/View;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->statsView:Landroid/view/View;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bitrateTextView:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingProgress:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z

    return v0
.end method

.method static synthetic access$1802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 123
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adAnnouced:Z

    return p1
.end method

.method static synthetic access$1900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adZeroSeconds:Z

    return v0
.end method

.method static synthetic access$1902(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 123
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adZeroSeconds:Z

    return p1
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/media/AudioManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    return-object v0
.end method

.method static synthetic access$2000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/Button;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;

    return-object v0
.end method

.method static synthetic access$2202(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 123
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->hideAdViewOnResume:Z

    return p1
.end method

.method static synthetic access$2300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/webkit/WebView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;

    return-object v0
.end method

.method static synthetic access$2400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isAdsActionBarAdjustedForStatusBar:Z

    return v0
.end method

.method static synthetic access$2402(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 123
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isAdsActionBarAdjustedForStatusBar:Z

    return p1
.end method

.method static synthetic access$2500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z

    return v0
.end method

.method static synthetic access$2502(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 123
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z

    return p1
.end method

.method static synthetic access$2600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$2700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method static synthetic access$2800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isLiveStream()Z

    move-result v0

    return v0
.end method

.method static synthetic access$2900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/FrameLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerFrame:Landroid/widget/FrameLayout;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/media/AudioManager$OnAudioFocusChangeListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    return-object v0
.end method

.method static synthetic access$3000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->thumbTime:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$3100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/RelativeLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerLayout:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$3200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->menuTabs:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$3300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onNow:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$3400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->title:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$3500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$3600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkName:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$3700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogo:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$3800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    return-object v0
.end method

.method static synthetic access$3900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/VideoPlayUtil;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayUtil:Lcom/xfinity/playerlib/VideoPlayUtil;

    return-object v0
.end method

.method static synthetic access$400()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 123
    sget-object v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$4000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/View$OnClickListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerOnClickListener:Landroid/view/View$OnClickListener;

    return-object v0
.end method

.method static synthetic access$4200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/comcast/cim/model/system/PlayerAndroidDevice;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    return-object v0
.end method

.method static synthetic access$4300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$4400(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/RelativeLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccContainer:Landroid/widget/RelativeLayout;

    return-object v0
.end method

.method static synthetic access$4500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$4600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->firstTimePlayed:Z

    return v0
.end method

.method static synthetic access$4602(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 123
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->firstTimePlayed:Z

    return p1
.end method

.method static synthetic access$4700(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$4800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$4900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    return-object v0
.end method

.method static synthetic access$5000(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Landroid/widget/LinearLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->infoPanel:Landroid/widget/LinearLayout;

    return-object v0
.end method

.method static synthetic access$5100(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    return v0
.end method

.method static synthetic access$5200(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)F
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # I

    .prologue
    .line 123
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getAdjustedBrightness(I)F

    move-result v0

    return v0
.end method

.method static synthetic access$5300(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z

    return v0
.end method

.method static synthetic access$5402(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # I

    .prologue
    .line 123
    iput p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    return p1
.end method

.method static synthetic access$5500(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayingBeforeSpeechSwipe:Z

    return v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mLastSystemVisibility:I

    return v0
.end method

.method static synthetic access$602(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # I

    .prologue
    .line 123
    iput p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mLastSystemVisibility:I

    return p1
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    return-object v0
.end method

.method static synthetic access$802(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    .prologue
    .line 123
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->selectedBabyGuideMenu:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BabyGuideType;

    return-object p1
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;

    .prologue
    .line 123
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    return-object v0
.end method

.method private changeAccessibilityControlToggleContentDescription(I)V
    .locals 2
    .param p1, "resId"    # I

    .prologue
    .line 585
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 586
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getView()Landroid/view/View;

    move-result-object v0

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/view/View;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 588
    :cond_0
    return-void
.end method

.method private configureActionBar()V
    .locals 3

    .prologue
    .line 482
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 483
    .local v0, "activity":Landroid/app/Activity;
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_tabs:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->menuTabs:Landroid/widget/LinearLayout;

    .line 485
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_guide:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;

    .line 486
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->babyGuideMenu:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$10;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$10;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 498
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_history:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;

    .line 499
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->historyMenu:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$11;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$11;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 511
    sget v1, Lcom/xfinity/playerlib/R$id;->menu_favorite:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;

    .line 512
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->favoriteMenu:Landroid/widget/LinearLayout;

    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$12;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$12;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/LinearLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 523
    sget v1, Lcom/xfinity/playerlib/R$id;->video_title:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->title:Landroid/widget/TextView;

    .line 524
    sget v1, Lcom/xfinity/playerlib/R$id;->on_now:I

    invoke-virtual {v0, v1}, Landroid/app/Activity;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onNow:Landroid/widget/TextView;

    .line 527
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onNow:Landroid/widget/TextView;

    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$13;

    invoke-direct {v2, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$13;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 534
    return-void
.end method

.method private configurePlayerControls()V
    .locals 14

    .prologue
    const-wide/16 v12, 0x190

    const-wide/16 v10, 0x0

    const/4 v8, 0x2

    const/4 v7, 0x0

    .line 539
    new-instance v0, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v0}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    .line 540
    .local v0, "appearingInterpolator":Landroid/animation/TimeInterpolator;
    new-instance v3, Landroid/view/animation/AccelerateDecelerateInterpolator;

    invoke-direct {v3}, Landroid/view/animation/AccelerateDecelerateInterpolator;-><init>()V

    .line 542
    .local v3, "disappearingInterpolator":Landroid/animation/TimeInterpolator;
    const-string v5, "alpha"

    new-array v6, v8, [F

    fill-array-data v6, :array_0

    invoke-static {v7, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v1

    .line 544
    .local v1, "defaultFadeIn":Landroid/animation/ObjectAnimator;
    invoke-virtual {v1, v12, v13}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 545
    invoke-virtual {v1, v10, v11}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    .line 546
    invoke-virtual {v1, v0}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 547
    const-string v5, "alpha"

    new-array v6, v8, [F

    fill-array-data v6, :array_1

    invoke-static {v7, v5, v6}, Landroid/animation/ObjectAnimator;->ofFloat(Ljava/lang/Object;Ljava/lang/String;[F)Landroid/animation/ObjectAnimator;

    move-result-object v2

    .line 549
    .local v2, "defaultFadeOut":Landroid/animation/ObjectAnimator;
    invoke-virtual {v2, v12, v13}, Landroid/animation/ObjectAnimator;->setDuration(J)Landroid/animation/ObjectAnimator;

    .line 550
    invoke-virtual {v2, v10, v11}, Landroid/animation/ObjectAnimator;->setStartDelay(J)V

    .line 551
    invoke-virtual {v2, v3}, Landroid/animation/ObjectAnimator;->setInterpolator(Landroid/animation/TimeInterpolator;)V

    .line 552
    new-instance v4, Landroid/animation/LayoutTransition;

    invoke-direct {v4}, Landroid/animation/LayoutTransition;-><init>()V

    .line 553
    .local v4, "layoutTransition":Landroid/animation/LayoutTransition;
    invoke-virtual {v4, v8, v1}, Landroid/animation/LayoutTransition;->setAnimator(ILandroid/animation/Animator;)V

    .line 554
    const/4 v5, 0x0

    invoke-virtual {v4, v5, v7}, Landroid/animation/LayoutTransition;->setAnimator(ILandroid/animation/Animator;)V

    .line 555
    const/4 v5, 0x1

    invoke-virtual {v4, v5, v7}, Landroid/animation/LayoutTransition;->setAnimator(ILandroid/animation/Animator;)V

    .line 556
    const/4 v5, 0x3

    invoke-virtual {v4, v5, v2}, Landroid/animation/LayoutTransition;->setAnimator(ILandroid/animation/Animator;)V

    .line 558
    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    invoke-virtual {v5, v4}, Landroid/view/ViewGroup;->setLayoutTransition(Landroid/animation/LayoutTransition;)V

    .line 559
    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    new-instance v6, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$14;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$14;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 569
    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    new-instance v6, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;

    invoke-direct {v6, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$15;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 580
    iget-object v5, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->configurePlaybackControls()V

    .line 581
    return-void

    .line 542
    nop

    :array_0
    .array-data 4
        0x0
        0x3f800000    # 1.0f
    .end array-data

    .line 547
    :array_1
    .array-data 4
        0x3f800000    # 1.0f
        0x0
    .end array-data
.end method

.method private configureVolumeAndBrightnessControls()V
    .locals 3

    .prologue
    const/4 v2, 0x1

    .line 2200
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->currentTime:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setLongClickable(Z)V

    .line 2201
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->currentTime:Landroid/widget/TextView;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$16;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$16;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 2215
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    invoke-virtual {v0, v2}, Landroid/widget/TextView;->setLongClickable(Z)V

    .line 2216
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$17;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setOnLongClickListener(Landroid/view/View$OnLongClickListener;)V

    .line 2233
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    const/4 v2, 0x3

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->getStreamMaxVolume(I)I

    move-result v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setMax(I)V

    .line 2234
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->updateVolumeSlider()V

    .line 2236
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$VolumeSliderOnSeekBarChangeListener;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setOnVerticalSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 2237
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->muteButton:Lcom/xfinity/playerlib/view/CustomStateImageView;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$18;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$18;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/CustomStateImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 2244
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    new-instance v1, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$BrightnessSliderOnSeekBarChangeListener;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setOnVerticalSeekBarChangeListener(Landroid/widget/SeekBar$OnSeekBarChangeListener;)V

    .line 2245
    return-void
.end method

.method private getAdjustedBrightness(I)F
    .locals 2
    .param p1, "brightness"    # I

    .prologue
    .line 2360
    const/4 v0, 0x3

    if-ge p1, v0, :cond_0

    .line 2361
    const/4 p1, 0x3

    .line 2364
    :cond_0
    int-to-float v0, p1

    const/high16 v1, 0x437f0000    # 255.0f

    div-float/2addr v0, v1

    return v0
.end method

.method private isLiveStream()Z
    .locals 2

    .prologue
    .line 591
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    if-eqz v1, :cond_0

    .line 592
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v1

    .line 595
    :goto_0
    return v1

    .line 594
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    invoke-virtual {v1}, Landroid/app/Activity;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v0

    .line 595
    .local v0, "arguments":Landroid/os/Bundle;
    const-string v1, "liveStreamID"

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v1

    goto :goto_0
.end method

.method private preventVolumeViewFromAnnouncingStateChanges()V
    .locals 3

    .prologue
    .line 707
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    const/4 v2, 0x2

    invoke-virtual {v0, v1, v2}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 708
    return-void
.end method


# virtual methods
.method public adjustVolume(I)V
    .locals 5
    .param p1, "direction"    # I

    .prologue
    const/4 v4, 0x0

    const/4 v3, 0x1

    .line 2299
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSliderLayout:Landroid/widget/LinearLayout;

    invoke-virtual {v2, v4}, Landroid/widget/LinearLayout;->setVisibility(I)V

    .line 2300
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    if-eqz v2, :cond_1

    .line 2301
    if-ne p1, v3, :cond_0

    .line 2302
    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->setMuteState(Z)V

    .line 2315
    :goto_0
    return-void

    .line 2305
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    iget v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    add-int/lit8 v4, v4, -0x1

    iput v4, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    invoke-virtual {v2, v4}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setProgress(I)V

    .line 2313
    :goto_1
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v2

    invoke-virtual {v2, v3}, Landroid/view/View;->setSystemUiVisibility(I)V

    .line 2314
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onVolumeChanged()V

    goto :goto_0

    .line 2308
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    const/4 v4, 0x3

    invoke-virtual {v2, v4}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    .line 2309
    .local v0, "currentVolume":I
    if-ne p1, v3, :cond_2

    move v2, v3

    :goto_2
    add-int v1, v0, v2

    .line 2310
    .local v1, "newVolume":I
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setProgress(I)V

    goto :goto_1

    .line 2309
    .end local v1    # "newVolume":I
    :cond_2
    const/4 v2, -0x1

    goto :goto_2
.end method

.method protected getCurrentVideoIntent()Landroid/content/Intent;
    .locals 6

    .prologue
    .line 2159
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isLiveStream()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2160
    new-instance v1, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity;

    invoke-direct {v1, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2161
    .local v1, "intent":Landroid/content/Intent;
    const/high16 v3, 0x50000000

    invoke-virtual {v1, v3}, Landroid/content/Intent;->setFlags(I)Landroid/content/Intent;

    .line 2173
    :goto_0
    return-object v1

    .line 2163
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v2

    .line 2164
    .local v2, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v3, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/VideoFacade;)V

    const/4 v4, 0x1

    .line 2165
    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->loadAsActivity(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 2166
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->currentlyPlayingVideo(Ljava/lang/Long;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v4

    .line 2167
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProgramId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v3

    sget-object v5, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    sget-object v3, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->Movie:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    :goto_1
    invoke-virtual {v4, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 2168
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 2170
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v1

    .restart local v1    # "intent":Landroid/content/Intent;
    goto :goto_0

    .line 2167
    .end local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    .end local v1    # "intent":Landroid/content/Intent;
    :cond_1
    sget-object v3, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvSeries:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    goto :goto_1
.end method

.method protected getFavoriteIntent()Landroid/content/Intent;
    .locals 5

    .prologue
    .line 2177
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    .line 2178
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-class v3, Lcom/xfinity/playerlib/view/favorite/BabyGuideBookmarksActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2179
    .local v0, "intent":Landroid/content/Intent;
    sget-object v2, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->EXTRA_BABY_GUIDE_MODE:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 2180
    const-string v4, "EXTRA_CURRENT_WATCH_VIDEO_ID"

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    :goto_0
    invoke-virtual {v0, v4, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 2181
    return-object v0

    .line 2180
    :cond_0
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method protected getHistoryIntent()Landroid/content/Intent;
    .locals 5

    .prologue
    .line 2185
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getVideoFacade()Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v1

    .line 2186
    .local v1, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    new-instance v0, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-class v3, Lcom/xfinity/playerlib/view/browsehistory/BabyGuideHistoryActivity;

    invoke-direct {v0, v2, v3}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 2187
    .local v0, "intent":Landroid/content/Intent;
    sget-object v2, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->EXTRA_BABY_GUIDE_MODE:Ljava/lang/String;

    const/4 v3, 0x1

    invoke-virtual {v0, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;Z)Landroid/content/Intent;

    .line 2188
    const-string v4, "EXTRA_CURRENT_WATCH_VIDEO_ID"

    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getVideoId()J

    move-result-wide v2

    :goto_0
    invoke-virtual {v0, v4, v2, v3}, Landroid/content/Intent;->putExtra(Ljava/lang/String;J)Landroid/content/Intent;

    .line 2189
    return-object v0

    .line 2188
    :cond_0
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method public isPlaying()Z
    .locals 2

    .prologue
    .line 2413
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 608
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 609
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 610
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 601
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    .line 603
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 604
    return-void
.end method

.method public onBackPressed()V
    .locals 1

    .prologue
    .line 711
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onBackButton()V

    .line 712
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 31
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 351
    sget v2, Lcom/xfinity/playerlib/R$layout;->video_player_fragment:I

    const/4 v3, 0x0

    move-object/from16 v0, p1

    move-object/from16 v1, p2

    invoke-virtual {v0, v2, v1, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    .line 355
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->stat:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->statsView:Landroid/view/View;

    .line 356
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->stat_bitrate:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bitrateTextView:Landroid/widget/TextView;

    .line 360
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->player_fragment_layout:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerLayout:Landroid/widget/RelativeLayout;

    .line 361
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->player_frame:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/FrameLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerFrame:Landroid/widget/FrameLayout;

    .line 363
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->buffering_progress:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingProgress:Landroid/widget/LinearLayout;

    .line 364
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->buffering_text:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->bufferingText:Landroid/widget/TextView;

    .line 365
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->audio_only:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->audioOnlyView:Landroid/widget/TextView;

    .line 366
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->cc_container:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/RelativeLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccContainer:Landroid/widget/RelativeLayout;

    .line 367
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->clickable_ad_more_info_button:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/Button;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->clickableAdButton:Landroid/widget/Button;

    .line 368
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->clickable_ad_more_info:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/webkit/WebView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adView:Landroid/webkit/WebView;

    .line 371
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->player_controls:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    .line 374
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->progressbar_layout:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;

    .line 375
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->progressBarLayout:Landroid/widget/LinearLayout;

    sget v3, Lcom/xfinity/playerlib/R$id;->progress_bar:I

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    .line 376
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->play_button:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playButton:Landroid/widget/ImageView;

    .line 377
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->pause_button:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->pauseButton:Landroid/widget/ImageView;

    .line 378
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->current_time:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->currentTime:Landroid/widget/TextView;

    .line 379
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->duration:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoDuration:Landroid/widget/TextView;

    .line 380
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->thumb_time:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->thumbTime:Landroid/widget/TextView;

    .line 381
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->volume_slider:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/VerticalSeekBar;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    .line 382
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->volume_slider_layout:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSliderLayout:Landroid/widget/LinearLayout;

    .line 383
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->volume_indicator:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/CustomStateImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

    .line 384
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->mute_button:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/CustomStateImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->muteButton:Lcom/xfinity/playerlib/view/CustomStateImageView;

    .line 385
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->brightness_slider:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/VerticalSeekBar;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    .line 386
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->brightness_slider_layout:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessSliderLayout:Landroid/widget/LinearLayout;

    .line 387
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->brightness_indicator:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/view/CustomStateImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

    .line 388
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->network_logo:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkLogo:Landroid/widget/ImageView;

    .line 389
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->network_name:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->networkName:Landroid/widget/TextView;

    .line 393
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->cc:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;

    .line 394
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$7;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$7;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 400
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->ccButton:Landroid/widget/ImageView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 402
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->sap:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;

    .line 403
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$8;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$8;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 409
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->sapButton:Landroid/widget/ImageView;

    const/4 v3, 0x0

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setEnabled(Z)V

    .line 411
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$bool;->player_behavior_as_phone:I

    invoke-virtual {v2, v3}, Landroid/content/res/Resources;->getBoolean(I)Z

    move-result v2

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z

    .line 412
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z

    if-nez v2, :cond_0

    .line 415
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerControls:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->info_panel:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/LinearLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->infoPanel:Landroid/widget/LinearLayout;

    .line 416
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->infoPanel:Landroid/widget/LinearLayout;

    new-instance v3, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$9;

    move-object/from16 v0, p0

    invoke-direct {v3, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$9;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    invoke-virtual {v2, v3}, Landroid/widget/LinearLayout;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 425
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerLayout:Landroid/widget/RelativeLayout;

    sget v3, Lcom/xfinity/playerlib/R$id;->ads_top_bar:I

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsActionBar:Lcom/comcast/cim/cmasl/android/util/view/widget/ResponsiveRelativeLayout;

    .line 426
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerLayout:Landroid/widget/RelativeLayout;

    sget v3, Lcom/xfinity/playerlib/R$id;->ads_count_down:I

    invoke-virtual {v2, v3}, Landroid/widget/RelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adsCountDown:Landroid/widget/TextView;

    .line 427
    const/4 v2, 0x0

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isAdsActionBarAdjustedForStatusBar:Z

    .line 430
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->startup_dialog:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupDialog:Landroid/view/ViewGroup;

    .line 431
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupDialog:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->message:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMessaging:Landroid/widget/TextView;

    .line 432
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupDialog:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->mature_content_rating:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMatureContentRating:Landroid/widget/TextView;

    .line 433
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupDialog:Landroid/view/ViewGroup;

    sget v3, Lcom/xfinity/playerlib/R$id;->mature_content_warning:I

    invoke-virtual {v2, v3}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->startupMatureContentWarning:Landroid/widget/TextView;

    .line 435
    move-object/from16 v0, p0

    iget-boolean v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z

    if-nez v2, :cond_3

    .line 436
    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$TabletPlayerUIController;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    .line 441
    :goto_0
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->configureActionBar()V

    .line 442
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->configurePlayerControls()V

    .line 444
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideActionBar()V

    .line 446
    new-instance v2, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->liveStreamMetaDataResourceFactory:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-object/from16 v0, p0

    iget-object v11, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->watchableCodec:Lcom/xfinity/playerlib/model/consumable/WatchableCodec;

    move-object/from16 v0, p0

    iget-object v13, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->androidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoAuthManager:Lcom/xfinity/playerlib/authorization/VideoAuthManager;

    move-object/from16 v16, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->uiThreadExecutor:Ljava/util/concurrent/Executor;

    move-object/from16 v17, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->parentalControlsCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-object/from16 v18, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    move-object/from16 v19, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-object/from16 v20, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerApplication:Lcom/xfinity/playerlib/PlayerApplication;

    move-object/from16 v21, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->httpClient:Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;

    move-object/from16 v22, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->cimAssetFactory:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;

    move-object/from16 v23, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerConfigUtil:Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;

    move-object/from16 v24, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->splunker:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-object/from16 v25, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->foxLogger:Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;

    move-object/from16 v26, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-object/from16 v27, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->errorFormatter:Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;

    move-object/from16 v28, v0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->errorDialogFactory:Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-object/from16 v29, v0

    invoke-direct/range {v2 .. v29}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;-><init>(Landroid/app/Activity;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/consumable/WatchableCodec;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/xfinity/playerlib/model/user/PlayNowUserManager;Lcom/comcast/cim/model/system/PlayerAndroidDevice;Lcom/xfinity/playerlib/authorization/VideoAuthManager;Ljava/util/concurrent/Executor;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;Lcom/xfinity/playerlib/PlayerApplication;Lcom/comcast/cim/httpcomponentsandroid/client/HttpClient;Lcom/xfinity/playerlib/model/videoplay/adobeplayer/CimAssetFactory;Lcom/xfinity/playerlib/model/videoplay/PlayerConfigUtil;Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;Lcom/comcast/cim/cmasl/analytics/AnalyticsLogger;Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;Lcom/comcast/cim/android/view/common/errorformatter/ErrorFormatter;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    .line 452
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const-string v3, "audio"

    invoke-virtual {v2, v3}, Landroid/app/Activity;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Landroid/media/AudioManager;

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    .line 454
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->configureVolumeAndBrightnessControls()V

    .line 456
    new-instance v2, Landroid/content/ComponentName;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getPackageName()Ljava/lang/String;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/view/videoplay/RemoteControlReceiver;

    invoke-virtual {v4}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v4

    invoke-direct {v2, v3, v4}, Landroid/content/ComponentName;-><init>(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mRemoteControlResponder:Landroid/content/ComponentName;

    .line 457
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/app/Activity;->setVolumeControlStream(I)V

    .line 459
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->turnLightsOut()V

    .line 462
    sget v2, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v3, 0x10

    if-lt v2, v3, :cond_1

    .line 463
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerFrame:Landroid/widget/FrameLayout;

    const/16 v3, 0x700

    invoke-virtual {v2, v3}, Landroid/widget/FrameLayout;->setSystemUiVisibility(I)V

    .line 465
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v2}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v2

    invoke-virtual {v2}, Landroid/view/Window;->getDecorView()Landroid/view/View;

    move-result-object v30

    .line 466
    .local v30, "rootView":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerOnSystemUiVisibilityChangeListener:Landroid/view/View$OnSystemUiVisibilityChangeListener;

    move-object/from16 v0, v30

    invoke-virtual {v0, v2}, Landroid/view/View;->setOnSystemUiVisibilityChangeListener(Landroid/view/View$OnSystemUiVisibilityChangeListener;)V

    .line 469
    .end local v30    # "rootView":Landroid/view/View;
    :cond_1
    invoke-direct/range {p0 .. p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->preventVolumeViewFromAnnouncingStateChanges()V

    .line 471
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    sget v4, Lcom/xfinity/playerlib/R$id;->touchy_parent:I

    invoke-interface {v2, v3, v4}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->setupPassiveGestureDetector(Landroid/view/View;I)V

    .line 473
    if-eqz p3, :cond_2

    .line 474
    const-string v2, "isMuted"

    const/4 v3, 0x0

    move-object/from16 v0, p3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    .line 475
    const-string v2, "STATE_IS_CONTROLS_ON"

    const/4 v3, 0x1

    move-object/from16 v0, p3

    invoke-virtual {v0, v2, v3}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v2

    move-object/from16 v0, p0

    iput-boolean v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z

    .line 478
    :cond_2
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->layout:Landroid/view/ViewGroup;

    return-object v2

    .line 438
    :cond_3
    new-instance v2, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;

    const/4 v3, 0x0

    move-object/from16 v0, p0

    invoke-direct {v2, v0, v3}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PhonePlayerUIController;-><init>(Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$1;)V

    move-object/from16 v0, p0

    iput-object v2, v0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    goto/16 :goto_0
.end method

.method public onDestroy()V
    .locals 1

    .prologue
    .line 781
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onFragmentDestroyed()V

    .line 782
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onDestroy()V

    .line 783
    return-void
.end method

.method public onDetach()V
    .locals 2

    .prologue
    .line 614
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onDetach()V

    .line 615
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 616
    return-void
.end method

.method public onLiveEventClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V
    .locals 0
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "eventId"    # Ljava/lang/String;

    .prologue
    .line 741
    return-void
.end method

.method public onLiveStreamClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 2
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 728
    if-eqz p1, :cond_0

    .line 729
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 730
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getLiveStream()Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 731
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onLiveStreamPlaySelected(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 736
    :goto_0
    return-void

    .line 733
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideInfoPanel()V

    .line 734
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAllControls()V

    goto :goto_0
.end method

.method public onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V
    .locals 1
    .param p1, "streamId"    # Ljava/lang/String;

    .prologue
    .line 745
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V

    .line 746
    return-void
.end method

.method public onPause()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 681
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onPause()V

    .line 683
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->unpauseDownloads()V

    .line 685
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-array v1, v4, [Landroid/content/BroadcastReceiver;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->connectionTypeChangeReceiver:Landroid/content/BroadcastReceiver;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Lcom/comcast/cim/utils/BroadcastReceiverUtil;->unregisterBroadcastReceiversQuietly(Landroid/content/ContextWrapper;[Landroid/content/BroadcastReceiver;)V

    .line 686
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-array v1, v4, [Landroid/content/BroadcastReceiver;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->headsetNoiseReceiver:Landroid/content/BroadcastReceiver;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Lcom/comcast/cim/utils/BroadcastReceiverUtil;->unregisterBroadcastReceiversQuietly(Landroid/content/ContextWrapper;[Landroid/content/BroadcastReceiver;)V

    .line 687
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    new-array v1, v4, [Landroid/content/BroadcastReceiver;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->remoteControlKeyReceiver:Landroid/content/BroadcastReceiver;

    aput-object v2, v1, v3

    invoke-static {v0, v1}, Lcom/comcast/cim/utils/BroadcastReceiverUtil;->unregisterBroadcastReceiversQuietly(Landroid/content/ContextWrapper;[Landroid/content/BroadcastReceiver;)V

    .line 689
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->abandonAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;)I

    .line 690
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mRemoteControlResponder:Landroid/content/ComponentName;

    invoke-virtual {v0, v1}, Landroid/media/AudioManager;->unregisterMediaButtonEventReceiver(Landroid/content/ComponentName;)V

    .line 692
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onActivityPaused()V

    .line 695
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->preventVolumeViewFromAnnouncingStateChanges()V

    .line 697
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    if-eqz v0, :cond_0

    .line 698
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    iget v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    invoke-virtual {v0, v5, v1, v3}, Landroid/media/AudioManager;->setStreamVolume(III)V

    .line 702
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v5, v3}, Landroid/media/AudioManager;->setStreamMute(IZ)V

    .line 703
    return-void
.end method

.method public onPlayOrResumePressed(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V
    .locals 1
    .param p1, "video"    # Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;

    .prologue
    .line 717
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 718
    return-void
.end method

.method public onResumeInternal()V
    .locals 7

    .prologue
    const/4 v6, 0x3

    const/4 v5, 0x1

    .line 620
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onResumeInternal()V

    .line 622
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->checkShouldPauseDownloads()V

    .line 624
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->dismissDialogs()V

    .line 626
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v1}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 627
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->programProgressBar:Lcom/xfinity/playerlib/view/videoplay/TimelineSeekBar;

    invoke-virtual {v1, v2, v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 630
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->connectionTypeChangeReceiver:Landroid/content/BroadcastReceiver;

    new-instance v3, Landroid/content/IntentFilter;

    const-string v4, "android.net.conn.CONNECTIVITY_CHANGE"

    invoke-direct {v3, v4}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 633
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->headsetNoiseReceiver:Landroid/content/BroadcastReceiver;

    new-instance v3, Landroid/content/IntentFilter;

    const-string v4, "android.media.AUDIO_BECOMING_NOISY"

    invoke-direct {v3, v4}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 634
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->remoteControlKeyReceiver:Landroid/content/BroadcastReceiver;

    new-instance v3, Landroid/content/IntentFilter;

    const-string v4, "com.xfinity.playerlib.videoplay.KEY_PRESSED"

    invoke-direct {v3, v4}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, v2, v3}, Landroid/app/Activity;->registerReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)Landroid/content/Intent;

    .line 636
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->afChangeListener:Landroid/media/AudioManager$OnAudioFocusChangeListener;

    invoke-virtual {v1, v2, v6, v5}, Landroid/media/AudioManager;->requestAudioFocus(Landroid/media/AudioManager$OnAudioFocusChangeListener;II)I

    move-result v0

    .line 642
    .local v0, "result":I
    if-ne v0, v5, :cond_1

    .line 643
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mRemoteControlResponder:Landroid/content/ComponentName;

    invoke-virtual {v1, v2}, Landroid/media/AudioManager;->registerMediaButtonEventReceiver(Landroid/content/ComponentName;)V

    .line 646
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onActivityResumed()V

    .line 648
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v1, v6}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    .line 649
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->setMuteState(Z)V

    .line 652
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    invoke-virtual {v1, v2, v5}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->setImportantForAccessibility(Landroid/view/View;I)V

    .line 655
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->updateBrightnessControl()V

    .line 662
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x13

    if-lt v1, v2, :cond_2

    .line 663
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->styleClosedCaptions()V

    .line 666
    :cond_2
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->hideAdViewOnResume:Z

    if-eqz v1, :cond_3

    .line 667
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->playerUIController:Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideAdView()V

    .line 668
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->hideAdViewOnResume:Z

    .line 670
    :cond_3
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 674
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 675
    const-string v0, "isMuted"

    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 676
    const-string v0, "STATE_IS_CONTROLS_ON"

    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->manualControlToggleOn:Z

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 677
    return-void
.end method

.method public onSpeechSwiped()V
    .locals 1

    .prologue
    .line 2426
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPlaying()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoPlayingBeforeSpeechSwipe:Z

    .line 2427
    return-void
.end method

.method public onVideoPlayOrResumePressed(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V
    .locals 1
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .prologue
    .line 723
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onNewVideoPlayOrResumeSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 724
    return-void
.end method

.method public onVolumeHardwareKeyPressed(I)Z
    .locals 3
    .param p1, "keyCode"    # I

    .prologue
    const/16 v2, 0x18

    const/4 v1, 0x1

    .line 2290
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsVolumeControl()Z

    move-result v0

    if-eqz v0, :cond_2

    const/16 v0, 0x19

    if-eq p1, v0, :cond_0

    if-ne p1, v2, :cond_2

    .line 2291
    :cond_0
    if-ne p1, v2, :cond_1

    move v0, v1

    :goto_0
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->adjustVolume(I)V

    .line 2295
    :goto_1
    return v1

    .line 2291
    :cond_1
    const/4 v0, -0x1

    goto :goto_0

    .line 2295
    :cond_2
    const/4 v1, 0x0

    goto :goto_1
.end method

.method public playLiveStream(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    .locals 1
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .prologue
    .line 771
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->onLiveStreamPlayOrResumePressed(Ljava/lang/String;)V

    .line 772
    return-void
.end method

.method public reset()V
    .locals 1

    .prologue
    .line 2193
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetVideoAndWatchable()V

    .line 2194
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->resetLiveStream()V

    .line 2195
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->reset()V

    .line 2196
    return-void
.end method

.method public seek(I)Z
    .locals 8
    .param p1, "timeInMilliseconds"    # I

    .prologue
    .line 2418
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPosition()J

    move-result-wide v2

    int-to-long v4, p1

    add-long v0, v2, v4

    .line 2419
    .local v0, "currentPosition":J
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v2

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v1, v3}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->setPosition(JZ)V

    .line 2421
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v2}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "position now at "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    const-wide/16 v6, 0x3e8

    div-long v6, v0, v6

    long-to-int v5, v6

    invoke-static {v4, v5}, Lcom/comcast/cim/utils/UIPresentationUtil;->getTimeForPlayer(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 2422
    const/4 v2, 0x1

    return v2
.end method

.method setMuteState(Z)V
    .locals 5
    .param p1, "mute"    # Z

    .prologue
    const/4 v1, 0x1

    const/4 v2, 0x0

    const/4 v4, 0x3

    .line 2269
    if-eqz p1, :cond_2

    .line 2271
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v4}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    .line 2272
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v4, p1}, Landroid/media/AudioManager;->setStreamMute(IZ)V

    .line 2279
    :goto_0
    if-nez p1, :cond_0

    if-nez p1, :cond_1

    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v4}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    if-lez v0, :cond_1

    .line 2280
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

    if-nez p1, :cond_3

    move v0, v1

    :goto_1
    invoke-virtual {v3, v0}, Lcom/xfinity/playerlib/view/CustomStateImageView;->setAppearEnabled(Z)V

    .line 2283
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    if-nez p1, :cond_4

    :goto_2
    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setAppearEnabled(Z)V

    .line 2284
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    iget v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setProgress(I)V

    .line 2285
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->muteButton:Lcom/xfinity/playerlib/view/CustomStateImageView;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/CustomStateImageView;->setAppearEnabled(Z)V

    .line 2286
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isMuted:Z

    .line 2287
    return-void

    .line 2275
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    invoke-virtual {v0, v4, p1}, Landroid/media/AudioManager;->setStreamMute(IZ)V

    .line 2276
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    iget v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mutedVolume:I

    invoke-virtual {v0, v4, v3, v2}, Landroid/media/AudioManager;->setStreamVolume(III)V

    goto :goto_0

    :cond_3
    move v0, v2

    .line 2280
    goto :goto_1

    :cond_4
    move v1, v2

    .line 2283
    goto :goto_2
.end method

.method public shouldShowSeriesListItemsChecked()Z
    .locals 1

    .prologue
    .line 776
    const/4 v0, 0x0

    return v0
.end method

.method public showDetail(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Ljava/lang/Long;)V
    .locals 1
    .param p1, "bookmark"    # Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .param p2, "currentlyPlayingVideoId"    # Ljava/lang/Long;

    .prologue
    .line 761
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onHistoryItemDetailSelected(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    .line 762
    return-void
.end method

.method public showDetail(Lcom/xfinity/playerlib/model/VideoFavorite;)V
    .locals 1
    .param p1, "favorite"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 766
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onFavoriteItemDetailSelected(Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 767
    return-void
.end method

.method public showSeriesDetail()V
    .locals 0

    .prologue
    .line 751
    return-void
.end method

.method public showSeriesWatchableDetail(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 1
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 756
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onSeriesWatchableDetailSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V

    .line 757
    return-void
.end method

.method public speechTriggerPause()Z
    .locals 2

    .prologue
    .line 2402
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onPauseButton()V

    .line 2403
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public speechTriggerPlay()Z
    .locals 2

    .prologue
    .line 2408
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onPlayButton()V

    .line 2409
    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->isAdPlaying()Z

    move-result v0

    if-nez v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->videoStateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getMediaPlayer()Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/PlayerPlatformMediaPlayer;->getPlayerStatus()Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    move-result-object v0

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method updateBrightnessControl()V
    .locals 5

    .prologue
    .line 2248
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getBrightnessValue()I

    move-result v0

    .line 2249
    .local v0, "brightness":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    .line 2250
    .local v1, "contentResolver":Landroid/content/ContentResolver;
    if-gez v0, :cond_0

    .line 2251
    const-string v3, "screen_brightness"

    const/4 v4, 0x1

    invoke-static {v1, v3, v4}, Landroid/provider/Settings$System;->getInt(Landroid/content/ContentResolver;Ljava/lang/String;I)I

    move-result v0

    .line 2252
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v3, v0}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setBrightnessValue(I)V

    .line 2255
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    const/16 v4, 0xff

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setMax(I)V

    .line 2256
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->brightnessSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    invoke-virtual {v3, v0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setProgress(I)V

    .line 2258
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3}, Landroid/view/Window;->getAttributes()Landroid/view/WindowManager$LayoutParams;

    move-result-object v2

    .line 2259
    .local v2, "lp":Landroid/view/WindowManager$LayoutParams;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsBrightnessControl()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 2260
    invoke-direct {p0, v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getAdjustedBrightness(I)F

    move-result v3

    iput v3, v2, Landroid/view/WindowManager$LayoutParams;->screenBrightness:F

    .line 2265
    :goto_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getWindow()Landroid/view/Window;

    move-result-object v3

    invoke-virtual {v3, v2}, Landroid/view/Window;->setAttributes(Landroid/view/WindowManager$LayoutParams;)V

    .line 2266
    return-void

    .line 2262
    :cond_1
    const/high16 v3, -0x40800000    # -1.0f

    iput v3, v2, Landroid/view/WindowManager$LayoutParams;->screenBrightness:F

    goto :goto_0
.end method

.method public updateVolumeSlider()V
    .locals 4

    .prologue
    const/4 v1, 0x0

    .line 2318
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->mAudioManager:Landroid/media/AudioManager;

    const/4 v3, 0x3

    invoke-virtual {v2, v3}, Landroid/media/AudioManager;->getStreamVolume(I)I

    move-result v0

    .line 2320
    .local v0, "volume":I
    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->isPhone:Z

    if-eqz v2, :cond_1

    .line 2321
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

    if-lez v0, :cond_0

    const/4 v1, 0x1

    :cond_0
    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/CustomStateImageView;->setAppearEnabled(Z)V

    .line 2326
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeSlider:Lcom/xfinity/playerlib/view/VerticalSeekBar;

    invoke-virtual {v1, v0}, Lcom/xfinity/playerlib/view/VerticalSeekBar;->setProgress(I)V

    .line 2327
    return-void

    .line 2323
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment;->volumeIndicator:Lcom/xfinity/playerlib/view/CustomStateImageView;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/CustomStateImageView;->setAppearEnabled(Z)V

    goto :goto_0
.end method
