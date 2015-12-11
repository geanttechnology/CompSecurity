.class Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "MovieDetailFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->loadScreenInfo()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    .prologue
    .line 176
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 234
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->onLoadingFailed()V

    .line 235
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 11
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 186
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->errorText:Landroid/widget/TextView;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$200(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Landroid/widget/TextView;

    move-result-object v6

    const/16 v7, 0x8

    invoke-virtual {v6, v7}, Landroid/widget/TextView;->setVisibility(I)V

    .line 188
    iget-object v2, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v2, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 189
    .local v2, "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v3, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e2:Ljava/lang/Object;

    check-cast v3, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;

    .line 190
    .local v3, "movieEntity":Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;
    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v6, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v6, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    iput-object v6, v7, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 192
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->instanceState:Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;

    iget-boolean v6, v6, Lcom/xfinity/playerlib/view/programdetails/DetailFragment$InstanceState;->showPanelFittedLayout:Z

    if-eqz v6, :cond_0

    .line 193
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$dimen;->detail_art_land_2x_width:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v5

    .line 194
    .local v5, "sourceWidth":I
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-virtual {v6}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->getResources()Landroid/content/res/Resources;

    move-result-object v6

    sget v7, Lcom/xfinity/playerlib/R$dimen;->detail_art_land_2x_height:I

    invoke-virtual {v6, v7}, Landroid/content/res/Resources;->getDimensionPixelSize(I)I

    move-result v4

    .line 195
    .local v4, "sourceHeight":I
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->detailArtView:Landroid/widget/ImageView;
    invoke-static {v8}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Landroid/widget/ImageView;

    move-result-object v8

    invoke-virtual {v6, v7, v8, v5, v4}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadDetailProgramArt(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;II)V

    .line 202
    .end local v4    # "sourceHeight":I
    .end local v5    # "sourceWidth":I
    :goto_0
    :try_start_0
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v7

    invoke-interface {v6, v7}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    .line 204
    .local v0, "dibicMovie":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    if-eqz v0, :cond_1

    .line 205
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    new-instance v7, Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    invoke-direct {v7, v3}, Lcom/xfinity/playerlib/model/consumable/MovieFacade;-><init>(Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;)V

    # setter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;
    invoke-static {v6, v7}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$402(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;Lcom/xfinity/playerlib/model/consumable/MovieFacade;)Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    .line 207
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;
    invoke-static {v7}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$600(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v7

    new-instance v8, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;

    iget-object v9, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v9, v9, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkDAO:Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    iget-object v10, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->movieFacade:Lcom/xfinity/playerlib/model/consumable/MovieFacade;
    invoke-static {v10}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$400(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/xfinity/playerlib/model/consumable/MovieFacade;

    move-result-object v10

    invoke-direct {v8, v9, v10}, Lcom/xfinity/playerlib/view/programdetails/EpisodeBookmarkCache;-><init>(Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    invoke-virtual {v7, v8}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v7

    # setter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    invoke-static {v6, v7}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$502(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 208
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v7, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkProvider:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    invoke-static {v7}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$500(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v7

    new-instance v8, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;

    invoke-direct {v8, p0, v2, v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2$1;-><init>(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    invoke-interface {v7, v8}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v7

    # setter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->bookmarkListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v6, v7}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$702(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_0 .. :try_end_0} :catch_0

    .line 230
    .end local v0    # "dibicMovie":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_1
    return-void

    .line 197
    :cond_0
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    iget-object v6, v6, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->programDetailArtImageLoader:Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/hal/HalMovieConsumable;->getMerlinEntityId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v7

    iget-object v8, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->detailArtView:Landroid/widget/ImageView;
    invoke-static {v8}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$300(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Landroid/widget/ImageView;

    move-result-object v8

    invoke-virtual {v6, v7, v8}, Lcom/xfinity/playerlib/image/ProgramDetailArtImageLoader;->loadDetailProgramArt(Lcom/xfinity/playerlib/model/MerlinId;Landroid/widget/ImageView;)V

    goto :goto_0

    .line 222
    .restart local v0    # "dibicMovie":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    :try_start_1
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    const/4 v7, 0x0

    invoke-virtual {v6, v7}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V
    :try_end_1
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_1 .. :try_end_1} :catch_0

    goto :goto_1

    .line 226
    .end local v0    # "dibicMovie":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :catch_0
    move-exception v1

    .line 227
    .local v1, "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    invoke-virtual {v6, v1}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->showFailureState(Lcom/comcast/cim/cmasl/utils/exceptions/CimException;)V

    .line 228
    iget-object v6, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {v6}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$800(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lorg/slf4j/Logger;

    move-result-object v6

    const-string v7, "Caught exception while trying to build MovieFacade"

    invoke-interface {v6, v7, v1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_1
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 176
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 180
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment$2;->this$0:Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;->access$100(Lcom/xfinity/playerlib/view/programdetails/MovieDetailFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 181
    return-void
.end method
