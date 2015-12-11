.class Lcom/amazon/device/ads/InterstitialAdWrapper;
.super Ljava/lang/Object;
.source "InterstitialAdWrapper.java"

# interfaces
.implements Lcom/amazon/device/ads/AdWrapper;


# instance fields
.field private final interstitialAd:Lcom/amazon/device/ads/InterstitialAd;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAd;)V
    .locals 0
    .param p1, "interstitialAd"    # Lcom/amazon/device/ads/InterstitialAd;

    .prologue
    .line 22
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 23
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAdWrapper;->interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

    .line 24
    return-void
.end method


# virtual methods
.method public getAd()Lcom/amazon/device/ads/Ad;
    .locals 1

    .prologue
    .line 29
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdWrapper;->interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

    return-object v0
.end method

.method public getAdData()Lcom/amazon/device/ads/AdData;
    .locals 1

    .prologue
    .line 35
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdWrapper;->interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    return-object v0
.end method

.method public getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;
    .locals 1

    .prologue
    .line 41
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdWrapper;->interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->getAdLoaderCallback()Lcom/amazon/device/ads/IAdLoaderCallback;

    move-result-object v0

    return-object v0
.end method

.method public prepareAd(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)I
    .locals 1
    .param p1, "listener"    # Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;

    .prologue
    .line 47
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAdWrapper;->interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0, p1}, Lcom/amazon/device/ads/InterstitialAd;->prepareAd(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)I

    move-result v0

    return v0
.end method
