.class Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "HistorySpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
        "<",
        "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
        "<",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
        ">;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

.field final synthetic val$filterText:Ljava/lang/String;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;[Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    .prologue
    .line 59
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    iput-object p4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 96
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->access$301(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;I)V

    .line 97
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 17
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 64
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    move-object/from16 v0, p1

    iget-object v14, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v14, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 65
    .local v14, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    move-object/from16 v0, p1

    iget-object v6, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    check-cast v6, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 66
    .local v6, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    # setter for: Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    invoke-static {v2, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->access$102(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 68
    move-object/from16 v0, p1

    iget-object v1, v0, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    check-cast v1, Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v16

    :cond_0
    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->hasNext()Z

    move-result v1

    if-eqz v1, :cond_3

    invoke-interface/range {v16 .. v16}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v13

    check-cast v13, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 70
    .local v13, "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    instance-of v1, v13, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v1, :cond_2

    move-object v4, v13

    .line 72
    check-cast v4, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 73
    .local v4, "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    invoke-interface {v14, v1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v5

    .line 76
    .local v5, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v7, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual/range {v1 .. v7}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->playOrShowIfEpisodeMatches(Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v1

    if-nez v1, :cond_1

    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    move-object/from16 v0, p0

    iget-object v8, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v12, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAY_FROM_HISTORY:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    move-object v9, v5

    move-object v11, v6

    .line 77
    invoke-virtual/range {v7 .. v12}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 92
    .end local v4    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local v5    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v13    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_1
    :goto_0
    return-void

    .line 80
    .restart local v13    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_2
    instance-of v1, v13, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    if-eqz v1, :cond_0

    move-object v15, v13

    .line 82
    check-cast v15, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 84
    .local v15, "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    invoke-virtual {v15}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTitle()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    invoke-virtual {v1, v2, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->checkTitleMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 85
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    invoke-virtual {v15}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v2

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->liveStreamResource:Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    invoke-static {v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->access$100(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->playLiveStream(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    goto :goto_0

    .line 91
    .end local v13    # "bookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .end local v15    # "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_3
    move-object/from16 v0, p0

    iget-object v1, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;

    move-object/from16 v0, p0

    iget-object v2, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    move-object/from16 v0, p0

    iget-object v3, v0, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v1, v2, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;->access$201(Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 59
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/HistorySpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    return-void
.end method
