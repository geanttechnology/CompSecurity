.class Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "PlayerSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
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
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    .prologue
    .line 47
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 82
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/comcast/cim/android/accessibility/SpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->access$001(Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;I)V

    .line 83
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 8
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
    .line 52
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 53
    .local v1, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 55
    .local v4, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    const-string v6, " "

    invoke-static {v5, v6}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 56
    .local v2, "filterText":Ljava/lang/String;
    invoke-interface {v1, v2}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    .line 58
    .local v3, "results":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_2

    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v6, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {v5, v6}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-nez v5, :cond_2

    .line 60
    const/4 v5, 0x0

    invoke-interface {v3, v5}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 62
    .local v0, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v6, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {v5, v6}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v5

    if-eqz v5, :cond_1

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v5

    if-eqz v5, :cond_1

    .line 64
    invoke-virtual {v4, v0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 65
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v6

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v7

    invoke-virtual {v5, v6, v7}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->playVideo(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 78
    .end local v0    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_0
    return-void

    .line 67
    .restart local v0    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_0
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    sget-object v6, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual {v5, v0, v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->closeWithNotEntitledDibicProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V

    goto :goto_0

    .line 72
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    invoke-virtual {v5, v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->showVideoDetails(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    goto :goto_0

    .line 76
    .end local v0    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_2
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;

    iget-object v6, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    invoke-virtual {v5, v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->createSearchIntent([Ljava/lang/String;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 47
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method
