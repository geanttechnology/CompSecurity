.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;
.super Ljava/lang/Enum;
.source "VPCaptionStyle.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "FontSize"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

.field public static final enum TEXT_SIZE_LARGE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

.field public static final enum TEXT_SIZE_NORMAL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

.field public static final enum TEXT_SIZE_SMALL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

.field public static final enum TEXT_SIZE_XLARGE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

.field public static final enum TEXT_SIZE_XSMALL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;


# instance fields
.field private size:I


# direct methods
.method static constructor <clinit>()V
    .locals 8

    .prologue
    const/4 v7, 0x4

    const/4 v6, 0x3

    const/4 v5, 0x2

    const/4 v4, 0x1

    const/4 v3, 0x0

    .line 9
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    const-string v1, "TEXT_SIZE_XSMALL"

    const/16 v2, 0x32

    invoke-direct {v0, v1, v3, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_XSMALL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    .line 10
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    const-string v1, "TEXT_SIZE_SMALL"

    const/16 v2, 0x4b

    invoke-direct {v0, v1, v4, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_SMALL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    .line 11
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    const-string v1, "TEXT_SIZE_NORMAL"

    const/16 v2, 0x64

    invoke-direct {v0, v1, v5, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_NORMAL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    .line 12
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    const-string v1, "TEXT_SIZE_LARGE"

    const/16 v2, 0x96

    invoke-direct {v0, v1, v6, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_LARGE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    .line 13
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    const-string v1, "TEXT_SIZE_XLARGE"

    const/16 v2, 0xc8

    invoke-direct {v0, v1, v7, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;-><init>(Ljava/lang/String;II)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_XLARGE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    .line 7
    const/4 v0, 0x5

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_XSMALL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_SMALL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_NORMAL:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    aput-object v1, v0, v5

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_LARGE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    aput-object v1, v0, v6

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->TEXT_SIZE_XLARGE:Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    aput-object v1, v0, v7

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;II)V
    .locals 0
    .param p3, "size"    # I
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(I)V"
        }
    .end annotation

    .prologue
    .line 18
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 19
    iput p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->size:I

    .line 20
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 7
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;
    .locals 1

    .prologue
    .line 7
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPCaptionStyle$FontSize;

    return-object v0
.end method
