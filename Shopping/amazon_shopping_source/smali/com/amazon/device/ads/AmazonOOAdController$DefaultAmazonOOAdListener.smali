.class Lcom/amazon/device/ads/AmazonOOAdController$DefaultAmazonOOAdListener;
.super Lcom/amazon/device/ads/DefaultAdListener;
.source "AmazonOOAdController.java"

# interfaces
.implements Lcom/amazon/device/ads/AmazonOOAdListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOOAdController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x2
    name = "DefaultAmazonOOAdListener"
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AmazonOOAdController;


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/AmazonOOAdController;)V
    .locals 1

    .prologue
    .line 100
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAdController$DefaultAmazonOOAdListener;->this$0:Lcom/amazon/device/ads/AmazonOOAdController;

    .line 101
    const-string/jumbo v0, "AmazonOOAdController"

    invoke-direct {p0, v0}, Lcom/amazon/device/ads/DefaultAdListener;-><init>(Ljava/lang/String;)V

    .line 102
    return-void
.end method


# virtual methods
.method public onAdReceived(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AmazonOOAdResponse;)Lcom/amazon/device/ads/AmazonOOActionCode;
    .locals 2
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "adResponse"    # Lcom/amazon/device/ads/AmazonOOAdResponse;

    .prologue
    .line 113
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdController$DefaultAmazonOOAdListener;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Default ad listener called - Ad Received."

    invoke-static {v0, v1}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;)V

    .line 114
    sget-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

    return-object v0
.end method

.method public onSpecialUrlClicked(Lcom/amazon/device/ads/Ad;Ljava/lang/String;)V
    .locals 4
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;
    .param p2, "url"    # Ljava/lang/String;

    .prologue
    .line 107
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdController$DefaultAmazonOOAdListener;->LOG_TAG:Ljava/lang/String;

    const-string/jumbo v1, "Default ad listener called - Special URL clicked. Url: %s"

    const/4 v2, 0x1

    new-array v2, v2, [Ljava/lang/Object;

    const/4 v3, 0x0

    aput-object p2, v2, v3

    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    .line 108
    return-void
.end method
