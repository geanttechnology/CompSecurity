.class public final enum Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;
.super Ljava/lang/Enum;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerNotification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ErrorCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;",
        ">;",
        "Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum AD_INSERTION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum AD_RESOLVER_METADATA_INVALID:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum AD_RESOLVER_RESOLVE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum AUDIO_TRACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum CONTENT_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum DOWNLOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum ENGINE_CREATION_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum ENGINE_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum ENGINE_RESET_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum ENGINE_RESOURCES_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum ENGINE_SET_VIEW_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum GENERIC_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum GET_QOS_DATA_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum MANIFEST_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum NATIVE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum PAUSE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum PERIOD_INFO_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum PLAYBACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum RESOURCE_LOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum RESOURCE_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum RETRIEVE_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum SEEK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum SET_ABR_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum SET_BUFFER_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum SET_BUFFER_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum SET_CC_STYLING_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum SET_CC_VISIBILITY_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

.field public static final enum SET_VOLUME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;


# instance fields
.field private final _code:J


# direct methods
.method static constructor <clinit>()V
    .locals 11

    const/4 v10, 0x4

    const/4 v9, 0x3

    const/4 v8, 0x2

    const/4 v7, 0x1

    const/4 v6, 0x0

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "PLAYBACK_ERROR"

    const-wide/32 v2, 0x18a88

    invoke-direct {v0, v1, v6, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PLAYBACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "PAUSE_ERROR"

    const-wide/32 v2, 0x18a90

    invoke-direct {v0, v1, v7, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PAUSE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "SEEK_ERROR"

    const-wide/32 v2, 0x18a91

    invoke-direct {v0, v1, v8, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SEEK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "PERIOD_INFO_ERROR"

    const-wide/32 v2, 0x18aee

    invoke-direct {v0, v1, v9, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PERIOD_INFO_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "RETRIEVE_TIME_ERROR"

    const-wide/32 v2, 0x18aef

    invoke-direct {v0, v1, v10, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RETRIEVE_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "GET_QOS_DATA_ERROR"

    const/4 v2, 0x5

    const-wide/32 v4, 0x18af0

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->GET_QOS_DATA_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "RESOURCE_LOAD_ERROR"

    const/4 v2, 0x6

    const-wide/32 v4, 0x18ed4

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RESOURCE_LOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "RESOURCE_PLACEMENT_FAILED"

    const/4 v2, 0x7

    const-wide/32 v4, 0x18ed5

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RESOURCE_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "NATIVE_ERROR"

    const/16 v2, 0x8

    const-wide/32 v4, 0x19e10

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->NATIVE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "ENGINE_CREATION_ERROR"

    const/16 v2, 0x9

    const-wide/32 v4, 0x19e11

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_CREATION_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "ENGINE_RELEASE_ERROR"

    const/16 v2, 0xa

    const-wide/32 v4, 0x19e12

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "ENGINE_RESOURCES_RELEASE_ERROR"

    const/16 v2, 0xb

    const-wide/32 v4, 0x19e13

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RESOURCES_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "ENGINE_RESET_ERROR"

    const/16 v2, 0xc

    const-wide/32 v4, 0x19e14

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RESET_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "ENGINE_SET_VIEW_ERROR"

    const/16 v2, 0xd

    const-wide/32 v4, 0x19e15

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_SET_VIEW_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "SET_VOLUME_ERROR"

    const/16 v2, 0xe

    const-wide/32 v4, 0x1a1f8

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_VOLUME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "SET_BUFFER_TIME_ERROR"

    const/16 v2, 0xf

    const-wide/32 v4, 0x1a1f9

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_BUFFER_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "SET_CC_VISIBILITY_ERROR"

    const/16 v2, 0x10

    const-wide/32 v4, 0x1a1fa

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_CC_VISIBILITY_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "SET_CC_STYLING_ERROR"

    const/16 v2, 0x11

    const-wide/32 v4, 0x1a1fb

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_CC_STYLING_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "SET_ABR_PARAMETERS_ERROR"

    const/16 v2, 0x12

    const-wide/32 v4, 0x1a1fc

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_ABR_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "SET_BUFFER_PARAMETERS_ERROR"

    const/16 v2, 0x13

    const-wide/32 v4, 0x1a1fd

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_BUFFER_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "AD_RESOLVER_METADATA_INVALID"

    const/16 v2, 0x14

    const-wide/32 v4, 0x19641

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_METADATA_INVALID:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "AD_RESOLVER_RESOLVE_FAIL"

    const/16 v2, 0x15

    const-wide/32 v4, 0x19643

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_RESOLVE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "AD_INSERTION_FAIL"

    const/16 v2, 0x16

    const-wide/32 v4, 0x19645

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_INSERTION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "MANIFEST_ERROR"

    const/16 v2, 0x17

    const-wide/32 v4, 0x18a8a

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->MANIFEST_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "CONTENT_ERROR"

    const/16 v2, 0x18

    const-wide/32 v4, 0x18a8c

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->CONTENT_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "DOWNLOAD_ERROR"

    const/16 v2, 0x19

    const-wide/32 v4, 0x18b50

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->DOWNLOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "AUDIO_TRACK_ERROR"

    const/16 v2, 0x1a

    const-wide/32 v4, 0x1a9c8

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AUDIO_TRACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const-string v1, "GENERIC_ERROR"

    const/16 v2, 0x1b

    const-wide/32 v4, 0x30d3f

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->GENERIC_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    const/16 v0, 0x1c

    new-array v0, v0, [Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PLAYBACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PAUSE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SEEK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v1, v0, v8

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->PERIOD_INFO_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v1, v0, v9

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RETRIEVE_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v1, v0, v10

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->GET_QOS_DATA_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RESOURCE_LOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->RESOURCE_PLACEMENT_FAILED:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->NATIVE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_CREATION_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RESOURCES_RELEASE_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_RESET_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->ENGINE_SET_VIEW_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_VOLUME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_BUFFER_TIME_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_CC_VISIBILITY_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_CC_STYLING_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_ABR_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->SET_BUFFER_PARAMETERS_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_METADATA_INVALID:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_RESOLVER_RESOLVE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AD_INSERTION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->MANIFEST_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->CONTENT_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->DOWNLOAD_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->AUDIO_TRACK_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->GENERIC_ERROR:Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;IJ)V
    .locals 1
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(J)V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-wide p3, p0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->_code:J

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;

    return-object v0
.end method


# virtual methods
.method public getCode()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->_code:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lcom/adobe/mediacore/MediaPlayerNotification$ErrorCode;->name()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
