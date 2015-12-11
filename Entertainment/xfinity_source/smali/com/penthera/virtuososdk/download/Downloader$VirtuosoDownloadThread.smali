.class Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;
.super Ljava/lang/Thread;
.source "Downloader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/penthera/virtuososdk/download/Downloader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "VirtuosoDownloadThread"
.end annotation

.annotation system Ldalvik/annotation/MemberClasses;
    value = {
        Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;
    }
.end annotation


# static fields
.field private static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission:[I

.field private static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion:[I


# instance fields
.field private client:Lorg/apache/http/client/HttpClient;

.field private completionLock:Ljava/lang/Object;

.field private iDiscoveredContentType:Ljava/lang/String;

.field private iDownloadStartTime:J

.field private iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

.field private iHlsReportedComplete:Z

.field private iLastUpdateTime:J

.field private iMinimumUpdateInterval:J

.field private killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

.field private killed:Z

.field private mHlsLock:Ljava/lang/Object;

.field private pauseAfterRemove:Z

.field private removeAfterPause:Z

.field final synthetic this$0:Lcom/penthera/virtuososdk/download/Downloader;


# direct methods
.method static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()[I
    .locals 3

    .prologue
    .line 909
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission:[I

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
    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission:[I

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

.method static synthetic $SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()[I
    .locals 3

    .prologue
    .line 909
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion:[I

    if-eqz v0, :cond_0

    :goto_0
    return-object v0

    :cond_0
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->values()[Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v0

    array-length v0, v0

    new-array v0, v0, [I

    :try_start_0
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0x13

    aput v2, v0, v1
    :try_end_0
    .catch Ljava/lang/NoSuchFieldError; {:try_start_0 .. :try_end_0} :catch_13

    :goto_1
    :try_start_1
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/4 v2, 0x4

    aput v2, v0, v1
    :try_end_1
    .catch Ljava/lang/NoSuchFieldError; {:try_start_1 .. :try_end_1} :catch_12

    :goto_2
    :try_start_2
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/4 v2, 0x2

    aput v2, v0, v1
    :try_end_2
    .catch Ljava/lang/NoSuchFieldError; {:try_start_2 .. :try_end_2} :catch_11

    :goto_3
    :try_start_3
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0xe

    aput v2, v0, v1
    :try_end_3
    .catch Ljava/lang/NoSuchFieldError; {:try_start_3 .. :try_end_3} :catch_10

    :goto_4
    :try_start_4
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFile:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0x9

    aput v2, v0, v1
    :try_end_4
    .catch Ljava/lang/NoSuchFieldError; {:try_start_4 .. :try_end_4} :catch_f

    :goto_5
    :try_start_5
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileCorrupt:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0xc

    aput v2, v0, v1
    :try_end_5
    .catch Ljava/lang/NoSuchFieldError; {:try_start_5 .. :try_end_5} :catch_e

    :goto_6
    :try_start_6
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0xb

    aput v2, v0, v1
    :try_end_6
    .catch Ljava/lang/NoSuchFieldError; {:try_start_6 .. :try_end_6} :catch_d

    :goto_7
    :try_start_7
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0xa

    aput v2, v0, v1
    :try_end_7
    .catch Ljava/lang/NoSuchFieldError; {:try_start_7 .. :try_end_7} :catch_c

    :goto_8
    :try_start_8
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/4 v2, 0x7

    aput v2, v0, v1
    :try_end_8
    .catch Ljava/lang/NoSuchFieldError; {:try_start_8 .. :try_end_8} :catch_b

    :goto_9
    :try_start_9
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0x8

    aput v2, v0, v1
    :try_end_9
    .catch Ljava/lang/NoSuchFieldError; {:try_start_9 .. :try_end_9} :catch_a

    :goto_a
    :try_start_a
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorsMaxed:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0xd

    aput v2, v0, v1
    :try_end_a
    .catch Ljava/lang/NoSuchFieldError; {:try_start_a .. :try_end_a} :catch_9

    :goto_b
    :try_start_b
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/4 v2, 0x5

    aput v2, v0, v1
    :try_end_b
    .catch Ljava/lang/NoSuchFieldError; {:try_start_b .. :try_end_b} :catch_8

    :goto_c
    :try_start_c
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/4 v2, 0x3

    aput v2, v0, v1
    :try_end_c
    .catch Ljava/lang/NoSuchFieldError; {:try_start_c .. :try_end_c} :catch_7

    :goto_d
    :try_start_d
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/4 v2, 0x6

    aput v2, v0, v1
    :try_end_d
    .catch Ljava/lang/NoSuchFieldError; {:try_start_d .. :try_end_d} :catch_6

    :goto_e
    :try_start_e
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedUnknown:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0xf

    aput v2, v0, v1
    :try_end_e
    .catch Ljava/lang/NoSuchFieldError; {:try_start_e .. :try_end_e} :catch_5

    :goto_f
    :try_start_f
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/4 v2, 0x1

    aput v2, v0, v1
    :try_end_f
    .catch Ljava/lang/NoSuchFieldError; {:try_start_f .. :try_end_f} :catch_4

    :goto_10
    :try_start_10
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0x12

    aput v2, v0, v1
    :try_end_10
    .catch Ljava/lang/NoSuchFieldError; {:try_start_10 .. :try_end_10} :catch_3

    :goto_11
    :try_start_11
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0x11

    aput v2, v0, v1
    :try_end_11
    .catch Ljava/lang/NoSuchFieldError; {:try_start_11 .. :try_end_11} :catch_2

    :goto_12
    :try_start_12
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadPriorityChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0x10

    aput v2, v0, v1
    :try_end_12
    .catch Ljava/lang/NoSuchFieldError; {:try_start_12 .. :try_end_12} :catch_1

    :goto_13
    :try_start_13
    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    const/16 v2, 0x14

    aput v2, v0, v1
    :try_end_13
    .catch Ljava/lang/NoSuchFieldError; {:try_start_13 .. :try_end_13} :catch_0

    :goto_14
    sput-object v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion:[I

    goto/16 :goto_0

    :catch_0
    move-exception v1

    goto :goto_14

    :catch_1
    move-exception v1

    goto :goto_13

    :catch_2
    move-exception v1

    goto :goto_12

    :catch_3
    move-exception v1

    goto :goto_11

    :catch_4
    move-exception v1

    goto :goto_10

    :catch_5
    move-exception v1

    goto :goto_f

    :catch_6
    move-exception v1

    goto :goto_e

    :catch_7
    move-exception v1

    goto :goto_d

    :catch_8
    move-exception v1

    goto :goto_c

    :catch_9
    move-exception v1

    goto :goto_b

    :catch_a
    move-exception v1

    goto :goto_a

    :catch_b
    move-exception v1

    goto/16 :goto_9

    :catch_c
    move-exception v1

    goto/16 :goto_8

    :catch_d
    move-exception v1

    goto/16 :goto_7

    :catch_e
    move-exception v1

    goto/16 :goto_6

    :catch_f
    move-exception v1

    goto/16 :goto_5

    :catch_10
    move-exception v1

    goto/16 :goto_4

    :catch_11
    move-exception v1

    goto/16 :goto_3

    :catch_12
    move-exception v1

    goto/16 :goto_2

    :catch_13
    move-exception v1

    goto/16 :goto_1
.end method

.method constructor <init>(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V
    .locals 6
    .param p2, "file"    # Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .prologue
    const-wide/16 v4, 0x0

    const/4 v2, 0x0

    .line 933
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    .line 934
    new-instance v0, Ljava/lang/StringBuilder;

    const-string v1, "VirtuosoDownloadThread-"

    invoke-direct {v0, v1}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-interface {p2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    invoke-direct {p0, v0}, Ljava/lang/Thread;-><init>(Ljava/lang/String;)V

    .line 911
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;

    .line 912
    iput-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iDownloadStartTime:J

    .line 921
    iput-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iLastUpdateTime:J

    .line 922
    const-wide/16 v0, 0x3e8

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iMinimumUpdateInterval:J

    .line 940
    new-instance v0, Ljava/lang/Object;

    invoke-direct {v0}, Ljava/lang/Object;-><init>()V

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->completionLock:Ljava/lang/Object;

    .line 1440
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z

    .line 1441
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iHlsReportedComplete:Z

    .line 1442
    const/4 v0, 0x0

    iput-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1444
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->pauseAfterRemove:Z

    .line 1445
    iput-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->removeAfterPause:Z

    .line 938
    iput-object p2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 939
    return-void
.end method

.method private HandleCompletion(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V
    .locals 3
    .param p1, "aCompletionReason"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .prologue
    .line 1200
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 1201
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-direct {p0, p1, v0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->HandleFileCompletion(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;)V

    .line 1207
    :goto_0
    return-void

    .line 1202
    :cond_0
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v0

    const/4 v1, 0x4

    if-ne v0, v1, :cond_1

    .line 1203
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    invoke-direct {p0, p1, v0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->HandleFileCompletion(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;)V

    goto :goto_0

    .line 1205
    :cond_1
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v0

    new-instance v1, Ljava/lang/StringBuilder;

    const-string v2, "c[ "

    invoke-direct {v1, v2}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v2, v2, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] HandleCompletion invalid contentType"

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "["

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v2

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v1

    const-string v2, "] completion reason -> "

    invoke-virtual {v1, v2}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v1

    invoke-virtual {v1}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private HandleFileCompletion(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;)V
    .locals 20
    .param p1, "aCompletionReason"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .param p2, "aFile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    .prologue
    .line 1209
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->completionLock:Ljava/lang/Object;

    monitor-enter v15

    .line 1210
    :try_start_0
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "c[ "

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "] HandleFileCompletion: url -> "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->assetURL()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " uuid -> "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->uuid()Ljava/lang/String;

    move-result-object v17

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, " Reason -> "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    move-object/from16 v0, v16

    move-object/from16 v1, p1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1211
    const/4 v14, 0x1

    move-object/from16 v0, p0

    iput-boolean v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iHlsReportedComplete:Z

    .line 1212
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()[I

    move-result-object v14

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    aget v14, v14, v16

    packed-switch v14, :pswitch_data_0

    .line 1209
    :cond_0
    :goto_0
    monitor-exit v15

    .line 1438
    return-void

    .line 1219
    :pswitch_0
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-object/from16 v0, p1

    if-ne v0, v14, :cond_1

    .line 1220
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    const-string v16, "Expired File should not have appeared in the downloader - marking as complete"

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1223
    :cond_1
    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v5

    .line 1224
    .local v5, "fp":Ljava/lang/String;
    const-string v14, "."

    invoke-virtual {v5, v14}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v6

    .line 1225
    .local v6, "idx":I
    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/String;->length()I

    move-result v14

    sub-int v6, v14, v6

    .line 1226
    const/4 v14, 0x5

    if-gt v6, v14, :cond_2

    const/4 v14, 0x2

    if-ge v6, v14, :cond_4

    .line 1228
    :cond_2
    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->mimeType()Ljava/lang/String;

    move-result-object v4

    .line 1229
    .local v4, "fileMime":Ljava/lang/String;
    invoke-static {v4}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-eqz v14, :cond_3

    .line 1230
    move-object/from16 v0, p0

    iget-object v4, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iDiscoveredContentType:Ljava/lang/String;

    .line 1232
    :cond_3
    invoke-static {v4}, Lcom/penthera/virtuososdk/utility/CommonUtil;->mimeTypeToExtension(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v11

    .line 1233
    .local v11, "s":Ljava/lang/String;
    invoke-static {v11}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_4

    .line 1234
    new-instance v14, Ljava/lang/StringBuilder;

    invoke-static {v5}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-direct {v14, v0}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v16, "."

    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v14

    invoke-virtual {v14}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v11

    .line 1235
    move-object/from16 v0, p2

    invoke-interface {v0, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setFilePath(Ljava/lang/String;)V

    .line 1236
    new-instance v3, Ljava/io/File;

    invoke-direct {v3, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1237
    .local v3, "f":Ljava/io/File;
    new-instance v10, Ljava/io/File;

    invoke-direct {v10, v11}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 1238
    .local v10, "rf":Ljava/io/File;
    invoke-virtual {v3, v10}, Ljava/io/File;->renameTo(Ljava/io/File;)Z

    .line 1242
    .end local v3    # "f":Ljava/io/File;
    .end local v4    # "fileMime":Ljava/lang/String;
    .end local v10    # "rf":Ljava/io/File;
    .end local v11    # "s":Ljava/lang/String;
    :cond_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$2(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1243
    const/4 v14, 0x0

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setPending(Z)V

    .line 1244
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-object/from16 v0, p1

    if-ne v0, v14, :cond_6

    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    :goto_1
    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1245
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v16, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadEnd:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v17, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->sendBroadcastForDownloadUpdate(Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v14, v0, v1}, Lcom/penthera/virtuososdk/download/Downloader;->access$3(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1246
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->removeAfterPause:Z

    if-nez v14, :cond_5

    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->pauseAfterRemove:Z

    if-eqz v14, :cond_7

    .line 1247
    :cond_5
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 1248
    .local v9, "pextras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v9, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1249
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v16, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v16

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v14, v0, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1209
    .end local v5    # "fp":Ljava/lang/String;
    .end local v6    # "idx":I
    .end local v9    # "pextras":Landroid/os/Bundle;
    :catchall_0
    move-exception v14

    monitor-exit v15
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v14

    .line 1244
    .restart local v5    # "fp":Ljava/lang/String;
    .restart local v6    # "idx":I
    :cond_6
    :try_start_1
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_1

    .line 1252
    :cond_7
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$5(Lcom/penthera/virtuososdk/download/Downloader;)V

    goto/16 :goto_0

    .line 1258
    .end local v5    # "fp":Ljava/lang/String;
    .end local v6    # "idx":I
    :pswitch_1
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1259
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1260
    .local v2, "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1261
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1262
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v16, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v16

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v14, v0, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    .line 1265
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-boolean v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    if-eqz v14, :cond_0

    .line 1266
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move/from16 v0, v16

    iput-boolean v0, v14, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    .line 1268
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v14

    sget-object v16, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-object/from16 v0, v16

    if-ne v14, v0, :cond_0

    .line 1269
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    goto/16 :goto_0

    .line 1277
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_2
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1278
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1279
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1280
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1281
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v16, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v16

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v14, v0, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1293
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_3
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$6(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/content/Context;

    move-result-object v14

    invoke-virtual {v14}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v17, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-static {v14, v0, v1}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v12

    .line 1294
    .local v12, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    const/4 v7, 0x0

    .line 1295
    .local v7, "marked_for_delete":Z
    if-eqz v12, :cond_8

    .line 1296
    move-object v0, v12

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    move-object v13, v0

    .line 1297
    .local v13, "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    invoke-interface {v13}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->getContentState()I

    move-result v14

    const/16 v16, 0x1

    move/from16 v0, v16

    if-ne v14, v0, :cond_9

    const/4 v7, 0x1

    .line 1299
    .end local v13    # "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    :cond_8
    :goto_2
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$7(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1300
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$8(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1301
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$2(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1302
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1303
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1304
    if-eqz v7, :cond_a

    .line 1305
    const-string v14, "failure_reason"

    sget-object v16, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1306
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    sget-object v17, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-interface {v14, v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1307
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v16, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v16

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$10(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    goto/16 :goto_0

    .line 1297
    .end local v2    # "extras":Landroid/os/Bundle;
    .restart local v13    # "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    :cond_9
    const/4 v7, 0x0

    goto :goto_2

    .line 1309
    .end local v13    # "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    .restart local v2    # "extras":Landroid/os/Bundle;
    :cond_a
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1310
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1311
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v16, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v16

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v14, v0, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1318
    .end local v2    # "extras":Landroid/os/Bundle;
    .end local v7    # "marked_for_delete":Z
    .end local v12    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :pswitch_4
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1319
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1320
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1321
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1322
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v14, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1328
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_5
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1329
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1330
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1331
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1332
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v14, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1335
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-boolean v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iConnChangeResumePending:Z

    if-eqz v14, :cond_b

    .line 1336
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move/from16 v0, v16

    iput-boolean v0, v14, Lcom/penthera/virtuososdk/download/Downloader;->iConnChangeResumePending:Z

    .line 1337
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v14

    sget-object v16, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-object/from16 v0, v16

    if-ne v14, v0, :cond_0

    .line 1338
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    goto/16 :goto_0

    .line 1341
    :cond_b
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    const-string v16, "requesting wifi reset on eng file"

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1342
    const-string v14, "virtuoso.intent.action.WIFI_RESET"

    invoke-static {v14}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1347
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_6
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1348
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1349
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1350
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1351
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v14, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1356
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_7
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1357
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1358
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1359
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1360
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v14, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1365
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_8
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1366
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1367
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1368
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1369
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v14, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1374
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_9
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1375
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1376
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1377
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1378
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v14, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1383
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_a
    sget-object v14, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p0

    invoke-direct {v0, v14}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1384
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1385
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1387
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-interface {v14, v0, v2}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->saveFileState(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1388
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    sget-object v16, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v16

    iput-object v0, v14, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 1390
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v14

    if-eqz v14, :cond_0

    .line 1391
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v14

    const-string v16, "download_file_data"

    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v8

    .line 1392
    .local v8, "p":Landroid/os/Parcelable;
    move-object v0, v8

    check-cast v0, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object v14, v0

    invoke-interface {v14}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_e

    .line 1394
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "c[ "

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "] same file replacing prioirty bundled file"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1397
    move-object v0, v8

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object v14, v0

    invoke-interface {v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v14

    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_c

    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->currentSize()D

    move-result-wide v16

    const-wide/16 v18, 0x0

    cmpl-double v14, v16, v18

    if-nez v14, :cond_c

    .line 1398
    move-object v0, v8

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object v14, v0

    invoke-interface {v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setFilePath(Ljava/lang/String;)V

    .line 1400
    :cond_c
    move-object v0, v8

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object v14, v0

    invoke-interface {v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->metadata()Ljava/lang/String;

    move-result-object v14

    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->metadata()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v14

    if-nez v14, :cond_d

    .line 1401
    check-cast v8, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    .end local v8    # "p":Landroid/os/Parcelable;
    invoke-interface {v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->metadata()Ljava/lang/String;

    move-result-object v14

    move-object/from16 v0, p2

    invoke-interface {v0, v14}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMetadata(Ljava/lang/String;)V

    .line 1404
    :cond_d
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v14

    const-string v16, "download_file_data"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v17, v0

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-virtual {v14, v0, v1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1406
    :cond_e
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-virtual {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->NewItem(Landroid/os/Bundle;)V

    .line 1407
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$7(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1408
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$8(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    goto/16 :goto_0

    .line 1414
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_b
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$7(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1415
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$8(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1416
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/16 v16, 0x0

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$2(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1417
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    if-nez v14, :cond_f

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "c[ "

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "] iFile is NULL!!"

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v14, v0}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1418
    :cond_f
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1419
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v14, "virtuoso_file"

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1420
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v2, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1421
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v14

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    sget-object v17, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    move-object/from16 v0, v16

    move-object/from16 v1, v17

    invoke-interface {v14, v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1423
    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->removeAfterPause:Z

    if-nez v14, :cond_10

    move-object/from16 v0, p0

    iget-boolean v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->pauseAfterRemove:Z

    if-eqz v14, :cond_11

    .line 1424
    :cond_10
    new-instance v9, Landroid/os/Bundle;

    invoke-direct {v9}, Landroid/os/Bundle;-><init>()V

    .line 1425
    .restart local v9    # "pextras":Landroid/os/Bundle;
    const-string v14, "failure_reason"

    invoke-virtual/range {p1 .. p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v16

    move/from16 v0, v16

    invoke-virtual {v9, v14, v0}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1426
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v16, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    move-object/from16 v0, v16

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v14, v0, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1429
    .end local v9    # "pextras":Landroid/os/Bundle;
    :cond_11
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$5(Lcom/penthera/virtuososdk/download/Downloader;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 1212
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_1
        :pswitch_2
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_9
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_5
        :pswitch_0
        :pswitch_2
        :pswitch_a
        :pswitch_b
        :pswitch_0
    .end packed-switch
.end method

.method private HandleFileCompletion(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;)V
    .locals 14
    .param p1, "aCompletionReason"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .param p2, "aFile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    .prologue
    const/4 v8, 0x1

    const/4 v9, 0x0

    .line 944
    iget-object v10, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->completionLock:Ljava/lang/Object;

    monitor-enter v10

    .line 945
    :try_start_0
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v11

    new-instance v12, Ljava/lang/StringBuilder;

    const-string v13, "c[ "

    invoke-direct {v12, v13}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v13, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v13, v13, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, "] HandleFileCompletion (HLS): url -> "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->assetURL()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " uuid -> "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->uuid()Ljava/lang/String;

    move-result-object v13

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    const-string v13, " Reason -> "

    invoke-virtual {v12, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v12

    invoke-virtual {v12}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v12

    invoke-static {v11, v12}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 946
    const/4 v11, 0x1

    iput-boolean v11, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iHlsReportedComplete:Z

    .line 947
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()[I

    move-result-object v11

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v12

    aget v11, v11, v12

    packed-switch v11, :pswitch_data_0

    .line 944
    :cond_0
    :goto_0
    monitor-exit v10

    .line 1152
    return-void

    .line 954
    :pswitch_0
    sget-object v8, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne p1, v8, :cond_1

    .line 955
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v8

    const-string v9, "Expired File should not have appeared in the downloader - marking as complete"

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 957
    :cond_1
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$2(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 958
    const/4 v8, 0x0

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setPending(Z)V

    .line 959
    sget-object v8, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne p1, v8, :cond_3

    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    :goto_1
    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 960
    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->expectedSize()D

    move-result-wide v8

    move-object/from16 v0, p2

    invoke-interface {v0, v8, v9}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setCurrentSize(D)V

    .line 961
    invoke-interface/range {p2 .. p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->totalFragments()I

    move-result v8

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setCompletedCount(I)V

    .line 962
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v9, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadEnd:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    iget-object v11, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->sendBroadcastForDownloadUpdate(Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v8, v9, v11}, Lcom/penthera/virtuososdk/download/Downloader;->access$3(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 963
    iget-boolean v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->removeAfterPause:Z

    if-nez v8, :cond_2

    iget-boolean v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->pauseAfterRemove:Z

    if-eqz v8, :cond_4

    .line 964
    :cond_2
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 965
    .local v5, "pextras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v5, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 966
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v9, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v8, v9, v5}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto :goto_0

    .line 944
    .end local v5    # "pextras":Landroid/os/Bundle;
    :catchall_0
    move-exception v8

    monitor-exit v10
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    throw v8

    .line 959
    :cond_3
    :try_start_1
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_1

    .line 969
    :cond_4
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$5(Lcom/penthera/virtuososdk/download/Downloader;)V

    goto :goto_0

    .line 974
    :pswitch_1
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-direct {p0, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 975
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 976
    .local v2, "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 977
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 978
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v9, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v8, v9, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    .line 981
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-boolean v8, v8, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    if-eqz v8, :cond_0

    .line 982
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    iput-boolean v9, v8, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    .line 984
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v8

    sget-object v9, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    if-ne v8, v9, :cond_0

    .line 985
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    goto/16 :goto_0

    .line 993
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_2
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-direct {p0, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 994
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 995
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 996
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 997
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v9, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Blocked:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v8, v9, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1009
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_3
    iget-object v11, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;
    invoke-static {v11}, Lcom/penthera/virtuososdk/download/Downloader;->access$6(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/content/Context;

    move-result-object v11

    invoke-virtual {v11}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v11

    iget-object v12, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v12}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v12

    iget-object v13, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v13, v13, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v11, v12, v13}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v6

    .line 1010
    .local v6, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    const/4 v3, 0x0

    .line 1011
    .local v3, "marked_for_delete":Z
    if-eqz v6, :cond_5

    .line 1012
    move-object v0, v6

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    move-object v7, v0

    .line 1013
    .local v7, "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    invoke-interface {v7}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->getContentState()I

    move-result v11

    if-ne v11, v8, :cond_6

    move v3, v8

    .line 1015
    .end local v7    # "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    :cond_5
    :goto_2
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$7(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1016
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$8(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1017
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$2(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1018
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1019
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1020
    if-eqz v3, :cond_7

    .line 1021
    const-string v8, "failure_reason"

    sget-object v9, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1022
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v8

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v11, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-interface {v8, v9, v11, v2}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1024
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v9, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$10(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    goto/16 :goto_0

    .end local v2    # "extras":Landroid/os/Bundle;
    .restart local v7    # "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    :cond_6
    move v3, v9

    .line 1013
    goto :goto_2

    .line 1026
    .end local v7    # "vieng":Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;
    .restart local v2    # "extras":Landroid/os/Bundle;
    :cond_7
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-direct {p0, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1027
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1028
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v9, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v8, v9, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1036
    .end local v2    # "extras":Landroid/os/Bundle;
    .end local v3    # "marked_for_delete":Z
    .end local v6    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :pswitch_4
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1037
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1038
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1039
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1040
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v8, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1046
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_5
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1047
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1048
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1049
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1050
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v8, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1052
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-boolean v8, v8, Lcom/penthera/virtuososdk/download/Downloader;->iConnChangeResumePending:Z

    if-eqz v8, :cond_8

    .line 1053
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    iput-boolean v9, v8, Lcom/penthera/virtuososdk/download/Downloader;->iConnChangeResumePending:Z

    .line 1054
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v8

    sget-object v9, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    if-ne v8, v9, :cond_0

    .line 1055
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v8}, Lcom/penthera/virtuososdk/download/Downloader;->Resume()V

    goto/16 :goto_0

    .line 1058
    :cond_8
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v8

    const-string v9, "requesting wifi reset"

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1059
    const-string v8, "virtuoso.intent.action.WIFI_RESET"

    invoke-static {v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendLocalBroadcast(Ljava/lang/String;)V

    goto/16 :goto_0

    .line 1065
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_6
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1066
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1067
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1068
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1069
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v8, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1074
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_7
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1075
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1076
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1077
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1078
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v8, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1083
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_8
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1084
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1085
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1086
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1087
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v8, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1092
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_9
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-object/from16 v0, p2

    invoke-interface {v0, v8}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1093
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1094
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1095
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1096
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->reportErrorStatus(Landroid/os/Bundle;)V
    invoke-static {v8, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$11(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1101
    .end local v2    # "extras":Landroid/os/Bundle;
    :pswitch_a
    sget-object v8, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-direct {p0, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1102
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1103
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1104
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v8

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-interface {v8, v9, v2}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->saveFileState(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1105
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v8, v8, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    sget-object v9, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Idle:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    iput-object v9, v8, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    .line 1107
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v8

    if-eqz v8, :cond_0

    .line 1108
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v8

    const-string v9, "download_file_data"

    invoke-virtual {v8, v9}, Landroid/os/Bundle;->getParcelable(Ljava/lang/String;)Landroid/os/Parcelable;

    move-result-object v4

    check-cast v4, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .line 1110
    .local v4, "p":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v9}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-eqz v8, :cond_a

    .line 1112
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v11, "c[ "

    invoke-direct {v9, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v11, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v11, v11, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v11, "] same file replacing prioirty bundled file"

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1115
    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->metadata()Ljava/lang/String;

    move-result-object v8

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v9}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->metadata()Ljava/lang/String;

    move-result-object v9

    invoke-virtual {v8, v9}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v8

    if-nez v8, :cond_9

    .line 1116
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->metadata()Ljava/lang/String;

    move-result-object v9

    invoke-interface {v8, v9}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->setMetadata(Ljava/lang/String;)V

    .line 1119
    :cond_9
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v8

    const-string v9, "download_file_data"

    iget-object v11, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v8, v9, v11}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1121
    :cond_a
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iPriorityDownloadBundle:Landroid/os/Bundle;
    invoke-static {v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$12(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v9

    invoke-virtual {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->NewItem(Landroid/os/Bundle;)V

    .line 1122
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$7(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1123
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$8(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    goto/16 :goto_0

    .line 1129
    .end local v2    # "extras":Landroid/os/Bundle;
    .end local v4    # "p":Lcom/penthera/virtuososdk/client/IVirtuosoAsset;
    :pswitch_b
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$7(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1130
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$8(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1131
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v9, 0x0

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/download/Downloader;->access$2(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/client/IVirtuosoAsset;)V

    .line 1132
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    if-nez v8, :cond_b

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v8

    new-instance v9, Ljava/lang/StringBuilder;

    const-string v11, "c[ "

    invoke-direct {v9, v11}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v11, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v11, v11, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    const-string v11, "] iFile is NULL!!"

    invoke-virtual {v9, v11}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v9

    invoke-virtual {v9}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v9

    invoke-static {v8, v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1133
    :cond_b
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1134
    .restart local v2    # "extras":Landroid/os/Bundle;
    const-string v8, "virtuoso_file"

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1135
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v2, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1136
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v8

    iget-object v9, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v11, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-interface {v8, v9, v11, v2}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1137
    iget-boolean v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->removeAfterPause:Z

    if-nez v8, :cond_c

    iget-boolean v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->pauseAfterRemove:Z

    if-eqz v8, :cond_d

    .line 1138
    :cond_c
    new-instance v5, Landroid/os/Bundle;

    invoke-direct {v5}, Landroid/os/Bundle;-><init>()V

    .line 1139
    .restart local v5    # "pextras":Landroid/os/Bundle;
    const-string v8, "failure_reason"

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v9

    invoke-virtual {v5, v8, v9}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1140
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v9, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Paused:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V
    invoke-static {v8, v9, v5}, Lcom/penthera/virtuososdk/download/Downloader;->access$4(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;Landroid/os/Bundle;)V

    goto/16 :goto_0

    .line 1143
    .end local v5    # "pextras":Landroid/os/Bundle;
    :cond_d
    iget-object v8, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setIdle()V
    invoke-static {v8}, Lcom/penthera/virtuososdk/download/Downloader;->access$5(Lcom/penthera/virtuososdk/download/Downloader;)V
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    goto/16 :goto_0

    .line 947
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_0
        :pswitch_2
        :pswitch_3
        :pswitch_1
        :pswitch_2
        :pswitch_2
        :pswitch_4
        :pswitch_5
        :pswitch_9
        :pswitch_6
        :pswitch_7
        :pswitch_8
        :pswitch_5
        :pswitch_0
        :pswitch_2
        :pswitch_a
        :pswitch_b
        :pswitch_0
    .end packed-switch
.end method

.method static synthetic access$0(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Ljava/lang/Object;
    .locals 1

    .prologue
    .line 911
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;

    return-object v0
.end method

.method static synthetic access$1(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Z
    .locals 1

    .prologue
    .line 1440
    iget-boolean v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z

    return v0
.end method

.method static synthetic access$2(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 1

    .prologue
    .line 1442
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    return-object v0
.end method

.method static synthetic access$3(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 1
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1929
    invoke-direct {p0, p1, p2, p3, p4}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadFragment(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$4(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    .locals 1

    .prologue
    .line 1154
    invoke-direct {p0, p1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->completionToState(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v0

    return-object v0
.end method

.method static synthetic access$5(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V
    .locals 0

    .prologue
    .line 1889
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->reportFragmentComplete(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V

    return-void
.end method

.method static synthetic access$8(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;)Lcom/penthera/virtuososdk/download/Downloader;
    .locals 1

    .prologue
    .line 909
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    return-object v0
.end method

.method private addClientConfiguredHeaders(Lorg/apache/http/client/methods/HttpGet;)V
    .locals 4
    .param p1, "aMethod"    # Lorg/apache/http/client/methods/HttpGet;

    .prologue
    .line 1921
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iClientConfiguredHeaders:Landroid/os/Bundle;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$17(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v2

    if-eqz v2, :cond_0

    .line 1922
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iClientConfiguredHeaders:Landroid/os/Bundle;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$17(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v2

    invoke-virtual {v2}, Landroid/os/Bundle;->keySet()Ljava/util/Set;

    move-result-object v1

    .line 1923
    .local v1, "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    invoke-interface {v1}, Ljava/util/Set;->iterator()Ljava/util/Iterator;

    move-result-object v2

    :goto_0
    invoke-interface {v2}, Ljava/util/Iterator;->hasNext()Z

    move-result v3

    if-nez v3, :cond_1

    .line 1927
    .end local v1    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_0
    return-void

    .line 1923
    .restart local v1    # "keys":Ljava/util/Set;, "Ljava/util/Set<Ljava/lang/String;>;"
    :cond_1
    invoke-interface {v2}, Ljava/util/Iterator;->next()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, Ljava/lang/String;

    .line 1924
    .local v0, "key":Ljava/lang/String;
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iClientConfiguredHeaders:Landroid/os/Bundle;
    invoke-static {v3}, Lcom/penthera/virtuososdk/download/Downloader;->access$17(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v3

    invoke-virtual {v3, v0}, Landroid/os/Bundle;->getString(Ljava/lang/String;)Ljava/lang/String;

    move-result-object v3

    invoke-virtual {p1, v0, v3}, Lorg/apache/http/client/methods/HttpGet;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    goto :goto_0
.end method

.method private completionToState(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;
    .locals 2
    .param p1, "aCompletionReason"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .prologue
    .line 1155
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$utility$CommonUtil$EFileDownloadCompletion()[I

    move-result-object v0

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1195
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    :goto_0
    return-object v0

    .line 1158
    :pswitch_0
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1160
    :pswitch_1
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->KvDE_Download_Complete:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1169
    :pswitch_2
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1173
    :pswitch_3
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Reachability_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1177
    :pswitch_4
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Network_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1180
    :pswitch_5
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Mime_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1183
    :pswitch_6
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Size_Mismatch:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1186
    :pswitch_7
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Corrupt:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1190
    :pswitch_8
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_File_Copy_Error:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1193
    :pswitch_9
    sget-object v0, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Download_Pending:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    goto :goto_0

    .line 1155
    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_1
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_8
        :pswitch_5
        :pswitch_6
        :pswitch_7
        :pswitch_4
        :pswitch_0
        :pswitch_2
        :pswitch_9
        :pswitch_8
        :pswitch_0
        :pswitch_2
    .end packed-switch
.end method

.method private downloadFragment(Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 25
    .param p1, "aFrag"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    .param p2, "connectionType"    # I
    .param p3, "eventBearerType"    # Ljava/lang/String;
    .param p4, "aClient"    # Lorg/apache/http/client/HttpClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1930
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] downloadFragment(HLS): url -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->remotePath()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " id -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->id()I

    move-result v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1933
    const/16 v18, 0x0

    .line 1934
    .local v18, "file":Ljava/io/File;
    const-wide/16 v16, 0x0

    .line 1935
    .local v16, "existingBytes":J
    sget-object v24, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1936
    .local v24, "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    const/4 v4, 0x0

    .line 1939
    .local v4, "downloadLoggedStarted":Z
    :try_start_0
    new-instance v9, Ljava/io/File;

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->filePath()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v9, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1940
    .end local v18    # "file":Ljava/io/File;
    .local v9, "file":Ljava/io/File;
    :try_start_1
    new-instance v6, Lorg/apache/http/client/methods/HttpGet;

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->remotePath()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 1941
    .local v6, "method":Lorg/apache/http/client/methods/HttpGet;
    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->addClientConfiguredHeaders(Lorg/apache/http/client/methods/HttpGet;)V

    .line 1943
    invoke-static {v9}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileHelpers;->getFileSize(Ljava/io/File;)J

    move-result-wide v16

    .line 1944
    const-wide/16 v10, 0x0

    cmp-long v5, v16, v10

    if-lez v5, :cond_2

    .line 1946
    move-wide/from16 v0, v16

    long-to-double v10, v0

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->expectedSize()D

    move-result-wide v12

    cmpl-double v5, v10, v12

    if-nez v5, :cond_1

    .line 1948
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] File already full downloaded: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v9}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1949
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 2011
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .local v14, "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_0

    .line 2014
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_0
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2019
    :goto_0
    return-object v5

    .line 1951
    .end local v14    # "bytesRead":J
    :cond_1
    :try_start_2
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v7, "bytes="

    invoke-direct {v5, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    invoke-virtual {v5, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, "-"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v20

    .line 1952
    .local v20, "range":Ljava/lang/String;
    const-string v5, "Range"

    move-object/from16 v0, v20

    invoke-virtual {v6, v5, v0}, Lorg/apache/http/client/methods/HttpGet;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 1954
    .end local v20    # "range":Ljava/lang/String;
    :cond_2
    move-object/from16 v0, p4

    invoke-interface {v0, v6}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v8

    .line 1957
    .local v8, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v21

    .line 1959
    .local v21, "retCode":I
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "Http response for download: "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move/from16 v0, v21

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1960
    const/16 v5, 0x1f4

    move/from16 v0, v21

    if-lt v0, v5, :cond_4

    .line 1961
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] HTTP Server error: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static/range {v21 .. v21}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1962
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2011
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_3

    .line 2014
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_3
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    goto/16 :goto_0

    .line 1963
    .end local v14    # "bytesRead":J
    :cond_4
    const/16 v5, 0xc8

    move/from16 v0, v21

    if-lt v0, v5, :cond_5

    const/16 v5, 0x12c

    move/from16 v0, v21

    if-lt v0, v5, :cond_a

    .line 1964
    :cond_5
    :try_start_3
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] HTTP other error: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v21

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1965
    const/16 v5, 0x1a0

    move/from16 v0, v21

    if-ne v0, v5, :cond_8

    .line 1966
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_6

    .line 1967
    invoke-virtual {v9}, Ljava/io/File;->delete()Z

    .line 1968
    const-wide/16 v10, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v10, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setCurrentSize(D)V

    .line 1970
    :cond_6
    invoke-virtual {v6}, Lorg/apache/http/client/methods/HttpGet;->abort()V

    .line 1971
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2011
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_7

    .line 2014
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_7
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    goto/16 :goto_0

    .line 1973
    .end local v14    # "bytesRead":J
    :cond_8
    :try_start_4
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 2011
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_9

    .line 2014
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_9
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    goto/16 :goto_0

    .line 1976
    .end local v14    # "bytesRead":J
    :cond_a
    :try_start_5
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v5

    invoke-static {v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$HttpUtils;->dumpHeaders([Lorg/apache/http/Header;)V

    .line 1977
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v19

    .line 1979
    .local v19, "h":[Lorg/apache/http/Header;
    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->getMimetypeFromHeaders([Lorg/apache/http/Header;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->validFragmentMimeType(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_c

    .line 1980
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 2011
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_b

    .line 2014
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_b
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    goto/16 :goto_0

    .line 1983
    .end local v14    # "bytesRead":J
    :cond_c
    :try_start_6
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    move-object/from16 v0, p0

    move-object/from16 v1, v19

    invoke-direct {v0, v1, v10, v11}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->getFileSizeFromHeaders([Lorg/apache/http/Header;J)D

    move-result-wide v22

    .line 1984
    .local v22, "reported_size":D
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->expectedSize()D

    move-result-wide v10

    const-wide/high16 v12, -0x4010000000000000L    # -1.0

    cmpl-double v5, v10, v12

    if-lez v5, :cond_f

    .line 1985
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->expectedSize()D

    move-result-wide v10

    cmpl-double v5, v22, v10

    if-eqz v5, :cond_10

    .line 1986
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_d

    .line 1987
    invoke-virtual {v9}, Ljava/io/File;->delete()Z

    .line 1989
    :cond_d
    invoke-virtual {v6}, Lorg/apache/http/client/methods/HttpGet;->abort()V

    .line 1991
    const-wide/16 v10, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v10, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setCurrentSize(D)V

    .line 1992
    const-wide/high16 v10, -0x4010000000000000L    # -1.0

    move-object/from16 v0, p1

    invoke-interface {v0, v10, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setExpectedSize(D)V

    .line 1993
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 2011
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_e

    .line 2014
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_e
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    goto/16 :goto_0

    .line 1997
    .end local v14    # "bytesRead":J
    :cond_f
    :try_start_7
    move-object/from16 v0, p1

    move-wide/from16 v1, v22

    invoke-interface {v0, v1, v2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setExpectedSize(D)V

    .line 1998
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-interface {v0, v5}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->update(Landroid/content/Context;)Z

    .line 2002
    :cond_10
    const/4 v4, 0x1

    .line 2006
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->expectedSize()D

    move-result-wide v10

    const/4 v13, 0x1

    move-object/from16 v5, p0

    move-object/from16 v7, p1

    move/from16 v12, p2

    invoke-virtual/range {v5 .. v13}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->readStreamBytes(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Object;Lorg/apache/http/HttpResponse;Ljava/io/File;DIZ)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v24

    .line 2008
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] DownloadFragment: finished url -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->remotePath()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, ", Expected size -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->expectedSize()D

    move-result-wide v10

    invoke-virtual {v7, v10, v11}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 2009
    const-string v10, ", Size -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    invoke-virtual {v7, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 2008
    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    .line 2011
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .restart local v14    # "bytesRead":J
    cmp-long v5, v14, v16

    if-lez v5, :cond_11

    .line 2014
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v7, 0x1

    iput-boolean v7, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_11
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    move-object/from16 v5, v24

    .line 2019
    goto/16 :goto_0

    .line 2010
    .end local v6    # "method":Lorg/apache/http/client/methods/HttpGet;
    .end local v8    # "response":Lorg/apache/http/HttpResponse;
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .end local v19    # "h":[Lorg/apache/http/Header;
    .end local v21    # "retCode":I
    .end local v22    # "reported_size":D
    .restart local v18    # "file":Ljava/io/File;
    :catchall_0
    move-exception v5

    move-object/from16 v9, v18

    .line 2011
    .end local v18    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    :goto_1
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2013
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_12

    .line 2014
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2017
    :cond_12
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2018
    throw v5

    .line 2010
    .end local v14    # "bytesRead":J
    :catchall_1
    move-exception v5

    goto :goto_1
.end method

.method private downloadItem()Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 20
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1601
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "c[ "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "] DownloadItem"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1603
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v15, 0x1

    iput-boolean v15, v14, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    .line 1604
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14, v15}, Lcom/penthera/virtuososdk/download/Downloader;->requestPermissionChecks(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 1607
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$6(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/content/Context;

    move-result-object v14

    invoke-static {v14}, Lcom/penthera/virtuososdk/utility/CommonUtil$NetworkHelpers;->isCell(Landroid/content/Context;)Z

    move-result v13

    .line 1608
    .local v13, "usingCell":Z
    if-eqz v13, :cond_1

    const/4 v3, 0x0

    .line 1609
    .local v3, "connectionType":I
    :goto_0
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->isSet()Z

    move-result v14

    if-eqz v14, :cond_2

    .line 1610
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    iget-object v8, v14, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .line 1611
    .local v8, "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    iget-object v9, v14, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iReason:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    .line 1612
    .local v9, "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->clear()V

    .line 1613
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "downloadItem(): Download being stopped: "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1615
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14, v15}, Lcom/penthera/virtuososdk/download/Downloader;->removeHandlerPermissionCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 1616
    move-object/from16 v0, p0

    invoke-direct {v0, v8, v9}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->permissionDeniedToFileCompletion(Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;Lcom/penthera/virtuososdk/download/Downloader$EStopReason;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v12

    .line 1698
    .end local v8    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .end local v9    # "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    :cond_0
    :goto_1
    return-object v12

    .line 1608
    .end local v3    # "connectionType":I
    :cond_1
    const/4 v3, 0x1

    goto :goto_0

    .line 1617
    .restart local v3    # "connectionType":I
    :cond_2
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v14

    sget-object v15, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadAllowed:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    if-eq v14, v15, :cond_3

    .line 1618
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader;->getDownloadPermission()Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-result-object v8

    .line 1619
    .restart local v8    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "Downloads not permitted: "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v8}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1621
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14, v15}, Lcom/penthera/virtuososdk/download/Downloader;->removeHandlerPermissionCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 1622
    move-object/from16 v0, p0

    invoke-direct {v0, v8}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->permissionDeniedToFileCompletion(Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v12

    goto :goto_1

    .line 1625
    .end local v8    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    :cond_3
    if-eqz v13, :cond_6

    const-string v6, "cellular"

    .line 1628
    .local v6, "eventBearerType":Ljava/lang/String;
    :goto_2
    sget-object v12, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1632
    .local v12, "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_start_0
    new-instance v7, Lorg/apache/http/params/BasicHttpParams;

    invoke-direct {v7}, Lorg/apache/http/params/BasicHttpParams;-><init>()V

    .line 1633
    .local v7, "httpParams":Lorg/apache/http/params/HttpParams;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->HTTP_SOCKET_TIMEOUT:I
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$13()I

    move-result v14

    invoke-static {v7, v14}, Lorg/apache/http/params/HttpConnectionParams;->setSoTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 1634
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->HTTP_CONNECTION_TIMEOUT:I
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$14()I

    move-result v14

    invoke-static {v7, v14}, Lorg/apache/http/params/HttpConnectionParams;->setConnectionTimeout(Lorg/apache/http/params/HttpParams;I)V

    .line 1636
    new-instance v4, Lorg/apache/http/conn/params/ConnPerRouteBean;

    const/16 v14, 0xa

    invoke-direct {v4, v14}, Lorg/apache/http/conn/params/ConnPerRouteBean;-><init>(I)V

    .line 1637
    .local v4, "cpr":Lorg/apache/http/conn/params/ConnPerRoute;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    const-string v15, "set params max per route"

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1638
    const/16 v14, 0x1e

    invoke-static {v7, v14}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxTotalConnections(Lorg/apache/http/params/HttpParams;I)V

    .line 1639
    invoke-static {v7, v4}, Lorg/apache/http/conn/params/ConnManagerParams;->setMaxConnectionsPerRoute(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/params/ConnPerRoute;)V

    .line 1641
    new-instance v11, Lorg/apache/http/conn/scheme/SchemeRegistry;

    invoke-direct {v11}, Lorg/apache/http/conn/scheme/SchemeRegistry;-><init>()V

    .line 1643
    .local v11, "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    new-instance v14, Lorg/apache/http/conn/scheme/Scheme;

    const-string v15, "http"

    invoke-static {}, Lorg/apache/http/conn/scheme/PlainSocketFactory;->getSocketFactory()Lorg/apache/http/conn/scheme/PlainSocketFactory;

    move-result-object v16

    const/16 v17, 0x50

    invoke-direct/range {v14 .. v17}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    .line 1642
    invoke-virtual {v11, v14}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 1645
    new-instance v14, Lorg/apache/http/conn/scheme/Scheme;

    const-string v15, "https"

    invoke-static {}, Lorg/apache/http/conn/ssl/SSLSocketFactory;->getSocketFactory()Lorg/apache/http/conn/ssl/SSLSocketFactory;

    move-result-object v16

    const/16 v17, 0x1bb

    invoke-direct/range {v14 .. v17}, Lorg/apache/http/conn/scheme/Scheme;-><init>(Ljava/lang/String;Lorg/apache/http/conn/scheme/SocketFactory;I)V

    .line 1644
    invoke-virtual {v11, v14}, Lorg/apache/http/conn/scheme/SchemeRegistry;->register(Lorg/apache/http/conn/scheme/Scheme;)Lorg/apache/http/conn/scheme/Scheme;

    .line 1646
    new-instance v2, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;

    invoke-direct {v2, v7, v11}, Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;-><init>(Lorg/apache/http/params/HttpParams;Lorg/apache/http/conn/scheme/SchemeRegistry;)V

    .line 1647
    .local v2, "ccm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    new-instance v14, Lorg/apache/http/impl/client/DefaultHttpClient;

    invoke-direct {v14, v2, v7}, Lorg/apache/http/impl/client/DefaultHttpClient;-><init>(Lorg/apache/http/conn/ClientConnectionManager;Lorg/apache/http/params/HttpParams;)V

    move-object/from16 v0, p0

    iput-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    .line 1648
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->overallThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->signalStart()V

    .line 1649
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->currentThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->reset()V

    .line 1650
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->currentThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->signalStart()V

    .line 1651
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v14}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v14

    const/4 v15, 0x1

    if-ne v14, v15, :cond_a

    .line 1652
    const-string v14, "TIMED_DOWNLOAD"

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "Start SINGLE "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v16, Ljava/util/Date;

    invoke-direct/range {v16 .. v16}, Ljava/util/Date;-><init>()V

    invoke-virtual/range {v16 .. v16}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    invoke-virtual/range {v15 .. v17}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1653
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v14, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v3, v6, v15}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadItem(Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v12

    .line 1654
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v14, v12, :cond_7

    .line 1655
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v14, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v3, v6, v15}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadItem(Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v12

    .line 1669
    :cond_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->isSet()Z

    move-result v14

    if-eqz v14, :cond_5

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->clear()V

    .line 1670
    :cond_5
    const-string v14, "TIMED_DOWNLOAD"

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "Stop SINGLE "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v16, Ljava/util/Date;

    invoke-direct/range {v16 .. v16}, Ljava/util/Date;-><init>()V

    invoke-virtual/range {v16 .. v16}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    invoke-virtual/range {v15 .. v17}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1689
    :goto_3
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-virtual {v14, v15}, Lcom/penthera/virtuososdk/download/Downloader;->removeHandlerPermissionCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 1691
    :try_start_1
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    if-eqz v14, :cond_0

    .line 1692
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    invoke-interface {v14}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v14

    invoke-interface {v14}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V
    :try_end_1
    .catch Ljava/lang/Exception; {:try_start_1 .. :try_end_1} :catch_0

    goto/16 :goto_1

    .line 1694
    :catch_0
    move-exception v5

    .line 1695
    .local v5, "e":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "c[ "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "] Caught Exception while shutting down connection manager: "

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_1

    .line 1625
    .end local v2    # "ccm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v4    # "cpr":Lorg/apache/http/conn/params/ConnPerRoute;
    .end local v5    # "e":Ljava/lang/Exception;
    .end local v6    # "eventBearerType":Ljava/lang/String;
    .end local v7    # "httpParams":Lorg/apache/http/params/HttpParams;
    .end local v11    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    .end local v12    # "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :cond_6
    const-string v6, "wifi"

    goto/16 :goto_2

    .line 1656
    .restart local v2    # "ccm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .restart local v4    # "cpr":Lorg/apache/http/conn/params/ConnPerRoute;
    .restart local v6    # "eventBearerType":Ljava/lang/String;
    .restart local v7    # "httpParams":Lorg/apache/http/params/HttpParams;
    .restart local v11    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    .restart local v12    # "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :cond_7
    :try_start_2
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v14, v12, :cond_8

    .line 1658
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v14, v12, :cond_4

    .line 1659
    :cond_8
    const/4 v10, 0x1

    .line 1661
    .local v10, "retryCount":I
    :goto_4
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v14, v12, :cond_9

    .line 1663
    sget-object v14, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v14, v12, :cond_4

    :cond_9
    const/4 v14, 0x3

    if-ge v10, v14, :cond_4

    .line 1664
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "received a http error or file size error retry attempt "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v15, v10}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1665
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v14, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v3, v6, v15}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadItem(Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v12

    .line 1666
    add-int/lit8 v10, v10, 0x1

    goto :goto_4

    .line 1671
    .end local v10    # "retryCount":I
    :cond_a
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v14}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v14

    const/4 v15, 0x4

    if-ne v14, v15, :cond_d

    .line 1672
    const-string v14, "TIMED_DOWNLOAD"

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "Start HLS "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v16, Ljava/util/Date;

    invoke-direct/range {v16 .. v16}, Ljava/util/Date;-><init>()V

    invoke-virtual/range {v16 .. v16}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    invoke-virtual/range {v15 .. v17}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 1673
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v14, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    move-object/from16 v0, p0

    invoke-direct {v0, v14, v3, v6, v15}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadItem(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)V

    .line 1674
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->isSet()Z

    move-result v14

    if-eqz v14, :cond_b

    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    invoke-virtual {v14}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->clear()V
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_0

    .line 1676
    :cond_b
    :try_start_3
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;

    monitor-enter v15
    :try_end_3
    .catch Ljava/lang/InterruptedException; {:try_start_3 .. :try_end_3} :catch_1
    .catchall {:try_start_3 .. :try_end_3} :catchall_0

    .line 1677
    :try_start_4
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->mHlsLock:Ljava/lang/Object;

    invoke-virtual {v14}, Ljava/lang/Object;->wait()V

    .line 1676
    monitor-exit v15
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 1680
    :goto_5
    :try_start_5
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->mStatus:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    invoke-static {v14}, Lcom/penthera/virtuososdk/download/Downloader;->access$15(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v12

    .line 1681
    move-object/from16 v0, p0

    iget-object v14, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v14, v14, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v15, 0x0

    iput-boolean v15, v14, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    .line 1682
    const-string v14, "TIMED_DOWNLOAD"

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "Stop HLS "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    new-instance v16, Ljava/util/Date;

    invoke-direct/range {v16 .. v16}, Ljava/util/Date;-><init>()V

    invoke-virtual/range {v16 .. v16}, Ljava/util/Date;->getTime()J

    move-result-wide v16

    const-wide/16 v18, 0x3e8

    div-long v16, v16, v18

    invoke-virtual/range {v15 .. v17}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_0

    goto/16 :goto_3

    .line 1687
    .end local v2    # "ccm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v4    # "cpr":Lorg/apache/http/conn/params/ConnPerRoute;
    .end local v7    # "httpParams":Lorg/apache/http/params/HttpParams;
    .end local v11    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    :catchall_0
    move-exception v14

    .line 1689
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Lcom/penthera/virtuososdk/download/Downloader;->removeHandlerPermissionCheck(Lcom/penthera/virtuososdk/download/Downloader;)V

    .line 1691
    :try_start_6
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    if-eqz v15, :cond_c

    .line 1692
    move-object/from16 v0, p0

    iget-object v15, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->client:Lorg/apache/http/client/HttpClient;

    invoke-interface {v15}, Lorg/apache/http/client/HttpClient;->getConnectionManager()Lorg/apache/http/conn/ClientConnectionManager;

    move-result-object v15

    invoke-interface {v15}, Lorg/apache/http/conn/ClientConnectionManager;->shutdown()V
    :try_end_6
    .catch Ljava/lang/Exception; {:try_start_6 .. :try_end_6} :catch_2

    .line 1697
    :cond_c
    :goto_6
    throw v14

    .line 1676
    .restart local v2    # "ccm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .restart local v4    # "cpr":Lorg/apache/http/conn/params/ConnPerRoute;
    .restart local v7    # "httpParams":Lorg/apache/http/params/HttpParams;
    .restart local v11    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    :catchall_1
    move-exception v14

    :try_start_7
    monitor-exit v15
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    :try_start_8
    throw v14
    :try_end_8
    .catch Ljava/lang/InterruptedException; {:try_start_8 .. :try_end_8} :catch_1
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 1679
    :catch_1
    move-exception v5

    .local v5, "e":Ljava/lang/InterruptedException;
    :try_start_9
    invoke-virtual {v5}, Ljava/lang/InterruptedException;->printStackTrace()V

    goto :goto_5

    .line 1684
    .end local v5    # "e":Ljava/lang/InterruptedException;
    :cond_d
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v14

    new-instance v15, Ljava/lang/StringBuilder;

    const-string v16, "c[ "

    invoke-direct/range {v15 .. v16}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v16, v0

    move-object/from16 v0, v16

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v16, v0

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "] downloadItem invalid contentType"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "["

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v16, v0

    invoke-interface/range {v16 .. v16}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v16

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v15

    const-string v16, "]"

    invoke-virtual/range {v15 .. v16}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v15

    invoke-virtual {v15}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    invoke-static {v14, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1685
    new-instance v14, Ljava/lang/RuntimeException;

    const-string v15, "Invalid item for download"

    invoke-direct {v14, v15}, Ljava/lang/RuntimeException;-><init>(Ljava/lang/String;)V

    throw v14
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 1694
    .end local v2    # "ccm":Lorg/apache/http/impl/conn/tsccm/ThreadSafeClientConnManager;
    .end local v4    # "cpr":Lorg/apache/http/conn/params/ConnPerRoute;
    .end local v7    # "httpParams":Lorg/apache/http/params/HttpParams;
    .end local v11    # "schemeRegistry":Lorg/apache/http/conn/scheme/SchemeRegistry;
    :catch_2
    move-exception v5

    .line 1695
    .local v5, "e":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v15

    new-instance v16, Ljava/lang/StringBuilder;

    const-string v17, "c[ "

    invoke-direct/range {v16 .. v17}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v17, v0

    move-object/from16 v0, v17

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v17, v0

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    const-string v17, "] Caught Exception while shutting down connection manager: "

    invoke-virtual/range {v16 .. v17}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v16

    invoke-virtual/range {v16 .. v16}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v16

    move-object/from16 v0, v16

    invoke-static {v15, v0, v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_6
.end method

.method private downloadItem(Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 34
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    .param p2, "connectionType"    # I
    .param p3, "eventBearerType"    # Ljava/lang/String;
    .param p4, "aClient"    # Lorg/apache/http/client/HttpClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2036
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] DownloadItem: url -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->assetURL()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, " uuid -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->uuid()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 2039
    const/4 v9, 0x0

    .line 2040
    .local v9, "file":Ljava/io/File;
    const-wide/16 v16, 0x0

    .line 2041
    .local v16, "existingBytes":J
    sget-object v30, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 2042
    .local v30, "status":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    const/4 v4, 0x0

    .line 2045
    .local v4, "downloadLoggedStarted":Z
    :try_start_0
    new-instance v19, Ljava/io/File;

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v19

    invoke-direct {v0, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 2046
    .end local v9    # "file":Ljava/io/File;
    .local v19, "file":Ljava/io/File;
    :try_start_1
    new-instance v6, Lorg/apache/http/client/methods/HttpGet;

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->assetURL()Ljava/lang/String;

    move-result-object v5

    invoke-direct {v6, v5}, Lorg/apache/http/client/methods/HttpGet;-><init>(Ljava/lang/String;)V

    .line 2047
    .local v6, "method":Lorg/apache/http/client/methods/HttpGet;
    move-object/from16 v0, p0

    invoke-direct {v0, v6}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->addClientConfiguredHeaders(Lorg/apache/http/client/methods/HttpGet;)V

    .line 2049
    invoke-static/range {v19 .. v19}, Lcom/penthera/virtuososdk/utility/CommonUtil$FileHelpers;->getFileSize(Ljava/io/File;)J

    move-result-wide v16

    .line 2050
    const-wide/16 v10, 0x0

    cmp-long v5, v16, v10

    if-lez v5, :cond_5

    .line 2052
    move-wide/from16 v0, v16

    long-to-double v10, v0

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v32

    cmpl-double v5, v10, v32

    if-nez v5, :cond_4

    .line 2054
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] File already full downloaded: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2055
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->fileMD5()Ljava/lang/String;

    move-result-object v20

    .line 2056
    .local v20, "fileHash":Ljava/lang/String;
    invoke-static/range {v20 .. v20}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-eqz v5, :cond_1

    .line 2057
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] no hash to check setting as complete"

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2058
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_1

    .line 2152
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .local v14, "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_0

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_0
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    move-object/from16 v9, v19

    .line 2161
    .end local v19    # "file":Ljava/io/File;
    .end local v20    # "fileHash":Ljava/lang/String;
    .restart local v9    # "file":Ljava/io/File;
    :goto_0
    return-object v5

    .line 2060
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .restart local v19    # "file":Ljava/io/File;
    .restart local v20    # "fileHash":Ljava/lang/String;
    :cond_1
    :try_start_2
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] checking hash..."

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2061
    new-instance v25, Lcom/penthera/virtuososdk/download/MD5;

    invoke-direct/range {v25 .. v25}, Lcom/penthera/virtuososdk/download/MD5;-><init>()V

    .line 2062
    .local v25, "md5":Lcom/penthera/virtuososdk/download/MD5;
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->md5State()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v5

    move-object/from16 v0, v25

    invoke-virtual {v0, v5}, Lcom/penthera/virtuososdk/download/MD5;->setState(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2063
    invoke-virtual/range {v25 .. v25}, Lcom/penthera/virtuososdk/download/MD5;->getHashString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v20

    invoke-virtual {v0, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_3

    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_2
    .catchall {:try_start_2 .. :try_end_2} :catchall_1

    .line 2152
    :goto_1
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_2

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_2
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    move-object/from16 v9, v19

    .line 2063
    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto :goto_0

    .line 2064
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .restart local v19    # "file":Ljava/io/File;
    :cond_3
    :try_start_3
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileCorrupt:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_1

    .line 2067
    .end local v20    # "fileHash":Ljava/lang/String;
    .end local v25    # "md5":Lcom/penthera/virtuososdk/download/MD5;
    :cond_4
    new-instance v5, Ljava/lang/StringBuilder;

    const-string v7, "bytes="

    invoke-direct {v5, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    invoke-virtual {v5, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v5

    const-string v7, "-"

    invoke-virtual {v5, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v26

    .line 2068
    .local v26, "range":Ljava/lang/String;
    const-string v5, "Range"

    move-object/from16 v0, v26

    invoke-virtual {v6, v5, v0}, Lorg/apache/http/client/methods/HttpGet;->addHeader(Ljava/lang/String;Ljava/lang/String;)V

    .line 2072
    .end local v26    # "range":Ljava/lang/String;
    :cond_5
    move-object/from16 v0, p4

    invoke-interface {v0, v6}, Lorg/apache/http/client/HttpClient;->execute(Lorg/apache/http/client/methods/HttpUriRequest;)Lorg/apache/http/HttpResponse;

    move-result-object v8

    .line 2075
    .local v8, "response":Lorg/apache/http/HttpResponse;
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getStatusLine()Lorg/apache/http/StatusLine;

    move-result-object v5

    invoke-interface {v5}, Lorg/apache/http/StatusLine;->getStatusCode()I

    move-result v27

    .line 2077
    .local v27, "retCode":I
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "Http response for download: "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move/from16 v0, v27

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 2078
    const/16 v5, 0x1f4

    move/from16 v0, v27

    if-lt v0, v5, :cond_7

    .line 2079
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] HTTP Server error: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-static/range {v27 .. v27}, Ljava/lang/Integer;->toString(I)Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2080
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_3
    .catchall {:try_start_3 .. :try_end_3} :catchall_1

    .line 2152
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_6

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_6
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    move-object/from16 v9, v19

    .line 2080
    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto/16 :goto_0

    .line 2081
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .restart local v19    # "file":Ljava/io/File;
    :cond_7
    const/16 v5, 0xc8

    move/from16 v0, v27

    if-lt v0, v5, :cond_8

    const/16 v5, 0x12c

    move/from16 v0, v27

    if-lt v0, v5, :cond_d

    .line 2082
    :cond_8
    :try_start_4
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] HTTP other error: "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move/from16 v0, v27

    invoke-virtual {v7, v0}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2083
    const/16 v5, 0x1a0

    move/from16 v0, v27

    if-ne v0, v5, :cond_b

    .line 2084
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_9

    .line 2085
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->delete()Z

    .line 2086
    const-wide/16 v10, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v10, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setCurrentSize(D)V

    .line 2088
    :cond_9
    invoke-virtual {v6}, Lorg/apache/http/client/methods/HttpGet;->abort()V

    .line 2089
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EInternalErrorRetryOn416:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_4
    .catchall {:try_start_4 .. :try_end_4} :catchall_1

    .line 2152
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_a

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_a
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    move-object/from16 v9, v19

    .line 2089
    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto/16 :goto_0

    .line 2091
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .restart local v19    # "file":Ljava/io/File;
    :cond_b
    :try_start_5
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorHTTP:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_5
    .catchall {:try_start_5 .. :try_end_5} :catchall_1

    .line 2152
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_c

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_c
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    move-object/from16 v9, v19

    .line 2091
    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto/16 :goto_0

    .line 2094
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .restart local v19    # "file":Ljava/io/File;
    :cond_d
    :try_start_6
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v5

    invoke-static {v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$HttpUtils;->dumpHeaders([Lorg/apache/http/Header;)V

    .line 2095
    invoke-interface {v8}, Lorg/apache/http/HttpResponse;->getAllHeaders()[Lorg/apache/http/Header;

    move-result-object v23

    .line 2097
    .local v23, "h":[Lorg/apache/http/Header;
    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->getMimetypeFromHeaders([Lorg/apache/http/Header;)Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p0

    iput-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iDiscoveredContentType:Ljava/lang/String;

    .line 2098
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->mimeType()Ljava/lang/String;

    move-result-object v21

    .line 2100
    .local v21, "fileMime":Ljava/lang/String;
    invoke-static/range {v21 .. v21}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_f

    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iDiscoveredContentType:Ljava/lang/String;

    move-object/from16 v0, v21

    invoke-virtual {v0, v5}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-nez v5, :cond_f

    .line 2101
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileMimeType:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_6
    .catchall {:try_start_6 .. :try_end_6} :catchall_1

    .line 2152
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_e

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_e
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    move-object/from16 v9, v19

    .line 2101
    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto/16 :goto_0

    .line 2104
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .restart local v19    # "file":Ljava/io/File;
    :cond_f
    :try_start_7
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v5

    const-string v7, "."

    invoke-virtual {v5, v7}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v24

    .line 2105
    .local v24, "idx":I
    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/String;->length()I

    move-result v5

    sub-int v24, v5, v24

    .line 2106
    const/4 v5, 0x5

    move/from16 v0, v24

    if-gt v0, v5, :cond_10

    const/4 v5, 0x2

    move/from16 v0, v24

    if-ge v0, v5, :cond_19

    .line 2107
    :cond_10
    const-string v5, "Content-Disposition"

    invoke-interface {v8, v5}, Lorg/apache/http/HttpResponse;->getHeaders(Ljava/lang/String;)[Lorg/apache/http/Header;

    move-result-object v5

    move-object/from16 v0, p0

    invoke-direct {v0, v5}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->getFileNameFromHeaders([Lorg/apache/http/Header;)Ljava/lang/String;

    move-result-object v22

    .line 2108
    .local v22, "fn":Ljava/lang/String;
    invoke-static/range {v22 .. v22}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_19

    .line 2109
    const-string v5, "."

    move-object/from16 v0, v22

    invoke-virtual {v0, v5}, Ljava/lang/String;->lastIndexOf(Ljava/lang/String;)I

    move-result v24

    .line 2110
    if-ltz v24, :cond_13

    move-object/from16 v0, v22

    move/from16 v1, v24

    invoke-virtual {v0, v1}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v13

    .line 2111
    .local v13, "extension":Ljava/lang/String;
    :goto_2
    invoke-static {v13}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_19

    .line 2112
    new-instance v5, Ljava/lang/StringBuilder;

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v7

    invoke-static {v7}, Ljava/lang/String;->valueOf(Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v7

    invoke-direct {v5, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v5, v13}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v5

    invoke-virtual {v5}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, p1

    invoke-interface {v0, v5}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setFilePath(Ljava/lang/String;)V

    .line 2113
    new-instance v18, Ljava/io/File;

    invoke-interface/range {p1 .. p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v5

    move-object/from16 v0, v18

    invoke-direct {v0, v5}, Ljava/io/File;-><init>(Ljava/lang/String;)V

    .line 2114
    .local v18, "f":Ljava/io/File;
    invoke-virtual/range {v19 .. v19}, Ljava/io/File;->length()J

    move-result-wide v10

    const-wide/16 v32, 0x0

    cmp-long v5, v10, v32

    if-lez v5, :cond_14

    .line 2115
    move-object/from16 v0, v19

    move-object/from16 v1, v18

    invoke-virtual {v0, v1}, Ljava/io/File;->renameTo(Ljava/io/File;)Z
    :try_end_7
    .catchall {:try_start_7 .. :try_end_7} :catchall_1

    move-object/from16 v9, v19

    .line 2123
    .end local v13    # "extension":Ljava/lang/String;
    .end local v18    # "f":Ljava/io/File;
    .end local v19    # "file":Ljava/io/File;
    .end local v22    # "fn":Ljava/lang/String;
    .restart local v9    # "file":Ljava/io/File;
    :goto_3
    :try_start_8
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    move-object/from16 v0, p0

    move-object/from16 v1, v23

    invoke-direct {v0, v1, v10, v11}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->getFileSizeFromHeaders([Lorg/apache/http/Header;J)D

    move-result-wide v28

    .line 2124
    .local v28, "reported_size":D
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v10

    const-wide/high16 v32, -0x4010000000000000L    # -1.0

    cmpl-double v5, v10, v32

    if-lez v5, :cond_15

    .line 2128
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v10

    cmpl-double v5, v28, v10

    if-eqz v5, :cond_16

    .line 2129
    invoke-virtual {v9}, Ljava/io/File;->exists()Z

    move-result v5

    if-eqz v5, :cond_11

    .line 2130
    invoke-virtual {v9}, Ljava/io/File;->delete()Z

    .line 2132
    :cond_11
    invoke-virtual {v6}, Lorg/apache/http/client/methods/HttpGet;->abort()V

    .line 2134
    const-wide/16 v10, 0x0

    move-object/from16 v0, p1

    invoke-interface {v0, v10, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setCurrentSize(D)V

    .line 2135
    const-wide/high16 v10, -0x4010000000000000L    # -1.0

    move-object/from16 v0, p1

    invoke-interface {v0, v10, v11}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setExpectedSize(D)V

    .line 2136
    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileExpectedSize:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_8
    .catchall {:try_start_8 .. :try_end_8} :catchall_0

    .line 2152
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_12

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_12
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    goto/16 :goto_0

    .line 2110
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .end local v28    # "reported_size":D
    .restart local v19    # "file":Ljava/io/File;
    .restart local v22    # "fn":Ljava/lang/String;
    :cond_13
    const/4 v13, 0x0

    goto/16 :goto_2

    .line 2117
    .restart local v13    # "extension":Ljava/lang/String;
    .restart local v18    # "f":Ljava/io/File;
    :cond_14
    move-object/from16 v9, v18

    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto :goto_3

    .line 2140
    .end local v13    # "extension":Ljava/lang/String;
    .end local v18    # "f":Ljava/io/File;
    .end local v22    # "fn":Ljava/lang/String;
    .restart local v28    # "reported_size":D
    :cond_15
    :try_start_9
    move-object/from16 v0, p1

    move-wide/from16 v1, v28

    invoke-interface {v0, v1, v2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setExpectedSize(D)V

    .line 2144
    :cond_16
    const/4 v4, 0x1

    .line 2147
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v5}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v10

    move-object/from16 v5, p0

    move-object/from16 v7, p1

    move/from16 v12, p2

    invoke-virtual/range {v5 .. v12}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->readStreamBytes(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Object;Lorg/apache/http/HttpResponse;Ljava/io/File;DI)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v30

    .line 2149
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v7, Ljava/lang/StringBuilder;

    const-string v10, "c[ "

    invoke-direct {v7, v10}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v10, v10, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, "] DownloadItem: finished url -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetURL()Ljava/lang/String;

    move-result-object v10

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    const-string v10, ", Expected size -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v10}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v10

    invoke-virtual {v7, v10, v11}, Ljava/lang/StringBuilder;->append(D)Ljava/lang/StringBuilder;

    move-result-object v7

    .line 2150
    const-string v10, ", Size -> "

    invoke-virtual {v7, v10}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    invoke-virtual {v7, v10, v11}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v7

    invoke-virtual {v7}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v7

    .line 2149
    invoke-static {v5, v7}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V
    :try_end_9
    .catchall {:try_start_9 .. :try_end_9} :catchall_0

    .line 2152
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v5, v14, v16

    if-lez v5, :cond_17

    .line 2155
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v7, 0x1

    iput-boolean v7, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_17
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v5, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v7, 0x0

    iput-boolean v7, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    move-object/from16 v5, v30

    .line 2161
    goto/16 :goto_0

    .line 2151
    .end local v6    # "method":Lorg/apache/http/client/methods/HttpGet;
    .end local v8    # "response":Lorg/apache/http/HttpResponse;
    .end local v14    # "bytesRead":J
    .end local v21    # "fileMime":Ljava/lang/String;
    .end local v23    # "h":[Lorg/apache/http/Header;
    .end local v24    # "idx":I
    .end local v27    # "retCode":I
    .end local v28    # "reported_size":D
    :catchall_0
    move-exception v5

    .line 2152
    :goto_4
    invoke-virtual {v9}, Ljava/io/File;->length()J

    move-result-wide v10

    sub-long v14, v10, v16

    .line 2154
    .restart local v14    # "bytesRead":J
    cmp-long v7, v14, v16

    if-lez v7, :cond_18

    .line 2155
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x1

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iBytesDownloaded:Z

    .line 2158
    :cond_18
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v14, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 2159
    move-object/from16 v0, p0

    iget-object v7, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v10, 0x0

    iput-boolean v10, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloading:Z

    .line 2160
    throw v5

    .line 2151
    .end local v9    # "file":Ljava/io/File;
    .end local v14    # "bytesRead":J
    .restart local v19    # "file":Ljava/io/File;
    :catchall_1
    move-exception v5

    move-object/from16 v9, v19

    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto :goto_4

    .end local v9    # "file":Ljava/io/File;
    .restart local v6    # "method":Lorg/apache/http/client/methods/HttpGet;
    .restart local v8    # "response":Lorg/apache/http/HttpResponse;
    .restart local v19    # "file":Ljava/io/File;
    .restart local v21    # "fileMime":Ljava/lang/String;
    .restart local v23    # "h":[Lorg/apache/http/Header;
    .restart local v24    # "idx":I
    .restart local v27    # "retCode":I
    :cond_19
    move-object/from16 v9, v19

    .end local v19    # "file":Ljava/io/File;
    .restart local v9    # "file":Ljava/io/File;
    goto/16 :goto_3
.end method

.method private downloadItem(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)V
    .locals 6
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    .param p2, "connectionType"    # I
    .param p3, "eventBearerType"    # Ljava/lang/String;
    .param p4, "aClient"    # Lorg/apache/http/client/HttpClient;
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 1885
    new-instance v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;

    move-object v1, p0

    move-object v2, p1

    move v3, p2

    move-object v4, p3

    move-object v5, p4

    invoke-direct/range {v0 .. v5}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;-><init>(Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;ILjava/lang/String;Lorg/apache/http/client/HttpClient;)V

    .line 1886
    .local v0, "hlsDownload":Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;
    invoke-virtual {v0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread$HlsDownload;->begin()V

    .line 1887
    return-void
.end method

.method private getFileNameFromHeaders([Lorg/apache/http/Header;)Ljava/lang/String;
    .locals 12
    .param p1, "headers"    # [Lorg/apache/http/Header;

    .prologue
    const/4 v8, 0x0

    const/4 v11, 0x0

    .line 2420
    if-nez p1, :cond_0

    move-object v0, v8

    .line 2443
    :goto_0
    return-object v0

    .line 2421
    :cond_0
    const/4 v1, 0x0

    .local v1, "i":I
    :goto_1
    array-length v9, p1

    if-lt v1, v9, :cond_1

    move-object v0, v8

    .line 2443
    goto :goto_0

    .line 2422
    :cond_1
    aget-object v6, p1, v1

    .line 2423
    .local v6, "value":Lorg/apache/http/Header;
    invoke-virtual {v6}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v7

    .line 2424
    .local v7, "valueStr":Ljava/lang/String;
    const-string v9, ":"

    invoke-virtual {v7, v9}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v5

    .line 2426
    .local v5, "splitArr":[Ljava/lang/String;
    aget-object v3, v5, v11

    .line 2427
    .local v3, "lhs":Ljava/lang/String;
    invoke-static {v3}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v9

    if-nez v9, :cond_2

    invoke-virtual {v3}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v9

    const-string v10, "Content-disposition"

    invoke-virtual {v9, v10}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v9

    if-eqz v9, :cond_2

    .line 2428
    const/4 v9, 0x1

    aget-object v4, v5, v9

    .line 2429
    .local v4, "rhs":Ljava/lang/String;
    const-string v0, "filename="

    .line 2430
    .local v0, "fn":Ljava/lang/String;
    invoke-virtual {v4, v0}, Ljava/lang/String;->indexOf(Ljava/lang/String;)I

    move-result v2

    .line 2431
    .local v2, "index":I
    if-lez v2, :cond_2

    .line 2432
    invoke-virtual {v0}, Ljava/lang/String;->length()I

    move-result v9

    add-int/lit8 v9, v9, 0x1

    add-int/2addr v2, v9

    .line 2433
    invoke-virtual {v4}, Ljava/lang/String;->length()I

    move-result v9

    if-ge v2, v9, :cond_2

    .line 2434
    invoke-virtual {v4, v2}, Ljava/lang/String;->substring(I)Ljava/lang/String;

    move-result-object v8

    invoke-virtual {v8}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v0

    .line 2435
    const/16 v8, 0x22

    invoke-virtual {v0, v8}, Ljava/lang/String;->indexOf(I)I

    move-result v2

    .line 2436
    invoke-virtual {v0, v11, v2}, Ljava/lang/String;->substring(II)Ljava/lang/String;

    move-result-object v0

    .line 2437
    goto :goto_0

    .line 2421
    .end local v0    # "fn":Ljava/lang/String;
    .end local v2    # "index":I
    .end local v4    # "rhs":Ljava/lang/String;
    :cond_2
    add-int/lit8 v1, v1, 0x1

    goto :goto_1
.end method

.method private getFileSizeFromHeaders([Lorg/apache/http/Header;J)D
    .locals 16
    .param p1, "headers"    # [Lorg/apache/http/Header;
    .param p2, "existingBytes"    # J

    .prologue
    .line 2462
    if-nez p1, :cond_1

    const-wide/16 v4, 0x0

    .line 2499
    :cond_0
    :goto_0
    return-wide v4

    .line 2464
    :cond_1
    const-wide/16 v4, 0x0

    .line 2465
    .local v4, "content_range_size":D
    const-wide/16 v2, 0x0

    .line 2466
    .local v2, "content_length":D
    const/4 v6, 0x0

    .local v6, "i":I
    :goto_1
    move-object/from16 v0, p1

    array-length v14, v0

    if-lt v6, v14, :cond_3

    .line 2496
    :cond_2
    const-wide/16 v14, 0x0

    cmpl-double v14, v4, v14

    if-gtz v14, :cond_0

    move-wide v4, v2

    .line 2499
    goto :goto_0

    .line 2467
    :cond_3
    aget-object v12, p1, v6

    .line 2468
    .local v12, "value":Lorg/apache/http/Header;
    invoke-virtual {v12}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v13

    .line 2469
    .local v13, "valueStr":Ljava/lang/String;
    const-string v14, ":"

    invoke-virtual {v13, v14}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v11

    .line 2471
    .local v11, "splitArr":[Ljava/lang/String;
    const/4 v14, 0x0

    aget-object v7, v11, v14

    .line 2473
    .local v7, "lhs":Ljava/lang/String;
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_4

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v14

    const-string v15, "Content-Length"

    invoke-virtual {v14, v15}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_4

    .line 2476
    const/4 v14, 0x1

    aget-object v10, v11, v14

    .line 2477
    .local v10, "rhs":Ljava/lang/String;
    invoke-virtual {v10}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D

    move-result-wide v2

    .line 2478
    move-wide/from16 v0, p2

    long-to-double v14, v0

    add-double/2addr v2, v14

    .line 2480
    .end local v10    # "rhs":Ljava/lang/String;
    :cond_4
    invoke-static {v7}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v14

    if-nez v14, :cond_5

    invoke-virtual {v7}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v14

    const-string v15, "Content-Range"

    invoke-virtual {v14, v15}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v14

    if-eqz v14, :cond_5

    .line 2482
    const/4 v14, 0x1

    aget-object v10, v11, v14

    .line 2483
    .restart local v10    # "rhs":Ljava/lang/String;
    const-string v14, "/"

    invoke-virtual {v10, v14}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v8

    .line 2484
    .local v8, "range_arr":[Ljava/lang/String;
    array-length v14, v8

    const/4 v15, 0x2

    if-ne v14, v15, :cond_5

    .line 2485
    const/4 v14, 0x1

    aget-object v9, v8, v14

    .line 2487
    .local v9, "range_val":Ljava/lang/String;
    :try_start_0
    invoke-virtual {v9}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v14

    invoke-static {v14}, Ljava/lang/Double;->parseDouble(Ljava/lang/String;)D
    :try_end_0
    .catch Ljava/lang/NumberFormatException; {:try_start_0 .. :try_end_0} :catch_0

    move-result-wide v4

    .line 2492
    .end local v8    # "range_arr":[Ljava/lang/String;
    .end local v9    # "range_val":Ljava/lang/String;
    .end local v10    # "rhs":Ljava/lang/String;
    :cond_5
    :goto_2
    const-wide/16 v14, 0x0

    cmpl-double v14, v2, v14

    if-lez v14, :cond_6

    const-wide/16 v14, 0x0

    cmpl-double v14, v4, v14

    if-gtz v14, :cond_2

    .line 2466
    :cond_6
    add-int/lit8 v6, v6, 0x1

    goto :goto_1

    .line 2488
    .restart local v8    # "range_arr":[Ljava/lang/String;
    .restart local v9    # "range_val":Ljava/lang/String;
    .restart local v10    # "rhs":Ljava/lang/String;
    :catch_0
    move-exception v14

    goto :goto_2
.end method

.method private getMimetypeFromHeaders([Lorg/apache/http/Header;)Ljava/lang/String;
    .locals 7
    .param p1, "headers"    # [Lorg/apache/http/Header;

    .prologue
    .line 2447
    if-nez p1, :cond_0

    const-string v5, ""

    .line 2458
    :goto_0
    return-object v5

    .line 2448
    :cond_0
    const/4 v0, 0x0

    .local v0, "i":I
    :goto_1
    array-length v5, p1

    if-lt v0, v5, :cond_1

    .line 2458
    const-string v5, ""

    goto :goto_0

    .line 2449
    :cond_1
    aget-object v3, p1, v0

    .line 2450
    .local v3, "value":Lorg/apache/http/Header;
    invoke-virtual {v3}, Ljava/lang/Object;->toString()Ljava/lang/String;

    move-result-object v4

    .line 2451
    .local v4, "valueStr":Ljava/lang/String;
    const-string v5, ":"

    invoke-virtual {v4, v5}, Ljava/lang/String;->split(Ljava/lang/String;)[Ljava/lang/String;

    move-result-object v2

    .line 2453
    .local v2, "splitArr":[Ljava/lang/String;
    const/4 v5, 0x0

    aget-object v1, v2, v5

    .line 2454
    .local v1, "lhs":Ljava/lang/String;
    invoke-static {v1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v5

    if-nez v5, :cond_2

    invoke-virtual {v1}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    const-string v6, "Content-Type"

    invoke-virtual {v5, v6}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v5

    if-eqz v5, :cond_2

    .line 2455
    const/4 v5, 0x1

    aget-object v5, v2, v5

    invoke-virtual {v5}, Ljava/lang/String;->trim()Ljava/lang/String;

    move-result-object v5

    goto :goto_0

    .line 2448
    :cond_2
    add-int/lit8 v0, v0, 0x1

    goto :goto_1
.end method

.method private permissionDeniedToFileCompletion(Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 1
    .param p1, "aPerm"    # Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    .prologue
    .line 1524
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EBlocked:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    invoke-direct {p0, p1, v0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->permissionDeniedToFileCompletion(Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;Lcom/penthera/virtuososdk/download/Downloader$EStopReason;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v0

    return-object v0
.end method

.method private permissionDeniedToFileCompletion(Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;Lcom/penthera/virtuososdk/download/Downloader$EStopReason;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 2
    .param p1, "aPerm"    # Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .param p2, "aReason"    # Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    .prologue
    .line 1528
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->$SWITCH_TABLE$com$penthera$virtuososdk$download$Downloader$EDownloadPermission()[I

    move-result-object v0

    invoke-virtual {p1}, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->ordinal()I

    move-result v1

    aget v0, v0, v1

    packed-switch v0, :pswitch_data_0

    .line 1553
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedUnknown:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    :goto_0
    return-object v0

    .line 1530
    :pswitch_0
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1532
    :pswitch_1
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedBattery:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1534
    :pswitch_2
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedHeadroom:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1536
    :pswitch_3
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1538
    :pswitch_4
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1540
    :pswitch_5
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EPriorityChange:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    if-ne p2, v0, :cond_0

    .line 1541
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadPriorityChange:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1543
    :cond_0
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EFileRemoved:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    if-ne p2, v0, :cond_1

    .line 1544
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1546
    :cond_1
    sget-object v0, Lcom/penthera/virtuososdk/download/Downloader$EStopReason;->EFileExpired:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    if-ne p2, v0, :cond_2

    .line 1547
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1550
    :cond_2
    :pswitch_6
    sget-object v0, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedAuthentication:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0

    .line 1528
    nop

    :pswitch_data_0
    .packed-switch 0x1
        :pswitch_5
        :pswitch_0
        :pswitch_1
        :pswitch_2
        :pswitch_3
        :pswitch_4
        :pswitch_6
    .end packed-switch
.end method

.method private reportFragmentComplete(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V
    .locals 6
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    .param p2, "fragment"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;

    .prologue
    .line 1893
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->totalFragments()I

    move-result v1

    .line 1894
    .local v1, "expected":I
    invoke-interface {p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->totalFragmentsComplete()I

    move-result v4

    add-int/lit8 v4, v4, 0x1

    invoke-static {v4, v1}, Ljava/lang/Math;->min(II)I

    move-result v0

    .line 1895
    .local v0, "completed":I
    invoke-interface {p1, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->setCompletedCount(I)V

    .line 1897
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iFragmentNotificationRate:I
    invoke-static {v4}, Lcom/penthera/virtuososdk/download/Downloader;->access$16(Lcom/penthera/virtuososdk/download/Downloader;)I

    move-result v4

    if-lez v4, :cond_0

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iFragmentNotificationRate:I
    invoke-static {v4}, Lcom/penthera/virtuososdk/download/Downloader;->access$16(Lcom/penthera/virtuososdk/download/Downloader;)I

    move-result v4

    rem-int v4, v0, v4

    if-nez v4, :cond_0

    .line 1898
    new-instance v2, Landroid/os/Bundle;

    invoke-direct {v2}, Landroid/os/Bundle;-><init>()V

    .line 1899
    .local v2, "extras":Landroid/os/Bundle;
    const-string v4, "virtuoso_file"

    invoke-virtual {v2, v4, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1900
    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v4}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v4

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-interface {v4, v5, v2}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->fragmentsComplete(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 1903
    .end local v2    # "extras":Landroid/os/Bundle;
    :cond_0
    div-int/lit8 v3, v1, 0x64

    .line 1904
    .local v3, "one_p":I
    if-lez v3, :cond_1

    rem-int v4, v0, v3

    if-nez v4, :cond_1

    .line 1905
    invoke-direct {p0, p1, p2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->reportHLSUpdate(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V

    .line 1907
    :cond_1
    return-void
.end method

.method private reportHLSUpdate(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V
    .locals 6
    .param p1, "aFile"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;
    .param p2, "fragment"    # Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;

    .prologue
    .line 1910
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iget-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iLastUpdateTime:J

    sub-long/2addr v2, v4

    iget-wide v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iMinimumUpdateInterval:J

    cmp-long v1, v2, v4

    if-ltz v1, :cond_0

    .line 1911
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v2

    iput-wide v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iLastUpdateTime:J

    .line 1912
    invoke-static {}, Lcom/penthera/virtuososdk/utility/CommonUtil;->getApplicationContext()Landroid/content/Context;

    move-result-object v1

    invoke-interface {p1, v1, p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;->updateFragment(Landroid/content/Context;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)Z

    .line 1913
    iget-boolean v1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iHlsReportedComplete:Z

    if-eqz v1, :cond_1

    .line 1918
    :cond_0
    :goto_0
    return-void

    .line 1914
    :cond_1
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1915
    .local v0, "extras":Landroid/os/Bundle;
    const-string v1, "virtuoso_file"

    invoke-virtual {v0, v1, p1}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1916
    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v1}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v1

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-interface {v1, v2, v0}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->hdsProgressUpdate(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    goto :goto_0
.end method

.method private sendQuotaUpdate(Landroid/os/Bundle;)V
    .locals 4
    .param p1, "quota_info"    # Landroid/os/Bundle;

    .prologue
    .line 2399
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->currentThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    const-string v1, "bearer_data_usage"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->update(J)V

    .line 2400
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->overallThroughPut:Lcom/penthera/virtuososdk/download/Downloader$Throughput;

    const-string v1, "bearer_data_usage"

    invoke-virtual {p1, v1}, Landroid/os/Bundle;->getInt(Ljava/lang/String;)I

    move-result v1

    int-to-long v2, v1

    invoke-virtual {v0, v2, v3}, Lcom/penthera/virtuososdk/download/Downloader$Throughput;->update(J)V

    .line 2401
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v0}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v0

    iget-object v1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    invoke-interface {v0, v1, p1}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->quotaUpdate(Lcom/penthera/virtuososdk/download/Downloader;Landroid/os/Bundle;)V

    .line 2402
    return-void
.end method

.method private tryDownloadFile()Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 12

    .prologue
    const-wide/16 v10, 0x0

    .line 1558
    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1559
    .local v4, "state":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    const/4 v2, 0x0

    .line 1561
    .local v2, "exception":Z
    :cond_0
    if-eqz v2, :cond_1

    .line 1562
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "tryDownloadItem(): Network failure -- trying again for item: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v7}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetURL()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1563
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "tryDownloadItem(): bytes read on the previous attempt: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget-wide v8, v7, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    invoke-virtual {v6, v8, v9}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1566
    :cond_1
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iput-wide v10, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    .line 1567
    const/4 v2, 0x0

    .line 1570
    :try_start_0
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->downloadItem()Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v4

    .line 1571
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v6, 0x0

    iput v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I
    :try_end_0
    .catch Ljava/net/UnknownHostException; {:try_start_0 .. :try_end_0} :catch_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_1
    .catch Ljava/lang/Throwable; {:try_start_0 .. :try_end_0} :catch_2

    .line 1592
    :goto_0
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v5, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    const/4 v6, 0x3

    if-lt v5, v6, :cond_3

    .line 1593
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "c[ "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v7, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v7, v7, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    const-string v7, "] No internet connection: connection not usable"

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 1594
    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorsMaxed:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1597
    .end local v4    # "state":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :cond_2
    :goto_1
    return-object v4

    .line 1572
    .restart local v4    # "state":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :catch_0
    move-exception v0

    .line 1573
    .local v0, "e":Ljava/net/UnknownHostException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "tryDownloadItem(): Network unavaialble -- Received unknown host excpetion: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v0}, Ljava/net/UnknownHostException;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1574
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    add-int/lit8 v6, v6, 0x1

    iput v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    .line 1575
    const-string v5, "virtuoso.intent.action.UNKNOWN_HOST"

    invoke-static {v5}, Lcom/penthera/virtuososdk/utility/CommonUtil$Broadcasts;->sendBroadcast(Ljava/lang/String;)V

    .line 1576
    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1577
    const/4 v2, 0x1

    goto :goto_0

    .line 1578
    .end local v0    # "e":Ljava/net/UnknownHostException;
    :catch_1
    move-exception v1

    .line 1579
    .local v1, "e2":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "tryDownloadItem(): Network problem -- Received a network error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v1}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1580
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    add-int/lit8 v6, v6, 0x1

    iput v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    .line 1582
    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1583
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 1584
    .end local v1    # "e2":Ljava/lang/Exception;
    :catch_2
    move-exception v3

    .line 1585
    .local v3, "r2":Ljava/lang/Throwable;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v5

    new-instance v6, Ljava/lang/StringBuilder;

    const-string v7, "tryDownloadItem(): Network problem -- unknown error: "

    invoke-direct {v6, v7}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual {v3}, Ljava/lang/Throwable;->getMessage()Ljava/lang/String;

    move-result-object v7

    invoke-virtual {v6, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v6

    invoke-virtual {v6}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v6

    invoke-static {v5, v6}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 1586
    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    add-int/lit8 v6, v6, 0x1

    iput v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    .line 1588
    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorNetwork:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1589
    const/4 v2, 0x1

    goto/16 :goto_0

    .line 1596
    .end local v3    # "r2":Ljava/lang/Throwable;
    :cond_3
    if-eqz v2, :cond_2

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    iget-wide v6, v5, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iLastBytesRead:J

    cmp-long v5, v6, v10

    if-gtz v5, :cond_0

    goto/16 :goto_1
.end method

.method private updateDownloadProgress()V
    .locals 3

    .prologue
    .line 2415
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v0

    iput-wide v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iLastUpdateTime:J

    .line 2416
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v1, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EProgressUpdate:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->sendBroadcastForDownloadUpdate(Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$3(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 2418
    return-void
.end method

.method private updateDownloadProgress(D)V
    .locals 3
    .param p1, "aFileSize"    # D

    .prologue
    .line 2405
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v0}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->type()I

    move-result v0

    const/4 v1, 0x1

    if-ne v0, v1, :cond_0

    .line 2406
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    invoke-interface {v0, p1, p2}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setCurrentSize(D)V

    .line 2407
    :cond_0
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress()V

    .line 2408
    return-void
.end method

.method private updateDownloadProgress(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V
    .locals 1
    .param p1, "aStatus"    # Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    .prologue
    .line 2411
    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v0, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    invoke-interface {v0, p1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 2412
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress()V

    .line 2413
    return-void
.end method

.method private validFragmentMimeType(Ljava/lang/String;)Z
    .locals 2
    .param p1, "mimetype"    # Ljava/lang/String;

    .prologue
    .line 2024
    invoke-static {p1}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_1

    .line 2025
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "video/mp2t"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2026
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "video/mp2ts"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2027
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "audio/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2028
    invoke-static {}, Ljava/util/Locale;->getDefault()Ljava/util/Locale;

    move-result-object v0

    invoke-virtual {p1, v0}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v0

    const-string v1, "video/"

    invoke-virtual {v0, v1}, Ljava/lang/String;->contains(Ljava/lang/CharSequence;)Z

    move-result v0

    if-nez v0, :cond_0

    .line 2029
    const-string v0, "application/octet-stream"

    invoke-virtual {v0, p1}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v0

    if-eqz v0, :cond_1

    .line 2031
    :cond_0
    const/4 v0, 0x1

    .line 2032
    :goto_0
    return v0

    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method killDownloadWithCompletionCode(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V
    .locals 6
    .param p1, "efdc"    # Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .prologue
    const/4 v5, 0x1

    .line 1451
    iput-boolean v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z

    .line 1453
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "c[ "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v4, v4, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] kill Download:  uuid -> "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v4

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, " Reason -> "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3, p1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1455
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    sget-object v3, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v2, v3, :cond_2

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq p1, v2, :cond_0

    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne p1, v2, :cond_2

    .line 1457
    :cond_0
    iput-boolean v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->removeAfterPause:Z

    .line 1459
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1460
    iget-object v3, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->completionLock:Ljava/lang/Object;

    monitor-enter v3

    .line 1462
    :try_start_0
    iget-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iHlsReportedComplete:Z

    if-eqz v2, :cond_1

    .line 1464
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iContext:Landroid/content/Context;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$6(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/content/Context;

    move-result-object v2

    invoke-virtual {v2}, Landroid/content/Context;->getContentResolver()Landroid/content/ContentResolver;

    move-result-object v2

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v4}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->uuid()Ljava/lang/String;

    move-result-object v4

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-static {v2, v4, v5}, Lcom/penthera/virtuososdk/interfaces/toolkit/VirtuosoContentBox;->getItem(Landroid/content/ContentResolver;Ljava/lang/String;Ljava/lang/String;)Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;

    move-result-object v1

    .line 1465
    .local v1, "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    if-eqz v1, :cond_1

    .line 1467
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v2

    new-instance v4, Ljava/lang/StringBuilder;

    const-string v5, "c[ "

    invoke-direct {v4, v5}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v5, v5, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    const-string v5, "] file completed removing "

    invoke-virtual {v4, v5}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v4

    invoke-virtual {v4}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v4

    invoke-static {v2, v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1468
    new-instance v0, Landroid/os/Bundle;

    invoke-direct {v0}, Landroid/os/Bundle;-><init>()V

    .line 1469
    .local v0, "extras":Landroid/os/Bundle;
    const-string v2, "virtuoso_file"

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-virtual {v0, v2, v4}, Landroid/os/Bundle;->putParcelable(Ljava/lang/String;Landroid/os/Parcelable;)V

    .line 1470
    const-string v2, "failure_reason"

    sget-object v4, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v4}, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->ordinal()I

    move-result v4

    invoke-virtual {v0, v2, v4}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 1471
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iDObserver:Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;
    invoke-static {v2}, Lcom/penthera/virtuososdk/download/Downloader;->access$9(Lcom/penthera/virtuososdk/download/Downloader;)Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;

    move-result-object v2

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v5, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EItemDownloadRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    invoke-interface {v2, v4, v5, v0}, Lcom/penthera/virtuososdk/download/Downloader$DownloaderObserver;->downloadUpdate(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1460
    .end local v0    # "extras":Landroid/os/Bundle;
    .end local v1    # "vi":Lcom/penthera/virtuososdk/client/IVirtuosoIdentifier;
    :cond_1
    monitor-exit v3
    :try_end_0
    .catchall {:try_start_0 .. :try_end_0} :catchall_0

    .line 1490
    :goto_0
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "c[ "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v4, v4, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] kill Download: code -> "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1496
    return-void

    .line 1460
    :catchall_0
    move-exception v2

    :try_start_1
    monitor-exit v3
    :try_end_1
    .catchall {:try_start_1 .. :try_end_1} :catchall_0

    throw v2

    .line 1475
    :cond_2
    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedPaused:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne p1, v2, :cond_4

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    sget-object v3, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileRemoved:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-eq v2, v3, :cond_3

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    sget-object v3, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadFileExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    if-ne v2, v3, :cond_4

    .line 1477
    :cond_3
    iput-boolean v5, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->pauseAfterRemove:Z

    goto :goto_0

    .line 1487
    :cond_4
    iput-object p1, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_0
.end method

.method readStreamBytes(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Object;Lorg/apache/http/HttpResponse;Ljava/io/File;DI)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 11
    .param p1, "method"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .param p2, "obj"    # Ljava/lang/Object;
    .param p3, "response"    # Lorg/apache/http/HttpResponse;
    .param p4, "file"    # Ljava/io/File;
    .param p5, "expectedFileSize"    # D
    .param p7, "connectionType"    # I
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2166
    const/4 v9, 0x0

    move-object v1, p0

    move-object v2, p1

    move-object v3, p2

    move-object v4, p3

    move-object v5, p4

    move-wide/from16 v6, p5

    move/from16 v8, p7

    invoke-virtual/range {v1 .. v9}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->readStreamBytes(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Object;Lorg/apache/http/HttpResponse;Ljava/io/File;DIZ)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v0

    return-object v0
.end method

.method readStreamBytes(Lorg/apache/http/client/methods/HttpRequestBase;Ljava/lang/Object;Lorg/apache/http/HttpResponse;Ljava/io/File;DIZ)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .locals 41
    .param p1, "method"    # Lorg/apache/http/client/methods/HttpRequestBase;
    .param p2, "obj"    # Ljava/lang/Object;
    .param p3, "response"    # Lorg/apache/http/HttpResponse;
    .param p4, "file"    # Ljava/io/File;
    .param p5, "expectedFileSize"    # D
    .param p7, "connectionType"    # I
    .param p8, "isFragment"    # Z
    .annotation system Ldalvik/annotation/Throws;
        value = {
            Ljava/io/IOException;
        }
    .end annotation

    .prologue
    .line 2172
    new-instance v16, Lcom/penthera/virtuososdk/download/MD5;

    invoke-direct/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;-><init>()V

    .line 2173
    .local v16, "md5":Lcom/penthera/virtuososdk/download/MD5;
    if-eqz p8, :cond_b

    const/16 v31, 0x0

    .line 2174
    .local v31, "updateMd5AndProgress":Z
    :goto_0
    const/4 v12, 0x0

    .line 2175
    .local v12, "engFile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    const/4 v13, 0x0

    .line 2176
    .local v13, "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    if-eqz p8, :cond_0

    move-object/from16 v13, p2

    .line 2177
    check-cast v13, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;

    .line 2180
    :cond_0
    if-eqz v31, :cond_1

    .line 2181
    move-object/from16 v0, p0

    iget-object v12, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    .end local v12    # "engFile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    check-cast v12, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;

    .line 2183
    .restart local v12    # "engFile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    :cond_1
    const/16 v19, 0x0

    .line 2185
    .local v19, "ostream":Ljava/io/FileOutputStream;
    :try_start_0
    new-instance v20, Ljava/io/FileOutputStream;

    const/16 v34, 0x1

    move-object/from16 v0, v20

    move-object/from16 v1, p4

    move/from16 v2, v34

    invoke-direct {v0, v1, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V
    :try_end_0
    .catch Ljava/io/FileNotFoundException; {:try_start_0 .. :try_end_0} :catch_0

    .end local v19    # "ostream":Ljava/io/FileOutputStream;
    .local v20, "ostream":Ljava/io/FileOutputStream;
    move-object/from16 v19, v20

    .line 2196
    .end local v20    # "ostream":Ljava/io/FileOutputStream;
    .restart local v19    # "ostream":Ljava/io/FileOutputStream;
    :goto_1
    const/4 v11, 0x0

    .line 2197
    .local v11, "endofstream":Z
    invoke-interface/range {p3 .. p3}, Lorg/apache/http/HttpResponse;->getEntity()Lorg/apache/http/HttpEntity;

    move-result-object v34

    invoke-interface/range {v34 .. v34}, Lorg/apache/http/HttpEntity;->getContent()Ljava/io/InputStream;

    move-result-object v14

    .line 2200
    .local v14, "inputStream":Ljava/io/InputStream;
    const/16 v4, 0x2000

    .line 2201
    .local v4, "BUFFER_SIZE":I
    const/16 v34, 0x2000

    move/from16 v0, v34

    new-array v6, v0, [B

    .line 2202
    .local v6, "b":[B
    invoke-virtual/range {p4 .. p4}, Ljava/io/File;->length()J

    move-result-wide v32

    .line 2203
    .local v32, "totalBytes":J
    const/16 v24, 0x0

    .local v24, "progressChunks":I
    const/16 v23, 0x0

    .local v23, "permissionChunks":I
    const/16 v27, 0x0

    .line 2204
    .local v27, "quotaChunks":I
    if-eqz p8, :cond_c

    const-wide/high16 v34, 0x3fd0000000000000L    # 0.25

    mul-double v34, v34, p5

    :goto_2
    move-wide/from16 v0, v34

    double-to-int v0, v0

    move/from16 v25, v0

    .line 2205
    .local v25, "progressUpdateSize":I
    if-eqz p8, :cond_d

    const/high16 v28, 0x20000

    .line 2206
    .local v28, "quotaUpdateSize":I
    :goto_3
    const-wide/high16 v34, 0x4108000000000000L    # 196608.0

    cmpg-double v34, p5, v34

    if-gez v34, :cond_e

    const-wide/high16 v34, 0x3fe0000000000000L    # 0.5

    mul-double v34, v34, p5

    move-wide/from16 v0, v34

    double-to-int v0, v0

    move/from16 v22, v0

    .line 2208
    .local v22, "permissionCheckThreshold":I
    :goto_4
    if-eqz v31, :cond_2

    .line 2209
    invoke-interface {v12}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->md5State()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v16

    move-object/from16 v1, v34

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/MD5;->setState(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2211
    :cond_2
    if-nez p7, :cond_3

    .line 2212
    const/high16 v34, 0x20000

    move/from16 v0, v25

    move/from16 v1, v34

    if-le v0, v1, :cond_f

    .line 2213
    const/high16 v28, 0x20000

    .line 2216
    :cond_3
    :goto_5
    if-eqz v31, :cond_10

    .line 2217
    move-wide/from16 v0, v32

    long-to-double v0, v0

    move-wide/from16 v34, v0

    move-object/from16 v0, p0

    move-wide/from16 v1, v34

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(D)V

    .line 2221
    :goto_6
    new-instance v26, Landroid/os/Bundle;

    invoke-direct/range {v26 .. v26}, Landroid/os/Bundle;-><init>()V

    .line 2222
    .local v26, "quotaBundle":Landroid/os/Bundle;
    const-string v35, "bearer"

    if-nez p7, :cond_11

    .line 2223
    sget-object v34, Lcom/penthera/virtuososdk/Common$BearerType;->cellular:Lcom/penthera/virtuososdk/Common$BearerType;

    invoke-virtual/range {v34 .. v34}, Lcom/penthera/virtuososdk/Common$BearerType;->ordinal()I

    move-result v34

    .line 2222
    :goto_7
    move-object/from16 v0, v26

    move-object/from16 v1, v35

    move/from16 v2, v34

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2224
    const-string v34, "bearer_action"

    sget-object v35, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->EDownload:Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;

    invoke-virtual/range {v35 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$BearerAction;->ordinal()I

    move-result v35

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2227
    :cond_4
    :goto_8
    if-eqz v11, :cond_12

    .line 2349
    if-eqz v31, :cond_5

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_5
    if-lez v27, :cond_6

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_6
    :try_start_1
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_7

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_1
    .catch Ljava/net/SocketException; {:try_start_1 .. :try_end_1} :catch_15
    .catch Ljava/io/IOException; {:try_start_1 .. :try_end_1} :catch_13

    .line 2369
    :cond_7
    :goto_9
    :try_start_2
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_8

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_2
    .catch Ljava/io/IOException; {:try_start_2 .. :try_end_2} :catch_14

    .line 2376
    :cond_8
    :goto_a
    if-eqz v31, :cond_3e

    .line 2377
    invoke-interface {v12}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->fileMD5()Ljava/lang/String;

    move-result-object v30

    .line 2378
    .local v30, "reportedHash":Ljava/lang/String;
    invoke-static/range {v30 .. v30}, Landroid/text/TextUtils;->isEmpty(Ljava/lang/CharSequence;)Z

    move-result v34

    if-eqz v34, :cond_3d

    .line 2379
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "file: {"

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v36, v0

    invoke-interface/range {v36 .. v36}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetURL()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ", "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v36, v0

    invoke-interface/range {v36 .. v36}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetId()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ", "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-interface {v12}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ", NO_HASH_IN_MD} has hash of ["

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->getHashString()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "]"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2389
    :cond_9
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v34, v0

    invoke-interface/range {v34 .. v34}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->expectedSize()D

    move-result-wide v34

    move-wide/from16 v0, v34

    invoke-interface {v12, v0, v1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setCurrentSize(D)V

    .line 2390
    const/16 v34, 0x0

    move/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setPending(Z)V

    .line 2395
    .end local v30    # "reportedHash":Ljava/lang/String;
    :goto_b
    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadComplete:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .end local v4    # "BUFFER_SIZE":I
    .end local v6    # "b":[B
    .end local v11    # "endofstream":Z
    .end local v14    # "inputStream":Ljava/io/InputStream;
    .end local v22    # "permissionCheckThreshold":I
    .end local v23    # "permissionChunks":I
    .end local v24    # "progressChunks":I
    .end local v25    # "progressUpdateSize":I
    .end local v26    # "quotaBundle":Landroid/os/Bundle;
    .end local v27    # "quotaChunks":I
    .end local v28    # "quotaUpdateSize":I
    .end local v32    # "totalBytes":J
    :cond_a
    :goto_c
    return-object v10

    .line 2173
    .end local v12    # "engFile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    .end local v13    # "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    .end local v19    # "ostream":Ljava/io/FileOutputStream;
    .end local v31    # "updateMd5AndProgress":Z
    :cond_b
    const/16 v31, 0x1

    goto/16 :goto_0

    .line 2186
    .restart local v12    # "engFile":Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;
    .restart local v13    # "fragment":Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;
    .restart local v19    # "ostream":Ljava/io/FileOutputStream;
    .restart local v31    # "updateMd5AndProgress":Z
    :catch_0
    move-exception v8

    .line 2187
    .local v8, "e":Ljava/io/FileNotFoundException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "wait and retry - file not found: "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {p4 .. p4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2189
    const-wide/16 v34, 0x64

    :try_start_3
    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sleep(J)V

    .line 2190
    new-instance v20, Ljava/io/FileOutputStream;

    const/16 v34, 0x1

    move-object/from16 v0, v20

    move-object/from16 v1, p4

    move/from16 v2, v34

    invoke-direct {v0, v1, v2}, Ljava/io/FileOutputStream;-><init>(Ljava/io/File;Z)V
    :try_end_3
    .catch Ljava/lang/Exception; {:try_start_3 .. :try_end_3} :catch_1

    .end local v19    # "ostream":Ljava/io/FileOutputStream;
    .restart local v20    # "ostream":Ljava/io/FileOutputStream;
    move-object/from16 v19, v20

    .end local v20    # "ostream":Ljava/io/FileOutputStream;
    .restart local v19    # "ostream":Ljava/io/FileOutputStream;
    goto/16 :goto_1

    .line 2191
    :catch_1
    move-exception v9

    .line 2192
    .local v9, "e1":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "file not found: "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    invoke-virtual/range {p4 .. p4}, Ljava/io/File;->getName()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, " "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual {v9}, Ljava/lang/Exception;->getMessage()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 2193
    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFile:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto :goto_c

    .line 2204
    .end local v8    # "e":Ljava/io/FileNotFoundException;
    .end local v9    # "e1":Ljava/lang/Exception;
    .restart local v4    # "BUFFER_SIZE":I
    .restart local v6    # "b":[B
    .restart local v11    # "endofstream":Z
    .restart local v14    # "inputStream":Ljava/io/InputStream;
    .restart local v23    # "permissionChunks":I
    .restart local v24    # "progressChunks":I
    .restart local v27    # "quotaChunks":I
    .restart local v32    # "totalBytes":J
    :cond_c
    const-wide v34, 0x3f847ae147ae147bL    # 0.01

    mul-double v34, v34, p5

    goto/16 :goto_2

    .restart local v25    # "progressUpdateSize":I
    :cond_d
    move/from16 v28, v25

    .line 2205
    goto/16 :goto_3

    .line 2206
    .restart local v28    # "quotaUpdateSize":I
    :cond_e
    const/high16 v22, 0x30000

    goto/16 :goto_4

    .restart local v22    # "permissionCheckThreshold":I
    :cond_f
    move/from16 v28, v25

    .line 2213
    goto/16 :goto_5

    .line 2219
    :cond_10
    move-wide/from16 v0, v32

    long-to-double v0, v0

    move-wide/from16 v34, v0

    move-wide/from16 v0, v34

    invoke-interface {v13, v0, v1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setCurrentSize(D)V

    goto/16 :goto_6

    .line 2223
    .restart local v26    # "quotaBundle":Landroid/os/Bundle;
    :cond_11
    sget-object v34, Lcom/penthera/virtuososdk/Common$BearerType;->wifi:Lcom/penthera/virtuososdk/Common$BearerType;

    invoke-virtual/range {v34 .. v34}, Lcom/penthera/virtuososdk/Common$BearerType;->ordinal()I

    move-result v34

    goto/16 :goto_7

    .line 2228
    :cond_12
    :try_start_4
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z

    move/from16 v34, v0

    if-eqz v34, :cond_16

    .line 2229
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    move-object/from16 v34, v0

    invoke-virtual/range {v34 .. v34}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->clear()V

    .line 2230
    invoke-virtual/range {p1 .. p1}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 2231
    move-object/from16 v0, p0

    iget-object v10, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_4
    .catch Ljava/io/IOException; {:try_start_4 .. :try_end_4} :catch_d
    .catchall {:try_start_4 .. :try_end_4} :catchall_0

    .line 2349
    if-eqz v31, :cond_13

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_13
    if-lez v27, :cond_14

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_14
    :try_start_5
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_15

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_5
    .catch Ljava/net/SocketException; {:try_start_5 .. :try_end_5} :catch_1d
    .catch Ljava/io/IOException; {:try_start_5 .. :try_end_5} :catch_3

    .line 2369
    :cond_15
    :goto_d
    :try_start_6
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_a

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_6
    .catch Ljava/io/IOException; {:try_start_6 .. :try_end_6} :catch_2

    goto/16 :goto_c

    .line 2372
    :catch_2
    move-exception v8

    .line 2373
    .local v8, "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_c

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    :catch_3
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_d

    .line 2233
    .end local v8    # "e":Ljava/io/IOException;
    :cond_16
    const-wide/high16 v34, 0x40c0000000000000L    # 8192.0

    const-wide/16 v36, 0x0

    move-wide/from16 v0, v32

    long-to-double v0, v0

    move-wide/from16 v38, v0

    sub-double v38, p5, v38

    :try_start_7
    invoke-static/range {v36 .. v39}, Ljava/lang/Math;->max(DD)D

    move-result-wide v36

    invoke-static/range {v34 .. v37}, Ljava/lang/Math;->min(DD)D

    move-result-wide v34

    move-wide/from16 v0, v34

    double-to-int v0, v0

    move/from16 v17, v0

    .line 2235
    .local v17, "next_expected_storage":I
    if-nez p7, :cond_23

    .line 2236
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;
    invoke-static/range {v34 .. v34}, Lcom/penthera/virtuososdk/download/Downloader;->access$18(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v34

    const-string v35, "enable_download_cell"

    const/16 v36, 0x1

    invoke-virtual/range {v34 .. v36}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v34

    if-nez v34, :cond_1a

    .line 2237
    invoke-virtual/range {p1 .. p1}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 2238
    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_7
    .catch Ljava/io/IOException; {:try_start_7 .. :try_end_7} :catch_d
    .catchall {:try_start_7 .. :try_end_7} :catchall_0

    .line 2349
    if-eqz v31, :cond_17

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_17
    if-lez v27, :cond_18

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_18
    :try_start_8
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_19

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_8
    .catch Ljava/net/SocketException; {:try_start_8 .. :try_end_8} :catch_1c
    .catch Ljava/io/IOException; {:try_start_8 .. :try_end_8} :catch_5

    .line 2369
    :cond_19
    :goto_e
    :try_start_9
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_a

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_9
    .catch Ljava/io/IOException; {:try_start_9 .. :try_end_9} :catch_4

    goto/16 :goto_c

    .line 2372
    :catch_4
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_c

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    :catch_5
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_e

    .line 2240
    .end local v8    # "e":Ljava/io/IOException;
    :cond_1a
    :try_start_a
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader;->cellOkay(I)Z

    move-result v34

    if-nez v34, :cond_1b

    .line 2241
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    invoke-virtual/range {v34 .. v34}, Lcom/penthera/virtuososdk/download/Downloader;->availableCellUsage()D

    move-result-wide v34

    move-wide/from16 v0, v34

    double-to-int v5, v0

    .line 2242
    .local v5, "available":I
    if-lez v5, :cond_1f

    .line 2243
    new-array v6, v5, [B

    .line 2254
    .end local v5    # "available":I
    :cond_1b
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader;->storageOkay(I)Z

    move-result v34

    if-nez v34, :cond_27

    .line 2256
    new-instance v34, Ljava/lang/StringBuilder;

    const-string v35, "Storage reported not okay - {\"storage_data\":{\"allowed_storage\" : "

    invoke-direct/range {v34 .. v35}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    const-string v35, "%1$,.2f"

    const/16 v36, 0x1

    move/from16 v0, v36

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v36, v0

    const/16 v37, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedStorageUsage:D

    move-wide/from16 v38, v0

    invoke-static/range {v38 .. v39}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v38

    aput-object v38, v36, v37

    invoke-static/range {v35 .. v36}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v35

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2257
    const-string v35, ", \"allowed_cell\" : "

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    const-string v35, "%1$,.2f"

    const/16 v36, 0x1

    move/from16 v0, v36

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v36, v0

    const/16 v37, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iAllowedCellUsage:D

    move-wide/from16 v38, v0

    invoke-static/range {v38 .. v39}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v38

    aput-object v38, v36, v37

    invoke-static/range {v35 .. v36}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v35

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2258
    const-string v35, ", \"current_storage\" : "

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    const-string v35, "%1$,.2f"

    const/16 v36, 0x1

    move/from16 v0, v36

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v36, v0

    const/16 v37, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    move-wide/from16 v38, v0

    invoke-static/range {v38 .. v39}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v38

    aput-object v38, v36, v37

    invoke-static/range {v35 .. v36}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v35

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2259
    const-string v35, ", \"current_cell\" : "

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    const-string v35, "%1$,.2f"

    const/16 v36, 0x1

    move/from16 v0, v36

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v36, v0

    const/16 v37, 0x0

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v38, v0

    move-object/from16 v0, v38

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    move-wide/from16 v38, v0

    invoke-static/range {v38 .. v39}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v38

    aput-object v38, v36, v37

    invoke-static/range {v35 .. v36}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v35

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    const-string v35, "}"

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2260
    const-string v35, ", \"storage_increase_calc_data\" : { \"buffer_size\" : "

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    const/16 v35, 0x2000

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2261
    const-string v35, ", \"expected_size\" : "

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    const-string v35, "%1$,.2f"

    const/16 v36, 0x1

    move/from16 v0, v36

    new-array v0, v0, [Ljava/lang/Object;

    move-object/from16 v36, v0

    const/16 v37, 0x0

    invoke-static/range {p5 .. p6}, Ljava/lang/Double;->valueOf(D)Ljava/lang/Double;

    move-result-object v38

    aput-object v38, v36, v37

    invoke-static/range {v35 .. v36}, Ljava/lang/String;->format(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;

    move-result-object v35

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2262
    const-string v35, ", \"total_bytes\" : "

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    move-object/from16 v0, v34

    move-wide/from16 v1, v32

    invoke-virtual {v0, v1, v2}, Ljava/lang/StringBuilder;->append(J)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2263
    const-string v35, ", \"next_expected_storage\" : "

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    move-object/from16 v0, v34

    move/from16 v1, v17

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(I)Ljava/lang/StringBuilder;

    move-result-object v34

    const-string v35, " } }"

    invoke-virtual/range {v34 .. v35}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v34

    .line 2256
    invoke-virtual/range {v34 .. v34}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v15

    .line 2264
    .local v15, "logString":Ljava/lang/String;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-static {v0, v15}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2266
    invoke-virtual/range {p1 .. p1}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 2267
    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedStorage:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_a
    .catch Ljava/io/IOException; {:try_start_a .. :try_end_a} :catch_d
    .catchall {:try_start_a .. :try_end_a} :catchall_0

    .line 2349
    if-eqz v31, :cond_1c

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_1c
    if-lez v27, :cond_1d

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_1d
    :try_start_b
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_1e

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_b
    .catch Ljava/net/SocketException; {:try_start_b .. :try_end_b} :catch_19
    .catch Ljava/io/IOException; {:try_start_b .. :try_end_b} :catch_b

    .line 2369
    :cond_1e
    :goto_f
    :try_start_c
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_a

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_c
    .catch Ljava/io/IOException; {:try_start_c .. :try_end_c} :catch_6

    goto/16 :goto_c

    .line 2372
    :catch_6
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_c

    .line 2245
    .end local v8    # "e":Ljava/io/IOException;
    .end local v15    # "logString":Ljava/lang/String;
    .restart local v5    # "available":I
    :cond_1f
    :try_start_d
    invoke-virtual/range {p1 .. p1}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 2246
    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedCell:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_d
    .catch Ljava/io/IOException; {:try_start_d .. :try_end_d} :catch_d
    .catchall {:try_start_d .. :try_end_d} :catchall_0

    .line 2349
    if-eqz v31, :cond_20

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_20
    if-lez v27, :cond_21

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_21
    :try_start_e
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_22

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_e
    .catch Ljava/net/SocketException; {:try_start_e .. :try_end_e} :catch_1b
    .catch Ljava/io/IOException; {:try_start_e .. :try_end_e} :catch_8

    .line 2369
    :cond_22
    :goto_10
    :try_start_f
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_a

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_f
    .catch Ljava/io/IOException; {:try_start_f .. :try_end_f} :catch_7

    goto/16 :goto_c

    .line 2372
    :catch_7
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_c

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    :catch_8
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_10

    .line 2249
    .end local v5    # "available":I
    .end local v8    # "e":Ljava/io/IOException;
    :cond_23
    const/16 v34, 0x1

    move/from16 v0, p7

    move/from16 v1, v34

    if-ne v0, v1, :cond_1b

    :try_start_10
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->iTestBundle:Landroid/os/Bundle;
    invoke-static/range {v34 .. v34}, Lcom/penthera/virtuososdk/download/Downloader;->access$18(Lcom/penthera/virtuososdk/download/Downloader;)Landroid/os/Bundle;

    move-result-object v34

    const-string v35, "enable_download_wifi"

    const/16 v36, 0x1

    invoke-virtual/range {v34 .. v36}, Landroid/os/Bundle;->getBoolean(Ljava/lang/String;Z)Z

    move-result v34

    if-nez v34, :cond_1b

    .line 2250
    invoke-virtual/range {p1 .. p1}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 2251
    sget-object v34, Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;->EDownloadBlockedWifi:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-object/from16 v0, p0

    move-object/from16 v1, v34

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->permissionDeniedToFileCompletion(Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_10
    .catch Ljava/io/IOException; {:try_start_10 .. :try_end_10} :catch_d
    .catchall {:try_start_10 .. :try_end_10} :catchall_0

    move-result-object v10

    .line 2349
    if-eqz v31, :cond_24

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_24
    if-lez v27, :cond_25

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_25
    :try_start_11
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_26

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_11
    .catch Ljava/net/SocketException; {:try_start_11 .. :try_end_11} :catch_1a
    .catch Ljava/io/IOException; {:try_start_11 .. :try_end_11} :catch_a

    .line 2369
    :cond_26
    :goto_11
    :try_start_12
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_a

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_12
    .catch Ljava/io/IOException; {:try_start_12 .. :try_end_12} :catch_9

    goto/16 :goto_c

    .line 2372
    :catch_9
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_c

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    :catch_a
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_11

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    .restart local v15    # "logString":Ljava/lang/String;
    :catch_b
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_f

    .line 2270
    .end local v8    # "e":Ljava/io/IOException;
    .end local v15    # "logString":Ljava/lang/String;
    :cond_27
    :try_start_13
    invoke-virtual {v14, v6}, Ljava/io/InputStream;->read([B)I

    move-result v18

    .line 2271
    .local v18, "numBytes":I
    add-int v24, v24, v18

    .line 2272
    add-int v23, v23, v18

    .line 2273
    add-int v27, v27, v18

    .line 2274
    move/from16 v0, v18

    int-to-long v0, v0

    move-wide/from16 v34, v0

    add-long v32, v32, v34

    .line 2277
    if-lez v18, :cond_38

    .line 2279
    const/16 v34, 0x0

    move-object/from16 v0, v19

    move/from16 v1, v34

    move/from16 v2, v18

    invoke-virtual {v0, v6, v1, v2}, Ljava/io/FileOutputStream;->write([BII)V

    .line 2281
    if-eqz v31, :cond_28

    .line 2282
    const/16 v34, 0x0

    move-object/from16 v0, v16

    move/from16 v1, v34

    move/from16 v2, v18

    invoke-virtual {v0, v6, v1, v2}, Lcom/penthera/virtuososdk/download/MD5;->update([BII)V

    .line 2284
    :cond_28
    if-nez p7, :cond_29

    .line 2285
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    move-wide/from16 v36, v0

    move/from16 v0, v18

    int-to-double v0, v0

    move-wide/from16 v38, v0

    add-double v36, v36, v38

    move-wide/from16 v0, v36

    move-object/from16 v2, v34

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentCellUsage:D

    .line 2286
    :cond_29
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    move-wide/from16 v36, v0

    move/from16 v0, v18

    int-to-double v0, v0

    move-wide/from16 v38, v0

    add-double v36, v36, v38

    move-wide/from16 v0, v36

    move-object/from16 v2, v34

    iput-wide v0, v2, Lcom/penthera/virtuososdk/download/Downloader;->iCurrentStorageUsage:D

    .line 2288
    move/from16 v0, v27

    move/from16 v1, v28

    if-lt v0, v1, :cond_2a

    .line 2290
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2291
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2292
    const-string v34, "next_storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v17

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2293
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2294
    const/16 v27, 0x0

    .line 2299
    :cond_2a
    move/from16 v0, v24

    move/from16 v1, v25

    if-lt v0, v1, :cond_35

    .line 2301
    if-eqz v31, :cond_30

    .line 2302
    move-wide/from16 v0, v32

    long-to-double v0, v0

    move-wide/from16 v34, v0

    move-object/from16 v0, p0

    move-wide/from16 v1, v34

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(D)V

    .line 2309
    :cond_2b
    :goto_12
    const/16 v24, 0x0

    .line 2320
    :cond_2c
    :goto_13
    move/from16 v0, v23

    move/from16 v1, v22

    if-lt v0, v1, :cond_4

    .line 2322
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    move-object/from16 v34, v0

    invoke-virtual/range {v34 .. v34}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->isSet()Z

    move-result v34

    if-eqz v34, :cond_37

    .line 2323
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iPermission:Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;

    move-object/from16 v21, v0

    .line 2324
    .local v21, "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->iReason:Lcom/penthera/virtuososdk/download/Downloader$EStopReason;

    move-object/from16 v29, v0

    .line 2325
    .local v29, "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "downloadItem(): Download being stopped: "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, v35

    move-object/from16 v1, v21

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, " reason: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    move-object/from16 v0, v35

    move-object/from16 v1, v29

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/Object;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 2326
    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v34, v0

    move-object/from16 v0, v34

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadStop:Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;

    move-object/from16 v34, v0

    invoke-virtual/range {v34 .. v34}, Lcom/penthera/virtuososdk/download/Downloader$DownloadStop;->clear()V

    .line 2327
    invoke-virtual/range {p1 .. p1}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 2328
    move-object/from16 v0, p0

    move-object/from16 v1, v21

    move-object/from16 v2, v29

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->permissionDeniedToFileCompletion(Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;Lcom/penthera/virtuososdk/download/Downloader$EStopReason;)Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_13
    .catch Ljava/io/IOException; {:try_start_13 .. :try_end_13} :catch_d
    .catchall {:try_start_13 .. :try_end_13} :catchall_0

    move-result-object v10

    .line 2349
    .local v10, "efdc":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    if-eqz v31, :cond_2d

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_2d
    if-lez v27, :cond_2e

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_2e
    :try_start_14
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_2f

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_14
    .catch Ljava/net/SocketException; {:try_start_14 .. :try_end_14} :catch_18
    .catch Ljava/io/IOException; {:try_start_14 .. :try_end_14} :catch_e

    .line 2369
    :cond_2f
    :goto_14
    :try_start_15
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_a

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_15
    .catch Ljava/io/IOException; {:try_start_15 .. :try_end_15} :catch_c

    goto/16 :goto_c

    .line 2372
    :catch_c
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_c

    .line 2305
    .end local v8    # "e":Ljava/io/IOException;
    .end local v10    # "efdc":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .end local v21    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .end local v29    # "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    :cond_30
    move-wide/from16 v0, v32

    long-to-double v0, v0

    move-wide/from16 v34, v0

    :try_start_16
    move-wide/from16 v0, v34

    invoke-interface {v13, v0, v1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setCurrentSize(D)V

    .line 2307
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z

    move/from16 v34, v0

    if-nez v34, :cond_2b

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v34, v0

    check-cast v34, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    move-object/from16 v0, p0

    move-object/from16 v1, v34

    invoke-direct {v0, v1, v13}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->reportHLSUpdate(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V
    :try_end_16
    .catch Ljava/io/IOException; {:try_start_16 .. :try_end_16} :catch_d
    .catchall {:try_start_16 .. :try_end_16} :catchall_0

    goto/16 :goto_12

    .line 2346
    .end local v17    # "next_expected_storage":I
    .end local v18    # "numBytes":I
    :catch_d
    move-exception v8

    .line 2347
    .restart local v8    # "e":Ljava/io/IOException;
    :try_start_17
    throw v8
    :try_end_17
    .catchall {:try_start_17 .. :try_end_17} :catchall_0

    .line 2348
    .end local v8    # "e":Ljava/io/IOException;
    :catchall_0
    move-exception v34

    .line 2349
    if-eqz v31, :cond_31

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v35

    move-object/from16 v0, v35

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_31
    if-lez v27, :cond_32

    .line 2353
    const-string v35, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v35

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v35, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v35

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v35, "next_storage_usage"

    const/16 v36, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v35

    move/from16 v2, v36

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_32
    :try_start_18
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v35

    new-instance v36, Ljava/lang/StringBuilder;

    const-string v37, "c[ "

    invoke-direct/range {v36 .. v37}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v37, v0

    move-object/from16 v0, v37

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v37, v0

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "] DownloadThread: closing istream"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    invoke-static/range {v35 .. v36}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_33

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_18
    .catch Ljava/net/SocketException; {:try_start_18 .. :try_end_18} :catch_16
    .catch Ljava/io/IOException; {:try_start_18 .. :try_end_18} :catch_11

    .line 2369
    :cond_33
    :goto_15
    :try_start_19
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v35

    new-instance v36, Ljava/lang/StringBuilder;

    const-string v37, "c[ "

    invoke-direct/range {v36 .. v37}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v37, v0

    move-object/from16 v0, v37

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v37, v0

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "] downloadFile(): closing ostream"

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    invoke-static/range {v35 .. v36}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_34

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_19
    .catch Ljava/io/IOException; {:try_start_19 .. :try_end_19} :catch_12

    .line 2375
    :cond_34
    :goto_16
    throw v34

    .line 2310
    .restart local v17    # "next_expected_storage":I
    .restart local v18    # "numBytes":I
    :cond_35
    :try_start_1a
    invoke-static {}, Ljava/lang/System;->currentTimeMillis()J

    move-result-wide v34

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iLastUpdateTime:J

    move-wide/from16 v36, v0

    sub-long v34, v34, v36

    move-object/from16 v0, p0

    iget-wide v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iMinimumUpdateInterval:J

    move-wide/from16 v36, v0

    cmp-long v34, v34, v36

    if-ltz v34, :cond_2c

    .line 2311
    if-eqz v31, :cond_36

    .line 2312
    move-wide/from16 v0, v32

    long-to-double v0, v0

    move-wide/from16 v34, v0

    move-object/from16 v0, p0

    move-wide/from16 v1, v34

    invoke-direct {v0, v1, v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->updateDownloadProgress(D)V

    goto/16 :goto_13

    .line 2314
    :cond_36
    move-wide/from16 v0, v32

    long-to-double v0, v0

    move-wide/from16 v34, v0

    move-wide/from16 v0, v34

    invoke-interface {v13, v0, v1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setCurrentSize(D)V

    .line 2315
    move-object/from16 v0, p0

    iget-boolean v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z

    move/from16 v34, v0

    if-nez v34, :cond_2c

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v34, v0

    check-cast v34, Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;

    move-object/from16 v0, p0

    move-object/from16 v1, v34

    invoke-direct {v0, v1, v13}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->reportHLSUpdate(Lcom/penthera/virtuososdk/internal/interfaces/IEngVHLSFile;Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;)V
    :try_end_1a
    .catch Ljava/io/IOException; {:try_start_1a .. :try_end_1a} :catch_d
    .catchall {:try_start_1a .. :try_end_1a} :catchall_0

    goto/16 :goto_13

    .line 2365
    .restart local v10    # "efdc":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .restart local v21    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .restart local v29    # "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    :catch_e
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_14

    .line 2332
    .end local v8    # "e":Ljava/io/IOException;
    .end local v10    # "efdc":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .end local v21    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .end local v29    # "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    :cond_37
    const/16 v23, 0x0

    goto/16 :goto_8

    .line 2336
    :cond_38
    if-gez v18, :cond_39

    .line 2337
    :try_start_1b
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] reached EOF"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 2338
    const/4 v11, 0x1

    goto/16 :goto_8

    .line 2341
    :cond_39
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    const-string v35, "File corrupt: End of stream not found"

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;)V

    .line 2342
    invoke-virtual/range {p1 .. p1}, Lorg/apache/http/client/methods/HttpRequestBase;->abort()V

    .line 2343
    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFile:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :try_end_1b
    .catch Ljava/io/IOException; {:try_start_1b .. :try_end_1b} :catch_d
    .catchall {:try_start_1b .. :try_end_1b} :catchall_0

    .line 2349
    if-eqz v31, :cond_3a

    .line 2350
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->currentState()Lcom/penthera/virtuososdk/download/MD5State;

    move-result-object v34

    move-object/from16 v0, v34

    invoke-interface {v12, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->setMd5State(Lcom/penthera/virtuososdk/download/MD5State;)V

    .line 2351
    :cond_3a
    if-lez v27, :cond_3b

    .line 2353
    const-string v34, "bearer_data_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2354
    const-string v34, "storage_usage"

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v27

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2355
    const-string v34, "next_storage_usage"

    const/16 v35, 0x0

    move-object/from16 v0, v26

    move-object/from16 v1, v34

    move/from16 v2, v35

    invoke-virtual {v0, v1, v2}, Landroid/os/Bundle;->putInt(Ljava/lang/String;I)V

    .line 2356
    move-object/from16 v0, p0

    move-object/from16 v1, v26

    invoke-direct {v0, v1}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->sendQuotaUpdate(Landroid/os/Bundle;)V

    .line 2359
    :cond_3b
    :try_start_1c
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] DownloadThread: closing istream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2360
    if-eqz v14, :cond_3c

    .line 2361
    invoke-virtual {v14}, Ljava/io/InputStream;->close()V
    :try_end_1c
    .catch Ljava/net/SocketException; {:try_start_1c .. :try_end_1c} :catch_17
    .catch Ljava/io/IOException; {:try_start_1c .. :try_end_1c} :catch_10

    .line 2369
    :cond_3c
    :goto_17
    :try_start_1d
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] downloadFile(): closing ostream"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2370
    if-eqz v19, :cond_a

    .line 2371
    invoke-virtual/range {v19 .. v19}, Ljava/io/FileOutputStream;->close()V
    :try_end_1d
    .catch Ljava/io/IOException; {:try_start_1d .. :try_end_1d} :catch_f

    goto/16 :goto_c

    .line 2372
    :catch_f
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_c

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    :catch_10
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_17

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    .end local v17    # "next_expected_storage":I
    .end local v18    # "numBytes":I
    :catch_11
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v35

    new-instance v36, Ljava/lang/StringBuilder;

    const-string v37, "c[ "

    invoke-direct/range {v36 .. v37}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v37, v0

    move-object/from16 v0, v37

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v37, v0

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "] Caught IOException while closing istream: "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v35

    move-object/from16 v1, v36

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_15

    .line 2372
    .end local v8    # "e":Ljava/io/IOException;
    :catch_12
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v35

    new-instance v36, Ljava/lang/StringBuilder;

    const-string v37, "c[ "

    invoke-direct/range {v36 .. v37}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v37, v0

    move-object/from16 v0, v37

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v37, v0

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    const-string v37, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v36 .. v37}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v36

    invoke-virtual/range {v36 .. v36}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v36

    move-object/from16 v0, v35

    move-object/from16 v1, v36

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_16

    .line 2365
    .end local v8    # "e":Ljava/io/IOException;
    :catch_13
    move-exception v8

    .line 2366
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing istream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_9

    .line 2372
    .end local v8    # "e":Ljava/io/IOException;
    :catch_14
    move-exception v8

    .line 2373
    .restart local v8    # "e":Ljava/io/IOException;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "c[ "

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    move-object/from16 v36, v0

    move-object/from16 v0, v36

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    move-object/from16 v36, v0

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "] Caught IOException while closing ostream: "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    move-object/from16 v0, v34

    move-object/from16 v1, v35

    invoke-static {v0, v1, v8}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto/16 :goto_a

    .line 2382
    .end local v8    # "e":Ljava/io/IOException;
    .restart local v30    # "reportedHash":Ljava/lang/String;
    :cond_3d
    invoke-virtual/range {v16 .. v16}, Lcom/penthera/virtuososdk/download/MD5;->getHashString()Ljava/lang/String;

    move-result-object v7

    .line 2383
    .local v7, "computedHash":Ljava/lang/String;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    new-instance v35, Ljava/lang/StringBuilder;

    const-string v36, "file: {"

    invoke-direct/range {v35 .. v36}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v36, v0

    invoke-interface/range {v36 .. v36}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetURL()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ", "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    move-object/from16 v0, p0

    iget-object v0, v0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    move-object/from16 v36, v0

    invoke-interface/range {v36 .. v36}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->assetId()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ", "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-interface {v12}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVFile;->filePath()Ljava/lang/String;

    move-result-object v36

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, ", "

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    move-object/from16 v0, v35

    move-object/from16 v1, v30

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "} has hash of ["

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    move-object/from16 v0, v35

    invoke-virtual {v0, v7}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    const-string v36, "]"

    invoke-virtual/range {v35 .. v36}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v35

    invoke-virtual/range {v35 .. v35}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v35

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 2384
    move-object/from16 v0, v30

    invoke-virtual {v7, v0}, Ljava/lang/String;->equalsIgnoreCase(Ljava/lang/String;)Z

    move-result v34

    if-nez v34, :cond_9

    .line 2385
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v34

    const-string v35, "hash verification failed"

    invoke-static/range {v34 .. v35}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->w(Ljava/lang/String;Ljava/lang/String;)V

    .line 2386
    sget-object v10, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorFileCorrupt:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    goto/16 :goto_c

    .line 2392
    .end local v7    # "computedHash":Ljava/lang/String;
    .end local v30    # "reportedHash":Ljava/lang/String;
    :cond_3e
    move-wide/from16 v0, p5

    invoke-interface {v13, v0, v1}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setCurrentSize(D)V

    .line 2393
    const/16 v34, 0x0

    move/from16 v0, v34

    invoke-interface {v13, v0}, Lcom/penthera/virtuososdk/internal/interfaces/IEngFileFragment;->setPending(Z)V

    goto/16 :goto_b

    .line 2362
    :catch_15
    move-exception v34

    goto/16 :goto_9

    :catch_16
    move-exception v35

    goto/16 :goto_15

    .restart local v17    # "next_expected_storage":I
    .restart local v18    # "numBytes":I
    :catch_17
    move-exception v34

    goto/16 :goto_17

    .restart local v10    # "efdc":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .restart local v21    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .restart local v29    # "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    :catch_18
    move-exception v34

    goto/16 :goto_14

    .end local v10    # "efdc":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    .end local v18    # "numBytes":I
    .end local v21    # "permission":Lcom/penthera/virtuososdk/download/Downloader$EDownloadPermission;
    .end local v29    # "reason":Lcom/penthera/virtuososdk/download/Downloader$EStopReason;
    .restart local v15    # "logString":Ljava/lang/String;
    :catch_19
    move-exception v34

    goto/16 :goto_f

    .end local v15    # "logString":Ljava/lang/String;
    :catch_1a
    move-exception v34

    goto/16 :goto_11

    .restart local v5    # "available":I
    :catch_1b
    move-exception v34

    goto/16 :goto_10

    .end local v5    # "available":I
    :catch_1c
    move-exception v34

    goto/16 :goto_e

    .end local v17    # "next_expected_storage":I
    :catch_1d
    move-exception v34

    goto/16 :goto_d
.end method

.method public run()V
    .locals 5

    .prologue
    .line 1501
    :try_start_0
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "c[ "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v4, v4, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] Download thread started"

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->i(Ljava/lang/String;Ljava/lang/String;)V

    .line 1502
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    invoke-interface {v2}, Lcom/penthera/virtuososdk/client/IVirtuosoAsset;->downloadStatus()Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    move-result-object v2

    sget-object v3, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kvDE_Expired:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    if-eq v2, v3, :cond_2

    .line 1503
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v2, v2, Lcom/penthera/virtuososdk/download/Downloader;->iStatus:Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;

    iget-object v2, v2, Lcom/penthera/virtuososdk/download/VirtuosoDownloadEngineStatus;->iStatus:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    if-eq v2, v3, :cond_0

    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v3, Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->setStatus(Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V
    invoke-static {v2, v3}, Lcom/penthera/virtuososdk/download/Downloader;->access$10(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/Common$EVirtuosoDownloadEngineStatus;)V

    .line 1504
    :cond_0
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    check-cast v2, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;

    sget-object v3, Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;->kVDE_Downloading:Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;

    invoke-interface {v2, v3}, Lcom/penthera/virtuososdk/internal/interfaces/IEngVIdentifier;->setDownloadStatus(Lcom/penthera/virtuososdk/Common$EFileDownloadStatus;)V

    .line 1505
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    sget-object v3, Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;->EDownloadStart:Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->iFile:Lcom/penthera/virtuososdk/client/IVirtuosoAsset;

    # invokes: Lcom/penthera/virtuososdk/download/Downloader;->sendBroadcastForDownloadUpdate(Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V
    invoke-static {v2, v3, v4}, Lcom/penthera/virtuososdk/download/Downloader;->access$3(Lcom/penthera/virtuososdk/download/Downloader;Lcom/penthera/virtuososdk/utility/CommonUtil$EDownloadCallbackType;Landroid/os/Parcelable;)V

    .line 1507
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v2, v2, Lcom/penthera/virtuososdk/download/Downloader;->iDownloadInfo:Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;

    const/4 v3, 0x0

    iput v3, v2, Lcom/penthera/virtuososdk/download/Downloader$DownloadInfo;->iDownloadExceptions:I

    .line 1508
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v3, 0x0

    iput-boolean v3, v2, Lcom/penthera/virtuososdk/download/Downloader;->iConnChangeResumePending:Z

    .line 1509
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    const/4 v3, 0x0

    iput-boolean v3, v2, Lcom/penthera/virtuososdk/download/Downloader;->iPowerChangeResumePending:Z

    .line 1510
    invoke-direct {p0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->tryDownloadFile()Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    move-result-object v0

    .line 1511
    .local v0, "code":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    iget-boolean v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killed:Z

    if-eqz v2, :cond_1

    iget-object v0, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->killCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1512
    :cond_1
    iget-object v2, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iput-object v0, v2, Lcom/penthera/virtuososdk/download/Downloader;->iLastFileCompletionErrorCode:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    .line 1513
    invoke-direct {p0, v0}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->HandleCompletion(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V

    .line 1521
    .end local v0    # "code":Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;
    :goto_0
    return-void

    .line 1516
    :cond_2
    sget-object v2, Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;->EDownloadBlockedErrorExpired:Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;

    invoke-direct {p0, v2}, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->HandleCompletion(Lcom/penthera/virtuososdk/utility/CommonUtil$EFileDownloadCompletion;)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    goto :goto_0

    .line 1518
    :catch_0
    move-exception v1

    .line 1519
    .local v1, "e":Ljava/lang/Exception;
    # getter for: Lcom/penthera/virtuososdk/download/Downloader;->LOG_TAG:Ljava/lang/String;
    invoke-static {}, Lcom/penthera/virtuososdk/download/Downloader;->access$0()Ljava/lang/String;

    move-result-object v2

    new-instance v3, Ljava/lang/StringBuilder;

    const-string v4, "c[ "

    invoke-direct {v3, v4}, Ljava/lang/StringBuilder;-><init>(Ljava/lang/String;)V

    iget-object v4, p0, Lcom/penthera/virtuososdk/download/Downloader$VirtuosoDownloadThread;->this$0:Lcom/penthera/virtuososdk/download/Downloader;

    iget-object v4, v4, Lcom/penthera/virtuososdk/download/Downloader;->iClientAuthority:Ljava/lang/String;

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    const-string v4, "] Uncaught exception in Download Thread: "

    invoke-virtual {v3, v4}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v3

    invoke-virtual {v3}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v3

    invoke-static {v2, v3, v1}, Lcom/penthera/virtuososdk/utility/CommonUtil$Log;->e(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V

    goto :goto_0
.end method
