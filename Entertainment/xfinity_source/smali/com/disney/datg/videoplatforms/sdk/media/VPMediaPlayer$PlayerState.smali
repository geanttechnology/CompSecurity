.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;
.super Ljava/lang/Enum;
.source "VPMediaPlayer.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x401c
    name = "PlayerState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum ERROR:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum IDLE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum PAUSED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum PLAYBACK_COMPLETED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum PREPARED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum STARTED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

.field public static final enum STOPPED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 62
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "IDLE"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->IDLE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "INITIALIZED"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "STOPPED"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->STOPPED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "PREPARED"

    invoke-direct {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PREPARED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "STARTED"

    invoke-direct {v0, v1, v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->STARTED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "PAUSED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "PLAYBACK_COMPLETED"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PLAYBACK_COMPLETED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const-string v1, "ERROR"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->ERROR:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    const/16 v0, 0x8

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->IDLE:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->INITIALIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->STOPPED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PREPARED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v1, v0, v6

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->STARTED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PAUSED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->PLAYBACK_COMPLETED:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->ERROR:Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    aput-object v2, v0, v1

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

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
    .line 62
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 62
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;
    .locals 1

    .prologue
    .line 62
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMediaPlayer$PlayerState;

    return-object v0
.end method
