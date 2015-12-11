.class public Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;
.super Lcom/xfinity/playerlib/view/programdetails/DetailFragment;
.source "MovieDetailFragment.java"


# instance fields
.field private alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

.field private availability:Landroid/widget/TextView;

.field private bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;>;"
        }
    .end annotation
.end field

.field protected bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

.field private bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;>;"
        }
    .end annotation
.end field

.field private castText:Landroid/widget/TextView;

.field private descriptionText:Landroid/widget/TextView;

.field private detailArtView:Landroid/widget/ImageView;

.field private dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;"
        }
    .end annotation
.end field

.field private duration:Landroid/widget/TextView;

.field private errorText:Landroid/widget/TextView;

.field private favoriteIndicator:Landroid/widget/CheckBox;

.field private infoTitle:Landroid/widget/TextView;

.field private layoutInflator:Landroid/view/LayoutInflater;

.field private movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
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

.field private movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

.field private movieFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

.field private newIndicator:Landroid/view/View;

.field private newReleaseYearContainer:Landroid/view/ViewGroup;

.field private releaseYearText:Landroid/widget/TextView;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
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
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

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

.field private videoItemContainer:Landroid/view/ViewGroup;


# direct methods
.method public constructor <init>()V
    .locals 2

    .prologue
    .line 48
    invoke-direct {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;-><init>()V

    .line 50
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    .line 51
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 52
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 53
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getMovieCacheMap()Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    .line 54
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 79
    new-instance v0, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getBookmarkUtils()Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;

    move-result-object v1

    invoke-direct {v0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;-><init>(Lcom/xfinity/playerlib/view/favorite/BookmarkUtils;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    return-object v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    return-object v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Landroid/widget/TextView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->errorText:Landroid/widget/TextView;

    return-object v0
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Landroid/widget/ImageView;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->detailArtView:Landroid/widget/ImageView;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/xfinity/playerlib/model/consumable/MovieFacade;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    return-object v0
.end method

.method static synthetic access$402(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;Lcom/xfinity/playerlib/model/consumable/MovieFacade;)Lcom/xfinity/playerlib/model/consumable/MovieFacade;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    return-object p1
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method static synthetic access$502(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object p1
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    return-object v0
.end method

.method static synthetic access$702(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;
    .param p1, "x1"    # Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .prologue
    .line 48
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object p1
.end method

.method static synthetic access$800(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lorg/slf4j/Logger;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 48
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->LOG:Lorg/slf4j/Logger;

    return-object v0
.end method


# virtual methods
.method public getDetailLayoutId()I
    .locals 1

    .prologue
    .line 321
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->showPanelFittedLayout:Z

    if-eqz v0, :cond_0

    .line 322
    sget v0, Lcom/xfinity/playerlib/R$layout;->movie_detail:I

    .line 324
    :goto_0
    return v0

    :cond_0
    sget v0, Lcom/xfinity/playerlib/R$layout;->layout_movie_entity_view:I

    goto :goto_0
.end method

.method public getVideoItemViewContainer()Landroid/view/ViewGroup;
    .locals 1

    .prologue
    .line 330
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->videoItemContainer:Landroid/view/ViewGroup;

    return-object v0
.end method

.method public loadScreenInfo()V
    .locals 4

    .prologue
    .line 156
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->useDownloadAsSource()Z

    move-result v1

    if-eqz v1, :cond_0

    .line 157
    new-instance v0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)V

    .line 174
    .local v0, "movieCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;"
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->dibicResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-virtual {v1, v2, v0, v3}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 176
    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)V

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 237
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 238
    return-void

    .line 172
    .end local v0    # "movieCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;"
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieCacheMap:Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v2, v2, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->merlinId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/task/TaskFactory;->get(Ljava/lang/Object;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    .restart local v0    # "movieCache":Lcom/comcast/cim/cmasl/taskexecutor/task/Task;, "Lcom/comcast/cim/cmasl/taskexecutor/task/Task<Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;>;"
    goto :goto_0
.end method

.method public onAttach(Landroid/app/Activity;)V
    .locals 1
    .param p1, "activity"    # Landroid/app/Activity;

    .prologue
    .line 87
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onAttach(Landroid/app/Activity;)V

    move-object v0, p1

    .line 89
    check-cast v0, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    iput-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    .line 90
    check-cast p1, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .end local p1    # "activity":Landroid/app/Activity;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    .line 91
    return-void
.end method

.method public onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V
    .locals 1
    .param p1, "menu"    # Landroid/view/Menu;
    .param p2, "inflator"    # Landroid/view/MenuInflater;

    .prologue
    .line 145
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 146
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    invoke-virtual {v0, p1, p2}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->onCreateOptionsMenu(Landroid/view/Menu;Landroid/view/MenuInflater;)V

    .line 147
    return-void
.end method

.method public onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
    .locals 3
    .param p1, "inflater"    # Landroid/view/LayoutInflater;
    .param p2, "container"    # Landroid/view/ViewGroup;
    .param p3, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 95
    invoke-super {p0, p1, p2, p3}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;

    move-result-object v0

    .line 97
    .local v0, "view":Landroid/view/View;
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->layoutInflator:Landroid/view/LayoutInflater;

    .line 98
    sget v1, Lcom/xfinity/playerlib/R$id;->detail_image:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/ImageView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->detailArtView:Landroid/widget/ImageView;

    .line 99
    sget v1, Lcom/xfinity/playerlib/R$id;->info_title:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->infoTitle:Landroid/widget/TextView;

    .line 101
    sget v1, Lcom/xfinity/playerlib/R$id;->new_release_year_container:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/view/ViewGroup;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newReleaseYearContainer:Landroid/view/ViewGroup;

    .line 102
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newReleaseYearContainer:Landroid/view/ViewGroup;

    sget v2, Lcom/xfinity/playerlib/R$id;->new_indicator:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newIndicator:Landroid/view/View;

    .line 103
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newReleaseYearContainer:Landroid/view/ViewGroup;

    sget v2, Lcom/xfinity/playerlib/R$id;->release_year:I

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->releaseYearText:Landroid/widget/TextView;

    .line 104
    sget v1, Lcom/xfinity/playerlib/R$id;->availability:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->availability:Landroid/widget/TextView;

    .line 105
    sget v1, Lcom/xfinity/playerlib/R$id;->duration:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->duration:Landroid/widget/TextView;

    .line 106
    sget v1, Lcom/xfinity/playerlib/R$id;->video_item_container:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/LinearLayout;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->videoItemContainer:Landroid/view/ViewGroup;

    .line 107
    sget v1, Lcom/xfinity/playerlib/R$id;->cast:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->castText:Landroid/widget/TextView;

    .line 108
    sget v1, Lcom/xfinity/playerlib/R$id;->description:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->descriptionText:Landroid/widget/TextView;

    .line 109
    sget v1, Lcom/xfinity/playerlib/R$id;->favorite_indicator:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/CheckBox;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->favoriteIndicator:Landroid/widget/CheckBox;

    .line 111
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->setupReviews(Landroid/view/View;)V

    .line 113
    sget v1, Lcom/xfinity/playerlib/R$id;->movie_detail_error_text:I

    invoke-virtual {v0, v1}, Landroid/view/View;->findViewById(I)Landroid/view/View;

    move-result-object v1

    check-cast v1, Landroid/widget/TextView;

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->errorText:Landroid/widget/TextView;

    .line 115
    iget-boolean v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->isFullScreen:Z

    if-eqz v1, :cond_0

    .line 116
    const/4 v1, 0x1

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->setHasOptionsMenu(Z)V

    .line 119
    :cond_0
    return-object v0
.end method

.method public onOptionsItemSelected(Landroid/view/MenuItem;)Z
    .locals 2
    .param p1, "item"    # Landroid/view/MenuItem;

    .prologue
    .line 151
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    invoke-virtual {v0, p1, p0, v1}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->onOptionsItemSelected(Landroid/view/MenuItem;Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)Z

    move-result v0

    return v0
.end method

.method public onPause()V
    .locals 2

    .prologue
    .line 310
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onPause()V

    .line 311
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 312
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 314
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_1

    .line 315
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 317
    :cond_1
    return-void
.end method

.method public onStartInternal()V
    .locals 2

    .prologue
    .line 124
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onStartInternal()V

    .line 127
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->errorText:Landroid/widget/TextView;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 128
    return-void
.end method

.method public onStop()V
    .locals 2

    .prologue
    .line 132
    invoke-super {p0}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->onStop()V

    .line 134
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_0

    .line 135
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 138
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    if-eqz v0, :cond_1

    .line 139
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 141
    :cond_1
    return-void
.end method

.method public presentConsumableMovie(Ljava/util/Map;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V
    .locals 15
    .param p2, "entitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p3, "program"    # Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/util/Map",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/VideoFacade;",
            "Lcom/xfinity/playerlib/bookmarks/VideoBookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/dibic/DibicProgram;",
            ")V"
        }
    .end annotation

    .prologue
    .line 242
    .local p1, "bookmarks":Ljava/util/Map;, "Ljava/util/Map<Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    move-object/from16 v0, p2

    invoke-virtual {p0, v0, v1}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getSortedVideos(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/Watchable;)Ljava/util/SortedSet;

    move-result-object v5

    .line 244
    .local v5, "sortedVideos":Ljava/util/SortedSet;, "Ljava/util/SortedSet<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getDisplayTitle()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->infoTitle:Landroid/widget/TextView;

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V

    .line 246
    new-instance v1, Lcom/xfinity/playerlib/model/VideoFavorite;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getDisplayTitle()Ljava/lang/String;

    move-result-object v3

    .line 247
    invoke-virtual/range {p3 .. p3}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v4

    invoke-direct {v1, v2, v3, v4}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;Z)V

    iput-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 249
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    iget-boolean v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->isFullScreen:Z

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->favoriteIndicator:Landroid/widget/CheckBox;

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;

    invoke-virtual {v1, p0, v2, v3, v4}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->setupFavorite(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;ZLandroid/widget/CheckBox;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 251
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->isNew()Z

    move-result v1

    if-nez v1, :cond_0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getReleaseYear()Ljava/lang/String;

    move-result-object v1

    if-eqz v1, :cond_3

    .line 252
    :cond_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->isNew()Z

    move-result v1

    if-eqz v1, :cond_1

    .line 253
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newIndicator:Landroid/view/View;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    .line 258
    :goto_0
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getReleaseYear()Ljava/lang/String;

    move-result-object v12

    .line 259
    .local v12, "releaseYear":Ljava/lang/String;
    if-eqz v12, :cond_2

    .line 260
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v1

    sget v2, Lcom/xfinity/playerlib/R$string;->release_year:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    aput-object v12, v3, v4

    invoke-virtual {v1, v2, v3}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v13

    .line 261
    .local v13, "releaseYearString":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->releaseYearText:Landroid/widget/TextView;

    invoke-virtual {v1, v13}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 262
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->releaseYearText:Landroid/widget/TextView;

    invoke-virtual {v1, v13}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 267
    .end local v13    # "releaseYearString":Ljava/lang/String;
    :goto_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newReleaseYearContainer:Landroid/view/ViewGroup;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 272
    .end local v12    # "releaseYear":Ljava/lang/String;
    :goto_2
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getExpiresDate()Ljava/util/Date;

    move-result-object v1

    if-eqz v1, :cond_4

    .line 273
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->availability:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 274
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getExpiresDate()Ljava/util/Date;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->formatAvailability(Ljava/util/Date;)Ljava/lang/String;

    move-result-object v11

    .line 275
    .local v11, "formattedAvailabilityDate":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->availability:Landroid/widget/TextView;

    invoke-virtual {v1, v11}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 276
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->availability:Landroid/widget/TextView;

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v2, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "."

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 281
    .end local v11    # "formattedAvailabilityDate":Ljava/lang/String;
    :goto_3
    invoke-interface {v5}, Ljava/util/SortedSet;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_5

    .line 282
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->duration:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 283
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->duration:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-interface {v5}, Ljava/util/SortedSet;->first()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v1

    invoke-static {v3, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDuration(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 284
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->duration:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getActivity()Landroid/app/Activity;

    move-result-object v3

    invoke-interface {v5}, Ljava/util/SortedSet;->first()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getDurationInSeconds()I

    move-result v1

    invoke-static {v3, v1}, Lcom/comcast/cim/utils/UIPresentationUtil;->getDurationSpoken(Landroid/content/Context;I)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v2, v1}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 289
    :goto_4
    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->videoItemContainer:Landroid/view/ViewGroup;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->layoutInflator:Landroid/view/LayoutInflater;

    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->playPressedListener:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-object v9, v1, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->currentlyPlayingVideoId:Ljava/lang/Long;

    move-object v1, p0

    move-object/from16 v2, p1

    move-object/from16 v3, p2

    invoke-virtual/range {v1 .. v9}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->addVideoItems(Ljava/util/Map;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/Watchable;Ljava/util/SortedSet;Landroid/view/ViewGroup;Landroid/view/LayoutInflater;Lcom/xfinity/playerlib/view/programdetails/DetailFragment$PlayPressedListener;Ljava/lang/Long;)V

    .line 291
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getCast()Ljava/lang/String;

    move-result-object v10

    .line 292
    .local v10, "cast":Ljava/lang/String;
    if-eqz v10, :cond_6

    invoke-virtual {v10}, Ljava/lang/String;->isEmpty()Z

    move-result v1

    if-nez v1, :cond_6

    .line 293
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->castText:Landroid/widget/TextView;

    const/4 v2, 0x0

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    .line 294
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->castText:Landroid/widget/TextView;

    invoke-virtual {v1, v10}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 295
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->castText:Landroid/widget/TextView;

    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v2

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_cast:I

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v6, 0x0

    aput-object v10, v4, v6

    invoke-virtual {v2, v3, v4}, Landroid/content/res/Resources;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 300
    :goto_5
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->descriptionText:Landroid/widget/TextView;

    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getDescription()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 301
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->descriptionText:Landroid/widget/TextView;

    sget v2, Lcom/xfinity/playerlib/R$string;->content_description_description:I

    const/4 v3, 0x1

    new-array v3, v3, [Ljava/lang/Object;

    const/4 v4, 0x0

    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getDescription()Ljava/lang/String;

    move-result-object v6

    aput-object v6, v3, v4

    invoke-virtual {p0, v2, v3}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setContentDescription(Ljava/lang/CharSequence;)V

    .line 304
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;->getReviews()Ljava/util/List;

    move-result-object v14

    .line 305
    .local v14, "reviews":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalReview;>;"
    invoke-virtual {p0, v14}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->presentReviews(Ljava/util/List;)V

    .line 306
    return-void

    .line 255
    .end local v10    # "cast":Ljava/lang/String;
    .end local v14    # "reviews":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/hal/HalReview;>;"
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newIndicator:Landroid/view/View;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/View;->setVisibility(I)V

    goto/16 :goto_0

    .line 264
    .restart local v12    # "releaseYear":Ljava/lang/String;
    :cond_2
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newReleaseYearContainer:Landroid/view/ViewGroup;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto/16 :goto_1

    .line 269
    .end local v12    # "releaseYear":Ljava/lang/String;
    :cond_3
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->newReleaseYearContainer:Landroid/view/ViewGroup;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/view/ViewGroup;->setVisibility(I)V

    goto/16 :goto_2

    .line 278
    :cond_4
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->availability:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_3

    .line 286
    :cond_5
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->duration:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto/16 :goto_4

    .line 297
    .restart local v10    # "cast":Ljava/lang/String;
    :cond_6
    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->castText:Landroid/widget/TextView;

    const/16 v2, 0x8

    invoke-virtual {v1, v2}, Landroid/widget/TextView;->setVisibility(I)V

    goto :goto_5
.end method

.method protected setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V
    .locals 5
    .param p1, "displayTitle"    # Ljava/lang/String;
    .param p2, "inlineDisplayTitle"    # Landroid/widget/TextView;

    .prologue
    .line 344
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/DetailFragment;->setDisplayTitle(Ljava/lang/String;Landroid/widget/TextView;)V

    .line 345
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->content_description_detail_title:I

    const/4 v2, 0x2

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    const-string v4, "movie"

    aput-object v4, v2, v3

    const/4 v3, 0x1

    aput-object p1, v2, v3

    invoke-virtual {p0, v1, v2}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->setTitle(Ljava/lang/String;)V

    .line 346
    return-void
.end method

.method public showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/utils/exceptions/CimException;

    .prologue
    const/16 v1, 0x8

    .line 335
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->onLoadingFinished()V

    .line 337
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bodyContainer:Landroid/view/View;

    invoke-virtual {v0, v1}, Landroid/view/View;->setVisibility(I)V

    .line 338
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->detailArtView:Landroid/widget/ImageView;

    invoke-virtual {v0, v1}, Landroid/widget/ImageView;->setVisibility(I)V

    .line 339
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->errorText:Landroid/widget/TextView;

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 340
    return-void
.end method
