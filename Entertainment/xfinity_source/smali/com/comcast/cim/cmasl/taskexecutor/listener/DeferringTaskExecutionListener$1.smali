.class Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;
.super Ljava/lang/Object;
.source "DeferringTaskExecutionListener.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->onPostExecute(Ljava/lang/Object;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;

.field final synthetic val$result:Ljava/lang/Object;


# direct methods
.method constructor <init>(Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 24
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener.1;"
    iput-object p1, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;

    iput-object p2, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;->val$result:Ljava/lang/Object;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 26
    .local p0, "this":Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener.1;"
    iget-object v0, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;->this$0:Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;

    # getter for: Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->delegate:Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    invoke-static {v0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;->access$000(Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    move-result-object v0

    iget-object v1, p0, Lcom/comcast/cim/cmasl/taskexecutor/listener/DeferringTaskExecutionListener$1;->val$result:Ljava/lang/Object;

    invoke-interface {v0, v1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPostExecute(Ljava/lang/Object;)V

    .line 27
    return-void
.end method
