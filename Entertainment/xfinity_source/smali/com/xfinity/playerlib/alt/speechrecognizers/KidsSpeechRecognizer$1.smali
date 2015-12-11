.class Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "KidsSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
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
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;

.field final synthetic val$filterText:Ljava/lang/String;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;[Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;

    .prologue
    .line 34
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    iput-object p4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "error"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 56
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;->access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;I)V

    .line 57
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 9
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
    .line 37
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v6, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v6, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 38
    .local v6, "programResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 40
    .local v4, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-interface {v6}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getPrograms()Ljava/util/List;

    move-result-object v7

    .line 42
    .local v7, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 44
    .local v2, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v2}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isKids()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 45
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;

    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v5, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;->playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 52
    .end local v2    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_0
    return-void

    .line 51
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;

    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v0, v1, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;->access$001(Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 34
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/KidsSpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method
