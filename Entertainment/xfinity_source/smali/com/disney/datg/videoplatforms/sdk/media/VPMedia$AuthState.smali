.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;
.super Ljava/lang/Enum;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AuthState"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

.field public static final enum AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

.field public static final enum NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

.field public static final enum RECEIVED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

.field public static final enum TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

.field public static final enum VALIDATE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

.field public static final enum WAITING:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 57
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    const-string v1, "NOT_AUTHORIZED"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    const-string v1, "WAITING"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->WAITING:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    const-string v1, "RECEIVED"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->RECEIVED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    const-string v1, "VALIDATE"

    invoke-direct {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->VALIDATE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    const-string v1, "TIMEOUT"

    invoke-direct {v0, v1, v7}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    const-string v1, "AUTHORIZED"

    const/4 v2, 0x5

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    const/4 v0, 0x6

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->NOT_AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->WAITING:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->RECEIVED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->VALIDATE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    aput-object v1, v0, v6

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->TIMEOUT:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    aput-object v1, v0, v7

    const/4 v1, 0x5

    sget-object v2, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->AUTHORIZED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    aput-object v2, v0, v1

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

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
    .line 57
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 57
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;
    .locals 1

    .prologue
    .line 57
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AuthState;

    return-object v0
.end method
