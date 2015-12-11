.class Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$7;
.super Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;
.source "StartState.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->fetchLiveStreamByName(Ljava/lang/String;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener",
        "<",
        "Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;
    .param p3, "x1"    # Landroid/content/Context;
    .param p4, "x2"    # Lcom/comcast/cim/android/view/common/ErrorDialogFactory;
    .param p5, "x3"    # Landroid/content/DialogInterface$OnCancelListener;

    .prologue
    .line 305
    .local p2, "x0":Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;, "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor<Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$7;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    invoke-direct {p0, p2, p3, p4, p5}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;Landroid/content/Context;Lcom/comcast/cim/android/view/common/ErrorDialogFactory;Landroid/content/DialogInterface$OnCancelListener;)V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 1
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 313
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$7;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->getUiController()Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;

    move-result-object v0

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/videoplay/VideoPlayerFragment$PlayerUIController;->hideLaunchScreen()V

    .line 314
    invoke-super {p0, p1}, Lcom/comcast/cim/model/provider/RetryingTaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    .line 315
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V
    .locals 1
    .param p1, "result"    # Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    .prologue
    .line 308
    iget-object v0, p0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$7;->this$0:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;

    iget-object v0, v0, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState;->stateController:Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;

    invoke-virtual {v0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/VideoStateController;->onLiveStreamFetched(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    .line 309
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 305
    check-cast p1, Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/model/videoplay/adobeplayer/StartState$7;->onPostExecute(Lcom/xfinity/playerlib/model/consumable/hal/HalLiveStream;)V

    return-void
.end method
