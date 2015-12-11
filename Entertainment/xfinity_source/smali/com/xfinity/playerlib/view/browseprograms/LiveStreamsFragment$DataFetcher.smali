.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "LiveStreamsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DataFetcher"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask",
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


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0

    .prologue
    .line 755
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$1;

    .prologue
    .line 755
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;-><init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple3;
    .locals 4
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;>;"
        }
    .end annotation

    .prologue
    .line 758
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2800(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v3

    invoke-interface {v3}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getFavorites()Ljava/util/List;

    move-result-object v0

    .line 759
    .local v0, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$2900(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 760
    .local v2, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v3, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v3}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$3000(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 761
    .local v1, "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    new-instance v3, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-direct {v3, v2, v1, v0}, Lcom/comcast/cim/cmasl/utils/container/Tuple3;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v3
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 755
    invoke-virtual {p0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$DataFetcher;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    move-result-object v0

    return-object v0
.end method
