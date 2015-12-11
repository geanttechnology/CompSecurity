.class Lcom/amazon/device/ads/AdController$5;
.super Ljava/lang/Object;
.source "AdController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdController;->adClosedExpansion()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdController;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdController;)V
    .locals 0

    .prologue
    .line 647
    iput-object p1, p0, Lcom/amazon/device/ads/AdController$5;->this$0:Lcom/amazon/device/ads/AdController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 2

    .prologue
    .line 651
    iget-object v0, p0, Lcom/amazon/device/ads/AdController$5;->this$0:Lcom/amazon/device/ads/AdController;

    # getter for: Lcom/amazon/device/ads/AdController;->adListener:Lcom/amazon/device/ads/AdListener;
    invoke-static {v0}, Lcom/amazon/device/ads/AdController;->access$200(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdListener;

    move-result-object v0

    iget-object v1, p0, Lcom/amazon/device/ads/AdController$5;->this$0:Lcom/amazon/device/ads/AdController;

    # getter for: Lcom/amazon/device/ads/AdController;->adLayout:Lcom/amazon/device/ads/AdLayout;
    invoke-static {v1}, Lcom/amazon/device/ads/AdController;->access$100(Lcom/amazon/device/ads/AdController;)Lcom/amazon/device/ads/AdLayout;

    move-result-object v1

    invoke-interface {v0, v1}, Lcom/amazon/device/ads/AdListener;->onAdCollapsed(Lcom/amazon/device/ads/Ad;)V

    .line 652
    return-void
.end method
