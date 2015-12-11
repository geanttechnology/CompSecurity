.class Lcom/amazon/device/ads/AdLoader$3$1;
.super Ljava/lang/Object;
.source "AdLoader.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdLoader$3;->startUpFailed()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdLoader$3;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdLoader$3;)V
    .locals 0

    .prologue
    .line 589
    iput-object p1, p0, Lcom/amazon/device/ads/AdLoader$3$1;->this$0:Lcom/amazon/device/ads/AdLoader$3;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 593
    new-instance v0, Lcom/amazon/device/ads/AdError;

    sget-object v1, Lcom/amazon/device/ads/AdError$ErrorCode;->NETWORK_ERROR:Lcom/amazon/device/ads/AdError$ErrorCode;

    const-string/jumbo v2, "The configuration was unable to be loaded"

    invoke-direct {v0, v1, v2}, Lcom/amazon/device/ads/AdError;-><init>(Lcom/amazon/device/ads/AdError$ErrorCode;Ljava/lang/String;)V

    .line 594
    .local v0, "adError":Lcom/amazon/device/ads/AdError;
    iget-object v1, p0, Lcom/amazon/device/ads/AdLoader$3$1;->this$0:Lcom/amazon/device/ads/AdLoader$3;

    iget-object v1, v1, Lcom/amazon/device/ads/AdLoader$3;->val$adSlots:[Lcom/amazon/device/ads/AdSlot;

    # invokes: Lcom/amazon/device/ads/AdLoader;->failAds(Lcom/amazon/device/ads/AdError;[Lcom/amazon/device/ads/AdSlot;)V
    invoke-static {v0, v1}, Lcom/amazon/device/ads/AdLoader;->access$200(Lcom/amazon/device/ads/AdError;[Lcom/amazon/device/ads/AdSlot;)V

    .line 595
    return-void
.end method
