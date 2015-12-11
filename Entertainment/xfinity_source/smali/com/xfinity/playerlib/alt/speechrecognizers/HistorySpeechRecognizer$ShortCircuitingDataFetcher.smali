.class Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "HistorySpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;
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
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;)V
    .locals 0

    .prologue
    .line 127
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;
    .param p2, "x1"    # Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;

    .prologue
    .line 127
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;)V

    return-void
.end method


# virtual methods
.method public execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;
    .locals 5
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
    .line 130
    iget-object v4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    iget-object v4, v4, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->bookmarkTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/util/List;

    .line 133
    .local v0, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_0

    .line 134
    iget-object v4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->access$700(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 135
    .local v1, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->access$800(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 141
    .local v3, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    :goto_0
    iget-object v4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->access$900(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    invoke-interface {v4}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 142
    .local v2, "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    new-instance v4, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-direct {v4, v0, v1, v3, v2}, Lcom/comcast/cim/cmasl/utils/container/Tuple4;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v4

    .line 137
    .end local v1    # "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .end local v2    # "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    .end local v3    # "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    :cond_0
    new-instance v1, Lcom/xfinity/playerlib/model/dibic/NullDibicResource;

    invoke-direct {v1}, Lcom/xfinity/playerlib/model/dibic/NullDibicResource;-><init>()V

    .line 138
    .restart local v1    # "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    new-instance v3, Lcom/xfinity/playerlib/model/entitlement/NullVideoEntitlement;

    invoke-direct {v3}, Lcom/xfinity/playerlib/model/entitlement/NullVideoEntitlement;-><init>()V

    .restart local v3    # "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    goto :goto_0
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 127
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$ShortCircuitingDataFetcher;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    move-result-object v0

    return-object v0
.end method
