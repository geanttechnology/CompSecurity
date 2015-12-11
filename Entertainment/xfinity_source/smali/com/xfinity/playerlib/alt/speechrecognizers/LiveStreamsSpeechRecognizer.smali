.class public Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;
.super Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
.source "LiveStreamsSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;
    }
.end annotation


# instance fields
.field private liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field private liveStreamBookmarks:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;"
        }
    .end annotation
.end field

.field private liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;"
        }
    .end annotation
.end field

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
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
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
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
.end field

.field private taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

.field private videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

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


# direct methods
.method public constructor <init>()V
    .locals 3

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;-><init>()V

    .line 28
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 29
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 30
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 32
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 33
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v1, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$DataTask;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 71
    return-void
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object v0
.end method

.method static synthetic access$102(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    return-object p1
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Ljava/util/List;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamBookmarks:Ljava/util/List;

    return-object v0
.end method

.method static synthetic access$202(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Ljava/util/List;)Ljava/util/List;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;
    .param p1, "x1"    # Ljava/util/List;

    .prologue
    .line 21
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamBookmarks:Ljava/util/List;

    return-object p1
.end method

.method static synthetic access$301(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 21
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    return-void
.end method

.method static synthetic access$401(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 21
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V

    return-void
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    .prologue
    .line 21
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method


# virtual methods
.method public attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 3
    .param p1, "terms"    # [Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 38
    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v1}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 39
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    .line 69
    :goto_0
    return-void

    .line 43
    :cond_0
    const-string v1, " "

    invoke-static {p1, v1}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 45
    .local v0, "filterText":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;

    invoke-direct {v2, p0, v0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Ljava/lang/String;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1

    .prologue
    .line 88
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method
