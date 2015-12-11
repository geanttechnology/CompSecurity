.class public Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
.super Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;
.source "DownloadsFragment.java"

# interfaces
.implements Lcom/xfinity/playerlib/view/ScrollStateTracker;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;,
        Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$NetworkReceiver;
    }
.end annotation


# instance fields
.field protected final LOG:Lorg/slf4j/Logger;

.field protected alphabetSortButton:Landroid/view/View;

.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private final bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

.field private bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;>;>;"
        }
    .end annotation
.end field

.field protected downloadList:Landroid/widget/ListView;

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

.field protected downloadedFiles:Ljava/util/ArrayList;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/ArrayList",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;"
        }
    .end annotation
.end field

.field protected downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

.field protected downloadsFTU:Landroid/widget/ImageView;

.field private final downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

.field protected final downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

.field protected downloadsSubNavBar:Landroid/view/ViewGroup;

.field protected expiringSortButton:Landroid/view/View;

.field protected final imageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private isEditMode:Z

.field private isPhone:Z

.field loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

.field protected final logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field protected offlineWarningLayout:Landroid/view/ViewGroup;

.field protected offlineWarningText:Landroid/widget/TextView;

.field protected pauseResumeButton:Landroid/widget/Button;

.field protected pauseResumeSpinner:Landroid/widget/ProgressBar;

.field protected pauseResumeView:Landroid/view/View;

.field private final providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field protected recentSortButton:Landroid/view/View;

.field private scrollState:I

.field private final sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/xfinity/playerlib/view/browseprograms/SortPolicy",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;"
        }
    .end annotation
.end field

.field protected final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;-><init>()V

    .line 74
    const-class v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->LOG:Lorg/slf4j/Logger;

    .line 93
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadsSortPolicy()Lcom/xfinity/playerlib/view/downloads/DownloadsSortPolicy;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    .line 102
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->imageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 103
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 105
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadServiceManager()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    .line 107
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDownloadsItemListDelegate()Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    .line 109
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 111
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 113
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isEditMode:Z

    .line 115
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    .line 116
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 121
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 123
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 130
    new-instance v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$1;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    .line 686
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->fetchBookmarksAndUpdateList()V

    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showOfflineWarningIfNecessary()V

    return-void
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isEditMode:Z

    return v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
    .param p1, "x1"    # I

    .prologue
    .line 73
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showItemAtPosition(I)V

    return-void
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showSelectedCountOnActionMenu()V

    return-void
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showSelectedCountOnActionMenu()V

    return-void
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->startActionMode()V

    return-void
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
    .param p1, "x1"    # I

    .prologue
    .line 73
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->selectItem(I)V

    return-void
.end method

