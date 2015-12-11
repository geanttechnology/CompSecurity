.class Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "SearchSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
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
        "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    .prologue
    .line 36
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 78
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;I)V

    .line 79
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V
    .locals 16
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple",
            "<",
            "Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 41
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple;, "Lcom/comcast/cim/cmasl/utils/container/Tuple<Lcom/xfinity/playerlib/model/tags/parser/TagsRoot;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    move-object/from16 v0, p1

    iget-object v9, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple;->e2:Ljava/lang/Object;

    check-cast v9, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 42
    .local v9, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->getIntent()Landroid/content/Intent;

    move-result-object v1

    invoke-virtual {v1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    const-string v3, "KEY_SEARCH_TERMS"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 43
    .local v15, "searchTerms":Ljava/lang/String;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    const-string v3, " "

    invoke-static {v1, v3}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v10

    .line 47
    .local v10, "filterText":Ljava/lang/String;
    invoke-interface {v9, v15}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramsMatchingTitleFilter(Ljava/lang/String;)Ljava/util/List;

    move-result-object v14

    .line 49
    .local v14, "results":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    new-instance v1, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;

    const/4 v3, 0x1

    invoke-direct {v1, v3}, Lcom/xfinity/playerlib/model/comparator/DibicProgramTitleComparator;-><init>(Z)V

    invoke-static {v14, v1}, Ljava/util/Collections;->sort(Ljava/util/List;Ljava/util/Comparator;)V

    .line 52
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v12

    .line 53
    .local v12, "newResults":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-static {}, Lcom/google/common/collect/Lists;->newArrayList()Ljava/util/ArrayList;

    move-result-object v11

    .line 54
    .local v11, "fullResults":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v14}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 55
    .local v13, "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    invoke-virtual {v13}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isNew()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 56
    invoke-interface {v12, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 58
    :cond_0
    invoke-interface {v11, v13}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    goto :goto_0

    .line 60
    .end local v13    # "program":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_1
    invoke-static {v12}, Lcom/google/common/collect/Lists;->newArrayList(Ljava/lang/Iterable;)Ljava/util/ArrayList;

    move-result-object v2

    .line 61
    .local v2, "sectionedResults":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/dibic/DibicProgram;>;"
    invoke-interface {v2, v11}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 63
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    const/4 v5, 0x0

    sget-object v6, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual/range {v1 .. v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->playOrShowIfValidListNumber(Ljava/util/List;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 74
    :goto_1
    return-void

    .line 67
    :cond_2
    invoke-interface {v2}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_3
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_4

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v5

    check-cast v5, Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    .line 68
    .local v5, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    move-object/from16 v0, p0

    iget-object v6, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    const/4 v7, 0x0

    sget-object v8, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    move-object v4, v10

    invoke-virtual/range {v3 .. v8}, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v3

    if-eqz v3, :cond_3

    goto :goto_1

    .line 73
    .end local v5    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :cond_4
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v1, v3, v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;->access$001(Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_1
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 36
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/SearchSpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple;)V

    return-void
.end method
