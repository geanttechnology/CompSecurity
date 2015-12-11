.class public final enum Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;
.super Ljava/lang/Enum;
.source "InitialPlayerState.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

.field public static final enum PAUSE:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

.field public static final enum PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

.field public static final enum USE_AUTO_PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 7
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    const-string v1, "PLAY"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    .line 8
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    const-string v1, "PAUSE"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->PAUSE:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    .line 9
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    const-string v1, "USE_AUTO_PLAY"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->USE_AUTO_PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    .line 6
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->PAUSE:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->USE_AUTO_PLAY:Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    aput-object v1, v0, v4

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

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
    .line 6
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 6
    const-class v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;
    .locals 1

    .prologue
    .line 6
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/enums/InitialPlayerState;

    return-object v0
.end method
