.class Lcom/amazon/device/ads/InterstitialAd$6;
.super Ljava/lang/Object;
.source "InterstitialAd.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAd;->callOnAdFailedToLoadOnMainThread(Lcom/amazon/device/ads/AdError;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/InterstitialAd;

.field final synthetic val$error:Lcom/amazon/device/ads/AdError;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/AdError;)V
    .locals 0

    .prologue
    .line 649
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd$6;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    iput-object p2, p0, Lcom/amazon/device/ads/InterstitialAd$6;->val$error:Lcom/amazon/device/ads/AdError;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 653
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$6;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    iget-object v1, p0, Lcom/amazon/device/ads/InterstitialAd$6;->val$error:Lcom/amazon/device/ads/AdError;

    invoke-virtual {v0, v1}, Lcom/amazon/device/ads/InterstitialAd;->callOnAdFailedToLoad(Lcom/amazon/device/ads/AdError;)V

    .line 654
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$6;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0}, Lcom/amazon/device/ads/InterstitialAd;->submitAndResetMetrics()V

    .line 655
    return-void
.end method
