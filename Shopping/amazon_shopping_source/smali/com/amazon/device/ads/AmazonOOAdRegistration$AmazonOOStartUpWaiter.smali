.class Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;
.super Lcom/amazon/device/ads/StartUpWaiter;
.source "AmazonOOAdRegistration.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AmazonOOAdRegistration;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "AmazonOOStartUpWaiter"
.end annotation


# instance fields
.field private final listener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;


# direct methods
.method public constructor <init>(Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;)V
    .locals 0
    .param p1, "listener"    # Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    .prologue
    .line 584
    invoke-direct {p0}, Lcom/amazon/device/ads/StartUpWaiter;-><init>()V

    .line 585
    iput-object p1, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;->listener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    .line 586
    return-void
.end method


# virtual methods
.method protected startUpFailed()V
    .locals 2

    .prologue
    .line 597
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;->listener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    invoke-static {}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->getAmazonOOAdRegistrationInfo()Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;->onRegistrationInfoReady(Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;)V

    .line 598
    return-void
.end method

.method protected startUpReady()V
    .locals 2

    .prologue
    .line 591
    iget-object v0, p0, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOStartUpWaiter;->listener:Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;

    invoke-static {}, Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;->getAmazonOOAdRegistrationInfo()Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/AmazonOOAdRegistrationListener;->onRegistrationInfoReady(Lcom/amazon/device/ads/AmazonOOAdRegistration$AmazonOOAdRegistrationInfo;)V

    .line 592
    return-void
.end method
