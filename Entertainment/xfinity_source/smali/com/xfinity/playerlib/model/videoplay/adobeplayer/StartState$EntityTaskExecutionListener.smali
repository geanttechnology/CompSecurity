.class abstract Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;
.super Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
.source "StartState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x402
    name = "EntityTaskExecutionListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "TE;>;E:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener",
        "<TT;>;"
    }
.end annotation


# instance fields
.field private companyId:Ljava/lang/Long;

.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

.field private watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;


# direct methods
.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V
    .locals 3
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 358
    .local p0, "this":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;, "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener<TT;TE;>;"
    .local p2, "taskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TT;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    .line 359
    iget-object v0, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getActivityContext()Landroid/app/Activity;

    move-result-object v0

    iget-object v1, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getErrorDialogFactory()Lcom/comcast/cim/android/view/common/ErrorDialogFactory;

    move-result-object v1

    iget-object v2, p1, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->cancelListener:Landroid/content/DialogInterface$OnCancelListener;

    invoke-direct {p0, p2, v0, v1, v2}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    .line 360
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Lcom/xfinity/playerlib/model/consumable/WatchableKey;)V
    .locals 0
    .param p3, "watchableKey"    # Lcom/xfinity/playerlib/model/consumable/WatchableKey;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;",
            "Lcom/xfinity/playerlib/model/consumable/WatchableKey;",
            ")V"
        }
    .end annotation

    .prologue
    .line 363
    .local p0, "this":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;, "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener<TT;TE;>;"
    .local p2, "taskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 364
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    .line 365
    return-void
.end method

.method public constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Ljava/lang/Long;)V
    .locals 0
    .param p3, "companyId"    # Ljava/lang/Long;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<TT;>;",
            "Ljava/lang/Long;",
            ")V"
        }
    .end annotation

    .prologue
    .line 368
    .local p0, "this":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;, "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener<TT;TE;>;"
    .local p2, "taskExecutor":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;)V

    .line 369
    iput-object p3, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->companyId:Ljava/lang/Long;

    .line 370
    return-void
.end method


