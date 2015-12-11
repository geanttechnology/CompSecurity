.class public abstract Lcom/xfinity/playerlib/view/featured/FeaturedFragment;
.super Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;
.source "FeaturedFragment.java"


# static fields
.field private static final LOG:Lorg/slf4j/Logger;

.field protected static final premiumNetworks:Ljava/util/Map;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/Map",
            "<",
            "Ljava/lang/Long;",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field protected final bookmarkFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;"
        }
    .end annotation
.end field

.field protected bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

.field protected final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field protected featuredResource:Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

.field protected fetchListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;>;"
        }
    .end annotation
.end field

.field protected firstTimeLoadStarted:Z

.field private final internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

.field protected layoutInflator:Landroid/view/LayoutInflater;

.field protected liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field private loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

.field protected final networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

.field protected programProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field protected provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;>;"
        }
    .end annotation
.end field

.field protected tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

.field protected trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field protected userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

.field protected videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

.field protected videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;


# direct methods
.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 50
    const-class v0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    invoke-static {v0}, Lorg/slf4j/LoggerFactory;->getLogger(Ljava/lang/Class;)Lorg/slf4j/Logger;

    move-result-object v0

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->LOG:Lorg/slf4j/Logger;

    .line 58
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    sput-object v0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->premiumNetworks:Ljava/util/Map;

    return-void
.end method

