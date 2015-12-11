.class Lcom/amazon/device/ads/MraidDisplayController$1;
.super Landroid/content/BroadcastReceiver;
.source "MraidDisplayController.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/device/ads/MraidDisplayController;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x0
    name = null
.end annotation


# instance fields
.field private mLastRotation:I

.field final synthetic this$0:Lcom/amazon/device/ads/MraidDisplayController;


# direct methods
.method constructor <init>(Lcom/amazon/device/ads/MraidDisplayController;)V
    .locals 0

    .prologue
    .line 82
    iput-object p1, p0, Lcom/amazon/device/ads/MraidDisplayController$1;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 8
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 88
    :try_start_0
    invoke-virtual {p2}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v0

    .line 89
    .local v0, "action":Ljava/lang/String;
    const-string/jumbo v3, "android.intent.action.CONFIGURATION_CHANGED"

    invoke-virtual {v0, v3}, Ljava/lang/String;->equals(Ljava/lang/Object;)Z

    move-result v3

    if-eqz v3, :cond_0

    .line 90
    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController$1;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    # invokes: Lcom/amazon/device/ads/MraidDisplayController;->getDisplayRotation()I
    invoke-static {v3}, Lcom/amazon/device/ads/MraidDisplayController;->access$000(Lcom/amazon/device/ads/MraidDisplayController;)I

    move-result v2

    .line 91
    .local v2, "orientation":I
    iget v3, p0, Lcom/amazon/device/ads/MraidDisplayController$1;->mLastRotation:I

    if-eq v2, v3, :cond_0

    .line 92
    iput v2, p0, Lcom/amazon/device/ads/MraidDisplayController$1;->mLastRotation:I

    .line 93
    iget-object v3, p0, Lcom/amazon/device/ads/MraidDisplayController$1;->this$0:Lcom/amazon/device/ads/MraidDisplayController;

    iget v4, p0, Lcom/amazon/device/ads/MraidDisplayController$1;->mLastRotation:I

    # invokes: Lcom/amazon/device/ads/MraidDisplayController;->onOrientationChanged(I)V
    invoke-static {v3, v4}, Lcom/amazon/device/ads/MraidDisplayController;->access$100(Lcom/amazon/device/ads/MraidDisplayController;I)V
    :try_end_0
    .catch Ljava/lang/Exception; {:try_start_0 .. :try_end_0} :catch_0

    .line 105
    .end local v0    # "action":Ljava/lang/String;
    .end local v2    # "orientation":I
    :cond_0
    :goto_0
    return-void

    .line 97
    :catch_0
    move-exception v1

    .line 102
    .local v1, "e":Ljava/lang/Exception;
    const-string/jumbo v3, "MraidDisplayController"

    const-string/jumbo v4, "Orientation broadcast receiver got exception while executing: %s"

    const/4 v5, 0x1

    new-array v5, v5, [Ljava/lang/Object;

    const/4 v6, 0x0

    invoke-virtual {v1}, Ljava/lang/Exception;->getLocalizedMessage()Ljava/lang/String;

    move-result-object v7

    aput-object v7, v5, v6

    invoke-static {v3, v4, v5}, Lcom/amazon/device/ads/Log;->d(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Object;)V

    goto :goto_0
.end method
