.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;
.super Ljava/lang/Enum;
.source "CaptionData.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/CaptionData;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CaptionEventType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

.field public static final enum CLEAR:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

.field public static final enum LINEBREAK:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

.field public static final enum TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 8
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    const-string v1, "TEXT"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    const-string v1, "CLEAR"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->CLEAR:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    const-string v1, "LINEBREAK"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->LINEBREAK:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    .line 7
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->TEXT:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->CLEAR:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->LINEBREAK:Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

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
    .line 7
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/CaptionData$CaptionEventType;

    return-object v0
.end method
