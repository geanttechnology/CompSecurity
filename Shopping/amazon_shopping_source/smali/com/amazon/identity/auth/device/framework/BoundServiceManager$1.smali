.class Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;
.super Ljava/lang/Object;
.source "BoundServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->callbackWhenServiceIsAvailable(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;


# direct methods
.method constructor <init>(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)V
    .locals 0

    .prologue
    .line 281
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager.1;"
    iput-object p1, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 286
    .local p0, "this":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager.1;"
    iget-object v4, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    monitor-enter v4

    .line 288
    :try_start_0
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mBoundService:Ljava/lang/Object;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$000(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Ljava/lang/Object;

    move-result-object v3

    if-eqz v3, :cond_1

    .line 290
    monitor-exit v4

    .line 308
    :cond_0
    return-void

    .line 293
    :cond_1
    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->TAG:Ljava/lang/String;
    invoke-static {}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$100()Ljava/lang/String;

    move-result-object v3

    new-instance v5, Ljava/lang/StringBuilder;

    const-string/jumbo v6, "Application timed out trying to bind to "

    invoke-direct {v5, v6}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v6, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mComponentName:Landroid/content/ComponentName;
    invoke-static {v6}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$200(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Landroid/content/ComponentName;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    invoke-static {v3, v5}, Lcom/amazon/identity/auth/device/utils/MAPLog;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 296
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$300(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Ljava/util/List;

    move-result-object v1

    .line 297
    .local v1, "queue":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;>;"
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    const/4 v5, 0x0

    # setter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mQueue:Ljava/util/List;
    invoke-static {v3, v5}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$302(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;Ljava/util/List;)Ljava/util/List;

    .line 298
    monitor-exit v4
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 300
    if-eqz v1, :cond_0

    .line 302
    const-string/jumbo v3, "BindTimeout"

    const/4 v4, 0x0

    new-array v4, v4, [Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/amazon/identity/platform/metric/MetricsHelper;->increasePeriodicCounter(Ljava/lang/String;[Ljava/lang/String;)V

    .line 303
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v0

    .local v0, "i$":Ljava/util/Iterator;
    :goto_0
    invoke-interface {v0}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-eqz v3, :cond_0

    invoke-interface {v0}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;

    .line 305
    .local v2, "task":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    iget-object v3, p0, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$1;->this$0:Lcom/amazon/identity/auth/device/framework/BoundServiceManager;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->mExecutor:Ljava/util/concurrent/Executor;
    invoke-static {v3}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager;->access$500(Lcom/amazon/identity/auth/device/framework/BoundServiceManager;)Ljava/util/concurrent/Executor;

    move-result-object v3

    new-instance v4, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;

    # getter for: Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->mCallback:Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;
    invoke-static {v2}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;->access$400(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;)Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;

    move-result-object v5

    invoke-direct {v4, v5}, Lcom/amazon/identity/auth/device/framework/BoundServiceManager$OnErrorRunnable;-><init>(Lcom/amazon/identity/auth/device/framework/BoundServiceManager$BoundServiceCallback;)V

    invoke-interface {v3, v4}, Ljava/util/concurrent/Executor;->execute(Ljava/lang/Runnable;)V

    goto :goto_0

    .line 298
    .end local v0    # "i$":Ljava/util/Iterator;
    .end local v1    # "queue":Ljava/util/List;, "Ljava/util/List<Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;>;"
    .end local v2    # "task":Lcom/amazon/identity/auth/device/framework/BoundServiceManager$RunnableBoundServiceCallback;, "Lcom/amazon/identity/auth/device/framework/BoundServiceManager<TT;>.RunnableBoundServiceCallback;"
    :catchall_0
    move-exception v3

    monitor-exit v4

    throw v3
.end method
