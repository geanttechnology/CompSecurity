.class public final enum Lcom/adobe/mediacore/MediaPlayer$Event;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "Event"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/MediaPlayer$Event;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/MediaPlayer$Event;

.field public static final enum AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

.field public static final enum BLACKOUTS:Lcom/adobe/mediacore/MediaPlayer$Event;

.field public static final enum DRM:Lcom/adobe/mediacore/MediaPlayer$Event;

.field public static final enum PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

.field public static final enum QOS:Lcom/adobe/mediacore/MediaPlayer$Event;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$Event;

    const-string v1, "PLAYBACK"

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$Event;

    const-string v1, "AD_PLAYBACK"

    invoke-direct {v0, v1, v3}, Lcom/adobe/mediacore/MediaPlayer$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$Event;->AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$Event;

    const-string v1, "QOS"

    invoke-direct {v0, v1, v4}, Lcom/adobe/mediacore/MediaPlayer$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$Event;

    const-string v1, "DRM"

    invoke-direct {v0, v1, v5}, Lcom/adobe/mediacore/MediaPlayer$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$Event;->DRM:Lcom/adobe/mediacore/MediaPlayer$Event;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$Event;

    const-string v1, "BLACKOUTS"

    invoke-direct {v0, v1, v6}, Lcom/adobe/mediacore/MediaPlayer$Event;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$Event;->BLACKOUTS:Lcom/adobe/mediacore/MediaPlayer$Event;

    const/4 v0, 0x5

    new-array v0, v0, [Lcom/adobe/mediacore/MediaPlayer$Event;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    aput-object v1, v0, v2

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->AD_PLAYBACK:Lcom/adobe/mediacore/MediaPlayer$Event;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->QOS:Lcom/adobe/mediacore/MediaPlayer$Event;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->DRM:Lcom/adobe/mediacore/MediaPlayer$Event;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$Event;->BLACKOUTS:Lcom/adobe/mediacore/MediaPlayer$Event;

    aput-object v1, v0, v6

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$Event;->$VALUES:[Lcom/adobe/mediacore/MediaPlayer$Event;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;I)V
    .locals 0
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "()V"
        }
    .end annotation

    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayer$Event;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/MediaPlayer$Event;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$Event;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/MediaPlayer$Event;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$Event;->$VALUES:[Lcom/adobe/mediacore/MediaPlayer$Event;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/MediaPlayer$Event;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/MediaPlayer$Event;

    return-object v0
.end method
