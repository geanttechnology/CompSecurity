.class public Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
.super Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;
.source "HistoryFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;,
        Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;,
        Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$VideoPlayOrResumePressedListener;,
        Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        ">;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        ">;",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        "Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;",
        ">;"
    }
.end annotation


# static fields
.field private static final LOG:Lorg/slf4j/Logger;


# instance fields
.field private androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO",
            "<*>;"
        }
    .end annotation
.end field

.field private final bookmarkFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;"
        }
    .end annotation
.end field

.field private final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private final dataProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private final dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

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

.field private downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

.field protected final downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

.field private historyListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;

.field private internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private final liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field liveStreamPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

.field private liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

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

.field private playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field private restoredFirstVisibleItemPosition:I

.field private final taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field protected uiUtil:Lcom/comcast/cim/utils/UIUtil;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

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

.field videoPlayButtonOnClickListener:Landroid/view/View$OnClickListener;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 58
    const-class v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->LOG:Lorg/slf4j/Logger;

    return-void
.end method

.method public constructor <init>()V
    .locals 3

    .prologue
    .line 56
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;-><init>()V

    .line 64
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 65
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 67
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 69
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 71
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadsItemListDelegate()Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    .line 73
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 75
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 77
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 79
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUIUtil()Lcom/comcast/cim/utils/UIUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    .line 83
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 84
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 85
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    .line 86
    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 91
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->bookmarkFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 118
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 119
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 120
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 122
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v1, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dataProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 124
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$2;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    .line 133
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$3;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    .line 181
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$4;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$4;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    .line 391
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    return-object v0
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$1200()Lorg/slf4j/Logger;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method

