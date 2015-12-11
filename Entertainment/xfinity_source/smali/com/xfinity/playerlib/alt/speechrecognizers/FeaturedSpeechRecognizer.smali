.class public Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;
.super Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;
.source "FeaturedSpeechRecognizer.java"


# instance fields
.field private final bookmarkTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/task/Task",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;>;"
        }
    .end annotation
.end field

.field protected liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

.field private taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
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
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;>;"
        }
    .end annotation
.end field

.field protected videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;


# direct methods
.method public constructor <init>()V
    .locals 5

    .prologue
    .line 28
    invoke-direct {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;-><init>()V

    .line 33
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getVideoBookmarkDAO()Lcom/xfinity/playerlib/model/database/CachingVideoBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->videoBookmarkDAO:Lcom/xfinity/playerlib/model/database/VideoBookmarkDAO;

    .line 34
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getLiveStreamBookmarkDAO()Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->liveStreamBookmarkDAO:Lcom/xfinity/playerlib/model/database/LiveStreamBookmarkDAO;

    .line 36
    new-instance v0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$1;

    invoke-direct {v0, p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$1;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;)V

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->bookmarkTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 56
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/container/PlayerContainer;->getTaskExecutorFactory()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;

    move-result-object v0

    .line 57
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v1

    invoke-virtual {v1}, Lcom/comcast/cim/container/PlayerContainer;->getVideoEntitlementCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v1

    .line 58
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v2

    invoke-virtual {v2}, Lcom/comcast/cim/container/PlayerContainer;->getFeaturedResourceCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v2

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->bookmarkTask:Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    .line 60
    invoke-static {}, Lcom/comcast/cim/container/PlayerContainer;->getInstance()Lcom/comcast/cim/container/PlayerContainer;

    move-result-object v4

    invoke-virtual {v4}, Lcom/comcast/cim/container/PlayerContainer;->getDibicCombinedCache()Lcom/comcast/cim/cmasl/taskexecutor/task/Task;

    move-result-object v4

    .line 57
    invoke-virtual {v0, v1, v2, v3, v4}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutorFactory;->create(Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;Lcom/comcast/cim/cmasl/taskexecutor/task/Task;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    .line 55
    return-void
.end method

.method static synthetic access$000(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .param p4, "x4"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .param p5, "x5"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 28
    invoke-direct/range {p0 .. p5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->showOrPlayLastWatched(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$100(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 1
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;
    .param p1, "x1"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p2, "x2"    # Ljava/lang/String;
    .param p3, "x3"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .param p4, "x4"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .param p5, "x5"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 28
    invoke-direct/range {p0 .. p5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->showOrPlayLastWatchIfTitleMatches(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v0

    return v0
.end method

.method static synthetic access$201(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;
    .param p1, "x1"    # [Ljava/lang/String;
    .param p2, "x2"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 28
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    return-void
.end method

.method static synthetic access$301(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;I)V
    .locals 0
    .param p0, "x0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;
    .param p1, "x1"    # I

    .prologue
    .line 28
    invoke-super {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V

    return-void
.end method

.method private playLiveStreamWithoutCheckingEntitlements(Ljava/lang/String;)V
    .locals 1
    .param p1, "liveStreamId"    # Ljava/lang/String;

    .prologue
    .line 191
    invoke-static {p1}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerActivity;->createIntentForPlayer(Ljava/lang/String;)Landroid/content/Intent;

    move-result-object v0

    .line 192
    .local v0, "intent":Landroid/content/Intent;
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->startActivity(Landroid/content/Intent;)V

    .line 193
    invoke-virtual {p0}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->closeWithIgnore()V

    .line 194
    return-void
.end method

.method private showOrPlayLastWatchIfTitleMatches(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 13
    .param p1, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p2, "filterText"    # Ljava/lang/String;
    .param p3, "lastWatchedBookmark"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .param p4, "dibicResource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .param p5, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 125
    move-object/from16 v0, p3

    instance-of v1, v0, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v1, :cond_1

    move-object/from16 v4, p3

    .line 126
    check-cast v4, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 127
    .local v4, "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-virtual {v4}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v1

    move-object/from16 v0, p4

    invoke-interface {v0, v1}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v5

    .line 129
    .local v5, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    sget-object v7, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    move-object v1, p0

    move-object v2, p2

    move-object/from16 v3, p5

    move-object v6, p1

    invoke-virtual/range {v1 .. v7}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playOrShowIfEpisodeMatches(Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/bookmarks/VideoBookmark;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v1

    if-nez v1, :cond_0

    sget-object v11, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    move-object v6, p0

    move-object v7, p2

    move-object v8, v5

    move-object/from16 v9, p5

    move-object v10, p1

    .line 130
    invoke-virtual/range {v6 .. v11}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 131
    :cond_0
    const/4 v1, 0x1

    .line 143
    .end local v4    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local v5    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    :goto_0
    return v1

    .line 133
    :cond_1
    move-object/from16 v0, p3

    instance-of v1, v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    if-eqz v1, :cond_2

    move-object/from16 v12, p3

    .line 135
    check-cast v12, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 137
    .local v12, "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    invoke-virtual {v12}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTitle()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {p0, v1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->checkTitleMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v1

    if-eqz v1, :cond_2

    .line 139
    invoke-virtual {v12}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-direct {p0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playLiveStreamWithoutCheckingEntitlements(Ljava/lang/String;)V

    .line 140
    const/4 v1, 0x1

    goto :goto_0

    .line 143
    .end local v12    # "liveStreamBookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :cond_2
    const/4 v1, 0x0

    goto :goto_0
.end method

.method private showOrPlayLastWatched(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    .locals 5
    .param p1, "videoEntitlement"    # Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    .param p2, "filterText"    # Ljava/lang/String;
    .param p3, "lastWatchedBookmark"    # Lcom/xfinity/playerlib/bookmarks/Bookmark;
    .param p4, "dibicResource"    # Lcom/xfinity/playerlib/model/dibic/DibicResource;
    .param p5, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    const/4 v2, 0x1

    .line 150
    const-string v3, "last watched"

    invoke-virtual {p0, p2, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->checkTitleMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_4

    .line 152
    instance-of v3, p3, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    if-eqz v3, :cond_3

    move-object v1, p3

    .line 154
    check-cast v1, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;

    .line 155
    .local v1, "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-interface {p4, v3}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v0

    .line 157
    .local v0, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    sget-object v3, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->PLAY:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p5, v3}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_1

    .line 159
    invoke-virtual {p1, v0}, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;->isEntitled(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 160
    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v3

    invoke-virtual {v1}, Lcom/xfinity/playerlib/bookmarks/VideoBookmark;->getParentMerlinIdIfApplicable()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v4

    invoke-virtual {p0, v3, v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playVideo(Lcom/xfinity/playerlib/model/MerlinId;Lcom/xfinity/playerlib/model/MerlinId;)V

    .line 181
    .end local v0    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v1    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .end local p3    # "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :goto_0
    return v2

    .line 162
    .restart local v0    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .restart local v1    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    .restart local p3    # "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_0
    sget-object v3, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual {p0, v0, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->closeWithNotEntitledDibicProgram(Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)V

    goto :goto_0

    .line 166
    :cond_1
    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/dibic/DibicProgram;->isMovie()Z

    move-result v3

    if-eqz v3, :cond_2

    .line 167
    invoke-virtual {p0, v0}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->showVideoDetails(Lcom/xfinity/playerlib/model/dibic/DibicProgram;)V

    goto :goto_0

    .line 169
    :cond_2
    invoke-virtual {p0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->showSeriesFromVideoBookmark(Lcom/xfinity/playerlib/bookmarks/VideoBookmark;)V

    goto :goto_0

    .line 175
    .end local v0    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v1    # "videoBookmark":Lcom/xfinity/playerlib/bookmarks/VideoBookmark;
    :cond_3
    instance-of v3, p3, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    if-eqz v3, :cond_4

    .line 177
    check-cast p3, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .end local p3    # "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    invoke-virtual {p3}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v3

    invoke-direct {p0, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playLiveStreamWithoutCheckingEntitlements(Ljava/lang/String;)V

    goto :goto_0

    .line 181
    .restart local p3    # "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    :cond_4
    const/4 v2, 0x0

    goto :goto_0
.end method


# virtual methods
.method public attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 2
    .param p1, "terms"    # [Ljava/lang/String;
    .param p2, "presentationMode"    # Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    .prologue
    .line 65
    sget-object v0, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->SEARCH:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-virtual {p2, v0}, Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 66
    invoke-super {p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    .line 119
    :goto_0
    return-void

    .line 70
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    new-instance v1, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;

    invoke-direct {v1, p0, p1, p2}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;-><init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iput-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    goto :goto_0
.end method

.method protected getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 1

    .prologue
    .line 198
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->taskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    return-object v0
.end method

.method protected getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    .locals 1

    .prologue
    .line 203
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->taskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    return-object v0
.end method
