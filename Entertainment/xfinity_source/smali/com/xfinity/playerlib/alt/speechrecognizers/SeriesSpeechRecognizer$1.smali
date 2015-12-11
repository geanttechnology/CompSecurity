.class Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "SeriesSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    .prologue
    .line 67
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "e"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 103
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->access$501(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;I)V

    .line 104
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V
    .locals 9
    .param p1, "resource"    # Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .prologue
    .line 72
    iget-object v3, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->tvSeriesFacade:Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;

    .line 73
    .local v3, "tvSeriesFacade":Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;
    iget-object v0, p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;->dibicResource:Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 75
    .local v0, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v5

    invoke-interface {v0, v5}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v2

    .line 77
    .local v2, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    if-nez v2, :cond_1

    .line 78
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    const/4 v6, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v5, v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;I)V

    .line 99
    :cond_0
    :goto_0
    return-void

    .line 82
    :cond_1
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v6

    iget-object v7, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iget-object v8, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->playOrShowIfValidListNumberForSeriesWatchable(Ljava/util/List;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    invoke-static {v5, v6, v7, v8}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->access$200(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;Ljava/util/List;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v5

    if-nez v5, :cond_0

    .line 86
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    const-string v6, " "

    invoke-static {v5, v6}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 88
    .local v1, "filterText":Ljava/lang/String;
    invoke-virtual {v3}, Lcom/xfinity/playerlib/model/consumable/TvSeriesFacade;->getAllEpisodeFacades()Ljava/util/List;

    move-result-object v5

    invoke-interface {v5}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v5

    :cond_2
    invoke-interface {v5}, Ljava/util/Iterator;->hasNext()Z

    move-result v6

    if-eqz v6, :cond_3

    invoke-interface {v5}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;

    .line 89
    .local v4, "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    invoke-interface {v4}, Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;->getDisplayTitle()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/String;->toLowerCase()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v6, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_2

    .line 90
    iget-object v6, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    iget-object v7, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->playOrLoadSeriesWatchable(Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    invoke-static {v6, v4, v7}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->access$300(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v6

    if-eqz v6, :cond_2

    goto :goto_0

    .line 96
    .end local v4    # "watchable":Lcom/xfinity/playerlib/model/consumable/SeriesWatchable;
    :cond_3
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;

    iget-object v6, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iget-object v7, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v5, v6, v7}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;->access$401(Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 67
    check-cast p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SeriesSpeechRecognizer$1;->onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V

    return-void
.end method
