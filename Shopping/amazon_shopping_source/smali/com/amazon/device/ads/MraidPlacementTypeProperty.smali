.class Lcom/amazon/device/ads/MraidPlacementTypeProperty;
.super Lcom/amazon/device/ads/MraidProperty;
.source "MraidProperty.java"


# instance fields
.field private final mPlacementType:Lcom/amazon/device/ads/MraidView$PlacementType;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidView$PlacementType;)V
    .locals 0
    .param p1, "placementType"    # Lcom/amazon/device/ads/MraidView$PlacementType;

    .prologue
    .line 33
    invoke-direct {p0}, Lcom/amazon/device/ads/MraidProperty;-><init>()V

    .line 34
    iput-object p1, p0, Lcom/amazon/device/ads/MraidPlacementTypeProperty;->mPlacementType:Lcom/amazon/device/ads/MraidView$PlacementType;

    .line 35
    return-void
.end method

.method public static createWithType(Lcom/amazon/device/ads/MraidView$PlacementType;)Lcom/amazon/device/ads/MraidPlacementTypeProperty;
    .locals 1
    .param p0, "placementType"    # Lcom/amazon/device/ads/MraidView$PlacementType;

    .prologue
    .line 39
    new-instance v0, Lcom/amazon/device/ads/MraidPlacementTypeProperty;

    invoke-direct {v0, p0}, Lcom/amazon/device/ads/MraidPlacementTypeProperty;-><init>(Lcom/amazon/device/ads/MraidView$PlacementType;)V

    return-object v0
.end method


# virtual methods
.method public toJsonPair()Ljava/lang/String;
    .locals 3

    .prologue
    .line 44
    new-instance v0, Ljava/lang/StringBuilder;

    invoke-direct {v0}, Ljava/lang/StringBuilder;-><init>()V

    const-string/jumbo v1, "placementType: \'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/MraidPlacementTypeProperty;->mPlacementType:Lcom/amazon/device/ads/MraidView$PlacementType;

    invoke-virtual {v1}, Lcom/amazon/device/ads/MraidView$PlacementType;->toString()Ljava/lang/String;

    move-result-object v1

    sget-object v2, Ljava/util/Locale;->US:Ljava/util/Locale;

    invoke-virtual {v1, v2}, Ljava/lang/String;->toLowerCase(Ljava/util/Locale;)Ljava/lang/String;

    move-result-object v1

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    const-string/jumbo v1, "\'"

    invoke-virtual {v0, v1}, Ljava/lang/StringBuilder;->append(Ljava/lang/String;)Ljava/lang/StringBuilder;

    move-result-object v0

    invoke-virtual {v0}, Ljava/lang/StringBuilder;->toString()Ljava/lang/String;

    move-result-object v0

    return-object v0
.end method
