.class Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;
.super Ljava/lang/Object;
.source "LiveStreamsFragment.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/android/util/view/widget/DefaultLoadingViewDelegate$ReadyListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->onCreateView(Landroid/view/LayoutInflater;Landroid/view/ViewGroup;Landroid/os/Bundle;)Landroid/view/View;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;


# direct methods
.method constructor <init>(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)V
    .locals 0
    .param p1, "this$0"    # Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    .prologue
    .line 266
    iput-object p1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onReady()V
    .locals 2

    .prologue
    .line 269
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getTaskExecutor()Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    invoke-virtual {v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->getTaskExecutionListener()Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 271
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # invokes: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->isInBabyGuide()Z
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$400(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 272
    iget-object v0, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutor:Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$600(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;

    move-result-object v0

    iget-object v1, p0, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment$3;->this$0:Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;

    # getter for: Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->featuredContentTaskExecutionListener:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v1}, Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;->access$500(Lcom/xfinity/playerlib/view/browseprograms/LiveStreamsFragment;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;->execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 274
    :cond_0
    return-void
.end method
