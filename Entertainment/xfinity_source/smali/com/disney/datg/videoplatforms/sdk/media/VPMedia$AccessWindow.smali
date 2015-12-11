.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;
.super Ljava/lang/Enum;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AccessWindow"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

.field public static final enum FREE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

.field public static final enum MARKET:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

.field public static final enum SUBSCRIPTION:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

.field public static final enum UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 55
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    const-string v1, "SUBSCRIPTION"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->SUBSCRIPTION:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    const-string v1, "FREE"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->FREE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    const-string v1, "MARKET"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->MARKET:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    const-string v1, "UNDEFINED"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    const/4 v0, 0x4

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->SUBSCRIPTION:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->FREE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->MARKET:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    aput-object v1, v0, v5

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

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
    .line 55
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 55
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;
    .locals 1

    .prologue
    .line 55
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AccessWindow;

    return-object v0
.end method