.method static synthetic access$1300(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/user/PlayNowUserManager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->showUpsellDialogForProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    return-void
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 56
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    return-void
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;

    return-object v0
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->bookmarkFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method private onLiveStreamPlayRequested(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V
    .locals 14
    .param p1, "liveStreamBookmark"    # Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .prologue
    .line 190
    iget-object v9, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->getLiveStream(Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v5

    .line 191
    .local v5, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    if-eqz v5, :cond_0

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v9

    if-nez v9, :cond_1

    .line 192
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 193
    .local v0, "args":Landroid/os/Bundle;
    const-string v9, "title"

    sget v10, Lcom/xfinity/playerlib/R$string;->unavailable:I

    invoke-virtual {p0, v10}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v0, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 194
    new-instance v9, Ljava/lang/StringBuilder;

    invoke-direct {v9}, Ljava/lang/StringBuilder;-><init>()V

    sget v10, Lcom/xfinity/playerlib/R$string;->error_stream_not_available_text:I

    invoke-virtual {p0, v10}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    sget v10, Lcom/xfinity/playerlib/R$string;->remove_item_prompt:I

    const/4 v11, 0x1

    new-array v11, v11, [Ljava/lang/Object;

    const/4 v12, 0x0

    const-string v13, "history"

    aput-object v13, v11, v12

    invoke-virtual {p0, v10, v11}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 195
    .local v2, "description":Ljava/lang/String;
    const-string v9, "description"

    invoke-virtual {v0, v9, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 197
    const-string v9, "inputPromptDlg"

    invoke-static {v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v3

    .line 198
    .local v3, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v3, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 200
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 201
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    sget v10, Lcom/xfinity/playerlib/R$string;->dlg_btn_yes:I

    invoke-virtual {p0, v10}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getString(I)Ljava/lang/String;

    move-result-object v10

    new-instance v11, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;

    invoke-direct {v11, p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$5;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    invoke-direct {v9, v10, v11}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 210
    new-instance v9, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v10

    sget v11, Lcom/xfinity/playerlib/R$string;->dlg_btn_no:I

    invoke-virtual {v10, v11}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v10

    new-instance v11, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$6;

    invoke-direct {v11, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$6;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V

    invoke-direct {v9, v10, v11}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v9}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 217
    invoke-virtual {v3, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 218
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v9

    const-string v10, "caldialogfragment"

    invoke-virtual {v3, v9, v10}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 237
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    .end local v2    # "description":Ljava/lang/String;
    .end local v3    # "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :goto_0
    return-void

    .line 220
    :cond_1
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v7

    .line 222
    .local v7, "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v10, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v9

    new-array v9, v9, [Ljava/lang/String;

    invoke-interface {v7, v9}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v9

    check-cast v9, [Ljava/lang/String;

    invoke-virtual {v10, v9}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 223
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getActivity()Landroid/app/Activity;

    move-result-object v6

    check-cast v6, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;

    .line 225
    .local v6, "liveStreamPlayOrResumePressedListener":Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;
    iget-object v9, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getActivity()Landroid/app/Activity;

    move-result-object v10

    new-instance v11, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;

    invoke-direct {v11, p0, v6, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$7;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)V

    invoke-virtual {v9, v10, v11}, Lcom/comcast/cim/utils/UIUtil;->ensureConnectivityBeforeExecuting(Landroid/content/Context;Ljava/lang/Runnable;)V

    goto :goto_0

    .line 232
    .end local v6    # "liveStreamPlayOrResumePressedListener":Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$LiveStreamPlayOrResumePressedListener;
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v4

    .line 233
    .local v4, "fm":Landroid/app/FragmentManager;
    sget-object v9, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-static {v9, v5}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v8

    .line 234
    .local v8, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v9, "upsell_dialog"

    invoke-virtual {v8, v4, v9}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private showUpsellDialogForProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 3
    .param p1, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .prologue
    .line 176
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v0

    .line 177
    .local v0, "fm":Landroid/app/FragmentManager;
    sget-object v2, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-static {v2, p1}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v1

    .line 178
    .local v1, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v2, "upsell_dialog"

    invoke-virtual {v1, v0, v2}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 179
    return-void
.end method


# virtual methods
.method protected createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;
    .locals 12
    .param p1, "inflater"    # Landroid/view/LayoutInflater;

    .prologue
    .line 307
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->inBabyGuideMode:Z

    if-eqz v0, :cond_0

    .line 308
    sget v7, Lcom/xfinity/playerlib/R$layout;->history_baby_guide_item:I

    .line 313
    .local v7, "itemLayoutId":I
    :goto_0
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamPlayButtonOnClickListener:Landroid/view/View$OnClickListener;

    iget-object v5, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->currentlyPlayingVideoId:Ljava/lang/Long;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 321
    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v9

    iget-object v11, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-object v1, p1

    move-object v10, p0

    invoke-direct/range {v0 .. v11}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Landroid/view/View$OnClickListener;Landroid/view/View$OnClickListener;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;ILjava/lang/Long;ZLcom/xfinity/playerlib/view/ScrollStateTracker;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    .line 325
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->addDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 326
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->addDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 327
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    return-object v0

    .line 310
    .end local v7    # "itemLayoutId":I
    :cond_0
    sget v7, Lcom/xfinity/playerlib/R$layout;->history_item:I

    .restart local v7    # "itemLayoutId":I
    goto :goto_0
.end method

.method protected bridge synthetic createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
    .locals 1

    .prologue
    .line 56
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    move-result-object v0

    return-object v0
.end method

.method protected deleteItem(Lcom/xfinity/playerlib/bookmarks/Bookmark;)V
    .locals 1
    .param p1, "item"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .prologue
    .line 366
    instance-of v0, p1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v0, :cond_0

    .line 367
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    check-cast p1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .end local p1    # "item":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;->deleteBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)Z

    .line 371
    :goto_0
    return-void

    .line 369
    .restart local p1    # "item":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    check-cast p1, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .end local p1    # "item":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    invoke-interface {v0, p1}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->removeHistoryItem(Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;)Z

    goto :goto_0
.end method

.method protected bridge synthetic deleteItem(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 56
    check-cast p1, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->deleteItem(Lcom/xfinity/playerlib/bookmarks/Bookmark;)V

    return-void
.end method

.method protected getData(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;)",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 387
    .local p1, "data":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method protected bridge synthetic getData(Ljava/lang/Object;)Ljava/util/List;
    .locals 1

    .prologue
    .line 56
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getData(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)Ljava/util/List;

    move-result-object v0

    return-object v0
.end method

.method protected getDataTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 332
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dataProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method protected getItemClickListener()Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;"
        }
    .end annotation

    .prologue
    .line 351
    new-instance v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$8;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V

    return-object v0
.end method

.method protected getListHeaderText()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 284
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->history:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getListViewId()I
    .locals 1

    .prologue
    .line 337
    sget v0, Lcom/xfinity/playerlib/R$id;->history_bookmarks:I

    return v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 342
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->inBabyGuideMode:Z

    if-eqz v0, :cond_0

    .line 343
    sget v0, Lcom/xfinity/playerlib/R$layout;->history_baby_guide:I

    .line 346
    :goto_0
    return v0

    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$layout;->history:I

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 242
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onAttach(Landroid/app/Activity;)V

    .line 243
    check-cast p1, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyListener:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$HistoryListener;

    .line 244
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 2
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 248
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v1, Lcom/xfinity/playerlib/tracking/PlayNowTab;->HISTORY:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V

    .line 251
    if-eqz p3, :cond_0

    .line 252
    const-string v0, "firstVisibleItemPosition"

    const/4 v1, 0x0

    invoke-virtual {p3, v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->restoredFirstVisibleItemPosition:I

    .line 255
    :cond_0
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    return-object v0
.end method

.method public onDestroyView()V
    .locals 2

    .prologue
    .line 260
    invoke-super {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onDestroyView()V

    .line 262
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->historyAdapter:Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->removeDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 263
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->playerDownloadServiceManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->removeDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 264
    return-void
.end method

.method protected onResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 289
    .local p1, "data":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    check-cast v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->setDibicResource(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V

    .line 290
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    check-cast v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 291
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    check-cast v0, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryAdapter;->setLiveStreamResource(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;)V

    .line 293
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 294
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 295
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 297
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onResourceFetched(Ljava/lang/Object;)V

    .line 300
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getListView()Landroid/widget/AbsListView;

    move-result-object v0

    iget v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->restoredFirstVisibleItemPosition:I

    invoke-virtual {v0, v1}, Landroid/widget/AbsListView;->setSelection(I)V

    .line 301
    return-void
.end method

.method protected bridge synthetic onResourceFetched(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 56
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->onResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    return-void
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "outState"    # Landroid/os/Bundle;

    .prologue
    .line 268
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onSaveInstanceState(Landroid/os/Bundle;)V

    .line 270
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->getListView()Landroid/widget/AbsListView;

    move-result-object v0

    invoke-virtual {v0}, Landroid/widget/AbsListView;->getFirstVisiblePosition()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->restoredFirstVisibleItemPosition:I

    .line 271
    const-string v0, "firstVisibleItemPosition"

    iget v1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->restoredFirstVisibleItemPosition:I

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 273
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 277
    invoke-super {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onStop()V

    .line 279
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->purgeJobs()V

    .line 280
    return-void
.end method
