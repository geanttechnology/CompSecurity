.class Lcom/amazon/device/ads/AdController$3;
.super Ljava/lang/Object;
.source "AdController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdController;->callListenerOnAdFailedToLoad(Lcom/amazon/device/ads/AdError;Z)V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdController;

.field final synthetic val$error:Lcom/amazon/device/ads/AdError;

.field final synthetic val$shouldSubmitMetrics:Z


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdController;Lcom/amazon/device/ads/AdError;Z)V
    .locals 0

    .prologue
    .line 620
    iput-object p1, p0, Lcom/amazon/device/ads/AdController$3;->this$0:Lcom/amazon/device/ads/AdController;

    iput-object p2, p0, Lcom/amazon/device/ads/AdController$3;->val$error:Lcom/amazon/device/ads/AdError;

    iput-boolean p3, p0, Lcom/amazon/device/ads/AdController$3;->val$shouldSubmitMetrics:Z

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 3

    .prologue
    .line 624
    iget-object v0, p0, Lcom/amazon/device/ads/AdController$3;->this$0:Lcom/amazon/device/ads/AdController;

    # getter for: Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;
    invoke-static {v0}, Lcom/amazon/device/ads/AdController;->access$200(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/AdController$3;->this$0:Lcom/amazon/device/ads/AdController;

    # getter for: Lcom/amazon/device/ads/AdController;->adLayout:Lcom/amazon/device/ads/AdLayout;
    invoke-static {v1}, Lcom/amazon/device/ads/AdController;->access$100(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdLayout;

    move-result-object v1

    iget-object v2, p0, Lcom/amazon/device/ads/AdController$3;->val$error:Lcom/amazon/device/ads/AdError;

    invoke-interface {v0, v1, v2}, Lcom/amazon/device/ads/AdListener;->onAdFailedToLoad(Lcom/amazon/device/ads/Ad;Lcom/amazon/device/ads/AdError;)V

    .line 625
    iget-object v0, p0, Lcom/amazon/device/ads/AdController$3;->this$0:Lcom/amazon/device/ads/AdController;

    iget-boolean v1, p0, Lcom/amazon/device/ads/AdController$3;->val$shouldSubmitMetrics:Z

    # invokes: Lcom/amazon/device/ads/AdController;->submitAndResetMetricsIfNecessary(Z)V
    invoke-static {v0, v1}, Lcom/amazon/device/ads/AdController;->access$300(Lcom/amazon/device/ads/AdController;Z)V

    .line 626
    return-void
.end method