# virtual methods
.method protected abstract createWatchable(Ljava/lang/Object;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TE;)",
            "Lcom/xfinity/playerlib/model/consumable/Watchable;"
        }
    .end annotation
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(TT;)V"
        }
    .end annotation

    .prologue
    .line 374
    .local p0, "this":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;, "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener<TT;TE;>;"
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "TT;"
    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 375
    .local v1, "entitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v2, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    .line 379
    .local v2, "entity":Ljava/lang/Object;, "TE;"
    :try_start_0
    invoke-virtual {p0, v2}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->createWatchable(Ljava/lang/Object;)Lcom/xfinity/playerlib/model/consumable/Watchable;
    :try_end_0
    .catch Lcom/comcast/cim/cmasl/utils/exceptions/CimException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-object v6

    .line 386
    .local v6, "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    const/4 v5, 0x0

    .line 387
    .local v5, "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    if-eqz v7, :cond_1

    .line 388
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->watchableKey:Lcom/xfinity/playerlib/model/consumable/WatchableKey;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/consumable/WatchableKey;->getVideoId()J

    move-result-wide v8

    invoke-interface {v6, v8, v9}, Lcom/xfinity/playerlib/model/consumable/Watchable;->findVideoById(J)Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    move-result-object v5

    .line 414
    :cond_0
    :goto_0
    if-eqz v5, :cond_5

    .line 415
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v7, v7, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7, v5, v6}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onVideoFetched(Lcom/xfinity/playerlib/model/consumable/VideoFacade;Lcom/xfinity/playerlib/model/consumable/Watchable;)V

    .line 420
    .end local v5    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .end local v6    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :goto_1
    return-void

    .line 380
    :catch_0
    move-exception v0

    .line 381
    .local v0, "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    # getter for: Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->access$000()Lorg/slf4j/Logger;

    move-result-object v7

    const-string v8, "Entity parsing error (possible data issue)"

    invoke-interface {v7, v8, v0}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 382
    new-instance v7, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    invoke-direct {v7, v0}, Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;-><init>(Ljava/lang/Throwable;)V

    invoke-virtual {p0, v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    goto :goto_1

    .line 389
    .end local v0    # "e":Lcom/comcast/cim/cmasl/utils/exceptions/CimException;
    .restart local v5    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    .restart local v6    # "watchable":Lcom/xfinity/playerlib/model/consumable/Watchable;
    :cond_1
    if-eqz v6, :cond_4

    invoke-interface {v6}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v7

    invoke-interface {v7}, Ljava/util/Set;->isEmpty()Z

    move-result v7

    if-nez v7, :cond_4

    .line 391
    new-instance v3, Ljava/util/TreeSet;

    new-instance v7, Lcom/xfinity/playerlib/model/consumable/VideoComparator;

    invoke-direct {v7, v1}, Lcom/xfinity/playerlib/model/consumable/VideoComparator;-><init>(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    invoke-direct {v3, v7}, Ljava/util/TreeSet;-><init>(Ljava/util/Comparator;)V

    .line 392
    .local v3, "sortedVideos":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    invoke-interface {v6}, Lcom/xfinity/playerlib/model/consumable/Watchable;->getVideos()Ljava/util/Set;

    move-result-object v7

    invoke-virtual {v3, v7}, Ljava/util/TreeSet;->addAll(Ljava/util/Collection;)Z

    .line 395
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->companyId:Ljava/lang/Long;

    if-eqz v7, :cond_3

    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->companyId:Ljava/lang/Long;

    invoke-virtual {v7}, Ljava/lang/Long;->longValue()J

    move-result-wide v8

    const-wide/16 v10, 0x0

    cmp-long v7, v8, v10

    if-lez v7, :cond_3

    .line 396
    invoke-virtual {v3}, Ljava/util/TreeSet;->iterator()Ljava/util/Iterator;

    move-result-object v7

    :cond_2
    invoke-interface {v7}, Ljava/util/Iterator;->hasNext()Z

    move-result v8

    if-eqz v8, :cond_3

    invoke-interface {v7}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .line 397
    .local v4, "tempVideo":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v8

    if-eqz v8, :cond_2

    invoke-virtual {v4}, Lcom/xfinity/playerlib/model/consumable/VideoFacade;->getNetworkInfo()Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;

    move-result-object v8

    invoke-virtual {v8}, Lcom/xfinity/playerlib/model/consumable/hal/HalNetworkProvider;->getCompanyId()J

    move-result-wide v8

    iget-object v10, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->companyId:Ljava/lang/Long;

    invoke-virtual {v10}, Ljava/lang/Long;->longValue()J

    move-result-wide v10

    cmp-long v8, v8, v10

    if-nez v8, :cond_2

    .line 398
    move-object v5, v4

    .line 405
    .end local v4    # "tempVideo":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    :cond_3
    if-nez v5, :cond_0

    .line 406
    invoke-virtual {v3}, Ljava/util/TreeSet;->first()Ljava/lang/Object;

    move-result-object v5

    .end local v5    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    check-cast v5, Lcom/xfinity/playerlib/model/consumable/VideoFacade;

    .restart local v5    # "video":Lcom/xfinity/playerlib/model/consumable/VideoFacade;
    goto :goto_0

    .line 410
    .end local v3    # "sortedVideos":Ljava/util/TreeSet;, "Ljava/util/TreeSet<Lcom/xfinity/playerlib/model/consumable/VideoFacade;>;"
    :cond_4
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v7, v7, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onVideoFetchFailed()V

    goto :goto_1

    .line 418
    :cond_5
    iget-object v7, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v7, v7, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v7}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onVideoFetchFailed()V

    goto/16 :goto_1
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 353
    .local p0, "this":Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;, "Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener<TT;TE;>;"
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$EntityTaskExecutionListener;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method
