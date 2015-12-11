.class public final enum Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;
.super Ljava/lang/Enum;

# interfaces
.implements Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayerNotification;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "WarningCode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;",
        ">;",
        "Lcom/adobe/mediacore/MediaPlayerNotification$NotificationCode;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum AD_RESOLVER_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum AD_RESOLVER_RETURNED_NO_ADS:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum BACKGROUND_MANIFEST_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum GENERIC_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum INVALID_SEEK_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum NATIVE_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum PLAYBACK_OPERATION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum TRICKPLAY_RATE_CHANGE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

.field public static final enum UNDEFINED_TIME_RANGES:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;


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

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "PLAYBACK_OPERATION_FAIL"

    const-wide/32 v2, 0x30d40

    invoke-direct {v0, v1, v6, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->PLAYBACK_OPERATION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "AD_RESOLVER_FAIL"

    const-wide/32 v2, 0x31128

    invoke-direct {v0, v1, v7, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_RESOLVER_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "AD_MANIFEST_LOAD_FAILED"

    const-wide/32 v2, 0x3112a

    invoke-direct {v0, v1, v8, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "AD_RESOLVER_RETURNED_NO_ADS"

    const-wide/32 v2, 0x3112b

    invoke-direct {v0, v1, v9, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_RESOLVER_RETURNED_NO_ADS:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "BACKGROUND_MANIFEST_WARNING"

    const-wide/32 v2, 0x31ce0

    invoke-direct {v0, v1, v10, v2, v3}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "INVALID_SEEK_WARNING"

    const/4 v2, 0x5

    const-wide/32 v4, 0x31ce1

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->INVALID_SEEK_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "NATIVE_WARNING"

    const/4 v2, 0x6

    const-wide/32 v4, 0x330cc

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->NATIVE_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "TRICKPLAY_RATE_CHANGE_FAIL"

    const/4 v2, 0x7

    const-wide/32 v4, 0x445c0

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->TRICKPLAY_RATE_CHANGE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "GENERIC_WARNING"

    const/16 v2, 0x8

    const-wide/32 v4, 0x493df

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->GENERIC_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const-string v1, "UNDEFINED_TIME_RANGES"

    const/16 v2, 0x9

    const-wide/32 v4, 0x3a980

    invoke-direct {v0, v1, v2, v4, v5}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;-><init>(Ljava/lang/String;IJ)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->UNDEFINED_TIME_RANGES:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    const/16 v0, 0xa

    new-array v0, v0, [Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->PLAYBACK_OPERATION_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_RESOLVER_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v1, v0, v7

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_MANIFEST_LOAD_FAILED:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v1, v0, v8

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->AD_RESOLVER_RETURNED_NO_ADS:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v1, v0, v9

    sget-object v1, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->BACKGROUND_MANIFEST_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v1, v0, v10

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->INVALID_SEEK_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->NATIVE_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->TRICKPLAY_RATE_CHANGE_FAIL:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->GENERIC_WARNING:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->UNDEFINED_TIME_RANGES:Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

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

    iput-wide p3, p0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->_code:J

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->$VALUES:[Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;

    return-object v0
.end method


# virtual methods
.method public getCode()J
    .locals 2

    iget-wide v0, p0, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->_code:J

    return-wide v0
.end method

.method public getName()Ljava/lang/String;
    .locals 1

    invoke-virtual {p0}, Lcom/adobe/mediacore/MediaPlayerNotification$WarningCode;->name()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
