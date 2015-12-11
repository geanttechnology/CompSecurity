.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;
.super Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
.source "StartState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchLiveStreamById(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

.field final synthetic val$streamId:Ljava/lang/String;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;Ljava/lang/String;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
    .param p3, "x1"    # Landroid/content/Context;
    .param p4, "x2"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .param p5, "x3"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 280
    .local p2, "x0":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iput-object p6, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;->val$streamId:Ljava/lang/String;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 289
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideLaunchScreen()V

    .line 290
    invoke-super {p0, p1}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    .line 291
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;)V
    .locals 2
    .param p1, "resource"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    .prologue
    .line 284
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    iget-object v1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;->val$streamId:Ljava/lang/String;

    invoke-virtual {p1, v1}, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;->getLiveStream(Ljava/lang/String;)Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 285
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 280
    check-cast p1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$6;->onPostExecute(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStreamResource;)V

    return-void
.end method
