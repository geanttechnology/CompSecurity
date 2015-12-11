.class Lcom/amazon/device/ads/InterstitialAd$3;
.super Landroid/content/BroadcastReceiver;
.source "InterstitialAd.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAd;->registerBroadcastReceiver()V
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
    .line 488
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd$3;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 492
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$3;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    invoke-virtual {v0, p2}, Lcom/amazon/device/ads/InterstitialAd;->onBroadcastReceived(Landroid/content/Intent;)V

    .line 493
    return-void
.end method
