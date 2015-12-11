.class Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "FavoriteSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
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
        "Lcom/xfinity/playerlib/model/Favorite;",
        ">;",
        "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        ">;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

.field final synthetic val$filterText:Ljava/lang/String;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;[Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    .prologue
    .line 56
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    iput-object p4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 92
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->access$201(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;I)V

    .line 93
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V
    .locals 13
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple4",
            "<",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/model/Favorite;",
            ">;",
            "Lcom/xfinity/playerlib/model/dibic/DibicResource;",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 61
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple4;, "Lcom/comcast/cim/cmasl/utils/container/Tuple4<Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;Lcom/xfinity/playerlib/model/dibic/DibicResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    iget-object v8, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e1:Ljava/lang/Object;

    check-cast v8, Ljava/util/List;

    .line 62
    .local v8, "favorites":Ljava/util/List;, "Ljava/util/List<Lcom/xfinity/playerlib/model/Favorite;>;"
    iget-object v6, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e2:Ljava/lang/Object;

    check-cast v6, Lcom/xfinity/playerlib/model/dibic/DibicResource;

    .line 63
    .local v6, "dibicResource":Lcom/xfinity/playerlib/model/dibic/DibicResource;
    iget-object v4, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e3:Ljava/lang/Object;

    check-cast v4, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 64
    .local v4, "videoEntitlement":Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    iget-object v9, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;->e4:Ljava/lang/Object;

    check-cast v9, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .line 66
    .local v9, "halLiveStreamResource":Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;
    invoke-interface {v8}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v12

    :cond_0
    invoke-interface {v12}, Ljava/util/Iterator;->hasNext()Z

    move-result v0

    if-eqz v0, :cond_2

    invoke-interface {v12}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v7

    check-cast v7, Lcom/xfinity/playerlib/model/Favorite;

    .line 68
    .local v7, "favorite":Lcom/xfinity/playerlib/model/Favorite;
    instance-of v0, v7, Lcom/xfinity/playerlib/model/VideoFavorite;

    if-eqz v0, :cond_1

    move-object v11, v7

    .line 70
    check-cast v11, Lcom/xfinity/playerlib/model/VideoFavorite;

    .line 71
    .local v11, "videoFavorite":Lcom/xfinity/playerlib/model/VideoFavorite;
    invoke-virtual {v11}, Lcom/xfinity/playerlib/model/VideoFavorite;->getMerlinId()Lcom/xfinity/playerlib/model/MerlinId;

    move-result-object v0

    invoke-interface {v6, v0}, Lcom/xfinity/playerlib/model/dibic/DibicResource;->getProgramByMerlinId(Lcom/xfinity/playerlib/model/MerlinId;)Lcom/xfinity/playerlib/model/dibic/DibicProgram;

    move-result-object v2

    .line 73
    .local v2, "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    sget-object v5, Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;->PLAYBACK:Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;

    invoke-virtual/range {v0 .. v5}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->playOrShowIfVideoMatches(Ljava/lang/String;Lcom/xfinity/playerlib/model/dibic/DibicProgram;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/view/common/UpsellDialog$UpsellType;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 88
    .end local v2    # "dibicProgram":Lcom/xfinity/playerlib/model/dibic/DibicProgram;
    .end local v7    # "favorite":Lcom/xfinity/playerlib/model/Favorite;
    .end local v11    # "videoFavorite":Lcom/xfinity/playerlib/model/VideoFavorite;
    :goto_0
    return-void

    .line 76
    .restart local v7    # "favorite":Lcom/xfinity/playerlib/model/Favorite;
    :cond_1
    instance-of v0, v7, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    if-eqz v0, :cond_0

    move-object v10, v7

    .line 78
    check-cast v10, Lcom/xfinity/playerlib/model/LiveStreamFavorite;

    .line 80
    .local v10, "liveStreamFavorite":Lcom/xfinity/playerlib/model/LiveStreamFavorite;
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getTitle()Ljava/lang/String;

    move-result-object v1

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    invoke-virtual {v0, v1, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->checkTitleMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 81
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    invoke-virtual {v10}, Lcom/xfinity/playerlib/model/LiveStreamFavorite;->getStreamId()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1, v9, v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->playLiveStream(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    goto :goto_0

    .line 87
    .end local v7    # "favorite":Lcom/xfinity/playerlib/model/Favorite;
    .end local v10    # "liveStreamFavorite":Lcom/xfinity/playerlib/model/LiveStreamFavorite;
    :cond_2
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;

    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v0, v1, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;->access$101(Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 56
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple4;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/FavoriteSpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple4;)V

    return-void
.end method
