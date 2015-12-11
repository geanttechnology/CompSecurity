.class public final enum Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;
.super Ljava/lang/Enum;
.source "VPCatalog.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "CatalogType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

.field public static final enum CHANNEL:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

.field public static final enum SCHEDULE:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

.field public static final enum VIDEO:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 9
    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    const-string v1, "VIDEO"

    invoke-direct {v0, v1, v2}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->VIDEO:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    const-string v1, "CHANNEL"

    invoke-direct {v0, v1, v3}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->CHANNEL:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    new-instance v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    const-string v1, "SCHEDULE"

    invoke-direct {v0, v1, v4}, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->SCHEDULE:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    const/4 v0, 0x3

    new-array v0, v0, [Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->VIDEO:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->CHANNEL:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->SCHEDULE:Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

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
    .line 9
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 9
    const-class v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    return-object v0
.end method

.method public static values()[Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;
    .locals 1

    .prologue
    .line 9
    sget-object v0, Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->$VALUES:[Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    invoke-virtual {v0}, [Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/disney/datg/videoplatforms/sdk/models/VPCatalog$CatalogType;

    return-object v0
.end method
