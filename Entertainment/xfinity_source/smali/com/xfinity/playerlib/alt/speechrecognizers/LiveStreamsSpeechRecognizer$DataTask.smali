.class Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;
.super Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;
.source "LiveStreamsSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DataTask"
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
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)V
    .locals 0

    .prologue
    .line 71
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/task/NonCachingBaseTask;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;
    .param p2, "x1"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;

    .prologue
    .line 71
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)V

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
    .line 74
    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    invoke-static {v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$500(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v3

    invoke-interface {v3}, Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;->getFavorites()Ljava/util/List;

    move-result-object v0

    .line 75
    .local v0, "bookmarks":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;"
    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$600(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 76
    .local v2, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    invoke-static {v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$700(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v3

    invoke-interface {v3}, Lcom/comcast/cim/cmasl/taskexecutor/task/Task;->execute()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 77
    .local v1, "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    new-instance v3, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-direct {v3, v2, v1, v0}, Lcom/comcast/cim/cmasl/utils/container/Tuple3;-><init>(Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;)V

    return-object v3
.end method

.method public bridge synthetic execute()Ljava/lang/Object;
    .locals 1

    .prologue
    .line 71
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;->execute()Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    move-result-object v0

    return-object v0
.end method
