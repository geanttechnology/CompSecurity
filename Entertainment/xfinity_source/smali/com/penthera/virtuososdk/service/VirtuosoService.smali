.class public Lcom/penthera/virtuososdk/service/VirtuosoService;
.super Landroid/app/Service;
.source "VirtuosoService.java"


# annotations
.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType:[I

.field private static LOG_TAG:Ljava/lang/String;

.field static iServiceThread:Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;


# instance fields
.field QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/concurrent/ConcurrentHashMap",
            "<",
            "Ljava/lang/String;",
            "Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;",
            ">;"
        }
    .end annotation
.end field

.field private final SEVEN_DAYS:J

.field private iApiReceiver:Landroid/content/BroadcastReceiver;

.field private final iBT:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

.field private iBackplaneBaseUrl:Ljava/lang/String;

.field private final iClientDownloadCallbackList:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/os/RemoteCallbackList",
            "<",
            "Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;",
            ">;>;"
        }
    .end annotation
.end field

.field private final iClientEngineCallbackList:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/os/RemoteCallbackList",
            "<",
            "Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;",
            ">;>;"
        }
    .end annotation
.end field

.field private final iClientQueueCallbackList:Ljava/util/HashMap;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/HashMap",
            "<",
            "Ljava/lang/String;",
            "Landroid/os/RemoteCallbackList",
            "<",
            "Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;",
            ">;>;"
        }
    .end annotation
.end field

.field private iCurrentAuthority:Ljava/lang/String;

.field private iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

.field private iHandler:Landroid/os/Handler;

.field private iPowerManager:Landroid/os/PowerManager;

.field private iProviderAuthList:Ljava/util/List;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "Ljava/util/List",
            "<",
            "Ljava/lang/String;",
            ">;"
        }
    .end annotation
.end field

.field private iProviders:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

.field private iResolver:Landroid/content/ContentResolver;

.field private final iServiceInterfaceImpl:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;

.field private iServiceStarted:Z


