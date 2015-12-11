.class final enum Lcom/amazon/device/ads/MraidView$PlacementType;
.super Ljava/lang/Enum;
.source "MraidView.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidView;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x4018
    name = "PlacementType"
.end annotation

.annotation system Ldalvik/annotation/Signature;
    value = {
        "Ljava/lang/Enum",
        "<",
        "Lcom/amazon/device/ads/MraidView$PlacementType;",
        ">;"
    }
.end annotation


# static fields
.field private static final synthetic $VALUES:[Lcom/amazon/device/ads/MraidView$PlacementType;

.field public static final enum INLINE:Lcom/amazon/device/ads/MraidView$PlacementType;

.field public static final enum INTERSTITIAL:Lcom/amazon/device/ads/MraidView$PlacementType;


# direct methods
.method static constructor <clinit>()V
    .locals 4

    .prologue
    const/4 v3, 0x1

    const/4 v2, 0x0

    .line 128
    new-instance v0, Lcom/amazon/device/ads/MraidView$PlacementType;

    const-string/jumbo v1, "INLINE"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/MraidView$PlacementType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$PlacementType;->INLINE:Lcom/amazon/device/ads/MraidView$PlacementType;

    .line 129
    new-instance v0, Lcom/amazon/device/ads/MraidView$PlacementType;

    const-string/jumbo v1, "INTERSTITIAL"

    invoke-direct {v0, v1, v3}, Lcom/amazon/device/ads/MraidView$PlacementType;-><init>(Ljava/lang/String;I)V

    sput-object v0, Lcom/amazon/device/ads/MraidView$PlacementType;->INTERSTITIAL:Lcom/amazon/device/ads/MraidView$PlacementType;

    .line 127
    const/4 v0, 0x2

    new-array v0, v0, [Lcom/amazon/device/ads/MraidView$PlacementType;

    sget-object v1, Lcom/amazon/device/ads/MraidView$PlacementType;->INLINE:Lcom/amazon/device/ads/MraidView$PlacementType;

    aput-object v1, v0, v2

    sget-object v1, Lcom/amazon/device/ads/MraidView$PlacementType;->INTERSTITIAL:Lcom/amazon/device/ads/MraidView$PlacementType;

    aput-object v1, v0, v3

    sput-object v0, Lcom/amazon/device/ads/MraidView$PlacementType;->$VALUES:[Lcom/amazon/device/ads/MraidView$PlacementType;

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
    .line 127
    invoke-direct {p0, p1, p2}, Ljava/lang/Enum;-><init>(Ljava/lang/String;I)V

    return-void
.end method

.method public static valueOf(Ljava/lang/String;)Lcom/amazon/device/ads/MraidView$PlacementType;
    .locals 1
    .param p0, "name"    # Ljava/lang/String;

    .prologue
    .line 127
    const-class v0, Lcom/amazon/device/ads/MraidView$PlacementType;

    invoke-static {v0, p0}, Ljava/lang/Enum;->valueOf(Ljava/lang/Class;Ljava/lang/String;)Ljava/lang/Enum;

    move-result-object v0

    check-cast v0, Lcom/amazon/device/ads/MraidView$PlacementType;

    return-object v0
.end method

.method public static values()[Lcom/amazon/device/ads/MraidView$PlacementType;
    .locals 1

    .prologue
    .line 127
    sget-object v0, Lcom/amazon/device/ads/MraidView$PlacementType;->$VALUES:[Lcom/amazon/device/ads/MraidView$PlacementType;

    invoke-virtual {v0}, [Lcom/amazon/device/ads/MraidView$PlacementType;->clone()Ljava/lang/Object;

    move-result-object v0

    check-cast v0, [Lcom/amazon/device/ads/MraidView$PlacementType;

    return-object v0
.end method
