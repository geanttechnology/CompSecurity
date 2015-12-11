.class Lcom/amazon/device/ads/AdLayout$1;
.super Landroid/content/BroadcastReceiver;
.source "AdLayout.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/device/ads/AdLayout;->registerScreenStateBroadcastReceiver()V
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field final synthetic this$0:Lcom/amazon/device/ads/AdLayout;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/AdLayout;)V
    .locals 0

    .prologue
    .line 307
    iput-object p1, p0, Lcom/amazon/device/ads/AdLayout$1;->this$0:Lcom/amazon/device/ads/AdLayout;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 3
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 311
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    const-string/jumbo v1, "android.intent.action.SCREEN_OFF"

    invoke-virtual {v0, v1}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v0

    if-eqz v0, :cond_0

    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout$1;->this$0:Lcom/amazon/device/ads/AdLayout;

    # getter for: Lcom/amazon/device/ads/AdLayout;->isInForeground:Z
    invoke-static {v0}, Lcom/amazon/device/ads/AdLayout;->access$000(Lcom/amazon/device/ads/AdLayout;)Z

    move-result v0

    if-eqz v0, :cond_0

    .line 314
    iget-object v0, p0, Lcom/amazon/device/ads/AdLayout$1;->this$0:Lcom/amazon/device/ads/AdLayout;

    # getter for: Lcom/amazon/device/ads/AdLayout;->controller:Lcom/amazon/device/ads/IAdController;
    invoke-static {v0}, Lcom/amazon/device/ads/AdLayout;->access$100(Lcom/amazon/device/ads/AdLayout;)Lcom/amazon/device/ads/IAdController;

    move-result-object v0

    const-string/jumbo v1, "close"

    const/4 v2, 0x0

    invoke-interface {v0, v1, v2}, Lcom/amazon/device/ads/IAdController;->sendCommand(Ljava/lang/String;Ljava/util/HashMap;)Z

    .line 316
    :cond_0
    return-void
.end method
