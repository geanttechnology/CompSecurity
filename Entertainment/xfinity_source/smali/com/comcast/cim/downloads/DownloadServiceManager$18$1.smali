.class Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;
.super Ljava/lang/Object;
.source "DownloadServiceManager.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/comcast/cim/downloads/DownloadServiceManager$18;->run()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$18;

.field final synthetic val$hlsFile:Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;


# direct methods
.method constructor <init>(Lcom/comcast/cim/downloads/DownloadServiceManager$18;Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;)V
    .locals 0
    .param p1, "this$1"    # Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    .prologue
    .line 876
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;"
    iput-object p1, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    iput-object p2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->val$hlsFile:Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 880
    .local p0, "this":Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;, "Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;"
    :try_start_0
    new-instance v1, Lorg/apache/commons/lang3/time/StopWatch;

    invoke-direct {v1}, Lorg/apache/commons/lang3/time/StopWatch;-><init>()V

    .line 881
    .local v1, "timer":Lorg/apache/commons/lang3/time/StopWatch;
    invoke-virtual {v1}, Lorg/apache/commons/lang3/time/StopWatch;->reset()V

    .line 882
    invoke-virtual {v1}, Lorg/apache/commons/lang3/time/StopWatch;->start()V

    .line 883
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    iget-object v2, v2, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->this$0:Lcom/comcast/cim/downloads/DownloadServiceManager;

    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->virtuosoService:Lcom/penthera/virtuososdk/client/Virtuoso;
    invoke-static {v2}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$500(Lcom/comcast/cim/downloads/DownloadServiceManager;)Lcom/penthera/virtuososdk/client/Virtuoso;

    move-result-object v2

    iget-object v3, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->val$hlsFile:Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    invoke-virtual {v2, v3}, Lcom/penthera/virtuososdk/client/Virtuoso;->addToQueue(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_0 .. :try_end_0} :catch_1

    .line 885
    :try_start_1
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    iget-object v2, v2, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$extraTask:Ljava/lang/Runnable;

    if-eqz v2, :cond_0

    .line 886
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    iget-object v2, v2, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$extraTask:Ljava/lang/Runnable;

    invoke-interface {v2}, Ljava/lang/Runnable;->run()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_1 .. :try_end_1} :catch_1

    .line 891
    :cond_0
    :try_start_2
    invoke-virtual {v1}, Lorg/apache/commons/lang3/time/StopWatch;->stop()V

    .line 892
    # getter for: Lcom/comcast/cim/downloads/DownloadServiceManager;->LOG:Lorg/slf4j/Logger;
    invoke-static {}, Lcom/comcast/cim/downloads/DownloadServiceManager;->access$000()Lorg/slf4j/Logger;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    const-string v4, "Added Virtuoso File to download Queue in "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " seconds"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-interface {v2, v3}, Lorg/slf4j/Logger;->debug(Ljava/lang/String;)V

    .line 894
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    iget-object v2, v2, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

    const/4 v3, 0x0

    invoke-interface {v2, v3}, Lcom/google/common/util/concurrent/FutureCallback;->onSuccess(Ljava/lang/Object;)V

    .line 898
    .end local v1    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    :goto_0
    return-void

    .line 888
    .restart local v1    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    :catch_0
    move-exception v0

    .line 889
    .local v0, "e":Ljava/lang/Exception;
    new-instance v2, Lcom/penthera/virtuososdk/client/ServiceException;

    invoke-direct {v2, v0}, Lcom/penthera/virtuososdk/client/ServiceException;-><init>(Ljava/lang/Throwable;)V

    throw v2
    :try_end_2
    .catch Lcom/penthera/virtuososdk/client/ServiceException; {:try_start_2 .. :try_end_2} :catch_1

    .line 895
    .end local v0    # "e":Ljava/lang/Exception;
    .end local v1    # "timer":Lorg/apache/commons/lang3/time/StopWatch;
    :catch_1
    move-exception v0

    .line 896
    .local v0, "e":Lcom/penthera/virtuososdk/client/ServiceException;
    iget-object v2, p0, Lcom/comcast/cim/downloads/DownloadServiceManager$18$1;->this$1:Lcom/comcast/cim/downloads/DownloadServiceManager$18;

    iget-object v2, v2, Lcom/comcast/cim/downloads/DownloadServiceManager$18;->val$resultCallback:Lcom/google/common/util/concurrent/FutureCallback;

    new-instance v3, Lcom/comcast/cim/downloads/DownloadServiceException;

    invoke-direct {v3, v0}, Lcom/comcast/cim/downloads/DownloadServiceException;-><init>(Ljava/lang/Throwable;)V

    invoke-interface {v2, v3}, Lcom/google/common/util/concurrent/FutureCallback;->onFailure(Ljava/lang/Throwable;)V

    goto :goto_0
.end method
