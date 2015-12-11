.class Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "FeaturedSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
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


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    .prologue
    .line 70
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$terms:[Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 116
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->access$301(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;I)V

    .line 117
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/editorial/FeaturedResource;",
            "Lcom/comcast/cim/cmasl/utils/container/Option",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/Bookmark;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 75
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/editorial/FeaturedResource;Lcom/comcast/cim/cmasl/utils/container/Option<Lcom/xfinity/playerlib/bookmarks/Bookmark;>;Lcom/xfinity/playerlib/model/dibic/DibicResource;>;"
    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 76
    .local v1, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v12, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v12, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;

    .line 77
    .local v12, "featuredResource":Lcom/xfinity/playerlib/model/editorial/FeaturedResource;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$terms:[Ljava/lang/String;

    const-string v5, " "

    invoke-static {v0, v5}, Lorg/apache/commons/lang3/StringUtils;->join([Ljava/lang/Object;Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 79
    .local v2, "filterText":Ljava/lang/String;
    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    check-cast v0, Lcom/comcast/cim/cmasl/utils/container/Option;

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/utils/container/Option;->getValue()Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Lcom/xfinity/playerlib/bookmarks/Bookmark;

    .line 80
    .local v3, "lastWatchedBookmark":Lcom/xfinity/playerlib/bookmarks/Bookmark;
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 82
    .local v4, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    if-eqz v3, :cond_2

    .line 84
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->showOrPlayLastWatched(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    invoke-static/range {v0 .. v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->access$000(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 112
    :cond_0
    :goto_0
    return-void

    .line 88
    :cond_1
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->showOrPlayLastWatchIfTitleMatches(Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z
    invoke-static/range {v0 .. v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->access$100(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Ljava/lang/String;Lcom/xfinity/playerlib/bookmarks/Bookmark;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 93
    :cond_2
    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getCoverVideos()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_3
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_4

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/model/EditorialProgram;

    .line 94
    .local v7, "video":Lcom/xfinity/playerlib/model/EditorialProgram;
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v9, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v11, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    move-object v6, v2

    move-object v8, v4

    move-object v10, v1

    invoke-virtual/range {v5 .. v11}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playOrShowIfProgramMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v5

    if-eqz v5, :cond_3

    goto :goto_0

    .line 99
    .end local v7    # "video":Lcom/xfinity/playerlib/model/EditorialProgram;
    :cond_4
    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getMovies()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_5
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_6

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/model/EditorialProgram;

    .line 100
    .restart local v7    # "video":Lcom/xfinity/playerlib/model/EditorialProgram;
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v9, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v11, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    move-object v6, v2

    move-object v8, v4

    move-object v10, v1

    invoke-virtual/range {v5 .. v11}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playOrShowIfProgramMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v5

    if-eqz v5, :cond_5

    goto :goto_0

    .line 105
    .end local v7    # "video":Lcom/xfinity/playerlib/model/EditorialProgram;
    :cond_6
    invoke-virtual {v12}, Lcom/xfinity/playerlib/model/editorial/FeaturedResource;->getSeries()Ljava/util/List;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    :cond_7
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v5

    if-eqz v5, :cond_8

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/model/EditorialProgram;

    .line 106
    .restart local v7    # "video":Lcom/xfinity/playerlib/model/EditorialProgram;
    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v9, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v11, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    move-object v6, v2

    move-object v8, v4

    move-object v10, v1

    invoke-virtual/range {v5 .. v11}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->playOrShowIfProgramMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/EditorialProgram;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v5

    if-eqz v5, :cond_7

    goto :goto_0

    .line 111
    .end local v7    # "video":Lcom/xfinity/playerlib/model/EditorialProgram;
    :cond_8
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;

    iget-object v5, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$terms:[Ljava/lang/String;

    iget-object v6, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v0, v5, v6}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;->access$201(Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 70
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FeaturedSpeechRecognizer$2;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    return-void
.end method
