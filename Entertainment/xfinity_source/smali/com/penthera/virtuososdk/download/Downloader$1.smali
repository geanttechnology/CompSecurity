.class Lcom/penthera/virtuososdk/download/Downloader$1;
.super Landroid/os/Handler;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 739
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 1
    return-void
.end method

.method private handleCheckPermissions(Landroid/os/Message;)V
    .locals 6
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 755
    iget-object v0, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v0, Lcom/penthera/virtuososdk/download/Downloader;

    .line 756
    .local v0, "d":Lcom/penthera/virtuososdk/download/Downloader;
    iget-object v3, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget-boolean v3, v3, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    if-eqz v3, :cond_0

    iget-object v3, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->isSet()Z

    move-result v3

    if-eqz v3, :cond_1

    .line 775
    :cond_0
    :goto_0
    return-void

    .line 760
    :cond_1
    const/4 v2, 0x0

    .line 761
    .local v2, "stopped":Z
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v1

    .line 762
    .local v1, "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    sget-object v3, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    if-eq v1, v3, :cond_2

    .line 763
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v3

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "Downloads not permitted: "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v4, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 764
    iget-object v3, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    iput-object v1, v3, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 765
    iget-object v3, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    sget-object v4, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EBlocked:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    iput-object v4, v3, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iReason:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    .line 766
    iget-object v3, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    const/4 v4, 0x1

    invoke-virtual {v3, v4}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->stop(Z)V

    .line 767
    const/4 v2, 0x1

    .line 770
    :cond_2
    iget-object v3, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget-boolean v3, v3, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    if-eqz v3, :cond_0

    if-nez v2, :cond_0

    .line 771
    invoke-virtual {v0, v0}, Lcom/penthera/virtuososdk/download/Downloader;->requestPermissionChecks(Lcom/penthera/virtuososdk/download/Downloader;)V

    goto :goto_0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 743
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 750
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "c[] Wrong message "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget v2, p1, Landroid/os/Message;->what:I

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 752
    :goto_0
    return-void

    .line 746
    :pswitch_0
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader$1;->handleCheckPermissions(Landroid/os/Message;)V

    goto :goto_0

    .line 743
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
