.class public Lcom/amazon/mShop/mobileads/MobileAdsLayout$MobileAdsDefaultListener;
.super Ljava/lang/Object;
.source "MobileAdsLayout.java"

# interfaces
.implements Lcom/amazon/device/ads/AmazonOOAdListener;


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/mShop/mobileads/MobileAdsLayout;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x9
    name = "MobileAdsDefaultListener"
.end annotation


# direct methods
.method public constructor <init>()V
    .locals 0

    .prologue
    .line 257
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onAdCollapsed(Lcom/amazon/device/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 259
    return-void
.end method

.method public onAdDismissed(Lcom/amazon/device/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 261
    return-void
.end method

.method public onAdExpanded(Lcom/amazon/device/ads/Ad;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 263
    return-void
.end method

.method public onAdFailedToLoad(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdError;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/device/ads/Ad;
    .param p2, "arg1"    # Lcom/amazon/device/ads/AdError;

    .prologue
    .line 265
    return-void
.end method

.method public onAdLoaded(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdProperties;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/device/ads/Ad;
    .param p2, "arg1"    # Lcom/amazon/device/ads/AdProperties;

    .prologue
    .line 267
    return-void
.end method

.method public onAdReceived(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AmazonOOAdResponse;)Lcom/amazon/device/ads/AmazonOOActionCode;
    .locals 1
    .param p1, "arg0"    # Lcom/amazon/device/ads/Ad;
    .param p2, "arg1"    # Lcom/amazon/device/ads/AmazonOOAdResponse;

    .prologue
    .line 270
    sget-object v0, Lcom/amazon/device/ads/AmazonOOActionCode;->DISPLAY:Lcom/amazon/device/ads/AmazonOOActionCode;

    return-object v0
.end method

.method public onSpecialUrlClicked(Lcom/amazon/device/ads/Ad;Ljava/lang/String;)V
    .locals 0
    .param p1, "arg0"    # Lcom/amazon/device/ads/Ad;
    .param p2, "arg1"    # Ljava/lang/String;

    .prologue
    .line 273
    return-void
.end method
