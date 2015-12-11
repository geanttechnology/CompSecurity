.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;
.super Ljava/lang/Enum;
.source "CaptionData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CaptionMode"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

.field public static final enum PAINT_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

.field public static final enum POP_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

.field public static final enum ROLL_UP:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

.field public static final enum TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

.field public static final enum UNKNOWN:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;


# direct methods
.method static constructor <clinit>()V
    .locals 7

    .prologue
    const/4 v6, 0x4

    const/4 v5, 0x3

    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 12
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    const-string v1, "UNKNOWN"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->UNKNOWN:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    const-string v1, "POP_ON"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->POP_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    const-string v1, "ROLL_UP"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->ROLL_UP:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    const-string v1, "PAINT_ON"

    invoke-direct {v0, v1, v5}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->PAINT_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    const-string v1, "TEXT"

    invoke-direct {v0, v1, v6}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    .line 11
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->UNKNOWN:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->POP_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->ROLL_UP:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->PAINT_ON:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    aput-object v1, v0, v6

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

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
    .line 11
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 11
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;
    .locals 1

    .prologue
    .line 11
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionMode;

    return-object v0
.end method
