.class Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;
.source "PreDownloadFlowFragment.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DeferWhenPausedTaskExecutionListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "<T:",
        "Ljava/lang/Object;",
        ">",
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener",
        "<TT;>;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<TT;>;)V"
        }
    .end annotation

    .prologue
    .line 948
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener<TT;>;"
    .local p2, "delegate":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<TT;>;"
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    .line 949
    invoke-direct {p0, p2}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;-><init>(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    .line 950
    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;
    .param p2, "x1"    # Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .param p3, "x2"    # Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$1;

    .prologue
    .line 946
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener<TT;>;"
    invoke-direct {p0, p1, p2}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V

    return-void
.end method


# virtual methods
.method protected onDefer(Ljava/lang/Runnable;)V
    .locals 1
    .param p1, "runnable"    # Ljava/lang/Runnable;

    .prologue
    .line 963
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->abortFlow()V

    .line 964
    return-void
.end method

.method protected shouldDefer()Z
    .locals 1

    .prologue
    .line 954
    .local p0, "this":Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;, "Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener<TT;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment$DeferWhenPausedTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/PreDownloadFlowFragment;->isResumed()Z

    move-result v0

    if-nez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
