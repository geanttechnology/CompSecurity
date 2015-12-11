.class Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;
.super Ljava/lang/Object;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "HlsDownload"
.end annotation


# instance fields
.field private volatile mAbort:Z

.field private mActiveWorkers:I

.field private mClient:Lorg/apache/http/client/HttpClient;

.field private mConnectionType:I

.field private mEventBearerType:Ljava/lang/String;

.field private mFile:Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

.field private mFragments:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;",
            ">;"
        }
    .end annotation
.end field

.field private mHlsWorkerLock:Ljava/lang/Object;

.field private volatile mIndex:I

.field final synthetic this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;


# direct methods
.method public constructor <init>(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)V
    .locals 1
    .param p2, "aFile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    .param p3, "connectionType"    # I
    .param p4, "eventBearerType"    # Ljava/lang/String;
    .param p5, "aClient"    # Lorg/apache/http/client/HttpClient;

    .prologue
    const/4 v0, 0x0

    .line 1728
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 1724
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mAbort:Z

    .line 1725
    iput v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I

    .line 1745
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mHlsWorkerLock:Ljava/lang/Object;

    .line 1729
    iput-object p2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFile:Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    .line 1730
    iput p3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mConnectionType:I

    .line 1731
    iput-object p4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mEventBearerType:Ljava/lang/String;

    .line 1732
    iput-object p5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mClient:Lorg/apache/http/client/HttpClient;

    .line 1733
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v0

    invoke-interface {p2, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->pendingFragments(Landroid/content/Context;)Ljava/util/List;

    move-result-object v0

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFragments:Ljava/util/List;

    .line 1744
    return-void
.end method

.method private MAX()I
    .locals 1

    .prologue
    .line 1712
    const/4 v0, 0x3

    return v0
.end method

.method static synthetic access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)I
    .locals 1

    .prologue
    .line 1725
    iget v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I

    return v0
.end method

.method static synthetic access$1(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;I)V
    .locals 0

    .prologue
    .line 1725
    iput p1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I

    return-void
.end method

