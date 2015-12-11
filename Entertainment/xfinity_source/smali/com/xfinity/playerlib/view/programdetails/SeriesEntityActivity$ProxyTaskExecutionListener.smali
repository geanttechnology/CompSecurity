.class Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;
.super Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;
.source "SeriesEntityActivity.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "ProxyTaskExecutionListener"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener",
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
    .line 406
    iput-object p1, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-direct {p0}, Lcom/comcast/cim/cmasl/taskexecutor/listener/DefaultTaskExecutionListener;-><init>()V

    return-void
.end method

.method synthetic constructor <init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;)V
    .locals 0
    .param p1, "x0"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;
    .param p2, "x1"    # Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$1;

    .prologue
    .line 406
    invoke-direct {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;-><init>(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    return-void
.end method


# virtual methods
.method public onError(Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;)V
    .locals 2
    .param p1, "exception"    # Lcom/comcast/cim/cmasl/taskexecutor/exceptions/TaskExecutionException;

    .prologue
    .line 428
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$200()Lorg/slf4j/Logger;

    move-result-object v0

    const-string v1, "Proxy fetch listener received error"

    invoke-interface {v0, v1, p1}, Lorg/slf4j/Logger;->error(Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 429
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # invokes: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->showError()V
    invoke-static {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$900(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)V

    .line 430
    return-void
.end method

.method public onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V
    .locals 5
    .param p1, "resource"    # Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    .prologue
    .line 415
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$200()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Data fetched with {} pending listeners"

    iget-object v4, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;
    invoke-static {v4}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Ljava/util/Set;

    move-result-object v4

    invoke-interface {v4}, Ljava/util/Set;->size()I

    move-result v4

    invoke-static {v4}, Ljava/lang/Integer;->valueOf(I)Ljava/lang/Integer;

    move-result-object v4

    invoke-interface {v2, v3, v4}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    .line 416
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->pendingListeners:Ljava/util/Set;
    invoke-static {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$800(Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;)Ljava/util/Set;

    move-result-object v2

    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v1

    .line 417
    .local v1, "iterator":Ljava/util/Iterator;, "Ljava/util/Iterator<Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<Lcom/xfinity/playerlib/view/programdetails/SeriesResource;>;>;"
    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-eqz v2, :cond_0

    .line 418
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;

    .line 419
    .local v0, "delegateListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<Lcom/xfinity/playerlib/view/programdetails/SeriesResource;>;"
    invoke-interface {v0, p1}, Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;->onPostExecute(Ljava/lang/Object;)V

    .line 420
    invoke-interface {v1}, Ljava/util/Iterator;->remove()V

    .line 421
    # getter for: Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->access$200()Lorg/slf4j/Logger;

    move-result-object v2

    const-string v3, "Delegate listener {} notified"

    invoke-interface {v2, v3, v0}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;Ljava/lang/Object;)V

    goto :goto_0

    .line 423
    .end local v0    # "delegateListener":Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener;, "Lcom/comcast/cim/cmasl/taskexecutor/listener/TaskExecutionListener<Lcom/xfinity/playerlib/view/programdetails/SeriesResource;>;"
    :cond_0
    iget-object v2, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-virtual {v2}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->hideLoading()V

    .line 424
    return-void
.end method

.method public bridge synthetic onPostExecute(Ljava/lang/Object;)V
    .locals 0

    .prologue
    .line 406
    check-cast p1, Lcom/xfinity/playerlib/view/programdetails/SeriesResource;

    invoke-virtual {p0, p1}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;->onPostExecute(Lcom/xfinity/playerlib/view/programdetails/SeriesResource;)V

    return-void
.end method

.method public onPreAsynchronousExecute()V
    .locals 1

    .prologue
    .line 410
    iget-object v0, p0, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity$ProxyTaskExecutionListener;->this$0:Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;

    invoke-virtual {v0}, Lcom/xfinity/playerlib/view/programdetails/SeriesEntityActivity;->showLoading()V

    .line 411
    return-void
.end method
