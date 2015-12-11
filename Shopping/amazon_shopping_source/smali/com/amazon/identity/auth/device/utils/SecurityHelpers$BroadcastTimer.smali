.class Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;
.super Landroid/content/BroadcastReceiver;
.source "SecurityHelpers.java"


# annotations
.annotation system Ldalvik/annotation/EnclosingClass;
    value = Lcom/amazon/identity/auth/device/utils/SecurityHelpers;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0xa
    name = "BroadcastTimer"
.end annotation


# instance fields
.field final mTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;


# direct methods
.method constructor <init>(Landroid/content/Intent;)V
    .locals 2
    .param p1, "intent"    # Landroid/content/Intent;

    .prologue
    .line 414
    invoke-direct {p0}, Landroid/content/BroadcastReceiver;-><init>()V

    .line 415
    const-string/jumbo v0, "BroadcastDelay"

    invoke-virtual {p1}, Landroid/content/Intent;->getAction()Ljava/lang/String;

    move-result-object v1

    invoke-static {v0, v1}, Lcom/amazon/identity/platform/metric/MetricsHelper;->startTimer(Ljava/lang/String;Ljava/lang/String;)Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    move-result-object v0

    iput-object v0, p0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;->mTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    .line 416
    return-void
.end method


# virtual methods
.method public onReceive(Landroid/content/Context;Landroid/content/Intent;)V
    .locals 1
    .param p1, "context"    # Landroid/content/Context;
    .param p2, "intent"    # Landroid/content/Intent;

    .prologue
    .line 421
    iget-object v0, p0, Lcom/amazon/identity/auth/device/utils/SecurityHelpers$BroadcastTimer;->mTimer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 422
    return-void
.end method
