.class public final enum Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;
.super Ljava/lang/Enum;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerNotification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "InfoCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;",
        ">;",
        "Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_BREAK_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_CLICK:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AD_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum AUDIO_TRACK_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum BITRATE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum CONTENT_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum DRM_METADATA_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum GENERIC_INFO:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum LOAD_INFO_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum PLAYBACK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum PLAYBACK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum PLAYER_STATE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum SEEK_ADJUST_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum SEEK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum SEEK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum TIMED_METADATA_ADD:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum TIMED_METADATA_ADD_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum TIMELINE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

.field public static final enum VIDEO_SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;


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

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "PLAYBACK_START"

    const-wide/32 v2, 0x493e0

    invoke-direct {v0, v1, v6, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->PLAYBACK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "PLAYBACK_COMPLETE"

    const-wide/32 v2, 0x493e1

    invoke-direct {v0, v1, v7, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->PLAYBACK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "SEEK_START"

    const-wide/32 v2, 0x493e2

    invoke-direct {v0, v1, v8, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->SEEK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "SEEK_COMPLETE"

    const-wide/32 v2, 0x493e3

    invoke-direct {v0, v1, v9, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->SEEK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "CONTENT_CHANGE"

    const-wide/32 v2, 0x493e4

    invoke-direct {v0, v1, v10, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->CONTENT_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "PLAYER_STATE_CHANGE"

    const/4 v2, 0x5

    const-wide/32 v4, 0x493e5

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->PLAYER_STATE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "CONTENT_MARKER"

    const/4 v2, 0x6

    const-wide/32 v4, 0x493e6

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "SEEK_ADJUST_COMPLETE"

    const/4 v2, 0x7

    const-wide/32 v4, 0x493e7

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->SEEK_ADJUST_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "LOAD_INFO_AVAILABLE"

    const/16 v2, 0x8

    const-wide/32 v4, 0x49444

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->LOAD_INFO_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "VIDEO_SIZE_CHANGED"

    const/16 v2, 0x9

    const-wide/32 v4, 0x49445

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->VIDEO_SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "BITRATE_CHANGE"

    const/16 v2, 0xa

    const-wide/32 v4, 0x49bb0

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->BITRATE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AUDIO_TRACK_CHANGE"

    const/16 v2, 0xb

    const-wide/32 v4, 0x4a380

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AUDIO_TRACK_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "TIMELINE_CHANGE"

    const/16 v2, 0xc

    const-wide/32 v4, 0x49f98

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMELINE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_BREAK_PLACEMENT_COMPLETE"

    const/16 v2, 0xd

    const-wide/32 v4, 0x49f99

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_BREAK_START"

    const/16 v2, 0xe

    const-wide/32 v4, 0x49f9a

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_BREAK_COMPLETE"

    const/16 v2, 0xf

    const-wide/32 v4, 0x49f9b

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_START"

    const/16 v2, 0x10

    const-wide/32 v4, 0x49f9c

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_COMPLETE"

    const/16 v2, 0x11

    const-wide/32 v4, 0x49f9d

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_PROGRESS"

    const/16 v2, 0x12

    const-wide/32 v4, 0x49f9e

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "TIMED_METADATA_ADD"

    const/16 v2, 0x13

    const-wide/32 v4, 0x49f9f

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMED_METADATA_ADD:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_CLICK"

    const/16 v2, 0x14

    const-wide/32 v4, 0x49fa0

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_CLICK:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "AD_BREAK_SKIPPED"

    const/16 v2, 0x15

    const-wide/32 v4, 0x49fa1

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "TIMED_METADATA_ADD_IN_BACKGROUND"

    const/16 v2, 0x16

    const-wide/32 v4, 0x2e3bfa

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMED_METADATA_ADD_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "DRM_METADATA_AVAILABLE"

    const/16 v2, 0x17

    const-wide/32 v4, 0x4a768

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->DRM_METADATA_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const-string v1, "GENERIC_INFO"

    const/16 v2, 0x18

    const-wide/32 v4, 0x61a7f

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->GENERIC_INFO:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    const/16 v0, 0x19

    new-array v0, v0, [Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->PLAYBACK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->PLAYBACK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->SEEK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v1, v0, v8

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->SEEK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v1, v0, v9

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->CONTENT_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v1, v0, v10

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->PLAYER_STATE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->CONTENT_MARKER:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->SEEK_ADJUST_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->LOAD_INFO_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->VIDEO_SIZE_CHANGED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->BITRATE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AUDIO_TRACK_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMELINE_CHANGE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_PLACEMENT_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_START:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_COMPLETE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_PROGRESS:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMED_METADATA_ADD:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_CLICK:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->AD_BREAK_SKIPPED:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->TIMED_METADATA_ADD_IN_BACKGROUND:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->DRM_METADATA_AVAILABLE:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->GENERIC_INFO:Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

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

    iput-wide p3, p0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->_code:J

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;

    return-object v0
.end method


# virtual methods
.method public getCode()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->_code:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lcom/adobe/mediacore/MediaPlayerNotification$InfoCode;->name()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
