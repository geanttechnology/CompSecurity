.class public Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;
.super Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
.source "FavoriteSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;
    }
.end annotation


# instance fields
.field private final dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
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

.field private liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

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

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;>;"
        }
    .end annotation
.end field

.field private final taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

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
    .locals 3

    .prologue
    .line 31
    invoke-direct {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;-><init>()V

    .line 33
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getFavoriteDAO()Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    .line 34
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 35
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    .line 37
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 38
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 40
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 43
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->taskExecutorFactory:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    new-instance v1, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;

    const/4 v2, 0x0

    invoke-direct {v1, p0, v2}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$FavoriteTask;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;)V

    invoke-virtual {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 97
    return-void
.end method

.method static synthetic access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 31
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    return-void
.end method

.method static synthetic access$201(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 31
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V

    return-void
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/xfinity/playerlib/model/database/FavoriteDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->favoriteDAO:Lcom/xfinity/playerlib/model/database/FavoriteDAO;

    return-object v0
.end method

.method static synthetic access$400(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    return-object v0
.end method

.method static synthetic access$500(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->dibicCombinedCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$600(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->videoEntitlementCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method

.method static synthetic access$700(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;)Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    .prologue
    .line 31
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->liveStreamResourceCache:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    return-object v0
.end method


# virtual methods
.method public attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 3
    .param p1, "terms"    # [Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 49
    sget-object v1, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v1}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 50
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    .line 95
    :goto_0
    return-void

    .line 54
    :cond_0
    const-string v1, " "

    invoke-static {p1, v1}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 56
    .local v0, "filterText":Ljava/lang/String;
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v2, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;

    invoke-direct {v2, p0, v0, p2, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;[Ljava/lang/String;)V

    invoke-interface {v1, v2}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    iput-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1

    .prologue
    .line 126
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1

    .prologue
    .line 131
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method
