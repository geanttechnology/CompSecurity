.class public Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "SeriesEpisodeListFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/AnimatedFragment;
.implements Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;,
        Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;,
        Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;
    }
.end annotation


# instance fields
.field protected final accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private animationsEnabled:Z

.field private announceListOnLoad:Z

.field protected bodyContainer:Landroid/view/ViewGroup;

.field protected bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

.field private consumableVideoList:Landroid/widget/ListView;

.field private consumableVideoListHelper:Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

.field private dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

.field private downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/downloads/DownloadServiceListener",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;"
        }
    .end annotation
.end field

.field private episodeAdapters:Ljava/util/Set;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Set",
            "<",
            "Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;",
            ">;"
        }
    .end annotation
.end field

.field private favoriteIndicator:Landroid/widget/CheckBox;

.field private fetchCanceledListener:Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

.field private instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private isFullScreen:Z

.field private loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

.field private mergeAdapter:Lcom/commonsware/MergeAdapter;

.field protected notAvailableContainer:Landroid/view/ViewGroup;

.field private playNowEpisodeListTalkHelper:Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

.field protected playerAndroidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

.field protected final programDetailImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

.field private restoredListState:Landroid/os/Parcelable;

.field private seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
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

.field private seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

.field private seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

.field private seriesFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

.field private seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

.field private seriesThumbnail:Landroid/widget/ImageView;

.field private seriesTitle:Landroid/widget/TextView;

.field protected seriesTitleContainer:Landroid/view/ViewGroup;

.field private speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;"
        }
    .end annotation
.end field

.field private tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

