.class public final Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
.super Ljava/lang/Object;
.source "DownloadEngineClientManager.java"

# interfaces
.implements Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;
.implements Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
.implements Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;
.implements Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;
.implements Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;,
        Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus:[I

.field private static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus:[I

.field private static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType:[I

.field private static final LOG_TAG:Ljava/lang/String;

.field private static final iDiskCheckHandler:Landroid/os/Handler;

.field private static iDownloadClientSettings:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;",
            ">;"
        }
    .end annotation
.end field

.field private static iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;",
            ">;"
        }
    .end annotation
.end field

.field private static iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/penthera/virtuososdk/download/Downloader;",
            ">;"
        }
    .end annotation
.end field

.field private static iInstance:Ljava/lang/ref/SoftReference;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/lang/ref/SoftReference",
            "<",
            "Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;",
            ">;"
        }
    .end annotation
.end field


# instance fields
.field private iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

.field private iConnectivityMonitor:Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;

.field private iContext:Landroid/content/Context;

.field private iDbInit:Z

.field private iDefaultAuthority:Ljava/lang/String;

.field iErrorItemsTimer:Ljava/util/Timer;

.field iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

.field private iNetworkInfo:Landroid/net/NetworkInfo;

.field iProvidersInstance:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

.field private iResolver:Landroid/content/ContentResolver;

.field private lwm:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;


