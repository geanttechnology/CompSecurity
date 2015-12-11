.class public final enum Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;
.super Ljava/lang/Enum;
.source "XuaEventType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaActivation:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaAdProgress:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaAuthentication:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaBitrateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaBlackout:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaCheckInRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaCheckOutRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaDeleteRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaEnvironment:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaError:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaFPSChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaFragmentWarning:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaHeartBeat:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaKeyEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaMediaEnded:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaMediaFailed:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaMediaInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaMediaOpened:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaOpeningMedia:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaPageView:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaPerformance:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaPlayStateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaPluginInitialized:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaProvisioning:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaScrubEnded:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaScrubStarted:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaSearch:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaSetDVRRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

.field public static final enum xuaTrickPlay:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 11
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaPluginInitialized"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPluginInitialized:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 12
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaHeartBeat"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaHeartBeat:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 13
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaOpeningMedia"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaOpeningMedia:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 14
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaMediaOpened"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaOpened:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 15
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaMediaEnded"

    invoke-direct {v0, v1, v7}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaEnded:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 16
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaMediaInfo"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 17
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaMediaFailed"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaFailed:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 18
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaBitrateChanged"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaBitrateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 19
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaFPSChanged"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaFPSChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 20
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaPlayStateChanged"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPlayStateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 21
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaAdProgress"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaAdProgress:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 22
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaBlackout"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaBlackout:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 23
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaFragmentWarning"

    const/16 v2, 0xc

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaFragmentWarning:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 24
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaError"

    const/16 v2, 0xd

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaError:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 25
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaPerformance"

    const/16 v2, 0xe

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPerformance:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 26
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaTrickPlay"

    const/16 v2, 0xf

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaTrickPlay:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 27
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaScrubStarted"

    const/16 v2, 0x10

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaScrubStarted:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 28
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaScrubEnded"

    const/16 v2, 0x11

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaScrubEnded:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 29
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaKeyEvent"

    const/16 v2, 0x12

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaKeyEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 30
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaProvisioning"

    const/16 v2, 0x13

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaProvisioning:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 31
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaActivation"

    const/16 v2, 0x14

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaActivation:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 32
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaAuthentication"

    const/16 v2, 0x15

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaAuthentication:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 33
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaPageView"

    const/16 v2, 0x16

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPageView:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 34
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaSearch"

    const/16 v2, 0x17

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaSearch:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 35
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaEnvironment"

    const/16 v2, 0x18

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaEnvironment:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 36
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaSetDVRRecording"

    const/16 v2, 0x19

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaSetDVRRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 37
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaDeleteRecording"

    const/16 v2, 0x1a

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaDeleteRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 38
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaCheckOutRecording"

    const/16 v2, 0x1b

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaCheckOutRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 39
    new-instance v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    const-string v1, "xuaCheckInRecording"

    const/16 v2, 0x1c

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaCheckInRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    .line 10
    const/16 v0, 0x1d

    new-array v0, v0, [Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPluginInitialized:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaHeartBeat:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaOpeningMedia:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaOpened:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaEnded:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaInfo:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaMediaFailed:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaBitrateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaFPSChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPlayStateChanged:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaAdProgress:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaBlackout:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xc

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaFragmentWarning:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xd

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaError:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xe

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPerformance:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0xf

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaTrickPlay:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x10

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaScrubStarted:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x11

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaScrubEnded:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x12

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaKeyEvent:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x13

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaProvisioning:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x14

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaActivation:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x15

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaAuthentication:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x16

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaPageView:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x17

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaSearch:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x18

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaEnvironment:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x19

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaSetDVRRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x1a

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaDeleteRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x1b

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaCheckOutRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    const/16 v1, 0x1c

    sget-object v2, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->xuaCheckInRecording:Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->$VALUES:[Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

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
    .line 10
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 10
    const-class v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;
    .locals 1

    .prologue
    .line 10
    sget-object v0, Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->$VALUES:[Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/analytics/java/xua/XuaEventType;

    return-object v0
.end method
