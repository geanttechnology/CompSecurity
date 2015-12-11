.class Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;
.super Ljava/lang/Object;
.source "DeferringTaskExecutionListener.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;

.field final synthetic val$exception:Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 0

    .prologue
    .line 38
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener.2;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;->val$exception:Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 40
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener.2;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->access$000(Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$2;->val$exception:Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V

    .line 41
    return-void
.end method
