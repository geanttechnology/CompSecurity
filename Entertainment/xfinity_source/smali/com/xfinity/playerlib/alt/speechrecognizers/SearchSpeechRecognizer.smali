.class public Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;
.super Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
.source "SearchSpeechRecognizer.java"


# instance fields
.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
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
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 21
    invoke-direct {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;-><init>()V

    .line 25
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTagsAndProgramsTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-void
.end method

.method static synthetic access$001(Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 21
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    return-void
.end method

.method static synthetic access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 21
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V

    return-void
.end method


# virtual methods
.method public attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 2
    .param p1, "terms"    # [Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 31
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v0}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 32
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    .line 81
    :goto_0
    return-void

    .line 36
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v1, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1

    .prologue
    .line 85
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1

    .prologue
    .line 90
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method
