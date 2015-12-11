.class public final enum Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;
.super Ljava/lang/Enum;
.source "PlayerSettings.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Setting"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum AD_BREAK_POLICIES:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum AD_TYPE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum AUDIO_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum AUTOPLAY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum BITRATE_PARAMS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum BITRATE_RANGE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum C3_ADS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum CAPTIONS_ENABLED:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum CAPTIONS_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum CAPTION_FORMAT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum DEVICE_ID:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum HEIGHT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum INITIAL_BITRATE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum LOGGER_VERBOSITY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum LOG_FACTORY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum UPDATE_INTERVAL:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum VOLUME:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum WIDTH:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

.field public static final enum ZOOM_SETTING:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 26
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "WIDTH"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->WIDTH:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 27
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "HEIGHT"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->HEIGHT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 28
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "BITRATE_PARAMS"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->BITRATE_PARAMS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 29
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "CAPTION_FORMAT"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTION_FORMAT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 30
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "AD_BREAK_POLICIES"

    invoke-direct {v0, v1, v7}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AD_BREAK_POLICIES:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 31
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "LOGGER_VERBOSITY"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->LOGGER_VERBOSITY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 32
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "LOG_FACTORY"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->LOG_FACTORY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 33
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "UPDATE_INTERVAL"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->UPDATE_INTERVAL:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 34
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "AUTOPLAY"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AUTOPLAY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 35
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "VOLUME"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->VOLUME:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 36
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "ZOOM_SETTING"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ZOOM_SETTING:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 37
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "AD_TYPE"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AD_TYPE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 38
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "C3_ADS"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->C3_ADS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 39
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "INITIAL_BITRATE"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->INITIAL_BITRATE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 40
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "BITRATE_RANGE"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->BITRATE_RANGE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 41
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "DEVICE_ID"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->DEVICE_ID:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 42
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "CAPTIONS_ENABLED"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_ENABLED:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "CAPTIONS_TRACK"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    new-instance v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    const-string v1, "AUDIO_TRACK"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AUDIO_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    .line 25
    const/16 v0, 0x13

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->WIDTH:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->HEIGHT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->BITRATE_PARAMS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTION_FORMAT:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AD_BREAK_POLICIES:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->LOGGER_VERBOSITY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->LOG_FACTORY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->UPDATE_INTERVAL:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AUTOPLAY:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->VOLUME:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->ZOOM_SETTING:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AD_TYPE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->C3_ADS:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->INITIAL_BITRATE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->BITRATE_RANGE:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->DEVICE_ID:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_ENABLED:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->CAPTIONS_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->AUDIO_TRACK:Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    .prologue
    .line 25
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 25
    const-class v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;
    .locals 1

    .prologue
    .line 25
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/player/PlayerSettings$Setting;

    return-object v0
.end method
