.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "LiveStreamsFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
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
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 469
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "error"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 487
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->loadingViewDelegate:Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1800(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;

    move-result-object v0

    invoke-virtual {v0}, Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate;->onLoadingFailed()V

    .line 488
    return-void
.end method

.method public onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V
    .locals 2
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
    .line 478
    .local p1, "resource":Lcom/comcast/cim/cmasl/utils/container/Tuple3;, "Lcom/comcast/cim/cmasl/utils/container/Tuple3<Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;Ljava/util/List<Lcom/xfinity/playerlib/bookmarks/LiveStreamBookmark;>;>;"
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e1:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    # setter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->videoEntitlement:Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;
    invoke-static {v1, v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1502(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;)Lcom/xfinity/playerlib/model/entitlement/VideoEntitlement;

    .line 479
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e3:Ljava/lang/Object;

    check-cast v0, Ljava/util/List;

    # setter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreamBookmarks:Ljava/util/List;
    invoke-static {v1, v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1602(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Ljava/util/List;)Ljava/util/List;

    .line 480
    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    iget-object v0, p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;->e2:Ljava/lang/Object;

    check-cast v0, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->getLiveStreams()Ljava/util/List;

    move-result-object v0

    # setter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->liveStreams:Ljava/util/List;
    invoke-static {v1, v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1002(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;Ljava/util/List;)Ljava/util/List;

    .line 481
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->displayLiveStreams()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1700(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V

    .line 482
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$id;->ACCESSIBILITY_ANNOUNCE_LOADED:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 483
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 469
    check-cast p1, Lcom/comcast/cim/cmasl/utils/container/Tuple3;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->onPostExecute(Lcom/comcast/cim/cmasl/utils/container/Tuple3;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 2

    .prologue
    .line 473
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$6;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->alternateInterfaceListener:Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$1400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;

    move-result-object v0

    invoke-interface {v0}, Lcom/comcast/cim/android/accessibility/AlternateInterfaceListener;->getTalkDelegate()Lcom/comcast/cim/android/accessibility/TalkDelegate;

    move-result-object v0

    sget v1, Lcom/xfinity/playerlib/R$string;->loading:I

    invoke-interface {v0, v1}, Lcom/comcast/cim/android/accessibility/TalkDelegate;->speakManagedMessage(I)V

    .line 474
    return-void
.end method
