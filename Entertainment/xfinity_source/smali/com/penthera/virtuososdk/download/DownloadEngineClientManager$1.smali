.class Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$1;
.super Landroid/os/Handler;
.source "DownloadEngineClientManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# direct methods
.method constructor <init>()V
    .locals 0

    .prologue
    .line 75
    invoke-direct {p0}, Landroid/os/Handler;-><init>()V

    .line 1
    return-void
.end method

.method private handleCheckStorage(Landroid/os/Message;)V
    .locals 8
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 91
    iget-object v1, p1, Landroid/os/Message;->obj:Ljava/lang/Object;

    check-cast v1, Lcom/penthera/virtuososdk/download/Downloader;

    .line 93
    .local v1, "d":Lcom/penthera/virtuososdk/download/Downloader;
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$1()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v3

    iget-object v4, v1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    .line 94
    .local v0, "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientSettings:Ljava/util/concurrent/ConcurrentHashMap;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$2()Ljava/util/concurrent/ConcurrentHashMap;

    move-result-object v3

    iget-object v4, v1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    .line 95
    .local v2, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    if-nez v0, :cond_0

    .line 103
    :goto_0
    return-void

    .line 96
    :cond_0
    invoke-virtual {v0, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    .line 98
    iget-wide v4, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    const-wide/16 v6, 0x0

    cmpl-double v3, v4, v6

    if-lez v3, :cond_1

    .line 99
    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader;->RetryOnStorageChange()V

    goto :goto_0

    .line 101
    :cond_1
    invoke-static {v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->requestDiskCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    goto :goto_0
.end method


# virtual methods
.method public handleMessage(Landroid/os/Message;)V
    .locals 3
    .param p1, "msg"    # Landroid/os/Message;

    .prologue
    .line 79
    iget v0, p1, Landroid/os/Message;->what:I

    packed-switch v0, :pswitch_data_0

    .line 86
    # getter for: Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->access$0()Ljava/lang/String;

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

    .line 88
    :goto_0
    return-void

    .line 82
    :pswitch_0
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$1;->handleCheckStorage(Landroid/os/Message;)V

    goto :goto_0

    .line 79
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
    .end packed-switch
.end method
