.class Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;
.super Ljava/lang/Object;
.source "Downloader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->begin()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    .line 1752
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 5

    .prologue
    .line 1757
    :goto_0
    :try_start_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->getNext()Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;

    move-result-object v0

    .local v0, "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    if-eqz v0, :cond_0

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mAbort:Z
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$2(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_1

    move-result v2

    if-eqz v2, :cond_2

    .line 1781
    :cond_0
    :goto_1
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)I

    move-result v3

    add-int/lit8 v3, v3, -0x1

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$1(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;I)V

    .line 1782
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)I

    move-result v2

    if-gtz v2, :cond_1

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mAbort:Z
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$2(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Z

    move-result v2

    if-nez v2, :cond_1

    .line 1783
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v2

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3

    .line 1784
    :try_start_1
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v2

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->notify()V

    .line 1783
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_4

    .line 1788
    :cond_1
    return-void

    .line 1758
    :cond_2
    :try_start_2
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->download(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    invoke-static {v2, v0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$3(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v1

    .line 1760
    .local v1, "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mHlsWorkerLock:Ljava/lang/Object;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$4(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 1761
    :try_start_3
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v2

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$1(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Z

    move-result v2

    if-eqz v2, :cond_3

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v2

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$2(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v1

    .line 1763
    :cond_3
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mAbort:Z
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$2(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Z

    move-result v2

    if-nez v2, :cond_4

    .line 1764
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v2

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v2

    invoke-static {v2, v1}, Lcom/penthera/virtuososdk/download/Downloader;->access$1(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V

    .line 1768
    :cond_4
    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v1, v2, :cond_6

    .line 1769
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    const/4 v4, 0x1

    invoke-static {v2, v4}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$5(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;Z)V

    .line 1771
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mClient:Lorg/apache/http/client/HttpClient;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$6(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lorg/apache/http/client/HttpClient;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v2

    invoke-interface {v2}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V

    .line 1772
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v2

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Ljava/lang/Object;

    move-result-object v4

    monitor-enter v4
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1773
    :try_start_4
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v2

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Ljava/lang/Object;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/Object;->notify()V

    .line 1772
    monitor-exit v4
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_2

    .line 1775
    :try_start_5
    monitor-exit v3

    goto/16 :goto_1

    .line 1760
    :catchall_0
    move-exception v2

    monitor-exit v3
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    :try_start_6
    throw v2
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 1780
    .end local v0    # "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    .end local v1    # "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :catchall_1
    move-exception v2

    .line 1781
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I
    invoke-static {v3}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)I

    move-result v4

    add-int/lit8 v4, v4, -0x1

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$1(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;I)V

    .line 1782
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I
    invoke-static {v3}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)I

    move-result v3

    if-gtz v3, :cond_5

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mAbort:Z
    invoke-static {v3}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$2(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Z

    move-result v3

    if-nez v3, :cond_5

    .line 1783
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v3}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v3

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;
    invoke-static {v3}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Ljava/lang/Object;

    move-result-object v3

    monitor-enter v3

    .line 1784
    :try_start_7
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;->this$2:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    invoke-static {v4}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    move-result-object v4

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;
    invoke-static {v4}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Ljava/lang/Object;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/Object;->notify()V

    .line 1783
    monitor-exit v3
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_3

    .line 1787
    :cond_5
    throw v2

    .line 1772
    .restart local v0    # "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    .restart local v1    # "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :catchall_2
    move-exception v2

    :try_start_8
    monitor-exit v4
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_2

    :try_start_9
    throw v2

    .line 1760
    :cond_6
    monitor-exit v3
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    goto/16 :goto_0

    .line 1783
    .end local v0    # "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    .end local v1    # "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :catchall_3
    move-exception v2

    :try_start_a
    monitor-exit v3
    :try_end_a
    .catchall {:try_start_a .. :try_end_a} :catchall_3

    throw v2

    .restart local v0    # "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    :catchall_4
    move-exception v2

    :try_start_b
    monitor-exit v3
    :try_end_b
    .catchall {:try_start_b .. :try_end_b} :catchall_4

    throw v2
.end method