# direct methods
.method static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[I
    .locals 3

    .prologue
    .line 55
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType:[I

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
    sput-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType:[I

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
    .line 58
    const-string v0, "VirtuosoService"

    sput-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    .line 55
    return-void
.end method

.method public constructor <init>()V
    .locals 2

    .prologue
    const/4 v1, 0x0

    .line 55
    invoke-direct {p0}, Landroid/app/Service;-><init>()V

    .line 60
    const/4 v0, 0x0

    iput-boolean v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceStarted:Z

    .line 71
    iput-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iBackplaneBaseUrl:Ljava/lang/String;

    .line 75
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$Config;->BUILD:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    iput-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iBT:Lcom/penthera/virtuososdk/utility/CommonUtil$Config$BUILD_TYPE;

    .line 77
    iput-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iHandler:Landroid/os/Handler;

    .line 80
    iput-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviders:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    .line 81
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;

    .line 82
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;

    .line 83
    new-instance v0, Ljava/util/HashMap;

    invoke-direct {v0}, Ljava/util/HashMap;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;

    .line 85
    new-instance v0, Lcom/penthera/virtuososdk/service/VirtuosoService$1;

    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/service/VirtuosoService$1;-><init>(Lcom/penthera/virtuososdk/service/VirtuosoService;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceInterfaceImpl:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;

    .line 527
    new-instance v0, Ljava/util/concurrent/ConcurrentHashMap;

    invoke-direct {v0}, Ljava/util/concurrent/ConcurrentHashMap;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;

    .line 528
    const-wide/32 v0, 0x93a80

    iput-wide v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->SEVEN_DAYS:J

    .line 1063
    new-instance v0, Lcom/penthera/virtuososdk/service/VirtuosoService$2;

    invoke-direct {v0, p0}, Lcom/penthera/virtuososdk/service/VirtuosoService$2;-><init>(Lcom/penthera/virtuososdk/service/VirtuosoService;)V

    iput-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    .line 55
    return-void
.end method

.method static synthetic access$0()Ljava/lang/String;
    .locals 1

    .prologue
    .line 58
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    return-object v0
.end method

.method static synthetic access$1(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$10(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 0

    .prologue
    .line 732
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performQueueCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    return-void
.end method

.method static synthetic access$11(Lcom/penthera/virtuososdk/service/VirtuosoService;)Z
    .locals 1

    .prologue
    .line 60
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceStarted:Z

    return v0
.end method

.method static synthetic access$12(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;
    .locals 1

    .prologue
    .line 80
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviders:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    return-object v0
.end method

.method static synthetic access$13(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/util/List;)V
    .locals 0

    .prologue
    .line 79
    iput-object p1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviderAuthList:Ljava/util/List;

    return-void
.end method

.method static synthetic access$2(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 83
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$3(Lcom/penthera/virtuososdk/service/VirtuosoService;)Ljava/util/HashMap;
    .locals 1

    .prologue
    .line 82
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;

    return-object v0
.end method

.method static synthetic access$4(Lcom/penthera/virtuososdk/service/VirtuosoService;Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V
    .locals 0

    .prologue
    .line 550
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performQuotaReset(Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V

    return-void
.end method

.method static synthetic access$5(Lcom/penthera/virtuososdk/service/VirtuosoService;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;
    .locals 1

    .prologue
    .line 599
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    return-object v0
.end method

.method static synthetic access$6(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D
    .locals 3

    .prologue
    .line 1139
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/service/VirtuosoService;->toMbytes(D)D

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$7(Lcom/penthera/virtuososdk/service/VirtuosoService;D)D
    .locals 3

    .prologue
    .line 1135
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/service/VirtuosoService;->toBytes(D)D

    move-result-wide v0

    return-wide v0
.end method

.method static synthetic access$8(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 0

    .prologue
    .line 1022
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performDownloadEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    return-void
.end method

.method static synthetic access$9(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 0

    .prologue
    .line 924
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    return-void
.end method

.method private initCellQuota(Ljava/lang/String;)V
    .locals 14
    .param p1, "client"    # Ljava/lang/String;

    .prologue
    const-wide/32 v12, 0x93a80

    const-wide/16 v10, 0x3e8

    .line 536
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v3, p1}, Ljava/util/concurrent/ConcurrentHashMap;->containsKey(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 537
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;

    new-instance v8, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;

    invoke-direct {v8, p0, p1}, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;-><init>(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;)V

    invoke-virtual {v3, p1, v8}, Ljava/util/concurrent/ConcurrentHashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 539
    :cond_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->QuotaResettersMap:Ljava/util/concurrent/ConcurrentHashMap;

    invoke-virtual {v3, p1}, Ljava/util/concurrent/ConcurrentHashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v2

    check-cast v2, Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;

    .line 540
    .local v2, "resetter":Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;
    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v8

    div-long v0, v8, v10

    .line 541
    .local v0, "now":J
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    invoke-virtual {v3, p1}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->cellQuotaStart(Ljava/lang/String;)J

    move-result-wide v6

    .line 542
    .local v6, "start":J
    sub-long v8, v0, v12

    cmp-long v3, v8, v6

    if-gtz v3, :cond_1

    .line 543
    const/4 v3, 0x1

    invoke-direct {p0, v2, p1, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performQuotaReset(Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V

    .line 549
    :goto_0
    return-void

    .line 545
    :cond_1
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iHandler:Landroid/os/Handler;

    invoke-virtual {v3, v2}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 546
    add-long v8, v6, v12

    sub-long v4, v8, v0

    .line 547
    .local v4, "seconds":J
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iHandler:Landroid/os/Handler;

    mul-long v8, v4, v10

    invoke-virtual {v3, v2, v8, v9}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    goto :goto_0
.end method

.method private initCellQuotas()V
    .locals 3

    .prologue
    .line 530
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviderAuthList:Ljava/util/List;

    invoke-interface {v1}, Ljava/util/List;->iterator()Ljava/util/Iterator;

    move-result-object v1

    :goto_0
    invoke-interface {v1}, Ljava/util/Iterator;->hasNext()Z

    move-result v2

    if-nez v2, :cond_0

    .line 533
    return-void

    .line 530
    :cond_0
    invoke-interface {v1}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 531
    .local v0, "auth":Ljava/lang/String;
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->initCellQuota(Ljava/lang/String;)V

    goto :goto_0
.end method

.method private declared-synchronized isServiceThreadAlive()Z
    .locals 1

    .prologue
    .line 656
    monitor-enter p0

    :try_start_0
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceThread:Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;

    if-eqz v0, :cond_0

    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceThread:Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/service/VirtuosoServiceThread;->isAlive()Z
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    move-result v0

    if-nez v0, :cond_1

    .line 657
    :cond_0
    const/4 v0, 0x0

    .line 658
    :goto_0
    monitor-exit p0

    return v0

    :cond_1
    const/4 v0, 0x1

    goto :goto_0

    .line 656
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized performDownloadEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 1
    .param p1, "aClient"    # Ljava/lang/String;
    .param p2, "aType"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .param p3, "aDataParcel"    # Landroid/os/Parcelable;

    .prologue
    .line 1023
    monitor-enter p0

    :try_start_0
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performDownloadEngineCallbackOnNewInterfaces(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1024
    monitor-exit p0

    return-void

    .line 1023
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0
.end method

.method private declared-synchronized performDownloadEngineCallbackOnNewInterfaces(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 3
    .param p1, "aClient"    # Ljava/lang/String;
    .param p2, "aType"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .param p3, "aDataParcel"    # Landroid/os/Parcelable;

    .prologue
    .line 1028
    monitor-enter p0

    :try_start_0
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[I

    move-result-object v0

    invoke-virtual {p2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1059
    :pswitch_0
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "performDownloadEngineCallbackOnNewInterfaces unhandled message "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1061
    :goto_0
    :pswitch_1
    monitor-exit p0

    return-void

    .line 1037
    :pswitch_2
    :try_start_1
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "performDownloadEngineCallbackOnNewInterfaces "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1038
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performQueueCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 1028
    :catchall_0
    move-exception v0

    monitor-exit p0

    throw v0

    .line 1046
    :pswitch_3
    :try_start_2
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "performDownloadEngineCallbackOnNewInterfaces "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1047
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    goto :goto_0

    .line 1051
    :pswitch_4
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "performDownloadEngineCallbackOnNewInterfaces "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1, p2}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1052
    invoke-direct {p0, p1, p2, p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performDownloadedCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_0

    .line 1028
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_3
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_4
        :pswitch_3
        :pswitch_1
        :pswitch_0
        :pswitch_3
        :pswitch_0
        :pswitch_3
        :pswitch_3
        :pswitch_2
        :pswitch_2
        :pswitch_2
    .end packed-switch
.end method

.method private declared-synchronized performDownloadedCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 14
    .param p1, "aClient"    # Ljava/lang/String;
    .param p2, "aType"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .param p3, "aDataParcel"    # Landroid/os/Parcelable;

    .prologue
    .line 881
    monitor-enter p0

    :try_start_0
    iget-object v11, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;

    invoke-virtual {v11, p1}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/RemoteCallbackList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 882
    .local v3, "callbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;>;"
    if-nez v3, :cond_0

    .line 922
    :goto_0
    monitor-exit p0

    return-void

    .line 883
    :cond_0
    :try_start_1
    invoke-virtual {v3}, Landroid/os/RemoteCallbackList;->beginBroadcast()I

    move-result v1

    .line 886
    .local v1, "N":I
    const/4 v7, 0x0

    .local v7, "i":I
    :goto_1
    if-lt v7, v1, :cond_1

    .line 921
    :goto_2
    invoke-virtual {v3}, Landroid/os/RemoteCallbackList;->finishBroadcast()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 881
    .end local v1    # "N":I
    .end local v3    # "callbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;>;"
    .end local v7    # "i":I
    :catchall_0
    move-exception v11

    monitor-exit p0

    throw v11

    .line 888
    .restart local v1    # "N":I
    .restart local v3    # "callbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;>;"
    .restart local v7    # "i":I
    :cond_1
    :try_start_2
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[I

    move-result-object v11

    invoke-virtual/range {p2 .. p2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v12

    aget v11, v11, v12

    packed-switch v11, :pswitch_data_0

    .line 912
    :pswitch_0
    sget-object v11, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "performDownloadedCallback unhandled message "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 886
    :cond_2
    :goto_3
    add-int/lit8 v7, v7, 0x1

    goto :goto_1

    .line 892
    :pswitch_1
    sget-object v11, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "performDownloadedCallback "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 893
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v4, v0

    .line 894
    .local v4, "data":Landroid/os/Bundle;
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->values()[Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    move-result-object v11

    const-string v12, "manage_files_action"

    invoke-virtual {v4, v12}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v12

    aget-object v2, v11, v12

    .line 895
    .local v2, "action":Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    sget-object v11, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListDownloaded:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    if-ne v2, v11, :cond_2

    .line 896
    const-string v11, "manage_files_list_size"

    invoke-virtual {v4, v11}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v10

    .line 897
    .local v10, "size":I
    const-string v11, "manage_files_index"

    invoke-virtual {v4, v11}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v8

    .line 898
    .local v8, "offset":I
    const-string v11, "virtuoso_file"

    invoke-virtual {v4, v11}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v9

    .line 899
    .local v9, "p":Landroid/os/Parcelable;
    const/4 v6, 0x0

    .line 900
    .local v6, "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v9, :cond_3

    .line 901
    move-object v0, v9

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-object v6, v0

    .line 902
    :cond_3
    invoke-virtual {v3, v7}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v11

    check-cast v11, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    invoke-interface {v11, v6, v8, v10}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;->engineContentInDownloadedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_3

    .line 916
    .end local v2    # "action":Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    .end local v4    # "data":Landroid/os/Bundle;
    .end local v6    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v8    # "offset":I
    .end local v9    # "p":Landroid/os/Parcelable;
    .end local v10    # "size":I
    :catch_0
    move-exception v5

    .line 918
    .local v5, "e":Ljava/lang/Exception;
    :try_start_3
    const-class v11, Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-virtual {v11}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v11

    const-string v12, "Exception during performDownloadedCallback callbacks"

    invoke-static {v11, v12, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    .line 907
    .end local v5    # "e":Ljava/lang/Exception;
    :pswitch_2
    :try_start_4
    sget-object v11, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "performDownloadedCallback "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v12, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 908
    invoke-virtual {v3, v7}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v11

    check-cast v11, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;

    invoke-interface {v11}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadedCallback;->engineDownloadedListChanged()V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto :goto_3

    .line 888
    nop

    :pswitch_data_0
    .packed-switch 0x6
        :pswitch_2
        :pswitch_0
        :pswitch_0
        :pswitch_1
    .end packed-switch
.end method

.method private declared-synchronized performEngineCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 18
    .param p1, "aClient"    # Ljava/lang/String;
    .param p2, "aType"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .param p3, "aDataParcel"    # Landroid/os/Parcelable;

    .prologue
    .line 925
    monitor-enter p0

    :try_start_0
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;

    move-object/from16 v0, p1

    invoke-virtual {v14, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v4

    check-cast v4, Landroid/os/RemoteCallbackList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 926
    .local v4, "callbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;>;"
    if-nez v4, :cond_0

    .line 1020
    :goto_0
    monitor-exit p0

    return-void

    .line 927
    :cond_0
    :try_start_1
    invoke-virtual {v4}, Landroid/os/RemoteCallbackList;->beginBroadcast()I

    move-result v1

    .line 930
    .local v1, "N":I
    const/4 v9, 0x0

    .local v9, "i":I
    :goto_1
    if-lt v9, v1, :cond_1

    .line 1019
    :goto_2
    invoke-virtual {v4}, Landroid/os/RemoteCallbackList;->finishBroadcast()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 925
    .end local v1    # "N":I
    .end local v4    # "callbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;>;"
    .end local v9    # "i":I
    :catchall_0
    move-exception v14

    monitor-exit p0

    throw v14

    .line 932
    .restart local v1    # "N":I
    .restart local v4    # "callbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;>;"
    .restart local v9    # "i":I
    :cond_1
    :try_start_2
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[I

    move-result-object v14

    invoke-virtual/range {p2 .. p2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v15

    aget v14, v14, v15

    packed-switch v14, :pswitch_data_0

    .line 1010
    :pswitch_0
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback unhandled message "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 930
    :cond_2
    :goto_3
    add-int/lit8 v9, v9, 0x1

    goto :goto_1

    .line 935
    :pswitch_1
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 936
    invoke-virtual {v4, v9}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v14

    check-cast v14, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    move-object/from16 v0, p3

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-object v15, v0

    invoke-interface {v14, v15}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;->downloadEngineStatusDidChange(Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;)V

    .line 938
    move-object/from16 v0, p3

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-object v10, v0

    .line 939
    .local v10, "ives":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "Got status change "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 940
    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v14

    sget-object v15, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v14, v15, :cond_2

    .line 941
    check-cast v10, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    .end local v10    # "ives":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    invoke-virtual {v10}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->extras()Landroid/os/Bundle;

    move-result-object v7

    .line 942
    .local v7, "extras":Landroid/os/Bundle;
    const-string v14, "virtuoso_file"

    invoke-virtual {v7, v14}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_2

    .line 943
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v15, "status change has file"

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 944
    invoke-direct/range {p0 .. p3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->performQueueCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto :goto_3

    .line 1014
    .end local v7    # "extras":Landroid/os/Bundle;
    :catch_0
    move-exception v6

    .line 1016
    .local v6, "e":Ljava/lang/Exception;
    :try_start_3
    const-class v14, Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-virtual {v14}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v14

    const-string v15, "Exception during performEngineCallback callbacks"

    invoke-static {v14, v15, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    .line 951
    .end local v6    # "e":Ljava/lang/Exception;
    :pswitch_2
    :try_start_4
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 952
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v5, v0

    .line 953
    .local v5, "data":Landroid/os/Bundle;
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->values()[Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    move-result-object v14

    const-string v15, "manage_files_action"

    invoke-virtual {v5, v15}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v15

    aget-object v2, v14, v15

    .line 954
    .local v2, "action":Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListAllFiles:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    if-ne v2, v14, :cond_2

    .line 955
    const-string v14, "manage_files_list_size"

    invoke-virtual {v5, v14}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v13

    .line 956
    .local v13, "size":I
    const-string v14, "manage_files_index"

    invoke-virtual {v5, v14}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v11

    .line 957
    .local v11, "offset":I
    const-string v14, "virtuoso_file"

    invoke-virtual {v5, v14}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v12

    .line 958
    .local v12, "p":Landroid/os/Parcelable;
    const/4 v8, 0x0

    .line 959
    .local v8, "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v12, :cond_3

    .line 960
    move-object v0, v12

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-object v8, v0

    .line 961
    :cond_3
    invoke-virtual {v4, v9}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v14

    check-cast v14, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    invoke-interface {v14, v8, v11, v13}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;->engineContentInList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V

    goto/16 :goto_3

    .line 967
    .end local v2    # "action":Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    .end local v5    # "data":Landroid/os/Bundle;
    .end local v8    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v11    # "offset":I
    .end local v12    # "p":Landroid/os/Parcelable;
    .end local v13    # "size":I
    :pswitch_3
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 968
    invoke-virtual {v4, v9}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v14

    check-cast v14, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v15, v0

    const-string v16, "flags"

    const/16 v17, 0x0

    invoke-virtual/range {v15 .. v17}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v15

    invoke-interface {v14, v15}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;->settingChanged(I)V

    goto/16 :goto_3

    .line 972
    :pswitch_4
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 973
    invoke-virtual {v4, v9}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v14

    check-cast v14, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    invoke-interface {v14}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;->engineListChanged()V

    goto/16 :goto_3

    .line 977
    :pswitch_5
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 978
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v14, v0

    const-string v15, "virtuoso_files"

    invoke-virtual {v14, v15}, Landroid/os/Bundle;->getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v3

    .line 979
    .local v3, "arr":[Landroid/os/Parcelable;
    if-nez v3, :cond_4

    .line 980
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v15, "Collection changed array is NULL!"

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    .line 982
    :cond_4
    invoke-virtual {v4, v9}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v14

    check-cast v14, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    check-cast v3, [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .end local v3    # "arr":[Landroid/os/Parcelable;
    invoke-interface {v14, v3}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;->collectionsChanged([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto/16 :goto_3

    .line 987
    :pswitch_6
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 988
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v14, v0

    const-string v15, "virtuoso_files"

    invoke-virtual {v14, v15}, Landroid/os/Bundle;->getStringArray(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v3

    .line 989
    .local v3, "arr":[Ljava/lang/String;
    if-nez v3, :cond_5

    .line 990
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v15, "Collection changed array is NULL!"

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    .line 992
    :cond_5
    invoke-virtual {v4, v9}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v14

    check-cast v14, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    invoke-interface {v14, v3}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;->collectionsDeleted([Ljava/lang/String;)V

    goto/16 :goto_3

    .line 998
    .end local v3    # "arr":[Ljava/lang/String;
    :pswitch_7
    sget-object v14, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "performEngineCallback "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v15, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 999
    if-eqz p3, :cond_2

    .line 1000
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v5, v0

    .line 1001
    .restart local v5    # "data":Landroid/os/Bundle;
    const-string v14, "virtuoso_file"

    invoke-virtual {v5, v14}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v12

    .line 1003
    .restart local v12    # "p":Landroid/os/Parcelable;
    if-eqz v12, :cond_2

    .line 1004
    invoke-virtual {v4, v9}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v14

    check-cast v14, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;

    check-cast v12, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .end local v12    # "p":Landroid/os/Parcelable;
    invoke-interface {v14, v12}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoEngineCallback;->itemUpdated(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_3

    .line 932
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_4
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_7
        :pswitch_5
        :pswitch_6
    .end packed-switch
.end method

.method private declared-synchronized performQueueCallback(Ljava/lang/String;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    .locals 27
    .param p1, "aClient"    # Ljava/lang/String;
    .param p2, "aType"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;
    .param p3, "aDataParcel"    # Landroid/os/Parcelable;

    .prologue
    .line 733
    monitor-enter p0

    :try_start_0
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;

    move-object/from16 v0, p1

    invoke-virtual {v5, v0}, Ljava/util/HashMap;->get(Ljava/lang/Object;)Ljava/lang/Object;

    move-result-object v23

    check-cast v23, Landroid/os/RemoteCallbackList;
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 734
    .local v23, "queueCallbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;>;"
    if-nez v23, :cond_0

    .line 878
    :goto_0
    monitor-exit p0

    return-void

    .line 735
    :cond_0
    :try_start_1
    invoke-virtual/range {v23 .. v23}, Landroid/os/RemoteCallbackList;->beginBroadcast()I

    move-result v4

    .line 738
    .local v4, "N":I
    const/16 v19, 0x0

    .local v19, "i":I
    :goto_1
    move/from16 v0, v19

    if-lt v0, v4, :cond_1

    .line 877
    :goto_2
    invoke-virtual/range {v23 .. v23}, Landroid/os/RemoteCallbackList;->finishBroadcast()V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto :goto_0

    .line 733
    .end local v4    # "N":I
    .end local v19    # "i":I
    .end local v23    # "queueCallbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;>;"
    :catchall_0
    move-exception v5

    monitor-exit p0

    throw v5

    .line 740
    .restart local v4    # "N":I
    .restart local v19    # "i":I
    .restart local v23    # "queueCallbackList":Landroid/os/RemoteCallbackList;, "Landroid/os/RemoteCallbackList<Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;>;"
    :cond_1
    :try_start_2
    invoke-static {}, Lcom/penthera/virtuososdk/service/VirtuosoService;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EDownloadCallbackType()[I

    move-result-object v5

    invoke-virtual/range {p2 .. p2}, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->ordinal()I

    move-result v6

    aget v5, v5, v6

    packed-switch v5, :pswitch_data_0

    .line 868
    :pswitch_0
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback unhandled message "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 738
    :cond_2
    :goto_3
    add-int/lit8 v19, v19, 0x1

    goto :goto_1

    .line 743
    :pswitch_1
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 744
    move-object/from16 v0, p3

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;

    move-object/from16 v20, v0

    .line 745
    .local v20, "ives":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    invoke-interface/range {v20 .. v20}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v5

    sget-object v6, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Errors:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v5, v6, :cond_3

    invoke-interface/range {v20 .. v20}, Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;->status()Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-result-object v5

    sget-object v6, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-ne v5, v6, :cond_2

    .line 746
    :cond_3
    check-cast v20, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    .end local v20    # "ives":Lcom/penthera/virtuososdk/client/IVirtuosoDownloadEngineStatus;
    invoke-virtual/range {v20 .. v20}, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->extras()Landroid/os/Bundle;

    move-result-object v17

    .line 747
    .local v17, "extras":Landroid/os/Bundle;
    const-string v5, "virtuoso_file"

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->containsKey(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 748
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v6, "status change erred file"

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 752
    const-string v5, "virtuoso_file"

    move-object/from16 v0, v17

    invoke-virtual {v0, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v25

    check-cast v25, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 753
    .local v25, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    if-eqz v25, :cond_2

    .line 754
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v6

    .line 755
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v7

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v7

    .line 756
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v8

    .line 757
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v10

    .line 758
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v12

    const/16 v26, 0x4

    move/from16 v0, v26

    if-ne v12, v0, :cond_4

    .line 759
    check-cast v25, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->totalFragmentsComplete()I

    move-result v12

    .line 754
    :goto_4
    invoke-interface/range {v5 .. v12}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->downloadEngineFileWithErrorMin(Ljava/lang/String;IDDI)V
    :try_end_2
    .catch Ljava/lang/Exception; {:try_start_2 .. :try_end_2} :catch_0
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    goto/16 :goto_3

    .line 872
    .end local v17    # "extras":Landroid/os/Bundle;
    :catch_0
    move-exception v16

    .line 874
    .local v16, "e":Ljava/lang/Exception;
    :try_start_3
    const-class v5, Lcom/penthera/virtuososdk/service/VirtuosoService;

    invoke-virtual {v5}, Ljava/lang/Class;->getName()Ljava/lang/String;

    move-result-object v5

    const-string v6, "Exception during performQueueCallback callbacks"

    move-object/from16 v0, v16

    invoke-static {v5, v6, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    goto/16 :goto_2

    .line 759
    .end local v16    # "e":Ljava/lang/Exception;
    .restart local v17    # "extras":Landroid/os/Bundle;
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_4
    const/4 v12, 0x0

    goto :goto_4

    .line 766
    .end local v17    # "extras":Landroid/os/Bundle;
    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :pswitch_2
    :try_start_4
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 768
    move-object/from16 v0, p3

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v25, v0

    .line 769
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    if-eqz v25, :cond_2

    .line 770
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v6

    .line 771
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v7

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v7

    .line 772
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v8

    .line 773
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v10

    .line 774
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v12

    const/16 v26, 0x4

    move/from16 v0, v26

    if-ne v12, v0, :cond_5

    .line 775
    check-cast v25, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->totalFragmentsComplete()I

    move-result v12

    .line 770
    :goto_5
    invoke-interface/range {v5 .. v12}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->downloadEngineDidStartDownloadingFileMin(Ljava/lang/String;IDDI)V

    goto/16 :goto_3

    .line 775
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_5
    const/4 v12, 0x0

    goto :goto_5

    .line 779
    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :pswitch_3
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 783
    move-object/from16 v0, p3

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v25, v0

    .line 784
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    if-eqz v25, :cond_2

    .line 785
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v6

    .line 786
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v7

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v7

    .line 787
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v8

    .line 788
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v10

    .line 789
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v12

    const/16 v26, 0x4

    move/from16 v0, v26

    if-ne v12, v0, :cond_6

    .line 790
    check-cast v25, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->totalFragmentsComplete()I

    move-result v12

    .line 785
    :goto_6
    invoke-interface/range {v5 .. v12}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->downloadEngineProgressUpdatedForFileMin(Ljava/lang/String;IDDI)V

    goto/16 :goto_3

    .line 790
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_6
    const/4 v12, 0x0

    goto :goto_6

    .line 795
    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :pswitch_4
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 798
    move-object/from16 v0, p3

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v25, v0

    .line 799
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    if-eqz v25, :cond_2

    .line 800
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v6

    .line 801
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v7

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v7

    .line 802
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v8

    .line 803
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v10

    .line 804
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v12

    const/16 v26, 0x4

    move/from16 v0, v26

    if-ne v12, v0, :cond_7

    .line 805
    check-cast v25, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->totalFragmentsComplete()I

    move-result v12

    .line 800
    :goto_7
    invoke-interface/range {v5 .. v12}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->downloadEngineDidFinishDownloadingFileMin(Ljava/lang/String;IDDI)V

    goto/16 :goto_3

    .line 805
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_7
    const/4 v12, 0x0

    goto :goto_7

    .line 811
    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :pswitch_5
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 812
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v15, v0

    .line 814
    .local v15, "data":Landroid/os/Bundle;
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->values()[Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    move-result-object v5

    const-string v6, "manage_files_action"

    invoke-virtual {v15, v6}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v6

    aget-object v13, v5, v6

    .line 815
    .local v13, "action":Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;->EListQueued:Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;

    if-ne v13, v5, :cond_2

    .line 816
    const-string v5, "manage_files_list_size"

    invoke-virtual {v15, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v24

    .line 817
    .local v24, "size":I
    const-string v5, "manage_files_index"

    invoke-virtual {v15, v5}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v21

    .line 818
    .local v21, "offset":I
    const-string v5, "virtuoso_file"

    invoke-virtual {v15, v5}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v22

    .line 819
    .local v22, "p":Landroid/os/Parcelable;
    const/16 v18, 0x0

    .line 820
    .local v18, "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v22, :cond_8

    .line 821
    move-object/from16 v0, v22

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-object/from16 v18, v0

    .line 822
    :cond_8
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    move-object/from16 v0, v18

    move/from16 v1, v21

    move/from16 v2, v24

    invoke-interface {v5, v0, v1, v2}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->engineContentInQueuedList(Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;II)V

    goto/16 :goto_3

    .line 827
    .end local v13    # "action":Lcom/penthera/virtuososdk/utility/CommonUtil$FileAction;
    .end local v15    # "data":Landroid/os/Bundle;
    .end local v18    # "file":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    .end local v21    # "offset":I
    .end local v22    # "p":Landroid/os/Parcelable;
    .end local v24    # "size":I
    :pswitch_6
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 828
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    invoke-interface {v5}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->engineDownloadQueueChanged()V

    goto/16 :goto_3

    .line 833
    :pswitch_7
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 834
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v5, v0

    const-string v6, "virtuoso_files"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v14

    .line 835
    .local v14, "arr":[Landroid/os/Parcelable;
    if-nez v14, :cond_9

    .line 836
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v6, "Collection array is NULL!"

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    .line 838
    :cond_9
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    check-cast v14, [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .end local v14    # "arr":[Landroid/os/Parcelable;
    invoke-interface {v5, v14}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->collectionsProgressUpdated([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto/16 :goto_3

    .line 843
    :pswitch_8
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 844
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v5, v0

    const-string v6, "virtuoso_files"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getParcelableArray(Ljava/lang/String;)[Landroid/os/Parcelable;

    move-result-object v14

    .line 845
    .restart local v14    # "arr":[Landroid/os/Parcelable;
    if-nez v14, :cond_a

    .line 846
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v6, "Collection array is NULL!"

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto/16 :goto_3

    .line 848
    :cond_a
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    check-cast v14, [Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    .end local v14    # "arr":[Landroid/os/Parcelable;
    invoke-interface {v5, v14}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->collectionsComplete([Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;)V

    goto/16 :goto_3

    .line 853
    :pswitch_9
    sget-object v5, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "performQueueCallback "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p2

    invoke-virtual {v6, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 857
    move-object/from16 v0, p3

    check-cast v0, Landroid/os/Bundle;

    move-object v5, v0

    const-string v6, "virtuoso_file"

    invoke-virtual {v5, v6}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v25

    check-cast v25, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 858
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    move-object/from16 v0, v23

    move/from16 v1, v19

    invoke-virtual {v0, v1}, Landroid/os/RemoteCallbackList;->getBroadcastItem(I)Landroid/os/IInterface;

    move-result-object v5

    check-cast v5, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;

    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v6

    .line 859
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v7

    invoke-virtual {v7}, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->ordinal()I

    move-result v7

    .line 860
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v8

    .line 861
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->currentSize()D

    move-result-wide v10

    .line 862
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v12

    const/16 v26, 0x4

    move/from16 v0, v26

    if-ne v12, v0, :cond_b

    .line 863
    check-cast v25, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;

    .end local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    invoke-interface/range {v25 .. v25}, Lcom/penthera/virtuososdk/client/IVirtuosoHLSFile;->totalFragmentsComplete()I

    move-result v12

    .line 858
    :goto_8
    invoke-interface/range {v5 .. v12}, Lcom/penthera/virtuososdk/interfaces/IVirtuosoDownloadQueueCallback;->fragmentCompleteMin(Ljava/lang/String;IDDI)V
    :try_end_4
    .catch Ljava/lang/Exception; {:try_start_4 .. :try_end_4} :catch_0
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    goto/16 :goto_3

    .line 863
    .restart local v25    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :cond_b
    const/4 v12, 0x0

    goto :goto_8

    .line 740
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_6
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_5
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_0
        :pswitch_7
        :pswitch_8
        :pswitch_9
    .end packed-switch
.end method

.method private performQuotaReset(Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;Ljava/lang/String;Z)V
    .locals 8
    .param p1, "resetter"    # Lcom/penthera/virtuososdk/service/VirtuosoService$QuotaResetter;
    .param p2, "aClientAuth"    # Ljava/lang/String;
    .param p3, "aNotify"    # Z

    .prologue
    .line 551
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iHandler:Landroid/os/Handler;

    invoke-virtual {v1, p1}, Landroid/os/Handler;->removeCallbacks(Ljava/lang/Runnable;)V

    .line 552
    new-instance v0, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;

    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iResolver:Landroid/content/ContentResolver;

    invoke-direct {v0, v1, p2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    .line 553
    .local v0, "si":Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;
    const-string v1, "cell_quota_start_date"

    new-instance v2, Ljava/lang/StringBuilder;

    invoke-direct {v2}, Ljava/lang/StringBuilder;-><init>()V

    new-instance v3, Ljava/util/Date;

    invoke-direct {v3}, Ljava/util/Date;-><init>()V

    invoke-virtual {v3}, Ljava/util/Date;->getTime()J

    move-result-wide v4

    const-wide/16 v6, 0x3e8

    div-long/2addr v4, v6

    invoke-virtual {v2, v4, v5}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v2

    invoke-virtual {v2}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v2

    invoke-virtual {v0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 554
    const-string v1, "cell_quota_used"

    const-string v2, "0"

    invoke-virtual {v0, v1, v2}, Lcom/penthera/virtuososdk/database/impl/provider/SettingsInstance;->set(Ljava/lang/String;Ljava/lang/String;)V

    .line 555
    if-eqz p3, :cond_0

    .line 556
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    const/16 v2, 0x40

    invoke-virtual {v1, p2, v2}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->clientSettingChange(Ljava/lang/String;I)V

    .line 557
    :cond_0
    iget-object v1, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iHandler:Landroid/os/Handler;

    const-wide/32 v2, 0x240c8400

    invoke-virtual {v1, p1, v2, v3}, Landroid/os/Handler;->postDelayed(Ljava/lang/Runnable;J)Z

    .line 558
    return-void
.end method

.method private registerApiReceiver()V
    .locals 3

    .prologue
    .line 1116
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "virtuoso.intent.action.COMMS_FAILURE"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 1117
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "virtuoso.intent.action.QUEUE_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 1118
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "virtuoso.intent.action.SETTING_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 1119
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "virtuoso.intent.action.DOWNLOAD_LIST_CHANGED"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 1120
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "virtuoso.intent.action.DOWNLOAD_CALLBACK"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 1121
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    new-instance v1, Landroid/content/IntentFilter;

    const-string v2, "virtuoso.intent.action.INTENT_FRAGMENT_COMPLETE_CALLBACK"

    invoke-direct {v1, v2}, Landroid/content/IntentFilter;-><init>(Ljava/lang/String;)V

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->registerLocalReceiver(Landroid/content/BroadcastReceiver;Landroid/content/IntentFilter;)V

    .line 1123
    return-void
.end method

.method private declared-synchronized startServiceThread()Z
    .locals 3

    .prologue
    .line 668
    monitor-enter p0

    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v2, "startServiceThread(): Aquiring cpu level wake lock before starting the sync thread"

    invoke-static {v1, v2}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 669
    const/4 v0, 0x1

    .line 672
    .local v0, "isAlive":Z
    monitor-exit p0

    return v0

    .line 668
    .end local v0    # "isAlive":Z
    :catchall_0
    move-exception v1

    monitor-exit p0

    throw v1
.end method

.method private toBytes(D)D
    .locals 5
    .param p1, "aMBValue"    # D

    .prologue
    const-wide/high16 v2, 0x4090000000000000L    # 1024.0

    .line 1136
    const-wide/16 v0, 0x0

    cmpg-double v0, p1, v0

    if-gez v0, :cond_0

    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    .line 1137
    :goto_0
    return-wide v0

    :cond_0
    mul-double v0, p1, v2

    mul-double/2addr v0, v2

    goto :goto_0
.end method

.method private toMbytes(D)D
    .locals 7
    .param p1, "aBytesValue"    # D

    .prologue
    const-wide/high16 v4, 0x4090000000000000L    # 1024.0

    const-wide v0, -0x3f70c00000000000L    # -1000.0

    .line 1140
    const-wide/16 v2, 0x0

    cmpg-double v2, p1, v2

    if-gez v2, :cond_1

    .line 1141
    cmpl-double v2, p1, v0

    if-nez v2, :cond_0

    .line 1144
    :goto_0
    return-wide v0

    .line 1142
    :cond_0
    const-wide/high16 v0, -0x4010000000000000L    # -1.0

    goto :goto_0

    .line 1144
    :cond_1
    div-double v0, p1, v4

    div-double/2addr v0, v4

    goto :goto_0
.end method

.method private unregisterApiReceiver()V
    .locals 1

    .prologue
    .line 1132
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iApiReceiver:Landroid/content/BroadcastReceiver;

    invoke-static {v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->unregisterLocalReceiver(Landroid/content/BroadcastReceiver;)V

    .line 1133
    return-void
.end method


# virtual methods
.method public onBind(Landroid/content/Intent;)Landroid/os/IBinder;
    .locals 4
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 575
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v1

    .line 576
    .local v1, "extras":Landroid/os/Bundle;
    if-eqz v1, :cond_0

    .line 577
    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v0

    .line 578
    .local v0, "auth":Ljava/lang/String;
    invoke-static {v0}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-nez v3, :cond_0

    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviderAuthList:Ljava/util/List;

    invoke-interface {v3, v0}, Ljava/util/List;->contains(Ljava/lang/Object;)Z

    move-result v3

    if-nez v3, :cond_0

    .line 579
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    invoke-virtual {v3, v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->initClient(Ljava/lang/String;)V

    .line 580
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->initCellQuota(Ljava/lang/String;)V

    .line 581
    new-instance v2, Lcom/penthera/virtuososdk/service/VirtuosoService$3;

    invoke-direct {v2, p0, v0}, Lcom/penthera/virtuososdk/service/VirtuosoService$3;-><init>(Lcom/penthera/virtuososdk/service/VirtuosoService;Ljava/lang/String;)V

    .line 592
    .local v2, "r":Ljava/lang/Runnable;
    new-instance v3, Ljava/lang/Thread;

    invoke-direct {v3, v2}, Ljava/lang/Thread;-><init>(Ljava/lang/Runnable;)V

    invoke-virtual {v3}, Ljava/lang/Thread;->start()V

    .line 595
    .end local v0    # "auth":Ljava/lang/String;
    .end local v2    # "r":Ljava/lang/Runnable;
    :cond_0
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceInterfaceImpl:Lcom/penthera/virtuososdk/interfaces/IVirtuosoService$Stub;

    return-object v3
.end method

.method public onCreate()V
    .locals 6

    .prologue
    .line 603
    invoke-super {p0}, Landroid/app/Service;->onCreate()V

    .line 604
    new-instance v3, Landroid/os/Handler;

    invoke-direct {v3}, Landroid/os/Handler;-><init>()V

    iput-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iHandler:Landroid/os/Handler;

    .line 605
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/penthera/virtuososdk/utility/CommonUtil;->setApplicationContext(Landroid/content/Context;)V

    .line 609
    :try_start_0
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getPackageManager()Landroid/content/pm/PackageManager;

    move-result-object v3

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getPackageName()Ljava/lang/String;

    move-result-object v4

    const/16 v5, 0x80

    invoke-virtual {v3, v4, v5}, Landroid/content/pm/PackageManager;->getApplicationInfo(Ljava/lang/String;I)Landroid/content/pm/ApplicationInfo;

    move-result-object v0

    .line 610
    .local v0, "ai":Landroid/content/pm/ApplicationInfo;
    iget-object v1, v0, Landroid/content/pm/ApplicationInfo;->metaData:Landroid/os/Bundle;

    .line 612
    .local v1, "b":Landroid/os/Bundle;
    const-string v3, "com.penthera.virtuososdk.client.pckg"

    invoke-virtual {v1, v3}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    iput-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 617
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 618
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "cannot retrieve client. was the metadata for com.penthera.virtuososdk.client.pckg specified in the manifest under application?"

    invoke-direct {v3, v4}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v3

    .line 614
    .end local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .end local v1    # "b":Landroid/os/Bundle;
    :catch_0
    move-exception v2

    .line 615
    .local v2, "e":Ljava/lang/Exception;
    new-instance v3, Ljava/lang/RuntimeException;

    const-string v4, "cannot retrieve authority"

    invoke-direct {v3, v4, v2}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;Ljava/lang/Throwable;)V

    throw v3

    .line 619
    .end local v2    # "e":Ljava/lang/Exception;
    .restart local v0    # "ai":Landroid/content/pm/ApplicationInfo;
    .restart local v1    # "b":Landroid/os/Bundle;
    :cond_0
    new-instance v3, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    invoke-virtual {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->getApplicationContext()Landroid/content/Context;

    move-result-object v4

    invoke-virtual {v4}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v4

    iget-object v5, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;

    invoke-direct {v3, v4, v5}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;-><init>(Landroid/content/ContentResolver;Ljava/lang/String;)V

    iput-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviders:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    .line 620
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviders:Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;

    iget-object v4, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Lcom/penthera/virtuososdk/database/impl/provider/ProvidersInstance;->addProvider(Ljava/lang/String;)Ljava/util/List;

    move-result-object v3

    iput-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iProviderAuthList:Ljava/util/List;

    .line 623
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientDownloadCallbackList:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;

    new-instance v5, Landroid/os/RemoteCallbackList;

    invoke-direct {v5}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 624
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientQueueCallbackList:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;

    new-instance v5, Landroid/os/RemoteCallbackList;

    invoke-direct {v5}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 625
    iget-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iClientEngineCallbackList:Ljava/util/HashMap;

    iget-object v4, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;

    new-instance v5, Landroid/os/RemoteCallbackList;

    invoke-direct {v5}, Landroid/os/RemoteCallbackList;-><init>()V

    invoke-virtual {v3, v4, v5}, Ljava/util/HashMap;->put(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;

    .line 628
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-virtual {v3}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v3

    iput-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iResolver:Landroid/content/ContentResolver;

    .line 629
    invoke-virtual {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    iget-object v4, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iCurrentAuthority:Ljava/lang/String;

    invoke-static {v3, v4}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->getInstance(Landroid/content/Context;Ljava/lang/String;)Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    move-result-object v3

    iput-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    .line 630
    invoke-direct {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->initCellQuotas()V

    .line 632
    invoke-direct {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->registerApiReceiver()V

    .line 634
    const-string v3, "power"

    invoke-virtual {p0, v3}, Lcom/penthera/virtuososdk/service/VirtuosoService;->getSystemService(Ljava/lang/String;)Ljava/lang/Object;

    move-result-object v3

    check-cast v3, Landroid/os/PowerManager;

    iput-object v3, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iPowerManager:Landroid/os/PowerManager;

    .line 638
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v3

    invoke-static {v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Directory;->createRoot(Landroid/content/Context;)Z

    .line 643
    return-void
.end method

.method public onDestroy()V
    .locals 2

    .prologue
    .line 648
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v1, "onDestroy(): Entering the onDestroy method"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 649
    invoke-direct {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->unregisterApiReceiver()V

    .line 650
    iget-object v0, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iDownloaderClientManager:Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;

    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/DownloadEngineClientManager;->release()V

    .line 651
    invoke-super {p0}, Landroid/app/Service;->onDestroy()V

    .line 652
    return-void
.end method

.method public onLowMemory()V
    .locals 2

    .prologue
    .line 678
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v1, "Service: OnLowMemory()"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 679
    invoke-super {p0}, Landroid/app/Service;->onLowMemory()V

    .line 680
    return-void
.end method

.method public onRebind(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 691
    sget-object v0, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v1, "onRebind"

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 692
    invoke-super {p0, p1}, Landroid/app/Service;->onRebind(Landroid/content/Intent;)V

    .line 693
    return-void
.end method

.method public onStart(Landroid/content/Intent;I)V
    .locals 5
    .param p1, "intent"    # Landroid/content/Intent;
    .param p2, "startId"    # I

    .prologue
    .line 701
    sget-object v2, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v3, "onStart(): Entering the onStart method"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 702
    const/4 v2, 0x1

    iput-boolean v2, p0, Lcom/penthera/virtuososdk/service/VirtuosoService;->iServiceStarted:Z

    .line 704
    if-nez p1, :cond_1

    .line 705
    sget-object v2, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v3, "c): Intent is null: not starting service"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 730
    :cond_0
    :goto_0
    return-void

    .line 709
    :cond_1
    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 710
    .local v0, "action":Ljava/lang/String;
    if-nez v0, :cond_2

    .line 711
    sget-object v2, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v3, "onStart(): No Action: not starting service"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0

    .line 715
    :cond_2
    sget-object v2, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "onStart(): action is "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 717
    const-string v2, "virtuoso.intent.action.START_VIRTUOSO_SERVICE_LOGGING"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_3

    .line 718
    sget-object v2, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    const-string v3, "setting log level"

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 720
    invoke-virtual {p1}, Landroid/content/Intent;->getExtras()Landroid/os/Bundle;

    move-result-object v2

    const-string v3, "loglevel"

    const/4 v4, 0x0

    invoke-virtual {v2, v3, v4}, Landroid/os/Bundle;->getInt(Ljava/lang/String;I)I

    move-result v1

    .line 721
    .local v1, "level":I
    sput v1, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->iLogLevel:I

    .line 722
    sget-object v2, Lcom/penthera/virtuososdk/service/VirtuosoService;->LOG_TAG:Ljava/lang/String;

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "setting log level to "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->a(Ljava/lang/String;Ljava/lang/String;)V

    .line 725
    .end local v1    # "level":I
    :cond_3
    const-string v2, "android.intent.action.BOOT_COMPLETED"

    invoke-virtual {v0, v2}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v2

    if-eqz v2, :cond_0

    invoke-direct {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->isServiceThreadAlive()Z

    move-result v2

    if-nez v2, :cond_0

    .line 727
    invoke-direct {p0}, Lcom/penthera/virtuososdk/service/VirtuosoService;->startServiceThread()Z

    goto :goto_0
.end method

.method public onUnbind(Landroid/content/Intent;)Z
    .locals 1
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 685
    const/4 v0, 0x0

    return v0
.end method
