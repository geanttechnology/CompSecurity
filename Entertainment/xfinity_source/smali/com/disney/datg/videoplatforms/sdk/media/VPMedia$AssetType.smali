.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;
.super Ljava/lang/Enum;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AssetType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

.field public static final enum MOV:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

.field public static final enum ULNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

.field public static final enum UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 56
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    const-string v1, "ULNK"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->ULNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    const-string v1, "MOV"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->MOV:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    const-string v1, "UNDEFINED"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->ULNK:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->MOV:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->UNDEFINED:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

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
    .line 56
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 56
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;
    .locals 1

    .prologue
    .line 56
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$AssetType;

    return-object v0
.end method
