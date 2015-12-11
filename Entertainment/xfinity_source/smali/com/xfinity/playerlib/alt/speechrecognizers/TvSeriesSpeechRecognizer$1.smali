.class Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "TvSeriesSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple",
        "<",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;

    .prologue
    .line 31
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 55
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;->access$201(Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;I)V

    .line 56
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 9
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 36
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;>;"
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 37
    .local v4, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v6, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e1:Ljava/lang/Object;

    check-cast v6, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 38
    .local v6, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;

    invoke-interface {v6}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getPrograms()Ljava/util/List;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;->sortList(Ljava/util/List;)Ljava/util/List;

    move-result-object v7

    .line 39
    .local v7, "programs":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    const-string v3, " "

    invoke-static {v0, v3}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 41
    .local v1, "filterText":Ljava/lang/String;
    invoke-interface {v7}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v8

    :cond_0
    invoke-interface {v8}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_1

    invoke-interface {v8}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 43
    .local v2, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v5, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;->playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 51
    .end local v2    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_0
    return-void

    .line 49
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v0, v3, v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;->access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 31
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/TvSeriesSpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method
