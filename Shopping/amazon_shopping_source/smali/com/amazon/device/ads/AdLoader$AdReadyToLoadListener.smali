.class public Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;
.super Ljava/lang/Object;
.source "AdLoader.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/AdLoader;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xc
    name = "AdReadyToLoadListener"
.end annotation


# instance fields
.field private final adSlots:[Lcom/amazon/device/ads/AdSlot;

.field private final requestOptions:Lcom/amazon/device/ads/AdTargetingOptions;

.field private final timeout:I

.field private final waitCount:Ljava/util/concurrent/atomic/AtomicInteger;


# direct methods
.method public varargs constructor <init>(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V
    .locals 0
    .param p1, "timeout"    # I
    .param p2, "waitCount"    # Ljava/util/concurrent/atomic/AtomicInteger;
    .param p3, "requestOptions"    # Lcom/amazon/device/ads/AdTargetingOptions;
    .param p4, "adSlots"    # [Lcom/amazon/device/ads/AdSlot;

    .prologue
    .line 719
    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    .line 720
    iput-object p2, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->waitCount:Ljava/util/concurrent/atomic/AtomicInteger;

    .line 721
    iput-object p3, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->requestOptions:Lcom/amazon/device/ads/AdTargetingOptions;

    .line 722
    iput-object p4, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->adSlots:[Lcom/amazon/device/ads/AdSlot;

    .line 723
    iput p1, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->timeout:I

    .line 724
    return-void
.end method


# virtual methods
.method public onAdReady(Lcom/amazon/device/ads/Ad;)V
    .locals 4
    .param p1, "ad"    # Lcom/amazon/device/ads/Ad;

    .prologue
    .line 731
    iget v0, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->timeout:I

    iget-object v1, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->waitCount:Ljava/util/concurrent/atomic/AtomicInteger;

    iget-object v2, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->requestOptions:Lcom/amazon/device/ads/AdTargetingOptions;

    iget-object v3, p0, Lcom/amazon/device/ads/AdLoader$AdReadyToLoadListener;->adSlots:[Lcom/amazon/device/ads/AdSlot;

    invoke-static {v0, v1, v2, v3}, Lcom/amazon/device/ads/AdLoader;->decrementCount(ILjava/util/concurrent/atomic/AtomicInteger;Lcom/amazon/device/ads/AdTargetingOptions;[Lcom/amazon/device/ads/AdSlot;)V

    .line 732
    return-void
.end method
