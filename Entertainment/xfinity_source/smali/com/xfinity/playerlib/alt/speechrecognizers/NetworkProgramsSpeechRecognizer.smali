.class public Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;
.super Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
.source "NetworkProgramsSpeechRecognizer.java"


# instance fields
.field private category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

.field private categoryId:Ljava/lang/String;

.field private companyId:J

.field private network:Lcom/xfinity/playerlib/model/tags/Network;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
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
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;>;"
        }
    .end annotation
.end field


# direct methods
.method public constructor <init>()V
    .locals 1

    .prologue
    .line 23
    invoke-direct {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;-><init>()V

    .line 25
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getProgramsAndTagsAndEntitlementTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)Lcom/xfinity/playerlib/model/tags/Network;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->network:Lcom/xfinity/playerlib/model/tags/Network;

    return-object v0
.end method

.method static synthetic access$002(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;Lcom/xfinity/playerlib/model/tags/Network;)Lcom/xfinity/playerlib/model/tags/Network;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/Network;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->network:Lcom/xfinity/playerlib/model/tags/Network;

    return-object p1
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)J
    .locals 2
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    .prologue
    .line 23
    iget-wide v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->companyId:J

    return-wide v0
.end method

.method static synthetic access$200(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    return-object v0
.end method

.method static synthetic access$202(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;Lcom/xfinity/playerlib/model/tags/OrderedTag;)Lcom/xfinity/playerlib/model/tags/OrderedTag;
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .prologue
    .line 23
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;

    return-object p1
.end method

.method static synthetic access$300(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)Ljava/lang/String;
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    .prologue
    .line 23
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->categoryId:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$401(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 23
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    return-void
.end method

.method static synthetic access$501(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 23
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V

    return-void
.end method


# virtual methods
.method public attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 2
    .param p1, "terms"    # [Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 46
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v0}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 47
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    .line 80
    :goto_0
    return-void

    .line 51
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v1, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;

    invoke-direct {v1, p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1

    .prologue
    .line 84
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1

    .prologue
    .line 89
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method

.method public onCreate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "savedInstanceState"    # Landroid/os/Bundle;

    .prologue
    .line 38
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onCreate(Landroid/os/Bundle;)V

    .line 39
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "companyId"

    const-wide/16 v2, 0x0

    invoke-virtual {v0, v1, v2, v3}, Landroid/content/Intent;->getLongExtra(Ljava/lang/String;J)J

    move-result-wide v0

    iput-wide v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->companyId:J

    .line 40
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v0

    const-string v1, "categoryId"

    invoke-virtual {v0, v1}, Landroid/content/Intent;->getStringExtra(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->categoryId:Ljava/lang/String;

    .line 41
    return-void
.end method
