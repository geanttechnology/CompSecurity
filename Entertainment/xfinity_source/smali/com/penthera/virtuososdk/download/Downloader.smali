.class public final Lcom/penthera/virtuososdk/download/Downloader;
.super Ljava/lang/Object;
.source "Downloader.java"

# interfaces
.implements Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;
.implements Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;,
        Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;,
        Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;,
        Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;,
        Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;,
        Lcom/penthera/virtuososdk/download/Downloader$EStopReason;,
        Lcom/penthera/virtuososdk/download/Downloader$Throughput;,
        Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission:[I

.field private static HTTP_CONNECTION_TIMEOUT:I

.field private static HTTP_SOCKET_TIMEOUT:I

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final iHandler:Landroid/os/Handler;


# instance fields
.field private final TEST_VD_LOCK:Z

.field private final VirtuosoDownloadThreadCreationLock:Ljava/lang/Object;

.field currentThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

.field iAllowedCellUsage:D

.field iAllowedStorageUsage:D

.field private iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

.field private iBatterySettingsBundle:Landroid/os/Bundle;

.field private iBatteryThreshold:I

.field final iClientAuthority:Ljava/lang/String;

.field private iClientConfiguredHeaders:Landroid/os/Bundle;

.field volatile iConnChangeResumePending:Z

.field private iContext:Landroid/content/Context;

.field iCurrentCellUsage:D

.field private iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

.field iCurrentStorageUsage:D

.field private iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

.field private iDbInit:Z

.field iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

.field iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

.field private iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

.field private iFragmentNotificationRate:I

.field iLastFileCompletionErrorCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field private iNetworkInfo:Landroid/net/NetworkInfo;

.field private iPauseDownloadEngine:Z

.field volatile iPowerChangeResumePending:Z

.field private iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

.field private iPriorityDownloadBundle:Landroid/os/Bundle;

.field private iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

.field iRemoveRequestWhileNotDownloading:Z

.field iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

.field private iTestBundle:Landroid/os/Bundle;

.field private mStatus:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field overallThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;


# direct methods
.method static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()[I
    .locals 3

    .prologue
    .line 69
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader;->$SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->values()[Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_7

    :goto_1
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_6

    :goto_2
    :try_start_2
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_5

    :goto_3
    :try_start_3
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_4

    :goto_4
    :try_start_4
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_3

    :goto_5
    :try_start_5
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_2

    :goto_6
    :try_start_6
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_1

    :goto_7
    :try_start_7
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedWifi:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_0

    :goto_8
    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader;->$SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_8

    :catch_1
    move-exception v1

    goto :goto_7

    :catch_2
    move-exception v1

    goto :goto_6

    :catch_3
    move-exception v1

    goto :goto_5

    :catch_4
    move-exception v1

    goto :goto_4

    :catch_5
    move-exception v1

    goto :goto_3

    :catch_6
    move-exception v1

    goto :goto_2

    :catch_7
    move-exception v1

    goto :goto_1
.end method

.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 89
    const-class v0, Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    .line 739
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$1;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/download/Downloader$1;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader;->iHandler:Landroid/os/Handler;

    .line 881
    const/16 v0, 0x7530

    sput v0, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_SOCKET_TIMEOUT:I

    .line 882
    const v0, 0xea60

    sput v0, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_CONNECTION_TIMEOUT:I

    .line 69
    return-void
.end method

.method constructor <init>(Landroid/content/Context;Ljava/lang/String;Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;Lcom/penthera/virtuososdk/monitor/BatteryMonitor;)V
    .locals 6
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .param p3, "dobs"    # Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    .param p4, "aqp"    # Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;
    .param p5, "aBm"    # Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v3, 0x0

    const/4 v2, 0x0

    .line 132
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 90
    iput-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    .line 94
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    .line 95
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    .line 97
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->TEST_VD_LOCK:Z

    .line 98
    new-instance v1, Ljava/lang/Object;

    invoke-direct {v1}, Ljava/lang/Object;-><init>()V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->VirtuosoDownloadThreadCreationLock:Ljava/lang/Object;

    .line 100
    iput-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    .line 101
    iput-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 103
    iput-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 104
    iput-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;

    .line 105
    iput-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    .line 106
    iput-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    .line 107
    iput-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    .line 108
    iput-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    .line 109
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPauseDownloadEngine:Z

    .line 110
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iLastFileCompletionErrorCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 128
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDbInit:Z

    .line 271
    iput-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientConfiguredHeaders:Landroid/os/Bundle;

    .line 634
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iRemoveRequestWhileNotDownloading:Z

    .line 694
    iput v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iFragmentNotificationRate:I

    .line 723
    new-instance v1, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-direct {v1, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;-><init>(Lcom/penthera/virtuososdk/download/Downloader;)V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    .line 724
    iput v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryThreshold:I

    .line 876
    new-instance v1, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    invoke-direct {v1, p0, v3}, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;-><init>(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;)V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    .line 906
    new-instance v1, Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    invoke-direct {v1, p0}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;-><init>(Lcom/penthera/virtuososdk/download/Downloader;)V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->currentThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    .line 907
    new-instance v1, Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    invoke-direct {v1, p0}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;-><init>(Lcom/penthera/virtuososdk/download/Downloader;)V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->overallThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    .line 2530
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    .line 2531
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iConnChangeResumePending:Z

    .line 133
    iput-object p3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    .line 134
    iput-object p4, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    .line 135
    new-instance v1, Ljava/lang/String;

    invoke-direct {v1, p2}, Ljava/lang/String;-><init>(Ljava/lang/String;)V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    .line 136
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;

    .line 137
    new-instance v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    invoke-direct {v1}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;-><init>()V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    .line 138
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;

    const-string v2, "connectivity"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 139
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iNetworkInfo:Landroid/net/NetworkInfo;

    .line 141
    iput-object p5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    .line 154
    return-void
.end method

.method private NewItemOrig(Landroid/os/Bundle;)V
    .locals 8
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    const-wide/16 v6, 0x0

    const/4 v5, 0x1

    .line 534
    if-eqz p1, :cond_0

    const-string v2, "fragment_download_progress_rate"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 535
    const-string v2, "fragment_download_progress_rate"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v2

    iput v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iFragmentNotificationRate:I

    .line 537
    :cond_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v2, v2, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v2, v3, :cond_1

    .line 538
    if-eqz p1, :cond_1

    .line 539
    const-string v2, "download_file_data"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v1

    .line 541
    .local v1, "p":Landroid/os/Parcelable;
    if-eqz v1, :cond_1

    .line 543
    iget-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iRemoveRequestWhileNotDownloading:Z

    if-eqz v2, :cond_2

    .line 548
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 549
    .local v0, "b":Landroid/os/Bundle;
    const-string v2, "forceIdleOnNewItemAfterDeleteDuringIdle"

    invoke-virtual {v0, v2, v5}, Landroid/os/Bundle;->putBoolean(Ljava/lang/String;Z)V

    .line 550
    const/4 v2, 0x0

    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iRemoveRequestWhileNotDownloading:Z

    .line 551
    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v2, v0, v5}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;Z)V

    .line 572
    .end local v0    # "b":Landroid/os/Bundle;
    .end local v1    # "p":Landroid/os/Parcelable;
    :cond_1
    :goto_0
    return-void

    .line 556
    .restart local v1    # "p":Landroid/os/Parcelable;
    :cond_2
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v2, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedStorageQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    .line 557
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v2, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedCellQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    .line 558
    iput-wide v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    .line 559
    iput-wide v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    .line 563
    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 564
    sget-object v2, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "c[ "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] Creating download thread from new file request"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 565
    check-cast v1, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .end local v1    # "p":Landroid/os/Parcelable;
    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 566
    new-instance v2, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-direct {v2, p0, v3}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;-><init>(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    iput-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    .line 567
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    invoke-virtual {v2, v5}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->setPriority(I)V

    .line 568
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->start()V

    goto :goto_0
.end method

.method private PriorityDownloadOrig(Landroid/os/Bundle;)V
    .locals 14
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 396
    if-eqz p1, :cond_1

    .line 397
    const-string v7, "fragment_download_progress_rate"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 398
    const-string v7, "fragment_download_progress_rate"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v7

    iput v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iFragmentNotificationRate:I

    .line 400
    :cond_0
    const-string v7, "download_file_data"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v6

    .line 401
    .local v6, "p":Landroid/os/Parcelable;
    if-eqz v6, :cond_1

    move-object v7, v6

    .line 403
    check-cast v7, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 404
    sget-object v7, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v8, v8, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v7, v8, :cond_2

    .line 410
    sget-object v7, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "c[ "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "] killing current download due to priority change"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 411
    invoke-virtual {p0, p0}, Lcom/penthera/virtuososdk/download/Downloader;->removeHandlerPermissionCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 418
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    sget-object v8, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    iput-object v8, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 419
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    sget-object v8, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EPriorityChange:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    iput-object v8, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iReason:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    .line 420
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->stop(Z)V

    .line 421
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;

    .line 507
    .end local v6    # "p":Landroid/os/Parcelable;
    :cond_1
    :goto_0
    return-void

    .line 424
    .restart local v6    # "p":Landroid/os/Parcelable;
    :cond_2
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v8, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v7, v8, :cond_3

    .line 426
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 427
    const/4 v7, 0x0

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 429
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v7, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedStorageQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v8

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    .line 430
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v7, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedCellQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v8

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    .line 431
    const-wide/16 v8, 0x0

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    .line 432
    const-wide/16 v8, 0x0

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    .line 434
    sget-object v7, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v7}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 435
    sget-object v7, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "c[ "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "] Creating download thread from idle state"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 436
    check-cast v6, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .end local v6    # "p":Landroid/os/Parcelable;
    iput-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 437
    new-instance v7, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-direct {v7, p0, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;-><init>(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    .line 438
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->setPriority(I)V

    .line 439
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->start()V

    goto :goto_0

    .line 440
    .restart local v6    # "p":Landroid/os/Parcelable;
    :cond_3
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v8, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v7, v8, :cond_6

    .line 441
    const/4 v0, 0x0

    .line 442
    .local v0, "can_resume":Z
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v7, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedCellQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v2

    .line 443
    .local v2, "new_cell_usage":D
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v7, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedStorageQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v4

    .line 445
    .local v4, "new_storage_usage":D
    sget-object v7, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "c[ "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "] New Storage Settings received store_usage[ "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "%1$,.2f"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v4, v5}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " ] cell_usage[ "

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "%1$,.2f"

    const/4 v10, 0x1

    new-array v10, v10, [Ljava/lang/Object;

    const/4 v11, 0x0

    invoke-static {v2, v3}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v12

    aput-object v12, v10, v11

    invoke-static {v9, v10}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, " ]"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 446
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->$SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()[I

    move-result-object v7

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v8

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v8

    aget v7, v7, v8

    packed-switch v7, :pswitch_data_0

    .line 462
    :goto_1
    :pswitch_0
    if-eqz v0, :cond_1

    .line 463
    sget-object v7, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "c[ "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "] can resume download"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 465
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 466
    const/4 v7, 0x0

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 468
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "Previous data \"storage_data\":{\"allowed_storage\" : "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 469
    const-string v8, ", \"allowed_cell\" : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 470
    const-string v8, ", \"current_storage\" : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 471
    const-string v8, ", \"current_cell\" : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "}"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 468
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 472
    .local v1, "logString":Ljava/lang/String;
    sget-object v7, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    invoke-static {v7, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 473
    iput-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    .line 474
    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    .line 475
    const-wide/16 v8, 0x0

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    .line 476
    const-wide/16 v8, 0x0

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    .line 478
    new-instance v7, Ljava/lang/StringBuilder;

    const-string v8, "New data \"storage_data\":{\"allowed_storage\" : "

    invoke-direct {v7, v8}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 479
    const-string v8, ", \"allowed_cell\" : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 480
    const-string v8, ", \"current_storage\" : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 481
    const-string v8, ", \"current_cell\" : "

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "%1$,.2f"

    const/4 v9, 0x1

    new-array v9, v9, [Ljava/lang/Object;

    const/4 v10, 0x0

    iget-wide v12, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    invoke-static {v12, v13}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v11

    aput-object v11, v9, v10

    invoke-static {v8, v9}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v8, "}"

    invoke-virtual {v7, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 478
    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    .line 483
    sget-object v7, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    invoke-static {v7, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 485
    sget-object v7, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v7}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 486
    sget-object v7, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "c[ "

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "] Creating download thread from blocked state"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 487
    check-cast v6, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .end local v6    # "p":Landroid/os/Parcelable;
    iput-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 488
    new-instance v7, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-direct {v7, p0, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;-><init>(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    .line 489
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    const/4 v8, 0x1

    invoke-virtual {v7, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->setPriority(I)V

    .line 490
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->start()V

    goto/16 :goto_0

    .line 450
    .end local v1    # "logString":Ljava/lang/String;
    .restart local v6    # "p":Landroid/os/Parcelable;
    :pswitch_1
    const-wide/16 v8, 0x0

    cmpl-double v7, v2, v8

    if-lez v7, :cond_4

    const/4 v0, 0x1

    .line 451
    :goto_2
    goto/16 :goto_1

    .line 450
    :cond_4
    const/4 v0, 0x0

    goto :goto_2

    .line 455
    :pswitch_2
    const-wide/16 v8, 0x0

    cmpl-double v7, v4, v8

    if-lez v7, :cond_5

    const/4 v0, 0x1

    .line 456
    :goto_3
    goto/16 :goto_1

    .line 455
    :cond_5
    const/4 v0, 0x0

    goto :goto_3

    .line 459
    :pswitch_3
    const/4 v0, 0x1

    goto/16 :goto_1

    .line 497
    .end local v0    # "can_resume":Z
    .end local v2    # "new_cell_usage":D
    .end local v4    # "new_storage_usage":D
    :cond_6
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 498
    const/4 v7, 0x0

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 499
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v7, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedStorageQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v8

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    .line 500
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iQuotaProvider:Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;

    invoke-interface {v7, p0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;->getAllowedCellQuota(Lcom/penthera/virtuososdk/download/Downloader;)D

    move-result-wide v8

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    .line 501
    const-wide/16 v8, 0x0

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    .line 502
    const-wide/16 v8, 0x0

    iput-wide v8, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    goto/16 :goto_0

    .line 446
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private ResumeOrig()V
    .locals 3

    .prologue
    .line 613
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPauseDownloadEngine:Z

    .line 614
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->isSet()Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    if-ne v0, v1, :cond_0

    .line 615
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->clear()V

    .line 617
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v0, v1, :cond_1

    .line 618
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    if-eqz v0, :cond_2

    .line 619
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 620
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "c[ "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] Creating download thread from download resume"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 621
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-direct {v0, p0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;-><init>(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    .line 622
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->setPriority(I)V

    .line 623
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->start()V

    .line 628
    :cond_1
    :goto_0
    return-void

    .line 625
    :cond_2
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V

    goto :goto_0
.end method

.method static synthetic access$0()Ljava/lang/String;
    .locals 1

    .prologue
    .line 89
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V
    .locals 0

    .prologue
    .line 112
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader;->mStatus:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    return-void
.end method

.method static synthetic access$10(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    .locals 0

    .prologue
    .line 160
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    return-void
.end method

.method static synthetic access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 189
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 104
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic access$13()I
    .locals 1

    .prologue
    .line 881
    sget v0, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_SOCKET_TIMEOUT:I

    return v0
.end method

.method static synthetic access$14()I
    .locals 1

    .prologue
    .line 882
    sget v0, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_CONNECTION_TIMEOUT:I

    return v0
.end method

.method static synthetic access$15(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 1

    .prologue
    .line 112
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->mStatus:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    return-object v0
.end method

.method static synthetic access$16(Lcom/penthera/virtuososdk/download/Downloader;)I
    .locals 1

    .prologue
    .line 694
    iget v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iFragmentNotificationRate:I

    return v0
.end method

.method static synthetic access$17(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 271
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientConfiguredHeaders:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic access$18(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;
    .locals 1

    .prologue
    .line 95
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    return-object v0
.end method

.method static synthetic access$2(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V
    .locals 0

    .prologue
    .line 101
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    return-void
.end method

.method static synthetic access$3(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 0

    .prologue
    .line 202
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/download/Downloader;->sendBroadcastForDownloadUpdate(Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    return-void
.end method

.method static synthetic access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 164
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    return-void
.end method

.method static synthetic access$5(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 0

    .prologue
    .line 198
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V

    return-void
.end method

.method static synthetic access$6(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/content/Context;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;

    return-object v0
.end method

.method static synthetic access$7(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
    .locals 0

    .prologue
    .line 104
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;

    return-void
.end method

.method static synthetic access$8(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V
    .locals 0

    .prologue
    .line 103
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    return-void
.end method

.method static synthetic access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    .locals 1

    .prologue
    .line 129
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    return-object v0
.end method

.method private reportErrorStatus(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "aExtras"    # Landroid/os/Bundle;

    .prologue
    .line 190
    const/4 v0, 0x4

    invoke-static {v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BuildFeatures;->isFlagSet(I)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 191
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    .line 196
    :goto_0
    return-void

    .line 193
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    .line 194
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V

    goto :goto_0
.end method

.method private sendBroadcastForDownloadUpdate(Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 3
    .param p1, "aType"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .param p2, "aParcel"    # Landroid/os/Parcelable;

    .prologue
    .line 203
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 204
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "download_update_type"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v2

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 205
    const-string v1, "download_update_data"

    invoke-virtual {v0, v1, p2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 206
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    invoke-interface {v1, p0, p1, v0}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 207
    return-void
.end method

.method private setIdle()V
    .locals 1

    .prologue
    .line 199
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 200
    return-void
.end method

.method private setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    .locals 1
    .param p1, "aNewStatus"    # Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .prologue
    .line 162
    const/4 v0, 0x0

    invoke-direct {p0, p1, v0}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    .line 163
    return-void
.end method

.method private setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "aNewStatus"    # Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .param p2, "aExtras"    # Landroid/os/Bundle;

    .prologue
    .line 165
    const/4 v0, 0x0

    invoke-direct {p0, p1, p2, v0}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;Z)V

    .line 166
    return-void
.end method

.method private setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;Z)V
    .locals 4
    .param p1, "aNewStatus"    # Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .param p2, "aExtras"    # Landroid/os/Bundle;
    .param p3, "force"    # Z

    .prologue
    .line 169
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "c[ "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] Engine changing status: from "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v3, v3, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v3}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, " to "

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->name()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 170
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v1, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne p1, v1, :cond_0

    if-nez p3, :cond_0

    .line 171
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Status is the same not sending status change"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 187
    :goto_0
    return-void

    .line 176
    :cond_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iput-object p1, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 177
    if-nez p2, :cond_1

    .line 178
    new-instance p2, Landroid/os/Bundle;

    .end local p2    # "aExtras":Landroid/os/Bundle;
    invoke-direct {p2}, Landroid/os/Bundle;-><init>()V

    .line 180
    .restart local p2    # "aExtras":Landroid/os/Bundle;
    :cond_1
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iput-object p2, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    .line 182
    new-instance v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;-><init>()V

    .line 183
    .local v0, "msgStatus":Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    iput-object p2, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iExtras:Landroid/os/Bundle;

    .line 184
    iput-object p1, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 185
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-direct {p0, v1, v0}, Lcom/penthera/virtuososdk/download/Downloader;->sendBroadcastForDownloadUpdate(Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    goto :goto_0
.end method


# virtual methods
.method BatterySettingChanged(Landroid/os/Bundle;)V
    .locals 10
    .param p1, "bundle"    # Landroid/os/Bundle;

    .prologue
    const-wide/high16 v8, 0x4059000000000000L    # 100.0

    .line 285
    const-string v3, "battery_threshold"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 287
    .local v2, "woop":Ljava/lang/String;
    if-nez v2, :cond_0

    const-string v3, "-1"

    :goto_0
    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    .line 288
    .local v0, "battery_level":D
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    const-string v4, "battery_threshold"

    mul-double v6, v0, v8

    double-to-int v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 290
    const-string v3, "battery_threshold_override"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v3

    if-eqz v3, :cond_2

    .line 291
    const-string v3, "battery_threshold_override"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    .line 292
    if-nez v2, :cond_1

    const-string v3, "-1"

    :goto_1
    invoke-static {v3}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v0

    .line 293
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    const-string v4, "battery_threshold_override"

    mul-double v6, v0, v8

    double-to-int v5, v6

    invoke-virtual {v3, v4, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 297
    :goto_2
    const/4 v3, -0x1

    invoke-virtual {p0, v3}, Lcom/penthera/virtuososdk/download/Downloader;->onBatteryLevelChanged(I)V

    .line 298
    return-void

    .end local v0    # "battery_level":D
    :cond_0
    move-object v3, v2

    .line 287
    goto :goto_0

    .restart local v0    # "battery_level":D
    :cond_1
    move-object v3, v2

    .line 292
    goto :goto_1

    .line 295
    :cond_2
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    const-string v4, "battery_threshold_override"

    invoke-virtual {v3, v4}, Landroid/os/Bundle;->remove(Ljava/lang/String;)V

    goto :goto_2
.end method

.method InitiliazationComplete(Landroid/os/Bundle;)V
    .locals 28
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 303
    if-nez p1, :cond_0

    .line 369
    :goto_0
    return-void

    .line 305
    :cond_0
    const-string v24, "battery_threshold"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 307
    .local v23, "woop":Ljava/lang/String;
    if-nez v23, :cond_5

    const-string v24, "-1"

    :goto_1
    invoke-static/range {v24 .. v24}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    .line 308
    .local v4, "battery_level":D
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    move-object/from16 v24, v0

    const-string v25, "battery_threshold"

    const-wide/high16 v26, 0x4059000000000000L    # 100.0

    mul-double v26, v26, v4

    move-wide/from16 v0, v26

    double-to-int v0, v0

    move/from16 v26, v0

    invoke-virtual/range {v24 .. v26}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 309
    const-string v24, "battery_threshold_override"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v24

    if-eqz v24, :cond_1

    .line 310
    const-string v24, "battery_threshold_override"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 311
    if-nez v23, :cond_6

    const-string v24, "-1"

    :goto_2
    invoke-static/range {v24 .. v24}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v4

    .line 312
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    move-object/from16 v24, v0

    const-string v25, "battery_threshold_override"

    const-wide/high16 v26, 0x4059000000000000L    # 100.0

    mul-double v26, v26, v4

    move-wide/from16 v0, v26

    double-to-int v0, v0

    move/from16 v26, v0

    invoke-virtual/range {v24 .. v26}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 315
    :cond_1
    const/4 v9, 0x0

    .line 316
    .local v9, "headers":Landroid/os/Bundle;
    const-string v24, "client_configuration_headers"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v24

    if-eqz v24, :cond_2

    .line 317
    const-string v24, "client_configuration_headers"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v15

    .line 318
    .local v15, "json":Ljava/lang/String;
    const/4 v13, 0x0

    .line 320
    .local v13, "jo":Lorg/json/JSONObject;
    :try_start_0
    new-instance v14, Lorg/json/JSONObject;

    invoke-direct {v14, v15}, Lorg/json/JSONObject;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catch Lorg/json/JSONException; {:try_start_0 .. :try_end_0} :catch_3

    .line 321
    .end local v13    # "jo":Lorg/json/JSONObject;
    .local v14, "jo":Lorg/json/JSONObject;
    :try_start_1
    const-string v24, "headers"

    move-object/from16 v0, v24

    invoke-virtual {v14, v0}, Lorg/json/JSONObject;->getJSONArray(Ljava/lang/String;)Lorg/json/JSONArray;

    move-result-object v12

    .line 322
    .local v12, "jar":Lorg/json/JSONArray;
    new-instance v10, Landroid/os/Bundle;

    invoke-direct {v10}, Landroid/os/Bundle;-><init>()V
    :try_end_1
    .catch Lorg/json/JSONException; {:try_start_1 .. :try_end_1} :catch_4

    .line 323
    .end local v9    # "headers":Landroid/os/Bundle;
    .local v10, "headers":Landroid/os/Bundle;
    const/4 v11, 0x0

    .local v11, "i":I
    move-object v13, v14

    .end local v14    # "jo":Lorg/json/JSONObject;
    .restart local v13    # "jo":Lorg/json/JSONObject;
    :goto_3
    :try_start_2
    invoke-virtual {v12}, Lorg/json/JSONArray;->length()I
    :try_end_2
    .catch Lorg/json/JSONException; {:try_start_2 .. :try_end_2} :catch_0

    move-result v24

    move/from16 v0, v24

    if-lt v11, v0, :cond_7

    move-object v9, v10

    .line 340
    .end local v10    # "headers":Landroid/os/Bundle;
    .end local v11    # "i":I
    .end local v12    # "jar":Lorg/json/JSONArray;
    .end local v13    # "jo":Lorg/json/JSONObject;
    .end local v15    # "json":Ljava/lang/String;
    .restart local v9    # "headers":Landroid/os/Bundle;
    :cond_2
    :goto_4
    const v6, 0xea60

    .line 341
    .local v6, "cTime":I
    const/16 v18, 0x7530

    .line 342
    .local v18, "sTime":I
    const-string v24, "client_configuration_conn_to"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v7

    .line 343
    .local v7, "cTimeS":Ljava/lang/String;
    const-string v24, "client_configuration_socket_to"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v19

    .line 344
    .local v19, "sTimeS":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v24

    if-nez v24, :cond_3

    .line 345
    const/16 v21, -0x1

    .line 347
    .local v21, "temp":I
    :try_start_3
    invoke-static {v7}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    move-result v21

    .line 349
    :goto_5
    if-ltz v21, :cond_3

    .line 350
    move/from16 v6, v21

    .line 352
    .end local v21    # "temp":I
    :cond_3
    invoke-static/range {v19 .. v19}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v24

    if-nez v24, :cond_4

    .line 353
    const/16 v21, -0x1

    .line 355
    .restart local v21    # "temp":I
    :try_start_4
    invoke-static/range {v19 .. v19}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_2

    move-result v21

    .line 357
    :goto_6
    if-ltz v21, :cond_4

    move/from16 v18, v21

    .line 359
    .end local v21    # "temp":I
    :cond_4
    const-string v24, "client_configuration_headers"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getBundle(Ljava/lang/String;)Landroid/os/Bundle;

    move-result-object v24

    move-object/from16 v0, p0

    move-object/from16 v1, v24

    move/from16 v2, v18

    invoke-virtual {v0, v1, v2, v6}, Lcom/penthera/virtuososdk/download/Downloader;->setClientConfiguration(Landroid/os/Bundle;II)V

    .line 361
    const-string v24, "downloader_init_state"

    move-object/from16 v0, p1

    move-object/from16 v1, v24

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v23

    .line 362
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->values()[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v24

    invoke-static/range {v23 .. v23}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v25

    aget-object v20, v24, v25

    .line 363
    .local v20, "st":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    sget-object v24, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v20

    move-object/from16 v1, v24

    if-eq v0, v1, :cond_b

    .line 364
    sget-object v24, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v20

    move-object/from16 v1, v24

    if-ne v0, v1, :cond_a

    const/16 v24, 0x1

    :goto_7
    move/from16 v0, v24

    move-object/from16 v1, p0

    iput-boolean v0, v1, Lcom/penthera/virtuososdk/download/Downloader;->iPauseDownloadEngine:Z

    .line 365
    move-object/from16 v0, p0

    move-object/from16 v1, v20

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    goto/16 :goto_0

    .end local v4    # "battery_level":D
    .end local v6    # "cTime":I
    .end local v7    # "cTimeS":Ljava/lang/String;
    .end local v9    # "headers":Landroid/os/Bundle;
    .end local v18    # "sTime":I
    .end local v19    # "sTimeS":Ljava/lang/String;
    .end local v20    # "st":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :cond_5
    move-object/from16 v24, v23

    .line 307
    goto/16 :goto_1

    .restart local v4    # "battery_level":D
    :cond_6
    move-object/from16 v24, v23

    .line 311
    goto/16 :goto_2

    .line 324
    .restart local v10    # "headers":Landroid/os/Bundle;
    .restart local v11    # "i":I
    .restart local v12    # "jar":Lorg/json/JSONArray;
    .restart local v13    # "jo":Lorg/json/JSONObject;
    .restart local v15    # "json":Ljava/lang/String;
    :cond_7
    :try_start_5
    invoke-virtual {v12, v11}, Lorg/json/JSONArray;->getJSONObject(I)Lorg/json/JSONObject;

    move-result-object v13

    .line 326
    invoke-virtual {v13}, Lorg/json/JSONObject;->keys()Ljava/util/Iterator;

    move-result-object v17

    .line 327
    .local v17, "myIter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    :cond_8
    :goto_8
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->hasNext()Z

    move-result v24

    if-nez v24, :cond_9

    .line 323
    add-int/lit8 v11, v11, 0x1

    goto/16 :goto_3

    .line 328
    :cond_9
    invoke-interface/range {v17 .. v17}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v16

    check-cast v16, Ljava/lang/String;

    .line 329
    .local v16, "key":Ljava/lang/String;
    move-object/from16 v0, v16

    invoke-virtual {v13, v0}, Lorg/json/JSONObject;->optString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v22

    .line 330
    .local v22, "value":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v24

    if-nez v24, :cond_8

    .line 331
    move-object/from16 v0, v16

    move-object/from16 v1, v22

    invoke-virtual {v10, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catch Lorg/json/JSONException; {:try_start_5 .. :try_end_5} :catch_0

    goto :goto_8

    .line 335
    .end local v16    # "key":Ljava/lang/String;
    .end local v17    # "myIter":Ljava/util/Iterator;, "Ljava/util/Iterator<Ljava/lang/String;>;"
    .end local v22    # "value":Ljava/lang/String;
    :catch_0
    move-exception v8

    move-object v9, v10

    .line 336
    .end local v10    # "headers":Landroid/os/Bundle;
    .end local v11    # "i":I
    .end local v12    # "jar":Lorg/json/JSONArray;
    .local v8, "e":Lorg/json/JSONException;
    .restart local v9    # "headers":Landroid/os/Bundle;
    :goto_9
    sget-object v24, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    const-string v25, "INvalid JSON header object"

    move-object/from16 v0, v24

    move-object/from16 v1, v25

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    .line 337
    const/4 v9, 0x0

    goto/16 :goto_4

    .line 364
    .end local v8    # "e":Lorg/json/JSONException;
    .end local v13    # "jo":Lorg/json/JSONObject;
    .end local v15    # "json":Ljava/lang/String;
    .restart local v6    # "cTime":I
    .restart local v7    # "cTimeS":Ljava/lang/String;
    .restart local v18    # "sTime":I
    .restart local v19    # "sTimeS":Ljava/lang/String;
    .restart local v20    # "st":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    :cond_a
    const/16 v24, 0x0

    goto :goto_7

    .line 367
    :cond_b
    invoke-direct/range {p0 .. p0}, Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V

    goto/16 :goto_0

    .line 348
    .end local v20    # "st":Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;
    .restart local v21    # "temp":I
    :catch_1
    move-exception v24

    goto/16 :goto_5

    .line 356
    :catch_2
    move-exception v24

    goto/16 :goto_6

    .line 335
    .end local v6    # "cTime":I
    .end local v7    # "cTimeS":Ljava/lang/String;
    .end local v18    # "sTime":I
    .end local v19    # "sTimeS":Ljava/lang/String;
    .end local v21    # "temp":I
    .restart local v13    # "jo":Lorg/json/JSONObject;
    .restart local v15    # "json":Ljava/lang/String;
    :catch_3
    move-exception v8

    goto :goto_9

    .end local v13    # "jo":Lorg/json/JSONObject;
    .restart local v14    # "jo":Lorg/json/JSONObject;
    :catch_4
    move-exception v8

    move-object v13, v14

    .end local v14    # "jo":Lorg/json/JSONObject;
    .restart local v13    # "jo":Lorg/json/JSONObject;
    goto :goto_9
.end method

.method ItemRemoved(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 2
    .param p1, "item"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 637
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->VirtuosoDownloadThreadCreationLock:Ljava/lang/Object;

    monitor-enter v1

    .line 638
    :try_start_0
    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->ItemRemovedNoLock(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 637
    monitor-exit v1

    .line 640
    return-void

    .line 637
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method ItemRemovedNoLock(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 4
    .param p1, "item"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 642
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v1, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v1, v2, :cond_4

    .line 644
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "c[ "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] remove item while downloading"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 645
    if-eqz p1, :cond_2

    .line 646
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    if-eqz v1, :cond_0

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v1, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_2

    .line 649
    :cond_0
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "c[ "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] not current download"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 650
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 651
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "virtuoso_file"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 652
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-interface {v1, p0, v2, v0}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 677
    .end local v0    # "extras":Landroid/os/Bundle;
    :cond_1
    :goto_0
    return-void

    .line 657
    :cond_2
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "c[ "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] is current download"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 659
    invoke-virtual {p0, p0}, Lcom/penthera/virtuososdk/download/Downloader;->removeHandlerPermissionCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 660
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    if-eqz v1, :cond_1

    .line 661
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v1

    sget-object v3, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-ne v1, v3, :cond_3

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    :goto_1
    invoke-virtual {v2, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killDownloadWithCompletionCode(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V

    goto :goto_0

    :cond_3
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_1

    .line 668
    :cond_4
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "c[ "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    const-string v3, "] not current download state not download"

    invoke-virtual {v2, v3}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 669
    const/4 v1, 0x1

    iput-boolean v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iRemoveRequestWhileNotDownloading:Z

    .line 670
    const/4 v1, 0x0

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentDownload:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 671
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 672
    .restart local v0    # "extras":Landroid/os/Bundle;
    const-string v1, "virtuoso_file"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 673
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-interface {v1, p0, v2, v0}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 674
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v1, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v1, v2, :cond_1

    .line 675
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V

    goto :goto_0
.end method

.method NewItem(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 511
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->VirtuosoDownloadThreadCreationLock:Ljava/lang/Object;

    monitor-enter v1

    .line 512
    :try_start_0
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->NewItemOrig(Landroid/os/Bundle;)V

    .line 511
    monitor-exit v1

    .line 527
    return-void

    .line 511
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method Pause()V
    .locals 2

    .prologue
    .line 576
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPauseDownloadEngine:Z

    .line 577
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v0, v1, :cond_1

    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v0, v1, :cond_1

    .line 579
    sget-object v0, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 585
    :cond_0
    :goto_0
    return-void

    .line 580
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v0, v1, :cond_0

    .line 581
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    if-eqz v0, :cond_0

    .line 582
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadThread:Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killDownloadWithCompletionCode(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V

    goto :goto_0
.end method

.method PriorityDownload(Landroid/os/Bundle;)V
    .locals 2
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 373
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->VirtuosoDownloadThreadCreationLock:Ljava/lang/Object;

    monitor-enter v1

    .line 374
    :try_start_0
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->PriorityDownloadOrig(Landroid/os/Bundle;)V

    .line 373
    monitor-exit v1

    .line 389
    return-void

    .line 373
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method Resume()V
    .locals 2

    .prologue
    .line 589
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader;->VirtuosoDownloadThreadCreationLock:Ljava/lang/Object;

    monitor-enter v1

    .line 590
    :try_start_0
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader;->ResumeOrig()V

    .line 589
    monitor-exit v1

    .line 605
    return-void

    .line 589
    :catchall_0
    move-exception v0

    monitor-exit v1
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v0
.end method

.method public RetryOnStorageChange()V
    .locals 3

    .prologue
    .line 2581
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v0, v1, :cond_1

    .line 2582
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iLastFileCompletionErrorCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v0, v1, :cond_0

    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iLastFileCompletionErrorCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v0, v1, :cond_1

    .line 2583
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "c[ "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] Creating Retry from blocked storage state"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 2584
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V

    .line 2587
    :cond_1
    return-void
.end method

.method availableCellUsage()D
    .locals 4

    .prologue
    .line 873
    iget-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    iget-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    sub-double/2addr v0, v2

    return-wide v0
.end method

.method public cellOkay(I)Z
    .locals 6
    .param p1, "aChange"    # I

    .prologue
    .line 867
    iget-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    iget-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    int-to-double v4, p1

    add-double/2addr v2, v4

    cmpl-double v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method public clearTestSettings()V
    .locals 1

    .prologue
    .line 268
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    invoke-virtual {v0}, Landroid/os/Bundle;->clear()V

    .line 269
    return-void
.end method

.method getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .locals 10

    .prologue
    const/4 v6, 0x0

    const/4 v5, 0x1

    .line 806
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v8, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_AuthenticationFailure:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v7, v8, :cond_0

    .line 807
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 863
    :goto_0
    return-object v5

    .line 811
    :cond_0
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v8, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v7, v8, :cond_1

    iget-boolean v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPauseDownloadEngine:Z

    if-eqz v7, :cond_2

    .line 812
    :cond_1
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto :goto_0

    .line 816
    :cond_2
    const/4 v4, 0x0

    .line 818
    .local v4, "usingCell":Z
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;

    const-string v8, "connectivity"

    invoke-virtual {v7, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/ConnectivityManager;

    .line 819
    .local v1, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v1}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v7

    iput-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iNetworkInfo:Landroid/net/NetworkInfo;

    .line 821
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iNetworkInfo:Landroid/net/NetworkInfo;

    if-eqz v7, :cond_3

    .line 822
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iNetworkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v7}, Landroid/net/NetworkInfo;->getType()I

    move-result v7

    if-nez v7, :cond_5

    move v4, v5

    .line 823
    :cond_3
    :goto_1
    if-eqz v4, :cond_6

    move v2, v6

    .line 825
    .local v2, "connectionType":I
    :goto_2
    if-nez v2, :cond_7

    invoke-virtual {p0, v5}, Lcom/penthera/virtuososdk/download/Downloader;->cellOkay(I)Z

    move-result v6

    if-eqz v6, :cond_4

    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v7, "enable_download_cell"

    invoke-virtual {v6, v7, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    if-nez v6, :cond_7

    .line 826
    :cond_4
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "c[ "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] Blocking download because of cellular considerations"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 827
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto :goto_0

    .end local v2    # "connectionType":I
    :cond_5
    move v4, v6

    .line 822
    goto :goto_1

    :cond_6
    move v2, v5

    .line 823
    goto :goto_2

    .line 828
    .restart local v2    # "connectionType":I
    :cond_7
    if-ne v2, v5, :cond_8

    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v7, "enable_download_wifi"

    invoke-virtual {v6, v7, v5}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v6

    if-nez v6, :cond_8

    .line 829
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedWifi:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto :goto_0

    .line 832
    :cond_8
    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iNetworkInfo:Landroid/net/NetworkInfo;

    if-eqz v6, :cond_9

    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iNetworkInfo:Landroid/net/NetworkInfo;

    if-eqz v6, :cond_a

    iget-object v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iNetworkInfo:Landroid/net/NetworkInfo;

    invoke-virtual {v6}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v6

    if-nez v6, :cond_a

    .line 833
    :cond_9
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "c[ "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] Blocking download because of no network"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 834
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedWifi:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto/16 :goto_0

    .line 838
    :cond_a
    invoke-virtual {p0, v5}, Lcom/penthera/virtuososdk/download/Downloader;->storageOkay(I)Z

    move-result v5

    if-nez v5, :cond_b

    .line 839
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "c[ "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] Blocking download because storage not available"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 840
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto/16 :goto_0

    .line 843
    :cond_b
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    const-string v6, "battery_threshold_override"

    .line 844
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    const-string v8, "battery_threshold"

    const/4 v9, -0x1

    invoke-virtual {v7, v8, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v7

    .line 843
    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v5

    iput v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryThreshold:I

    .line 847
    iget v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryThreshold:I

    if-gez v5, :cond_c

    .line 848
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "c[ "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] Blocking download for battery because we could not get the setting from the bundle!!"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 849
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto/16 :goto_0

    .line 852
    :cond_c
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v6, "battery_charging"

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->isCharging()Z

    move-result v7

    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    if-nez v5, :cond_d

    .line 853
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v6, "battery_level"

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->getLevel()I

    move-result v7

    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    .line 854
    .local v3, "current_battery_level":I
    const/16 v5, 0x64

    iget v6, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryThreshold:I

    invoke-static {v5, v6}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 855
    .local v0, "acceptable_level":I
    if-le v0, v3, :cond_d

    .line 857
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "c[ "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] Blocking download because battery level ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ") < setting ("

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, ")"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 858
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto/16 :goto_0

    .line 863
    .end local v0    # "acceptable_level":I
    .end local v3    # "current_battery_level":I
    :cond_d
    sget-object v5, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    goto/16 :goto_0
.end method

.method public onBatteryLevelChanged(I)V
    .locals 2
    .param p1, "level"    # I

    .prologue
    .line 2521
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    if-ne v0, v1, :cond_1

    .line 2522
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    const-string v1, "battery change call resume"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2523
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    .line 2528
    :cond_0
    :goto_0
    return-void

    .line 2524
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v0, v1, :cond_0

    .line 2525
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    const-string v1, "battery change during download set resume pending"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2526
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    goto :goto_0
.end method

.method public onConnectivityChange(Landroid/net/NetworkInfo;)V
    .locals 6
    .param p1, "nInfo"    # Landroid/net/NetworkInfo;

    .prologue
    const/4 v2, 0x1

    .line 2535
    invoke-static {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$NetworkHelpers;->dump(Landroid/net/NetworkInfo;)V

    .line 2537
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    const-string v4, "wifi"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Landroid/net/wifi/WifiManager;

    .line 2540
    .local v1, "theMan":Landroid/net/wifi/WifiManager;
    invoke-static {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$NetworkHelpers;->dump(Landroid/net/wifi/WifiManager;)V

    .line 2542
    if-eqz p1, :cond_0

    invoke-virtual {p1}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v3

    if-eqz v3, :cond_0

    .line 2543
    sget-object v3, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "c[ "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "] onConnectivityChange(): Network gained - current status "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 2544
    iget-boolean v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPauseDownloadEngine:Z

    if-nez v3, :cond_0

    .line 2546
    invoke-virtual {p1}, Landroid/net/NetworkInfo;->getType()I

    move-result v3

    if-nez v3, :cond_1

    move v0, v2

    .line 2547
    .local v0, "is_cell":Z
    :goto_0
    if-eqz v0, :cond_2

    invoke-virtual {p0, v2}, Lcom/penthera/virtuososdk/download/Downloader;->cellOkay(I)Z

    move-result v3

    if-nez v3, :cond_2

    .line 2548
    sget-object v2, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    const-string v3, "connectivity change cell not okay returning"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2562
    .end local v0    # "is_cell":Z
    :cond_0
    :goto_1
    return-void

    .line 2546
    :cond_1
    const/4 v0, 0x0

    goto :goto_0

    .line 2551
    .restart local v0    # "is_cell":Z
    :cond_2
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v3, v3, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v4, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v3, v4, :cond_3

    .line 2552
    sget-object v2, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    const-string v3, "connectivity change call resume"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2553
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    goto :goto_1

    .line 2556
    :cond_3
    sget-object v3, Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;

    const-string v4, "connectivity change during download set resume pending"

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2557
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iConnChangeResumePending:Z

    goto :goto_1
.end method

.method public onPowerConnected()V
    .locals 2

    .prologue
    .line 2507
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v0, v1, :cond_1

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v0

    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    if-ne v0, v1, :cond_1

    .line 2508
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    .line 2512
    :cond_0
    :goto_0
    return-void

    .line 2509
    :cond_1
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v0, v1, :cond_0

    .line 2510
    const/4 v0, 0x1

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    goto :goto_0
.end method

.method public onPowerDisconnected()V
    .locals 0

    .prologue
    .line 2517
    return-void
.end method

.method public powerStatusOK()Z
    .locals 10

    .prologue
    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 779
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    const-string v6, "battery_threshold_override"

    .line 780
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatterySettingsBundle:Landroid/os/Bundle;

    const-string v8, "battery_threshold"

    const/4 v9, -0x1

    invoke-virtual {v7, v8, v9}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v7

    .line 779
    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 783
    .local v1, "bt":I
    if-gez v1, :cond_1

    .line 790
    :cond_0
    :goto_0
    return v3

    .line 785
    :cond_1
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v6, "battery_charging"

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->isCharging()Z

    move-result v7

    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v5

    if-eqz v5, :cond_2

    move v3, v4

    goto :goto_0

    .line 787
    :cond_2
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v6, "battery_level"

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->getLevel()I

    move-result v7

    invoke-virtual {v5, v6, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v2

    .line 789
    .local v2, "current_battery_level":I
    const/16 v5, 0x64

    invoke-static {v5, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 790
    .local v0, "acceptable_level":I
    if-gt v0, v2, :cond_0

    move v3, v4

    goto :goto_0
.end method

.method removeHandlerPermissionCheck(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 2
    .param p1, "d"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 727
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader;->iHandler:Landroid/os/Handler;

    const/4 v1, 0x1

    invoke-virtual {v0, v1, p1}, Landroid/os/Handler;->removeMessages(ILjava/lang/Object;)V

    .line 728
    return-void
.end method

.method requestPermissionChecks(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 4
    .param p1, "d"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 731
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 732
    .local v0, "msg":Landroid/os/Message;
    const/4 v1, 0x1

    iput v1, v0, Landroid/os/Message;->what:I

    .line 733
    iput-object p1, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 734
    sget-object v1, Lcom/penthera/virtuososdk/download/Downloader;->iHandler:Landroid/os/Handler;

    const-wide/16 v2, 0x1388

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 735
    return-void
.end method

.method public setClientConfiguration(Landroid/os/Bundle;II)V
    .locals 2
    .param p1, "headers"    # Landroid/os/Bundle;
    .param p2, "aConnectionTimeOut"    # I
    .param p3, "aSocketTimeout"    # I

    .prologue
    const/4 v1, -0x1

    .line 2567
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader;->iClientConfiguredHeaders:Landroid/os/Bundle;

    .line 2568
    if-le p3, v1, :cond_0

    .line 2569
    sput p3, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_SOCKET_TIMEOUT:I

    .line 2572
    :goto_0
    if-le p2, v1, :cond_1

    .line 2573
    sput p2, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_CONNECTION_TIMEOUT:I

    .line 2577
    :goto_1
    return-void

    .line 2571
    :cond_0
    const/16 v0, 0x7530

    sput v0, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_SOCKET_TIMEOUT:I

    goto :goto_0

    .line 2575
    :cond_1
    const v0, 0xea60

    sput v0, Lcom/penthera/virtuososdk/download/Downloader;->HTTP_CONNECTION_TIMEOUT:I

    goto :goto_1
.end method

.method public setTestSettings(Landroid/os/Bundle;)V
    .locals 9
    .param p1, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 223
    const/4 v3, 0x0

    .line 224
    .local v3, "doPowerConnected":Z
    const/4 v4, 0x0

    .line 225
    .local v4, "doPowerDisconnected":Z
    const/4 v2, 0x0

    .line 227
    .local v2, "doLevelChange":Z
    if-eqz p1, :cond_2

    .line 229
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v8, "battery_charging"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    const-string v7, "battery_charging"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_7

    .line 230
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v8, "battery_charging"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v1

    .line 231
    .local v1, "current":Z
    const-string v7, "battery_charging"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v0

    .line 232
    .local v0, "change":Z
    if-eq v0, v1, :cond_0

    .line 233
    if-eqz v0, :cond_6

    .line 234
    const/4 v3, 0x1

    .line 246
    .end local v0    # "change":Z
    .end local v1    # "current":Z
    :cond_0
    :goto_0
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v8, "battery_level"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_a

    const-string v7, "battery_level"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_a

    .line 247
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v8, "battery_level"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    .line 248
    .local v1, "current":I
    const-string v7, "battery_level"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v0

    .line 249
    .local v0, "change":I
    if-eq v0, v1, :cond_9

    const/4 v2, 0x1

    .line 253
    .end local v0    # "change":I
    .end local v1    # "current":I
    :cond_1
    :goto_1
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    invoke-virtual {v7, p1}, Landroid/os/Bundle;->putAll(Landroid/os/Bundle;)V

    .line 254
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v8, "enable_download_wifi"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_2

    .line 255
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v7

    const-string v8, "wifi"

    invoke-virtual {v7, v8}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v6

    check-cast v6, Landroid/net/wifi/WifiManager;

    .line 256
    .local v6, "theMan":Landroid/net/wifi/WifiManager;
    if-eqz v6, :cond_2

    .line 257
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v8, "enable_download_wifi"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v5

    .line 258
    .local v5, "enable":Z
    invoke-virtual {v6, v5}, Landroid/net/wifi/WifiManager;->setWifiEnabled(Z)Z

    .line 262
    .end local v5    # "enable":Z
    .end local v6    # "theMan":Landroid/net/wifi/WifiManager;
    :cond_2
    if-eqz v3, :cond_3

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->onPowerConnected()V

    .line 263
    :cond_3
    if-eqz v4, :cond_4

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/Downloader;->onPowerDisconnected()V

    .line 264
    :cond_4
    if-eqz v2, :cond_5

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;

    const-string v8, "battery_level"

    invoke-virtual {v7, v8}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v7

    invoke-virtual {p0, v7}, Lcom/penthera/virtuososdk/download/Downloader;->onBatteryLevelChanged(I)V

    .line 265
    :cond_5
    return-void

    .line 236
    .local v0, "change":Z
    .local v1, "current":Z
    :cond_6
    const/4 v4, 0x1

    goto :goto_0

    .line 239
    .end local v0    # "change":Z
    .end local v1    # "current":Z
    :cond_7
    const-string v7, "battery_charging"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_0

    .line 240
    const-string v7, "battery_charging"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_8

    .line 241
    const/4 v3, 0x1

    goto :goto_0

    .line 243
    :cond_8
    const/4 v4, 0x1

    goto :goto_0

    .line 249
    .local v0, "change":I
    .local v1, "current":I
    :cond_9
    const/4 v2, 0x0

    goto :goto_1

    .line 250
    .end local v0    # "change":I
    .end local v1    # "current":I
    :cond_a
    const-string v7, "battery_level"

    invoke-virtual {p1, v7}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v7

    if-eqz v7, :cond_1

    .line 251
    const/4 v2, 0x1

    goto :goto_1
.end method

.method public status()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .locals 1

    .prologue
    .line 157
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    return-object v0
.end method

.method public storageOkay(I)Z
    .locals 6
    .param p1, "aChange"    # I

    .prologue
    .line 870
    iget-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    iget-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    int-to-double v4, p1

    add-double/2addr v2, v4

    cmpl-double v0, v0, v2

    if-ltz v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method
