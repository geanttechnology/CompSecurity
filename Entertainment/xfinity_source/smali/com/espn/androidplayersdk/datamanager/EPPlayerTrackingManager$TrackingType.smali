.class final enum Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;
.super Ljava/lang/Enum;
.source "EPPlayerTrackingManager.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401a
    name = "TrackingType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;",
        ">;"
    }
.end annotation


# static fields
.field public static final enum AD_COMPLETE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum AD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum AUTH_ATTEMPT:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum AUTH_SUCCESS:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field private static final synthetic ENUM$VALUES:[Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum EVENT_CONCLUDED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum MAP_AFFILIATE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum MILESTONE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum MUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum UNMUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VIDEO_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VIDEO_PLAY_FROM_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VIDEO_SCRUBBED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VIDEO_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VIDEO_STOP:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VOD_END:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VOD_MID:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

.field public static final enum VOD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 76
    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "AUTH_ATTEMPT"

    invoke-direct {v0, v1, v3}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AUTH_ATTEMPT:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "AUTH_SUCCESS"

    invoke-direct {v0, v1, v4}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AUTH_SUCCESS:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VIDEO_START"

    invoke-direct {v0, v1, v5}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "MILESTONE"

    invoke-direct {v0, v1, v6}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MILESTONE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "EVENT_CONCLUDED"

    invoke-direct {v0, v1, v7}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->EVENT_CONCLUDED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VIDEO_STOP"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_STOP:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VIDEO_PAUSE"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VIDEO_SCRUBBED"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_SCRUBBED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VIDEO_PLAY_FROM_PAUSE"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PLAY_FROM_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "MUTE"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "UNMUTE"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->UNMUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "AD_START"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "AD_COMPLETE"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_COMPLETE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "MAP_AFFILIATE"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MAP_AFFILIATE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VOD_START"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VOD_MID"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_MID:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    new-instance v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    const-string v1, "VOD_END"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_END:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    .line 75
    const/16 v0, 0x11

    new-array v0, v0, [Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AUTH_ATTEMPT:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AUTH_SUCCESS:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MILESTONE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->EVENT_CONCLUDED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_STOP:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_SCRUBBED:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VIDEO_PLAY_FROM_PAUSE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->UNMUTE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->AD_COMPLETE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->MAP_AFFILIATE:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_START:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_MID:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->VOD_END:Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ENUM$VALUES:[Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0

    .prologue
    .line 75
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;
    .locals 1

    .prologue
    .line 1
    const-class v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    return-object v0
.end method

.method public static values()[Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;
    .locals 4

    .prologue
    const/4 v3, 0x0

    .line 1
    sget-object v0, Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;->ENUM$VALUES:[Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    array-length v1, v0

    new-array v2, v1, [Lcom/espn/androidplayersdk/datamanager/EPPlayerTrackingManager$TrackingType;

    invoke-static {v0, v3, v2, v3, v1}, Ljava/lang/System;->arraycopy(Ljava/lang/Object;ILjava/lang/Object;II)V

    return-object v2
.end method
