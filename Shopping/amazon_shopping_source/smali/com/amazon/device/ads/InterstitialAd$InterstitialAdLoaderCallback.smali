.class Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;
.super Ljava/lang/Object;
.source "InterstitialAd.java"

# interfaces
.implements Lcom/amazon/device/ads/IAdLoaderCallback;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/InterstitialAd;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = "InterstitialAdLoaderCallback"
.end annotation


# instance fields
.field private final interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

.field final synthetic this$0:Lcom/amazon/device/ads/InterstitialAd;


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/InterstitialAd;)V
    .locals 0
    .param p2, "interstitialAd"    # Lcom/amazon/device/ads/InterstitialAd;

    .prologue
    .line 753
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 754
    iput-object p2, p0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;->interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

    .line 755
    return-void
.end method


# virtual methods
.method public adFailed(Lcom/amazon/device/ads/AdError;)V
    .locals 2
    .param p1, "error"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 766
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/InterstitialAd;->getAndSetHasFinishedLoading(Z)Z

    move-result v0

    if-nez v0, :cond_0

    .line 768
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    # invokes: Lcom/amazon/device/ads/InterstitialAd;->failAd(Lcom/amazon/device/ads/AdError;)V
    invoke-static {v0, p1}, Lcom/amazon/device/ads/InterstitialAd;->access$000(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/AdError;)V

    .line 770
    :cond_0
    return-void
.end method

.method public adShown()V
    .locals 1

    .prologue
    .line 781
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->getAdData()Lcom/amazon/device/ads/AdData;

    move-result-object v0

    invoke-virtual {v0}, Lcom/amazon/device/ads/AdData;->getImpressionPixelUrl()Ljava/lang/String;

    move-result-object v0

    invoke-static {v0}, Lcom/amazon/device/ads/WebRequest;->executeWebRequestInThread(Ljava/lang/String;)V

    .line 782
    return-void
.end method

.method public getTimeout()I
    .locals 1

    .prologue
    .line 775
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;->interstitialAd:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->getTimeout()I

    move-result v0

    return v0
.end method

.method public handleResponse()V
    .locals 1

    .prologue
    .line 760
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$InterstitialAdLoaderCallback;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->prerenderHtml()V

    .line 761
    return-void
.end method
