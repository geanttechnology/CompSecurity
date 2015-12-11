.class Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "HistoryFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ShortCircuitingDataFetcher"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
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


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V
    .locals 0

    .prologue
    .line 391
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$1;

    .prologue
    .line 391
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;-><init>(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 6
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation

    .prologue
    .line 394
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->bookmarkFetcher:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$900(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 397
    .local v0, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 398
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$1000(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 399
    .local v1, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$1100(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 406
    .local v3, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;

    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$1300(Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 407
    .local v2, "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    new-instance v4, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-direct {v4, v0, v1, v3, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v4

    .line 401
    .end local v1    # "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .end local v2    # "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    .end local v3    # "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    :cond_0
    # getter for: Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment;->access$1200()Lorg/slf4j/Logger;

    move-result-object v4

    const-string v5, "No bookmarks, skipping dibic and entitlement fetches"

    invoke-interface {v4, v5}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 402
    new-instance v1, Lcom/xfinity/playerlib/model/dibic/NullDibicResource;

    invoke-direct {v1}, Lcom/xfinity/playerlib/model/dibic/NullDibicResource;-><init>()V

    .line 403
    .restart local v1    # "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    new-instance v3, Lcom/xfinity/playerlib/model/entitlement/NullVideoEntitlement;

    invoke-direct {v3}, Lcom/xfinity/playerlib/model/entitlement/NullVideoEntitlement;-><init>()V

    .restart local v3    # "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    goto :goto_0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 391
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browsehistory/HistoryFragment$ShortCircuitingDataFetcher;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method