.method static synthetic access$802(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;
    .param p1, "x1"    # I

    .prologue
    .line 73
    iput p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->scrollState:I

    return p1
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;

    .prologue
    .line 73
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    return-object v0
.end method

.method private enableListSelection(Z)V
    .locals 2
    .param p1, "enable"    # Z

    .prologue
    .line 169
    if-eqz p1, :cond_0

    .line 170
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    new-instance v1, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$2;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 198
    :goto_0
    return-void

    .line 184
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    new-instance v1, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$3;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$3;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    goto :goto_0
.end method

.method private fetchBookmarksAndUpdateList()V
    .locals 9

    .prologue
    const/16 v7, 0x8

    const/4 v6, 0x0

    .line 616
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getAdultFilteredList()Ljava/util/List;

    move-result-object v1

    .line 618
    .local v1, "files":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getShowDownloadsFTU()Z

    move-result v5

    if-nez v5, :cond_0

    .line 619
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsFTU:Landroid/widget/ImageView;

    invoke-virtual {v5, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 629
    :goto_0
    new-instance v3, Ljava/util/HashMap;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    invoke-direct {v3, v5}, Ljava/util/HashMap;-><init>(I)V

    .line 630
    .local v3, "videos":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_2

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 631
    .local v0, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v4

    .line 632
    .local v4, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v6

    invoke-interface {v4, v6, v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v2

    .line 633
    .local v2, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-interface {v3, v2, v4}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_1

    .line 621
    .end local v0    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    .end local v2    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v3    # "videos":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;>;"
    .end local v4    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_0
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    if-lez v5, :cond_1

    .line 622
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->setShowDownloadsFTU(Z)V

    .line 623
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsFTU:Landroid/widget/ImageView;

    invoke-virtual {v5, v7}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 625
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsFTU:Landroid/widget/ImageView;

    invoke-virtual {v5, v6}, Landroid/widget/ImageView;->setVisibility(I)V

    goto :goto_0

    .line 636
    .restart local v3    # "videos":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;>;"
    :cond_2
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    new-instance v7, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    invoke-direct {v7, v8, v3}, Lcom/xfinity/playerlib/view/downloads/DownloadedVideosBookmarkCache;-><init>(Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;Ljava/util/Map;)V

    invoke-virtual {v5, v6, v7}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v5

    iput-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 637
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v6, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;

    invoke-direct {v6, p0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$8;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;Ljava/util/List;)V

    invoke-interface {v5, v6}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v5

    iput-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 664
    return-void
.end method

.method private getAdultFilteredList()Ljava/util/List;
    .locals 8
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;",
            ">;"
        }
    .end annotation

    .prologue
    .line 591
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v1

    .line 592
    .local v1, "files":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    new-instance v2, Ljava/util/ArrayList;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    invoke-direct {v2, v5}, Ljava/util/ArrayList;-><init>(I)V

    .line 594
    .local v2, "filteredFiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z

    move-result v5

    if-nez v5, :cond_2

    .line 595
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_0
    :goto_0
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 596
    .local v0, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->isDownloadComplete()Z

    move-result v6

    if-eqz v6, :cond_1

    .line 597
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v4

    .line 598
    .local v4, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getVideoId()J

    move-result-wide v6

    invoke-interface {v4, v6, v7}, Lcom/xfinity/playerlib/model/consumable/Watchable;->findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v3

    .line 599
    .local v3, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->isAdult()Z

    move-result v6

    if-nez v6, :cond_0

    .line 600
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 604
    .end local v3    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v4    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_1
    invoke-interface {v2, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 608
    .end local v0    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_2
    invoke-interface {v2, v1}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 611
    :cond_3
    return-object v2
.end method

.method private hideSortButtons()V
    .locals 3

    .prologue
    const/16 v2, 0x8

    .line 667
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isPhone:Z

    if-eqz v0, :cond_0

    .line 668
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 670
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsSubNavBar:Landroid/view/ViewGroup;

    invoke-virtual {v0, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 671
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 672
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 673
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    invoke-virtual {v0, v2}, Landroid/view/View;->setVisibility(I)V

    .line 674
    return-void
.end method

.method private selectItem(I)V
    .locals 4
    .param p1, "i"    # I

    .prologue
    const/4 v1, 0x0

    .line 419
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getCheckedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v0

    .line 420
    .local v0, "sba":Landroid/util/SparseBooleanArray;
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v0, p1, v1}, Landroid/util/SparseBooleanArray;->get(IZ)Z

    move-result v3

    if-nez v3, :cond_0

    const/4 v1, 0x1

    :cond_0
    invoke-virtual {v2, p1, v1}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 422
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showSelectedCountOnActionMenu()V

    .line 423
    return-void
.end method

.method private showItemAtPosition(I)V
    .locals 5
    .param p1, "index"    # I

    .prologue
    .line 427
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v3, p1}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 429
    .local v1, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-eqz v1, :cond_0

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getExpirationStatus()Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    move-result-object v3

    sget-object v4, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;->AAW_EXPIRED:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile$ExpirationStatus;

    if-eq v3, v4, :cond_0

    .line 430
    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isPhone:Z

    if-eqz v3, :cond_1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v3

    invoke-interface {v3}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/MerlinId;->getNamespace()Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    move-result-object v3

    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    if-ne v3, v4, :cond_1

    .line 431
    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    const/4 v4, 0x0

    .line 432
    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->shouldHideSeriesTitle(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 433
    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchable()Lcom/xfinity/playerlib/model/consumable/Watchable;

    move-result-object v4

    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->episodeId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    sget-object v4, Lcom/xfinity/playerlib/model/MerlinId$Namespace;->TvEpisode:Lcom/xfinity/playerlib/model/MerlinId$Namespace;

    .line 434
    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->overrideNamespace(Lcom/xfinity/playerlib/model/MerlinId$Namespace;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v3

    .line 435
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v0

    .line 437
    .local v0, "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    new-instance v2, Landroid/content/Intent;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    const-class v4, Lcom/xfinity/playerlib/view/programdetails/EpisodeDetailActivity;

    invoke-direct {v2, v3, v4}, Landroid/content/Intent;-><init>(Landroid/content/Context;Ljava/lang/Class;)V

    .line 438
    .local v2, "intent":Landroid/content/Intent;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getBundle()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v2, v3}, Landroid/content/Intent;->putExtras(Landroid/os/Bundle;)Landroid/content/Intent;

    .line 439
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->startActivity(Landroid/content/Intent;)V

    .line 450
    .end local v0    # "detailIntentHelper":Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;
    .end local v2    # "intent":Landroid/content/Intent;
    :cond_0
    :goto_0
    return-void

    .line 441
    :cond_1
    new-instance v3, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getWatchableKey()Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    move-result-object v4

    invoke-direct {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V

    .line 442
    invoke-virtual {v3}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v3

    .line 443
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v4

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v2

    .line 446
    .restart local v2    # "intent":Landroid/content/Intent;
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->startActivity(Landroid/content/Intent;)V

    goto :goto_0
.end method

.method private showNoWifiWarningIfNecessary()V
    .locals 7

    .prologue
    const/16 v4, 0x8

    const/4 v6, 0x0

    .line 201
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUser()Lcom/comcast/cim/model/user/User;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/user/PlayNowUser;

    .line 202
    .local v1, "user":Lcom/xfinity/playerlib/model/user/PlayNowUser;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getFilesList()Ljava/util/List;

    move-result-object v3

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v0

    .line 203
    .local v0, "fileListSize":I
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    .line 205
    .local v2, "userSettings":Lcom/xfinity/playerlib/model/user/PlayerUserSettings;
    if-eqz v1, :cond_0

    if-lez v0, :cond_0

    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnectedNotOnWiFi()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 206
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getUseCellularWhenAvailable()Z

    move-result v3

    if-nez v3, :cond_0

    .line 208
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$color;->semitransparent_blue:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getColor(I)I

    move-result v4

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    .line 209
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->cellular_not_enabled_but_it_could_be:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 211
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    invoke-virtual {v3, v6}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 212
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {v3, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 219
    :goto_0
    return-void

    .line 216
    :cond_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    invoke-virtual {v3, v4}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 217
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {v3, v4}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0
.end method

.method private showOfflineWarningIfNecessary()V
    .locals 11

    .prologue
    const/16 v6, 0x8

    const/4 v8, 0x1

    const/4 v10, 0x0

    .line 223
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getDownloadedFileList()Ljava/util/List;

    move-result-object v1

    .line 224
    .local v1, "downloadedFiles":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v5

    if-eqz v5, :cond_0

    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    invoke-virtual {v5}, Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;->isConnected()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 225
    :cond_0
    invoke-direct {p0, v8}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->enableListSelection(Z)V

    .line 226
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    invoke-virtual {v5, v6}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 227
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setVisibility(I)V

    .line 228
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showNoWifiWarningIfNecessary()V

    .line 269
    :goto_0
    return-void

    .line 232
    :cond_1
    const/4 v4, 0x0

    .line 233
    .local v4, "soonestDate":Ljava/util/Date;
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    :goto_1
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_4

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 234
    .local v2, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    if-nez v4, :cond_3

    .line 235
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getLicenseExpirationDate()Ljava/util/Date;

    move-result-object v4

    goto :goto_1

    .line 237
    :cond_3
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getLicenseExpirationDate()Ljava/util/Date;

    move-result-object v6

    invoke-virtual {v4, v6}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 238
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;->getLicenseExpirationDate()Ljava/util/Date;

    move-result-object v4

    goto :goto_1

    .line 243
    .end local v2    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_4
    if-eqz v4, :cond_8

    .line 244
    new-instance v5, Ljava/util/Date;

    invoke-direct {v5}, Ljava/util/Date;-><init>()V

    invoke-virtual {v4, v5}, Ljava/util/Date;->after(Ljava/util/Date;)Z

    move-result v5

    if-eqz v5, :cond_7

    .line 245
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$color;->semitransparent_blue:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    .line 247
    invoke-static {v4}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDaysLeft(Ljava/util/Date;)I

    move-result v0

    .line 248
    .local v0, "daysLeft":I
    if-lez v0, :cond_5

    .line 249
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$plurals;->offline_warning_content_expiring:I

    new-array v8, v8, [Ljava/lang/Object;

    invoke-static {v0}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-virtual {v6, v7, v0, v8}, Landroid/content/res/Resources;->getQuantityString(II[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 264
    .end local v0    # "daysLeft":I
    :goto_2
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    invoke-virtual {v5, v10}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 265
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {v5, v10}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_0

    .line 251
    .restart local v0    # "daysLeft":I
    :cond_5
    invoke-virtual {p0, v4}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getHoursLeft(Ljava/util/Date;)I

    move-result v3

    .line 252
    .local v3, "hoursLeft":I
    const/16 v5, 0x17

    if-ne v3, v5, :cond_6

    .line 253
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$string;->offline_warning_content_expiring_today:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 255
    :cond_6
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$string;->offline_warning_content_expiring_in_hours:I

    new-array v8, v8, [Ljava/lang/Object;

    add-int/lit8 v9, v3, 0x1

    invoke-static {v9}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v9

    aput-object v9, v8, v10

    invoke-virtual {v6, v7, v8}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    goto :goto_2

    .line 260
    .end local v0    # "daysLeft":I
    .end local v3    # "hoursLeft":I
    :cond_7
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$color;->semitransparent_black:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getColor(I)I

    move-result v6

    invoke-virtual {v5, v6}, Landroid/view/ViewGroup;->setBackgroundColor(I)V

    .line 261
    iget-object v5, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$string;->offline_warning_content_expired:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 262
    invoke-direct {p0, v10}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->enableListSelection(Z)V

    goto :goto_2

    .line 267
    :cond_8
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showNoWifiWarningIfNecessary()V

    goto/16 :goto_0
.end method

.method private showSortButtons()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 677
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isPhone:Z

    if-eqz v0, :cond_0

    .line 678
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->setVisibility(I)V

    .line 680
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsSubNavBar:Landroid/view/ViewGroup;

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 681
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 682
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 683
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 684
    return-void
.end method


# virtual methods
.method protected applySort()V
    .locals 2

    .prologue
    .line 711
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingStarted()V

    .line 713
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getCurrentSortComparator()Ljava/util/Comparator;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->sort(Ljava/util/Comparator;)V

    .line 715
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getCount()I

    move-result v0

    if-nez v0, :cond_0

    .line 716
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->hideSortButtons()V

    .line 721
    :goto_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->updatePauseButton()V

    .line 723
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showOfflineWarningIfNecessary()V

    .line 725
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->notifyDataSetChanged()V

    .line 727
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 728
    return-void

    .line 718
    :cond_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->showSortButtons()V

    goto :goto_0
.end method

.method protected deleteItems()V
    .locals 6

    .prologue
    .line 485
    iget-object v4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getCheckedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v3

    .line 486
    .local v3, "sparseBooleanArray":Landroid/util/SparseBooleanArray;
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 487
    .local v1, "files":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;>;"
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v4}, Landroid/widget/ListView;->getCount()I

    move-result v4

    if-ge v2, v4, :cond_1

    .line 488
    invoke-virtual {v3, v2}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v4

    if-eqz v4, :cond_0

    .line 489
    iget-object v4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v4, v2}, Landroid/widget/ListView;->getItemAtPosition(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;

    .line 490
    .local v0, "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    const/4 v5, 0x0

    invoke-virtual {v4, v2, v5}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 491
    invoke-interface {v1, v0}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 487
    .end local v0    # "file":Lcom/xfinity/playerlib/model/downloads/PlayerDownloadFile;
    :cond_0
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 496
    :cond_1
    :try_start_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v4, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->deleteFiles(Ljava/util/List;)Ljava/util/Map;
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    .line 500
    :goto_1
    return-void

    .line 497
    :catch_0
    move-exception v4

    goto :goto_1
.end method

.method protected getCheckedItemsCount()I
    .locals 4

    .prologue
    .line 504
    const/4 v1, 0x0

    .line 506
    .local v1, "retval":I
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getCheckedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v2

    .line 507
    .local v2, "sparseBooleanArray":Landroid/util/SparseBooleanArray;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v3}, Landroid/widget/ListView;->getCount()I

    move-result v3

    if-ge v0, v3, :cond_1

    .line 508
    invoke-virtual {v2, v0}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 509
    add-int/lit8 v1, v1, 0x1

    .line 507
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 512
    :cond_1
    return v1
.end method

.method public getHoursLeft(Ljava/util/Date;)I
    .locals 8
    .param p1, "expireDate"    # Ljava/util/Date;

    .prologue
    .line 272
    invoke-virtual {p1}, Ljava/util/Date;->getTime()J

    move-result-wide v2

    .line 273
    .local v2, "time":J
    new-instance v4, Ljava/util/Date;

    invoke-direct {v4}, Ljava/util/Date;-><init>()V

    invoke-virtual {v4}, Ljava/util/Date;->getTime()J

    move-result-wide v0

    .line 274
    .local v0, "now":J
    sub-long v4, v2, v0

    const-wide/32 v6, 0x36ee80

    div-long/2addr v4, v6

    long-to-int v4, v4

    return v4
.end method

.method protected getTotalItemsCount()I
    .locals 1

    .prologue
    .line 517
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->getCount()I

    move-result v0

    return v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 465
    sget v0, Lcom/xfinity/playerlib/R$layout;->downloads:I

    return v0
.end method

.method protected isEditEnabled()Z
    .locals 1

    .prologue
    .line 470
    const/4 v0, 0x1

    return v0
.end method

.method public isFlinging()Z
    .locals 2

    .prologue
    .line 156
    iget v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->scrollState:I

    const/4 v1, 0x2

    if-ne v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 544
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onAttach(Landroid/app/Activity;)V

    .line 545
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 546
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 16
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 279
    invoke-super/range {p0 .. p3}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v12

    .line 280
    .local v12, "layout":Landroid/view/View;
    sget v1, Lcom/xfinity/playerlib/R$id;->downloadsSubNavBar:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsSubNavBar:Landroid/view/ViewGroup;

    .line 282
    sget v1, Lcom/xfinity/playerlib/R$id;->offline_warning_layout:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningLayout:Landroid/view/ViewGroup;

    .line 283
    sget v1, Lcom/xfinity/playerlib/R$id;->offline_warning_text:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->offlineWarningText:Landroid/widget/TextView;

    .line 285
    sget v1, Lcom/xfinity/playerlib/R$id;->downloads_ftu:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsFTU:Landroid/widget/ImageView;

    .line 287
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->sortPolicy:Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy;->getSortTypes()Ljava/util/List;

    move-result-object v15

    .line 289
    .local v15, "sortTypes":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;>;"
    sget v1, Lcom/xfinity/playerlib/R$id;->expiringSort:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    .line 290
    sget v1, Lcom/xfinity/playerlib/R$id;->alphabetSort:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    .line 291
    sget v1, Lcom/xfinity/playerlib/R$id;->recentSort:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    .line 292
    sget v1, Lcom/xfinity/playerlib/R$id;->downloadList:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ListView;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    .line 293
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    const/4 v2, 0x2

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setChoiceMode(I)V

    .line 295
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    if-nez v1, :cond_2

    const/4 v1, 0x1

    :goto_0
    move-object/from16 v0, p0

    iput-boolean v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isPhone:Z

    .line 296
    move-object/from16 v0, p0

    iget-boolean v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isPhone:Z

    if-eqz v1, :cond_0

    .line 299
    sget v1, Lcom/xfinity/playerlib/R$layout;->downloads_list_header:I

    const/4 v2, 0x0

    const/4 v3, 0x0

    move-object/from16 v0, p1

    invoke-virtual {v0, v1, v2, v3}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v13

    .line 300
    .local v13, "listViewHeader":Landroid/view/View;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    const/4 v2, 0x0

    const/4 v3, 0x0

    invoke-virtual {v1, v13, v2, v3}, Landroid/widget/ListView;->addHeaderView(Landroid/view/View;Ljava/lang/Object;Z)V

    .line 302
    sget v1, Lcom/xfinity/playerlib/R$id;->expiringSort:I

    invoke-virtual {v13, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    .line 303
    sget v1, Lcom/xfinity/playerlib/R$id;->alphabetSort:I

    invoke-virtual {v13, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    .line 304
    sget v1, Lcom/xfinity/playerlib/R$id;->recentSort:I

    invoke-virtual {v13, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    .line 307
    .end local v13    # "listViewHeader":Landroid/view/View;
    :cond_0
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    new-instance v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;

    const/4 v1, 0x0

    invoke-interface {v15, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 308
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    new-instance v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;

    const/4 v1, 0x1

    invoke-interface {v15, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 309
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    new-instance v3, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;

    const/4 v1, 0x2

    invoke-interface {v15, v1}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    move-object/from16 v0, p0

    invoke-direct {v3, v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$SortButtonOnTouchListener;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V

    invoke-virtual {v2, v3}, Landroid/view/View;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 311
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadedFiles:Ljava/util/ArrayList;

    .line 313
    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->month_day_year_format:I

    invoke-virtual {v1, v2}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-static {v1}, Lorg/apache/commons/lang3/time/FastDateFormat;->getInstance(Ljava/lang/String;)Lorg/apache/commons/lang3/time/FastDateFormat;

    move-result-object v11

    .line 314
    .local v11, "sdf":Lorg/apache/commons/lang3/time/FastDateFormat;
    new-instance v1, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadedFiles:Ljava/util/ArrayList;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->imageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsItemListener:Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->logoImageLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-object/from16 v0, p0

    iget-object v9, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-object/from16 v4, p1

    move-object/from16 v10, p0

    invoke-direct/range {v1 .. v11}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;-><init>(Landroid/app/Activity;Ljava/util/List;Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Lcom/xfinity/playerlib/view/downloads/DownloadsItemListener;Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/xfinity/playerlib/view/ScrollStateTracker;Lorg/apache/commons/lang3/time/FastDateFormat;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    .line 317
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setAdapter(Landroid/widget/ListAdapter;)V

    .line 319
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    new-instance v2, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$4;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 334
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    new-instance v2, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$5;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$5;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    invoke-virtual {v1, v2}, Landroid/widget/ListView;->setOnScrollListener(Landroid/widget/AbsListView$OnScrollListener;)V

    .line 346
    const/4 v1, 0x1

    move-object/from16 v0, p0

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->enableListSelection(Z)V

    .line 348
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    move-object/from16 v0, p0

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->registerForContextMenu(Landroid/view/View;)V

    .line 350
    sget v1, Lcom/xfinity/playerlib/R$id;->pauseResumeLayout:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeView:Landroid/view/View;

    .line 353
    sget v1, Lcom/xfinity/playerlib/R$id;->pauseResumeButton:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/Button;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    .line 355
    sget v1, Lcom/xfinity/playerlib/R$id;->pauseResumeLayoutPhone:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v14

    .line 357
    .local v14, "pauseRemoveClickView":Landroid/view/View;
    if-nez v14, :cond_1

    .line 358
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeView:Landroid/view/View;

    .line 361
    :cond_1
    new-instance v1, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;

    move-object/from16 v0, p0

    invoke-direct {v1, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$6;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    invoke-virtual {v14, v1}, Landroid/view/View;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 392
    sget v1, Lcom/xfinity/playerlib/R$id;->pauseResumeSpinner:I

    invoke-virtual {v12, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ProgressBar;

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeSpinner:Landroid/widget/ProgressBar;

    .line 394
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v2, Lcom/xfinity/playerlib/tracking/PlayNowTab;->DOWNLOADS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V

    .line 396
    new-instance v1, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual/range {p0 .. p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$id;->body_container:I

    .line 397
    invoke-virtual {v12, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Landroid/view/ViewGroup;

    sget v4, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    .line 398
    invoke-virtual {v12, v4}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v4

    check-cast v4, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    new-instance v6, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;

    move-object/from16 v0, p0

    invoke-direct {v6, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$7;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    invoke-direct/range {v1 .. v6}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;-><init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V

    move-object/from16 v0, p0

    iput-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    .line 414
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    new-instance v2, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$NetworkReceiver;

    move-object/from16 v0, p0

    invoke-direct {v2, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$NetworkReceiver;-><init>(Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;)V

    invoke-virtual {v1, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->setNetworkReceiver(Landroid/content/BroadcastReceiver;)V

    .line 415
    return-object v12

    .line 295
    .end local v11    # "sdf":Lorg/apache/commons/lang3/time/FastDateFormat;
    .end local v14    # "pauseRemoveClickView":Landroid/view/View;
    :cond_2
    const/4 v1, 0x0

    goto/16 :goto_0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 550
    invoke-super {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onPause()V

    .line 552
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->removeDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 553
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->removeDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 555
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 556
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 558
    :cond_0
    return-void
.end method

.method public onResumeInternal()V
    .locals 2

    .prologue
    .line 535
    invoke-super {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onResumeInternal()V

    .line 536
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->addDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 537
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadServiceListener:Lcom/comcast/cim/downloads/DownloadServiceListener;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->addDownloadServiceListener(Lcom/comcast/cim/downloads/DownloadServiceListener;)V

    .line 539
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->startLoading()V

    .line 540
    return-void
.end method

.method public onStartInternal()V
    .locals 1

    .prologue
    .line 522
    invoke-super {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onStartInternal()V

    .line 523
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStart()V

    .line 524
    return-void
.end method

.method public onStop()V
    .locals 1

    .prologue
    .line 528
    invoke-super {p0}, Lcom/xfinity/playerlib/view/favorite/MultiDeleteActionFragment;->onStop()V

    .line 530
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStop()V

    .line 531
    return-void
.end method

.method protected select(Landroid/view/View;)V
    .locals 1
    .param p1, "button"    # Landroid/view/View;

    .prologue
    .line 561
    const/4 v0, 0x1

    invoke-virtual {p1, v0}, Landroid/view/View;->setSelected(Z)V

    .line 562
    return-void
.end method

.method protected setEditMode(Z)V
    .locals 1
    .param p1, "b"    # Z

    .prologue
    .line 475
    iput-boolean p1, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isEditMode:Z

    .line 476
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsAdapter:Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/view/downloads/DownloadsArrayAdapter;->setEditMode(Z)V

    .line 478
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->isEditMode:Z

    if-nez v0, :cond_0

    .line 479
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->uncheckAll()V

    .line 481
    :cond_0
    return-void
.end method

.method protected tempDisablePauseButton()V
    .locals 2

    .prologue
    .line 731
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/Button;->setVisibility(I)V

    .line 732
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeSpinner:Landroid/widget/ProgressBar;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 733
    return-void
.end method

.method protected uncheckAll()V
    .locals 4

    .prologue
    .line 453
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getCheckedItemPositions()Landroid/util/SparseBooleanArray;

    move-result-object v1

    .line 455
    .local v1, "sparseBooleanArray":Landroid/util/SparseBooleanArray;
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    invoke-virtual {v2}, Landroid/widget/ListView;->getCount()I

    move-result v2

    if-ge v0, v2, :cond_1

    .line 457
    invoke-virtual {v1, v0}, Landroid/util/SparseBooleanArray;->get(I)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 458
    iget-object v2, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadList:Landroid/widget/ListView;

    const/4 v3, 0x0

    invoke-virtual {v2, v0, v3}, Landroid/widget/ListView;->setItemChecked(IZ)V

    .line 455
    :cond_0
    add-int/lit8 v0, v0, 0x1

    goto :goto_0

    .line 461
    :cond_1
    return-void
.end method

.method protected unselect(Landroid/view/View;)V
    .locals 1
    .param p1, "button"    # Landroid/view/View;

    .prologue
    .line 565
    const/4 v0, 0x0

    invoke-virtual {p1, v0}, Landroid/view/View;->setSelected(Z)V

    .line 566
    return-void
.end method

.method protected updatePauseButton()V
    .locals 9

    .prologue
    const/16 v8, 0x8

    .line 737
    :try_start_0
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeSpinner:Landroid/widget/ProgressBar;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/widget/ProgressBar;->setVisibility(I)V

    .line 738
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->downloadsManager:Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/downloads/PlayerDownloadServiceManager;->getDownloadEngineStatus()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v2

    .line 739
    .local v2, "status":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v1

    .line 740
    .local v1, "eStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v1, v3, :cond_0

    .line 741
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeView:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 742
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 743
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->pause_download_text:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 744
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$drawable;->btn_download_pause:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v5, v6, v7}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V

    .line 759
    .end local v1    # "eStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .end local v2    # "status":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :goto_0
    return-void

    .line 745
    .restart local v1    # "eStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .restart local v2    # "status":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :cond_0
    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v1, v3, :cond_1

    .line 746
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeView:Landroid/view/View;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    .line 747
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    const/4 v4, 0x0

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setVisibility(I)V

    .line 748
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$string;->resume_download_text:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Landroid/widget/Button;->setText(Ljava/lang/CharSequence;)V

    .line 749
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeButton:Landroid/widget/Button;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v4

    sget v5, Lcom/xfinity/playerlib/R$drawable;->btn_download_resume:I

    invoke-virtual {v4, v5}, Landroid/content/res/Resources;->getDrawable(I)Landroid/graphics/drawable/Drawable;

    move-result-object v4

    const/4 v5, 0x0

    const/4 v6, 0x0

    const/4 v7, 0x0

    invoke-virtual {v3, v4, v5, v6, v7}, Landroid/widget/Button;->setCompoundDrawablesWithIntrinsicBounds(Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;Landroid/graphics/drawable/Drawable;)V
    :try_end_0
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 755
    .end local v1    # "eStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .end local v2    # "status":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :catch_0
    move-exception v0

    .line 756
    .local v0, "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->LOG:Lorg/slf4j/Logger;

    invoke-virtual {v0}, Lcom/comcast/cim/downloads/DownloadServiceException;->getMessage()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v3, v4, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 757
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeView:Landroid/view/View;

    invoke-virtual {v3, v8}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 750
    .end local v0    # "e":Lcom/comcast/cim/downloads/DownloadServiceException;
    .restart local v1    # "eStatus":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .restart local v2    # "status":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    :cond_1
    :try_start_1
    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v1, v3, :cond_2

    .line 751
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeView:Landroid/view/View;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V

    goto :goto_0

    .line 753
    :cond_2
    iget-object v3, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->pauseResumeView:Landroid/view/View;

    const/16 v4, 0x8

    invoke-virtual {v3, v4}, Landroid/view/View;->setVisibility(I)V
    :try_end_1
    .catch Lcom/comcast/cim/downloads/DownloadServiceException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_0
.end method

.method protected updateSortButtonStates(Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;)V
    .locals 3
    .param p1, "selectedSort"    # Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;

    .prologue
    .line 569
    sget-object v0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment$9;->$SwitchMap$com$xfinity$playerlib$view$browseprograms$SortPolicy$SortType:[I

    invoke-virtual {p1}, Lcom/xfinity/playerlib/view/browseprograms/SortPolicy$SortType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 586
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->LOG:Lorg/slf4j/Logger;

    new-instance v1, Ljava/lang/StringBuilder;

    invoke-direct {v1}, Ljava/lang/StringBuilder;-><init>()V

    const-string v2, "unexpected sort="

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lorg/slf4j/Logger;->warn(Ljava/lang/String;)V

    .line 588
    :goto_0
    return-void

    .line 571
    :pswitch_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->select(Landroid/view/View;)V

    .line 572
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->unselect(Landroid/view/View;)V

    .line 573
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->unselect(Landroid/view/View;)V

    goto :goto_0

    .line 576
    :pswitch_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->select(Landroid/view/View;)V

    .line 577
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->unselect(Landroid/view/View;)V

    .line 578
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->unselect(Landroid/view/View;)V

    goto :goto_0

    .line 581
    :pswitch_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->expiringSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->select(Landroid/view/View;)V

    .line 582
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->alphabetSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->unselect(Landroid/view/View;)V

    .line 583
    iget-object v0, p0, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->recentSortButton:Landroid/view/View;

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/downloads/DownloadsFragment;->unselect(Landroid/view/View;)V

    goto :goto_0

    .line 569
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_1
        :pswitch_2
    .end packed-switch
.end method
