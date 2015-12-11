.class public final enum Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;
.super Ljava/lang/Enum;
.source "AmsHttpErrorException.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "PlayerAction"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

.field public static final enum INCREMENT:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

.field public static final enum STOP:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 206
    new-instance v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    const-string v1, "STOP"

    invoke-direct {v0, v1, v2}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->STOP:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    new-instance v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    const-string v1, "INCREMENT"

    invoke-direct {v0, v1, v3}, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->INCREMENT:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    .line 205
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    sget-object v1, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->STOP:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->INCREMENT:Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    aput-object v1, v0, v3

    sput-object v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->$VALUES:[Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

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
    .line 205
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 205
    const-class v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    return-object v0
.end method

.method public static values()[Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;
    .locals 1

    .prologue
    .line 205
    sget-object v0, Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->$VALUES:[Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    invoke-virtual {v0}, [Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/cim/cmasl/xip/ams/AmsHttpErrorException$PlayerAction;

    return-object v0
.end method
