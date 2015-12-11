.class Lcom/amazon/device/ads/InterstitialAd$4;
.super Ljava/lang/Object;
.source "InterstitialAd.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/InterstitialAd;->onAdTimedOut()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/InterstitialAd;

.field final synthetic val$mraidView:Lcom/amazon/device/ads/MraidView;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/InterstitialAd;Lcom/amazon/device/ads/MraidView;)V
    .locals 0

    .prologue
    .line 607
    iput-object p1, p0, Lcom/amazon/device/ads/InterstitialAd$4;->this$0:Lcom/amazon/device/ads/InterstitialAd;

    iput-object p2, p0, Lcom/amazon/device/ads/InterstitialAd$4;->val$mraidView:Lcom/amazon/device/ads/MraidView;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 611
    iget-object v0, p0, Lcom/amazon/device/ads/InterstitialAd$4;->val$mraidView:Lcom/amazon/device/ads/MraidView;

    invoke-virtual {v0}, Lcom/amazon/device/ads/MraidView;->destroy()V

    .line 612
    return-void
.end method
