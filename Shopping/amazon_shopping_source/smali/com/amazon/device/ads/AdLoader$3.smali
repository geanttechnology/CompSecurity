.class final Lcom/amazon/device/ads/AdLoader$3;
.super Lcom/amazon/device/ads/StartUpWaiter;
.source "AdLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdLoader;->decrementCount(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$adSlots:[Lcom/amazon/device/ads/AdSlot;

.field final synthetic val$requestOptions:Lcom/amazon/device/ads/AdTargetingOptions;

.field final synthetic val$timeout:I


# direct methods
.method constructor <init>(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V
    .locals 0

    .prologue
    .line 575
    iput p1, p0, Lcom/amazon/device/ads/AdLoader$3;->val$timeout:I

    iput-object p2, p0, Lcom/amazon/device/ads/AdLoader$3;->val$requestOptions:Lcom/amazon/device/ads/AdTargetingOptions;

    iput-object p3, p0, Lcom/amazon/device/ads/AdLoader$3;->val$adSlots:[Lcom/amazon/device/ads/AdSlot;

    invoke-direct {p0}, Lcom/amazon/device/ads/StartUpWaiter;-><init>()V

    return-void
.end method


# virtual methods
.method protected startUpFailed()V
    .locals 2

    .prologue
    .line 587
    new-instance v0, Landroid/os/Handler;

    invoke-static {}, Landroid/os/Looper;->getMainLooper()Landroid/os/Looper;

    move-result-object v1

    invoke-direct {v0, v1}, Landroid/os/Handler;-><init>(Landroid/os/Looper;)V

    .line 588
    .local v0, "handler":Landroid/os/Handler;
    new-instance v1, Lcom/amazon/device/ads/AdLoader$3$1;

    invoke-direct {v1, p0}, Lcom/amazon/device/ads/AdLoader$3$1;-><init>(Lcom/amazon/device/ads/AdLoader$3;)V

    invoke-virtual {v0, v1}, Landroid/os/Handler;->post(Ljava/lang/Runnable;)Z

    .line 597
    return-void
.end method

.method protected startUpReady()V
    .locals 3

    .prologue
    .line 579
    invoke-static {}, Lcom/amazon/device/ads/InternalAdRegistration;->getInstance()Lcom/amazon/device/ads/IInternalAdRegistration;

    move-result-object v0

    invoke-interface {v0}, Lcom/amazon/device/ads/IInternalAdRegistration;->register()V

    .line 580
    iget v0, p0, Lcom/amazon/device/ads/AdLoader$3;->val$timeout:I

    iget-object v1, p0, Lcom/amazon/device/ads/AdLoader$3;->val$requestOptions:Lcom/amazon/device/ads/AdTargetingOptions;

    iget-object v2, p0, Lcom/amazon/device/ads/AdLoader$3;->val$adSlots:[Lcom/amazon/device/ads/AdSlot;

    # invokes: Lcom/amazon/device/ads/AdLoader;->beginFetchAds(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V
    invoke-static {v0, v1, v2}, Lcom/amazon/device/ads/AdLoader;->access$100(ILcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V

    .line 581
    return-void
.end method
