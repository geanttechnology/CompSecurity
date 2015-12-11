.class Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "LiveStreamsSpeechRecognizer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
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
        "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        "Ljava/util/List",
        "<",
        "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
        ">;>;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

.field final synthetic val$filterText:Ljava/lang/String;

.field final synthetic val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

.field final synthetic val$terms:[Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Ljava/lang/String;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    .prologue
    .line 45
    iput-object p1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    iput-object p2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    iput-object p3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iput-object p4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 66
    iget-object v0, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    const/4 v1, 0x0

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->onError(I)V
    invoke-static {v0, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$401(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;I)V

    .line 67
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 5
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/utils/container/Tuple3",
            "<",
            "Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;",
            "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
            "Ljava/util/List",
            "<",
            "Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;",
            ">;>;)V"
        }
    .end annotation

    .prologue
    .line 50
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;>;"
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    # setter for: Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v2, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$102(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 51
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v1, Ljava/util/List;

    # setter for: Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamBookmarks:Ljava/util/List;
    invoke-static {v2, v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$202(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;Ljava/util/List;)Ljava/util/List;

    .line 53
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->liveStreamBookmarks:Ljava/util/List;
    invoke-static {v1}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$200(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Ljava/util/List;

    move-result-object v1

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_1

    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;

    .line 55
    .local v0, "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getTitle()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->val$filterText:Ljava/lang/String;

    invoke-virtual {v2, v3, v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->checkTitleMatch(Ljava/lang/String;Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 56
    iget-object v2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;->getStreamId()Ljava/lang/String;

    move-result-object v3

    iget-object v1, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e2:Ljava/lang/Object;

    check-cast v1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    iget-object v4, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    # getter for: Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$100(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    move-result-object v4

    invoke-virtual {v2, v3, v1, v4}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->playLiveStream(Ljava/lang/String;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)V

    .line 62
    .end local v0    # "bookmark":Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;
    :goto_0
    return-void

    .line 61
    :cond_1
    iget-object v1, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->this$0:Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;

    iget-object v2, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->val$terms:[Ljava/lang/String;

    iget-object v3, p0, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->val$presentationMode:Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;

    # invokes: Lcom/xfinity/playerlib/alt/speechrecognizers/PlayerSpeechRecognizer;->attemptSearch([Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V
    invoke-static {v1, v2, v3}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;->access$301(Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer;[Ljava/lang/String;Lcom/comcast/cim/android/accessibility/SpeechPresentationMode;)V

    goto :goto_0
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 45
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/alt/speechrecognizers/LiveStreamsSpeechRecognizer$1;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method
