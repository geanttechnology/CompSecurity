.class Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "SeriesEpisodeListFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadScreenInfo()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .prologue
    .line 298
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "e"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 414
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$000(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 415
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V
    .locals 14
    .param p1, "resource"    # Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .prologue
    .line 306
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->notAvailableContainer:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 308
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v1, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$602(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .line 309
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v1, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    # setter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$702(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Lcom/xfinity/playerlib/model/dibic/DibicResource;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 310
    iget-object v5, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->entitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 312
    .local v5, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$700(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/dibic/DibicResource;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v6

    .line 313
    .local v6, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    if-nez v6, :cond_1

    .line 314
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->showEntityUnavailableView()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)V

    .line 410
    :cond_0
    :goto_0
    return-void

    .line 316
    :cond_1
    const/4 v2, 0x0

    .line 318
    .local v2, "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->hasOnlySeriesInfo()Z

    move-result v0

    if-eqz v0, :cond_a

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v0

    if-lez v0, :cond_a

    .line 319
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v8

    .line 320
    .local v8, "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->companyId:Ljava/lang/Long;

    if-nez v0, :cond_2

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    iget-boolean v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v0, :cond_9

    .line 323
    :cond_2
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_3
    :goto_1
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 324
    .local v7, "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    if-eqz v2, :cond_6

    .line 349
    .end local v7    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .end local v8    # "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_4
    :goto_2
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    new-instance v1, Lcom/xfinity/playerlib/model/VideoFavorite;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v10}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v10

    .line 350
    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getTitle()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v6}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isAdult()Z

    move-result v11

    invoke-direct {v1, v3, v10, v11}, Lcom/xfinity/playerlib/model/VideoFavorite;-><init>(Lcom/xfinity/playerlib/model/MerlinId;Ljava/lang/String;Z)V

    .line 349
    # setter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$902(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Lcom/xfinity/playerlib/model/VideoFavorite;)Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 358
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->showSeriesArt:Ljava/lang/Boolean;

    invoke-virtual {v0}, Ljava/lang/Boolean;->booleanValue()Z

    move-result v0

    if-eqz v0, :cond_c

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->playerAndroidDevice:Lcom/comcast/cim/model/system/PlayerAndroidDevice;

    invoke-virtual {v0}, Lcom/comcast/cim/model/system/PlayerAndroidDevice;->isTabletDevice()Z

    move-result v0

    if-eqz v0, :cond_5

    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->isAccessibilityEnabled()Z

    move-result v0

    if-nez v0, :cond_c

    .line 360
    :cond_5
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesTitleContainer:Landroid/view/ViewGroup;

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/view/ViewGroup;->setVisibility(I)V

    .line 361
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getActivity()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/app/Activity;->setTitle(Ljava/lang/CharSequence;)V

    .line 362
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesTitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1000(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/TextView;

    move-result-object v0

    const/16 v1, 0x8

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 364
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    const/4 v3, 0x1

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .line 365
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->favoriteIndicator:Landroid/widget/CheckBox;
    invoke-static {v10}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1100(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/CheckBox;

    move-result-object v10

    iget-object v11, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-static {v11}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$900(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/VideoFavorite;

    move-result-object v11

    .line 364
    invoke-virtual {v0, v1, v3, v10, v11}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->setupFavorite(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;ZLandroid/widget/CheckBox;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    .line 378
    :goto_3
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    sget v3, Lcom/xfinity/playerlib/R$string;->content_description_detail_title:I

    const/4 v10, 0x2

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    const-string v12, "tv series"

    aput-object v12, v10, v11

    const/4 v11, 0x1

    iget-object v12, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v12}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v12

    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getTitle()Ljava/lang/String;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-virtual {v1, v3, v10}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->getString(I[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->setTitle(Ljava/lang/String;)V

    .line 380
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesHeader:Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1400(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;

    move-result-object v0

    new-instance v1, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;

    invoke-direct {v1, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/android/util/view/widget/CheckableRelativeLayout;->setOnClickListener(Landroid/view/View$OnClickListener;)V

    .line 390
    new-instance v4, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;

    invoke-direct {v4, p0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4$2;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;)V

    .line 404
    .local v4, "infoClickListenerFactory":Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v1, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->bookmarkMap:Ljava/util/Map;

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v3

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->displayDetail(Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V
    invoke-static/range {v0 .. v5}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;Ljava/util/Map;Lcom/xfinity/playerlib/model/consumable/Watchable;Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 406
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->restoredListState:Landroid/os/Parcelable;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/os/Parcelable;

    move-result-object v0

    if-eqz v0, :cond_0

    .line 407
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->consumableVideoList:Landroid/widget/ListView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1700(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/ListView;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->restoredListState:Landroid/os/Parcelable;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/os/Parcelable;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/ListView;->onRestoreInstanceState(Landroid/os/Parcelable;)V

    goto/16 :goto_0

    .line 328
    .end local v4    # "infoClickListenerFactory":Lcom/xfinity/playerlib/view/programdetails/ConsumableVideoListHelper$InfoClickListenerFactory;
    .restart local v7    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .restart local v8    # "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_6
    invoke-interface {v7}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getVideos()Ljava/util/Set;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_7
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_3

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v9

    check-cast v9, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 329
    .local v9, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v3

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->companyId:Ljava/lang/Long;

    if-eqz v3, :cond_8

    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    if-eqz v3, :cond_8

    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v3

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v10

    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v3

    iget-object v3, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->companyId:Ljava/lang/Long;

    invoke-virtual {v3}, Ljava/lang/Long;->longValue()J

    move-result-wide v12

    cmp-long v3, v10, v12

    if-nez v3, :cond_8

    .line 330
    move-object v2, v7

    .line 331
    goto/16 :goto_1

    .line 332
    :cond_8
    iget-object v3, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v3

    iget-boolean v3, v3, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->wantsSubscriptionOnly:Z

    if-eqz v3, :cond_7

    .line 333
    invoke-virtual {v9}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getProviderCode()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v5, v3}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_7

    .line 334
    move-object v2, v7

    .line 335
    goto/16 :goto_1

    .line 341
    .end local v7    # "seriesWatchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    .end local v9    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_9
    const/4 v0, 0x0

    invoke-interface {v8, v0}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    .end local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    check-cast v2, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .restart local v2    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    goto/16 :goto_2

    .line 343
    .end local v8    # "seriesWatchableList":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;>;"
    :cond_a
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v0, :cond_b

    .line 344
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v1

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getVideoId()J

    move-result-wide v10

    invoke-virtual {v0, v10, v11}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->findWatchableByVideoId(J)Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    move-result-object v2

    goto/16 :goto_2

    .line 345
    :cond_b
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->useEpisodeId()Z

    move-result v0

    if-eqz v0, :cond_4

    .line 346
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;

    move-result-object v1

    iget-object v1, v1, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$InstanceState;->episodeId:Lcom/xfinity/playerlib/model/MerlinId;

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->findEpisodeById(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/consumable/EpisodeFacade;

    move-result-object v2

    goto/16 :goto_2

    .line 369
    :cond_c
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesTitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1000(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/TextView;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    move-result-object v1

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setText(Ljava/lang/CharSequence;)V

    .line 370
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesTitle:Landroid/widget/TextView;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1000(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/TextView;

    move-result-object v0

    const/4 v1, 0x0

    invoke-virtual {v0, v1}, Landroid/widget/TextView;->setVisibility(I)V

    .line 373
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    iget-object v0, v0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->bookmarkMenuItemDelegate:Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;

    iget-object v1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    const/4 v3, 0x0

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    .line 374
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->favoriteIndicator:Landroid/widget/CheckBox;
    invoke-static {v10}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$1100(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Landroid/widget/CheckBox;

    move-result-object v10

    iget-object v11, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->seriesFavorite:Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-static {v11}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$900(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/xfinity/playerlib/model/VideoFavorite;

    move-result-object v11

    .line 373
    invoke-virtual {v0, v1, v3, v10, v11}, Lcom/xfinity/playerlib/view/favorite/BookmarkMenuItemDelegate;->setupFavorite(Lcom/comcast/cim/android/view/launch/AuthenticatingFragment;ZLandroid/widget/CheckBox;Lcom/xfinity/playerlib/model/VideoFavorite;)V

    goto/16 :goto_3
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 298
    check-cast p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 301
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment$4;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/SeriesEpisodeListFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 302
    return-void
.end method
