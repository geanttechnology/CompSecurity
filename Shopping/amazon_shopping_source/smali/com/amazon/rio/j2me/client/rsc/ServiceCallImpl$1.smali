.class Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;
.super Ljava/lang/Object;
.source "ServiceCallImpl.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->cancel()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

.field final synthetic val$worker:Lcom/amazon/rio/j2me/client/util/Worker;


# direct methods
.method constructor <init>(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;Lcom/amazon/rio/j2me/client/util/Worker;)V
    .locals 0

    .prologue
    .line 262
    iput-object p1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;->this$0:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    iput-object p2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;->val$worker:Lcom/amazon/rio/j2me/client/util/Worker;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 4

    .prologue
    .line 264
    :try_start_0
    iget-object v1, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;->this$0:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    # getter for: Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->serverConnection:Lcom/amazon/rio/j2me/client/trans/IServiceConnection;
    invoke-static {v1}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->access$000(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)Lcom/amazon/rio/j2me/client/trans/IServiceConnection;

    move-result-object v1

    invoke-interface {v1}, Lcom/amazon/rio/j2me/client/trans/IServiceConnection;->cancel()V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 268
    # getter for: Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;
    invoke-static {}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->access$300()Lcom/amazon/rio/j2me/client/util/WorkerPool;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;->val$worker:Lcom/amazon/rio/j2me/client/util/Worker;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->releaseWorker(Lcom/amazon/rio/j2me/client/util/Worker;)V

    .line 269
    :goto_0
    return-void

    .line 265
    :catch_0
    move-exception v0

    .line 266
    .local v0, "e":Ljava/lang/Exception;
    :try_start_1
    # getter for: Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->logger:Lcom/amazon/rio/j2me/client/util/Logger;
    invoke-static {}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->access$200()Lcom/amazon/rio/j2me/client/util/Logger;

    move-result-object v1

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v3, "serverConnection.cancel() failed: id="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;->this$0:Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;

    # getter for: Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->id:I
    invoke-static {v3}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->access$100(Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;)I

    move-result v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string/jumbo v3, " exp="

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v1, v2}, Lcom/amazon/rio/j2me/client/util/Logger;->error(Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    .line 268
    # getter for: Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;
    invoke-static {}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->access$300()Lcom/amazon/rio/j2me/client/util/WorkerPool;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;->val$worker:Lcom/amazon/rio/j2me/client/util/Worker;

    invoke-virtual {v1, v2}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->releaseWorker(Lcom/amazon/rio/j2me/client/util/Worker;)V

    goto :goto_0

    .end local v0    # "e":Ljava/lang/Exception;
    :catchall_0
    move-exception v1

    # getter for: Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->workerPool:Lcom/amazon/rio/j2me/client/util/WorkerPool;
    invoke-static {}, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl;->access$300()Lcom/amazon/rio/j2me/client/util/WorkerPool;

    move-result-object v2

    iget-object v3, p0, Lcom/amazon/rio/j2me/client/rsc/ServiceCallImpl$1;->val$worker:Lcom/amazon/rio/j2me/client/util/Worker;

    invoke-virtual {v2, v3}, Lcom/amazon/rio/j2me/client/util/WorkerPool;->releaseWorker(Lcom/amazon/rio/j2me/client/util/Worker;)V

    throw v1
.end method
