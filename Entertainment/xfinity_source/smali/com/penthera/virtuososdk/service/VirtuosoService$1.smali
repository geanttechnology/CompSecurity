.class Lcom/penthera/virtuososdk/service/VirtuosoService$1;
.super Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;
.source "VirtuosoService.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/service/VirtuosoService;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;


# direct methods
.method constructor <init>(Lcom/penthera/virtuososdk/service/VirtuosoService;)V
    .locals 0

    .prologue
    .line 1
    iput-object p1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    .line 85
    invoke-direct {p0}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;-><init>()V

    return-void
.end method


# virtual methods
.method public allowableStorageRemaining(Ljava/lang/String;)D
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 351
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "allowableStorageRemaining"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 352
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->availableStorage(Ljava/lang/String;)D

    move-result-wide v2

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->toMbytes(D)D
    invoke-static {v0, v2, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$6(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public cellularDataQuotaOK(Ljava/lang/String;)Z
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 316
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "cellularDataQuotaOK"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 317
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellularDataQuotaOK(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public cleanup(Ljava/lang/String;)V
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 334
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "cleanup"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 335
    return-void
.end method

.method public configure(Landroid/os/Bundle;IILjava/lang/String;)V
    .locals 2
    .param p1, "headers"    # Landroid/os/Bundle;
    .param p2, "aConnectionTimeOut"    # I
    .param p3, "aSocketTimeOut"    # I
    .param p4, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 376
    if-gez p2, :cond_0

    const/4 p2, -0x1

    .line 377
    :cond_0
    if-gez p3, :cond_1

    const/4 p3, -0x1

    .line 378
    :cond_1
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->setClientConfiguration(Landroid/os/Bundle;IILjava/lang/String;)V

    .line 379
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 380
    .local v0, "extras":Landroid/os/Bundle;
    if-eqz p1, :cond_2

    .line 381
    const-string v1, "client_configuration_headers"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putBundle(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 382
    :cond_2
    const-string v1, "client_configuration_conn_to"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 383
    const-string v1, "client_configuration_socket_to"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 385
    return-void
.end method

.method public diskStatusOK(Ljava/lang/String;)Z
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 310
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "diskStatusOK"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 311
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->diskStatusOK()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->availableStorage(Ljava/lang/String;)D

    move-result-wide v2

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->toMbytes(D)D
    invoke-static {v0, v2, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$6(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D

    move-result-wide v0

    const-wide v2, 0x3f80624dd2f1a9fcL    # 0.008

    cmpl-double v0, v0, v2

    if-lez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public enabled(Ljava/lang/String;)Z
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 285
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "enabled"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 286
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->status(Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v0

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Disabled:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v0, v1, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public getCurrentThroughput(Ljava/lang/String;)D
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 514
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getCurrentThroughput(Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0
.end method

.method public getOverallThroughput(Ljava/lang/String;)D
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 521
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getOverallThroughput(Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0
.end method

.method public markComplete(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Ljava/lang/String;)V
    .locals 6
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    const/4 v5, 0x0

    .line 392
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v3

    const/4 v4, 0x1

    if-ne v3, v4, :cond_0

    move-object v3, p1

    .line 393
    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-interface {v3, v5}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setPending(Z)V

    move-object v3, p1

    .line 394
    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    sget-object v4, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface {v3, v4}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 397
    :cond_0
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v3

    const/4 v4, 0x4

    if-ne v3, v4, :cond_1

    move-object v3, p1

    .line 398
    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-interface {v3, v5}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setPending(Z)V

    move-object v3, p1

    .line 399
    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    sget-object v4, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface {v3, v4}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 402
    :cond_1
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 403
    .local v0, "extras":Landroid/os/Bundle;
    const-string v3, "download_update_type"

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadEnd:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v4

    invoke-virtual {v0, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 404
    const-string v3, "download_update_data"

    invoke-virtual {v0, v3, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 407
    new-instance v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    invoke-direct {v1}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;-><init>()V

    .line 408
    .local v1, "idleStatus":Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    new-instance v3, Landroid/os/Bundle;

    invoke-direct {v3}, Landroid/os/Bundle;-><init>()V

    iput-object v3, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    .line 409
    iget-object v3, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    const-string v4, "failure_reason"

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 410
    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    iput-object v3, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 412
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 413
    .local v2, "idleupdate":Landroid/os/Bundle;
    const-string v3, "download_update_type"

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v4

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 414
    const-string v3, "download_update_data"

    invoke-virtual {v2, v3, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 416
    return-void
.end method

.method public markErrored(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ILjava/lang/String;)V
    .locals 8
    .param p1, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "aFileCompletionErrorCode"    # I
    .param p3, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 421
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 423
    .local v0, "extras":Landroid/os/Bundle;
    new-instance v3, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    invoke-direct {v3}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;-><init>()V

    .line 424
    .local v3, "msgStatus":Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    iput-object v5, v3, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    .line 425
    iget-object v5, v3, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    const-string v6, "failure_reason"

    invoke-virtual {v5, v6, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 426
    iget-object v5, v3, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    const-string v6, "virtuoso_file"

    invoke-virtual {v5, v6, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 427
    sget-object v5, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    iput-object v5, v3, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 429
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 430
    .local v4, "update":Landroid/os/Bundle;
    const-string v5, "download_update_type"

    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v6

    invoke-virtual {v4, v5, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 431
    const-string v5, "download_update_data"

    invoke-virtual {v4, v5, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 435
    new-instance v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    invoke-direct {v1}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;-><init>()V

    .line 436
    .local v1, "idleStatus":Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    iput-object v5, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    .line 437
    iget-object v5, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    const-string v6, "failure_reason"

    const/4 v7, 0x0

    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 438
    sget-object v5, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    iput-object v5, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 440
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 441
    .local v2, "idleupdate":Landroid/os/Bundle;
    const-string v5, "download_update_type"

    sget-object v6, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v6

    invoke-virtual {v2, v5, v6}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 442
    const-string v5, "download_update_data"

    invoke-virtual {v2, v5, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 444
    return-void
.end method

.method public networkStatusOK(Ljava/lang/String;)Z
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 304
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "networkStatusOK"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 305
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellularDataQuotaOK(Ljava/lang/String;)Z

    move-result v1

    invoke-virtual {v0, p1, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->networkStatusOK(Ljava/lang/String;Z)Z

    move-result v0

    return v0
.end method

.method public pauseDownloads(Ljava/lang/String;)V
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 357
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "pauseDownloads"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 358
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->pauseClient(Ljava/lang/String;)V

    .line 359
    return-void
.end method

.method public powerStatusOK(Ljava/lang/String;)Z
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 298
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "powerStatusOK"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 299
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->powerStatusOK(Ljava/lang/String;)Z

    move-result v0

    return v0
.end method

.method public queueSize(Ljava/lang/String;)I
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 369
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "queueSize"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 370
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->fullPendingQueueSize(Ljava/lang/String;)I

    move-result v0

    return v0
.end method

.method public quotaRecordingStart(Ljava/lang/String;)J
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 328
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "quotaRecordingStart"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 329
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellQuotaStart(Ljava/lang/String;)J

    move-result-wide v0

    return-wide v0
.end method

.method public registerDownloadCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;Ljava/lang/String;)V
    .locals 2
    .param p1, "aCallback"    # Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 92
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "registerDownloadCallbackHandler for download updates"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 93
    if-eqz p1, :cond_1

    .line 95
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 96
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    new-instance v1, Landroid/os/RemoteCallbackList;

    invoke-direct {v1}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v0, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 98
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList;

    invoke-virtual {v0, p1}, Landroid/os/RemoteCallbackList;->register(Landroid/os/IInterface;)Z

    .line 101
    :cond_1
    return-void
.end method

.method public registerEngineCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;Ljava/lang/String;)V
    .locals 2
    .param p1, "aCallback"    # Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 120
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "registerEngineCallbackHandler for download updates"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 121
    if-eqz p1, :cond_1

    .line 123
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 124
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    new-instance v1, Landroid/os/RemoteCallbackList;

    invoke-direct {v1}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v0, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 126
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList;

    invoke-virtual {v0, p1}, Landroid/os/RemoteCallbackList;->register(Landroid/os/IInterface;)Z

    .line 129
    :cond_1
    return-void
.end method

.method public registerQueueCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;Ljava/lang/String;)V
    .locals 2
    .param p1, "aCallback"    # Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 148
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "registerQueueCallbackHandler for download updates"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 149
    if-eqz p1, :cond_1

    .line 151
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 152
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    new-instance v1, Landroid/os/RemoteCallbackList;

    invoke-direct {v1}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v0, p2, v1}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 154
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList;

    invoke-virtual {v0, p1}, Landroid/os/RemoteCallbackList;->register(Landroid/os/IInterface;)Z

    .line 157
    :cond_1
    return-void
.end method

.method public resetCellularDataQuota(Ljava/lang/String;)V
    .locals 3
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 276
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "resetCellularDataQuota"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 277
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v0, v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 278
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v0, v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;

    new-instance v1, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;

    iget-object v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-direct {v1, v2, p1}, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;-><init>(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;)V

    invoke-virtual {v0, p1, v1}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 280
    :cond_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v0, v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;

    const/4 v2, 0x1

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->performQuotaReset(Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V
    invoke-static {v1, v0, p1, v2}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$4(Lcom/penthera/virtuososdk/service/VirtuosoService;Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V

    .line 281
    return-void
.end method

.method public resetErrorQueue(Ljava/lang/String;)V
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 466
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->resetErrorQueue(Ljava/lang/String;)V

    .line 467
    return-void
.end method

.method public resetTestSettings(Ljava/lang/String;)V
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 461
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clearTestSettings(Ljava/lang/String;)V

    .line 462
    return-void
.end method

.method public resumeDownloads(Ljava/lang/String;)V
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 363
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "resumeDownloads"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 364
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->resumeClient(Ljava/lang/String;)V

    .line 365
    return-void
.end method

.method public setTestSettings(Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 4
    .param p1, "settings"    # Landroid/os/Bundle;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 448
    if-eqz p1, :cond_1

    .line 449
    const-string v0, "headroom_override"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 450
    const-string v0, "headroom_override"

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v2, "headroom_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->toBytes(D)D
    invoke-static {v1, v2, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$7(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D

    move-result-wide v2

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 452
    :cond_0
    const-string v0, "max_storage_override"

    invoke-virtual {p1, v0}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 453
    const-string v0, "max_storage_override"

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    const-string v2, "max_storage_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getDouble(Ljava/lang/String;)D

    move-result-wide v2

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->toBytes(D)D
    invoke-static {v1, v2, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$7(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D

    move-result-wide v2

    invoke-virtual {p1, v0, v2, v3}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 456
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->setTestSettings(Landroid/os/Bundle;Ljava/lang/String;)V

    .line 457
    return-void
.end method

.method public signalDelete(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "aAuth"    # Ljava/lang/String;
    .param p2, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 483
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientDeletedItem(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 485
    return-void
.end method

.method public signalDownloadSettingChange(Ljava/lang/String;I)V
    .locals 3
    .param p1, "aAuth"    # Ljava/lang/String;
    .param p2, "flags"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 499
    and-int/lit8 v1, p2, 0x20

    if-gtz v1, :cond_0

    and-int/lit8 v1, p2, 0x10

    if-gtz v1, :cond_0

    .line 500
    and-int/lit16 v1, p2, 0x80

    if-gtz v1, :cond_0

    and-int/lit16 v1, p2, 0x400

    if-gtz v1, :cond_0

    and-int/lit16 v1, p2, 0x100

    if-lez v1, :cond_1

    .line 501
    :cond_0
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v1

    const-string v2, "doInterruptOnSettingChange"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 502
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1, p2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettingChange(Ljava/lang/String;I)V

    .line 505
    :cond_1
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 506
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 507
    const-string v1, "flags"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 508
    const-string v1, "virtuoso.intent.action.SETTING_CHANGED"

    invoke-static {v1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 509
    return-void
.end method

.method public signalExpire(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "aAuth"    # Ljava/lang/String;
    .param p2, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 491
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1, p2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientExpiredItem(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 493
    return-void
.end method

.method public signalQueueChange(Ljava/lang/String;Z)V
    .locals 2
    .param p1, "aAuth"    # Ljava/lang/String;
    .param p2, "aNotifyDownloader"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 472
    if-eqz p2, :cond_0

    .line 473
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientQueueChange(Ljava/lang/String;)V

    .line 474
    :cond_0
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 475
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 476
    const-string v1, "virtuoso.intent.action.QUEUE_CHANGED"

    invoke-static {v1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 477
    return-void
.end method

.method public status(Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 292
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "status"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 293
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->status(Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v0

    return-object v0
.end method

.method public storageUsed(Ljava/lang/String;)D
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 339
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "storageUsed"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 340
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->storageUsed(Ljava/lang/String;)D

    move-result-wide v2

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->toMbytes(D)D
    invoke-static {v0, v2, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$6(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public totalFileSize(Ljava/lang/String;)D
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 345
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "totalFileSize"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 346
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v1

    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->totalFileSize(Ljava/lang/String;)D

    move-result-wide v2

    # invokes: Lcom/penthera/virtuososdk/service/VirtuosoService;->toMbytes(D)D
    invoke-static {v0, v2, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$6(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D

    move-result-wide v0

    return-wide v0
.end method

.method public unregisterDownloadCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;Ljava/lang/String;)V
    .locals 2
    .param p1, "aCallback"    # Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 107
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "unregisterDownloadCallbackHandler"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 108
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 110
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList;

    invoke-virtual {v0, p1}, Landroid/os/RemoteCallbackList;->unregister(Landroid/os/IInterface;)Z

    .line 112
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 114
    :cond_0
    return-void
.end method

.method public unregisterEngineCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;Ljava/lang/String;)V
    .locals 2
    .param p1, "aCallback"    # Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 135
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "unregisterEngineCallbackHandler"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 136
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 138
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList;

    invoke-virtual {v0, p1}, Landroid/os/RemoteCallbackList;->unregister(Landroid/os/IInterface;)Z

    .line 140
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 142
    :cond_0
    return-void
.end method

.method public unregisterQueueCallbackHandler(Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;Ljava/lang/String;)V
    .locals 2
    .param p1, "aCallback"    # Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 163
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "unregisterQueueCallbackHandler"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 164
    if-eqz p1, :cond_0

    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 166
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;

    move-result-object v0

    invoke-virtual {v0, p2}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/os/RemoteCallbackList;

    invoke-virtual {v0, p1}, Landroid/os/RemoteCallbackList;->unregister(Landroid/os/IInterface;)Z

    .line 168
    invoke-static {}, Ljava/lang/System;->gc()V

    .line 170
    :cond_0
    return-void
.end method

.method public utilizedCellularDataQuota(Ljava/lang/String;)D
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Landroid/os/RemoteException;
        }
    .end annotation

    .prologue
    .line 322
    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$0()Ljava/lang/String;

    move-result-object v0

    const-string v1, "utilizedCellularDataQuota"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 323
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;->this$0:Lcom/penthera/virtuososdk/service/VirtuosoService;

    # getter for: Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    invoke-static {v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v0

    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->usedCellQuota(Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0
.end method
