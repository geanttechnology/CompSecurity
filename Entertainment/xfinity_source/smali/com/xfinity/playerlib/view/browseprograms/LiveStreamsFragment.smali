.class public Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "LiveStreamsFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamBookmarkEventListener;,
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;,
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;,
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamClickedListener;,
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$StreamViewHolder;,
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;,
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;,
        Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$HalLiveFeaturedContentContainer;
    }
.end annotation


# instance fields
.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field private final appLauncher:Lcom/comcast/cim/utils/AppLauncher;

.field private bodyContainer:Landroid/view/ViewGroup;

.field protected bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field private carouselAdapter:Landroid/support/v4/view/PagerAdapter;

.field private carouselCurrentItem:I

.field private carouselIndex:I

.field private final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

.field private featuredCarousel:Landroid/support/v4/view/ViewPager;

.field private featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

.field private featuredContentTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
            ">;"
        }
    .end annotation
.end field

.field private featuredContentTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
            ">;"
        }
    .end annotation
.end field

.field private gridState:Landroid/os/Parcelable;

.field private imageHeight:I

.field private imageViewHeight:I

.field private imageViewWidth:I

.field private imageWidth:I

.field private inTabletBabyGuide:Z

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field private liveFeaturedContentList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContent;",
            ">;"
        }
    .end annotation
.end field

.field private liveFeaturedContentResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveFeaturedContentResource;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field private liveStreamBookmarks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamClickListener:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;

.field private liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreams:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
            ">;"
        }
    .end annotation
.end field

.field private loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

.field private onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

