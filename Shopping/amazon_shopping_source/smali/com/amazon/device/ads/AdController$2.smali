.class Lcom/amazon/device/ads/AdController$2;
.super Ljava/lang/Object;
.source "AdController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdController;->adLoaded(Lcom/amazon/device/ads/AdProperties;)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdController;

.field final synthetic val$props:Lcom/amazon/device/ads/AdProperties;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdController;Lcom/amazon/device/ads/AdProperties;)V
    .locals 0

    .prologue
    .line 511
    iput-object p1, p0, Lcom/amazon/device/ads/AdController$2;->this$0:Lcom/amazon/device/ads/AdController;

    iput-object p2, p0, Lcom/amazon/device/ads/AdController$2;->val$props:Lcom/amazon/device/ads/AdProperties;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 515
    iget-object v0, p0, Lcom/amazon/device/ads/AdController$2;->this$0:Lcom/amazon/device/ads/AdController;

    # getter for: Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;
    invoke-static {v0}, Lcom/amazon/device/ads/AdController;->access$200(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/AdController$2;->this$0:Lcom/amazon/device/ads/AdController;

    # getter for: Lcom/amazon/device/ads/AdController;->adLayout:Lcom/amazon/device/ads/AdLayout;
    invoke-static {v1}, Lcom/amazon/device/ads/AdController;->access$100(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/AdController$2;->val$props:Lcom/amazon/device/ads/AdProperties;

    invoke-interface {v0, v1, v2}, Lcom/amazon/device/ads/AdListener;->onAdLoaded(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdProperties;)V

    .line 516
    iget-object v0, p0, Lcom/amazon/device/ads/AdController$2;->this$0:Lcom/amazon/device/ads/AdController;

    const/4 v1, 0x1

    # invokes: Lcom/amazon/device/ads/AdController;->submitAndResetMetricsIfNecessary(Z)V
    invoke-static {v0, v1}, Lcom/amazon/device/ads/AdController;->access$300(Lcom/amazon/device/ads/AdController;Z)V

    .line 517
    return-void
.end method
