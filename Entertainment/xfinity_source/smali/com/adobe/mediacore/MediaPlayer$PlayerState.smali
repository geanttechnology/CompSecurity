.class public final enum Lcom/adobe/mediacore/MediaPlayer$PlayerState;
.super Ljava/lang/Enum;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/adobe/mediacore/MediaPlayer;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PlayerState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/adobe/mediacore/MediaPlayer$PlayerState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum IDLE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum INITIALIZING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum PREPARING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum READY:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum RELEASED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

.field public static final enum SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "IDLE"

    invoke-direct {v0, v1, v3}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->IDLE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "INITIALIZING"

    invoke-direct {v0, v1, v4}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "INITIALIZED"

    invoke-direct {v0, v1, v5}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "PREPARING"

    invoke-direct {v0, v1, v6}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "PREPARED"

    invoke-direct {v0, v1, v7}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "READY"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->READY:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "PLAYING"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "PAUSED"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "COMPLETE"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "ERROR"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "RELEASED"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->RELEASED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    new-instance v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const-string v1, "SUSPENDED"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/adobe/mediacore/MediaPlayer$PlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    const/16 v0, 0xc

    new-array v0, v0, [Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->IDLE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->INITIALIZED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v1, v0, v5

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v1, v0, v6

    sget-object v1, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PREPARED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->READY:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PLAYING:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->PAUSED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->COMPLETE:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->ERROR:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->RELEASED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->SUSPENDED:Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    aput-object v2, v0, v1

    sput-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->$VALUES:[Lcom/adobe/mediacore/MediaPlayer$PlayerState;

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

.method public static valueOf(Ljava/lang/String;)Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .locals 1

    const-class v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    return-object v0
.end method

.method public static values()[Lcom/adobe/mediacore/MediaPlayer$PlayerState;
    .locals 1

    sget-object v0, Lcom/adobe/mediacore/MediaPlayer$PlayerState;->$VALUES:[Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    invoke-virtual {v0}, [Lcom/adobe/mediacore/MediaPlayer$PlayerState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/adobe/mediacore/MediaPlayer$PlayerState;

    return-object v0
.end method
