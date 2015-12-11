.class public Lcom/amazon/device/ads/AmazonOOAdLayout;
.super Lcom/amazon/device/ads/AdLayout;
.source "AmazonOOAdLayout.java"


# direct methods
.method public constructor <init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V
    .locals 0
    .param p1, "activity"    # Landroid/app/Activity;
    .param p2, "size"    # Lcom/amazon/device/ads/AdSize;

    .prologue
    .line 27
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AdLayout;-><init>(Landroid/app/Activity;Lcom/amazon/device/ads/AdSize;)V

    .line 28
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;

    .prologue
    .line 17
    invoke-direct {p0, p1, p2}, Lcom/amazon/device/ads/AdLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;)V

    .line 18
    return-void
.end method

.method public constructor <init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V
    .locals 0
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "attrs"    # Landroid/util/AttributeSet;
    .param p3, "defStyle"    # I

    .prologue
    .line 22
    invoke-direct {p0, p1, p2, p3}, Lcom/amazon/device/ads/AdLayout;-><init>(Landroid/content/Context;Landroid/util/AttributeSet;I)V

    .line 23
    return-void
.end method


# virtual methods
.method protected createAdController(Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)Lcom/amazon/device/ads/AdController;
    .locals 1
    .param p1, "size"    # Lcom/amazon/device/ads/AdSize;
    .param p2, "context"    # Landroid/content/Context;

    .prologue
    .line 33
    new-instance v0, Lcom/amazon/device/ads/AmazonOOAdController;

    invoke-direct {v0, p0, p1, p2}, Lcom/amazon/device/ads/AmazonOOAdController;-><init>(Lcom/amazon/device/ads/AdLayout;Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)V

    return-object v0
.end method

.method protected bridge synthetic createAdController(Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)Lcom/amazon/device/ads/IAdController;
    .locals 1
    .param p1, "x0"    # Lcom/amazon/device/ads/AdSize;
    .param p2, "x1"    # Landroid/content/Context;

    .prologue
    .line 13
    invoke-virtual {p0, p1, p2}, Lcom/amazon/device/ads/AmazonOOAdLayout;->createAdController(Lcom/amazon/device/ads/AdSize;Landroid/content/Context;)Lcom/amazon/device/ads/AdController;

    move-result-object v0

    return-object v0
.end method

.method public setShouldDisableWebViewHardwareAcceleration(Z)V
    .locals 0
    .param p1, "shouldDisableWebViewHardwareAcceleration"    # Z

    .prologue
    .line 44
    invoke-super {p0, p1}, Lcom/amazon/device/ads/AdLayout;->setShouldDisableWebViewHardwareAcceleration(Z)V

    .line 45
    return-void
.end method
