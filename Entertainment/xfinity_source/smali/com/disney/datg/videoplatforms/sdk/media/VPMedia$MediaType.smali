.class public final enum Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;
.super Ljava/lang/Enum;
.source "VPMedia.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/media/VPMedia;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "MediaType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

.field public static final enum LIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

.field public static final enum VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;


# instance fields
.field private label:Ljava/lang/String;

.field private types:Ljava/lang/String;


# direct methods
.method static constructor <clinit>()V
    .locals 6

    .prologue
    const/4 v5, 0x1

    const/4 v4, 0x0

    .line 60
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    const-string v1, "VOD"

    const-string v2, "VOD"

    const-string v3, "lf,es,mp"

    invoke-direct {v0, v1, v4, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    const-string v1, "LIVE"

    const-string v2, "LIVE"

    const-string v3, "lv"

    invoke-direct {v0, v1, v5, v2, v3}, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;-><init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->LIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    .line 58
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->VOD:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    aput-object v1, v0, v4

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->LIVE:Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    aput-object v1, v0, v5

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    return-void
.end method

.method private constructor <init>(Ljava/lang/String;ILjava/lang/String;Ljava/lang/String;)V
    .locals 0
    .param p3, "l"    # Ljava/lang/String;
    .param p4, "t"    # Ljava/lang/String;
    .annotation system Ldalvik/annotation/Signature;
        value = {
            "(",
            "Ljava/lang/String;",
            "Ljava/lang/String;",
            ")V"
        }
    .end annotation

    .prologue
    .line 64
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    .line 65
    iput-object p3, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->label:Ljava/lang/String;

    .line 66
    iput-object p4, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->types:Ljava/lang/String;

    .line 67
    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 58
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;
    .locals 1

    .prologue
    .line 58
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;

    return-object v0
.end method


# virtual methods
.method public getTypes()Ljava/lang/String;
    .locals 1

    .prologue
    .line 72
    iget-object v0, p0, Lcom/disney/datg/videoplatforms/sdk/media/VPMedia$MediaType;->types:Ljava/lang/String;

    return-object v0
.end method
