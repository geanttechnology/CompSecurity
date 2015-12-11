.class public Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;
.super Ljava/lang/Object;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x1
    name = "DownloadStop"
.end annotation


# instance fields
.field iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

.field iReason:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

.field private iStopDownload:Z

.field final synthetic this$0:Lcom/penthera/virtuososdk/download/Downloader;


# direct methods
.method public constructor <init>(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 1

    .prologue
    .line 697
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 699
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iStopDownload:Z

    .line 700
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 701
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->ENone:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iReason:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    return-void
.end method


# virtual methods
.method declared-synchronized clear()V
    .locals 1

    .prologue
    .line 718
    monitor-enter p0

    const/4 v0, 0x0

    :try_start_0
    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iStopDownload:Z

    .line 719
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 720
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->ENone:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iReason:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 721
    monitor-exit p0

    return-void

    .line 718
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized isSet()Z
    .locals 1

    .prologue
    .line 712
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    iget-boolean v0, v0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iStopDownload:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    monitor-exit p0

    return v0

    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method public declared-synchronized stop(Z)V
    .locals 1
    .param p1, "stop"    # Z

    .prologue
    .line 706
    monitor-enter p0

    :try_start_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    iput-boolean p1, v0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iStopDownload:Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 707
    monitor-exit p0

    return-void

    .line 706
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method
