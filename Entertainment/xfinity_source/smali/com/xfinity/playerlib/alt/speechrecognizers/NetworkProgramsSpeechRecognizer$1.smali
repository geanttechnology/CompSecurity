.class Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "NetworkProgramsSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
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
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    .prologue
    .line 51
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 77
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$501(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;I)V

    .line 78
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 12
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 55
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v6, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v6, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 56
    .local v6, "programResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v8, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e2:Ljava/lang/Object;

    check-cast v8, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;

    .line 57
    .local v8, "tagsRoot":Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 58
    .local v4, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    const-string v3, " "

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 60
    .local v1, "filterText":Ljava/lang/String;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->companyId:J
    invoke-static {v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$100(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)J

    move-result-wide v10

    invoke-interface {v8, v10, v11}, Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;->getNetworkByCompanyId(J)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v3

    # setter for: Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v0, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$002(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;Lcom/xfinity/playerlib/model/tags/Network;)Lcom/xfinity/playerlib/model/tags/Network;

    .line 61
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$000(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v3

    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->categoryId:Ljava/lang/String;
    invoke-static {v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$300(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v3, v5}, Lcom/xfinity/playerlib/model/tags/Network;->getCategoryById(Ljava/lang/String;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v3

    # setter for: Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-static {v0, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$202(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;Lcom/xfinity/playerlib/model/tags/OrderedTag;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    .line 63
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->category:Lcom/xfinity/playerlib/model/tags/OrderedTag;
    invoke-static {v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$200(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)Lcom/xfinity/playerlib/model/tags/OrderedTag;

    move-result-object v0

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->network:Lcom/xfinity/playerlib/model/tags/Network;
    invoke-static {v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$000(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;)Lcom/xfinity/playerlib/model/tags/Network;

    move-result-object v3

    invoke-interface {v6, v0, v3}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingGenreAndNetwork(Lcom/xfinity/playerlib/model/tags/OrderedTag;Lcom/xfinity/playerlib/model/tags/Network;)Ljava/util/List;

    move-result-object v7

    .line 65
    .local v7, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v9

    :cond_0
    invoke-interface {v9}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v9}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 67
    .local v2, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v5, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 73
    .end local v2    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_0
    return-void

    .line 72
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v0, v3, v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;->access$401(Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 51
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/NetworkProgramsSpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method
