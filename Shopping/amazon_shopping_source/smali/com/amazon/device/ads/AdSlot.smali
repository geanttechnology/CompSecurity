.class Lcom/amazon/device/ads/AdSlot;
.super Ljava/lang/Object;
.source "AdSlot.java"


# instance fields
.field private adError:Lcom/amazon/device/ads/AdError;

.field private final adOptions:Lcom/amazon/device/ads/AdTargetingOptions;

.field private final adWrapper:Lcom/amazon/device/ads/AdWrapper;

.field private slotNumber:I


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdTargetingOptions;)V
    .locals 1
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "adOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;

    .prologue
    .line 27
    invoke-static {p1}, Lcom/amazon/device/ads/AdSlot;->createAdWrapper(Lcom/amazon/device/ads/Ad;)Lcom/amazon/device/ads/AdWrapper;

    move-result-object v0

    invoke-direct {p0, v0, p2}, Lcom/amazon/device/ads/AdSlot;-><init>(Lcom/amazon/device/ads/AdWrapper;Lcom/amazon/device/ads/AdTargetingOptions;)V

    .line 28
    return-void
.end method

.method constructor <init>(Lcom/amazon/device/ads/AdWrapper;Lcom/amazon/device/ads/AdTargetingOptions;)V
    .locals 1
    .param p1, "adWrapper"    # Lcom/amazon/device/ads/AdWrapper;
    .param p2, "adOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;

    .prologue
    .line 31
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 32
    iput-object p1, p0, Lcom/amazon/device/ads/AdSlot;->adWrapper:Lcom/amazon/device/ads/AdWrapper;

    .line 33
    if-nez p2, :cond_0

    .line 35
    new-instance v0, Lcom/amazon/device/ads/AdTargetingOptions;

    invoke-direct {v0}, Lcom/amazon/device/ads/AdTargetingOptions;-><init>()V

    iput-object v0, p0, Lcom/amazon/device/ads/AdSlot;->adOptions:Lcom/amazon/device/ads/AdTargetingOptions;

    .line 41
    :goto_0
    return-void

    .line 39
    :cond_0
    iput-object p2, p0, Lcom/amazon/device/ads/AdSlot;->adOptions:Lcom/amazon/device/ads/AdTargetingOptions;

    goto :goto_0
.end method

.method static createAdWrapper(Lcom/amazon/device/ads/Ad;)Lcom/amazon/device/ads/AdWrapper;
    .locals 1
    .param p0, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 101
    instance-of v0, p0, Lcom/amazon/device/ads/AdLayout;

    if-eqz v0, :cond_0

    .line 103
    new-instance v0, Lcom/amazon/device/ads/AdLayoutWrapper;

    check-cast p0, Lcom/amazon/device/ads/AdLayout;

    .end local p0    # "ad":Lcom/amazon/device/ads/Ad;
    invoke-direct {v0, p0}, Lcom/amazon/device/ads/AdLayoutWrapper;-><init>(Lcom/amazon/device/ads/AdLayout;)V

    .line 109
    :goto_0
    return-object v0

    .line 105
    .restart local p0    # "ad":Lcom/amazon/device/ads/Ad;
    :cond_0
    instance-of v0, p0, Lcom/amazon/device/ads/InterstitialAd;

    if-eqz v0, :cond_1

    .line 107
    new-instance v0, Lcom/amazon/device/ads/InterstitialAdWrapper;

    check-cast p0, Lcom/amazon/device/ads/InterstitialAd;

    .end local p0    # "ad":Lcom/amazon/device/ads/Ad;
    invoke-direct {v0, p0}, Lcom/amazon/device/ads/InterstitialAdWrapper;-><init>(Lcom/amazon/device/ads/InterstitialAd;)V

    goto :goto_0

    .line 109
    .restart local p0    # "ad":Lcom/amazon/device/ads/Ad;
    :cond_1
    const/4 v0, 0x0

    goto :goto_0
.end method


# virtual methods
.method public getAd()Lcom/amazon/device/ads/Ad;
    .locals 1

    .prologue
    .line 48
    iget-object v0, p0, Lcom/amazon/device/ads/AdSlot;->adWrapper:Lcom/amazon/device/ads/AdWrapper;

    invoke-interface {v0}, Lcom/amazon/device/ads/AdWrapper;->getAd()Lcom/amazon/device/ads/Ad;

    move-result-object v0

    return-object v0
.end method

.method getAdData()Lcom/amazon/device/ads/AdData;
    .locals 1

    .prologue
    .line 86
    iget-object v0, p0, Lcom/amazon/device/ads/AdSlot;->adWrapper:Lcom/amazon/device/ads/AdWrapper;

    invoke-interface {v0}, Lcom/amazon/device/ads/AdWrapper;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    return-object v0
.end method

.method getAdError()Lcom/amazon/device/ads/AdError;
    .locals 1

    .prologue
    .line 76
    iget-object v0, p0, Lcom/amazon/device/ads/AdSlot;->adError:Lcom/amazon/device/ads/AdError;

    return-object v0
.end method

.method getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;
    .locals 1

    .prologue
    .line 91
    iget-object v0, p0, Lcom/amazon/device/ads/AdSlot;->adWrapper:Lcom/amazon/device/ads/AdWrapper;

    invoke-interface {v0}, Lcom/amazon/device/ads/AdWrapper;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v0

    return-object v0
.end method

.method public getAdTargetingOptions()Lcom/amazon/device/ads/AdTargetingOptions;
    .locals 1

    .prologue
    .line 56
    iget-object v0, p0, Lcom/amazon/device/ads/AdSlot;->adOptions:Lcom/amazon/device/ads/AdTargetingOptions;

    return-object v0
.end method

.method getAdWrapper()Lcom/amazon/device/ads/AdWrapper;
    .locals 1

    .prologue
    .line 81
    iget-object v0, p0, Lcom/amazon/device/ads/AdSlot;->adWrapper:Lcom/amazon/device/ads/AdWrapper;

    return-object v0
.end method

.method getSlotNumber()I
    .locals 1

    .prologue
    .line 66
    iget v0, p0, Lcom/amazon/device/ads/AdSlot;->slotNumber:I

    return v0
.end method

.method setAdError(Lcom/amazon/device/ads/AdError;)V
    .locals 0
    .param p1, "adError"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 71
    iput-object p1, p0, Lcom/amazon/device/ads/AdSlot;->adError:Lcom/amazon/device/ads/AdError;

    .line 72
    return-void
.end method

.method setSlotNumber(I)V
    .locals 0
    .param p1, "slotNumber"    # I

    .prologue
    .line 61
    iput p1, p0, Lcom/amazon/device/ads/AdSlot;->slotNumber:I

    .line 62
    return-void
.end method