.field private final pageTransformer:Lcom/xfinity/playerlib/view/DimmingPageTransformer;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field private final userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

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
    .locals 2

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    .line 76
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 77
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 78
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 79
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 81
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 83
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 84
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 85
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .line 86
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 87
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAppLauncher()Lcom/comcast/cim/utils/AppLauncher;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;

    .line 88
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 91
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveFeaturedContentResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 92
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 93
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 132
    const/4 v0, -0x1

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselCurrentItem:I

    .line 135
    new-instance v0, Lcom/xfinity/playerlib/view/DimmingPageTransformer;

    invoke-direct {v0}, Lcom/xfinity/playerlib/view/DimmingPageTransformer;-><init>()V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->pageTransformer:Lcom/xfinity/playerlib/view/DimmingPageTransformer;

    .line 143
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$2;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    .line 765
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$002(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->displayLiveFeaturedContent()V

    return-void
.end method

.method static synthetic access$1000(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreams:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1002(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreams:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1100(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "x2"    # Ljava/lang/String;

    .prologue
    .line 69
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->launchLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V

    return-void
.end method

.method static synthetic access$1200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/content/DialogInterface$OnDismissListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    return-object v0
.end method

.method static synthetic access$1400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$1500(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object v0
.end method

.method static synthetic access$1502(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object p1
.end method

.method static synthetic access$1600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarks:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$1602(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 69
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarks:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$1700(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->displayLiveStreams()V

    return-void
.end method

.method static synthetic access$1800(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    return-object v0
.end method

.method static synthetic access$1900(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->transformCarouselItems()V

    return-void
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/view/PagerContainer;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

    return-object v0
.end method

.method static synthetic access$2100(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I

    return v0
.end method

.method static synthetic access$2200(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewHeight:I

    return v0
.end method

.method static synthetic access$2300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageWidth:I

    return v0
.end method

.method static synthetic access$2400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageHeight:I

    return v0
.end method

.method static synthetic access$2500(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/image/CoverArtImageLoader;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    return-object v0
.end method

.method static synthetic access$2600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    return-object v0
.end method

.method static synthetic access$2800(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    return-object v0
.end method

.method static synthetic access$2900(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/support/v4/view/ViewPager;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    return-object v0
.end method

.method static synthetic access$3000(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->isInBabyGuide()Z

    move-result v0

    return v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Landroid/view/ViewGroup;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bodyContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)I
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselIndex:I

    return v0
.end method

.method static synthetic access$802(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;I)I
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p1, "x1"    # I

    .prologue
    .line 69
    iput p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselIndex:I

    return p1
.end method

.method static synthetic access$900(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/utils/AppLauncher;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 69
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->appLauncher:Lcom/comcast/cim/utils/AppLauncher;

    return-object v0
.end method

.method private displayLiveFeaturedContent()V
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 517
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v1

    if-nez v1, :cond_0

    .line 518
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/PagerContainer;->setVisibility(I)V

    .line 570
    :goto_0
    return-void

    .line 521
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

    invoke-virtual {v1, v3}, Lcom/xfinity/playerlib/view/PagerContainer;->setVisibility(I)V

    .line 524
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselAdapter:Landroid/support/v4/view/PagerAdapter;

    check-cast v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$HalLiveFeaturedContentContainer;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;

    invoke-interface {v1, v2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$HalLiveFeaturedContentContainer;->setLiveFeaturedContentList(Ljava/util/List;)V

    .line 525
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselAdapter:Landroid/support/v4/view/PagerAdapter;

    invoke-virtual {v1}, Landroid/support/v4/view/PagerAdapter;->notifyDataSetChanged()V

    .line 527
    iget v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselCurrentItem:I

    const/4 v2, -0x1

    if-ne v1, v2, :cond_1

    .line 528
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselAdapter:Landroid/support/v4/view/PagerAdapter;

    invoke-virtual {v1}, Landroid/support/v4/view/PagerAdapter;->getCount()I

    move-result v1

    div-int/lit8 v1, v1, 0x2

    iput v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselCurrentItem:I

    .line 531
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    iget v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselCurrentItem:I

    invoke-virtual {v1, v2, v3}, Landroid/support/v4/view/ViewPager;->setCurrentItem(IZ)V

    .line 533
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    iput v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselIndex:I

    .line 535
    sget v1, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v2, 0x13

    if-lt v1, v2, :cond_2

    .line 542
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getViewTreeObserver()Landroid/view/ViewTreeObserver;

    move-result-object v0

    .line 543
    .local v0, "viewTreeObserver":Landroid/view/ViewTreeObserver;
    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;

    invoke-direct {v1, p0, v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$7;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Landroid/view/ViewTreeObserver;)V

    invoke-virtual {v0, v1}, Landroid/view/ViewTreeObserver;->addOnGlobalLayoutListener(Landroid/view/ViewTreeObserver$OnGlobalLayoutListener;)V

    .line 569
    .end local v0    # "viewTreeObserver":Landroid/view/ViewTreeObserver;
    :cond_2
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getWrappedAdapter()Landroid/widget/ListAdapter;

    move-result-object v1

    check-cast v1, Landroid/widget/BaseAdapter;

    invoke-virtual {v1}, Landroid/widget/BaseAdapter;->notifyDataSetChanged()V

    goto :goto_0
.end method

.method private displayLiveStreams()V
    .locals 5

    .prologue
    .line 495
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayNowUserManager;->getUserSettings()Lcom/comcast/cim/model/user/service/UserSettings;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/user/PlayerUserSettings;->getWantsAdultContent()Z

    move-result v3

    if-nez v3, :cond_1

    .line 496
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreams:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 497
    .local v1, "iter":Ljava/util/Iterator;
    :cond_0
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 498
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .line 499
    .local v2, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->isAdultContent()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 500
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    goto :goto_0

    .line 505
    .end local v1    # "iter":Ljava/util/Iterator;
    .end local v2    # "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    :cond_1
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->getWrappedAdapter()Landroid/widget/ListAdapter;

    move-result-object v3

    invoke-static {v3}, Lcom/comcast/cim/cmasl/utils/CommonUtils;->uncheckedCast(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;

    .line 506
    .local v0, "adapter":Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreams:Ljava/util/List;

    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;->setEntities(Ljava/util/List;)V

    .line 508
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFinished()V

    .line 509
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->update()V

    .line 511
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->gridState:Landroid/os/Parcelable;

    if-eqz v3, :cond_2

    .line 512
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->gridState:Landroid/os/Parcelable;

    invoke-virtual {v3, v4}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    .line 514
    :cond_2
    return-void
.end method

.method private initFeaturedCarousel()V
    .locals 10

    .prologue
    const/4 v9, 0x0

    .line 280
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->live_featured_carousel_image_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 281
    .local v4, "coverArtWidth":I
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->live_featured_carousel_image_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    .line 284
    .local v5, "coverArtHeight":I
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x10

    if-gt v0, v1, :cond_4

    .line 285
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 287
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

    const/4 v1, 0x1

    const/4 v2, 0x0

    invoke-virtual {v0, v1, v2}, Lcom/xfinity/playerlib/view/PagerContainer;->setLayerType(ILandroid/graphics/Paint;)V

    .line 290
    :cond_0
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;

    invoke-direct/range {v0 .. v5}, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselPagerAdapter;-><init>(Landroid/app/Activity;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Ljava/util/List;II)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselAdapter:Landroid/support/v4/view/PagerAdapter;

    .line 295
    :goto_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    if-nez v0, :cond_1

    .line 296
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getView()Landroid/view/View;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->carousel_pager:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    .line 299
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselAdapter:Landroid/support/v4/view/PagerAdapter;

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setAdapter(Landroid/support/v4/view/PagerAdapter;)V

    .line 300
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    const/4 v1, 0x4

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOffscreenPageLimit(I)V

    .line 301
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0, v9}, Landroid/support/v4/view/ViewPager;->setClipChildren(Z)V

    .line 303
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v0}, Landroid/support/v4/view/ViewPager;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v8

    .line 304
    .local v8, "params":Landroid/view/ViewGroup$LayoutParams;
    iget v0, v8, Landroid/view/ViewGroup$LayoutParams;->width:I

    const/4 v1, -0x1

    if-ne v0, v1, :cond_2

    .line 305
    new-instance v7, Landroid/util/DisplayMetrics;

    invoke-direct {v7}, Landroid/util/DisplayMetrics;-><init>()V

    .line 306
    .local v7, "metrics":Landroid/util/DisplayMetrics;
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0, v7}, Landroid/view/Display;->getRealMetrics(Landroid/util/DisplayMetrics;)V

    .line 311
    iget v0, v7, Landroid/util/DisplayMetrics;->widthPixels:I

    div-int/lit8 v6, v0, 0x2

    .line 312
    .local v6, "imageHeight":I
    int-to-double v0, v6

    const-wide/high16 v2, 0x3fe8000000000000L    # 0.75

    div-double/2addr v0, v2

    double-to-int v0, v0

    iput v0, v8, Landroid/view/ViewGroup$LayoutParams;->height:I

    .line 315
    .end local v6    # "imageHeight":I
    .end local v7    # "metrics":Landroid/util/DisplayMetrics;
    :cond_2
    sget v0, Landroid/os/Build$VERSION;->SDK_INT:I

    const/16 v1, 0x13

    if-lt v0, v1, :cond_3

    .line 316
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->pageTransformer:Lcom/xfinity/playerlib/view/DimmingPageTransformer;

    invoke-virtual {v0, v9, v1}, Landroid/support/v4/view/ViewPager;->setPageTransformer(ZLandroid/support/v4/view/ViewPager$PageTransformer;)V

    .line 319
    :cond_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$4;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnTouchListener(Landroid/view/View$OnTouchListener;)V

    .line 422
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$5;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    invoke-virtual {v0, v1}, Landroid/support/v4/view/ViewPager;->setOnPageChangeListener(Landroid/support/v4/view/ViewPager$OnPageChangeListener;)V

    .line 440
    return-void

    .line 292
    .end local v8    # "params":Landroid/view/ViewGroup$LayoutParams;
    :cond_4
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveFeaturedContentList:Ljava/util/List;

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/xfinity/playerlib/view/browseprograms/LiveFeaturedCarouselAdapter;-><init>(Landroid/app/FragmentManager;Ljava/util/List;II)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselAdapter:Landroid/support/v4/view/PagerAdapter;

    goto :goto_0
.end method

.method private isInBabyGuide()Z
    .locals 1

    .prologue
    .line 626
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->inTabletBabyGuide:Z

    if-nez v0, :cond_0

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity;

    if-eqz v0, :cond_1

    :cond_0
    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private launchLiveStream(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V
    .locals 9
    .param p1, "liveStream"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    .param p2, "eventId"    # Ljava/lang/String;

    .prologue
    .line 590
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v6

    if-nez v6, :cond_1

    .line 591
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 592
    .local v0, "args":Landroid/os/Bundle;
    const-string v6, "title"

    sget v7, Lcom/xfinity/playerlib/R$string;->unavailable:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 593
    const-string v6, "description"

    sget v7, Lcom/xfinity/playerlib/R$string;->error_stream_not_available_text:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v0, v6, v7}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 595
    const-string v6, "inputPromptDlg"

    invoke-static {v6}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v2

    .line 596
    .local v2, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v2, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 598
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 599
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v6, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    sget v7, Lcom/xfinity/playerlib/R$string;->dlg_btn_ok:I

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getString(I)Ljava/lang/String;

    move-result-object v7

    new-instance v8, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$8;

    invoke-direct {v8, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$8;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    invoke-direct {v6, v7, v8}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v6}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 606
    invoke-virtual {v2, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 607
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->onDismissListener:Landroid/content/DialogInterface$OnDismissListener;

    invoke-virtual {v2, v6}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setOnDismissListener(Landroid/content/DialogInterface$OnDismissListener;)V

    .line 608
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v6

    const-string v7, "caldialogfragment"

    invoke-virtual {v2, v6, v7}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 623
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    .end local v2    # "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :goto_0
    return-void

    .line 610
    :cond_1
    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v4

    .line 611
    .local v4, "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {v4}, Ljava/util/List;->size()I

    move-result v6

    new-array v6, v6, [Ljava/lang/String;

    invoke-interface {v4, v6}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v6

    check-cast v6, [Ljava/lang/String;

    invoke-virtual {v7, v6}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v6

    if-eqz v6, :cond_3

    .line 612
    if-nez p2, :cond_2

    .line 613
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamClickListener:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;

    invoke-interface {v6, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;->onLiveStreamClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    goto :goto_0

    .line 615
    :cond_2
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamClickListener:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;

    invoke-interface {v6, p1, p2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;->onLiveEventClick(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;Ljava/lang/String;)V

    goto :goto_0

    .line 618
    :cond_3
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v3

    .line 619
    .local v3, "fm":Landroid/app/FragmentManager;
    sget-object v6, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-static {v6, p1}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v5

    .line 620
    .local v5, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v6, "upsell_dialog"

    invoke-virtual {v5, v3, v6}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private transformCarouselItems()V
    .locals 9

    .prologue
    .line 574
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v6}, Landroid/support/v4/view/ViewPager;->getScrollX()I

    move-result v4

    .line 575
    .local v4, "scrollX":I
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v6}, Landroid/support/v4/view/ViewPager;->getChildCount()I

    move-result v1

    .line 576
    .local v1, "childCount":I
    const/4 v2, 0x0

    .local v2, "i":I
    :goto_0
    if-ge v2, v1, :cond_1

    .line 577
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v6, v2}, Landroid/support/v4/view/ViewPager;->getChildAt(I)Landroid/view/View;

    move-result-object v0

    .line 578
    .local v0, "child":Landroid/view/View;
    invoke-virtual {v0}, Landroid/view/View;->getLayoutParams()Landroid/view/ViewGroup$LayoutParams;

    move-result-object v3

    check-cast v3, Landroid/support/v4/view/ViewPager$LayoutParams;

    .line 580
    .local v3, "lp":Landroid/support/v4/view/ViewPager$LayoutParams;
    iget-boolean v6, v3, Landroid/support/v4/view/ViewPager$LayoutParams;->isDecor:Z

    if-eqz v6, :cond_0

    .line 576
    :goto_1
    add-int/lit8 v2, v2, 0x1

    goto :goto_0

    .line 584
    :cond_0
    invoke-virtual {v0}, Landroid/view/View;->getLeft()I

    move-result v6

    sub-int/2addr v6, v4

    int-to-float v6, v6

    iget-object v7, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v7}, Landroid/support/v4/view/ViewPager;->getMeasuredWidth()I

    move-result v7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v8}, Landroid/support/v4/view/ViewPager;->getPaddingLeft()I

    move-result v8

    sub-int/2addr v7, v8

    iget-object v8, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v8}, Landroid/support/v4/view/ViewPager;->getPaddingRight()I

    move-result v8

    sub-int/2addr v7, v8

    int-to-float v7, v7

    div-float v5, v6, v7

    .line 585
    .local v5, "transformPos":F
    iget-object v6, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->pageTransformer:Lcom/xfinity/playerlib/view/DimmingPageTransformer;

    invoke-virtual {v6, v0, v5}, Lcom/xfinity/playerlib/view/DimmingPageTransformer;->transformPage(Landroid/view/View;F)V

    goto :goto_1

    .line 587
    .end local v0    # "child":Landroid/view/View;
    .end local v3    # "lp":Landroid/support/v4/view/ViewPager$LayoutParams;
    .end local v5    # "transformPos":F
    :cond_1
    return-void
.end method


# virtual methods
.method protected getLayoutId()I
    .locals 1

    .prologue
    .line 456
    sget v0, Lcom/xfinity/playerlib/R$layout;->browse_live_streams:I

    return v0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;>;>;"
        }
    .end annotation

    .prologue
    .line 468
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-nez v0, :cond_0

    .line 469
    new-instance v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 491
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;>;>;"
        }
    .end annotation

    .prologue
    .line 460
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-nez v0, :cond_0

    .line 461
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 464
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 444
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 445
    check-cast v0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamClickListener:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamOnClickListener;

    .line 446
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 447
    return-void
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 162
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onCreate(Landroid/os/Bundle;)V

    .line 164
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-virtual {v3}, Landroid/app/Activity;->getActionBar()Landroid/app/ActionBar;

    move-result-object v0

    .line 165
    .local v0, "actionBar":Landroid/app/ActionBar;
    if-eqz v0, :cond_0

    .line 166
    invoke-virtual {v0}, Landroid/app/ActionBar;->getCustomView()Landroid/view/View;

    move-result-object v1

    .line 167
    .local v1, "actionBarLayout":Landroid/view/View;
    sget v3, Lcom/xfinity/playerlib/R$id;->xod:I

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/widget/ImageView;

    .line 168
    .local v2, "actionBarLogo":Landroid/widget/ImageView;
    if-eqz v2, :cond_0

    .line 169
    const/16 v3, 0x8

    invoke-virtual {v2, v3}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 173
    .end local v1    # "actionBarLayout":Landroid/view/View;
    .end local v2    # "actionBarLogo":Landroid/widget/ImageView;
    :cond_0
    if-eqz p1, :cond_1

    .line 174
    const-string v3, "carouselCurrentItem"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v3

    iput v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselCurrentItem:I

    .line 175
    const-string v3, "gridState"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    iput-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->gridState:Landroid/os/Parcelable;

    .line 177
    :cond_1
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 11
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    const/4 v1, 0x0

    .line 202
    sget v0, Lcom/xfinity/playerlib/R$layout;->browse_live_streams:I

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v9

    check-cast v9, Landroid/view/ViewGroup;

    .line 204
    .local v9, "layout":Landroid/view/ViewGroup;
    sget v0, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v9, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/view/ViewGroup;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bodyContainer:Landroid/view/ViewGroup;

    .line 205
    sget v0, Lcom/xfinity/playerlib/R$layout;->live_featured_carousel:I

    const/4 v2, 0x0

    invoke-virtual {p1, v0, v2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/view/PagerContainer;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

    .line 206
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

    sget v2, Lcom/xfinity/playerlib/R$id;->carousel_pager:I

    invoke-virtual {v0, v2}, Lcom/xfinity/playerlib/view/PagerContainer;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/support/v4/view/ViewPager;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    .line 207
    sget v0, Lcom/xfinity/playerlib/R$id;->list_view:I

    invoke-virtual {v9, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    .line 209
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarouselContainer:Lcom/xfinity/playerlib/view/PagerContainer;

    invoke-virtual {v0, v2}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->addHeaderView(Landroid/view/View;)V

    .line 211
    if-eqz p3, :cond_0

    .line 212
    const-string v0, "carouselCurrentItem"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->carouselCurrentItem:I

    .line 213
    const-string v0, "gridState"

    invoke-virtual {p3, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->gridState:Landroid/os/Parcelable;

    .line 216
    :cond_0
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->initFeaturedCarousel()V

    .line 218
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    if-eqz v0, :cond_1

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "numColumns"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 219
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v0

    const-string v2, "numColumns"

    invoke-virtual {v0, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v8

    .line 220
    .local v8, "gridNumOfColumns":I
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v0, v8}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setNumColumns(I)V

    .line 223
    .end local v8    # "gridNumOfColumns":I
    :cond_1
    sget v0, Lcom/xfinity/playerlib/R$id;->top_scrolling_shadow:I

    invoke-virtual {v9, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v10

    .line 224
    .local v10, "scrollingShadow":Landroid/view/View;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v0, v10}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setScrollingShadow(Landroid/view/View;)V

    .line 226
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getArguments()Landroid/os/Bundle;

    move-result-object v6

    .line 227
    .local v6, "args":Landroid/os/Bundle;
    if-eqz v6, :cond_3

    const-string v0, "inBabyGuide"

    invoke-virtual {v6, v0, v1}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v0

    if-eqz v0, :cond_3

    const/4 v0, 0x1

    :goto_0
    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->inTabletBabyGuide:Z

    .line 228
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->inTabletBabyGuide:Z

    if-eqz v0, :cond_4

    .line 229
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->babyguide_live_stream_poster_art_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageWidth:I

    .line 230
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->baby_guide_panel_size:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v1}, Landroid/view/View;->getPaddingLeft()I

    move-result v1

    sub-int/2addr v0, v1

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v1}, Landroid/view/View;->getPaddingRight()I

    move-result v1

    sub-int/2addr v0, v1

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I

    .line 233
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageWidth:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageHeight:I

    .line 234
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewHeight:I

    .line 248
    :goto_1
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    iget v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setColumnWidth(I)V

    .line 249
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;

    invoke-direct {v1, p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$LiveStreamAdapter;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Landroid/view/LayoutInflater;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->initialize(Landroid/widget/ListAdapter;)V

    .line 250
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamClickedListener;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamClickedListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setOnItemClickListener(Landroid/widget/AdapterView$OnItemClickListener;)V

    .line 255
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->inTabletBabyGuide:Z

    if-nez v0, :cond_2

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    instance-of v0, v0, Lcom/xfinity/playerlib/view/browseprograms/BabyGuideLiveStreamsActivity;

    if-nez v0, :cond_2

    .line 256
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    new-instance v1, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;

    invoke-direct {v1, p0, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$OnLiveStreamLongClickedListener;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setOnItemLongClickListener(Landroid/widget/AdapterView$OnItemLongClickListener;)V

    .line 259
    :cond_2
    const v0, 0x1020004

    invoke-virtual {v9, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v7

    .line 260
    .local v7, "emptyView":Landroid/view/View;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v0, v7}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setEmptyView(Landroid/view/View;)V

    .line 262
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v1, Lcom/xfinity/playerlib/tracking/PlayNowTab;->LIVE:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V

    .line 263
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    sget v1, Lcom/xfinity/playerlib/R$string;->live:I

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getString(I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 265
    sget v0, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {v9, v0}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    .line 266
    .local v3, "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->bodyContainer:Landroid/view/ViewGroup;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    new-instance v5, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;-><init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    .line 276
    return-object v9

    .end local v3    # "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    .end local v7    # "emptyView":Landroid/view/View;
    :cond_3
    move v0, v1

    .line 227
    goto/16 :goto_0

    .line 236
    :cond_4
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->live_stream_poster_art_width:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageWidth:I

    .line 237
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$dimen;->live_stream_poster_art_height:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageHeight:I

    .line 239
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_5

    .line 240
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageWidth:I

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I

    .line 241
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageHeight:I

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewHeight:I

    goto/16 :goto_1

    .line 243
    :cond_5
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    invoke-virtual {v0}, Landroid/app/Activity;->getWindowManager()Landroid/view/WindowManager;

    move-result-object v0

    invoke-interface {v0}, Landroid/view/WindowManager;->getDefaultDisplay()Landroid/view/Display;

    move-result-object v0

    invoke-virtual {v0}, Landroid/view/Display;->getWidth()I

    move-result v0

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I

    .line 244
    iget v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewWidth:I

    div-int/lit8 v0, v0, 0x2

    iput v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->imageViewHeight:I

    goto/16 :goto_1
.end method

.method public onSaveInstanceState(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 451
    const-string v0, "carouselCurrentItem"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredCarousel:Landroid/support/v4/view/ViewPager;

    invoke-virtual {v1}, Landroid/support/v4/view/ViewPager;->getCurrentItem()I

    move-result v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 452
    const-string v0, "gridState"

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->entityGridView:Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;

    invoke-virtual {v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/EntityGridView;->onSaveInstanceState()Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {p1, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 453
    return-void
.end method

.method public onStartInternal()V
    .locals 1

    .prologue
    .line 181
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStartInternal()V

    .line 182
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStart()V

    .line 183
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 187
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStop()V

    .line 189
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStop()V

    .line 191
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-eqz v0, :cond_0

    .line 192
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 195
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_1

    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-eqz v0, :cond_1

    .line 196
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 198
    :cond_1
    return-void
.end method