.method public constructor <init>()V
    .locals 6

    .prologue
    const/4 v5, 0x0

    .line 48
    invoke-direct {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;-><init>()V

    .line 55
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 60
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    .line 61
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 62
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUserManager()Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->userManager:Lcom/xfinity/playerlib/model/user/PlayNowUserManager;

    .line 63
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->bookmarkUtils:Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    .line 64
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getInternetConnection()Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    .line 66
    new-instance v0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$1;-><init>(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->bookmarkFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 85
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    .line 86
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    .line 87
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/container/PlayerContainer;->getFeaturedResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    .line 88
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v3

    invoke-virtual {v3}, Lcom/comcast/cim/container/PlayerContainer;->getTagsRootCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->bookmarkFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 86
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 91
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->programProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 93
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createNetworkLogoImageLoader()Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    .line 94
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 100
    new-instance v0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    invoke-direct {v0, v5, v5}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;-><init>(Lcom/xfinity/playerlib/model/editorial/EditorialMovieAndSeriesResource;Lcom/xfinity/playerlib/model/editorial/EditorialVideoCoverResource;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->featuredResource:Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    .line 102
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->firstTimeLoadStarted:Z

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/featured/FeaturedFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    return-object v0
.end method


# virtual methods
.method protected abstract getLayoutId()I
.end method

.method protected getPremiumNetworks(Ljava/util/List;)V
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/tags/Network;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 201
    .local p1, "networks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/tags/Network;>;"
    sget-object v1, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->premiumNetworks:Ljava/util/Map;

    invoke-interface {v1}, Ljava/util/Map;->keySet()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->size()I

    move-result v1

    if-lez v1, :cond_1

    .line 210
    :cond_0
    return-void

    .line 205
    :cond_1
    invoke-interface {p1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_2
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/tags/Network;

    .line 206
    .local v0, "n":Lcom/xfinity/playerlib/model/tags/Network;
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/Network;->isPremium()Z

    move-result v2

    if-eqz v2, :cond_2

    .line 207
    sget-object v2, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->premiumNetworks:Ljava/util/Map;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/tags/Network;->getCompanyId()J

    move-result-wide v4

    invoke-static {v4, v5}, Ljava/lang/Long;->valueOf(J)Ljava/lang/Long;

    move-result-object v3

    invoke-interface {v2, v3, v0}, Ljava/util/Map;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    goto :goto_0
.end method

.method public loadResources()V
    .locals 2

    .prologue
    .line 166
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v1, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$3;-><init>(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->fetchListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 188
    return-void
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 141
    invoke-super {p0, p1}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onAttach(Landroid/app/Activity;)V

    .line 142
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 143
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 7
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 110
    iput-object p1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->layoutInflator:Landroid/view/LayoutInflater;

    .line 112
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->getLayoutId()I

    move-result v0

    const/4 v1, 0x0

    invoke-virtual {p1, v0, p2, v1}, Landroid/view/LayoutInflater;->inflate(ILandroid/view/ViewGroup;Z)Landroid/view/View;

    move-result-object v6

    .line 114
    .local v6, "layout":Landroid/view/View;
    sget v0, Lcom/xfinity/playerlib/R$id;->body_container:I

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v2

    check-cast v2, Landroid/view/ViewGroup;

    .line 115
    .local v2, "bodyContainer":Landroid/view/ViewGroup;
    sget v0, Lcom/xfinity/playerlib/R$id;->loading_indicator:I

    invoke-virtual {v6, v0}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v3

    check-cast v3, Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;

    .line 117
    .local v3, "loadingIndicator":Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;
    new-instance v0, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->getActivity()Landroid/app/Activity;

    move-result-object v1

    iget-object v4, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->internetConnection:Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;

    new-instance v5, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$2;

    invoke-direct {v5, p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment$2;-><init>(Lcom/xfinity/playerlib/view/featured/FeaturedFragment;)V

    invoke-direct/range {v0 .. v5}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;-><init>(Landroid/app/Activity;Landroid/view/ViewGroup;Lcom/comcast/cim/cmasl/android/util/view/widget/LoadingIndicator;Lcom/comcast/cim/cmasl/android/util/system/InternetConnection;Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    .line 124
    return-object v6
.end method

.method public onStartInternal()V
    .locals 1

    .prologue
    .line 147
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStartInternal()V

    .line 148
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStart()V

    .line 149
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 153
    invoke-super {p0}, Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;->onStop()V

    .line 155
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onStop()V

    .line 157
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->fetchListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    if-eqz v0, :cond_0

    .line 158
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->provider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->fetchListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 161
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/image/CoverArtImageLoader;->purgeJobs()V

    .line 162
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->networkLogoLoader:Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/image/NetworkLogoImageLoader;->purgeJobs()V

    .line 163
    return-void
.end method

.method protected abstract postOnResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;)V"
        }
    .end annotation
.end method

.method protected setupResources(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 192
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/editorial/FeaturedResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/comcast/cim/cmasl/utils/container/Option<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;>;"
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 193
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->featuredResource:Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    .line 194
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 196
    iget-object v0, p0, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->tagsRoot:Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    invoke-interface {v0}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworks()Ljava/util/List;

    move-result-object v0

    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->getPremiumNetworks(Ljava/util/List;)V

    .line 197
    return-void
.end method

.method protected showDetail(Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 1
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 128
    const/4 v0, 0x0

    invoke-virtual {p0, p1, v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->showDetail(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 129
    return-void
.end method

.method protected showDetail(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V
    .locals 3
    .param p1, "merlinId"    # Lcom/xfinity/playerlib/model/MerlinId;
    .param p2, "episodeId"    # Lcom/xfinity/playerlib/model/MerlinId;

    .prologue
    .line 131
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    invoke-direct {v1, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;-><init>(Lcom/xfinity/playerlib/model/MerlinId;)V

    const/4 v2, 0x1

    .line 132
    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->showDetail(Z)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v1

    .line 133
    invoke-virtual {v1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->episodeId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;

    move-result-object v1

    .line 134
    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper$Builder;->build()Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;

    move-result-object v1

    .line 135
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->getActivity()Landroid/app/Activity;

    move-result-object v2

    invoke-virtual {v1, v2}, Lcom/xfinity/playerlib/view/programdetails/DetailIntentHelper;->getIntent(Landroid/content/Context;)Landroid/content/Intent;

    move-result-object v0

    .line 136
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/featured/FeaturedFragment;->startActivity(Landroid/content/Intent;)V

    .line 137
    return-void
.end method
