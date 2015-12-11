.class Lcom/amazon/device/ads/InterstitialAd$1;
.super Ljava/util/TimerTask;
.source "InterstitialAd.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAd;->prepareAd(Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;)I
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/InterstitialAd;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAd;)V
    .locals 0

    .prologue
    .line 230
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd$1;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-direct {p0}, Ljava/util/TimerTask;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 234
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$1;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    const/4 v1, 0x1

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/InterstitialAd;->getAndSetHasFinishedLoading(Z)Z

    move-result v0

    if-nez v0, :cond_0

    .line 237
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$1;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->onAdTimedOut()V

    .line 239
    :cond_0
    return-void
.end method
