.class Lnet/singular/sdk/Collector$2;
.super Ljava/lang/Object;
.source "Collector.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lnet/singular/sdk/Collector;->runExternalJob(Ljava/lang/String;Ljava/lang/Runnable;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lnet/singular/sdk/Collector;

.field final synthetic val$name:Ljava/lang/String;

.field final synthetic val$setRunnable:Ljava/lang/Runnable;

.field final synthetic val$waitSem:Ljava/util/concurrent/Semaphore;


# direct methods
.method constructor <init>(Lnet/singular/sdk/Collector;Ljava/lang/Runnable;Ljava/lang/String;Ljava/util/concurrent/Semaphore;)V
    .locals 0

    .prologue
    .line 136
    iput-object p1, p0, Lnet/singular/sdk/Collector$2;->this$0:Lnet/singular/sdk/Collector;

    iput-object p2, p0, Lnet/singular/sdk/Collector$2;->val$setRunnable:Ljava/lang/Runnable;

    iput-object p3, p0, Lnet/singular/sdk/Collector$2;->val$name:Ljava/lang/String;

    iput-object p4, p0, Lnet/singular/sdk/Collector$2;->val$waitSem:Ljava/util/concurrent/Semaphore;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 7

    .prologue
    .line 140
    :try_start_0
    iget-object v1, p0, Lnet/singular/sdk/Collector$2;->val$setRunnable:Ljava/lang/Runnable;

    invoke-interface {v1}, Ljava/lang/Runnable;->run()V
    :try_end_0
    .catch Ljava/lang/RuntimeException; {:try_start_0 .. :try_end_0} :catch_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 146
    :try_start_1
    iget-object v1, p0, Lnet/singular/sdk/Collector$2;->val$waitSem:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v1}, Ljava/util/concurrent/Semaphore;->release()V
    :try_end_1
    .catch Ljava/lang/RuntimeException; {:try_start_1 .. :try_end_1} :catch_3

    .line 149
    :goto_0
    return-void

    .line 141
    :catch_0
    move-exception v0

    .line 142
    .local v0, "e":Ljava/lang/RuntimeException;
    :try_start_2
    iget-object v1, p0, Lnet/singular/sdk/Collector$2;->this$0:Lnet/singular/sdk/Collector;

    # getter for: Lnet/singular/sdk/Collector;->log:Lnet/singular/sdk/SingularLog;
    invoke-static {v1}, Lnet/singular/sdk/Collector;->access$200(Lnet/singular/sdk/Collector;)Lnet/singular/sdk/SingularLog;

    move-result-object v1

    const-string v2, "singular_sdk"

    const-string v3, "runExternalJob(%s) failed"

    const/4 v4, 0x1

    new-array v4, v4, [Ljava/lang/Object;

    const/4 v5, 0x0

    iget-object v6, p0, Lnet/singular/sdk/Collector$2;->val$name:Ljava/lang/String;

    aput-object v6, v4, v5

    invoke-static {v3, v4}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3, v0}, Lnet/singular/sdk/SingularLog;->trackError(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 146
    :try_start_3
    iget-object v1, p0, Lnet/singular/sdk/Collector$2;->val$waitSem:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v1}, Ljava/util/concurrent/Semaphore;->release()V
    :try_end_3
    .catch Ljava/lang/RuntimeException; {:try_start_3 .. :try_end_3} :catch_1

    goto :goto_0

    .line 147
    :catch_1
    move-exception v1

    goto :goto_0

    .line 145
    .end local v0    # "e":Ljava/lang/RuntimeException;
    :catchall_0
    move-exception v1

    .line 146
    :try_start_4
    iget-object v2, p0, Lnet/singular/sdk/Collector$2;->val$waitSem:Ljava/util/concurrent/Semaphore;

    invoke-virtual {v2}, Ljava/util/concurrent/Semaphore;->release()V
    :try_end_4
    .catch Ljava/lang/RuntimeException; {:try_start_4 .. :try_end_4} :catch_2

    .line 147
    :goto_1
    throw v1

    :catch_2
    move-exception v2

    goto :goto_1

    :catch_3
    move-exception v1

    goto :goto_0
.end method
