.class Lcom/amazon/device/ads/AdController$1;
.super Ljava/lang/Object;
.source "AdController.java"

# interfaces
.implements Ljava/lang/Runnable;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdController;->prepareAd(J)V
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
    .line 360
    iput-object p1, p0, Lcom/amazon/device/ads/AdController$1;->this$0:Lcom/amazon/device/ads/AdController;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public run()V
    .locals 1

    .prologue
    .line 366
    invoke-static {}, Lcom/amazon/device/ads/DeviceInfo;->getUserAgentString()Ljava/lang/String;

    move-result-object v0

    if-nez v0, :cond_0

    .line 368
    iget-object v0, p0, Lcom/amazon/device/ads/AdController$1;->this$0:Lcom/amazon/device/ads/AdController;

    # invokes: Lcom/amazon/device/ads/AdController;->retrieveAndSetUserAgentString()V
    invoke-static {v0}, Lcom/amazon/device/ads/AdController;->access$000(Lcom/amazon/device/ads/AdController;)V

    .line 370
    :cond_0
    return-void
.end method