.method static synthetic access$2(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Z
    .locals 1

    .prologue
    .line 1724
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mAbort:Z

    return v0
.end method

.method static synthetic access$3(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 1

    .prologue
    .line 1804
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->download(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$4(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 1745
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mHlsWorkerLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$5(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;Z)V
    .locals 0

    .prologue
    .line 1724
    iput-boolean p1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mAbort:Z

    return-void
.end method

.method static synthetic access$6(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lorg/apache/http/client/HttpClient;
    .locals 1

    .prologue
    .line 1722
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mClient:Lorg/apache/http/client/HttpClient;

    return-object v0
.end method

.method static synthetic access$7(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    .locals 1

    .prologue
    .line 1702
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    return-object v0
.end method

.method private download(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 14
    .param p1, "frag"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;

    .prologue
    const-wide/16 v12, 0x0

    const/4 v10, 0x3

    .line 1805
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1806
    .local v5, "state":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    const/4 v2, 0x0

    .line 1808
    .local v2, "exception":Z
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->filePath()Ljava/lang/String;

    move-result-object v6

    invoke-static {v6}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v6

    if-eqz v6, :cond_0

    .line 1809
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->generateFilePath()V

    .line 1811
    :cond_0
    sget-object v6, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface {p1, v6}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1812
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFile:Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    invoke-interface {v6, v7, p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->updateFragment(Landroid/content/Context;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Z

    .line 1814
    :cond_1
    if-eqz v2, :cond_2

    .line 1815
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "tryDownloadItem(): Network failure -- trying again for fragment: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->remotePath()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1816
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "tryDownloadItem(): bytes read on the previous attempt: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v8

    iget-object v8, v8, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget-wide v8, v8, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    invoke-virtual {v7, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1819
    :cond_2
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v6

    iget-object v6, v6, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v12, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 1820
    const/4 v2, 0x0

    .line 1823
    :try_start_0
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget v7, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mConnectionType:I

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mEventBearerType:Ljava/lang/String;

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mClient:Lorg/apache/http/client/HttpClient;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadFragment(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    invoke-static {v6, p1, v7, v8, v9}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$3(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v5

    .line 1824
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v6, v5, :cond_5

    .line 1825
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget v7, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mConnectionType:I

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mEventBearerType:Ljava/lang/String;

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mClient:Lorg/apache/http/client/HttpClient;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadFragment(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    invoke-static {v6, p1, v7, v8, v9}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$3(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v5

    .line 1837
    :cond_3
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v6

    iget-object v6, v6, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v7, 0x0

    iput v7, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_2

    .line 1858
    :goto_0
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v6

    iget-object v6, v6, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v6, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    if-lt v6, v10, :cond_8

    .line 1859
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "c[ "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v8

    iget-object v8, v8, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "] No internet connection: connection not usable"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1860
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->completionToState(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    invoke-static {v6, v5}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$4(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v6

    invoke-interface {p1, v6}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1861
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFile:Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    invoke-interface {v6, v7, p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->updateFragment(Landroid/content/Context;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Z

    .line 1862
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorsMaxed:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1880
    .end local v5    # "state":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :cond_4
    :goto_1
    return-object v5

    .line 1826
    .restart local v5    # "state":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :cond_5
    :try_start_1
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v6, v5, :cond_6

    .line 1827
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v6, v5, :cond_6

    .line 1828
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v6, v5, :cond_3

    .line 1829
    :cond_6
    const/4 v4, 0x1

    .line 1830
    .local v4, "retryCount":I
    :goto_2
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v6, v5, :cond_7

    .line 1831
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v6, v5, :cond_7

    .line 1832
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v6, v5, :cond_3

    :cond_7
    if-ge v4, v10, :cond_3

    .line 1833
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget v7, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mConnectionType:I

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mEventBearerType:Ljava/lang/String;

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mClient:Lorg/apache/http/client/HttpClient;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadFragment(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    invoke-static {v6, p1, v7, v8, v9}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$3(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_1
    .catch Ljava/net/UnknownHostException; {:try_start_1 .. :try_end_1} :catch_0
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_1
    .catch Ljava/lang/Throwable; {:try_start_1 .. :try_end_1} :catch_2

    move-result-object v5

    .line 1834
    add-int/lit8 v4, v4, 0x1

    goto :goto_2

    .line 1838
    .end local v4    # "retryCount":I
    :catch_0
    move-exception v0

    .line 1839
    .local v0, "e":Ljava/net/UnknownHostException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "tryDownloadItem(): Network unavaialble -- Received unknown host excpetion: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/UnknownHostException;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1840
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v6

    iget-object v6, v6, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v7, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    add-int/lit8 v7, v7, 0x1

    iput v7, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    .line 1841
    const-string v6, "virtuoso.intent.action.UNKNOWN_HOST"

    invoke-static {v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;)V

    .line 1842
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1843
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 1844
    .end local v0    # "e":Ljava/net/UnknownHostException;
    :catch_1
    move-exception v1

    .line 1845
    .local v1, "e2":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "tryDownloadItem(): Network problem -- Received a network error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1846
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v6

    iget-object v6, v6, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v7, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    add-int/lit8 v7, v7, 0x1

    iput v7, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    .line 1848
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1849
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 1850
    .end local v1    # "e2":Ljava/lang/Exception;
    :catch_2
    move-exception v3

    .line 1851
    .local v3, "r2":Ljava/lang/Throwable;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v6

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "tryDownloadItem(): Network problem -- unknown error: "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v6, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1852
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v6

    iget-object v6, v6, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v7, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    add-int/lit8 v7, v7, 0x1

    iput v7, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    .line 1853
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1854
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 1864
    .end local v3    # "r2":Ljava/lang/Throwable;
    :cond_8
    if-eqz v2, :cond_9

    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v6

    iget-object v6, v6, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget-wide v6, v6, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    cmp-long v6, v6, v12

    if-gtz v6, :cond_1

    .line 1866
    :cond_9
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v5, v6, :cond_b

    .line 1867
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->markComplete()V

    .line 1871
    :goto_3
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v6

    sget-object v7, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v6, v7, :cond_a

    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->currentSize()D

    move-result-wide v6

    const-wide/16 v8, 0x0

    cmpg-double v6, v6, v8

    if-gtz v6, :cond_a

    .line 1872
    const/4 v6, 0x0

    invoke-interface {p1, v6}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setFilePath(Ljava/lang/String;)V

    .line 1875
    :cond_a
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFile:Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    invoke-interface {v6, v7, p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->updateFragment(Landroid/content/Context;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Z

    .line 1877
    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v5, v6, :cond_4

    .line 1878
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFile:Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->reportFragmentComplete(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V
    invoke-static {v6, v7, p1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$5(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V

    goto/16 :goto_1

    .line 1869
    :cond_b
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->completionToState(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    invoke-static {v6, v5}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$4(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v6

    invoke-interface {p1, v6}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    goto :goto_3
.end method


# virtual methods
.method public begin()V
    .locals 6

    .prologue
    .line 1747
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->this$1:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;
    invoke-static {v4}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v4

    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-static {v4, v5}, Lcom/penthera/virtuososdk/download/Downloader;->access$1(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V

    .line 1748
    const/4 v4, 0x0

    iput v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I

    .line 1749
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->MAX()I

    move-result v0

    .line 1750
    .local v0, "MAX":I
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_0
    if-lt v1, v0, :cond_0

    .line 1793
    return-void

    .line 1751
    :cond_0
    iget v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I

    add-int/lit8 v4, v4, 0x1

    iput v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mActiveWorkers:I

    .line 1752
    new-instance v2, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;

    invoke-direct {v2, p0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload$1;-><init>(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;)V

    .line 1790
    .local v2, "r":Ljava/lang/Runnable;
    new-instance v3, Ljava/lang/Thread;

    invoke-direct {v3, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    .line 1791
    .local v3, "t":Ljava/lang/Thread;
    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    .line 1750
    add-int/lit8 v1, v1, 0x1

    goto :goto_0
.end method

.method declared-synchronized getNext()Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    .locals 4

    .prologue
    .line 1796
    monitor-enter p0

    const/4 v1, 0x0

    .line 1797
    .local v1, "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    :try_start_0
    iget v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mIndex:I

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFragments:Ljava/util/List;

    invoke-interface {v3}, Ljava/util/List;->size()I

    move-result v3

    if-ge v2, v3, :cond_0

    .line 1798
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mFragments:Ljava/util/List;

    iget v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mIndex:I

    invoke-interface {v2, v3}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v2

    move-object v0, v2

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;

    move-object v1, v0

    .line 1799
    iget v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mIndex:I

    add-int/lit8 v2, v2, 0x1

    iput v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->mIndex:I
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1801
    :cond_0
    monitor-exit p0

    return-object v1

    .line 1796
    :catchall_0
    move-exception v2

    monitor-exit p0

    throw v2
.end method
