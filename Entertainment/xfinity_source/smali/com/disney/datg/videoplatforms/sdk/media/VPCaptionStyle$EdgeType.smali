.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;
.super Ljava/lang/Enum;
.source "VPCaptionStyle.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "EdgeType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

.field public static final enum EDGE_TYPE_DROP_SHADOW:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

.field public static final enum EDGE_TYPE_NONE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 29
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    const-string v1, "EDGE_TYPE_NONE"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->EDGE_TYPE_NONE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    .line 30
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    const-string v1, "EDGE_TYPE_DROP_SHADOW"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->EDGE_TYPE_DROP_SHADOW:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    .line 28
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->EDGE_TYPE_NONE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->EDGE_TYPE_DROP_SHADOW:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

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
    .line 28
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 28
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;
    .locals 1

    .prologue
    .line 28
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$EdgeType;

    return-object v0
.end method
