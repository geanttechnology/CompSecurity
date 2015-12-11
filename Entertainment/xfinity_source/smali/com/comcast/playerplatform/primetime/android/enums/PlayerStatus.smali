.class public final enum Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
.super Ljava/lang/Enum;
.source "PlayerStatus.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum COMPLETE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum ERROR:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum INITIALIZED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum INITIALIZING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum PREPARING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum READY:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum RELEASED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

.field public static final enum SUSPENDED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 14
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "IDLE"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 15
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "INITIALIZING"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 16
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "INITIALIZED"

    invoke-direct {v0, v1, v5}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 17
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "PREPARING"

    invoke-direct {v0, v1, v6}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 18
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "PREPARED"

    invoke-direct {v0, v1, v7}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 19
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "READY"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->READY:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 20
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "PLAYING"

    const/4 v2, 0x6

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 21
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "PAUSED"

    const/4 v2, 0x7

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 22
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "COMPLETE"

    const/16 v2, 0x8

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->COMPLETE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 23
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "ERROR"

    const/16 v2, 0x9

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->ERROR:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 24
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "RELEASED"

    const/16 v2, 0xa

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->RELEASED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 25
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    const-string v1, "SUSPENDED"

    const/16 v2, 0xb

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->SUSPENDED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    .line 13
    const/16 v0, 0xc

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->IDLE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v1, v0, v4

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->INITIALIZED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v1, v0, v5

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v1, v0, v6

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PREPARED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->READY:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v2, v0, v1

    const/4 v1, 0x6

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PLAYING:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v2, v0, v1

    const/4 v1, 0x7

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->PAUSED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x8

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->COMPLETE:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v2, v0, v1

    const/16 v1, 0x9

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->ERROR:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xa

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->RELEASED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v2, v0, v1

    const/16 v1, 0xb

    sget-object v2, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->SUSPENDED:Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    aput-object v2, v0, v1

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

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
    .line 13
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 13
    const-class v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;
    .locals 1

    .prologue
    .line 13
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/enums/PlayerStatus;

    return-object v0
.end method
