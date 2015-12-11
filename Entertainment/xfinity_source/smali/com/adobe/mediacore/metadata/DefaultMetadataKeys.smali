.class public final enum Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum AD_BREAK_AS_WATCHED_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum AD_SIGNALING_MODE_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum BLACKOUT_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum CUSTOM_PARAMETERS:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum DISABLE_CONTENT_CACHING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum DRM_ERROR_STRING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum ENABLE_LIVE_PRE_ROLL:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum JSON_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum MARKER_CONTENT_DURATION_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum MARKER_CONTENT_ID_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum MARKER_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum METADATA_KEY_TYPE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum NATIVE_SUBERROR_CODE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum NETWORK_CONFIGURATION:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum NIELSEN_TRACKING_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

.field public static final enum VIDEO_ANALYTICS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;


# instance fields
.field private final _value:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 9

    const/4 v8, 0x4

    const/4 v7, 0x3

    const/4 v6, 0x2

    const/4 v5, 0x1

    const/4 v4, 0x0

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "ADVERTISING_METADATA"

    const-string v2, "advertising_metadata"

    invoke-direct {v0, v1, v4, v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "AUDITUDE_METADATA_KEY"

    const-string v2, "auditude_metadata"

    invoke-direct {v0, v1, v5, v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "JSON_METADATA_KEY"

    const-string v2, "json_metadata"

    invoke-direct {v0, v1, v6, v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->JSON_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "VIDEO_ANALYTICS_METADATA_KEY"

    const-string v2, "video_analytics_metadata_key"

    invoke-direct {v0, v1, v7, v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->VIDEO_ANALYTICS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "CUSTOM_AD_MARKERS_METADATA_KEY"

    const-string v2, "custom_ad_markers_metadata_key"

    invoke-direct {v0, v1, v8, v2}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "BLACKOUT_METADATA_KEY"

    const/4 v2, 0x5

    const-string v3, "blackout_metadata_key"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->BLACKOUT_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "TIME_RANGES_METADATA_KEY"

    const/4 v2, 0x6

    const-string v3, "time_ranges_metadata_key"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "ENABLE_LIVE_PRE_ROLL"

    const/4 v2, 0x7

    const-string v3, "enable_live_pre_roll"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ENABLE_LIVE_PRE_ROLL:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "METADATA_KEY_TYPE"

    const/16 v2, 0x8

    const-string v3, "type"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_TYPE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "METADATA_KEY_ADJUST_SEEK_ENABLED"

    const/16 v2, 0x9

    const-string v3, "adjust-seek-enabled"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "CUSTOM_PARAMETERS"

    const/16 v2, 0xa

    const-string v3, "custom_parameters"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_PARAMETERS:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "MARKER_KEY"

    const/16 v2, 0xb

    const-string v3, "marker_key"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "MARKER_CONTENT_ID_KEY"

    const/16 v2, 0xc

    const-string v3, "content_id_key"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_CONTENT_ID_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "MARKER_CONTENT_DURATION_KEY"

    const/16 v2, 0xd

    const-string v3, "content_duration_key"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_CONTENT_DURATION_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "AD_SIGNALING_MODE_KEY"

    const/16 v2, 0xe

    const-string v3, "ad_signaling_mode"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_SIGNALING_MODE_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "AD_BREAK_AS_WATCHED_KEY"

    const/16 v2, 0xf

    const-string v3, "ad_break_as_watched"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_BREAK_AS_WATCHED_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "DISABLE_CONTENT_CACHING"

    const/16 v2, 0x10

    const-string v3, "disable_content_caching"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->DISABLE_CONTENT_CACHING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "NETWORK_CONFIGURATION"

    const/16 v2, 0x11

    const-string v3, "network-configuration"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NETWORK_CONFIGURATION:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "NIELSEN_TRACKING_METADATA_KEY"

    const/16 v2, 0x12

    const-string v3, "nielsen_tracking_metadata_key"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NIELSEN_TRACKING_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "NATIVE_SUBERROR_CODE"

    const/16 v2, 0x13

    const-string v3, "NATIVE_SUBERROR_CODE"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NATIVE_SUBERROR_CODE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    new-instance v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const-string v1, "DRM_ERROR_STRING"

    const/16 v2, 0x14

    const-string v3, "DRM_ERROR_STRING"

    invoke-direct {v0, v1, v2, v3}, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;-><init>(Ljava/lang/String;ILjava/lang/String;)V

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->DRM_ERROR_STRING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    const/16 v0, 0x15

    new-array v0, v0, [Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ADVERTISING_METADATA:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AUDITUDE_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->JSON_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->VIDEO_ANALYTICS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_AD_MARKERS_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v1, v0, v8

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->BLACKOUT_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->TIME_RANGES_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->ENABLE_LIVE_PRE_ROLL:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_TYPE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->METADATA_KEY_ADJUST_SEEK_ENABLED:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->CUSTOM_PARAMETERS:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_CONTENT_ID_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->MARKER_CONTENT_DURATION_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_SIGNALING_MODE_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->AD_BREAK_AS_WATCHED_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->DISABLE_CONTENT_CACHING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NETWORK_CONFIGURATION:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NIELSEN_TRACKING_METADATA_KEY:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->NATIVE_SUBERROR_CODE:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->DRM_ERROR_STRING:Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->$VALUES:[Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    iput-object p3, p0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->_value:Ljava/lang/String;

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->$VALUES:[Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;

    return-object v0
.end method


# virtual methods
.method public getValue()Ljava/lang/String;
    .locals 1

    iget-object v0, p0, Lcom/adobe/mediacore/metadata/DefaultMetadataKeys;->_value:Ljava/lang/String;

    return-object v0
.end method
