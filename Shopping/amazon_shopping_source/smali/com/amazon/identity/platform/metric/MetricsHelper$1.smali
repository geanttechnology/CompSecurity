.class final Lcom/amazon/identity/platform/metric/MetricsHelper$1;
.super Ljava/lang/Object;
.source "MetricsHelper.java"

# interfaces
.implements Lcom/amazon/identity/auth/device/api/Callback;


# annotations
.annotation system Ldalvik/annotation/EnclosingMethod;
    value = Lcom/amazon/identity/platform/metric/MetricsHelper;->wrapCallback(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)Lcom/amazon/identity/auth/device/api/Callback;
.end annotation

.annotation system Ldalvik/annotation/InnerClass;
    accessFlags = 0x8
    name = null
.end annotation


# instance fields
.field final synthetic val$callback:Lcom/amazon/identity/auth/device/api/Callback;

.field final synthetic val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;


# direct methods
.method constructor <init>(Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;Lcom/amazon/identity/auth/device/api/Callback;)V
    .locals 0

    .prologue
    .line 138
    iput-object p1, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    iput-object p2, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-direct {p0}, Ljava/lang/Object;-><init>()V

    return-void
.end method


# virtual methods
.method public onError(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 153
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 154
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_0

    .line 156
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onError(Landroid/os/Bundle;)V

    .line 158
    :cond_0
    return-void
.end method

.method public onSuccess(Landroid/os/Bundle;)V
    .locals 1
    .param p1, "result"    # Landroid/os/Bundle;

    .prologue
    .line 143
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$timer:Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;

    invoke-virtual {v0}, Lcom/amazon/identity/platform/metric/PlatformMetricsTimer;->stop()V

    .line 144
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    if-eqz v0, :cond_0

    .line 146
    iget-object v0, p0, Lcom/amazon/identity/platform/metric/MetricsHelper$1;->val$callback:Lcom/amazon/identity/auth/device/api/Callback;

    invoke-interface {v0, p1}, Lcom/amazon/identity/auth/device/api/Callback;->onSuccess(Landroid/os/Bundle;)V

    .line 148
    :cond_0
    return-void
.end method
