.class public final enum Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;
.super Ljava/lang/Enum;
.source "Asset.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/comcast/playerplatform/primetime/android/asset/Asset;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4019
    name = "AssetType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

.field public static final enum DISNEY:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

.field public static final enum ESPN:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

.field public static final enum PRIMETIME:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;


# direct methods
.method static constructor <clinit>()V
    .locals 5

    .prologue
    const/4 v4, 0x2

    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 289
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    const-string v1, "PRIMETIME"

    invoke-direct {v0, v1, v2}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->PRIMETIME:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 290
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    const-string v1, "ESPN"

    invoke-direct {v0, v1, v3}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->ESPN:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 291
    new-instance v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    const-string v1, "DISNEY"

    invoke-direct {v0, v1, v4}, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->DISNEY:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    .line 288
    const/4 v0, 0x3

    new-array v0, v0, [Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->PRIMETIME:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->ESPN:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    aput-object v1, v0, v3

    sget-object v1, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->DISNEY:Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    aput-object v1, v0, v4

    sput-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

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
    .line 288
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 288
    const-class v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    return-object v0
.end method

.method public static values()[Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;
    .locals 1

    .prologue
    .line 288
    sget-object v0, Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->$VALUES:[Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    invoke-virtual {v0}, [Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/comcast/playerplatform/primetime/android/asset/Asset$AssetType;

    return-object v0
.end method
