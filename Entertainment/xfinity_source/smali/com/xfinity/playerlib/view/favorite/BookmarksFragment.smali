.class public Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;
.super Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;
.source "BookmarksFragment.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;
    }
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/model/Favorite;",
        ">;>;",
        "Lcom/xfinity/playerlib/model/Favorite;",
        "Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;",
        ">;"
    }
.end annotation


# instance fields
.field private final androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

.field protected final coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

.field private final dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

.field private favoriteListener:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;

.field private liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

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

.field private final providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private final resourceFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;>;>;"
        }
    .end annotation
.end field

.field private final taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;>;>;"
        }
    .end annotation
.end field

.field protected final trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

.field protected uiUtil:Lcom/comcast/cim/utils/UIUtil;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

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


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 43
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;-><init>()V

    .line 46
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getUIUtil()Lcom/comcast/cim/utils/UIUtil;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    .line 47
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getFavoriteDAO()Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    .line 48
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 49
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 50
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 51
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 52
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 53
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getAndroidDevice()Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    .line 55
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$1;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->resourceFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 75
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->providerFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->resourceFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 76
    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 78
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    .line 79
    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->createCoverArtImageLoader()Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    .line 80
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTrackingService()Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    .line 172
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/model/database/FavoriteDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteListener:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .prologue
    .line 43
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->onLiveStreamPlayRequested(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V

    return-void
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;

    .prologue
    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    return-object v0
.end method

.method private onLiveStreamPlayRequested(Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V
    .locals 13
    .param p1, "liveStreamFavorite"    # Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .prologue
    .line 178
    iget-object v8, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-virtual {p1}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->getLiveStream(Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v5

    .line 179
    .local v5, "liveStream":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;
    if-eqz v5, :cond_0

    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getPlaybackLink()Ljava/lang/String;

    move-result-object v8

    if-nez v8, :cond_1

    .line 180
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 181
    .local v0, "args":Landroid/os/Bundle;
    const-string v8, "title"

    sget v9, Lcom/xfinity/playerlib/R$string;->unavailable:I

    invoke-virtual {p0, v9}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v0, v8, v9}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 182
    new-instance v8, Ljava/lang/StringBuilder;

    invoke-direct {v8}, Ljava/lang/StringBuilder;-><init>()V

    sget v9, Lcom/xfinity/playerlib/R$string;->error_stream_not_available_text:I

    invoke-virtual {p0, v9}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    sget v9, Lcom/xfinity/playerlib/R$string;->remove_item_prompt:I

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v12, "bookmarks"

    aput-object v12, v10, v11

    invoke-virtual {p0, v9, v10}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    .line 183
    .local v2, "description":Ljava/lang/String;
    const-string v8, "description"

    invoke-virtual {v0, v8, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 185
    const-string v8, "inputPromptDlg"

    invoke-static {v8}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->newInstance(Ljava/lang/String;)Lcom/comcast/cim/android/view/common/CALDialogFragment;

    move-result-object v3

    .line 186
    .local v3, "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    invoke-virtual {v3, v0}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->addArguments(Landroid/os/Bundle;)V

    .line 188
    new-instance v1, Ljava/util/ArrayList;

    invoke-direct {v1}, Ljava/util/ArrayList;-><init>()V

    .line 189
    .local v1, "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    new-instance v8, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    sget v9, Lcom/xfinity/playerlib/R$string;->dlg_btn_yes:I

    invoke-virtual {p0, v9}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-instance v10, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;

    invoke-direct {v10, p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$3;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V

    invoke-direct {v8, v9, v10}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 198
    new-instance v8, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v9

    sget v10, Lcom/xfinity/playerlib/R$string;->dlg_btn_no:I

    invoke-virtual {v9, v10}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v9

    new-instance v10, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$4;

    invoke-direct {v10, p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$4;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)V

    invoke-direct {v8, v9, v10}, Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;-><init>(Ljava/lang/String;Landroid/content/DialogInterface$OnClickListener;)V

    invoke-interface {v1, v8}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 205
    invoke-virtual {v3, v1}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->setButtonList(Ljava/util/List;)V

    .line 206
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v8

    const-string v9, "caldialogfragment"

    invoke-virtual {v3, v8, v9}, Lcom/comcast/cim/android/view/common/CALDialogFragment;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    .line 223
    .end local v0    # "args":Landroid/os/Bundle;
    .end local v1    # "buttonList":Ljava/util/List;, "Ljava/util/List<Lcom/comcast/cim/android/view/common/CALDialogFragment$CDFButton;>;"
    .end local v2    # "description":Ljava/lang/String;
    .end local v3    # "dialog":Lcom/comcast/cim/android/view/common/CALDialogFragment;
    :goto_0
    return-void

    .line 208
    :cond_1
    invoke-virtual {v5}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;->getProviderCodes()Ljava/util/List;

    move-result-object v6

    .line 210
    .local v6, "providerCodes":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    iget-object v9, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-interface {v6}, Ljava/util/List;->size()I

    move-result v8

    new-array v8, v8, [Ljava/lang/String;

    invoke-interface {v6, v8}, Ljava/util/List;->toArray([Ljava/lang/Object;)[Ljava/lang/Object;

    move-result-object v8

    check-cast v8, [Ljava/lang/String;

    invoke-virtual {v9, v8}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitledToList([Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_2

    .line 211
    iget-object v8, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->uiUtil:Lcom/comcast/cim/utils/UIUtil;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getActivity()Landroid/app/Activity;

    move-result-object v9

    new-instance v10, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$5;

    invoke-direct {v10, p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$5;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;Lcom/xfinity/playerlib/model/LiveStreamFavorite;)V

    invoke-virtual {v8, v9, v10}, Lcom/comcast/cim/utils/UIUtil;->ensureConnectivityBeforeExecuting(Landroid/content/Context;Ljava/lang/Runnable;)V

    goto :goto_0

    .line 218
    :cond_2
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getFragmentManager()Landroid/app/FragmentManager;

    move-result-object v4

    .line 219
    .local v4, "fm":Landroid/app/FragmentManager;
    sget-object v8, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-static {v8, v5}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->newInstance(Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)Lcom/xfinity/playerlib/view/common/UpsellDialog;

    move-result-object v7

    .line 220
    .local v7, "upsellDialog":Lcom/xfinity/playerlib/view/common/UpsellDialog;
    const-string v8, "upsell_dialog"

    invoke-virtual {v7, v4, v8}, Lcom/xfinity/playerlib/view/common/UpsellDialog;->show(Landroid/app/FragmentManager;Ljava/lang/String;)V

    goto :goto_0
.end method


# virtual methods
.method protected bridge synthetic createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;
    .locals 1

    .prologue
    .line 43
    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    move-result-object v0

    return-object v0
.end method

.method protected createAdapter(Landroid/view/LayoutInflater;)Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;
    .locals 3
    .param p1, "inflator"    # Landroid/view/LayoutInflater;

    .prologue
    .line 149
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->coverArtImageLoader:Lcom/xfinity/playerlib/image/CoverArtImageLoader;

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->inBabyGuideMode:Z

    invoke-direct {v0, p1, v1, v2}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;-><init>(Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/image/CoverArtImageLoader;Z)V

    return-object v0
.end method

.method protected deleteItem(Lcom/xfinity/playerlib/model/Favorite;)V
    .locals 3
    .param p1, "item"    # Lcom/xfinity/playerlib/model/Favorite;

    .prologue
    .line 164
    instance-of v1, p1, Lcom/xfinity/playerlib/model/VideoFavorite;

    if-eqz v1, :cond_0

    .line 165
    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    check-cast p1, Lcom/xfinity/playerlib/model/VideoFavorite;

    .end local p1    # "item":Lcom/xfinity/playerlib/model/Favorite;
    invoke-virtual {v1, p1}, Lcom/xfinity/playerlib/model/database/FavoriteDAO;->deleteFavorite(Lcom/xfinity/playerlib/model/VideoFavorite;)Z

    .line 170
    :goto_0
    return-void

    .restart local p1    # "item":Lcom/xfinity/playerlib/model/Favorite;
    :cond_0
    move-object v0, p1

    .line 167
    check-cast v0, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .line 168
    .local v0, "liveStreamFavorite":Lcom/xfinity/playerlib/model/LiveStreamFavorite;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->deleteFavorite(Ljava/lang/String;)Z

    goto :goto_0
.end method

.method protected bridge synthetic deleteItem(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/xfinity/playerlib/model/Favorite;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->deleteItem(Lcom/xfinity/playerlib/model/Favorite;)V

    return-void
.end method

.method protected getData(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)Ljava/util/List;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;>;)",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;"
        }
    .end annotation

    .prologue
    .line 154
    .local p1, "data":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;>;"
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v0, Ljava/util/List;

    return-object v0
.end method

.method protected bridge synthetic getData(Ljava/lang/Object;)Ljava/util/List;
    .locals 1

    .prologue
    .line 43
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getData(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)Ljava/util/List;

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
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;>;>;"
        }
    .end annotation

    .prologue
    .line 122
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method protected getItemClickListener()Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener;
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment$ItemClickListener",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;"
        }
    .end annotation

    .prologue
    .line 135
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$2;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$2;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;)V

    return-object v0
.end method

.method protected getListHeaderText()Ljava/lang/CharSequence;
    .locals 2

    .prologue
    .line 117
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->favorite:I

    invoke-virtual {v0, v1}, Landroid/content/res/Resources;->getString(I)Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method

.method protected getListViewId()I
    .locals 1

    .prologue
    .line 159
    sget v0, Lcom/xfinity/playerlib/R$id;->bookmarks_grid:I

    return v0
.end method

.method protected getViewLayoutId()I
    .locals 1

    .prologue
    .line 108
    iget-boolean v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->inBabyGuideMode:Z

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 109
    sget v0, Lcom/xfinity/playerlib/R$layout;->bookmarks_babyguide:I

    .line 112
    :goto_0
    return v0

    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$layout;->bookmarks:I

    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 102
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onAttach(Landroid/app/Activity;)V

    .line 103
    check-cast p1, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->favoriteListener:Lcom/xfinity/playerlib/view/favorite/BookmarksFragment$FavoriteListener;

    .line 104
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 5
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 86
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v1

    .line 87
    .local v1, "layout":Landroid/view/View;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->trackingService:Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;

    sget-object v4, Lcom/xfinity/playerlib/tracking/PlayNowTab;->BOOKMARKS:Lcom/xfinity/playerlib/tracking/PlayNowTab;

    invoke-virtual {v3, v4}, Lcom/xfinity/playerlib/tracking/PlayNowTrackingService;->trackTabRendered(Lcom/xfinity/playerlib/tracking/PlayNowTab;)V

    .line 89
    const/4 v2, 0x1

    .line 90
    .local v2, "numColumns":I
    iget-object v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->androidDevice:Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;

    invoke-virtual {v3}, Lcom/comcast/cim/cmasl/android/util/system/AndroidDevice;->isTabletDevice()Z

    move-result v3

    if-eqz v3, :cond_0

    iget-boolean v3, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->inBabyGuideMode:Z

    if-nez v3, :cond_0

    .line 91
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v3

    sget v4, Lcom/xfinity/playerlib/R$integer;->browse_grid_columns:I

    invoke-virtual {v3, v4}, Landroid/content/res/Resources;->getInteger(I)I

    move-result v2

    .line 94
    :cond_0
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->getListViewId()I

    move-result v3

    invoke-virtual {v1, v3}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v0

    check-cast v0, Landroid/widget/GridView;

    .line 95
    .local v0, "grid":Landroid/widget/GridView;
    invoke-virtual {v0, v2}, Landroid/widget/GridView;->setNumColumns(I)V

    .line 97
    return-object v1
.end method

.method protected onResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 127
    .local p1, "data":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    check-cast v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->setDibicResource(Lcom/xfinity/playerlib/model/dibic/DibicResource;)V

    .line 128
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    check-cast v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->setVideoEntitlement(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 129
    iget-object v0, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->adapter:Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseAdapter;

    check-cast v0, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarksAdapter;->setLiveStreamResource(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;)V

    .line 130
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v0, Ljava/util/List;

    invoke-super {p0, v0}, Lcom/xfinity/playerlib/view/browsehistory/MultiDeleteBrowseFragment;->setData(Ljava/util/List;)V

    .line 131
    return-void
.end method

.method protected bridge synthetic onResourceFetched(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 43
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/favorite/BookmarksFragment;->onResourceFetched(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    return-void
.end method
