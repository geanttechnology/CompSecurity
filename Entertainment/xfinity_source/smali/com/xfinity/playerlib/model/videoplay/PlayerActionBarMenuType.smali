.class public final enum Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;
.super Ljava/lang/Enum;
.source "PlayerActionBarMenuType.java"


# annotations
.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

.field public static final enum BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

.field public static final enum FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

.field public static final enum HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 4
    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    const-string v1, "BABY_GUIDE"

    invoke-direct {v0, v1, v2}, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    const-string v1, "HISTORY"

    invoke-direct {v0, v1, v3}, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    new-instance v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    const-string v1, "FAVORITE"

    invoke-direct {v0, v1, v4}, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    .line 3
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->BABY_GUIDE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->HISTORY:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->FAVORITE:Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->$VALUES:[Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

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
    .line 3
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 3
    const-class v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    return-object v0
.end method

.method public static values()[Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;
    .locals 1

    .prologue
    .line 3
    sget-object v0, Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->$VALUES:[Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    invoke-virtual {v0}, [Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/xfinity/playerlib/model/videoplay/PlayerActionBarMenuType;

    return-object v0
.end method