# direct methods
.method static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus()[I
    .locals 3

    .prologue
    .line 52
    sget-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->values()[Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_e

    :goto_1
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete_Pending_Integrity_Check:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_d

    :goto_2
    :try_start_2
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_c

    :goto_3
    :try_start_3
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_b

    :goto_4
    :try_start_4
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_a

    :goto_5
    :try_start_5
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_9

    :goto_6
    :try_start_6
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_HLS_Fragment_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0xf

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_8

    :goto_7
    :try_start_7
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_7

    :goto_8
    :try_start_8
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Not_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_6

    :goto_9
    :try_start_9
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_5

    :goto_a
    :try_start_a
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_4

    :goto_b
    :try_start_b
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_3

    :goto_c
    :try_start_c
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Collection_Partially_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0xd

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_2

    :goto_d
    :try_start_d
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0xc

    aput v2, v0, v1
    :try_end_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d .. :try_end_d} :catch_1

    :goto_e
    :try_start_e
    sget-object v1, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_HLS_Manifest_Processing:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v1

    const/16 v2, 0xe

    aput v2, v0, v1
    :try_end_e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_e .. :try_end_e} :catch_0

    :goto_f
    sput-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus:[I

    goto/16 :goto_0

    :catch_0
    move-exception v1

    goto :goto_f

    :catch_1
    move-exception v1

    goto :goto_e

    :catch_2
    move-exception v1

    goto :goto_d

    :catch_3
    move-exception v1

    goto :goto_c

    :catch_4
    move-exception v1

    goto :goto_b

    :catch_5
    move-exception v1

    goto :goto_a

    :catch_6
    move-exception v1

    goto :goto_9

    :catch_7
    move-exception v1

    goto :goto_8

    :catch_8
    move-exception v1

    goto :goto_7

    :catch_9
    move-exception v1

    goto :goto_6

    :catch_a
    move-exception v1

    goto :goto_5

    :catch_b
    move-exception v1

    goto/16 :goto_4

    :catch_c
    move-exception v1

    goto/16 :goto_3

    :catch_d
    move-exception v1

    goto/16 :goto_2

    :catch_e
    move-exception v1

    goto/16 :goto_1
.end method

.method static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus()[I
    .locals 3

    .prologue
    .line 52
    sget-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->values()[Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_AuthenticationFailure:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_6

    :goto_1
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_5

    :goto_2
    :try_start_2
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Disabled:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_4

    :goto_3
    :try_start_3
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_3

    :goto_4
    :try_start_4
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_2

    :goto_5
    :try_start_5
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_1

    :goto_6
    :try_start_6
    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_0

    :goto_7
    sput-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus:[I

    goto :goto_0

    :catch_0
    move-exception v1

    goto :goto_7

    :catch_1
    move-exception v1

    goto :goto_6

    :catch_2
    move-exception v1

    goto :goto_5

    :catch_3
    move-exception v1

    goto :goto_4

    :catch_4
    move-exception v1

    goto :goto_3

    :catch_5
    move-exception v1

    goto :goto_2

    :catch_6
    move-exception v1

    goto :goto_1
.end method

.method static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[I
    .locals 3

    .prologue
    .line 52
    sget-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->values()[Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0xf

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_10

    :goto_1
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionProgress:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0xe

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_f

    :goto_2
    :try_start_2
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0xc

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_e

    :goto_3
    :try_start_3
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ECollectionsDeleted:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0xd

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_d

    :goto_4
    :try_start_4
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadEnd:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_c

    :goto_5
    :try_start_5
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadQueueChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_b

    :goto_6
    :try_start_6
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadStart:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_a

    :goto_7
    :try_start_7
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadedListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_9

    :goto_8
    :try_start_8
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFragmentComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0x10

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_8

    :goto_9
    :try_start_9
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EFullListChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_7

    :goto_a
    :try_start_a
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0x11

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_6

    :goto_b
    :try_start_b
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_5

    :goto_c
    :try_start_c
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EListFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_4

    :goto_d
    :try_start_d
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EListFilesIteratively:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d .. :try_end_d} :catch_3

    :goto_e
    :try_start_e
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EProgressUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_e .. :try_end_e} :catch_2

    :goto_f
    :try_start_f
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ESettingsChanged:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_f
    .catch Ljava/lang/NoSuchFieldError; {:try_start_f .. :try_end_f} :catch_1

    :goto_10
    :try_start_10
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EStatusChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_10
    .catch Ljava/lang/NoSuchFieldError; {:try_start_10 .. :try_end_10} :catch_0

    :goto_11
    sput-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType:[I

    goto/16 :goto_0

    :catch_0
    move-exception v1

    goto :goto_11

    :catch_1
    move-exception v1

    goto :goto_10

    :catch_2
    move-exception v1

    goto :goto_f

    :catch_3
    move-exception v1

    goto :goto_e

    :catch_4
    move-exception v1

    goto :goto_d

    :catch_5
    move-exception v1

    goto :goto_c

    :catch_6
    move-exception v1

    goto :goto_b

    :catch_7
    move-exception v1

    goto :goto_a

    :catch_8
    move-exception v1

    goto :goto_9

    :catch_9
    move-exception v1

    goto :goto_8

    :catch_a
    move-exception v1

    goto :goto_7

    :catch_b
    move-exception v1

    goto/16 :goto_6

    :catch_c
    move-exception v1

    goto/16 :goto_5

    :catch_d
    move-exception v1

    goto/16 :goto_4

    :catch_e
    move-exception v1

    goto/16 :goto_3

    :catch_f
    move-exception v1

    goto/16 :goto_2

    :catch_10
    move-exception v1

    goto/16 :goto_1
.end method

.method static constructor <clinit>()V
    .locals 1

    .prologue
    .line 54
    const-class v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    invoke-virtual {v0}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v0

    sput-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    .line 75
    new-instance v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$1;

    invoke-direct {v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$1;-><init>()V

    sput-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDiskCheckHandler:Landroid/os/Handler;

    .line 52
    return-void
.end method

.method private constructor <init>(Landroid/content/Context;Ljava/lang/String;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "default_authority"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x0

    .line 125
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 69
    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->lwm:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    .line 71
    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    .line 73
    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    .line 106
    const/4 v1, 0x0

    iput-boolean v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDbInit:Z

    .line 126
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    .line 127
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    const-string v2, "connectivity"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 128
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iNetworkInfo:Landroid/net/NetworkInfo;

    .line 129
    iput-object p2, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDefaultAuthority:Ljava/lang/String;

    .line 130
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    invoke-virtual {v1}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    .line 131
    new-instance v1, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-direct {v1, v2, p2}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iProvidersInstance:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    .line 132
    new-instance v1, Lcom/penthera/virtuososdk/manager/FileManager;

    invoke-direct {v1}, Lcom/penthera/virtuososdk/manager/FileManager;-><init>()V

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    .line 137
    invoke-static {}, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->getInstance()Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iConnectivityMonitor:Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;

    .line 138
    invoke-static {}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->getInstance()Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    .line 139
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->initClients()V

    .line 140
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iConnectivityMonitor:Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;

    invoke-virtual {v1, p0}, Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor;->addObserver(Lcom/penthera/virtuososdk/monitor/ConnectivityMonitor$IOnConnectivityChangeObserver;)V

    .line 141
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    invoke-virtual {v1, p0}, Lcom/penthera/virtuososdk/monitor/BatteryMonitor;->addObserver(Lcom/penthera/virtuososdk/monitor/BatteryMonitor$IBatteryObserver;)V

    .line 142
    invoke-static {}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->instance()Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    move-result-object v1

    iput-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->lwm:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    .line 143
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->lwm:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    invoke-virtual {v1, p0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->addObserver(Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor$IWifiCheckObserver;)V

    .line 144
    return-void
.end method

.method static synthetic access$0()Ljava/lang/String;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1

    .prologue
    .line 64
    sget-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method static synthetic access$2()Ljava/util/concurrent/ConcurrentHashMap;
    .locals 1

    .prologue
    .line 63
    sget-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientSettings:Ljava/util/concurrent/ConcurrentHashMap;

    return-object v0
.end method

.method static synthetic access$6(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V
    .locals 0

    .prologue
    .line 753
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->performRetryErrorQueue(Ljava/lang/String;)V

    return-void
.end method

.method private availableCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D
    .locals 8
    .param p1, "si"    # Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    .prologue
    const-wide/16 v2, 0x0

    .line 897
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellquota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v4

    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->usedCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v6

    sub-double v0, v4, v6

    .line 898
    .local v0, "available":D
    cmpg-double v4, v0, v2

    if-gez v4, :cond_0

    move-wide v0, v2

    .end local v0    # "available":D
    :cond_0
    return-wide v0
.end method

.method private cellQuotaDisabled(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)Z
    .locals 4
    .param p1, "si"    # Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    .prologue
    .line 905
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellquota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v0

    const-wide/16 v2, 0x0

    cmpg-double v0, v0, v2

    if-gez v0, :cond_0

    const/4 v0, 0x1

    :goto_0
    return v0

    :cond_0
    const/4 v0, 0x0

    goto :goto_0
.end method

.method private cellquota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D
    .locals 4
    .param p1, "si"    # Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    .prologue
    .line 909
    const-string v1, "cell_data_quota_override"

    invoke-virtual {p1, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 911
    .local v0, "cell_quota":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 912
    const-string v1, "cell_data_quota"

    invoke-virtual {p1, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 914
    :cond_0
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-nez v1, :cond_1

    .line 915
    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    .line 917
    :goto_0
    return-wide v2

    :cond_1
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method private clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 189
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientSettings:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 190
    new-instance v0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-direct {v0, v1, p1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 191
    .local v0, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientSettings:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 193
    .end local v0    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :cond_0
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientSettings:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    return-object v1
.end method

.method private downloadBundleForNextItem(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;
    .locals 8
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 261
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->nextItemForDownloader(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v2

    .line 262
    .local v2, "item":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v2, :cond_1

    .line 264
    sget-object v4, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    iget-object v5, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    .line 265
    .local v0, "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    iget-object v4, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {p0, v4}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v3

    .line 266
    .local v3, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-virtual {v0, v3}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    .line 268
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 269
    .local v1, "extras":Landroid/os/Bundle;
    const-string v4, "fragment_download_progress_rate"

    const-string v5, "default_configuration_fragment_rate"

    const/4 v6, 0x1

    invoke-virtual {v3, v5, v6}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;Z)Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Ljava/lang/Integer;->parseInt(Ljava/lang/String;)I

    move-result v5

    invoke-virtual {v1, v4, v5}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 270
    const-string v4, "download_file_data"

    invoke-virtual {v1, v4, v2}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 271
    const-string v6, "max_download_size_cellular"

    invoke-direct {p0, v3}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellQuotaDisabled(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)Z

    move-result v4

    if-eqz v4, :cond_0

    iget-wide v4, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    :goto_0
    invoke-virtual {v1, v6, v4, v5}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 272
    const-string v4, "max_download_size"

    iget-wide v6, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    invoke-virtual {v1, v4, v6, v7}, Landroid/os/Bundle;->putDouble(Ljava/lang/String;D)V

    .line 275
    .end local v0    # "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    .end local v1    # "extras":Landroid/os/Bundle;
    .end local v3    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :goto_1
    return-object v1

    .line 271
    .restart local v0    # "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    .restart local v1    # "extras":Landroid/os/Bundle;
    .restart local v3    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :cond_0
    invoke-direct {p0, v3}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->availableCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v4

    goto :goto_0

    .line 275
    .end local v0    # "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    .end local v1    # "extras":Landroid/os/Bundle;
    .end local v3    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :cond_1
    const/4 v1, 0x0

    goto :goto_1
.end method

.method private downloadClient(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 185
    sget-object v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v0, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/Downloader;

    return-object v0
.end method

.method private getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;
    .locals 7
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 174
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1}, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v1

    if-nez v1, :cond_0

    .line 175
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iBatteryMonitor:Lcom/penthera/virtuososdk/monitor/BatteryMonitor;

    move-object v2, p1

    move-object v3, p0

    move-object v4, p0

    invoke-direct/range {v0 .. v5}, Lcom/penthera/virtuososdk/download/Downloader;-><init>(Landroid/content/Context;Ljava/lang/String;Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;Lcom/penthera/virtuososdk/download/Downloader$DownloadQuotaProvider;Lcom/penthera/virtuososdk/monitor/BatteryMonitor;)V

    .line 176
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v1, p1, v0}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 178
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v6

    .line 179
    .local v6, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    new-instance v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    invoke-direct {v2, p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;-><init>(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V

    invoke-virtual {v1, p1, v2}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 180
    invoke-virtual {v6}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->getBundle()Landroid/os/Bundle;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader;->InitiliazationComplete(Landroid/os/Bundle;)V

    .line 182
    .end local v0    # "client":Lcom/penthera/virtuososdk/download/Downloader;
    .end local v6    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :cond_0
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->downloadClient(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v1

    return-object v1
.end method

.method public static declared-synchronized getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .locals 5
    .param p0, "context"    # Landroid/content/Context;
    .param p1, "default_authority"    # Ljava/lang/String;

    .prologue
    .line 113
    const-class v4, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    monitor-enter v4

    const/4 v1, 0x0

    .line 114
    .local v1, "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    :try_start_0
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iInstance:Ljava/lang/ref/SoftReference;

    if-eqz v3, :cond_1

    .line 115
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iInstance:Ljava/lang/ref/SoftReference;

    invoke-virtual {v3}, Ljava/lang/ref/SoftReference;->get()Ljava/lang/Object;

    move-result-object v3

    move-object v0, v3

    check-cast v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-object v1, v0
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-object v2, v1

    .line 118
    .end local v1    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .local v2, "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    :goto_0
    if-nez v2, :cond_0

    .line 119
    :try_start_1
    new-instance v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    invoke-direct {v1, p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;-><init>(Landroid/content/Context;Ljava/lang/String;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 120
    .end local v2    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .restart local v1    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    :try_start_2
    new-instance v3, Ljava/lang/ref/SoftReference;

    invoke-direct {v3, v1}, Ljava/lang/ref/SoftReference;-><init>(Ljava/lang/Object;)V

    sput-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iInstance:Ljava/lang/ref/SoftReference;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 122
    :goto_1
    monitor-exit v4

    return-object v1

    .line 113
    :catchall_0
    move-exception v3

    :goto_2
    monitor-exit v4

    throw v3

    .end local v1    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .restart local v2    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    :catchall_1
    move-exception v3

    move-object v1, v2

    .end local v2    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .restart local v1    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    goto :goto_2

    .end local v1    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .restart local v2    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    :cond_0
    move-object v1, v2

    .end local v2    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .restart local v1    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    goto :goto_1

    :cond_1
    move-object v2, v1

    .end local v1    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .restart local v2    # "instance":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    goto :goto_0
.end method

.method private handleFileComplete(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/os/Bundle;)V
    .locals 9
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "file"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p3, "bundle"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    const/4 v7, 0x0

    .line 328
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_2

    move-object v5, p2

    .line 329
    check-cast v5, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-interface {v5, v7}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setPending(Z)V

    :cond_0
    :goto_0
    move-object v5, p2

    .line 333
    check-cast v5, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-direct {p0, v5}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V

    .line 335
    new-instance v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v6, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {v3, v5, v6}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 336
    .local v3, "reg":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    invoke-virtual {v3, v8}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 337
    .local v2, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v5

    invoke-interface {v2, v5}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    move-result v4

    .line 338
    .local v4, "wasRemoved":Z
    if-eqz v4, :cond_1

    .line 339
    invoke-virtual {v3, v8, v2}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueueNoAdd(Ljava/lang/String;Ljava/util/List;)V

    .line 342
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v6

    iget-object v7, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v5, v6, v7}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 343
    .local v0, "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v0, :cond_1

    move-object v5, v0

    check-cast v5, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-interface {v5}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->getContentState()I

    move-result v5

    if-nez v5, :cond_1

    .line 344
    const-string v5, "download_update_data"

    invoke-virtual {p3, v5, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 345
    const-string v5, "com.penthera.virtuososdk.client.pckg"

    iget-object v6, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {p3, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 346
    const-string v5, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    invoke-static {v5, p3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 351
    .end local v0    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_1
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 352
    .local v1, "extras":Landroid/os/Bundle;
    const-string v5, "com.penthera.virtuososdk.client.pckg"

    iget-object v6, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v1, v5, v6}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 353
    const-string v5, "virtuoso.intent.action.QUEUE_CHANGED"

    invoke-static {v5, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 354
    const-string v5, "virtuoso.intent.action.DOWNLOAD_LIST_CHANGED"

    invoke-static {v5, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 355
    return-void

    .line 330
    .end local v1    # "extras":Landroid/os/Bundle;
    .end local v2    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v3    # "reg":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    .end local v4    # "wasRemoved":Z
    :cond_2
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v5

    const/4 v6, 0x4

    if-ne v5, v6, :cond_0

    move-object v5, p2

    .line 331
    check-cast v5, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-interface {v5, v7}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setPending(Z)V

    goto :goto_0
.end method

.method private handleFileErrored(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 9
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "file"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    const/4 v8, 0x0

    .line 313
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v2

    const/4 v3, 0x1

    if-ne v2, v3, :cond_0

    move-object v2, p2

    .line 314
    check-cast v2, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object v3, p2

    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-interface {v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->errorCount()J

    move-result-wide v4

    const-wide/16 v6, 0x1

    add-long/2addr v4, v6

    invoke-interface {v2, v4, v5}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setErrorCount(J)V

    :cond_0
    move-object v2, p2

    .line 315
    check-cast v2, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V

    .line 317
    new-instance v1, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v3, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 318
    .local v1, "reg":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    invoke-virtual {v1, v8}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 319
    .local v0, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 320
    invoke-virtual {v1, v8, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueueNoAdd(Ljava/lang/String;Ljava/util/List;)V

    .line 321
    invoke-virtual {v1, v8}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 322
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v2

    invoke-interface {v0, v2}, Ljava/util/List;->add(Ljava/lang/Object;)Z

    .line 323
    invoke-virtual {v1, v8, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 324
    return-void
.end method

.method private handleFileStart(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z
    .locals 8
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "file"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;
        }
    .end annotation

    .prologue
    const/4 v7, 0x0

    const/4 v6, 0x0

    .line 359
    const/4 v2, 0x0

    .line 360
    .local v2, "qchange":Z
    new-instance v3, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v5, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {v3, v4, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 361
    .local v3, "reg":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    invoke-virtual {v3, v6}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 362
    .local v1, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    if-lez v4, :cond_1

    .line 363
    invoke-interface {v1, v7}, Ljava/util/List;->get(I)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 364
    .local v0, "first":Ljava/lang/String;
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v0, v4}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_1

    .line 365
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-nez v4, :cond_0

    new-instance v4, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;

    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v4, p0, v5}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;-><init>(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V

    throw v4

    .line 366
    :cond_0
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 367
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v7, v4}, Ljava/util/List;->add(ILjava/lang/Object;)V

    .line 368
    invoke-virtual {v3, v6, v1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueueNoAdd(Ljava/lang/String;Ljava/util/List;)V

    .line 369
    const/4 v2, 0x1

    .line 373
    .end local v0    # "first":Ljava/lang/String;
    :cond_1
    invoke-virtual {v3, v6}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 374
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v4

    if-eqz v4, :cond_2

    .line 375
    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-interface {v1, v4}, Ljava/util/List;->remove(Ljava/lang/Object;)Z

    .line 376
    invoke-virtual {v3, v6, v1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    :cond_2
    move-object v4, p2

    .line 379
    check-cast v4, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    sget-object v5, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface {v4, v5}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 380
    check-cast p2, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    .end local p2    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-direct {p0, p2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V

    .line 381
    return v2
.end method

.method private handleRetryErrorQueue(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 6
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    const/4 v5, 0x0

    .line 386
    new-instance v2, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    iget-object v3, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v4, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {v2, v3, v4}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 387
    .local v2, "reg":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    invoke-virtual {v2, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 388
    .local v1, "pq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v2, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 389
    .local v0, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v3

    if-lez v3, :cond_0

    .line 390
    invoke-interface {v1, v0}, Ljava/util/List;->addAll(Ljava/util/Collection;)Z

    .line 391
    invoke-interface {v0}, Ljava/util/List;->clear()V

    .line 392
    invoke-virtual {v2, v5, v0}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->saveErrorQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 393
    invoke-virtual {v2, v5, v1}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->savePendingQueue(Ljava/lang/String;Ljava/util/List;)V

    .line 395
    :cond_0
    return-void
.end method

.method private interruptClientDownloader(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 1
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 245
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->downloadBundleForNextItem(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v0

    .line 246
    .local v0, "downloadBundle":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 247
    invoke-virtual {p1, v0}, Lcom/penthera/virtuososdk/download/Downloader;->PriorityDownload(Landroid/os/Bundle;)V

    .line 249
    :cond_0
    return-void
.end method

.method private nextItemForDownloader(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .locals 11
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    const/4 v5, 0x0

    const/4 v10, 0x4

    .line 281
    new-instance v1, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;

    iget-object v6, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v7, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {v1, v6, v7}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 282
    .local v1, "reg":Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;
    invoke-virtual {v1, v5}, Lcom/penthera/virtuososdk/database/impl/provider/RegistryInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 284
    .local v0, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v0}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_1

    move-object v4, v5

    .line 308
    :cond_0
    :goto_1
    return-object v4

    .line 284
    :cond_1
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Ljava/lang/String;

    .line 285
    .local v2, "uuid":Ljava/lang/String;
    iget-object v7, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v8, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v7, v2, v8}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v4

    .line 286
    .local v4, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v4, :cond_4

    .line 287
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v5

    const/4 v6, 0x1

    if-ne v5, v6, :cond_2

    move-object v3, v4

    .line 288
    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    .line 289
    .local v3, "vfile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    invoke-interface {v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 290
    sget-object v5, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v6, "updating file path."

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 291
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v6, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    invoke-interface {v3, v5, v6, v7}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->regenerateFilePath(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)V

    .line 292
    invoke-direct {p0, v3, v10}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;I)V

    goto :goto_1

    .line 294
    .end local v3    # "vfile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    :cond_2
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v5

    if-ne v5, v10, :cond_0

    move-object v3, v4

    .line 295
    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    .line 296
    .local v3, "vfile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    invoke-interface {v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v5

    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_3

    const-string v5, "/"

    invoke-interface {v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_0

    .line 297
    :cond_3
    sget-object v5, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v6, "updating file path hls."

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 298
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    iget-object v6, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    invoke-interface {v3, v5, v6, v7}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->regenerateFilePath(Landroid/content/ContentResolver;Ljava/lang/String;Landroid/content/Context;)V

    .line 299
    invoke-direct {p0, v3, v10}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;I)V

    goto :goto_1

    .line 305
    .end local v3    # "vfile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    :cond_4
    sget-object v7, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v8, Ljava/lang/StringBuilder;

    const-string v9, "item ["

    invoke-direct {v8, v9}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v8, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    const-string v9, "] not retrieved deleted from under us? moving to next"

    invoke-virtual {v8, v9}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v8

    invoke-static {v7, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0
.end method

.method private notifyListChanges(ZZLjava/lang/String;)V
    .locals 2
    .param p1, "queueChanged"    # Z
    .param p2, "downloadList"    # Z
    .param p3, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 697
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 698
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v0, v1, p3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 699
    if-eqz p1, :cond_0

    .line 700
    const-string v1, "virtuoso.intent.action.QUEUE_CHANGED"

    invoke-static {v1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 701
    :cond_0
    if-eqz p2, :cond_1

    .line 702
    const-string v1, "virtuoso.intent.action.DOWNLOAD_LIST_CHANGED"

    invoke-static {v1, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 703
    :cond_1
    return-void
.end method

.method private notifyQueueChanged(Ljava/lang/String;)V
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 706
    const/4 v0, 0x1

    const/4 v1, 0x0

    invoke-direct {p0, v0, v1, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->notifyListChanges(ZZLjava/lang/String;)V

    .line 707
    return-void
.end method

.method private performDownloadResume(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 1
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 735
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 736
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 737
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 738
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    .line 741
    :cond_0
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->performRetryErrorQueue(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 742
    return-void
.end method

.method private performRetryErrorQueue(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 0
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 746
    if-nez p1, :cond_0

    .line 751
    :goto_0
    return-void

    .line 748
    :cond_0
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->handleRetryErrorQueue(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 750
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->provideItemToClientDownloader(Lcom/penthera/virtuososdk/download/Downloader;)V

    goto :goto_0
.end method

.method private performRetryErrorQueue(Ljava/lang/String;)V
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 754
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->performRetryErrorQueue(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 755
    return-void
.end method

.method private provideItemToClientDownloader(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 3
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 253
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->downloadBundleForNextItem(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v0

    .line 254
    .local v0, "downloadBundle":Landroid/os/Bundle;
    if-eqz v0, :cond_0

    .line 255
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v2, "Providing new item to downloader"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 256
    invoke-virtual {p1, v0}, Lcom/penthera/virtuososdk/download/Downloader;->NewItem(Landroid/os/Bundle;)V

    .line 258
    :cond_0
    return-void
.end method

.method static requestDiskCheck(Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 4
    .param p0, "d"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 166
    new-instance v0, Landroid/os/Message;

    invoke-direct {v0}, Landroid/os/Message;-><init>()V

    .line 167
    .local v0, "msg":Landroid/os/Message;
    const/4 v1, 0x1

    iput v1, v0, Landroid/os/Message;->what:I

    .line 168
    iput-object p0, v0, Landroid/os/Message;->obj:Ljava/lang/Object;

    .line 169
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDiskCheckHandler:Landroid/os/Handler;

    const-wide/16 v2, 0x1388

    invoke-virtual {v1, v0, v2, v3}, Landroid/os/Handler;->sendMessageDelayed(Landroid/os/Message;J)Z

    .line 170
    return-void
.end method

.method private saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V
    .locals 1
    .param p1, "file"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    .prologue
    .line 775
    const/4 v0, 0x6

    invoke-direct {p0, p1, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;I)V

    .line 776
    return-void
.end method

.method private saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;I)V
    .locals 1
    .param p1, "file"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    .param p2, "flags"    # I

    .prologue
    .line 778
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-static {v0, p1, p2}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->saveFileState(Landroid/content/ContentResolver;Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;I)V

    .line 779
    return-void
.end method

.method private usedCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D
    .locals 4
    .param p1, "si"    # Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    .prologue
    .line 877
    const-string v1, "cell_quota_used"

    invoke-virtual {p1, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 878
    .local v0, "quotaUsed":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v1

    if-eqz v1, :cond_0

    .line 879
    const-wide/16 v2, 0x0

    .line 880
    :goto_0
    return-wide v2

    :cond_0
    invoke-static {v0}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    goto :goto_0
.end method


# virtual methods
.method public availableStorage(Ljava/lang/String;)D
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1135
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    .line 1137
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    .line 1138
    .local v0, "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 1139
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    .line 1141
    iget-wide v2, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    return-wide v2
.end method

.method calcDiskUsage(Ljava/lang/String;)D
    .locals 2
    .param p1, "authority"    # Ljava/lang/String;

    .prologue
    .line 931
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-static {v0, p1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->appDiskUsage(Landroid/content/ContentResolver;Ljava/lang/String;)D

    move-result-wide v0

    return-wide v0
.end method

.method public cellQuotaStart(Ljava/lang/String;)J
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 864
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v0

    .line 865
    .local v0, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    const-string v2, "cell_quota_start_date"

    invoke-virtual {v0, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v1

    .line 866
    .local v1, "str":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v2

    if-nez v2, :cond_0

    .line 867
    const-string v2, "cell_quota_start_date"

    invoke-virtual {v0, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->get(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v2

    invoke-static {v2}, Ljava/lang/Long;->parseLong(Ljava/lang/String;)J

    move-result-wide v2

    .line 869
    :goto_0
    return-wide v2

    :cond_0
    const-wide/16 v2, -0x1

    goto :goto_0
.end method

.method public cellularDataQuotaOK(Ljava/lang/String;)Z
    .locals 6
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    const/4 v1, 0x1

    .line 884
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v0

    .line 885
    .local v0, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellQuotaDisabled(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 889
    :cond_0
    :goto_0
    return v1

    :cond_1
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->availableCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v2

    const-wide/16 v4, 0x0

    cmpl-double v2, v2, v4

    if-gtz v2, :cond_0

    const/4 v1, 0x0

    goto :goto_0
.end method

.method public clearTestSettings(Ljava/lang/String;)V
    .locals 5
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1227
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 1228
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader;->clearTestSettings()V

    .line 1230
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v2

    .line 1231
    .local v2, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    new-instance v1, Landroid/os/Bundle;

    invoke-direct {v1}, Landroid/os/Bundle;-><init>()V

    .line 1232
    .local v1, "overrides":Landroid/os/Bundle;
    const-string v3, "headroom_override"

    const-string v4, "headroom_override"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1233
    const-string v3, "max_storage_override"

    const-string v4, "max_storage_override"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1234
    const-string v3, "cell_data_quota_override"

    const-string v4, "cell_data_quota_override"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1235
    const-string v3, "battery_threshold_override"

    const-string v4, "battery_threshold_override"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1236
    const-string v3, "destination_path_override"

    const-string v4, "destination_path_override"

    invoke-virtual {v1, v3, v4}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 1237
    invoke-virtual {v2, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->removeOverrideValues(Landroid/os/Bundle;)V

    .line 1238
    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->getBundle()Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v0, v3}, Lcom/penthera/virtuososdk/download/Downloader;->BatterySettingChanged(Landroid/os/Bundle;)V

    .line 1239
    return-void
.end method

.method public clientDeletedItem(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .param p2, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 233
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 234
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0, p2}, Lcom/penthera/virtuososdk/download/Downloader;->ItemRemoved(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 235
    return-void
.end method

.method public clientExpiredItem(Ljava/lang/String;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .param p2, "aItem"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 238
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 239
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0, p2}, Lcom/penthera/virtuososdk/download/Downloader;->ItemRemoved(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 240
    return-void
.end method

.method public clientQueueChange(Ljava/lang/String;)V
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 197
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 198
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->interruptClientDownloader(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 199
    return-void
.end method

.method public clientSettingChange(Ljava/lang/String;I)V
    .locals 3
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .param p2, "flags"    # I

    .prologue
    .line 202
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 203
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    and-int/lit16 v2, p2, 0x100

    if-lez v2, :cond_0

    .line 204
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 205
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-virtual {v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->getBundle()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/penthera/virtuososdk/download/Downloader;->BatterySettingChanged(Landroid/os/Bundle;)V

    .line 213
    .end local v1    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :goto_0
    return-void

    .line 212
    :cond_0
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->interruptClientDownloader(Lcom/penthera/virtuososdk/download/Downloader;)V

    goto :goto_0
.end method

.method public diskStatusOK()Z
    .locals 4

    .prologue
    .line 925
    invoke-static {}, Landroid/os/Environment;->getExternalStorageState()Ljava/lang/String;

    move-result-object v0

    .line 926
    .local v0, "storageState":Ljava/lang/String;
    sget-object v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v2, Ljava/lang/StringBuilder;

    const-string v3, "diskStatus is "

    invoke-direct {v2, v3}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v2, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 927
    const-string v1, "mounted"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v1

    return v1
.end method

.method doDownloadStart(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/os/Bundle;Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 5
    .param p1, "file"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "bundle"    # Landroid/os/Bundle;
    .param p3, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;
        }
    .end annotation

    .prologue
    .line 807
    invoke-direct {p0, p3, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->handleFileStart(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)Z

    move-result v1

    .line 809
    .local v1, "queue_changed":Z
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v3

    iget-object v4, p3, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v2, v3, v4}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 810
    .local v0, "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    const-string v2, "download_update_data"

    invoke-virtual {p2, v2, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 811
    const-string v2, "com.penthera.virtuososdk.client.pckg"

    iget-object v3, p3, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {p2, v2, v3}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 812
    const-string v2, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    invoke-static {v2, p2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 813
    if-eqz v1, :cond_0

    .line 814
    iget-object v2, p3, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->notifyQueueChanged(Ljava/lang/String;)V

    .line 815
    :cond_0
    return-void
.end method

.method doDownloadUpdate(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ZLandroid/os/Bundle;Lcom/penthera/virtuososdk/download/Downloader;)V
    .locals 4
    .param p1, "file"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .param p2, "isComplete"    # Z
    .param p3, "bundle"    # Landroid/os/Bundle;
    .param p4, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 789
    if-eqz p2, :cond_1

    .line 791
    invoke-direct {p0, p4, p1, p3}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->handleFileComplete(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/os/Bundle;)V

    .line 804
    :cond_0
    :goto_0
    return-void

    :cond_1
    move-object v1, p1

    .line 794
    check-cast v1, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V

    .line 795
    iget-object v1, p4, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v1, v1, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v2, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v1, v2, :cond_0

    .line 797
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v2

    iget-object v3, p4, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v1, v2, v3}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v0

    .line 798
    .local v0, "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v0, :cond_0

    move-object v1, v0

    check-cast v1, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-interface {v1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->getContentState()I

    move-result v1

    if-nez v1, :cond_0

    .line 799
    const-string v1, "download_update_data"

    invoke-virtual {p3, v1, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 800
    const-string v1, "com.penthera.virtuososdk.client.pckg"

    iget-object v2, p4, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {p3, v1, v2}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 801
    const-string v1, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    invoke-static {v1, p3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method doGetRetryErrorsTask(Ljava/lang/String;)Ljava/util/TimerTask;
    .locals 1
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 723
    new-instance v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$2;

    invoke-direct {v0, p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$2;-><init>(Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;Ljava/lang/String;)V

    return-object v0
.end method

.method doRemoveFileFromDisk(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    .locals 2
    .param p1, "vfile"    # Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .prologue
    .line 714
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_1

    .line 715
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    check-cast p1, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    .end local p1    # "vfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/manager/FileManager;->remove(Ljava/lang/String;)V

    .line 719
    :cond_0
    :goto_0
    return-void

    .line 716
    .restart local p1    # "vfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_1
    invoke-interface {p1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->type()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_0

    .line 717
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iFileManager:Lcom/penthera/virtuososdk/manager/FileManager;

    check-cast p1, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    .end local p1    # "vfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->localBaseDir()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/manager/FileManager;->remove(Ljava/lang/String;)V

    goto :goto_0
.end method

.method public downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 34
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "aType"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .param p3, "aParcel"    # Landroid/os/Parcelable;

    .prologue
    .line 399
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[I

    move-result-object v29

    invoke-virtual/range {p2 .. p2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v30

    aget v29, v29, v30

    packed-switch v29, :pswitch_data_0

    .line 686
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v30, Ljava/lang/StringBuilder;

    const-string v31, "unhandled download callback type "

    invoke-direct/range {v30 .. v31}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v30

    move-object/from16 v1, p2

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    move-object/from16 v5, p3

    .line 687
    check-cast v5, Landroid/os/Bundle;

    .line 688
    .local v5, "bundle":Landroid/os/Bundle;
    const-string v29, "com.penthera.virtuososdk.client.pckg"

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v5, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 689
    const-string v29, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    move-object/from16 v0, v29

    invoke-static {v0, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 693
    .end local v5    # "bundle":Landroid/os/Bundle;
    :cond_0
    :goto_0
    :pswitch_0
    return-void

    .line 401
    :pswitch_1
    const/16 v21, 0x0

    .local v21, "qChange":Z
    move-object/from16 v5, p3

    .line 402
    check-cast v5, Landroid/os/Bundle;

    .line 403
    .restart local v5    # "bundle":Landroid/os/Bundle;
    const-string v29, "download_update_data"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v18

    .local v18, "p":Landroid/os/Parcelable;
    move-object/from16 v26, v18

    .line 404
    check-cast v26, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    .line 405
    .local v26, "status":Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v30, Ljava/lang/StringBuilder;

    const-string v31, "Got status "

    invoke-direct/range {v30 .. v31}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 406
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus()[I

    move-result-object v29

    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v30

    aget v29, v29, v30

    packed-switch v29, :pswitch_data_1

    .line 500
    :cond_1
    :goto_1
    :pswitch_2
    const-string v29, "com.penthera.virtuososdk.client.pckg"

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v5, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 501
    const-string v29, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    move-object/from16 v0, v29

    invoke-static {v0, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 502
    if-eqz v21, :cond_2

    const/16 v29, 0x1

    const/16 v30, 0x0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v31, v0

    move-object/from16 v0, p0

    move/from16 v1, v29

    move/from16 v2, v30

    move-object/from16 v3, v31

    invoke-direct {v0, v1, v2, v3}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->notifyListChanges(ZZLjava/lang/String;)V

    .line 504
    :cond_2
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EVirtuosoDownloadEngineStatus()[I

    move-result-object v29

    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v30

    aget v29, v29, v30

    packed-switch v29, :pswitch_data_2

    goto :goto_0

    .line 510
    :pswitch_3
    new-instance v14, Landroid/os/Bundle;

    invoke-direct {v14}, Landroid/os/Bundle;-><init>()V

    .line 511
    .local v14, "notificationBundle":Landroid/os/Bundle;
    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->extras()Landroid/os/Bundle;

    move-result-object v27

    .line 512
    .local v27, "statusExtras":Landroid/os/Bundle;
    const/16 v23, 0x0

    .line 513
    .local v23, "qname":Ljava/lang/String;
    const-string v12, ""

    .line 514
    .local v12, "fu":Ljava/lang/String;
    if-eqz v27, :cond_4

    .line 515
    const-string v29, "virtuoso_file"

    move-object/from16 v0, v27

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v10

    check-cast v10, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 516
    .local v10, "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v10, :cond_3

    .line 517
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v12

    .line 518
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v23

    .line 519
    const-string v29, "notification_file"

    move-object/from16 v0, v29

    invoke-virtual {v14, v0, v10}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 522
    :cond_3
    const-string v29, "notification_engine_status_info_ordinal"

    const-string v30, "failure_reason"

    move-object/from16 v0, v27

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v30

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-virtual {v14, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 524
    .end local v10    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_4
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v25

    .line 525
    .local v25, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v20

    .line 526
    .local v20, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v7

    .line 527
    .local v7, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface/range {v20 .. v20}, Ljava/util/List;->size()I

    move-result v29

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v30

    add-int v28, v29, v30

    .line 528
    .local v28, "value":I
    const-string v29, "notification_num_queued_files"

    move-object/from16 v0, v29

    move/from16 v1, v28

    invoke-virtual {v14, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 529
    const-string v29, "notification_engine_status_ordinal"

    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v30

    move-object/from16 v0, v29

    move/from16 v1, v30

    invoke-virtual {v14, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 531
    const-string v13, ".NOTIFICATION_DOWNLOAD_STOPPED"

    .line 532
    .local v13, "notification":Ljava/lang/String;
    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v29

    sget-object v30, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    if-ne v0, v1, :cond_5

    .line 533
    const-string v13, ".NOTIFICATION_DOWNLOADS_PAUSED"

    .line 535
    :cond_5
    const-string v29, "NOTIFICATION SEND"

    new-instance v30, Ljava/lang/StringBuilder;

    const-string v31, "notification: ["

    invoke-direct/range {v30 .. v31}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v31, v0

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, "] for file ["

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    move-object/from16 v0, v30

    invoke-virtual {v0, v12}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, "]"

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 536
    new-instance v29, Ljava/lang/StringBuilder;

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v30 .. v30}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v30

    invoke-direct/range {v29 .. v30}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v29

    invoke-virtual {v0, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-static {v0, v14}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 408
    .end local v7    # "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v12    # "fu":Ljava/lang/String;
    .end local v13    # "notification":Ljava/lang/String;
    .end local v14    # "notificationBundle":Landroid/os/Bundle;
    .end local v20    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v23    # "qname":Ljava/lang/String;
    .end local v25    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    .end local v27    # "statusExtras":Landroid/os/Bundle;
    .end local v28    # "value":I
    :pswitch_4
    invoke-direct/range {p0 .. p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->provideItemToClientDownloader(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 410
    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->extras()Landroid/os/Bundle;

    move-result-object v29

    const-string v30, "forceIdleOnNewItemAfterDeleteDuringIdle"

    invoke-virtual/range {v29 .. v30}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;)Z

    move-result v29

    if-eqz v29, :cond_1

    .line 411
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "Got EXTRA_DELETION_DURING_IDLE_FORCED_NEW_IDLE"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 419
    :pswitch_5
    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->extras()Landroid/os/Bundle;

    move-result-object v27

    .line 420
    .restart local v27    # "statusExtras":Landroid/os/Bundle;
    if-eqz v27, :cond_7

    .line 421
    const-string v29, "failure_reason"

    move-object/from16 v0, v27

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v17

    .line 422
    .local v17, "ordinal":I
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->values()[Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v29

    aget-object v11, v29, v17

    .line 423
    .local v11, "filestate":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    sget-object v29, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-object/from16 v0, v29

    if-eq v11, v0, :cond_6

    sget-object v29, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-object/from16 v0, v29

    if-ne v11, v0, :cond_7

    .line 424
    :cond_6
    invoke-static/range {p1 .. p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->requestDiskCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 431
    .end local v11    # "filestate":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .end local v17    # "ordinal":I
    .end local v27    # "statusExtras":Landroid/os/Bundle;
    :cond_7
    :pswitch_6
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "Got error status"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 432
    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->extras()Landroid/os/Bundle;

    move-result-object v4

    .line 433
    .local v4, "b":Landroid/os/Bundle;
    const-string v29, "virtuoso_file"

    move-object/from16 v0, v29

    invoke-virtual {v4, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v19

    .local v19, "q":Landroid/os/Parcelable;
    move-object/from16 v10, v19

    .line 434
    check-cast v10, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 436
    .local v10, "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    if-nez v10, :cond_8

    .line 437
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "Null File sent when reporting update"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 439
    :cond_8
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v8

    .line 441
    .local v8, "err":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus()[I

    move-result-object v29

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v30

    aget v29, v29, v30

    packed-switch v29, :pswitch_data_3

    .line 470
    :cond_9
    :goto_2
    :pswitch_7
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    move-object/from16 v29, v0

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v31, v0

    invoke-static/range {v29 .. v31}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v6

    .line 471
    .local v6, "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v6, :cond_b

    .line 473
    sget-object v29, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v30

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    if-ne v0, v1, :cond_d

    .line 475
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-direct {v0, v1, v10}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->handleFileErrored(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 477
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    move-object/from16 v29, v0

    if-eqz v29, :cond_a

    .line 478
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Ljava/util/Timer;->cancel()V

    .line 479
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    move-object/from16 v29, v0

    invoke-virtual/range {v29 .. v29}, Ljava/util/Timer;->purge()I

    .line 482
    :cond_a
    new-instance v29, Ljava/util/Timer;

    const-string v30, "RetryErrorDownloads"

    invoke-direct/range {v29 .. v30}, Ljava/util/Timer;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v29

    move-object/from16 v1, p0

    iput-object v0, v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    .line 483
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    move-object/from16 v29, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doGetRetryErrorsTask(Ljava/lang/String;)Ljava/util/TimerTask;

    move-result-object v30

    const-wide/32 v32, 0x36ee80

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    move-wide/from16 v2, v32

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 490
    :cond_b
    :goto_3
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    move-object/from16 v29, v0

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v31, v0

    invoke-static/range {v29 .. v31}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v6

    .line 492
    invoke-virtual/range {v26 .. v26}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->extras()Landroid/os/Bundle;

    move-result-object v29

    const-string v30, "virtuoso_file"

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-virtual {v0, v1, v6}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 494
    const-string v29, "download_update_data"

    move-object/from16 v0, v29

    move-object/from16 v1, v26

    invoke-virtual {v5, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 495
    const/16 v21, 0x1

    goto/16 :goto_1

    .line 444
    .end local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :pswitch_8
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v30

    const-wide/16 v32, 0x0

    cmpg-double v29, v30, v32

    if-gtz v29, :cond_9

    .line 447
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "***** Resetting file path"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 448
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v29

    const/16 v30, 0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_c

    move-object/from16 v29, v10

    .line 449
    check-cast v29, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    const-string v30, ""

    invoke-interface/range {v29 .. v30}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setFilePath(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 451
    :cond_c
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v29

    const/16 v30, 0x4

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_9

    move-object/from16 v29, v10

    .line 452
    check-cast v29, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    const-string v30, ""

    invoke-interface/range {v29 .. v30}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setLocalBaseDir(Ljava/lang/String;)V

    goto/16 :goto_2

    .line 461
    :pswitch_9
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doRemoveFileFromDisk(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 462
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v29

    const/16 v30, 0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_9

    move-object/from16 v29, v10

    .line 463
    check-cast v29, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    const-wide/16 v30, 0x0

    invoke-interface/range {v29 .. v31}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setCurrentSize(D)V

    move-object/from16 v29, v10

    .line 464
    check-cast v29, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    new-instance v30, Lcom/penthera/virtuososdk/download/MD5State;

    invoke-direct/range {v30 .. v30}, Lcom/penthera/virtuososdk/download/MD5State;-><init>()V

    invoke-interface/range {v29 .. v30}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    goto/16 :goto_2

    .restart local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_d
    move-object/from16 v29, v10

    .line 486
    check-cast v29, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V

    goto/16 :goto_3

    .end local v4    # "b":Landroid/os/Bundle;
    .end local v5    # "bundle":Landroid/os/Bundle;
    .end local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v8    # "err":Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    .end local v10    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v18    # "p":Landroid/os/Parcelable;
    .end local v19    # "q":Landroid/os/Parcelable;
    .end local v21    # "qChange":Z
    .end local v26    # "status":Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;
    :pswitch_a
    move-object/from16 v5, p3

    .line 547
    check-cast v5, Landroid/os/Bundle;

    .line 548
    .restart local v5    # "bundle":Landroid/os/Bundle;
    const-string v29, "download_update_data"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v18

    .restart local v18    # "p":Landroid/os/Parcelable;
    move-object/from16 v10, v18

    .line 549
    check-cast v10, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 551
    .local v10, "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :try_start_0
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    move-object/from16 v29, v0

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v31, v0

    invoke-static/range {v29 .. v31}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v6

    .line 552
    .restart local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v6, :cond_e

    .line 553
    move-object/from16 v0, p0

    move-object/from16 v1, p1

    invoke-virtual {v0, v10, v5, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doDownloadStart(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/os/Bundle;Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 555
    :cond_e
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v25

    .line 556
    .restart local v25    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v23

    .line 557
    .restart local v23    # "qname":Ljava/lang/String;
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v20

    .line 558
    .restart local v20    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v7

    .line 559
    .restart local v7    # "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface/range {v20 .. v20}, Ljava/util/List;->size()I

    move-result v29

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v30

    add-int v28, v29, v30

    .line 560
    .restart local v28    # "value":I
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 561
    .restart local v4    # "b":Landroid/os/Bundle;
    const-string v29, "notification_file"

    move-object/from16 v0, v29

    move-object/from16 v1, v18

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 562
    const-string v29, "notification_num_queued_files"

    move-object/from16 v0, v29

    move/from16 v1, v28

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 563
    new-instance v29, Ljava/lang/StringBuilder;

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v30 .. v30}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v30

    invoke-direct/range {v29 .. v30}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v30, ".NOTIFICATION_DOWNLOAD_START"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-static {v0, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V
    :try_end_0
    .catch Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException; {:try_start_0 .. :try_end_0} :catch_0

    goto/16 :goto_0

    .line 564
    .end local v4    # "b":Landroid/os/Bundle;
    .end local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v7    # "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v20    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v23    # "qname":Ljava/lang/String;
    .end local v25    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    .end local v28    # "value":I
    :catch_0
    move-exception v22

    .line 565
    .local v22, "qe":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v30, Ljava/lang/StringBuilder;

    const-string v31, "QueueException for "

    invoke-direct/range {v30 .. v31}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v22 .. v22}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;->getMessage()Ljava/lang/String;

    move-result-object v31

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    const-string v31, " on start"

    invoke-virtual/range {v30 .. v31}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v30

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .end local v5    # "bundle":Landroid/os/Bundle;
    .end local v10    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v18    # "p":Landroid/os/Parcelable;
    .end local v22    # "qe":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$QueueException;
    :pswitch_b
    move-object/from16 v5, p3

    .line 571
    check-cast v5, Landroid/os/Bundle;

    .line 572
    .restart local v5    # "bundle":Landroid/os/Bundle;
    const-string v29, "download_update_data"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v18

    .restart local v18    # "p":Landroid/os/Parcelable;
    move-object/from16 v10, v18

    .line 573
    check-cast v10, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 574
    .restart local v10    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    move-object/from16 v29, v0

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->uuid()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v31, v0

    invoke-static/range {v29 .. v31}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v6

    .line 575
    .restart local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v6, :cond_f

    .line 576
    const/16 v29, 0x0

    move-object/from16 v0, p0

    move/from16 v1, v29

    move-object/from16 v2, p1

    invoke-virtual {v0, v10, v1, v5, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doDownloadUpdate(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ZLandroid/os/Bundle;Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 579
    :cond_f
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    move-object/from16 v29, v0

    move-object/from16 v0, v29

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v29, v0

    sget-object v30, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    if-eq v0, v1, :cond_0

    .line 580
    if-eqz v6, :cond_0

    check-cast v6, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    .end local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    invoke-interface {v6}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->getContentState()I

    move-result v29

    if-nez v29, :cond_0

    .line 581
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move-object/from16 v1, v29

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v25

    .line 582
    .restart local v25    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v23

    .line 583
    .restart local v23    # "qname":Ljava/lang/String;
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v20

    .line 584
    .restart local v20    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    move-object/from16 v0, v25

    move-object/from16 v1, v23

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v7

    .line 585
    .restart local v7    # "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface/range {v20 .. v20}, Ljava/util/List;->size()I

    move-result v29

    invoke-interface {v7}, Ljava/util/List;->size()I

    move-result v30

    add-int v28, v29, v30

    .line 586
    .restart local v28    # "value":I
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 587
    .restart local v4    # "b":Landroid/os/Bundle;
    const-string v29, "notification_file"

    move-object/from16 v0, v29

    move-object/from16 v1, v18

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 588
    const-string v29, "notification_num_queued_files"

    move-object/from16 v0, v29

    move/from16 v1, v28

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 589
    new-instance v29, Ljava/lang/StringBuilder;

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v30 .. v30}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v30

    invoke-direct/range {v29 .. v30}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v30, ".NOTIFICATION_DOWNLOAD_UPDATE"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-static {v0, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .end local v4    # "b":Landroid/os/Bundle;
    .end local v5    # "bundle":Landroid/os/Bundle;
    .end local v7    # "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v10    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v18    # "p":Landroid/os/Parcelable;
    .end local v20    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v23    # "qname":Ljava/lang/String;
    .end local v25    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    .end local v28    # "value":I
    :pswitch_c
    move-object/from16 v5, p3

    .line 596
    check-cast v5, Landroid/os/Bundle;

    .line 597
    .restart local v5    # "bundle":Landroid/os/Bundle;
    const-string v29, "download_update_data"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v18

    .restart local v18    # "p":Landroid/os/Parcelable;
    move-object/from16 v10, v18

    .line 598
    check-cast v10, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 600
    .local v10, "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    move-object/from16 v29, v0

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v30

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v31, v0

    invoke-static/range {v29 .. v31}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v6

    .line 602
    .restart local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v6, :cond_0

    .line 603
    invoke-interface {v6}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v29

    sget-object v30, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    if-ne v0, v1, :cond_11

    move-object/from16 v29, v10

    .line 606
    check-cast v29, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    sget-object v30, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface/range {v29 .. v30}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 607
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v29

    const/16 v30, 0x1

    move/from16 v0, v29

    move/from16 v1, v30

    if-ne v0, v1, :cond_10

    move-object/from16 v29, v10

    .line 608
    check-cast v29, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    const-wide/16 v30, 0x0

    invoke-interface/range {v29 .. v31}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setCurrentSize(D)V

    .line 610
    :cond_10
    move-object/from16 v0, p0

    invoke-virtual {v0, v10}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doRemoveFileFromDisk(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 612
    :cond_11
    const/16 v29, 0x1

    move-object/from16 v0, p0

    move/from16 v1, v29

    move-object/from16 v2, p1

    invoke-virtual {v0, v10, v1, v5, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doDownloadUpdate(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;ZLandroid/os/Bundle;Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 615
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 616
    .restart local v4    # "b":Landroid/os/Bundle;
    const-string v29, "notification_file"

    move-object/from16 v0, v29

    move-object/from16 v1, v18

    invoke-virtual {v4, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 617
    new-instance v29, Ljava/lang/StringBuilder;

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    invoke-static/range {v30 .. v30}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v30

    invoke-direct/range {v29 .. v30}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v30, ".NOTIFICATION_DOWNLOAD_COMPLETE"

    invoke-virtual/range {v29 .. v30}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v29

    invoke-virtual/range {v29 .. v29}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v29

    move-object/from16 v0, v29

    invoke-static {v0, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .end local v4    # "b":Landroid/os/Bundle;
    .end local v5    # "bundle":Landroid/os/Bundle;
    .end local v6    # "dbfile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v10    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    .end local v18    # "p":Landroid/os/Parcelable;
    :pswitch_d
    move-object/from16 v5, p3

    .line 624
    check-cast v5, Landroid/os/Bundle;

    .line 625
    .restart local v5    # "bundle":Landroid/os/Bundle;
    const-string v29, "virtuoso_file"

    move-object/from16 v0, v29

    invoke-virtual {v5, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v9

    check-cast v9, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .line 626
    .local v9, "f":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    const/4 v15, 0x0

    .line 627
    .local v15, "notifyDownloadListChanged":Z
    const/16 v16, 0x0

    .line 628
    .local v16, "notifyDownloadQueueChanged":Z
    const/16 v24, 0x1

    .line 629
    .local v24, "removeFromDb":Z
    if-nez v9, :cond_12

    .line 630
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "ILLEGAL STATE: EItemDownloadRemoved called with no file as extra data!!"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 633
    :cond_12
    invoke-static {}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->$SWITCH_TABLE$com$penthera$virtuososdk$Common$EFileDownloadStatus()[I

    move-result-object v29

    invoke-interface {v9}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v30

    invoke-virtual/range {v30 .. v30}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v30

    aget v29, v29, v30

    packed-switch v29, :pswitch_data_4

    .line 659
    :pswitch_e
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "ILLEGAL STATE: unhandled file error condition."

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_0

    .line 635
    :pswitch_f
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "Download Completed removing file on disk"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 636
    const/4 v15, 0x1

    .line 663
    :goto_4
    if-eqz v24, :cond_13

    .line 664
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    move-object/from16 v29, v0

    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v30, v0

    move-object/from16 v0, v29

    move-object/from16 v1, v30

    invoke-static {v9, v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->remove(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;Landroid/content/Context;Ljava/lang/String;)V

    .line 665
    :cond_13
    move-object/from16 v0, p0

    invoke-virtual {v0, v9}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doRemoveFileFromDisk(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    .line 667
    move-object/from16 v0, p1

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v29, v0

    move-object/from16 v0, p0

    move/from16 v1, v16

    move-object/from16 v2, v29

    invoke-direct {v0, v1, v15, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->notifyListChanges(ZZLjava/lang/String;)V

    goto/16 :goto_0

    .line 644
    :pswitch_10
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "Download Completed with error removing file as requested"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 645
    const/16 v16, 0x1

    .line 646
    goto :goto_4

    .line 649
    :pswitch_11
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "no error on file removing it from disk"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 650
    const/16 v16, 0x1

    .line 651
    goto :goto_4

    .line 653
    :pswitch_12
    sget-object v29, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v30, "expired file removing it only from disk"

    invoke-static/range {v29 .. v30}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 654
    const/4 v15, 0x1

    .line 655
    const/16 v16, 0x1

    .line 656
    const/16 v24, 0x0

    .line 657
    goto :goto_4

    .line 399
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_a
        :pswitch_b
        :pswitch_c
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_d
    .end packed-switch

    .line 406
    :pswitch_data_1
    .packed-switch 0x2
        :pswitch_4
        :pswitch_2
        :pswitch_2
        :pswitch_5
        :pswitch_6
    .end packed-switch

    .line 504
    :pswitch_data_2
    .packed-switch 0x2
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
        :pswitch_3
    .end packed-switch

    .line 441
    :pswitch_data_3
    .packed-switch 0x6
        :pswitch_8
        :pswitch_7
        :pswitch_7
        :pswitch_9
    .end packed-switch

    .line 633
    :pswitch_data_4
    .packed-switch 0x2
        :pswitch_11
        :pswitch_11
        :pswitch_10
        :pswitch_10
        :pswitch_10
        :pswitch_10
        :pswitch_10
        :pswitch_10
        :pswitch_e
        :pswitch_f
        :pswitch_12
    .end packed-switch
.end method

.method public fragmentsComplete(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
    .locals 2
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 833
    iget-object v0, p1, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v1, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v0, v1, :cond_0

    .line 836
    :goto_0
    return-void

    .line 834
    :cond_0
    const-string v0, "com.penthera.virtuososdk.client.pckg"

    iget-object v1, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {p2, v0, v1}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 835
    const-string v0, "virtuoso.intent.action.INTENT_FRAGMENT_COMPLETE_CALLBACK"

    invoke-static {v0, p2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public fullPendingQueueSize(Ljava/lang/String;)I
    .locals 6
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    const/4 v4, 0x0

    .line 1161
    const/4 v3, 0x0

    .line 1162
    .local v3, "value":I
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v2

    .line 1163
    .local v2, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    if-eqz v2, :cond_0

    .line 1164
    invoke-virtual {v2, v4}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v1

    .line 1165
    .local v1, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v2, v4}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v0

    .line 1166
    .local v0, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->size()I

    move-result v4

    invoke-interface {v0}, Ljava/util/List;->size()I

    move-result v5

    add-int v3, v4, v5

    .line 1168
    .end local v0    # "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    .end local v1    # "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    :cond_0
    return v3
.end method

.method public getAllowedCellQuota(Lcom/penthera/virtuososdk/download/Downloader;)D
    .locals 4
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 1270
    if-eqz p1, :cond_1

    .line 1271
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    iget-object v3, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    .line 1272
    .local v0, "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    iget-object v2, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 1273
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    .line 1274
    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellQuotaDisabled(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)Z

    move-result v2

    if-eqz v2, :cond_0

    iget-wide v2, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    .line 1276
    .end local v0    # "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    .end local v1    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :goto_0
    return-wide v2

    .line 1274
    .restart local v0    # "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    .restart local v1    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :cond_0
    invoke-direct {p0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->availableCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v2

    goto :goto_0

    .line 1276
    .end local v0    # "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    .end local v1    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :cond_1
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method public getAllowedStorageQuota(Lcom/penthera/virtuososdk/download/Downloader;)D
    .locals 4
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;

    .prologue
    .line 1258
    if-eqz p1, :cond_0

    .line 1259
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    iget-object v3, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v2, v3}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    .line 1260
    .local v0, "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    iget-object v2, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 1261
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    .line 1262
    iget-wide v2, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iAvailable:D

    .line 1265
    .end local v0    # "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    .end local v1    # "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    :goto_0
    return-wide v2

    :cond_0
    const-wide/16 v2, 0x0

    goto :goto_0
.end method

.method public getCurrentThroughput(Ljava/lang/String;)D
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1247
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 1248
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    iget-object v1, v0, Lcom/penthera/virtuososdk/download/Downloader;->currentThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->mbs()D

    move-result-wide v2

    return-wide v2
.end method

.method public getOverallThroughput(Ljava/lang/String;)D
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1252
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 1253
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    iget-object v1, v0, Lcom/penthera/virtuososdk/download/Downloader;->overallThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->mbs()D

    move-result-wide v2

    return-wide v2
.end method

.method public hdsProgressUpdate(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
    .locals 12
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 840
    const-string v9, "virtuoso_file"

    invoke-virtual {p2, v9}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v3

    check-cast v3, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    .line 841
    .local v3, "f":Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    iget-object v9, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iResolver:Landroid/content/ContentResolver;

    invoke-interface {v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->uuid()Ljava/lang/String;

    move-result-object v10

    iget-object v11, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v9, v10, v11}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v1

    .line 842
    .local v1, "dbFile":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v1, :cond_0

    .line 843
    const/4 v9, 0x4

    invoke-direct {p0, v3, v9}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;I)V

    .line 844
    iget-object v9, p1, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v9, v9, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v10, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v9, v10, :cond_1

    .line 861
    :cond_0
    :goto_0
    return-void

    .line 845
    :cond_1
    new-instance v4, Landroid/os/Bundle;

    invoke-direct {v4}, Landroid/os/Bundle;-><init>()V

    .line 846
    .local v4, "p_extras":Landroid/os/Bundle;
    const-string v9, "com.penthera.virtuososdk.client.pckg"

    iget-object v10, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v9, v10}, Landroid/os/Bundle;->putString(Ljava/lang/String;Ljava/lang/String;)V

    .line 847
    const-string v9, "download_update_type"

    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EProgressUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-virtual {v10}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v10

    invoke-virtual {v4, v9, v10}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 848
    const-string v9, "download_update_data"

    invoke-virtual {v4, v9, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 849
    const-string v9, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    invoke-static {v9, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    .line 851
    iget-object v9, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {p0, v9}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v7

    .line 852
    .local v7, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-interface {v1}, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;->parentUuid()Ljava/lang/String;

    move-result-object v6

    .line 853
    .local v6, "qname":Ljava/lang/String;
    invoke-virtual {v7, v6}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->pendingQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v5

    .line 854
    .local v5, "q":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-virtual {v7, v6}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->errorQueue(Ljava/lang/String;)Ljava/util/List;

    move-result-object v2

    .line 855
    .local v2, "eq":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v5}, Ljava/util/List;->size()I

    move-result v9

    invoke-interface {v2}, Ljava/util/List;->size()I

    move-result v10

    add-int v8, v9, v10

    .line 856
    .local v8, "value":I
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 857
    .local v0, "b":Landroid/os/Bundle;
    const-string v9, "notification_file"

    invoke-virtual {v0, v9, v3}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 858
    const-string v9, "notification_num_queued_files"

    invoke-virtual {v0, v9, v8}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 859
    new-instance v9, Ljava/lang/StringBuilder;

    iget-object v10, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v10}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v10

    invoke-direct {v9, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v10, ".NOTIFICATION_DOWNLOAD_UPDATE"

    invoke-virtual {v9, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v9, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method public initClient(Ljava/lang/String;)V
    .locals 0
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 158
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    .line 159
    return-void
.end method

.method initClients()V
    .locals 4

    .prologue
    .line 147
    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v2}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    .line 148
    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v2}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientSettings:Ljava/util/concurrent/ConcurrentHashMap;

    .line 149
    new-instance v2, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v2}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    sput-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    .line 151
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iProvidersInstance:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    invoke-virtual {v2}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->getProviders()Ljava/util/List;

    move-result-object v1

    .line 152
    .local v1, "providers":Ljava/util/List;, "Ljava/util/List<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 155
    return-void

    .line 152
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 153
    .local v0, "p":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    goto :goto_0
.end method

.method public isOkay(Z)V
    .locals 4
    .param p1, "isOkay"    # Z

    .prologue
    .line 1059
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v1, "received is okay from monitor ["

    invoke-direct {v3, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    if-eqz p1, :cond_1

    const-string v1, "true]"

    :goto_0
    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v2, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1060
    if-eqz p1, :cond_0

    .line 1061
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    const-string v2, "connectivity"

    invoke-virtual {v1, v2}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 1062
    .local v0, "cm":Landroid/net/ConnectivityManager;
    if-nez v0, :cond_2

    .line 1065
    .end local v0    # "cm":Landroid/net/ConnectivityManager;
    :cond_0
    :goto_1
    return-void

    .line 1059
    :cond_1
    const-string v1, "false]"

    goto :goto_0

    .line 1063
    .restart local v0    # "cm":Landroid/net/ConnectivityManager;
    :cond_2
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    invoke-virtual {p0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->onConnectivityChange(Landroid/net/NetworkInfo;)V

    goto :goto_1
.end method

.method public networkStatusOK(Ljava/lang/String;Z)Z
    .locals 5
    .param p1, "aClientAuth"    # Ljava/lang/String;
    .param p2, "cellularDataQuotaOK"    # Z

    .prologue
    const/4 v2, 0x0

    .line 1122
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iContext:Landroid/content/Context;

    const-string v4, "connectivity"

    invoke-virtual {v3, v4}, Landroid/content/Context;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Landroid/net/ConnectivityManager;

    .line 1123
    .local v0, "cm":Landroid/net/ConnectivityManager;
    invoke-virtual {v0}, Landroid/net/ConnectivityManager;->getActiveNetworkInfo()Landroid/net/NetworkInfo;

    move-result-object v1

    .line 1124
    .local v1, "info":Landroid/net/NetworkInfo;
    if-eqz v1, :cond_0

    .line 1125
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->getType()I

    move-result v3

    if-nez v3, :cond_1

    if-nez p2, :cond_1

    .line 1130
    :cond_0
    :goto_0
    return v2

    .line 1128
    :cond_1
    invoke-virtual {v1}, Landroid/net/NetworkInfo;->isAvailable()Z

    move-result v2

    goto :goto_0
.end method

.method public onBatteryLevelChanged(I)V
    .locals 6
    .param p1, "level"    # I

    .prologue
    .line 1102
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    .line 1103
    .local v0, "clients":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/penthera/virtuososdk/download/Downloader;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 1108
    return-void

    .line 1103
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/download/Downloader;

    .line 1104
    .local v1, "d":Lcom/penthera/virtuososdk/download/Downloader;
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sending onBatteryLevelChanged to "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, v1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1105
    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/Downloader;->onBatteryLevelChanged(I)V

    goto :goto_0
.end method

.method public onConnectivityChange(Landroid/net/NetworkInfo;)V
    .locals 6
    .param p1, "aActiveNetworkInfo"    # Landroid/net/NetworkInfo;

    .prologue
    .line 1070
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    .line 1071
    .local v0, "clients":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/penthera/virtuososdk/download/Downloader;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 1075
    return-void

    .line 1071
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/download/Downloader;

    .line 1072
    .local v1, "d":Lcom/penthera/virtuososdk/download/Downloader;
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sending onConnectivityChange to "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, v1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1073
    invoke-virtual {v1, p1}, Lcom/penthera/virtuososdk/download/Downloader;->onConnectivityChange(Landroid/net/NetworkInfo;)V

    goto :goto_0
.end method

.method public onPowerConnected()V
    .locals 6

    .prologue
    .line 1080
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    .line 1081
    .local v0, "clients":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/penthera/virtuososdk/download/Downloader;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 1086
    return-void

    .line 1081
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/download/Downloader;

    .line 1082
    .local v1, "d":Lcom/penthera/virtuososdk/download/Downloader;
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sending onPowerConnected to "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, v1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1083
    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader;->onPowerConnected()V

    goto :goto_0
.end method

.method public onPowerDisconnected()V
    .locals 6

    .prologue
    .line 1091
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClients:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2}, Ljava/util/concurrent/ConcurrentHashMap;->values()Ljava/util/Collection;

    move-result-object v0

    .line 1092
    .local v0, "clients":Ljava/util/Collection;, "Ljava/util/Collection<Lcom/penthera/virtuososdk/download/Downloader;>;"
    invoke-interface {v0}, Ljava/util/Collection;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_0

    .line 1097
    return-void

    .line 1092
    :cond_0
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/download/Downloader;

    .line 1093
    .local v1, "d":Lcom/penthera/virtuososdk/download/Downloader;
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "sending onPowerDisconnected to "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, v1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1094
    invoke-virtual {v1}, Lcom/penthera/virtuososdk/download/Downloader;->onPowerDisconnected()V

    goto :goto_0
.end method

.method public pauseClient(Ljava/lang/String;)V
    .locals 5
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 216
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 217
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader;->Pause()V

    .line 218
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 219
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    const-string v2, "downloader_init_state"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 221
    return-void
.end method

.method public powerStatusOK(Ljava/lang/String;)Z
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1116
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 1117
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader;->powerStatusOK()Z

    move-result v1

    return v1
.end method

.method public quotaUpdate(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
    .locals 10
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "bundle"    # Landroid/os/Bundle;

    .prologue
    const/4 v8, 0x0

    .line 819
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->LOG_TAG:Ljava/lang/String;

    const-string v6, "QuotaUpdate Callback"

    invoke-static {v3, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 820
    if-nez p2, :cond_1

    .line 829
    :cond_0
    :goto_0
    return-void

    .line 821
    :cond_1
    invoke-static {}, Lcom/penthera/virtuososdk/Common$BearerType;->values()[Lcom/penthera/virtuososdk/Common$BearerType;

    move-result-object v3

    const-string v6, "bearer"

    invoke-virtual {p2, v6, v8}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v6

    aget-object v0, v3, v6

    .line 822
    .local v0, "bt":Lcom/penthera/virtuososdk/Common$BearerType;
    sget-object v3, Lcom/penthera/virtuososdk/Common$BearerType;->cellular:Lcom/penthera/virtuososdk/Common$BearerType;

    if-ne v3, v0, :cond_0

    .line 823
    iget-object v3, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-direct {p0, v3}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v2

    .line 824
    .local v2, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->usedCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v6

    const-string v3, "bearer_data_usage"

    invoke-virtual {p2, v3, v8}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v3

    int-to-double v8, v3

    add-double v4, v6, v8

    .line 825
    .local v4, "used_quota":D
    const-string v3, "cell_quota_used"

    new-instance v6, Ljava/lang/StringBuilder;

    invoke-direct {v6}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v6, v4, v5}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-virtual {v2, v3, v6}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 826
    sget-object v3, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    iget-object v6, p1, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v6}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    .line 827
    .local v1, "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    invoke-virtual {v1, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    goto :goto_0
.end method

.method public release()V
    .locals 1

    .prologue
    .line 1280
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->lwm:Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/monitor/LocalWifiMonitor;->release()V

    .line 1281
    return-void
.end method

.method public resetErrorQueue(Ljava/lang/String;)V
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 759
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    if-eqz v0, :cond_0

    .line 760
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->cancel()V

    .line 761
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    invoke-virtual {v0}, Ljava/util/Timer;->purge()I

    .line 764
    :cond_0
    new-instance v0, Ljava/util/Timer;

    const-string v1, "RetryErrorDownloads"

    invoke-direct {v0, v1}, Ljava/util/Timer;-><init>(Ljava/lang/String;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    .line 765
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iErrorItemsTimer:Ljava/util/Timer;

    invoke-virtual {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->doGetRetryErrorsTask(Ljava/lang/String;)Ljava/util/TimerTask;

    move-result-object v1

    const-wide/16 v2, 0x1f4

    invoke-virtual {v0, v1, v2, v3}, Ljava/util/Timer;->schedule(Ljava/util/TimerTask;J)V

    .line 766
    return-void
.end method

.method public resumeClient(Ljava/lang/String;)V
    .locals 5
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 224
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 225
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    .line 226
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 227
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    const-string v2, "downloader_init_state"

    new-instance v3, Ljava/lang/StringBuilder;

    invoke-direct {v3}, Ljava/lang/StringBuilder;-><init>()V

    sget-object v4, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->ordinal()I

    move-result v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 228
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->performDownloadResume(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 229
    return-void
.end method

.method public saveFileState(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V
    .locals 1
    .param p1, "downloader"    # Lcom/penthera/virtuososdk/download/Downloader;
    .param p2, "extras"    # Landroid/os/Bundle;

    .prologue
    .line 771
    const-string v0, "virtuoso_file"

    invoke-virtual {p2, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->saveFileState(Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;)V

    .line 772
    return-void
.end method

.method public setClientConfiguration(Landroid/os/Bundle;IILjava/lang/String;)V
    .locals 8
    .param p1, "headers"    # Landroid/os/Bundle;
    .param p2, "aConnectionTimeOut"    # I
    .param p3, "aSocketTimeOut"    # I
    .param p4, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1173
    invoke-direct {p0, p4}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 1174
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-direct {p0, p4}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v4

    .line 1175
    .local v4, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    if-eqz p1, :cond_2

    .line 1176
    invoke-virtual {p1}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v2

    .line 1177
    .local v2, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    new-instance v3, Ljava/lang/StringBuffer;

    invoke-direct {v3}, Ljava/lang/StringBuffer;-><init>()V

    .line 1178
    .local v3, "sb":Ljava/lang/StringBuffer;
    invoke-interface {v2}, Ljava/util/Set;->isEmpty()Z

    move-result v6

    if-nez v6, :cond_0

    .line 1179
    const-string v6, "{\"headers\":["

    invoke-virtual {v3, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1181
    :cond_0
    invoke-interface {v2}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v6

    :cond_1
    :goto_0
    invoke-interface {v6}, Ljava/util/Iterator;->hasNext()Z

    move-result v7

    if-nez v7, :cond_3

    .line 1191
    invoke-virtual {v3}, Ljava/lang/StringBuffer;->length()I

    move-result v6

    if-lez v6, :cond_2

    .line 1192
    const-string v6, "]}"

    invoke-virtual {v3, v6}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1193
    const-string v6, "client_configuration_headers"

    invoke-virtual {v3}, Ljava/lang/StringBuffer;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1196
    .end local v2    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .end local v3    # "sb":Ljava/lang/StringBuffer;
    :cond_2
    const-string v6, "client_configuration_conn_to"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, p2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1197
    const-string v6, "client_configuration_socket_to"

    new-instance v7, Ljava/lang/StringBuilder;

    invoke-direct {v7}, Ljava/lang/StringBuilder;-><init>()V

    invoke-virtual {v7, p3}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v4, v6, v7}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1198
    invoke-virtual {v0, p1, p2, p3}, Lcom/penthera/virtuososdk/download/Downloader;->setClientConfiguration(Landroid/os/Bundle;II)V

    .line 1200
    return-void

    .line 1181
    .restart local v2    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    .restart local v3    # "sb":Ljava/lang/StringBuffer;
    :cond_3
    invoke-interface {v6}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v1

    check-cast v1, Ljava/lang/String;

    .line 1182
    .local v1, "key":Ljava/lang/String;
    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v5

    .line 1183
    .local v5, "value":Ljava/lang/String;
    invoke-static {v5}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v7

    if-nez v7, :cond_1

    .line 1184
    const-string v7, "{\""

    invoke-virtual {v3, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1185
    invoke-virtual {v3, v1}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1186
    const-string v7, "\":\""

    invoke-virtual {v3, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1187
    invoke-virtual {v3, v5}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    .line 1188
    const-string v7, "\"},"

    invoke-virtual {v3, v7}, Ljava/lang/StringBuffer;->append(Ljava/lang/String;)Ljava/lang/StringBuffer;

    goto :goto_0
.end method

.method public setTestSettings(Landroid/os/Bundle;Ljava/lang/String;)V
    .locals 4
    .param p1, "settings"    # Landroid/os/Bundle;
    .param p2, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1203
    invoke-direct {p0, p2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 1204
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0, p1}, Lcom/penthera/virtuososdk/download/Downloader;->setTestSettings(Landroid/os/Bundle;)V

    .line 1205
    invoke-direct {p0, p2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 1206
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    if-eqz p1, :cond_4

    .line 1207
    const-string v2, "headroom_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_0

    .line 1208
    const-string v2, "headroom_override"

    const-string v3, "headroom_override"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1210
    :cond_0
    const-string v2, "max_storage_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_1

    .line 1211
    const-string v2, "max_storage_override"

    const-string v3, "max_storage_override"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1213
    :cond_1
    const-string v2, "cell_data_quota_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_2

    .line 1214
    const-string v2, "cell_data_quota_override"

    const-string v3, "cell_data_quota_override"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1216
    :cond_2
    const-string v2, "destination_path_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 1217
    const-string v2, "destination_path_override"

    const-string v3, "destination_path_override"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1219
    :cond_3
    const-string v2, "battery_threshold_override"

    invoke-virtual {p1, v2}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v2

    if-eqz v2, :cond_4

    .line 1220
    const-string v2, "battery_threshold_override"

    const-string v3, "battery_threshold_override"

    invoke-virtual {p1, v3}, Landroid/os/Bundle;->get(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-virtual {v1, v2, v3}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 1221
    invoke-virtual {v1}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->getBundle()Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v0, v2}, Lcom/penthera/virtuososdk/download/Downloader;->BatterySettingChanged(Landroid/os/Bundle;)V

    .line 1224
    :cond_4
    return-void
.end method

.method public status(Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1111
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    move-result-object v0

    .line 1112
    .local v0, "client":Lcom/penthera/virtuososdk/download/Downloader;
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader;->status()Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-result-object v1

    return-object v1
.end method

.method public storageUsed(Ljava/lang/String;)D
    .locals 4
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1146
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getDownloadClientAddIfNeeded(Ljava/lang/String;)Lcom/penthera/virtuososdk/download/Downloader;

    .line 1148
    sget-object v2, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->iDownloadClientStorage:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v2, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;

    .line 1149
    .local v0, "csi":Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v1

    .line 1150
    .local v1, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->update(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)V

    .line 1152
    iget-wide v2, v0, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager$ClientStorageInfo;->iUsedByApp:D

    return-wide v2
.end method

.method public totalFileSize(Ljava/lang/String;)D
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 1157
    const-wide/16 v0, 0x0

    return-wide v0
.end method

.method public usedCellQuota(Ljava/lang/String;)D
    .locals 2
    .param p1, "aClientAuth"    # Ljava/lang/String;

    .prologue
    .line 873
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettings(Ljava/lang/String;)Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    move-result-object v0

    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->usedCellQuota(Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;)D

    move-result-wide v0

    return-wide v0
.end method
