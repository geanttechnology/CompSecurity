.class Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;
.super Ljava/lang/Object;
.source "SeriesEntityActivity.java"

# interfaces
.implements Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ProxyTaskExecutor"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Object;",
        "Lcom/comcast/cim/cmasl/taskexecutor/executor/TaskExecutor",
        "<",
        "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
        ">;"
    }
.end annotation


# instance fields
.field final synthetic this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;


# direct methods
.method private constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V
    .locals 0

    .prologue
    .line 385
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;

    .prologue
    .line 385
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    return-void
.end method


# virtual methods
.method public cancelNotificationsFor(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;)V"
        }
    .end annotation

    .prologue
    .line 402
    .local p1, "taskExecutionListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<Lcom/xfinity/playerlib/view/programdetails/SeriesResource;>;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Set;->remove(Ljava/lang/Object;)Z

    .line 403
    return-void
.end method

.method public execute(Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;)Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;
    .locals 2
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "<",
            "L::Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener",
            "<",
            "Lcom/xfinity/playerlib/view/programdetails/SeriesResource;",
            ">;>(T",
            "L;",
            ")T",
            "L;"
        }
    .end annotation

    .prologue
    .line 389
    .local p1, "delegateListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "TL;"
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0}, Ljava/util/Set;->isEmpty()Z

    move-result v0

    if-eqz v0, :cond_0

    .line 390
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 391
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$200()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Fetching data for delegate listener {}"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 392
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->triggerLoading()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$400(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    .line 397
    :goto_0
    return-object p1

    .line 394
    :cond_0
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutor;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Ljava/util/Set;

    move-result-object v0

    invoke-interface {v0, p1}, Ljava/util/Set;->add(Ljava/lang/Object;)Z

    .line 395
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$200()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Added {} to the list of pending listeners for in-progress fetch"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0
.end method
