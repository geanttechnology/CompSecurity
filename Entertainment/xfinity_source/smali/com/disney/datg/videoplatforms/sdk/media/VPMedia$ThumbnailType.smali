.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;
.super Ljava/lang/Enum;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "ThumbnailType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

.field public static final enum EPISODE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

.field public static final enum SHOW:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 54
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    const-string v1, "SHOW"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->SHOW:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    const-string v1, "EPISODE"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->EPISODE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    const/4 v0, 0x2

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->SHOW:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->EPISODE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

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
    .line 54
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 54
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;
    .locals 1

    .prologue
    .line 54
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$ThumbnailType;

    return-object v0
.end method