.field private uiUtil:Lcom/comcast/cim/utils/UIUtil;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    .line 75
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUIUtil()Lcom/comcast/cim/utils/UIUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    .line 76
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getConsumableVideoListHelper()Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->consumableVideoListHelper:Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

    .line 78
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 79
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->animationsEnabled:Z

    .line 80
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListSpeechListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    .line 81
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAccessibilityUtil()Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    .line 82
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playerAndroidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    .line 83
    invoke-static {}, Lcom/comcast/cim/container/CALContainer;->getInstance()Lcom/comcast/cim/container/CALContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/CALContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 85
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    .line 94
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 95
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getSeriesCombinedTaskExecutorFactory()Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    .line 99
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createProgramDetailArtImageLoader()Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->programDetailImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    .line 112
    new-instance v0, Ljava/util/HashSet;

    invoke-direct {v0}, Ljava/util/HashSet;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->episodeAdapters:Ljava/util/Set;

    .line 122
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    .line 139
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z

    .line 574
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadScreenInfo()V

    return-void
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesTitle:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/CheckBox;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->favoriteIndicator:Landroid/widget/CheckBox;

    return-object v0
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->clearEpisodeAdaptersSelections()V

    return-void
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
    .param p1, "x1"    # Ljava/util/Map;
    .param p2, "x2"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "x3"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p4, "x4"    # Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;
    .param p5, "x5"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 72
    invoke-direct/range {p0 .. p5}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->displayDetail(Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    return-void
.end method

.method static synthetic access$1600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/os/Parcelable;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->restoredListState:Landroid/os/Parcelable;

    return-object v0
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/ListView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->consumableVideoList:Landroid/widget/ListView;

    return-object v0
.end method

.method static synthetic access$1800(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playNowEpisodeListTalkHelper:Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
    .param p1, "x1"    # Landroid/content/Context;

    .prologue
    .line 72
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getPlayNowEpisodeListTalkHelper(Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    return-object v0
.end method

.method static synthetic access$2002(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Z)Z
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
    .param p1, "x1"    # Z

    .prologue
    .line 72
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z

    return p1
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    return-object v0
.end method

.method static synthetic access$602(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    return-object p1
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object v0
.end method

.method static synthetic access$702(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Lcom/xfinity/playerlib/model/dibic/DibicResource;)Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object p1
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->showEntityUnavailableView()V

    return-void
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/VideoFavorite;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 72
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    return-object v0
.end method

.method static synthetic access$902(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)Lcom/xfinity/playerlib/model/VideoFavorite;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/VideoFavorite;

    .prologue
    .line 72
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    return-object p1
.end method

.method private clearEpisodeAdaptersSelections()V
    .locals 3

    .prologue
    .line 504
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->episodeAdapters:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    .line 505
    .local v0, "adapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    invoke-interface {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;->shouldShowSeriesListItemsChecked()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 506
    const/4 v2, -0x1

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->setCheckedPos(I)V

    goto :goto_0

    .line 509
    .end local v0    # "adapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    :cond_1
    return-void
.end method

.method private displayDetail(Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    .locals 14
    .param p2, "watchable"    # Lcom/xfinity/playerlib/model/consumable/Watchable;
    .param p3, "tvSeriesFacade"    # Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    .param p4, "infoClickListenerFactory"    # Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;
    .param p5, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;",
            "Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;",
            "Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ")V"
        }
    .end annotation

    .prologue
    .line 449
    .local p1, "bookmarkMap":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->consumableVideoListHelper:Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->consumableVideoList:Landroid/widget/ListView;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-object v7, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-object v8, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->companyId:Ljava/lang/Long;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-boolean v9, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->wantsSubscriptionOnly:Z

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    .line 452
    invoke-interface {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;->shouldShowSeriesListItemsChecked()Z

    move-result v12

    move-object/from16 v3, p3

    move-object/from16 v4, p2

    move-object/from16 v6, p4

    move-object/from16 v10, p5

    move-object v11, p1

    .line 449
    invoke-virtual/range {v0 .. v12}, Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper;->populateConsumableVideoList(Landroid/app/Activity;Landroid/widget/ListView;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/comcast/cim/utils/UIUtil;Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;Ljava/lang/Long;Ljava/lang/Long;ZLcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/util/Map;Z)Lcom/comcast/cim/cmasl/utils/container/Tuple;

    move-result-object v13

    .line 454
    .local v13, "tuple":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Ljava/util/Set<Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;>;Lcom/commonsware/MergeAdapter;>;"
    iget-object v0, v13, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v0, Ljava/util/Set;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->episodeAdapters:Ljava/util/Set;

    .line 455
    iget-object v0, v13, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/commonsware/MergeAdapter;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->mergeAdapter:Lcom/commonsware/MergeAdapter;

    .line 458
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->seriesDetailSelected:Z

    if-nez v0, :cond_0

    if-nez p2, :cond_1

    .line 459
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->showSeriesAsSelected()V

    .line 462
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 463
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListItems()Z

    .line 464
    return-void
.end method

.method private getPlayNowEpisodeListTalkHelper(Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;
    .locals 2
    .param p1, "context"    # Landroid/content/Context;

    .prologue
    .line 567
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playNowEpisodeListTalkHelper:Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    if-eqz v0, :cond_0

    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z

    if-eqz v0, :cond_1

    .line 568
    :cond_0
    new-instance v0, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    invoke-direct {v0, v1, p1}, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;-><init>(Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Landroid/content/Context;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playNowEpisodeListTalkHelper:Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    .line 571
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playNowEpisodeListTalkHelper:Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    return-object v0
.end method

.method private loadScreenInfo()V
    .locals 4

    .prologue
    .line 271
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->useDownloadAsSource()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 272
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$3;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    .line 290
    .local v1, "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :goto_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    .line 292
    .local v0, "activity":Landroid/app/Activity;
    instance-of v2, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    if-eqz v2, :cond_1

    .line 293
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    .end local v0    # "activity":Landroid/app/Activity;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 298
    :goto_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;

    invoke-direct {v3, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 417
    return-void

    .line 287
    .end local v1    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v2, v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    .restart local v1    # "seriesCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalTvSeriesConsumable;>;"
    goto :goto_0

    .line 295
    .restart local v0    # "activity":Landroid/app/Activity;
    :cond_1
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesCombinedTaskExecutorFactory:Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;

    invoke-virtual {v2, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesCombinedTaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v2

    iput-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    goto :goto_1
.end method

.method private showEntityUnavailableView()V
    .locals 2

    .prologue
    .line 483
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    sget v1, Lcom/xfinity/playerlib/R$string;->error_series_not_available_text:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed(I)V

    .line 484
    return-void
.end method


# virtual methods
.method public announceListItems()Z
    .locals 3

    .prologue
    const/4 v0, 0x0

    .line 554
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z

    if-eqz v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    if-eqz v1, :cond_0

    .line 555
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->cancelAllMessages()V

    .line 556
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-direct {p0, v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getPlayNowEpisodeListTalkHelper(Landroid/content/Context;)Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;

    move-result-object v2

    invoke-virtual {v2}, Lcom/xfinity/playerlib/alt/PlayerEpisodeListTalkListHelper;->speakResults()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speak(Ljava/lang/String;)V

    .line 557
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z

    .line 558
    const/4 v0, 0x1

    .line 561
    :goto_0
    return v0

    .line 560
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v1, v2}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    goto :goto_0
.end method

.method public getMergeAdapter()Lcom/commonsware/MergeAdapter;
    .locals 1

    .prologue
    .line 549
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->mergeAdapter:Lcom/commonsware/MergeAdapter;

    return-object v0
.end method

.method public onActivityCreated(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 235
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onActivityCreated(Landroid/os/Bundle;)V

    .line 236
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->addSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 238
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->accessibilityUtil:Lcom/comcast/cim/android/accessibility/AccessibilityUtil;

    invoke-virtual {v0}, Lcom/comcast/cim/android/accessibility/AccessibilityUtil;->isAccessibilityEnabled()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playerAndroidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 239
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/ActionBar;->hide()V

    .line 241
    :cond_0
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 221
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 222
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    .line 224
    instance-of v0, p1, Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    if-eqz v0, :cond_0

    move-object v0, p1

    .line 225
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->fetchCanceledListener:Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    .line 230
    :goto_0
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 231
    return-void

    .line 227
    .restart local p1    # "activity":Landroid/app/Activity;
    :cond_0
    iput-object p0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->fetchCanceledListener:Lcom/xfinity/playerlib/view/programdetails/FetchCanceledListener;

    goto :goto_0
.end method

.method public onCancel(Landroid/content/DialogInterface;)V
    .locals 0
    .param p1, "dialog"    # Landroid/content/DialogInterface;

    .prologue
    .line 513
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->showEntityUnavailableView()V

    .line 514
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflator"    # Landroid/view/MenuInflater;

    .prologue
    .line 421
    invoke-super {p0, p1, p2}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 422
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 423
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 9
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v4, 0x0

    .line 156
    sget v0, Lcom/xfinity/playerlib/R$layout;->series_episode_list:I

    invoke-virtual {p1, v0, p2, v4}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v7

    check-cast v7, Landroid/view/ViewGroup;

    .line 158
    .local v7, "layout":Landroid/view/ViewGroup;
    sget v0, Lcom/xfinity/playerlib/R$id;->header:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    .line 159
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    sget v1, Lcom/xfinity/playerlib/R$id;->series_title:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/TextView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesTitle:Landroid/widget/TextView;

    .line 160
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    sget v1, Lcom/xfinity/playerlib/R$id;->series_thumbnail:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ImageView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesThumbnail:Landroid/widget/ImageView;

    .line 161
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    sget v1, Lcom/xfinity/playerlib/R$id;->favorite_indicator:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/CheckBox;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->favoriteIndicator:Landroid/widget/CheckBox;

    .line 163
    sget v0, Lcom/xfinity/playerlib/R$id;->episode_list:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/ListView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->consumableVideoList:Landroid/widget/ListView;

    .line 164
    sget v0, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->bodyContainer:Landroid/view/ViewGroup;

    .line 165
    sget v0, Lcom/xfinity/playerlib/R$id;->not_available_container:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->notAvailableContainer:Landroid/view/ViewGroup;

    .line 167
    sget v0, Lcom/xfinity/playerlib/R$id;->series_title_container:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesTitleContainer:Landroid/view/ViewGroup;

    .line 169
    new-instance v6, Landroid/os/Bundle;

    invoke-direct {v6}, Landroid/os/Bundle;-><init>()V

    .line 171
    .local v6, "bundle":Landroid/os/Bundle;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 172
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 175
    :cond_0
    if-eqz p3, :cond_1

    .line 176
    invoke-virtual {v6, p3}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 179
    :cond_1
    const-string v0, "KEY_ANNOUNCE_EPISODES"

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListOnLoad:Z

    .line 181
    invoke-static {v6}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->fromBundle(Landroid/os/Bundle;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    .line 183
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->showSeriesArt:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_3

    .line 187
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->useDownloadAsSource()Z

    move-result v0

    if-eqz v0, :cond_2

    .line 188
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getParentMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v8

    .line 193
    .local v8, "seriesId":Lcom/xfinity/playerlib/model/MerlinId;
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->programDetailImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesThumbnail:Landroid/widget/ImageView;

    invoke-virtual {v0, v8, v1}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadDetailProgramArt(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;)V

    .line 194
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesThumbnail:Landroid/widget/ImageView;

    invoke-virtual {v0, v4}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 196
    const/4 v0, 0x1

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->setHasOptionsMenu(Z)V

    .line 203
    .end local v8    # "seriesId":Lcom/xfinity/playerlib/model/MerlinId;
    :goto_1
    const-string v0, "listState"

    invoke-virtual {v6, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->restoredListState:Landroid/os/Parcelable;

    .line 205
    sget v0, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 206
    .local v2, "bodyContainer":Landroid/view/ViewGroup;
    sget v0, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {v7, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    .line 207
    .local v3, "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    new-instance v5, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$2;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;-><init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    .line 214
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    sget v1, Lcom/xfinity/playerlib/R$id;->touchy_parent:I

    invoke-interface {v0, v7, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->setupPassiveGestureDetector(Landroid/view/View;I)V

    .line 216
    return-object v7

    .line 190
    .end local v2    # "bodyContainer":Landroid/view/ViewGroup;
    .end local v3    # "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    iget-object v8, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->seriesId:Lcom/xfinity/playerlib/model/MerlinId;

    .restart local v8    # "seriesId":Lcom/xfinity/playerlib/model/MerlinId;
    goto :goto_0

    .line 200
    .end local v8    # "seriesId":Lcom/xfinity/playerlib/model/MerlinId;
    :cond_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesThumbnail:Landroid/widget/ImageView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_1
.end method

.method public onDetach()V
    .locals 2

    .prologue
    .line 245
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onDetach()V

    .line 246
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->speechListener:Lcom/comcast/cim/android/accessibility/SpeechListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->removeSpeechListener(Lcom/comcast/cim/android/accessibility/SpeechListener;)V

    .line 247
    return-void
.end method

.method public onInflate(Landroid/app/Activity;Landroid/util/AttributeSet;Landroid/os/Bundle;)V
    .locals 3
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 147
    invoke-super {p0, p1, p2, p3}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onInflate(Landroid/app/Activity;Landroid/util/AttributeSet;Landroid/os/Bundle;)V

    .line 149
    sget-object v1, Lcom/xfinity/playerlib/R$styleable;->com_xfinity_playerlib_view_programdetails_SeriesEpisodeListFragment:[I

    invoke-virtual {p1, p2, v1}, Landroid/app/Activity;->obtainStyledAttributes(Landroid/util/AttributeSet;[I)Landroid/content/res/TypedArray;

    move-result-object v0

    .line 150
    .local v0, "a":Landroid/content/res/TypedArray;
    sget v1, Lcom/xfinity/playerlib/R$styleable;->com_xfinity_playerlib_view_programdetails_SeriesEpisodeListFragment_isFullScreen:I

    const/4 v2, 0x1

    invoke-virtual {v0, v1, v2}, Landroid/content/res/TypedArray;->getBoolean(IZ)Z

    move-result v1

    iput-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->isFullScreen:Z

    .line 151
    invoke-virtual {v0}, Landroid/content/res/TypedArray;->recycle()V

    .line 152
    return-void
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 427
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    invoke-virtual {v0, p1, p0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->onOptionsItemSelected(Landroid/view/MenuItem;Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)Z

    move-result v0

    return v0
.end method

.method public onResumeInternal()V
    .locals 0

    .prologue
    .line 499
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onResumeInternal()V

    .line 500
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->announceListItems()Z

    .line 501
    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 488
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 490
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->addToBundle(Landroid/os/Bundle;)Landroid/os/Bundle;

    .line 493
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->consumableVideoList:Landroid/widget/ListView;

    invoke-virtual {v0}, Landroid/widget/ListView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->restoredListState:Landroid/os/Parcelable;

    .line 494
    const-string v0, "listState"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->restoredListState:Landroid/os/Parcelable;

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 495
    return-void
.end method

.method public onStartInternal()V
    .locals 2

    .prologue
    .line 251
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStartInternal()V

    .line 252
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStart()V

    .line 253
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->addDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 254
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 258
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStop()V

    .line 259
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStop()V

    .line 260
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->removeDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 262
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 263
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 265
    :cond_0
    return-void
.end method

.method public setAnimationEnabled(Ljava/lang/Boolean;)V
    .locals 1
    .param p1, "animationsEnabled"    # Ljava/lang/Boolean;

    .prologue
    .line 545
    invoke-virtual {p1}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->animationsEnabled:Z

    .line 546
    return-void
.end method

.method public showEpisodeAsSelected(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;)V
    .locals 3
    .param p1, "watchable"    # Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .prologue
    .line 474
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    invoke-interface {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;->shouldShowSeriesListItemsChecked()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 475
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->setChecked(Z)V

    .line 476
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->episodeAdapters:Ljava/util/Set;

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;

    .line 477
    .local v0, "adapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->getPosition(Ljava/lang/Object;)I

    move-result v2

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;->setCheckedPos(I)V

    goto :goto_0

    .line 480
    .end local v0    # "adapter":Lcom/xfinity/playerlib/view/common/PlayNowConsumableEpisodeArrayAdapter;
    :cond_0
    return-void
.end method

.method public showSeriesAsSelected()V
    .locals 2

    .prologue
    .line 467
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesEpisodeListContainer:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;

    invoke-interface {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$SeriesEpisodeListContainer;->shouldShowSeriesListItemsChecked()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 468
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->clearEpisodeAdaptersSelections()V

    .line 469
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->setChecked(Z)V

    .line 471
    :cond_0
    return-void
.end method
